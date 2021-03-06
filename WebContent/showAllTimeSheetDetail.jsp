<%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="java.util.List"%>
<%@page import="java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Show All Timesheet</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
     <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
<%@include file="header.jsp"%>
</head>
<script type="text/javascript">
function timesheetAllDelete(id) {
	
	var date = document.getElementById("date"+id).value;
	
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("timeSheetAllDelete?date="+date);
		}
			else
			{
				window.location.replace("showAllTimeSheetDetail.jsp");
				return false;
	 		}
	
}
</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
	<!-- <div class="se-pre-con" align="center" style="padding : 370px;"><h3>Loading...</h3></div> -->
	<%
		int employee_id = user.getEmployee_master_id();
	%>
	<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">All Timesheet</h4>
				                		</div>
				            		</div>

								<!-- /.row -->
							
								<%
									if (request.getAttribute("success") != null) {
								%>
								<div class="panel-body" id="panelbody">
									<div class="alert alert-dismissable alert-success ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${success}
									</div>
								</div>
								<%
									}
								%>
<div class="card-body collapse in">
	  <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<div class="row">
													<div class="col-lg-6">
														<span class="icon-ios-calendar"></span> &nbsp;&nbsp;<b>All
															TIME-SHEET</b>
													</div>
													<div class="col-lg-6" align="right">
														<a href="timesheet.jsp"><button class="btn btn-primary"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Back">
																<span class="icon-reply"></span>&nbsp;&nbsp;<b>Back
																	To Home</b>
															</button></a>
													</div>
												</div>
											</div>
											<!-- /.panel-heading -->

						<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
							<li class="nav-item">
							<a class="nav-link active" id="#home" data-toggle="tab" href="#home" aria-controls="homeIcon1" aria-expanded="true"><i class="icon-alert"></i> Pending</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="#profile" data-toggle="tab" href="#profile" aria-controls="profileIcon1" aria-expanded="false"><i class="icon-checkmark"></i> Approved</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="#messages" data-toggle="tab" href="#messages" aria-controls="aboutIcon1" aria-expanded="false"><i class="icon-android-close"></i> Rejected</a>
							</li>
						</ul>
												<!-- Tab panes -->
												<div class="tab-content px-1 pt-1">
							<div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="homeIcon-tab1" aria-expanded="true">
														<br>
														<h4>Pending Time sheets</h4>
														<table class="table table-stripped table-hover">
															<thead>
																<tr>
																	<th>Date</th>
																	<th>Day</th>
																	<th>Total Worked Hours</th>
																	<th>Task Status</th>
																	<th>Approval Status</th>
																	<th>Action</th>
																</tr>
															</thead>
															<tbody>
																<%
																	AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();

																	List<TimeSheetBean> getWeeklyTimesheet2 = allListDAO.getAllTimesheet(employee_id);
																	List<UnplanProjectBean> getUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheet(employee_id);
																	for (TimeSheetBean t : getWeeklyTimesheet2) {
																		if (t.getApproval_status().equalsIgnoreCase("pending")
																				|| t.getApproval_status().equalsIgnoreCase("updated")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();
																				try {

																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					Date result = formater.parse(date);
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																					d = AppDateFormat.format(result);
																					System.out.println(AppDateFormat.format(result));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}

																			}

																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>
																<tr>
																	<input type="hidden" name="date"
																		id="date<%=t.getTimesheet_master_id()%>"
																		value="<%=date%>">

																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getTask_time_status().equalsIgnoreCase("saved")) {
																		%> <a
																		href="duplicatTimesheetCheck?date=<%=date%>&allList=allList">
																				<i class="icon-edit2" data-toggle="tooltip" data-placement="top"
																				title="Edit"></i>
																			</a>
																			&nbsp;
																			<i class="icon-trash2" style="color:#337ab7;" data-toggle="tooltip" data-placement="top"
																			title="Delete" onclick="timesheetAllDelete(<%=t.getTimesheet_master_id()%>)"></i>
																			<%
																	 	} else if (t.getTask_time_status().equalsIgnoreCase("submit")) {
																	 %> &nbsp; <a href="duplicatTimesheetCheck?date=<%=date%>&update=update">
																			<i class="icon-eye4" data-toggle="tooltip" data-placement="top"
																					title="View Details"></i></a> <%
																		 	}
																		 %>
																	</td>
																</tr>
																<%
																	}
																	}
																%>

																<%
																	for (UnplanProjectBean t : getUnplanTimeSheetList) {
																		if (t.getApproval_status().equalsIgnoreCase("pending")
																				|| t.getApproval_status().equalsIgnoreCase("updated")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			try {

																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				Date result = formater.parse(date);
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																				d = AppDateFormat.format(result);
																				System.out.println(AppDateFormat.format(result));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();
																			}

																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>
																<tr>
																	<input type="hidden" name="date"
																		id="date<%=t.getTimesheet_unplan_project_id()%>"
																		value="<%=date%>">
																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getTask_time_status().equalsIgnoreCase("saved")) {
																		%> <a
																		href="duplicatTimesheetCheck?date=<%=date%>&allList=allList">
																				<i class="icon-edit2" data-toggle="tooltip" data-placement="top"
																				title="Edit"></i></a> <a href="">
																				<i class="icon-trash2" style="color:#337ab7;" data-toggle="tooltip" data-placement="top" title="Delete"
																					onclick="timesheetAllDelete(<%=t.getTimesheet_unplan_project_id()%>)"></i></a> <%
																	 	} else if (t.getTask_time_status().equalsIgnoreCase("submit")) {
																	 %> <a href="duplicatTimesheetCheck?date=<%=date%>&update=update"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="View Details">
																				</i></a> <%
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

														<br>
														<h5><b>Legends :&nbsp;</b></h5>&nbsp;&nbsp;&nbsp;<i class="icon-edit2" style="color:#337ab7;"></i><b> : Edit </b> &nbsp;&nbsp;&nbsp;<i class="icon-eye4" style="color:#337ab7;"></i><b> : View Details </b>
															&nbsp;&nbsp;&nbsp;<i class="icon-trash2" style="color:#337ab7;"></i><b> : Delete </b>
													</div>



													<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profileIcon-tab1" aria-expanded="false">
														<br>
														<h4>Approved Timesheets</h4>
														<table
															class="table table-striped table-bordered table-hover zero-configuration">
															<thead>
																<tr>
																	<th>Date</th>
																	<th>Day</th>
																	<th>Total Worked Hours</th>
																	<th>Task Status</th>
																	<th>Approval Status</th>
																	<th>Action</th>
																</tr>
															</thead>
															<tbody>
																<%
																	for (TimeSheetBean t : getWeeklyTimesheet2) {
																		if (t.getApproval_status().equalsIgnoreCase("approved")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();

																				try {

																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					Date result = formater.parse(date);
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																					d = AppDateFormat.format(result);
																					System.out.println(AppDateFormat.format(result));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}

																			}

																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>
																<tr>
																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getApproval_status().equalsIgnoreCase("approved")) {
																		%> <a
																		href="duplicatTimesheetCheck?date=<%=date%>&update=update"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="View Details"></i></a> 
																		<%
 	}
 %>
																	</td>

																</tr>
																<%
																	}
																	}
																%>

																<%
																	for (UnplanProjectBean t : getUnplanTimeSheetList) {
																		if (t.getApproval_status().equalsIgnoreCase("approved")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			try {

																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				Date result = formater.parse(date);
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																				d = AppDateFormat.format(result);
																				System.out.println(AppDateFormat.format(result));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();
																			}

																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>
																<tr>
																	<input type="hidden" name="date"
																		id="date<%=t.getTimesheet_unplan_project_id()%>"
																		value="<%=date%>">
																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getApproval_status().equalsIgnoreCase("approved")) {
																		%>
																		 <a
																		href="duplicatTimesheetCheck?date=<%=date%>&update=update">
																				<i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
																				 <%
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

														<br>
														<h5><b>Legends :&nbsp;</b></h5> &nbsp;&nbsp;&nbsp;<i class="icon-eye4" style="color:#337ab7;"></i><b> : View Details </b>
															
													</div>




													<div class="tab-pane fade" id="messages" role="tabpanel" aria-labelledby="aboutIcon1-tab" aria-expanded="false">
														<br>
														<h4>Rejected Timesheets</h4>
														<table
															class="table table-striped table-bordered table-hover zero-configuration">
															<thead>
																<tr>
																	<th>Date</th>
																	<th>Day</th>
																	<th>Total Worked Hours</th>
																	<th>Task Status</th>
																	<th>Approval Status</th>
																	<th>Action</th>
																</tr>
															</thead>
															<tbody>
																<%
																	for (TimeSheetBean t : getWeeklyTimesheet2) {
																		if (t.getApproval_status().equalsIgnoreCase("rejected")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();

																				try {

																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					Date result = formater.parse(date);
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																					d = AppDateFormat.format(result);
																					System.out.println(AppDateFormat.format(result));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}

																			}
																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>

																<tr>
																	<input type="hidden" name="date"
																		id="date<%=t.getTimesheet_master_id()%>"
																		value="<%=date%>">
																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getApproval_status().equalsIgnoreCase("rejected")) {
																		%> <a
																		href="duplicatTimesheetCheck?date=<%=date%>&allList=allList"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="View Details"></i>
																				</a><a href="">
																				<i class="icon-trash2" style="color:#337ab7;" data-toggle="tooltip" data-placement="top" title="Delete"
																					onclick="timesheetAllDelete(<%=t.getTimesheet_master_id()%>)"></i></a>
																					<%
																					 	}
																					 %>
																	</td>
																</tr>
																<%
																	}
																	}
																%>

																<%
																	for (UnplanProjectBean t : getUnplanTimeSheetList) {
																		if (t.getApproval_status().equalsIgnoreCase("rejected")) {
																			String date = t.getDate();
																			double workSum = 0;
																			String w = null;
																			String d = null;

																			try {

																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				Date result = formater.parse(date);
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																				d = AppDateFormat.format(result);
																				System.out.println(AppDateFormat.format(result));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}

																			List<TimeSheetBean> listOfSum = allListDAO.getSumOfWorkHours(employee_id, date);
																			for (TimeSheetBean tb : listOfSum) {
																				workSum = workSum + tb.getWorked_hours();
																			}

																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO
																					.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {

																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}
																			w = String.format("%.2f", workSum);
																%>
																<tr>
																	<input type="hidden" name="date"
																		id="date<%=t.getTimesheet_unplan_project_id()%>"
																		value="<%=date%>">
																	<td><%=d%></td>
																	<td><%=t.getDayBean().getDay()%></td>
																	<td><%=w%></td>
																	<td><%=t.getTask_time_status().toUpperCase()%></td>
																	<td><%=t.getApproval_status().toUpperCase()%></td>
																	<td>
																		<%
																			if (t.getApproval_status().equalsIgnoreCase("rejected")) {
																		%> <a
																		href="duplicatTimesheetCheck?date=<%=date%>&allList=allList"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="Edit"></i>
																			</a> <a href="">
																				<i class="icon-trash2" style="color:#337ab7;" data-toggle="tooltip" data-placement="top" title="Delete"
																					onclick="timesheetAllDelete(<%=t.getTimesheet_unplan_project_id()%>)"></i></a>
																					  <%
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

														<br>
														<h5><b>Legends :&nbsp;</b></h5>&nbsp;&nbsp;&nbsp;<i class="icon-edit2" style="color:#337ab7;"></i><b> : Edit </b> &nbsp;&nbsp;&nbsp;<i class="icon-eye4" style="color:#337ab7;"></i><b> : View Details </b>
															&nbsp;&nbsp;&nbsp;<i class="icon-trash2" style="color:#337ab7;"></i><b> : Delete </b>
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
				</div>
			</div>
		
		</section>
		</div>
		</div>
	</div>
	<%@include file="footer.html"%>
	<script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.sticky.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/navs/navs.min.js" type="text/javascript"></script>
</body>
</html>