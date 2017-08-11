package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.SoftskillCriteriaBean;
import com.hrms.recruitement.bean.SubSoftskillCriteriaBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class SubSoftskillCriteriaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String id = request.getParameter("softskillCriteria");
		int softskill_criteria_id = Integer.parseInt(id);
		System.out.println("softskill_criteria_id : " +softskill_criteria_id);
		String sub_softskill_criteria_name = request.getParameter("subSoftskillCriteria");
		System.out.println("sub_softskill_criteria_name : " +sub_softskill_criteria_name);
		String description = request.getParameter("description");
		System.out.println("description : " +description);
		
		
		SoftskillCriteriaBean softskillCriteriaBean = new SoftskillCriteriaBean();
		
		softskillCriteriaBean.setSoftskill_criteria_id(softskill_criteria_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		SubSoftskillCriteriaBean subSoftskillCriteriaBean = new SubSoftskillCriteriaBean(sub_softskill_criteria_name, description, softskillCriteriaBean);
		boolean result = allInsertDAO.subSoftskillCriteriaInsert(subSoftskillCriteriaBean);
		
		request.setAttribute("id",id);
		request.getRequestDispatcher("addSubSoftskillCriteria.jsp").forward(request, response);
	
	
	
	
	
	}

}
