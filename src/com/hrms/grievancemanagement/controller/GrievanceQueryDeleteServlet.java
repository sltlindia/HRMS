package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllDeleteGrievanceDAO;

public class GrievanceQueryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("grievance_query_id"));
		AllDeleteGrievanceDAO allDeleteGrievanceDAO = new AllDeleteGrievanceDAO();
		boolean result = allDeleteGrievanceDAO.grievanceQueryDelete(id);
		if(result == true){
			request.setAttribute("delete", "Grievance Query Successfully Deleted.");
		}else{
			request.setAttribute("delete", "Query Not Deleted.");
		}
		request.getRequestDispatcher("allGrievanceHrList.jsp").forward(request, response);
	
	}

}
