package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.dao.AllListDAO;


public class AppraisalReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int year_id = Integer.parseInt(request.getParameter("year_id"));
	int employee_id = Integer.parseInt(request.getParameter("employee_id"));
	String action = request.getParameter("rdbMonth");
	
	AllListDAO allListDAO = new AllListDAO();
	if(action.equalsIgnoreCase("monthly")){
	List<AppraisalBean> listOfAppraisal = allListDAO.getAppraisalMonthReport(employee_id, year_id);
	request.setAttribute("listOfAppraisal", listOfAppraisal);
	}else if(action.equalsIgnoreCase("quarterly")){
		List<AppraisalBean> listOfAppraisal = allListDAO.getAppraisalMonthReport(employee_id, year_id);
		request.setAttribute("listOfAppraisal", listOfAppraisal);
	}
	request.getRequestDispatcher("appraisalReport.jsp").forward(request, response);
	
	
	}

}
