package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.PreEmploymentArrangementBean;
import com.hrms.recruitement.dao.AllInsertDAO;
public class PreEmploymentArrangementInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String employee_name = request.getParameter("employeeName");
		int employee_master_id = Integer.parseInt(employee_name);
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_master_id);
		System.out.println("employee_master_id :" + employee_master_id);
		
		String designation = request.getParameter("designation");
		int role_id = Integer.parseInt(designation);
		RoleBean roleBean = new RoleBean();
		roleBean.setRole_id(role_id);
		System.out.println("role_id"+ role_id);
		
		String department = request.getParameter("hiringDepartment");
		int department_id = Integer.parseInt(department);
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartment_id(department_id);
		System.out.println("department_id"+ department_id);
		
		String joining_date = request.getParameter("joiningDate");
		System.out.println("joining_date"+ joining_date);
		
		String computer_laptop = request.getParameter("computerLaptop");
		System.out.println("computer_laptop"+ computer_laptop);
		
		String cug_connection = request.getParameter("cugConnection");
		System.out.println("cug_connection"+ cug_connection);
		
		String mobile_handset = request.getParameter("mobileHandset");
		System.out.println("mobile_handset"+ mobile_handset);
		
		String internet_data_card = request.getParameter("internetCard");
		System.out.println("internet_data_card"+ internet_data_card);
		
		String tickets = request.getParameter("tickets");
		System.out.println("tickets"+ tickets);
		
		String email_id = request.getParameter("emailId");
		System.out.println("email_id"+ email_id);
		
		String sitting_arrangement = request.getParameter("sittingArrangement");
		System.out.println("sitting_arrangement"+ sitting_arrangement);
		
		String id_card = request.getParameter("idCard");
		System.out.println("id_card"+ id_card);
		
		String visiting_card = request.getParameter("visitingCard");
		System.out.println("visiting_card"+ visiting_card);
		
		String catalog = request.getParameter("catalog");
		System.out.println("catalog"+ catalog);
		
		String authorized_by = request.getParameter("authorizedBy");
		System.out.println("authorized_by"+ authorized_by);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		PreEmploymentArrangementBean preEmploymentArrangementBean = new PreEmploymentArrangementBean(joining_date, computer_laptop, cug_connection, mobile_handset, internet_data_card, tickets, email_id, sitting_arrangement, visiting_card, id_card, catalog, authorized_by, roleBean, departmentBean, employeeBean);
		boolean result = allInsertDAO.preEmploymentArrangementInsert(preEmploymentArrangementBean);
		response.sendRedirect("hrHome.jsp");	}

}
