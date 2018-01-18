package com.hrms.selfservice.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

public class ComplaintInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			int complaint_id =0;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			String date = dateFormat.format(date1);
			
			int employee_master_id = 0;
			
			if(request.getParameter("employee_name") != null){
				String value = request.getParameter("employee_name");

				String[] split = value.split(",");
				int emp_code = Integer.parseInt(split[0]);
				String name = split[1];
				int other_manager_id = 0;
				
				String[] splitName = name.split(" ");
				String firstName = splitName[0];
				String lastName = splitName[1];
				
				System.out.println("emp_code:"+emp_code);
				System.out.println("firstName:"+firstName);
				System.out.println("lastName:"+lastName);
				
				LoginDAO loginDAO = new LoginDAO();
				EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
				
				employee_master_id = employeeBean1.getEmployee_master_id();
			}else{
				 employee_master_id = user.getEmployee_master_id();
			}
			
			
			
			int extension = Integer.parseInt(request.getParameter("extension"));
			int problem_nature_id = Integer.parseInt(request.getParameter("problem_nature"));
			String location = request.getParameter("location");
			String description = request.getParameter("problem_desc");
			String status = "pending";
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
			ProblemNatureBean problemNatureBean = new ProblemNatureBean();
			problemNatureBean.setProblem_nature_id(problem_nature_id);
			int cartigeCount = Integer.parseInt(request.getParameter("cartigeCount")); 
			
			ComplaintBean complaintBean = new ComplaintBean(location, extension, description, date, status, employeeBean, problemNatureBean,cartigeCount);
			AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
			boolean result = allInsertSelfServiceDAO.complaintInsert(complaintBean);
			complaint_id = complaintBean.getComplaint_id();
			
			AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
			List<ComplaintBean> listOfComplaint = allListSelfServiceDAO.getcomplaintByComplaintId(complaint_id);
			for (ComplaintBean c : listOfComplaint) {
				String email_id = "it@sahajanandlaser.com"; 
				/*String email_id = "cprajapati1404@gmail.com"; */
				int employee_code = user.getEmployee_code();
				String username = user.getFirstname() + " " + user.getLastname();
				String complaintNature = c.getProblemNatureBean().getProblem_nature_name();
				String complaintDescription = c.getDescription();
				String complaintDate = date;
				int extension1 = c.getExtension();
				String location1 = c.getLocation();
				String dept = c.getEmployeeBean().getDepartmentBean().getDepartment_name();
				
			

				new Thread(new Runnable() {
					@Override
					public void run() {

						String to = email_id;
						String sub = username + " Register a complaint.";
						String userName = username;
						
						String complaint_date = null;
						
						DateFormat appFormater = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
						try {
							
							Date result = dateFormat.parse(complaintDate);
							complaint_date = appFormater.format(result);
							
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						
						int emp_code = employee_code;
						String complaint_description = complaintDescription;
						String complaintnature = complaintNature;
						int extension = extension1;
						String location = location1;
						String department = dept;
						

						 System.out.println("test"); 

						Mailer.complaintSend(to, sub, complaint_date, emp_code, complaint_description, userName,
								department,complaintnature,extension,location);

					}
				}).start();
			}
			
			
			
			request.getRequestDispatcher("complaint.jsp").forward(request, response);
	}

}

}