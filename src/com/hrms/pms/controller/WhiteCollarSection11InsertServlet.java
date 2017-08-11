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

import com.hrms.pms.bean.Appraisal5sBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.AppraisalKizenBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalTrainingBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.QuterlyMonthBean;
import com.hrms.pms.dao.AllInsertDAO;

public class WhiteCollarSection11InsertServlet extends HttpServlet {
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
		int appraisal_id = 0;
		String goals = null;
		String result = null;
		String employee_cmt = null;
		String weightage = "-";
		String appraiser_comment = "-";
		int grade_id = 0;

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
						appraisalBean.setAppraisal_id(appraisal_id);
					}
					
					if (fieldName.equalsIgnoreCase("goals")) {
						goals = fieldValue;
						System.out.println("goals:"+goals);
					}
					
					
					if (fieldName.equalsIgnoreCase("result")) {
						result = fieldValue;
						System.out.println("result:"+result);
					}
					
					
					if (fieldName.equalsIgnoreCase("employee_cmt")) {
						employee_cmt = fieldValue;
						System.out.println("employee_cmt:"+employee_cmt);
						
						if(!goals.equalsIgnoreCase("")){
						AppraisalWhiteCollarGradeBean collarGradeBean = new AppraisalWhiteCollarGradeBean(goals, result, employee_cmt, appraisalBean, weightage, appraiser_comment);
						boolean result1 = allInsertDAO.appraisalwhiteSection11Insert(collarGradeBean);
						}
					}
				
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("appraisal_id", appraisal_id);
						request.getRequestDispatcher("whiteCollarAppraisalSection3.jsp").forward(request, response);
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
