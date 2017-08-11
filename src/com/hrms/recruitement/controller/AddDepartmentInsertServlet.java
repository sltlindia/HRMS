package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class AddDepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String department_name = request.getParameter("department");
	System.out.println("department : "+department_name);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	DepartmentBean departmentBean = new DepartmentBean(department_name);
	boolean result  = allInsertDAO.addDepartmentInsert(departmentBean);
	if (result == true)
	{
		response.sendRedirect("addDepartment.jsp");
		System.out.println("Department successfully inserted");
	}
	
	}

}
