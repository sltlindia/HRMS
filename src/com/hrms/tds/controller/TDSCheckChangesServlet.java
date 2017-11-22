package com.hrms.tds.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSPayrollBean;
import com.hrms.tds.bean.TDSPayrollSalaryDataBean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.dao.PayrollList;
import com.hrms.tds.dao.TDSListDAO;
import com.hrms.tds.dao.TDSUpdateDAO;

public class TDSCheckChangesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		int tds_id = Integer.parseInt(request.getParameter("tds_id"));
		System.out.println("TDS ID :"+tds_id);
		
		TDSListDAO tdslistDAO = new TDSListDAO();
		TDSBean tdsBean = tdslistDAO.detailsOfTDS(tds_id);
		
		int emp_code = tdsBean.getEmployeeBean().getEmployee_code();
		String hrms_company_name = tdsBean.getEmployeeBean().getCompanyListBean().getCompany_code();
			String payroll_company_name = null;
	  		if(hrms_company_name.equals("SL"))
	  		{
	  			payroll_company_name = "SLT";
	  		}
	  		else if(hrms_company_name.equals("SE"))
	  		{
	  			payroll_company_name = "SENT";
	  		}
	  		else if(hrms_company_name.equals("SS"))
	  		{
	  			payroll_company_name = "SRI";
	  		}
	  		else if(hrms_company_name.equals("S.HR"))
	  		{
	  			payroll_company_name = "SHR";
	  		}
	  		else if(hrms_company_name.equals("CO"))
	  		{
	  			payroll_company_name = "COSMOS";
	  		}
	  		else if(hrms_company_name.equals("CS"))
	  		{
	  			payroll_company_name = "CSLaser";
	  		}
	  		else if(hrms_company_name.equals("O"))
	  		{
	  			payroll_company_name = "App";
	  		}
	  	System.err.println("COMPANY NAME :"+payroll_company_name);
		System.out.println("Employee Code :"+emp_code);
		
		PayrollList payrollList = new PayrollList();
  		List<TDSPayrollSalaryDataBean> payrollBean = tdslistDAO.getTDSPayrollSalaryDataByEmpCode(emp_code, payroll_company_name);
      	
  		double basicSalary = 0.0;
  		double medical = 0.0 ;
  		double conveyance = 0.0 ;
		double incentive = 0.0 ;          		
  		double actualHRA = 0.0 ;
  		double uniAllw = 0.0 ;
  		double eduAllw = 0.0 ;
  		double otherAllw = 0.0 ;
  		double adhocAllw = 0.0 ;
  		double ltc = 0.0 ;
  		double ptax = 0.0 ;
  		double prvSalary = 0.0 ;
  		double pf = 0.0;
  		String joiningDate = null ;
  		double gross_salary = 0.0 ;
  		double annual_gross_salary = 0.0 ;
  		double bonus = 8400 ;
  		double leave = 0.0 ;
  		double performancePay = 0.0 ;
  		double Incentive = 0.0;
  		
  		double lastBasicSalary = 0.0;
  		double lastMedical = 0.0 ;
  		double lastConveyance = 0.0 ;
  		double lastActualHRA = 0.0 ;
  		double lastUniAllw = 0.0 ;
  		double lastEduAllw = 0.0 ;
  		double lastOtherAllw = 0.0 ;
  		double lastAdhocAllw = 0.0 ;
  		double lastLtc = 0.0 ;
  		double lastPerformancePay = 0.0 ;
  		double lastSalary = 0.0;
  		
  		double a_conveyance = 0.0;
  		double d_conveyance = 0.0;
  		double d_non_metro_total_basic = 0.0;
  		double d_metro_total_basic = 0.0;
  		double d_non_metro_hra = 0.0;
  		double d_metro_hra = 0.0;
  		double a_medical = 0.0;
  		double d_medical = 0.0;
  		double d_lta = 0.0;
  		double annual_education_allw = 0.0;
  		double d_uni_allw = 0.0;
  		double actual_lta = 0.0;
  		double uni_allw_during_year = 0.0;
  		
  		for(TDSPayrollSalaryDataBean bean : payrollBean){
  			joiningDate = bean.getDate();
  		}
		
		Calendar calCurrDate = Calendar.getInstance();
		int currentMonth = calCurrDate.get(Calendar.MONTH)+1;
		System.err.println("current month :"+currentMonth);
		int start_month = 4;
  		int total_month = 0 ; 
      	
  		if(currentMonth >= start_month)
      	{
      		total_month = (12 - currentMonth) + 3 ; 
      	}
      	else if(currentMonth < start_month)
      	{
      		total_month = (3 - currentMonth) + 1 ; 
      	}
  		
  		
  		
  		double dueMonthBasicSalary = payrollList.getDueMonthBasicSalary(emp_code, payroll_company_name);
  		double dueMonthHRA = payrollList.getDueMonthHRA(emp_code, payroll_company_name);
  		double dueMonthConveyance = payrollList.getDueMonthConveyance(emp_code, payroll_company_name);
  		double dueMonthLTC = payrollList.getDueMonthLTC(emp_code, payroll_company_name);
  		double dueMonthMedical = payrollList.getDueMonthMedical(emp_code, payroll_company_name);
  		double dueMonthUniAllw = payrollList.getDueMonthUniAllw(emp_code, payroll_company_name);
  		double dueMonthEduAllw = payrollList.getDueMonthEduAllw(emp_code, payroll_company_name);
  		double dueMonthOtherAllw = payrollList.getDueMonthOtherAllw(emp_code, payroll_company_name);
  		double dueMonthAdhocAllw = payrollList.getDueMonthAdhocAllw(emp_code, payroll_company_name);
  		double dueMonthIncentive = payrollList.getdueMonthIncentive(emp_code, payroll_company_name);
  		double dueMonthSalary = payrollList.getDueMonthSalary(emp_code, payroll_company_name);
  		double dueMonthPTAX = payrollList.getDueMonthPTAX(emp_code, payroll_company_name);
  		double dueMonthPF = payrollList.getDueMonthPF(emp_code, payroll_company_name);
  		double dueMonthPreviousSalary = payrollList.getdueMonthPreviousSalary(emp_code, payroll_company_name);
  		double dueMonthPerformancePay = payrollList.getdueMonthPerformancePay(emp_code, payroll_company_name);
  		
  		/*double maxBasicSalary = payrollList.getMaxBasicSalary(emp_code, payroll_company_name);
  		double maxHRA = payrollList.getMaxHRA(emp_code, payroll_company_name);
  		double maxConveyance = payrollList.getMaxConveyance(emp_code, payroll_company_name);
  		double maxLTC = payrollList.getMaxLTC(emp_code, payroll_company_name);
  		double maxMedical = payrollList.getMaxMedical(emp_code, payroll_company_name);
  		double maxUniAllw = payrollList.getMaxUniAllw(emp_code, payroll_company_name);
  		double maxEduAllw = payrollList.getMaxEduAllw(emp_code, payroll_company_name);
  		double maxOtherAllw = payrollList.getMaxOtherAllw(emp_code, payroll_company_name);
  		double maxAdhocAllw = payrollList.getMaxAdhocAllw(emp_code, payroll_company_name);
  		//double maxIncentive = payrollList.getMaxIncentive(emp_code, payroll_company_name);
  		double maxSalary = payrollList.getMaxSalary(emp_code, payroll_company_name);
  		//double maxPTAX = payrollList.getDueMonthPTAX(emp_code, payroll_company_name);
  		//double maxPF = payrollList.getDueMonthPF(emp_code, payroll_company_name);
  		//double maxPreviousSalary = payrollList.getMaxPreviousSalary(emp_code, payroll_company_name);
  		double maxPerformancePay = payrollList.getMaxPerformancePay(emp_code, payroll_company_name);*/
  		
  		
  		List<TDSPayrollBean> lastrecord  = payrollList.getLastBasicSalary(emp_code,payroll_company_name);
  		System.err.println("LAst Basic Salary :"+lastrecord);
  		
  		for(TDSPayrollBean tdsPayrollBean : lastrecord){
  			lastBasicSalary = tdsPayrollBean.getBasic_salary();
  			lastMedical = tdsPayrollBean.getMedical();
  			lastConveyance = tdsPayrollBean.getConveyance();
  			lastActualHRA = tdsPayrollBean.getHra();
  			lastUniAllw = tdsPayrollBean.getUni_allw();
  			lastEduAllw = tdsPayrollBean.getEdu_allw();
  			lastOtherAllw = tdsPayrollBean.getOther_allw();
  			lastAdhocAllw = tdsPayrollBean.getAdhoc_allw();
  			lastLtc = tdsPayrollBean.getLtc();
  			lastPerformancePay = tdsPayrollBean.getPerformance_pay();
  			lastSalary = tdsPayrollBean.getSalary();
  		}
  		
      	/*basicSalary = dueMonthBasicSalary + (maxBasicSalary * total_month);
      	actualHRA = dueMonthHRA + (maxHRA * total_month);
      	conveyance = dueMonthConveyance + (maxConveyance * total_month);
      	ltc = dueMonthLTC + (maxLTC * total_month);
      	medical = dueMonthMedical + (maxMedical * total_month);
      	uniAllw = dueMonthUniAllw + (maxUniAllw * total_month);
      	eduAllw = dueMonthEduAllw + (maxEduAllw * total_month);
      	otherAllw = dueMonthOtherAllw + (maxOtherAllw * total_month);
      	adhocAllw = dueMonthAdhocAllw + (maxAdhocAllw * total_month);
      	incentive = dueMonthIncentive;
      	annual_gross_salary = dueMonthSalary + (maxSalary * total_month);
      	prvSalary = dueMonthPreviousSalary;
      	performancePay = dueMonthPerformancePay + (maxPerformancePay * total_month);
      	ptax = dueMonthPTAX;
      	pf = dueMonthPF;*/
      	
      	basicSalary = dueMonthBasicSalary + (lastBasicSalary * total_month);
      	actualHRA = dueMonthHRA + (lastActualHRA * total_month);
      	conveyance = dueMonthConveyance + (lastConveyance * total_month);
      	ltc = dueMonthLTC + (lastLtc * total_month);
      	medical = dueMonthMedical + (lastMedical * total_month);
      	uniAllw = dueMonthUniAllw + (lastUniAllw * total_month);
      	eduAllw = dueMonthEduAllw + (lastEduAllw * total_month);
      	otherAllw = dueMonthOtherAllw + (lastOtherAllw * total_month);
      	adhocAllw = dueMonthAdhocAllw + (lastAdhocAllw * total_month);
      	incentive = dueMonthIncentive;
      	annual_gross_salary = dueMonthSalary + (lastSalary * total_month);
      	prvSalary = dueMonthPreviousSalary;
      	performancePay = dueMonthPerformancePay + (lastPerformancePay * total_month);
      	ptax = dueMonthPTAX;
      	pf = dueMonthPF;
      	//leave = dueMonthLeave;
      	gross_salary = lastSalary;

      	double totalA = annual_gross_salary + prvSalary + performancePay + bonus + leave + Incentive ;
      	
      	System.err.println("Basic Salary :"+basicSalary);
			System.err.println("Medical :"+medical);
			System.err.println("conveyance :"+conveyance);
			System.err.println("incentive :"+incentive);
			System.err.println("actualHRA :"+actualHRA);
			System.err.println("uniAllw :"+uniAllw);
			System.err.println("eduAllw :"+eduAllw);
			System.err.println("otherAllw :"+otherAllw);
			System.err.println("adhocAllw :"+adhocAllw);
			System.err.println("ltc :"+ltc);
			System.err.println("ptax :"+ptax);
			System.err.println("prvSalary :"+prvSalary);
			System.err.println("pf :"+pf);
			System.err.println("performancePay :"+performancePay);
			System.err.println("joiningDate :"+joiningDate);
			System.err.println("Salary :"+annual_gross_salary);
		
			if(conveyance >= 19200)
			{
				a_conveyance = conveyance;
				d_conveyance = 19200;
			}
			else if(conveyance < 19200)
			{
				a_conveyance = conveyance;
				d_conveyance = conveyance;
			}
      		
			d_non_metro_total_basic = (basicSalary * 40)/100 ;
			d_metro_total_basic = (basicSalary * 50)/100 ;
			
			d_non_metro_hra = actualHRA;
			d_metro_hra = actualHRA;
			
			if(medical >= 15000)
			{
				a_medical = medical;
				d_medical = 15000;
			}
			else if(medical < 15000)
			{
				a_medical = medical;
				d_medical = medical;
			}
			
			TDSTotalBBean bBean = tdslistDAO.detailsOfTDSTotal_B(tds_id);
			actual_lta = bBean.getActual_expenditure_lta();
			uni_allw_during_year = bBean.getActual_expenditure_uni_allw();
			
			if(ltc >= actual_lta)
			{
				d_lta = actual_lta;
			}
			else
			{
				d_lta = ltc;
			}
			
			if(uniAllw >= uni_allw_during_year) {
				d_uni_allw = uni_allw_during_year;
			}
			else
			{
				d_uni_allw = uniAllw;
			}
			/*SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
			Date new_date = new Date();
			String current_date = YYYYMMDD.format(new_date);
			System.err.println("============ Current Date ==========" + current_date);*/
			
      		
			
			TDSUpdateDAO tdsUpdateDAO = new TDSUpdateDAO();
			tdsUpdateDAO.tdsTotalAUpdate(tds_id, annual_gross_salary, bonus, gross_salary, incentive, prvSalary, performancePay, totalA);
			/*tdsUpdateDAO.tdsTotalBUpdate(tds_id, a_conveyance, d_conveyance, annual_basic_salary, d_non_metro_total_basic, d_metro_total_basic, annual_hra, d_non_metro_hra, d_metro_hra, a_medical, d_medical, lta_during_year, d_lta, annual_ptax, annual_uni_allw_during_year, d_uni_allw );*/
			tdsUpdateDAO.tdsTotalBUpdate(tds_id, a_conveyance, d_conveyance, basicSalary, d_non_metro_total_basic, d_metro_total_basic, actualHRA, d_non_metro_hra, d_metro_hra, a_medical, d_medical, ltc, d_lta, ptax, uniAllw, d_uni_allw );
			tdsUpdateDAO.tdsTotalDUpdate(tds_id, pf);
			
			session.setAttribute("tds_id", tds_id);
			session.setAttribute("annual_education_allw", annual_education_allw);
			response.sendRedirect("TDSUpdateForm.jsp");
		}
	}


