/*
Name : Bhoomi Patel
Action : Employee's Family Detail Insert  */

package com.hrms.pms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.FamilyDetailBean;
import com.hrms.pms.bean.FamilyRelationBean;
import com.hrms.pms.dao.AllInsertDAO;

/**
 * Servlet implementation class FamilyDetailInsertServlet
 */
public class FamilyDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			int employee_master_id = (Integer)request.getAttribute("employee_master_id");
			String[] name = request.getParameterValues("name");
			String[] relation = request.getParameterValues("relation");
			String[] dob = request.getParameterValues("dob");  
			String[] occupation = request.getParameterValues("occupation");
			String[] contact_number = request.getParameterValues("contact_number");
			String[] adhaar_number = request.getParameterValues("adhaar_number");
			
			
			FamilyRelationBean familyRelationBean = new FamilyRelationBean();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			System.out.println(employee_master_id);
			
			
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
				System.out.println(relation[i]);
				System.out.println(dob[i]);
				System.out.println(occupation[i]);
				System.out.println(contact_number[i]);
				System.out.println(adhaar_number[i]);
				
				familyRelationBean.setFamily_relation_id(Integer.parseInt(relation[i]));
				
				if(!name[i].equalsIgnoreCase("")){
					FamilyDetailBean familyDetailBean = new FamilyDetailBean(name[i],Integer.parseInt(relation[i]), dob[i], occupation[i], contact_number[i], adhaar_number[i], employeeBean, familyRelationBean);
					boolean result = allInsertDAO.familyDetailInsert(familyDetailBean);    //Insert Method 
					System.out.println("Inserted....");
			}
			}
			
			
			
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}

