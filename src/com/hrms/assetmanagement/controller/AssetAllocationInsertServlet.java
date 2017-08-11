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
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.bean.SupplierSrNoBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class AssetAllocationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			
			int asset_quantity = Integer.parseInt(request.getParameter("asset_quantity"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int stock_id = Integer.parseInt(request.getParameter("stock_id"));
			String sltl_sr_no = request.getParameter("sltl_sr_no");
			int supplier_sr_no_id = Integer.parseInt(request.getParameter("supplire_sr_no"));
			String model_no = request.getParameter("model_no");
			String issue_date = request.getParameter("issue_date");
			String remark = request.getParameter("remark");
			String location = request.getParameter("location");
			
			String status = "Allocated";
			
			SupplierSrNoBean supplierSrNoBean = new SupplierSrNoBean();
			supplierSrNoBean.setSupplier_sr_no_id(supplier_sr_no_id);
			
			int assets = asset_quantity - quantity;
			
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = null;
			try {
				date = formater.parse(issue_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			issue_date = formater1.format(date);
			
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
			
			StockMasterBean stockMasterBean = new StockMasterBean();
			stockMasterBean.setStock_master_id(stock_id);
			
			AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
			AssetAllocationBean assetAllocationBean = new AssetAllocationBean(sltl_sr_no, issue_date, quantity, status, remark, location, stockMasterBean, employeeBean, supplierSrNoBean);
			
			boolean result = allInsertAssetDAO.allocatioInsert(assetAllocationBean);
			
			AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
			boolean result1 = allUpdateAssetDAO.stockQuantityUpdate(stock_id,assets);
			boolean result2 = allUpdateAssetDAO.supplierSrNoStatusUpdate(supplier_sr_no_id, status);
			
			request.getRequestDispatcher("assetAllocation.jsp").forward(request, response);
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}