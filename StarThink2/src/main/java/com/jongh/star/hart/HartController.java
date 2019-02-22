package com.jongh.star.hart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongh.star.sns.SNS;

@Controller
public class HartController {
	
	@Autowired
	private HartDAO hDAO;
	
	@RequestMapping(value = "/hart.check", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Harts hartCount(SNS s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartCheck(s);
	}
	@RequestMapping(value = "/hart.check.img", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Harts hartImg(SNS s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartImgCheck(s);
	}
}
