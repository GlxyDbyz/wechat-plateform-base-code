package org.dbyz.wechat.app.enum_;

public enum CustomMsgType {

	TEXT("text"), // 文本消息
	IMAGE("image"), // 图片消息
	VOICE("voice"), // 声音消息
	VIDEO("video"), // 视频消息
	MUSIC("music"), // 音乐消息
	NEWS("news"), // 图文消息
	WXCARD("wxcard")// 卡券消息
	;

	private String msgtype;

	private CustomMsgType(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getMsgtype() {
		return msgtype;
	}
}
