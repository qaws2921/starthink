package com.jongh.star.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongh.star.sns.SNSDAO;
import com.jongh.star.weather.WeatherDAO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;

	// 가입
	@RequestMapping(value = "/member.join", method = RequestMethod.GET)
	public String join(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		req.setAttribute("loginPage", "member/login.jsp");
		req.setAttribute("contentPage", "member/join.jsp");
		
		
		return "index";
	}
	@RequestMapping(value = "/member.join.reg", method = RequestMethod.POST)
	public String regJoin(Member m, HttpServletRequest req,HttpServletResponse res) {
		
		WeatherDAO.weather(req, res);
		req.setAttribute("loginPage", "member/login.jsp");
		if (mDAO.regMemberJoin(m, req, res)) {
			snsDAO.seachSNSClean(req, res);
			req.setAttribute("contentPage", "home/home.jsp");			
			return "index2";
		}else {	
			req.setAttribute("contentPage", "member/join.jsp");
			return "index";
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////////
	//회원정보
	@RequestMapping(value = "/member.membership", method = RequestMethod.GET)
	public String membership(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			mDAO.membership(req, res);
			req.setAttribute("contentPage", "member/membership.jsp");
		} else {
			snsDAO.seachSNSClean(req, res);
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
		}		
		return "index";
	}
	@RequestMapping(value = "/member.membership.update", method = RequestMethod.POST)
	public String updateMembership(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			mDAO.updateMember(req, res);
			mDAO.membership(req, res);
			req.setAttribute("contentPage", "member/membership.jsp");
		} else {
			snsDAO.seachSNSClean(req, res);
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
		}		
		return "index";
	}
	@RequestMapping(value = "/member.membership.delete", method = RequestMethod.GET)
	public String deleteMembership(Member m,HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			mDAO.deleteMember(m, req, res);
			mDAO.logoutMember(req, res);
			mDAO.loginCheck(req, res);
		}
		snsDAO.seachSNSClean(req, res);
		snsDAO.pagingSNS(1, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////	
	//로그인
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String getMember(Member m, HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		mDAO.loginMember(m, req, res);
		mDAO.loginCheck(req, res);
		snsDAO.seachSNSClean(req, res);
		snsDAO.pagingSNS(1, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		
		
		return "index";
	}
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logoutMember(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		mDAO.logoutMember(req, res);
		mDAO.loginCheck(req, res);
		snsDAO.seachSNSClean(req, res);
		snsDAO.pagingSNS(1, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		
		
		return "index";
	}
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody Members memberIdCheck(Member m,HttpServletRequest req,HttpServletResponse res) {
				
		return mDAO.memberIdCheck(m, req, res);
	}


}
