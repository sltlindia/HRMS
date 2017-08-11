package com.hrms.recruitement.controller;

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class SendResumeToInterviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String fieldName = null;
			String fieldValue = null;
			String status = "pending";
			ResumeDataBean resumeDataBean = new ResumeDataBean();

			int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
			
			System.out.println(resume_data_id);
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result1 = allUpdateDAO.resumeStatusUpdate(status, resume_data_id);
			request.getRequestDispatcher("resumeDataSearchEngine").forward(request, response);
	}
	}
}
