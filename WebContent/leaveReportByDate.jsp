<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>Leave Report</title>
<script type="text/javascript">
	var datefield = document.createElement("input")
	datefield.setAttribute("type", "date")
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
			$('#currDate').datepicker({
				dateFormat : 'yy-mm-dd'
			});
			$('#plannedStartDate').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>
</head>
<%@include file="header.jsp"%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currdate = new Date();
		System.out.println(dateFormat.format(currdate));
	%>

	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
								<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">Leave List</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>
								<%
									String date1 = (String) request.getAttribute("date");
								%>
								<form action="leaveReportByDate" method="post">
									<div class="panel-group" id="accordion">
										<div class="panel panel-default">
											<div id="collapseOne" class="panel-collapse collapse in">
												<div class="panel-body">
													<div class="row">
														<div class="col-md-2">
															<b>Enter Date :</b>
														</div>
														<div class="col-md-4">
															<input type="date" class="form-control" name="date"
																id="currDate" value="<%=date1%>" style="width: 200px"
																required>

														</div>
														<input type="submit" class="btn btn-primary" name="submit"
															value="SUBMIT">
													</div>
												</div>

											</div>
										</div>
										<br>
										<div class="row">
											<div class="col-lg-12">
												<div class="panel panel-default">
													<div class="panel-heading">
														<p>
															Pending Leave Report Of
															<%=date1%>
														</p>
													</div>
													<!-- /.panel-heading -->
													<div class="panel-body">
														<div class="dataTable_wrapper">
													<div class="table-responsive">
															<table
																class="table table-striped table-bordered zero-configuration">
																<thead>
																	<tr>
																		<th>Employee Name</th>
																		<th>Employee Code</th>
																		<th>From Date</th>
																		<th>To Date</th>
																		<th>submission Date</th>
																		<th>Reporting Manager</th>
																		<th>Status</th>
																		<th>Action</th>
																	</tr>
																</thead>
																<tbody>
																	<%
																		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																		LeaveBean leaveBean = new LeaveBean();
																		List<LeaveBean> listOfEmployeeOnLeave = (ArrayList) request.getAttribute("listOfEmployee");
																		for (LeaveBean l : listOfEmployeeOnLeave) {
																			if (l.getStatus().equalsIgnoreCase("pending")) {
																	%>

																	<tr>
																		<td><%=l.getEmployeeBean().getFirstname() + " " + l.getEmployeeBean().getLastname()%></td>
																		<td><%=l.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=l.getLeave_From()%></td>
																		<td><%=l.getLeave_To()%></td>
																		<td><%=l.getSubmission_date()%></td>
																		<%
																			LoginDAO loginDAO = new LoginDAO();
																					int manager_id = l.getUnder_manager_id();
																					EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																		%>
																		<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																		<%
																			String status = l.getStatus();
																		%>
																		<%
																			if (status.equalsIgnoreCase("pending")) {
																		%>
																		<td><font color="blue"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else if (status.equalsIgnoreCase("approved")) {
																		%>
																		<td><font color="green"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else if (status.equalsIgnoreCase("cancelled")) {
																		%>
																		<td><font color="orange"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else {
																		%>
																		<td><font color="red"><b><%=l.getStatus()%></b></font></td>
																		<%
																			}
																		%>
																		<td><a
																			href="pendingLeave?leave_id=<%=l.getLeave_id()%>&status=<%=l.getStatus()%>">
																				<i class="glyphicon glyphicon-ok"></i>
																		</a></td>

																	</tr>

																	<%
																		}
																		}
																	%>
																</tbody>
															</table>
													</div>
													</div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-12">
												<div class="panel panel-default">
													<div class="panel-heading">
														<p>
															Approved Leave Report Of
															<%=date1%>
														</p>
													</div>
													<!-- /.panel-heading -->
													<div class="panel-body">
													<div class="dataTable_wrapper">
													<div class="table-responsive">
															<table
																class="table table-striped table-bordered zero-configuration">
																<thead>
																	<tr>
																		<th>Employee Name</th>
																		<th>Employee Code</th>
																		<th>From Date</th>
																		<th>To Date</th>
																		<th>submission Date</th>
																		<th>Reporting Manager</th>
																		<th>Status</th>
																	</tr>
																</thead>
																<tbody>
																	<%
																		for (LeaveBean l : listOfEmployeeOnLeave) {
																			if (l.getStatus().equalsIgnoreCase("approved")) {
																	%>

																	<tr>
																		<td><%=l.getEmployeeBean().getFirstname() + " " + l.getEmployeeBean().getLastname()%></td>
																		<td><%=l.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=l.getLeave_From()%></td>
																		<td><%=l.getLeave_To()%></td>
																		<td><%=l.getSubmission_date()%></td>
																		<%
																			LoginDAO loginDAO = new LoginDAO();
																					int manager_id = l.getUnder_manager_id();
																					EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																		%>
																		<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																		<%
																			String status = l.getStatus();
																		%>
																		<%
																			if (status.equalsIgnoreCase("pending")) {
																		%>
																		<td><font color="blue"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else if (status.equalsIgnoreCase("approved")) {
																		%>
																		<td><font color="green"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else if (status.equalsIgnoreCase("cancelled")) {
																		%>
																		<td><font color="orange"><b><%=l.getStatus()%></b></font></td>
																		<%
																			} else {
																		%>
																		<td><font color="red"><b><%=l.getStatus()%></b></font></td>
																		<%
																			}
																		%>
																	</tr>

																	<%
																		}
																		}
																	%>
																</tbody>
															</table>
															</div>
														</div>
													</div>
													</div>
												</div>
											</div>
										<br>
										<div class="row">
											<div class="col-lg-12">
												<div class="panel panel-default">
													<div class="panel-heading">
														<p>
															Cancelled Leave Report Of
															<%=date1%>
														</p>
													</div>
													<!-- /.panel-heading -->
													<div class="panel-body">
															<table
																class="table table-striped table-bordered zero-configuration">
																<thead>
																	<tr>
																		<th>Employee Name</th>
																		<th>Employee Code</th>
																		<th>From Date</th>
																		<th>To Date</th>
																		<th>submission Date</th>
																		<th>Reporting Manager</th>
																		<th>Status</th>
																	</tr>
																</thead>
																<tbody>
																	<%
																		for (LeaveBean l : listOfEmployeeOnLeave) {
																			if (l.getStatus().equalsIgnoreCase("cancelled")) {
																	%>

																	<tr>
																		<td><%=l.getEmployeeBean().getFirstname() + " " + l.getEmployeeBean().getLastname()%></td>
																		<td><%=l.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=l.getLeave_From()%></td>
																		<td><%=l.getLeave_To()%></td>
																		<td><%=l.getSubmission_date()%></td>
																		<%
																			LoginDAO loginDAO = new LoginDAO();
																					int manager_id = l.getUnder_manager_id();
																					EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																		%>
																		<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																		<%
																			String status = l.getStatus();
																		%>
																		<td>
																			<%
																				if (status.equalsIgnoreCase("pending")) {
																			%> <font
																			color="blue"><b><%=l.getStatus()%></b></font> <%
 	} else if (status.equalsIgnoreCase("approved")) {
 %>
																			<font color="green"><b><%=l.getStatus()%></b></font>
																			<%
																				} else if (status.equalsIgnoreCase("cancelled")) {
																			%> <font
																			color="orange"><b><%=l.getStatus()%></b></font> <%
 	} else {
 %>
																			<font color="red"><b><%=l.getStatus()%></b></font> <%
 	}
 %>
																		</td>
																	</tr>

																	<%
																		}
																		}
																	%>
																</tbody>
															</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
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
	<script src="app-assets/vendors/js/extensions/moment.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js"
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
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
      <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
</body>
</html>