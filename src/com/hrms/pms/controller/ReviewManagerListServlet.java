package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GradeMasterBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.ReviewCriteriaBean;
import com.hrms.pms.bean.ReviewSoftskillBean;
import com.hrms.pms.bean.TechnicalBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class ReviewManagerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int review_id = (Integer) session.getAttribute("review_id");
		int tech_per = (Integer) session.getAttribute("tech_per");
		int soft_per = (Integer) session.getAttribute("soft_per");
		int performance_score = 0;
		
		int tectSum = 0;
		int softSum = 0;
		int techFinal = 0;
		int softFinal = 0;
		
		
		System.out.println("review_id:"+review_id);
		AllListDAO allListDAO = new AllListDAO();
		
		List<Object[]> listOfReviewCriteria = allListDAO.getTechnicalbyId(review_id);
		double techTotal = listOfReviewCriteria.size();
		for(Object[] aRows : listOfReviewCriteria){
				ReviewCriteriaBean reviewCriteriaBean = (ReviewCriteriaBean) aRows[0]; 
				int technical = reviewCriteriaBean.getManagerGradeMasterBean().getManager_grade_master_id();
				tectSum = tectSum + technical;
				System.out.println(tectSum);
		}
				
	
		List<Object[]> listOfReviewSoftskill = allListDAO.getSoftskillbyId(review_id);
		double softTotal = listOfReviewSoftskill.size();
		for(Object[] aRows : listOfReviewSoftskill){
			ReviewSoftskillBean reviewSoftskillBean = (ReviewSoftskillBean) aRows[0]; 
			int softskill = reviewSoftskillBean.getManagerGradeMasterBean().getManager_grade_master_id();
			softSum = softSum + softskill;
			System.out.println(softSum);
		}
		
		System.out.println("technical :"+tectSum);
		System.out.println("softskill :"+softSum);
		System.out.println("techTotal :"+techTotal);
		System.out.println("softToatal :"+softTotal);
		System.out.println("techPer:"+tech_per);
		System.out.println("softPer:"+soft_per);
		techFinal = tech_per/100;
		
		double techAve = tectSum/techTotal;
		double softAve = softSum/softTotal;
		
		System.out.println("techAve :"+techAve);
		System.out.println("SoftAve :"+softAve);
		
		double techBonus = ((techAve*tech_per)/100);
		double softBonus = ((softAve*soft_per)/100);
		
		System.out.println("techBonus:"+techBonus);
		System.out.println("softBonus:"+softBonus);
		
		double total = techBonus+softBonus;
		System.out.println("totalBonus:"+total);
		
		int totalBonus = (int) Math.round(total);
		System.out.println("totalBonus :"+totalBonus);
		
		if(totalBonus == 5)
		{
			System.out.println("Total Bouns " + 150 + "%");
			performance_score = 150;
		}
		else if(totalBonus == 4)
		{
			System.out.println("Total Bouns " + 125 + "%");
			performance_score = 125;
		}
		else if(totalBonus == 3)
		{
			System.out.println("Total Bouns " + 100 + "%");
			performance_score = 100;
		}
		else if(totalBonus == 2)
		{
			System.out.println("Total Bouns " + 75 + "%");
			performance_score = 75;
		}
		else if(totalBonus == 1)
		{
			System.out.println("Total Bouns " + 25 + "%");
			performance_score = 25;
		}
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.reviewUpdate(techAve, softAve, techBonus, softBonus, totalBonus,review_id,performance_score);
		List<Object[]> listOfReview = allListDAO.getReviewbyId(review_id);
		request.setAttribute("techPer", tech_per);
		request.setAttribute("softPer", soft_per);
		request.setAttribute("listOfReview", listOfReview);
		request.setAttribute("listOfReviewCriteria", listOfReviewCriteria);
		request.setAttribute("listOfReviewSoftskill", listOfReviewSoftskill);
		request.getRequestDispatcher("showReviewFinal.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
