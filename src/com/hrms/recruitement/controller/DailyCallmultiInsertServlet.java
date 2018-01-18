package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.DailyCallingDataBean;
import com.hrms.recruitement.bean.DailyCallingStatusBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

/**
 * Servlet implementation class DailyCallmultiInsertServlet
 */
public class DailyCallmultiInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyCallmultiInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] Checkbox = request.getParameterValues("vacanyname");
		AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
		ResumeDataBean resumeDataBean = null;
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
		DailyCallingStatusBean dailyCallingStatusBean = new DailyCallingStatusBean();
		EmployeeBean employeeBean = new EmployeeBean();
		String Status = "pending";
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		int Emp_MAsterID = user.getEmployee_master_id();
		employeeBean.setEmployee_master_id(Emp_MAsterID);
		
			AllInsertDAO allInsertDAO = new AllInsertDAO();
		System.out.println("CHECK VALUE " + Checkbox);
		boolean result = false;
		for(String a : Checkbox)
		{
			System.err.println(a);
			int dailyid = Integer.parseInt(a); 
			List<DailyCallingDataBean> listofcall = allRecruitmentListDAO.getListdailycalllforinsert(dailyid);
			for(DailyCallingDataBean d : listofcall)
			{
				vacancyFormBean.setVacancy_id(d.getVacancyFormBean().getVacancy_id());
				sourceOfResumeBean.setSource_of_resume_id(d.getSourceOfResumeBean().getSource_of_resume_id());
				dailyCallingStatusBean.setDaily_calling_status_id(1);
				resumeDataBean = new ResumeDataBean(vacancyFormBean ,d.getCandidate_name(), d.getGender(), d.getCurrent_location(), d.getMobile_number(), d.getEmail_id(), d.getHighest_qualification(),Status , d.getUpload_resume() , d.getSubmission_date(), sourceOfResumeBean,employeeBean, dailyCallingStatusBean);
			}
			
			result = allInsertDAO.resumedataInsert(resumeDataBean);
		}
		
		if(result == true)
		{
			response.sendRedirect("myVacancyAllocation.jsp");
		}
	}

}
