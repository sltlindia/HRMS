package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.dao.AllDeleteDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class DeptManagerRemoveServlet
 */
public class DeptManagerRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptTaskId = Integer.parseInt(request.getParameter("deptTaskId"));
		int master_id = Integer.parseInt(request.getParameter("master_id"));
		
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		AllListDAO allListDAO = new AllListDAO();
		ProjectDepartmentTaskBean projectDepartmentTaskBean = allListDAO.getProjectDepartmentDetail(deptTaskId);
		
		int manager_id = projectDepartmentTaskBean.getManagerBean().getManager_id();
		
		
		boolean result = allDeleteDAO.deptTaskRemove(deptTaskId);
		boolean result1 = allUpdateDAO.setMasterTaskIdToZero(master_id,manager_id);
		
		request.setAttribute("success", "Manager view Successfully Removed...");
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		
	}

}
