package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.dao.AllDeleteAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class ConfigurationEditDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			int config_id = Integer.parseInt(request.getParameter("config_id"));
			String action = request.getParameter("action");
			boolean result = false;
			
			if(action.equalsIgnoreCase("edit")){
				String config_name = request.getParameter("configName");
				
				AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
				result = allUpdateAssetDAO.configUpdate(config_id, config_name);
				
				System.out.println("updated...");

			}else if(action.equalsIgnoreCase("delete")){
			
				AllDeleteAssetDAO allDeleteAssetDAO = new AllDeleteAssetDAO();
				result = allDeleteAssetDAO.configDelete(config_id);
				
			}
			
			request.getRequestDispatcher("addConfiguration.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	

}