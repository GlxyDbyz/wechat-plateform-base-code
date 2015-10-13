package org.dbyz.wechat.app.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Menu {
	private Button[] button;

	public Menu() {
		super();
	}

	public Menu(Button[] button) {
		super();
		this.button = button;
	}

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public static class Button {
		private String name;

		private SubButton[] sub_button;

		public Button() {
			super();
		}

		public Button(String name, SubButton[] sub_button) {
			super();
			this.name = name;
			this.sub_button = sub_button;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public SubButton[] getSub_button() {
			return sub_button;
		}

		public void setSub_button(SubButton[] sub_button) {
			this.sub_button = sub_button;
		}
	}

	public static class SubButton {
		private String type;
		private String name;
		private String key;
		private String url;
		private String media_id;
		private String[] sub_button = { };

		public SubButton( String name, MenuType type,String key, String url,
				String media_id) {
			super();
			this.type = type.getName();
			this.name = name;
			this.key = key;
			this.url = url;
			this.media_id = media_id;
		}

		public SubButton() {
			super();
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

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public String[] getSub_button() {
			return sub_button;
		}

		public void setSub_button(String[] sub_button) {
			this.sub_button = sub_button;
		}

	}

	public static enum MenuType {
		/**
		 * 点击推事件
		 */
		click("click"),
		/**
		 * 跳转URL
		 */
		view("view"),
		/**
		 * 扫码推事件
		 */
		scancode_push("scancode_push"),
		/**
		 * 扫码推事件且弹出“消息接收中”提示框
		 */
		scancode_waitmsg("scancode_waitmsg"),
		/**
		 * 弹出系统拍照发图
		 */
		pic_sysphoto("pic_sysphoto"),
		/**
		 * 弹出拍照或者相册发图
		 */
		pic_photo_or_album("pic_photo_or_album"),
		/**
		 * 弹出微信相册发图器
		 */
		pic_weixin("pic_weixin"),
		/**
		 * 弹出地理位置选择器
		 */
		location_select("location_select"),
		/**
		 * 下发消息（除文本消息）
		 */
		media_id("media_id"),
		/**
		 * 跳转图文消息URL
		 */
		view_limited("view_limited");
		private String name;

		private MenuType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
}
