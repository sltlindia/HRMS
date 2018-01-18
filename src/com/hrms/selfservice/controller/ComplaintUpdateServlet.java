package com.hrms.selfservice.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

/**
 * Servlet implementation class ComplaintUpdateServlet
 */
public class ComplaintUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			String date = dateFormat.format(date1);
			
			int complaint_id = Integer.parseInt(request.getParameter("complaint_id"));
			String firstname = user.getFirstname();
			String lastname = user.getLastname();
			int employee_master_id = user.getEmployee_master_id();
			int employee_code = user.getEmployee_code();
			String department_name = user.getDepartmentBean().getDepartment_name();
			int extension = Integer.parseInt(request.getParameter("extension"));
			int problem_nature_id = Integer.parseInt(request.getParameter("problem_nature"));
			String location = request.getParameter("location");
			String description = request.getParameter("problem_desc");
			int cartigeCount = Integer.parseInt(request.getParameter("cartigeCount"));
			String status = "pending";
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
			ProblemNatureBean problemNatureBean = new ProblemNatureBean();
			problemNatureBean.setProblem_nature_id(problem_nature_id);
			
			ComplaintBean complaintBean = new ComplaintBean(complaint_id, location, extension, description, date, status, employeeBean, problemNatureBean,cartigeCount);
			AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
			boolean result = allUpdateSelfServiceDAO.complaintUpdate(complaintBean);
			request.getRequestDispatcher("complaint.jsp").forward(request, response);
	}

	
	}

}
