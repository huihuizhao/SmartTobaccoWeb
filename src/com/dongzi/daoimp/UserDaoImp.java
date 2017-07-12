package com.dongzi.daoimp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dongzi.db.GetConn;

public class UserDaoImp {
	public boolean Insert(String count,String area,String variety,String longitude,String latitude,String date,String fieldID,String town,String picturePath) 
	{                           
		boolean b = false;
		GetConn getConn=new GetConn();
		ResultSet rs = null;
		Connection conn=getConn.getConnection();
		  String sql="insert into transplant (count,area,variety,longitude,latitude,date,fieldID,town, picturePath) values (?,?,?,?,?,?,?,?,?)";  
	        try {  
	            PreparedStatement preStmt=conn.prepareStatement(sql);  
//	            preStmt.setString(1, "李四");  
//	            preStmt.setString(2, "123");  
	            preStmt.setString(1, count);  
	            preStmt.setString(2, area);  
	            preStmt.setString(3, variety);  
	            preStmt.setString(4, longitude);  
	            preStmt.setString(5, latitude);  
	            preStmt.setString(6, date);  
	            preStmt.setString(7, fieldID);  
	            preStmt.setString(8, town);  
	            preStmt.setString(9, picturePath);  
	            
	            
	              
	            preStmt.executeUpdate();  
	            b = true;
	              
	        } catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
		

		return b;
	}
	
	
	

}
