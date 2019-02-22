package com.jongh.star.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jongh.star.community.CommuniyDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private CommuniyDAO cDAO;
	
	@Autowired
	private SqlSession ss;

	public boolean regMemberJoin(Member m, HttpServletRequest req, HttpServletResponse res) {

		String path = null;
		MultipartRequest mr = null;
		try {

			path = req.getSession().getServletContext().getRealPath("resources/memberImg");
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			req.setAttribute("r", "파일이 너무큼");
			return false;
		}

		try {

			String sm_id = mr.getParameter("sm_id");
			String sm_pw = mr.getParameter("sm_pw");
			String sm_name = mr.getParameter("sm_name");
			String sm_addr = String.format("%s!%s!%s", mr.getParameter("sm_addr1"), mr.getParameter("sm_addr2"),
					mr.getParameter("sm_addr3"));

			String sm_img = mr.getFilesystemName("sm_img");

			if (sm_img == null) {
				sm_img = "kakao.jpg";
			} else {
				sm_img = URLEncoder.encode(sm_img, "utf-8");
				sm_img = sm_img.replace("+", " ");

			}

			m.setSm_id(sm_id);
			m.setSm_pw(sm_pw);
			m.setSm_name(sm_name);
			m.setSm_addr(sm_addr);
			m.setSm_img(sm_img);

			if (ss.getMapper(MemberMapper.class).regMemberJoin(m) == 1) {
				Cookie joinId = new Cookie("joinId", sm_id);
				joinId.setMaxAge(10);
				res.addCookie(joinId);
				cDAO.regCommuntiy(m);

				return true;
			}
			return false;

		} catch (Exception e) {
			req.setAttribute("r", "회원가입 실패");
			File f = new File(path + "/" + mr.getFilesystemName("sm_img"));
			f.delete();
			e.printStackTrace();
			return false;
		}
	}

	public void loginMember(Member m, HttpServletRequest req, HttpServletResponse res) {

		try {

			String sm_auto = req.getParameter("sm_auto");

			Member m2 = ss.getMapper(MemberMapper.class).getMember(m);

			if (m2 != null) {
				if (m.getSm_pw().equals(m2.getSm_pw())) {

					req.getSession().setAttribute("loginMember", m2);
					req.getSession().setMaxInactiveInterval(30 * 60);

					if (sm_auto != null) {
						Cookie loginId = new Cookie("loginId", m2.getSm_id());
						loginId.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(loginId);
					}

				} else {
					req.setAttribute("r", "비번 오류");
				}

			} else {
				req.setAttribute("r", "없는 ID");

			}

		} catch (Exception e) {
			req.setAttribute("r", "로그인 실패");
			e.printStackTrace();
		}
	}

	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		autoLoginCheck(req, res);
		Member m = (Member) req.getSession().getAttribute("loginMember");

		if (m != null) {
			req.setAttribute("loginPage", "member/loginOK.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	private void autoLoginCheck(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loginId")) {
					String sm_id = c.getValue();
					if (sm_id != null && sm_id != "") {
						try {

							Member m2 = new Member();
							m2.setSm_id(sm_id);
							m2 = (Member) ss.getMapper(MemberMapper.class).getMember(m2);
							;
							if (m2 != null) {

								req.getSession().setAttribute("loginMember", m2);
								req.getSession().setMaxInactiveInterval(30 * 60);

							} else {
								req.setAttribute("r", "없는 ID");
							}

						} catch (Exception e) {
							req.setAttribute("r", "로그인 실패");
							e.printStackTrace();
						}
					}

					break;
				}
			}
		}
	}

	public void logoutMember(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loginId")) {
					c.setValue(null);
					res.addCookie(c);
					break;
				}
			}
		}
	}

	public void membership(HttpServletRequest req, HttpServletResponse res) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String[] addrs = m.getSm_addr().split("!");
		
		req.setAttribute("sm_addr1", addrs[0]);
		req.setAttribute("sm_addr2", addrs[1]);
		req.setAttribute("sm_addr3", addrs[2]);
	}

	public void updateMember(HttpServletRequest req, HttpServletResponse res) {

		String path = null;
		MultipartRequest mr = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/memberImg");

			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			req.setAttribute("r", "파일이 너무 큼");

		}

		Member m = null;
		Member m2 = null;
		try {

			String sm_id = mr.getParameter("sm_id");
			String sm_pw = mr.getParameter("sm_pw");
			String sm_name = mr.getParameter("sm_name");
			String sm_addr = String.format("%s,%s,%s", mr.getParameter("sm_addr1"), mr.getParameter("sm_addr2"),
					mr.getParameter("sm_addr3"));
			String sm_img = mr.getFilesystemName("sm_img");
			
			m2 = new Member(sm_id, sm_pw, sm_name, sm_addr, null);

			if (sm_img != null) {
			
				m = ss.getMapper(MemberMapper.class).getMember(m2);
				sm_img = URLEncoder.encode(sm_img, "utf-8");
				sm_img = sm_img.replace("+", " ");
				m2.setSm_img(sm_img);

				if (ss.getMapper(MemberMapper.class).updateMembershipImg(m2) == 1) {
					req.setAttribute("r", "수정 성공");
					loginMember2(sm_id, sm_pw, req, res);
					if (sm_img != null) {
						String img = URLDecoder.decode(m.getSm_img(), "utf-8");
						File f = new File(path + "/" + img);
						f.delete();
					}
					cDAO.updateCommuntiy(ss.getMapper(MemberMapper.class).getMember(m2));
				}

			} else {
				if (ss.getMapper(MemberMapper.class).updateMembership(m2) == 1) {
					req.setAttribute("r", "수정 성공");
					loginMember2(sm_id, sm_pw, req, res);
					cDAO.updateCommuntiy(ss.getMapper(MemberMapper.class).getMember(m2));
				}

			}

			// CommunityDAO.getCdao().updateCommuntiy(ss.selectOne("memberMapper.getMember",m2));

		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
			e.printStackTrace();

		}
	}

	private void loginMember2(String sm_id, String sm_pw, HttpServletRequest request, HttpServletResponse response) {
		try {

			Member m = new Member(sm_id, sm_pw, null, null, null);

			Member m2 = ss.getMapper(MemberMapper.class).getMember(m);
			if (m2 != null) {
				if (sm_pw.equals(m2.getSm_pw())) {

					request.getSession().setAttribute("loginMember", m2);
					request.getSession().setMaxInactiveInterval(30 * 60);

				} else {
					request.setAttribute("r", "비번 오류");
				}

			} else {
				request.setAttribute("r", "없는 ID");

			}

		} catch (Exception e) {
			request.setAttribute("r", "로그인 실패");
			e.printStackTrace();
		}
	}

	public void deleteMember(Member m ,HttpServletRequest req, HttpServletResponse res) {

		
		Member m2 = null;
		String path = null;
		try {
			path = req.getSession().getServletContext().getRealPath("/resources/memberImg");
			MemberMapper mm = ss.getMapper(MemberMapper.class);
			MemberMapper mm2 = ss.getMapper(MemberMapper.class);
			m2 = mm.getMember(m);
			
			cDAO.deleteCommuntiy(m2);

			if (mm2.deleteMembership(m) == 1) {
				req.setAttribute("r", "삭제 성공");
				String img = URLDecoder.decode(m2.getSm_img(), "utf-8");
				File f = new File(path + "/" + img);
				f.delete();

			}

		} catch (Exception e) {
			req.setAttribute("r", "삭제 실패");
			e.printStackTrace();

		}
	}
	
	public Members memberIdCheck(Member m,HttpServletRequest req,HttpServletResponse res) {
		Member dbM = ss.getMapper(MemberMapper.class).getMember(m);
		ArrayList<Member> al = new ArrayList<Member>();
		al.add(dbM);
		Members ms = new Members(al);
		
		return ms;
	}
}
