package com.hrms.recruitement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class InterviewerTimeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (user != null) {

			String first = request.getParameter("fdate&time");
			String second = request.getParameter("sdate&time");
			String third = request.getParameter("tdate&time");
			String first_time = request.getParameter("finterviewTime");
			String second_time = request.getParameter("sinterviewTime");
			String third_time = request.getParameter("tinterviewTime");
			String first_interview_type = request.getParameter("firstInterviewType");
			String second_interview_type = request.getParameter("secondInterviewType");
			String third_interview_type = request.getParameter("thirdInterviewType");

			first = first + "T" + first_time;
			second = second + "T" + second_time;
			third = third + "T" + third_time;

			System.out.println(first);
			System.out.println(second);
			System.out.println(third);
			int manager_id = user.getManagerBean().getManager_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());

			int id = Integer.parseInt(request.getParameter("it_id"));
			String status = "time given";
			int resume_id = Integer.parseInt(request.getParameter("resume_id"));

			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();

			boolean result = allUpdateDAO.interviewTimeUpdate(id, first, second, third, status, first_interview_type, second_interview_type, third_interview_type);
			request.setAttribute("SuccessInterviewDateTime", "You date and time Successfully updated");

			if (manager_id != 99) {
				if (manager_id == 1 || manager_id == 2 || manager_id == 3) {
					System.out.println("sltl");
					response.sendRedirect("sltlAdmin.jsp");
				} else if (manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117) {
					response.sendRedirect("hrHome.jsp");
					System.out.println("hr");
				} else {
					System.out.println("manager");
					response.sendRedirect("managerHome.jsp");

				}
			} else {
				if (under_manager_id == 4 || under_manager_id == 117) {
					response.sendRedirect("hrHome.jsp");
					System.out.println("hr");
				} else {
					response.sendRedirect("empHome.jsp");
					System.out.println("emp");
				}
			}

		}
	}

}
