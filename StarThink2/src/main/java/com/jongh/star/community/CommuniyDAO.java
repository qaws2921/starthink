package com.jongh.star.community;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jongh.star.member.Member;

@Service
public class CommuniyDAO {
	private List<Member> ms;
	private HashMap<String, Integer> msMap;
	

	@Autowired
	private SqlSession ss;

	public void getAllCommunity() {
		System.out.println("시작");
		ms = ss.getMapper(CommunityMapper.class).getAllCommunity();
		System.out.println(ms.size());
		msMap = new HashMap<String, Integer>();
		for (int i = 0; i < ms.size(); i++) {
			msMap.put(ms.get(i).getSm_id(), i);
		}

	}
	
	
	public void regCommuntiy(Member m) {
		
		ms.add(m);
		
		msMap.put(m.getSm_id(), msMap.size());
	}
	
	public void deleteCommuntiy(Member m) {
		int no = msMap.get(m.getSm_id());
		ms.remove(no);
		msMap.remove(m.getSm_id());
		Member m2 = null;
		for (int i = no; i < msMap.size(); i++) {
			m2 = ms.get(i);
			msMap.put(m2.getSm_id(),i);
		}
	}
	
	public void updateCommuntiy(Member m) {
		int no = msMap.get(m.getSm_id());
		ms.set(no, m);
		
	}

	public void getSearchMessage(HttpServletRequest req, HttpServletResponse res) {

		Member m = (Member) req.getSession().getAttribute("loginMember");
		List<Message> mes = ss.getMapper(CommunityMapper.class).getSearchMessage(m);
		req.getSession().setAttribute("searchMessage", mes);
	

	}

	public void pagingCommunity(HttpServletRequest req, HttpServletResponse res) {

		List<Member> ms2 = ms;

		if (ms2 != null && ms2.size() > 0) {
			req.setAttribute("ms", ms2);
		}

		List<Message> mes2 = (List<Message>)req.getSession().getAttribute("searchMessage");

		if (mes2 != null && mes2.size() > 0) {
			req.setAttribute("mes", mes2);
		}
	}

	public void regMessage(Message me, HttpServletRequest req, HttpServletResponse res) {

		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String sme_id = m.getSm_id();
			me.setSme_id(sme_id);
			String sme_name = m.getSm_name();
			me.setSme_name(sme_name);
			String sme_img = m.getSm_img();
			me.setSme_img(sme_img);

			if (ss.getMapper(CommunityMapper.class).regMessage(me) == 1) {
				req.setAttribute("r", "메세지 보내기 성공");

			}

		} catch (Exception e) {
			req.setAttribute("r", "메세지 보내기 실패");
			e.printStackTrace();

		}
	}
	public void deleteMessage(Message me, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			if (ss.getMapper(CommunityMapper.class).getDeleteMessage(me) == 1) {
				req.setAttribute("r", "메세지 삭제 성공");
				
			}
			
		} catch (Exception e) {
			req.setAttribute("r", "메세지 삭제 실패");
			e.printStackTrace();
			
		}
	}
}
