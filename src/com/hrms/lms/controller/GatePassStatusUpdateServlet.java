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

public class GatePassStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
		String status = request.getParameter("status");
		String reason = request.getParameter("reason");
		int Approved_ID = user.getEmployee_master_id();
		
		
		System.out.println("ID " + gate_pass_id + " REason " + reason + " Status " + status);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String date1 = sdf.format(date);
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.gatePassStatusUpdate(gate_pass_id, status, date1, reason , Approved_ID);
		
		if(result == true)
		{
				if(status.equalsIgnoreCase("Approved"))
				{
					request.setAttribute("Success", "Gate Pass Approved Successfully...");
					request.getRequestDispatcher("gatePassListManager.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("reject", "Gate Pass Rejected Successfully...");
					request.getRequestDispatcher("gatePassListManager.jsp").forward(request, response);
				}
			}
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
