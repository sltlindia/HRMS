package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveTypeBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveUnplanInsertServlet
 */
public class LeaveUnplanInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveUnplanInsertServlet() {
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
			//String from_haif = null;
			String Leave_To = null; 
			//String to_haif = null;
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
			double BCO = 0 , BPL = 0 , BSL = 0 , BLWP = 0 , LWPSUM = 0 , FLAG = 9;
			int CONSTANTDAY = 9;
			double SELECTDAY = 9;
			double ADJDAY = 0 ,COPY = 0;
			double MAIN_CO = 0 , MAIN_PL = 0 , MAIN_SL = 0 , MAIN_LWP = 0;
			String RFT = "akash";
			String RTT = "One Day Leave";
			//String ColumnName = null;
			//double fs = 0 , sf = 0;
			String leavetype = null;
			String Status = "Pending";
			int show_view = 0;
			int leave_id = 0;
			int unplancounter = 0;
			String HR_Flag_unplan_leave = "YES";
			String HOD_Flag_unplan_leave = "YES";
			LeaveBean leaveBean = new LeaveBean();
			LeavecutBalance leavecutBalance = new LeavecutBalance();
			LeaveTypeBean leaveTypeBean = new LeaveTypeBean();
			EmployeeBean employeeBean = new EmployeeBean();
	
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
						/*if (fieldName.equalsIgnoreCase("COCUT"))
						{
							String value = fieldValue;
							COCUT = Double.parseDouble(value);
							System.out.println("CO CUT Value  : "+ COCUT);
						}
						
						if (fieldName.equalsIgnoreCase("PLCUT"))
						{
							String value = fieldValue;
							PLCUT = Double.parseDouble(value);
							System.out.println("Leave With Pay Value  : "+ PLCUT);
						}
						
						if (fieldName.equalsIgnoreCase("SLCUT"))
						{
							String value = fieldValue;
							SLCUT = Double.parseDouble(value);
							System.out.println("Leave With Pay Value  : "+ SLCUT);
						}*/
						
						SimpleDateFormat fromdate1 = new SimpleDateFormat("dd/mm/yy");
						long diff  = 0 , diff1 = 0;
						if (fieldName.equalsIgnoreCase("redirect"))
						{		
							System.out.println("UNPLAN LEAVE IF IN");
							AllInsertDAO allInsertDAO = new AllInsertDAO();
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
							List<LeaveBean> duplicate = allLMSListDAO.getLeaveDupicate(Leave_From, Leave_To, employee_code);
							List<LeaveBean> fromtodate = allLMSListDAO.getLeavefromtodate(Leave_From, Leave_To, employee_code);
							List<LeaveBean> l = (ArrayList<LeaveBean>) allLMSListDAO.getLeavesendwitchroul(Leave_From, Leave_To, employee_code);
							List<LeaveBean> l1 = (ArrayList<LeaveBean>) allLMSListDAO.getunplannedByEmp_code(employee_code);	
							
							
							String From_date = null, To_Date = null ,PushDate = null , FromHaf = null, Tohaf = null , popdate = null;
							double day = 0;						
							int Leave_Id = 0;
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
								
												
							}	
							
							if(leavetype.equalsIgnoreCase("PLAN LEAVE"))
							{								
								if(l.size() != 0 && Tohaf.equalsIgnoreCase("FF"))
								{
									
									try
									{
										Date d1 = fromdate1.parse(From_date);
										Date d2 = fromdate1.parse(To_Date );
										Date d3 = fromdate1.parse(PushDate);
										Date d4 = fromdate1.parse(Leave_To);
										Date d5 = fromdate1.parse(popdate);
								
									}
									catch(Exception e)
									{
											e.printStackTrace();
									}
									System.out.println("IF");
									if(PushDate.equals(Leave_From))
									{
										System.out.println("(PUSH FUNCTION)");
										if(RFT.equals("FH") || RFT.equals("SH"))
										{
											if(SL != 0)
											{
												if(SL > days)		
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SL = 0;
															SELECTDAY = 0;
														}
														else
														{
															SL = SL - SELECTDAY;
															days = days - SELECTDAY;
															ADJDAY = 0;
															BSL = SELECTDAY;
														}
													}
													else
													{
														SL = SL - days;
														ADJDAY = 0;
														BSL = days;
													}
												}
												else if(SL <= days)
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SELECTDAY = 0;
															SL = 0;		
														}
														else
														{
															SELECTDAY = SELECTDAY - SL;
															days = days - SL;
															ADJDAY = days;
															BSL = SL;
															SL = 0;
														}
													}
													else
													{
														SELECTDAY = SELECTDAY - SL;
														days = days - SL;
														ADJDAY = days;
														BSL = SL;
														SL = 0;
													}
												}
											}
											else
											{
												ADJDAY = SELECTDAY;
											}
										
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)	
												{	
													if(CO != 0)
													{
														if(CO > days)		
														{
															if(days > SELECTDAY)
															{
																CO = CO - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BCO = SELECTDAY;
																SELECTDAY = 0;
															}
															else
															{
																CO = CO - days;
																ADJDAY = 0;
																BCO = days;
															}
														}
														else if(CO <= days)
														{
															if(days > SELECTDAY)
															{	
																BCO = SELECTDAY;
																if(CO > SELECTDAY)
																{
																	ADJDAY = CO - SELECTDAY;
																	CO = days - SELECTDAY;
																	days = days - PL;
																	SELECTDAY = 0;
																}
																else
																{
																	BCO = CO;
																	SELECTDAY = SELECTDAY - CO;
																	ADJDAY = days - CO;
																	days = ADJDAY;
																	CO = 0;
																}						
															}
															else
															{
																ADJDAY = CO - SELECTDAY;
																SELECTDAY = SELECTDAY - CO;
																days = days - CO;
																BCO = CO;
																CO = 0;	
															}
														}	
													}
												}
												else
												{
													//ADJDAY = SELECTDAY;
												}
											}
											
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)
												{
													if(PL != 0)
													{
														if(PL > days)		
														{
															if(days > SELECTDAY) 
															{
																PL = PL - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BPL = SELECTDAY;
															}
															else
															{
																PL = PL - days;
																ADJDAY = 0;
																BPL = days;
															}
														}
														else if(PL <= days)
														{
															if(days > SELECTDAY)
															{								
																if(PL > SELECTDAY)
																{
																	BPL = SELECTDAY;
																	ADJDAY = days - SELECTDAY;
																	PL = PL - SELECTDAY;
																	SELECTDAY = 0;
																}
															else
															{
																BPL = PL;
																ADJDAY = ADJDAY - SELECTDAY;
																SELECTDAY = SELECTDAY - PL;
																PL = 0;
															}
														}
														else
														{
															days = days - PL;
															ADJDAY = days;
															BPL = PL;  
															PL = 0;
														}
													}
												}
											}
										} 
										else
										{
											//ADJDAY = days;
										}
									    	
											if(BSL != 0)
											{
												System.out.println("Leave Type ID SL (5)");
												LeaveType_ID = 5;
											}
									    	employeeBean.setEmployee_master_id(employee_code);
											leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, days ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave);
											leaveBean.setLeave_id(leave_id);
											leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
											boolean result = allInsertDAO.leaveInsert(leaveBean);
											boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);
										
											if(result == true && result1 == true)
											{
												System.out.println("Leave Apply Successfully");
												request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
												/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
												response.sendRedirect("applyleave.jsp");
											}
											
									
										}
										else
										{
											System.out.println(" PUSH FUNCTION IN ELSE IF");
											try
											{
												DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
												
												Date to = df.parse(Leave_To);
												Date from = df.parse(From_date);
												Calendar cal1 = Calendar.getInstance();
											    Calendar cal2 = Calendar.getInstance();
											    
											    cal1.setTime(to);
											    cal2.setTime(from);
											    
												System.out.println("Todate:"+to);
												System.out.println("fromdate:"+from);
												
											    int numberOfDays = 0;
											    while (cal2.before(cal1)) 
											    {
											           
											    	numberOfDays++;
											        cal2.add(Calendar.DATE,1);
											    }
											    
											    numberOfDays = numberOfDays + 1;
											    days = numberOfDays;
											    System.out.println(" TOTAL DAYS PUSH FUCTION " + days);	
											}
											catch(Exception e)
											{
												
											}
										
											if(SL != 0)
											{
												if(SL > days)		
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SL = 0;
															SELECTDAY = 0;
														}
														else
														{
															SL = SL - SELECTDAY;
															days = days - SELECTDAY;
															ADJDAY = 0;
															BSL = SELECTDAY;
														}
													}
													else
													{
														SL = SL - days;
														ADJDAY = 0;
														BSL = days;
													}
												}
												else if(SL <= days)
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SELECTDAY = 0;
															SL = 0;		
														}
														else
														{
															SELECTDAY = SELECTDAY - SL;
															days = days - SL;
															ADJDAY = days;
															BSL = SL;
															SL = 0;
														}
													}
													else
													{
														SELECTDAY = SELECTDAY - SL;
														days = days - SL;
														ADJDAY = days;
														BSL = SL;
														SL = 0;
													}
												}
											}
											else
											{
												ADJDAY = SELECTDAY;
											}
										
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)	
												{	
													if(CO != 0)
													{
														if(CO > days)		
														{
															if(days > SELECTDAY)
															{
																CO = CO - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BCO = SELECTDAY;
																SELECTDAY = 0;
															}
															else
															{
																CO = CO - days;
																ADJDAY = 0;
																BCO = days;
															}
														}
														else if(CO <= days)
														{
															if(days > SELECTDAY)
															{	
																BCO = SELECTDAY;
																if(CO > SELECTDAY)
																{
																	ADJDAY = CO - SELECTDAY;
																	CO = days - SELECTDAY;
																	days = days - PL;
																	SELECTDAY = 0;
																}
																else
																{
																	BCO = CO;
																	SELECTDAY = SELECTDAY - CO;
																	ADJDAY = days - CO;
																	days = ADJDAY;
																	CO = 0;
																}						
															}
															else
															{
																ADJDAY = CO - SELECTDAY;
																SELECTDAY = SELECTDAY - CO;
																days = days - CO;
																BCO = CO;
																CO = 0;	
															}
														}	
													}
												}
												else
												{
													//ADJDAY = SELECTDAY;
												}
											}
											
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)
												{
													if(PL != 0)
													{
														if(PL > days)		
														{
															if(days > SELECTDAY) 
															{
																PL = PL - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BPL = SELECTDAY;
															}
															else
															{
																PL = PL - days;
																ADJDAY = 0;
																BPL = days;
															}
														}
														else if(PL <= days)
														{
															if(days > SELECTDAY)
															{								
																if(PL > SELECTDAY)
																{
																	BPL = SELECTDAY;
																	ADJDAY = days - SELECTDAY;
																	PL = PL - SELECTDAY;
																	SELECTDAY = 0;
																}
															else
															{
																BPL = PL;
																ADJDAY = ADJDAY - SELECTDAY;
																SELECTDAY = SELECTDAY - PL;
																PL = 0;
															}
														}
														else
														{
															days = days - PL;
															ADJDAY = days;
															BPL = PL;  
															PL = 0;
														}
													}
												}
											}
										} 
										else
										{
											//ADJDAY = days;
										}	
												boolean	result = allUpdateDAO.LeavesendwitchleaveBeanupdate(Purpose_of_Leave, From_date , RFT, Leave_To , RTT, days , CO, PL, SL, ADJDAY, Address, Number, Status, pushMainDate , popdate, Leave_Id);
												boolean	result1 = allUpdateDAO.Leavesendwitchroulupdate(BCO, BPL, BSL, ADJDAY, MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP, Leave_Id);							
										
												if((result == true) && (result1 == true))
												{
													System.out.println("Leave Apply Successfully");
													request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
													/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
													response.sendRedirect("applyleave.jsp");
												}	
										}
									}
									else if(popdate.equals(Leave_To))
									{
										System.out.println("POP FUNCTION");
										try
										{    
											    if(RTT.equals("FH") || RTT.equals("SH"))
												{
											    	
											    	if(SL != 0)
													{
														if(SL > days)		
														{
															if(days > SELECTDAY)
															{
																if(SL > SELECTDAY)
																{
																	BSL = SL;
																	ADJDAY = days - SL;
																	SL = 0;
																	SELECTDAY = 0;
																}
																else
																{
																	SL = SL - SELECTDAY;
																	days = days - SELECTDAY;
																	ADJDAY = 0;
																	BSL = SELECTDAY;
																}
															}
															else
															{
																SL = SL - days;
																ADJDAY = 0;
																BSL = days;
															}
														}
														else if(SL <= days)
														{
															if(days > SELECTDAY)
															{
																if(SL > SELECTDAY)
																{
																	BSL = SL;
																	ADJDAY = days - SL;
																	SELECTDAY = 0;
																	SL = 0;		
																}
																else
																{
																	SELECTDAY = SELECTDAY - SL;
																	days = days - SL;
																	ADJDAY = days;
																	BSL = SL;
																	SL = 0;
																}
															}
															else
															{
																SELECTDAY = SELECTDAY - SL;
																days = days - SL;
																ADJDAY = days;
																BSL = SL;
																SL = 0;
															}
														}
													}
													else
													{
														ADJDAY = SELECTDAY;
													}
												
													if(ADJDAY != 0)
													{
														if(SELECTDAY != 0)	
														{	
															if(CO != 0)
															{
																if(CO > days)		
																{
																	if(days > SELECTDAY)
																	{
																		CO = CO - SELECTDAY;
																		days = days - SELECTDAY;
																		ADJDAY = days;
																		BCO = SELECTDAY;
																		SELECTDAY = 0;
																	}
																	else
																	{
																		CO = CO - days;
																		ADJDAY = 0;
																		BCO = days;
																	}
																}
																else if(CO <= days)
																{
																	if(days > SELECTDAY)
																	{	
																		BCO = SELECTDAY;
																		if(CO > SELECTDAY)
																		{
																			ADJDAY = CO - SELECTDAY;
																			CO = days - SELECTDAY;
																			days = days - PL;
																			SELECTDAY = 0;
																		}
																		else
																		{
																			BCO = CO;
																			SELECTDAY = SELECTDAY - CO;
																			ADJDAY = days - CO;
																			days = ADJDAY;
																			CO = 0;
																		}						
																	}
																	else
																	{
																		ADJDAY = CO - SELECTDAY;
																		SELECTDAY = SELECTDAY - CO;
																		days = days - CO;
																		BCO = CO;
																		CO = 0;	
																	}
																}	
															}
														}
														else
														{
															//ADJDAY = SELECTDAY;
														}
													}
													
													if(ADJDAY != 0)
													{
														if(SELECTDAY != 0)
														{
															if(PL != 0)
															{
																if(PL > days)		
																{
																	if(days > SELECTDAY) 
																	{
																		PL = PL - SELECTDAY;
																		days = days - SELECTDAY;
																		ADJDAY = days;
																		BPL = SELECTDAY;
																	}
																	else
																	{
																		PL = PL - days;
																		ADJDAY = 0;
																		BPL = days;
																	}
																}
																else if(PL <= days)
																{
																	if(days > SELECTDAY)
																	{								
																		if(PL > SELECTDAY)
																		{
																			BPL = SELECTDAY;
																			ADJDAY = days - SELECTDAY;
																			PL = PL - SELECTDAY;
																			SELECTDAY = 0;
																		}
																	else
																	{
																		BPL = PL;
																		ADJDAY = ADJDAY - SELECTDAY;
																		SELECTDAY = SELECTDAY - PL;
																		PL = 0;
																	}
																}
																else
																{
																	days = days - PL;
																	ADJDAY = days;
																	BPL = PL;  
																	PL = 0;
																}
															}
														}
													}
												} 
												else
												{
													//ADJDAY = days;
												}
													if(BSL != 0)
													{
														System.out.println("Leave Type ID SL (5)");
														LeaveType_ID = 5;
													}					    	
											    	employeeBean.setEmployee_master_id(employee_code);
													leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, days ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave);
													leaveBean.setLeave_id(leave_id);
													leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
													boolean result = allInsertDAO.leaveInsert(leaveBean);
													boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);
												
													if(result == true && result1 == true)
													{
														System.out.println("Leave Apply Successfully");
														request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
														/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
														response.sendRedirect("applyleave.jsp");
													}
												}
											    else
											    {
											    	
											    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
													Date to = df.parse(To_Date);
													Date from = df.parse(Leave_From);
													
													 	Calendar cal1 = Calendar.getInstance();
													    Calendar cal2 = Calendar.getInstance();
													    cal1.setTime(to);
													    cal2.setTime(from);
														System.out.println("Todate:"+to);
														System.out.println("fromdate:"+from);
														
													    int numberOfDays = 0;
													    while (cal2.before(cal1)) 
													    {
													            numberOfDays++;
													        cal2.add(Calendar.DATE,1);
													    }
													    
													    numberOfDays = numberOfDays + 1;
													    days = numberOfDays;
													    System.out.println("TOTAL DAY POP FUNCTION " + days);
													    
													    if(SL != 0)
														{
															if(SL > days)		
															{
																if(days > SELECTDAY)
																{
																	if(SL > SELECTDAY)
																	{
																		BSL = SL;
																		ADJDAY = days - SL;
																		SL = 0;
																		SELECTDAY = 0;
																	}
																	else
																	{
																		SL = SL - SELECTDAY;
																		days = days - SELECTDAY;
																		ADJDAY = 0;
																		BSL = SELECTDAY;
																	}
																}
																else
																{
																	SL = SL - days;
																	ADJDAY = 0;
																	BSL = days;
																}
															}
															else if(SL <= days)
															{
																if(days > SELECTDAY)
																{
																	if(SL > SELECTDAY)
																	{
																		BSL = SL;
																		ADJDAY = days - SL;
																		SELECTDAY = 0;
																		SL = 0;		
																	}
																	else
																	{
																		SELECTDAY = SELECTDAY - SL;
																		days = days - SL;
																		ADJDAY = days;
																		BSL = SL;
																		SL = 0;
																	}
																}
																else
																{
																	SELECTDAY = SELECTDAY - SL;
																	days = days - SL;
																	ADJDAY = days;
																	BSL = SL;
																	SL = 0;
																}
															}
														}
														else
														{
															ADJDAY = SELECTDAY;
														}
													
														if(ADJDAY != 0)
														{
															if(SELECTDAY != 0)	
															{	
																if(CO != 0)
																{
																	if(CO > days)		
																	{
																		if(days > SELECTDAY)
																		{
																			CO = CO - SELECTDAY;
																			days = days - SELECTDAY;
																			ADJDAY = days;
																			BCO = SELECTDAY;
																			SELECTDAY = 0;
																		}
																		else
																		{
																			CO = CO - days;
																			ADJDAY = 0;
																			BCO = days;
																		}
																	}
																	else if(CO <= days)
																	{
																		if(days > SELECTDAY)
																		{	
																			BCO = SELECTDAY;
																			if(CO > SELECTDAY)
																			{
																				ADJDAY = CO - SELECTDAY;
																				CO = days - SELECTDAY;
																				days = days - PL;
																				SELECTDAY = 0;
																			}
																			else
																			{
																				BCO = CO;
																				SELECTDAY = SELECTDAY - CO;
																				ADJDAY = days - CO;
																				days = ADJDAY;
																				CO = 0;
																			}						
																		}
																		else
																		{
																			ADJDAY = CO - SELECTDAY;
																			SELECTDAY = SELECTDAY - CO;
																			days = days - CO;
																			BCO = CO;
																			CO = 0;	
																		}
																	}	
																}
															}
															else
															{
																//ADJDAY = SELECTDAY;
															}
														}
														
														if(ADJDAY != 0)
														{
															if(SELECTDAY != 0)
															{
																if(PL != 0)
																{
																	if(PL > days)		
																	{
																		if(days > SELECTDAY) 
																		{
																			PL = PL - SELECTDAY;
																			days = days - SELECTDAY;
																			ADJDAY = days;
																			BPL = SELECTDAY;
																		}
																		else
																		{
																			PL = PL - days;
																			ADJDAY = 0;
																			BPL = days;
																		}
																	}
																	else if(PL <= days)
																	{
																		if(days > SELECTDAY)
																		{								
																			if(PL > SELECTDAY)
																			{
																				BPL = SELECTDAY;
																				ADJDAY = days - SELECTDAY;
																				PL = PL - SELECTDAY;
																				SELECTDAY = 0;
																			}
																		else
																		{
																			BPL = PL;
																			ADJDAY = ADJDAY - SELECTDAY;
																			SELECTDAY = SELECTDAY - PL;
																			PL = 0;
																		}
																	}
																	else
																	{
																		days = days - PL;
																		ADJDAY = days;
																		BPL = PL;  
																		PL = 0;
																	}
																}
															}
														}
													} 
													else
													{
														//ADJDAY = days;
													}
												    
											    	boolean	result = allUpdateDAO.LeavesendwitchleaveBeanupdate(Purpose_of_Leave, Leave_From , RFT, To_Date , RTT, days, CO, PL, SL, ADJDAY, Address, Number, Status, PushDate , popMainDate, Leave_Id);
													boolean	result1 = allUpdateDAO.Leavesendwitchroulupdate(BCO, BPL, BSL, ADJDAY, MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP, Leave_Id);					
													
														if((result == true) && (result1 == true))
														{
															System.out.println("Leave Apply Successfully");
															request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
															/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
															response.sendRedirect("applyleave.jsp");
														}
											    }
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
									}
								}
								else
								{
									System.out.println("Forword Date Not Found");
									if(duplicate.size() == 0)
									{
										if(fromtodate.size() == 0)
										{
											if(SL != 0)
											{
												if(SL > days)		
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SL = 0;
															SELECTDAY = 0;
														}
														else
														{
															SL = SL - SELECTDAY;
															days = days - SELECTDAY;
															ADJDAY = 0;
															BSL = SELECTDAY;
														}
													}
													else
													{
														SL = SL - days;
														ADJDAY = 0;
														BSL = days;
													}
												}
												else if(SL <= days)
												{
													if(days > SELECTDAY)
													{
														if(SL > SELECTDAY)
														{
															BSL = SL;
															ADJDAY = days - SL;
															SELECTDAY = 0;
															SL = 0;		
														}
														else
														{
															SELECTDAY = SELECTDAY - SL;
															days = days - SL;
															ADJDAY = days;
															BSL = SL;
															SL = 0;
														}
													}
													else
													{
														SELECTDAY = SELECTDAY - SL;
														days = days - SL;
														ADJDAY = days;
														BSL = SL;
														SL = 0;
													}
												}
											}
											else
											{
												ADJDAY = SELECTDAY;
											}
										
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)	
												{	
													if(CO != 0)
													{
														if(CO > days)		
														{
															if(days > SELECTDAY)
															{
																CO = CO - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BCO = SELECTDAY;
																SELECTDAY = 0;
															}
															else
															{
																CO = CO - days;
																ADJDAY = 0;
																BCO = days;
															}
														}
														else if(CO <= days)
														{
															if(days > SELECTDAY)
															{	
																BCO = SELECTDAY;
																if(CO > SELECTDAY)
																{
																	ADJDAY = CO - SELECTDAY;
																	CO = days - SELECTDAY;
																	days = days - PL;
																	SELECTDAY = 0;
																}
																else
																{
																	BCO = CO;
																	SELECTDAY = SELECTDAY - CO;
																	ADJDAY = days - CO;
																	days = ADJDAY;
																	CO = 0;
																}						
															}
															else
															{
																ADJDAY = CO - SELECTDAY;
																SELECTDAY = SELECTDAY - CO;
																days = days - CO;
																BCO = CO;
																CO = 0;	
															}
														}	
													}
												}
												else
												{
													//ADJDAY = SELECTDAY;
												}
											}
											
											if(ADJDAY != 0)
											{
												if(SELECTDAY != 0)
												{
													if(PL != 0)
													{
														if(PL > days)		
														{
															if(days > SELECTDAY) 
															{
																PL = PL - SELECTDAY;
																days = days - SELECTDAY;
																ADJDAY = days;
																BPL = SELECTDAY;
															}
															else
															{
																PL = PL - days;
																ADJDAY = 0;
																BPL = days;
															}
														}
														else if(PL <= days)
														{
															if(days > SELECTDAY)
															{								
																if(PL > SELECTDAY)
																{
																	BPL = SELECTDAY;
																	ADJDAY = days - SELECTDAY;
																	PL = PL - SELECTDAY;
																	SELECTDAY = 0;
																}
															else
															{
																BPL = PL;
																ADJDAY = ADJDAY - SELECTDAY;
																SELECTDAY = SELECTDAY - PL;
																PL = 0;
															}
														}
																else
																{
																	days = days - PL;
																	ADJDAY = days;
																	BPL = PL;  
																	PL = 0;
																}
															}
														}
													}
												} 
												else
												{
													//ADJDAY = days;
												}
									    	
												
												System.out.println("Current CO Balance " + CO); 
												System.out.println("Current Plan Balance " + PL);   
												System.out.println("Current Unplan Balance " +  SL); 
												System.out.println("Current LWP Balance " + ADJDAY); 
												System.out.println("Cut CO " + BCO); 
												System.out.println("Cut Plan " + BPL);   
												System.out.println("Cut Unplan " + BSL); 
												System.out.println("Current LWP Balance  " + ADJDAY); 
											
											/*
												if(BCO != 0)
												{
													System.out.println("Leave Type ID CO (3)");
													LeaveType_ID = 3;
												}
												else if(BPL != 0)
												{
													System.out.println("Leave Type ID PL (1)");
													LeaveType_ID = 1;
												}*/
												if(BSL != 0)
												{
													System.out.println("Leave Type ID SL (5)");
													LeaveType_ID = 5;
												}
											
												employeeBean.setEmployee_master_id(employee_code);
												leaveBean = new LeaveBean(LeaveType_ID ,employeeBean,Purpose_of_Leave,Leave_From,RFT,Leave_To,RTT, days ,CO,PL,SL,ADJDAY,Address,Number,Manager_id,Status ,show_view, pushMainDate,popMainDate, unplancounter,HR_Flag_unplan_leave, HOD_Flag_unplan_leave);
												leaveBean.setLeave_id(leave_id);
												leavecutBalance = new LeavecutBalance(leaveBean, BCO, BPL, BSL, ADJDAY , MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP);
												boolean result = allInsertDAO.leaveInsert(leaveBean);
												boolean result1 = allInsertDAO.leaveCutBalanceInsert(leavecutBalance);
										
												if(result == true && result1 == true)
												{
													System.out.println("Leave Apply Successfully");
													request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
													/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
													response.sendRedirect("applyleave.jsp");
												}
											}
											else
											{
												if(RTT.equals("FH") || RTT.equals("SH"))
												{
													for(LeaveBean c : fromtodate)
													{
														From_date      = c.getLeave_From();
														To_Date        = c.getLeave_To();
														Tohaf 		   = c.getTo_half();
														Leave_Id       = c.getLeave_id();
													}
												
													if((Tohaf.equals("FH") && RTT.equals("FH")) || (Tohaf.equals("SH") && (RTT.equals("SH"))))
													{
														System.out.println("Leave All Ready exit");
														request.setAttribute("LeaveExist", "Leave Already Exists");
														/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
														response.sendRedirect("applyleave.jsp");
													}
													else
													{
														if(Tohaf.equals("FH") || Tohaf.equals("SH"))
														{
															try
															{
																DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
																Date to = df.parse(To_Date);
																Date from = df.parse(From_date);
																
																 	Calendar cal1 = Calendar.getInstance();
																    Calendar cal2 = Calendar.getInstance();
																    cal1.setTime(to);
																    cal2.setTime(from);
																	System.out.println("Todate:"+to);
																	System.out.println("fromdate:"+from);
																	
																    int numberOfDays = 0;
																    while (cal2.before(cal1)) 
																    {
																            numberOfDays++;
																        cal2.add(Calendar.DATE,1);
																    }
																    	numberOfDays = numberOfDays + 1;
																    	days = numberOfDays;
																    	System.out.println( " SAME DATE IN TOTAL DAY COUNT " + days);
															}
															catch(Exception e)
															{
																
															}
															
															if(SL != 0)
															{
																if(SL > days)		
																{
																	if(days > SELECTDAY)
																	{
																		if(SL > SELECTDAY)
																		{
																			BSL = SL;
																			ADJDAY = days - SL;
																			SL = 0;
																			SELECTDAY = 0;
																		}
																		else
																		{
																			SL = SL - SELECTDAY;
																			days = days - SELECTDAY;
																			ADJDAY = 0;
																			BSL = SELECTDAY;
																		}
																	}
																	else
																	{
																		SL = SL - days;
																		ADJDAY = 0;
																		BSL = days;
																	}
																}
																else if(SL <= days)
																{
																	if(days > SELECTDAY)
																	{
																		if(SL > SELECTDAY)
																		{
																			BSL = SL;
																			ADJDAY = days - SL;
																			SELECTDAY = 0;
																			SL = 0;		
																		}
																		else
																		{
																			SELECTDAY = SELECTDAY - SL;
																			days = days - SL;
																			ADJDAY = days;
																			BSL = SL;
																			SL = 0;
																		}
																	}
																	else
																	{
																		SELECTDAY = SELECTDAY - SL;
																		days = days - SL;
																		ADJDAY = days;
																		BSL = SL;
																		SL = 0;
																	}
																}
															}
															else
															{
																ADJDAY = SELECTDAY;
															}
														
															if(ADJDAY != 0)
															{
																if(SELECTDAY != 0)	
																{	
																	if(CO != 0)
																	{
																		if(CO > days)		
																		{
																			if(days > SELECTDAY)
																			{
																				CO = CO - SELECTDAY;
																				days = days - SELECTDAY;
																				ADJDAY = days;
																				BCO = SELECTDAY;
																				SELECTDAY = 0;
																			}
																			else
																			{
																				CO = CO - days;
																				ADJDAY = 0;
																				BCO = days;
																			}
																		}
																		else if(CO <= days)
																		{
																			if(days > SELECTDAY)
																			{	
																				BCO = SELECTDAY;
																				if(CO > SELECTDAY)
																				{
																					ADJDAY = CO - SELECTDAY;
																					CO = days - SELECTDAY;
																					days = days - PL;
																					SELECTDAY = 0;
																				}
																				else
																				{
																					BCO = CO;
																					SELECTDAY = SELECTDAY - CO;
																					ADJDAY = days - CO;
																					days = ADJDAY;
																					CO = 0;
																				}						
																			}
																			else
																			{
																				ADJDAY = CO - SELECTDAY;
																				SELECTDAY = SELECTDAY - CO;
																				days = days - CO;
																				BCO = CO;
																				CO = 0;	
																			}
																		}	
																	}
																}
																else
																{
																	//ADJDAY = SELECTDAY;
																}
															}
															
															if(ADJDAY != 0)
															{
																if(SELECTDAY != 0)
																{
																	if(PL != 0)
																	{
																		if(PL > days)		
																		{
																			if(days > SELECTDAY) 
																			{
																				PL = PL - SELECTDAY;
																				days = days - SELECTDAY;
																				ADJDAY = days;
																				BPL = SELECTDAY;
																			}
																			else
																			{
																				PL = PL - days;
																				ADJDAY = 0;
																				BPL = days;
																			}
																		}
																		else if(PL <= days)
																		{
																			if(days > SELECTDAY)
																			{								
																				if(PL > SELECTDAY)
																				{
																					BPL = SELECTDAY;
																					ADJDAY = days - SELECTDAY;
																					PL = PL - SELECTDAY;
																					SELECTDAY = 0;
																				}
																			else
																			{
																				BPL = PL;
																				ADJDAY = ADJDAY - SELECTDAY;
																				SELECTDAY = SELECTDAY - PL;
																				PL = 0;
																			}
																		}
																		else
																		{
																			days = days - PL;
																			ADJDAY = days;
																			BPL = PL;  
																			PL = 0;
																		}
																	}
																}
															}
														} 
														else
														{
															//ADJDAY = days;
														}
													    	
													    	
														RFT = "FF";
														RTT = "FF";
														Status = "Pending";
														boolean	result = allUpdateDAO.LeavesendwitchleaveBeanupdate(Purpose_of_Leave, From_date , RFT, Leave_To , RTT, days, CO, PL, SL, ADJDAY, Address, Number, Status, pushMainDate , popMainDate, Leave_Id);
														boolean	 result1 = allUpdateDAO.Leavesendwitchroulupdate(BCO, BPL, BSL, ADJDAY, MAIN_CO, MAIN_PL, MAIN_SL, MAIN_LWP, Leave_Id);
														if(result == true && result1 == true)
														{
																request.setAttribute("LeaveSuccessfully", "Leave Apply Successfully");
																/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
																response.sendRedirect("applyleave.jsp");
														}
													}
												}
											}
											else
											{
												System.out.println("Leave From Date And To Date Already exit");
												request.setAttribute("LeavefromtodateExist", "Leave From Date And To Date Already Exists");
												/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
												response.sendRedirect("applyleave.jsp");
											}
										}
									}
									else
									{
										System.out.println("Leave All Ready exit");
										request.setAttribute("LeaveExist", "Leave Already Exists");
										/*request.getRequestDispatcher("applyleave.jsp").forward(request, response);*/
										response.sendRedirect("applyleave.jsp");
									}
								}
							}
							else
							{
								//request.getRequestDispatcher("LeaveUnplanInsert").forward(request, response);
							}
						}						
					}
					else
					{
	
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
