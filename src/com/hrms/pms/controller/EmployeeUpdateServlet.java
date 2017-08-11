package com.hrms.pms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.dao.LoginDAO;

public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
			System.out.println(employee_master_id);
			String firstname = request.getParameter("firstname");
			String middlename = request.getParameter("middlename");
			String lastname = request.getParameter("lastname");
			int employee_code = Integer.parseInt(request.getParameter("empCode"));
			String grade_code = request.getParameter("gradecode");
			String salutation = request.getParameter("optionsRadiosInline");
			System.out.println("salutation:"+salutation);
			String marital_status = request.getParameter("maritalstatus");
			String adress = request.getParameter("address");
			String jd = request.getParameter("joiningdate");
			String bd = request.getParameter("birthdate");
			
			
			String birth_date = null;
			String joining_date = null;
			
				
				
				try {
						  
						SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
						Date result = formater.parse(bd);
						Date result1 = formater.parse(jd);
						SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
						birth_date = AppDateFormat.format(result);
						joining_date = AppDateFormat.format(result1);
						
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}	
			
			int hiringDepartment= Integer.parseInt(request.getParameter("department"));
			String sub_department = request.getParameter("subdepartment");
			String gender = request.getParameter("gender");
			String gross_salary = request.getParameter("grosssalary");
			String languages = request.getParameter("languages");
			String blood_group = request.getParameter("bloodgroup");
			String height = request.getParameter("height");
			String weight = request.getParameter("weight");
			String identification_marks = request.getParameter("identificationmarks");
			int company = Integer.parseInt(request.getParameter("company"));
			String location = request.getParameter("location");
			int role =Integer.parseInt(request.getParameter("role"));
			int manager_id = Integer.parseInt(request.getParameter("manager"));
			int employee_status_id = Integer.parseInt(request.getParameter("employee_status_id"));
			String resource_cost = request.getParameter("resourcecost");
			String email_id = request.getParameter("emailid");
			String mob_num = request.getParameter("mobileno");
			String nationality = request.getParameter("nationality");
			String basic_qualification = request.getParameter("basic_qualification");
			String special_qualification = request.getParameter("special_qualification");
			String iti_course = request.getParameter("iti_course");
			String diploma_course = request.getParameter("diploma_course");
			String special_interest = request.getParameter("special_interest");
			String digital_sign = null;
			String photo = null;
			String graduate = request.getParameter("graduate_degree");
			String master = request.getParameter("master_degree");
			String cug_num = request.getParameter("cug_num");
			String per_emailid = request.getParameter("per_emailid");
			
			
			
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.employeeAllUpdate(employee_master_id, firstname, middlename, lastname, employee_code, salutation, marital_status, adress, joining_date, birth_date, hiringDepartment, sub_department, gender, gross_salary, languages, blood_group, height, weight, identification_marks, company, location, role, manager_id, resource_cost, email_id, mob_num, nationality, basic_qualification, special_qualification,employee_status_id,graduate,master,per_emailid,cug_num,grade_code,iti_course,diploma_course,special_interest);
			
	
			request.setAttribute("updateData", "Employee Successfully Updated");
			request.setAttribute("success", "Profile update successfully...");
			
			
				
				if(request.getParameter("companyWise") != null){
					request.getRequestDispatcher("employeeUpdate.jsp").forward(request, response);
				}else{
				
					request.getRequestDispatcher("employeeUpdate.jsp").forward(request, response);
				}
			
			
			
				}else{
						request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
						request.getRequestDispatcher("login.jsp").forward(request, response);
				}
	}

}
