package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.selfservice.bean.ProblemNatureBean;

public class ClassMasterUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassMasterUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String action = request.getParameter("action");
	
	AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
	
	if(action.equalsIgnoreCase("classification")){
		
		
		int classification_id = Integer.parseInt(request.getParameter("classification_id"));
		String class_name = request.getParameter("class_name");
		
		
		
		ProductMasterBean productMasterBean = new ProductMasterBean();
		
		ClassificationBean classificationBean = new ClassificationBean(classification_id, class_name);
		boolean result = allIncentiveUpdateDAO.classUpdate(classificationBean);
		
		
		request.getRequestDispatcher("incentiveMaster1.jsp").forward(request, response);
			
		
	}else if(action.equalsIgnoreCase("laser")){
		
		int laser_master_id  = Integer.parseInt(request.getParameter("laser_master_id"));
		String laser_source = request.getParameter("laser_source");
		
		LaserMasterBean laserMasterBean = new LaserMasterBean(laser_master_id, laser_source);
		boolean result = allIncentiveUpdateDAO.laserUpdate(laserMasterBean); 
		
		request.getRequestDispatcher("incentiveMaster1.jsp").forward(request, response);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
