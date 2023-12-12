package com.shoekream.faq.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.faq.dao.FaqDao;
import com.shoekream.faq.vo.FaqVo;
import com.shoekream.page.vo.PageVo;

public class FaqService {
	
	//게시글 전체 목록 조회
	public List<FaqVo> FaqList(PageVo pvo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		List<FaqVo> faqVoList = dao.FaqList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return faqVoList;
	}

	//게시글 전체 갯수 조회
	public int selectFaqCount() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		int listCount = dao.selectFaqCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//게시글 검색 갯수 조회
	public int selectSearchFaqCount(String title) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		int listCount = dao.selectSearchFaqCount(conn, title);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	//게시글 상세 조회
	public FaqVo selectFaqListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		FaqVo vo = dao.selectFaqByNo(conn, no);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시글 검색
	public List<FaqVo> faqSearch(String title, PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		List<FaqVo> faqVoList = dao.faqSearch(conn, title, pvo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return faqVoList;
	}
	
	//게시글 작성
	public int faqWrite(FaqVo vo) throws Exception{
		
		//conn 
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		int result = dao.faqWrite(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시글 삭제
	public int faqDelete(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		int result = dao.faqDelete(conn, no);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//no로 DB받아오기
	public FaqVo getFaqByNo(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		FaqVo vo = dao.getFaqByNo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시글 수정
	public int faqEdit(FaqVo vo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		FaqDao dao = new FaqDao();
		int result = dao.faqEdit(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
