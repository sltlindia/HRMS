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
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleDocumentAttachmentBean;
import com.hrms.vehicletracking.bean.VehicleDocumentBean;
import com.hrms.vehicletracking.dao.AllInsertVtsDAO;
import com.hrms.vehicletracking.dao.AllListVtsDAO;

/**
 * Servlet implementation class VehicleDocumentInsertServlet
 */
public class VehicleDocumentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user =(EmployeeBean)session.getAttribute("user");
		if(user != null){
			
			
			String filePath = request.getServletContext().getInitParameter("vehicle_tracking");
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
			 int vehicle_master_id = 0;
			 int vehicle_document_id = 0;
			 int vehicle_document_attachment_id = 0;
			 String document_name = null;
			 int id = user.getEmployee_master_id();
			 String document = "document";
			 String vehicle_folder = null;
			 
			 EmployeeBean employeeBean = new EmployeeBean();
			 employeeBean.setEmployee_master_id(id);
				
			
			 VehicleDocumentBean vehicleDocumentBean = new VehicleDocumentBean();
			VehicleBean vehicleBean = new VehicleBean();
			AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
			AllInsertVtsDAO allInsertVtsDAO = new AllInsertVtsDAO();
			VehicleBean vehicleBean2 = null;
			/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			date_of_submission = dateFormat.format(date);
*/
			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("vehicle_master_id")) {
							String value = fieldValue;
							vehicle_master_id = Integer.parseInt(value);
							vehicleBean.setVehicle_master_id(vehicle_master_id);
							System.out.println("vehicle_master_id:"+vehicle_master_id);
							vehicleBean2 = allListVtsDAO.getVehicleDetailsById(vehicle_master_id);
							vehicle_folder = vehicleBean2.getVehicle_name()+"_"+vehicleBean2.getVehicle_no();
						}
						
						if (fieldName.equalsIgnoreCase("document_name")) {
							document_name = fieldValue;
							System.out.println("document_name:"+document_name);
							VehicleDocumentBean vehicleDocumentBean1 = new VehicleDocumentBean(document_name, vehicleBean);
							allInsertVtsDAO.vehicleDocumentInsert(vehicleDocumentBean1);
							vehicle_document_id = vehicleDocumentBean1.getVehicle_document_id();
							vehicleDocumentBean.setVehicle_document_id(vehicle_document_id);
						}
				
						
						if (fieldName.equalsIgnoreCase("redirect")) {
							request.getRequestDispatcher("vehicleDocumentList.jsp").forward(request, response);
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
								+ vehicle_folder + File.separator + document + File.separator + fileName);
						System.out.println("filePath:"+file);

						try {

							if (fileName.isEmpty()) {
								
								VehicleDocumentAttachmentBean vehicleDocumentAttachmentBean = new VehicleDocumentAttachmentBean(attachment, vehicleDocumentBean);
								
							} else if(fieldName.equalsIgnoreCase("attachment")){
								System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									System.out.println("photo uploaded");
									
									VehicleDocumentAttachmentBean vehicleDocumentAttachmentBean = new VehicleDocumentAttachmentBean(attachment, vehicleDocumentBean);
									boolean result = allInsertVtsDAO.vehicleDocumentAttachmentInsert(vehicleDocumentAttachmentBean);
									
									
									
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



