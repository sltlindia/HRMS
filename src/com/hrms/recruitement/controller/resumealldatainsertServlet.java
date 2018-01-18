package com.hrms.recruitement.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.DailyCallingStatusBean;
import com.hrms.recruitement.bean.HrresumeBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

/**
 * Servlet implementation class resumealldatainsertServlet
 */
public class resumealldatainsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resumealldatainsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		int vid = Integer.parseInt(request.getParameter("v_id"));
		int resumeid = Integer.parseInt(request.getParameter("resume_id"));
		
		
		AllRecruitmentListDAO all = new AllRecruitmentListDAO();
		System.out.println("V " + vid + " resume " + resumeid);
		
		List<HrresumeBean> listofdata = all.getListOfgetallResumeData(resumeid);
		
		String name = null;
		String gender = null;
		String date_of_birth = null;
		String residing_country = null;
		String current_location = null;
		String current_contact_no = null;
		String email = null;
		String educational_qualification = null;
		String specialization = null;
		String experience = null;
		String current_company_name = null;
		String functional_area_appying_for = null;
		String role_as = null;
		String current_functional_area = null;
		String current_role = null;
		String key_skills = null;
		String status = "pending";
		String upload_resume = null;
		File file = null;
		String ex_employee = null;
		int employee_code = 0;
		int expected_salary = 0;
		String current_salary = null;
		String notice_period = null;
		String submission_date = null;
		String speciality = null;
		int resource_id = 1;
		String graduate_qualification = null;
		String post_graduate_qualification = null;
		String phd_qualification = null;
		int daily_calling_status_id = 1;
		int employee_id = user.getEmployee_master_id();

		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
		DailyCallingStatusBean dailyCallingStatusBean = new DailyCallingStatusBean();
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_id);
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		ResumeDataBean resumeDataBean = null;
		for(HrresumeBean h : listofdata)
		{
			
			vacancyFormBean.setVacancy_id(vid);
			sourceOfResumeBean.setSource_of_resume_id(resource_id);
			dailyCallingStatusBean.setDaily_calling_status_id(daily_calling_status_id);
		
		 resumeDataBean = new ResumeDataBean(h.getName(), h.getGender(), h.getDate_of_birth(), h.getResiding_country(), h.getCurrent_location(), h.getCurrent_contact_no(),
					h.getEmail(), h.getEducational_qualification(), h.getSpecialization(), h.getExperience(), 
					h.getCurrent_company_name(), h.getFunctional_area_applying_for(), h.getRole_as(), 
					h.getCurrent_functional_area(), h.getRole_as(), h.getKey_skills(), h.getStatus(),
					h.getUpload_resume(), vacancyFormBean, h.getEx_employee(), h.getEmployee_code(), 
					h.getExpected_salary(), h.getCurrent_salary(), h.getNotice_period(), submission_date,
					h.getSpeciality(), sourceOfResumeBean,employeeBean,h.getGraduate_qualification(),h.getPost_graduate_qualification()
					,h.getPhd_qualification(), dailyCallingStatusBean);
			
			
			
			
		}
		
		boolean result = allInsertDAO.resumedataInsert(resumeDataBean);
		
		if(result == true)
		{
			
			response.sendRedirect("allResumeList.jsp");
		}
		
		
		
	}

}
