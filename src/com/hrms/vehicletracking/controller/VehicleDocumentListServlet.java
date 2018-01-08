package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VehicleDocumentListServlet
 */
public class VehicleDocumentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int vehicle_master_id = Integer.parseInt(request.getParameter("vehicle_master_id"));
		
		if(request.getParameter("document") != null){
		request.getRequestDispatcher("vehicleDocumentList.jsp").forward(request, response);
		}
		if(request.getParameter("policy") != null){
			request.getRequestDispatcher("carDocumentList.jsp").forward(request, response);
		}
	}

}
