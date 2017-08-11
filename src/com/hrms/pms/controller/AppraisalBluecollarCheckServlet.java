package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class AppraisalBluecollarCheckServlet
 */
public class AppraisalBluecollarCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
		int employee_id = Integer.parseInt(request.getParameter("employee_master_id"));
		int month_id = Integer.parseInt(request.getParameter("month_id"));
		int year_id = Integer.parseInt(request.getParameter("year_id"));
		int q_id = Integer.parseInt(request.getParameter("q_id"));
		AllListDAO  allListDAO = new AllListDAO();
		List<AppraisalLeaveBean> listOfLeave = allListDAO.getappraisalLeave(appraisal_id);
		if(listOfLeave.size() == 0)
		{
			/*request.setAttribute("appraisal_id", appraisalBean.getAppraisal_id());*/
			request.setAttribute("month_id", month_id);
			request.setAttribute("year_id", year_id);
			request.setAttribute("q_id", q_id);
			request.setAttribute("employee_id", employee_id);
			request.setAttribute("appraisal_id", appraisal_id);
			request.getRequestDispatcher("blueCollarAppraisalSection1.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("blueCollarEditSection1.jsp").forward(request, response);
		}
		
	
	
	}

}
