package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;

/**
 * Servlet implementation class LaserSourceInsertServlet
 */
public class LaserSourceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String lasreName = request.getParameter("laserName");
		
		LaserMasterBean laserMasterBean = new LaserMasterBean(lasreName);
		
		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();
		boolean result = allIncentiveInsertDAO.incentiveLaserSourceInsert(laserMasterBean);
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("incentiveMasterAction", "laser");
		session.setAttribute("success", "SuccessFully added");
		response.sendRedirect("incentiveMaster1.jsp");
	
	
	
	}

}
