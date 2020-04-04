package line.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.vo.Dept;
import emp.model.vo.Emp;
import line.model.dao.LineDao;
import line.model.vo.Line;


public class LineService {

	private LineDao ldao = new LineDao();
	
	
	public Line selectOne(int lineNo) {
		
		Connection conn = getConnection();
		Line line = ldao.selectOne(conn, lineNo);
		
		return line;
		
	}
	
	public ArrayList<Line> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Line>list = ldao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertLine(Line line) {
		
		Connection conn = getConnection();
		int result = ldao.insertLine(conn, line);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int deleteLine(int lineNo) {
		
		Connection conn = getConnection();
		int result = ldao.deleteLine(conn, lineNo);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	

	public int updateLine(Line line) {
		
		Connection conn = getConnection();
		int result = ldao.updateLine(conn, line);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public String lineAnswer(int docId, int number) {
		
		Connection conn = getConnection();
		String answer = ldao.lineAnswer(conn, docId, number);
		
		return answer;
	}

	public int updateAnswer(int answerNo, int lineNo) {

		Connection conn = getConnection();
		int result = ldao.updateAnswer(conn, answerNo, lineNo);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}

	public int rejectAnswer(int answerNo, int lineNo) {
		Connection conn = getConnection();
		int result = ldao.rejectAnswer(conn, answerNo, lineNo);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	

	
}
