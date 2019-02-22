package com.jongh.star.sns;

import java.util.List;

public interface SNSCommentMapper {
	public abstract int regSNSComment(SNSComment snsc);
	public abstract int deleteSNSComment(SNSComment snsc);
	public abstract int updateSNSComment(SNSComment snsc);
	public abstract List<SNSComment> getAllSNSComment(SNS sns);
	
}
