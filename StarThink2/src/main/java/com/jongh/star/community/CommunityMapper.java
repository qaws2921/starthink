package com.jongh.star.community;

import java.util.List;

import com.jongh.star.member.Member;

public interface CommunityMapper {
	public abstract List<Member> getAllCommunity();
	public abstract List<Message> getSearchMessage(Member m);
	public abstract Message getMessage();
	public abstract int regMessage(Message me);
	public abstract int getDeleteMessage(Message me);
}
