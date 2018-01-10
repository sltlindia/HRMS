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
			String employeeCode = "-";
			int employee_code = 0;
			String employeeName = "-";
			String companyName = "-";
			double basicSalary = 0.0;
			double hra = 0.0;
			double conveyance = 0.0;
			double medical = 0.0;
			double uniformAllw = 0.0;
			double educationAllw = 0.0;
			double annual_basicSalary = 0.0;
			double annual_hra = 0.0;
			double annual_conveyance = 0.0;
			double annual_medical = 0.0;
			double annual_uniformAllw = 0.0;
			double annual_educationAllw = 0.0;
			
			try {
				employeeCode = new DataFormatter().formatCellValue(row.getCell(0));
				employee_code = Integer.parseInt(employeeCode);
				System.out.print(employeeCode + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				employeeName = row.getCell(1).toString();
				System.out.print(employeeName + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				companyName = row.getCell(2).toString();
				System.out.print(companyName + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				basicSalary = Double.parseDouble(row.getCell(3).toString());
				System.out.print(basicSalary + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_basicSalary = Double.parseDouble(row.getCell(4).toString());
				System.out.print(annual_basicSalary + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				hra = Double.parseDouble(row.getCell(5).toString());
				System.out.print(hra + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_hra = Double.parseDouble(row.getCell(6).toString());
				System.out.print(annual_hra + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				conveyance = Double.parseDouble(row.getCell(7).toString());
				System.out.print(conveyance + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_conveyance = Double.parseDouble(row.getCell(8).toString());
				System.out.print(annual_conveyance + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				medical = Double.parseDouble(row.getCell(9).toString());
				System.out.print(medical + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_medical = Double.parseDouble(row.getCell(10).toString());
				System.out.print(annual_medical + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				educationAllw = Double.parseDouble(row.getCell(11).toString());
				System.out.print(educationAllw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_educationAllw = Double.parseDouble(row.getCell(12).toString());
				System.out.print(annual_educationAllw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				uniformAllw = Double.parseDouble(row.getCell(13).toString());
				System.out.print(uniformAllw + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			try {
				annual_uniformAllw = Double.parseDouble(row.getCell(14).toString());
				System.out.print(basicSalary + "\t");
			} catch (NullPointerException e) {} catch (NumberFormatException e) {}
			
			TDSInsertDAO tdsInsertDAO = new TDSInsertDAO();
			TDSListDAO tdsListDAO = new TDSListDAO();
			TDSUpdateDAO updateDAO = new TDSUpdateDAO();
			
			List<TDSPayrollSalaryDataBean> salaryList = tdsListDAO.getTDSPayrollSalaryDataByEmpCode(employee_code, companyName);
			System.err.println(salaryList.size());
			
			System.out.println("------------------------------------------------------------------");
			
			if(salaryList.size() != 0) {
				System.out.println("Update");
				updateDAO.tdsPayrollSalaryDataUpdate(employee_code, companyName, basicSalary, hra, conveyance, medical, educationAllw, uniformAllw);
			}else {
				System.out.println("insert");
				TDSPayrollSalaryDataBean tdsPayrollSalaryDataBean = new TDSPayrollSalaryDataBean(employee_code, employeeName, companyName, basicSalary, annual_basicSalary, conveyance, annual_conveyance, hra, annual_hra, medical, annual_medical, uniformAllw, annual_uniformAllw, educationAllw, annual_educationAllw, monthBean, yearBean);
				boolean result = tdsInsertDAO.tdsPayrollSalaryDataInsert(tdsPayrollSalaryDataBean);
			
			}
			
			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd"); 
			String current_date = "";
			Date d = new Date();
			current_date = YYYYMMDD.format(d);
			
			TDSPayrollBean tdsPayroll = new TDSPayrollBean(employee_code, companyName, basicSalary, annual_basicSalary, conveyance, annual_conveyance, hra, annual_hra, medical, annual_medical, uniformAllw, annual_uniformAllw, educationAllw, annual_educationAllw, monthBean, yearBean);
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
