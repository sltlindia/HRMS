package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.FinalSelectionBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class FinalSelectionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResumeDataBean resumeDataBean = new ResumeDataBean();
		EmployeeBean employeeBean = new EmployeeBean();
		DepartmentBean departmentBean = new DepartmentBean();
		RoleBean roleBean = new RoleBean();
		JobLocationBean jobLocationBean = new JobLocationBean();

		int resume_data_id = 0;
		if(request.getParameter("resume_data_id") != null){
			resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
			System.out.println("resume"+resume_data_id);
		}
		
		int employee_master_id = 0;
		if(request.getParameter("employee_master_id") != null){
		employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		System.out.println("employee_master_id "+employee_master_id);
		}
		
		int role_id = 0;
		if(request.getParameter("designation") != null){
			role_id = Integer.parseInt(request.getParameter("designation"));
		System.out.println("role_id "+role_id);
		}
		
		int department_id = 0 ;
		if(request.getParameter("hiringDepartment") != null){
		department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
		System.out.println("department "+department_id);
		}
		
		String decision = null ;
		if(request.getParameter("decision") != null){
		decision = request.getParameter("decision");
		System.out.println("decision"+decision);
		}
		
		String reject_reason = null ;
		if(request.getParameter("rejectReason") != null){
		reject_reason = request.getParameter("rejectReason");
		System.out.println("reject_reason"+reject_reason);
		}
		
		String joining_in_days = null;
		if(request.getParameter("joiningInDays") != null){
		joining_in_days = request.getParameter("joiningInDays");
		System.out.println("joining in days"+joining_in_days);
		}
		
		double salary = 0 ;
		if(request.getParameter("salary") != null){
		salary = Double.parseDouble(request.getParameter("salary"));
		System.out.println("salary"+salary);
		}
		
		String probation_period = null ;
		if(request.getParameter("probationPeriod") != null){
		probation_period = request.getParameter("probationPeriod");
		System.out.println("probation_period"+probation_period);
		}
		
		String procced_for_next = null;
		if(request.getParameter("nextProceed") != null){
		procced_for_next = request.getParameter("nextProceed");
		System.out.println("proceed"+procced_for_next);
		}
		
		int job_location_id = 0 ;
		if(request.getParameter("Place") != null){
		job_location_id = Integer.parseInt(request.getParameter("Place"));
		System.out.println("job_location_id"+job_location_id);
		}
		
		resumeDataBean.setResume_data_id(resume_data_id);
		employeeBean.setEmployee_master_id(employee_master_id);
		departmentBean.setDepartment_id(department_id);
		roleBean.setRole_id(role_id);
		jobLocationBean.setJob_location_id(job_location_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		FinalSelectionBean finalSelectionBean = new FinalSelectionBean(decision, reject_reason, joining_in_days, salary,
				probation_period, procced_for_next, roleBean, departmentBean, employeeBean, resumeDataBean, jobLocationBean);

		boolean result = allInsertDAO.finalSelectionInsert(finalSelectionBean);
		if(result == true)
		{
			request.setAttribute("employee_master_id", employee_master_id);
			response.sendRedirect("offerLetterViaFeedback.jsp");
		}
		
	}

}
