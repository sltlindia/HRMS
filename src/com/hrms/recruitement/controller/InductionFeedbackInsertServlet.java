package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InductionFeedbackBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class InductionFeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeBean employeeBean = new EmployeeBean();
		
		String employee_name = request.getParameter("employeeName");
		int employee_master_id = Integer.parseInt(employee_name);
		
		
		System.out.println("employee_master_id :" + employee_master_id);
		
		String induction_feedback_q1 = request.getParameter("q1");
		System.out.println("induction_feedback_q1"+ induction_feedback_q1);
		
		String induction_feedback_q2 = request.getParameter("q2");
		System.out.println("induction_feedback_q2"+ induction_feedback_q2);
		
		String induction_feedback_q3 = request.getParameter("q3");
		System.out.println("induction_feedback_q3"+ induction_feedback_q3);
		
		String induction_feedback_q4 = request.getParameter("q4");
		System.out.println("induction_feedback_q4"+ induction_feedback_q4);
		
		String induction_feedback_q5 = request.getParameter("q5");
		System.out.println("induction_feedback_q5"+ induction_feedback_q5);
		
		String induction_feedback_q6 = request.getParameter("q6");
		System.out.println("induction_feedback_q6"+ induction_feedback_q6);
		
		String induction_feedback_q7 = request.getParameter("q7");
		System.out.println("induction_feedback_q7"+ induction_feedback_q7);
		
		String induction_feedback_q8 = request.getParameter("q8");
		System.out.println("induction_feedback_q8"+ induction_feedback_q8);
		
		String induction_feedback_q9 = request.getParameter("q9");
		System.out.println("induction_feedback_q9"+ induction_feedback_q9);
		
		String induction_feedback_q10 = request.getParameter("q10");
		System.out.println("induction_feedback_q10"+ induction_feedback_q10);
		
		String suggestion = null;
		
		if(request.getParameter("suggestion") != null){
			suggestion = request.getParameter("suggestion");
			System.out.println("suggestion"+ suggestion);
		}
		System.out.println("suggestion"+ suggestion);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		employeeBean.setEmployee_master_id(employee_master_id);
		InductionFeedbackBean inductionFeedbackBean = new InductionFeedbackBean(induction_feedback_q1, induction_feedback_q2, induction_feedback_q3, induction_feedback_q4,
		induction_feedback_q5, induction_feedback_q6, induction_feedback_q7, induction_feedback_q8, induction_feedback_q9, induction_feedback_q10, suggestion, employeeBean);
		
		boolean result = allInsertDAO.inductionFeedbackInsert(inductionFeedbackBean);
		response.sendRedirect("hrHome.jsp");
		
	}

}
