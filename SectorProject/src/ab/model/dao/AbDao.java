package ab.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ab.model.vo.Ab;
import emp.model.vo.Emp;

public class AbDao {

	/*public ArrayList<Ab> selectAll(Connection conn) {
		
		ArrayList<Ab> list = new ArrayList<Ab>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from ab";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Ab ab = new Ab();

				ab.setAbName(rset.getString("AB_NAME"));
				ab.setAbPhone(rset.getString("AB_PHONE"));
				ab.setAbCom(rset.getString("AB_COM"));
				ab.setAbJobName(rset.getString("AB_JOB_NAME"));
				ab.setAbEmail(rset.getString("AB_EMAIL"));
				ab.setAbAddress(rset.getString("AB_ADDRESS"));
				ab.setAbAnniDate(rset.getDate("AB_ANNIDATE"));
				ab.setAbAnniName(rset.getString("AB_ANNINAME"));
				ab.setAbGroup(rset.getString("AB_GROUP"));
				
				
				list.add(ab);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}*/

	public ArrayList<Emp> selectAllEmp(Connection conn, String empsort) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sort = null;
		
		if(empsort.equals("이름")) {
			sort = "emp_name";
		}else {
			sort = "dept_name";
		}
		
		
		String query = "select (rank() over(order by "
						+ sort
						+ ")) as rank, emp_name, emp_phone, dept_name, job_name, emp_email, emp_address "
						+ "from emp e join dept d on e.dept_id = d.dept_id join sjob j on e.job_id = j.job_id";
		
		if(empsort.equals("이름")) {
			query += " order by emp_name asc";
		}else {
			query += " order by dept_name asc";
		}
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			while(rset.next()) {
				Emp emp = new Emp();
				
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpPhone(phone(rset.getString("EMP_PHONE")));
				emp.setDeptId(rset.getString("DEPT_NAME"));
				emp.setJobId(rset.getString("JOB_NAME"));
				emp.setEmpEmail(rset.getString("EMP_EMAIL"));
				emp.setEmpAddress(rset.getString("EMP_ADDRESS"));
				emp.setRowNum(rset.getInt("RANK"));
				list.add(emp);
						
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}
		
	public int insertAb(Connection conn, Ab ab) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = "insert into ab values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, ab.getAbCom());
			pstmt.setString(2, ab.getAbPhone());
			pstmt.setString(3, ab.getAbName());
			pstmt.setString(4, ab.getAbJobName());
			pstmt.setString(5, ab.getAbEmail());
			pstmt.setString(6, ab.getAbAddress());
			pstmt.setDate(7, ab.getAbAnniDate());
			pstmt.setString(8, ab.getAbAnniName());
			pstmt.setString(9, ab.getAbGroup());
			pstmt.setInt(10, ab.getAbEmpId());
			pstmt.setInt(11, ab.getAbWriterCom());
			pstmt.setString(12, ab.getAbDeptId());
			
			
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	public ArrayList<Ab> selectAllShareList(Connection conn, String sharesort, String empId, int userComNo, String deptId) {
		ArrayList<Ab> list = new ArrayList<Ab>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sort = null;
		if(sharesort.equals("이름")) {
			sort = "ab_name";
		}else {
			sort = "ab_com";
		}
		
		
		String query = "select (rank() over(order by "
						+ sort
						+ ")) as rank, rownum, a.* "
						+ "from ab a "
						+ "where ab_group='share' and ab_user_com_no= ? and dept_id= ? "
						+ "order by "
						+ sort
						+ " asc";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, userComNo);
			pstmt.setString(2, deptId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Ab ab = new Ab();
				
				ab.setAbCom(rset.getString("AB_COM"));
				ab.setAbName(rset.getString("AB_NAME"));
				ab.setAbPhone(phone(rset.getString("AB_PHONE")));
				ab.setAbJobName(rset.getString("AB_JOB_NAME"));
				ab.setAbEmail(rset.getString("AB_EMAIL"));
				ab.setAbAddress(rset.getString("AB_ADDRESS"));
				ab.setAbRowNum(rset.getInt("RANK"));
				list.add(ab);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}

	public ArrayList<Ab> selectAllPersonalList(Connection conn, String personalsort, String userId) {
		ArrayList<Ab> list = new ArrayList<Ab>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sort = null;
		
		if(personalsort.equals("이름")) {
			sort = "ab_name";
		}else {
			sort = "ab_com";
		}
		String query = "select (rank() over(order by "
						+ sort
						+ ")) as rank, rownum, a.* "
						+ "from ab a "
						+ "where (ab_group='share' or ab_group='personal') and emp_id=(select emp_id from emp where user_id = ?) order by "
						+ sort
						+ " asc";
		
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Ab ab = new Ab();
				
				ab.setAbCom(rset.getString("AB_COM"));
				ab.setAbName(rset.getString("AB_NAME"));
				ab.setAbPhone(phone(rset.getString("AB_PHONE")));
				ab.setAbJobName(rset.getString("AB_JOB_NAME"));
				ab.setAbEmail(rset.getString("AB_EMAIL"));
				ab.setAbAddress(rset.getString("AB_ADDRESS"));
				ab.setAbRowNum(rset.getInt("rank"));
				
				list.add(ab);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}

	public ArrayList<Emp> searchEmp(Connection conn, String searchval, String searchkeyword) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select emp_name, emp_phone, dept_name, job_name, emp_email, emp_address "
				+ "from emp e join dept d on e.dept_id = d.dept_id join sjob j on e.job_id = j.job_id";
		if(searchval.equals("이름")) {
			query +=" where emp_name like '%" + searchkeyword + "%'";
		}else {
			query +=" where dept_name like '%" + searchkeyword + "%'";
		}
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Emp emp = new Emp();
				
				emp.setDeptId(rset.getString("DEPT_NAME"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpPhone(phone(rset.getString("EMP_PHONE")));
				emp.setJobId(rset.getString("JOB_NAME"));
				emp.setEmpEmail(rset.getString("EMP_EMAIL"));
				emp.setEmpAddress(rset.getString("EMP_ADDRESS"));
				list.add(emp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
		
	}

	public ArrayList<Ab> searchAb(Connection conn, String searchval, String searchkeyword) {
		ArrayList<Ab> list = new ArrayList<Ab>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select AB_COM, Ab_PHONE, AB_NAME, AB_JOB_NAME, AB_EMAIL, AB_ADDRESS from AB";
		if(searchval.equals("이름")) {
			query +=" where AB_NAME like '%" + searchkeyword+"%'";
		}else {
			query +=" where AB_COM like '%" + searchkeyword+"%'";
		}
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Ab ab = new Ab();
				
				ab.setAbCom(rset.getString("AB_COM"));
				ab.setAbName(rset.getString("AB_NAME"));
				ab.setAbPhone(phone(rset.getString("AB_PHONE")));
				ab.setAbJobName(rset.getString("AB_JOB_NAME"));
				ab.setAbEmail(rset.getString("Ab_EMAIL"));
				ab.setAbAddress(rset.getString("Ab_ADDRESS"));
				list.add(ab);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	


	
	public int toDeleteAb(Connection conn, String num) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update ab set ab_group = 'delete' where ab_phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int updateAb(Connection conn, Ab ab) {


		int result = 0;
		
		
		return result;
	}
	
	public static String phone(String src) {
	    if (src == null) {
	      return "";
	    }else if (src.length() == 8) {
	      return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
	    }else if (src.length() == 12) {
	      return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
	    }
	    return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	  }

	public ArrayList<Ab> selectAllDeleteList(Connection conn, String personalsort, String userId) {
		ArrayList<Ab> list = new ArrayList<Ab>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sort = null;
		
		if(personalsort.equals("이름")) {
			sort = "ab_name";
		}else {
			sort = "ab_com";
		}
		
		String query = "select (rank() over(order by "
				+ sort
				+ ")) as rank, rownum, a.* "
				+ "from ab a "
				+ "where ab_group='delete' and emp_id=(select emp_id from emp where user_id = ?) order by "
				+ sort
				+ " asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Ab ab = new Ab();
				
				ab.setAbCom(rset.getString("AB_COM"));
				ab.setAbName(rset.getString("AB_NAME"));
				ab.setAbPhone(phone(rset.getString("AB_PHONE")));
				ab.setAbJobName(rset.getString("AB_JOB_NAME"));
				ab.setAbEmail(rset.getString("AB_EMAIL"));
				ab.setAbAddress(rset.getString("AB_ADDRESS"));
				ab.setAbRowNum(rset.getInt("rank"));
				
				list.add(ab);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int shareToPersonal(Connection conn, String num) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update ab set ab_group = 'personal' where ab_phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int deleteAb(Connection conn, String num) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete ab where ab_phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int personalToShare(Connection conn, String num) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update ab set ab_group = 'share' where ab_phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public Emp empInfo(Connection conn, String userId, int userComNo) {
		Emp emp = new Emp();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from emp where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			
			emp.setDeptId(rset.getString("DEPT_ID"));
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return emp;
	}

	public int deleteToPersonalAb(Connection conn, String num) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update ab set ab_group = 'personal' where ab_phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	


}
