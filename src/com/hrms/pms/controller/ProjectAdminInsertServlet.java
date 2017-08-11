package com.hrms.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectStatusBean;
import com.hrms.pms.dao.AllInsertDAO;




		public class ProjectAdminInsertServlet extends HttpServlet {
			private static final long serialVersionUID = 1L;

			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				EmployeeBean user = (EmployeeBean)session.getAttribute("user");
				if(user!=null){
			
					int manager_id = Integer.parseInt(request.getParameter("manager_id"));
					String projectName = request.getParameter("project_name");
					String project_desc = request.getParameter("project_desc");
					String startDate = request.getParameter("plannedStartDate");
					String endDate = request.getParameter("plannedEndDate");
					int client_id = Integer.parseInt(request.getParameter("client_id"));
					double cost =  Double.parseDouble(request.getParameter("cost"));
					String duration = request.getParameter("duration");
					String resources = request.getParameter("resources");
					int priority_id = Integer.parseInt(request.getParameter("priority_id"));
					int misc_Project = Integer.parseInt(request.getParameter("rdbType"));
					
					int projectStatus = 3;
					String hold_date ="-";
					String hold_reason ="-";
					String resume_date="-";
					String actual_start="-";
					String actual_end="-";
					
					System.out.println(manager_id);
					System.out.println(projectName);
					System.out.println(startDate);
					System.out.println(endDate);
					
					ManagerBean managerBean = new ManagerBean();
					ProjectStatusBean projectStatusBean = new ProjectStatusBean();
					ClientMasterBean clientMasterBean = new ClientMasterBean();
					PriorityBean priorityBean = new PriorityBean();
					managerBean.setManager_id(manager_id);
					projectStatusBean.setProject_status_id(projectStatus);
					clientMasterBean.setClient_master_id(client_id);
					priorityBean.setPriority_id(priority_id);
					
					ProjectMasterBean projectMasterBean = new ProjectMasterBean(projectName, project_desc,startDate,endDate, managerBean, projectStatusBean, hold_date, hold_reason, resume_date,cost,resources,duration,actual_end,actual_start,clientMasterBean,priorityBean,misc_Project);
					AllInsertDAO allInsertDAO = new AllInsertDAO();
					boolean result = allInsertDAO.projectInsert(projectMasterBean);
					if(result == false){
						System.out.println("Not ADD");
						request.setAttribute("sameProject", "Project Already Exist");
						/*request.getRequestDispatcher("projectAllocationWithPercentage.jsp").forward(request, response);*/
						request.getRequestDispatcher("projectList.jsp").forward(request, response);
					}else if(result == true){
						System.out.println("ADD");
					System.out.println("project_id:"+projectMasterBean.getProject_master_id());
					request.setAttribute("project_id", projectMasterBean.getProject_master_id());
					request.setAttribute("endDate", endDate);
					request.setAttribute("startDate", startDate);
					request.setAttribute("project_name", projectName);
					request.setAttribute("plannedResources", resources);
					request.setAttribute("insertData", "Project Successfully Added");
					request.setAttribute("action", "projAdmin");
					request.getRequestDispatcher("projectAllocationWithPercentage.jsp").forward(request, response);
					/*request.getRequestDispatcher("projectList.jsp").forward(request, response);*/
					
					}
				}else{
						request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
			
			}

		}
