package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.QuterlyMonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

public class AppraisalInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int employee_id = Integer.parseInt(request.getParameter("employee_master_id"));
	int month_id = Integer.parseInt(request.getParameter("month_id"));
	int year_id = Integer.parseInt(request.getParameter("year_id"));
	int q_id = Integer.parseInt(request.getParameter("q_id"));
	int white_collar = 0;
	if(request.getParameter("whiteCollar") != null){
		white_collar = Integer.parseInt(request.getParameter("whiteCollar"));
	}
	String achievement = "-";
	String area_of_improvement ="-";
	String emp_comment = "-";
	String appraiser_commnet = "-";
	String reviewing_comment = "-";
	String status = "pending";
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	String date1 = dateFormat.format(date);
	
	EmployeeBean employeeBean = new EmployeeBean();
	MonthBean monthBean = new MonthBean();
	YearBean yearBean = new YearBean();
	QuterlyMonthBean quterlyMonthBean = new QuterlyMonthBean();
	
	employeeBean.setEmployee_master_id(employee_id);
	monthBean.setMonth_id(month_id);
	yearBean.setYear_id(year_id);
	quterlyMonthBean.setQuarterly_month_id(q_id);
	
	
	AllListDAO allListDAO = new AllListDAO();
	List<AppraisalBean> listOfAppraisalYear = allListDAO.getAppraisalCheckYear(year_id,employee_id);
	List<AppraisalBean> listOfAppraisalMonth = allListDAO.getAppraisalCheckMonth(year_id,month_id,employee_id);
	List<AppraisalBean> listOfAppraisalQuarter = allListDAO.getAppraisalCheckQuarter(q_id,employee_id,year_id);
	
	
	
	if(listOfAppraisalYear.size() != 0){
		request.setAttribute("yearExist", "Appraisal of this year already exist and If you want to update the appraisal Go to My Appraisal History click on this icon:");
	}else if(listOfAppraisalMonth.size() != 0){
		request.setAttribute("monthExist", "Appraisal of this Month already exist If you want to update the appraisal Go to My Appraisal History click on this icon:");
	}else if(listOfAppraisalQuarter.size() != 0){
		request.setAttribute("quarterExist", "Appraisal of this Quarter already exist If you want to update the appraisal Go to My Appraisal History click on this icon:");
	}else{
	AppraisalBean appraisalBean = new AppraisalBean(employeeBean, monthBean, yearBean,date1,achievement,area_of_improvement,emp_comment,appraiser_commnet,reviewing_comment,quterlyMonthBean,white_collar,status);
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean result = allInsertDAO.appraisalInsert(appraisalBean);
	
	request.setAttribute("appraisal_id", appraisalBean.getAppraisal_id());
	request.setAttribute("month_id", month_id);
	request.setAttribute("year_id", year_id);
	request.setAttribute("q_id", q_id);
	request.setAttribute("employee_id", employee_id);
	
	if(request.getParameter("action") != null){
		request.getRequestDispatcher("whiteCollarAppraisalSection1.jsp").forward(request, response);
	}else{
	request.getRequestDispatcher("blueCollarAppraisalSection1.jsp").forward(request, response);
	}
	
	}
	
	if(listOfAppraisalYear.size() != 0 || listOfAppraisalMonth.size() != 0 || listOfAppraisalQuarter.size() != 0){
	if(request.getParameter("action") != null){
		request.setAttribute("employee_id", employee_id);
		request.getRequestDispatcher("whiteCollarAppraisal.jsp").forward(request, response);
	}else{
		request.setAttribute("employee_id", employee_id);
	request.getRequestDispatcher("blueCollarAppraisal.jsp").forward(request, response);
	}
	}
	}

}
