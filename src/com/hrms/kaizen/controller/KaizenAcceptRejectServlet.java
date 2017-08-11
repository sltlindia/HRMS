package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.kaizen.dao.AllKaizenUpdateDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class KaizenAcceptRejectServlet
 */
public class KaizenAcceptRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		int manager_id = user.getManagerBean().getManager_id();
		String status = request.getParameter("value");
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		int employee_id = user.getEmployee_master_id();
		String reason = "-";
		int kaizen_manager_id = Integer.parseInt(request.getParameter("kaizen_manager_id"));
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		
		if(status.equalsIgnoreCase("approved")){
			
			if(kaizen_manager_id == manager_id){
				boolean result = allKaizenUpdateDAO.kaizenMainApproval(kaizen_id, status, reason);
			}else{
			boolean result = allKaizenUpdateDAO.kaizenApproval(kaizen_id, status, reason, employee_id);
			}
			
		}else if(status.equalsIgnoreCase("rejected")){
			
			reason = request.getParameter("reason");
			
			if(kaizen_manager_id == manager_id){
				boolean result = allKaizenUpdateDAO.kaizenMainApproval(kaizen_id, status, reason);
			}else{
			boolean result = allKaizenUpdateDAO.kaizenApproval(kaizen_id, status, reason, employee_id);
			}
			
		}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
