package com.hrms.tds.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSHistoryBean;
import com.hrms.tds.bean.TDSHrBean;
import com.hrms.tds.bean.TDSHrHistoryBean;
import com.hrms.tds.bean.TDSHrTotalABean;
import com.hrms.tds.bean.TDSHrTotalBBean;
import com.hrms.tds.bean.TDSHrTotalCBean;
import com.hrms.tds.bean.TDSHrTotalDBean;
import com.hrms.tds.bean.TDSHrTotalEBean;
import com.hrms.tds.bean.TDSHrTotalFBean;
import com.hrms.tds.bean.TDSTaxBean;
import com.hrms.tds.bean.TDSTotalABean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.bean.TDSTotalCBean;
import com.hrms.tds.bean.TDSTotalDBean;
import com.hrms.tds.bean.TDSTotalEBean;
import com.hrms.tds.bean.TDSTotalFBean;
import com.hrms.tds.dao.TDSInsertDAO;
import com.hrms.tds.dao.TDSListDAO;
import com.hrms.tds.dao.TDSUpdateDAO;

public class TDSHrUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TDSHrUpdateServlet() {
    	super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
			
		}
		/**/
		//<------ total A Variable ----->
		int EMP_MASTER_ID = 0;
		int tds_hr_id = 0;
		int tds_id = 0;
		String current_date = "";
		String name = "";
		String pan_no = "";
		String status = "view";
		double annual_gross_salary = 0;
		double bonus = 0.0;
		double leave = 0.0;
		double incentive = 0.0;
		double previous_employeed_salary = 0.0;
		double performance_pay = 0.0;
		double total_a = 0.0;
		double full_final_leave = 0.0;
		double full_final_bonus = 0.0;
	
		//<------ total B Variable ----->
		double conveyance = 0.0;
		double d_conveyance = 0.0;
		String metro_non_metro = "";
		double a_total_basic = 0.0;
		double a_rent_slip = 0.0;
		double a_hra = 0.0;
		double d_non_metro_total_basic = 0.0;
		double d_metro_total_basic = 0.0;
		double d_non_metro_rent_slip = 0.0;
		double d_metro_rent_slip = 0.0;
		double d_metro_hra = 0.0;
		double d_non_metro_hra = 0.0;
		double hra_non_metro_deduction = 0.0;
		double hra_metro_deduction = 0.0;
		String landlord_name = "";
		String landlord_pan_no = "";
		double house_rant = 0.0;
		double a_medical = 0.0;
		double provided_medical_bills = 0.0;
		double d_medical = 0.0;
		double meal_card = 0.0;
		double lta_during_year = 0.0;
		double actual_expenditure_lta = 0.0;
		double d_lta = 0.0;
		double LTA = 0.0;
		double ptax = 0.0;
		int no_of_child = 0;
		double d_education_allw = 0.0;
		double uni_allw_during_year = 0.0;
		double actual_expenditure_uni_allw = 0.0;
		double d_uni_allw = 0.0;
		double total_hra = 0.0;
		double total_b = 0.0;
		
		//  <-------- Total C Variable --------->
		double other_income = 0.0;
		double a_house_loan = 0.0;
		double d_house_loan = 0.0;
		String bank_name = "";
		String bank_pan_no = "";
		String bank_address = "";
		double total_c = 0.0;
		
		//  <-------- Total D Variable --------->
		double life_insurance = 0.0;
		double ePF = 0.0;
		double pPF = 0.0;
		double nSC = 0.0;
		double mF = 0.0;
		double tuition_fees = 0.0;
		double stamp_duty = 0.0;
		double house_loan_principal = 0.0;
		double tax_saver_deposite = 0.0;
		String other_document = null;
		double other = 0.0;
		double a_total_d = 0.0;
		double d_total_d = 0.0;
		double total_d = 0.0;
		double payable_lic = 0.0;
		double payable_epf = 0.0;
		double payable_ppf = 0.0;
		double payable_nsc = 0.0;
		double payable_mf = 0.0;
		double payable_tuition_fees = 0.0;
		double payable_stamp_duty = 0.0;
		double payable_house_loan = 0.0;
		double payable_fix_deposite = 0.0;
		double payable_other = 0.0;
		double payable_a_total_d = 0.0;
		double payable_d_total_d = 0.0;
		double payable_total_d = 0.0;
		
		//  <-------- Total E Variable --------->
		double a_NPS = 0.0;
		double d_NPS = 0.0;
		double a_RGESS = 0.0;
		double d_RGESS = 0.0;
		double a_NPS_RGESS = 0.0;
		double total_NPS_RGESS = 0.0;
		double total_e = 0.0;
		double payable_total_e = 0.0;
		
		//  <-------- Total F Variable --------->
		double a_self = 0.0;
		double d_self = 0.0;
		String father_birthdate = null;
		double a_parents = 0.0;
		double d_parents = 0.0;
		double a_health_checkup = 0.0;
		double d_health_checkup = 0.0;
		double a_mediclaim = 0.0;
		double d_mediclaim = 0.0;
		String cash_cheque = "";
		double a_cash_amount = 0.0;
		double d_cash_amount = 0.0;
		double a_cheque_amount = 0.0;
		double d_cheque_amount = 0.0;
		double donation_80G = 0.0;
		double a_donation_80GGC = 0.0;
		double d_donation_80GGC = 0.0;
		double education_loan = 0.0;
		double total_80egd = 0.0;
		double total_f = 0.0;
		double tax = 0.0;
		double tax_remit = 0.0;
		double total_tax = 0.0;
		double edu_cess = 0.0;
		double total_h = 0.0;
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
		double tax_paid = 0.0;
		double tax_payable = 0.0;
		double payable_total_f = 0.0;
		double payable_tax = 0.0;
		double payable_tax_remit = 0.0;
		double payable_total_tax = 0.0;
		double payable_edu_cess = 0.0;
		double payable_total_h = 0.0;
		String action = null;
		
		//EMP_MASTER_ID = user.getEmployee_master_id();
		name = request.getParameter("emp_name");
		System.out.println("Employee Name:"+name);
		pan_no = request.getParameter("pan_no");
		System.out.println("PAN no:"+pan_no);
		tds_hr_id = Integer.parseInt((request.getParameter("id")));
		System.out.println("HR ID IN SERVLET"+tds_hr_id);
		
		EMP_MASTER_ID = Integer.parseInt(request.getParameter("EMP_MASTER_ID"));
		//  <-------- Total A --------->
		annual_gross_salary = Double.parseDouble(request.getParameter("totalBasic"));
		System.out.println("totalBasic:"+annual_gross_salary);
		bonus = Double.parseDouble(request.getParameter("Bonus"));
		System.out.println("Bonus:"+bonus);
		leave = Double.parseDouble(request.getParameter("Leave"));
		System.out.println("Leave:"+leave);
		incentive = Double.parseDouble(request.getParameter("Incentive"));
		System.out.println("Incentive:"+incentive);
		previous_employeed_salary = Double.parseDouble(request.getParameter("PreviousSalary"));
		System.out.println("PreviousSalary:"+previous_employeed_salary);
		performance_pay = Double.parseDouble(request.getParameter("Performance"));
		System.out.println("Performance:"+performance_pay);
		/*Double Full_FinalBonus = Double.parseDouble(request.getParameter("Full&FinalBonus"));
		System.out.println("Full&FinalBonus:"+Full_FinalBonus);
		Double Full_FinalLeave = Double.parseDouble(request.getParameter("Full&FinalLeave"));
		System.out.println("Full&FinalLeave:"+Full_FinalLeave);*/
		total_a = Double.parseDouble(request.getParameter("TotalGross"));
		System.out.println("TotalGross:"+total_a);
		
	    //  <-------- Total B --------->
		conveyance = Double.parseDouble(request.getParameter("Conveyance"));
		System.out.println("a_conveyance:"+conveyance);
		d_conveyance = Double.parseDouble(request.getParameter("PermissibleConveyance"));
		System.out.println("d_conveyance:"+d_conveyance);
		metro_non_metro = request.getParameter("checked");
		System.out.println("City:"+metro_non_metro);
		a_total_basic = Double.parseDouble(request.getParameter("totalBasic1"));
		System.out.println("totalBasic1:"+a_total_basic);
		a_hra = Double.parseDouble(request.getParameter("actualHRA"));
		System.out.println("actualHRA:"+a_hra);
		a_rent_slip = Double.parseDouble(request.getParameter("rentSlip"));
		System.out.println("rentSlip:"+a_rent_slip);
	
		d_metro_total_basic = Double.parseDouble(request.getParameter("totalBasicMetro"));
		System.out.println("totalBasicMetro:"+d_metro_total_basic);
			
		d_metro_rent_slip = Double.parseDouble(request.getParameter("rentSlipMetro"));
		System.out.println("rentSlipMetro:"+d_metro_rent_slip);
			
		d_metro_hra = Double.parseDouble(request.getParameter("actualHRAMetro"));
		System.out.println("actualHRAMetro:"+d_metro_hra);
			
		hra_metro_deduction = Double.parseDouble(request.getParameter("metroDeduction"));
		System.out.println("metroDeduction:"+hra_metro_deduction);

		d_non_metro_total_basic = Double.parseDouble(request.getParameter("totalBasicNonMetro"));
		System.out.println("totalBasicNonMetro:"+d_non_metro_total_basic);
			
		d_non_metro_rent_slip = Double.parseDouble(request.getParameter("rentSlipNonMetro"));
		System.out.println("rentSlipNonMetro:"+d_non_metro_rent_slip);
			
		d_non_metro_hra = Double.parseDouble(request.getParameter("actualHRANonMetro"));
		System.out.println("actualHRANonMetro:"+d_non_metro_hra);
			
		hra_non_metro_deduction = Double.parseDouble(request.getParameter("nonMetroDeduction"));
		System.out.println("nonMetroDeduction:"+hra_non_metro_deduction);
		
		landlord_name = request.getParameter("LandlordName");
		System.out.println("LandlordName:"+landlord_name);
		landlord_pan_no = request.getParameter("LandlordPanNo");
		System.out.println("LandlordPanNo:"+landlord_pan_no);
		house_rant = Double.parseDouble(request.getParameter("HouseRant"));
		System.out.println("HouseRant:"+house_rant);
		a_medical = Double.parseDouble(request.getParameter("Medical"));
		System.out.println("Medical:"+a_medical);
		provided_medical_bills = Double.parseDouble(request.getParameter("ProvidedMedicalBills"));
		System.out.println("provided_medical_bills :"+provided_medical_bills);
		d_medical = Double.parseDouble(request.getParameter("MedicalBill"));
		System.out.println("Medical Deduction:"+d_medical);
		meal_card = Double.parseDouble(request.getParameter("MealCard"));
		System.out.println("Meal Card:"+meal_card);
		lta_during_year = Double.parseDouble(request.getParameter("LTABillSalary"));
		System.out.println("lta_during_year:"+lta_during_year);
		actual_expenditure_lta = Double.parseDouble(request.getParameter("LTABill"));
		System.out.println("actual_lta:"+actual_expenditure_lta);
		d_lta = Double.parseDouble(request.getParameter("actualLTABill"));
		System.out.println("Actual LTA:"+d_lta);
		LTA = Double.parseDouble(request.getParameter("LTA"));
		System.out.println("LTA:"+LTA);
		ptax = Double.parseDouble(request.getParameter("PTAX"));
		System.out.println("PTAX:"+ptax);
		no_of_child = Integer.parseInt(request.getParameter("EducationLoan"));
		System.out.println("No of Child:"+no_of_child);
		d_education_allw = Double.parseDouble(request.getParameter("Education"));
		System.out.println("Education Loan:"+d_education_allw);
		uni_allw_during_year = Double.parseDouble(request.getParameter("UniformAllowance"));
		System.out.println("uni_allw_during_year:"+uni_allw_during_year);
		actual_expenditure_uni_allw = Double.parseDouble(request.getParameter("ActualUniformAllowance"));
		System.out.println("actual_uni_allw:"+actual_expenditure_uni_allw);
		d_uni_allw = Double.parseDouble(request.getParameter("Uniform"));
		System.out.println("d_uni_allw:"+d_uni_allw);
		total_hra = Double.parseDouble(request.getParameter("TotalB"));
		System.out.println("total_hra:"+total_hra);
		total_b = Double.parseDouble(request.getParameter("TotalAB"));
		System.out.println("total_b:"+total_b);
		
		//  <-------- Total C --------->
		other_income = Double.parseDouble(request.getParameter("OtherIncome"));
		System.out.println("Other Income:"+other_income);
		a_house_loan = Double.parseDouble(request.getParameter("HouseLoan1"));
		System.out.println("House Loan:"+a_house_loan);
		d_house_loan = Double.parseDouble(request.getParameter("HouseLoanDeduction"));
		System.out.println("d_house_loan:"+d_house_loan);
		bank_name = request.getParameter("BankName");
		System.out.println("Bank Name:"+bank_name);
		bank_pan_no = request.getParameter("BankPANNo");
		System.out.println("Bank PAN No:"+bank_pan_no);
		bank_address = request.getParameter("BankAddress");
		System.out.println("Bank Address:"+bank_address);
		total_c = Double.parseDouble(request.getParameter("TotalC"));
		System.out.println("total_c:"+total_c);
		
		//  <-------- Total D --------->
		life_insurance = Double.parseDouble(request.getParameter("LifeInsurance"));
		System.out.println("Life Insurance:"+life_insurance);
		ePF = Double.parseDouble(request.getParameter("EPF"));
		System.out.println("EPF:"+ePF);
		pPF = Double.parseDouble(request.getParameter("PPF"));
		System.out.println("PPF:"+pPF);
		nSC = Double.parseDouble(request.getParameter("NSC"));
		System.out.println("NSC:"+nSC);
		mF = Double.parseDouble(request.getParameter("MF"));
		System.out.println("MF:"+mF);
		tuition_fees = Double.parseDouble(request.getParameter("TuitionFees"));
		System.out.println("Tuition Fees:"+tuition_fees);
		stamp_duty = Double.parseDouble(request.getParameter("StampDuty"));
		System.out.println("Stamp Duty:"+stamp_duty);
		house_loan_principal = Double.parseDouble(request.getParameter("HouseLoanPrincipal"));
		System.out.println("House Loan Principal:"+house_loan_principal);
		tax_saver_deposite = Double.parseDouble(request.getParameter("TaxSaverFixDeposit"));
		System.out.println("TaxSaver Fix Deposit:"+tax_saver_deposite);
		other_document = request.getParameter("OtherDocument");
		System.out.println("other_document :"+other_document);
		other = Double.parseDouble(request.getParameter("Other"));
		System.out.println("Other:"+other);
		a_total_d = Double.parseDouble(request.getParameter("TotalD"));
		System.out.println("a_total_d:"+a_total_d);
		d_total_d = Double.parseDouble(request.getParameter("80CTotal"));
		System.out.println("d_total_d:"+d_total_d);
		total_d = Double.parseDouble(request.getParameter("totalD"));
		System.out.println("total_d:"+total_d);
		payable_lic = Double.parseDouble(request.getParameter("LICPayable"));
		System.out.println("payable_lic :"+payable_lic);
		payable_epf = Double.parseDouble(request.getParameter("EPFPayable"));
		System.out.println("payable_epf :"+payable_epf);
		payable_ppf = Double.parseDouble(request.getParameter("PPFPayable"));
		System.out.println("payable_ppf :"+payable_ppf);
		payable_nsc = Double.parseDouble(request.getParameter("NSCPayable"));
		System.out.println("payable_nsc :"+payable_nsc);
		payable_mf = Double.parseDouble(request.getParameter("MFPayable"));
		System.out.println("payable_mf :"+payable_mf);
		payable_tuition_fees = Double.parseDouble(request.getParameter("TuitionFeesPayable"));
		System.out.println("payable_tuition_fees :"+payable_tuition_fees);
		payable_stamp_duty = Double.parseDouble(request.getParameter("StampDutyPayable"));
		System.out.println("payable_stamp_duty :"+payable_stamp_duty);
		payable_house_loan = Double.parseDouble(request.getParameter("HouseLoanPayable"));
		System.out.println("payable_house_loan :"+payable_house_loan);
		payable_fix_deposite = Double.parseDouble(request.getParameter("FixDepositePayable"));
		System.out.println("payable_fix_deposite :"+payable_fix_deposite);
		payable_other = Double.parseDouble(request.getParameter("OtherPayable"));
		System.out.println("payable_other :"+payable_other);
		payable_a_total_d = Double.parseDouble(request.getParameter("PayableTotalD"));
		System.out.println("payable_a_total_d :"+payable_a_total_d);
		payable_d_total_d = Double.parseDouble(request.getParameter("Payable80CTotal"));
		System.out.println("payable_d_total_d :"+payable_d_total_d);
		payable_total_d = Double.parseDouble(request.getParameter("PayabletotalD"));
		System.out.println("payable_total_d :"+payable_total_d);
		
		//  <-------- Total E --------->
		System.out.println("Hello shruti");
		a_NPS = Double.parseDouble(request.getParameter("NPS1"));
		System.out.println("a_NPS:"+a_NPS);
		d_NPS = Double.parseDouble(request.getParameter("NPSDeduction"));
		System.out.println("d_NPS:"+d_NPS);
		a_RGESS = Double.parseDouble(request.getParameter("RGESS1"));
		System.out.println("a_RGESS:"+a_RGESS);
		d_RGESS = Double.parseDouble(request.getParameter("RGESSDeduction"));
		System.out.println("d_RGESS:"+d_RGESS);
		a_NPS_RGESS = Double.parseDouble(request.getParameter("actualTotalE"));
		System.out.println("a_NPS_RGESS:"+a_NPS_RGESS);
		total_NPS_RGESS = Double.parseDouble(request.getParameter("TotalE"));
		System.out.println("d_NPS_RGESS:"+total_NPS_RGESS);
		total_e = Double.parseDouble(request.getParameter("TotalCE"));
		System.out.println("total_e:"+total_e);
		payable_total_e = Double.parseDouble(request.getParameter("PayabletotalE"));
		System.out.println("payable_total_e :"+payable_total_e);
		
		//  <-------- Total F --------->
		a_self = Double.parseDouble(request.getParameter("SelfSpouseChildren"));
		System.out.println("a_self:"+a_self);
		d_self = Double.parseDouble(request.getParameter("SelfSpouseChildrenDeduction"));
		System.out.println("d_self:"+d_self);
		
		if(request.getParameter("datepicker1") != null){
		father_birthdate = request.getParameter("datepicker1");
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat father1_date = new SimpleDateFormat("dd/MM/yyyy");
		Date father_date = null;	
		try {																			
			father_date = father1_date.parse(father_birthdate);
			father_birthdate = date.format(father_date);
			System.out.println("Father Birhtdate:"+father_birthdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		a_parents = Double.parseDouble(request.getParameter("Parents"));
		System.out.println("a_parents:"+a_parents);
		d_parents = Double.parseDouble(request.getParameter("ParentsDeduction"));
		System.out.println("d_parents:"+d_parents);
		a_health_checkup = Double.parseDouble(request.getParameter("health"));
		System.out.println("a_health_checkup:"+a_health_checkup);
		d_health_checkup = Double.parseDouble(request.getParameter("healthDeduction"));
		System.out.println("d_health_checkup:"+d_health_checkup);
		a_mediclaim = Double.parseDouble(request.getParameter("TotalActual"));
		System.out.println("a_mediclaim:"+a_mediclaim);
		d_mediclaim = Double.parseDouble(request.getParameter("TotalDeduction"));
		System.out.println("d_mediclaim:"+d_mediclaim);
					
		a_cash_amount = Double.parseDouble(request.getParameter("cashAmount"));
		System.out.println("a_cash_amount:"+a_cash_amount);
		d_cash_amount = Double.parseDouble(request.getParameter("cashDeduction"));
		System.out.println("d_cash_amount:"+d_cash_amount);
		a_cheque_amount = Double.parseDouble(request.getParameter("chequeAmount"));
		System.out.println("a_cheque_amount:"+a_cheque_amount);
		d_cheque_amount = Double.parseDouble(request.getParameter("chequeDeduction"));
		System.out.println("d_cheque_amount:"+d_cheque_amount);
		donation_80G = Double.parseDouble(request.getParameter("Donation"));
		System.out.println("donation_80g:"+donation_80G);
		
		a_donation_80GGC = Double.parseDouble(request.getParameter("donationAmount"));
		System.out.println("a_donation_80ggc:"+a_donation_80GGC);
		d_donation_80GGC = Double.parseDouble(request.getParameter("donationDeduction"));
		System.out.println("d_donation_80ggc:"+d_donation_80GGC);
		education_loan = Double.parseDouble(request.getParameter("EducationLoaninterest"));
		System.out.println("education_loan:"+education_loan);
		total_80egd = Double.parseDouble(request.getParameter("TotalF"));
		System.out.println("total_80egd:"+total_80egd);
		total_f = Double.parseDouble(request.getParameter("TaxableIncome"));
		System.out.println("total_f:"+total_f);
		tax = Double.parseDouble(request.getParameter("Tax"));
		System.out.println("Tax:"+tax);
		tax_remit = Double.parseDouble(request.getParameter("TaxRemit"));
		System.out.println("tax_remit:"+tax_remit);
		total_tax = Double.parseDouble(request.getParameter("TotalTax"));
		System.out.println("total_tax:"+total_tax);
		edu_cess = Double.parseDouble(request.getParameter("EduCess"));
		System.out.println("edu_cess:"+edu_cess);
		total_h = Double.parseDouble(request.getParameter("TotalH"));
		System.out.println("total_h:"+total_h);
		april = Double.parseDouble(request.getParameter("april"));
		System.out.println("april:"+april);
		may = Double.parseDouble(request.getParameter("may"));
		System.out.println("may:"+may);
		june = Double.parseDouble(request.getParameter("june"));
		System.out.println("june:"+june);
		july = Double.parseDouble(request.getParameter("july"));
		System.out.println("july:"+july);
		august = Double.parseDouble(request.getParameter("august"));
		System.out.println("august:"+august);
		september = Double.parseDouble(request.getParameter("september"));
		System.out.println("september:"+september);
		october = Double.parseDouble(request.getParameter("october"));
		System.out.println("october:"+october);
		november = Double.parseDouble(request.getParameter("november"));
		System.out.println("november:"+november);
		december = Double.parseDouble(request.getParameter("december"));
		System.out.println("december:"+december);
		january = Double.parseDouble(request.getParameter("january"));
		System.out.println("january:"+january);
		february = Double.parseDouble(request.getParameter("february"));
		System.out.println("february:"+february);
		march = Double.parseDouble(request.getParameter("march"));
		System.out.println("march:"+march);
		payable_total_f = Double.parseDouble(request.getParameter("PayabletotalF"));
		System.out.println("payable_total_f :"+payable_total_f);
		payable_tax = Double.parseDouble(request.getParameter("PayableTax"));
		System.out.println("payable_tax :"+payable_tax);
		payable_tax_remit = Double.parseDouble(request.getParameter("PayableTaxRemit"));
		System.out.println("payable_tax_remit :"+payable_tax_remit);
		payable_total_tax = Double.parseDouble(request.getParameter("PayableTotalTax"));
		System.out.println("payable_total_tax :"+payable_total_tax);
		payable_edu_cess = Double.parseDouble(request.getParameter("PayableEduCess"));
		System.out.println("payable_edu_cess :"+payable_edu_cess);
		payable_total_h = Double.parseDouble(request.getParameter("PayableTotalH"));
		System.out.println("payable_total_h :"+payable_total_h);
		tax_paid = Double.parseDouble(request.getParameter("TaxPaid"));
		
		int docList = Integer.parseInt(request.getParameter("docList"));
		if(docList == 0) {
			tax_payable = Double.parseDouble(request.getParameter("TaxPayable"));
		}else {
			tax_payable = Double.parseDouble(request.getParameter("PayableTaxPayable"));
		}
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(EMP_MASTER_ID);
		
		SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat formateNowMonth = new SimpleDateFormat("MM");
		Date d = new Date();
		String current = formateNowMonth.format(d);
		int current_month = Integer.parseInt(current);
		System.out.println("Month Id"+current_month);
		String end_year = null;
		int end_year_int = 0;
		int start_year = 0;
		String period = null;
		if(current_month > 2) {
			end_year = formatNowYear.format(d);
			end_year_int = Integer.parseInt(end_year);
			start_year = (end_year_int + 1);
			period = end_year +"-"+ start_year;
			System.out.println(period);
		}else {
			end_year = formatNowYear.format(d);
			end_year_int = Integer.parseInt(end_year);
			start_year = (end_year_int - 1);
			period = end_year +"-"+ start_year;
			System.out.println(period);
		}
		try{
			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
			current_date = YYYYMMDD.format(d);
			}catch(Exception e){
			
		}
		
		/*TDSListDAO  tdsListDAO = new TDSListDAO();
		List<TDSBean> gopi= tdsListDAO.getTDSDupicate(period, EMP_MASTER_ID);
		
		if(gopi.size() == 0)
		{*/
			action = request.getParameter("LOCKNAME");
			if(action.equals("UNLOCK")) {
				
				TDSInsertDAO tdsUpdateDAO = new TDSInsertDAO();
				TDSListDAO listDAO = new TDSListDAO();
				/*boolean result = tdsUpdateDAO.tdsHrInsert(tdsHrBean);
				int tdsHrId = tdsHrBean.getTds_hr_id();
				System.out.println("TDS HR ID" + tdsHrId);
				session.setAttribute("tds_hr_id", tdsHrId);*/
				TDSHrBean tdsHrBean1 = new TDSHrBean();
				tdsHrBean1.setTds_hr_id(tds_hr_id);
				
				TDSHrBean hrBeanId = listDAO.detailsOfTDSHr(tds_hr_id);
				TDSHrTotalABean hraBeanId = listDAO.detailsOfTDSHrTotal_A(tds_hr_id);
				TDSHrTotalBBean hrbBeanId = listDAO.detailsOfTDSHrTotal_B(tds_hr_id);
				TDSHrTotalCBean hrcBeanId = listDAO.detailsOfTDSHrTotal_C(tds_hr_id);
				TDSHrTotalDBean hrdBeanId = listDAO.detailsOfTDSHrTotal_D(tds_hr_id);
				TDSHrTotalEBean hreBeanId = listDAO.detailsOfTDSHrTotal_E(tds_hr_id);
				TDSHrTotalFBean hrfBeanId = listDAO.detailsOfTDSHrTotal_F(tds_hr_id);
				
				TDSHrBean hrBean = new TDSHrBean(tds_hr_id, status, current_date, period, employeeBean);
				TDSHrTotalABean hraBean = new TDSHrTotalABean(hraBeanId.getTds_hr_totala_id(),annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, tdsHrBean1);
				TDSHrTotalBBean hrbBean = new TDSHrTotalBBean(hrbBeanId.getTds_hr_totalb_id(),conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, tdsHrBean1);
				TDSHrTotalCBean hrcBean = new TDSHrTotalCBean(hrcBeanId.getTds_hr_totalc_id(),other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, tdsHrBean1);
				TDSHrTotalDBean hrdBean = new TDSHrTotalDBean(hrdBeanId.getTds_hr_totald_id(), life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, payable_total_d, tdsHrBean1);
				TDSHrTotalEBean hreBean = new TDSHrTotalEBean(hreBeanId.getTds_hr_totale_id(), a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, tdsHrBean1);
				TDSHrTotalFBean hrfBean = new TDSHrTotalFBean(hrfBeanId.getTds_hr_totalf_id(), a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, tdsHrBean1, april, may, june, july, august, september, october, november, december, january, february, march, tax_paid, tax_payable);
				
				boolean resultHr = tdsUpdateDAO.tdsHrInsert(hrBean);
				boolean resultHrTotalA = tdsUpdateDAO.tdsHrTotalAInsert(hraBean);
				boolean resultHrTotalB = tdsUpdateDAO.tdsHrTotalBInsert(hrbBean);
				boolean resultHrTotalC = tdsUpdateDAO.tdsHrTotalCInsert(hrcBean);
				boolean resultHrTotalD = tdsUpdateDAO.tdsHrTotalDInsert(hrdBean);
				boolean resultHrTotalE = tdsUpdateDAO.tdsHrTotalEInsert(hreBean);
				boolean resultHrTotalF = tdsUpdateDAO.tdsHrTotalFInsert(hrfBean);
				
				String update_date = d.toString();
				TDSInsertDAO tdsInsertDAO = new TDSInsertDAO();
				TDSHrHistoryBean tdshrhistoryBean = new TDSHrHistoryBean(status, update_date, period, annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, april, may, june, july, august, september, october, november, december, january, february, march, tax_paid, tax_payable, tdsHrBean1, employeeBean);
				boolean history = tdsInsertDAO.tdsHrHistoryInsert(tdshrhistoryBean);
				
				TDSListDAO tdsListDAO = new TDSListDAO();
				TDSBean tdsBean = tdsListDAO.detailsOfTDSByEmpID(EMP_MASTER_ID);
				tds_id = tdsBean.getTds_id();
				System.err.println(tds_id);
				
				TDSBean tById = tdsListDAO.detailsOfTDS(tds_id);
				TDSTotalABean taById = tdsListDAO.detailsOfTDSTotal_A(tds_id);
				TDSTotalBBean tbById = tdsListDAO.detailsOfTDSTotal_B(tds_id);
				TDSTotalCBean tcById = tdsListDAO.detailsOfTDSTotal_C(tds_id);
				TDSTotalDBean tdById = tdsListDAO.detailsOfTDSTotal_D(tds_id);
				TDSTotalEBean teById = tdsListDAO.detailsOfTDSTotal_E(tds_id);
				TDSTotalFBean tfById = tdsListDAO.detailsOfTDSTotal_F(tds_id);
				
				TDSBean t = new TDSBean(tds_id, status, current_date, period, employeeBean);
				TDSTotalABean ta = new TDSTotalABean(taById.getTds_totala_id(), annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, tdsBean);
				TDSTotalBBean tb = new TDSTotalBBean(tbById.getTds_totalb_id(), conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, tdsBean);
				TDSTotalCBean tc = new TDSTotalCBean(tcById.getTds_totalc_id(), other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, tdsBean);
				TDSTotalDBean td = new TDSTotalDBean(tdById.getTds_totald_id(), life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, payable_total_d, tdsBean);
				TDSTotalEBean te = new TDSTotalEBean(teById.getTds_totale_id(), a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, tdsBean);
				TDSTotalFBean tf = new TDSTotalFBean(tfById.getTds_totalf_id(), a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, tax_paid, tax_payable, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, april, may, june, july, august, september, october, november, december, january, february, march, tdsBean);
				
				boolean result_t = tdsInsertDAO.tdsInsert(t);
				boolean result_ta = tdsInsertDAO.tdsTotalAInsert(ta);
				boolean result_tb = tdsInsertDAO.tdsTotalBInsert(tb);
				boolean result_tc = tdsInsertDAO.tdsTotalCInsert(tc);
				boolean result_td = tdsInsertDAO.tdsTotalDInsert(td);
				boolean result_te = tdsInsertDAO.tdsTotalEInsert(te);
				boolean result_tf = tdsInsertDAO.tdsTotalFInsert(tf);
				
				
			}else if(action.equals("LOCK")) {
				String hr_status = "LOCK";
				TDSInsertDAO tdsUpdateDAO = new TDSInsertDAO();
				TDSListDAO listDAO = new TDSListDAO();
				/*boolean result = tdsUpdateDAO.tdsHrInsert(tdsHrBean);
				int tdsHrId = tdsHrBean.getTds_hr_id();
				System.out.println("TDS HR ID" + tdsHrId);
				session.setAttribute("tds_hr_id", tdsHrId);*/
				
				employeeBean.setEmployee_master_id(EMP_MASTER_ID);
				
				TDSHrBean tdsHrBean1 = new TDSHrBean(hr_status,employeeBean);
				tdsHrBean1.setTds_hr_id(tds_hr_id);
				
				TDSHrBean hrBeanId = listDAO.detailsOfTDSHr(tds_hr_id);
				TDSHrTotalABean hraBeanId = listDAO.detailsOfTDSHrTotal_A(tds_hr_id);
				TDSHrTotalBBean hrbBeanId = listDAO.detailsOfTDSHrTotal_B(tds_hr_id);
				TDSHrTotalCBean hrcBeanId = listDAO.detailsOfTDSHrTotal_C(tds_hr_id);
				TDSHrTotalDBean hrdBeanId = listDAO.detailsOfTDSHrTotal_D(tds_hr_id);
				TDSHrTotalEBean hreBeanId = listDAO.detailsOfTDSHrTotal_E(tds_hr_id);
				TDSHrTotalFBean hrfBeanId = listDAO.detailsOfTDSHrTotal_F(tds_hr_id);
				
				TDSHrBean hrBean = new TDSHrBean(tds_hr_id, hr_status, current_date, period, employeeBean);
				TDSHrTotalABean hraBean = new TDSHrTotalABean(hraBeanId.getTds_hr_totala_id(),annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, tdsHrBean1);
				TDSHrTotalBBean hrbBean = new TDSHrTotalBBean(hrbBeanId.getTds_hr_totalb_id(),conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, tdsHrBean1);
				TDSHrTotalCBean hrcBean = new TDSHrTotalCBean(hrcBeanId.getTds_hr_totalc_id(),other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, tdsHrBean1);
				TDSHrTotalDBean hrdBean = new TDSHrTotalDBean(hrdBeanId.getTds_hr_totald_id(), life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, payable_total_d, tdsHrBean1);
				TDSHrTotalEBean hreBean = new TDSHrTotalEBean(hreBeanId.getTds_hr_totale_id(), a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, tdsHrBean1);
				TDSHrTotalFBean hrfBean = new TDSHrTotalFBean(hrfBeanId.getTds_hr_totalf_id(), a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, tdsHrBean1, april, may, june, july, august, september, october, november, december, january, february, march, tax_paid, tax_payable);
				
				boolean resultHr = tdsUpdateDAO.tdsHrInsert(hrBean);
				boolean resultHrTotalA = tdsUpdateDAO.tdsHrTotalAInsert(hraBean);
				boolean resultHrTotalB = tdsUpdateDAO.tdsHrTotalBInsert(hrbBean);
				boolean resultHrTotalC = tdsUpdateDAO.tdsHrTotalCInsert(hrcBean);
				boolean resultHrTotalD = tdsUpdateDAO.tdsHrTotalDInsert(hrdBean);
				boolean resultHrTotalE = tdsUpdateDAO.tdsHrTotalEInsert(hreBean);
				boolean resultHrTotalF = tdsUpdateDAO.tdsHrTotalFInsert(hrfBean);
				
				String update_date = d.toString();
				TDSInsertDAO tdsInsertDAO = new TDSInsertDAO();
				TDSHrHistoryBean tdshrhistoryBean = new TDSHrHistoryBean(status, update_date, period, annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, april, may, june, july, august, september, october, november, december, january, february, march, tax_paid, tax_payable, tdsHrBean1, employeeBean);
				boolean history = tdsInsertDAO.tdsHrHistoryInsert(tdshrhistoryBean);
				
				TDSListDAO tdsListDAO = new TDSListDAO();
				TDSBean tdsBean = tdsListDAO.detailsOfTDSByEmpID(EMP_MASTER_ID);
				tds_id = tdsBean.getTds_id();
				System.err.println(tds_id);
				
				TDSBean tById = tdsListDAO.detailsOfTDS(tds_id);
				TDSTotalABean taById = tdsListDAO.detailsOfTDSTotal_A(tds_id);
				TDSTotalBBean tbById = tdsListDAO.detailsOfTDSTotal_B(tds_id);
				TDSTotalCBean tcById = tdsListDAO.detailsOfTDSTotal_C(tds_id);
				TDSTotalDBean tdById = tdsListDAO.detailsOfTDSTotal_D(tds_id);
				TDSTotalEBean teById = tdsListDAO.detailsOfTDSTotal_E(tds_id);
				TDSTotalFBean tfById = tdsListDAO.detailsOfTDSTotal_F(tds_id);
				
				TDSBean t = new TDSBean(tds_id, hr_status, current_date, period, employeeBean);
				TDSTotalABean ta = new TDSTotalABean(taById.getTds_totala_id(), annual_gross_salary, bonus, leave, incentive, previous_employeed_salary, performance_pay, full_final_leave, full_final_bonus, total_a, tdsBean);
				TDSTotalBBean tb = new TDSTotalBBean(tbById.getTds_totalb_id(), conveyance, d_conveyance, metro_non_metro, a_total_basic, d_non_metro_total_basic, d_metro_total_basic, a_rent_slip, d_non_metro_rent_slip, d_metro_rent_slip, a_hra, d_non_metro_hra, d_metro_hra, hra_non_metro_deduction, hra_metro_deduction, house_rant, landlord_name, landlord_pan_no, a_medical, provided_medical_bills, d_medical, meal_card, lta_during_year, actual_expenditure_lta, d_lta, ptax, no_of_child, d_education_allw, uni_allw_during_year, actual_expenditure_uni_allw, d_uni_allw, total_hra, total_b, tdsBean);
				TDSTotalCBean tc = new TDSTotalCBean(tcById.getTds_totalc_id(), other_income, a_house_loan, d_house_loan, bank_name, bank_pan_no, bank_address, total_c, tdsBean);
				TDSTotalDBean td = new TDSTotalDBean(tdById.getTds_totald_id(), life_insurance, ePF, pPF, nSC, mF, tuition_fees, stamp_duty, house_loan_principal, tax_saver_deposite, other_document, other, a_total_d, d_total_d, total_d, payable_lic, payable_epf, payable_ppf, payable_nsc, payable_mf, payable_tuition_fees, payable_stamp_duty, payable_house_loan, payable_fix_deposite, payable_other, payable_a_total_d, payable_d_total_d, payable_total_d, tdsBean);
				TDSTotalEBean te = new TDSTotalEBean(teById.getTds_totale_id(), a_NPS, d_NPS, a_RGESS, d_RGESS, total_NPS_RGESS, total_e, payable_total_e, tdsBean);
				TDSTotalFBean tf = new TDSTotalFBean(tfById.getTds_totalf_id(), a_self, d_self, father_birthdate, a_parents, d_parents, a_health_checkup, d_health_checkup, a_mediclaim, d_mediclaim, a_cash_amount, d_cash_amount, a_cheque_amount, d_cheque_amount, donation_80G, a_donation_80GGC, d_donation_80GGC, education_loan, total_80egd, total_f, tax, tax_remit, total_tax, edu_cess, total_h, tax_paid, tax_payable, payable_total_f, payable_tax, payable_tax_remit, payable_total_tax, payable_edu_cess, payable_total_h, april, may, june, july, august, september, october, november, december, january, february, march, tdsBean);
				
				boolean result_t = tdsInsertDAO.tdsInsert(t);
				boolean result_ta = tdsInsertDAO.tdsTotalAInsert(ta);
				boolean result_tb = tdsInsertDAO.tdsTotalBInsert(tb);
				boolean result_tc = tdsInsertDAO.tdsTotalCInsert(tc);
				boolean result_td = tdsInsertDAO.tdsTotalDInsert(td);
				boolean result_te = tdsInsertDAO.tdsTotalEInsert(te);
				boolean result_tf = tdsInsertDAO.tdsTotalFInsert(tf);
				
				/*TDSUpdateDAO tdsUpdateDAO1 = new TDSUpdateDAO();
				boolean result1 = tdsUpdateDAO1.tdsStatusLock(EMP_MASTER_ID, hr_status);*/
				
			}
			
			TDSListDAO tdsListDAO = new TDSListDAO();
			TDSInsertDAO insertDAO = new TDSInsertDAO();
			
			List<TDSTaxBean> taxList = tdsListDAO.getTDSTaxList(current_month,end_year_int,EMP_MASTER_ID);
			System.err.println("SIZE :"+ taxList.size());
			
			TDSBean tdsBean1 = new TDSBean();
			tdsBean1.setTds_id(tds_id);
			
			MonthBean monthBean = new MonthBean();
			monthBean.setMonth_id(current_month);
			
			if(taxList.size() != 0)
			{
				TDSTaxBean taxBeanId = tdsListDAO.detailsOfTDSTax(tds_id,current_month,end_year_int);
				TDSTaxBean taxBean = new TDSTaxBean(taxBeanId.getTds_tax_id(), end_year_int, tax_payable, tdsBean1, employeeBean, monthBean);
				boolean resultTax = insertDAO.tdsTaxInsert(taxBean);
			}
			else
			{
				TDSTaxBean taxBean = new TDSTaxBean( end_year_int, tax_payable, tdsBean1, employeeBean, monthBean);
				boolean tdsTaxResult = insertDAO.tdsTaxInsert(taxBean);
			}
		
			//TDSUpdateDAO tdsUpdateDAO1 = new TDSUpdateDAO();
			//boolean result1 = tdsUpdateDAO1.tdsStatusUpdate(EMP_MASTER_ID, status);
			
			
			/*if(tax == 0.0)
			{
				//request.getRequestDispatcher("form16PartA.jsp").forward(request, response);
				response.sendRedirect("form16PartA.jsp");
			}else if(tax != 0.0) {
				//request.getRequestDispatcher("form16PartB.jsp").forward(request, response);
				response.sendRedirect("form16PartB.jsp");
			}*/
			
			response.sendRedirect("TDSDemo.jsp");
		/*}
		else
		{
			
			System.out.println("FOUND");
			request.setAttribute("TDSExist", "TDS Already Exists");
			response.sendRedirect("TDSCalculation.jsp");
		}*/
		
	
	}

}
