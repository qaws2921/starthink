package com.jongh.star.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongh.star.member.MemberDAO;
import com.jongh.star.weather.WeatherDAO;

@Controller
public class SNSController {
	
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;
	
	@RequestMapping(value = "/sns.reg", method = RequestMethod.POST)
	public String regSNS(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.regSNS(req, res);
			snsDAO.seachSNSSession(req, res);
		} 
		snsDAO.pagingSNS(1, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.update", method = RequestMethod.POST)
	public String updateSNS(HttpServletRequest req,HttpServletResponse res) {
	
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.updateSMS(req, res);
			snsDAO.seachSNSSession(req, res);
		}
		
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
		
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String deleteSNS(SNS sns,HttpServletRequest req,HttpServletResponse res) {
		
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.deleteSNS(sns,req, res);
			snsDAO.seachSNSSession(req, res);
		}
		
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
		
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.detail", method = RequestMethod.GET)
	public String detailSNS(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			
			snsDAO.detailSMSTxt(req, res);

			req.setAttribute("snsUpdate", "snsUpdate");
		} 
		snsDAO.sessionSMSPageNo(req, res);
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.show.paging", method = RequestMethod.GET)
	public String showSNS(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		snsDAO.sessionSMSPageNo(req, res);
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
				
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.show.search", method = RequestMethod.GET)
	public String searchSNS(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		snsDAO.seachSNS(req, res);
		snsDAO.pagingSNS(1, req, res);
		
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.comment.reg", method = RequestMethod.GET)
	public String regSNSComment(SNSComment snsc,HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.regSNSComment(snsc, req, res);
			
		}
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.comment.delete", method = RequestMethod.GET)
	public String deleteSNSComment(SNSComment snsc,HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.deleteSNSComment(snsc, req, res);
			
		}
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.comment.update", method = RequestMethod.GET)
	public String updateSNSComment(SNSComment snsc,HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			snsDAO.updateSNSComment(snsc, req, res);
			
		}
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.page.ajax", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSs pagingAjaxSNS(HttpServletRequest req,HttpServletResponse res) {
		return snsDAO.pagingAjaxSNS(req, res);
	}
	
}
