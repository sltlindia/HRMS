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

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.DesignInputsBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskDefaultListBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class ManagerInsertServlet
 */
public class ManagerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		int project_id = 0;
		String design_inputs_name = null;
		String remarks = null;
		int emp_id = 0;
		String designName = null;
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		DesignInputsBean designInputsBean = new DesignInputsBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					
					if (fieldName.equalsIgnoreCase("project_id")) {
						String value = fieldValue;
						project_id = Integer.parseInt(value);
						System.out.println("project_id:"+project_id);
						
						projectMasterBean.setProject_master_id(project_id);
					}
					
					if (fieldName.equalsIgnoreCase("chkemployee")) {
						String value = fieldValue;
						emp_id = Integer.parseInt(value);
						System.out.println("emp_id:"+emp_id);
						
						EmployeeBean employeeBean = new EmployeeBean();
						employeeBean.setEmployee_master_id(emp_id);
						
						ProjectManagerListBean projectManagerListBean = new ProjectManagerListBean(employeeBean, projectMasterBean);
						boolean result1 = allInsertDAO.projectManagerInsert(projectManagerListBean);
						
						LoginDAO loginDAO = new LoginDAO();
						EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(emp_id);
						
						String name = employeeBean2.getFirstname() +" "+ employeeBean2.getLastname();
						String email = employeeBean2.getEmail_id();
						int dept_id = employeeBean2.getDepartmentBean().getDepartment_id();
						
						
						AllListDAO allListDAO = new AllListDAO();
						ProjectMasterBean projectMasterBean2 = allListDAO.getDetailsOfProject(project_id);
						String proeject_code = projectMasterBean2.getProject_code();
						String project_name = projectMasterBean2.getProject_master_name();
						String project_start_date = projectMasterBean2.getPlanned_start_date();
						String project_end_date = projectMasterBean2.getPlanned_end_date();
						int manager = projectMasterBean2.getManagerBean().getManager_id();
						 
						EmployeeBean empBean = loginDAO.getEmailId(manager);
						
						String manager_name = empBean.getFirstname() +" "+ empBean.getLastname();
						
						
						new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	
						    	String to = email;
						    	String sub = "Project "+ project_name + " is Assigned to You";
						    	String proj_code = proeject_code;
						    	String proj_name = project_name;
						    	String proj_start_date = project_start_date;
						    	String proj_end_date = project_end_date;
						    
						    	System.out.println("test");
						    	
						    	Mailer.createProject(to, sub, proj_code, proj_name, proj_start_date, proj_end_date, project_name, manager_name);
						    	
						    }
						}).start();
						
						List<TaskDefaultListBean> listOfDefaultTask = allListDAO.getListOfDefaultTask(dept_id);
						ProjectMasterBean p = allListDAO.getDetailsOfProject(project_id);
						
						String plannedStartDate = p.getPlanned_start_date();
						String plannedEndDate = p.getPlanned_start_date();
						String duration = p.getProj_estimated_duration();
						double cost = 0;
						int priority_id = 1;
						int manager_id = employeeBean2.getManagerBean().getManager_id();
						int dependent_id = 0;
						String resources = "1";
						int milestone_id = 1;
						int task_id = 0;
						int master_task_id = 0;
						
						List<Object[]> listOfTask2 = allListDAO.getTaskListByProjectMilestoneID111(project_id,manager_id);

						if(listOfTask2.size() == 0){
						
						for(TaskDefaultListBean taskDefaultListBean : listOfDefaultTask){
							
							String task_name = taskDefaultListBean.getTask_default_list_name();
							String task_desc = taskDefaultListBean.getTask_default_list_name();
							
							
							TaskMasterBean taskMasterBean = new TaskMasterBean();
							boolean result = allInsertDAO.taskInsert(task_name, task_desc, plannedStartDate, plannedEndDate, duration, cost, priority_id, manager_id,project_id,dependent_id,resources,milestone_id,task_id,master_task_id);
						
						}
						}
						
					}
					
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						
						request.setAttribute("project_id", project_id);
						request.setAttribute("activeView", "projectDetail");
						request.setAttribute("creatorView", "creatorView");
						request.getRequestDispatcher("redirection.jsp").forward(request, response);
						
					}
					
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}


