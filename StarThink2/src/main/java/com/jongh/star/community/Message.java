package com.jongh.star.community;

import java.math.BigDecimal;
import java.util.Date;

public class Message {
	private BigDecimal sme_no;
	private String sme_sm_id;
	private String sme_txt;
	private String sme_id;
	private String sme_img;
	private String sme_name;
	private Date sme_date;
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(BigDecimal sme_no, String sme_sm_id, String sme_txt, String sme_id, String sme_img, String sme_name,
			Date sme_date) {
		super();
		this.sme_no = sme_no;
		this.sme_sm_id = sme_sm_id;
		this.sme_txt = sme_txt;
		this.sme_id = sme_id;
		this.sme_img = sme_img;
		this.sme_name = sme_name;
		this.sme_date = sme_date;
	}
	public BigDecimal getSme_no() {
		return sme_no;
	}
	public void setSme_no(BigDecimal sme_no) {
		this.sme_no = sme_no;
	}
	public String getSme_sm_id() {
		return sme_sm_id;
	}
	public void setSme_sm_id(String sme_sm_id) {
		this.sme_sm_id = sme_sm_id;
	}
	public String getSme_txt() {
		return sme_txt;
	}
	public void setSme_txt(String sme_txt) {
		this.sme_txt = sme_txt;
	}
	public String getSme_id() {
		return sme_id;
	}
	public void setSme_id(String sme_id) {
		this.sme_id = sme_id;
	}
	public String getSme_img() {
		return sme_img;
	}
	public void setSme_img(String sme_img) {
		this.sme_img = sme_img;
	}
	public String getSme_name() {
		return sme_name;
	}
	public void setSme_name(String sme_name) {
		this.sme_name = sme_name;
	}
	public Date getSme_date() {
		return sme_date;
	}
	public void setSme_date(Date sme_date) {
		this.sme_date = sme_date;
	}
	
}
