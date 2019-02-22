package com.jongh.star.follow;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Follow {
	private String jsf_followingid;
	private String jsf_followerid;
	private Date jsf_date;
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	public Follow(String jsf_followingid, String jsf_followerid, Date jsf_date) {
		super();
		this.jsf_followingid = jsf_followingid;
		this.jsf_followerid = jsf_followerid;
		this.jsf_date = jsf_date;
	}

	public String getJsf_followingid() {
		return jsf_followingid;
	}
	@XmlElement
	public void setJsf_followingid(String jsf_followingid) {
		this.jsf_followingid = jsf_followingid;
	}

	public String getJsf_followerid() {
		return jsf_followerid;
	}

	@XmlElement
	public void setJsf_followerid(String jsf_followerid) {
		this.jsf_followerid = jsf_followerid;
	}

	public Date getJsf_date() {
		return jsf_date;
	}

	@XmlElement
	public void setJsf_date(Date jsf_date) {
		this.jsf_date = jsf_date;
	}
	
}
