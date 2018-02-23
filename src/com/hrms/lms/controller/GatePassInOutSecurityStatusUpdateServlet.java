package com.hrms.lms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class GatePassInOutSecurityStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
			String status = request.getParameter("status");
			String approve_status = request.getParameter("approve_status");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String date1 = sdf.format(date);
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			if(status.equalsIgnoreCase("Out")){
			if(approve_status.equalsIgnoreCase("approved")){
			boolean result = allUpdateDAO.gatePassInOutStatusUpdate(gate_pass_id, status, date1);
			}else if(approve_status.equalsIgnoreCase("pending")){
				int e_id = user.getEmployee_master_id();
				boolean result1 = allUpdateDAO.gatePassInOutStatusUpdateWithSecurityId(gate_pass_id, status, date1, e_id);
			}
			}else{
				boolean result = allUpdateDAO.gatePassInOutStatusUpdate(gate_pass_id, status, date1);
			}
			
				
			if(status.equalsIgnoreCase("Out")){	
				request.setAttribute("success", "Employee OUT Successfully");
				request.setAttribute("openStatus", "out");
				/*request.getRequestDispatcher("gatePassListSecurity.jsp").forward(request, response);*/
				response.sendRedirect("gatePassListSecurity.jsp");
			}else{
				request.setAttribute("success", "Employee IN Successfully");
				if(request.getParameter("gateEntry")!=null){
					request.setAttribute("openStatus", "interCompany");
				}else{
				request.setAttribute("openStatus", "out");
				}
				/*request.getRequestDispatcher("gatePassListSecurity.jsp").forward(request, response);*/
				response.sendRedirect("gatePassListSecurity.jsp");
			}

			
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}
	}

}
