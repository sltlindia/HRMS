package com.hrms.pms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GoalEmployeeAllocationBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.MonthlyGoalDetailBean;
import com.hrms.pms.bean.WorkBehaviourBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.dao.AllInsertDAO;

public class MonthlyGoalInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = 
	             getServletContext().getInitParameter("goal-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		int goal_employee_allocation_id = 0;
		String goal = null;
		String actual = null;
		String name = null;
		String year = null;
		int month_id = 0;
		int goal_id = 0;
		String comment = null;
		String attachment = null;
		
		GoalEmployeeAllocationBean goalEmployeeAllocationBean = new GoalEmployeeAllocationBean();
		MonthBean monthBean = new MonthBean();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("goal_employee_allocation_id")) {
						String value = fieldValue;
						goal_employee_allocation_id = Integer.parseInt(value);
						goalEmployeeAllocationBean.setGoal_employee_allocation_id(goal_employee_allocation_id);
						System.out.println("goal_employee_allocation_id:"+goal_employee_allocation_id);
					}
					
					if (fieldName.equalsIgnoreCase("month_id")) {
						String value = fieldValue;
						month_id = Integer.parseInt(value);
						System.out.println("month_id:"+month_id);
						monthBean.setMonth_id(month_id);
					}
					
					if (fieldName.equalsIgnoreCase("goal")) {
						goal = fieldValue;
						System.out.println("goal:"+goal);
					}
					
					if (fieldName.equalsIgnoreCase("name")) {
						name = fieldValue;
						System.out.println("name:"+name);
					}
					if (fieldName.equalsIgnoreCase("year")) {
						year = fieldValue;
						System.out.println("year:"+year);
					}
					
					if (fieldName.equalsIgnoreCase("goal_id")) {
						String value = fieldValue;
						goal_id = Integer.parseInt(value);
						System.out.println("goal_id:"+goal_id);
					}
					
					if (fieldName.equalsIgnoreCase("actual")) {
						actual = fieldValue;
						System.out.println("actual:"+actual);
						
						
					}
					
					if (fieldName.equalsIgnoreCase("comment")) {
						comment = fieldValue;
						System.out.println("comment:"+comment);
					}
					
					
				
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("id", goal_employee_allocation_id);
						request.setAttribute("name", name);
						request.setAttribute("year", year);
						request.setAttribute("goal_id", goal_id);
						
						request.getRequestDispatcher("fillMonthlyGoal.jsp").forward(request, response);
					}
					
					
					
					
				}else{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					/*String appPath = context.getRealPath("\\")+("WebContent\\upload");
					System.out.println("appPath : "+appPath);*/
					
					
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							attachment = "-";
							if(!goal.equalsIgnoreCase("")){
								MonthlyGoalDetailBean monthlyGoalDetailBean = new MonthlyGoalDetailBean(goal, actual, goalEmployeeAllocationBean, monthBean,comment,attachment);
								boolean result = allInsertDAO.MonthlyGoalDetailInsert(monthlyGoalDetailBean);
								
								}
							
						} else if(fieldName.equalsIgnoreCase("attachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								attachment = file.getName();
								
								if(!goal.equalsIgnoreCase("")){
									MonthlyGoalDetailBean monthlyGoalDetailBean = new MonthlyGoalDetailBean(goal, actual, goalEmployeeAllocationBean, monthBean,comment,attachment);
									boolean result = allInsertDAO.MonthlyGoalDetailInsert(monthlyGoalDetailBean);
									
									}
								
						}
					} catch (Exception e) {
						e.printStackTrace();
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

