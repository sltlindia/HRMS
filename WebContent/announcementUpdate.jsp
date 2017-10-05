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
<title>Broadcast Update</title>
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
	<%
	CompanyListDAO companyListDAO = new CompanyListDAO();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
	
	List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
	List<CompanyListBean> listOfCompany = companyListDAO.getListOfCompanyList();
	List<RoleCategoryBean> listOfCategory = allListSelfServiceDAO.getListOfAnnouncementCategory();
	%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12">
					<h2 class="content-header-title mb-0">Broadcast Form</h2>
				</div>
			</div>
			<div class="content-body">
				<section id="striped-row-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="striped-row-layout-basic">Add
									Broadcast</h4>
							</div>
						<%
											int announcement_id = Integer.parseInt(request.getParameter("announcement_id"));
										%>
										<input type="hidden" name="announcement_id"
											id="announcement_id" value="<%=announcement_id%>">

										<%
											
											List<AnnouncementBean> listOfAnnouncement = allListSelfServiceDAO.getListOfAnnouncement(announcement_id);
											for (AnnouncementBean a : listOfAnnouncement) {
										%>
										<input type="hidden" name="file" id="file"
											value="<%=a.getAnnouncement_attachment()%>">
							<div class="card-body collapse in">
								<div class="card-block">
									<form class="form form-horizontal form-bordered"
										action="announcementUpdate" method="post"
										name="announcement_form" enctype="multipart/form-data">
										<div class="form-body">
											<div class="form-group row">
												<label class="col-md-3 label-control">Title</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
													<input type="text" class="form-control"
															name="announcement_title"
															autofocus id="announcement_title" required="required"
															value="<%=a.getAnnouncement_title()%>">
														<div class="form-control-position">
															<i class="icon-paper-stack"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control" for="Description">Description</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
													<textarea name="description" id="description" rows="5"
															class="form-control"
															required="required"><%=a.getAnnouncement_description()%></textarea>
														<div class="form-control-position">
															<i class="icon-file2"></i>
														</div>
													</div>
												</div>
											</div>
												<div class="form-group row">
												<label class="col-md-3 label-control">Broadcast Date</label>
												<div class="col-md-3">
													<div class="position-relative has-icon-left">
														<input type="text" class="form-control"
															name="announcement_date" id="announcement_date"
															required="required" onchange="ValidateDate(this.value)"
															data-toggle="tooltip" data-trigger="hover"
															data-placement="top" data-title="Start Date"
															value="<%=a.getAnnouncment_date()%>">
															<div class="form-control-position">
															<i class="icon-calendar4"></i>
														</div>
													</div>
												</div>
												<label class="col-md-3 label-control">Broadcast End</label>
												<div class="col-md-3">
													<div class="position-relative has-icon-left">
														<input type="text" class="form-control"
															name="announcement_enddate" id="announcement_enddate"
															required="required"
															onchange="ValidateDateMitigation(this.value);endDateValidation(this.value)"
															data-toggle="tooltip" data-trigger="hover"
															data-placement="top" data-title="End Date"
															value="<%=a.getAnnouncement_enddate()%>">
															<div class="form-control-position">
															<i class="icon-calendar4"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control">Time Slot</label>
												<div class="col-md-2">
												Start Time
												</div>
												<div class="col-md-2">
													<div class="position-relative has-icon-left">
														<input type="text" id="fromTime"
													class="form-control" name="fromTime" placeholder="HH:mm" value="<%=a.getFrom_time()%>" required>
														<div class="form-control-position">
															<i class="icon-clock5"></i>
														</div>
													</div>
												</div>

												<label class="col-md-2 label-control">End Time</label>
												<div class="col-md-2">
													<div class="position-relative has-icon-left">
														<input type="text" id="toTime"
													class="form-control" name="toTime" placeholder="HH:mm" value="<%=a.getTo_time()%>"  required>
														<div class="form-control-position">
															<i class="icon-clock5"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control">Select File
													<p class="help-block">(.pdf, .doc, .docx, .jpg, .png,
														.jpeg, .txt, .ppt, .xml, .xlsx, .xls, .png, .pptx)</p>
												</label>
												<div class="col-md-9">
													<label id="projectinput7" class="file center-block">
														<input type="file" name="attachment" value=""
														id="attachment_id" onchange="checkFile(this)" /> <a
														onclick="removeAttachment();" style="cursor: pointer;">
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
 %>
															<i class="fa fa-times"></i>
													</a> <span class="file-custom"></span>
													</label>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control">Company</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
													
													<%
															
																
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
															data-target="#myModalViewCompany<%=c.getCompany_list_id()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Company"></i></a>&nbsp;</label>
														</div>

														<%
															} else {
														%>

														<div class="col-lg-5" style="height: 25px;">
															<label><input type="checkbox" name="company"
																id="company" value="<%=c.getCompany_list_id()%>">&nbsp;&nbsp;<%=c.getCompany_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCompany<%=c.getCompany_list_id()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Company"></i></a>&nbsp;</label>
														</div>

														<%
															}
																}
														%>
													</div>												
												</div>
												</div>
												<div class="form-group row">
												<label class="col-md-3 label-control">Department</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
													<%
															
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
															data-target="#myModalViewDepartment<%=d.getDepartment_id()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Department"></i></a>&nbsp;</label>
														</div>
														<%
															} else {
														%>
														<div class="col-lg-4" style="height: 25px;">
															<label><input type="checkbox" name="department"
																id="department" value="<%=d.getDepartment_id()%>">&nbsp;&nbsp;<%=d.getDepartment_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewDepartment<%=d.getDepartment_id()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Department"></i></a>&nbsp;</label>
														</div>
														<%
															}
																	}
																}
														%>
													
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control">Role Category</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
													<%
															
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
															data-target="#myModalViewCategory<%=r1.getRole_category_name()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Category"></i></a>&nbsp; 
														</label>
														<%
															} else {
														%>
														<label> <input type="checkbox" name="category"
															id="category" value="<%=r1.getRole_category_id()%>">&nbsp;&nbsp;<%=r1.getRole_category_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCategory<%=r1.getRole_category_name()%>"><i class="icon icon-eye4" data-toggle="tooltip"
																	data-placement="top" title="View Category"></i></a>&nbsp; 
														</label>
														<%
															}
																}
														%>
													</div>
												</div>
											</div>
											<div class="form-actions right">
											<input type="hidden" name="redirect"> 
												<a href="announcementForm.jsp"><button type="reset" class="btn btn-warning mr-1">
													<i class="icon-cross2"></i> CANCEL
												</button></a>
												<button type="submit" class="btn btn-primary">
													<i class="icon-check2"></i> SAVE
													</button>
											</div>
											</div>
											</form>

										</div>
								</div>
										<%
											}
										%>
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
			</div>
				</section>
			</div>
		</div>
	<%
									for (RoleCategoryBean a1 : listOfCategory) {
								%>
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<!-- Modal -->
										<div class="modal animated slideInUp text-xs-left"
											id="myModalViewCategory<%=a1.getRole_category_name()%>"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel74"
											aria-hidden="true">
											<div class="modal-dialog modal-lg" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">
															<b>Role Type of this category : <%=a1.getRole_category_name()%></b>
														</h4>
													</div>
													<div class="modal-body">
													<div class="row">
														<%
															String role_name = a1.getRole_category_name();
																AllListDAO allListDAO = new AllListDAO();
																List<RoleBean> listOfRole = allListDAO.getListOfRoleById(role_name);
																for (RoleBean r : listOfRole) {
														%>
														<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
															<i class="icon-user4"></i>&nbsp;<label><%=r.getRole_type()%></label>
														</div>
														<%
															}
														%>
														</div>
														</div>
													<div class="modal-footer">
														<button type="button"
															class="btn grey btn-outline-secondary"
															data-dismiss="modal">Close</button>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
								<%
									for (DepartmentBean d : listOfDepartment) {
								%>
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<!-- Modal -->
										<div class="modal animated slideInUp text-xs-left"
											id="myModalViewDepartment<%=d.getDepartment_id()%>"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel74"
											aria-hidden="true">
											<div class="modal-dialog modal-lg" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">
															<b>Employee Name For Department : <%=d.getDepartment_name()%></b>
														</h4>
													</div>
													<div class="modal-body">
													<div class="row">
														<%
															int department_id = d.getDepartment_id();
																AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> listOfEmployees = allListDAO.getListOfEmployeeAllocationByDepartment(department_id);
																for (EmployeeBean r : listOfEmployees) {
														%>
														<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
															<i class="icon-user4"></i>&nbsp;<label><%=r.getFirstname() + " " + r.getLastname()%></label>
														</div>
														<%
															}
														%>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button"
															class="btn grey btn-outline-secondary"
															data-dismiss="modal">Close</button>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
								<%
									for (CompanyListBean c1 : listOfCompany) {
								%>

								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<!-- Modal -->
										<div class="modal animated slideInUp text-xs-left"
											id="myModalViewCompany<%=c1.getCompany_list_id()%>"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel74"
											aria-hidden="true">
											<div class="modal-dialog modal-lg" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">
															<b>Employee Name For Company : <%=c1.getCompany_name()%></b>
														</h4>
													</div>
													<div class="modal-body">
													<div class="row">
														<%
															int company_id = c1.getCompany_list_id();
																AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> listOfEmployees = allListDAO.getListOfEmployeeByCompany(company_id);
																for (EmployeeBean r : listOfEmployees) {
														%>
														
														<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
															<i class="icon-user4"></i>&nbsp;<label><%=r.getFirstname() + " " + r.getLastname()%></label><br>
														</div>
														<%
															}
														%>
														</div>
														</div>
													<div class="modal-footer">
														<button type="button"
															class="btn grey btn-outline-secondary"
															data-dismiss="modal">Close</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>

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