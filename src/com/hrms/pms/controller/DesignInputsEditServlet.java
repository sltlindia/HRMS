package com.hrms.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.bean.DesignInputsBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class DesignInputsEditServlet
 */
public class DesignInputsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		int project_id = 0;
		String design_inputs_name = null;
		String remarks = null;
		int emp_id = 0;
		int projHeadId = 0;
		int projBodyId = 0;
		String designName = null;
		String date = null;
		String time = null;
		
		String headCol="-", headCol1 = "-",headCol2 = "-",headCol3 = "-",headCol4 = "-",headCol5 = "-",headCol6 = "-",headCol7 = "-",headCol8 = "-",headCol9 = "-",headCol10 = "-",
				headCol11 = "-",headCol12 = "-",headCol13 = "-",headCol14 = "-",headCol15 = "-",headCol16 = "-",headCol17 = "-",headCol18 = "-",headCol19 = "-",headCol20 = "-";
		
		String remarks1 = "-",remarks2 = "-",remarks3 = "-",remarks4 = "-",remarks5 = "-",remarks6 = "-",remarks7 = "-",remarks8 = "-",remarks9 = "-",remarks10 = "-",
				remarks11 = "-",remarks12 = "-",remarks13 = "-",remarks14 = "-",remarks15 = "-",remarks16 = "-",remarks17 = "-",remarks18 = "-",remarks19 = "-",remarks20 = "-";
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		DesignInputsBean designInputsBean = new DesignInputsBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					
					if (fieldName.equalsIgnoreCase("project_id")) {
						String value = fieldValue;
						project_id = Integer.parseInt(value);
						System.out.println("project_id:"+project_id);
						
						projectMasterBean.setProject_master_id(project_id);
					}
					
					if (fieldName.equalsIgnoreCase("projHeadId")) {
						String value = fieldValue;
						projHeadId = Integer.parseInt(value);
						System.out.println("projHeadId:"+projHeadId);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("time")) {
						time = fieldValue;
						System.out.println("time:"+time);
						
					}
					
					if (fieldName.equalsIgnoreCase("date")) {
						date = fieldValue+" "+time;
						System.out.println("date:"+date);
					}
					
					if (fieldName.equalsIgnoreCase("designName")) {
						designName = fieldValue;
						System.out.println("designName:"+designName);
					}
					
					if (fieldName.equalsIgnoreCase("headCol")) {
						headCol = fieldValue;
						System.out.println("headCol:"+headCol);
					}
					
					if (fieldName.equalsIgnoreCase("headCol1")) {
						headCol1 = fieldValue;
						System.out.println("headCol1:"+headCol1);
					}
					
					if (fieldName.equalsIgnoreCase("headCol2")) {
						headCol2 = fieldValue;
						System.out.println("headCol2:"+headCol2);
					}
					
					if (fieldName.equalsIgnoreCase("headCol3")) {
						headCol3 = fieldValue;
						System.out.println("headCol3:"+headCol3);
					}
					
					if (fieldName.equalsIgnoreCase("headCol4")) {
						headCol4 = fieldValue;
						System.out.println("headCol4:"+headCol4);
					}
					
					if (fieldName.equalsIgnoreCase("headCol5")) {
						headCol5 = fieldValue;
						System.out.println("headCol5:"+headCol5);
					}
					
					if (fieldName.equalsIgnoreCase("headCol6")) {
						headCol6 = fieldValue;
						System.out.println("headCol6:"+headCol6);
					}
					
					if (fieldName.equalsIgnoreCase("headCol7")) {
						headCol7 = fieldValue;
						System.out.println("headCol7:"+headCol7);
					}
					
					if (fieldName.equalsIgnoreCase("headCol8")) {
						headCol8 = fieldValue;
						System.out.println("headCol8:"+headCol8);
					}
					
					if (fieldName.equalsIgnoreCase("headCol9")) {
						headCol9 = fieldValue;
						System.out.println("headCol9:"+headCol9);
					}
					
					if (fieldName.equalsIgnoreCase("headCol10")) {
						headCol10 = fieldValue;
						System.out.println("headCol10:"+headCol10);
					}
					
					if (fieldName.equalsIgnoreCase("headCol11")) {
						headCol11 = fieldValue;
						System.out.println("headCol11:"+headCol11);
					}
					
					if (fieldName.equalsIgnoreCase("headCol12")) {
						headCol12 = fieldValue;
						System.out.println("headCol12:"+headCol12);
					}
					
					if (fieldName.equalsIgnoreCase("headCol13")) {
						headCol13 = fieldValue;
						System.out.println("headCol13:"+headCol13);
					}
					
					if (fieldName.equalsIgnoreCase("headCol14")) {
						headCol14 = fieldValue;
						System.out.println("headCol14:"+headCol14);
					}
					
					if (fieldName.equalsIgnoreCase("headCol15")) {
						headCol15 = fieldValue;
						System.out.println("headCol15:"+headCol15);
					}
					
					if (fieldName.equalsIgnoreCase("headCol16")) {
						headCol16 = fieldValue;
						System.out.println("headCol16:"+headCol16);
					}
					
					if (fieldName.equalsIgnoreCase("headCol17")) {
						headCol17 = fieldValue;
						System.out.println("headCol17:"+headCol17);
					}
					
					if (fieldName.equalsIgnoreCase("headCol18")) {
						headCol18 = fieldValue;
						System.out.println("headCol18:"+headCol18);
					}
					
					if (fieldName.equalsIgnoreCase("headCol19")) {
						headCol19 = fieldValue;
						System.out.println("headCol19:"+headCol19);
					}
					
					if (fieldName.equalsIgnoreCase("headCol20")) {
						headCol20 = fieldValue;
						System.out.println("headCol20:"+headCol20);
					}
					
					if (fieldName.equalsIgnoreCase("headInsert")) {
						System.out.println("insert");
						
						ProjectDesignHeadBean projectDesignHeadBean = new ProjectDesignHeadBean(projHeadId,designName, headCol, headCol1, headCol2, headCol3, headCol4, headCol5, headCol6, headCol7, headCol8, headCol9, headCol10, headCol11, headCol12, headCol13, headCol14, headCol15, headCol16, headCol17, headCol18, headCol19, headCol20, projectMasterBean, date);
						boolean result = allUpdateDAO.projInputsHeadUpdateUpdate(projectDesignHeadBean);
					}
					
					if (fieldName.equalsIgnoreCase("projBodyId")) {
						String value = fieldValue;
						projBodyId = Integer.parseInt(value);
						System.out.println("projBodyId:"+projBodyId);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("design_inputs_name")) {
						design_inputs_name = fieldValue;
						System.out.println("design_inputs_name:"+design_inputs_name);
					}
					
					
					if (fieldName.equalsIgnoreCase("remarks")) {
						remarks = fieldValue;
						System.out.println("remarks:"+remarks);
						
						
					}
					
					if (fieldName.equalsIgnoreCase("remarks1")) {
						remarks1 = fieldValue;
						System.out.println("remarks1:"+remarks1);
					}
					
					if (fieldName.equalsIgnoreCase("remarks2")) {
						remarks2 = fieldValue;
						System.out.println("remarks2:"+remarks2);
					}
					
					if (fieldName.equalsIgnoreCase("remarks3")) {
						remarks3 = fieldValue;
						System.out.println("remarks3:"+remarks3);
					}
					
					if (fieldName.equalsIgnoreCase("remarks4")) {
						remarks4 = fieldValue;
						System.out.println("remarks4:"+remarks4);
					}
					
					if (fieldName.equalsIgnoreCase("remarks5")) {
						remarks5 = fieldValue;
						System.out.println("remarks5:"+remarks5);
					}
					
					if (fieldName.equalsIgnoreCase("remarks6")) {
						remarks6 = fieldValue;
						System.out.println("remarks6:"+remarks6);
					}
					
					if (fieldName.equalsIgnoreCase("remarks7")) {
						remarks7 = fieldValue;
						System.out.println("remarks7:"+remarks7);
					}
					
					if (fieldName.equalsIgnoreCase("remarks8")) {
						remarks8 = fieldValue;
						System.out.println("remarks8:"+remarks8);
					}
					
					if (fieldName.equalsIgnoreCase("remarks9")) {
						remarks9 = fieldValue;
						System.out.println("remarks9:"+remarks9);
					}
					
					if (fieldName.equalsIgnoreCase("remarks10")) {
						remarks10 = fieldValue;
						System.out.println("remarks10:"+remarks10);
					}
					
					if (fieldName.equalsIgnoreCase("remarks11")) {
						remarks11 = fieldValue;
						System.out.println("remarks11:"+remarks11);
					}
					
					if (fieldName.equalsIgnoreCase("remarks12")) {
						remarks12 = fieldValue;
						System.out.println("remarks12:"+remarks12);
					}
					
					if (fieldName.equalsIgnoreCase("remarks13")) {
						remarks13 = fieldValue;
						System.out.println("remarks13:"+remarks13);
					}
					
					if (fieldName.equalsIgnoreCase("remarks14")) {
						remarks14 = fieldValue;
						System.out.println("remarks14:"+remarks14);
					}
					
					if (fieldName.equalsIgnoreCase("remarks15")) {
						remarks15 = fieldValue;
						System.out.println("remarks15:"+remarks15);
					}
					if (fieldName.equalsIgnoreCase("remarks16")) {
						remarks16 = fieldValue;
						System.out.println("remarks16:"+remarks16);
					}
					
					if (fieldName.equalsIgnoreCase("remarks17")) {
						remarks17 = fieldValue;
						System.out.println("remarks17:"+remarks17);
					}
					
					if (fieldName.equalsIgnoreCase("remarks18")) {
						remarks18 = fieldValue;
						System.out.println("remarks18:"+remarks18);
					}
					
					if (fieldName.equalsIgnoreCase("remarks19")) {
						remarks19 = fieldValue;
						System.out.println("remarks19:"+remarks19);
					}
					
					if (fieldName.equalsIgnoreCase("remarks20")) {
						remarks20 = fieldValue;
						System.out.println("remarks20:"+remarks20);
					}
					
					if (fieldName.equalsIgnoreCase("designInsert")) {
						System.out.println("insert");
						
						if(projBodyId != 0){
							ProjectDesignInputsBean projectDesignInputsBean = new ProjectDesignInputsBean(projBodyId, design_inputs_name, remarks, remarks1, remarks2, remarks3, remarks4, remarks5, remarks6, remarks7, remarks8, remarks9, remarks10, remarks11, remarks12, remarks13, remarks14, remarks15, remarks16, remarks17, remarks18, remarks19, remarks20, projectMasterBean, date);
							boolean result = allUpdateDAO.projInputsBodyUpdateUpdate(projectDesignInputsBean);
						}else{
						ProjectDesignInputsBean projectDesignInputsBean = new ProjectDesignInputsBean(design_inputs_name, remarks, remarks1, remarks2, remarks3, remarks4, remarks5, remarks6, remarks7, remarks8, remarks9, remarks10, remarks11, remarks12, remarks13, remarks14, remarks15, remarks16, remarks17, remarks18, remarks19, remarks20, projectMasterBean, date);
						boolean result = allInsertDAO.designInputInsert(projectDesignInputsBean);
						}
						
						projBodyId =0;
					}
					
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("creatorView", "creatorView");
						request.setAttribute("project_id", project_id);
						request.getRequestDispatcher("redirection.jsp").forward(request, response);
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


