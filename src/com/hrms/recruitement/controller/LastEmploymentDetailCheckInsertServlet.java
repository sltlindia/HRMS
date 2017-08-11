package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.LastEmploymentDetailCheckBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class LastEmploymentDetailCheckInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int interview_feedback_id = Integer.parseInt(request.getParameter("candidate"));
		String last_employment = request.getParameter("employmentName");
		String company_address = request.getParameter("companyAddress");
		String from_date = request.getParameter("from");
		String to_date = request.getParameter("to");
		String designation = request.getParameter("designation");
		String employee_code = request.getParameter("employeeId");
		String contact_no = request.getParameter("contactNo");
		String mode_of_separation = request.getParameter("modeOfSeparation");
		String annual_salary = request.getParameter("annualSalary");
		String authority_name = request.getParameter("authorityName");
		String authority_contact_no = request.getParameter("authorityContactNo");
		String authority_designation = request.getParameter("authorityDesignation");
		String authority_email_id = request.getParameter("authorityEmailId");
		String hr_name = request.getParameter("hrName");
		String hr_designation = request.getParameter("hrDesignation");
		String hr_contact_no = request.getParameter("hrContactNo");
		String hr_email_id = request.getParameter("hrEmailId");
		String company_functioning = request.getParameter("companyFunction");
		String social_security_no = request.getParameter("socialSecurityNo");
		
		InterviewFeedbackBean interviewFeedbackBean = new InterviewFeedbackBean();
		interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		LastEmploymentDetailCheckBean lastEmploymentDetailCheckBean = new LastEmploymentDetailCheckBean(interviewFeedbackBean, last_employment, 
				company_address, from_date, to_date, designation, employee_code, contact_no, mode_of_separation, annual_salary, authority_name, 
				authority_contact_no, authority_designation, authority_email_id, hr_name, hr_designation, hr_contact_no, hr_email_id, 
				company_functioning, social_security_no);
		boolean result = allInsertDAO.lastEmploymentDetailCheckInsert(lastEmploymentDetailCheckBean);
		if(result == true){
			
			response.sendRedirect("hrHome.jsp");
		}
	
	
	
	
	
	
	
	}

}
