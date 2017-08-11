package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.dao.AllListDAO;

public class TimeSheetViewButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		String date = request.getParameter("date");
		String startDate = null;
		String endDate = null;
		String dayOfWeek = null;
		int day_id = 0;
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> timeSheetUpdateButton = allListDAO1.timeSheetUpdateButton(employee_master_id,date);
		System.out.println(timeSheetUpdateButton.size());
		/*String task_time_status= request.getAttribute("data");*/
		request.setAttribute("timeSheetUpdateButton", timeSheetUpdateButton);
		request.getRequestDispatcher("timesheetView.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}

}
