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

public class AssetEditDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			int asset_id = Integer.parseInt(request.getParameter("assetId"));
			String action = request.getParameter("action");
			boolean result = false;
			
			if(action.equalsIgnoreCase("edit")){
				String asset_name = request.getParameter("assetName");
				
				AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
				result = allUpdateAssetDAO.assetUpdate(asset_id, asset_name);
				
				System.out.println("updated...");

			}else if(action.equalsIgnoreCase("delete")){
			
				
				AllDeleteAssetDAO allDeleteAssetDAO = new AllDeleteAssetDAO();
				result = allDeleteAssetDAO.assetDelete(asset_id);
				boolean resultConfig = allDeleteAssetDAO.assetConfigurationDelete(asset_id);
				
			}
			
			request.getRequestDispatcher("addAsset.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	

}
