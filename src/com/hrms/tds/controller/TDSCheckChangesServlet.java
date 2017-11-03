package com.hrms.tds.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.action.BeforeTransactionCompletionProcess;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.tds.bean.PayrollBean;
import com.hrms.tds.bean.PerformancePayBean;
import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSPayrollBean;
import com.hrms.tds.bean.TDSTotalABean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.dao.PayrollList;
import com.hrms.tds.dao.TDSInsertDAO;
import com.hrms.tds.dao.TDSListDAO;
import com.hrms.tds.dao.TDSUpdateDAO;

public class TDSCheckChangesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		int tds_id = Integer.parseInt(request.getParameter("tds_id"));
		System.out.println("TDS ID :"+tds_id);
		
		TDSListDAO tdsListDAO = new TDSListDAO();
		TDSBean tdsBean = tdsListDAO.detailsOfTDS(tds_id);
		
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
		
		String first_name = tdsBean.getEmployeeBean().getFirstname();
		String last_name = tdsBean.getEmployeeBean().getLastname();
		String name = first_name + " "+ last_name;
		System.err.println("Name :"+name);
		
		PayrollList payrollList = new PayrollList();
		List<PayrollBean> payrollBean = payrollList.listOfPayroll(emp_code,payroll_company_name);
		 double payroll_basic_salary = 0.0;
		for(PayrollBean bean : payrollBean) {
			payroll_basic_salary = bean.getBasicSalary();
			System.err.println("Payroll Basic Salary :"+payroll_basic_salary);
		}
		
		//String company_name = user.getCompanyListBean().getCompany_name();
		String company_code = user.getCompanyListBean().getCompany_code();
		int employee_code = user.getEmployee_code();
		TDSPayrollBean tdsPayrollBean = tdsListDAO.detailsOfTDSPayrollBean(employee_code, payroll_company_name);
			double hrms_basic_salary = tdsPayrollBean.getBasic_salary();
			double hrms_conveyance = tdsPayrollBean.getConveyance();
			double hrms_incentive = tdsPayrollBean.getIncentive();
			double hrms_previous_salary = tdsPayrollBean.getPrevious_salary();
			double hrms_performance_pay = tdsPayrollBean.getPerformance_pay();
			double hrms_hra = tdsPayrollBean.getHra();
			double hrms_medical = tdsPayrollBean.getMedical();
			double hrms_ltc = tdsPayrollBean.getLtc();
			double hrms_ptax = tdsPayrollBean.getPtax();
			double hrms_uni_allw = tdsPayrollBean.getUni_allw();
			double hrms_edu_allw = tdsPayrollBean.getEdu_allw();
			double hrms_other_allw = tdsPayrollBean.getOther_allw();
			double hrms_adhoc_allw = tdsPayrollBean.getAdhoc_allw();
			
			double hrms_gross_salary =  hrms_basic_salary + hrms_conveyance + hrms_medical + hrms_incentive + hrms_hra + hrms_uni_allw + hrms_edu_allw + hrms_other_allw + hrms_adhoc_allw + hrms_ltc ;
			System.err.println("HRMS Basic Salary :"+hrms_basic_salary);
			System.err.println("HRMS Conveyance :"+hrms_conveyance);
			System.err.println("HRMS incentive :"+hrms_incentive);
			System.err.println("HRMS previous Salary :"+hrms_previous_salary);
			System.err.println("HRMS Performance pay:"+hrms_performance_pay);
			System.err.println("HRMS HRA :"+hrms_hra);
			System.err.println("HRMS Medical :"+hrms_medical);
			System.err.println("HRMS LTC :"+hrms_ltc);
			System.err.println("HRMS PTAX :"+hrms_ptax);
			System.err.println("HRMS Uni All :"+hrms_uni_allw);
			System.err.println("HRMS Edu All :"+hrms_edu_allw);
			System.err.println("HRMS Other :"+hrms_other_allw);
			System.err.println("HRMS Adhoc :"+hrms_adhoc_allw);
			System.err.println("HRMS Gross Salary :"+hrms_gross_salary);
		
		double actual_lta = 0.0;
		double uni_allw_during_year = 0.0;
		
		TDSTotalBBean bBean = tdsListDAO.detailsOfTDSTotal_B(tds_id);
			actual_lta = bBean.getActual_expenditure_lta();
			uni_allw_during_year = bBean.getActual_expenditure_uni_allw();
		
		if(payroll_basic_salary == hrms_basic_salary) 
		{
			System.err.println("Basic Value Same As In Payroll.....");
			session.setAttribute("tds_id", tds_id);
			response.sendRedirect("TDSUpdateForm.jsp");
		}
		else if(payroll_basic_salary != hrms_basic_salary)
		{
			System.err.println("Basic Value Change In Payroll.....");
			double basic_salary = 0.0;
			double medical = 0.0 ;
      		double conveyance = 0.0 ;
			double incentive = 0.0 ;          		
      		double actualHRA = 0.0 ;
      		double uni_Allw = 0.0 ;
      		double edu_Allw = 0.0 ;
      		double other_Allw = 0.0 ;
      		double adhoc_Allw = 0.0 ;
      		double ltc = 0.0 ;
      		double ptax = 0.0 ;
      		double pf = 0.0;
      		double prvSalary = 0.0 ;
      		String joiningDate = null ;
      		String company = null;
      		double gross_salary = 0.0 ;
      		double annual_gross_salary = 0.0 ;
      		double bonus = 8400 ;
      		double leave = 0.0 ;
      		double Incentive = 0.0 ;
      		String month = null;
      		int year = 0;
      		
      		double annual_conveyance = 0.0;
      		double a_conveyance = 0.0;
      		double d_conveyance = 0.0;
      		double annual_basic_salary = 0.0;
      		double d_non_metro_total_basic = 0.0;
      		double d_metro_total_basic = 0.0;
      		double annual_hra = 0.0;
      		double d_non_metro_hra = 0.0;
      		double d_metro_hra = 0.0;
      		double annual_medical = 0.0;
      		double a_medical = 0.0;
      		double d_medical = 0.0;
      		double lta_during_year = 0.0;
      		double d_lta = 0.0;
      		double annual_ptax = 0.0;
      		double annual_education_allw = 0.0;
      		double annual_uni_allw_during_year = 0.0;
      		double d_uni_allw = 0.0;
      		
			for(PayrollBean bean : payrollBean) {
				basic_salary = bean.getBasicSalary();
				medical = bean.getMA();
				conveyance = bean.getConv();
				incentive = bean.getAll1();
				actualHRA = bean.getAll2();
				uni_Allw = bean.getAll3();
				edu_Allw = bean.getAll4();
				other_Allw = bean.getAll5();
				adhoc_Allw = bean.getAll6();
				ltc = bean.getLTC();
				ptax = bean.getPTax();
				pf = bean.getPF();
				prvSalary = bean.getPrvSalary();
				joiningDate = bean.getJoiningDate();
				month = bean.getMonth();
				year = bean.getYear();
				company = bean.getCompany();
				
				System.err.println("basic_salary :"+basic_salary);
				System.err.println("conveyance :"+conveyance);
				System.err.println("medical :"+medical);
				System.err.println("incentive :"+incentive);
				System.err.println("actualHRA :"+actualHRA);
				System.err.println("uni_Allw :"+uni_Allw);
				System.err.println("edu_Allw :"+edu_Allw);
				System.err.println("other_Allw :"+other_Allw);
				System.err.println("adhoc_Allw :"+adhoc_Allw);
				System.err.println("ltc :"+ltc);
				System.err.println("ptax :"+ptax);
				System.err.println("prvSalary :"+prvSalary);
				System.err.println("Date :"+joiningDate);
				System.err.println("MONTH :"+month);
				System.err.println("YEAR :"+year);
				System.err.println("Company :"+company);
				
			}
			
			List<PerformancePayBean> performancePayBean = payrollList.listOfPerformancePay(emp_code, payroll_company_name);
      		double performancePay = 0.0 ;
      		
      		for(PerformancePayBean payBean : performancePayBean){
      			performancePay = payBean.getPerAmt();
      			System.err.println("Performance Pay :"+performancePay);
      		}
      		
      		SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
			Date new_date = new Date();
			String current_date = YYYYMMDD.format(new_date);
			System.err.println("============ Current Date ==========" + current_date);
			
      		TDSInsertDAO insertDAO = new TDSInsertDAO();
			TDSPayrollBean tdsPayrollBean2 = new TDSPayrollBean(payroll_company_name, employee_code, current_date, basic_salary, incentive, prvSalary, performancePay, conveyance, actualHRA, medical, ltc, ptax, pf, uni_Allw, edu_Allw, other_Allw, adhoc_Allw);
			boolean tdsPayrollResult = insertDAO.tdsPayrollInsert(tdsPayrollBean2);
			
			gross_salary = basic_salary + conveyance + medical + incentive + actualHRA + uni_Allw + edu_Allw + other_Allw + adhoc_Allw + ltc ;
			System.err.println("Gross Salary :"+gross_salary);
			
			double totalA = annual_gross_salary + prvSalary + performancePay + bonus + gross_salary + Incentive ;
			System.err.println("TOTAL A :"+totalA);
			
			double start_month = 4.0 ;
			double before_salary_changed_month_diff = 0.0;
			double after_salary_changed_month_diff = 0.0;
			double before_salary_changed_gross_salary = 0.0;
			double after_salary_changed_gross_salary = 0.0;
			double before_salary_changed_conv = 0.0;
			double after_salary_changed_conv = 0.0;
			double before_salary_changed_basic_salary = 0.0;
			double after_salary_changed_basic_salary = 0.0;
			double before_salary_changed_hra = 0.0;
			double after_salary_changed_hra = 0.0;
			double before_salary_changed_medical = 0.0;
			double after_salary_changed_medical = 0.0;
			double before_salary_changed_uni_allw = 0.0;
			double after_salary_changed_uni_allw = 0.0;
			double before_salary_changed_ptax = 0.0;
			double after_salary_changed_ptax = 0.0 ;
			double before_salary_changed_lta = 0.0;
			double after_salary_changed_lta = 0.0;
			
			int tds_payroll_id = tdsPayrollBean2.getTds_payroll_id();
			TDSListDAO listDAO = new TDSListDAO();
			TDSPayrollBean listOfTDSPayroll = listDAO.getAllTdsPayrollListByEmployeeCode(tds_payroll_id);
				String date1 = listOfTDSPayroll.getDate();
				String split[] = date1.split("-");
				
				double changeMonth = Double.parseDouble(split[1]);
				System.err.println("----=====---- Change Month ----====----"+changeMonth);
				
			/*Date date = null ;
			try {
				date = new SimpleDateFormat("MMMM").parse(month);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			double changeMonth = cal.get(Calendar.MONTH)+1;
			System.err.println("Salary Change Month :"+changeMonth);*/
			
			before_salary_changed_month_diff = changeMonth - start_month ;
			System.out.println("Month Differernce :"+before_salary_changed_month_diff);

			after_salary_changed_month_diff = 12 - before_salary_changed_month_diff ;
			System.out.println("Month Differernce After Salary Change :"+after_salary_changed_month_diff);
			
			before_salary_changed_gross_salary = hrms_gross_salary * before_salary_changed_month_diff;
			after_salary_changed_gross_salary = gross_salary * after_salary_changed_month_diff ;
			annual_gross_salary = before_salary_changed_gross_salary + after_salary_changed_gross_salary;
			System.out.println("final annual gross Salary :"+ annual_gross_salary);
			
			before_salary_changed_conv = hrms_conveyance * before_salary_changed_month_diff ;
			after_salary_changed_conv = conveyance * after_salary_changed_month_diff ;
			annual_conveyance = before_salary_changed_conv + after_salary_changed_conv ;
				if(annual_conveyance >= 19200)
				{
					a_conveyance = annual_conveyance;
					d_conveyance = 19200;
				}
				else if(annual_conveyance < 19200)
				{
					a_conveyance = annual_conveyance;
					d_conveyance = annual_conveyance;
				}
			System.out.println("conveyance :"+d_conveyance);
			
			before_salary_changed_basic_salary = hrms_basic_salary * before_salary_changed_month_diff ;
			after_salary_changed_basic_salary = basic_salary * after_salary_changed_month_diff ;
			annual_basic_salary = before_salary_changed_basic_salary + after_salary_changed_basic_salary ;
				d_non_metro_total_basic = (annual_basic_salary * 50)/100 ;
				d_metro_total_basic = (annual_basic_salary * 40)/100 ;
				System.err.println("annual_basic_salary :"+annual_basic_salary);
				System.err.println("d_non_metro_total_basic :"+d_non_metro_total_basic);
				System.err.println("d_metro_total_basic :"+d_metro_total_basic);
			System.out.println("final basic salary :"+annual_basic_salary);
			
			before_salary_changed_hra = hrms_hra * before_salary_changed_month_diff ;
			after_salary_changed_hra = actualHRA * after_salary_changed_month_diff ;
			annual_hra = before_salary_changed_hra + after_salary_changed_hra ;
				d_non_metro_hra = annual_hra;
				d_metro_hra = annual_hra;
			System.out.println("final hra :"+annual_hra);
			
			before_salary_changed_medical = hrms_medical * before_salary_changed_month_diff ;
			after_salary_changed_medical = medical * after_salary_changed_month_diff ;
			annual_medical = before_salary_changed_medical + after_salary_changed_medical ;
				if(annual_medical >= 15000)
				{
					a_medical = annual_medical;
					d_medical = 15000;
				}
				else if(annual_medical < 15000)
				{
					a_medical = annual_medical;
					d_medical = annual_medical;
				}
				System.err.println("annual_medical :"+annual_medical);
				System.err.println("a_medical :"+a_medical);
				System.err.println("d_medical :"+d_medical);
			System.out.println("final medical :"+annual_medical);
			
			before_salary_changed_lta = hrms_ltc * before_salary_changed_month_diff ;
			after_salary_changed_lta = ltc * after_salary_changed_month_diff ;
			lta_during_year = before_salary_changed_lta + after_salary_changed_lta ;
				if(lta_during_year >= actual_lta)
				{
					d_lta = actual_lta;
				}
				else
				{
					d_lta = lta_during_year;
				}
				System.err.println("d_lta :"+d_lta);
			System.err.println("lta_during_year :"+lta_during_year);
				
			annual_education_allw = edu_Allw * 12 ;
			System.err.println("annual_education_allw :"+ annual_education_allw);
			
			before_salary_changed_ptax = hrms_ptax * before_salary_changed_month_diff ;
			after_salary_changed_ptax = ptax * after_salary_changed_month_diff ;
			annual_ptax = before_salary_changed_ptax + after_salary_changed_ptax ;
			System.out.println("final ptax :"+annual_ptax);
			
			before_salary_changed_uni_allw = hrms_uni_allw * before_salary_changed_month_diff ;
			after_salary_changed_uni_allw = uni_Allw * after_salary_changed_month_diff ;
			annual_uni_allw_during_year = before_salary_changed_uni_allw + after_salary_changed_uni_allw ;
				if(annual_uni_allw_during_year >= uni_allw_during_year) {
					d_uni_allw = uni_allw_during_year;
				}
				else
				{
					d_uni_allw = annual_uni_allw_during_year;
				}
				System.err.println("actual_uni_allw_during_year :"+uni_allw_during_year);
				System.err.println("uni_allw_during_year :"+annual_uni_allw_during_year);
				System.err.println("d_uni_allw :"+ d_uni_allw);
			System.out.println("final uni allw :"+annual_uni_allw_during_year);
			
			TDSUpdateDAO tdsUpdateDAO = new TDSUpdateDAO();
			tdsUpdateDAO.tdsTotalAUpdate(tds_id, annual_gross_salary, bonus, gross_salary, incentive, prvSalary, performancePay, totalA);
			tdsUpdateDAO.tdsTotalBUpdate(tds_id, a_conveyance, d_conveyance, annual_basic_salary, d_non_metro_total_basic, d_metro_total_basic, annual_hra, d_non_metro_hra, d_metro_hra, a_medical, d_medical, lta_during_year, d_lta, annual_ptax, annual_uni_allw_during_year, d_uni_allw );
			
			session.setAttribute("tds_id", tds_id);
			session.setAttribute("annual_education_allw", annual_education_allw);
			response.sendRedirect("TDSUpdateForm.jsp");
		}
	}

}
