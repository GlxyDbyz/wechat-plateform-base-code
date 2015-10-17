package org.dbyz.wechat.app.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户发来的的请求消息类
 *
 * @ClassName: Request
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class RequestMsg {
	/**
	 * 公众号微信标识
	 */
	@XmlElement(name = "ToUserName")
	private String toUserName;
	/**
	 * 发送方微信标识
	 */
	@XmlElement(name = "FromUserName")
	private String fromUserName;
	/**
	 * 消息创建时间 （长整型）
	 */
	@XmlElement(name = "CreateTime")
	private Long createTime;
	/**
	 * 消息类型
	 */
	@XmlElement(name = "MsgType")
	private String msgType;
	/**
	 * 消息id，64位整型
	 */
	@XmlElement(name = "MsgId", required = false)
	private Long msgId;

	// -----------1.文本消息---------------------------------------
	/**
	 * 文本消息内容
	 */
	@XmlElement(name = "Content", required = false)
	private String content;

	// --------- 2.图片消息 --------------------------------------
	/**
	 * 图片链接
	 */
	@XmlElement(name = "PicUrl", required = false)
	private String picUrl;
	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@XmlElement(name = "MediaId", required = false)
	private String mediaId;

	// -----------3.语音消息---------------------------------------
	/**
	 * 语音格式 一般为amr
	 */
	@XmlElement(name = "Format", required = false)
	private String format;
	/**
	 * 语音翻译结果
	 */
	@XmlElement(name = "Recognition", required = false)
	private String recognition;
	// MediaId

	// ----------4.视频消息-------------------------------------
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	@XmlElement(name = "ThumbMediaId", required = false)
	private String thumbMediaId;
	// MediaId

	// -----------5.地理位置---------------------------------------
	/**
	 * 纬度
	 */
	@XmlElement(name = "Location_X", required = false)
	private Float location_X;
	/**
	 * 经度
	 */
	@XmlElement(name = "Location_Y", required = false)
	private Float location_Y;
	/**
	 * 缩放大小
	 */
	@XmlElement(name = "Scale", required = false)
	private Integer scale;
	/**
	 * 地理位置信息
	 */
	@XmlElement(name = "Label", required = false)
	private String label;

	// ----------6. 链接消息
	/**
	 * 消息标题
	 */
	@XmlElement(name = "Title", required = false)
	private String title;
	/**
	 * 消息描述
	 */
	@XmlElement(name = "Description", required = false)
	private String description;
	/**
	 * 消息链接
	 */
	@XmlElement(name = "Url", required = false)
	private String url;

	// -------7. 事件推送-------------------
	/**
	 * 事件名称
	 */
	@XmlElement(name = "Event", required = false)
	private String event;
	/**
	 * 事件键值
	 */
	@XmlElement(name = "EventKey", required = false)
	private String eventKey;
	/**
	 * 以关注时候扫描你的二维码的ticket，可用来换取二维码图片
	 */
	@XmlElement(name = "Ticket", required = false)
	private String ticket;
	/**
	 * 上报地理位置事件-地理位置纬度
	 */
	@XmlElement(name = "Latitude", required = false)
	private String latitude;
	/**
	 * 上报地理位置事件-地理位置经度
	 */
	@XmlElement(name = "Longitude", required = false)
	private String longitude;
	/**
	 * 上报地理位置事件-地理位置经度-地理位置精度
	 */
	@XmlElement(name = "Precision", required = false)
	private String precision;

	@XmlElementWrapper(name = "ScanCodeInfo", required = false)
	@XmlElements({ @XmlElement(name = "ScanResult"),
			@XmlElement(name = "ScanType") })
	private ArrayList<String> scanCodeInfo;

	@Override
	public String toString() {
		return "RequestMsg [toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + ", content=" + content
				+ ", picUrl=" + picUrl + ", mediaId=" + mediaId + ", format="
				+ format + ", recognition=" + recognition + ", thumbMediaId="
				+ thumbMediaId + ", location_X=" + location_X + ", location_Y="
				+ location_Y + ", scale=" + scale + ", label=" + label
				+ ", title=" + title + ", description=" + description
				+ ", url=" + url + ", event=" + event + ", eventKey="
				+ eventKey + ", ticket=" + ticket + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", precision=" + precision
				+ ", scanCodeInfo=" + scanCodeInfo + "]";
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public Float getLocation_X() {
		return location_X;
	}

	public void setLocation_X(Float location_X) {
		this.location_X = location_X;
	}

	public Float getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(Float location_Y) {
		this.location_Y = location_Y;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public ArrayList<String> getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ArrayList<String> scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

	public String getScanType() {
		return scanCodeInfo.get(0);
	}
	
	public String getScanResult() {
		return scanCodeInfo.get(1);
	}

	
	public static enum RequestMsgType {
		/**
		 * 文本消息
		 */
		text("text"),
		/**
		 * 图片消息
		 */
		image("image"),
		/**
		 * 语音消息
		 */
		voice("voice"),
		/**
		 * 视频消息
		 */
		video("video"),
		/**
		 * 小视频消息
		 */
		shortvideo("shortvideo"),
		/**
		 * 地理位置消息
		 */
		location("location"),
		/**
		 * 时间推送消息
		 */
		event("event");

		/**
		 * 消息类型名称
		 */
		private String name;

		private RequestMsgType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public static enum EventType {
		/**
		 * 关注事件
		 */
		SUBSCRIBE("subscribe"),
		/**
		 * 取消关注事件
		 */
		UNSUBSCRIBE("unsubscribe"),
		/**
		 * 用户已关注时的扫描事件推送
		 */
		SCAN("SCAN"),
		/**
		 * 上报地理位置事件
		 */
		LOCATION("LOCATION"),
		/**
		 * 自定义菜单事件
		 */
		CLICK("CLICK"),
		/**
		 * 点击菜单跳转链接时的事件推送
		 */
		VIEW("VIEW"),
		/**
		 * 扫描二维码直接推送事件
		 */
		SCANCODE_PUSH("scancode_push"),
		/**
		 * 扫描二维码先让用户查看再推送事件
		 */
		SCANCODE_WAITMSG("scancode_waitmsg"),
		/**
		 * 系统拍照发图事件
		 */
		PIC_SYSPHOTO("pic_sysphoto"),
		/**
		 * 相册发图事件
		 */
		PIC_WEIXIN("pic_weixin"),
		;
		private String name;

		private EventType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}