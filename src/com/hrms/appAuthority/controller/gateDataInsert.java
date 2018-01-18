package com.hrms.appAuthority.controller;

import java.util.List;

import com.hrms.appAuthority.bean.AppAuthorityBean;
import com.hrms.appAuthority.bean.UserBean;
import com.hrms.appAuthority.dao.AllInsertAppDAO;
import com.hrms.appAuthority.dao.AllListAppDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class gateDataInsert {

	
public static void main(String[] args) {
		
	AllListAppDAO  allListAppDAO = new AllListAppDAO();
		List<AppAuthorityBean> listOfEmployee = allListAppDAO.getAllListOfGateAuthority();
		
		AllInsertAppDAO allInsertAppDAO = new AllInsertAppDAO();
		for(AppAuthorityBean aub :listOfEmployee) {
			int emp_id = aub.getEmployeeBean().getEmployee_master_id();
			String usre_name = aub.getEmployeeBean().getFirstname()+" "+aub.getEmployeeBean().getLastname();
			String cardential = String.valueOf(aub.getEmployeeBean().getEmployee_code());
			String password = aub.getEmployeeBean().getPassword();
			int manager_id = aub.getEmployeeBean().getManagerBean().getManager_id();
			int under_manager_id = Integer.parseInt(aub.getEmployeeBean().getUnder_manager_id());
			String email = aub.getEmployeeBean().getEmail_id();
			
			
			UserBean userBean = allListAppDAO.checkData(emp_id);
			UserBean userBean2 = new UserBean(usre_name, cardential, password, "-", "-", 0, "-", emp_id, manager_id, under_manager_id,email);
			if(userBean == null) {
				allInsertAppDAO.userInsert(userBean2);
			}
			
			
			
		}
		
	}
	
}
