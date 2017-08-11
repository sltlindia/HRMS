package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class WhiteCollarSection1UpdateServlet
 */
public class WhiteCollarSection1UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
		String roles = request.getParameter("roles");
		String contributions = request.getParameter("contributions");
		String obstacles = request.getParameter("obstacles");
		String opportunities = request.getParameter("opportunities");
		
		int appraisalWhiteSection1Id = Integer.parseInt(request.getParameter("appraisalWhiteSection1Id")); 
		AppraisalBean appraisalBean = new AppraisalBean();
		appraisalBean.setAppraisal_id(appraisal_id);
		
		AppraisalWhiteSection1Bean appraisalWhiteSection1Bean = new AppraisalWhiteSection1Bean(appraisalWhiteSection1Id, roles, contributions, obstacles, opportunities, appraisalBean);
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		boolean result = allUpdateDAO.appraisalWhiteCollarSection1Update(appraisalWhiteSection1Bean);
		
		
		/*request.setAttribute("appraisal_id", appraisal_id);*/
		AllListDAO allListDAO = new AllListDAO();
				
		List<AppraisalWhiteCollarGradeBean> listOfGrade = allListDAO.getappraisalGrade(appraisal_id);
		
		if(listOfGrade.size() == 0)
		{
			request.setAttribute("appraisal_id", appraisal_id);
			request.getRequestDispatcher("whiteCollarAppraisalSection1.1.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("whiteCollarAppraisalSection1.1Update.jsp").forward(request, response);	
		}
		
		
	
	}

}
