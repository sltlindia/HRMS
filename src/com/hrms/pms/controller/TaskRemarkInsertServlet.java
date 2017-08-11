package com.hrms.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import com.hrms.pms.bean.DesignInputsBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.TaskRemarkBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

public class TaskRemarkInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		String remark = request.getParameter("remark");
		int remarkId = Integer.parseInt(request.getParameter("remarkId"));
		
		TaskMasterBean taskMasterBean = new TaskMasterBean(); 
		taskMasterBean.setTask_master_id(task_id);
		
		if(remarkId == 0){
		TaskRemarkBean taskRemarkBean = new TaskRemarkBean(remark, taskMasterBean);
			boolean result = allInsertDAO.taskRemarkInsert(taskRemarkBean);
		}else {
			boolean result = allUpdateDAO.taskRemarkUpdate(remarkId, remark);
		}
		
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		
		
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}


