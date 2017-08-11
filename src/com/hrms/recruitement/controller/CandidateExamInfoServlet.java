package com.hrms.recruitement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.hrms.recruitement.bean.CandidateExamInfoBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

/**
 * Servlet implementation class CandidateExamInfoServlet
 */
public class CandidateExamInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			/* EmployeeBean user = session.getAttribute("user"); */
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String status = "notified";
			int iq_test = 0;
			int technical_written_test = 0;
			int technical_interview = 0;
			int hr_interview = 0;
			int group_discussion = 0;
			String required_time = "0";
			int resume_id = 0;
			int personality_test = 0;
			int aptitude_test = 0;
			

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date today = Calendar.getInstance().getTime();
			String currentDate = dateFormat.format(today);
			ResumeDataBean resumeDataBean = new ResumeDataBean();
			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
						
						if (fieldName.equalsIgnoreCase("resume_id")) {
							String value = fieldValue;
							resume_id = Integer.parseInt(value);
							System.out.println("resume_id:" + resume_id);
						}
						
						if (fieldName.equalsIgnoreCase("iq_test")) {
							String value = fieldValue;
							iq_test = Integer.parseInt(value);
							System.out.println("iq_test:" + iq_test);
						}
						
						if (fieldName.equalsIgnoreCase("technical_written_test")) {
							String value= fieldValue;
							technical_written_test = Integer.parseInt(value);
							System.out.println("technical_written_test:" + technical_written_test);
						}
						
						if (fieldName.equalsIgnoreCase("technical_interview")) {
							String value = fieldValue;
							technical_interview = Integer.parseInt(value);
							System.out.println("technical_interview:" + technical_interview);
						}
						
						if (fieldName.equalsIgnoreCase("hr_interview")) {
							String value = fieldValue;
							hr_interview = Integer.parseInt(value);
							System.out.println("hr_interview:" + hr_interview);
						}
						
						if (fieldName.equalsIgnoreCase("group_discussion")) {
							String value = fieldValue;
							group_discussion = Integer.parseInt(value);
							System.out.println("group_discussion:" + group_discussion);
						}
						
						if (fieldName.equalsIgnoreCase("personality_test")) {
							String value = fieldValue;
							personality_test = Integer.parseInt(value);
							System.out.println("personality_test:" + personality_test);
						}
						
						if (fieldName.equalsIgnoreCase("aptitude_test")) {
							String value = fieldValue;
							aptitude_test = Integer.parseInt(value);
							System.out.println("aptitude_test:" + aptitude_test);
						}
						
						
						
						if (fieldName.equalsIgnoreCase("requiredTime")) {
							required_time = fieldValue;
							System.out.println("requiredTime:" + required_time);
							
							System.out.println(resume_id);
							System.out.println(iq_test);
							System.out.println(technical_written_test);
							System.out.println(technical_interview);
							System.out.println(hr_interview);
							System.out.println(group_discussion);
							System.out.println(required_time);
							System.out.println(personality_test);
							System.out.println(aptitude_test);
							System.out.println("end");
							
							resumeDataBean.setResume_data_id(resume_id);
							if(iq_test !=0 || technical_interview !=0 || technical_written_test !=0 || hr_interview !=0 || group_discussion !=0){
							CandidateExamInfoBean candidateExamInfoBean = new CandidateExamInfoBean(iq_test, technical_written_test, technical_interview,
									hr_interview, group_discussion,	required_time, resumeDataBean,currentDate, personality_test, aptitude_test);
							AllInsertDAO allInsertDAO = new AllInsertDAO();
							boolean result = allInsertDAO.candidateExamTypeInsert(candidateExamInfoBean);
							if (result == true){
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result1 = allUpdateDAO.resumeStatusUpdate(status, resume_id);
								System.out.println("Successful");
							}
						}
						}
						
						if (fieldName.equalsIgnoreCase("redirection")) {
						
						response.sendRedirect("hrHome.jsp");
						}
						
				}
			}
			
	}
			catch(Exception e)
			{
				
			}
	}
}
}
