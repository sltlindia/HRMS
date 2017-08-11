package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class AssetInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			String asset_name = request.getParameter("asset_name");
			AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
			
			AssetMasterBean assetMasterBean = new AssetMasterBean(asset_name);
			boolean result = allInsertAssetDAO.addAsset(assetMasterBean);
			request.getRequestDispatcher("addAsset.jsp").forward(request, response);
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}