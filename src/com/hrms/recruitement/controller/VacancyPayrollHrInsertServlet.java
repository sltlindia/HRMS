package com.hrms.recruitement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.VacancyAllocationBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.bean.VacancyGradeLevelBean;
import com.hrms.recruitement.bean.VacancyPayrollHrInfoBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

/**
 * Servlet implementation class VacancyPayrollHrInsertServlet
 */
public class VacancyPayrollHrInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VacancyPayrollHrInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
		int emp_id = Integer.parseInt(request.getParameter("employee_id"));
		String payroll_type = request.getParameter("payroll");
		String payroll_company = request.getParameter("payrollCompany");
		int vacancy_grade_level_id = Integer.parseInt(request.getParameter("vacancyGradeName"));
		VacancyGradeLevelBean vacancyGradeLevelBean = new VacancyGradeLevelBean();
		vacancyGradeLevelBean.setVacancy_grade_level_id(vacancy_grade_level_id);
		String allocated_date = null;
		int days = 0;
		String targated_closed_date = null;
		AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
		List<VacancyAllocationBean> listOfVacancy = allRecruitmentListDAO.getListOfVacancyAllocationByVacancyID(vacancy_id);
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(emp_id);
		
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		vacancyFormBean.setVacancy_id(vacancy_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		for(VacancyAllocationBean vacancyAllocationBean : listOfVacancy)
		{
			allocated_date = vacancyAllocationBean.getAllocated_date();
			
		}
		
		List<VacancyGradeLevelBean> listOfGradeDays = allRecruitmentListDAO.getListOfVacancyTargatedDays(vacancy_grade_level_id);
		
		for(VacancyGradeLevelBean vacancyGradeLevelBean2 : listOfGradeDays)
		{
			days = Integer.parseInt(vacancyGradeLevelBean2.getVacancy_grade_targeted_days());
		}
		
		for(int i=1;i<=days;i++)
		{
			c.add(Calendar.DATE, 1);  // number of days to add
			allocated_date = sdf.format(c.getTime());  // dt is now the new date
			System.out.println("Date:"+allocated_date);
			targated_closed_date = allocated_date;
		}
		
		VacancyPayrollHrInfoBean vacancyPayrollHrInfoBean = new VacancyPayrollHrInfoBean(vacancyFormBean, vacancyGradeLevelBean, employeeBean, targated_closed_date, payroll_company, payroll_type);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result = allInsertDAO.vacancyPayrollHrInfoInsert(vacancyPayrollHrInfoBean);
		
		if(result == true)
		{
			response.sendRedirect("myVacancyAllocation.jsp");
		}
		
		
	}

}
