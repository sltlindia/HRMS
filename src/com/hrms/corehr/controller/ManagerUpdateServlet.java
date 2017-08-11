package com.hrms.corehr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.corehr.dao.AllUpdateCoreHrDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.dao.AllListDAO;

public class ManagerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		AllListDAO allListDAO = new AllListDAO();
		List<EmployeeBean> listOfTask = allListDAO.getListOfEmployeeById(employee_master_id);
		for (EmployeeBean employeeBean : listOfTask) {
			 String manager_name = employeeBean.getFirstname() +" "+ employeeBean.getLastname();
			 int emp_code = employeeBean.getEmployee_code();
			 AllUpdateCoreHrDAO allUpdateCoreHrDAO = new AllUpdateCoreHrDAO();
				boolean result = allUpdateCoreHrDAO.managerUpdate(manager_name,manager_id,emp_code);
				if(result == true)
				{
					System.out.println("Manager successfully Inserted.");
					response.sendRedirect("addManager.jsp");
				}

		}
	}
}
