package com.hrms.exitformality.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewManagerCommentsBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;

public class ExitInterviewManagerCommentsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			int manager_id = user.getManagerBean().getManager_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			int employee_id = user.getEmployee_master_id();
			int exit_interview_employee_id = Integer.parseInt(request.getParameter("exit_interview_employee_id"));
			String mainIssue = request.getParameter("mainIssue");
			String secondaryIssue = request.getParameter("secondaryIssue");
			String keySuggestions = request.getParameter("keySuggestions");
			
			AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_id);
			
			ExitInterviewEmployeeBean exitInterviewEmployeeBean = new ExitInterviewEmployeeBean();
			exitInterviewEmployeeBean.setExit_interview_employee_id(exit_interview_employee_id);
			
			ExitInterviewManagerCommentsBean exitInterviewManagerCommentsBean = new ExitInterviewManagerCommentsBean(mainIssue, secondaryIssue, keySuggestions, employeeBean, exitInterviewEmployeeBean);
			boolean result = allInsertExitFormalityDAO.managerCommentInsert(exitInterviewManagerCommentsBean);
			
			
			if(result == true){
				
				request.setAttribute("success", "Form Submitted Successfully.... ");
				if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
					request.getRequestDispatcher("exitInterviewHRList.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("exitInterviewManagerList.jsp").forward(request, response);
				}
				
			}else{	
				
				
				
			}
			
				
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
