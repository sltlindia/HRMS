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
import org.dom4j.dom.DOMProcessingInstruction;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalCriteriaBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalCriteriaManagerBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.AppraisalUpdateManagerScoreBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class AppraisalScoreManagerUpdateServlet extends HttpServlet {
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
		double score = 0;
		int appraisal_criteria_id = 0;
		
		AppraisalBean appraisalBean = new AppraisalBean();
		AppraisalCriteriaManagerBean appraisalCriteriaManagerBean = new AppraisalCriteriaManagerBean();
		
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
					
					
					if (fieldName.equalsIgnoreCase("appraisal_criteria_id")) {
						String value = fieldValue;
						appraisal_criteria_id = Integer.parseInt(value);
						appraisalCriteriaManagerBean.setAppraisal_criteria_manager_id(appraisal_criteria_id);
						System.out.println("appraisal_criteria_id:"+appraisal_criteria_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("score")) {
						String value = fieldValue;
						score = Double.parseDouble(value);
						System.out.println("score:"+score);
						
						AppraisalUpdateManagerScoreBean appraisalUpdateManagerScoreBean = new AppraisalUpdateManagerScoreBean(score, appraisalBean, appraisalCriteriaManagerBean);
						boolean result = allInsertDAO.managerScoreUpdateInsert(appraisalUpdateManagerScoreBean);
					}

					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("appraisal_id", appraisal_id);
					request.getRequestDispatcher("whiteCollarFinalView.jsp").forward(request, response);
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

	
