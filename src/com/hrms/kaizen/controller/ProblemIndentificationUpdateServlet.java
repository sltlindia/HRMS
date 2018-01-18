package com.hrms.kaizen.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.bean.KaizenProblemIdentificationBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class ProblemIndentificationUpdateServlet
 */
public class ProblemIndentificationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String problem = request.getParameter("description");
		String category = request.getParameter("category");
		String parseDate = request.getParameter("date");
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		
		
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(emp_id);
		
		AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
		KaizenProblemIdentificationBean kaizenProblemIdentificationBean = new KaizenProblemIdentificationBean(p_id,problem, category, employeeBean,parseDate);
		boolean result = allKaizenInsertDAO.kaizenProblemInsert(kaizenProblemIdentificationBean);
		
		response.sendRedirect("kaizenProblemIdentification.jsp");
	
	}

}
