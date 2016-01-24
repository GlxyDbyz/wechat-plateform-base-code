package org.dbyz.wechat.app.util;

import static java.lang.String.format;
import static org.apache.commons.httpclient.HttpStatus.SC_OK;
import static org.dbyz.wechat.app.util.ConfigUtil.getString;
import static org.dbyz.wechat.app.util.JsonUtil.jsonToObject;
import static org.dbyz.wechat.app.util.JsonUtil.objectToJson;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.dbyz.wechat.app.entity.AccessToken;
import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.ErrCode;
import org.dbyz.wechat.app.entity.ErrCode.ErrorCodeType;
import org.dbyz.wechat.app.entity.Menu;
import org.dbyz.wechat.app.entity.Oauth2Token;
import org.dbyz.wechat.app.entity.PlateformUserInfo;
import org.dbyz.wechat.app.entity.TemplateMsg;

/**
 * 微信接口工具
 * 
 * @ClassName: AppUtil
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public class AppUtil {
	private static final String APPID = getString("AppID");
	private static final String APPSECRET = getString("AppSecret");

	private static final String OPENID_GET_BY_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret=" + APPSECRET + "&code=%s&grant_type=authorization_code";
	private static final String WEIXIN_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;
	private static final String USER_INFO_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
	private static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
	private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	private static final String TEMPLATE_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";
	private static final String TEMPLATEID_GET_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s";
	private static final String INDUSTRY_SET_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s";
	private static final String CUSTOM_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";

	private static Long accessTokenLastGetTime = 0L;
	private static String accessTokenStr = "";

	/**
	 * 获取 AccessToken
	 * 
	 * @Title: getAccessToken
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static String getAccessToken() {
		if ((System.currentTimeMillis() - accessTokenLastGetTime) > 3600 * 1000 * 1) {// 每小时取一次
			accessTokenLastGetTime = System.currentTimeMillis();
			// 拼接访问的url
			String urlStr = format(WEIXIN_TOKEN_URL);
			HttpClient client = new HttpClient();
			GetMethod getMethod = new GetMethod(urlStr);
			try {
				client.executeMethod(getMethod);
				if (getMethod.getStatusCode() == SC_OK) {
					String json = getMethod.getResponseBodyAsString();
					AccessToken tokenBean = jsonToObject(json, AccessToken.class);
					accessTokenStr = tokenBean.getAccess_token();
				}

			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				getMethod.releaseConnection();
			}
		}
		return accessTokenStr;
	}

	/**
	 * 根据Code得到相应的OpenId
	 * 
	 * @Title: getOpenIdByCode
	 * @param @param code
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static String getOpenIdByCode(String code) {
		String urlStr = format(OPENID_GET_BY_CODE_URL, code);
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(urlStr);
		try {
			client.executeMethod(getMethod);
			if (getMethod.getStatusCode() == SC_OK) {
				String json = getMethod.getResponseBodyAsString();
				Oauth2Token oauth2Token = jsonToObject(json, Oauth2Token.class);
				return oauth2Token.getOpenid();
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return null;
	}

	/**
	 * 发送客服消息方法
	 * 
	 * @Title: sendCustomerMsg
	 * @param @param msg
	 * @param @return
	 * @return: boolean
	 * @since V1.0
	 */
	public static boolean sendCustomerMsg(CustomMsg msg) {
		String json = objectToJson(msg);
		String urlStr = format(CUSTOM_MESSAGE_SEND_URL, getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == SC_OK) {
				json = postMethod.getResponseBodyAsString();
				ErrCode err = jsonToObject(json, ErrCode.class);
				if (ErrorCodeType.ok.getErrcode().equals(err.getErrcode())) {
					return true;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return false;
	}

	/**
	 * 设置所属行业
	 * 
	 * @Title: setPlateformIndustryType
	 * @param @param code1
	 * @param @param code2
	 * @param @return
	 * @return: Boolean
	 * @since V1.0
	 */
	public static Boolean setPlateformIndustryType(int code1, int code2) {
		String json = "{\"industry_id1\":\"" + code1 + "\",\"industry_id2\":\"" + code2 + "\"}";
		String urlStr = format(INDUSTRY_SET_URL, getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == SC_OK) {
				json = postMethod.getResponseBodyAsString();
				ErrCode err = jsonToObject(json, ErrCode.class);
				if (ErrorCodeType.ok.getErrcode().equals(err.getErrcode())) {
					return true;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return false;
	}

	/**
	 * 获取TemplateId
	 * 
	 * @Title: getTemplateMsgId
	 * @param @param shortTemplateId
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static String getTemplateMsgId(String shortTemplateId) {
		String json = " {\"template_id_short\":\"" + shortTemplateId + "\"}";
		String urlStr = format(TEMPLATEID_GET_URL, getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == SC_OK) {
				json = postMethod.getResponseBodyAsString();
				ErrCode err = jsonToObject(json, ErrCode.class);
				if (ErrorCodeType.ok.getErrcode().equals(err.getErrcode())) {
					return err.getTemplate_id();
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return null;
	}

	/**
	 * 发送模版消息
	 * 
	 * @Title: sendTemplateMsg
	 * @param @param templateMsgJson
	 * @param @return
	 * @return: Boolean
	 * @since V1.0
	 */
	public static Boolean sendTemplateMsg(TemplateMsg msg) {
		String urlStr = format(TEMPLATE_MESSAGE_SEND_URL, getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(objectToJson(msg),
					"application/json", "UTF-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == SC_OK) {
				String json = postMethod.getResponseBodyAsString();
				ErrCode err = jsonToObject(json, ErrCode.class);
				if (ErrorCodeType.ok.getErrcode().equals(err.getErrcode())) {
					return true;
				}
			}

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return false;
	}

	/**
	 * 天气接口调用
	 * 
	 * @Title: getWeather
	 * @param @param cityCode
	 * @return: void
	 * @since V1.0
	 */
	public static void getWeather(String cityCode) {
		String urlStr = format("http://www.weather.com.cn/data/cityinfo/%s.html", cityCode);
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(urlStr);
		try {
			client.executeMethod(getMethod);
			if (getMethod.getStatusCode() == SC_OK) {
				String json = getMethod.getResponseBodyAsString();
				System.out.println(json);
			}

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
	}

	/**
	 * 创建菜单
	 * 
	 * @Title: createMenu
	 * @param @param menu
	 * @param @return
	 * @return: Boolean
	 * @since V1.0
	 */
	public static Boolean createMenu(Menu menu) {
		String urlStr = format(MENU_CREATE_URL, getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(objectToJson(menu),
					"application/json", "UTF-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == SC_OK) {
				String json = postMethod.getResponseBodyAsString();
				ErrCode err = jsonToObject(json, ErrCode.class);
				if (ErrorCodeType.ok.getErrcode().equals(err.getErrcode())) {
					return true;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 获取当前菜单JSON
	 * 
	 * @Title: getMenu
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static String getMenu() {
		String urlStr = format(MENU_GET_URL, getAccessToken());
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(urlStr);
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == SC_OK) {
				String json = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"),
						"UTF-8");
				return json;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取指定openId的用户信息
	 * 
	 * @Title: getMenu
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static PlateformUserInfo getPlateformUserInfo(String openId) {
		String urlStr = format(USER_INFO_GET_URL, getAccessToken(), openId);
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(urlStr);
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == SC_OK) {
				String json = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"),
						"UTF-8");
				return jsonToObject(json, PlateformUserInfo.class);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
