package com.hrms.lms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.GatePassBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;

/**
 * Servlet implementation class GatePassStatusMailUpdateServlet
 */
public class GatePassStatusMailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int gate_pass_id = Integer.parseInt(request.getParameter("gate_pass_id"));
		
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		
		GatePassBean gatePassBean = allLMSListDAO.getGatePassDetail(gate_pass_id);
		
		String status = request.getParameter("status");
		String reason = "-";
		
		if(gatePassBean.getStatus().equalsIgnoreCase("approved") || gatePassBean.getStatus().equalsIgnoreCase("out")) {
			request.setAttribute("success", "Gate Pass already Approved by gate person...");
			request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		}else {
		
		if(status.equalsIgnoreCase("rejected")) {
			reason = "Email Rejection so Please concern to your manager for this rejection";
		}else {
			
		}
		int Approved_ID = Integer.parseInt(request.getParameter("approvedId"));
		
		
		System.out.println("ID " + gate_pass_id + " REason " + reason + " Status " + status);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String date1 = sdf.format(date);
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.gatePassStatusUpdate(gate_pass_id, status, date1, reason , Approved_ID);
		
		if(result == true)
		{
				if(status.equalsIgnoreCase("Approved"))
				{
					request.setAttribute("success", "Gate Pass Approved Successfully...");
					request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("error", "Gate Pass Rejected Successfully...");
					request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
				}
		}
		}
		
	}

}
