package com.hrms.lms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hrms.lms.bean.LeaveAfterAddBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllDeleteDAO;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class LeaveUpdateServlet
 */
public class LeaveUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		AllListDAO allListDAO2 = new AllListDAO();
		
		LoginDAO loginDAO = new LoginDAO();
		if(user != null)
		{
			int Leave_id = 0 , Emp_MasterID = 0 , LeaveType = 0 , month_id = 0 , Approval_By = 0 ,empid = 0;
			String Status  = null , reason = null;
			double CO = 0 , PL = 0 , SL = 0 , LWP = 0;
			double BCO = 0 , BPL = 0 , BSL = 0 ;
			double CONSTANTDAY = 9 , DEFF = 0;
			double SELECTDAY = 3, unplanLeave = 0, planLeave = 0, PLAN = 0, UNPLAN = 0 , TOTALPLANUNPLA = 0 , daycount = 0;
			double ADJDAY = 0 ,COPY = 0 , days = 0, aaaaa = 0;
			double MAINCO = 0 , MAINPL = 0 , MAINSL = 0 , MAIN_LWP = 0;
			double TEMPDAY = 0;
			Status = request.getParameter("status");
			
			LeaveType = Integer.parseInt(request.getParameter("leavetypeid"));
			CO = Double.parseDouble(request.getParameter("CO"));
			PL = Double.parseDouble(request.getParameter("plan"));
			SL = Double.parseDouble(request.getParameter("unplan"));
			LWP = Double.parseDouble(request.getParameter("LWP"));
			days = Double.parseDouble(request.getParameter("numdays"));
			Leave_id = Integer.parseInt(request.getParameter("leaveid"));
			Emp_MasterID =  Integer.parseInt(request.getParameter("employee_master_id"));
			month_id = Integer.parseInt(request.getParameter("month_id"));
			reason = request.getParameter("remarks");
			empid = Integer.parseInt(request.getParameter("empcode"));
			String colunmname1 = "CO";
			String colunmname2 = "Plan_Leave";
			String colunmname3 = "Unplan_Leave";
			String colunmname4 = "Leave_without_pay";
			int mail_view = 1;
			
			TEMPDAY = days;
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date today = Calendar.getInstance().getTime();  
			String date1= dateFormat.format(today);
			
			String Approval_Date = null;
			String currentdate = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String approvalDate = sdf.format(date);
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			String unplanstartDate = null;
			String unplanendDate = null;
			
			if(month_id==1 || month_id==3 ||month_id==5 ||month_id==7 ||month_id==8)
			{
				unplanstartDate = year+"-0"+month_id+"-01";
				unplanendDate = year+"-0"+month_id+"-31";
			}
			else if(month_id==4 ||month_id==6 ||month_id==9)
			{
				unplanstartDate = year+"-0"+month_id+"-01";
				unplanendDate = year+"-0"+month_id+"-30";
			}
			else if(month_id==10 || month_id==12)
			{
				unplanstartDate = year+"-"+month_id+"-01";
				unplanendDate = year+"-"+month_id+"-31";
			}
			if(month_id == 11)
			{
				unplanstartDate = year+"-"+month_id+"-01";
				unplanendDate = year+"-"+month_id+"-30";
			}
			if(month_id==2)
			{
				if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
				{
					unplanstartDate = year+"-0"+month_id+"-01";
					unplanendDate = year+"-0"+month_id+"-29";
				}
				else
				{
					unplanstartDate = year+"-0"+month_id+"-01";
					unplanendDate = year+"-0"+month_id+"-28";
				}
			}
	
			
			
			
			List<LeaveBean> listOfLeave = allLMSListDAO.getUnplanListPerMonth(unplanstartDate, unplanendDate, Emp_MasterID);
			for(LeaveBean leaveBean2 : listOfLeave)
			{
				int id = leaveBean2.getLeave_id();	
				List<LeavecutBalance> listOfUnplanLeave = allLMSListDAO.getListOfCutLeave(id);
				for(LeavecutBalance lll : listOfUnplanLeave)
				{
					double leave = lll.getSL();
					double pl =  lll.getCO() + lll.getMain_PL() + lll.getSL() + lll.getLWP();
					
					System.out.println("leave" + leave);	
					unplanLeave = unplanLeave + leave;
					planLeave = planLeave + lll.getPL();
					PLAN = PLAN + lll.getPL();
					UNPLAN = UNPLAN + lll.getSL();
				}
			}
			TOTALPLANUNPLA = PLAN + UNPLAN;
			System.out.println("Total PL And SL " + TOTALPLANUNPLA);
			
			EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(empid);
			 String EmailId = employeeBean2.getEmail_id();
			 int emp_code = employeeBean2.getEmployee_code();
			 String name = employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
			
			List<LeaveBean> leaveInfo = allListDAO2.getLeaveByLeaveId(Leave_id);
			String to = null;
			String from = null;
			int code = 0;
			for(LeaveBean l : leaveInfo){
				to = l.getLeave_To();
				from =l.getLeave_From();
				Approval_By = l.getUnder_manager_id();
				
				EmployeeBean employeeBean = loginDAO.getEmailId(Approval_By);
				code = employeeBean.getEmployee_code();
			}
			
			
			String lfff = null;
		String tlll = null;
		
		try 
		{
		  
			SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
			Date result1 = formater1.parse(from);
			Date result2 = formater1.parse(to);
			SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
			lfff = formater2.format(result1);
			tlll = formater2.format(result2);
		
		}
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}	
			
		if(Status.equals("approved"))
		{	
			if(LeaveType == 1) // PLAN  CODE ...... NEW CODE CREATE DATE 04/02/2016 //
			{
				
					/*if(CO > days)
					{
						CO = CO - days;
						ADJDAY = 0;
						BCO = days;
					}
					else if(CO <= days)
					{
						BCO = CO;
						ADJDAY = days - CO;
						CO = 0;
					}	
					
					double aaaa = TOTALPLANUNPLA + ADJDAY;
					if(aaaa >= 9)
					{
						aaaaa = aaaa - 9;	
						ADJDAY = 9 - TOTALPLANUNPLA;
					}
					
					
					if(ADJDAY != 0)
					{
						if((CO == 0) && (PL != 0))
						{							
							if(PL > ADJDAY)
							{	
								if(PL > 9)
								{	
									if(ADJDAY > 9)
									{
										PL = PL - CONSTANTDAY;
										ADJDAY = ADJDAY - CONSTANTDAY;
										BPL = CONSTANTDAY;
									}
									else if(ADJDAY <= 9)
									{
										BPL = ADJDAY;
										PL = PL - ADJDAY;
										ADJDAY = 0;
									}
								}
								else if(PL <= 9)
								{
									BPL = ADJDAY;
									PL = PL - ADJDAY;
									ADJDAY = 0;
								}		
							}
							else if(PL <= ADJDAY)
							{
								if(PL > 9)
								{
									if(ADJDAY > 9)
									{
										PL = ADJDAY - CONSTANTDAY;
										ADJDAY = ADJDAY - CONSTANTDAY;
									}
								}
								else if(PL <= 9)
								{
									COPY = CONSTANTDAY - PL;
									ADJDAY = ADJDAY - PL;
									BPL = PL;
									PL = 0;
								}
							}
						}
						else
						{
							COPY = 0;
							BPL = PL;
						}
					}
					if(ADJDAY != 0)
					{
						if(SL != 0)
						{
							
							if((PL == 0) && (COPY == 0))
							{
								if(SL > ADJDAY)
								{
									if(ADJDAY > 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
									else if(ADJDAY <= 7)
									{
										SL = SL - ADJDAY;
										BSL = ADJDAY;
										ADJDAY = 0;
										BSL = SL;
										SL = SL - COPY;
										//ADJDAY = 0;
										
										
									}
								}
								else if(SL <= ADJDAY)
								{
									if(ADJDAY > 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
									else if(ADJDAY <= 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
																	
								}
							}
							else
							{
								if(SL > ADJDAY)
								{
									if(COPY > ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL <= COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;	
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
											}
											else if(SL <= COPY)
											{
											
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
												
											}
										}
									}
									
									else if(COPY <= ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												if(COPY > ADJDAY)
												{
													SL = SL - COPY;
													BSL = COPY;
													ADJDAY = 0;
												}
												else if(COPY <= ADJDAY)
												{
													SL = SL - COPY;
													ADJDAY = ADJDAY - COPY;
													BSL = COPY;
												}
											}
											else if(SL <= COPY)
											{
											
											}
										}
									}							
								}
								else if(SL <= ADJDAY)
								{
									if(COPY > ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
												ADJDAY = ADJDAY -SL;
												BSL = SL;
												SL = 0;
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
											
											}
											else if(SL <= COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
												
											}
										}
									}
									else if(COPY <= ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
												BSL = SL;
												ADJDAY = ADJDAY - SL;
												SL = 0;
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												SL = SL - COPY;
												BSL = COPY;
												ADJDAY = ADJDAY - COPY;
											}
											else if(SL <= COPY)
											{
												ADJDAY = ADJDAY - SL;
												SL = 0;
												BSL = COPY;
												ADJDAY = ADJDAY - SL;
												SL = 0;
											}
										}
									}	
								}
							}
						}
						else
						{
							BSL = SL;
						}
					}
					ADJDAY = ADJDAY + aaaaa;*/
					
					LocalDate leaveStart = LocalDate.parse(from);
					LocalDate leaveEnd = LocalDate.parse(to);
					
					if(TOTALPLANUNPLA >= 9)
					{
						if(CO > days)
						{
							CO = CO - days;
							ADJDAY = 0;
							BCO = days;
						}
						else if(CO <= days)
						{
							BCO = CO;
							ADJDAY = days - CO;
							CO = 0;
						}
						else
						{
							ADJDAY = days;
						}
						
					}
					else
					{
						
					
					if(CO > days)
					{
						CO = CO - days;
						ADJDAY = 0;
						BCO = days;
					}
					else if(CO <= days)
					{
						BCO = CO;
						ADJDAY = days - CO;
						CO = 0;
					}	
					
					double aaaa = TOTALPLANUNPLA + ADJDAY;
					if(aaaa >= 9)
					{
						aaaaa = aaaa - 9;	
						ADJDAY = 9 - TOTALPLANUNPLA;
					}
					
					
					if(ADJDAY != 0)
					{
						if((CO == 0) && (PL != 0))
						{
							if(PL > ADJDAY)
							{	
								if(PL > 9)
								{	
									if(ADJDAY > 9)
									{
										PL = PL - CONSTANTDAY;
										ADJDAY = ADJDAY - CONSTANTDAY;
										BPL = CONSTANTDAY;
									}
									else if(ADJDAY <= 9)
									{
										BPL = ADJDAY;
										PL = PL - ADJDAY;
										ADJDAY = 0;
									}
								}
								else if(PL <= 9)
								{
									BPL = ADJDAY;
									PL = PL - ADJDAY;
									ADJDAY = 0;
								}		
							}
							else if(PL <= ADJDAY)
							{
								if(PL > 9)
								{
									if(ADJDAY > 9)
									{
										PL = ADJDAY - CONSTANTDAY;
										ADJDAY = ADJDAY - CONSTANTDAY;
									}
								}
								else if(PL <= 9)
								{
									COPY = CONSTANTDAY - PL;
									ADJDAY = ADJDAY - PL;
									BPL = PL;
									PL = 0;
								}
							}
						}
						else
						{
							COPY = 0;
							BPL = PL;
						}
					}
					if(ADJDAY != 0)
					{
						if(SL != 0)
						{
							
							if((PL == 0) && (COPY == 0))
							{
								if(SL > ADJDAY)
								{
									if(ADJDAY > 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
									else if(ADJDAY <= 7)
									{
										SL = SL - ADJDAY;
										BSL = ADJDAY;
										ADJDAY = 0;
										/*BSL = SL;
										SL = SL - COPY;
										//ADJDAY = 0;*/
										
										
									}
								}
								else if(SL <= ADJDAY)
								{
									if(ADJDAY > 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
									else if(ADJDAY <= 7)
									{
										ADJDAY = ADJDAY - SL;
										BSL = SL;
										SL = 0;
									}
																	
								}
							}
							else
							{
								if(SL > ADJDAY)
								{
									if(COPY > ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL <= COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;	
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
											}
											else if(SL <= COPY)
											{
											
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
												
											}
										}
									}
									
									else if(COPY <= ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												if(COPY > ADJDAY)
												{
													SL = SL - COPY;
													BSL = COPY;
													ADJDAY = 0;
												}
												else if(COPY <= ADJDAY)
												{
													SL = SL - COPY;
													ADJDAY = ADJDAY - COPY;
													BSL = COPY;
												}
											}
											else if(SL <= COPY)
											{
											
											}
										}
									}							
								}
								else if(SL <= ADJDAY)
								{
									if(COPY > ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
												ADJDAY = ADJDAY -SL;
												BSL = SL;
												SL = 0;
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
											
											}
											else if(SL <= COPY)
											{
												SL = SL - ADJDAY;
												BSL = ADJDAY;
												ADJDAY = 0;
												
											}
										}
									}
									else if(COPY <= ADJDAY)
									{
										if(COPY > 7)
										{
											if(SL > COPY)
											{
											}
											else if(SL <= COPY)
											{
												BSL = SL;
												ADJDAY = ADJDAY - SL;
												SL = 0;
											}
										}
										else if(COPY <= 7)
										{
											if(SL > COPY)
											{
												SL = SL - COPY;
												BSL = COPY;
												ADJDAY = ADJDAY - COPY;
											}
											else if(SL <= COPY)
											{
												/*ADJDAY = ADJDAY - SL;
												SL = 0;*/
												BSL = COPY;
												ADJDAY = ADJDAY - SL;
												SL = 0;
											}
										}
									}	
								}
							}
						}
						else
						{
							BSL = SL;
						}
					}
				}
					ADJDAY = ADJDAY + aaaaa;
					System.out.println("CO " + CO + "PL " + PL + " UPL " + SL + "LWP " + LWP);
					System.out.println("CUT CO " + BCO + " CUT PL " + BPL + "CUT SL " + BSL + " ADD LWP " + ADJDAY);
					
					
					MAIN_LWP = ADJDAY + LWP;
					
					
					System.out.println("ADJ " + ADJDAY);
					
					System.out.println("AFTER CUT BALANCE " + MAINCO +  " " + MAINPL + " " + MAINSL + " " + MAIN_LWP);
					boolean	result = allUpdateDAO.Leavesendwitchroulupdate(BCO, BPL, BSL, ADJDAY, CO, PL, SL, MAIN_LWP, Leave_id);										
					boolean result1 = allUpdateDAO.LeaveUpdateStatus(Status , Leave_id, approvalDate);
					boolean result2 = allUpdateDAO.LeaveUpdate1(colunmname1, CO, colunmname2, PL, colunmname3, SL, colunmname4, MAIN_LWP, Emp_MasterID);
					
					if(result == true && result1 == true && result2 == true)
					{
						System.out.println("Successfully");
						request.setAttribute("LeaveapprovedSuccessfully", "Leave approved Successfully");
						
						if(request.getAttribute("action") == null)
						{
							
							String to1 = to;
							String from1 = from;
							double days1 = daycount;
							String reason1 = reason;
							System.out.println("EmailID:"+ EmailId);
						 
						
						
							/* new Thread(new Runnable() {
								    @Override
								    public void run() {
								    	
								    	String to = EmailId;
								    	String sub = name+" your Leave Accepted";
								    	double days = days1;
								    	String leavefrom = from1;
								    	String leaveto = to1 ;
								    	String status = "Accepted";
								    		
								    	Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason1,emp_code);
								    	
								    }
								}).start();
						*/
						
						}
							if(request.getParameter("hrApproval") != null)
							{
								request.setAttribute("success", "Leave Successfully Approved");
								request.getRequestDispatcher("pendingLeaveHrSide.jsp").forward(request, response);
							}else if(request.getParameter("specialLeave") != null){
								request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
							}
							else
							{
								request.getRequestDispatcher("leaveListManager.jsp").forward(request, response);
							}
						}
					
					
					
					
					
				}
				else if(LeaveType == 5) // UNPLAN CODE ...... NEW CODE CREATE DATE 04/02/2016 //
				{
					SELECTDAY = 3;
				
				if(unplanLeave >= 3)
				{
					
					if(CO != 0)
					{
						if(CO > days)
						{
							CO = CO - days;
							ADJDAY = 0;
							BCO = days;
						}	
						else if(CO <= days)
						{
							BCO = CO;
							ADJDAY = days - CO;
							CO = 0;
						}		
					}
					else
					{
						ADJDAY = days;
					}
					
				}
				else
				{
					if(TOTALPLANUNPLA >= 9)
					{
						if(CO > days)
						{
							CO = CO - days;
							ADJDAY = 0;
							BCO = days;
						}
						else if(CO <= days)
						{
							BCO = CO;
							ADJDAY = days - CO;
							CO = 0;
						}
						else
						{
							ADJDAY = days;
						}
					}
					else
					{
						if(TOTALPLANUNPLA == 0)
						{
							SELECTDAY = SELECTDAY - unplanLeave;
						}
						else if(TOTALPLANUNPLA >= 6 && TOTALPLANUNPLA <= 9)
						{
							SELECTDAY = CONSTANTDAY - TOTALPLANUNPLA ;
						}
						else
						{
							SELECTDAY = SELECTDAY - unplanLeave;
						}
					
						if(SL != 0)
						{
							if(SL > days)		
							{
								if(days > SELECTDAY)
								{
									if(SL > SELECTDAY)
									{
										BSL = SELECTDAY;
										SL = SL - SELECTDAY;
										ADJDAY = days - SELECTDAY;
												
										if(CO != 0)
										{
											if(CO > ADJDAY)
											{
												BCO = ADJDAY;
												CO = CO - ADJDAY;
												ADJDAY = 0;
											}
											else if(CO <= ADJDAY)
											{
												
												BCO = CO;
												ADJDAY = ADJDAY - CO;
												CO = 0;
												
											}
											
										}
									}
									else
									{
										SL = SL - days;
										ADJDAY = 0;									
									}
								}
								else
								{
									if(SL > SELECTDAY)
									{	
										BSL = days;
										SL = SL - days;
										ADJDAY = 0;		
									}
									else
									{
										BSL = days;
										SL = SL - days;
										ADJDAY = 0;									
									}
								}
							}
							else if(SL <= days)
							{
								if(days > SELECTDAY)
								{
									if(SL > SELECTDAY)
									{
										BSL = SELECTDAY;
										SL = SL - SELECTDAY;
										ADJDAY = days - SELECTDAY;
																														
										if(CO != 0)
										{
											if(CO > ADJDAY)
											{
												BCO = ADJDAY;
												CO = CO - ADJDAY;
												ADJDAY = 0;
											}
											else if(CO <= ADJDAY)
											{
												
												BCO = CO;
												ADJDAY = ADJDAY - CO;
												CO = 0;
												
											}
											
										}
									}
									else
									{
										ADJDAY = days - SL;
										BSL = SL;
										SL = 0;
									
										if(CO != 0)
										{
											if(CO > ADJDAY)
											{
												BCO = ADJDAY;
												CO = CO - ADJDAY;
												ADJDAY = 0;
											}
											else if(CO <= ADJDAY)
											{
												
												BCO = CO;
												ADJDAY = ADJDAY - CO;
												CO = 0;
												
											}
											
										}																		
									}
								}
								else
								{
									if(SL > SELECTDAY)
									{
									}
									else
									{
										if(SL > days)
										{
											SL = SL - days;
											BSL = days;
											ADJDAY = 0;
										}
										else
										{
											ADJDAY = days - SL;
											BSL = SL;
											SL = 0;
											
											if(CO != 0)
											{
												if(CO > ADJDAY)
												{
													BCO = ADJDAY;
													CO = CO - ADJDAY;
													ADJDAY = 0;
												}
												else if(CO <= ADJDAY)
												{
													
													BCO = CO;
													ADJDAY = ADJDAY - CO;
													CO = 0;
													
												}
												
											}		
										}		
									}
								}
							}
						}
						else
						{
							if(CO != 0)
							{
								if(CO > days)
								{
									CO = CO - days;
									ADJDAY = 0;
									BCO = days;
								}	
								else if(CO <= days)
								{
									BCO = CO;
									ADJDAY = days - CO;
									CO = 0;
								}		
							}
							else
							{
								ADJDAY = days;
							}
						}
					}
				}
				
				
				MAIN_LWP = ADJDAY + LWP;
				System.out.println("CO " + CO + "PL " + PL + " UPL " + SL + "LWP " + ADJDAY);
				
				
				
				boolean	result = allUpdateDAO.Leavesendwitchroulupdate(BCO, BPL, BSL, ADJDAY, CO, PL, SL, LWP, Leave_id);									
				boolean result1 = allUpdateDAO.LeaveUpdateStatus(Status , Leave_id, approvalDate);
				boolean result2 = allUpdateDAO.LeaveUpdate1(colunmname1, CO, colunmname2, PL, colunmname3, SL, colunmname4, MAIN_LWP, Emp_MasterID);
			
				if(result == true && result1 == true && result2 == true)
				{
					System.out.println("Successfully Akash");
					request.setAttribute("LeaveapprovedSuccessfully", "Leave approved Successfully");
					
					if(request.getAttribute("action") == null)
					{
					
					String to1 = tlll;
					String from1 = lfff;
					double days1 = TEMPDAY;
					String reason1 = reason;
					System.out.println("EmailID:"+EmailId);
					 
					int lid = Leave_id;
					
					 new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	
						    	String to = EmailId;
						    	String sub = name+" Your Leave Approved.";
						    	double days = days1;
						    	String leavefrom = from1;
						    	String leaveto = to1 ;
						    	String status = "Approved";
						    		
						    	Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason1,emp_code,name);
						    	boolean result = allUpdateDAO.LeaveMailUpdate(lid,mail_view);
						    	
						    }
						}).start();
					
					}
						if(request.getParameter("hrApproval") != null)
						{
							request.setAttribute("success", "Leave Successfully Approved");
							request.getRequestDispatcher("pendingLeaveHrSide.jsp").forward(request, response);
						}
						else if(request.getParameter("specialLeave") != null){
							request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
						}else
						{
							request.getRequestDispatcher("leaveListManager.jsp").forward(request, response);
						}
					}
				}
			}
			else if(Status.equals("rejected"))
			{
				boolean result = allUpdateDAO.LeaveStatusreject(Status, reason, Leave_id,approvalDate);
				if(result == true)
				{
					System.out.println("Successfully");
					request.setAttribute("LeaverejectedSuccessfully", "Leave Rejected Successfully");
				

				String to1 = tlll;
				String from1 = lfff;
				double days1 = daycount;
				String reason1 = reason;
				System.out.println("EmailID:"+EmailId);
				int lid = Leave_id;
				
				 new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = EmailId;
					    	String sub = name+" your Leave Rejected";
					    	double days = days1;
					    	String leavefrom = from1;
					    	String leaveto = to1 ;
					    	String status = "Rejected";
					    	
					    		Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason1,emp_code,name);
					    		boolean result = allUpdateDAO.LeaveMailUpdate(lid,mail_view);
					    }
					}).start();
					
					
				 	if(request.getParameter("hrApproval") != null)
				 	{
					 	request.setAttribute("error", "Leave Rejected Successfully");
						request.getRequestDispatcher("pendingLeaveHrSide.jsp").forward(request, response);
					}
				 	else
					{
						request.getRequestDispatcher("leaveListManager.jsp").forward(request, response);
					}
				}
			}		
		}
		else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
