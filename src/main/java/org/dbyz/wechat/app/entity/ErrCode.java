package org.dbyz.wechat.app.entity;

public class ErrCode {
	/**
	 * 错误编码
	 */
	private String errcode;
	/**
	 * 错误消息
	 */
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

	public static enum ErrorCodeType {
		busy("-1"),
		ok("0");

		private String errcode;

		private ErrorCodeType(String errcode) {
			this.errcode = errcode;
		}

		public String getErrcode() {
			return errcode;
		}
	}
}
