package dev.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import dev.model.dao.DevDao;
import dev.model.vo.Dev;

public class DevService {

	private DevDao ddao;
	
    public Dev selectOne(String devId) {
    	Connection conn = getConnection();
		Dev dev = ddao.selectOne(conn, devId);
		
		return dev;
    }
	
	
}
