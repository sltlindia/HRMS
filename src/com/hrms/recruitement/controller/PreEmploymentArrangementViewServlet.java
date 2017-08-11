package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.PreEmploymentArrangementBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class PreEmploymentArrangementViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int pre_employment_arrangement_id = Integer.parseInt(request.getParameter("pre_employment_arrangement_id"));
		System.out.println("pre_employment_arrangement_id:"+pre_employment_arrangement_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<PreEmploymentArrangementBean> listofPreEmploymentArrangement = AllRecruitmentListDAO.getListOfPreEmploymentArrangement(pre_employment_arrangement_id);
		request.setAttribute("pre_employment_arrangement_id", pre_employment_arrangement_id);
		request.setAttribute("listofPreEmploymentArrangement", listofPreEmploymentArrangement);
		request.getRequestDispatcher("viewPreEmploymentArrangementForm.jsp").forward(request, response);
	
	}

}
