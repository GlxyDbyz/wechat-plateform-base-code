package org.dbyz.wechat.app.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 单条图文消息
 *
 * @ClassName: ArticleItem
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a> 
 * @version: V1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "items")
public class ArticleItem {
	// 标题文字
	@XmlElement(name = "Title")
	private String title;
	// 说明文字
	@XmlElement(name = "Description")
	private String description;
	// 图片地址
	@XmlElement(name = "PicUrl")
	private String picUrl;
	// 连接地址
	@XmlElement(name = "Url")
	private String url;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ArticleItem [title=" + title + ", description=" + description
				+ ", picUrl=" + picUrl + ", url=" + url + "]";
	}
}
