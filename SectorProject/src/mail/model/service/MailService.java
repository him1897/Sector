package mail.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.vo.Dept;
import mail.model.dao.MailDao;
import mail.model.vo.Mail;

public class MailService {

	private MailDao mdao;
	
	public Mail selectOne(int mailId) {
		
		Connection conn = getConnection();
		Mail mail = mdao.selectOne(conn, mailId);
		
		return mail;
		
	}
	
	public ArrayList<Mail> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Mail>list = mdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertDept(Mail mail) {
		
		Connection conn = getConnection();
		int result = mdao.insertMail(conn, mail);
		
		return result;
	}
	
	public int deleteMail(int mailId) {
		
		Connection conn = getConnection();
		int result = mdao.deleteMail(conn, mailId);
		
		return result;
	}
	
	public int updateMail(int mailId) {
		
		Connection conn = getConnection();
		int result = mdao.updateMail(conn, mailId);
		
		return result;
	}
	
}
