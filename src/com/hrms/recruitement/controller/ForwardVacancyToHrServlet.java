package com.hrms.recruitement.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.VacancyAllocationBean;
import com.hrms.recruitement.bean.VacancyApprovalBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;


public class ForwardVacancyToHrServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date today = Calendar.getInstance().getTime();

		String date1 = dateFormat.format(today);

		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date today1 = Calendar.getInstance().getTime();

		String date2 = dateFormat1.format(today1);

		String d1 = null;
		String dd = today1.toString();

		try {

			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			Date result = formater.parse(date1);
			SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			d1 = AppDateFormat.format(result);
			System.out.println(AppDateFormat.format(result));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
		String Remark = "";
		
		Remark = request.getParameter("remark");
		
		System.out.println("REMARK " + Remark);
		
		
		String[] chkEmp = request.getParameterValues("chkHrName");
		int show_view = 0;
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		EmployeeBean employeeBean = new EmployeeBean();
		
		vacancyFormBean.setVacancy_id(vacancy_id);
		
		for(String employee : chkEmp ){
			int id = Integer.parseInt(employee);
			employeeBean.setEmployee_master_id(id);
			VacancyAllocationBean allocationBean = new VacancyAllocationBean(vacancyFormBean, employeeBean,show_view,date2 , Remark);
			boolean result = allInsertDAO.vacancyAllocationInsert(allocationBean);
			
		}
		
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result1 = allUpdateDAO.vacancyApprovalStatusForwarded(vacancy_id);
		
		boolean result = allUpdateDAO.vacancyStatusUpdate(vacancy_id);
		
		request.setAttribute("allocated", "Vacancy successfully forwarded.....");
		request.getRequestDispatcher("vacancyAllocationForm.jsp").forward(request, response);
	}

}
	