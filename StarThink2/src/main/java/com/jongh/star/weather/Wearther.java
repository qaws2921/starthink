package com.jongh.star.weather;

public class Wearther {
	private String description;
	private String icon;
	private double temp;
	private double humidity;
	public Wearther() {
		// TODO Auto-generated constructor stub
	}
	public Wearther(String description, String icon, double temp, double humidity) {
		super();
		this.description = description;
		this.icon = icon;
		this.temp = temp;
		this.humidity = humidity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	
	
}
