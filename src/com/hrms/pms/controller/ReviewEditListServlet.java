package com.hrms.pms.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.dao.AllListDAO;

public class ReviewEditListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
		int review_id = Integer.parseInt(request.getParameter("review_id"));
	     
		AllListDAO allListDAO = new AllListDAO();
		
			
			List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
			List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
			List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
			request.setAttribute("listOfReview", listOfReview);
			request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
			request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
			request.getRequestDispatcher("reviewEdit.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
	
	}

}
