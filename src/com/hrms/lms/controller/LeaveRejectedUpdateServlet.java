package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveTypeBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveRejectedUpdateServlet
 */
public class LeaveRejectedUpdateServlet extends HttpServlet {
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
			int leaveid = 0;
			int month_id = 0;
			int employee_master_id = 0;
			String Purpose_of_Leave	 = null; 
			String fromDate = null;
			String toDate = null;
			double days = 0.0; 
			double mainday = 0;
			double diffrenceday = 0;
			String Address = null; 
			String Number = null;
			double CO = 0 , PL = 0 , SL = 0 , LWP = 0;
			double BCO = 0 , BPL = 0 , BSL = 0 , BLWP = 0 , LWPSUM = 0 , FLAG = 9;
			double MainCO = 0 , MainPL = 0 , MainSL = 0 , MainLWP = 0;
			double AdjustPL = 0;
			double cutCO = 0 , cutPL = 0, cutSL = 0 ,  cutWP = 0;
			double ADJDAY = 0 ,COPY = 0;
			int CONSTANTDAY = 9;
			double SELECTDAY = 9;
			int LeaveType = 0;
			double DAYS = 0;
			String status = "Pending";
			String MainStatus = null;
			String pushMainDate = null;
			String popMainDate = null;
			String colunmname1 = "CO";
			String colunmname2 = "Plan_Leave";
			String colunmname3 = "Unplan_Leave";
			String colunmname4 = "Leave_without_pay";
			double unplanLeave = 0;
			double planLeave = 0;
			String RFT = null;
			String RTT = null;
			int mail_view = 0;
			double PLAN = 0 , UNPLAN = 0 , TOTALPLANUNPLA = 0 , aaaaa = 0;
			LeaveBean leaveBean = new LeaveBean();
			LeaveTypeBean leaveTypeBean = new LeaveTypeBean();
			EmployeeBean employeeBean = new EmployeeBean();
			try {
				
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++)
				{
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
					
						if (fieldName.equalsIgnoreCase("leaveid"))
						{
							String value = fieldValue;
							leaveid= Integer.parseInt(value);
							System.out.println("Leave Id:"+ leaveid);
						}
						if (fieldName.equalsIgnoreCase("empcode"))
						{
							String value = fieldValue;
							employee_master_id= Integer.parseInt(value);
							System.out.println("Employee Code :"+ employee_master_id);
						}
						if (fieldName.equalsIgnoreCase("purposeofleave"))
						{
							Purpose_of_Leave = fieldValue;
							System.out.println("Purpose Of Leave:" + Purpose_of_Leave);
						}
						
						if (fieldName.equalsIgnoreCase("fromDate"))
						{
							fromDate = fieldValue;
							System.out.println("Form Date :-" + fromDate);
						}
						
						if (fieldName.equalsIgnoreCase("toDate"))
						{
							toDate = fieldValue;
							System.out.println("To Date:"+ toDate);
						}
												
						if (fieldName.equalsIgnoreCase("daycount"))
						{
							String value = fieldValue;
							days = Double.parseDouble(value);
							System.out.println("Day Count:"+ days);
						}
						
						if (fieldName.equalsIgnoreCase("Mainday"))
						{
							String value = fieldValue;
							mainday = Double.parseDouble(value);
							System.out.println("Day Count:"+ mainday);
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
						
						if (fieldName.equalsIgnoreCase("LeaveType"))
						{
							String value = fieldValue;
							LeaveType = Integer.parseInt(value);
							System.out.println("Leave type Id:"+ LeaveType);
						}
						
						if (fieldName.equalsIgnoreCase("MainStatus"))
						{
							MainStatus = fieldValue;
							System.out.println("MainStatus  "+ MainStatus);
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
						if (fieldName.equalsIgnoreCase("monthID"))
						{
							String value = fieldValue;
							month_id = Integer.parseInt(value);
							System.out.println("Month ID :"+ month_id);
						}
						if (fieldName.equalsIgnoreCase("leavefromDate"))
						{
							RFT = fieldValue;
							System.out.println("FROM DATE RADIO:"+ RFT);
						}
						if (fieldName.equalsIgnoreCase("leavetoDate"))
						{
							RTT = fieldValue;
							System.out.println("TO DATE RADIO:"+ RTT);
						}
						
						if (fieldName.equalsIgnoreCase("redirect"))
						{
									
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
							//List<LeavecutBalance> l =(ArrayList<LeavecutBalance>) allLMSListDAO.getListOfCutLeave(leaveid);
							LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(employee_master_id);
							
							System.out.println("IF");
							CO = leaveBalanceBean.getCO();
							PL = leaveBalanceBean.getPlan_Leave();
							SL = leaveBalanceBean.getUnplan_Leave();
							LWP = leaveBalanceBean.getLeave_without_pay();
							System.out.println(" CO " + CO + " PLAN " + PL + " UNPLAN " + SL + " LWP " + LWP);
							System.out.println("LEAVE TYPE ID" + LeaveType);
							System.out.println("LEAVE STATUS " + MainStatus);
						
							if(MainStatus.equals("Pending") || MainStatus.equals("rejected") ||  MainStatus.equals("approved"))
							{
								
								try {
									  
									SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
									Date result1 = formater1.parse(fromDate);
									Date result2 = formater1.parse(toDate);
									SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
									fromDate = formater2.format(result1);
									toDate = formater2.format(result2);
									System.out.println("Leave From Date " + fromDate);
									System.out.println("Leave From Date " + toDate);
								}
								catch (ParseException e1) 
								{
									e1.printStackTrace();
								}	
								
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
								
							
								
								List<LeaveBean> listOfLeave = allLMSListDAO.getUnplanListPerMonth(unplanstartDate, unplanendDate, employee_master_id);
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
								
						
								DAYS = days;
								if(LeaveType == 1)
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
							}
								else if(LeaveType == 5)
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
																	CO = CO - ADJDAY;
																	BCO = ADJDAY;
																	ADJDAY = 0;			
																}
																else if(CO <= ADJDAY)
																{
																	BCO = ADJDAY;
																	CO = CO - ADJDAY;
															 		ADJDAY = 0;
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
								}
								
								System.out.println("Current CO Balance " + CO); 
								System.out.println("Current Plan Balance " + PL);   
								System.out.println("Current Unplan Balance " +  SL); 
								System.out.println("Current LWP Balance " + LWP); 
								System.out.println("Cut CO " + BCO); 
								System.out.println("Cut Plan " + BPL);   
								System.out.println("Cut Unplan " + BSL); 
								System.out.println("Current LWP Balance  " + ADJDAY); 
									
								
								boolean update = allUpdateDAO.Leaverejectupdate(Purpose_of_Leave, fromDate, toDate, DAYS, CO, PL, SL, ADJDAY, Address, Number, pushMainDate, popMainDate, status, leaveid,RFT,RTT);
								boolean result = allUpdateDAO.LeaveMailUpdate(leaveid,mail_view);
								//boolean result = allUpdateDAO.LeaveUpdateBeforeApproved(colunmname1, CO, colunmname2, PL, colunmname3, SL , colunmname4 , ADJDAY, employee_master_id);
								boolean cutbalance = allUpdateDAO.LeaveCUTUpdateBeforeApproved(BCO, BPL, BSL, ADJDAY, leaveid);
								
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
								 catch (MalformedURLException  e1)
								 {    
									 e1.printStackTrace();
							     }
								 catch (IOException e2)
								 {
									 e2.printStackTrace();
								 }
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								if(update == true && cutbalance == true)
								{
									request.setAttribute("LeaveSuccessfully", "Leave Update Successfully");
									 /*request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);*/
									response.sendRedirect("leavesuccess.jsp");
								}
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
