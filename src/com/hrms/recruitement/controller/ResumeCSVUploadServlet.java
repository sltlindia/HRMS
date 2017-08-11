package com.hrms.recruitement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.ResumeDataCSVBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;




public class ResumeCSVUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResumeCSVUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date today = Calendar.getInstance().getTime();

		String date1 = dateFormat.format(today);

		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date today1 = Calendar.getInstance().getTime();

		String date2 = dateFormat1.format(today1);

		String d = null;

		try {

			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			Date result = formater.parse(date1);
			SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			d = AppDateFormat.format(result);
			System.out.println(AppDateFormat.format(result));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
			String uploadAttachment =(String) request.getAttribute("uploadAttachment");
			int vacancy_id =(Integer) request.getAttribute("vacancy_id");
			int emp_id =(Integer) request.getAttribute("emp_id");
		
		ArrayList<String> array = new ArrayList<String>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		/*double[] array1 = new double[7];
		String[] array = new String[17];
		Date[] array2 = new Date[4];*/
		
		try
		{
			FileInputStream file = new FileInputStream(new File("D:\\hrms\\upload\\CriteriaAttachment\\"+uploadAttachment));
			

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				if(row.getRowNum()==0){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								System.out.print(cell.getDateCellValue() + "\t");
								array.add(format.format(cell.getDateCellValue()));
							} else {
								System.out.print(cell.getNumericCellValue() + "\t");
								array.add(String.valueOf(cell.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							String value = cell.getStringCellValue();
							if(value.equalsIgnoreCase("null")){
								array.add("null");
							}else{
								array.add(value);
							}
							break;
						case Cell.CELL_TYPE_BLANK:
							array.add("null");
					}
					
				}
				System.out.println("");
				/*System.out.println(array1+""+array+""+array2);*/
				System.out.println(array);
				System.out.println(array.size());
				
				
				
				String name = array.get(0);
				String gender = array.get(1);
				String date_of_birth = array.get(2);
				String residing_country = array.get(3);
				String current_location = array.get(4);
				String current_contact_no = array.get(5);
				String email = array.get(6);
				String educational_qualification = array.get(7);
				String specialization = array.get(8); 
				String experience = array.get(9);
				String current_company_name = array.get(10);
				String functional_area_applying_for = array.get(11);
				String role_as = array.get(12);
				String current_functional_area = array.get(13);
				String current_role = array.get(14);
				String key_skills = array.get(15); 
				String ex_employee = array.get(16);
				String employee_code = array.get(17);
				String expected_salary = array.get(18);
				String current_salary = array.get(19);
				String notice_period = array.get(20);
				String submission_date = date2;
				String reply_date = "null";
				String speciality = array.get(21);
				String source_of_resume_id = array.get(22).toUpperCase();
				String graduate_qualification = array.get(23);
				String post_graduate_qualification = array.get(24);
				String phd_qualification = array.get(25);
				
				String status = "pending";
				String upload_resume = "null";
				
				AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
				List<SourceOfResumeBean> listOfSource = allRecruitmentListDAO.getListOfAllRecruiter();
				
				int source_id = 0;
				
				for(SourceOfResumeBean s : listOfSource){
					if(s.getSource_of_resume_name().toUpperCase().equalsIgnoreCase(source_of_resume_id)){
						source_id = s.getSource_of_resume_id();
					}
				}
				
				System.out.println("source"+source_id);
				
				VacancyFormBean vacancyFormBean = new VacancyFormBean();
				vacancyFormBean.setVacancy_id(vacancy_id);
				
				SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
				sourceOfResumeBean.setSource_of_resume_id(source_id);
				
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setEmployee_master_id(emp_id);
				
				
				
				
					AllInsertDAO allInsertDAO = new AllInsertDAO();
					
					ResumeDataCSVBean resumeDataCSVBean = new ResumeDataCSVBean(name, gender, date_of_birth, 
							residing_country, current_location, current_contact_no, email, educational_qualification,
							specialization, experience, current_company_name, functional_area_applying_for, role_as,
							current_functional_area, current_role, key_skills, upload_resume, status, ex_employee,
							employee_code, expected_salary, current_salary, notice_period, submission_date, reply_date,
							speciality, graduate_qualification, post_graduate_qualification, phd_qualification, 
							vacancyFormBean, sourceOfResumeBean, employeeBean);
					
				boolean result =	allInsertDAO.resumedataInsert(resumeDataCSVBean);
					
					
					request.setAttribute("success", "Resume(s) Successfullly inserted");
				
				array.clear();
			}
			file.close();
			
			request.getRequestDispatcher("myVacancyAllocation.jsp").forward(request, response);
			/*request.getRequestDispatcher("employeeList.jsp").forward(request, response);*/
	} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
