<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.bean.RoleCategoryBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
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

textarea {
	/* box-sizing: padding-box; */
	overflow: hidden;
	/* demo only: */
	padding: 10px;
	width: 100%;
	font-size: 14px;
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
			error += "Please make sure your file is in pdf , doc ,docx , xml , jpg , jpeg , xls , txt , png or ppt.";
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
	function ValidateDateMitigation(value) {

		var a = value;
		var b = document.getElementById("currentDate").value;

		if (a < b) {
			alert("Please give future date as a announcement end date");
			document.getElementById("announcement_enddate").value = 0000 - 00 - 00;
		}

	}
	function endDateValidation(value) {

		// alert("enddatevalidate function ni andar ayu");
		var a = value;
		var b = document.getElementById("announcement_date").value;

		if (a < b) {
			// alert("Endvalidate if ni andar");
			alert("Announcement end date must be bigger than announcement date.");
			document.getElementById("announcement_enddate").value = 0000 - 00 - 00;
		}

	}
	function ValidateDate(value) {
		// alert("validate function ni andar ayu");
		var a = value;
		var b = document.getElementById("currentDate").value;

		if (a < b) {
			alert("Please give future date as a announcement date");
			document.getElementById("announcement_date").value = 0000 - 00 - 00;
		}

	}
	function removeAttachment() {
		document.getElementById('attachment_id').value = '';
	}
	function hideMessage() {
		//document.getElementById("panelbody").style.display="none"; 
		$('#panelbody').fadeOut('slow');
	}
	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
	function checkType(value) {
		if (value == "yes") {
			document.getElementById("fromTime").disabled = false;
			document.getElementById("toTime").disabled = false;
		}
		if (value == "no") {
			document.getElementById("fromTime").disabled = true;
			document.getElementById("toTime").disabled = true;
		}
	}
</script>
<script>
	$(document).ready(function() {
		$('#decision').on('change', function() {
			if (this.value == 'rejected')
			//.....................^.......
			{
				$("#accordion1").show();
				$("#accordion2").hide();
			} else if (this.value == 'selected') {
				$("#accordion2").show();
				$("#accordion1").hide();
			} else {
				$("#accordion1").hide();
				$("#accordion2").hide();
			}

		});
	});
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#selecctall').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});

	$(document).ready(function() {
		$('#selecctall1').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});

	$(document).ready(function() {
		$('#selecctall2').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});
</script>

<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String date1 = dateFormat.format(date);
	%>
	<%
		int employee_id = user.getEmployee_master_id();
	%>
 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
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
		<div class="col-md-12">
	        <div class="card">
	            <div class="card-header">
	                <h4 class="card-title" id="striped-label-layout-icons">Broadcast Form</h4>
	                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
	            </div>
				   <div class="card-body collapse in">
	                <div class="card-block">
							<form action="announcementInsert" method="post"
								name="announcement_form" enctype="multipart/form-data">
								<div class="form-body">
	                			<div class="form-group row">
	                        		<label class="col-md-3 label-control">Title <i class="icon-android-alert" style="color: red" id="inoOfBox"></i></label>
	                        		<div class="col-md-9">
			                           <div class="position-relative has-icon-left">
			                            	<input type="text" class="form-control"
													name="announcement_title" placeholder="Broadcast Title" autofocus
													id="announcement_title" required="required">
				                            <div class="form-control-position">
				                                <i class="icon-paper-stack"></i>
				                            </div>
			                            </div>
									</div>
		                        </div>
		                        <div class="form-group row">
									<label class="col-md-3 label-control" for="timesheetinput7">Description</label>
									<div class="col-md-9">
										<div class="position-relative has-icon-left">
			                            	<textarea
														name="description" placeholder="Max. 10000 words"
														required="required" class="form-control"></textarea>
				                            <div class="form-control-position">
				                                <i class="icon-file2"></i>
				                            </div>
			                            </div>
			                        </div>
								</div>
								<div class="form-group row">
	                        		<label class="col-md-3 label-control">Broadcast Date<i class="icon-android-alert" style="color: red" id="inoOfBox"></i></label>
	                        		<div class="col-md-9">
			                           <div class="position-relative has-icon-left">
			                            	<input type="text" class="form-control"
													name="announcement_date" id="announcement_date"
													required="required"
													onchange="ValidateDate(this.value)">
											<label>Would you like to add
														time slot for broadcast?</label>
														<input type="radio" name="yes" id="yes"
													value="yes" onchange="checkType(this.value)">
													Yes <input type="radio" name="yes" id="no" value="no"
													onchange="checkType(this.value)" autofocus> No
				                            <div class="form-control-position">
				                                <i class="icon-paper-stack"></i>
				                            </div>
			                            </div>
									</div>
		                        </div>
		                        <div class="form-group row">
	                        		<label class="col-md-3 label-control">Time Slot<i class="icon-android-alert" style="color: red" id="inoOfBox"></i></label>
	                        		<div class="col-md-9">
			                           <div class="position-relative has-icon-left">
			                            From :
												<input type="text" id="fromTime"
													class="form-control" name="fromTime" placeholder="HH:mm"
													required disabled="disabled">
													<p class="help-block">Please use 24Hours Time-format</p>
												To:<input type="text" id="toTime"
													class="form-control" style="width:210px;" name="toTime" placeholder="HH:mm" disabled="disabled"
													required>
			                            
			                            
				                            <div class="form-control-position">
				                                <i class="icon-paper-stack"></i>
				                            </div>
			                            </div>
									</div>
		                        </div>
		                        <div class="form-group row">
	                        		<label class="col-md-3 label-control">Broadcast End Date<i class="icon-android-alert" style="color: red" id="inoOfBox"></i></label>
	                        		<div class="col-md-9">
			                           <div class="position-relative has-icon-left">
			                              <input type="text" class="form-control"
													name="announcement_enddate" id="announcement_enddate"
													required="required"
													onchange="ValidateDateMitigation(this.value);endDateValidation(this.value)">
													<label>Attachment</label>
													<input type="file" name="attachment" value=""
													id="attachment_id" onchange="checkFile(this)" />
													<p class="help-block">(.pdf, .doc, .docx, .jpg, .png,
														.jpeg, .txt, .ppt, .xml, .xlsx, .xls, .png, .pptx)</p>
														<a onclick="removeAttachment();" style="cursor: pointer;"> <i
														class="fa fa-times"></i></a>
				                            <div class="form-control-position">
				                                <i class="icon-paper-stack"></i>
				                            </div>
			                            </div>
									</div>
		                        </div>
		                      	  <div class="form-actions right">
	                            <button type="reset" class="btn btn-warning mr-1">
	                            	<i class="icon-cross2"></i> CANCEL
	                            </button>
	                            <input type="hidden" name="redirection"> <input
											type="submit" class="btn btn-primary">
	                                <i class="icon-check2"></i> SAVE
	                        </div>
								</div>
       </div>
	            </div>
	        </div>
	    </div>
	</div>
	
</div>
</div>
</div>								
								
								<%-- <div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped table-hover">
											<tr>
												<th>Title</th>
												<td>:</td>
												<td colspan="5"><input type="text" class="form-control"
													name="announcement_title" placeholder="Broadcast Title" autofocus
													id="announcement_title" required="required"></td>
											</tr>
											<tr>
												<th>Description</th>
												<td>:</td>
												<td colspan="5"><textarea
														name="description" placeholder="Max. 10000 words"
														required="required" class="form-control"></textarea></td>
											</tr>
											<tr>
											<th>Broadcast Date</th>
												<td>:</td>
												<td><input type="text" class="form-control"
													name="announcement_date" id="announcement_date"
													required="required"
													onchange="ValidateDate(this.value)"></td>
												<td><label>Would you like to add
														time slot for broadcast?</label></td>
												<td>:</td>
												<td colspan="1"><input type="radio" name="yes" id="yes"
													value="yes" onchange="checkType(this.value)">
													Yes <input type="radio" name="yes" id="no" value="no"
													onchange="checkType(this.value)" autofocus> No</td>
											</tr>

											<tr>
												<th>From</th>
												<td>:</td>
												<td><input type="text" id="fromTime"
													class="form-control" name="fromTime" placeholder="HH:mm"
													required disabled="disabled">
													<p class="help-block">Please use 24Hours Time-format</p>
													</td>
												<th>To</th>
												<td>:</td>
												<td><input type="text" id="toTime"
													class="form-control" style="width:210px;" name="toTime" placeholder="HH:mm" disabled="disabled"
													required>
													
													</td>
												<td></td>
											</tr>
											<tr>
												<th>Broadcast End Date</th>
												<td>:</td>
												<td><input type="text" class="form-control"
													name="announcement_enddate" id="announcement_enddate"
													required="required"
													onchange="ValidateDateMitigation(this.value);endDateValidation(this.value)"></td>

												<th>Attachment
													<p class="help-block">(Max size 1MB)</p>
												</th>
												<td colspan="2"><input type="file" name="attachment" value=""
													id="attachment_id" onchange="checkFile(this)" />
													<p class="help-block">(.pdf, .doc, .docx, .jpg, .png,
														.jpeg, .txt, .ppt, .xml, .xlsx, .xls, .png, .pptx)</p></td>
												<td><a onclick="removeAttachment();" style="cursor: pointer;"> <i
														class="fa fa-times"></i></a></td>
											</tr>
											<!-- 	<tr>
											<div class="col-lg-6">	
												<td>
												<div class="col-lg-2">From</div>
											</td>
											<td><input type="text" id="outTime" class="form-control" name="outTime" placeholder="HH:mm" required>
										</td>	
										</div>
		<div class="col-lg-6">
											<td><div class="col-lg-2">To</div></td>
											<td>	
											<input type="text" id="outTime1" class="form-control" name="outTime1" placeholder="HH:mm" required>
											</td></div>
												
											</tr> -->
										<tr>
												<td><label>Category<i
														class="fa fa-question-circle" data-toggle="tooltip"
														data-placement="top"
														title="All the team members of the specific category which you select will notify by all the details of broadcast."></i></label></td>
												<td>:</td>
												<td colspan="5">
													<div class="form-group">
													<label><input type="checkbox" id="selecctall" name="checkAll[]" onclick="myFunction()">All</label></br>
														<%
															AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
															List<RoleCategoryBean> listOfCategory = allListSelfServiceDAO.getListOfAnnouncementCategory();
															for (RoleCategoryBean a1 : listOfCategory) {
														%>
														<label>
														<input type="checkbox" name="category" class="checkbox1"
															id="category" value="<%=a1.getRole_category_id()%>">&nbsp;&nbsp;<%=a1.getRole_category_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCategory<%=a1.getRole_category_name()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Category"></i></a>&nbsp; </label>
														<%
															}
														%>
													</div>
												</td>
											</tr>
											
											<tr>
												<td><label>&nbsp;Department&nbsp;<i
														class="fa fa-question-circle" data-toggle="tooltip"
														data-placement="top"
														title="All the team members of the specific department which you select will notify by all the details of broadcast."></i></label></td>
												<td>:</td>
												<td colspan="4">
												<label><input type="checkbox" id="selecctall1" name="checkAll[]" onclick="myFunction()">All</label></br>
													<!-- <div class="row"> -->
														<%
															DepartmentDAO departmentDAO = new DepartmentDAO();
															List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
															for (DepartmentBean d : listOfDepartment) {
																if (d.getDepartment_id() != 0) {
														%>
														<div class="col-lg-4" style="height: 25px;">
															<label><input type="checkbox" name="department" class="checkbox2" 
																id="department" value="<%=d.getDepartment_id()%>">&nbsp;&nbsp;<%=d.getDepartment_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewDepartment<%=d.getDepartment_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Department"></i></a>&nbsp;</label>
														</div>
														<%
															}
															}
														%>
													<!-- </div> -->
												</td>
											</tr>
											<tr>
												<td><label>&nbsp;Company&nbsp;<i
														class="fa fa-question-circle" data-toggle="tooltip"
														data-placement="top"
														title="All the employee of the specific company which you select will notify by all the details of broadcast."></i></label></td>
												<td>:</td>
												<td colspan="5">
												<label><input type="checkbox" id="selecctall2" name="checkAll[]" onclick="myFunction()">All</label></br>
													<%
														CompanyListDAO companyListDAO = new CompanyListDAO();
														List<CompanyListBean> listOfCompany = companyListDAO.getListOfCompanyList();
														for (CompanyListBean c1 : listOfCompany) {
													%>
													<div class="col-lg-5" style="height: 25px;">
														<label><input type="checkbox" name="company" class="checkbox3"
															id="company" value="<%=c1.getCompany_list_id()%>">&nbsp;<%=c1.getCompany_name()%>&nbsp;&nbsp;<a
															href="" data-toggle="modal"
															data-target="#myModalViewCompany<%=c1.getCompany_list_id()%>"><i
																class="glyphicon glyphicon-eye-open"
																data-toggle="tooltip" data-placement="top"
																title="View Company"></i></a>&nbsp;</label>
													</div> <%
 	}
 %>
												</td>
											</tr>
											
										</table>
									</div>
									<center>
										<input type="hidden" name="redirection"> <input
											type="submit" value="Submit" class="btn btn-primary">
										<input type="reset" value="Cancel" class="btn btn-danger">
									</center>
									<br>
									<p>
										<b>Note : </b><font color="red">
										You can send notification and e-mail by picking either particular or all category / department / company. This will send notification and e-mail
										to the selected entities. 
										</font> 
								</div>
							</form>
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
			</div>
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
							</div>
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div> --%>

	<%@include file="footer.jsp"%>

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
