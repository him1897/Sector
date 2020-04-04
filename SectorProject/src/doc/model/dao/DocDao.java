package doc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import doc.model.vo.Doc;
import emp.model.vo.Emp;

import static common.JDBCTemplate.*;

public class DocDao {
	
	public DocDao() {}

	public Doc selectOne(Connection conn, int docId) {

		Doc doc = new Doc();
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select * from doc where doc_id = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
					
			pstmt.setInt(1, docId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			
				doc.setDocId(docId);
				doc.setDocType(rset.getString("doc_type"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocContent(rset.getString("doc_content"));
				doc.setDocLevel(rset.getString("doc_level"));
				doc.setDocSaveStart(rset.getDate("doc_save_start"));
				doc.setDocSaveEnd(rset.getDate("doc_save_end"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocEnd(rset.getDate("doc_end"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocBoxId(rset.getInt("doc_box_id"));
				doc.setDocWriter(rset.getInt("doc_writer"));
				doc.setLineNo(rset.getInt("line_no"));
				
				
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		
		
		return doc;
	}

	public ArrayList<Doc> selectAll(Connection conn, int curPage) {
		
		
		ArrayList<Doc>list = new ArrayList<Doc>();;
		
		PreparedStatement pstmt = null;
		
		String query =  "select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level  " + 
				"    						from  " + 
				"                           (select * from doc join emp " + 
				"                           on doc.doc_writer = emp.emp_id  order by doc_start desc) " + 
				"                           ) " + 
				"                           where rnum >= ? and rnum <= ?";
				
		
		
		int end = curPage * 10 ;
		int start = end - 9;
		
		ResultSet rset = null;
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
			
			
				list.add(doc);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
		
	}

	public int insertDoc(Connection conn, Doc doc) {
		
		int result = 0;
		
		
		
		PreparedStatement pstmt = null;
		
		String query = "insert into doc values (doc_seq.nextval, ?, ?, ?, ?, sysdate, sysdate + ?, sysdate, sysdate + 7, ?, 1, ?, (select max(line_no) from line))";

				
				
				/*" (select line_no " + 
				"from (select line_no, rownum from line order by rownum desc) " + 
				"where rownum = 1)"*/
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, doc.getDocType());
			
			pstmt.setString(2, doc.getDocTitle());
		
			pstmt.setString(3, doc.getDocContent());
		
			pstmt.setString(4, String.valueOf(doc.getDocLevel()));
			
			pstmt.setInt(5, doc.getDocYear() * 365);
		
			pstmt.setString(6, doc.getDocStatus());
			
			pstmt.setInt(7, doc.getDocWriter());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}

	public int deleteDoc(Connection conn, int docId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "DELETE DOC WHERE DOC_ID = ?";
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docId);
			
			result = pstmt.executeUpdate();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	

	
	//종류별 문서보기 
	public ArrayList<Doc> selectOption(Connection conn, String option, int curPage) {
		
		ArrayList<Doc>list = new ArrayList<Doc>();
		
		int end = curPage * 10 ;
		int start = end - 9;
		
		PreparedStatement pstmt = null;
		
		String query = null;
		
		
		switch(option) {
		case "complete" : query =
				"select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level    " + 
						"				  from (select * from doc join emp on doc.doc_writer = emp.emp_id where doc_status = '완료' order by doc_start desc)     " + 
						"				  )  " + 
						"				    where rnum >= ? and rnum <= ? "; break;
		case "progress" : query = 
			    "select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level    " + 
						"				  from (select * from doc join emp on doc.doc_writer = emp.emp_id where doc_status = '진행' order by doc_start desc)     " + 
						"				  )  " + 
						"				    where rnum >= ? and rnum <= ? "; break;
		case "standby" : query =   
				"select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level    " + 
						"				  from (select * from doc join emp on doc.doc_writer = emp.emp_id where doc_status = '대기' order by doc_start desc)     " + 
						"				  )  " + 
						"				    where rnum >= ? and rnum <= ? "; break;
		case "all" : query = "select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level    " + 
				"				  from (select * from doc join emp on doc.doc_writer = emp.emp_id  order by doc_start desc)     " + 
				"				  )  " + 
				"				    where rnum >= ? and rnum <= ? ";  break;		
		
		case "reject" : query = 
				"select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level    " + 
						"				  from (select * from doc join emp on doc.doc_writer = emp.emp_id where doc_status = '반려' order by doc_start desc)     " + 
						"				  )  " + 
						"				    where rnum >= ? and rnum <= ? "; break;
		
		}
		
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
					
		
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
			
				
				list.add(doc);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
		
		
	}

	public ArrayList<Emp> selectLineEmp(Connection conn) {
		
		ArrayList<Emp>list = new ArrayList<Emp>();;
		
		Statement stmt = null;
		String query = "select emp_name, job_name, emp_id, sjob.job_id as job_id " + 
				"from emp " + 
				"join sjob " + 
				"on emp.job_id = sjob.job_id order by job_id desc";
		
		ResultSet rset = null;
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				Emp emp = new Emp();
				
				emp.setEmpName(rset.getString("emp_name"));
				emp.setJobName(rset.getString("job_name"));
				emp.setEmpId(rset.getInt("emp_id"));
				
				
				
				
				
				list.add(emp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
		return list;
		
	}

	
	public ArrayList<Doc> searchLineEmp(Connection conn, String name) {
	ArrayList<Doc>list = new ArrayList<Doc>();;
		
		PreparedStatement stmt = null;
		String query = "select emp_name, job_name " + 
				"from emp " + 
				"join sjob " + 
				"on emp.job_id = sjob.job_id where emp_name like ?";
		
		ResultSet rset = null;
		
		try {
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1,"%" +name + "%");
			
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				doc.setEmpName(rset.getString("emp_name"));
				doc.setJobName(rset.getString("job_name"));
				
				list.add(doc);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}

	public Doc searchEmpById(Connection conn, int empId) {
		
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select emp_name, job_name, dept_name, emp_id " + 
				"from emp " + 
				"join sjob on emp.job_id = sjob.job_id " + 
				"join dept on emp.dept_id = dept.dept_id " + 
				"where emp_id = ?";
		
		
		
		
		Doc doc = new Doc();
		
		try {
			
			pstmt = conn.prepareStatement(query);
					
			pstmt.setInt(1, empId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			
			 doc.setDeptName(rset.getString("dept_name"));
			 doc.setJobName(rset.getString("job_name"));
			 doc.setEmpName(rset.getString("emp_name"));
			 doc.setEmpId(rset.getInt("emp_id"));
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		
		
		return doc;
		
		
	}

	public int maxDocId(Connection conn) {
		
		
		Statement stmt = null;
		
		ResultSet rset = null;
		
		String query = "select max(doc_id) as docId from doc";
		
		int max = 0;
				
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				max = rset.getInt("docId");
				
				System.out.println("max : " + max);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return max;  
	}

	public int updateDoc(Connection conn, Doc doc) {
			int result = 0;
		
		
		
		PreparedStatement pstmt = null;
		String query = "UPDATE DOC SET DOC_TYPE=?, DOC_TITLE=?, DOC_CONTENT=?, DOC_LEVEL=?, "
				+ "DOC_SAVE_START = SYSDATE, DOC_SAVE_END = SYSDATE + ? WHERE DOC_ID = ? ";
		
	
			
		
		try {
			
		pstmt = conn.prepareStatement(query);
		
		
		pstmt.setString(1, doc.getDocType());
		pstmt.setString(2, doc.getDocTitle());
		pstmt.setString(3, doc.getDocContent());
		pstmt.setString(4, String.valueOf(doc.getDocLevel()));
		pstmt.setInt(5, doc.getDocYear() * 365);
		
		pstmt.setInt(6, doc.getDocId());
		
		result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}

	public int updateStatus(Connection conn, int docId) {
		
		int result = 0;
				
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE DOC SET DOC_STATUS = '진행' WHERE DOC_ID = ? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docId);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result; 
	}

	public int stausFinal(Connection conn, int docId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE DOC SET DOC_STATUS = '완료' WHERE DOC_ID = ? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Doc> selectBox(Connection conn ,int empId, String option, int curPage) {
	
		int end = curPage * 10 ;
		int start = end - 9;
		
		
		ArrayList<Doc>list = new ArrayList<Doc>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		
		
		
		switch(option) {
		case "standby" : query ="select * " + 
				"          from ( " + 
				"           " + 
				"          select rownum as rnum, doc_id, doc_title, doc_type, emp_name, doc_start, doc_status, doc_level " + 
				"          from( " + 
				"          select  doc_id, doc_title, doc_type, emp_name, doc_start,         " + 
				"				            doc_status, doc_level " + 
				"                    from doc join emp on doc.doc_writer = emp.emp_id  " + 
				"                            join line on line.line_no = doc.line_no " + 
				"                    where (first = ? and answer1 = 'N' ) or (second = ? and answer2='N') or (third = ? and answer3 ='N') or          " + 
				"				            (fourth = ? and answer4 = 'N' ) or (fifth = ? and answer5 = 'N' ) or (sixth = ? and answer6 = 'N' )         " + 
				"				            or (seventh = ? and answer7 ='N') and doc_status ='대기' order by doc_start desc " + 
				"          ) " + 
				"           " + 
				"          ) where rnum >= ? and rnum <= ?"; break;
	            
		case "complete"	: query = "select * " + 
				"          from ( " + 
				"           " + 
				"          select rownum as rnum, doc_id, doc_title, doc_type, emp_name, doc_start, doc_status, doc_level " + 
				"          from( " + 
				"          select  doc_id, doc_title, doc_type, emp_name, doc_start,         " + 
				"				            doc_status, doc_level " + 
				"                    from doc join emp on doc.doc_writer = emp.emp_id  " + 
				"                            join line on line.line_no = doc.line_no " + 
				"                    where (first = ? and answer1 = 'Y' ) or (second = ? and answer2='Y') or (third = ? and answer3 ='Y') or          " + 
				"				            (fourth = ? and answer4 = 'Y' ) or (fifth = ? and answer5 = 'Y' ) or (sixth = ? and answer6 = 'Y' )         " + 
				"				            or (seventh = ? and answer7 ='Y') order by doc_start desc " + 
				"          ) " + 
				"           " + 
				"          ) where rnum >= ? and rnum <= ?"; break;	 
		
		}
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, empId);
			pstmt.setInt(2, empId);
			pstmt.setInt(3, empId);
			pstmt.setInt(4, empId);
			pstmt.setInt(5, empId);
			pstmt.setInt(6, empId);
			pstmt.setInt(7, empId);
			
			pstmt.setInt(8, start);
			pstmt.setInt(9, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
				
				
				list.add(doc);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return list; 
	}

	public ArrayList<Doc> searchByDate(Connection conn, Date startDate, Date endDate, int curPage) {
		
		
		
		
		int end = curPage * 10 ;
		int start = end - 9;
		
		ArrayList<Doc> list = new ArrayList<Doc>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "      select *     " + 
				"			   from (" + 
				"              select rownum as rnum, doc_id, doc_title, doc_type, emp_name, doc_start, " + 
				"              doc_status, doc_level from (select * from doc join emp on doc.doc_writer = emp.emp_id where doc_start >= ? and" + 
				"              doc_start <= ? order by doc_start desc)" + 
				"              )" + 
				"              where rnum >= ? and rnum <= ?";
		
		
			
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
				
				
				list.add(doc);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}

	public int getCount(String option) {
		
		int result = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		
		switch(option) {
		case "all" : query = "select count(*) as count from doc"; break;
		case "complete" : query = "select count(*) as count from doc where doc_status = '완료'"; break;
		case "progress" : query = "select count(*) as count from doc where doc_status = '진행'"; break;
		case "standby" :query = "select count(*) as count from doc where doc_status = '대기' "; break;
		case "reject" : query = "select count(*) as count from doc where doc_status = '반려' "; break;
		
		}
		
		try {
			
			Connection conn = getConnection();
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				result = rset.getInt("count");
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return result;
		
	}

	
	
	public int stausReject(Connection conn, int docId) {
		
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE DOC SET DOC_STATUS = '반려' WHERE DOC_ID = ? ";
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docId);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
		 e.printStackTrace();
		}finally {
		 close(pstmt);
		}
		
		
		return result; 
	}

	

	

	public int getCountByDate(Date startDate, Date endDate) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Connection conn = getConnection();
		
		String query = "select count(*) as count from doc where doc_start >= ? and doc_start <= ? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				count = rset.getInt("count");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public String searchByDate(Connection conn, int empId) {
		
		String jobId = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select sjob.job_id "
				+ "		from sjob "
				+ "     join emp "
				+ "		on emp.job_id = sjob.job_id where emp_Id = ? ";
		
		try {
			
		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, empId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				jobId = rset.getString("job_id");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return jobId;
	}

	public int getCount(int empId, String option) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		
		switch(option) {
		case "standby" : query = "select count(*) as count from doc join line on doc.line_no = line.line_no " + 
				                 "where (first = ? and answer1 = 'N' ) or (second = ? and answer2='N') or (third = ? and answer3 ='N') or               " + 
				"				 (fourth = ? and answer4 = 'N' ) or (fifth = ? and answer5 = 'N' ) or (sixth = ? and answer6 = 'N' )              " + 
				"				 or (seventh = ? and answer7 ='N')"; break;
		case "complete" : query = "select count(*) as count from doc join line on doc.line_no = line.line_no " + 
								"where (first = ? and answer1 = 'Y' ) or (second = ? and answer2='Y') or (third = ? and answer3 ='Y') or               " + 
"								 (fourth = ? and answer4 = 'Y' ) or (fifth = ? and answer5 = 'Y' ) or (sixth = ? and answer6 = 'Y' )              " + 
"				 				or (seventh = ? and answer7 ='Y')"; break;
		
		}
		
		try {
			
			Connection conn = getConnection();
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, empId);
			pstmt.setInt(2, empId);
			pstmt.setInt(3, empId);
			pstmt.setInt(4, empId);
			pstmt.setInt(5, empId);
			pstmt.setInt(6, empId);
			pstmt.setInt(7, empId);
		  
		   rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				result = rset.getInt("count");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int getCountByEmpId(int empId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select count(*) as count from doc where doc_writer = ?";
				
		
		
		
		try {
			
			Connection conn = getConnection();
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, empId);
		  
		   rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				result = rset.getInt("count");
			}
			
			
			System.out.println("count : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Doc> docWhoWrite(Connection conn,int curPage, int empId) {
		
		int end = curPage * 10 ;
		int start = end - 9;
		
		ArrayList<Doc> list = new ArrayList<Doc>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "select * from (select rownum as rnum, doc_id, doc_title, emp_name, doc_start, doc_type, doc_status, doc_level  " + 
				"    						from  " + 
				"                           (select * from doc join emp " + 
				"                           on doc.doc_writer = emp.emp_id where doc_writer = ? order by doc_start desc ) " + 
				"                           ) " + 
				"                           where rnum >= ? and rnum <= ?  ";
		
		
			
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setInt(1, empId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
				
				
				list.add(doc);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
		
		
	}

	public ArrayList<Doc> docTopSearchBar(Connection conn, String docName) {
		
		
		ArrayList<Doc> list = new ArrayList<Doc>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "select * from doc join emp on doc.doc_writer = emp.emp_id "
				+ "where doc_title like ? or emp_name like ? order by doc_start desc";
		
		
		System.out.println("docName : " + docName);
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "%" + docName + "%");
			pstmt.setString(2, "%" + docName + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Doc doc = new Doc();
				
				
				doc.setDocId(rset.getInt("doc_id"));
				doc.setDocTitle(rset.getString("doc_title"));
				doc.setDocType(rset.getString("doc_type"));
				doc.setEmpName(rset.getString("emp_name"));
				doc.setDocStart(rset.getDate("doc_start"));
				doc.setDocStatus(rset.getString("doc_status"));
				doc.setDocLevel(rset.getString("doc_level"));
				
				
				
				list.add(doc);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
		
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
