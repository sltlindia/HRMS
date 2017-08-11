package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.grievancemanagement.dao.AllInsertGrievanceDAO;


public class QueryTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String name = request.getParameter("query_name");
	
	GrievanceQueryTypeBean grievanceQueryTypeBean = new GrievanceQueryTypeBean(name);
	AllInsertGrievanceDAO allInsertGrievanceDAO = new AllInsertGrievanceDAO();
	
	boolean result = allInsertGrievanceDAO.grievanceQueryTypeInsert(grievanceQueryTypeBean);
	if(result == true){
	request.setAttribute("create", "Query Type Successfull added");
	}else{
		request.setAttribute("error", "Query Type already exist");
	}
	request.getRequestDispatcher("grievanceQueryType.jsp").forward(request, response);
	
	
	}

}
