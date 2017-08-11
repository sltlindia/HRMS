package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.PersonalDetailCheckBean;
import com.hrms.recruitement.dao.AllInsertDAO;


public class PersonalDetailCheckInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	InterviewFeedbackBean interviewFeedbackBean = new InterviewFeedbackBean();
	int interview_feedback_id = Integer.parseInt(request.getParameter("candidate"));
	
	interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
	String full_name = request.getParameter("fullName");
	String employee_code = request.getParameter("employeeCode");
	String nationality = request.getParameter("nationality");
	String joining_date = request.getParameter("joiningDate");
	String birth_date = request.getParameter("birthDate");
	String gender = request.getParameter("gender");
	String marital_status = request.getParameter("maritalStatus");
	String landline_no = request.getParameter("landlineNo");
	String mobile_no = request.getParameter("mobileNo");
	String pan_no = request.getParameter("panNo");
	String passport_number = request.getParameter("passportNo");
	String present_address = request.getParameter("presentAddress");
	String present_state= request.getParameter("presentState");
	String present_city = request.getParameter("presentCity");
	String present_landmark = request.getParameter("presentLandmark");
	String present_pincode = request.getParameter("presentPinCode");
	String present_period_of_stay = request.getParameter("presentPeriodOfStay");
	String present_contact_no = request.getParameter("presentContactNo");
	String email_id = request.getParameter("emailId");
	String alternative_contact_no = request.getParameter("alternativeContactNo");
	String permanent_address = request.getParameter("permanentAddress");
	String permanent_city = request.getParameter("permanentCity");
	String permanent_state = request.getParameter("permanentState");
	String permanent_pincode = request.getParameter("permanentpinCode");
	String permanent_landmark = request.getParameter("permanentlandmark");
	String permanent_period_of_stay = request.getParameter("permanentperiodOfStay");
	String permanent_contact_no = request.getParameter("permanentContactNo");
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	PersonalDetailCheckBean personalDetailCheckBean = new PersonalDetailCheckBean(employee_code, joining_date, full_name, 
			birth_date, gender, pan_no, marital_status, nationality,mobile_no, passport_number, present_address, present_city, 
			present_period_of_stay, present_state, present_pincode, email_id, present_contact_no, present_landmark, 
			alternative_contact_no, permanent_address, permanent_city, permanent_pincode, permanent_period_of_stay, 
			permanent_state, permanent_landmark, permanent_contact_no, landline_no, interviewFeedbackBean);
	boolean result = allInsertDAO.personalDetailCheckInsert(personalDetailCheckBean);
	if(result == true){
		
		response.sendRedirect("hrHome.jsp");
		
	}
	
	}

}
