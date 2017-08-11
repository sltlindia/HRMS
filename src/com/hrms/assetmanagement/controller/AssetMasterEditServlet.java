package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

public class AssetMasterEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			String asset_name = request.getParameter("asset_name");
			System.out.println("name:"+asset_name);
			int asset_master_id = Integer.parseInt(request.getParameter("asset_master_id"));
			System.out.println("asset_master_id:"+asset_master_id);
			
			AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
			AssetMasterBean assetMasterBean = new AssetMasterBean(asset_master_id, asset_name); 
			
			boolean result = allUpdateAssetDAO.assetUpdate(assetMasterBean);
			request.getRequestDispatcher("addAsset.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	
	}

}
