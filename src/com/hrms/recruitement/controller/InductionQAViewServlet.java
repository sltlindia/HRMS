package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.InductionQABean;
import com.hrms.recruitement.bean.PreEmploymentArrangementBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class InductionQAViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int induction_qa_id = Integer.parseInt(request.getParameter("induction_qa_id"));
		System.out.println("induction_qa_id :"+ induction_qa_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<InductionQABean> listofInductionQA = AllRecruitmentListDAO.getListOfInductionQA(induction_qa_id);
		request.setAttribute("induction_qa_id", induction_qa_id);
		request.setAttribute("listofInductionQA", listofInductionQA);
		request.getRequestDispatcher("viewInductionQAForm.jsp").forward(request, response);
	
	
	}

}
