package com.hrms.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class DesignInputsInsertServlet
 */
public class DesignInputsInsertServlet extends HttpServlet {
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
		String currDate = null;
		String addTaskPage = null;
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date); 
		
		
		String headCol="-", headCol1 = "-",headCol2 = "-",headCol3 = "-",headCol4 = "-",headCol5 = "-",headCol6 = "-",headCol7 = "-",headCol8 = "-",headCol9 = "-",headCol10 = "-",
				headCol11 = "-",headCol12 = "-",headCol13 = "-",headCol14 = "-",headCol15 = "-",headCol16 = "-",headCol17 = "-",headCol18 = "-",headCol19 = "-",headCol20 = "-";
		
		String remarks1 = "-",remarks2 = "-",remarks3 = "-",remarks4 = "-",remarks5 = "-",remarks6 = "-",remarks7 = "-",remarks8 = "-",remarks9 = "-",remarks10 = "-",
				remarks11 = "-",remarks12 = "-",remarks13 = "-",remarks14 = "-",remarks15 = "-",remarks16 = "-",remarks17 = "-",remarks18 = "-",remarks19 = "-",remarks20 = "-";
		
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
					
					if (fieldName.equalsIgnoreCase("date")) {
						currDate = fieldValue+" "+time;
						System.out.println("currDate:"+currDate);
					}

					if (fieldName.equalsIgnoreCase("addTaskPage")) {
						addTaskPage = fieldValue;
						System.out.println("addTaskPage:"+addTaskPage);
					}
					
					if (fieldName.equalsIgnoreCase("designName")) {
						designName = fieldValue;
						System.out.println("designName:"+designName);
					}
					
					if (fieldName.equalsIgnoreCase("headCol")) {
						headCol = fieldValue;
						System.out.println("headCol:"+headCol);
					}
					
					if (fieldName.equalsIgnoreCase("headCol1")) {
						headCol1 = fieldValue;
						System.out.println("headCol1:"+headCol1);
					}
					
					if (fieldName.equalsIgnoreCase("headCol2")) {
						headCol2 = fieldValue;
						System.out.println("headCol2:"+headCol2);
					}
					
					if (fieldName.equalsIgnoreCase("headCol3")) {
						headCol3 = fieldValue;
						System.out.println("headCol3:"+headCol3);
					}
					
					if (fieldName.equalsIgnoreCase("headCol4")) {
						headCol4 = fieldValue;
						System.out.println("headCol4:"+headCol4);
					}
					
					if (fieldName.equalsIgnoreCase("headCol5")) {
						headCol5 = fieldValue;
						System.out.println("headCol5:"+headCol5);
					}
					
					if (fieldName.equalsIgnoreCase("headCol6")) {
						headCol6 = fieldValue;
						System.out.println("headCol6:"+headCol6);
					}
					
					if (fieldName.equalsIgnoreCase("headCol7")) {
						headCol7 = fieldValue;
						System.out.println("headCol7:"+headCol7);
					}
					
					if (fieldName.equalsIgnoreCase("headCol8")) {
						headCol8 = fieldValue;
						System.out.println("headCol8:"+headCol8);
					}
					
					if (fieldName.equalsIgnoreCase("headCol9")) {
						headCol9 = fieldValue;
						System.out.println("headCol9:"+headCol9);
					}
					
					if (fieldName.equalsIgnoreCase("headCol10")) {
						headCol10 = fieldValue;
						System.out.println("headCol10:"+headCol10);
					}
					
					if (fieldName.equalsIgnoreCase("headCol11")) {
						headCol11 = fieldValue;
						System.out.println("headCol11:"+headCol11);
					}
					
					if (fieldName.equalsIgnoreCase("headCol12")) {
						headCol12 = fieldValue;
						System.out.println("headCol12:"+headCol12);
					}
					
					if (fieldName.equalsIgnoreCase("headCol13")) {
						headCol13 = fieldValue;
						System.out.println("headCol13:"+headCol13);
					}
					
					if (fieldName.equalsIgnoreCase("headCol14")) {
						headCol14 = fieldValue;
						System.out.println("headCol14:"+headCol14);
					}
					
					if (fieldName.equalsIgnoreCase("headCol15")) {
						headCol15 = fieldValue;
						System.out.println("headCol15:"+headCol15);
					}
					
					if (fieldName.equalsIgnoreCase("headCol16")) {
						headCol16 = fieldValue;
						System.out.println("headCol16:"+headCol16);
					}
					
					if (fieldName.equalsIgnoreCase("headCol17")) {
						headCol17 = fieldValue;
						System.out.println("headCol17:"+headCol17);
					}
					
					if (fieldName.equalsIgnoreCase("headCol18")) {
						headCol18 = fieldValue;
						System.out.println("headCol18:"+headCol18);
					}
					
					if (fieldName.equalsIgnoreCase("headCol19")) {
						headCol19 = fieldValue;
						System.out.println("headCol19:"+headCol19);
					}
					
					if (fieldName.equalsIgnoreCase("headCol20")) {
						headCol20 = fieldValue;
						System.out.println("headCol20:"+headCol20);
					}
					
					if (fieldName.equalsIgnoreCase("headInsert")) {
						System.out.println("insert");
						
						AllListDAO allListDAO = new AllListDAO();
						ProjectDesignHeadBean projectDesignHeadBean1 = allListDAO.getDetailsOfHeadForProjectByDate(project_id, currDate);
						
						if(projectDesignHeadBean1 == null){
							
							System.out.println("inside head");
							
						ProjectDesignHeadBean projectDesignHeadBean = new ProjectDesignHeadBean(designName, headCol, headCol1, headCol2, headCol3, headCol4, headCol5, headCol6, headCol7, headCol8, headCol9, headCol10, headCol11, headCol12, headCol13, headCol14, headCol15, headCol16, headCol17, headCol18, headCol19, headCol20, projectMasterBean, currDate);
						boolean result = allInsertDAO.designHeadInputInsert(projectDesignHeadBean);
						}
					}
					
					
					
					
					
					if (fieldName.equalsIgnoreCase("design_inputs_name")) {
						design_inputs_name = fieldValue;
						System.out.println("design_inputs_name:"+design_inputs_name);
					}
					
					
					if (fieldName.equalsIgnoreCase("remarks")) {
						remarks = fieldValue;
						System.out.println("remarks:"+remarks);
						
						
					}
					
					if (fieldName.equalsIgnoreCase("remarks1")) {
						remarks1 = fieldValue;
						System.out.println("remarks1:"+remarks1);
					}
					
					if (fieldName.equalsIgnoreCase("remarks2")) {
						remarks2 = fieldValue;
						System.out.println("remarks2:"+remarks2);
					}
					
					if (fieldName.equalsIgnoreCase("remarks3")) {
						remarks3 = fieldValue;
						System.out.println("remarks3:"+remarks3);
					}
					
					if (fieldName.equalsIgnoreCase("remarks4")) {
						remarks4 = fieldValue;
						System.out.println("remarks4:"+remarks4);
					}
					
					if (fieldName.equalsIgnoreCase("remarks5")) {
						remarks5 = fieldValue;
						System.out.println("remarks5:"+remarks5);
					}
					
					if (fieldName.equalsIgnoreCase("remarks6")) {
						remarks6 = fieldValue;
						System.out.println("remarks6:"+remarks6);
					}
					
					if (fieldName.equalsIgnoreCase("remarks7")) {
						remarks7 = fieldValue;
						System.out.println("remarks7:"+remarks7);
					}
					
					if (fieldName.equalsIgnoreCase("remarks8")) {
						remarks8 = fieldValue;
						System.out.println(remarks8);
					}
					
					if (fieldName.equalsIgnoreCase("remarks9")) {
						remarks9 = fieldValue;
						System.out.println("remarks9:"+remarks9);
					}
					
					if (fieldName.equalsIgnoreCase("remarks10")) {
						remarks10 = fieldValue;
						System.out.println("remarks10:"+remarks10);
					}
					
					if (fieldName.equalsIgnoreCase("remarks11")) {
						remarks11 = fieldValue;
						System.out.println("remarks11:"+remarks11);
					}
					
					if (fieldName.equalsIgnoreCase("remarks12")) {
						remarks12 = fieldValue;
						System.out.println("remarks12:"+remarks12);
					}
					
					if (fieldName.equalsIgnoreCase("remarks13")) {
						remarks13 = fieldValue;
						System.out.println("remarks13:"+remarks13);
					}
					
					if (fieldName.equalsIgnoreCase("remarks14")) {
						remarks14 = fieldValue;
						System.out.println("remarks14:"+remarks14);
					}
					
					if (fieldName.equalsIgnoreCase("remarks15")) {
						remarks15 = fieldValue;
						System.out.println("remarks15:"+remarks15);
					}
					if (fieldName.equalsIgnoreCase("remarks16")) {
						remarks16 = fieldValue;
						System.out.println("remarks16:"+remarks16);
					}
					
					if (fieldName.equalsIgnoreCase("remarks17")) {
						remarks17 = fieldValue;
						System.out.println("remarks17:"+remarks17);
					}
					
					if (fieldName.equalsIgnoreCase("remarks18")) {
						remarks18 = fieldValue;
						System.out.println("remarks18:"+remarks18);
					}
					
					if (fieldName.equalsIgnoreCase("remarks19")) {
						remarks19 = fieldValue;
						System.out.println("remarks19:"+remarks19);
					}
					
					if (fieldName.equalsIgnoreCase("remarks20")) {
						remarks20 = fieldValue;
						System.out.println("remarks20:"+remarks20);
					}
					
					if (fieldName.equalsIgnoreCase("designInsert")) {
						System.out.println("insert");
						ProjectDesignInputsBean projectDesignInputsBean = new ProjectDesignInputsBean(design_inputs_name, remarks, remarks1, remarks2, remarks3, remarks4, remarks5, remarks6, remarks7, remarks8, remarks9, remarks10, remarks11, remarks12, remarks13, remarks14, remarks15, remarks16, remarks17, remarks18, remarks19, remarks20, projectMasterBean, currDate);
						boolean result = allInsertDAO.designInputInsert(projectDesignInputsBean);
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
						    	String sub = "Project : "+ project_name + " is Assigned to You";
						    	String proj_code = proeject_code;
						    	String proj_name = project_name;
						    	String proj_start_date = project_start_date;
						    	String proj_end_date = project_end_date;
						    
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
						request.setAttribute("creatorView", "creatorView");
						
						if(addTaskPage != null){
							request.getRequestDispatcher("redirection.jsp").forward(request, response);
						}else{
							request.getRequestDispatcher("projectView.jsp").forward(request, response);
						}
						
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

