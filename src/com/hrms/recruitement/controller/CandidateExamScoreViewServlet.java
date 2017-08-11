package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.CandidateExamScoreBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class CandidateExamScoreViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int candidate_exam_score_id = Integer.parseInt(request.getParameter("candidate_exam_score_id"));
		System.out.println("candidate_exam_score_id :"+ candidate_exam_score_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<CandidateExamScoreBean> listofCandidateExamScore = AllRecruitmentListDAO.getListOfCandidateExamScore(candidate_exam_score_id);
		request.setAttribute("candidate_exam_score_id", candidate_exam_score_id);
		request.setAttribute("listofCandidateExamScore", listofCandidateExamScore);
		request.getRequestDispatcher("viewCandidateExamScoreForm.jsp").forward(request, response);
	
	}

}
