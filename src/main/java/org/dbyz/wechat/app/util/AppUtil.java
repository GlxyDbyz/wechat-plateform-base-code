package org.dbyz.wechat.app.util;

import static org.dbyz.wechat.app.util.JsonUtil.jsonToObject;
import static org.dbyz.wechat.app.util.JsonUtil.objectToJson;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.dbyz.wechat.app.entity.AccessToken;
import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.ErrCode;
import org.dbyz.wechat.app.entity.Oauth2Token;
import org.dbyz.wechat.app.entity.TemplateMsg;
import org.dbyz.wechat.app.enum_.ErrorCodeType;

/**
 * 微信接口工具
 * 
 * @ClassName: AppUtil
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public class AppUtil {
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
		if (System.currentTimeMillis() - accessTokenLastGetTime > (3600 * 1 * 1000)) {// 每小时取一次
			accessTokenLastGetTime = System.currentTimeMillis();

			// 拼接访问的url
			String urlStr = String
					.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
							ConfigUtil.getString("AppID"),
							ConfigUtil.getString("AppSecret"));
			HttpClient client = new HttpClient();
			GetMethod getMethod = new GetMethod(urlStr);
			
			try {
				client.executeMethod(getMethod);
				if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
					String json = getMethod.getResponseBodyAsString();
					AccessToken tokenBean = jsonToObject(json,
							AccessToken.class);
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
		String urlStr = String
				.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
						ConfigUtil.getString("AppID"),
						ConfigUtil.getString("AppSecret"), code);

		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(urlStr);

		try {
			client.executeMethod(getMethod);
			if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
				String json = getMethod.getResponseBodyAsString();
				Oauth2Token oauth2Token = jsonToObject(json,
						Oauth2Token.class);
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
		String urlStr = String
				.format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s",
						getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);

		try {
			RequestEntity requestEntity = new StringRequestEntity(json,
					"application/json", "utf-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
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

		String json = "{\"industry_id1\":\"" + code1 + "\",\"industry_id2\":\""
				+ code2 + "\"}";
		String urlStr = String
				.format("https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s",
						getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);

		try {
			RequestEntity requestEntity = new StringRequestEntity(json,
					"application/json", "utf-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
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
		String urlStr = String
				.format("https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s",
						getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);

		try {
			RequestEntity requestEntity = new StringRequestEntity(json,
					"application/json", "utf-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
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
		;
		String urlStr = String
				.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s",
						getAccessToken());
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(urlStr);

		try {
			RequestEntity requestEntity = new StringRequestEntity(
					objectToJson(msg), "application/json", "utf-8");
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
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

		String urlStr = String.format(
				"http://www.weather.com.cn/data/cityinfo/%s.html", cityCode);
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(urlStr);

		try {
			client.executeMethod(getMethod);
			if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
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
}
