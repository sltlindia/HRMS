package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.DailyCallingStatusBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class SuggestedResumeDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			int employee_id = user.getEmployee_master_id();

			int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
			int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			vacancyFormBean.setVacancy_id(vacancy_id);
			AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
			List<ResumeDataBean> listOfResume = allRecruitmentListDAO.getListOfResumeData(resume_data_id);
			for (ResumeDataBean resumeDataBean : listOfResume) {
				int daily_calling_status_id = resumeDataBean.getDailyCallingStatusBean().getDaily_calling_status_id();
				DailyCallingStatusBean dailyCallingStatusBean = new DailyCallingStatusBean();
				dailyCallingStatusBean.setDaily_calling_status_id(daily_calling_status_id);

				String name = resumeDataBean.getName();
				String gender = resumeDataBean.getGender();
				String date_of_birth = resumeDataBean.getDate_of_birth();
				String residing_country = resumeDataBean.getResiding_country();
				String current_location = resumeDataBean.getCurrent_location();
				String current_contact_no = resumeDataBean.getCurrent_contact_no();
				String email = resumeDataBean.getEmail();
				String current_salary = resumeDataBean.getCurrent_salary();
				int expected_salary = resumeDataBean.getExpected_salary();
				String notice_period = resumeDataBean.getNotice_period();
				String educational_qualification = resumeDataBean.getEducational_qualification();
				String graduate_qualification = resumeDataBean.getGraduate_qualification();
				String post_graduate_qualification = resumeDataBean.getPost_graduate_qualification();
				String phd_qualification = resumeDataBean.getPhd_qualification();
				String specialization = resumeDataBean.getSpecialization();
				String experience = resumeDataBean.getExperience();
				String current_company_name = resumeDataBean.getCurrent_company_name();
				String current_role = resumeDataBean.getCurrent_role();
				String key_skills = resumeDataBean.getKey_skills();
				String ex_employee = resumeDataBean.getEx_employee();
				int employee_code = resumeDataBean.getEmployee_code();
				String speciality = resumeDataBean.getSpeciality();
				int source_of_resume_id = resumeDataBean.getSourceOfResumeBean().getSource_of_resume_id();
				String status = "pending";
				String functional_area_applying_for = null;
				String role_as = null;
				String current_functional_area = null;
				String upload_resume = resumeDataBean.getUpload_resume();
				String submission_date = resumeDataBean.getSubmission_date();
				int employee_master_id = user.getEmployee_master_id();
				SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
				sourceOfResumeBean.setSource_of_resume_id(source_of_resume_id);

				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setEmployee_master_id(employee_master_id);

				ResumeDataBean resumeDataBean2 = new ResumeDataBean(name, gender, date_of_birth, residing_country,
						current_location, current_contact_no, email, educational_qualification, specialization,
						experience, current_company_name, functional_area_applying_for, role_as,
						current_functional_area, current_role, key_skills, status, upload_resume, vacancyFormBean,
						ex_employee, employee_code, expected_salary, current_salary, notice_period, submission_date,
						speciality, sourceOfResumeBean, employeeBean, graduate_qualification,
						post_graduate_qualification, phd_qualification, dailyCallingStatusBean);

				AllInsertDAO allInsertDAO = new AllInsertDAO();
				boolean result = allInsertDAO.resumedataInsert(resumeDataBean2);
				
				if(result == true)
				{
					response.sendRedirect("myVacancyAllocation.jsp");
				}

			}
		}

	}

}
