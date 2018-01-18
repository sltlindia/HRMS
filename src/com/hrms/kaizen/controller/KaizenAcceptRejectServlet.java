package com.hrms.kaizen.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.KaizenMemberBean;
import com.hrms.kaizen.bean.KaizenReactivationRemarkBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.kaizen.dao.AllKaizenListDAO;
import com.hrms.kaizen.dao.AllKaizenUpdateDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class KaizenAcceptRejectServlet
 */
public class KaizenAcceptRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		int manager_id = user.getManagerBean().getManager_id();
		String status = request.getParameter("value");
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		int employee_id = user.getEmployee_master_id();
		String reason = "-";
		int kaizen_manager_id = Integer.parseInt(request.getParameter("kaizen_manager_id"));
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		LoginDAO loginDAO = new LoginDAO();
		
		EmployeeBean managerInfoBean = loginDAO.getEmailId(kaizen_manager_id);
		
		
		List<KaizenManagerBean> listOfManager = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
		KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
		List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
		
		String affectingmanager = "";
		String teamMembers = "";
		for(KaizenManagerBean k : listOfManager) {
			
			if(affectingmanager.equalsIgnoreCase("")) {
				affectingmanager = k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}else {
			affectingmanager = affectingmanager+","+k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}
		}
		
		
		for(KaizenMemberBean k : listOfMember) {
			
			if(teamMembers.equalsIgnoreCase("")) {
				teamMembers = k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}else {
				teamMembers = teamMembers+","+k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}
		}
		
		String team = teamMembers;
		String managerList = affectingmanager;
		
		
		if(status.equalsIgnoreCase("approved")){
			
			
			
			if(kaizen_manager_id == manager_id){
				boolean result = allKaizenUpdateDAO.kaizenMainApproval(kaizen_id, status, reason);
				
				
				
				for(KaizenManagerBean k : listOfManager) {
					
					int emp_id = k.getEmployeeBean().getEmployee_master_id();
					EmployeeBean bean = loginDAO.getInfoById(emp_id);
					
					
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = bean.getEmail_id();
					    	String sub ="CI Approval Reminder";
					    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
					    	String managername = bean.getFirstname()+" "+bean.getLastname();
					    
					    	Mailer.kaizenAffectingManagerReminder(to, sub, empname,managername,kaizenBean.getKaizen_name(),kaizenBean.getKaizen_desc(),team,kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(),managerList);
					    	System.out.println("Done");
					    	
					    }
					}).start();
				}
				
				
				List<KaizenManagementApprovalBean> listOfKaizenManagement = allKaizenListDAO.getListOfManagemnet(kaizen_id);
				
				for(KaizenManagementApprovalBean k : listOfKaizenManagement) {
					
					int emp_id = k.getEmployeeBean().getEmployee_master_id();
					EmployeeBean bean = loginDAO.getInfoById(emp_id);
					
					
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = bean.getEmail_id();
					    	String sub ="CI Approval Reminder";
					    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
					    	String managername = bean.getFirstname()+" "+bean.getLastname();
					    
					    	Mailer.kaizenAffectingManagerReminder(to, sub, empname,managername,kaizenBean.getKaizen_name(),kaizenBean.getKaizen_desc(),team,kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(),managerList);
					    	System.out.println("Done");
					    	
					    }
					}).start();
				}
				
				
			}else if(kaizenBean.getEmployeeBean().getEmployee_master_id() == user.getEmployee_master_id()) {
				
				boolean result = allKaizenUpdateDAO.kaizenMainApprovalRejetcion(kaizen_id,"pending");
				String reactivationRemark = request.getParameter("reactivationRemark");
				
				AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
				
				KaizenReactivationRemarkBean kaizenReactivationRemarkBean = new KaizenReactivationRemarkBean(reactivationRemark, kaizenBean);
				boolean result1 = allKaizenInsertDAO.kaizenReactivatkionInsert(kaizenReactivationRemarkBean);
				
				new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	String to = managerInfoBean.getEmail_id();
				    	String sub ="CI Approval Reminder";
				    	String empname = user.getFirstname()+" "+user.getLastname();
				    	String managername = managerInfoBean.getFirstname()+" "+managerInfoBean.getLastname();
				    
				    	Mailer.kaizenManagerReminder(to, sub, empname,managername,kaizenBean.getKaizen_name(),kaizenBean.getKaizen_desc(),user.getDepartmentBean().getDepartment_name(),managerList);
				    	System.out.println("Done");
				    	
				    }
				}).start();
				
				
				return;
				
				
			}else{
				
			boolean result = allKaizenUpdateDAO.kaizenApproval(kaizen_id, status, reason, employee_id);
			
			
			}
			
			
			String aStatus = "approved";
			List<KaizenManagerBean> listOfManagerOfKaizen = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
			List<KaizenManagementApprovalBean> listOfManagementOfKaizen = allKaizenListDAO.getListOfManagemnet(kaizen_id);
			for(KaizenManagerBean kaizenManagerBean :  listOfManagerOfKaizen) {
				if(kaizenManagerBean.getStatus().equalsIgnoreCase("pending")) {
					aStatus = "pending";
				}else if(kaizenManagerBean.getStatus().equalsIgnoreCase("rejected")) {
					aStatus = "rejected";
				}
			}
			
			
			for(KaizenManagementApprovalBean kaizenManagerBean :  listOfManagementOfKaizen) {
				if(kaizenManagerBean.getManagement_approval_status().equalsIgnoreCase("pending")) {
					aStatus = "pending";
				}else if(kaizenManagerBean.getManagement_approval_status().equalsIgnoreCase("rejected")) {
					aStatus = "rejected";
				}
			}
			
			if(!aStatus.equalsIgnoreCase("pending")) {
				boolean result = allKaizenUpdateDAO.kaizenMainApprovalRejetcion(kaizen_id, aStatus);
				if(aStatus.equalsIgnoreCase("approved")) {
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = kaizenBean.getEmployeeBean().getEmail_id();
					    	String sub ="Your CI is approved";
					    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
					    	
					    	LoginDAO loginDAO = new LoginDAO();
					    	EmployeeBean bean = loginDAO.getEmailId(Integer.parseInt(kaizenBean.getEmployeeBean().getUnder_manager_id()));
					    	
					    	String managername = bean.getFirstname()+" "+bean.getLastname();
					    
					    	Mailer.kaizenEmployeeSend(to, sub, empname, managername, kaizenBean.getKaizen_name(), kaizenBean.getKaizen_desc(), team, kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(), managerList);
					    	System.out.println("Done");
					    	
					    }
					}).start();
					
					
					if(kaizen_manager_id != manager_id) {
						
						new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	
						    	String to = managerInfoBean.getEmail_id();
						    	String sub ="Your Team Member CI is Approved";
						    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
						    	
						    	LoginDAO loginDAO = new LoginDAO();
						    	EmployeeBean bean = loginDAO.getEmailId(Integer.parseInt(kaizenBean.getEmployeeBean().getUnder_manager_id()));
						    	
						    	String managername = bean.getFirstname()+" "+bean.getLastname();
						    
						    	Mailer.kaizenEmployeeApprovedNotificationToManagerSend(to, sub, empname, managername, kaizenBean.getKaizen_name(), kaizenBean.getKaizen_desc(), team, kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(), managerList);
						    	System.out.println("Done");
						    	
						    }
						}).start();
						
						
					}
					
				}
			}
			
			
		}else if(status.equalsIgnoreCase("rejected")){
			
			reason = request.getParameter("reason");
			
			if(kaizen_manager_id == manager_id){
				boolean result = allKaizenUpdateDAO.kaizenMainApproval(kaizen_id, status, reason);
			}else{
				boolean result = allKaizenUpdateDAO.kaizenApproval(kaizen_id, status, reason, employee_id);
			}
			
			
			
			
			
			
			List<KaizenManagerBean> listOfManagerOfKaizen = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
			List<KaizenManagementApprovalBean> listOfManagementOfKaizen = allKaizenListDAO.getListOfManagemnet(kaizen_id);
			String aStatus = "Rejected";
			
			
			if(!aStatus.equalsIgnoreCase("pending")) {
				String res = reason;
				boolean result = allKaizenUpdateDAO.kaizenMainApprovalRejetcion(kaizen_id, aStatus);
				if(aStatus.equalsIgnoreCase("rejected")) {
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = kaizenBean.getEmployeeBean().getEmail_id();
					    	String sub ="Your CI is Rejected";
					    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
					    	
					    	
					    	LoginDAO loginDAO = new LoginDAO();
					    	EmployeeBean bean = loginDAO.getEmailId(Integer.parseInt(kaizenBean.getEmployeeBean().getUnder_manager_id()));
					    	
					    	String managername = bean.getFirstname()+" "+bean.getLastname();
					    
					    	Mailer.kaizenEmployeeRejectedSend(to, sub, empname, managername, kaizenBean.getKaizen_name(), kaizenBean.getKaizen_desc(), team, kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(), managerList,res);
					    	System.out.println("Done");
					    	
					    }
					}).start();
				}
				
				
				if(kaizen_manager_id != manager_id) {
					
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = managerInfoBean.getEmail_id();
					    	String sub ="Your Team Member CI is Rejected";
					    	String empname = kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname();
					    	
					    	LoginDAO loginDAO = new LoginDAO();
					    	EmployeeBean bean = loginDAO.getEmailId(Integer.parseInt(kaizenBean.getEmployeeBean().getUnder_manager_id()));
					    	
					    	String managername = bean.getFirstname()+" "+bean.getLastname();
					    	String deptName = user.getDepartmentBean().getDepartment_name();
					    	String deptHODName = user.getFirstname()+" "+user.getLastname();
					    
					    	Mailer.kaizenEmployeeRejectedNotificationToManagerSend(to, sub, empname, managername, kaizenBean.getKaizen_name(), kaizenBean.getKaizen_desc(), team, kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name(), managerList,res,deptName,deptHODName);
					    	System.out.println("Done");
					    	
					    }
					}).start();
					
					
				}
				
				
			}
			
			
		}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
