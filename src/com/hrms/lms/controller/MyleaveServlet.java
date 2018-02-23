package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;

public class MyleaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyleaveServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session = request.getSession();
		
		int leave_id = Integer.parseInt(request.getParameter("leave_id"));
		String status = request.getParameter("status");
		System.out.println("Leave_id: "+ leave_id);
		
		if(status.equalsIgnoreCase("approved"))
		{
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.LeaveShowView(leave_id);
			if(result == true)
			{
				System.out.println("Show View 1 Successfully");
			}
		}
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveBean> listOfLeave = allListDAO.getLeaveByLeaveId(leave_id);
		request.setAttribute("listOfLeave", listOfLeave);
		if(request.getParameter("action") != null)
		{
				if(request.getParameter("action").equalsIgnoreCase("afterApprove"))
				{
					/*request.getRequestDispatcher("leaveUpdateAfterApprove.jsp").forward(request, response);*/
					response.sendRedirect("leaveUpdateAfterApprove.jsp");
				}
				else
				{
					/*request.getRequestDispatcher("MyLeaveForHr.jsp").forward(request, response);*/
					response.sendRedirect("MyLeaveForHr.jsp");
				}
		}
		else{
		/*request.getRequestDispatcher("Myleave.jsp").forward(request, response);*/
			response.sendRedirect("Myleave.jsp");
		}
	}

}
