package com.dongzi.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import com.dongzi.daoimp.UserDaoImp;

public class InsertAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse response;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void Insert() {
		try {

			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			Map<String, String> json = new HashMap<String, String>();

			String count = this.request.getParameter("count");
			String area = this.request.getParameter("area");
			String variety = this.request.getParameter("variety");
			String longitude = this.request.getParameter("longitude");
			String latitude = this.request.getParameter("latitude");
			String ID = this.request.getParameter("ID");
			String date = this.request.getParameter("date");
			String fieldID = this.request.getParameter("fieldID");
			String town = this.request.getParameter("town");
			String picturePath = this.request.getParameter("picturePath");
			UserDaoImp userDaoImp = new UserDaoImp();
			boolean b = userDaoImp.Insert(count,area, variety,  longitude, latitude, date, fieldID, town, picturePath);
			if (b) {
				json.put("message", "插入成功");
			} else {
				json.put("message", "插入失败");
			}

			byte[] jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
