package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



	
	public class JDBCTemplate {
		
		private static String id = "sector";
		private static String pwd = "sector";
	


		public static String getId() {
			return id;
		}



		public static void setId(String id) {
			JDBCTemplate.id = id;
		}



		public static String getPwd() {
			return pwd;
		}



		public static void setPwd(String pwd) {
			JDBCTemplate.pwd = pwd;
		}



		public static Connection getConnection() {
			Connection conn = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", id, pwd);
				
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return conn;
		}
	
		

		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed())
					rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void commit(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void rollback(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
