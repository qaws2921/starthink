package com.jongh.star.file;

import java.math.BigDecimal;
import java.util.Date;

public class File {
	private BigDecimal sf_no;
	private String sf_id;
	private String sf_img;
	private String sf_title;
	private String sf_file;
	private String sf_color;
	private Date sf_date;
	public File() {
		// TODO Auto-generated constructor stub
	}
	public File(BigDecimal sf_no, String sf_id, String sf_img, String sf_title, String sf_file, String sf_color,
			Date sf_date) {
		super();
		this.sf_no = sf_no;
		this.sf_id = sf_id;
		this.sf_img = sf_img;
		this.sf_title = sf_title;
		this.sf_file = sf_file;
		this.sf_color = sf_color;
		this.sf_date = sf_date;
	}
	public BigDecimal getSf_no() {
		return sf_no;
	}
	public void setSf_no(BigDecimal sf_no) {
		this.sf_no = sf_no;
	}
	public String getSf_id() {
		return sf_id;
	}
	public void setSf_id(String sf_id) {
		this.sf_id = sf_id;
	}
	public String getSf_img() {
		return sf_img;
	}
	public void setSf_img(String sf_img) {
		this.sf_img = sf_img;
	}
	public String getSf_title() {
		return sf_title;
	}
	public void setSf_title(String sf_title) {
		this.sf_title = sf_title;
	}
	public String getSf_file() {
		return sf_file;
	}
	public void setSf_file(String sf_file) {
		this.sf_file = sf_file;
	}
	public String getSf_color() {
		return sf_color;
	}
	public void setSf_color(String sf_color) {
		this.sf_color = sf_color;
	}
	public Date getSf_date() {
		return sf_date;
	}
	public void setSf_date(Date sf_date) {
		this.sf_date = sf_date;
	}
	
}
