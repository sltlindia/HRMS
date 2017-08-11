package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class KaizenManagementInsertServlet
 */
public class KaizenManagementInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String management_approval_status = "pending";
		String management_rejection_reason = "-";
		
		KaizenBean kaizenBean = new KaizenBean();
		EmployeeBean employeeBean = new EmployeeBean();
		
		kaizenBean.setKaizen_id(kaizen_id);
		employeeBean.setEmployee_master_id(employee_id);
		
		AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
		
		KaizenManagementApprovalBean kaizenManagementApprovalBean = new KaizenManagementApprovalBean(management_approval_status, management_rejection_reason, employeeBean, kaizenBean);
		boolean result = allKaizenInsertDAO.kaizenManagementInsert(kaizenManagementApprovalBean);
	
	
	}

}
