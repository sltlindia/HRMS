package com.hrms.incentive.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.bean.AksharNewBean;
import com.hrms.incentive.bean.AksharNewHistoryBean;
import com.hrms.incentive.bean.AksharRepeatBean;
import com.hrms.incentive.bean.AksharRepeatHistoryBean;
import com.hrms.incentive.bean.BrahmastraNewBean;
import com.hrms.incentive.bean.BrahmastraNewHistoryBean;
import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.BrahmastraRepeatHistoryBean;
import com.hrms.incentive.bean.IncentiveCriteriaBean;
import com.hrms.incentive.bean.IncentiveCriteriaHistoryBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;
import com.hrms.incentive.dao.AllIncentiveListDAO;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;

/**
 * Servlet implementation class IncentiveMasterEditServlet
 */
public class IncentiveMasterEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
		AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();
		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();
		
		Date date1 = new Date();
		
		String date = date1.toString();
		
		
		if(action.equalsIgnoreCase("aksharNew")){
			
			int id = Integer.parseInt(request.getParameter("akshar_new_id"));
			double discount_to = Double.parseDouble(request.getParameter("discount_to"));
			double discount_from = Double.parseDouble(request.getParameter("discount_from"));
			double se_sse = Double.parseDouble(request.getParameter("se_sse"));
			double asm = Double.parseDouble(request.getParameter("asm"));
			double zsm = Double.parseDouble(request.getParameter("zsm"));
			
			AksharNewBean aksharNewBean = new AksharNewBean();
			aksharNewBean.setAkshar_new_id(id);
			
			AksharNewBean a = allIncentiveListDAO.getDetailOfNewAksharById(id);
			AksharNewHistoryBean aksharNewHistoryBean = new AksharNewHistoryBean(a.getDiscount_to(), a.getDiscount_from(), a.getSe_sse(), a.getAsm(), a.getZsm(), date, aksharNewBean);
			boolean result1 = allIncentiveInsertDAO.akshrNewHistoryInsert(aksharNewHistoryBean);
			
			
			aksharNewBean = new AksharNewBean(id, discount_to, discount_from, se_sse, asm, zsm);
			boolean result = allIncentiveUpdateDAO.aksharNewUpdate(aksharNewBean);
			request.setAttribute("colorChanger", action+""+id);
			// request.getRequestDispatcher("incentiveMaster.jsp").forward(request, response);
			response.sendRedirect("incentiveMaster.jsp");
			
			
		}else if(action.equalsIgnoreCase("brahmastraNew")){
			
			
			int id = Integer.parseInt(request.getParameter("brahmastra_new_id"));
			double discount_to = Double.parseDouble(request.getParameter("discount_to"));
			double discount_from = Double.parseDouble(request.getParameter("discount_from"));
			double rsm = Double.parseDouble(request.getParameter("rsm"));
			double asm = Double.parseDouble(request.getParameter("asm"));
			double zsm = Double.parseDouble(request.getParameter("zsm"));
			
			BrahmastraNewBean brahmastraNewBean = new BrahmastraNewBean();
			brahmastraNewBean.setBrahmastra_new_id(id);
			BrahmastraNewBean b = allIncentiveListDAO.getDetailOfNewBrahmastraById(id);
			BrahmastraNewHistoryBean brahmastraNewHistoryBean = new BrahmastraNewHistoryBean(b.getDiscount_to(), b.getDiscount_from(), b.getRsm(), b.getAm(), b.getZsm(), date, brahmastraNewBean);
			boolean result1 = allIncentiveInsertDAO.brahmashtraNewHistoryInsert(brahmastraNewHistoryBean);
			
			
			brahmastraNewBean = new BrahmastraNewBean(id, discount_to, discount_from, rsm, asm, zsm);
			boolean result = allIncentiveUpdateDAO.brahmastraNewUpdate(brahmastraNewBean);
			request.setAttribute("colorChanger", action+""+id);
			// request.getRequestDispatcher("incentiveMaster.jsp").forward(request, response);
			response.sendRedirect("incentiveMaster.jsp");
			
		}else if(action.equalsIgnoreCase("aksharRepeat")){
			
			int id = Integer.parseInt(request.getParameter("akshar_repeat_id"));
			double discount_to = Double.parseDouble(request.getParameter("discount_to"));
			double discount_from = Double.parseDouble(request.getParameter("discount_from"));
			double se_sse = Double.parseDouble(request.getParameter("se_sse"));
			double asm = Double.parseDouble(request.getParameter("asm"));
			double zsm = Double.parseDouble(request.getParameter("zsm"));
			double service = Double.parseDouble(request.getParameter("service"));
			
			AksharRepeatBean aksharRepeatBean = new AksharRepeatBean();
			aksharRepeatBean.setAkshar_repeat_id(id);
			AksharRepeatBean a = allIncentiveListDAO.getDetailOfRepeatAksharById(id);
			AksharRepeatHistoryBean aksharRepeatHistoryBean = new AksharRepeatHistoryBean(a.getDiscount_to(), a.getDiscount_from(), a.getSe_sse(), a.getAsm(), a.getZsm(), a.getService(), date, aksharRepeatBean);
			boolean result1 = allIncentiveInsertDAO.akshrRepeatHistoryInsert(aksharRepeatHistoryBean);
			
			 aksharRepeatBean = new AksharRepeatBean(id, discount_to, discount_from, se_sse, asm, zsm, service);
			boolean result = allIncentiveUpdateDAO.aksharRepeatUpdate(aksharRepeatBean);
			request.setAttribute("colorChanger", action+""+id);
			// request.getRequestDispatcher("incentiveMaster.jsp").forward(request, response);
			response.sendRedirect("incentiveMaster.jsp");
			
		}else if(action.equalsIgnoreCase("brahmastraRepeat")){
			
			int id = Integer.parseInt(request.getParameter("brahmastra_repeat_id"));
			double discount_to = Double.parseDouble(request.getParameter("discount_to"));
			double discount_from = Double.parseDouble(request.getParameter("discount_from"));
			double se_sse = Double.parseDouble(request.getParameter("se_sse"));
			double asm = Double.parseDouble(request.getParameter("asm"));
			double zsm = Double.parseDouble(request.getParameter("zsm"));
			double service = Double.parseDouble(request.getParameter("service"));
			
			BrahmastraRepeatBean brahmastraRepeatBean = new BrahmastraRepeatBean();
			brahmastraRepeatBean.setBrahmastra_repeat_id(id);
			BrahmastraRepeatBean b = allIncentiveListDAO.getDetailOfrepeatBrahmashtraById(id);
			BrahmastraRepeatHistoryBean brahmastraRepeatHistoryBean = new BrahmastraRepeatHistoryBean(b.getDiscount_to(), b.getDiscount_from(), b.getSe_sse(), b.getAsm(), b.getZsm(), b.getService(), date, brahmastraRepeatBean);
			boolean result1 = allIncentiveInsertDAO.brahmashtraRepeatHistoryInsert(brahmastraRepeatHistoryBean);
			
			 brahmastraRepeatBean = new BrahmastraRepeatBean(id, discount_to, discount_from, se_sse, asm, zsm, service);
			boolean result = allIncentiveUpdateDAO.brahmastraRepeatUpdate(brahmastraRepeatBean);
			request.setAttribute("colorChanger", action+""+id);
			//request.getRequestDispatcher("incentiveMaster.jsp").forward(request, response);
			response.sendRedirect("incentiveMaster.jsp");
			
		}else if(action.equalsIgnoreCase("incentiveCriteria")){
			
			int id = Integer.parseInt(request.getParameter("incentive_criteria_id"));
			double target_to = Double.parseDouble(request.getParameter("discount_to"));
			double target_from = Double.parseDouble(request.getParameter("discount_from"));
			double eligible_incentive = Double.parseDouble(request.getParameter("eligible_criteria"));
			
			IncentiveCriteriaBean incentiveCriteriaBean = new IncentiveCriteriaBean();
			incentiveCriteriaBean.setIncentive_criteria_id(id);
			IncentiveCriteriaBean i = allIncentiveListDAO.getDetailOfIncentiveCriteriaById(id);
			IncentiveCriteriaHistoryBean incentiveCriteriaHistoryBean = new IncentiveCriteriaHistoryBean(i.getTarget_to(), i.getTarget_from(), i.getEligible_incentive(), date, incentiveCriteriaBean);
			boolean reslut1 = allIncentiveInsertDAO.incentiveCriteriaHistoryInsert(incentiveCriteriaHistoryBean);
			
			
			 incentiveCriteriaBean = new IncentiveCriteriaBean(id, target_to, target_from, eligible_incentive);
			boolean result = allIncentiveUpdateDAO.incentiveCriteriaUpdate(incentiveCriteriaBean);
			request.setAttribute("colorChanger", action+""+id);
			//request.getRequestDispatcher("incentiveMaster.jsp").forward(request, response);
			response.sendRedirect("incentiveMaster.jsp");
			
			
		}
		
	}

}
