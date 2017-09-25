package com.hrms.kaizen.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.kaizenRCABean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class KaizenInsertServlet
 */
public class KaizenInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
				String kaizen_name = "null";
				String description = null;
				String implementation_cost = null;
				/*String time_saving = "null";
				String money_saving = "null";
				String effort_saving = "null";*/
				String existing_problem = "null";
				String safety_features = "-";
				String status = "pending";
				String affecting_department = null;
				String time_saving = "null";
				String money_saving = "null";
				String effort_saving = "null";
				String safety_saving = "null";
				String productivity_saving = "null";
				String category = null;
				int memberCount = 0;
				int kaizen_id = 0;
				String affectingmanager = "";
				String completion_status = "saved"; 
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
				LoginDAO loginDAO = new LoginDAO();
				
				EmployeeBean bean = loginDAO.getEmailId(under_manager_id);
				
				EmployeeBean employeeBean = new EmployeeBean();
				
				
				AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
				KaizenBean kaizenBean = new KaizenBean();
				DepartmentBean departmentBean = new DepartmentBean();
				
				Date date = new Date();
				String parseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
						
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							if (fieldName.equalsIgnoreCase("kaizen_name")) {
								kaizen_name = fieldValue;
								System.out.println("kaizen_name:"+kaizen_name);
							}
							
							if (fieldName.equalsIgnoreCase("description")) {
								description = fieldValue;
								System.out.println("description:"+description);
							}
							
							if (fieldName.equalsIgnoreCase("category")) {
								category = fieldValue;
								System.out.println("category:"+category);
							}
							
							if (fieldName.equalsIgnoreCase("existing_problem")) {
								existing_problem = fieldValue;
								System.out.println("existing_problem:"+existing_problem);
							}
							
							if (fieldName.equalsIgnoreCase("implementation_cost")) {
								implementation_cost = fieldValue;
								System.out.println("implementation_cost:"+implementation_cost);
							}
							
							if (fieldName.equalsIgnoreCase("safety_features")) {
								safety_features = fieldValue;
								System.out.println("safety_features:"+safety_features);
							}
							
							if (fieldName.equalsIgnoreCase("time_saving")) {
								time_saving = fieldValue;
								System.out.println("time_saving:"+time_saving);
							}
							
							if (fieldName.equalsIgnoreCase("money_saving")) {
								money_saving = fieldValue;
								System.out.println("money_saving:"+money_saving);
							}
							
							if (fieldName.equalsIgnoreCase("effort_saving")) {
								effort_saving = fieldValue;
								System.out.println("effort_saving:"+effort_saving);
							}
							
							if (fieldName.equalsIgnoreCase("safety_saving")) {
								safety_saving = fieldValue;
								System.out.println("safety_saving:"+safety_saving);
							}
							
							if (fieldName.equalsIgnoreCase("productivity_saving")) {
								productivity_saving = fieldValue;
								System.out.println("productivity_saving:"+productivity_saving);
							}
							
							if (fieldName.equalsIgnoreCase("memberCount")) {
								memberCount = Integer.parseInt(fieldValue);
								System.out.println("memberCount:"+memberCount);
							}
							
							if (fieldName.equalsIgnoreCase("insert")) 
							{
								
								EmployeeBean bean1 = new EmployeeBean();
								bean1.setEmployee_master_id(user.getEmployee_master_id());
								
								kaizenBean = new KaizenBean(kaizen_name, description, existing_problem,safety_features, implementation_cost,under_manager_id,status,parseDate, time_saving,money_saving, effort_saving, safety_saving , productivity_saving,bean1,completion_status,category);
								boolean result = allKaizenInsertDAO.kaizenInsert(kaizenBean);
								
								kaizen_id = kaizenBean.getKaizen_id();
								kaizenBean.setKaizen_id(kaizen_id);
								
								
							}	
							
							
							if (fieldName.equalsIgnoreCase("management_id")) {
								String value = fieldValue;
								System.out.println("management_id:"+value);
								String management_approval_status = "pending";
								String management_rejection_reason = "-";
								
								int employee_id = Integer.parseInt(value);
								employeeBean.setEmployee_master_id(employee_id);
								
								
								
								KaizenManagementApprovalBean kaizenManagementApprovalBean = new KaizenManagementApprovalBean(management_approval_status, management_rejection_reason, employeeBean, kaizenBean);
								boolean result = allKaizenInsertDAO.kaizenManagementInsert(kaizenManagementApprovalBean);
								
							}
							
							if (fieldName.equalsIgnoreCase("affecting_department")) {
								affecting_department = fieldValue;
								System.out.println("affecting_department:"+affecting_department);
							}
							
							
							if (fieldName.equalsIgnoreCase("mngEmployee")) 
							{
								
									
								int value = Integer.parseInt(fieldValue);
								employeeBean.setEmployee_master_id(value);
								KaizenManagerBean kaizenManagerBean = new KaizenManagerBean(status, employeeBean, kaizenBean);
								
								EmployeeBean bean2 = loginDAO.getInfoById(value);
								
								boolean result = allKaizenInsertDAO.kaizenManagerInsert(kaizenManagerBean);
								affectingmanager = affectingmanager+","+bean2.getFirstname()+" "+bean2.getLastname();
								
								
							}	
							
							
							if (fieldName.equalsIgnoreCase("rcaAns1")) {
								String value = fieldValue;
								System.out.println("rcaAns1:"+value);
								if(!value.equalsIgnoreCase("")) {
									kaizenRCABean kaizenRCABean = new kaizenRCABean(value, kaizenBean);
									boolean result = allKaizenInsertDAO.kaizenRCAInsert(kaizenRCABean);
								}
							}
							
							if (fieldName.equalsIgnoreCase("rcaAns2")) {
								String value = fieldValue;
								System.out.println("rcaAns2:"+value);
								if(!value.equalsIgnoreCase("")) {
									kaizenRCABean kaizenRCABean = new kaizenRCABean(value, kaizenBean);
									boolean result = allKaizenInsertDAO.kaizenRCAInsert(kaizenRCABean);
								}
							}
							
							if (fieldName.equalsIgnoreCase("rcaAns3")) {
								String value = fieldValue;
								System.out.println("rcaAns3:"+value);
								if(!value.equalsIgnoreCase("")) {
									kaizenRCABean kaizenRCABean = new kaizenRCABean(value, kaizenBean);
									boolean result = allKaizenInsertDAO.kaizenRCAInsert(kaizenRCABean);
								}
							}
							
							
							if (fieldName.equalsIgnoreCase("rcaAns4")) {
								String value = fieldValue;
								System.out.println("rcaAns4:"+value);
								if(!value.equalsIgnoreCase("")) {
									kaizenRCABean kaizenRCABean = new kaizenRCABean(value, kaizenBean);
									boolean result = allKaizenInsertDAO.kaizenRCAInsert(kaizenRCABean);
								}
							}
							
							
							if (fieldName.equalsIgnoreCase("rcaAns5")) {
								String value = fieldValue;
								System.out.println("rcaAns5:"+value);
								if(!value.equalsIgnoreCase("")) {
									kaizenRCABean kaizenRCABean = new kaizenRCABean(value, kaizenBean);
									boolean result = allKaizenInsertDAO.kaizenRCAInsert(kaizenRCABean);
								}
							}
							
							
							if (fieldName.equalsIgnoreCase("redirection")) {
								request.setAttribute("memberCount", memberCount);
								request.setAttribute("kaizen_id", kaizen_id);
								request.getRequestDispatcher("kaizenMember.jsp").forward(request, response);
							}	
							
						}
							
					}
							
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			
				}else{
					request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			
			}

		}
