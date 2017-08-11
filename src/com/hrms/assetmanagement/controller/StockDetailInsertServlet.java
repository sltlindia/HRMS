package com.hrms.assetmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.StockConfigurationBean;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewScoreBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.exitformality.dao.AllUpdateExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;

public class StockDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			String filePath = 
		             getServletContext().getInitParameter("file-upload"); 
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			 List<FileItem> items = null;
				String fieldName = null;
				String fieldValue = null;
				String fileName = null;
				File file = null;
				
				
				
				
				int asset_id = 0;
				int configuration_id = 0;
				String quantity = "null";
				String make = "null";
				String issue_date = "null";
				String store_name = "null";
				String configuration_detail = "null";
				String model_no = "null";
				String life_time = "null";
				int fixed = 0 ;  // 0 means STOCK, 1 means FIX IT ASSET
				
				StockMasterBean stockMasterBean = null;
				int stock_master_id = 0;
				AssetConfigurationBean assetConfigurationBean = new AssetConfigurationBean();
				AssetMasterBean assetMasterBean = new AssetMasterBean(); 
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				
				AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
				ExitInterviewEmployeeBean exitInterviewEmployeeBean = new ExitInterviewEmployeeBean();
				EmployeeBean employeeBean = new EmployeeBean();
				AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							
							if (fieldName.equalsIgnoreCase("asset")) {
								String value = fieldValue;
								asset_id = Integer.parseInt(value);
								System.out.println("asset:"+asset_id);
								assetMasterBean.setAsset_master_id(asset_id);
							}
							
							if (fieldName.equalsIgnoreCase("life_time")) {
								life_time = fieldValue;
								System.out.println("life_time:"+life_time);
							}
														
							if (fieldName.equalsIgnoreCase("quantity")) {
								quantity = fieldValue;
								System.out.println("quantity:"+quantity);
							}
							
							if (fieldName.equalsIgnoreCase("make")) {
								make = fieldValue;
								System.out.println("make:"+make);
							}
							
							if (fieldName.equalsIgnoreCase("model_no")) {
								model_no = fieldValue;
								System.out.println("make:"+model_no);
							}
							
							if (fieldName.equalsIgnoreCase("issue_date")) {
								issue_date = fieldValue;
								Date date = null;
								try {
									date = formater.parse(issue_date);
								} catch (ParseException e) {
									
									e.printStackTrace();
								}
								issue_date = formater1.format(date);
								System.out.println("issue_date:"+issue_date);
							}
							
							
							if (fieldName.equalsIgnoreCase("store_name")) {
								store_name = fieldValue;
								System.out.println("store_name:"+store_name);
							}
							
							if (fieldName.equalsIgnoreCase("fixed")) {
								String value = fieldValue;
								fixed = Integer.parseInt(value);
								System.out.println("fixed:"+fixed);
							}
							
							
							if (fieldName.equalsIgnoreCase("stockDetail")) {
								
								System.out.println("stockDetail");
								
								
								
								stockMasterBean =  new StockMasterBean(make, quantity, issue_date, store_name, model_no, life_time, fixed, assetMasterBean);
								allInsertAssetDAO.stockInsert(stockMasterBean);
								stock_master_id = stockMasterBean.getStock_master_id(); 
								quantity = stockMasterBean.getQuantity();
								
							}
							
														
							
							if (fieldName.equalsIgnoreCase("configuration_id")) {
								String value = fieldValue;
								configuration_id = Integer.parseInt(value);
								System.out.println("configuration_id:"+configuration_id);
								assetConfigurationBean.setAsset_configuration_id(configuration_id);
							}
	
							
							if (fieldName.equalsIgnoreCase("configuration_detail")) {
								configuration_detail = fieldValue;
								System.out.println("configuration_detail:"+configuration_detail);
								
								
								stockMasterBean.setStock_master_id(stock_master_id);
								if(!configuration_detail.equalsIgnoreCase("")){
								StockConfigurationBean stockConfigurationBean = new StockConfigurationBean(configuration_detail, assetConfigurationBean, stockMasterBean);
								allInsertAssetDAO.stockConfigurationInsert(stockConfigurationBean);
								}
								
								
							}
							
							
							
							
							if (fieldName.equalsIgnoreCase("redirect")) 
							{
								request.setAttribute("stock_master_id", stock_master_id);
								request.setAttribute("quantity", quantity);
								request.setAttribute("fixedOrNot", fixed);
								request.getRequestDispatcher("addSupplierSrNo.jsp").forward(request, response);
							}	
						
						
					}
						
				}
						
			} catch (FileUploadException e) {
							e.printStackTrace();
			}
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
