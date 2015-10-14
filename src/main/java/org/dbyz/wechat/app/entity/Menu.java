package org.dbyz.wechat.app.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 菜单实体类
 *
 * @ClassName: Menu
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 * 
 *           1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 *           2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 *           3、创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。
 *           测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 */
@XmlRootElement
public class Menu {
	/**
	 * 一级菜单数组
	 */
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

	/**
	 * 一级菜单实体类
	 *
	 * @ClassName: Button
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
	public static class Button {
		/**
		 * 一级菜单名称
		 */
		private String name;
		/**
		 * 菜单类型
		 */
		private String type;
		/**
		 * click菜单的key
		 */
		private String key;
		/**
		 * view 菜单的url
		 */
		private String url;
		/**
		 * media_id类型和view_limited类型
		 */
		private String media_id;

		/**
		 * 二级菜单数组
		 */
		private Button[] sub_button;

		public Button() {
			super();
		}

		/**
		 * 二级菜单构造器/简单一级菜单构造器
		 * 
		 * @param name
		 * @param type
		 * @param key
		 * @param url
		 * @param media_id
		 */
		public Button(String name, MenuType type, String key, String url,
				String media_id) {
			super();
			this.type = type.getName();
			this.name = name;
			this.key = key;
			this.url = url;
			this.media_id = media_id;
		}
		
		/**
		 * 复杂一级菜单构造器
		 * 
		 * @param name
		 * @param sub_button
		 */
		public Button(String name, Button[] sub_button) {
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

		public Button[] getSub_button() {
			return sub_button;
		}

		public void setSub_button(Button[] sub_button) {
			this.sub_button = sub_button;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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

	}

	/**
	 * 菜单类型
	 *
	 * @ClassName: MenuType
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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