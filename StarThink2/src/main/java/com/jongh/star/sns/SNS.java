package com.jongh.star.sns;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SNS {
	private BigDecimal st_no;
	private String st_id;
	private String st_txt;
	private String st_img;
	private String st_photo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime st_date;
	
	private String sm_name;
	private String st_host;
	private List<SNSComment> snscs;
	public SNS() {
		// TODO Auto-generated constructor stub
	}
	public SNS(BigDecimal st_no, String st_id, String st_txt, String st_img, String st_photo, LocalDateTime st_date,
			String sm_name, String st_host, List<SNSComment> snscs) {
		super();
		this.st_no = st_no;
		this.st_id = st_id;
		this.st_txt = st_txt;
		this.st_img = st_img;
		this.st_photo = st_photo;
		this.st_date = st_date;
		this.sm_name = sm_name;
		this.st_host = st_host;
		this.snscs = snscs;
	}
	public BigDecimal getSt_no() {
		return st_no;
	}
	public void setSt_no(BigDecimal st_no) {
		this.st_no = st_no;
	}
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_txt() {
		return st_txt;
	}
	public void setSt_txt(String st_txt) {
		this.st_txt = st_txt;
	}
	public String getSt_img() {
		return st_img;
	}
	public void setSt_img(String st_img) {
		this.st_img = st_img;
	}
	public String getSt_photo() {
		return st_photo;
	}
	public void setSt_photo(String st_photo) {
		this.st_photo = st_photo;
	}
	public LocalDateTime getSt_date() {
		return st_date;
	}
	public void setSt_date(LocalDateTime st_date) {
		this.st_date = st_date;
	}
	public String getSm_name() {
		return sm_name;
	}
	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}
	public String getSt_host() {
		return st_host;
	}
	public void setSt_host(String st_host) {
		this.st_host = st_host;
	}
	public List<SNSComment> getSnscs() {
		return snscs;
	}
	public void setSnscs(List<SNSComment> snscs) {
		this.snscs = snscs;
	}
	
	
}
