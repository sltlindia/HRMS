package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.dao.AllListDAO;

public class AllocationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int specific_id = Integer.parseInt(request.getParameter("specific_id"));
		
		AllListDAO allListDAO = new AllListDAO();
		
		/*SpecificCriteriaAllocationBean allocationBean = allListDAO.getspecificById(specific_id);*/
		
		SpecificCriteriaBean allocationBean = allListDAO.getspecificCriteriaById(specific_id);
		
		 List<SpecificCriteriaSoftskillBean> listOfSpecificSoftskill= allListDAO.getSpecificAllocatedCriteriaSoftskill(specific_id);
		 List<SpecificCriteriaTechnicalBean> listOfSpecificTechnical= allListDAO.getSpecificAllocatedCriteriaTechnical(specific_id);
		 List<SpecificCriteriaMonthBean> listOfSpecificMonth= allListDAO.getSpecificAllocatedCriteriaMonth(specific_id);
		
		request.setAttribute("allocationBean", allocationBean);
		request.setAttribute("listOfSpecificSoftskill", listOfSpecificSoftskill);
		request.setAttribute("listOfSpecificTechnical", listOfSpecificTechnical);
		request.setAttribute("listOfSpecificMonth", listOfSpecificMonth);
		request.getRequestDispatcher("specificCriteriaView.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
