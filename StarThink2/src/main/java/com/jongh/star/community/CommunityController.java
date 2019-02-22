package com.jongh.star.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jongh.star.member.MemberDAO;
import com.jongh.star.sns.SNSDAO;
import com.jongh.star.weather.WeatherDAO;

@Controller
public class CommunityController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;
	@Autowired
	private CommuniyDAO cDAO;
	
	@RequestMapping(value="/commnunity.go", method = RequestMethod.GET)
	public String commnunity(HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		
		if (mDAO.loginCheck(req, res)) {
			
			cDAO.getSearchMessage(req, res);
			cDAO.pagingCommunity(req, res);
			req.setAttribute("contentPage", "community/community.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/message.reg", method = RequestMethod.GET)
	public String regMessage(Message me ,HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		
		if (mDAO.loginCheck(req, res)) {
			cDAO.regMessage(me, req, res);
			cDAO.getSearchMessage(req, res);
			cDAO.pagingCommunity(req, res);
			req.setAttribute("contentPage", "community/community.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/message.delete", method = RequestMethod.GET)
	public String deleteMessage(Message me ,HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		
		if (mDAO.loginCheck(req, res)) {
			cDAO.deleteMessage(me, req, res);
			cDAO.getSearchMessage(req, res);
			cDAO.pagingCommunity(req, res);
			req.setAttribute("contentPage", "community/community.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
}
