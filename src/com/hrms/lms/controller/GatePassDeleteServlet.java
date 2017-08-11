package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.dao.AllDeleteDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class GatePassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
			
			int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
			AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
			boolean result = allDeleteDAO.gatePassDelete(gate_pass_id);
			
			if(result == true){
				request.setAttribute("delete", "Gate PAss Successfully Deleted...");
				request.getRequestDispatcher("gatePassListSecurity.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
