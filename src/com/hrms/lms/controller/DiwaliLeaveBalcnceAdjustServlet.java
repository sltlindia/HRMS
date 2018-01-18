package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class DiwaliLeaveBalcnceAdjustServlet
 */
public class DiwaliLeaveBalcnceAdjustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LoginDAO loginDAO = new LoginDAO();
		List<EmployeeBean> listOfEmoloyee = loginDAO.getListOfEmployee();
		
		for(EmployeeBean employeeBean : listOfEmoloyee) {
			System.out.println(employeeBean.getEmployee_code()+":"+employeeBean.getFirstname()+" "+employeeBean.getLastname());
			
			if(employeeBean.getEmployeeStatusBean().getEmployee_status_id() == 1) {
				boolean result = loginDAO.employeeLeaveBalanceUpdate(0, 23, 7, 0, employeeBean.getEmployee_master_id());
			}else{
				boolean result = loginDAO.employeeLeaveBalanceUpdate(0, 0, 0, 0, employeeBean.getEmployee_master_id());
			}
		
		}
		
		
		
	}

}
