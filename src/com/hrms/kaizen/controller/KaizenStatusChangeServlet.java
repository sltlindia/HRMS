package com.hrms.kaizen.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenUpdateDAO;

/**
 * Servlet implementation class KaizenStatusChangeServlet
 */
public class KaizenStatusChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		
		if(status.equalsIgnoreCase("submitted")) {
		boolean result = allKaizenUpdateDAO.kaizenStatusUpdate(kaizen_id, status);
		}else if(status.equalsIgnoreCase("completed")) {
		
			Date date = new Date();
			String parseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);	
			
		boolean result = allKaizenUpdateDAO.kaizenStatusUpdateWithTime(kaizen_id, status,parseDate);
		}
		
	
	}

}
