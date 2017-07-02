package com.dongzi.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import com.dongzi.daoimp.UserDaoImp;

public class loginServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse response;

//	public void setServletRequest(HttpServletRequest request) {
//		this.request = request;
//	}
//
//	public void setServletResponse(HttpServletResponse response) {
//		this.response = response;
//	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	this.request = request;
    	this.response = response;
        doGet(request, response);
    }
	
    public void doGet(HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
 
                } 

	public void login() {
		try {

			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");

			Map<String, String> json = new HashMap<String, String>();

			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String imagePath = request.getParameter("imagePath");
			String voicePath = request.getParameter("voicePath");
			String videoPath = request.getParameter("videoPath");
			UserDaoImp userDaoImp = new UserDaoImp();
			boolean b = userDaoImp.Insert(username, password,imagePath,voicePath,videoPath);
			if (b) {
//				json.put("message", "��¼�ɹ���");
				json.put("message", "登录成功");
			} else {
//				json.put("message", "��¼ʧ�ܣ�");
				json.put("message", "登录失败");
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
