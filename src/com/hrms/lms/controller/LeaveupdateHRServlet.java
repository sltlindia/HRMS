package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.hql.ast.tree.BooleanLiteralNode;

import com.hrms.lms.bean.LeaveAdjustBalanceBean;
import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

import javassist.compiler.ast.Symbol;

public class LeaveupdateHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeaveupdateHRServlet() {
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
		if(user!=null){
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
		 int empcode = 0 , employee_masert_id = 0;
		 String colunm = null , column1 = null , currentdate = null , column2 = null ;
		 double addvalue = 0;
		 double plan = 0 , unplan = 0 , CO = 0 , LWP = 0;;
		 double addplan = 0 , addunplan = 0, addco = 0;
		 double sumplan = 0 , sumunplan = 0 , sumco = 0;
		 String Reason = null;
		 double subValue = 0;
		 int companyId = 0;
		 String name1 = user.getFirstname()+" "+user.getLastname();
		 AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		 /*plan =  Double.parseDouble(request.getParameter("plan"));
		 unplan =  Double.parseDouble(request.getParameter("unplan"));
		 CO =  Double.parseDouble(request.getParameter("CO"));	*/
		 
		 LeaveAdjustBalanceBean adjustBalanceBean;
		 EmployeeBean employeeBean = new EmployeeBean();
		 AllInsertDAO allInsertDAO = new AllInsertDAO();
		 try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) 
				
				{
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("empcode")) 
						{
							String value = fieldValue;
							empcode = Integer.parseInt(value);
							System.out.println("Employee Code:"+ empcode);
						}
						
						if (fieldName.equalsIgnoreCase("companyId")) 
						{
							String value = fieldValue;
							companyId = Integer.parseInt(value);
							System.out.println("companyId:"+ companyId);
						}
						
						if (fieldName.equalsIgnoreCase("date"))
						{
							currentdate = fieldValue;
							System.out.println("Current Date : - " + currentdate);
						}
						
						if (fieldName.equalsIgnoreCase("empmaster")) 
						{
							String value = fieldValue;
							employee_masert_id = Integer.parseInt(value);
							System.out.println("Employee Master Id:"+ employee_masert_id);
							
							
							
						}
						if (fieldName.equalsIgnoreCase("leaveName"))
						{
							colunm = fieldValue;
							System.out.println("Colunm Name:" + colunm);
						}
						
						if(fieldName.equalsIgnoreCase("Plan"))
						{
							String value = fieldValue;
							plan = Double.parseDouble(value);
							System.out.println("Plan Value:"+ plan);
							
							
						}
						if(fieldName.equalsIgnoreCase("Unplan"))
						{
							String value = fieldValue;
							unplan = Double.parseDouble(value);
							System.out.println("UnPlan Value:"+ unplan);
						}
						if(fieldName.equalsIgnoreCase("CO"))
						{
							String value = fieldValue;
							CO = Double.parseDouble(value);
							System.out.println("CO Value:"+ CO);
						}
						
						if(fieldName.equalsIgnoreCase("LWP"))
						{
							String value = fieldValue;
							LWP = Double.parseDouble(value);
							System.out.println("CO Value:"+ LWP);
						}
						
						if(fieldName.equalsIgnoreCase("addvalue"))
						{
							String value = fieldValue;
							addvalue = Double.parseDouble(value);
							System.out.println("Adjust Value : "+addvalue);
						}
						
						if(fieldName.equalsIgnoreCase("subValue"))
						{
							String value = fieldValue;
							subValue = Double.parseDouble(value);
							System.out.println("Sub Value : "+subValue);
						}
						
						
						if (fieldName.equalsIgnoreCase("Reason"))
						{
							Reason = fieldValue;
							System.out.println("Reason for Plan " + Reason);
							
							
							
							if(colunm.equals("Plan Leave"))
							{
								
								if((addvalue != 0) || (subValue !=0))
								{
									
									
									column1  = "Plan_Leave";
									column2 = "Plan_Reason";
									sumplan = plan + addvalue;
									sumplan = sumplan - subValue;
									System.out.println("Sub PLan " + subValue );
									System.out.println(" Plan Adjust Value : "+ sumplan);
									boolean result = allUpdateDAO.LeaveUpdateHR(column1, sumplan, currentdate, column2,  Reason, employee_masert_id,name1);
									employeeBean.setEmployee_master_id(employee_masert_id);
									if(addvalue != 0)
									{
										adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean,  currentdate, name1, addvalue, subValue, Reason);
										boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
									}
									 
									if(subValue != 0)
									{
										adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, currentdate, name1, addvalue ,subValue, Reason);
										boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
									}
									
									

								}
								else
								{
									System.out.println("Not Value Add in Plan Leave");
								}
							}
							else
							{
								
							}
							if(colunm.equals("Unplan Leave"))
							{
								if((addvalue != 0) || (subValue !=0))
								{
									column1  = "Unplan_Leave";
									column2 = "Unplan_Reason";
									sumunplan = unplan + addvalue;
									sumunplan = sumunplan - subValue; 
									System.out.println(" Unplan Adjust Value : "+ sumunplan);
									boolean result = allUpdateDAO.LeaveUpdateHR(column1, sumunplan, currentdate, column2,   Reason,employee_masert_id,name1);
									
									employeeBean.setEmployee_master_id(employee_masert_id);
									if(addvalue != 0)
									{
										adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean,  currentdate, addvalue, subValue, name1,  Reason);
										boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
									}
									 
									if(subValue != 0)
									{
										adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, currentdate, addvalue ,subValue,  name1,Reason);
										boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
									}
									
									
								}
								else
								{
									System.out.println("Not Value Add in UnPlan Leave");
								}
							}
							else
							{
								
							}
							if(colunm.equals("CO"))
							{
								
								if((addvalue != 0) || (subValue !=0))
									{
										column1  = "CO";
										column2 = "CO_Reason";
										sumco = CO + addvalue;
										sumco = sumco - subValue; 
										System.out.println(" CO Adjust Value : "+ sumco);
										boolean result = allUpdateDAO.LeaveUpdateHR(column1, sumco, currentdate, column2,  Reason, employee_masert_id,name1);
										employeeBean.setEmployee_master_id(employee_masert_id);
										
										if(addvalue != 0)
										{
											adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, addvalue, subValue, currentdate, name1, Reason);
											boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
										}
										 
										if(subValue != 0)
										{
											adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, addvalue ,subValue, currentdate, name1, Reason);
											boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
										}
										
										
									}
								else
								{
									System.out.println("Not Value Add in CO Leave");
								}
							}
							else
							{
								
							}
							if(colunm.equals("LWP"))
							{
								
								if((addvalue != 0) || (subValue !=0))
									{
									
									
										column1  = "Leave_without_pay";
										column2 = "LWP_Reason";
										sumco = LWP + addvalue;
										sumco = sumco - subValue; 
										System.out.println(" CO Adjust Value : "+ sumco);
										boolean result = allUpdateDAO.LeaveUpdateHR(column1, sumco, currentdate, column2,  Reason ,employee_masert_id,name1);
										employeeBean.setEmployee_master_id(employee_masert_id);
										
										if(addvalue != 0)
										{
											adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, currentdate, name1, Reason ,  addvalue, subValue);
											boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
										}
										 
										if(subValue != 0)
										{
											adjustBalanceBean = new LeaveAdjustBalanceBean(employeeBean, currentdate, name1, Reason,  addvalue ,subValue);
											boolean result1 = allInsertDAO.leaveAdjustInsert(adjustBalanceBean);
										}
										
										
										
								
									}
								else
								{
									System.out.println("Not Value Add in CO Leave");
								}
							}
							
						}
						
					}
					
				}
				
				if (fieldName.equalsIgnoreCase("redirect"))
				{
					AllLMSListDAO allListDAO = new AllLMSListDAO();
					request.setAttribute("empcode", empcode);
					LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allListDAO.getleaveListbyEMPCodeAndCopanyID(empcode,companyId);
					/*	List<LeaveBean> listOfLeave = allListDAO.getLeaveByLeaveId(leave_id);*/
						request.setAttribute("leaveBalanceBean", leaveBalanceBean);
						String fristname = leaveBalanceBean.getEmployeeBean().getFirstname();
						String lasttname = leaveBalanceBean.getEmployeeBean().getLastname();
						String name = fristname + " " + lasttname;
						int emp_id = leaveBalanceBean.getEmployeeBean().getEmployee_master_id();
						List<LeaveAdjustBalanceBean> listOfAdjustHrBalance = allListDAO.getLeaveAdjustByEmpId(emp_id);
						request.setAttribute("empcode", empcode);
						request.setAttribute("name", name);
						request.setAttribute("companyId", companyId);
						request.setAttribute("listOfAdjustHrBalance", listOfAdjustHrBalance);
						request.setAttribute("LeaveSuccessfully", "Leave Adujusted successfully...");
						/*request.getRequestDispatcher("leaveadjustHR.jsp").forward(request, response);*/
						response.sendRedirect("leaveadjustHR.jsp");
							
					
				}
				
		 }
		 catch(Exception e)
		 {
			 
		 }
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}
		
	}

}
