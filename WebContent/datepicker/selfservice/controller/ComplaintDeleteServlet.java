package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;

public class ComplaintDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ComplaintDeleteServlet() {
        super();
    }

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int comp_id = Integer.parseInt(request.getParameter("complaint_id"));
		
		AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
		boolean result = allDeleteSelfServiceDAO.complaintDelete(comp_id);		
		request.setAttribute("delete", "Complaint deleted successfully....");
		request.getRequestDispatcher("complaint.jsp").forward(request, response);
	}

}
