package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.dao.AllLMSListDAO;

import jsx3.net.Request;



/**
 * Servlet implementation class pendingLeaveServlet
 */
public class pendingLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pendingLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		int leave_id = 0;
		
		if(request.getParameter("leave_id") != null)
		{
			leave_id = Integer.parseInt(request.getParameter("leave_id"));
		}
		else
		{
			leave_id =(Integer) request.getAttribute("leave_id");
		}	
		
		System.out.println("Leave_id: "+ leave_id);
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveBean> listOfLeave = allListDAO.getLeaveByLeaveId(leave_id);
		request.setAttribute("listOfLeave", listOfLeave);
		
		if(request.getParameter("leave_id") != null)
		{
			request.getRequestDispatcher("pendingleave.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("leave_id", leave_id);
			request.getRequestDispatcher("leaveSpecialPending.jsp").forward(request, response);
		}	
	}
}
