package com.jongh.star.file;

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
public class FileController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO snsDAO;
	@Autowired
	private FileDAO fDAO;
	
	@RequestMapping(value="/file.go", method = RequestMethod.GET)
	public String file(HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		fDAO.searchFileClean(req, res);
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("contentPage", "file/file.jsp");
			fDAO.pagingFile(req, res);
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/file.search", method = RequestMethod.GET)
	public String searchFile(File file,HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			fDAO.getSearchFile(file, req, res);
			req.setAttribute("contentPage", "file/file.jsp");
			fDAO.pagingFile(req, res);
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/file.reg", method = RequestMethod.POST)
	public String regFile(HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			fDAO.regFile(req, res);
			fDAO.pagingFile(req, res);
			req.setAttribute("contentPage", "file/file.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/file.delete", method = RequestMethod.GET)
	public String deleteFile(File file,HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			fDAO.deleteFile(file, req, res);
			fDAO.pagingFile(req, res);
			req.setAttribute("contentPage", "file/file.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/file.update", method = RequestMethod.POST)
	public String updateFile(HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			fDAO.updateFile(req, res);
			fDAO.pagingFile(req, res);
			req.setAttribute("contentPage", "file/file.jsp");
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	@RequestMapping(value="/file.detail", method = RequestMethod.GET)
	public String detailFile(File file,HttpServletRequest req, HttpServletResponse res){
		WeatherDAO.weather(req, res);
		if (mDAO.loginCheck(req, res)) {
			fDAO.detailFile(file, req, res);
			req.setAttribute("FilePage", "FilePage");
			req.setAttribute("contentPage", "file/file.jsp");
			fDAO.pagingFile(req, res);
			
		}else {
			snsDAO.pagingSNS(1, req, res);
			req.setAttribute("contentPage", "home/home.jsp");
			
		}
		return "index";
	}
	
	
	
}
