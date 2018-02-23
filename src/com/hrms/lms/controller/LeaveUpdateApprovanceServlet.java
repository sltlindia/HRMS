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
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveUpdateApprovanceServlet
 */
public class LeaveUpdateApprovanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			String authority = user.getRoleBean().getRole_authority();
			
		int leave_id = Integer.parseInt(request.getParameter("leave_id"));
		String status = request.getParameter("status");
		int leave_cancel_id = Integer.parseInt(request.getParameter("leave_cancel_id"));
	 
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		LeaveCancelRequestBean leaveCancelRequestBean = allLMSListDAO.getCancelLeaveById(leave_id);
		List<LeaveBean> listOfLeave = allLMSListDAO.getLeaveByLeaveId(leave_id);
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
		
		String pastFromDate = null;
		String pastToDate = null;
		String pastFrom = null;
		String pastTo = null;
		double totalDays = 0;
		
		
		
		
		for(LeaveBean leaveBean  : listOfLeave){
			
			pastFromDate = leaveBean.getLeave_From();
			pastToDate = leaveBean.getLeave_To();
			pastFrom = leaveBean.getFrom_half();
			pastTo = leaveBean.getTo_half();
			totalDays = leaveBean.getDay_count();
			
		}
		
		
		String fromDate = leaveCancelRequestBean.getUpdated_leave_from();
		String toDate = leaveCancelRequestBean.getUpdated_leave_to();
		String fromHalf = leaveCancelRequestBean.getUpdated_from_half();
		String toHalf = leaveCancelRequestBean.getUpdated_to_half();
		Double days = leaveCancelRequestBean.getUpdated_day_count();
		int emp_id = leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getEmployee_master_id();
		
		double daycount = totalDays - days;
		
		if(status.equalsIgnoreCase("approved")){
			
			boolean result = allUpdateDAO.LeaveApprovanceupdate(fromDate, toDate, days,leave_id,fromHalf,toHalf);
			List<LeavecutBalance> leaveCutBalance =(ArrayList<LeavecutBalance>) allLMSListDAO.getListOfCutLeave(leave_id);
			
			double cutCO = 0;
			double cutPL = 0;
			double cutSL = 0;
			double cutWP = 0;
			
			double CO = 0;
			double PL = 0;
			double SL = 0;
			double LWP = 0;
			
			for(LeavecutBalance l : leaveCutBalance){
				CO = cutCO = l.getCO(); 
				PL = cutPL = l.getPL();
				SL = cutSL = l.getSL();
				LWP= cutWP = l.getLWP();
			}
			
			System.out.println(cutCO);
			System.out.println(cutPL);
			System.out.println(cutSL);
			System.out.println(cutWP);

			
			if(cutSL != 0){
				
				if(cutWP!=0 && daycount!=0){
					if(daycount > cutWP){
						daycount = daycount - cutWP;
						cutWP = 0;
					}else{
						cutWP = cutWP - daycount;
						daycount = 0;
					}
				}

				if(cutCO != 0 && daycount!=0){
					if(daycount > cutCO){
						daycount = daycount - cutCO;
						cutCO = 0;
					}else{
						cutCO = cutCO - daycount;
						daycount = 0;
					}
				}
				
				if(cutSL != 0 && daycount!=0){
				if(daycount > cutSL){
					daycount = daycount - cutSL;
					cutSL = 0;
				}else{
					cutSL = cutSL - daycount;
					daycount = 0;
				}
				}
				
				
			}
			
			if(cutPL != 0){
				
				
				if(cutWP != 0 && daycount!=0){
					if(daycount > cutWP){
						daycount = daycount - cutWP;
						cutWP = 0;
					}else{
						cutWP = cutWP - daycount;
						daycount = 0;
					}
				}
				
				
				if(cutPL != 0 && daycount!=0){
				if(daycount > cutPL){
					daycount = daycount - cutPL;
					cutPL = 0;
				}else{
					cutPL = cutPL - daycount;
					daycount = 0;
				}
				}
				
				if(cutCO != 0 && daycount!=0){
					if(daycount > cutCO){
						daycount = daycount - cutCO ;
						cutCO = 0;
					}else{
						cutCO = cutCO - daycount;
						daycount = 0;
					}
				}
				
				
			}
			
			
			if(cutCO != 0){
				
				
				if(cutWP != 0 && daycount!=0){
					if(daycount > cutWP){
						daycount = daycount - cutWP;
						cutWP = 0;
					}else{
						cutWP = cutWP - daycount;
						daycount = 0;
					}
				}
				
				if(cutCO != 0 && daycount!=0){
				if(daycount > cutCO){
					daycount = daycount - cutCO ;
					cutCO = 0;
				}else{
					cutCO = cutCO - daycount;
					daycount = 0;
				}
				}
				
				
			}
			
			if(cutWP != 0 && daycount!=0){
				if(daycount > cutWP){
					daycount = daycount - cutWP;
					cutWP = 0;
				}else{
					cutWP = cutWP - daycount;
					daycount = 0;
				}
			}
			
			
			System.out.println(cutCO);
			System.out.println(cutPL);
			System.out.println(cutSL);
			System.out.println(cutWP);
			System.out.println("emp_id:"+emp_id);
			
			boolean result1 = allUpdateDAO.LeaveCUTUpdateApproved(cutCO, cutPL, cutSL, cutWP,leave_id);
			LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(emp_id);
			double remCO = CO - cutCO;
			double remPL = PL - cutPL;
			double remSL = SL - cutSL;		
			double remLWp = LWP - cutWP;
			
			System.out.println(CO - cutCO);
			System.out.println(PL - cutPL);
			System.out.println(SL - cutSL);
			System.out.println(LWP - cutWP);
			
			double sumCO = remCO + leaveBalanceBean.getCO();
			double sumPL = remPL + leaveBalanceBean.getPlan_Leave();
			double sumSL = remSL + leaveBalanceBean.getUnplan_Leave();
			double sumWP = leaveBalanceBean.getLeave_without_pay() - remLWp;
			boolean result2 = allUpdateDAO.LeaveUpdateAfterApproved(emp_id, sumCO, sumPL, sumSL, sumWP);
			boolean result3 = allUpdateDAO.LeaveApprovanceUpdate(leave_id, status, pastFromDate, pastToDate, pastFrom, pastTo, totalDays);
			
			
			if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
					|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
					|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
					|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {

if(manager_id != 99){

if(manager_id == 1 || manager_id == 2 || manager_id == 3){
	/*request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);*/
	response.sendRedirect("sltlAdmin.jsp");
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
			
			
		}else if(status.equalsIgnoreCase("rejected")){
			
			boolean result = allUpdateDAO.LeaveCancelUpdate(leave_id, status);
			
			if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
					|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
					|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
					|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {

if(manager_id != 99){

if(manager_id == 1 || manager_id == 2 || manager_id == 3){
	/*request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);*/
	response.sendRedirect("sltlAdmin.jsp");
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
		response.sendRedirect("managerHome.jsp");
				}
			}
		
			}
		}
		
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}
		
	}

}
