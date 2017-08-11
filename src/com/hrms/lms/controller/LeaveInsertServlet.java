package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.hrms.lms.bean.LeaveAfterAddBean;
import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;


public class LeaveInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();    
		if(user!=null)
		{
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			int employee_code = 0; 
			String Purpose_of_Leave	 = null; 
			int LeaveType_ID = 0; 
			int Leave_type_check_id = 0; 
			String Leave_From = null; 
			String Leave_To = null; 
			double adjvalue = 0.0;
			double days = 0.0; 
			String Address = null; 
			String Number = null;
			int Manager_id = 0;
			String approval = null;
			double privilege = 0.0;
			String pushMainDate = null;
			String popMainDate = null;
			double CO = 0 , PL = 0 , SL = 0 , LWP = 0;
			double BCO = 0 , BPL = 0 , BSL = 0 ;
			int CONSTANTDAY = 9;
			int month_id = 0 , GETMONTH_ID = 0;
			double SELECTDAY = 9;
			double ADJDAY = 0 ,COPY = 0;
			double MAIN_CO = 0 , MAIN_PL = 0 , MAIN_SL = 0 , MAIN_LWP = 0;
			String RFT = "akash";
			String RTT = "One Day Leave";
			String leavetype = null;
			String Status = "Pending";
			String sunday = null , holiday = null;
			int show_view = 0;
			int leave_id = 0;
			int unplancounter = 0;
			double unplanLeave = 0;
			double planLeave = 0;
			double DAYS = 0;
			boolean duplicateFlag = false;
			String HR_Flag_unplan_leave = "YES";
			String HOD_Flag_unplan_leave = "YES";
			LeaveBean leaveBean = new LeaveBean();
			LeavecutBalance leavecutBalance = new LeavecutBalance();
			EmployeeBean employeeBean = new EmployeeBean();
			String lff = null;
			String tll = null;
			double d = 0;
			String alert = null;
			double aaaaa = 0;
			double PLAN = 0 , UNPLAN = 0 , TOTALPLANUNPLA = 0;
			int manager_id =Integer.parseInt(user.getUnder_manager_id());
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean2 = loginDAO.getEmailId(manager_id);
			String EmailId = employeeBean2.getEmail_id();
			String name = user.getFirstname()+" "+user.getLastname();
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String date1 = sdf.format(date);
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			
			try {
				items = upload.parseRequest(request);// Parse Requ
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("employee_master_id")) 
						{
							String value = fieldValue;
							employee_code = Integer.parseInt(value);
							System.out.println("Employee Code:"+ employee_code);
						}
						
						if (fieldName.equalsIgnoreCase("privilege")) 
						{
							String value = fieldValue;
							privilege = Double.parseDouble(value);
							System.out.println("privilege Leave:"+ privilege);
							
						}
						
						if (fieldName.equalsIgnoreCase("purposeOfLeave"))
						{
							Purpose_of_Leave = fieldValue;
							System.out.println("Purpose Of Leave:" + Purpose_of_Leave);
						}
						
						if (fieldName.equalsIgnoreCase("typeOfLeave"))
						{
							String value = fieldValue;
							LeaveType_ID = Integer.parseInt(value);
							System.out.println("Type Of Leaver : "+LeaveType_ID);
							
						}
					
						if (fieldName.equalsIgnoreCase("typeOfcheckboxLeave"))
						{
							String value = fieldValue;
							Leave_type_check_id = Integer.parseInt(value);
							System.out.println("Type Of Check: "+Leave_type_check_id);	
						}
						
						if (fieldName.equalsIgnoreCase("fromDate"))
						{
							Leave_From = fieldValue;
							System.out.println("Form Date :-" + Leave_From);
						}
						
						if (fieldName.equalsIgnoreCase("leavefromDate"))
						{
							RFT = fieldValue;
							System.out.println("FROM DATE RADIO:"+ RFT);
						}
						
						if (fieldName.equalsIgnoreCase("toDate"))
						{
							Leave_To = fieldValue;
							System.out.println("To Date:"+Leave_To);
						}
												
						if (fieldName.equalsIgnoreCase("leavetoDate"))
						{
							RTT = fieldValue;
							System.out.println("TO DATE RADIO:"+ RTT);
						}
						
						if (fieldName.equalsIgnoreCase("numdays3"))
						{
							String value = fieldValue;
							adjvalue = Double.parseDouble(value);
							System.out.println("Day Count:"+ adjvalue);
						}
						
						if (fieldName.equalsIgnoreCase("numdays"))
						{
							String value = fieldValue;
							days = Double.parseDouble(value);
							System.out.println("Day Count:"+ days);
						}
						
		
						if (fieldName.equalsIgnoreCase("contactAddress"))
						{
							Address = fieldValue;
							System.out.println("Address :"+Address);
						}
						
						if (fieldName.equalsIgnoreCase("contactNumberDuringLeave"))
						{
							Number = fieldValue;
							System.out.println("Number  "+Number);
						}
						
						if (fieldName.equalsIgnoreCase("reportingManager"))
						{
							String value = fieldValue;
							Manager_id = Integer.parseInt(value);
							System.out.println("reportingManager manager:"+Manager_id);
						}
						
						if (fieldName.equalsIgnoreCase("approval"))
						{
							approval = fieldValue;
							System.out.println("approval :"+approval);
							
						}
						if (fieldName.equalsIgnoreCase("CO"))
						{
							String value = fieldValue;
							CO = Double.parseDouble(value);
							MAIN_CO = CO;
							System.out.println("CO Value : "+ CO);
						}
						if (fieldName.equalsIgnoreCase("plan"))
						{
							String value = fieldValue;
							PL = Double.parseDouble(value);
							MAIN_PL = PL;
							System.out.println(" Plan Leave Value :"+ PL);
						}
						if (fieldName.equalsIgnoreCase("unplan"))
						{
							String value = fieldValue;
							SL = Double.parseDouble(value);
							MAIN_SL = SL;
							System.out.println("Unplan Leave Value : "+ SL);
						}
						if (fieldName.equalsIgnoreCase("LWP"))
						{
							String value = fieldValue;
							LWP = Double.parseDouble(value);
							MAIN_LWP = LWP;
							System.out.println("Leave With Pay Value  : "+ LWP);
						}
						
						if (fieldName.equalsIgnoreCase("pushMainDate"))
						{
							pushMainDate = fieldValue;
							System.out.println(" After Date   : "+ pushMainDate);
						}
						if (fieldName.equalsIgnoreCase("popMainDate"))
						{
							popMainDate = fieldValue;
							System.out.println("popMainDate   : "+ popMainDate);
						}
						
						if (fieldName.equalsIgnoreCase("leavetype"))
						{
							leavetype = fieldValue;
							System.out.println("Leave Type   : "+ leavetype);
						}
						if (fieldName.equalsIgnoreCase("monthID"))
						{
							String value = fieldValue;
							month_id = Integer.parseInt(value);
							System.out.println("Month ID :"+ month_id);
						}
						
						if (fieldName.equalsIgnoreCase("sunday"))
						{
							sunday = fieldValue;
							System.out.println("Sandwichruls Flag   : "+ sunday);
						}
						
						if (fieldName.equalsIgnoreCase("holiday"))
						{
							holiday = fieldValue;
							System.out.println("Holiday Flag   : "+ holiday);
						}
						
						if (fieldName.equalsIgnoreCase("redirect"))
						{	
							try 
							{
							  
								SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
								Date result1 = formater1.parse(Leave_From);
								Date result2 = formater1.parse(Leave_To);
								SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
								Leave_From = formater2.format(result1);
								Leave_To = formater2.format(result2);
								System.out.println("Leave From Date " + Leave_From);
								System.out.println("Leave TO Date " + Leave_To);
							
							}
							catch (ParseException e1) 
							{
								e1.printStackTrace();
							}	
							
							
								AllInsertDAO allInsertDAO = new AllInsertDAO();
								AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
								List<LeaveBean> duplicate = allLMSListDAO.getLeaveDupicate(Leave_From, Leave_To, employee_code);
								List<LeaveBean> fromtodate = allLMSListDAO.getLeavefromtodate(Leave_From, Leave_To, employee_code);
								List<LeaveBean> fromtodate1 = allLMSListDAO.getLeavefromtodate1(Leave_From, Leave_To, employee_code);
								List<LeaveBean> l = (ArrayList<LeaveBean>) allLMSListDAO.getLeavesendwitchroul(Leave_From, Leave_To, employee_code);
								List<LeaveBean> l1 = (ArrayList<LeaveBean>) allLMSListDAO.getunplannedByEmp_code(employee_code);	
								String From_date = null, To_Date = null , PushDate = null , FromHaf = null, Tohaf = null , popdate = null , checktype = null, snwruls = null , holisunw = null;
								double day = 0;
								double temp =  0;
								int Leave_Id = 0;
								System.out.println("LEAVE LEAVE LEAVE LEAVE:"+l.size());
								for(LeaveBean c : l)
								{
									From_date      = c.getLeave_From();
									To_Date        = c.getLeave_To();
									FromHaf 	   = c.getFrom_half();
									Tohaf 		   = c.getTo_half();
									day 		   = c.getDay_count();
									PushDate  	   = c.getPushMainDate();
									Leave_Id       = c.getLeave_id();
									popdate        = c.getPopMainDate();
									snwruls        = c.getSunday();
									holisunw	   = c.getHoliday();	
									temp = temp + day;
												
							}	
								
								System.out.println("Sunday Flag " + snwruls + "Holday Flag " + holisunw);
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
						
								
								
								
								List<LeaveBean> listOfLeave = allLMSListDAO.getUnplanListPerMonth(unplanstartDate, unplanendDate, employee_code);
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
								
								
								for(LeaveBean leaveBean2 : listOfLeave){
									
									String dateFrom = leaveBean2.getLeave_From();
									String dateTo = leaveBean2.getLeave_To();
									Date lf = null;
									Date df = null;
									Date dt = null;
									
									try 
									{
										SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										lf = formater2.parse(Leave_From);
										df = formater2.parse(dateFrom);
										dt = formater2.parse(dateTo);
									
									}
									catch (ParseException e1) 
									{
										e1.printStackTrace();
									}	
									
									
									if(lf.after(df) && lf.before(dt)){
										duplicateFlag = true;
										System.out.println("Between two date.....");
									}
									
								}
								
								
								System.out.println("planLeave Akash " + planLeave);	
								System.out.println("unplanLeave Akash " + unplanLeave);	
								System.out.println("Leave POP Date " + popdate);
								System.out.println("Leave PUSH Date " + PushDate);
								
								SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
								Calendar c = Calendar.getInstance();
								Calendar c11 = Calendar.getInstance();
								
								
								
								try {
									c.setTime(formater2.parse(Leave_From));
									c11.setTime(formater2.parse(Leave_To));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								c.add(Calendar.DATE, -1); 
								String checkPushDate = formater2.format(c.getTime());
								
								List<LeaveBean> leaveFromDateCheck = (ArrayList<LeaveBean>) allLMSListDAO.getLeaveFromDateCheck(checkPushDate, employee_code);
								
								
								
								
								c11.add(Calendar.DATE, 1); 
								String checkPopDate = formater2.format(c.getTime());
								
								List<LeaveBean> leaveToDateCheck = (ArrayList<LeaveBean>) allLMSListDAO.getLeaveToDateCheck(checkPopDate, employee_code);
								
								System.out.println("fromdatecjheck:"+leaveFromDateCheck.size());
								System.out.println("Todatecjheck:"+leaveToDateCheck.size());
								
								int sumOfDateCheck = leaveFromDateCheck.size() + leaveToDateCheck.size();
	
							if(leavetype.equalsIgnoreCase("PLAN LEAVE"))
							{
								//.......................... PLAN LEAVE...........................//
								System.out.println("Plan Leave");
								LeaveType_ID = 1;
								DAYS = days;
								
			
								if(l.size() != 0 && Tohaf.equalsIgnoreCase("FF"))
								{
									
									if(popdate.equals(Leave_To) && snwruls.equalsIgnoreCase("TRUE") && sunday.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 
								   || (popdate.equals(Leave_To) && holisunw.equalsIgnoreCase("TRUE") && holisunw.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 ))
									{
										System.out.println("POP FUNCTION");
										
										try
										{
											c.setTime(formater2.parse(Leave_To));
											c.add(Calendar.DATE, 1); 
											Leave_From = formater2.format(c.getTime());
											System.out.println("MAIN DATE ZZZZZZZZZZ " + Leave_To);
											
											DAYS = days + 1;
											days = DAYS;
											
											
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
											
											
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										catch (Exception e) {
											// TODO: handle exception
										}
										
									
									}
									else if((PushDate.equals(Leave_From) && snwruls.equalsIgnoreCase("TRUE") && sunday.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 )
										|| (PushDate.equals(Leave_From) && holisunw.equalsIgnoreCase("TRUE") && holisunw.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 ))
									{
										System.out.println("PUSH FUNCTION");
										
										
										try
										{
											c.setTime(formater2.parse(Leave_From));
											c.add(Calendar.DATE, -1); 
											Leave_From = formater2.format(c.getTime());
											System.out.println("MAIN DATE ZZZZZZZZZZ " + Leave_From);
											
											DAYS = days + 1;
											days = DAYS;
											
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
											
											
											
											
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										
										
									}
									else
									{
										System.out.println("Normal Insert");
										
										

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
										
										
										
										
										
										
										employeeBean.setEmployee_master_id(employee_code);
										leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
										leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
										boolean result = allInsertDAO.leaveInsert(leaveBean);
										boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
										leave_id = leaveBean.getLeave_id();
										System.out.println("final:"+leaveBean.getLeave_id());
										
										if(result == true && result1 == true)
										{
											System.out.println("Leave Apply Successfully");
											 lff = Leave_From;
											 tll = Leave_To;
											 d = DAYS;
											request.setAttribute("success", "Leave Applied Successfully");
										//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
										}
										
									}	
								}
								else
								{	
									if(duplicateFlag == false)
									{
										if(duplicate.size() == 0 && fromtodate1.size() == 0)
										{
											System.out.println("Normal Insert 222222");
											
											

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
												
												double aaaa = TOTALPLANUNPLA + days;
												if(aaaa >= 9)
												{
													aaaaa = aaaa - 9;	
													days = 9 - TOTALPLANUNPLA;
												}
										
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
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										else
										{
											System.out.println("Leave From Date And To Date Already exit");
											request.setAttribute("LeavefromtodateExist", "Leave From Date And To Date Already Exists");
										}
									}
									else
									{
										System.out.println("Leave All Ready exit");
										request.setAttribute("LeaveExist", "Leave Already Exists");
									}
								}
							}
							else if(leavetype.equalsIgnoreCase("UNPLAN LEAVE"))
							{
								//.......................... UNPLAN LEAVE...........................// 
								System.out.println("UnPlan Leave");
								LeaveType_ID = 5;
								SELECTDAY = 3;
								DAYS = days;
								for(LeaveBean c1 : l1)
								{
									unplancounter = c1.getUnplan_leave_counter();
													
								}
								
								if(l.size() != 0 && Tohaf.equalsIgnoreCase("FF"))
								{
									if(popdate.equals(Leave_To) && snwruls.equalsIgnoreCase("TRUE") && sunday.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0  
								   || (popdate.equals(Leave_To) && holisunw.equalsIgnoreCase("TRUE") && holisunw.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 ))
									{
										System.out.println("POP FUNCTION");
										
										try
										{
											c.setTime(formater2.parse(Leave_To));
											c.add(Calendar.DATE, 1); 
											Leave_To = formater2.format(c.getTime());
											System.out.println("MAIN DATE ZZZZZZZZZZ " + Leave_To);
											
											DAYS = days + 1;
											days = DAYS;
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
											
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										catch (Exception e) {
											// TODO: handle exception
										}
										
									
									}
									else if(PushDate.equals(Leave_From) && snwruls.equalsIgnoreCase("TRUE") && sunday.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0  
									    || (PushDate.equals(Leave_From) && holisunw.equalsIgnoreCase("TRUE") && holisunw.equalsIgnoreCase("TRUE") && RTT.equalsIgnoreCase("FF") && sumOfDateCheck == 0 ))
									{
										System.out.println("PUSH FUNCTION");
										
										
										try
										{
											c.setTime(formater2.parse(Leave_From));
											c.add(Calendar.DATE, -1); 
											Leave_From = formater2.format(c.getTime());
											System.out.println("MAIN DATE ZZZZZZZZZZ " + Leave_From);
											
											DAYS = days + 1;
											days = DAYS;
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
											
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										
										
									}
									else
									{
										System.out.println("Normal Insert");
										
										
										
										
										
										if(duplicateFlag == false)
										{
											if(duplicate.size() == 0 && fromtodate1.size() == 0)
											{
												System.out.println("Normal Insert 222222");
												
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
												
												employeeBean.setEmployee_master_id(employee_code);
												leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
												leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
												boolean result = allInsertDAO.leaveInsert(leaveBean);
												boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);
												leave_id = leaveBean.getLeave_id();
												System.out.println("final:"+leaveBean.getLeave_id());
												
												
												if(result == true && result1 == true)
												{
													System.out.println("Leave Apply Successfully");
													 lff = Leave_From;
													 tll = Leave_To;
													 d = DAYS;
													request.setAttribute("success", "Leave Applied Successfully");
												//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
												}
											}
											else
											{
												System.out.println("Leave From Date And To Date Already exit");
												request.setAttribute("LeavefromtodateExist", "Leave From Date And To Date Already Exists");
											}
										}
									}
								}
								else
								{
									if(duplicateFlag == false)
									{
										if(duplicate.size() == 0 && fromtodate1.size() == 0)
										{
											System.out.println("Normal Insert 222222");
											
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
											
											employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, DAYS ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave,date1,sunday,holiday,month_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);	
											leave_id = leaveBean.getLeave_id();
											System.out.println("final:"+leaveBean.getLeave_id());
											
											
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												 lff = Leave_From;
												 tll = Leave_To;
												 d = DAYS;
												request.setAttribute("success", "Leave Applied Successfully");
											//	request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
											}
										}
										else
										{
											System.out.println("Leave From Date And To Date Already exit");
											request.setAttribute("LeavefromtodateExist", "Leave From Date And To Date Already Exists");
										}
									}
									else
									{
										System.out.println("Leave All Ready exit");
										request.setAttribute("LeaveExist", "Leave Already Exists");
									}
								}
							}		
						}
					
						if (fieldName.equalsIgnoreCase("Mailredirect"))
						{
							int ManagerID =  Manager_id;
							String Name = user.getFirstname() + " " + user.getLastname();
							String Leavetype = "Leave";
							
							 try {
						            // open a connection to the site
						              URL  url = new URL("http://192.168.182.104/HRMS/send_notification.php?");
						              //  URL url = new URL("http://sltlhrms.16mb.com/HRMS/send_notification.php?");
						            URLConnection  con = url.openConnection();
						            // activate the output
						            con.setDoOutput(true);
						            PrintStream ps = new PrintStream(con.getOutputStream());
						            // send your parameters to your site
						          
						            ps.print("&manager_id=" + ManagerID);
						            ps.print("&Name=" + Name);               
						            ps.print("&Leavetype=" + Leavetype);
						           
						            System.out.println("MANAGER " + ManagerID + " NAME " + Name + " TYPE " + Leavetype);
						            

						            // we have to get the input stream in order to actually send the request
						            con.getInputStream();

						            // close the print stream
						            ps.close();
						      }
							 catch (MalformedURLException  e1)
							 {    
								 e1.printStackTrace();
						     }
							 catch (IOException e2)
							 {
								 e2.printStackTrace();
							 }
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							if(lff != null){
							 String no = Number;
							 String lfff = null;
							 String tlll = null;
							 double dd = d;
							 String alert1 = alert;
							
							try 
							{
							  
								SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
								Date result1 = formater1.parse(lff);
								Date result2 = formater1.parse(tll);
								SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
								lfff = formater2.format(result1);
								tlll = formater2.format(result2);
							
							}
							catch (ParseException e1) 
							{
								e1.printStackTrace();
							}	
							
							String lffff = lfff;
							String tllll = tlll;
							System.out.println(lffff);
							System.out.println(tllll);
							System.out.println(d);
							System.out.println(Number);
							System.out.println(alert);
							System.out.println(EmailId);
							
							System.out.println("finalLeaveId:"+leave_id);

							int lId = leave_id;
							
							
							new Thread(new Runnable() {
								    @Override
								    public void run() {
								    	
								    	String to = EmailId;
								    	String sub = name + " apply for leave";
								    	String leavefrom = lffff;
								    	String leaveto = tllll;
								    	double days = dd;
								    	String mobileNo = no;
								    	int emp_code = user.getEmployee_code();
								    	int mail_view = 1;
								    
								    	System.out.println("test");
								    	
								    	Mailer.send(to, sub, leavefrom, leaveto, days, emp_code,mobileNo,alert1,lId,name);
								    	boolean result = allUpdateDAO.LeaveMailUpdate(lId,mail_view);
								    	
								    }
								}).start();


							 request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);	
						}else{
							request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);	
						}
						}
					}
				}
			}
			catch (FileUploadException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}
}
