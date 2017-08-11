package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class StatusChangeOfSrNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int supplier_sr_no_id = Integer.parseInt(request.getParameter("supplier_sr_no_id"));
			String status = "Scrap";
			
			AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
			boolean result = allUpdateAssetDAO.statusUpdate(supplier_sr_no_id, status);
			
			if(result == true){
				
				request.getRequestDispatcher("assetTransfer.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}