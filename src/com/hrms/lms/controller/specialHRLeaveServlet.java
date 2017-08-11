package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class specialHRLeaveServlet
 */
public class specialHRLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public specialHRLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int empcode = Integer.parseInt(request.getParameter("empcode"));
		String leavetypeselect = request.getParameter("leavetypeselect");
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		
		System.out.println("Emp Code" + empcode);
		
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		
		EmployeeBean employeeBean = (EmployeeBean) allListDAO.getspecialleaveListbyEMPCode(empcode,companyId);
		if(employeeBean != null){
		String fristname = employeeBean.getFirstname();
		String lasttname = employeeBean.getLastname();
		int emp_id = employeeBean.getEmployee_master_id();
		int dept_id = employeeBean.getDepartmentBean().getDepartment_id();
		String under_manger_id = employeeBean.getUnder_manager_id();
		String marrital_status = employeeBean.getMarital_status();
		String name = fristname + " " + lasttname;
		String gender = employeeBean.getGender();

		request.setAttribute("employeeBean", employeeBean);
		
		request.setAttribute("emp_id", emp_id);
		request.setAttribute("empcode", empcode);
		request.setAttribute("name", name);
		request.setAttribute("dept_id", dept_id);
		request.setAttribute("marrital_status", marrital_status);
		request.setAttribute("under_manger_id", under_manger_id);
		request.setAttribute("gender", gender);
		
		request.setAttribute("leavetypeselect", leavetypeselect);
		
		}else{
			request.setAttribute("LeaveExist", "No Employee Exist for this Employee Code");
		}
		
		if(leavetypeselect.equalsIgnoreCase("Leave")){
			request.setAttribute("HR", "HRLeave");
			request.getRequestDispatcher("applyLeave.jsp").forward(request, response);
		}else if(leavetypeselect.equalsIgnoreCase("CO")){
			request.setAttribute("HR", "HRCO");
			request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
		}else if(leavetypeselect.equalsIgnoreCase("OD")){
			request.setAttribute("HR", "HROD");
			request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
		}else if(leavetypeselect.equalsIgnoreCase("GatePass")){
			request.setAttribute("HR", "HRGatePass");
			request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
		
		}
		
	}

}
