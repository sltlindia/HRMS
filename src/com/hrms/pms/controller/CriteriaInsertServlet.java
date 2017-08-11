package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Synthesizer;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.SoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.bean.TechnicalBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

public class CriteriaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			int manager_id =Integer.parseInt(request.getParameter("manager_id"));
			int dept_id =Integer.parseInt(request.getParameter("dept_id"));
			int year =Integer.parseInt(request.getParameter("year"));
			int year2 = 0;
			if(request.getParameter("year2") != null){
				year2 =Integer.parseInt(request.getParameter("year2"));
			}
			String[] month = request.getParameterValues("chkMonth");
			
			String[] month2 = null;
			if(request.getParameterValues("chkMonth2") != null){
			month2 = request.getParameterValues("chkMonth2");
			}
			
			String[] employee_master_id = request.getParameterValues("chkEmployee");
			int project_id = Integer.parseInt(request.getParameter("rdbProject"));
			int technical_per = Integer.parseInt(request.getParameter("technical_per"));
			int softskill_per = Integer.parseInt(request.getParameter("softskill_per"));
			String[] technical_id = request.getParameterValues("chkTechnical");
			String[] softskill_id = request.getParameterValues("chkSoftskill");
			
			String allTechnical="";
			String allSoftskill="";
			String services="";
			
			EmployeeBean employeeBean = new EmployeeBean();	
			MonthBean monthBean = new MonthBean();
			YearBean yearBean = new YearBean();
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			
			System.out.println("Year:"+year);
			System.out.println("project:"+project_id);
			
			yearBean.setYear_id(year);
			projectMasterBean.setProject_master_id(project_id);
			
			for(String chkmonth : month ){
				System.out.println("month:"+chkmonth);
			}
			
			
			
			for(int i=0;i<=technical_id.length;i++){
				
			}
			for(String technical : technical_id ){
				allTechnical += technical + ",";
			}
			
			System.out.println("s:"+allTechnical);
			
			String[] splitValues = allTechnical.split(",");
			
			
			System.out.println("s:"+allSoftskill);
			
			String[] splitValue = allSoftskill.split(",");
			
			for(String softskill : softskill_id ){
				allSoftskill += softskill + ",";
			}
			
			System.out.println("s:"+allSoftskill);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			AllListDAO allListDAO = new AllListDAO();
			
			for(String employee : employee_master_id ){
				
				System.out.println("employee:"+employee);
				int employee1 = Integer.parseInt(employee);
				employeeBean.setEmployee_master_id(employee1);
				
				List<SpecificCriteriaBean> listOfSpecificCriteria = allListDAO.getSpecificCriteria(employee1, project_id);
				
				if(listOfSpecificCriteria.size() == 0){
				
				SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean(employeeBean, projectMasterBean, manager_id, technical_per, softskill_per, dept_id);
				boolean result = allInsertDAO.specificCriteriaAllocationInsert(specificCriteriaBean);
				
				int specific_id = specificCriteriaBean.getSpecific_criteria_allocation_id();
				specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
				for(String chkmonth : month ){
					System.out.println("month:"+chkmonth);
					int Month = Integer.parseInt(chkmonth);
					monthBean.setMonth_id(Month);
				
					SpecificCriteriaMonthBean specificCriteriaMonthBean = new SpecificCriteriaMonthBean(specificCriteriaBean, monthBean, yearBean);
					boolean result1 = allInsertDAO.specificCriteriaAllocationMonthInsert(specificCriteriaMonthBean);
					
					}
				
				for(String technical : technical_id ){
					TechnicalBean technicalBean  = new TechnicalBean();
					int criteria_id = Integer.parseInt(technical);
					technicalBean.setCriteria_id(criteria_id);
					
					SpecificCriteriaTechnicalBean specificCriteriaTechnialBean = new SpecificCriteriaTechnicalBean(specificCriteriaBean, technicalBean);
					boolean result2 = allInsertDAO.specificCriteriaAllocationTechnicalInsert(specificCriteriaTechnialBean);
					
				}
				
				
				for(String softskill : softskill_id ){
					SoftskillBean softskillBean = new SoftskillBean();
					int sofskillId = Integer.parseInt(softskill);
					softskillBean.setSoftskill_id(sofskillId);
					
					SpecificCriteriaSoftskillBean specificCriteriaSoftskillBean = new SpecificCriteriaSoftskillBean(specificCriteriaBean, softskillBean);
					boolean result3 = allInsertDAO.specificCriteriaAllocationSoftskillInsert(specificCriteriaSoftskillBean);
					
				}
				}else{
					request.setAttribute("duplicate", "Allocation already exist...");
				}
				
			}
			
			
			
			if(year2 != 0){
				yearBean.setYear_id(year2);
			for(String employee : employee_master_id ){
				
				System.out.println("employee:"+employee);
				int employee1 = Integer.parseInt(employee);
				employeeBean.setEmployee_master_id(employee1);
				
				List<SpecificCriteriaBean> listOfSpecificCriteria = allListDAO.getSpecificCriteria(employee1, project_id);
				
				if(listOfSpecificCriteria.size() == 0){
					
				SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean(employeeBean, projectMasterBean, manager_id, technical_per, softskill_per, dept_id);
				boolean result = allInsertDAO.specificCriteriaAllocationInsert(specificCriteriaBean);
				
				
				int specific_id = specificCriteriaBean.getSpecific_criteria_allocation_id();
				specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
				for(String chkmonth2 : month2 ){
					System.out.println("month:"+chkmonth2);
					int Month2 = Integer.parseInt(chkmonth2);
					monthBean.setMonth_id(Month2);
				
					SpecificCriteriaMonthBean specificCriteriaMonthBean = new SpecificCriteriaMonthBean(specificCriteriaBean, monthBean, yearBean);
					boolean result1 = allInsertDAO.specificCriteriaAllocationMonthInsert(specificCriteriaMonthBean);
					}
				
				for(String technical : technical_id ){
					TechnicalBean technicalBean  = new TechnicalBean();
					int criteria_id = Integer.parseInt(technical);
					technicalBean.setCriteria_id(criteria_id);
					
					SpecificCriteriaTechnicalBean specificCriteriaTechnialBean = new SpecificCriteriaTechnicalBean(specificCriteriaBean, technicalBean);
					boolean result2 = allInsertDAO.specificCriteriaAllocationTechnicalInsert(specificCriteriaTechnialBean);
				}
				
				
				for(String softskill : softskill_id ){
					SoftskillBean softskillBean = new SoftskillBean();
					int sofskillId = Integer.parseInt(softskill);
					softskillBean.setSoftskill_id(sofskillId);
					
					SpecificCriteriaSoftskillBean specificCriteriaSoftskillBean = new SpecificCriteriaSoftskillBean(specificCriteriaBean, softskillBean);
					boolean result3 = allInsertDAO.specificCriteriaAllocationSoftskillInsert(specificCriteriaSoftskillBean);
				}
				
			}else{
				request.setAttribute("duplicate", "Allocation already exist...");
			}
			}
			}
			
			
			request.getRequestDispatcher("criteriaAllocationList.jsp").forward(request, response);
			return;
			
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
	
	}

}
