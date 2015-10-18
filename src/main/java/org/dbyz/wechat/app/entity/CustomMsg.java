package org.dbyz.wechat.app.entity;

/**
 * 客服消息
 *
 * @ClassName: CustomMsg
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public class CustomMsg {
	/**
	 * 发送的openId
	 */
	private String touser;
	/**
	 * 消息的类型
	 * 
	 * @see CustomMsgType
	 */
	private String msgtype;
	/**
	 * 以下四种只能有一种
	 */
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

	/**
	 * 客服消息-文本消息
	 *
	 * @ClassName: text
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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

	/**
	 * 客服消息-图片消息
	 *
	 * @ClassName: image
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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

	/**
	 * 客服消息-语音消息
	 *
	 * @ClassName: voice
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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

	/**
	 * 客服消息-视频消息
	 *
	 * @ClassName: video
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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

	/**
	 * 客服消息-音乐消息
	 *
	 * @ClassName: music
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
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

	/**
	 * 客服消息-图文消息
	 *
	 * @ClassName: news
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
	public static class news {
		/**
		 * 图文列表
		 */
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

	/**
	 * 单条图文
	 *
	 * @ClassName: article
	 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
	 * @version: V1.0
	 */
	public static class article {
		/**
		 * 显示的标题
		 */
		private String title;
		/**
		 * 显示图片的连接
		 */
		private String picurl;
		/**
		 * 打开的URL
		 */
		private String url;

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

	public static enum CustomMsgType {

		/**
		 * 文本消息
		 */
		TEXT("text"),
		/**
		 * 图片消息
		 */
		IMAGE("image"),
		/**
		 * 声音消息
		 */
		VOICE("voice"),
		/**
		 * 视频消息
		 */
		VIDEO("video"),
		/**
		 * 音乐消息
		 */
		MUSIC("music"),
		/**
		 * 图文消息
		 */
		NEWS("news"),
		/**
		 * 卡券消息
		 */
		WXCARD("wxcard");

		private String msgtype;

		private CustomMsgType(String msgtype) {
			this.msgtype = msgtype;
		}

		public String getMsgtype() {
			return msgtype;
		}
	}

}
