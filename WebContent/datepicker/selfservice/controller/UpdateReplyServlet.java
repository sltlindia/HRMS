package com.hrms.selfservice.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;


public class UpdateReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateReplyServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			String date = dateFormat.format(date1);
			
			int complaint_id = Integer.parseInt(request.getParameter("complaint_id"));
			int problem_nature_id = Integer.parseInt(request.getParameter("problem_nature_id"));
			String date3 = request.getParameter("date");		
			String description = request.getParameter("description");
			String location = request.getParameter("description");
			String extension = request.getParameter("extension");
			String correction = request.getParameter("correction");
			String date2 = request.getParameter("date2");
			String remarks = request.getParameter("remarks");
			String[] verified_by = request.getParameterValues("managerName");
			ProblemNatureBean problemNatureBean = new ProblemNatureBean();
			problemNatureBean.setProblem_nature_id(problem_nature_id);
			
			AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
			allDeleteSelfServiceDAO.complaintVerifiedPersonDelete(complaint_id);
			
			System.out.println("test");
			ComplaintBean complaintBean = new ComplaintBean();
			complaintBean.setComplaint_id(complaint_id);
			for(String s : verified_by){
				EmployeeBean e = new EmployeeBean();
				e.setEmployee_master_id(Integer.parseInt(s));
				ComplaintVerifiedByBean complaintVerifiedByBean = new ComplaintVerifiedByBean(complaintBean, e);
				AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
				allInsertSelfServiceDAO.complaintVerifiedByInsert(complaintVerifiedByBean);
			}
			
			AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
			boolean result = allUpdateSelfServiceDAO.replyUpdateManager(problem_nature_id,description,location,extension,correction,remarks,complaint_id,date3,date2);
			System.out.println("updted");
			request.getRequestDispatcher("itComplaint.jsp").forward(request, response);
	}

	
	}


}
