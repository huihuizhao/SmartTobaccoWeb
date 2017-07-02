package com.dongzi.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dongzi.db.GetConn;



public class AdminLoginDao {
	
	public String Login(String name, String password) {
		String b = "0";
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		Connection conn = getConn.getConnection();
		// String sql = "select * from usermsg where username=? and password=?";
		String sql = "select * from  admin where name=? and password=?";
//		String sql = "select * from  admin where name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				b = "1";
			} else {
				b = "0";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

}
