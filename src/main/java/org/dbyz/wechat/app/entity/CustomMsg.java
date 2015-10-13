package org.dbyz.wechat.app.entity;

/**
 * 客服消息
 *
 * @ClassName: CustomMsg
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public class CustomMsg {
	private String touser;
	private String msgtype;
	private text text;
	private image image;
	private voice voice;
	private video video;
	private music music;
	private news news;

	public image getImage() {
		return image;
	}

	public void setImage(image image) {
		this.image = image;
	}

	public voice getVoice() {
		return voice;
	}

	public void setVoice(voice voice) {
		this.voice = voice;
	}

	public video getVideo() {
		return video;
	}

	public void setVideo(video video) {
		this.video = video;
	}

	public music getMusic() {
		return music;
	}

	public void setMusic(music music) {
		this.music = music;
	}

	public news getNews() {
		return news;
	}

	public void setNews(news news) {
		this.news = news;
	}

	public CustomMsg(String touser, String msgtype) {
		super();
		this.touser = touser;
		this.msgtype = msgtype;
	}

	public text getText() {
		return text;
	}

	public void setText(text text) {
		this.text = text;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public static class text {
		private String content;

		public text(String content) {
			super();
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class image {
		private String media_id;

		public image(String media_id) {
			super();
			this.media_id = media_id;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}

	public static class voice {
		private String media_id;

		public voice(String media_id) {
			super();
			this.media_id = media_id;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}

	public static class video {
		private String media_id;
		private String thumb_media_id;
		private String title;
		private String description;

		public video(String media_id, String thumb_media_id, String title,
				String description) {
			super();
			this.media_id = media_id;
			this.thumb_media_id = thumb_media_id;
			this.title = title;
			this.description = description;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
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

	}

	public static class music {
		private String title;
		private String description;
		private String musicurl;
		private String hqmusicurl;
		private String thumb_media_id;

		public music(String title, String description, String musicurl,
				String hqmusicurl, String thumb_media_id) {
			super();
			this.title = title;
			this.description = description;
			this.musicurl = musicurl;
			this.hqmusicurl = hqmusicurl;
			this.thumb_media_id = thumb_media_id;
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

		public String getMusicurl() {
			return musicurl;
		}

		public void setMusicurl(String musicurl) {
			this.musicurl = musicurl;
		}

		public String getHqmusicurl() {
			return hqmusicurl;
		}

		public void setHqmusicurl(String hqmusicurl) {
			this.hqmusicurl = hqmusicurl;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}
	}

	public static class news {
		private article[] articles;

		public news(article[] articles) {
			super();
			this.articles = articles;
		}

		public article[] getArticles() {
			return articles;
		}

		public void setArticles(article[] articles) {
			this.articles = articles;
		}

	}

	public static class article {
		private String title;
		private String url;
		private String picurl;

		public article(String title, String url, String picurl) {
			super();
			this.title = title;
			this.url = url;
			this.picurl = picurl;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}

	}
}
