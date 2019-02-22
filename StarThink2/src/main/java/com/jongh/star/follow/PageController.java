package com.jongh.star.follow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongh.star.member.Member;
import com.jongh.star.member.MemberDAO;
import com.jongh.star.sns.SNSDAO;
import com.jongh.star.weather.WeatherDAO;

@Controller
public class PageController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;
	@Autowired
	private PageDAO pDAO;

	
	@RequestMapping(value = "/page.my.go", method = RequestMethod.GET)
	public String myPage(Member m,HttpServletRequest req,HttpServletResponse res) {
		
		WeatherDAO.weather(req, res);
		
		if (mDAO.loginCheck(req, res)) {
			pDAO.page(m, req, res);
			req.setAttribute("contentPage", "page/myPage.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value = "/page.go", method = RequestMethod.GET)
	public String page(Member m,HttpServletRequest req,HttpServletResponse res) {
		
		WeatherDAO.weather(req, res);
		
		if (mDAO.loginCheck(req, res)) {
			pDAO.page(m, req, res);
			req.setAttribute("contentPage", "page/page.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	
	@RequestMapping(value = "/page.follow", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody Follows following(Follow fo,HttpServletRequest req) {

		return pDAO.followCheck(fo, req);
	}
	@RequestMapping(value = "/page.follower", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody Follows follower(Follow fo,HttpServletRequest req) {
		
		return pDAO.follower(fo, req);
	}
	
	@RequestMapping(value = "/page.follower.check", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody Follows followerCheck(Follow fo,HttpServletRequest req) {
		
		return pDAO.followerCheck(fo, req);
	}
	
	@RequestMapping(value = "/page.follower.delete", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody String followerDelete(Follow fo,HttpServletRequest req) {
		return pDAO.followerDelete(fo);
	}
	@RequestMapping(value = "/page.follower.reg", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody String followerReg(Follow fo,HttpServletRequest req) {
		return pDAO.followerReg(fo);
	}
	
	
	
}
