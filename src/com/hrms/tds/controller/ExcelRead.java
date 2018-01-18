package com.hrms.tds.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.tds.bean.TDSPayrollBean;
import com.hrms.tds.bean.TDSPayrollSalaryDataBean;
import com.hrms.tds.dao.TDSInsertDAO;
import com.hrms.tds.dao.TDSListDAO;
import com.hrms.tds.dao.TDSUpdateDAO;

public class ExcelRead {
	
	public void readData(String filename, MonthBean monthBean,YearBean yearBean) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\hrms\\upload\\TDSSalaryData\\"+filename);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		Row row;
		
		for(int i = 1; i<=sheet.getLastRowNum();i++)
		{
			row = (Row) sheet.getRow(i);
			
			String employeeCode;
			int employee_code = 0;
			if(row.getCell(0) == null) {
				employeeCode = "0";
			}
			else
			{
				employeeCode = new DataFormatter().formatCellValue(row.getCell(0));
				employee_code = Integer.parseInt(employeeCode);
				System.out.print(employeeCode + "\t");
			}
			
			String employeeName;
			if(row.getCell(1) == null) {
				employeeName = "-";
			}
			else
			{
				employeeName = row.getCell(1).toString();
				System.out.print(employeeName + "\t");
			}
			
			String companyName;
			if(row.getCell(2) == null) {
				companyName = "-";
			}
			else
			{
				companyName = row.getCell(2).toString();
				System.out.print(companyName + "\t");
			}
			
			double basicSalary;
			if(row.getCell(3) == null) {
				basicSalary = 0.0;
			}
			else
			{
				basicSalary = Double.parseDouble(row.getCell(3).toString());
				System.out.print(basicSalary + "\t");
			}
			
			double hra;
			if(row.getCell(4) == null) {
				hra = 0.0;
			}
			else
			{
				hra = Double.parseDouble(row.getCell(4).toString());
				System.out.print(hra + "\t");
			}
			
			double conveyance;
			if(row.getCell(5) == null) {
				conveyance = 0.0;
			}
			else
			{
				conveyance = Double.parseDouble(row.getCell(5).toString());
				System.out.print(conveyance + "\t");
			}
			
			double ltc;
			if(row.getCell(6) == null) {
				ltc = 0.0;
			}
			else
			{
				ltc = Double.parseDouble(row.getCell(6).toString());
				System.out.print(ltc + "\t");
			}
			
			double medical;
			if(row.getCell(7) == null) {
				medical = 0.0;
			}
			else
			{
				medical = Double.parseDouble(row.getCell(7).toString());
				System.out.print(medical + "\t");
			}
			
			double uniformAllw;
			if(row.getCell(8) == null) {
				uniformAllw = 0.0;
			}
			else
			{
				uniformAllw = Double.parseDouble(row.getCell(8).toString());
				System.out.print(uniformAllw + "\t");
			}
			
			double educationAllw;
			if(row.getCell(9) == null) {
				educationAllw = 0.0;
			}
			else
			{
				educationAllw = Double.parseDouble(row.getCell(9).toString());
				System.out.print(educationAllw + "\t");
			}
			
			double otherAllw;
			if(row.getCell(10) == null) {
				otherAllw = 0.0;
			}
			else
			{
				otherAllw = Double.parseDouble(row.getCell(10).toString());
				System.out.print(otherAllw + "\t");
			}
			
			double adhocAllw;
			if(row.getCell(11) == null) {
				adhocAllw = 0.0;
			}
			else
			{
				adhocAllw = Double.parseDouble(row.getCell(11).toString());
				System.out.print(adhocAllw + "\t");
			}
			
			double incentive;
			if(row.getCell(12) == null) {
				incentive = 0.0;
			}
			else
			{
				incentive = Double.parseDouble(row.getCell(12).toString());
				System.out.print(incentive + "\t");
			}
			
			double salary;
			if(row.getCell(13) == null) {
				salary = 0.0;
			}
			else
			{
				salary = Double.parseDouble(row.getCell(13).toString());
				System.out.print(salary + "\t");
			}
			
			double previousSalary;
			if(row.getCell(14) == null) {
				previousSalary = 0.0;
			}
			else
			{
				previousSalary = Double.parseDouble(row.getCell(14).toString());
				System.out.print(previousSalary + "\t");
			}
			
			double performancePay;
			if(row.getCell(15) == null) {
				performancePay = 0.0;
			}
			else
			{
				performancePay = Double.parseDouble(row.getCell(15).toString());
				System.out.print(performancePay + "\t");
			}
			
			double ptax;
			if(row.getCell(16) == null) {
				ptax = 0.0;
			}
			else
			{
				ptax = Double.parseDouble(row.getCell(16).toString());
				System.out.print(ptax + "\t");
			}
			
			double pf;
			if(row.getCell(17) == null) {
				pf = 0.0;
			}
			else
			{
				pf = Double.parseDouble(row.getCell(17).toString());
				System.out.print(pf + "\t");
			}
			
			double leave;
			if(row.getCell(18) == null) {
				leave = 0.0;
			}
			else
			{
				leave = Double.parseDouble(row.getCell(18).toString());
				System.out.print(leave + "\t");
			}
			
			String date;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy");
			if(row.getCell(19) == null) {
				date = "";
			}
			else
			{
				date = row.getCell(19).toString();
				try {
					Date d1 = formater.parse(date);
					date = format.format(d1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(date + "\t");
			}
			
			TDSInsertDAO tdsInsertDAO = new TDSInsertDAO();
			TDSListDAO tdsListDAO = new TDSListDAO();
			TDSUpdateDAO updateDAO = new TDSUpdateDAO();
			
			List<TDSPayrollSalaryDataBean> salaryList = tdsListDAO.getTDSPayrollSalaryDataByEmpCode(employee_code, companyName);
			System.err.println(salaryList.size());
			System.out.println(date);
			System.out.println("Akash:"+leave);
			
			System.out.println("------------------------------------------------------------------");
			
			if(salaryList.size() != 0) {
				System.out.println("Update");
				updateDAO.tdsPayrollSalaryDataUpdate(employee_code, companyName, basicSalary, incentive, previousSalary, performancePay, conveyance, hra, medical, ltc, ptax, pf, uniformAllw, educationAllw, otherAllw, adhocAllw, salary, leave);
			}else {
				System.out.println("insert");
				TDSPayrollSalaryDataBean tdsPayrollSalaryDataBean = new TDSPayrollSalaryDataBean(employee_code, employeeName, companyName, date, basicSalary, incentive, previousSalary, performancePay, conveyance, hra, medical, ltc, ptax, pf, uniformAllw, educationAllw, otherAllw, adhocAllw,salary, leave);
				boolean result = tdsInsertDAO.tdsPayrollSalaryDataInsert(tdsPayrollSalaryDataBean);
			
			}
			
			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd"); 
			String current_date = "";
			Date d = new Date();
			current_date = YYYYMMDD.format(d);
			
			TDSPayrollBean tdsPayroll = new TDSPayrollBean(companyName, employee_code, current_date, basicSalary, incentive, previousSalary, performancePay, conveyance, hra, medical, ltc, ptax, pf, uniformAllw, educationAllw, otherAllw, adhocAllw, salary, leave, monthBean, yearBean);
			boolean tdsPayroll1 = tdsInsertDAO.tdsPayrollInsert(tdsPayroll);
			
		}
	}
}


/*FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

for(Row row : sheet) {
	for(Cell cell : row) {
		switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			System.out.print(cell.getNumericCellValue() + "\t");
			break;

		case Cell.CELL_TYPE_STRING:
			System.out.print(cell.getStringCellValue() + "\t");
			break;
		}
	}
	System.out.println();
}*/
