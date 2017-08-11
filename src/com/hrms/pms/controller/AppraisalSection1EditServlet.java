package com.hrms.pms.controller;

import java.io.File;
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

import com.hrms.pms.bean.Appraisal5sBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.AppraisalKizenBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalTrainingBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.QuterlyMonthBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class AppraisalSection1EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String fileName = null;
		File file = null;
		int appraisal_id = 0;
		double leave = 0;
		int aLeave_id = 0;
		int lateComing = 0;
		int attendanceGrade = 0;
		int totalKaizen = 0;
		int aKizen_id = 0;
		int approvedKaizen = 0;
		String remarkKizen = null;
		int kaizenGrade = 0;
		int qid = 0;
		int qScore = 0;
		String qRemarks = null;
		String tTopic = null;
		String tFaculty = null;
		String tDate = null;
		String tTrainingRemark = null;
		int qGrade = 0;
		int tHrs = 0;
		int a5s_id = 0;
		int atraining_id = 0;

		AppraisalBean appraisalBean = new AppraisalBean();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("appraisal_id")) {
						String value = fieldValue;
						appraisal_id = Integer.parseInt(value);
						System.out.println("appraisal_id:"+appraisal_id);
						appraisalBean.setAppraisal_id(appraisal_id);
					}
					
					if (fieldName.equalsIgnoreCase("aLeave_id")) {
						String value = fieldValue;
						aLeave_id = Integer.parseInt(value);
						System.out.println("aLeave_id:"+aLeave_id);
					}
					
					if (fieldName.equalsIgnoreCase("leave")) {
						String value = fieldValue;
						leave = Double.parseDouble(value);
						System.out.println("leave:"+leave);
					}
					
					
					if (fieldName.equalsIgnoreCase("lateComing")) {
						String value = fieldValue;
						lateComing = Integer.parseInt(value);
						System.out.println("lateComing:"+lateComing);
					}
					
					if (fieldName.equalsIgnoreCase("attendanceGrade")) {
						String value = fieldValue;
						attendanceGrade = Integer.parseInt(value);
						System.out.println("attendanceGrade:"+attendanceGrade);
						
						AppraisalGradeBean appraisalGradeBean = new AppraisalGradeBean();
						appraisalGradeBean.setAppraisal_grade_id(attendanceGrade);
						
						AppraisalLeaveBean appraisalLeaveBean  = new AppraisalLeaveBean(leave, lateComing, appraisalBean, appraisalGradeBean,aLeave_id);
						boolean result = allUpdateDAO.appraisalLeaveUpdate(appraisalLeaveBean);
						
					}
					
					
					
					if (fieldName.equalsIgnoreCase("aKizen_id")) {
						String value = fieldValue;
						aKizen_id = Integer.parseInt(value);
						System.out.println("aKizen_id:"+aKizen_id);
					}
					
					if (fieldName.equalsIgnoreCase("totalKaizen")) {
						String value = fieldValue;
						totalKaizen = Integer.parseInt(value);
						System.out.println("totalKaizen:"+totalKaizen);
					}
					
					
					if (fieldName.equalsIgnoreCase("approvedKaizen")) {
						String value = fieldValue;
						approvedKaizen = Integer.parseInt(value);
						System.out.println("approvedKaizen:"+approvedKaizen);
					}
					
					if (fieldName.equalsIgnoreCase("remarkKizen")) {
						remarkKizen = fieldValue;
						System.out.println("remarkKizen:"+remarkKizen);
					}
					
					if (fieldName.equalsIgnoreCase("kaizenGrade")) {
						String value = fieldValue;
						kaizenGrade = Integer.parseInt(value);
						System.out.println("kaizenGrade:"+kaizenGrade);
						
						AppraisalGradeBean appraisalGradeBean = new AppraisalGradeBean();
						appraisalGradeBean.setAppraisal_grade_id(kaizenGrade);
						
						
						AppraisalKizenBean appraisalKizenBean = new AppraisalKizenBean(totalKaizen, approvedKaizen, remarkKizen, appraisalBean, appraisalGradeBean,aKizen_id);
						boolean result = allUpdateDAO.appraisalKaizenUpdate(appraisalKizenBean);
					}
					
					
					if (fieldName.equalsIgnoreCase("a5s_id")) {
						String value = fieldValue;
						a5s_id = Integer.parseInt(value);
						System.out.println("a5s_id:"+a5s_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("qid")) {
						String value = fieldValue;
						qid = Integer.parseInt(value);
						System.out.println("qid:"+qid);
						
					}
					
					if (fieldName.equalsIgnoreCase("qScore")) {
						String value = fieldValue;
						qScore = Integer.parseInt(value);
						System.out.println("qScore:"+qScore);
					}
					
					if (fieldName.equalsIgnoreCase("qRemarks")) {
						qRemarks = fieldValue;
						System.out.println("qRemarks:"+qRemarks);
					}
					
					if (fieldName.equalsIgnoreCase("qGrade")) {
						String value = fieldValue;
						qGrade = Integer.parseInt(value);
						System.out.println("qGrade:"+qGrade);
						
						AppraisalGradeBean appraisalGradeBean = new AppraisalGradeBean();
						QuterlyMonthBean quterlyMonthBean = new QuterlyMonthBean();
						appraisalGradeBean.setAppraisal_grade_id(qGrade);
						quterlyMonthBean.setQuarterly_month_id(qid);
						
						Appraisal5sBean appraisal5sBean = new Appraisal5sBean(qScore, qRemarks, appraisalBean, appraisalGradeBean, quterlyMonthBean,a5s_id);
						boolean result = allUpdateDAO.appraisal5sUpdate(appraisal5sBean);
						
					}
					
					if (fieldName.equalsIgnoreCase("atraining_id")) {
						String value = fieldValue;
						atraining_id = Integer.parseInt(value);
						System.out.println("atraining_id:"+atraining_id);
					}
					
					if (fieldName.equalsIgnoreCase("tTopic")) {
						tTopic = fieldValue;
						System.out.println("tTopic:"+tTopic);
					}
					
					if (fieldName.equalsIgnoreCase("tFaculty")) {
						tFaculty = fieldValue;
						System.out.println("tFaculty:"+tFaculty);
					}
					
					if (fieldName.equalsIgnoreCase("tDate")) {
						tDate = fieldValue;
						System.out.println("tDate:"+tDate);
					}
					
					if (fieldName.equalsIgnoreCase("tHrs")) {
						String value = fieldValue;
						tHrs = Integer.parseInt(value);
						System.out.println("tHrs:"+tHrs);
					}
					
					if (fieldName.equalsIgnoreCase("tTrainingRemark")) {
						tTrainingRemark = fieldValue;
						System.out.println("tTrainingRemark:"+tTrainingRemark);
						
							if(!tTopic.equalsIgnoreCase("")){
							AppraisalTrainingBean appraisalTrainingBean = new AppraisalTrainingBean(tTopic, tFaculty, tDate, tHrs, tTrainingRemark, appraisalBean,atraining_id);
							boolean result = allUpdateDAO.appraisalTrainingUpdate(appraisalTrainingBean);
						}	
					}
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("appraisal_id", appraisal_id);
						AllListDAO allListDAO = new AllListDAO();
						List<AppraisalCriteriaGradeBean> listAppraisalCriteriaGrade = allListDAO.getappraisalGradeCriteria(appraisal_id);
						if(listAppraisalCriteriaGrade.size() != 0){
							request.getRequestDispatcher("blueCollarEditSection2.jsp").forward(request, response);	
						}
						else{
							request.getRequestDispatcher("blueCollarAppraisalSection2.jsp").forward(request, response);
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
