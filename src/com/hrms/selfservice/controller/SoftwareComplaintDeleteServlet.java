package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;

/**
 * Servlet implementation class SoftwareComplaintDeleteServlet
 */
public class SoftwareComplaintDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SoftwareComplaintDeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int comp_id = Integer.parseInt(request.getParameter("software_complaint_id"));
		
		AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
		boolean result = allDeleteSelfServiceDAO.softwareComplaintDelete(comp_id);
		request.setAttribute("delete", "Complaint deleted successfully....");
		request.getRequestDispatcher("complaintListSoftware.jsp").forward(request, response);
	
	
	}

}
