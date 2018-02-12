package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;

public class MarqueeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int employee_id = user.getEmployee_master_id();
		String desc = request.getParameter("description");
		System.out.println("description:"+desc);
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_id);
		System.out.println("empid"+employee_id);
		AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
		MarqueeBean marqueeBean = new MarqueeBean(desc, employeeBean);
		boolean result = allInsertSelfServiceDAO.marqueeInsert(marqueeBean);
		
		
		request.getRequestDispatcher("addMarquee.jsp").forward(request, response); 
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}
