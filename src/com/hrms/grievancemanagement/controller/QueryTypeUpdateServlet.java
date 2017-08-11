package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;


public class QueryTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int grievance_type_id = Integer.parseInt(request.getParameter("query_id"));
		String query_type = request.getParameter("queryType");
		
		AllUpdateGrievanceDAO allUpdateGrievanceDAO = new AllUpdateGrievanceDAO();
		boolean result = allUpdateGrievanceDAO.grievanceQueryTypeUpdate(grievance_type_id, query_type);
		request.setAttribute("success","Query Type Successfully Updated");
		request.getRequestDispatcher("grievanceQueryType.jsp").forward(request, response);
		
	}

}
