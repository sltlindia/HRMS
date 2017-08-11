package com.hrms.pms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RecommendationBean;
import com.hrms.pms.bean.RecommendationOptionsBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class RecommendationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			String role_authority = user.getRoleBean().getRole_authority();
		
	int employee_id =Integer.parseInt(request.getParameter("employee_id"));
	int review_id = Integer.parseInt(request.getParameter("review_id"));
	int  recommendation_id =Integer.parseInt( request.getParameter("rdbRecommendation"));
	String description = request.getParameter("description");
	int manager_id = user.getManagerBean().getManager_id();
	int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean result = allInsertDAO.recommendationInsert(employee_id,review_id,recommendation_id,description);
	request.setAttribute("success", "Recommendation successfully send to HR...");
	
	
	if(manager_id != 99){
		if(manager_id == 1 || manager_id == 2 || manager_id == 3){
		 request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
		}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
		 request.getRequestDispatcher("hrHome.jsp").forward(request, response);
		}else{
		 request.getRequestDispatcher("managerHome.jsp").forward(request, response);
		}	
		}else{
			if(under_manager_id == 4 || under_manager_id == 117){
				request.getRequestDispatcher("hrHome.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("empHome.jsp").forward(request, response);
						}
					}	
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
		
	}
}
