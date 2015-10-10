/**
 * 
 */
package org.dbyz.wechat.app.entity;

/**
 *  菜单
 *
 * @ClassName: Button
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a> 
 * @version: V1.0
 */
public class Button {
	/**
	 * 1、click：点击推事件 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event
	 * 的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互； 2、view：跳转URL
	 * 用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
	 * 3、scancode_push：扫码推事件
	 * 用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者
	 * ，开发者可以下发消息。 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框
	 * 用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后
	 * ，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
	 * 5、pic_sysphoto：弹出系统拍照发图
	 * 用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者
	 * ，同时收起系统相机，随后可能会收到开发者下发的消息。 6、pic_photo_or_album：弹出拍照或者相册发图
	 * 用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
	 * 7、pic_weixin：弹出微信相册发图器
	 * 用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者
	 * ，同时收起相册，随后可能会收到开发者下发的消息。 8、location_select：弹出地理位置选择器
	 * 用户点击按钮后，微信客户端将调起地理位置选择工具
	 * ，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
	 */
	private String type;
	/*
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
	private String name;
	/**
	 * click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节
	 */
	private String key;
	/**
	 * view类型必须 网页链接，用户点击菜单可打开链接，不超过256字节
	 */
	private String url;
	/**
	 * 子菜单
	 */
	private Button[] subs;

	public Button[] getSubs() {
		return subs;
	}

	public void setSubs(Button[] subs) {
		this.subs = subs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
