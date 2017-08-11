package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenUpdateDAO;

/**
 * Servlet implementation class KaizenManagementApprovalServlet
 */
public class KaizenManagementApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		String reason = request.getParameter("reason");
		String status = request.getParameter("status");
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		
		boolean result = allKaizenUpdateDAO.kaizenManagemnetApproval(kaizen_id, status, reason);
		
	
		
	
	}

}
