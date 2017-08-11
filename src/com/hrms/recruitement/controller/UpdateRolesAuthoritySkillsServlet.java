package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.DepartmentDesignationBean;
import com.hrms.recruitement.bean.DesignationTemplateBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;


public class UpdateRolesAuthoritySkillsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int department_designation_id = Integer.parseInt(request.getParameter("department_designation_id"));
		int department_template_id = Integer.parseInt(request.getParameter("department_template_id"));
		
		DepartmentDesignationBean departmentDesignationBean = new DepartmentDesignationBean();
		departmentDesignationBean.setDepartment_designation_id(department_designation_id);
		System.out.println("department_designation_id"+department_designation_id);

		String roles_responsibility = request.getParameter("rolesResponsibility");
		String authority = request.getParameter("authority");
		String skills_knowledge = request.getParameter("skillsKnowledge");
		
		System.out.println("roles_responsibility"+roles_responsibility);
		System.out.println("authority"+authority);
		System.out.println("skills_knowledge"+skills_knowledge);


		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		DesignationTemplateBean designationTemplateBean = new DesignationTemplateBean(roles_responsibility, authority, skills_knowledge, departmentDesignationBean, department_template_id);
		boolean result = allUpdateDAO.addRolesAuthoritySkillsInsert(designationTemplateBean);
		
		if(result == true)
		{
			System.out.println("Roles Skills and autohirty successfully inserted");
			response.sendRedirect("departmentDesignationList.jsp");
		}
	
	}

}
