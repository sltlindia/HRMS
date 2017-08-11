package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.dao.AllInsertDAO;


public class WhiteCollarSection1InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
	String roles = request.getParameter("roles");
	String contributions = request.getParameter("contributions");
	String obstacles = request.getParameter("obstacles");
	String opportunities = request.getParameter("opportunities");
	
	
	AppraisalBean appraisalBean = new AppraisalBean();
	appraisalBean.setAppraisal_id(appraisal_id);
	
	AppraisalWhiteSection1Bean appraisalWhiteSection1Bean = new AppraisalWhiteSection1Bean(roles, contributions, obstacles, opportunities, appraisalBean);
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean result = allInsertDAO.appraisalwhiteSection1Insert(appraisalWhiteSection1Bean);
	request.setAttribute("appraisal_id", appraisal_id);
	request.getRequestDispatcher("whiteCollarAppraisalSection1.1.jsp").forward(request, response);
	}

}
