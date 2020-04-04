package comm.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import comm.model.dao.CommDao;
import comm.model.vo.Comm;
import qna.model.vo.Qna;

public class CommService {

	private CommDao cdao;
	
	public Comm selectOne(int commId) {
		
		Connection conn = getConnection();
		Comm comm = cdao.selectOne(conn, commId);
		
		return comm;
		
	}
	
	public ArrayList<Comm> selectAll(int postId){
		
		Connection conn = getConnection();
		ArrayList<Comm>list = cdao.selectAll(conn, postId);
		
		return list;
		
	}
	
	public int insertComm(Comm comm) {
		
		Connection conn = getConnection();
		int result = cdao.insertComm(conn, comm);
		
		return result;
	}
	
	public int deleteComm(int commId) {
		
		Connection conn = getConnection();
		int result = cdao.deleteComm(conn, commId);
		
		return result;
	}
	
	public int updateComm(int commId) {
	
		Connection conn = getConnection();
		int result = cdao.deleteComm(conn, commId);
		
		return result;
	}
}
