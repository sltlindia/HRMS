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
public class SubDepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int sub_department_id = Integer.parseInt(request.getParameter("sub_department_id"));
		String sub_department_name = request.getParameter("sub_department_name") ;
		
		System.out.println("sub_department_name : "+sub_department_name);
		System.out.println("sub_department_id : "+sub_department_id);
		
		AllUpdateCoreHrDAO allUpdateCoreHrDAO = new AllUpdateCoreHrDAO();
		boolean result  = allUpdateCoreHrDAO.subDepartmentUpdate(sub_department_name, sub_department_id);
		if (result == true)
		{
			/*response.sendRedirect("addSubDepartment.jsp");*/
			System.out.println("Department successfully updated");
		}
		
	
	}

}
