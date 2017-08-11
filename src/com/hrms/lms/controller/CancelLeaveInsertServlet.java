package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.dao.AllInsertDAO;

/**
 * Servlet implementation class CancelLeaveInsertServlet
 */
public class CancelLeaveInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int leave_id = Integer.parseInt(request.getParameter("leave_id"));
	String reason = request.getParameter("remarks");
	int type = 1;
	String status = "pending";
	String from = "-";
	String to = "-";
	double day = 0;
	String lf ="-";
	String lt = "-";
	int mail_view = 0;
	
	LeaveBean leaveBean = new LeaveBean();
	leaveBean.setLeave_id(leave_id);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	
	LeaveCancelRequestBean leaveCancelRequestBean = new LeaveCancelRequestBean(type, reason, status, from, to, day, lf, lt, leaveBean,mail_view);
	boolean result = allInsertDAO.leaveCancelRequestInsert(leaveCancelRequestBean);
	
	request.setAttribute("success", "Your Leave is successfully gone to your manager for cancel...");
	request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
	
	}

}
