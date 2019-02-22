package com.jongh.star.follow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jongh.star.member.Member;
import com.jongh.star.member.MemberMapper;
import com.jongh.star.sns.Inquiry;
import com.jongh.star.sns.SNS;
import com.jongh.star.sns.SNSComment;
import com.jongh.star.sns.SNSCommentMapper;
import com.jongh.star.sns.SNSMapper;

@Service
public class PageDAO {
	@Autowired
	private SqlSession ss;
	
	private int snsCount;
	
	public void page(Member m, HttpServletRequest req , HttpServletResponse res) {
		Member m2 = ss.getMapper(MemberMapper.class).getMember(m);
		req.setAttribute("m", m2);
		
		
	}
	
	public Follows followCheck(Follow fo,HttpServletRequest req) {
		
		return new Follows(ss.getMapper(FollowMapper.class).following(fo));
	}
	public Follows follower(Follow fo,HttpServletRequest req) {
		
		return new Follows(ss.getMapper(FollowMapper.class).follower(fo));
	}
	
	public Follows followerCheck(Follow fo,HttpServletRequest req) {
		
		return new Follows(ss.getMapper(FollowMapper.class).followerCheck(fo));
	}
	
	public String followerDelete(Follow fo) {
		if (ss.getMapper(FollowMapper.class).followerDelete(fo) == 1) {
			return "<result>ok</result>";
		}else {
			return "<result>fail</result>";
		}
		
		
		
	}
	public String followerReg(Follow fo) {
		if (ss.getMapper(FollowMapper.class).followerReg(fo) == 1) {
			return "<result>ok</result>";
		}else {
			return "<result>fail</result>";
		}
	}
	
	
	public void pagingSNS(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		req.setAttribute("curPage", pageNo);
		double count = 5;
		int pageCount = (int) Math.ceil(snsCount / count);
		req.setAttribute("pageCount", pageCount);
	
		if (snsCount > 0) {


			int start = snsCount - (pageNo - 1) * (int) count;
			int end = (pageNo == pageCount) ? 1 : start - ((int) count - 1);
			
			
			Inquiry in = new Inquiry(new BigDecimal(start), new BigDecimal(end),null);
			List<SNS> snssRownum = ss.getMapper(SNSMapper.class).getShowPageSNS(in);

			
			for (SNS sns : snssRownum) {
				sns.setSnscs(ss.getMapper(SNSCommentMapper.class).getAllSNSComment(sns));
							
			}
			
			
			req.setAttribute("snss", snssRownum);

		}

	}
	
	public void getAllSNSCount(HttpServletRequest req, HttpServletResponse res) {
		String sm_id=req.getParameter("sm_id");
		Member m = new Member();
		m.setSm_id(sm_id);
		snsCount = ss.getMapper(SNSMapper.class).getSNSIdCount(m);

	}
}
