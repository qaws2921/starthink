package com.jongh.star.sns;

import java.math.BigDecimal;

public class Inquiry {
	private BigDecimal x;
	private BigDecimal y;
	private String i_st_id;
	public Inquiry() {
		// TODO Auto-generated constructor stub
	}
	public Inquiry(BigDecimal x, BigDecimal y, String i_st_id) {
		super();
		this.x = x;
		this.y = y;
		this.i_st_id = i_st_id;
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public BigDecimal getY() {
		return y;
	}
	public void setY(BigDecimal y) {
		this.y = y;
	}
	public String getI_st_id() {
		return i_st_id;
	}
	public void setI_st_id(String i_st_id) {
		this.i_st_id = i_st_id;
	}
	
}
