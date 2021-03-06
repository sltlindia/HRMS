package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllListDAO;

public class ReviewEmployeeShowViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String reviewId = request.getParameter("review_id");
		String action = request.getParameter("action");
		int review_id = Integer.parseInt(reviewId);
		AllListDAO allListDAO = new AllListDAO();
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		
		
		
		if(action.equalsIgnoreCase("employeeView")){
			request.getRequestDispatcher("showReviewEmployeeFinal.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("managerView")){
			request.getRequestDispatcher("reviewFinalManagerSide.jsp").forward(request, response);
		}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
