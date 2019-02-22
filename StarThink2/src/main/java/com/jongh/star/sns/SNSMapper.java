package com.jongh.star.sns;

import java.util.List;

import com.jongh.star.member.Member;

public interface SNSMapper {
	public abstract int regSNS(SNS sns);
	public abstract int updateSNSPhoto(SNS sns);
	public abstract int updateSNS(SNS sns);
	public abstract int deleteSNS(SNS sns);
	public abstract List<SNS> getShowSNS(Inquiry in);
	public abstract List<SNS> getShowPageSNS(Inquiry in);
	public abstract List<SNS> getAllSNS();
	public abstract List<SNS> getSeachSNSId(SNS sns);
	public abstract List<SNS> getSeachSNSTxt(SNS sns);
	public abstract SNS getSNS(SNS sns);
	public abstract Integer getAllSNSCount();
	public abstract Integer getSNSIdCount(Member m);
}
