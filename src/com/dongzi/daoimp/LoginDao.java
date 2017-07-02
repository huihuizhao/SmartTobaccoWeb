package com.dongzi.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dongzi.db.GetConn;

public class LoginDao {
	public boolean login(String username, String password) {
		boolean b = false;
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		Connection conn = getConn.getConnection();
//		String sql = "select * from usermsg where username=? and password=?";
		String sql = "select * from  user where phoneNumber=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
//			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
