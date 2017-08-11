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
import com.hrms.pms.dao.AllUpdateDAO;

public class UpdateAttachmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
	String action = request.getParameter("action");
	int review_id =  Integer.parseInt(request.getParameter("review_id"));
	AllUpdateDAO updateDAO = new AllUpdateDAO();
	AllListDAO  allListDAO = new AllListDAO();
	if(action.equalsIgnoreCase("technical")){
		int reviewTech_id = Integer.parseInt(request.getParameter("reviewTech_id"));
		boolean result = updateDAO.techAttachmentUpdate(reviewTech_id);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("reviewEdit.jsp").forward(request, response);
	}else if(action.equalsIgnoreCase("softSkill")){
		int reviewSoft_id = Integer.parseInt(request.getParameter("reviewSoft_id"));
		boolean result = updateDAO.softAttachmentUpdate(reviewSoft_id);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("reviewEdit.jsp").forward(request, response);
		
	}else if(action.equalsIgnoreCase("managerTechnical")){
		int reviewTech_id = Integer.parseInt(request.getParameter("reviewTech_id"));
		System.out.println(reviewTech_id);
		boolean result = updateDAO.managerTechAttachmentUpdate(reviewTech_id);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("ShowDataInManager.jsp").forward(request, response);
		
	}else if(action.equalsIgnoreCase("managerSoftSkill")){
		int reviewSoft_id = Integer.parseInt(request.getParameter("reviewSoft_id"));
		boolean result = updateDAO.managerSoftAttachmentUpdate(reviewSoft_id);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("ShowDataInManager.jsp").forward(request, response);
		
	}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
