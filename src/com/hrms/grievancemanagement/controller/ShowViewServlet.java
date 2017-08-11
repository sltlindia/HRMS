package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;


public class ShowViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int query_id = Integer.parseInt(request.getParameter("query_id"));
		int show_view = 1;
		
		AllUpdateGrievanceDAO allUpdateGrievanceDAO = new AllUpdateGrievanceDAO();
		boolean result = allUpdateGrievanceDAO.grievanceQueryUpdateShowView(query_id, show_view);
		request.setAttribute("remove", "Query Successfully Removed.");
		request.getRequestDispatcher("allGrievanceList.jsp").forward(request, response);
	}

}
