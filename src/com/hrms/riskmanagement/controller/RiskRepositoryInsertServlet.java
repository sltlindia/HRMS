package com.hrms.riskmanagement.controller;

import java.io.IOException
;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.riskmanagement.bean.ConcernPersonBean;
import com.hrms.riskmanagement.bean.MonitoringFrequencyBean;
import com.hrms.riskmanagement.bean.ProbabilityBean;
import com.hrms.riskmanagement.bean.RiskPriorityBean;
import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.RiskStatusBean;
import com.hrms.riskmanagement.bean.SeverityBean;
import com.hrms.riskmanagement.bean.StakHoldersDetailsBean;
import com.hrms.riskmanagement.dao.AllInsertDAO;
import com.hrms.riskmanagement.dao.AllRiskManagementDAO;
import com.hrms.riskmanagement.dao.AllUpdateDAO;


public class RiskRepositoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int project_master_id = Integer.parseInt(request.getParameter("project_master_id"));
		int risk_priority_id = Integer.parseInt(request.getParameter("risk_priority_id"));
		int monitoring_frequency_id = Integer.parseInt(request.getParameter("monitoring_frequency_id"));
		int probability_id = Integer.parseInt(request.getParameter("probability_id"));
		int severity_id = Integer.parseInt(request.getParameter("severity_id"));
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		int risk_status_id = Integer.parseInt(request.getParameter("risk_status_id"));
		String date_of_risk_identification = null;
		String updated_on = null;
		String risk_type = null;
		String category_of_risk = null;
		String risk_description = null;
		String stage = null;
		String impact = null;
		String impact_description = null;
		String justification = null;
		String mitigation_action= null;
		String mitigation_date = null;
		String threshold_condition_mitigation = null;
		String contingency_action = null;
		String contingency_date = null;
		int employee_id_contingency = 0;
		String threshold_condition_contingency = null;
		String fallback_plan  = null;
		String remarks = null;
		String closed_on = null;
		String viewed_on = null;
		int impact_cal = probability_id*severity_id;
		System.out.println(impact);
		risk_description = request.getParameter("risk_description");
		if(impact_cal == 1 || impact_cal ==2 ||  impact_cal==3)
		{
			impact = "Low";
		}
		else if(impact_cal == 4 || impact_cal ==5 || impact_cal ==6)
		{
			impact = "Medium";
		}
		else if (impact_cal == 7 || impact_cal ==8 || impact_cal==9)
		{
			 impact = "High";
		}
		else
		{
			impact = "null";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String date1 = dateFormat.format(date);
		date_of_risk_identification = date1;
		updated_on = date_of_risk_identification;
		risk_type = request.getParameter("risk_type");
		category_of_risk = request.getParameter("category_of_risk");
		stage = request.getParameter("stage");
		impact_description = request.getParameter("impact_description");
		justification = request.getParameter("justification");
		mitigation_action = request.getParameter("mitigation_action");
		mitigation_date = request.getParameter("mitigation_date");
		threshold_condition_mitigation = request.getParameter("threshold_condition_mitigation");
		contingency_action = request.getParameter("contingency_action");
		contingency_date = request.getParameter("contingency_date");
		employee_id_contingency = Integer.parseInt(request.getParameter("employee_id_contingency"));
		threshold_condition_contingency = request.getParameter("threshold_condition_contingency");
		fallback_plan = request.getParameter("fallback_plan");
		remarks = request.getParameter("remarks");
		closed_on = date1;
		viewed_on = date1;
		
		String[] stak_holders_name = request.getParameterValues("stak_holders_name");
		String[] stak_holders_contact_no = request.getParameterValues("contact_no");
		String[] stak_holders_email_id = request.getParameterValues("email_id");
		
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		projectMasterBean.setProject_master_id(project_master_id);
		
		RiskPriorityBean riskPriorityBean = new RiskPriorityBean();
		riskPriorityBean.setRisk_priority_id(risk_priority_id);
		
		MonitoringFrequencyBean monitoringFrequencyBean = new MonitoringFrequencyBean();
		monitoringFrequencyBean.setMonitoring_frequency_id(monitoring_frequency_id);
		
		ProbabilityBean probabilityBean = new ProbabilityBean();
		probabilityBean.setProbability_id(probability_id);
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_master_id);
		
		RiskStatusBean riskStatusBean = new RiskStatusBean();
		riskStatusBean.setRisk_status_id(risk_status_id);
		
		SeverityBean severityBean = new SeverityBean();
		severityBean.setSeverity_id(severity_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		RiskRepositoryBean riskRepositoryBean= new RiskRepositoryBean(date_of_risk_identification,updated_on, risk_type, category_of_risk, risk_description, stage, impact, impact_description, justification, mitigation_action, threshold_condition_mitigation, mitigation_date, contingency_action, threshold_condition_contingency, contingency_date, employee_id_contingency, riskPriorityBean, projectMasterBean, probabilityBean, monitoringFrequencyBean, employeeBean, riskStatusBean,severityBean,fallback_plan,remarks);
		boolean result = allInsertDAO.riskManagementDataInsert(riskRepositoryBean);
		int id = riskRepositoryBean.getRisk_repository_id();
		 riskRepositoryBean.setRisk_repository_id(id);
		 
		System.out.println("id:"+id);
		
		if (risk_status_id == 4) {
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			allUpdateDAO.riskCloseDateUpdate(closed_on,id,viewed_on,remarks);
		}
		
		String[] concern_person = request.getParameterValues("concern_person");
		
		if(concern_person != null){
		for(String s : concern_person){
			System.out.println("s:"+s);
			EmployeeBean e = new EmployeeBean();
			e.setEmployee_master_id(Integer.parseInt(s));
			int e_id = Integer.parseInt(s); 
			ConcernPersonBean concernPersonBean = new ConcernPersonBean(e, riskRepositoryBean);
			allInsertDAO.concernPersonInsert(concernPersonBean);
			AllRiskManagementDAO allRiskManagementDAO = new AllRiskManagementDAO();
			List<EmployeeBean> listOfEmployeeBean = allRiskManagementDAO.getListOfEmailId(e_id);
			for(EmployeeBean c : listOfEmployeeBean){
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	String risk_description = request.getParameter("risk_description");
					String mitigation_action = request.getParameter("mitigation_action");
					String contingency_action = request.getParameter("contingency_action");
					String fallback_plan = request.getParameter("fallback_plan");
					String to = c.getEmail_id();
					String subject = "Concern Authority for Risk";
					String msg ="You are added as a concern authority";
					String desc = risk_description;
					String mitigation_plan = mitigation_action;
					String person_for_mitigation = c.getFirstname()+ c.getLastname();
					String contingency_plan = contingency_action;
					String person_for_contingency = c.getFirstname()+ c.getLastname();
					String fallbackPlan = fallback_plan;
					Mailer.send(to, subject, msg, desc, mitigation_plan, person_for_mitigation, contingency_plan, person_for_contingency, fallbackPlan);
					System.out.println("message has been sent successfully");
			    } }).start();
		}}
		}
		List<String> nameArray = new ArrayList();
		List<String> contactArray = new ArrayList();
		List<String> emailArray = new ArrayList();
		
		for(String name : stak_holders_name){
			System.out.println("name:"+name);
			nameArray.add(name);
			
		}
		
		for(String contact : stak_holders_contact_no){
			System.out.println("contact:"+contact);
			contactArray.add(contact);
		}
		
		for(String email : stak_holders_email_id){
			System.out.println("email:"+email);
			emailArray.add(email);
		}
		
	 
	 StakHoldersDetailsBean stakHoldersDetailsBean = new StakHoldersDetailsBean();
	 
	 if(nameArray.get(0) != ""){
		
		 stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
		 stakHoldersDetailsBean.setStak_holders_name(nameArray.get(0));
		 stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(0));
		 stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(0));
	boolean result1= allInsertDAO.stakHoldersDataInsert(stakHoldersDetailsBean);
	
	 }
	 if(nameArray.get(1) != ""){
		 stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
		 stakHoldersDetailsBean.setStak_holders_name(nameArray.get(1));
		 stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(1));
		 stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(1));
	boolean result1= allInsertDAO.stakHoldersDataInsert(stakHoldersDetailsBean);
	 }
	 
	 if(nameArray.get(2) != ""){
		 stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
		 stakHoldersDetailsBean.setStak_holders_name(nameArray.get(2));
		 stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(2));
		 stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(2));
	boolean result1= allInsertDAO.stakHoldersDataInsert(stakHoldersDetailsBean);
	 }
	 
	LoginDAO loginDAO = new LoginDAO();
	 EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(employee_master_id);
	 EmployeeBean employeeBean3 = loginDAO.getEmailIdEmployee(employee_id_contingency);
	 for(int i =1;i<=3;i++){
			EmployeeBean employeeBean1 = loginDAO.getEmailId(i);
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			String risk_description = request.getParameter("risk_description");
			String mitigation_action = request.getParameter("mitigation_action");
			String contingency_action = request.getParameter("contingency_action");
			String fallback_plan = request.getParameter("fallback_plan");
			
			String to = employeeBean1.getEmail_id();
			String subject = "New Risk Creation";
	
			String msg ="Risk has been Created";
			String desc = risk_description;
			String mitigation_plan = mitigation_action;
			String person_for_mitigation = employeeBean2.getFirstname()+employeeBean2.getLastname();
			String contingency_plan = contingency_action;
			String person_for_contingency = employeeBean3.getFirstname()+employeeBean3.getLastname();
			String fallbackPlan = fallback_plan;
			
	
			Mailer.send(to, subject, msg, desc,mitigation_plan,person_for_mitigation,contingency_plan,person_for_contingency,fallbackPlan);
			System.out.println("message has been sent successfully");
			}
			}).start();
		}	
	 new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		String risk_description = request.getParameter("risk_description");
		String mitigation_action = request.getParameter("mitigation_action");
		String contingency_action = request.getParameter("contingency_action");
		String to = employeeBean2.getEmail_id();
		String subject = "Responsible person ";

		String msg ="You are responsible for mitigating risk ";
		String desc1 = risk_description; 
		String mitigation_action_plan = mitigation_action;
		

		Mailer.send1(to, subject, msg, desc1,mitigation_action_plan);
		System.out.println("message has been sent successfully");
		
		
		String to1 = employeeBean3.getEmail_id();
		String subject1 = "Responsible person ";

		String msg1 ="You are responsible for creation of risk(responsible person for contingency)";
		String desc2 = risk_description;
		String contingency_action_plan = contingency_action;
		

		Mailer.send1(to1, subject1, msg1, desc2,contingency_action_plan);
		System.out.println("message has been sent successfully");
		    }
		}).start();
		response.sendRedirect("riskList.jsp");

	}

}
