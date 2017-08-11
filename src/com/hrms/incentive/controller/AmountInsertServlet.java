package com.hrms.incentive.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.SimpleAuxiliaryDatabaseObject;

import com.hrms.incentive.bean.AmountHistoryBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;

/**
 * Servlet implementation class AmountInsertServlet
 */
public class AmountInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double amount = Double.parseDouble(request.getParameter("amount"));
		String date = request.getParameter("date");
		int incentive_id = Integer.parseInt(request.getParameter("incentive_id"));
		
		IncentiveBean incentiveBean = new IncentiveBean();
		incentiveBean.setIncentive_id(incentive_id);
		
		/*Date date = new Date();*/
		
		Date date1 = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			date1 = (Date) dateFormat.parseObject(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();
		
		AmountHistoryBean amountHistoryBean = new AmountHistoryBean(amount, date1, incentiveBean);
		boolean result = allIncentiveInsertDAO.amountInsert(amountHistoryBean);
		
		request.getRequestDispatcher("incentiveView.jsp").forward(request, response);
	
	
	
	}


}
