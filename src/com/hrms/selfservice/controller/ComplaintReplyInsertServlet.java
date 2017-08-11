package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.riskmanagement.bean.ConcernPersonBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

public class ComplaintReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ComplaintReplyInsertServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			String correction = request.getParameter("reply");
			System.out.println("reply:"+correction);
			String date_of_resolve = request.getParameter("date_of_resolve");
			System.out.println("date"+date_of_resolve);
			String remarks = request.getParameter("remarks");
			System.out.println("erre"+remarks);
			int complaint_id = Integer.parseInt(request.getParameter("complaint_id"));
			System.out.println("com_id"+complaint_id);
			String status = "completed";
			/*int verified_by = Integer.parseInt(request.getParameter("employee_master_id"));*/
			String[] verified_by = request.getParameterValues("managerName");
			AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
			boolean result = allUpdateSelfServiceDAO.replyUpdate(correction,date_of_resolve,remarks,status,complaint_id);
			ComplaintBean complaintBean = new ComplaintBean();
			complaintBean.setComplaint_id(complaint_id);
			for(String s : verified_by){
				/*int e_id = Integer.parseInt(s); 
				System.out.println("e_id"+e_id);*/
				EmployeeBean e = new EmployeeBean();
				e.setEmployee_master_id(Integer.parseInt(s));
				ComplaintVerifiedByBean complaintVerifiedByBean = new ComplaintVerifiedByBean(complaintBean, e);
				AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
				allInsertSelfServiceDAO.complaintVerifiedByInsert(complaintVerifiedByBean);
			
			}
			
			request.getRequestDispatcher("itComplaint.jsp").forward(request, response); 
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
		}	
		
			
		}


