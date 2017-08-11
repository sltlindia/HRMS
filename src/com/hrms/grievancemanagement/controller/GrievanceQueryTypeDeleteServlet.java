package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllDeleteGrievanceDAO;


public class GrievanceQueryTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("type_id"));
		AllDeleteGrievanceDAO allDeleteGrievanceDAO = new AllDeleteGrievanceDAO();
		boolean result = allDeleteGrievanceDAO.grievanceQueryTypeDelete(id);
		if(result == true){
			request.setAttribute("delete", "Grievance Query Type Successfully Deleted.");
		}else{
			request.setAttribute("delete", "Query Type Not Deleted.");
		}
		request.getRequestDispatcher("grievanceQueryType.jsp").forward(request, response);
	}


}
