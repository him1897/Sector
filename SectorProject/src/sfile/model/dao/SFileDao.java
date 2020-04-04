package sfile.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sfile.model.vo.Sfile;

import static common.JDBCTemplate.*;


public class SFileDao {

	public Sfile selectOne(Connection conn, int fileId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Sfile> selectAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertSfile(Connection conn, Sfile sfile) {
		
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query="insert into sfile (originalFileName, renameFileName, doc_id, mail_id, post_id) values (?, ? , ?, ? ,?) ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
		
			
			pstmt.setString(1, sfile.getOriginalFileName());
			pstmt.setString(2, sfile.getRenameFileName());
			pstmt.setString(3, sfile.getDocId());
			pstmt.setString(4, sfile.getMailId());
			pstmt.setString(5, sfile.getPostId());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result; 
	}

	public int deleteSfile(Connection conn, int fileId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSfile(Connection conn, int fileId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Sfile selectOneByDoc(Connection conn, int docId) {
		
		
		Sfile sfile = new Sfile();
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from sfile where doc_id = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sfile.setDocId(String.valueOf(rset.getInt("doc_id")));
				sfile.setOriginalFileName(rset.getString("originalfilename"));
				sfile.setRenameFileName(rset.getString("renamefilename"));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return sfile;
		
	}

}
