package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.recruitement.bean.AcademicDetailCheckBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class AcademicDetailCheckInsertServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InterviewFeedbackBean interviewFeedbackBean  = new InterviewFeedbackBean();
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		String qualification = null;
		String mode_of_education = null;
		String name_of_institute = null;
		String name_of_university = null;
		String from_date = null;
		String to_date = null;
		String marks = null;
		String roll_no = null;
		int interview_feedback_id = 0;
		
		String fieldName = null;
		String fieldValue = null;
		
		try {
			
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);

				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();

					if (fieldName.equalsIgnoreCase("candidate")) {
						String value = fieldValue;
						interview_feedback_id = Integer.parseInt(value);
						System.out.println("interview_feedback_id :" + interview_feedback_id);
					}
					if (fieldName.equalsIgnoreCase("qualification")) {
						qualification = fieldValue;
						System.out.println("qualification :" + qualification);
					}

					if (fieldName.equalsIgnoreCase("modeOfEducation")) {
						mode_of_education = fieldValue;
						System.out.println("mode_of_education :" + mode_of_education);
					}

					if (fieldName.equalsIgnoreCase("nameOfInstitute")) {
						name_of_institute = fieldValue;
						System.out.println("title_of_position :" + name_of_institute);
					}
					
					if (fieldName.equalsIgnoreCase("nameOfUniversity")) {
						name_of_university = fieldValue;
						System.out.println("mode_of_education :" + name_of_university);
					}
					
					if (fieldName.equalsIgnoreCase("fromDate")) {
						from_date = fieldValue;
						System.out.println("fromDate :" + from_date);
					}
					
					if (fieldName.equalsIgnoreCase("toDate")) {
						to_date = fieldValue;
						System.out.println("toDate :" + to_date);
					}
					if (fieldName.equalsIgnoreCase("enrollmentNo")) {
						roll_no = fieldValue;
						System.out.println("rollNo :" + roll_no);
					}
					
					if (fieldName.equalsIgnoreCase("marks")) {
						marks = fieldValue;
						System.out.println("marks :" + marks);
						
						if(!qualification.equalsIgnoreCase("")){
						
						interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
						
						AllInsertDAO allInsertDAO = new AllInsertDAO();
						AcademicDetailCheckBean academicDetailCheckBean = new AcademicDetailCheckBean(interviewFeedbackBean, 
								qualification, mode_of_education, name_of_institute, name_of_university, roll_no, 
								marks, from_date, to_date);
						boolean result = allInsertDAO.academicDetailCheckInsert(academicDetailCheckBean);
						}
					}
					
					
					
					if (fieldName.equalsIgnoreCase("redirect")) {
					
						response.sendRedirect("hrHome.jsp");
						}
						
					}
					
					
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		finally{}
	
		}
}
