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
import com.hrms.pms.dao.LoginDAO;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.ResumeShareBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class ResumeShareInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String shared_date = null;
			String reply_date = null;
			String reason = null;
			String status = "pending";
			String value5 = null;
			int resume_data_id = 0;
			String resume_status = "shared";
			String first_date_time = "No Date & Time Set";
			String second_date_time = "No Date & Time Set";
			String third_date_time = "No Date & Time Set";
			String show_view = "0";

			ResumeDataBean resumeDataBean = new ResumeDataBean();
			EmployeeBean employeeBean = new EmployeeBean();

			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();

						if (fieldName.equalsIgnoreCase("resume_data_id")) {
							String value = fieldValue;
							resume_data_id = Integer.parseInt(value);
							System.out.println("resume_id :" + resume_data_id);
						}

						if (fieldName.equalsIgnoreCase("submission_date")) {
							shared_date = fieldValue;
							System.out.println("shared_date :" + shared_date);
						}

						if (fieldName.equalsIgnoreCase("employee_name")) {
							value5 = fieldValue;
							System.out.println("employee_name:" + value5);

							if (!value5.equalsIgnoreCase("")) {

								String[] split = value5.split(",");
								int emp_code = Integer.parseInt(split[0]);
								String name = split[1];

								String[] splitName = name.split(" ");
								String firstName = splitName[0];
								String lastName = splitName[1];

								System.out.println("emp_code:" + emp_code);
								System.out.println("firstName:" + firstName);
								System.out.println("lastName:" + lastName);

								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName,
										lastName);

								int emp_id = employeeBean1.getEmployee_master_id();

								System.out.println("emp_id:" + emp_id);

								AllInsertDAO allInsertDAO = new AllInsertDAO();
								employeeBean.setEmployee_master_id(emp_id);
								resumeDataBean.setResume_data_id(resume_data_id);
								ResumeShareBean resumeShareBean = new ResumeShareBean(resumeDataBean, employeeBean,
										status, reason, shared_date, reply_date, first_date_time,
										second_date_time, third_date_time, show_view);
								boolean result1 = allInsertDAO.resumeShareInsert(resumeShareBean);

								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result2 = allUpdateDAO.resumeStatusUpdate(resume_status, resume_data_id);

								if (result1 == true && result2 == true) {
									response.sendRedirect("allResumeList.jsp");
								}

								else {
									response.sendRedirect("allResumeList.jsp");
								}

							}
						}

					}

				}
			}

			catch (Exception E) {

			}

		}

	}
}