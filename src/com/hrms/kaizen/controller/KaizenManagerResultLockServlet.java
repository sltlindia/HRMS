package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.bean.KaizenBillboardResultBean;
import com.hrms.kaizen.bean.KaizenManagerScoreBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.kaizen.dao.AllKaizenListDAO;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class KaizenManagerResultLockServlet
 */
public class KaizenManagerResultLockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		int month_id = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		
		System.out.println(employee_id);
		System.out.println(month_id);
		System.out.println(year);
		
		
		AllListDAO allListDAO =  new AllListDAO();
		YearBean yearBean = allListDAO.detailsOfYear(year);
		
		int year_id = yearBean.getYear_id();
		
		MonthBean monthBean = new MonthBean();
		
		monthBean.setMonth_id(month_id);
		
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		
		KaizenManagerScoreBean kaizenManagerScoreBean = allKaizenListDAO.getresultOfBillBordByMonthAndYear(employee_id, month_id, year);
		kaizenManagerScoreBean.setKaizen_manager_score_id(kaizenManagerScoreBean.getKaizen_manager_score_id());
		double total_score = kaizenManagerScoreBean.getTotal();
		
		AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
		
		KaizenBillboardResultBean kaizenBillboardResultBean = new KaizenBillboardResultBean(kaizenManagerScoreBean, monthBean, year,total_score);
		boolean result = allKaizenInsertDAO.kaizenManagerResultnsert(kaizenBillboardResultBean);
		
		
	
	}

}
