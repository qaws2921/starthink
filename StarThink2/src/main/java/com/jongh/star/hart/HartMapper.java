package com.jongh.star.hart;

import java.util.List;

import com.jongh.star.sns.SNS;

public interface HartMapper {
	public abstract List<Hart> hart(SNS s);
	public abstract List<Hart> hartImgCheck(SNS s);
}
