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
import com.hrms.pms.bean.AppraisalCriteriaBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class AppraisalSection2EditServlet extends HttpServlet {
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
		int gradeId = 0;
		int appraisal_criteria_id = 0;
		String remarks = null;
		String achivements = null;
		String improvement = null;
		String employeeComments = null;
		String appraiserComments = null;
		String reviewingComments = null;
		int ag_id = 0;
		
		
		AppraisalBean appraisalBean = new AppraisalBean();
		AppraisalGradeBean appraisalGradeBean = new AppraisalGradeBean();
		AppraisalCriteriaBean appraisalCriteriaBean = new AppraisalCriteriaBean();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
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
					
					if (fieldName.equalsIgnoreCase("ag_id")) {
						String value = fieldValue;
						ag_id = Integer.parseInt(value);
						System.out.println("ag_id:"+ag_id);
					}
					
					if (fieldName.equalsIgnoreCase("appraisal_criteria_id")) {
						String value = fieldValue;
						appraisal_criteria_id = Integer.parseInt(value);
						System.out.println("appraisal_criteria_id:"+appraisal_criteria_id);
					}
					
					if (fieldName.equalsIgnoreCase("gradeId")) {
						String value = fieldValue;
						gradeId = Integer.parseInt(value);
						System.out.println("gradeId:"+gradeId);
						
					}
					

					if (fieldName.equalsIgnoreCase("remarks")) {
						remarks = fieldValue;
						System.out.println("remarks:"+remarks);
						
						appraisalGradeBean.setAppraisal_grade_id(gradeId);
						appraisalCriteriaBean.setAppraisal_criteria_id(appraisal_criteria_id);
						
						AppraisalCriteriaGradeBean appraisalCriteriaGradeBean = new AppraisalCriteriaGradeBean(remarks, appraisalBean, appraisalGradeBean, appraisalCriteriaBean,ag_id);
						boolean result = allUpdateDAO.appraisalCriteriaGradeUpdate(appraisalCriteriaGradeBean);
					}
					
					if (fieldName.equalsIgnoreCase("achivements")) {
						achivements = fieldValue;
						System.out.println("achivements:"+achivements);
					}

					
					if (fieldName.equalsIgnoreCase("improvement")) {
						improvement = fieldValue;
						System.out.println("improvement:"+improvement);
					}

					
					if (fieldName.equalsIgnoreCase("employeeComments")) {
						employeeComments = fieldValue;
						System.out.println("employeeComments:"+employeeComments);
					}

					
					if (fieldName.equalsIgnoreCase("appraiserComments")) {
						appraiserComments = fieldValue;
						System.out.println("appraiserComments:"+appraiserComments);
					}
					
					if (fieldName.equalsIgnoreCase("reviewingComments")) {
						reviewingComments = fieldValue;
						System.out.println("reviewingComments:"+reviewingComments);
						
						
						AllUpdateDAO allupdateDAO = new AllUpdateDAO();
						boolean result = allupdateDAO.appraisalUpdate(achivements, improvement, employeeComments, appraiserComments, reviewingComments, appraisal_id);
						request.setAttribute("appraisal_id", appraisal_id);
						request.getRequestDispatcher("blueCollarFinalView.jsp").forward(request, response);
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

