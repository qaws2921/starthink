package com.jongh.star.follow;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Follows {
	private List<Follow> follow;
	public Follows() {
		// TODO Auto-generated constructor stub
	}
	public Follows(List<Follow> follow) {
		super();
		this.follow = follow;
	}
	public List<Follow> getFollow() {
		return follow;
	}
	@XmlElement
	public void setFollow(List<Follow> follow) {
		this.follow = follow;
	}
	
}
