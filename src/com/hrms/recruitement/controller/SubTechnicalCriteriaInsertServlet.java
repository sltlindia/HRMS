package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.SubTechnicalCriteriaBean;
import com.hrms.recruitement.bean.TechnicalCriteriaBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class SubTechnicalCriteriaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id = request.getParameter("technicalCriteria");
		int technical_criteria_id = Integer.parseInt(id);
			String sub_technical_criteria_name = request.getParameter("subTechnicalCriteria");
			System.out.println("sub_technical_criteria_name : " +sub_technical_criteria_name);
			String description = request.getParameter("description");
			System.out.println("description : " +description);
			
			
			TechnicalCriteriaBean technicalCriteriaBean = new TechnicalCriteriaBean();
			
			technicalCriteriaBean.setTechnical_criteria_id(technical_criteria_id);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			SubTechnicalCriteriaBean subTechnicalCriteriaBean = new SubTechnicalCriteriaBean( sub_technical_criteria_name, description, technicalCriteriaBean);
			boolean result = allInsertDAO.subTechnicalCriteriaInsert(subTechnicalCriteriaBean);
			
			
			
			request.setAttribute("id",id);
			request.getRequestDispatcher("addSubTechnicalCriteria.jsp").forward(request, response);
	}

}
