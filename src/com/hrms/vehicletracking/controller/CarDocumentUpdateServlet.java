package com.hrms.vehicletracking.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehiclePolicyDocumentBean;
import com.hrms.vehicletracking.dao.AllInsertVtsDAO;
import com.hrms.vehicletracking.dao.AllListVtsDAO;

/**
 * Servlet implementation class CarDocumentUpdateServlet
 */
public class CarDocumentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		EmployeeBean user =(EmployeeBean)session.getAttribute("user");
		if(user != null){
			
			
			String filePath= request.getServletContext().getInitParameter("vehicle_tracking");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = response.getWriter();
			
			 List<FileItem> items = null;
			 String fieldName = null;
			 String fieldValue = null;
			 String fileName = null;
			 File file = null;
			 String description = null;
			 String attachment ="-";
			 int vehicle_id = 0;
			 String registered_no = null;
			 String policyNo = null;
			 String amount = null;
			 String fromDate = null;
			 String toDate = null;
			 int id = user.getEmployee_master_id();
			 int vehicle_policy_document_id = 0;
			 String date_of_submission = null;
			 String insurance = "insurance";
			 EmployeeBean employeeBean = new EmployeeBean();
			 employeeBean.setEmployee_master_id(id);
				
			VehicleBean vehicleBean = new VehicleBean();
			VehicleBean vehicleBean2 = null;
			AllInsertVtsDAO allInsertVtsDAO = new AllInsertVtsDAO();
			AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			date_of_submission = dateFormat.format(date);

			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("vehicle_policy_document_id")) {
							String value = fieldValue;
							vehicle_policy_document_id = Integer.parseInt(value);
							System.out.println("vehicle_policy_document_id:"+vehicle_policy_document_id);
						}
						if (fieldName.equalsIgnoreCase("vehicle_master_id")) {
							String value = fieldValue;
							vehicle_id = Integer.parseInt(value);
							System.out.println("vehicle_master_id:"+vehicle_id);
							vehicleBean.setVehicle_master_id(vehicle_id);
							vehicleBean2 = allListVtsDAO.getVehicleDetailsById(vehicle_id);
						}
						if (fieldName.equalsIgnoreCase("registered_no")) {
							registered_no = fieldValue;
							System.out.println("registered_no:"+registered_no);
						}
						if (fieldName.equalsIgnoreCase("description")) {
							description = fieldValue;
							System.out.println("description:"+description);
						}
						if (fieldName.equalsIgnoreCase("policyNo")) {
							policyNo = fieldValue;
							System.out.println("policyNo:"+policyNo);
						}
				
						if (fieldName.equalsIgnoreCase("amount")) {
							amount = fieldValue;
							System.out.println("amount:"+amount);
						}
				
						if (fieldName.equalsIgnoreCase("fromDate")) {
							fromDate = fieldValue;
							System.out.println("fromDate:"+fromDate);
						}
				
						if (fieldName.equalsIgnoreCase("toDate")) {
							toDate = fieldValue;
							System.out.println("toDate:"+toDate);
						}
				
						if (fieldName.equalsIgnoreCase("redirect")) {
							request.getRequestDispatcher("carDocumentList.jsp").forward(request, response);
						}
						
					}else {
						fieldName = item.getFieldName();
						System.out.println("FieldName : "+fieldName);
						fileName = item.getName();
						System.out.println("File Name : "+fileName);
						
						fileName = fileName.substring(
								fileName.lastIndexOf("\\") + 1,
								fileName.length());
						System.out.println("File Name 1 : "+fileName);
						
						ServletContext context = getServletContext();
						String appPath = context.getRealPath("\\")+("WebContent\\upload");
						System.out.println("appPath : "+appPath);
						
						
						
						
						file = new File(filePath + File.separator
								+vehicleBean2.getVehicle_name()+"_"+vehicleBean2.getVehicle_no() + File.separator + insurance + File.separator + fileName);
						System.out.println("filePath:"+file);

						try {

							if (fileName.isEmpty()) {
								
								VehiclePolicyDocumentBean vehiclePolicyDocumentBean = new VehiclePolicyDocumentBean(vehicle_policy_document_id,registered_no, description, fromDate, toDate, attachment,amount,policyNo, vehicleBean);
								boolean result = allInsertVtsDAO.vehiclePolicyDocumentInsert(vehiclePolicyDocumentBean);
								
								
								
							} else if(fieldName.equalsIgnoreCase("attachment")){
								System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									System.out.println("photo uploaded");
									VehiclePolicyDocumentBean vehiclePolicyDocumentBean = new VehiclePolicyDocumentBean(vehicle_policy_document_id,registered_no, description, fromDate, toDate, attachment,amount,policyNo, vehicleBean);
									boolean result = allInsertVtsDAO.vehiclePolicyDocumentInsert(vehiclePolicyDocumentBean);
									
									
									
							}
						} catch (Exception e) {
							e.printStackTrace();
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
