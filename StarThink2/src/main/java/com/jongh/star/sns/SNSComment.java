package com.jongh.star.sns;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SNSComment {
	private BigDecimal sc_no;
	private BigDecimal sc_st_no;
	private String sc_id;
	private String sc_txt;
	private String sc_img;
	private String sc_host;
	
	private LocalDateTime sc_date;
	public SNSComment() {
		// TODO Auto-generated constructor stub
	}
	public SNSComment(BigDecimal sc_no, BigDecimal sc_st_no, String sc_id, String sc_txt, String sc_img, String sc_host,
			LocalDateTime sc_date) {
		super();
		this.sc_no = sc_no;
		this.sc_st_no = sc_st_no;
		this.sc_id = sc_id;
		this.sc_txt = sc_txt;
		this.sc_img = sc_img;
		this.sc_host = sc_host;
		this.sc_date = sc_date;
	}
	public BigDecimal getSc_no() {
		return sc_no;
	}
	public void setSc_no(BigDecimal sc_no) {
		this.sc_no = sc_no;
	}
	public BigDecimal getSc_st_no() {
		return sc_st_no;
	}
	public void setSc_st_no(BigDecimal sc_st_no) {
		this.sc_st_no = sc_st_no;
	}
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_txt() {
		return sc_txt;
	}
	public void setSc_txt(String sc_txt) {
		this.sc_txt = sc_txt;
	}
	public String getSc_img() {
		return sc_img;
	}
	public void setSc_img(String sc_img) {
		this.sc_img = sc_img;
	}
	public String getSc_host() {
		return sc_host;
	}
	public void setSc_host(String sc_host) {
		this.sc_host = sc_host;
	}
	public LocalDateTime getSc_date() {
		return sc_date;
	}
	public void setSc_date(LocalDateTime sc_date) {
		this.sc_date = sc_date;
	}
	
	
	
}
