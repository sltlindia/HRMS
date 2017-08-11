package com.hrms.recruitement.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InterviewerPanelBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class AddInterviewerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		EmployeeBean employeeBean = new EmployeeBean();

		String interviewer_expertise = request.getParameter("expertise");
		System.out.println("expertise : " +interviewer_expertise);
		String interviewer_speciality = request.getParameter("speciality");
		System.out.println("speciality : " +interviewer_speciality);
		String interviewer = request.getParameter("interviewerName");
		
		String[] a = interviewer.split(",");
		int employee_master_id = Integer.parseInt(a[0]);
		String interviewer_name = a[1];
		
		System.out.println("employee_master_id : " +employee_master_id);
		System.out.println("interviewer_name : " +interviewer_name);
		
		/*String interviewer_name = request.getParameter("interviewer");
		System.out.println("interviewer_name : " +interviewer_name);*/
		
		employeeBean.setEmployee_master_id(employee_master_id);

		AllInsertDAO allInsertDAO = new AllInsertDAO();
		InterviewerPanelBean interviewerPanelBean = new InterviewerPanelBean(interviewer_name, interviewer_expertise, interviewer_speciality, employeeBean);
		boolean result = allInsertDAO.interviewerInsert(interviewerPanelBean);
		response.sendRedirect("hrHome.jsp");

	}

}
