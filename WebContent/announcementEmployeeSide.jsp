<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.selfservice.bean.RoleCategoryBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page
	import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Announcement Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Exit Interview From</title>
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<script type="text/javascript">
	function checkFile(fieldObj) {
		var FileName = fieldObj.value;
		var FileExt = FileName.substr(FileName.lastIndexOf('.') + 1);
		var FileSize = fieldObj.files[0].size;
		var FileSizeMB = (FileSize / 1048576).toFixed(2);

		if ((FileExt != "pdf" && FileExt != "doc" && FileExt != "docx"
				&& FileExt != "jpg" && FileExt != "png" && FileExt != "jpeg"
				&& FileExt != "txt" && FileExt != "ppt" && FileExt != "xml"
				&& FileExt != "xlsx" && FileExt != "xls" && FileExt != "png" && FileExt != "pptx")) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file is in pdf or doc or docx or xml or jpg or jpeg or xls or txt or png or ppt.\n\n";
			alert(error);
			fieldObj.value = "";
		} else if (FileSize > 1048576) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file size less than 1 MB.\n\n";
			alert(error);
			fieldObj.value = "";
			return false;
		}
		return true;
	}
</script>
<title>Broadcast List</title>
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<%
				if (request.getAttribute("successAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-success">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${successAnnouncement}
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("conflictAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-success">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${conflictAnnouncement}
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("deleteAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-danger">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${deleteAnnouncement}
				</div>
			</div>
			<%
				}
			%>
				<div class="row">
					<div class="col-xs-12">
						<h4>Broadcast Form</h4>
						<hr>
					</div>
				</div>
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">


								<div class="row">
									<div class="col-lg-12">
										<div class="dataTable_wrapper">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h6 align="left">Broadcast List</h6>
												</div>
												<div class="panel-body">
													<table
														class="table table-striped table-bordered table-hover"
														border="1" id="dataTables-example1">
														<thead>
															<tr>
																<th>Title</th>
																<th>Broadcast By</th>
																<th>Date Of Submission</th>
																<th>Attachment</th>
																<th>Action</th>
															</tr>
														</thead>

														<tbody>
															<%
																DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
																Date date1 = new Date();
																String currDate = dateFormat2.format(date1);
																System.out.println(dateFormat2.format(date1));
																String role_authority = user.getRoleBean().getRole_authority();
																AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
																boolean result = false;
																List<AnnouncementBean> listOfAnnouncementEndDate = allListSelfServiceDAO
																		.getListOfAnnouncementEndDate(currDate);
																for (AnnouncementBean a : listOfAnnouncementEndDate) {
																	int announcement_id = a.getAnnouncement_id();
																	boolean result1 = false;
																	List<AnnouncementCategoryBean> listOfCategory = allListSelfServiceDAO
																			.getListOfAnnouncementCategoryDetail(announcement_id);
																	for (AnnouncementCategoryBean a1 : listOfCategory) {

																		String role_category_name = a1.getRoleCategoryBean().getRole_category_name();
																		int announcementId = a1.getAnnouncementBean().getAnnouncement_id();
																		if (role_category_name.equalsIgnoreCase(role_authority)) {
																			result1 = true;
																			List<AnnouncementCategoryBean> listOfCategoryByRole = allListSelfServiceDAO
																					.getListOfAnnouncementCategoryByRole(announcementId, role_category_name);
																			for (AnnouncementCategoryBean a2 : listOfCategoryByRole) {
																				result = true;
																				String date_of_submission = a.getAnnouncement_submission_date();
																				String ds = "-";
																				Date date = new Date();
																				String end_date = a.getAnnouncement_enddate();
																				Date result3 = null;
																				try {
																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																					Date resultDate1 = formater.parse(date_of_submission);
																					ds = AppDateFormat.format(resultDate1);
																					result3 = formater.parse(end_date);
																					System.out.println("end_date " + result3);
																					System.out.println(AppDateFormat.format(resultDate1));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}
															%>
															<tr>
																<td><%=a.getAnnouncement_title()%></td>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																<td><%=ds%></td>
																<td>
																	<%
																		String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																						if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
																		src="upload/IconsOfMSOffice/<%=ext2%>.png"
																		height="50px" width="50px" data-toggle="tooltip"
																		data-placement="top"
																		title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
																	<%
																		} else {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																		<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
																</td>
																<td><center>
																		<a href="" data-toggle="modal"
																			data-target="#myModalView<%=a.getAnnouncement_id()%>"><i
																			class="glyphicon glyphicon-eye-open"
																			data-toggle="tooltip" data-placement="top"
																			title="View Announcmenet"></i></a>
																	</center>&nbsp;</td>

															</tr>
															<%
																}
																		}
																	}
																	int company_id = user.getCompanyListBean().getCompany_list_id();
																	List<AnnouncementCompanyBean> listOfCompany = allListSelfServiceDAO
																			.getListOfAnnouncementCompanyDetail(announcement_id);
																	if (result1 == false) {
																		for (AnnouncementCompanyBean a2 : listOfCompany) {
																			System.out.println("result1" + result1);
																			int companyId = a2.getCompanyListBean().getCompany_list_id();
																			int announcementId1 = a2.getAnnouncementBean().getAnnouncement_id();
																			if (companyId == company_id) {
																				result = true;
																				System.out.println(result);
																				String date_of_submission = a.getAnnouncement_submission_date();
																				String ds = "-";
																				Date date = new Date();
																				String end_date = a.getAnnouncement_enddate();
																				Date result3 = null;
																				try {
																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																					Date resultDate2 = formater.parse(date_of_submission);
																					ds = AppDateFormat.format(resultDate2);
																					result3 = formater.parse(end_date);
																					System.out.println("end_date " + result3);
																					System.out.println(AppDateFormat.format(resultDate2));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}
															%>
															<tr>
																<td><%=a.getAnnouncement_title()%></td>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																<td><%=ds%></td>
																<td>
																	<%
																		String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																						if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
																		src="upload/IconsOfMSOffice/<%=ext2%>.png"
																		height="50px" width="50px" data-toggle="tooltip"
																		data-placement="top"
																		title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
																	<%
																		} else {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																		<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
																</td>
																<td><center>
																		<a href="" data-toggle="modal"
																			data-target="#myModalView<%=a.getAnnouncement_id()%>"><i
																			class="glyphicon glyphicon-eye-open"
																			data-toggle="tooltip" data-placement="top"
																			title="View Announcmenet"></i></a>
																	</center>&nbsp;</td>

															</tr>
															<%
																}
																		}
																	}
																	int department_id = user.getDepartmentBean().getDepartment_id();
																	List<AnnouncementDepartmentBean> listOfDepartment = allListSelfServiceDAO
																			.getListOfAnnouncementDepartmentDetail(announcement_id);
																	if (result1 == false) {
																		for (AnnouncementDepartmentBean a3 : listOfDepartment) {
																			int departmentId = a3.getDepartmentBean().getDepartment_id();
																			int announcementId2 = a3.getAnnouncementBean().getAnnouncement_id();
																			if (departmentId == department_id) {
																				System.out.println(result);
																				String date_of_submission = a.getAnnouncement_submission_date();
																				String ds = "-";
																				Date date = new Date();
																				String end_date = a.getAnnouncement_enddate();
																				Date result3 = null;
																				try {
																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																					Date resultDate3 = formater.parse(date_of_submission);
																					ds = AppDateFormat.format(resultDate3);
																					result3 = formater.parse(end_date);
																					System.out.println("end_date " + result3);
																					System.out.println(AppDateFormat.format(resultDate3));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}
															%>
															<tr>
																<td><%=a.getAnnouncement_title()%></td>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																<td><%=ds%></td>
																<td>
																	<%
																		String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																						if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
																		src="upload/IconsOfMSOffice/<%=ext2%>.png"
																		height="50px" width="50px" data-toggle="tooltip"
																		data-placement="top"
																		title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
																	<%
																		} else {
																	%> <a
																	href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																		<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
																</td>
																<td><center>
																		<a href="" data-toggle="modal"
																			data-target="#myModalView<%=a.getAnnouncement_id()%>"><i
																			class="glyphicon glyphicon-eye-open"
																			data-toggle="tooltip" data-placement="top"
																			title="View Announcmenet"></i></a>
																	</center>&nbsp;</td>

															</tr>
															<%
																}
																		}
																	}
																}
															%>
														</tbody>
													</table>
													<%
														for (AnnouncementBean a : listOfAnnouncementEndDate) {
													%>
													<div class="modal fade"
														id="myModalView<%=a.getAnnouncement_id()%>" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<%
															int announcement_id = a.getAnnouncement_id();
														%>
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h4 class="modal-title" id="myModalLabel"></h4>
																</div>
																<table class="table">
																	<tr>
																		<td width="25%"><label>&nbsp;Title</label></td>
																		<td>:</td>
																		<td><%=a.getAnnouncement_title()%></td>
																	</tr>
																	<tr>
																		<td style="white-space: pre-wrap;"><label>&nbsp;Description</label></td>
																		<td>:</td>
																		<td><%=a.getAnnouncement_description()%></td>
																	</tr>
																	<%
																		if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																	%>
																	<tr>
																		<td><label>&nbsp;Attachment</label></td>
																		<td>:</td>
																		<td>
																			<%
																				String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																						if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																			%> <a
																			href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
																				src="upload/IconsOfMSOffice/<%=ext2%>.png"
																				height="50px" width="50px" data-toggle="tooltip"
																				data-placement="top"
																				title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
																			<%
																				} else {
																			%> <a
																			href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																				<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
																		</td>
																	</tr>
																	<%
																		}
																	%>
																	<%
																		String ds = a.getAnnouncement_submission_date();
																			String de = a.getAnnouncement_enddate();
																			String ad = a.getAnnouncment_date();
																			try {
																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																				Date result1 = formater.parse(ds);
																				Date result2 = formater.parse(de);
																				Date result3 = formater.parse(ad);
																				ds = AppDateFormat.format(result1);
																				de = AppDateFormat.format(result2);
																				ad = AppDateFormat.format(result3);

																				System.out.println(AppDateFormat.format(result1));
																				System.out.println(AppDateFormat.format(result2));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}
																	%>
																	<%-- <tr>
															<td><label>&nbsp;Date Of Submission</label></td>
															<td>:</td>
															<td><%=ds%></td>
														</tr> --%>
																	<tr>
																		<td><label>&nbsp;Announcement Date</label></td>
																		<td>:</td>
																		<td><%=ad%></td>
																	</tr>

																	<tr>
																		<td><label>&nbsp;End Date Of Broadcast</label></td>
																		<td>:</td>
																		<td><%=de%></td>
																	</tr>
																	<%
																		if (!a.getFrom_time().equalsIgnoreCase("00:00:00")) {
																	%>
																	<tr>
																		<td><label>&nbsp;From Time</label></td>
																		<td>:</td>
																		<td><%=a.getFrom_time()%></td>
																	</tr>
																	<%
																		}
																	%>
																	<%
																		if (!a.getTo_time().equalsIgnoreCase("00:00:00")) {
																	%>
																	<tr>
																		<td><label>&nbsp;To Time</label></td>
																		<td>:</td>
																		<td><%=a.getTo_time()%></td>
																	</tr>
																	<%
																		}
																	%>
																	<%-- <tr>
															<td><label>&nbsp;Category </label></td>
															<td>:</td>
															<%
																List<AnnouncementCategoryBean> listOfCategoryDetail = allListSelfServiceDAO
																			.getListOfAnnouncementCategoryDetail(announcement_id);
																	if (listOfCategoryDetail.size() != 0) {
															%>
															<td>
																<%
																	for (AnnouncementCategoryBean a1 : listOfCategoryDetail) {
																%> <%=a1.getRoleCategoryBean().getRole_category_name()%>,<%
 	}
 %>
															</td>
															<%
																} else {
															%>
															<td>No Category</td>
															<%
																}
															%>
														</tr>
														<tr>
															<td><label>&nbsp;Department </label></td>
															<td>:</td>
															<%
																List<AnnouncementDepartmentBean> listOfDeparmentDetail = allListSelfServiceDAO
																			.getListOfAnnouncementDepartmentDetail(announcement_id);
																	if (listOfDeparmentDetail.size() != 0) {
															%>

															<td>
																<%
																	for (AnnouncementDepartmentBean a1 : listOfDeparmentDetail) {
																%> <%=a1.getDepartmentBean().getDepartment_name()%>,<%
 	}
 %>
															</td>
															<%
																} else {
															%>
															<td>No Department</td>
															<%
																}
															%>
														</tr>
														<tr>
															<td><label>&nbsp;Company </label></td>
															<td>:</td>
															<%
																List<AnnouncementCompanyBean> listOfCompanyDetail = allListSelfServiceDAO
																			.getListOfAnnouncementCompanyDetail(announcement_id);
																	if (listOfCompanyDetail.size() != 0) {
															%>
															<td>
																<%
																	for (AnnouncementCompanyBean a1 : listOfCompanyDetail) {
																%> <%=a1.getCompanyListBean().getCompany_name()%>,<%
 	}
 %>
															</td>
															<%
																} else {
															%>
															<td>No Company</td>
															<%
																}
															%>

														</tr> --%>
																	<tr>
																		<td><label>&nbsp;Broadcast Done By</label></td>
																		<td>:</td>
																		<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																	</tr>

																</table>


																<input type="hidden" name="redirect">
																<div class="modal-footer">
																	<button type="button" class="btn btn-danger"
																		data-dismiss="modal">CLOSE</button>
																</div>
															</div>
															</form>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->



													</div>
													<%
														}
													%>

													</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
									<!-- /.panel -->
								</div>

							</div>
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div>

	<%@include file="footer.html"%>

	<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script
		src="app-assets/vendors/js/pickers/dateTime/moment-with-locales.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.date.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.time.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/legacy.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/pickers/daterange/daterangepicker.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js"
		type="text/javascript"></script>

	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<!-- END PAGE LEVEL JS-->
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true,
				"bSort" : false
			});
			$('#dataTables-example1').DataTable({
				responsive : true,
				"bSort" : false
			});
			$('#dataTables-example2').DataTable({
				responsive : true,
				"bSort" : false
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>