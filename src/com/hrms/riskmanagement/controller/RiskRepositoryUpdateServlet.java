package com.hrms.riskmanagement.controller;

import java.io.IOException;
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

public class RiskRepositoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String date1 = dateFormat.format(date);
		int risk_repository_id = Integer.parseInt(request.getParameter("risk_repository_id"));
		System.out.println(risk_repository_id);
		int risk_priority_id = Integer.parseInt(request.getParameter("risk_priority_id"));
		System.out.println(risk_repository_id);
		int monitoring_frequency_id = Integer.parseInt(request.getParameter("monitoring_frequency_id"));
		System.out.println(monitoring_frequency_id);
		int probability_id = Integer.parseInt(request.getParameter("probability_id"));
		System.out.println(probability_id);
		int severity_id = Integer.parseInt(request.getParameter("severity_id"));
		System.out.println(severity_id);
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		System.out.println(employee_master_id);
		int risk_status_id = Integer.parseInt(request.getParameter("risk_status_id"));
		System.out.println(risk_status_id);
		String updated_on = date1;
		System.out.println(updated_on);
		String risk_type = request.getParameter("risk_type");
		System.out.println(risk_type);
		String category_of_risk = request.getParameter("category_of_risk");
		System.out.println(category_of_risk);
		String risk_description = request.getParameter("risk_description");
		System.out.println(risk_description);
		String stage = request.getParameter("stage");
		System.out.println(stage);
		String impact = request.getParameter("impact");
		System.out.println(impact);
		String impact_description = request.getParameter("impact_description");
		System.out.println(impact_description);
		String justification = request.getParameter("justification");
		System.out.println(justification);
		String mitigation_action = request.getParameter("mitigation_action");
		System.out.println(mitigation_action);
		String mitigation_date = request.getParameter("mitigation_date");
		System.out.println(mitigation_date);
		String threshold_condition_mitigation = request.getParameter("threshold_condition_mitigation");
		System.out.println(threshold_condition_mitigation);
		String contingency_action = request.getParameter("contingency_action");
		System.out.println(contingency_action);
		String contingency_date = request.getParameter("contingency_date");
		System.out.println(contingency_date);
		int employee_id_contingency = Integer.parseInt(request.getParameter("employee_id_contingency"));
		System.out.println(employee_id_contingency);
		String threshold_condition_contingency = request.getParameter("threshold_condition_contingency");
		System.out.println(threshold_condition_contingency);
		String fallback_plan = request.getParameter("fallback_plan");
		RiskPriorityBean riskPriorityBean = new RiskPriorityBean();
		riskPriorityBean.setRisk_priority_id(risk_priority_id);
		String closed_on = null;
		String viewed_on = null;
		String remarks = null;
		String date2 = dateFormat.format(date);
		closed_on = date2;
		viewed_on = date2;
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
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		if (risk_status_id == 4) {
			allUpdateDAO.riskCloseDateUpdate(closed_on, risk_repository_id, viewed_on, remarks);
		}

		boolean result = allUpdateDAO.riskManagementDataUpdate(monitoring_frequency_id, updated_on, risk_type,
				category_of_risk, risk_description, stage, probability_id, severity_id, impact, impact_description,
				risk_status_id, risk_priority_id, justification, mitigation_action, threshold_condition_mitigation,
				employee_master_id, mitigation_date, threshold_condition_contingency, contingency_action,
				contingency_date, employee_id_contingency, fallback_plan, risk_repository_id);
		RiskRepositoryBean riskRepositoryBean = new RiskRepositoryBean();
		int id = Integer.parseInt(request.getParameter("risk_id"));
		riskRepositoryBean.setRisk_repository_id(id);
		
		AllRiskManagementDAO allRiskManagementDAO = new AllRiskManagementDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		String[] concern_person = request.getParameterValues("concern_person");
		if(concern_person != null){
		for(String s : concern_person){
			int employee_id = Integer.parseInt(s);
			System.out.println("s:"+s);
			EmployeeBean e = new EmployeeBean();
			e.setEmployee_master_id(Integer.parseInt(s));
			ConcernPersonBean concernPersonBean = new ConcernPersonBean(e, riskRepositoryBean);
			ConcernPersonBean concernPersonBean1= allRiskManagementDAO.getConcernPerson(employee_id, id);
			
			if(concernPersonBean1 == null){
				allInsertDAO.concernPersonInsert(concernPersonBean);
			}
			
		}
		}
		String[] stak_holders_name = request.getParameterValues("stak_holders_name");
		String[] stak_holders_contact_no = request.getParameterValues("contact_no");
		String[] stak_holders_email_id = request.getParameterValues("email_id");
		String[] stakHoldersId = request.getParameterValues("stakholders_id");
	
		/*int stakHoldersId = Integer.parseInt(request.getParameter("stakholders_id"));*/
		System.out.println("id:" + id);
	
		List<String> nameArray = new ArrayList();
		List<String> contactArray = new ArrayList();
		List<String> emailArray = new ArrayList();
		List<String> sIdArray = new ArrayList();
		
		if(stak_holders_name!= null){
		for (String name : stak_holders_name) {
			System.out.println("name:" + name);
			nameArray.add(name);

		}

		for (String contact : stak_holders_contact_no) {
			System.out.println("contact:" + contact);
			contactArray.add(contact);
		}

		for (String email : stak_holders_email_id) {
			System.out.println("email:" + email);
			emailArray.add(email);
		}
		
		for (String s_id : stakHoldersId) {
			System.out.println("s_id:" + s_id);
			sIdArray.add(s_id);
		}

		}
		System.out.println("size:"+nameArray.size());
		
		StakHoldersDetailsBean stakHoldersDetailsBean = new StakHoldersDetailsBean();
		AllUpdateDAO allUpdateDAO2 = new AllUpdateDAO();

		if(nameArray.size() != 0){
		if (nameArray.get(0) != "" && nameArray.size() != 0) {
			stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
			stakHoldersDetailsBean.setStak_holders_name(nameArray.get(0));
			stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(0));
			stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(0));
			stakHoldersDetailsBean.setStak_holders_id(Integer.parseInt(sIdArray.get(0)));
			boolean result1 = allUpdateDAO2.stakHoldersDataInsert(stakHoldersDetailsBean);
		}
		}

		
		if(nameArray.size() == 2){
		if (nameArray.get(1) != "") {
			riskRepositoryBean.setRisk_repository_id(id);
			stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
			stakHoldersDetailsBean.setStak_holders_name(nameArray.get(1));
			stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(1));
			stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(1));
			stakHoldersDetailsBean.setStak_holders_id(Integer.parseInt(sIdArray.get(1)));
			boolean result1 = allUpdateDAO2.stakHoldersDataInsert(stakHoldersDetailsBean);
		}}

		
		if(nameArray.size() == 3){
		if (nameArray.get(2) != "") {
			riskRepositoryBean.setRisk_repository_id(id);
			stakHoldersDetailsBean.setRiskRepositoryBean(riskRepositoryBean);
			stakHoldersDetailsBean.setStak_holders_name(nameArray.get(2));
			stakHoldersDetailsBean.setStak_holders_contact_no(contactArray.get(2));
			stakHoldersDetailsBean.setStak_holders_email_id(emailArray.get(2));
			stakHoldersDetailsBean.setStak_holders_id(Integer.parseInt(sIdArray.get(2)));
			boolean result1 = allUpdateDAO2.stakHoldersDataInsert(stakHoldersDetailsBean);
		}}

		response.sendRedirect("riskList.jsp");
	}

}
