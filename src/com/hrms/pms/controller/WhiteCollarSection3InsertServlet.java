package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllUpdateDAO;

public class WhiteCollarSection3InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	int appraisal_id =Integer.parseInt(request.getParameter("appraisal_id"));
	String status = request.getParameter("status");
	String a_cmt  = "-";
	if(request.getParameter("a_cmt") != null){
		a_cmt = request.getParameter("a_cmt");
	}
	String b_cmt ="-";
	if(request.getParameter("b_cmt") != null){
	b_cmt = request.getParameter("b_cmt");
	}
	String r_cmt = "-";
	if(request.getParameter("r_cmt") != null){
		r_cmt = request.getParameter("r_cmt");
	}
	String achivements ="-";
	String improvement = "-";
	
	AllUpdateDAO allupdateDAO = new AllUpdateDAO();
	if(a_cmt.equals("-")){
		boolean result = allupdateDAO.appraisalUpdate1(b_cmt, r_cmt, appraisal_id,status);
		request.setAttribute("appraisal_id", appraisal_id);
		request.getRequestDispatcher("whiteCollarFinalView.jsp").forward(request, response);
	}else{
	boolean result = allupdateDAO.appraisalUpdate(achivements, improvement, a_cmt, b_cmt, r_cmt, appraisal_id);
	request.setAttribute("appraisal_id", appraisal_id);
	request.getRequestDispatcher("whiteCollarEmployeeView.jsp").forward(request, response);
	}
	}

}
