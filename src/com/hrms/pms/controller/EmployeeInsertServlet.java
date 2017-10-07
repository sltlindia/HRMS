package com.hrms.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.hrms.lms.bean.LeaveBalanceCSVUploadBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EmployeeStatusBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectStatusBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.recruitement.bean.CompanyListBean;


public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeInsertServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			String firstname = request.getParameter("firstname");
			String middlename = request.getParameter("middlename");
			String lastname = request.getParameter("lastname");
			int employee_code = Integer.parseInt(request.getParameter("employeecode"));
			String grade_code = request.getParameter("gradecode");
			String salutation = request.getParameter("optionsRadiosInline");
			String marital_status = request.getParameter("maritalstatus");
			String adress = request.getParameter("address");
			String joining_date = request.getParameter("joiningdate");
			String birth_date = request.getParameter("birthdate");
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
			String password = request.getParameter("employeecode");
			String location = request.getParameter("location");
			int role =Integer.parseInt(request.getParameter("role"));
			String manager_id = request.getParameter("manager");
			double resource_cost = Double.parseDouble(request.getParameter("resourcecost"));
			String email_id = request.getParameter("emailid");
			String cug_num = request.getParameter("cug_num");
			String per_emailid = request.getParameter("per_emailid");
			String mob_num = request.getParameter("mobileno");
			String nationality = request.getParameter("nationality");
			String basic_qualification = request.getParameter("basic_qualification");
			String special_qualification = request.getParameter("special_qualification");
			String iti_course = request.getParameter("iti_course");
			String diploma_course = request.getParameter("diploma_course");
			String special_interest = request.getParameter("special_interest");
			int employee_status_id = Integer.parseInt(request.getParameter("employee_status_id"));
			
			
			String digital_sign = null;
			String photo = "user.png";
			String graduate = request.getParameter("graduate_degree");
			String master = request.getParameter("master_degree");
			
			String plan_leave = null;
			String unplan_leave = null;
			String cO = null;
			String leave_without_pay = null;
			
			if(employee_status_id == 1){
				plan_leave = "23";
				unplan_leave = "7";
				cO = "0";
				leave_without_pay = "0";
			}else if(employee_status_id == 2){
				plan_leave = "0";
				unplan_leave = "0";
				cO = "0";
				leave_without_pay = "0";
			}
			
			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartment_id(hiringDepartment);
			RoleBean roleBean = new RoleBean();
			roleBean.setRole_id(role);
			ManagerBean managerBean = new ManagerBean();
			managerBean.setManager_id(99);
			CompanyListBean companyListBean = new CompanyListBean();
			companyListBean.setCompany_list_id(company);
			EmployeeStatusBean employeeStatusBean  = new EmployeeStatusBean();
			employeeStatusBean.setEmployee_status_id(employee_status_id);
			
			System.out.println("EmailId"+per_emailid);
			
			
			EmployeeBean employeeDummyBean = new EmployeeBean(firstname, middlename, lastname, employee_code, salutation, adress, joining_date, birth_date, marital_status, languages, sub_department, gender, gross_salary, blood_group, height, weight, identification_marks, digital_sign, photo, password, location, email_id, per_emailid , resource_cost, mob_num, cug_num, nationality, basic_qualification, special_qualification, roleBean, departmentBean, managerBean, companyListBean,manager_id,employeeStatusBean,graduate,master, grade_code,iti_course,diploma_course,special_interest );
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			boolean result = allInsertDAO.employeeInsert(employeeDummyBean);
			int emp_master_id = employeeDummyBean.getEmployee_master_id();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(emp_master_id);
			
			LeaveBalanceCSVUploadBean leaveBalanceCSVUploadBean = new LeaveBalanceCSVUploadBean(plan_leave, unplan_leave, cO, leave_without_pay, employeeBean);
			allInsertDAO.leaveBalanceCSVInsert(leaveBalanceCSVUploadBean);
			
			request.setAttribute("employee_master_id", emp_master_id );
			request.getRequestDispatcher("employeeAccountDetail").forward(request, response);
		
		}
	
	}
}


