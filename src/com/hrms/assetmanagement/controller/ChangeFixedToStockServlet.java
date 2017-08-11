package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class ChangeFixedToStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int stock_master_id = Integer.parseInt(request.getParameter("stock_master_id"));
			int fixed_asset_or_not = 0;
			
			AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
			boolean result = allUpdateAssetDAO.fixedToStockUpdate(fixed_asset_or_not, stock_master_id);
			
			if(result == true){
				
				request.getRequestDispatcher("stockList.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}