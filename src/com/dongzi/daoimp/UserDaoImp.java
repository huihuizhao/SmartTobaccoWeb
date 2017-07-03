package com.dongzi.daoimp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dongzi.db.GetConn;

public class UserDaoImp {
	public boolean Insert(String ID,String area,String count,String longitude,String latitude,String date,String fieldID,String town,String picturePath) 
	{
		boolean b = false;
		GetConn getConn=new GetConn();
		ResultSet rs = null;
		Connection conn=getConn.getConnection();
		  String sql="insert into transplant (ID,area,count,longitude,latitude,date,fieldID,town, picturePath) values (?,?,?,?,?,?,?,?,?)";  
	        try {  
	            PreparedStatement preStmt=conn.prepareStatement(sql);  
//	            preStmt.setString(1, "李四");  
//	            preStmt.setString(2, "123");  
	            preStmt.setString(1, ID);  
	            preStmt.setString(2, area);  
	            preStmt.setString(3, count);  
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
