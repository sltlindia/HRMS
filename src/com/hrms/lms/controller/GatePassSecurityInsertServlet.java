package com.hrms.lms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.GatePassBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class GatePassSecurityInsertServlet
 */
public class GatePassSecurityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			/*String value = 

			String[] split = value.split(",");
			int emp_code = Integer.parseInt(split[0]);
			String name = split[1];
			
			
			String[] splitName = name.split(" ");
			String firstName = splitName[0];
			String lastName = splitName[1];
			
			System.out.println("emp_code:"+emp_code);
			System.out.println("firstName:"+firstName);
			System.out.println("lastName:"+lastName);
			
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);*/
			int other_manager_id = 0;
			int emp_id = Integer.parseInt(request.getParameter("employee_name"));
			
			
			System.out.println("emp_id:"+emp_id);
			
			String purpose_of_gatePass = "Official";
			String reason = "Official Work";
			String Fromdec = request.getParameter("CompanyName");
			String Todec = request.getParameter("Todec");
			String status = "Out";
			int gate_entry = 1;
			String Returnable  = "-";
			
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:aa");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String out_time = sdf.format(date);
			String securityOutTime = sdf1.format(date);
			
			System.out.println("Current Date:"+out_time);
			System.out.println("Security Current Date:"+securityOutTime);
			System.out.println("Emp_id:"+emp_id);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(emp_id);
			
			GatePassBean gatePassBean = new GatePassBean(employeeBean, purpose_of_gatePass, reason,Returnable, out_time, status, securityOutTime , Fromdec , Todec,gate_entry,other_manager_id);
			boolean result = allInsertDAO.gatePassInsert(gatePassBean);
			int gate_pass_id = gatePassBean.getGate_pass_id();
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO(); 
			
			int e_id = user.getEmployee_master_id();
			boolean result1 = allUpdateDAO.gatePassInOutStatusUpdateWithSecurityId(gate_pass_id, status, securityOutTime, e_id);
			
			
			if(result == true){
				request.setAttribute("success", "Employee OUT Successfully");
				request.setAttribute("openStatus", "interCompany");
				request.getRequestDispatcher("gatePassListSecurity.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
