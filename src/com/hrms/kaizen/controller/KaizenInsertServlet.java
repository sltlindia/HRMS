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
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
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
				String safety_features = "null";
				String status = "pending";
				String affecting_department = null;
				String time_saving = "null";
				String money_saving = "null";
				String effort_saving = "null";
				String safety_saving = "null";
				String productivity_saving = "null";
				int memberCount = 0;
				int kaizen_id = 0;
				String completion_status = "saved"; 
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
				
				
				
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
								
								EmployeeBean bean = new EmployeeBean();
								bean.setEmployee_master_id(user.getEmployee_master_id());
								
								kaizenBean = new KaizenBean(kaizen_name, description, existing_problem,safety_features, implementation_cost,under_manager_id,status,parseDate, time_saving,money_saving, effort_saving, safety_saving , productivity_saving,bean,completion_status);
								boolean result = allKaizenInsertDAO.kaizenInsert(kaizenBean);
								
								kaizen_id = kaizenBean.getKaizen_id();
								kaizenBean.setKaizen_id(kaizen_id);
								
							}	
							
							
							if (fieldName.equalsIgnoreCase("affecting_department")) {
								affecting_department = fieldValue;
								System.out.println("affecting_department:"+affecting_department);
							}
							
							
							if (fieldName.equalsIgnoreCase("mngEmployee")) 
							{
								
								if(affecting_department.equalsIgnoreCase("yes")){
									
								int value = Integer.parseInt(fieldValue);
								employeeBean.setEmployee_master_id(value);
								KaizenManagerBean kaizenManagerBean = new KaizenManagerBean(status, employeeBean, kaizenBean);
								
								boolean result = allKaizenInsertDAO.kaizenManagerInsert(kaizenManagerBean);
								
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
