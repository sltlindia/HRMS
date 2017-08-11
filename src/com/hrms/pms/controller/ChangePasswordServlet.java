package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			String password = request.getParameter("pwd");

			LoginDAO loginDAO = new LoginDAO();
			boolean result = loginDAO.employeeUpdateInForgotPassword(emp_id, password);

			request.setAttribute("success", "Password Successfully Changed..");

			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			String authority = user.getRoleBean().getRole_authority();
			int manager_id = user.getManagerBean().getManager_id();
			if (manager_id != 99) {
				if (manager_id == 1 || manager_id == 2 || manager_id == 3) {
					System.out.println("sltl");
					request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
				} else if (manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117) {
					request.getRequestDispatcher("hrHome.jsp").forward(request, response);
					System.out.println("hr");
				} else {
					System.out.println("manager");
					request.getRequestDispatcher("managerHome.jsp").forward(request, response);

				}
			} else {
				if (under_manager_id == 4 || under_manager_id == 117) {
					request.getRequestDispatcher("hrHome.jsp").forward(request, response);
					System.out.println("hr");
				} else {
					request.getRequestDispatcher("empHome.jsp").forward(request, response);
					System.out.println("emp");
				}
			}

		} else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
