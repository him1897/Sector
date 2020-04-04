package qna.model.service;

import qna.model.dao.QnaDao;
import qna.model.vo.Qna;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;



public class QnaService {

	private QnaDao qdao;
	
	public Qna selectOne(int qnaId) {
		
		Connection conn = getConnection();
		Qna qna = qdao.selectOne(conn, qnaId);
		
		return qna;
		
	}
	
	public ArrayList<Qna> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Qna>list = qdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertQna(Qna qna) {
		
		Connection conn = getConnection();
		int result = qdao.insertQna(conn, qna);
		
		return result;
	}
	
	public int deleteQna(int qnaId) {
		
		Connection conn = getConnection();
		int result = qdao.deleteQna(conn, qnaId);
		
		return result;
	}
	
	public int updateQna(int qnaId) {
		
		Connection conn = getConnection();
		int result = qdao.updateQna(conn, qnaId);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
