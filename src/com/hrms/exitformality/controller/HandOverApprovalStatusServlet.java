package com.hrms.exitformality.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;

import com.hrms.exitformality.bean.DetailsOfHandOverFormBean;
import com.hrms.exitformality.bean.HandOverApprovalBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.exitformality.dao.AllUpdateExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;


public class HandOverApprovalStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
			int hand_over_form_detail_id = Integer.parseInt(request.getParameter("hand_over_form_detail_id"));
			int employee_master_id = user.getEmployee_master_id();
			String status = "Approved";
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String approvalDateTime = formater.format(date);
			
			
			AllUpdateExitFormalityDAO allUpdateExitFormalityDAO = new AllUpdateExitFormalityDAO();
			DetailsOfHandOverFormBean detailsOfHandOverFormBean = new DetailsOfHandOverFormBean();
			AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
			EmployeeBean bean = new EmployeeBean();
			
			detailsOfHandOverFormBean.setDetails_of_hand_over_form_id(hand_over_form_detail_id);
			bean.setEmployee_master_id(employee_master_id);
			
			boolean result = false;
			if(request.getParameter("hrApproval") != null){
				System.out.println("Insert");
				HandOverApprovalBean handOverApprovalBean = new HandOverApprovalBean(status, approvalDateTime, bean, detailsOfHandOverFormBean);
				result = allInsertExitFormalityDAO.insertHandOverApproval(handOverApprovalBean);
			}else{
				result = allUpdateExitFormalityDAO.updateApprovalStatus(hand_over_form_detail_id,employee_master_id,status,approvalDateTime);
			}
			
			if(result == true){
				
				request.setAttribute("success", "Approved Successfully...");
				if(request.getParameter("hrApproval") != null){
					request.getRequestDispatcher("handOverFormHRList.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("handOverFormList.jsp").forward(request, response);
				}
				
			}
			
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
}

}

}
