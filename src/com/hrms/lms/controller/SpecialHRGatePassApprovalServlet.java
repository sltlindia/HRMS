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
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class SpecialHRGatePassApprovalServlet
 */
public class SpecialHRGatePassApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialHRGatePassApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			String purpose_of_leave = request.getParameter("purpose_of_leave");
			String reason = request.getParameter("reason");
			String Returnable = "-";
			String Fromdec = request.getParameter("CompanyName");
			String Todec = request.getParameter("Todec");
			String out_time = request.getParameter("outTime");
			String status = "Pending";
			int gate_entry = 0;
			int manager_id = Integer.parseInt(user.getUnder_manager_id());             // Manager Of Employee
			int other_manager_id = Integer.parseInt(request.getParameter("manager")); // Higher Manager of Manager of Employee
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String date1 = sdf.format(date);
			String mailDate = sdf1.format(date);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(emp_id);
			
			GatePassBean gatePassBean = new GatePassBean(employeeBean, purpose_of_leave, reason, Returnable, out_time, status, date1 , Fromdec , Todec,gate_entry,other_manager_id);
			
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean2 = loginDAO.getEmailId(manager_id);
			String EmailId = employeeBean2.getEmail_id();
			
			boolean result = allInsertDAO.gatePassInsert(gatePassBean);
			if(result == true){
				
				/*new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	String to = EmailId;
				    	String sub = name + " apply for Gate Pass";
				    	int emp_code = user.getEmployee_code();
				    	
				    	Mailer.applyGatePass(to, sub, emp_code,name,out_time, Fromdec, Todec,mailDate,reason);
				    	
				    }
				}).start();*/
				
				request.setAttribute("success", "Gate Pass Successfully Applied....");
				request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
