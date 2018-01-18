package com.hrms.appAuthority.controller;

import java.util.List;

import com.hrms.appAuthority.bean.AppAuthorityBean;
import com.hrms.appAuthority.bean.UserBean;
import com.hrms.appAuthority.dao.AllInsertAppDAO;
import com.hrms.appAuthority.dao.AllListAppDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class authortyInsert {

	
	public static void main(String[] args) {
		
		LoginDAO loginDAO = new LoginDAO();
		
		List<EmployeeBean> listOfEmployee = loginDAO.getListOfEmployee();
		AllListAppDAO  allListAppDAO = new AllListAppDAO();
		AllInsertAppDAO allInsertAppDAO = new AllInsertAppDAO();
		for(EmployeeBean employeeBean :listOfEmployee) {
			int emp_id = employeeBean.getEmployee_master_id();
			employeeBean.setEmployee_master_id(emp_id);
			
			AppAuthorityBean appAuthorityBean = allListAppDAO.checkAuthority(emp_id);
			AppAuthorityBean appAuthorityBean2 = new AppAuthorityBean(0, employeeBean);
			
			if(appAuthorityBean == null) {
				allInsertAppDAO.appAuthority(appAuthorityBean2);
			}
			
			
		}
		
	}
	
}
