package suser.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import emp.model.vo.Emp;
import suser.model.vo.Suser;

public class SuserDao {
	
	//�α��� ����
	public Suser loginCheck(Connection conn, String userId, String userPwd) {
		Emp emp = new Emp();
		Suser suser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT *  " + 
				"FROM SUSER " + 
				"JOIN EMP  " + 
				"ON SUSER.USER_ID = EMP.USER_ID " + 
				"WHERE SUSER.USER_ID =  ? AND SUSER.USER_PWD =  ? ";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();

			
			if(rset.next()) {
				suser = new Suser();
				
				suser.setUserId(userId);
				suser.setUserName(rset.getString("USER_NAME"));
				suser.setUserPwd(userPwd);
				suser.setUserComNo(rset.getInt("USER_COM_NO"));
				suser.setUserMaster(rset.getString("USER_MASTER"));
				suser.setEmpId(rset.getInt("EMP_ID"));
				suser.setJobId(rset.getString("job_id"));
				suser.setIdent(rset.getString("IDENT"));
				
				System.out.println("아이디 : " + suser.getUserId());
				System.out.println("이름 : " + suser.getUserName());
				System.out.println("비밀번호 : " + suser.getUserPwd());
				System.out.println("회원사번호 : " +suser.getUserComNo());
				System.out.println("마스터유무 : " + suser.getUserMaster());
				System.out.println("사번 : " + suser.getEmpId());
				System.out.println("인증유무 : " + suser.getIdent());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return suser;
	}
	
	//��� ��� ���
	public ArrayList<Emp> selectList(
			Connection conn, int currentPage, int limit) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Emp emp = new Emp();
				Suser suser = new Suser();
				
				emp.setEmpId(Integer.parseInt(rset.getNString("EMP_ID")));
				emp.setEmpName("EMP_NAME");
				emp.setDeptId("DEPT_ID");
				emp.setJobId("JOB_ID");
				emp.setEmpPhone("EMP_PHONE");
				emp.setEmpEmail("EMP_EMAIL");
				emp.setEmpAddress("EMP_ADDRESS");
				suser.setIdent("IDENT");
				
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Boolean IdCheck(Connection conn, String userId) {
		// ȸ������ ���̵� �ߺ�Ȯ��
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		
		try {
			//
			conn.setAutoCommit(false);
			StringBuffer query = new StringBuffer();
			query.append("SELECT USER_ID FROM SUSER");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "userId");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public Suser selectOne(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Suser> selectAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertSuser(Connection conn, Suser suser) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteSuser(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSuser(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Suser IdSearch(Connection conn, String ID, String PWD) {
		// 
		Suser suser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT USER_ID, USER_PWD FROM SUSER WHERE SUSER.USER_ID = ? AND SUSER.USER_PWD = ?";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ID);
			pstmt.setString(2, PWD);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				suser = new Suser();
				
				suser.setUserId(ID);
				suser.setUserPwd(PWD);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return suser;
	}

}
