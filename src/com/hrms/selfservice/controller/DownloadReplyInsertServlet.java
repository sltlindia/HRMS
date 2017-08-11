package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

public class DownloadReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadReplyInsertServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			String reply = request.getParameter("reply");
			System.out.println("reply:"+reply);
			
			String remarks = request.getParameter("remarks");
			System.out.println("erre"+remarks);
			int download_id = Integer.parseInt(request.getParameter("download_id"));
			System.out.println("down_id"+download_id);
			String status = "completed";
		
			AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
			boolean result = allUpdateSelfServiceDAO.downloadUpdate(reply, remarks, status, download_id);
			
			
			request.getRequestDispatcher("itComplaint.jsp").forward(request, response); 
			}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
		}	
	
}
