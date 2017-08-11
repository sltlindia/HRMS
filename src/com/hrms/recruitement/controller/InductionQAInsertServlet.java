package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InductionQABean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class InductionQAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String employee_name = request.getParameter("employeeName");
		int employee_master_id = Integer.parseInt(employee_name);
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_master_id);
		System.out.println("employee_master_id :" + employee_master_id);
		
		String induction_qa1 = request.getParameter("q1");
		System.out.println("induction_qa1"+ induction_qa1);
		
		String induction_qa2 = request.getParameter("q2");
		System.out.println("induction_qa2"+ induction_qa2);
		
		String induction_qa3 = request.getParameter("q3");
		System.out.println("induction_qa3"+ induction_qa3);
		
		String induction_qa4 = request.getParameter("q4");
		System.out.println("induction_qa4"+ induction_qa4);
		
		String induction_qa5 = request.getParameter("q5");
		System.out.println("induction_qa5"+ induction_qa5);
		
		String induction_qa6 = request.getParameter("q6");
		System.out.println("induction_qa6"+ induction_qa6);
		
		String induction_qa7 = request.getParameter("q7");
		System.out.println("induction_qa7"+ induction_qa7);
		
		String induction_qa8 = request.getParameter("q8");
		System.out.println("induction_qa8"+ induction_qa8);
		
		String induction_qa9 = request.getParameter("q9");
		System.out.println("induction_qa9"+ induction_qa9);
		
		String induction_qa10 = request.getParameter("q10");
		System.out.println("induction_qa10"+ induction_qa10);
		
		String induction_qa11 = request.getParameter("q11");
		System.out.println("induction_qa11"+ induction_qa11);
		
		String induction_qa12 = request.getParameter("q12");
		System.out.println("induction_qa12"+ induction_qa12);
		
		String induction_qa13 = request.getParameter("q13");
		System.out.println("induction_qa13"+ induction_qa13);
		
		String induction_qa14 = request.getParameter("q14");
		System.out.println("induction_qa14"+ induction_qa14);
	
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		InductionQABean inductionQABean = new InductionQABean(employeeBean, induction_qa1, induction_qa2, induction_qa3, induction_qa4, induction_qa5, induction_qa6, induction_qa7, induction_qa8, induction_qa9, induction_qa10, induction_qa11, induction_qa12, induction_qa13, induction_qa14);
		boolean result = allInsertDAO.inductionQAInsert(inductionQABean);
		response.sendRedirect("hrHome.jsp");
	}

}
