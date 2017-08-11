package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.DailyCallingDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class DailyCallingDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeBean employeeBean = new EmployeeBean();
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		DepartmentBean departmentBean = new DepartmentBean();
		SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();

		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
		int department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
		int source_of_resume_id = Integer.parseInt(request.getParameter("sourceOfResaume"));

		employeeBean.setEmployee_master_id(employee_id);
		vacancyFormBean.setVacancy_id(vacancy_id);
		departmentBean.setDepartment_id(department_id);
		sourceOfResumeBean.setSource_of_resume_id(source_of_resume_id);

		String submission_date = request.getParameter("submission_date");
		String candidate_name = request.getParameter("candidateName");
		String current_location = request.getParameter("candidateLocation");
		String mobile_number = request.getParameter("mobileNumber");
		String email_id = request.getParameter("emailId");
		String current_designation = request.getParameter("currentDesignation");
		String total_experience = request.getParameter("totalExperience");
		String highest_qualification = request.getParameter("highestQualification");
		String current_CTC = request.getParameter("currentCTC");
		String expected_CTC = request.getParameter("expectedCTC");
		String notice_period = request.getParameter("noticePeriod");
		String status = request.getParameter("status");
		String remarks = request.getParameter("remarks");
		String offered_gross = request.getParameter("offeredGross");
		String offered_CTC = request.getParameter("offeredCTC");
		String joining_date = request.getParameter("tentativeJoiningDate");

		DailyCallingDataBean dailyCallingDataBean = new DailyCallingDataBean(submission_date, candidate_name,
				current_location, mobile_number, email_id, current_designation, total_experience, highest_qualification,
				current_CTC, expected_CTC, notice_period, status, remarks, offered_gross, offered_CTC, joining_date,
				departmentBean, vacancyFormBean, sourceOfResumeBean, employeeBean);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result  = allInsertDAO.dailyCallingDataInsert(dailyCallingDataBean);
		
		
		if(result == true)
		{
			response.sendRedirect("hrHome.jsp");
		}
		
		

	}

}
