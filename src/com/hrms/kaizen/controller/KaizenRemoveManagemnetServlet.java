package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenDeleteDAO;

/**
 * Servlet implementation class KaizenRemoveManagemnetServlet
 */
public class KaizenRemoveManagemnetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int managent_id = Integer.parseInt(request.getParameter("kaizen_management_id"));
	int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
	
	boolean rejectFlag = false;
	
	if(request.getParameter("reject") != null) {
		rejectFlag = true;
	}
	
	
	AllKaizenDeleteDAO allKaizenDeleteDAO = new AllKaizenDeleteDAO();
	boolean result = allKaizenDeleteDAO.kaizenManagemnetDelete(managent_id);
	
	if(rejectFlag == false) {
		request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("kaizenRejectionUpdate.jsp").forward(request, response);
	}
	
		
	
	}

}
