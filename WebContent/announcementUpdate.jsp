<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
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
<title>Broadcast List</title>
<%@include file="header.jsp"%>
<script type="text/javascript" src="css/TimerPicker/jquery.min.js"></script>
<script type="text/javascript" src="css/TimerPicker/jquery-ui.min.js"></script>
<link href="css/TimerPicker/jquery-ui.css" rel="stylesheet">

<link href="css/timepicki.css" rel="stylesheet">

<style type="text/css">
.timepicker_wrap {
	padding: 10px;
	border-radius: 5px;
	z-index: 998;
	display: none;
	box-shadow: 2px 2px 5px 0 rgba(50, 50, 50, 0.35);
	background: #f6f6f6;
	border: 1px solid #ccc;
	float: left;
	position: absolute;
	top: 27px;
	left: 0;
	width: 280px;
	format: 'HH:mm';
	showMeridian: false;
}
textarea{  
  /* box-sizing: padding-box; */
  overflow:hidden;
  /* demo only: */
  padding:10px;
  width:100%;
  font-size:14px;
}
</style>
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
<script type="text/javascript">
	var datefield = document.createElement("input")
	datefield.setAttribute("type", "text")
	if (datefield.type != "date") { //if browser doesn't support input type="date", load files for jQuery UI Date Picker
		document
				.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
	}
</script>
<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#announcement_enddate').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>
<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#announcement_date').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
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
					<div class="panel panel-primary">
						<div class="panel-heading">Broadcast Form</div>
						<div class="panel-body">

							<form action="announcementUpdate" method="post"
								name="announcement_form" enctype="multipart/form-data">
								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<%
											int announcement_id = Integer.parseInt(request.getParameter("announcement_id"));
										%>
										<input type="hidden" name="announcement_id"
											id="announcement_id" value="<%=announcement_id%>">

										<%
											AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
											List<AnnouncementBean> listOfAnnouncement = allListSelfServiceDAO.getListOfAnnouncement(announcement_id);
											for (AnnouncementBean a : listOfAnnouncement) {
										%>
										<input type="hidden" name="file" id="file"
											value="<%=a.getAnnouncement_attachment()%>">
										<table class="table table-stripped table-hover">
											<tr>
												<th>Title</th>
												<td>:</td>
												<td colspan="4"><input type="text" class="form-control"
													name="announcement_title" id="announcement_title" autofocus
													required="required" value="<%=a.getAnnouncement_title()%>"></td>
											</tr>
											<tr>
												<th>Description</th>
												<td>:</td>
												<td colspan="4" style="white-space: pre-wrap;"><textarea class="form-control" name="description"
														required="required"><%=a.getAnnouncement_description()%></textarea></td>
											</tr>
											<tr>
												<th>From</th>
												<td>:</td>
												<td><input type="text" id="fromTime"
													class="form-control" name="fromTime"
													value="<%=a.getFrom_time()%>" required></td>
												<!-- <th>To</th> -->
												<th>To</th>
												<td>:</td>
												<td><input type="text" id="toTime" class="form-control"
													name="toTime"
													value="<%=a.getTo_time()%>" required></td>
											</tr>
											<tr>
												<th>Broadcast Date</th>
												<td>:</td>
												<td><input type="text" class="form-control"
													name="announcement_date" id="announcement_date"
													required="required" value="<%=a.getAnnouncment_date()%>"
													onchange="ValidateDate(this.value)"></td>
												<th>Broadcast End Date</th>
												<td>:</td>
												<td colspan="4"><input type="text" class="form-control"
													name="announcement_enddate" id="announcement_enddate"
													required="required"
													value="<%=a.getAnnouncement_enddate()%>"></td>
											</tr>
											<tr>
												<th>Attachment
													<p class="help-block">(Max size 1MB)</p>
												</th>
												<td>:</td>
												<td colspan="4"><input type="file" value="Browse"
													class="form-control" name="attachment" id="attachment_id"
													value="">
													<p class="help-block">(.pdf, .doc, .docx, .jpg, .png,
														.jpeg, .txt, .ppt, .xml, .xlsx, .xls, .png, .pptx)</p> <%
 	String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

 		if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
 %> <a
													href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
														src="upload/IconsOfMSOffice/<%=ext2%>.png" height="50px"
														width="50px" data-toggle="tooltip" data-placement="top"
														title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
													<%
														} else {
													%> <a
													href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
														<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %></td>

											</tr>
											<tr>
												<th>Category</th>
												<td>:</td>
												<td colspan="4">
													<div class="form-group">
														<%
															List<RoleCategoryBean> listOfCategory = allListSelfServiceDAO.getListOfAnnouncementCategory();
																for (RoleCategoryBean r1 : listOfCategory) {
																	boolean flag = false;
																	List<AnnouncementCategoryBean> listOfCategoryDetail = allListSelfServiceDAO
																			.getListOfAnnouncementCategoryDetail(announcement_id);
																	for (AnnouncementCategoryBean a1 : listOfCategoryDetail) {
																		if (a1.getRoleCategoryBean().getRole_category_id() == r1.getRole_category_id()) {
																			flag = true;
																		}
																	}
														%>
														<%
															if (flag == true) {
														%>
														<label><input type="checkbox" name="category"
															id="category" value="<%=r1.getRole_category_id()%>"
															checked="checked">&nbsp;&nbsp;<%=r1.getRole_category_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCategory<%=r1.getRole_category_name()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp; 
														</label>
														<%
															} else {
														%>
														<label> <input type="checkbox" name="category"
															id="category" value="<%=r1.getRole_category_id()%>">&nbsp;&nbsp;<%=r1.getRole_category_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCategory<%=r1.getRole_category_name()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp; 
														</label>
														<%
															}
																}
														%>
													</div>
												</td>
											</tr>
											<tr>
												<th>Department&nbsp;<i class="fa fa-question-circle"
													data-toggle="tooltip" data-placement="top"
													title="All the team members of the specific department which you select will notify by all the details of announcement."></i></th>
												<td>:</td>
												<td colspan="4">
													<div class="form-group">
														<%
															DepartmentDAO departmentDAO = new DepartmentDAO();
																List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
																for (DepartmentBean d : listOfDepartment) {
																	if (d.getDepartment_id() != 0) {
																		boolean flag = false;
																		List<AnnouncementDepartmentBean> listOfDepartmentDetail = allListSelfServiceDAO
																				.getListOfAnnouncementDepartmentDetail(announcement_id);
																		for (AnnouncementDepartmentBean a1 : listOfDepartmentDetail) {
																			if (a1.getDepartmentBean().getDepartment_id() == d.getDepartment_id()) {
																				flag = true;
																			}
																		}
														%>
														<%
															if (flag == true) {
														%>
														<div class="col-lg-4" style="height: 25px;">
															<label><input type="checkbox" name="department"
																id="department" value="<%=d.getDepartment_id()%>"
																checked="checked">&nbsp;&nbsp;<%=d.getDepartment_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewDepartment<%=d.getDepartment_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp;</label>
														</div>
														<%
															} else {
														%>
														<div class="col-lg-4" style="height: 25px;">
															<label><input type="checkbox" name="department"
																id="department" value="<%=d.getDepartment_id()%>">&nbsp;&nbsp;<%=d.getDepartment_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewDepartment<%=d.getDepartment_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp;</label>
														</div>
														<%
															}
																	}
																}
														%>
													</div>
												</td>
											</tr>
											<tr>
												<th>Company&nbsp;<i class="fa fa-question-circle"
													data-toggle="tooltip" data-placement="top"
													title="All the employee of the specific company which you select will notify by all the details of announcement."></i></th>
												<td>:</td>
												<td colspan="4">
													<div class="form-group">
														<%
															CompanyListDAO companyListDAO = new CompanyListDAO();
																List<CompanyListBean> listOfCompany = companyListDAO.getListOfCompanyList();
																for (CompanyListBean c : listOfCompany) {
																	boolean flag = false;
																	List<AnnouncementCompanyBean> listOfCompanyDetail = allListSelfServiceDAO
																			.getListOfAnnouncementCompanyDetail(announcement_id);
																	for (AnnouncementCompanyBean a1 : listOfCompanyDetail) {
																		if (a1.getCompanyListBean().getCompany_list_id() == c.getCompany_list_id()) {
																			flag = true;
																		}
																	}
														%>
														<%
															if (flag == true) {
														%>

														<div class="col-lg-5" style="height: 25px;">
															<label><input type="checkbox" name="company"
																id="company" value="<%=c.getCompany_list_id()%>"
																checked="checked">&nbsp;&nbsp;<%=c.getCompany_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCompany<%=c.getCompany_list_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp;</label>
														</div>

														<%
															} else {
														%>

														<div class="col-lg-5" style="height: 25px;">
															<label><input type="checkbox" name="company"
																id="company" value="<%=c.getCompany_list_id()%>">&nbsp;&nbsp;<%=c.getCompany_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCompany<%=c.getCompany_list_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Broadcast"></i></a>&nbsp;</label>
														</div>

														<%
															}
																}
														%>
													</div>
												</td>
											</tr>
										</table>
											<%
				for (RoleCategoryBean a1 : listOfCategory) {
			%>
			<div class="modal fade col-lg-12"
				id="myModalViewCategory<%=a1.getRole_category_name()%>"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>Role Type of this category : <%=a1.getRole_category_name()%></b>
							</h4>
						</div>

						<table class="table table-striped table-hover">
							<tr>
								<td class="col-lg-4">
									<%
										String role_name = a1.getRole_category_name();
											AllListDAO allListDAO = new AllListDAO();
											List<RoleBean> listOfRole = allListDAO.getListOfRoleById(role_name);
											for (RoleBean r : listOfRole) {
									%>
									<div class="col-lg-4">
										<label><%=r.getRole_type()%></label>
									</div> <%
 	}
 %>
								</td>

							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<%
				}
			%>
			<%
				for (DepartmentBean d : listOfDepartment) {
			%>
			<div class="modal fade col-lg-12"
				id="myModalViewDepartment<%=d.getDepartment_id()%>"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>Employee Name For Department : <%=d.getDepartment_name()%></b>
							</h4>
						</div>

						<table class="table table-striped table-hover">
							<tr>
								<td class="col-lg-4">
									<%
										int department_id = d.getDepartment_id();
											AllListDAO allListDAO = new AllListDAO();
											List<EmployeeBean> listOfEmployees = allListDAO.getListOfEmployeeAllocationByDepartment(department_id);
											for (EmployeeBean r : listOfEmployees) {
									%>
									<div class="col-lg-4">
										<label><%=r.getFirstname()+" "+r.getLastname()%></label>
									</div> <%
 	}
 %>
								</td>

							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<%
				}
			%>
			<%
				for (CompanyListBean c1 : listOfCompany) {
			%>
			<div class="modal fade col-lg-12"
				id="myModalViewCompany<%=c1.getCompany_list_id()%>"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>Employee Name For Company : <%=c1.getCompany_name()%></b>
							</h4>
						</div>

						<table class="table table-striped table-hover">
							<tr>
								<td class="col-lg-4">
									<%
										int company_id = c1.getCompany_list_id();
											AllListDAO allListDAO = new AllListDAO();
											List<EmployeeBean> listOfEmployees = allListDAO.getListOfEmployeeByCompany(company_id);
											for (EmployeeBean r : listOfEmployees) {
									%>
									<div class="col-lg-4">
										<label><%=r.getFirstname()+" "+r.getLastname()%></label>
									</div> <%
 	}
 %>
								</td>

							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<%
				}
			%>
										<%
											}
										%>
										
									</div>
									<center>
										<input type="hidden" name="redirect"> <input
											type="submit" value="Submit" class="btn btn-primary">
										<a href="announcementForm.jsp"><input type="button"
											value="Cancel" class="btn btn-danger"></a>
									</center>
								</div>
								
							</form>
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
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
				responsive : true
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
		<script src="js/timepicki.js"></script>

		<script>
			$('#fromTime').timepicki();
		</script>


		<script type="text/javascript">
			$(function() {
				$('#fromTime').timepicki({
					showMeridian : false
				});
			});
		</script>
		<script>
			$('#toTime').timepicki();
		</script>


		<script type="text/javascript">
			$(function() {
				$('#toTime').timepicki({
					showMeridian : false
				});
			});
			
			var textarea = document.querySelector('textarea');

		 	textarea.addEventListener('keydown', autosize);
		 	             
		 	function autosize(){
		 	  var el = this;
		 	  setTimeout(function(){
		 	    el.style.cssText = 'height:auto; padding:5px;';
		 	    // for box-sizing other than "content-box" use:
		 	    // el.style.cssText = '-moz-box-sizing:content-box';
		 	    el.style.cssText = 'height:' + el.scrollHeight + 'px';
		 	  },0);
		 	}
		</script>
</body>
</html>