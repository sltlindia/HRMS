package com.hrms.pms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.CommentMilestoneBean;
import com.hrms.pms.bean.CommentTaskBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class TaskCommentInsertServlet
 */
public class TaskCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			//Bhoomi Patel
			//17-03-2017 : ArrayList Of Email
			
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		String task_name = request.getParameter("task_name");
		String project_name = request.getParameter("project_name");
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		String comment = request.getParameter("comment");
		int email_manager_id = Integer.parseInt(request.getParameter("email_manager_id"));
		String commentor_email_id = user.getEmail_id();
 		
		int employee_id =  user.getEmployee_master_id();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String date1 = sdf.format(date);
		
		AllListDAO allListDAO = new AllListDAO();
		List<ProjectManagerListBean> listOfManager  = allListDAO.getListOfManagerForProject(project_id);
		List<Object[]> listOfEmployee = allListDAO.getPerOfAllocationByProjectId(project_id);
		
		TaskMasterBean taskMasterBean = new TaskMasterBean();
		EmployeeBean employeeBean = new EmployeeBean();
		
		taskMasterBean.setTask_master_id(task_id);
		employeeBean.setEmployee_master_id(employee_id);
		
		
		
		CommentTaskBean commentTaskBean = new CommentTaskBean(comment, date1, taskMasterBean, employeeBean);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result = allInsertDAO.taskCommentInsert(commentTaskBean);
		
		List<String> arrayListOfEmail = new ArrayList<>();
		
		for(ProjectManagerListBean projectManagerListBean : listOfManager){
			arrayListOfEmail.add(projectManagerListBean.getEmployeeBean().getEmail_id());
		}
		
		for(Object[] aRow : listOfEmployee){
			ProjectAllocationPercentageBean projectAllocationPercentageBean = (ProjectAllocationPercentageBean) aRow[0];
			arrayListOfEmail.add(projectAllocationPercentageBean.getEmployeeBean().getEmail_id());
			
		}
		
			arrayListOfEmail.add(commentor_email_id);
			
		LoginDAO loginDAO = new LoginDAO(); 
		EmployeeBean employeeBean2 = loginDAO.getEmailId(email_manager_id);
		String EmailId = employeeBean2.getEmail_id();
		String manager_name = employeeBean2.getSalutation()+" "+employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
		String commenter = user.getFirstname() +" "+ user.getLastname();
		
		System.out.println("Commentor Email_id"+commentor_email_id);
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	String to = EmailId;
		    	String sub = "Comment ";
		    	String name = manager_name;

		    	Mailer.commentorSend(to, sub, commenter, comment, name, task_name, project_name, arrayListOfEmail);
		    	System.out.println("Done.");
		    }
		}).start();
		
		
		
		if(result == true){
			if(request.getParameter("creatorView") != null){
				request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
			}else{
			request.getRequestDispatcher("addTask.jsp").forward(request, response); 
			}
		}
				
				
		}else {
			request.setAttribute("fail", "Email id not match with your Emloyee Code");
			request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
		}
	}

}
