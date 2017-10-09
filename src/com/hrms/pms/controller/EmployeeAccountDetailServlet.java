

/*Date : 13-06-2016
Name : Bhoomi Patel
Action : Employee Account Detail Insert  */

package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class EmployeeAccountDetailServlet
 */
public class EmployeeAccountDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int employee_master_id = (Integer)request.getAttribute("employee_master_id");
			String pan_no = request.getParameter("pan_no");
			String adhar_no = request.getParameter("adhar_no");
			String pf_no = request.getParameter("pf_no");
			String pf_uan_no = request.getParameter("pf_uan_no");
			String esic_no = request.getParameter("esic_no");
			String bank_acount_no = request.getParameter("bank_acount_no");
			String bank_name = request.getParameter("bank_name");
			String ifsc_code = request.getParameter("ifsc_code");
			
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.updateAccountDetail(employee_master_id, pan_no, adhar_no, pf_uan_no, esic_no, bank_acount_no, bank_name,pf_no,ifsc_code);
			request.setAttribute("employee_master_id", employee_master_id);
			
			
				request.getRequestDispatcher("familyDetailInsert").forward(request, response);
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	
	}

}
