package org.dbyz.wechat.app.enum_;

public enum ErrorCodeType {
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
