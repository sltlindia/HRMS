package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
			int emp_code = 0;
			emp_code =Integer.parseInt(request.getParameter("employeeCode"));
			
			AllLMSListDAO allListDAO = new AllLMSListDAO();
			
			List<LeavecutBalance> listOfLeaveReport = allListDAO.getLeaveReport(emp_code);
			request.setAttribute("listOfLeaveReport", listOfLeaveReport);
			/*request.getRequestDispatcher("LeaveBalanceReport.jsp").forward(request, response);*/
			response.sendRedirect("LeaveBalanceReport.jsp");
		}
		else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}
	}
}
