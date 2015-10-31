package org.dbyz.wechat.common;

import static org.dbyz.wechat.app.util.AppUtil.getOpenIdByCode;
import static org.dbyz.wechat.app.util.ConfigUtil.getString;
import static org.dbyz.wechat.common.ConstantUtil.SYS_SESSION_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dbyz.wechat.sys.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 用户权限判断
 * 
 * @ClassName: OperationInterceptor
 * @Description:
 * @author 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version 创建时间：2014年12月11日下午5:38:52
 */
public class OperationInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(OperationInterceptor.class);

	/**
	 * 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		String url = request.getRequestURI();

		if (isStaticWebResourse(url) || url.indexOf("/app") > -1) {
			// 静态页面和微信接口（/app）不拦截
			return true;

		} else if (url.indexOf("/sys/login") > -1) {
			// 管理后台登录不拦截
			return true;

		} else if (url.indexOf("/sys") > -1) {
			// 管理后台
			HttpSession sysSession = request.getSession(false);
			if (sysSession != null && (SysUser) sysSession.getAttribute(SYS_SESSION_USER) == null) {
				// 管理后台没有登录
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return false;

			} else {
				// 管理后台已经登录
				return true;

			}
		}

		// 以下是微信前台

		HttpSession session = null;
		/**
		 * 如果是调试状态则可以在连接后面添加openId属性进行授权页面调试
		 */
		if ("true".equals(getString("app.debug"))) {
			if (request.getParameter("openId") != null) {
				session = request.getSession(true);
				session.setAttribute("openId", request.getParameter("openId"));
				return true;
			}
		}

		session = request.getSession(false);
		if (session != null && session.getAttribute("openId") != null) {
			return true; // 已经有openId了
		}

		String code = request.getParameter("code");
		String openId = null;
		if (!StringUtils.isEmpty(code)) {
			// 没有openId 通过code获取
			openId = getOpenIdByCode(code);

			if (openId != null && openId.trim().length() > 10) {
				// 有openId则把它放入session
				session = request.getSession(true);
				session.setAttribute("openId", openId);
				return true;

			} else {
				// 没有 openId 跳转提示页面
				// request.getRequestDispatcher("/error.jsp").forward(request,response);
				response.sendRedirect(request.getContextPath() + "/error400.jsp");
				return false;
			}

		}
		// 其他情况
		return false;
	}

	/**
	 * 重写 afterCompletion()方法，在业务处理器处理请求后处理数据(日志)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {

		String url = request.getRequestURI();
		HttpSession session = request.getSession(false);
		String openId = "";
		if (session != null) {
			openId = (String) session.getAttribute("openId");
		}

		if (!isStaticWebResourse(url)) {
			if (!StringUtils.isEmpty(openId)) {// 微信前台
			}

			if (url.indexOf("/sys") != 0) {// 管理后台
			}
		}
	}

	/**
	 * 是否为静态WEB资源
	 * 
	 * @Title: isWebStaticResourse
	 * @param url
	 *            访问路径
	 * @return: boolean
	 * @since V1.0
	 */
	private boolean isStaticWebResourse(String url) {
		return (url.indexOf("/images") > -1 || url.indexOf("/css") > -1
				|| url.indexOf("/font") > -1 || url.indexOf("/js") > -1 || url.indexOf("/error") > -1);
	}
}
