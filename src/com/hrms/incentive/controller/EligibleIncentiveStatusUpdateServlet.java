package com.hrms.incentive.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.bean.IncentiveSalesPersonListBean;
import com.hrms.incentive.dao.AllIncentiveListDAO;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class EligibleIncentiveStatusUpdateServlet
 */
public class EligibleIncentiveStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String listOfId = request.getParameter("listOfId");
		int sales_id = Integer.parseInt(request.getParameter("sales_id"));
		int month_id = Integer.parseInt(request.getParameter("month_id"));
		int year_id = Integer.parseInt(request.getParameter("year_id"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		double incentive = Double.parseDouble(request.getParameter("incentive"));
		
		System.out.println("listOfId:"+listOfId);
		System.out.println("incentive:"+incentive);
		
		
		AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();
		
		List<IncentiveSalesPersonListBean> listOfIncentiveByHigherAuthority = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, month_id, year_id, product_id);
		
		AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO(); 
		for(IncentiveSalesPersonListBean incentiveSalesPersonListBean : listOfIncentiveByHigherAuthority) {
		boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive,incentiveSalesPersonListBean.getIncentiveBean().getIncentive_id());
		}
		
		List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, month_id , year_id, product_id);
		
		for(IncentiveBean incentiveBean : listOfIncentive) {
		boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive,incentiveBean.getIncentive_id());
		}
		/*String splitValue = split[1];
		
		String[] split1 = splitValue.split("]");
		
		System.out.println("list:"+split1[0]);*/
		
	}

}
