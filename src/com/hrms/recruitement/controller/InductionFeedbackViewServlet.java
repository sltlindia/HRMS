package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InductionFeedbackBean;
import com.hrms.recruitement.bean.PreEmploymentArrangementBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class InductionFeedbackViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int induction_feedback_id = Integer.parseInt(request.getParameter("induction_feedback_id"));
		System.out.println("induction_feedback_id:"+induction_feedback_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<InductionFeedbackBean> listofInductionFeedback = AllRecruitmentListDAO.getListOfInductionFeedback(induction_feedback_id);
		request.setAttribute("induction_feedback_id", induction_feedback_id);
		request.setAttribute("listofInductionFeedback", listofInductionFeedback);
		request.getRequestDispatcher("viewInductionFeedbackForm.jsp").forward(request, response);
		
	}

}
