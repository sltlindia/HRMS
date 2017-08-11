package com.hrms.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class LeaveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeaveDeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		String status = "Cancelled";
		int leave_id = Integer.parseInt(request.getParameter("leave_id"));
		int emp_id = 0;
		String leave_status = request.getParameter("status");
		System.out.println("Leave_id: "+ leave_id);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		
		List<LeaveBean> getEmpId = allLMSListDAO.getLeaveByLeaveId(leave_id);
		for(LeaveBean leaveBean : getEmpId){
		 emp_id = 	leaveBean.getEmployeeBean().getEmployee_master_id();
		}
		
		if(leave_status.equalsIgnoreCase("approved"))
		{
			
				List<LeavecutBalance> l =(ArrayList<LeavecutBalance>) allLMSListDAO.getListOfCutLeave(leave_id);
				LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(emp_id);
				double cutCO = 0;
				double cutPL = 0;
				double cutSL = 0;
				double cutWP = 0;
				
					double Co_Leave = leaveBalanceBean.getCO();
					double Plan_Leave = leaveBalanceBean.getPlan_Leave();
					double unplan_Leave = leaveBalanceBean.getUnplan_Leave();
					double LWP = leaveBalanceBean.getLeave_without_pay();
				
				for (LeavecutBalance c : l)	
					{
						cutCO = c.getCO();
						cutPL =c.getPL();
						cutSL = c.getSL();
						cutWP = c.getLWP();
						
					}
				
				System.out.println("cutco:"+cutCO);
				System.out.println("cutPL:"+cutPL);
				System.out.println("cutSL:"+cutSL);
				System.out.println("cutWP:"+cutWP);
				
				System.out.println("Co_Leave:"+Co_Leave);
				System.out.println("Plan_Leave:"+Plan_Leave);
				System.out.println("unplan_Leave:"+unplan_Leave);
				System.out.println("LWP:"+LWP);
				
				
				double sumCO = cutCO + Co_Leave;
				double sumPL = cutPL + Plan_Leave;
				double sumSL = cutSL + unplan_Leave;
				double sumWP = LWP - cutWP;
				
				System.out.println("sumCO:"+sumCO);
				System.out.println("sumPL:"+sumPL);
				System.out.println("sumSL:"+sumSL);
				System.out.println("sumWP:"+sumWP);
				
				
				boolean result = allUpdateDAO.LeaveCancelled(status, leave_id);
				request.setAttribute("success", "Leave Cancelled Successfully...");
				if(result == true)
				{
					boolean result1 = allUpdateDAO.LeaveUpdateAfterApproved(emp_id, sumCO, sumPL, sumSL, sumWP);
					if(request.getParameter("action") != null){
						request.getRequestDispatcher("pendingLeaveHrSide.jsp").forward(request, response);
					}else{
					request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
					}
				}
			
			}
			else if(leave_status.equalsIgnoreCase("Pending") || leave_status.equalsIgnoreCase("Rejected"))
			{
				status = "Cancelled";
				boolean result = allUpdateDAO.LeaveCancelled(status, leave_id);
				request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
