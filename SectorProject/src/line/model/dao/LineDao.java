package line.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import emp.model.vo.Emp;
import line.model.vo.Line;

import static common.JDBCTemplate.*;

public class LineDao {

	public Line selectOne(Connection conn, int lineNo) {

		Line line = new Line();
		
		
		PreparedStatement pstmt = null;
		String query = "select * from line where line_no = ?";
		ResultSet rset = null;
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, lineNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				line.setLineNo(lineNo);
				line.setLineName(rset.getString("line_name"));
				line.setFirst(String.valueOf(rset.getInt("first")));
				line.setSecond(String.valueOf(rset.getInt("second")));
				line.setThird(String.valueOf(rset.getInt("third")));
				line.setFourth(String.valueOf(rset.getInt("fourth")));
				line.setFifth(String.valueOf(rset.getInt("fifth")));
				line.setSixth(String.valueOf(rset.getInt("sixth")));
				line.setSeventh(String.valueOf(rset.getInt("seventh")));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		
		return line;
	}

	public ArrayList<Line> selectAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public int insertLine(Connection conn, Line line) {
		
		int result = 0;
		
		
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO LINE VALUES (LINE_SEQ.NEXTVAL,'이름없음', ?, ?, ?, ?, ?, ?, ?, 'N', 'N', 'N', 'N', 'N', 'N', 'N')";
		
		
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, line.getFirst());
		pstmt.setString(2, line.getSecond());
		pstmt.setString(3, line.getThird());
		pstmt.setString(4, line.getFourth());
		pstmt.setString(5, line.getFifth());
		pstmt.setString(6, line.getSixth());
		pstmt.setString(7, line.getSeventh());
			
		result = pstmt.executeUpdate();	
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	
		return result; 
	}

	public int deleteLine(Connection conn, int lineNo) {
		
		int result = 0;
		
		
		PreparedStatement pstmt = null;
		
		String query = "DELETE LINE WHERE LINE_NO = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, lineNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public int updateLine(Connection conn, Line line) {
		int result = 0;
		
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE LINE SET "
				+ "FIRST=?, SECOND=?, THIRD=?, FOURTH=?, FIFTH=?, SIXTH=?, SEVENTH=?, ANSWER1='N', ANSWER2='N', ANSWER3='N', "
				+ " ANSWER4='N', ANSWER5='N', ANSWER6='N', ANSWER7='N'"
				+ " WHERE LINE_NO = ?";
		
		
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, line.getFirst());
		pstmt.setString(2, line.getSecond());
		pstmt.setString(3, line.getThird());
		pstmt.setString(4, line.getFourth());
		pstmt.setString(5, line.getFifth());
		pstmt.setString(6, line.getSixth());
		pstmt.setString(7, line.getSeventh());
		
		pstmt.setInt(8, line.getLineNo());
		
			
		result = pstmt.executeUpdate();	
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result; 
	}

	public String lineAnswer(Connection conn, int docId, int number) {
		
		String answer = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		
		switch(number) {
		
		case 1 : query = "SELECT ANSWER1 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		case 2 : query = "SELECT ANSWER2 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		case 3 : query = "SELECT ANSWER3 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		case 4 : query = "SELECT ANSWER4 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		case 5 : query = "SELECT ANSWER5 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break; 
		case 6 : query = "SELECT ANSWER6 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		case 7 : query = "SELECT ANSWER7 AS ANSWER FROM LINE WHERE LINE_NO = ?"; break;
		
		
		}
		
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, docId);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			
			answer = rset.getString("answer");
			
		}
		
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		if(answer == null) {
			answer = "";
		}
		
		return answer;
	}

	public int updateAnswer(Connection conn, int answerNo, int lineNo) {
		
		int result = 0;
		
		
		PreparedStatement pstmt = null;
		
		String query = null;
		
		
		
		switch(answerNo) {
		
		case 1: query = "UPDATE LINE SET ANSWER1 ='Y' WHERE LINE_NO = ?"; break;
		case 2: query = "UPDATE LINE SET ANSWER2 ='Y' WHERE LINE_NO = ?"; break;
		case 3: query = "UPDATE LINE SET ANSWER3 ='Y' WHERE LINE_NO = ?"; break;
		case 4: query = "UPDATE LINE SET ANSWER4 ='Y' WHERE LINE_NO = ?"; break;
		case 5: query = "UPDATE LINE SET ANSWER5 ='Y' WHERE LINE_NO = ?"; break;
		case 6: query = "UPDATE LINE SET ANSWER6 ='Y' WHERE LINE_NO = ?"; break;
		case 7: query = "UPDATE LINE SET ANSWER7 ='Y' WHERE LINE_NO = ?"; break;
		
		
		
		}
		
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, lineNo);
		
		result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result; 
		
	}

	public int rejectAnswer(Connection conn, int answerNo, int lineNo) {
			int result = 0;
		
			System.out.println("lineNo : " + lineNo);
			
		PreparedStatement pstmt = null;
		
		String query = null;
		
		
		
		switch(answerNo) {
		
		case 1: query = "UPDATE LINE SET ANSWER1 ='R' WHERE LINE_NO = ?"; break;
		case 2: query = "UPDATE LINE SET ANSWER2 ='R' WHERE LINE_NO = ?"; break;
		case 4: query = "UPDATE LINE SET ANSWER4 ='R' WHERE LINE_NO = ?"; break;
		case 5: query = "UPDATE LINE SET ANSWER5 ='R' WHERE LINE_NO = ?"; break;
		case 6: query = "UPDATE LINE SET ANSWER6 ='R' WHERE LINE_NO = ?"; break;
		case 7: query = "UPDATE LINE SET ANSWER7 ='R' WHERE LINE_NO = ?"; break;
		
		
		
		}
		
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, lineNo);
		
		result = pstmt.executeUpdate();
		

		System.out.println("result : " + result);	
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
