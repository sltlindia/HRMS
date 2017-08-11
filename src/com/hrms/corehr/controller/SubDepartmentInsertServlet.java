package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.bean.SubDepartmentBean;
import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.recruitement.bean.CompanyListBean;


public class SubDepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sub_department_name = request.getParameter("sub_department_name");
		
		AllInsertCoreHrDAO allInsertCoreHrDAO = new AllInsertCoreHrDAO();
		SubDepartmentBean subDepartmentBean = new SubDepartmentBean(sub_department_name);
		boolean result = allInsertCoreHrDAO.addSubDepartment(subDepartmentBean);
		if(result == true)
		{
			System.out.println("Sub Deparment successfully Inserted.");
			response.sendRedirect("addSubDepartment.jsp");
		}
	
	}

}
