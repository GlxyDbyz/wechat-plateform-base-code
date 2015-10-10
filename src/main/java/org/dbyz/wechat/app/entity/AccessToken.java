package org.dbyz.wechat.app.entity;

/**
 * AccessToken 实体类
 * 
 * @ClassName: AccessToken
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public class AccessToken {
	private String access_token;
	private String expires_in;

	public AccessToken() {
	}

	public AccessToken(String access_token, String expires_in) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in="
				+ expires_in + "]";
	}

}