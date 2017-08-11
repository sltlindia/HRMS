package com.hrms.pms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.CommentMilestoneBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.dao.AllInsertDAO;

/**
 * Servlet implementation class MilestoneCommentInsertServlet
 */
public class MilestoneCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
		int milestone_id = Integer.parseInt(request.getParameter("milestone_id"));
		String comment = request.getParameter("comment");
		
		int employee_id =  user.getEmployee_master_id();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String date1 = sdf.format(date);
		
		MilestoneBean milestoneBean = new MilestoneBean();
		EmployeeBean employeeBean = new EmployeeBean();
		
		milestoneBean.setMilestone_id(milestone_id);
		employeeBean.setEmployee_master_id(employee_id);
		
		CommentMilestoneBean commentMilestoneBean = new CommentMilestoneBean(comment, date1, milestoneBean, employeeBean); 
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result = allInsertDAO.milestoneCommentInsert(commentMilestoneBean);
				
		if(result == true){
			request.setAttribute("success", "Comment Successfully Added");
			if(request.getParameter("action") != null){
				request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}
		}	
		
		
		}else {
			request.setAttribute("fail", "Email id not match with your Emloyee Code");
			request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
		}
	}

}
