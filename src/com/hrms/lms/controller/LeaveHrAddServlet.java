package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveAdjustBalanceBean;
import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.dao.AllLMSListDAO;

/**
 * Servlet implementation class LeaveHrAddServlet
 */
public class LeaveHrAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int empcode = Integer.parseInt(request.getParameter("empcode"));
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		
		System.out.println("Emp Code" + empcode);
		
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allListDAO.getleaveListbyEMPCodeAndCopanyID(empcode,companyId);
		if(leaveBalanceBean != null){
			
		String fristname = leaveBalanceBean.getEmployeeBean().getFirstname();
		String lasttname = leaveBalanceBean.getEmployeeBean().getLastname();
		int emp_id = leaveBalanceBean.getEmployeeBean().getEmployee_master_id();
		String name = fristname + " " + lasttname;
	/*	List<LeaveBean> listOfLeave = allListDAO.getLeaveByLeaveId(leave_id);*/
		List<LeaveAdjustBalanceBean> listOfAdjustHrBalance = allListDAO.getLeaveAdjustByEmpId(emp_id);
		request.setAttribute("leaveBalanceBean", leaveBalanceBean);
		request.setAttribute("listOfAdjustHrBalance", listOfAdjustHrBalance);
		
		request.setAttribute("empcode", empcode);
		request.setAttribute("name", name);
		request.setAttribute("companyId", companyId);
		}else{
			request.setAttribute("LeaveExist", "No Employee is exist for this Employee code");
		}
		request.getRequestDispatcher("leaveadjustHR.jsp").forward(request, response);
	}

}
