<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.timesheet.bean.ProjectAllocationBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.zone.ZoneOffsetTransitionRule.TimeDefinition"%>
<%@page import="javax.print.attribute.standard.SheetCollate"%>
<%@page import="java.util.ArrayList"%>
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
<title>Time sheet</title>
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
<script src="dist/js/dontBack.js"></script>
<script type="text/javascript">
	function save(id) {
		/* alert(id); */
		if (id == 1) {
			document.getElementById('data').value = "saved";
		} else if (id == 2) {
			document.getElementById('data').value = "submit";
		} else if (id == 3) {
			document.getElementById('data').value = "saved";
			document.getElementById('redirect').value = "unplannedRedirect";
		}
	}

	function replica() {

		var a = document.getElementById('comment');
		var b = document.getElementById('employeeComment');

		b.value = a.value;

	}

	/* function confirm() {
	 if(document.getElementById('workedHours').value <8){
	 alert("your workhours is less than 8 hours..")
	 }
	 } */

	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var colCount = table.rows[0].cells.length;

		for (var i = 0; i < colCount; i++) {

			var newcell = row.insertCell(i);

			newcell.innerHTML = table.rows[0].cells[i].innerHTML;
			//alert(newcell.childNodes);
			switch (newcell.childNodes[0].type) {
			case "text":
				newcell.childNodes[0].value = "0";
				break;
			case "checkbox":
				newcell.childNodes[0].checked = false;
				break;
			case "select-one":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			case "select-two":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			case "select-three":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			}
		}
	}

	function confSubmit() {

		var Val = confirm("You can not edit your Timesheet after submit.Are you sure you want to submit the form?");

		if (Val == true) {
			document.getElementById('employeeTimeSheetInsert').submit();
		} else {
			alert("You decided to not submit the form!");
		}

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					if (rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					var r = confirm("Are you sure you want to delete?");
					if (r == true) {
						table.deleteRow(i);
						rowCount--;
						i--;
					} else {
						break;
					}

				}

			}
		} catch (e) {
			alert(e);
		}
	}

	function sumOfHours(id) {
		/* alert(id);  */
		var a = document.getElementById(id).value;
		var sum = parseInt("0");
		var b = 0;
		for (var i = id; i < 10; i++) {
			/* alert(i); */
			b = parseInt(document.getElementById(i).value);
			/* 	alert(b); */
			sum = sum + b;
		}
		alert(sum);
	}
	function handleChange(id) {
		var a = document.getElementById(id).value;

		if (a<0 || a>100) {
			document.getElementById(id).value = 0;
			alert("Please! Enter percentage between 0 to 100 ");
		}

	}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
	<%
		String date = null;
		String comment = null;
		double w = 0;
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
										<h1 class="page-header">Time-Sheet Management</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>
								<!-- /.row -->
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">MY TIME-SHEET</div>
											<div class="panel-body">
												<%
													if (request.getParameter("action") != null) {
												%>
												<form name="demo" action="timeSheetInsert"
													id="employeeTimeSheetInsert" enctype="multipart/form-data"
													method="post">
													<%
														} else {
													%>
													<form name="demo" action="employeeTimeSheetInsert"
														id="employeeTimeSheetInsert" enctype="multipart/form-data"
														method="post">
														<%
															}
														%>
														<input type="hidden" name="employeeComment"
															id="employeeComment" value="">
														<div class="panel-group" id="accordion">

															<div class="panel panel-default">
																<div id="collapseOne" class="panel-collapse collapse in">
																	<div class="panel-body">
																		<%
																			AllListDAO allListDAO = new AllListDAO();
																			List<Object[]> getWeeklyTimesheet2 = (ArrayList) request.getAttribute("getWeeklyTimesheet2");
																			for (Object[] aRow : getWeeklyTimesheet2) {
																				double workSum = 0;

																				TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
																				EmployeeBean employeeBean = (EmployeeBean) aRow[1];
																				DayBean dayBean = (DayBean) aRow[2];
																				ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
																				ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
																				TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];
																				String date1 = (String) request.getAttribute("date");

																				List<Object[]> listOfSum = allListDAO.getSumOfHours(employee_master_id, date1);

																				for (Object[] arow : listOfSum) {

																					TimeSheetBean t = (TimeSheetBean) arow[0];

																					workSum = workSum + t.getWorked_hours();
																					System.out.println("date:" + t.getDate());
																					System.out.println("work hour:" + t.getWorked_hours());
																					w = Double.parseDouble(String.format("%.2f", workSum));
																					comment = t.getEmployee_comment();
																				}
																			}
																		%>

																		<div class="table-responsive">
																			<table class="table table-striped">
																				<tbody>
																					<tr>
																						<input type="hidden" name="project_master_id"
																							value="2">
																						<input type="hidden" name="project_master_name"
																							value="No">
																						<input type="hidden" name="client_master_id"
																							value="<%=request.getParameter("client_master_id")%>">
																						<input type="hidden" name="client_master_name"
																							value=<%=request.getParameter("client_master_name")%>">
																						<td><b>Project Name : <%=request.getAttribute("project_master_name")%></b></td>
																						<td><b>Client Name : <%=request.getAttribute("client_master_name")%></b></td>
																					</tr>
																				</tbody>
																			</table>

																		</div>
																	</div>
																</div>
															</div>
															<div class="panel panel-default">

																<div id="collapseOne" class="panel-collapse collapse in">
																	<div class="panel-body">

																		<div class="table-responsive">
																			<table class="table table-striped">
																				<tbody>
																					<tr>
																						<td><b>Date : </b><input type="hidden"
																							class="form-control" name="date"
																							value="<%=request.getAttribute("date")%>"><b><%=request.getAttribute("format")%></b></td>
																						<td><input type="hidden" class="form-control"
																							name="day_id"
																							value="<%=request.getAttribute("day_id")%>"><b>Day
																								: </b><b><%=request.getAttribute("dayOfWeek")%></b></td>
																						<input type="hidden" class="form-control"
																							name="day"
																							value="<%=request.getAttribute("dayOfWeek")%>">
																					</tr>
																				</tbody>
																			</table>

																			<input type="hidden" name="data" id="data" value="">
																			<center>
																				<h6 style="color: red;">
																					Total Worked hours for
																					<%=request.getAttribute("format")%>
																					are
																					<%=w%></h6>
																			</center>
																		</div>
																	</div>
																</div>
																<div class="calc">
																	<!-- /.panel-heading -->
																	<div class="panel-body">
																		<div class="table-responsive">
																			<input type="hidden" id="sumOfworkHours"
																				value="<%=w%>">
																			<table
																				class="table table-striped table-bordered table-hover zero-configuration">
																				<thead>
																					<tr>
																						<th name="taskName">Task
																							Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
																						<th>Worked Hours</th>
																						<th>% Completed</th>
																					</tr>
																				</thead>
																				<%
																					int client_master_id = (Integer) session.getAttribute("client_master_id");
																				%>
																				<%
																					int project_master_id = (Integer) session.getAttribute("project_master_id");
																				%>


																				<tbody>
																					<tr>
																						<td><input type="hidden"
																							name="task_master_id" value="0"><input
																							type="text" class="form-control" name="task_Desc"
																							value="" maxlength="500"
																							placeholder="max 500 words"></td>
																						<td width="97px"><input type="text"
																							class="txt" size="3" name="workedHours"
																							id="workedHours" value="0"></td>
																						<td width="97px"><input type="text"
																							name="percentage_completed" size="3" value="0"
																							id="task_master_id"
																							onchange="handleChange(this.id);"><b></b></td>
																					</tr>

																				</tbody>
																				<tr id="summation" style="visibility: hidden;">
																					<td>&nbsp;</td>
																					<td align="right">Sum :</td>
																					<td align="center"><span id="sum">0</span></td>
																				</tr>

																			</table>

																		</div>
																		<!-- /.table-responsive -->
																	</div>
																	<!-- /.panel-body -->
																</div>
																<!-- /.panel -->
																<input type="hidden" name="redirect" id="redirect"
																	value="redirect">
																<!-- <button type="button" class="btn btn-info">Edit</button> -->

																<%-- <a href="employeeTimeSheetInsert?date=<%=date%>"><INPUT type="button" value="Add Row"/></a> --%>

																<input type="submit" class="btn btn-success"
																	value="Save" onclick="save(1)" /> <input type="button"
																	class="btn btn-primary" value="Submit"
																	onclick="save(2); confSubmit();" /> <a
																	href="employeeTimeSheetDefault"><button
																		type="button" class="btn btn-danger">Cancel</button></a> <br>
																<br>
																<div class="panel panel-default">

																	<div class="panel-footer">Comments:</div>
																	<!-- <div class="form-group">
												<textarea class="form-control" rows="3"
													name="m" id="comment" oninput="replica()"></textarea>
											</div> -->
																	<%
																		if (comment == null) {
																	%>
																	<div class="form-group">
																		<textarea class="form-control" rows="3" name="m"
																			id="comment" oninput="replica()"></textarea>
																	</div>
																	<%
																		} else {
																	%>
																	<div class="form-group">
																		<textarea class="form-control" rows="3" name="m"
																			id="comment" oninput="replica()"><%=comment%></textarea>
																	</div>
																	<%
																		}
																	%>
																</div>
															</div>
														</div>
														<%-- <div class="row">
								<div class="panel-body">
									<!-- Button trigger modal -->
									<a
										href="newUnplannedTaskEmployeeInsert?date=<%=request.getAttribute("date")%>&day=<%=request.getAttribute("dayOfWeek")%>&day_id=<%=request.getAttribute("day_id")%>"><input
										type="submit" value="Add Unplan Task"
										class="btn btn-primary btn-lg" onclick="save(3)"> </a>
									<!-- /.modal -->
								</div>
								<!-- .panel-body -->
							</div>
							<!-- /.row -->
										
                            <br><br> --%>
														<div class="row">
															<div class="col-lg-12">
																<div class="panel panel-default">
																	<div class="panel-heading">Daily Timesheet</div>
																	<!-- /.panel-heading -->
																	<div class="panel-body">
																		<div class="dataTable_wrapper">
																			<div class="table-responsive">
																				<table
																					class="table table-striped table-bordered table-hover zero-configuration">


																					<thead>
																						<tr>
																							<th>Date</th>
																							<th>Day</th>
																							<th>Project Name</th>
																							<th>Client Name</th>
																							<th>Task Name</th>
																							<th>Worked Hours</th>
																							<th>% Completed</th>
																							<th>Status</th>

																						</tr>
																					</thead>
																					<tbody>
																						<%
																							List<Object[]> getdayTimeSheetList = (ArrayList) request.getAttribute("getdayTimeSheetList");
																							for (Object[] aRow : getdayTimeSheetList) {
																								String d = null;
																								TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
																								/* int employee_master_id = user.getEmployee_master_id();
																										AllListDAO allListDAO = new AllListDAO();
																										List<Object[]> listofdata = allListDAO.getmanagerTimeSheetList1(employee_master_id); */
																								request.getAttribute("date");

																								EmployeeBean employeeBean = (EmployeeBean) aRow[1];
																								DayBean dayBean = (DayBean) aRow[2];
																								ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
																								ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
																								TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];
																						%>
																						<%
																							try {

																									String date1 = timeSheetBean1.getDate();
																									SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																									Date result = formater.parse(date1);
																									SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																									d = AppDateFormat.format(result);
																									System.out.println(AppDateFormat.format(result));
																								} catch (ParseException e1) {
																									e1.printStackTrace();
																								}
																						%>
																						<tr>
																							<td><%=d%></td>
																							<td><%=dayBean.getDay()%></td>
																							<td><%=projectMasterBean.getProject_master_name()%></td>
																							<td><%=clientMasterBean.getClient_master_name()%></td>
																							<td>
																								<%
																									if (taskMasterBean.getTask_master_id() != 0) {
																								%>
																								<%=taskMasterBean.getTask_master_name()%> <%
 	} else {
 %>
																								<%=timeSheetBean1.getExternal_task_name()%> <%
 	}
 %>
																							</td>
																							<td><%=timeSheetBean1.getWorked_hours()%></td>
																							<td><div>
																									<p>
																										<span class="pull-right text-muted"><%=timeSheetBean1.getPercentage_completed()%>%</span>
																									</p>
																									<div class="progress progress-striped active">
																										<%
																											if (timeSheetBean1.getPercentage_completed() <= 50) {
																										%>
																										<div class="progress-bar progress-bar-success"
																											role="progressbar"
																											aria-valuenow="<%=timeSheetBean1.getPercentage_completed()%>"
																											aria-valuemin="0" aria-valuemax="100"
																											style="width: <%=timeSheetBean1.getPercentage_completed()%>%">
																											<span class="sr-only"><%=timeSheetBean1.getPercentage_completed()%>
																												(success)</span>
																										</div>
																										<%
																											} else if (50 < timeSheetBean1.getPercentage_completed()
																														&& timeSheetBean1.getPercentage_completed() <= 75) {
																										%>
																										<div class="progress-bar progress-bar-info"
																											role="progressbar"
																											aria-valuenow="<%=timeSheetBean1.getPercentage_completed()%>"
																											aria-valuemin="0" aria-valuemax="100"
																											style="width: <%=timeSheetBean1.getPercentage_completed()%>%">
																											<span class="sr-only"><%=timeSheetBean1.getPercentage_completed()%>
																												(success)</span>
																										</div>
																										<%
																											} else if (timeSheetBean1.getPercentage_completed() > 75) {
																										%>
																										<div class="progress-bar progress-bar-danger"
																											role="progressbar"
																											aria-valuenow="<%=timeSheetBean1.getPercentage_completed()%>"
																											aria-valuemin="0" aria-valuemax="100"
																											style="width: <%=timeSheetBean1.getPercentage_completed()%>%">
																											<span class="sr-only"><%=timeSheetBean1.getPercentage_completed()%>
																												(success)</span>
																										</div>
																										<%
																											}
																										%>
																									</div>
																								</div></td>
																							<td><%=timeSheetBean1.getTask_time_status()%></td>
																						</tr>

																						<%
																							}
																						%>

																					</tbody>
																				</table>
																			</div>
																		</div>
																	</div>
																</div>
													</form>
													<!-- /.table-responsive -->
											</div>
											<!-- /.panel -->
										</div>
										<!-- /.col-lg-12 -->
									</div>
									<!-- /.row -->
								</div>
								<!-- /#page-wrapper -->
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
	<script>
		$(document).ready(function() {

			//iterate through each textboxes and add keyup
			//handler to trigger sum event
			$(".txt").each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {

			var sum = 0;
			//iterate through each textboxes and add the values
			$(".txt").each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
				}
				/* if(sum>24){
					alert("WorkedHours can not be greater than 24");
					$('#workedHours').val(0);
				} */
				/* else if(sum < 8)
					{
					alert("WorkedHours can not be less than 8");
					} */
			});
			//.toFixed() method will roundoff the final sum to 2 decimal places
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			/* alert(diff); */
			if (totalWorkHour > 24) {
				alert("WorkedHours can not be greater than 24");
				$('.txt').val(0);
			}
			$("#sum").html(sum.toFixed(2));
		}
	</script>

</body>
</html>