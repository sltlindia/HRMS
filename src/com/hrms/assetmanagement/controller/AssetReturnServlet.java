package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetAllocationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.dao.AllListAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class AssetReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			int asset_allocation_id = Integer.parseInt(request.getParameter("asset_allocation_id"));			 
			String status = "Return";
			AllListAssetDAO allListAssetDAO = new AllListAssetDAO();
		    AssetAllocationBean assetAllocationBean = allListAssetDAO.getListOfAssetAllocationById(asset_allocation_id);
			
		    int stock_master_id = assetAllocationBean.getStockMasterBean().getStock_master_id();
		    int allocation_quantity = assetAllocationBean.getQuantity();
		    
		    StockMasterBean stockMasterBean = allListAssetDAO.getListOfStockMasterById(stock_master_id);
		    
		    int stock_quantity = Integer.parseInt(stockMasterBean.getQuantity());
		    int sum = allocation_quantity + stock_quantity;
		    int supplier_sr_no_id = assetAllocationBean.getSupplierSrNoBean().getSupplier_sr_no_id();
		    
		    AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
		    
		    boolean result = allUpdateAssetDAO.assetAllocationStatusUpdate(asset_allocation_id, status);
		    boolean result1 = allUpdateAssetDAO.assetQuantityUpdate(stock_master_id, sum);
		    boolean result2 = allUpdateAssetDAO.supplierSrNoStatusUpdate(supplier_sr_no_id, status);
		    
		    request.getRequestDispatcher("assetTransfer.jsp").forward(request, response);
	    
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	

}