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

/**
 * Servlet implementation class LeaveCancelApprovanceServlet
 */
public class LeaveCancelApprovanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		String leave_status = "Cancelled";
		int leave_id = Integer.parseInt(request.getParameter("leave_id"));
		int emp_id = 0;
		String status = request.getParameter("status");
		System.out.println("Leave_id: "+ leave_id);
		String authority = user.getRoleBean().getRole_authority();
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		
		List<LeaveBean> getEmpId = allLMSListDAO.getLeaveByLeaveId(leave_id);
		for(LeaveBean leaveBean : getEmpId){
		 emp_id = 	leaveBean.getEmployeeBean().getEmployee_master_id();
		}
		
		if(status.equalsIgnoreCase("approved"))
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
				
				
				boolean result = allUpdateDAO.LeaveCancelled(leave_status, leave_id);
				boolean result2 = allUpdateDAO.LeaveCancelUpdate(leave_id, status);
				request.setAttribute("success", "Leave Cancelled Successfully...");
				if(result == true)
				{
					boolean result1 = allUpdateDAO.LeaveUpdateAfterApproved(emp_id, sumCO, sumPL, sumSL, sumWP);
					if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
							|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
							|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
							|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
		
		if(manager_id != 99){
		
		if(manager_id == 1 || manager_id == 2 || manager_id == 3){
			/*request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);*/
			response.sendRedirect("sltlAdmin.jsp");
	}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
		request.getRequestDispatcher("hrHome.jsp").forward(request, response);
		}else{
			/*request.getRequestDispatcher("managerHome.jsp").forward(request, response);*/
			response.sendRedirect("managerHome.jsp");
		}	
	}else{
		if(under_manager_id == 4 || under_manager_id == 117){
			/*request.getRequestDispatcher("hrHome.jsp").forward(request, response);*/
			response.sendRedirect("hrHome.jsp");
		}else{
			/*request.getRequestDispatcher("empHome.jsp").forward(request, response);*/
			response.sendRedirect("empHome.jsp");
					}
				}
				
					}
				
				}
			
			}
			else if(status.equalsIgnoreCase("Rejected"))
			{
				boolean result2 = allUpdateDAO.LeaveCancelUpdate(leave_id, status);
				if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
						|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
						|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
						|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
	
	if(manager_id != 99){
	
	if(manager_id == 1 || manager_id == 2 || manager_id == 3){
		request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
	/*request.getRequestDispatcher("hrHome.jsp").forward(request, response);*/
	response.sendRedirect("hrHome.jsp");
	}else{
		/*request.getRequestDispatcher("managerHome.jsp").forward(request, response);*/
		response.sendRedirect("managerHome.jsp");
	}	
}else{
	if(under_manager_id == 4 || under_manager_id == 117){
		/*request.getRequestDispatcher("hrHome.jsp").forward(request, response);*/
		response.sendRedirect("hrHome.jsp");
	}else{
		/*request.getRequestDispatcher("empHome.jsp").forward(request, response);*/
		response.sendRedirect("empHome.jsp");
				}
			}
		}
		else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}
	}
}
	}
}