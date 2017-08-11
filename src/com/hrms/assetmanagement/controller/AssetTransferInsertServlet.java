package com.hrms.assetmanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.AssetAllocationBean;
import com.hrms.assetmanagement.bean.AssetTransferHistoryBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class AssetTransferInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			int transfer_from = Integer.parseInt(request.getParameter("transfer_from"));
			String issue_date = request.getParameter("issue_date");
			int asset_allocation_id = Integer.parseInt(request.getParameter("asset_allocation_id"));
			String asset_transfer_from_location = request.getParameter("transfer_from_location");
			String asset_transfer_to_location = request.getParameter("transfer_to_location");
			
			
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String transfer_date = formater.format(date);
			
			
			String value = request.getParameter("employee_name");

			String[] split = value.split(",");
			int emp_code = Integer.parseInt(split[0]);
			String name = split[1];
			
			String[] splitName = name.split(" ");
			String firstName = splitName[0];
			String lastName = splitName[1];
			
			System.out.println("emp_code:"+emp_code);
			System.out.println("firstName:"+firstName);
			System.out.println("lastName:"+lastName);
			
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
			
			int emp_id = employeeBean1.getEmployee_master_id();
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(emp_id);
			
			AssetAllocationBean assetAllocationBean = new AssetAllocationBean();
			assetAllocationBean.setAsset_allocation_id(asset_allocation_id);
			
			System.out.println("transfer_from:"+transfer_from);
			System.out.println("issue_date:"+issue_date);
			System.out.println("asset_allocation_id:"+asset_allocation_id);
			System.out.println("transfer_date:"+transfer_date);
			System.out.println("emp_id:"+asset_allocation_id);
			
			
			AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
			AssetTransferHistoryBean assetTransferHistoryBean = new AssetTransferHistoryBean(issue_date, transfer_date, transfer_from, asset_transfer_from_location, asset_transfer_to_location, employeeBean, assetAllocationBean);
			
			boolean result = allInsertAssetDAO.assetTransferHistoryInsert(assetTransferHistoryBean);
			System.out.println("Inserted...");
			
			
			AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
			boolean result1 = allUpdateAssetDAO.assetTransferDetailUpdate(asset_allocation_id, emp_id, issue_date, asset_transfer_to_location);
			System.out.println("Updated...");
			
			request.getRequestDispatcher("assetTransfer.jsp").forward(request, response);
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}