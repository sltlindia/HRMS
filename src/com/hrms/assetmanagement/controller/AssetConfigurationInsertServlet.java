package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class AssetConfigurationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		int asset_id = Integer.parseInt(request.getParameter("asset_id"));
		String configuration = request.getParameter("configuration");
		
		AssetMasterBean assetMasterBean = new AssetMasterBean();
		assetMasterBean.setAsset_master_id(asset_id);
		
		AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
		
		AssetConfigurationBean assetConfigurationBean = new AssetConfigurationBean(configuration, assetMasterBean);
		boolean result = allInsertAssetDAO.configurationInsert(assetConfigurationBean);
		
		request.getRequestDispatcher("addConfiguration.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}