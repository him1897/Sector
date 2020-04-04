package post.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import post.model.vo.Post;

public class PostDao {
	public PostDao() {}
	
	
	
	
	public ArrayList<Post> selectList(Connection conn, String genre, int startRow, int endRow) {
		ArrayList<Post> list = new ArrayList<Post>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, post_id, post_title, emp_name, board_name, post_date, dept_id " + 
				"from post " + 
				"join emp " + 
				"on post.emp_id = emp.emp_id ";
				
				
				
		System.out.println("genre : " + genre);
		
		switch(genre) {
		
		case "all" : 
			query = query; break;
		case "free" : 		
			 query += " where board_name = '자유게시판'"; break;
		case "FN" :
			query += " where board_name = '재무부서'"; break;
			
		case "notice" :
			query += " where board_name = '공지사항'"; break;			
		
		case "HR" :
			query += " where board_name = '인사부서'"; break;
			
		case "AD" :
			query += " where board_name = '행정부서'"; break;
			
		case "ST" :
			query += " where board_name = '기획부서'"; break;
		}
				
		query += " order by post_date desc ) where rnum >= " + startRow + " and rnum <= " + endRow;
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				Post post = new Post();
				
				post.setPostTitle(rset.getString("post_title"));
				post.setWriter(rset.getString("emp_name"));
				post.setBoardName(rset.getString("board_name"));
				post.setPostDate(rset.getDate("post_date"));
				post.setPostId(rset.getInt("post_id"));
				
				
				
				list.add(post);
				
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
	
		return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from post";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}


	public int insertPost(Connection conn, Post post) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into post (post_id, post_title, emp_id, board_name, post_date, post_content) values (post_seq.nextval ,?, ?, ?, sysdate, ?)";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, post.getPostTitle());
			pstmt.setInt(2, post.getEmpId());
			pstmt.setString(3, post.getBoardName());
			pstmt.setString(4, post.getPostContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}




	public Post selectOne(Connection conn, int postId) {
		Post post = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select post_title, post_id, post_date, post_content, board_id, board_name, emp.emp_name, emp.emp_id " + 
				"from post " + 
				"join emp on emp.emp_id = post.emp_id " + 
				"where post_id = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				post = new Post();

				post.setPostTitle(rset.getString("post_title"));
				post.setPostId(rset.getInt("post_id"));
				post.setPostDate(rset.getDate("post_date"));
				post.setPostContent(rset.getString("post_content"));
				post.setEmpId(rset.getInt("emp_id"));
				post.setBoardId(rset.getInt("board_id"));
				post.setBoardName(rset.getString("board_name"));
				post.setWriter(rset.getString("emp_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return post;
	}




	public int updatePost(Connection conn, Post post) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update post set "
				+ "post_title = ?, "
				+ "post_content = ?, "
				+ "board_name = ?"
				+ "where post_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, post.getPostTitle());
			pstmt.setString(2, post.getPostContent());
			pstmt.setString(3, post.getBoardName());
			pstmt.setInt(4, post.getPostId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}




	public int deletePost(Connection conn, int postId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from post "
				+ "where post_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}




	public ArrayList<Post> writeName(Connection conn, int empId) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select post_id, post_title, emp_name, board_name, post_date, dept_id " + 
				"from post " + 
				"join emp " + 
				"on post.emp_id = emp.emp_id " +
				"join suser " +
				"on emp.user_id = suser.user_id " +
				"where post.emp_id = ? ";
				
		

		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, empId);
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				
				Post post = new Post();
				
				post.setPostTitle(rset.getString("post_title"));
				post.setWriter(rset.getString("emp_name"));
				post.setBoardName(rset.getString("board_name"));
				post.setPostDate(rset.getDate("post_date"));
				post.setPostId(rset.getInt("post_id"));
				
				
				
				list.add(post);
				
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
	
		return list;
	}

	
	public ArrayList<Post> searchPost(Connection conn, String category, String keyword, int startRow, int endRow) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, post_id, post_title, emp_name, board_name, post_date, dept_id " + 
				"from post " + 
				"join emp " + 
				"on post.emp_id = emp.emp_id ";
			
			switch(category) {
			
			case "title": query += "where post_title like ? order by post_date desc ) where rnum >= " + startRow + " and rnum <= " + endRow; break;
			
			case "writer" : query += "where emp_name like ? order by post_date desc ) where rnum >= " + startRow + " and rnum <= " + endRow; break;
			
			}
		
		try {
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "%"+keyword+"%");
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				
				Post post = new Post();
				
				post.setPostTitle(rset.getString("post_title"));
				post.setWriter(rset.getString("emp_name"));
				post.setBoardName(rset.getString("board_name"));
				post.setPostDate(rset.getDate("post_date"));
				post.setPostId(rset.getInt("post_id"));
				
				
				
				list.add(post);
				
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
	
		return list;
	}
	
	
	public int listCount(Connection conn) {
		int count = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from post";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				count = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return count;
	}
}
