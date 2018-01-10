package com.hrms.tds.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSDocumentUploadBean;
import com.hrms.tds.dao.TDSInsertDAO;

public class TDSDocumentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonthBean monthBean;
       
    public TDSDocumentInsertServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int employee_master_id = 0;
    	HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
			employee_master_id = user.getEmployee_master_id();
		}
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_master_id);
		String filePath = getServletContext().getInitParameter("tds-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("shruti");

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String fileName = null;
			String month_name = null;
			File attachment = null;
			String attachment_name = null;
			String value = null;
			String id = null;
			int month_id = 0;
			int year = 0;
			int tds_id = 0;
			int attachment_priority = 0;
			double amount = 0.0;
			MonthBean monthBean = null;
			TDSBean tdsBean = null;
			String output = null;
			Calendar currentDate = Calendar.getInstance();
			year = currentDate.get(Calendar.YEAR);
			System.out.println("YEAR :"+year);
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
						if(fieldName.equalsIgnoreCase("monthName")) {
							month_name = fieldValue;
							month_id = Integer.parseInt(month_name);
							System.out.println("Month Id :"+ month_id);
							monthBean = new MonthBean();
							monthBean.setMonth_id(month_id);
						}
						
						if(fieldName.equalsIgnoreCase("attachment_name")) {
							attachment_name = fieldValue;
							output = attachment_name;
							System.out.println("Attachment Name :"+attachment_name);
						}
						
						if(fieldName.equalsIgnoreCase("attachment_priority")) {
							attachment_priority = Integer.parseInt(fieldValue);
							System.out.println("Attachment Priority :"+attachment_priority);
						}
						
						if(fieldName.equalsIgnoreCase("amount")) {
							value = fieldValue;
							 amount = Double.parseDouble(value);
							System.out.println("Amount :"+amount);
						}
						
						if(fieldName.equalsIgnoreCase("tds_id")) {
							id = fieldValue;
							tds_id = Integer.parseInt(id);
							System.out.println("TDS ID:"+tds_id);
							tdsBean = new TDSBean();
							tdsBean.setTds_id(tds_id);
						}
						
					
				}else {
					String document_name = null;
					String uploadAttachment = null;
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					/*String appPath = context.getRealPath("\\")+("\\WebContent\\upload\\CriteriaAttachment");
					System.out.println("appPath : "+appPath);*/
					
					attachment = new File(filePath + File.separator + fileName);
					System.out.println("filePath:"+attachment);

					try {

						if (fileName.isEmpty()) {
							
						} else {
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(attachment);
								System.out.println("===> "+attachment.getName());

								uploadAttachment = attachment.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("uploadAttachment", attachment.getName());
								System.out.println("Document:"+uploadAttachment);
								String status = "Uploaded";
								TDSDocumentUploadBean documentUploadBean = new TDSDocumentUploadBean(uploadAttachment, attachment_name, amount, status, attachment_priority, year, monthBean, tdsBean, employeeBean);
								TDSInsertDAO insertDAO = new TDSInsertDAO();
								boolean result = insertDAO.tdsDocumentInsert(documentUploadBean);
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
			
			
			
	
	
    }

}
