package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;

public class AttachmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AttachmentDeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
	EmployeeBean user = (EmployeeBean)session.getAttribute("user");
	if(user != null){
		
	int selfservice_query_id = Integer.parseInt(request.getParameter("selfservice_query_id"));
	
	
	AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
	
	allDeleteSelfServiceDAO.selfServiceDelete(selfservice_query_id);

	request.getRequestDispatcher("selfServiceList.jsp").forward(request, response);
	
	}
	
	else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}
	
	}


