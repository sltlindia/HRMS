package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;



public class LeaveApprovedUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
	int leave_id = Integer.parseInt(request.getParameter("leaveid"));
	
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	String leavefromDate = request.getParameter("leavefromDate");
	String leavetoDate = request.getParameter("leavetoDate");
	String purposeOfLeave = request.getParameter("purposeofleave");
	String contactAddress = request.getParameter("contactAddress");
	String contactNumberDuringLeave = request.getParameter("contactNumberDuringLeave");
	String pastFromDate = request.getParameter("pastFromDate");
	String pastToDate = request.getParameter("pastToDate");
	int manager_id =Integer.parseInt(user.getUnder_manager_id());
	int emp_id = Integer.parseInt(request.getParameter("empcode"));
	double day =Double.parseDouble(request.getParameter("daycount"));
	double taotalDays =Double.parseDouble(request.getParameter("totalDays"));
	String mobile_no = request.getParameter("contactNumberDuringLeave");
	
	
	
	LoginDAO loginDAO = new LoginDAO();
	EmployeeBean employeeBean2 = loginDAO.getEmailId(manager_id);
	String EmailId = employeeBean2.getEmail_id();
	String name = user.getFirstname()+" "+user.getLastname();
	
	double daycount = taotalDays - day;
	System.out.println(daycount);
	try {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		Date result = formater.parse(fromDate);
		Date result1 = formater.parse(toDate);
		SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fromDate = AppDateFormat.format(result);
		toDate = AppDateFormat.format(result1);
	} catch (ParseException e1) {
		e1.printStackTrace();
	}		
		
		
	
	AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
	List<LeavecutBalance> leaveCutBalance =(ArrayList<LeavecutBalance>) allLMSListDAO.getListOfCutLeave(leave_id);
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	boolean result = allUpdateDAO.LeaveApproveupdate(purposeOfLeave, fromDate, toDate, day, contactAddress, contactNumberDuringLeave,leave_id,leavefromDate,leavetoDate);
	
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
	
	
	String fd = null;
	String td = null;
	String pfd = null;
	String ptd = null;
	
	
	try 
	{
	  
		SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
		Date result11 = formater1.parse(fromDate);
		Date result22 = formater1.parse(toDate);
		Date result33 = formater1.parse(pastFromDate);
		Date result44 = formater1.parse(pastToDate);
		SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
		fd = formater2.format(result11);
		td = formater2.format(result22);
		pfd = formater2.format(result33);
		ptd = formater2.format(result44);
	
	}
	catch (ParseException e1) 
	{
		e1.printStackTrace();
	}	
	
	String fd1 = fd;
	String td1 = td;
	String pfd1 = pfd;
	String ptd1 = ptd;
	
	new Thread(new Runnable() {
	    @Override
	    public void run() {
		    	String to = EmailId;
		    	String sub = name + " Updated his/her leave";
		    	double days = day;
		    	int emp_code = user.getEmployee_code();
		    
		    	Mailer.approveMail(to, sub, pfd1, ptd1, taotalDays, emp_code, mobile_no, name, fd1, td1, days);
	    }
	}).start();   	
	
	
	
	String ManagerID =  user.getUnder_manager_id();
	String Name = user.getFirstname() + " " + user.getLastname();
	String Leavetype = "Leave";
	String st = "Update";
	 try {
            // open a connection to the site
              URL  url = new URL("http://192.168.182.104/HRMS/send_notification.php?");
              //  URL url = new URL("http://sltlhrms.16mb.com/HRMS/send_notification.php?");
            URLConnection con = url.openConnection();
            // activate the output
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            // send your parameters to your site
          
            ps.print("&manager_id=" + ManagerID);
            ps.print("&Name=" + Name);               
            ps.print("&Leavetype=" + Leavetype);
            ps.print("&st=" + st);
            System.out.println("MANAGER " + ManagerID + " NAME " + Name + " TYPE " + Leavetype);
            

            // we have to get the input stream in order to actually send the request
            con.getInputStream();

            // close the print stream
            ps.close();
      }
	 catch (MalformedURLException e1)
	 {    
		 e1.printStackTrace();
     }
	 catch (IOException e2)
	 {
		 e2.printStackTrace();
	 }
	
	
	
	
	
	
	
	
	
	
	
	request.setAttribute("LeaveSuccessfully", "Your leave successfully updated..");
	if(request.getParameter("action").equalsIgnoreCase("hrSide")){
		response.sendRedirect("pendingLeaveHrSide.jsp");
	}else{
		request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
	}
	
	
	}

}
