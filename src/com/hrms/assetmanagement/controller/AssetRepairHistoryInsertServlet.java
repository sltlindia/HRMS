package com.hrms.assetmanagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetAllocationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.AssetRepairHistoryBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class AssetRepairHistoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			int asset_allocation_id = Integer.parseInt(request.getParameter("asset_allocation_id"));
			int asset_master_id = Integer.parseInt(request.getParameter("asset_master_id"));
			String repairing_date = request.getParameter("repairing_date");
			String store = request.getParameter("store");
			String cost = request.getParameter("cost");
			String remark = request.getParameter("remark");
			
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = null;
			try {
				date = formater.parse(repairing_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repairing_date = formater1.format(date);
			
			
			AssetAllocationBean assetAllocationBean = new AssetAllocationBean();
			assetAllocationBean.setAsset_allocation_id(asset_allocation_id);
			
			AssetMasterBean assetMasterBean = new AssetMasterBean();
			assetMasterBean.setAsset_master_id(asset_master_id);
			
			AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
			AssetRepairHistoryBean assetRepairHistoryBean = new AssetRepairHistoryBean(repairing_date, cost, store, remark, assetAllocationBean, assetMasterBean);
			
			boolean result = allInsertAssetDAO.assetRepairHistoryInsert(assetRepairHistoryBean);
			request.getRequestDispatcher("assetTransfer.jsp").forward(request, response);
			
		}else{
			
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}