package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;

/**
 * Servlet implementation class LeaveODEmployeeShowServlet
 */
public class LeaveODEmployeeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveODEmployeeShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int OD_ID = Integer.parseInt(request.getParameter("OD_ID"));
		System.out.println("CO_ID: "+ OD_ID);
		String status = request.getParameter("status");
		
		if(status.equalsIgnoreCase("approved"))
		{
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.ODShowView(OD_ID);
			if(result == true)
			{
				System.out.println("OD Show View Update successfully");
			}
		}
		
	
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveODBean> listOfOD = allListDAO.getODByODId(OD_ID);
		request.setAttribute("listOfOD", listOfOD);
		/*request.getRequestDispatcher("LeaveODEmployeeShow.jsp").forward(request, response);*/
		response.sendRedirect("LeaveODEmployeeShow.jsp");
	}

}
