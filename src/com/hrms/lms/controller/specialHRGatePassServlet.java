package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllLMSListDAO;

/**
 * Servlet implementation class specialHRGatePassServlet
 */
public class specialHRGatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public specialHRGatePassServlet() {
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
		
		
	}

}
