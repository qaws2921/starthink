package com.jongh.star.member;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	private String sm_id;
	private String sm_pw;
	private String sm_name;
	private String sm_addr;
	private String sm_img;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String sm_id, String sm_pw, String sm_name, String sm_addr, String sm_img) {
		super();
		this.sm_id = sm_id;
		this.sm_pw = sm_pw;
		this.sm_name = sm_name;
		this.sm_addr = sm_addr;
		this.sm_img = sm_img;
	}

	public String getSm_id() {
		return sm_id;
	}
	@XmlElement
	public void setSm_id(String sm_id) {
		this.sm_id = sm_id;
	}
	public String getSm_pw() {
		return sm_pw;
	}
	@XmlElement
	public void setSm_pw(String sm_pw) {
		this.sm_pw = sm_pw;
	}
	public String getSm_name() {
		return sm_name;
	}
	@XmlElement
	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}
	public String getSm_addr() {
		return sm_addr;
	}
	@XmlElement
	public void setSm_addr(String sm_addr) {
		this.sm_addr = sm_addr;
	}
	public String getSm_img() {
		return sm_img;
	}
	@XmlElement
	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}
	
}
