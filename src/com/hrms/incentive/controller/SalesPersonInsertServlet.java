package com.hrms.incentive.controller;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class SalesPersonInsertServlet
 */
public class SalesPersonInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesPersonInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("employee_name");

		String[] split = value.split(",");
		int emp_code = Integer.parseInt(split[0]);
		String name = split[1];
		int other_manager_id = 0;
		String middleName = null;
				
		String[] splitName = name.split(" ");
		String firstName = splitName[0];
		String lastName = splitName[1];
		
		System.out.println("emp_code:"+emp_code);
		System.out.println("firstName:"+firstName);
		System.out.println("lastName:"+lastName);
		
		LoginDAO loginDAO = new LoginDAO();
		EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
		
		int emp_id = employeeBean1.getEmployee_master_id();
		firstName = employeeBean1.getFirstname();
		middleName = employeeBean1.getMiddlename();
		lastName = employeeBean1.getLastname();
		
		String designation = request.getParameter("designation");
		String alias = request.getParameter("alias");

		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(emp_id);

		SalespersonBean salespersonBean = new SalespersonBean(firstName, middleName, lastName, designation, alias,
				employeeBean);

		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();

		boolean result = allIncentiveInsertDAO.salesPersonInsert(salespersonBean);
	
		HttpSession session = request.getSession();
		session.setAttribute("incentiveMasterAction", "sales");
		session.setAttribute("success", "SuccessFully added");
		
		response.sendRedirect("incentiveMaster1.jsp");
	}

}
