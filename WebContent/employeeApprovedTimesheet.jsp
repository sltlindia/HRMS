<%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.timesheet.bean.DayBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Approved Timesheet</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
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
	href="app-assets/vendors/css/extensions/sweetalert.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
 <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
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
										<h1 class="page-header">Reports</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>
								<!-- /.row -->

								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">Time-Sheet Report</div>
											<!-- /.panel-heading -->
											<div class="panel-body">
												<div class="dataTable_wrapper">
													<table
														class="table table-striped table-bordered table-hover zero-configuration">
														<thead>
															<tr>
																<th style="width: 150px;">Date</th>
																<th style="width: 150px;">Day</th>
																<!-- <th>Worked Hours</th> -->
																<th>Employee Comment</th>
																<th>Status</th>
																<th>Reason</th>
																<th>Action</th>
															</tr>
														</thead>
														<%
															double w = 0;
														%>
														<tbody>
															<%
																List<Object[]> approvedEmployeeTimeSheet = (ArrayList) request.getAttribute("approvedEmployeeTimeSheet");
																for (Object[] aRow : approvedEmployeeTimeSheet) {
																	String d = null;
																	double workSum = 0;
																	TimeSheetBean timeSheetBean = (TimeSheetBean) aRow[0];
																	EmployeeBean employeeBean = (EmployeeBean) aRow[1];
																	DayBean dayBean = (DayBean) aRow[2];
																	ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
																	ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
																	TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];
																	try {
																		String date1 = timeSheetBean.getDate();
																		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																		Date result = formater.parse(date1);
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																		d = AppDateFormat.format(result);
																		System.out.println(AppDateFormat.format(result));
																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}
																	AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();
																	List<Object[]> listOfSum = allListDAO.getSumOfHoursApprovedTs(d);

																	for (Object[] arow : listOfSum) {

																		TimeSheetBean t = (TimeSheetBean) arow[0];

																		workSum = workSum + t.getWorked_hours();
																		System.out.println("date:" + t.getDate());
																		System.out.println("work hour:" + t.getWorked_hours());
																		w = Double.parseDouble(String.format("%.2f", workSum));

																	}
															%>

															<tr>
																<td style="width: 150px;"><%=d%></td>
																<td style="width: 150px;"><%=dayBean.getDay()%></td>
																<%-- <td><%=w %></td> --%>

																<%
																	if (timeSheetBean.getEmployee_comment().equalsIgnoreCase("")) {
																%>
																<td>No Comment</td>
																<%
																	} else {
																%>

																<td><%=timeSheetBean.getEmployee_comment()%></td>
																<%
																	}
																%>
																<td><%=timeSheetBean.getApproval_status()%></td>
																<%
																	if (timeSheetBean.getApproval_status().equalsIgnoreCase("Approved")) {
																%>
																<td>------</td>
																<%
																	} else if (timeSheetBean.getApproval_status().equalsIgnoreCase("Rejected")) {
																%>
																<td><%=timeSheetBean.getRejection_reason()%></td>
																<%
																	} else if (timeSheetBean.getApproval_status().equalsIgnoreCase("Pending")) {
																%>
																<td>------</td>
																<%
																	}
																%>
																<td><a
																	href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean.getDate()%>"><li
																		class="icon icon-eye4"
																		data-toggle="tooltip" data-placement="top"
																		title="Show View"></li></a></td>
															</tr>
															<%
																}
															%>
														</tbody>
														<!-- /.tbody -->
													</table>
													<!-- /.table -->
												</div>
												<!-- /.dataTable_wrapper -->
											</div>
											<!-- /.panel-body -->
										</div>
										<!-- /.panel panel-primary -->
									</div>
									<!-- /.col-lg-12 -->
								</div>
								<!-- /.row -->
							</div>
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div><%@include file="footer.html"%>
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
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js"
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

	 <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
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
</body>
</html>