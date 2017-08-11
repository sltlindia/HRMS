package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;


public class MarqueeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user != null){
			
		int marquee_id = Integer.parseInt(request.getParameter("marquee_id"));
		
		
		AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
		
		allDeleteSelfServiceDAO.marqueeDelete(marquee_id);

		request.getRequestDispatcher("addMarquee.jsp").forward(request, response);
		
		}
		
		else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	
	}

}
