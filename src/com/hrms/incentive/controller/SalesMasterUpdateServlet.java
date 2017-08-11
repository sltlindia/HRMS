package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class SalesMasterUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalesMasterUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			int sales_person_id = Integer.parseInt(request.getParameter("sales_person_id"));
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			String last_name = request.getParameter("last_name");
			String designation = request.getParameter("designation");
			String alias = request.getParameter("alias");
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(emp_id);
		
			System.out.println("emp_id:"+emp_id);
			
			SalespersonBean salespersonBean = new SalespersonBean(sales_person_id, first_name, middle_name, last_name, designation, alias,employeeBean);
			AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
			boolean result = allIncentiveUpdateDAO.salesUpdate(salespersonBean);
			
			request.getRequestDispatcher("incentiveMaster1.jsp").forward(request, response);
				
				
	
	}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


}
}