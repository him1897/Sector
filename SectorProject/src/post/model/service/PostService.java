package post.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import post.model.vo.Post;
import post.model.dao.PostDao;
import post.model.vo.Post;

public class PostService {

	private PostDao pdao = new PostDao();
	
	public PostService() {}
	
	
	public ArrayList<Post> selectList(String genre, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Post> list = pdao.selectList(conn, genre, startRow, endRow);
		close(conn);
		return list;
	}
	
	
	
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = pdao.getListCount(conn);
		close(conn);
		return listCount;
	}


	public int insertPost(Post post) {
		Connection conn = getConnection();
		int result = pdao.insertPost(conn, post);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public Post selectOne(int postId) {
		Connection conn = getConnection();
		Post post = pdao.selectOne(conn, postId);
		close(conn);
		return post;
	}


	public int updatePost(Post post) {
		Connection conn = getConnection();
		int result = pdao.updatePost(conn, post);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public int deletePost(int postId) {
		Connection conn = getConnection();
		int result = pdao.deletePost(conn, postId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Post> writeName(int empId) {
		Connection conn = getConnection();
		ArrayList<Post> list = pdao.writeName(conn, empId);
		close(conn);
		return list;
	}

	public ArrayList<Post> searchPost(String category, String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Post> list = pdao.searchPost(conn, category, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public int listCount() {
		Connection conn = getConnection();
		int count = pdao.listCount(conn);
		close(conn);
		return count;
	}
}
