package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.AppointmentLetterBean;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class AppointmentLetterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String submission_date = request.getParameter("submission_date");
		System.out.println("submission_date" + submission_date);

		String candidate_name = request.getParameter("name");
		System.out.println("candidate_name" + candidate_name);

		String joining_date = request.getParameter("joiningDate");
		System.out.println("joining_date" + joining_date);

		String address = request.getParameter("address");
		System.out.println("address" + address);

		String gross_salary = request.getParameter("grossSalary");
		System.out.println("gross_salary" + gross_salary);

		String ctc = request.getParameter("ctcSalary");
		System.out.println("basic_salary" + ctc);

		String notice_period = request.getParameter("noticePeriod");
		System.out.println("notice_period" + notice_period);

		RoleBean roleBean = new RoleBean();
		int role_id = Integer.parseInt(request.getParameter("designation"));
		roleBean.setRole_id(role_id);
		System.out.println("role_id" + role_id);

		EmployeeBean employeeBean = new EmployeeBean();
		int emp_id = Integer.parseInt(request.getParameter("employee_master_id"));
		employeeBean.setEmployee_master_id(emp_id);
		System.out.println("emp_id"+emp_id);

		CompanyListBean companyListBean = new CompanyListBean();
		int company_list_id = Integer.parseInt(request.getParameter("companyName"));
		companyListBean.setCompany_list_id(company_list_id);
		System.out.println("company_list_id :" + company_list_id);

		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AppointmentLetterBean appointmentLetterBean = new AppointmentLetterBean(roleBean, companyListBean, employeeBean,
				joining_date, candidate_name, address, ctc, gross_salary, notice_period,
				submission_date);
		boolean result = allInsertDAO.appointmentLetterInsert(appointmentLetterBean);
		if (result == true) {
			response.sendRedirect("hrHome.jsp");
		}else
		{
			response.sendRedirect("hrHome.jsp");
		}
	}

}