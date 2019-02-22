package com.jongh.star.hart;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jongh.star.sns.SNS;

@Service
public class HartDAO {
	@Autowired
	private SqlSession ss;
	
	public Harts hartCheck(SNS s) {
		return new Harts(ss.getMapper(HartMapper.class).hart(s));
	}
	public Harts hartImgCheck(SNS s) {
		return new Harts(ss.getMapper(HartMapper.class).hartImgCheck(s));
	}
	
}
