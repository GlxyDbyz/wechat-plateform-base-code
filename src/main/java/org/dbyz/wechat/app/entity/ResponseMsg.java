package org.dbyz.wechat.app.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复微信响应类
 *
 * @ClassName: Response
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a> 
 * @version: V1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ResponseMsg {
	/**
	 * 用户微信标识
	 */
	@XmlElement(name = "ToUserName")
	private String toUserName;
	/**
	 * 公众号微信标识
	 */
	@XmlElement(name = "FromUserName")
	private String platformUserName;
	/**
	 * 消息创建时间（整形）
	 */
	@XmlElement(name = "CreateTime")
	private Long createTime;
	/**
	 * 消息类型
	 */
	@XmlElement(name = "MsgType")
	private String msgType;
	/**
	 * 文本消息的内容
	 */
	@XmlElement(name = "Content", required = false)
	private String content;
	
	/**
	 * 附加的字段
	 */
	@XmlElement(name = "FuncFlag", required = false)
	private Integer funcFlag;
	@XmlElement(name = "ArticleCount", required = false)
	private Integer articleCount;
	
	/**
	 * 图文消息
	 */
	@XmlElementWrapper(name = "Articles")
	@XmlElements(@XmlElement(name = "item", required = false))
	private List<ArticleItem> items;

	private Integer id;

	public ResponseMsg() {
		super();
	}

	public ResponseMsg(String toUserName, String platformUserName) {
		this.toUserName = toUserName;
		this.platformUserName = platformUserName;
		this.createTime = System.currentTimeMillis();
	}

	public ResponseMsg(RequestMsg request) {
		this(request.getFromUserName(), request.getToUserName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getPlatformUserName() {
		return platformUserName;
	}

	public void setFromUserName(String platformUserName) {
		this.platformUserName = platformUserName;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		this.setFuncFlag(0);
		this.setMsgType("text");
	}

	public Integer getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<ArticleItem> getItems() {
		return items;
	}

	public void setItems(List<ArticleItem> items) {
		this.items = items;
		this.setArticleCount(items.size());
		this.setFuncFlag(1);
		this.setMsgType("news");
	}

	@Override
	public String toString() {
		if (this.getContent() != null && !this.getContent().equals("")) {
			return "WeixinResponse [toUserName=" + toUserName
					+ ", platformUserName=" + platformUserName
					+ ", createTime=" + createTime + ", msgType=" + msgType
					+ ", content=" + content + ", funcFlag=" + funcFlag + "]";
		} else {
			return "WeixinResponse [toUserName=" + toUserName
					+ ", platformUserName=" + platformUserName
					+ ", createTime=" + createTime + ", msgType=" + msgType
					+ ", articleCount=" + articleCount + ", items="
					+ items.toString() + ", funcFlag=" + funcFlag + "]";
		}
	}
}
