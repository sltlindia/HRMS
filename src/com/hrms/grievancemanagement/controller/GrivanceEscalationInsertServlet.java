package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.grievancemanagement.dao.AllListGrievanceDAO;
import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;

public class GrivanceEscalationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int emp_id = Integer.parseInt(request.getParameter("employee_master_id"));
	int grievance_id = Integer.parseInt(request.getParameter("grievance_id"));
	
	
	
	
	
	AllUpdateGrievanceDAO allUpdateGrievanceDAO = new AllUpdateGrievanceDAO();
	boolean result = allUpdateGrievanceDAO.grievanceQueryEscalation(emp_id, grievance_id);
	
	
	
	AllListGrievanceDAO allListDAO = new AllListGrievanceDAO();
	GrievanceQueryBean grievanceQueryBean = allListDAO.getGrivenceById(grievance_id);
	System.out.println(grievanceQueryBean.getGrievanceQueryTypeBean().getGrievance_query_type());
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String sub =  "One Query Escalted To you";
	    	String type = grievanceQueryBean.getGrievanceQueryTypeBean().getGrievance_query_type();
	    	String query = grievanceQueryBean.getQuery();
	    	String candidateName = grievanceQueryBean.getEmployeeBean().getFirstname()+" "+grievanceQueryBean.getEmployeeBean().getLastname();
	    	int code = grievanceQueryBean.getEmployeeBean().getEmployee_code();
	    	String attachment = grievanceQueryBean.getAttachment();
	    	String to = grievanceQueryBean.getEmployeeBean().getEmail_id();
	    	
	    	Mailer.send2(sub, type , query,code,attachment,candidateName,to);
	    	
	    }
	}).start();
	
	//request.getRequestDispatcher("allGrievanceHrList.jsp").forward(request, response);
	
	}

}
