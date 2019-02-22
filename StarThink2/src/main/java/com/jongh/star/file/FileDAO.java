package com.jongh.star.file;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
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
public class FileDAO {
	
	@Autowired
	private SqlSession ss;
	
	private List<File> files;
	private HashMap<Integer, Integer> filesMap;
	
	public void regFile(HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest mr = null;
		String path = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/file");
			mr = new MultipartRequest(req, path, 1024*1024*1024,"utf-8",new DefaultFileRenamePolicy() );
		} catch (Exception e) {
			req.setAttribute("r", "파일 크기가 너무 크다");
			return;
		}
		String sf_file = mr.getFilesystemName("sf_file");
		
		try {
			sf_file = URLEncoder.encode(sf_file, "utf-8");
			sf_file = sf_file.replace("+", " ");
			Member m = (Member) req.getSession().getAttribute("loginMember"); 
			String sf_id = m.getSm_id();
			String sf_img = m.getSm_img();
			
			String sf_title = mr.getParameter("sf_title");
			String sf_color = mr.getParameter("sf_color");
			File file = new File(null, sf_id, sf_img, sf_title, sf_file, sf_color, null);
			if (ss.getMapper(FileMapper.class).regFile(file)==1) {
				req.setAttribute("r", "파일 등록 성공");
				File file2 = ss.getMapper(FileMapper.class).getFile();
				files.add(file2);
				filesMap.put(file2.getSf_no().intValue(),filesMap.size());
			}
			
		} catch (Exception e) {
			req.setAttribute("r", "파일 등록 실패");
			java.io.File f = new java.io.File(path+"/"+sf_file);
			f.delete();
			e.printStackTrace();
		}
	}
	public void updateFile(HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest mr = null;
		String path = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/file");
			mr = new MultipartRequest(req, path, 1024*1024*1024,"utf-8",new DefaultFileRenamePolicy() );
		} catch (Exception e) {
			req.setAttribute("r", "파일 크기가 너무 크다");
			return;
		}
		String sf_file = mr.getFilesystemName("sf_file");
		
		try {
			String sf_title = mr.getParameter("sf_title");
			int sf_no = Integer.parseInt(mr.getParameter("sf_no"));
			
			if (sf_file != null) {
				sf_file = URLEncoder.encode(sf_file, "utf-8");
				sf_file = sf_file.replace("+", " ");			
			}
			
			File file = new File(new BigDecimal(sf_no), null, null, sf_title, sf_file, null, null);
			File file2 = ss.getMapper(FileMapper.class).getFileNo(file);
			
			if (sf_file == null) {
				if (ss.getMapper(FileMapper.class).updateFile(file)==1) {
					req.setAttribute("r", "파일 수정 성공");
					
				}
			}else {
				if (ss.getMapper(FileMapper.class).updateFileFile(file)==1) {
					req.setAttribute("r", "파일 수정 성공");
					String fileName = URLDecoder.decode(file2.getSf_file(), "uft-8");
					java.io.File f = new java.io.File(path+"/"+fileName);
					f.delete();
				}
			}
			
			int no = filesMap.get(sf_no);
			files.set(no, ss.getMapper(FileMapper.class).getFileNo(file));
			
			
			
		} catch (Exception e) {
			req.setAttribute("r", "파일 수정 실패");
			java.io.File f = new java.io.File(path+"/"+sf_file);
			f.delete();
			e.printStackTrace();
		}
	}
	
	public void getAllFile() {
		files = ss.getMapper(FileMapper.class).getAllFile();
		filesMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < files.size(); i++) {
			filesMap.put(files.get(i).getSf_no().intValue(), i);
		}
	}
	public void deleteFile(File file,HttpServletRequest req, HttpServletResponse res) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/file");
			File file2 = ss.getMapper(FileMapper.class).getFileNo(file);
			if (ss.getMapper(FileMapper.class).deleteFile(file)==1) {
				req.setAttribute("r", "파일 삭제 성공");
				int no = filesMap.get(file2.getSf_no().intValue());
				files.remove(no);
				File file3 = null;
				for (int i = no; i < files.size(); i++) {
					file3 = files.get(i);
					filesMap.put(file3.getSf_no().intValue(), i);
				}
				String sf_file = URLDecoder.decode(file2.getSf_file(),"utf-8");
				java.io.File f = new java.io.File(path+"/"+sf_file);
				f.delete();
			}
		} catch (Exception e) {
			req.setAttribute("r", "파일 삭제 실패");
			e.printStackTrace();
		}
	}
	public void detailFile(File file,HttpServletRequest req, HttpServletResponse res) {
		
		File file2 = ss.getMapper(FileMapper.class).getFileNo(file);
		req.setAttribute("updateFileTitle", file2.getSf_title());
	}
	
	public void pagingFile(HttpServletRequest req, HttpServletResponse res) {
		List<File> searchFile = (List<File>) req.getSession().getAttribute("searchFile");
		List<File> files2 = files;
		
		if (searchFile !=null) {
			files2 = searchFile;
		}
		
		if (files2 != null && files2.size() >0) {
			req.setAttribute("files", files2);
		}
	}
	
	public void searchFileClean(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("searchFile", null);
	}
	
	public void getSearchFile(File file,HttpServletRequest req, HttpServletResponse res) {
		file.setSf_color("#"+file.getSf_color());
		req.getSession().setAttribute("searchFile", ss.getMapper(FileMapper.class).getSearchFile(file));
	}
}
