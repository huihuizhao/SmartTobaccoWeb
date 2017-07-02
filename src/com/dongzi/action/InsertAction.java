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

			String phoneNumber = this.request.getParameter("phoneNumber");
			String date = this.request.getParameter("date");
			String imagePath = this.request.getParameter("imagePath");
			String voicePath = this.request.getParameter("voicePath");		
			String videoPath = this.request.getParameter("videoPath");
			UserDaoImp userDaoImp = new UserDaoImp();
			boolean b = userDaoImp.Insert(phoneNumber, date,imagePath,voicePath,videoPath);
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
