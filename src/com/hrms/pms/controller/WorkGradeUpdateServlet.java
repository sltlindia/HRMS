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
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.WorkBehaviourBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class WorkGradeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WorkGradeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = getServletContext().getInitParameter("file-upload"); 
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
		int grade_id = 0;
		int work_id = 0;
		int employee_id = 0;
		int work_grade_id = 0;
		
		AppraisalBean appraisalBean = new AppraisalBean();
		WorkBehaviourBean workBehaviourBean = new WorkBehaviourBean();
		AppraisalGradeBean appraisalGradeBean = new AppraisalGradeBean();
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("work_grade_id")) {
						String value = fieldValue;
						work_grade_id = Integer.parseInt(value);
						System.out.println("work_grade_id:"+work_grade_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("appraisal_id")) {
						String value = fieldValue;
						appraisal_id = Integer.parseInt(value);
						System.out.println("appraisal_id:"+appraisal_id);
						appraisalBean.setAppraisal_id(appraisal_id);
					}
					
					if (fieldName.equalsIgnoreCase("work_id")) {
						String value = fieldValue;
						work_id = Integer.parseInt(value);
						workBehaviourBean.setWork_behaviors_id(work_id);
						System.out.println("work_id:"+work_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("grade_id")) {
						String value = fieldValue;
						grade_id = Integer.parseInt(value);
						appraisalGradeBean.setAppraisal_grade_id(grade_id);
						System.out.println("grade_id:"+grade_id);
						
						
						WorkGradeBean workGradeBean = new WorkGradeBean(work_grade_id, appraisalBean, workBehaviourBean, appraisalGradeBean);
						
						boolean result = allUpdateDAO.workGradeUpdate(workGradeBean);
					}
				
					if (fieldName.equalsIgnoreCase("employee_id"))
					{
						String value = fieldValue;
						employee_id = Integer.parseInt(value);
						
						System.out.println("employee_id:" +employee_id);
						
					
					}
				
					
					
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("appraisal_id", appraisal_id);
						request.setAttribute("employee_id", employee_id);
						AllListDAO  allListDAO = new AllListDAO();
						List<AppraisalLeaveBean> listOfLeave = allListDAO.getappraisalLeave(appraisal_id);
						if(listOfLeave.size() == 0)
						{
							request.getRequestDispatcher("whiteCollarAppraisalSection2.2.jsp").forward(request, response);
						}else
						{
							
							request.getRequestDispatcher("whiteCollarEditAppraisalSection2.2.jsp").forward(request, response);
						}}
					
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
