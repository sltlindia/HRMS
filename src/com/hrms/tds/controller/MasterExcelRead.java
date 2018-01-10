package com.hrms.tds.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.tds.bean.TDSPayrollMasterDataBean;
import com.hrms.tds.dao.TDSInsertDAO;

public class MasterExcelRead {
	
	public void readMasterData(String filename, MonthBean monthBean, YearBean yearBean ) throws IOException, ParseException {
		
		FileInputStream fis = new FileInputStream("D:\\hrms\\upload\\TDSSalaryData\\"+filename);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		Row row;
		
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = 1; i<=sheet.getLastRowNum();i++)
		{
			row = (Row) sheet.getRow(i);
			
			String emp_code = "-";
			int employee_code = 0;
			String company_name = "-";
			String employee_name = "-";
			String pan_no = "-";
			String date_of_birth = "-";
			String designation = "-";
			String gender = "-";
			String joining_date = "-";
			String from_date = "-";
			String to_date = "-";
			String resign_date = "-";
			String period = "-";
			double salary = 0.0;
			double bonus = 0.0;
			double leave_count = 0.0;
			double interest = 0.0;
			double full_final_bonus = 0.0;
			double full_final_leave = 0.0;
			double incentive = 0.0;
			double previous_salary = 0.0;
			double performance = 0.0;
			double total_a = 0.0;
			double conveyance = 0.0;
			double hra = 0.0;
			double medical_allw = 0.0;
			double mealcard = 0.0;
			double education_allw = 0.0;
			double lta = 0.0;
			double ptax = 0.0;
			double uniform_allw = 0.0;
			double other_allw = 0.0;
			double total_b = 0.0;
			double houseloan_interest = 0.0;
			double other_income = 0.0;
			double final_houseloan_interest = 0.0;
			double total_c = 0.0;
			double lic = 0.0;
			double epf = 0.0;
			double ppf = 0.0;
			double nsc = 0.0;
			double mf = 0.0;
			double tuition_fees = 0.0;
			double houseloan_principal = 0.0;
			double stamp_duty = 0.0;
			double tax_saver_deposite = 0.0;
			double other = 0.0;
			double total_d = 0.0;
			double total_80c = 0.0;
			double nps = 0.0;
			double rgess = 0.0;
			double total_e = 0.0;
			double mediclaim = 0.0;
			double donation = 0.0;
			double final_donation = 0.0;
			double edu_loan_interest = 0.0;
			double total_f = 0.0;
			double a10 = 0.0;
			double total_g = 0.0;
			double tax = 0.0;
			double tax_remit = 0.0;
			double total_tax = 0.0;
			double edu_cess = 0.0;
			double total_h = 0.0;
			double tax_payable = 0.0;
			double previous_tax_paid = 0.0;
			double tax_paid = 0.0;
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
			
			try {
				emp_code = new DataFormatter().formatCellValue(row.getCell(1));
				employee_code = Integer.parseInt(emp_code);
				System.out.print(employee_code + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				company_name = row.getCell(2).toString();
				System.out.print(company_name + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				employee_name = row.getCell(3).toString();
				System.out.print(employee_name + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				pan_no = row.getCell(4).toString();
				System.out.print(pan_no + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				date_of_birth = row.getCell(5).toString();
				System.err.print(date_of_birth + "\t");
				Date d1 = formater.parse(date_of_birth);
				date_of_birth = format.format(d1);
				System.out.print(date_of_birth + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				designation = row.getCell(6).toString();
				System.out.print(designation + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				gender = row.getCell(7).toString();
				System.out.print(gender + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				joining_date= row.getCell(8).toString();
				Date d2 = formater.parse(joining_date);
				joining_date = format.format(d2);
				System.out.print(joining_date + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				from_date = row.getCell(9).toString();
				Date d3 = formater.parse(from_date);
				from_date = format.format(d3);
				System.out.print(from_date + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				to_date = row.getCell(10).toString();
				Date d4 = formater.parse(to_date);
				to_date = format.format(d4);
				System.out.print(to_date + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				resign_date = row.getCell(11).toString();
				Date d5 = formater.parse(resign_date);
				resign_date = format.format(d5);
				System.out.print(resign_date + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {} catch (ParseException e) {}
			
			try {
				period = row.getCell(12).toString();
				System.out.print(period + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				salary = Double.parseDouble(row.getCell(13).toString());
				System.out.print(salary + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				bonus = Double.parseDouble(row.getCell(14).toString());
				System.out.print(bonus + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				leave_count = Double.parseDouble(row.getCell(15).toString());
				System.out.print(leave_count + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				interest = Double.parseDouble(row.getCell(16).toString());
				System.out.print(interest + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				full_final_bonus = Double.parseDouble(row.getCell(17).toString());
				System.out.print(full_final_bonus + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				full_final_leave = Double.parseDouble(row.getCell(18).toString());
				System.out.print(full_final_leave + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				incentive = Double.parseDouble(row.getCell(19).toString());
				System.out.print(incentive + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				previous_salary = Double.parseDouble(row.getCell(20).toString());
				System.out.print(previous_salary + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				performance = Double.parseDouble(row.getCell(21).toString());
				System.out.print(performance + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_a = Double.parseDouble(row.getCell(22).toString());
				System.out.print(total_a + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				conveyance = Double.parseDouble(row.getCell(23).toString());
				System.out.print(conveyance + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				hra = Double.parseDouble(row.getCell(24).toString());
				System.out.print(hra + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				medical_allw = Double.parseDouble(row.getCell(25).toString());
				System.out.print(medical_allw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				mealcard = Double.parseDouble(row.getCell(26).toString());
				System.out.print(mealcard + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			
			try {
				education_allw = Double.parseDouble(row.getCell(27).toString());
				System.out.print(education_allw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				lta = Double.parseDouble(row.getCell(28).toString());
				System.out.print(lta + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				ptax = Double.parseDouble(row.getCell(29).toString());
				System.out.print(ptax + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				uniform_allw = Double.parseDouble(row.getCell(30).toString());
				System.out.print(uniform_allw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				other_allw = Double.parseDouble(row.getCell(31).toString());
				System.out.print(other_allw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_b = Double.parseDouble(row.getCell(32).toString());
				System.out.print(total_b + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				houseloan_interest = Double.parseDouble(row.getCell(33).toString());
				System.out.print(houseloan_interest + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				other_income = Double.parseDouble(row.getCell(34).toString());
				System.out.print(other_income + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				final_houseloan_interest = Double.parseDouble(row.getCell(35).toString());
				System.out.print(final_houseloan_interest + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_c = Double.parseDouble(row.getCell(36).toString());
				System.out.print(total_c + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				lic = Double.parseDouble(row.getCell(37).toString());
				System.out.print(lic + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				epf = Double.parseDouble(row.getCell(38).toString());
				System.out.print(epf + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				ppf = Double.parseDouble(row.getCell(39).toString());
				System.out.print(ppf + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				nsc = Double.parseDouble(row.getCell(40).toString());
				System.out.print(nsc + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				mf = Double.parseDouble(row.getCell(41).toString());
				System.out.print(mf + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tuition_fees = Double.parseDouble(row.getCell(42).toString());
				System.out.print(tuition_fees + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				houseloan_principal = Double.parseDouble(row.getCell(43).toString());
				System.out.print(houseloan_principal + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				stamp_duty = Double.parseDouble(row.getCell(44).toString());
				System.out.print(stamp_duty + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tax_saver_deposite = Double.parseDouble(row.getCell(45).toString());
				System.out.print(tax_saver_deposite + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				other = Double.parseDouble(row.getCell(46).toString());
				System.out.print(other + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_d = Double.parseDouble(row.getCell(47).toString());
				System.out.print(total_d + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_80c = Double.parseDouble(row.getCell(48).toString());
				System.out.print(total_80c + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				nps = Double.parseDouble(row.getCell(49).toString());
				System.out.print(nps + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				rgess = Double.parseDouble(row.getCell(50).toString());
				System.out.print(rgess + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_e = Double.parseDouble(row.getCell(51).toString());
				System.out.print(total_e + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				mediclaim = Double.parseDouble(row.getCell(52).toString());
				System.out.print(mediclaim + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				donation = Double.parseDouble(row.getCell(53).toString());
				System.out.print(donation + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				final_donation = Double.parseDouble(row.getCell(54).toString());
				System.out.print(final_donation + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				edu_loan_interest = Double.parseDouble(row.getCell(55).toString());
				System.out.print(edu_loan_interest + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_f = Double.parseDouble(row.getCell(56).toString());
				System.out.print(total_f + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				a10 = Double.parseDouble(row.getCell(57).toString());
				System.out.print(a10 + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_g = Double.parseDouble(row.getCell(58).toString());
				System.out.print(total_g + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tax = Double.parseDouble(row.getCell(59).toString());
				System.out.print(tax + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tax_remit = Double.parseDouble(row.getCell(60).toString());
				System.out.print(tax_remit + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_tax = Double.parseDouble(row.getCell(61).toString());
				System.out.print(total_tax + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				edu_cess = Double.parseDouble(row.getCell(62).toString());
				System.out.print(edu_cess + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				total_h = Double.parseDouble(row.getCell(63).toString());
				System.out.print(total_h + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tax_payable = Double.parseDouble(row.getCell(64).toString());
				System.out.print(tax_payable + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				previous_tax_paid = Double.parseDouble(row.getCell(65).toString());
				System.out.print(previous_tax_paid + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				tax_paid = Double.parseDouble(row.getCell(66).toString());
				System.out.print(tax_paid + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				april = Double.parseDouble(row.getCell(68).toString());
				System.out.print(april + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				may = Double.parseDouble(row.getCell(69).toString());
				System.out.print(may + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				june = Double.parseDouble(row.getCell(70).toString());
				System.out.print(june + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				july = Double.parseDouble(row.getCell(71).toString());
				System.out.print(july + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				august = Double.parseDouble(row.getCell(72).toString());
				System.out.print(august + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				september = Double.parseDouble(row.getCell(73).toString());
				System.out.print(september + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				october = Double.parseDouble(row.getCell(74).toString());
				System.out.print(october + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				november = Double.parseDouble(row.getCell(75).toString());
				System.out.print(november + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				december = Double.parseDouble(row.getCell(76).toString());
				System.out.print(december + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				january = Double.parseDouble(row.getCell(77).toString());
				System.out.print(january + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				february = Double.parseDouble(row.getCell(78).toString());
				System.out.print(february + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				march = Double.parseDouble(row.getCell(79).toString());
				System.out.print(march + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			System.out.println("======================================================================================");
			TDSInsertDAO tdsInsertDAO = new TDSInsertDAO();
			TDSPayrollMasterDataBean tdsPayrollMasterDataBean = new TDSPayrollMasterDataBean(employee_code, company_name, employee_name, pan_no, date_of_birth, designation, gender, joining_date, from_date, to_date, resign_date, period, salary, bonus, leave_count, interest, full_final_bonus, full_final_leave, incentive, previous_salary, performance, total_a, conveyance, hra, medical_allw, mealcard, education_allw, lta, ptax, uniform_allw, other_allw, total_b, houseloan_interest, other_income, final_houseloan_interest, total_c, lic, epf, ppf, nsc, mf, tuition_fees, houseloan_principal, stamp_duty, tax_saver_deposite, other, total_d, total_80c, nps, rgess, total_e, mediclaim, donation, final_donation, edu_loan_interest, total_f, a10, total_g, tax, tax_remit, total_tax, edu_cess, total_h, tax_payable, previous_tax_paid, tax_paid, april, may, june, july, august, september, october, november, december, january, february, march, monthBean, yearBean);
			boolean result = tdsInsertDAO.tdsPayrollMsaterDataInsert(tdsPayrollMasterDataBean);
		}
	}
}
