package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllUpdateCoreHrDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.recruitement.dao.AllInsertDAO;

/**
 * Servlet implementation class UpdateDepartmentServlet
 */
public class DepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String department_name = request.getParameter("department_name");
		int department_id = Integer.parseInt(request.getParameter("department_id")) ;
		System.out.println("department : "+department_name);
		
		AllUpdateCoreHrDAO allUpdateCoreHrDAO = new AllUpdateCoreHrDAO();
		boolean result  = allUpdateCoreHrDAO.departmentUpdate(department_name, department_id);
		if (result == true)
		{
			response.sendRedirect("addDepartment.jsp");
			System.out.println("Department successfully inserted");
		}
		
	
	}

}
