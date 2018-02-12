package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllDeleteGrievanceDAO;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;

public class ComplaintHideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("complaint_id"));
		System.out.println("com_id"+id);
		AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
		boolean result = allDeleteSelfServiceDAO.complaintHide(id);
		if(result == true){
			request.setAttribute("delete", "Compalint Successfully Deleted.");
		}else{
			request.setAttribute("delete", "Complaint Not Deleted.");
		}
		request.getRequestDispatcher("itComplaint.jsp").forward(request, response);
	
	}

}
