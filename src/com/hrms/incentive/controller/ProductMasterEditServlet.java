package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class ProductMasterEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductMasterEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			
			
			int prod_new_id = Integer.parseInt(request.getParameter("prod_new_id"));
			String prod_name = request.getParameter("prod_name");
			String category = request.getParameter("category");
	
			ProductMasterBean productMasterBean = new ProductMasterBean(prod_new_id, prod_name, category);
			AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
			
			boolean result = allIncentiveUpdateDAO.productUpdate(productMasterBean);
			
			
			request.getRequestDispatcher("incentiveMaster1.jsp").forward(request, response);
				
				
			
	}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	}

}