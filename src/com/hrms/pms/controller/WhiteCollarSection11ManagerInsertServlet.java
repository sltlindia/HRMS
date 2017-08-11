package com.hrms.pms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class WhiteCollarSection11ManagerInsertServlet extends HttpServlet {
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
		int criteriaGrade_id = 0;
		int employee_id = 0;
		String weightage = null;
		String appraiser_comment = null;
		int grade_id = 0;
		int appraisal_id = 0;
		AppraisalBean appraisalBean = new AppraisalBean();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("appraisal_id")) {
						String value = fieldValue;
						appraisal_id = Integer.parseInt(value);
						System.out.println("appraisal_id:"+appraisal_id);
					}
					
					if (fieldName.equalsIgnoreCase("criteriaGrade_id")) {
						String value = fieldValue;
						criteriaGrade_id = Integer.parseInt(value);
						System.out.println("criteriaGrade_id:"+criteriaGrade_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("weightage")) {
						weightage = fieldValue;
						System.out.println("weightage:"+weightage);
					}
					
					
					
					if (fieldName.equalsIgnoreCase("a_cmt")) {
						appraiser_comment = fieldValue;
						System.out.println("appraiser_comment:"+appraiser_comment);
					}
					
					
					if (fieldName.equalsIgnoreCase("grade")) {
						String value = fieldValue;
						grade_id = Integer.parseInt(value);
						System.out.println("result:"+grade_id);
						
						AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
						boolean result = allUpdateDAO.appraisalWhiteCollarUpdate(criteriaGrade_id, weightage, appraiser_comment, grade_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("employee_id")) {
						String value = fieldValue;
						employee_id = Integer.parseInt(value);
						System.out.println("employee_id :"+employee_id);
					}
					
					if (fieldName.equalsIgnoreCase("redirect"))
					{
						request.setAttribute("appraisal_id", appraisal_id);
						request.setAttribute("employee_id", employee_id);
						request.getRequestDispatcher("whiteCollarAppraisalSection2.jsp").forward(request, response);
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

