package com.hrms.pms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.lms.bean.LeaveBalanceCSVUploadBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EmployeeCSVUploadBean;
import com.hrms.pms.bean.EmployeeStatusBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.recruitement.bean.DepartmentDesignationBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.CompanyListDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;




public class EmployeeCSVUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeCSVUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
String uploadAttachment =(String) request.getAttribute("uploadAttachment");
		
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
						case Cell.CELL_TYPE_BLANK:
							array.add("null");
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								//System.out.print(cell.getDateCellValue() + "\t");
								array.add(format.format(cell.getDateCellValue()));
							} else {
								//System.out.print(cell.getNumericCellValue() + "\t");
								array.add(String.valueOf(cell.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							String value = cell.getStringCellValue();
							if(value.equalsIgnoreCase("null")){
								array.add("null");
							}else{
								array.add(value);
							}
							break;
						default :
							//System.out.print("AKASH");
							array.add("null");	
						
					}
					
				}
				
				System.out.println("");
				/*System.out.println(array1+""+array+""+array2);*/
				System.out.println(array);
				System.out.println(array.size());
				
				
				
				String firstName = array.get(0);
				String middleName = array.get(1);
				String lastName = array.get(2);
				String employee_code = array.get(3);
				String email_id = array.get(4);
				String company_list_id = array.get(5).toUpperCase().trim();
				String manager_status = array.get(6).toUpperCase().trim();
				String under_manager_id = array.get(7).toUpperCase().trim();
				String department_id = array.get(8).toUpperCase().trim(); 
				String salutation = array.get(9);
				String adress = array.get(10);
				String joining_date = array.get(11);
				String birth_date = array.get(12);
				String marrital_status = array.get(13).toUpperCase();
				String languages= array.get(14);
				String sub_department = array.get(15); 
				String gross_salary = array.get(16);
				String gender = array.get(17).toUpperCase();
				String blood_group = array.get(18);
				String height = array.get(19);
				String weight = array.get(20);
				String identification_marks = array.get(21);
				String digital_sign = array.get(22);
				String location = array.get(23);
				String role = array.get(24).toUpperCase();
				String resource_cost = array.get(25);
				String mob_num = array.get(26);
				String nationality = array.get(27);
				String basic_qualification = array.get(28);
				String special_qualification = array.get(29);
				String photo = array.get(30);
				String employee_status_id = array.get(31).toUpperCase();
				String plan_leave = array.get(32);
				String unplan_leave = array.get(33);
				String cO= array.get(34);
				String leave_without_pay = array.get(35);
				
				
				
				
				int manager_id = 0;
				Double pwd = new Double(employee_code);
			//	double pwd = Double.valueOf(employee_code);
				String password = Integer.toString(pwd.intValue());
				
				System.out.println("EmployeCode"+employee_code);
				System.out.println("password"+password);
				
				AllListDAO allListDAO = new AllListDAO();
				CompanyListDAO companyListDAO = new CompanyListDAO(); 
				List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment();
				List<RoleBean> listOfRole = allListDAO.getListOfRole();
				List<ManagerBean> listofManager = allListDAO.getListOfManager();
				List<EmployeeStatusBean> listofEmployeeStatus = allListDAO.getListOfEmployeeStatus();
				List<ManagerBean> listofUnderManager = allListDAO.getListOfManager();
				List<CompanyListBean> listofCompany = companyListDAO.getListOfCompanyList();
				
				if(manager_status.equalsIgnoreCase("YES")){
					String manager_name = firstName +" "+ lastName;
					ManagerBean managerBean = new ManagerBean(manager_name, employee_code);
					AllInsertDAO allInsertDAO = new AllInsertDAO();
					allInsertDAO.managerInsert(managerBean);
					manager_id = managerBean.getManager_id(); 
				}
				else{
					
					manager_id = 99;
				}
				
				
				/*employee_code = Integer.toString(employeeCode);*/
				int dept_id = 0;
				int role_id = 0;
				int under_id = 0;
				int status_id = 0;
				int com_id = 0;
				
				for(DepartmentBean d : listOfDepartment){
					if(d.getDepartment_name().toUpperCase().trim().equalsIgnoreCase(department_id)){
						dept_id = d.getDepartment_id();
					}
				}
				
				
				
				for(RoleBean r : listOfRole){
					if(r.getRole_type().toUpperCase().trim().equals(role)){
						role_id = r.getRole_id();
					}
				}
				
				
				
				for(ManagerBean u : listofUnderManager){
					if(u.getManager_name().toUpperCase().trim().equalsIgnoreCase(under_manager_id)){
						under_id = u.getManager_id();
					}
				}
				
				
				for(EmployeeStatusBean e : listofEmployeeStatus){
					if(e.getEmployee_status_name().toUpperCase().trim().equalsIgnoreCase(employee_status_id)){
						status_id = e.getEmployee_status_id();
					}
				}
				
				
				
				
				
				if(company_list_id.equalsIgnoreCase("SLT") || company_list_id.equalsIgnoreCase("SLTL") || company_list_id.equalsIgnoreCase("SL") || company_list_id.equalsIgnoreCase("SAHAJANAND LASER TECHNOLOGY LIMITED") || company_list_id.equalsIgnoreCase("SLT.")  || company_list_id.equalsIgnoreCase("SL.") )
				{
					com_id = 1; // For SAHAJANAND LASER TECHNOLOGY LIMITED
				}else if(company_list_id.equalsIgnoreCase("SS") || company_list_id.equalsIgnoreCase("SHREEJI SERVICES")){
					com_id = 2; // FOR SHREEJI SERVICES
				}else if(company_list_id.equalsIgnoreCase("S.HR") || company_list_id.equalsIgnoreCase("SHREEJI HR SOLUTION")){
					com_id = 3; // FOR SHREEJI HR SOLUTION
				}else if(company_list_id.equalsIgnoreCase("CO") || company_list_id.equalsIgnoreCase("COSMOS")){
					com_id = 4; // FOR COSMOS
				}else if(company_list_id.equalsIgnoreCase("CS") || company_list_id.equalsIgnoreCase("CS Laser LLP")){
					com_id = 5; // FOR CS Laser LLP
				}else if(company_list_id.equalsIgnoreCase("SZ") || company_list_id.equalsIgnoreCase("SEZ GANDHINAGAR")){
					com_id = 6; // FOR SEZ GANDHINAGAR
				}else if(company_list_id.equalsIgnoreCase("SHREEJI ENTERPRISE") || company_list_id.equalsIgnoreCase("SE") || company_list_id.equalsIgnoreCase("SENT")){
					com_id = 7; // FOR SHREEJI ENTERPRISE
				}else if(company_list_id.equalsIgnoreCase("O") || company_list_id.equalsIgnoreCase("APPRENTICE") || company_list_id.equalsIgnoreCase("APP")){
					com_id = 8; // FOR APPRENTICE
				}else if(company_list_id.equalsIgnoreCase("CONSULTANT") || company_list_id.equalsIgnoreCase("C")){
					com_id = 9; // FOR CONSULTANT
				}
				
				
				/*for(CompanyListBean c : listofCompany){
					if(c.getCompany_code().toUpperCase().equalsIgnoreCase(company_list_id)){
						com_id = c.getCompany_list_id();
					}
				}*/
				
				
				DepartmentBean departmentBean = new DepartmentBean();
				RoleBean roleBean = new RoleBean();
				ManagerBean managerBean = new ManagerBean();
				EmployeeStatusBean employeeStatusBean = new EmployeeStatusBean();
				CompanyListBean companyListBean = new CompanyListBean();
				departmentBean.setDepartment_id(dept_id);
				
				roleBean.setRole_id(role_id);
				managerBean.setManager_id(manager_id);
				employeeStatusBean.setEmployee_status_id(status_id);
				companyListBean.setCompany_list_id(com_id);
				
				
				List<EmployeeCSVUploadBean> listofEmployee = allListDAO.getListOfEmployee(employee_code, com_id ,mob_num);
				
			/*	System.out.println("emp_code:"+employee_code);
				Double p = Double.parseDouble(employee_code);
				System.out.println("p:"+p);
				Integer i = p.intValue();
				System.out.println("i:"+i);
				String password = i.toString();*/
				
				
				System.out.println("mob:"+mob_num);
				Double m = Double.parseDouble(mob_num);
				Integer j = m.intValue();
				String mob_num1 = String.format("%.2f",new BigDecimal(mob_num));
				System.out.println("mob:"+mob_num1);
				
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("department==>"+dept_id+"==>"+department_id);
				System.out.println("role_id==>"+role_id+"==>"+role);
				System.out.println("under_id==>"+under_id+"==>"+under_manager_id);
				System.out.println("status_id==>"+status_id+"==>"+employee_status_id);
				System.out.println("com_id==>"+com_id+"==>"+company_list_id);
				System.out.println("---------------------------------------------------------------");
				
				
				if(listofEmployee.size() == 0){
					
					/*AllInsertDAO allInsertDAO = new AllInsertDAO();
					EmployeeCSVUploadBean employeeCSVUploadBean = new EmployeeCSVUploadBean(employee_code, password, firstName, lastName, middleName, under_id, email_id, resource_cost, photo, joining_date, languages, sub_department, gross_salary, blood_group, height, weight, identification_marks, digital_sign, location, mob_num1, nationality, basic_qualification, special_qualification, marrital_status, gender, salutation, adress, birth_date, roleBean, departmentBean, managerBean, companyListBean, employeeStatusBean);
					boolean result = allInsertDAO.employeeCSVInsert(employeeCSVUploadBean);
				
					int employee_id = employeeCSVUploadBean.getEmployee_master_id();
					System.out.println("emp_id"+employee_id);
					EmployeeBean employeeBean = new EmployeeBean();
					employeeBean.setEmployee_master_id(employee_id);
					
					
					LeaveBalanceCSVUploadBean leaveBalanceCSVUploadBean = new LeaveBalanceCSVUploadBean(plan_leave, unplan_leave, cO, leave_without_pay, employeeBean);
					allInsertDAO.leaveBalanceCSVInsert(leaveBalanceCSVUploadBean);
					request.setAttribute("success", "Employee(s) Successfullly added");*/
				
				}
				else
				{
					request.setAttribute("error", "This employeecode already exists in this company");
					System.out.println("Employee already exist..");
				}
				
				array.clear();
			}
			file.close();
			
			/*request.getRequestDispatcher("employeeList.jsp").forward(request, response);*/
	} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
