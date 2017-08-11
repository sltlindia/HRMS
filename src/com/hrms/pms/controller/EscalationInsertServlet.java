package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;

public class EscalationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	int review_id =  Integer.parseInt(request.getParameter("reviewId"));
	String id_email = request.getParameter("employee_master_id");
	
	System.out.println("review_id:"+review_id);
	System.out.println("id:"+id_email);
	
	String[] split = id_email.split("/");
	
	int employee_id = Integer.parseInt(split[0]);
	String email = split[1];
	
	System.out.println(employee_id);
	System.out.println(email);
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	boolean result = allUpdateDAO.reviewEscalteUpdate(employee_id, review_id);
	
	response.sendRedirect("employeeHistory.jsp");
	
	/*String to = email;
	String subject="Esclated";
	String msg="escalated successfull...";
	
	Mailer.send(to, subject, msg);
	System.out.println("message has been sent successfully");*/
	
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

}
