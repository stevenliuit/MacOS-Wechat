package com.wechat.pojo;

import java.io.Serializable;

public class UserInfo  implements Serializable{
	private String title;
	private String subTitle;
	private String url;
	private String icon;
	private String userId;
	private String copyText;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCopyText() {
		return copyText;
	}
	public void setCopyText(String copyText) {
		this.copyText = copyText;
	}

}
