package com.dongzi.daoimp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dongzi.bean.PersonInfo;
import com.dongzi.bean.TransplantInfo;
import com.dongzi.db.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDao {

public ArrayList<TransplantInfo> QueryPersonList(String strSQL) {

		ArrayList<TransplantInfo> personList = new ArrayList<TransplantInfo>();
		try {
			GetConn getConn = new GetConn();
			Connection conn = getConn.getConnection();
			Statement stmt = conn.createStatement(); // 创建Statement对象
			// System.out.println("成功连接到数据库！");

			String sql = "select * from transplant"; // 要执行的SQL
			ResultSet resultSet = stmt.executeQuery(sql);// 创建数据对象
			while (resultSet.next()) {
				TransplantInfo transplantInfo = new TransplantInfo();
				transplantInfo.setcount(resultSet.getString("count"));
				transplantInfo.setarea(resultSet.getString("area"));
				transplantInfo.setvariety(resultSet.getString("variety"));
				transplantInfo.setlongitude(resultSet.getString("longitude"));
				transplantInfo.setlatitude(resultSet.getString("latitude"));
				transplantInfo.setdate(resultSet.getString("date"));
				transplantInfo.setfieldID(resultSet.getString("fieldID"));
				transplantInfo.settown(resultSet.getString("town"));
				transplantInfo.setpicturePath(resultSet.getString("picturePath"));

				personList.add(transplantInfo);
			}
			resultSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return personList;
	}



public ArrayList<PersonInfo> QueryPersonByPhoneNumber(String phoneNumber) {

		ArrayList<PersonInfo> personList = new ArrayList<PersonInfo>();
		try {
			GetConn getConn = new GetConn();
			Connection conn = getConn.getConnection();
			Statement stmt = conn.createStatement(); // 创建Statement对象
			// System.out.println("成功连接到数据库！");

			String sql = "select * from Person where phoneNumber ="+"'"+phoneNumber+"'"; // 要执行的SQL
			ResultSet resultSet = stmt.executeQuery(sql);// 创建数据对象
			while (resultSet.next()) {
				PersonInfo personInfo = new PersonInfo();
				personInfo.setphoneNumber(resultSet.getString("phoneNumber"));
				personInfo.setdate(resultSet.getString("date"));
				personInfo.setimagePath(resultSet.getString("imagePath"));
				personInfo.setvoicePath(resultSet.getString("voicePath"));
				personInfo.setvideoPath(resultSet.getString("videoPath"));

				personList.add(personInfo);
			}
			resultSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return personList;
	}



}
