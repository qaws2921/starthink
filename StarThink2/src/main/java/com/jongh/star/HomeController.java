package com.jongh.star;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jongh.star.community.CommuniyDAO;
import com.jongh.star.file.FileDAO;
import com.jongh.star.member.MemberDAO;
import com.jongh.star.sns.SNSDAO;
import com.jongh.star.weather.WeatherDAO;

// 자바빈 사용하지 않음
// serviet-context.xml에 등록해놓은거는 사용하지 않아도 다 생성(AAC 방식)
// HomeController, SNSDAO, SqlSession
// 생성 순서???


@Controller // serviet-context.xml에 등록, 컨트롤러로 역할로 사용
public class HomeController {

	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;
	@Autowired
	private FileDAO fDAO;
	@Autowired
	private CommuniyDAO cDAO;
	// SNSDAO, SqlSession이 아직 생성되지 않았을 수 있음
	private boolean firstReq; // 첫 요청인지 따질 변수
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req,HttpServletResponse res) {
		if (firstReq) {
			snsDAO.getAllSNSCount(null, null);
			fDAO.getAllFile();
			cDAO.getAllCommunity();
			firstReq = false;
		}
		
		WeatherDAO.weather(req, res);
		snsDAO.seachSNSClean(req, res);
		mDAO.loginCheck(req, res);
		snsDAO.homeSMSPageNo(req, res);
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		
		
		return "index";
	}
	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String home2(HttpServletRequest req,HttpServletResponse res) {
		WeatherDAO.weather(req, res);
		mDAO.loginCheck(req, res);
		snsDAO.seachSNSClean(req, res);
		snsDAO.homeSMSPageNo(req, res);
		int pageNo = (Integer) req.getSession().getAttribute("SNSPaging");
		snsDAO.pagingSNS(pageNo, req, res);
		req.setAttribute("contentPage", "home/home.jsp");
		
		
		return "index";
	}
	
}
