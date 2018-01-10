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
import com.hrms.tds.bean.TDSPayrollMasterDataBean;
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
	  			payroll_company_name = "SLTL";
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
		List<TDSPayrollMasterDataBean> lastRecordOfMasterData  = payrollList.getLastRecordOfMasterData(emp_code,payroll_company_name);
  		System.err.println("SIZE===========>"+lastRecordOfMasterData.size());
      	
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
  		double mealCard = 0.0;
  		String joiningDate = null ;
  		double gross_salary = 0.0 ;
  		double annual_gross_salary = 0.0 ;
  		double bonus = 8400 ;
  		double leave = 0.0 ;
  		double performancePay = 0.0 ;
  		double Incentive = 0.0;
  		double fullFinalBonus = 0.0;
  		double fullFinalLeave = 0.0;
  		double interest = 0.0;
  		String pan_no = null;
  		
  		double dueBasicSalary = 0.0;
  		double dueMedical = 0.0 ;
  		double dueConveyance = 0.0 ;
  		double dueActualHRA = 0.0 ;
  		double dueUniAllw = 0.0 ;
  		double dueEduAllw = 0.0 ;
  		double april = 0.0;
  		double may = 0.0;
		double june = 0.0;
		double july = 0.0;
		double august = 0.0;
		double september = 0.0;
		double october = 0.0;
		double november = 0.0;
		double december = 0.0;
		double january = 0.0;
		double february = 0.0;
		double march = 0.0;
  		
  		double lastBasicSalary = 0.0;
  		double lastMedical = 0.0 ;
  		double lastConveyance = 0.0 ;
  		double lastActualHRA = 0.0 ;
  		double lastUniAllw = 0.0 ;
  		double lastEduAllw = 0.0 ;
  		
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
  		
  		
  		for(TDSPayrollMasterDataBean masterDataBean : lastRecordOfMasterData){
  			annual_gross_salary = masterDataBean.getSalary();
  			bonus = masterDataBean.getBonus();
  			leave = masterDataBean.getLeave_count();
  			interest = masterDataBean.getInterest();
  			fullFinalBonus = masterDataBean.getFull_final_bonus();
  			fullFinalLeave = masterDataBean.getFull_final_leave();
  			Incentive = masterDataBean.getIncentive();
  			prvSalary = masterDataBean.getPrevious_salary();
  			performancePay = masterDataBean.getPerformance();
  			ptax = masterDataBean.getPtax();
  			pf = masterDataBean.getEpf();
  			mealCard = masterDataBean.getMealcard();
  			joiningDate = masterDataBean.getJoining_date();
  			pan_no = masterDataBean.getPan_no();
  			ltc = masterDataBean.getLta();
  			april = masterDataBean.getApril();
  			may = masterDataBean.getMay();
  			june = masterDataBean.getJune();
  			july = masterDataBean.getJuly();
  			august = masterDataBean.getAugust();
  			september = masterDataBean.getSeptember();
  			october = masterDataBean.getOctober();
  			november = masterDataBean.getNovember();
  			december = masterDataBean.getDecember();
  			january = masterDataBean.getJanuary();
  			february = masterDataBean.getFebruary();
  			march = masterDataBean.getMarch();
  		}
  		double tax_paid = april + may + june + july + august + september + october + november + december + january + february + march;
  		
  		/*List<TDSPayrollBean> listOfData  = payrollList.getListOfDataByEmpCode(emp_code,payroll_company_name);
  		System.err.println("Monthly SIZE===========>"+listOfData.size());
  		for(TDSPayrollBean tdsPayrollBean : listOfData)
  		{
  			dueBasicSalary = dueBasicSalary + (tdsPayrollBean.getBasic_salary());
  			dueConveyance = dueConveyance + (tdsPayrollBean.getConveyance());
  			dueActualHRA = dueActualHRA + (tdsPayrollBean.getHra());
  			dueMedical = dueMedical + (tdsPayrollBean.getMedical());
  			dueEduAllw = dueEduAllw + (tdsPayrollBean.getEdu_allw());
  			dueUniAllw = dueUniAllw + (tdsPayrollBean.getUni_allw());
  		}*/
  		
  		
  		List<TDSPayrollBean> lastrecord  = payrollList.getLastBasicSalary(emp_code,payroll_company_name);
  		System.err.println("LAst Basic Salary=====> :"+lastrecord);
  		
  		for(TDSPayrollBean tdsPayrollBean : lastrecord){
  			basicSalary = tdsPayrollBean.getAnnual_basic_salary();
  			actualHRA = tdsPayrollBean.getAnnual_hra();
  			conveyance = tdsPayrollBean.getAnnual_conveyance();
  			medical = tdsPayrollBean.getAnnual_medical();
  			uniAllw = tdsPayrollBean.getAnnual_uni_allw();
  			eduAllw = tdsPayrollBean.getAnnual_edu_allw();
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
      	
      	/*basicSalary = dueBasicSalary + (lastBasicSalary * total_month);
      	actualHRA = dueActualHRA + (lastActualHRA * total_month);
      	conveyance = dueConveyance + (lastConveyance * total_month);
      	medical = dueMedical + (lastMedical * total_month);
      	uniAllw = dueUniAllw + (lastUniAllw * total_month);
      	eduAllw = dueEduAllw + (lastEduAllw * total_month);*/

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
			tdsUpdateDAO.tdsTotalAUpdate(tds_id, annual_gross_salary, bonus, leave, Incentive, prvSalary, performancePay, totalA);
			/*tdsUpdateDAO.tdsTotalBUpdate(tds_id, a_conveyance, d_conveyance, annual_basic_salary, d_non_metro_total_basic, d_metro_total_basic, annual_hra, d_non_metro_hra, d_metro_hra, a_medical, d_medical, lta_during_year, d_lta, annual_ptax, annual_uni_allw_during_year, d_uni_allw );*/
			tdsUpdateDAO.tdsTotalBUpdate(tds_id, a_conveyance, d_conveyance, basicSalary, d_non_metro_total_basic, d_metro_total_basic, actualHRA, d_non_metro_hra, d_metro_hra, a_medical, d_medical, ltc, d_lta, ptax, uniAllw, d_uni_allw, mealCard );
			tdsUpdateDAO.tdsTotalDUpdate(tds_id, pf);
			tdsUpdateDAO.tdsTotalFUpdate(tds_id, april, may, june, july, august, september, october, november, december, january, february, march, tax_paid);
			
			session.setAttribute("tds_id", tds_id);
			session.setAttribute("annual_education_allw", annual_education_allw);
			response.sendRedirect("TDSUpdateForm.jsp");
		}
	}


