package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.ReferenceDetailCheckBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class ReferenceDetailCheckInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InterviewFeedbackBean interviewFeedbackBean = new InterviewFeedbackBean();
		int interview_feedback_id = Integer.parseInt(request.getParameter("candidate"));
		
		String reference1_name = request.getParameter("person1Name");
		String reference2_name = request.getParameter("person2Name");
		String reference1_designation = request.getParameter("person1Designation");
		String reference2_designation = request.getParameter("person2Designation");
		String reference1_contact_no = request.getParameter("person1ContactNo");
		String reference2_contact_no = request.getParameter("person2ContactNo");
		String reference1_email_id = request.getParameter("person1EmailId");
		String reference2_email_id = request.getParameter("person2EmailId");
		String reference1_organization = request.getParameter("person1Organization");
		String reference2_organization = request.getParameter("person2Organization");
		String reference1_name_of_acquaintance = request.getParameter("person1NameOfAcquaintance");
		String reference2_name_of_acquaintance = request.getParameter("person2NameOfAcquaintance");
		String reference1_period_of_acquaintance = request.getParameter("person1PeriodOfAcquaintance");
		String reference2_period_of_acquaintance = request.getParameter("person2PeriodOfAcquaintance");
		
		interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		ReferenceDetailCheckBean referenceDetailCheckBean = new ReferenceDetailCheckBean(interviewFeedbackBean, reference1_name, reference2_name, 
				reference1_designation, reference2_designation, reference1_contact_no, reference2_contact_no, reference1_email_id, 
				reference2_email_id, reference1_organization, reference2_organization, reference1_name_of_acquaintance, 
				reference2_name_of_acquaintance, reference1_period_of_acquaintance, reference2_period_of_acquaintance);
		boolean result = allInsertDAO.referenceDetailEmploymentDetailCheckInsert(referenceDetailCheckBean);
		
		if(result == true)
		{
			
			response.sendRedirect("hrHome.jsp");
			
		}
	
	
	
	}

}
