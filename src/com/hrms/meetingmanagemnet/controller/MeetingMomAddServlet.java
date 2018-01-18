package com.hrms.meetingmanagemnet.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.meetingmanagemnet.bean.MeetingAttachmentBean;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingMOMBean;
import com.hrms.meetingmanagemnet.dao.AllInsertMeetingDAO;
import com.hrms.meetingmanagemnet.dao.AllListMeetingDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class MettingMomAddServlet
 */
public class MeetingMomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String filePath= request.getServletContext().getInitParameter("meetingAttachment");
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				response.setContentType("text/html;charset=UTF-8");
				 PrintWriter out = response.getWriter();
				
				 List<FileItem> items = null;
				 String fieldName = null;
				 String fieldValue = null;
				 String fileName = null;
				 File file = null;
				 String mom = null;
				 String attachment ="-";
				 int book_id = 0 ;
				 
				MeetingBookingDetailBean meetingBookingDetailBean = new MeetingBookingDetailBean();
				AllInsertMeetingDAO allInsertMeetingDAO = new AllInsertMeetingDAO();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							if (fieldName.equalsIgnoreCase("bookid")) {
								String value = fieldValue;
								book_id = Integer.parseInt(value);
								meetingBookingDetailBean.setMeeting_booking_detail_id(book_id);
							}
							
							
							if (fieldName.equalsIgnoreCase("mom")) {
								mom = fieldValue;
								MeetingMOMBean meetingMOMBean = new MeetingMOMBean(mom, meetingBookingDetailBean);
								allInsertMeetingDAO.bookingDescInsert(meetingMOMBean);
							}
							
							if (fieldName.equalsIgnoreCase("redirect")) {
								request.setAttribute("bookId", book_id);
								request.getRequestDispatcher("meetingFullDetail.jsp").forward(request, response);
							}
							
							
						}else{
							
							
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							fieldName = item.getFieldName();
							System.out.println("FieldName : "+fieldName);
							fileName = item.getName();
							System.out.println("File Name : "+fileName);
							
							fileName = fileName.substring(
									fileName.lastIndexOf("\\") + 1,
									fileName.length());
							System.out.println("File Name 1 : "+fileName);
							
							ServletContext context = getServletContext();
							String appPath = context.getRealPath("\\")+("WebContent\\upload");
							System.out.println("appPath : "+appPath);
							
							
							
							
							file = new File(filePath + File.separator
									+ fileName);
							System.out.println("filePath:"+file);

							try {

								if (fileName.isEmpty()) {
									
								} else{
									System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									System.out.println("photo uploaded");
										
									MeetingAttachmentBean meetingAttachmentBean = new MeetingAttachmentBean(attachment, meetingBookingDetailBean);
									allInsertMeetingDAO.bookiungAttachmentInsert(meetingAttachmentBean);

										
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							
							
						}

					}

				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			
	}else{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
		
	}
	}

}
