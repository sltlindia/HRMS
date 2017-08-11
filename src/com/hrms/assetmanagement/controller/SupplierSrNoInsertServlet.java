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
import com.hrms.assetmanagement.bean.SupplierSrNoBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;

public class SupplierSrNoInsertServlet extends HttpServlet {
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
				
				
				
				
				int stock_master_id = 0;
				int fixOrNot = 0;
				String supplier_sr_no= "null";
				String status = "Not Allocated";
				
				StockMasterBean stockMasterBean = new StockMasterBean();
				AssetConfigurationBean assetConfigurationBean = new AssetConfigurationBean();
				AssetMasterBean assetMasterBean = new AssetMasterBean(); 
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				
				
				AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							
							if (fieldName.equalsIgnoreCase("stock_master_id")) {
								String value = fieldValue;
								stock_master_id = Integer.parseInt(value);
								System.out.println("stock_master_id"+stock_master_id);
								stockMasterBean.setStock_master_id(stock_master_id);
							}
							
							
							if (fieldName.equalsIgnoreCase("fixedOrNot")) {
								String value = fieldValue;
								fixOrNot = Integer.parseInt(value);
								System.out.println("fixOrNot"+fixOrNot);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("supplier_sr_no")) {
								supplier_sr_no = fieldValue;
								System.out.println("supplier_sr_no:"+supplier_sr_no);
								
								SupplierSrNoBean supplierSrNoBean = null;
								
								if(stock_master_id != 0){
									 supplierSrNoBean = new SupplierSrNoBean(supplier_sr_no, status, stockMasterBean);
								}
								
								allInsertAssetDAO.supplierSrNoInsert(supplierSrNoBean);
								
								
							}	
						
							if (fieldName.equalsIgnoreCase("redirect")) {
								
								if(fixOrNot == 0){
									request.getRequestDispatcher("assetAllocation.jsp").forward(request, response);
								}else{
									request.getRequestDispatcher("stockList.jsp").forward(request, response);
								}
								
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