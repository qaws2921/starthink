package com.jongh.star.hart;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Hart {
	private BigDecimal sh_st_no;
	private String sh_id;
	private LocalDateTime sh_date;
	public Hart() {
		// TODO Auto-generated constructor stub
	}
	public Hart(BigDecimal sh_st_no, String sh_id, LocalDateTime sh_date) {
		super();
		this.sh_st_no = sh_st_no;
		this.sh_id = sh_id;
		this.sh_date = sh_date;
	}
	public BigDecimal getSh_st_no() {
		return sh_st_no;
	}
	public void setSh_st_no(BigDecimal sh_st_no) {
		this.sh_st_no = sh_st_no;
	}
	public String getSh_id() {
		return sh_id;
	}
	public void setSh_id(String sh_id) {
		this.sh_id = sh_id;
	}
	public LocalDateTime getSh_date() {
		return sh_date;
	}
	public void setSh_date(LocalDateTime sh_date) {
		this.sh_date = sh_date;
	}
	
}
