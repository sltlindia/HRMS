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
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class EmployeeSelfUpdateServlet
 */
public class EmployeeSelfUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){

			int employee_dummy_id = Integer.parseInt(request.getParameter("employee_dummy_id"));
			System.out.println(employee_dummy_id);
			String firstname = request.getParameter("firstname");
			String middlename = request.getParameter("middlename");
			String lastname = request.getParameter("lastname");
			int employee_code = user.getEmployee_code();
			String salutation = request.getParameter("optionsRadiosInline");
			System.out.println("salutation:"+salutation);
			String marital_status = request.getParameter("maritalstatus");
			String adress = request.getParameter("address");
			String jd = user.getJoining_date();
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
			
			int hiringDepartment= user.getDepartmentBean().getDepartment_id();
			String sub_department = user.getSub_department();
			String gender = request.getParameter("gender");
			String gross_salary = user.getGross_salary();
			String languages = request.getParameter("languages");
			String blood_group = request.getParameter("bloodgroup");
			String height = request.getParameter("height");
			String weight = request.getParameter("weight");
			String identification_marks = request.getParameter("identificationmarks");
			int company = user.getCompanyListBean().getCompany_list_id();
			String location = request.getParameter("location");
			int role = user.getRoleBean().getRole_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			int employee_status_id = user.getEmployeeStatusBean().getEmployee_status_id();
			Double r = user.getResource_cost();
			String resource_cost = r.toString();
			String email_id = request.getParameter("emailid");
			String mob_num = request.getParameter("mobileno");
			String nationality = request.getParameter("nationality");
			String basic_qualification = request.getParameter("basic_qualification");
			String special_qualification = request.getParameter("special_qualification");
			String graduate = request.getParameter("graduate_degree");
			String master = request.getParameter("master_degree");
			String digital_sign = null;
			String photo = null;
		
			
			
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.employeeAllUpdate(employee_dummy_id, firstname, middlename, lastname, employee_code, salutation, marital_status, adress, joining_date, birth_date, hiringDepartment, sub_department, gender, gross_salary, languages, blood_group, height, weight, identification_marks, company, location, role, under_manager_id, resource_cost, email_id, mob_num, nationality, basic_qualification, special_qualification,employee_status_id,graduate,master);
			
	
			request.setAttribute("updateData", "Employee Successfully Updated");
			request.setAttribute("success", "Profile update successfully...");
			if(request.getParameter("action")!= null){
				String authority = user.getRoleBean().getRole_authority();
				int manager_id  = user.getManagerBean().getManager_id();
				
				if(manager_id != 99){
					if(manager_id == 1 || manager_id == 2 || manager_id == 3){
					 request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
					}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
					 request.getRequestDispatcher("hrHome.jsp").forward(request, response);
					}else{
					 request.getRequestDispatcher("managerHome.jsp").forward(request, response);
					}	
					}else{
						if(under_manager_id == 4 || under_manager_id == 117){
							request.getRequestDispatcher("hrHome.jsp").forward(request, response);
						}else{
							request.getRequestDispatcher("empHome.jsp").forward(request, response);
									}
								}
				
				
			}else{
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);
			}
				}else{
						request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
						request.getRequestDispatcher("login.jsp").forward(request, response);
				}
	}

}

