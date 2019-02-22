package com.jongh.star.member;

public interface MemberMapper {
	public abstract int regMemberJoin(Member m);
	public abstract Member getMember(Member m);
//	public abstract ArrayList<Member> memberid(Member m);

	public abstract int updateMembership(Member m);
	public abstract int updateMembershipImg(Member m);
	public abstract int deleteMembership(Member m);
}
