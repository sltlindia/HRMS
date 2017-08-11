package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.bean.DepartmentDesignationBean;


public class AddDesignationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String designation_name =request.getParameter("designation");
		System.out.println("designation"+ designation_name);
		
		
		int department_id = Integer.parseInt(request.getParameter("existingDepartment"));
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartment_id(department_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		DepartmentDesignationBean departmentDesignationBean = new DepartmentDesignationBean(designation_name, departmentBean);
		boolean result = allInsertDAO.addDesignationInsert(departmentDesignationBean);
		
		if(result == true)
		{
			System.out.println("Designation successfully Inserted.");
			response.sendRedirect("addDesignation.jsp");
		}
	
	}

}
