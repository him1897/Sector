package emp.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import emp.model.vo.Emp;
import suser.model.vo.Suser;

public class EmpDao {

	
	//사원 전체 목록 리턴 
public ArrayList<Emp> selectAll(Connection conn){
		
		ArrayList<Emp> list = new ArrayList<Emp>();
	      Statement stmt = null;
	      ResultSet rset = null;
	      Suser suser = new Suser();
	      
	      String query ="select * from emp join suser using(user_id) where user_com_no = master_com_no";
	      try {
	          stmt = conn.createStatement();
	          rset = stmt.executeQuery(query);
	          
	          while(rset.next()) {
	             
	             Emp emp = new Emp();
	             
	             emp.setEmpId(rset.getInt("EMP_ID"));
	             emp.setEmpName(rset.getString("EMP_NAME"));
	             emp.setDeptId(rset.getString("DEPT_ID"));
	             emp.setJobId(rset.getString("JOB_ID"));
	             emp.setEmpPhone(rset.getString("EMP_PHONE"));
	             emp.setEmpEmail(rset.getString("EMP_EMAIL"));
	             emp.setEmpAddress(rset.getString("EMP_ADDRESS"));
	             emp.setIdent(rset.getString("IDENT"));
	             
	             list.add(emp);
	          }
	             
	       } catch (Exception e) {
	          e.printStackTrace();
	       }finally {
	          close(rset);
	          close(stmt);
	       }
	    
	       return list;
	}
	
	
	//사원 한명 리턴 
	public Emp selectOne(Connection conn, int empId) {
		Emp emp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * " +
				"from emp " +
				"join suser using(user_id) " +
				"where emp_id = ? ";
			
		try {
			pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, empId);
	        
			rset = pstmt.executeQuery();	
			
			if(rset.next()) {
			emp = new Emp();
			
			emp.setEmpId(empId);
	        emp.setEmpName(rset.getString("EMP_NAME"));
	        emp.setUserId(rset.getString("USER_ID"));
	        emp.setDeptId(rset.getString("DEPT_ID"));
	        emp.setJobId(rset.getString("JOB_ID"));
	        emp.setEmpPhone(rset.getString("EMP_PHONE"));
	        emp.setEmpEmail(rset.getString("EMP_EMAIL"));
	        emp.setEmpNo(rset.getString("EMP_NO"));
	        emp.setEmpAddress(rset.getString("EMP_ADDRESS"));
	        emp.setSalary(rset.getInt("SALARY"));
	        emp.setBonusPct(rset.getDouble("BONUS_PCT"));
	        emp.setHireDate(rset.getDate("HIRE_DATE"));
	        emp.setVacation(rset.getInt("VACATION"));
	        emp.setMarriage(rset.getString("MARRIAGE"));
	        emp.setIdent(rset.getString("IDENT"));
	         
			}
	        
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return emp;
	}
	
	
	
	//사원 검색 
	public ArrayList<Emp> searchEmp(Connection conn, int no){
		
		
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		//swithc문 
		//1. 이름으로 검색 
		
		//2. 부서별 검색 
				
		//3. 직급별 검색 
				
		
		
		return list;
		
		
		
	}
	
	
	
	//직원 인증 및 인증 취소 
	public int changeStatus(Connection conn, String userId, int no) {
		
		//int no = 0, 1  0 이면 취소 1이면 인증 
		
		int result = 0;
		
	
		
		return result;
	}
	
	
	//직원 정렬 기능 (이름, 부서, 직급, 봉급)
	public ArrayList<Emp> orderBy(Connection conn, String orderType, String keyword){
		
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		// ? 에 orderType, keyword가 들어간다 
		// order by salary(?) desc
		 
		
		
		return list;
		
		
	}
	
	
	
	
	//직원 수정 (일반사원용 : 이메일, 전화번호, 주소 , 비밀번호) 
	public int updateByEmp(Connection conn, Emp emp) {
		int result = 0;
		
		
		
		return result;
	}
	
	
	
	
	//여기서부터 인사 관리 기능 
	
	
	//직원 수정 (마스터용 : 직급, 연봉, 보너스 , 부서) 
	public int updateByMaster(Connection conn, Emp emp) {
		int result = 0;
		
		
		return result;
	}
	
	//연차 감소 
	public int useVacaction(Connection conn, String user_id, int day) {
		int result = 0;
		
		
		
		/* update set emp vacation = (select vacation from emp where user_id = ?) - ?
				 where user_id = ?*/

		return result;
	}


	public int insertEmp(Connection conn, Emp emp) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO EMP VALUES(EMP_ID_SEQ.nextval, ?, ?, 'HR', 'F', ?, ?, ?, ?,"
				+ "0, 0, SYSDATE, 0, 'N',?)";
				/*INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) 
				VALUES (1562,'홍길동','SALESMAN',7698,SYSDATE,2000,1000,30);*/
		try {
			pstmt = conn.prepareStatement(query);
			
			//pstmt.setInt(1, emp.getEmpId()); //1. 사번 시퀀스
			pstmt.setString(1, emp.getEmpName()); //2. 이름
			pstmt.setString(2, emp.getUserId()); //3. 아이디
			//pstmt.setString(4, emp.getDeptId()); //4. 부서코드
			//pstmt.setString(5, emp.getJobId()); //5. 직급코드
			pstmt.setString(3, emp.getEmpPhone()); //6. 전화번호
			pstmt.setString(4, emp.getEmpEmail()); //7. 이메일
			pstmt.setString(5, emp.getEmpNo()); //8. 주민번호
			pstmt.setString(6, emp.getEmpAddress()); //9. 주소
			//pstmt.setInt(10, emp.getSalary()); //11. 월급
			//pstmt.setDouble(11, emp.getBonusPct()); //12. 보너스
			//pstmt.setDate(12, emp.getHireDate()); //13. 입사일
			//pstmt.setInt(13, emp.getVacation()); //14. 잔여연차
			//pstmt.setString(14, emp.getMarriage()); //15. 결혼유무
			pstmt.setInt(7, emp.getMasterComNo()); //15. 마스터유무
			
			result = pstmt.executeUpdate();
			
			System.out.println("Dao emp" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/*public Emp selectOne(Connection conn, int empNo) {
		// 사원 한명 정보 출력
		int result = 0;
		
		return Emp;
	}*/

	public int insertSuser(Connection conn, Suser suser) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO SUSER VALUES(?, ?, ?, default, ?, default, default)";
		System.out.println("나다" + suser.getUserComNo());
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, suser.getUserId());
			pstmt.setString(2, suser.getUserPwd());
			pstmt.setString(3, suser.getUserName());
			//pstmt.setString(4, suser.getIdent()); 인증여부
			pstmt.setInt(4, suser.getUserComNo());
			//pstmt.setString(6, suser.getUserSign());
			//pstmt.setString(7, suser.getUserMaster());
			
			result = pstmt.executeUpdate();
			
			System.out.println("Dao suser" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int updateEmp(Connection conn, Emp emp) {
		// 마스터권한 사원 수정
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update emp set EMP_NAME = ?, USER_ID = ?, DEPT_ID = ?, JOB_ID = ?, EMP_PHONE = ?,"
				+ "EMP_EMAIL = ?, EMP_NO = ?, EMP_ADDRESS = ?, SALARY = ?, BONUS_PCT = ?,"
				/*+ "HIRE_DATE = ?,"*/
				+ " VACATION = ?, MARRIAGE = ? where emp_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getUserId());
			pstmt.setString(3, emp.getDeptId());
			pstmt.setString(4, emp.getJobId());
			pstmt.setString(5, emp.getEmpPhone());
			pstmt.setString(6, emp.getEmpEmail());
			pstmt.setString(7, emp.getEmpNo());
			pstmt.setString(8, emp.getEmpAddress());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setDouble(10, emp.getBonusPct());
			/*pstmt.setString(11, emp.getHireDate());*/
			pstmt.setInt(11, emp.getVacation());
			pstmt.setString(12, emp.getMarriage());
			pstmt.setInt(13, emp.getEmpId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int updateSuser(Connection conn, Suser suser) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update suser set IDENT = ? where user_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, suser.getIdent());
			pstmt.setString(2, suser.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result;
	}


	
	
	
	
	
	
	
	
}
