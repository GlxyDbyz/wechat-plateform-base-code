package org.dbyz.wechat.app.entity;

public class ErrCode {
	private String errcode;
	private String errmsg;
	/**
	 * 获取模版消息时候会有此参数返回
	 */
	private String template_id;
	

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
}
