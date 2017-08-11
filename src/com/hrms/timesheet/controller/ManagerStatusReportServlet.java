package com.hrms.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllListDAO;

public class ManagerStatusReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");

		if (user != null) {

			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			int employee_id = 0;
			int department_id = 0;
			if (request.getParameter("employee_id") != null) {
				employee_id = Integer.parseInt(request.getParameter("employee_id"));
			}
			if (request.getParameter("department_id") != null) {
				department_id = Integer.parseInt(request.getParameter("department_id"));
			}

			int manager_id = user.getManagerBean().getManager_id();
			int role_id = user.getRoleBean().getRole_id();
			TimeSheetBean timeSheetBean = new TimeSheetBean();
			AllListDAO allListDAO = new AllListDAO();
			
			LocalDate startOfTask = LocalDate.parse(endDate);
			startOfTask = startOfTask.plusDays(6);
			System.out.println("Start date of Task:" + startOfTask);
			String date = startOfTask.toString();

			if (role_id == 1 || role_id == 2 || role_id == 3 || manager_id == 4) {

				List<TimeSheetBean> listOfStatusReport = allListDAO.getStatusReportAll(startDate, endDate,employee_id,department_id);
				
				
				
				if (employee_id != 0) {
					List<ProjectAllocationBean> listofTask = allListDAO.getListOfTaskByDate1(employee_id, endDate,
							date);
					request.setAttribute("listofTask1", listofTask);
					request.setAttribute("employee_id", employee_id);

				} else {
					List<TaskMasterBean> listofTask = allListDAO.getListOfAllTaskByDate(endDate, date);
					request.setAttribute("listofTask", listofTask);

				}
				
				if (department_id != 0) {
					request.setAttribute("department_id", department_id);
				}
				request.setAttribute("listOfStatusReport", listOfStatusReport);

			} else {

				List<TimeSheetBean> listOfStatusReport = allListDAO.getStatusReport(manager_id, startDate, endDate,
						employee_id,department_id);

				

				if (employee_id != 0) {
					List<ProjectAllocationBean> listofTask = allListDAO.getListOfTaskByDate1(employee_id, endDate,
							date);
					request.setAttribute("listofTask1", listofTask);
					request.setAttribute("employee_id", employee_id);
				} else {
					List<TaskMasterBean> listofTask = allListDAO.getListOfTaskByDate(manager_id, endDate, date);
					request.setAttribute("listofTask", listofTask);

				}
				if (department_id != 0) {
					request.setAttribute("department_id", department_id);
				}
				request.setAttribute("listOfStatusReport", listOfStatusReport);
			}

			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.getRequestDispatcher("managerStatusReport.jsp").forward(request, response);

		} else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
