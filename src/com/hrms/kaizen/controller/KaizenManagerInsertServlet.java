package com.hrms.kaizen.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class KaizenManagerInsertServlet
 */
public class KaizenManagerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			 List<FileItem> items = null;
				String fieldName = null;
				String fieldValue = null;
				String kaizen_name = "null";
				String description = null;
				String implementation_cost = null;
				String time_saving = "null";
				String money_saving = "null";
				String effort_saving = "null";
				String existing_problem = "null";
				String safety_features = "null";
				String status = "pending";
				String affecting_department = null;
				int memberCount = 0;
				int kaizen_id = 0;
				boolean rejectionflag = false;
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				
				
				
				EmployeeBean employeeBean = new EmployeeBean();
				
				
				AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
				KaizenBean kaizenBean = new KaizenBean();
				
						
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							if (fieldName.equalsIgnoreCase("kaizen_id")) {
								kaizen_id =  Integer.parseInt(fieldValue);
								System.out.println("kaizen_id:"+kaizen_id);
								kaizenBean.setKaizen_id(kaizen_id);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("mngEmployee")) 
							{
								
									
								int value = Integer.parseInt(fieldValue);
								employeeBean.setEmployee_master_id(value);
								KaizenManagerBean kaizenManagerBean = new KaizenManagerBean(status, employeeBean, kaizenBean);
								
								boolean result = allKaizenInsertDAO.kaizenManagerInsert(kaizenManagerBean);
								
								
							}	
							
							if (fieldName.equalsIgnoreCase("reject")) 
							{
								
									
								rejectionflag = true;
								
								
							}
							
							
							
							if (fieldName.equalsIgnoreCase("redirection")) {
								request.setAttribute("kaizen_id", kaizen_id);
								if(rejectionflag == false) {
								request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
								}else {
								request.getRequestDispatcher("kaizenRejectionUpdate.jsp").forward(request, response);
								}
							}	
							
						}
							
					}
							
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			
				}else{
					request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
	
	
	}

}
