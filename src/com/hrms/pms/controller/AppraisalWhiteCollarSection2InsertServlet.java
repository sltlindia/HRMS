package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteCollarSection2Bean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

public class AppraisalWhiteCollarSection2InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		
		String roles = request.getParameter("Roles");
		String Accomplishments = request.getParameter("Accomplishments");
		String Opportunities = request.getParameter("Opportunities");
		String job_assignment = request.getParameter("job/assignment");
		
		AppraisalBean appraisalBean = new AppraisalBean();
		appraisalBean.setAppraisal_id(appraisal_id);
		
		
		AllListDAO allListDAO = new AllListDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean = allListDAO.getAppraisalSection2QuestionDetail(appraisal_id);
		if(appraisalWhiteCollarSection2Bean != null){
			int section2_id = Integer.parseInt(request.getParameter("section2_id"));
			
			AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean2 = new AppraisalWhiteCollarSection2Bean(section2_id, roles, Accomplishments, Opportunities, job_assignment, appraisalBean);
			boolean result = allInsertDAO.appraisalwhiteSection2Insert(appraisalWhiteCollarSection2Bean2);
			
		}else{
		AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean1 = new AppraisalWhiteCollarSection2Bean(roles, Accomplishments, Opportunities, job_assignment, appraisalBean);
		
		
		boolean result = allInsertDAO.appraisalwhiteSection2Insert(appraisalWhiteCollarSection2Bean1);
		
		System.out.println("EMP ID" + employee_id);
		}
		
		
		request.setAttribute("appraisal_id", appraisal_id);
		request.setAttribute("employee_id", employee_id);
		
		List<WorkGradeBean> listOfWorkGrade = allListDAO.getListOfWorkGrade(appraisal_id);
		
		if(listOfWorkGrade.size() == 0){
		request.getRequestDispatcher("whiteCollarAppraisalSection2.1.jsp").forward(request, response);
		System.out.println("test");
		
		}else{
			request.getRequestDispatcher("whiteCollarEditSection2.1.jsp").forward(request, response);
		}

}

}





