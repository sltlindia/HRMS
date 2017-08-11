package com.hrms.recruitement.controller;

import java.io.IOException
;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.recruitement.bean.InterviewedByBean;
import com.hrms.recruitement.bean.InterviewerPanelBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.bean.InterviewTimingBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

/*import jdk.nashorn.internal.ir.RuntimeNode.Request;*/

public class ResumeDataUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String approved = null;
	String status = "pending";
	int resume_data_id = 0;
	int resume_id = 0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String filePath = getServletContext().getInitParameter("file-upload");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*EmployeeBean user = session.getAttribute("user");*/
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String date = null;
		int vacancy_id = 0;
		int employee_master_id = user.getEmployee_master_id();
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		ResumeDataBean resumeDataBean1 = new ResumeDataBean();
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);

				
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("resume_id")) {
						String value1 = fieldValue;
						resume_data_id = Integer.parseInt(value1);
						System.out.println("resume_data_id:" + resume_data_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("submission_date")) {
						date = fieldValue;
						System.out.println("date:" + date);
					}
					
					if (fieldName.equalsIgnoreCase("action")) {
						approved = fieldValue;
						System.out.println("approved:" + approved);
						AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
						
						
						boolean result = allUpdateDAO.resumeDataUpdate(resume_data_id,approved,date,employee_master_id);
						
						
					}
					
					if (fieldName.equalsIgnoreCase("vacancy_id")) {
						String value = fieldValue;
						vacancy_id = Integer.parseInt(value);
						System.out.println("vacancy_id:" + vacancy_id);
						
						AllRecruitmentListDAO allRecruitmentListDAO = new  AllRecruitmentListDAO();
						List<InterviewedByBean> listOfInterviewer = allRecruitmentListDAO.getListOfInterviewerByVacncyId(vacancy_id);
						for(InterviewedByBean interviewedByBean : listOfInterviewer){
							
							String first = "No Date & Time Set";
							String second = "No Date & Time Set";
							String third = "No Date & Time Set";
							String first_time = "No Date & Time Set";
							String second_time = "No Date & Time Set";
							String third_time = "No Date & Time Set";
							int show_view = 0;
							int id = interviewedByBean.getEmployeeBean().getEmployee_master_id();
							EmployeeBean employeeBean = new EmployeeBean();
							resumeDataBean1.setResume_data_id(resume_data_id);
							employeeBean.setEmployee_master_id(id);
							
							InterviewTimingBean interviewTimingBean = new InterviewTimingBean(first, second, third, employeeBean, resumeDataBean1, first_time, second_time, third_time, show_view);
							
							AllInsertDAO allInsertDAO = new AllInsertDAO();
							boolean result = allInsertDAO.interviewTimingInsert(interviewTimingBean);
							
						}
						
						/*request.getRequestDispatcher("criteriaChecklist.jsp").forward(request, response);*/
						response.sendRedirect("viewAllResumeListForManager.jsp");
					}
					
					/*if(fieldName.equalsIgnoreCase("resume_data_id"))
					{
						String value = fieldValue;
						resume_id = Integer.parseInt(value);
						System.out.println("resume_data_id :"+resume_data_id);
					}
					
					if(fieldValue.equalsIgnoreCase("status")){
						String value = fieldValue;
						AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
						boolean result = allUpdateDAO.resumeStatusUpdate(value, resume_id);
						
						if(result == true)
						{
							response.sendRedirect("hrHome.jsp");
						}
						
					}*/
					
		}
}
}
catch(Exception e){
			
		}
		
		}
	}
}