package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;

public class ProductMasterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductMasterInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String product_name = request.getParameter("productName");
		String machine_category = request.getParameter("product");
		
		ProductMasterBean productMasterBean = new ProductMasterBean(product_name, machine_category);
		
		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();
		boolean result = allIncentiveInsertDAO.productMasterInsert(productMasterBean);
		
		HttpSession session = request.getSession();
		session.setAttribute("incentiveMasterAction", "product");
		session.setAttribute("success", "SuccessFully added");
		
		response.sendRedirect("incentiveMaster1.jsp");
		}

}
