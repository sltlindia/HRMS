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

/**
 * Servlet implementation class GatePassTimeUpdateServlet
 */
public class GatePassTimeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
			String status = request.getParameter("status");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String date1 = sdf.format(date);
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			if(status.equalsIgnoreCase("Out")){
			boolean result = allUpdateDAO.gatePassTimeUpdate(gate_pass_id, status, date1);
			}else{
				boolean result = allUpdateDAO.gatePassTimeUpdate(gate_pass_id, status, date1);
			}
			
			if(status.equalsIgnoreCase("Out")){
				request.setAttribute("success", "Employee out successfully");
				}else{
					request.setAttribute("success", "Employee In successfully");
				}
				/*request.getRequestDispatcher("gatePassListSecurity.jsp").forward(request, response);*/
					response.sendRedirect("gatePassListSecurity.jsp");

			
		}
	}

}

