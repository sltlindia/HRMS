package com.hrms.pms.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllListDAO;

public class GetReviewListByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
	int employee_master_id = Integer.parseInt(request.getParameter("employee_id"));
	String action = request.getParameter("action");
	System.out.println("action:"+action);
	
	
	Calendar c= Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int cmonth = c.get(Calendar.MONTH);
     
	
		if(action.equalsIgnoreCase("managerView")){
			int month_id = Integer.parseInt(request.getParameter("month_id"));
			int year_id = Integer.parseInt(request.getParameter("year_id"));
			AllListDAO allListDAO = new AllListDAO();
			List<Object[]> listOfReviewById = allListDAO.getReviewByMonth(employee_master_id,month_id,year_id);
			for(Object[] arow :listOfReviewById){
				ReviewBean reviewBean = (ReviewBean) arow[0];
				EmployeeBean employeeBean =(EmployeeBean) arow[1];
				MonthBean monthBean = (MonthBean) arow[2];
				YearBean yearBean = (YearBean) arow[3];
				
				int review_id = reviewBean.getReview_id();
				System.out.println(reviewBean.getReview_id());
				
				List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
				List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
				List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
				request.setAttribute("listOfReview", listOfReview);
				request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
				request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("ShowDataInManager.jsp").forward(request, response);
			}
	}else if(action.equalsIgnoreCase("employeeView")){
		int month_id = Integer.parseInt(request.getParameter("month_id"));
		int year_id = Integer.parseInt(request.getParameter("year_id"));
		AllListDAO allListDAO = new AllListDAO();
		List<Object[]> listOfReviewById = allListDAO.getReviewByMonth(employee_master_id,month_id,year_id);
		for(Object[] arow :listOfReviewById){
			ReviewBean reviewBean = (ReviewBean) arow[0];
			EmployeeBean employeeBean =(EmployeeBean) arow[1];
			MonthBean monthBean = (MonthBean) arow[2];
			YearBean yearBean = (YearBean) arow[3];
			
			int review_id = reviewBean.getReview_id();
			System.out.println(reviewBean.getReview_id());
			
			List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
			List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
			List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
			request.setAttribute("listOfReview", listOfReview);
			request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
			request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("showReviewData.jsp").forward(request, response);
		}
	}else if(action.equalsIgnoreCase("managerViewList")){
		int review_id = Integer.parseInt(request.getParameter("review_id"));
		AllListDAO allListDAO = new AllListDAO();
		
			List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
			List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
			List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
			request.setAttribute("listOfReview", listOfReview);
			request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
			request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("showReviewData.jsp").forward(request, response);
	
	}
		
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

}
