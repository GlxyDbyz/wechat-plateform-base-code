package org.dbyz.wechat.app.entity;

/**
 * 模版消息实体类
 *
 * @ClassName: TemplateMsg
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public class TemplateMsg {
	/**
	 * 发送对象的openId
	 */
	private String touser;
	/**
	 * 模版Id
	 */
	private String template_id;
	/**
	 * 跳转的地址
	 */
	private String url;
	/**
	 * 模版消息数据
	 */
	private Data data;

	/**
	 * 模版消息构造器
	 * 
	 * @param touser
	 * @param template_id
	 * @param url
	 * @param data
	 */
	public TemplateMsg(String touser, String template_id, String url, Data data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}

	private TemplateMsg() {
		super();
	}

	/**
	 * 创建工具ValueAndColor的对象工具
	 */
	private static TemplateMsg me = new TemplateMsg();

	/**
	 * 传入文本和颜色构建一个显示的.DATA
	 * 
	 * @Title: createValueAndColor
	 * @param @param value
	 * @param @param color
	 * @param @return
	 * @return: ValueAndColor
	 * @since V1.0
	 */
	public static ValueAndColor createValueAndColor(String value, String color) {
		return me.new ValueAndColor(value, color);
	}

	/**
	 * 构建Data
	 * 
	 * @Title: createData
	 * @param @return
	 * @return: Data
	 * @since V1.0
	 */
	public static Data createData() {
		return me.new Data();
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * 发送的数据 value-color键值对组（十组备用）
	 *
	 * @ClassName: Data
	 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
	 * @version: V1.0
	 */
	public class Data {
		private ValueAndColor first;
		private ValueAndColor second;
		private ValueAndColor third;
		private ValueAndColor fourth;
		private ValueAndColor fifth;
		private ValueAndColor sixth;
		private ValueAndColor seventh;
		private ValueAndColor eighth;
		private ValueAndColor ninth;
		private ValueAndColor tenth;

		public Data() {
			super();
		}

		public ValueAndColor getFirst() {
			return first;
		}

		public void setFirst(ValueAndColor first) {
			this.first = first;
		}

		public ValueAndColor getSecond() {
			return second;
		}

		public void setSecond(ValueAndColor second) {
			this.second = second;
		}

		public ValueAndColor getThird() {
			return third;
		}

		public void setThird(ValueAndColor third) {
			this.third = third;
		}

		public ValueAndColor getFourth() {
			return fourth;
		}

		public void setFourth(ValueAndColor fourth) {
			this.fourth = fourth;
		}

		public ValueAndColor getFifth() {
			return fifth;
		}

		public void setFifth(ValueAndColor fifth) {
			this.fifth = fifth;
		}

		public ValueAndColor getSixth() {
			return sixth;
		}

		public void setSixth(ValueAndColor sixth) {
			this.sixth = sixth;
		}

		public ValueAndColor getSeventh() {
			return seventh;
		}

		public void setSeventh(ValueAndColor seventh) {
			this.seventh = seventh;
		}

		public ValueAndColor getEighth() {
			return eighth;
		}

		public void setEighth(ValueAndColor eighth) {
			this.eighth = eighth;
		}

		public ValueAndColor getNinth() {
			return ninth;
		}

		public void setNinth(ValueAndColor ninth) {
			this.ninth = ninth;
		}

		public ValueAndColor getTenth() {
			return tenth;
		}

		public void setTenth(ValueAndColor tenth) {
			this.tenth = tenth;
		}
	}

	/**
	 * 文本和颜色的键值对
	 *
	 * @ClassName: ValueAndColor
	 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
	 * @version: V1.0
	 */
	public class ValueAndColor {
		/**
		 * 文本内容
		 */
		private String value;
		/**
		 * 文本颜色
		 */
		private String color;

		public ValueAndColor(String value, String color) {
			super();
			this.value = value;
			this.color = color;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
}
