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

public class GatePassStatusCancelledEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GatePassStatusCancelledEmpServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
		
			int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
			String status = request.getParameter("status");
			
			System.out.println("ID " + gate_pass_id + "Status " + status);
			
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String date1 = sdf.format(date);
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.gatePassStatusCancelledEMP(gate_pass_id, status);
		
			if(result == true)
			{
				if(status.equalsIgnoreCase("Cancelled"))
					{
						request.setAttribute("Success", "Gate Pass Cancelled Successfully...");
						request.getRequestDispatcher("gatePassListEmployee.jsp").forward(request, response);
					}
			}
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
