package com.jongh.star.sns;

import java.io.File;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jongh.star.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class SNSDAO {

	private int snsCount;

	@Autowired
	private SqlSession ss;

	public void regSNS(HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest mr = null;
		String path = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/photo");
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "파일이 크다");
			return;
		}

		try {
			String st_id = mr.getParameter("st_id");
			String st_txt = mr.getParameter("st_txt");
			st_txt = st_txt.replace("\r\n", "<br>");

			String st_img = mr.getParameter("st_img");
			String st_photo = mr.getFilesystemName("st_photo");

			String st_host = InetAddress.getLocalHost().getHostAddress();

			
			System.out.println(st_host);
			if (st_photo != null) {
				st_photo = URLEncoder.encode(st_photo, "utf-8");
				st_photo = st_photo.replace("+", " ");
			} else {
				st_photo = "photo";
			}

			SNS sns = new SNS(null, st_id, st_txt, st_img, st_photo, null, null, st_host,null);

			if (ss.getMapper(SNSMapper.class).regSNS(sns) == 1) {
				req.setAttribute("r", "글 등록 성공");
				snsCount++;

			}
		} catch (Exception e) {
			req.setAttribute("r", "글 등록 실패");
			e.printStackTrace();
		}
	}

	public void pagingSNS(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		List<SNS> snssSearch = (List<SNS>) req.getSession().getAttribute("snssSearch");
		req.setAttribute("curPage", pageNo);
		double count = 5;
		int pageCount = (int) Math.ceil(snsCount / count);
		req.setAttribute("pageCount", pageCount);
		if (snssSearch != null && snssSearch.size() > 0) {
			// 검색
			pageCount = (int) Math.ceil(snssSearch.size() / count);
			req.setAttribute("pageCount", pageCount);

			int start = snssSearch.size() - (pageNo - 1) * (int) count;
			int end = (pageNo == pageCount) ? 1 : start - ((int) count - 1);

			List<SNS> snss3 = new ArrayList<SNS>();
			List<SNSComment> snscs = null;
			SNS s = null;
			for (int i = start - 1; i >= end - 1; i--) {
				s = snssSearch.get(i);
				snscs = ss.getMapper(SNSCommentMapper.class).getAllSNSComment(s);
				s.setSnscs(snscs);
				snss3.add(s);
			}
			if (snss3.size() == 1) {
				req.getSession().setAttribute("SNSPaging", (Integer) req.getSession().getAttribute("SNSPaging") - 1);
			}

			req.setAttribute("snss", snss3);

		} else if (snssSearch != null && snssSearch.size() == 0) {
			req.setAttribute("snss", snssSearch);
		} else if (snsCount > 0) {


			int start = snsCount - (pageNo - 1) * (int) count;
			int end = (pageNo == pageCount) ? 1 : start - ((int) count - 1);
			
			
			Inquiry in = new Inquiry(new BigDecimal(start), new BigDecimal(end),null);
			List<SNS> snssRownum = ss.getMapper(SNSMapper.class).getShowSNS(in);

			
			for (SNS sns : snssRownum) {
				sns.setSnscs(ss.getMapper(SNSCommentMapper.class).getAllSNSComment(sns));
							
			}
			
			
			req.setAttribute("snss", snssRownum);

		}

		// int start = pageNo;
		// if (pageNo != 1) {
		// start = (pageNo-1)*((int)count+1);
		// if (pageNo !=2) {
		// start = start-(pageNo-2);
		// }
		// }
		// int end = start+((int)count-1);

	}
	public SNSs pagingAjaxSNS(HttpServletRequest req, HttpServletResponse res) {
		int pageNo = Integer.parseInt(req.getParameter("page"));
		List<SNS> snssSearch = (List<SNS>) req.getSession().getAttribute("snssSearch");
		req.setAttribute("curPage", pageNo);
		double count = 5;
		int pageCount = (int) Math.ceil(snsCount / count);
		req.setAttribute("pageCount", pageCount);
		if (snssSearch != null && snssSearch.size() > 0) {
			// 검색
			pageCount = (int) Math.ceil(snssSearch.size() / count);
			req.setAttribute("pageCount", pageCount);
			
			int start = snssSearch.size() - (pageNo - 1) * (int) count;
			int end = (pageNo == pageCount) ? 1 : start - ((int) count - 1);
			
			List<SNS> snss3 = new ArrayList<SNS>();
			List<SNSComment> snscs = null;
			SNS s = null;
			for (int i = start - 1; i >= end - 1; i--) {
				s = snssSearch.get(i);
				snscs = ss.getMapper(SNSCommentMapper.class).getAllSNSComment(s);
				s.setSnscs(snscs);
				snss3.add(s);
			}
			if (snss3.size() == 1) {
				req.getSession().setAttribute("SNSPaging", (Integer) req.getSession().getAttribute("SNSPaging") - 1);
			}
			return new SNSs(snss3);
			
			
		} else if (snssSearch != null && snssSearch.size() == 0) {
			req.setAttribute("snss", snssSearch);
			return new SNSs(snssSearch);
		} else if (snsCount > 0) {
			
			
			int start = snsCount - (pageNo - 1) * (int) count;
			int end = (pageNo == pageCount) ? 1 : start - ((int) count - 1);
			
			
			Inquiry in = new Inquiry(new BigDecimal(start), new BigDecimal(end),null);
			List<SNS> snssRownum = ss.getMapper(SNSMapper.class).getShowSNS(in);
			
			
			for (SNS sns : snssRownum) {
				sns.setSnscs(ss.getMapper(SNSCommentMapper.class).getAllSNSComment(sns));
				
			}
			
			return new SNSs(snssRownum);
			
			
		}
		return null;
		
		// int start = pageNo;
		// if (pageNo != 1) {
		// start = (pageNo-1)*((int)count+1);
		// if (pageNo !=2) {
		// start = start-(pageNo-2);
		// }
		// }
		// int end = start+((int)count-1);
		
	}

	public void seachSNSSession(HttpServletRequest req, HttpServletResponse res) {
		if (req.getSession().getAttribute("what") != null) {
			String what = (String) req.getSession().getAttribute("what");
			String st_content = (String) req.getSession().getAttribute("st_content");
			SNS sns = new SNS();
			List<SNS> snssSearch = new ArrayList<SNS>();
			if (what.equals("st_id")) {
				sns.setSt_id(st_content);
				snssSearch = ss.getMapper(SNSMapper.class).getSeachSNSId(sns);
			} else {
				sns.setSt_txt(st_content);
				snssSearch = ss.getMapper(SNSMapper.class).getSeachSNSTxt(sns);
			}
			req.getSession().setAttribute("snssSearch", snssSearch);
			req.getSession().setMaxInactiveInterval(2 * 60);

		}
	}

	public void seachSNS(HttpServletRequest req, HttpServletResponse res) {
		String what = req.getParameter("what");
		String st_content = req.getParameter("st_content");
		req.getSession().setAttribute("what", what);
		req.getSession().setAttribute("st_content", st_content);
		req.getSession().setMaxInactiveInterval(2 * 60);
		SNS sns = new SNS();
		List<SNS> snssSearch = new ArrayList<SNS>();
		if (what.equals("st_id")) {
			sns.setSt_id(st_content);
			snssSearch = ss.getMapper(SNSMapper.class).getSeachSNSId(sns);
		} else {
			sns.setSt_txt(st_content);
			snssSearch = ss.getMapper(SNSMapper.class).getSeachSNSTxt(sns);
		}
		req.getSession().setAttribute("snssSearch", snssSearch);
		req.getSession().setMaxInactiveInterval(2 * 60);
	}

	public void seachSNSClean(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("snssSearch", null);
		req.getSession().setAttribute("what", null);
		req.getSession().setAttribute("st_content", null);
	}

	// public void getAllSNS(HttpServletRequest req,HttpServletResponse res) {
	// snss = ss.getMapper(SNSMapper.class).getAllSNS();
	//
	// int no=0;
	// snssMap = new HashMap<Integer, Integer>();
	// for (SNS s : snss) {
	// snssMap.put(s.getSt_no().intValue(), no);
	// no++;
	// }
	//
	// }
	//
	public void getAllSNSCount(HttpServletRequest req, HttpServletResponse res) {
		snsCount = ss.getMapper(SNSMapper.class).getAllSNSCount();

	}
	// public void getShowSNS(int x,HttpServletRequest req,HttpServletResponse
	// res) {
	//
	// Inquiry in = new Inquiry( new BigDecimal(x) , new BigDecimal(x+4));
	//
	// snss = ss.getMapper(SNSMapper.class).getShowSNS(in);
	// req.setAttribute("curPage", x);
	// req.setAttribute("snss", snss);
	//
	// }

	public void sessionSMSPageNo2(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("SNSPaging", (Integer) req.getSession().getAttribute("SNSPaging") - 1);
	}

	public void sessionSMSPageNo(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("SNSPaging", Integer.parseInt(req.getParameter("pageNo")));
	}

	public void homeSMSPageNo(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("SNSPaging", 1);
	}

	public void detailSMSTxt(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("st_txt", req.getParameter("st_txt").replace("<br>", "\r\n"));

	}

	public void updateSMS(HttpServletRequest req, HttpServletResponse res) {
		String path = null;
		MultipartRequest mr = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/photo");
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "파일이 너무 크다");
			return;
		}
		try {

			int st_no = Integer.parseInt(mr.getParameter("st_no"));
			String st_txt = mr.getParameter("st_txt");
			st_txt = st_txt.replace("\r\n", "<br>");

			String st_photo = mr.getFilesystemName("st_photo");
			SNS sns = new SNS(new BigDecimal(st_no), null, st_txt, null, null, null, null, null,null);

			if (st_photo != null) {
				st_photo = URLEncoder.encode(st_photo, "utf-8");
				st_photo = st_photo.replace("+", " ");
				sns.setSt_photo(st_photo);
				if (ss.getMapper(SNSMapper.class).updateSNSPhoto(sns) == 1) {
					req.setAttribute("r", "글 수정 성공");

				}
			} else {
				if (ss.getMapper(SNSMapper.class).updateSNS(sns) == 1) {
					req.setAttribute("r", "글 수정 성공");

				}
			}

		} catch (Exception e) {
			req.setAttribute("r", "글 수정 실패");
			e.printStackTrace();
		}

	}

	public void deleteSNS(SNS sns, HttpServletRequest req, HttpServletResponse res) {

		try {
			String path = req.getSession().getServletContext().getRealPath("resources/photo");
			SNS snsf = ss.getMapper(SNSMapper.class).getSNS(sns);
			String sf_photo = snsf.getSt_photo();
			if (ss.getMapper(SNSMapper.class).deleteSNS(sns) == 1) {
				req.setAttribute("r", "글 삭제 성공");
				File f = new File(path + "/" + sf_photo);
				f.delete();
				snsCount--;

			}
		} catch (Exception e) {
			req.setAttribute("r", "글 삭제 실패");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void regSNSComment(SNSComment snsc, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String sc_id = m.getSm_id();
			String sc_img = m.getSm_img();
			String sc_host = InetAddress.getLocalHost().getHostAddress();
			snsc.setSc_id(sc_id);
			System.out.println(sc_id);
			System.out.println(sc_id);
			snsc.setSc_img(sc_img);
			System.out.println(sc_img);
			snsc.setSc_host(sc_host);
			System.out.println(sc_host);
			
			if (ss.getMapper(SNSCommentMapper.class).regSNSComment(snsc) == 1) {
				req.setAttribute("r", "댓글 등록 성공");
				
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글 등록 실패");
			e.printStackTrace();
		}
	}
	public void deleteSNSComment(SNSComment snsc, HttpServletRequest req, HttpServletResponse res) {
		try {
			if (ss.getMapper(SNSCommentMapper.class).deleteSNSComment(snsc) == 1) {
				req.setAttribute("r", "댓글 삭제 성공");
				
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글 삭제 실패");
			e.printStackTrace();
		}
	}
	public void updateSNSComment(SNSComment snsc, HttpServletRequest req, HttpServletResponse res) {
		try {
			if (ss.getMapper(SNSCommentMapper.class).updateSNSComment(snsc) == 1) {
				
				req.setAttribute("r", "댓글 수정 성공");
				
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글 수정 실패");
			e.printStackTrace();
		}
	}

}
