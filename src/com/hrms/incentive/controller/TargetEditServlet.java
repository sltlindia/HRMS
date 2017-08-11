package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

/**
 * Servlet implementation class TargetEditServlet
 */
public class TargetEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			int sales_target_id = Integer.parseInt(request.getParameter("sales_target_id"));
			int month_id  = Integer.parseInt(request.getParameter("month_id"));
			int year_id = Integer.parseInt(request.getParameter("year_id"));
			int sales_id = Integer.parseInt(request.getParameter("sales"));
			int product_id = Integer.parseInt(request.getParameter("product"));
	
			String target_value = request.getParameter("target");
	
		

			MonthBean monthBean = new MonthBean();
			monthBean.setMonth_id(month_id);
			
			YearBean yearBean = new YearBean();
			yearBean.setYear_id(year_id);
			
			SalespersonBean salespersonBean = new SalespersonBean();
			salespersonBean.setSales_person_id(sales_id);
		
			ProductMasterBean productMasterBean = new ProductMasterBean();
			productMasterBean.setProduct_master_id(product_id);
			
			
			TargetBean targetBean = new TargetBean(sales_target_id,target_value, monthBean, yearBean, salespersonBean, productMasterBean);
			AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
			boolean result = allIncentiveUpdateDAO.salesTrgetUpdate(targetBean);
			
			
			request.getRequestDispatcher("targetSales.jsp").forward(request, response);
				
				
			
	}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	}

}
