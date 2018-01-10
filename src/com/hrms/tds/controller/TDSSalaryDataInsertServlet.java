package com.hrms.tds.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

public class TDSSalaryDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filePath = getServletContext().getInitParameter("tdsSalary-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String uploadAttachment = null;
			File file = null;
			String fileName = null;
			String month = null;
			int month_id = 0;
			int year_id = 0;
			String year = null;
			String documentType = null;
			MonthBean monthBean = null;
			YearBean yearBean = null;

			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
						if(fieldName.equalsIgnoreCase("month")) {
							month = fieldValue;
							month_id = Integer.parseInt(month);
							System.out.println("Month Id :"+ month_id);
							monthBean = new MonthBean();
							monthBean.setMonth_id(month_id);
						}
						
						if(fieldName.equalsIgnoreCase("year")) {
							year = fieldValue;
							year_id = Integer.parseInt(year);
							System.err.println("YEAR :"+year);
							yearBean = new YearBean();
							yearBean.setYear_id(year_id);
						}
						
						if(fieldName.equalsIgnoreCase("documentType")) {
							documentType = fieldValue;
							System.err.println("Type :"+documentType);
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
					//String appPath = context.getRealPath("\\")+("\\WebContent\\upload\\CriteriaAttachment");
					//System.out.println("appPath : "+appPath);
					
					
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							
						} else if(fieldName.equalsIgnoreCase("uploadTDSSalaryData")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+fileName);

								uploadAttachment = file.getName();
								
								System.out.println("Document uploaded");
								request.setAttribute("uploadAttachment", file.getName());
								
								if(documentType.equalsIgnoreCase("Master Data"))
								{
									System.err.println("------------- in master data-------------------");
									MasterExcelRead masterExcelRead = new MasterExcelRead();
									masterExcelRead.readMasterData(uploadAttachment,monthBean,yearBean);
								}
								else if(documentType.equalsIgnoreCase("Monthly Data"))
								{
									System.err.println("------------- in monthly data-------------------");
									ExcelRead excelRead = new ExcelRead();
									excelRead.readData(uploadAttachment,monthBean,yearBean);
								}
								
							}
							
							HttpSession session = request.getSession();
							session.setAttribute("success", "Salary Data Successfully Uploaded");
							response.sendRedirect("TDSSalaryDataUpload.jsp");
							//request.getRequestDispatcher("TDSSalaryDataUpload.jsp").forward(request, response);
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
