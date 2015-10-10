package org.dbyz.wechat.app.entity;

/**
 * 模版消息实体类
 *
 * @ClassName: TemplateMsg
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public class TemplateMsg {

	private String touser;
	private String template_id;
	private String url;
	private Data data;

	public TemplateMsg() {
		super();
	}

	public TemplateMsg(String touser, String template_id, String url, Data data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}

	private static TemplateMsg me = new TemplateMsg();

	public static ValueAndColor createValueAndColor(String value, String color) {
		return me.new ValueAndColor(value, color);
	}

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

	public class ValueAndColor {
		private String value;
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
