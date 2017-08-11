package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class ViewInterviewFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int interview_id = Integer.parseInt(request.getParameter("i_id"));
		System.out.println("i_id:"+interview_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<InterviewFeedbackBean> listofInterviewFeedback = AllRecruitmentListDAO.getListOfInterviewFeedback1(interview_id);
		request.setAttribute("interview_id", interview_id);
		request.setAttribute("listofInterviewFeedback", listofInterviewFeedback);
		request.getRequestDispatcher("ViewInterviewFeedbackForm.jsp").forward(request, response);
	}
}




