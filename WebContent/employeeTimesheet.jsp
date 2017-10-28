<%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.w3c.dom.ls.LSInput"%>
<%@page import="com.hrms.timesheet.bean.ProjectAllocationBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>My Timesheet</title>
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
    <!-- END VENDOR CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
  </head>
<script type="text/javascript">
function replica(id){
	
	var a = document.getElementById("date1");
	var b = document.getElementById(id);
	
	b.value = a.value;
	
}


function validateForm() {
    var x = document.getElementById("date1").value;
    if (x == null || x == "") {
        alert("Date must be filled out");
        return false;
    }
}
</script>
<script type="text/javascript">
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "date")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
    }
</script>

<script>
    if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
        jQuery(function($){ //on document.ready
            $('#date1').datepicker({
                dateFormat: 'yy-mm-dd'
            });
        })
    }
    
    function hideMessage()
    {
    	//document.getElementById("panelbody").style.display="none"; 
    	 $('#panelbody').fadeOut('slow');
    }

    	function startTimer()
    	 {
    			var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
    	 }
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns" onload="startTimer()">
<%DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date currdate = new Date();
System.out.println(dateFormat.format(currdate)); %>
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
			<%if(request.getAttribute("successTimesheet") !=null || request.getAttribute("updatedTimesheet") !=null ) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${successTimesheet}${updatedTimesheet}
                            </div>
          		</div>  
          		<%} %>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">MY TIME-SHEET</div>
						<div class="panel-body">
							<!-- /.panel-body -->
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
												<div class="row">
															${duplicate} ${duplicateDate}
																<div class="col-md-2"><b>Enter Date :</b> </div>
																<div class="col-md-4"><input type="date"
																	class="form-control" name="date" id="date1" value="<%=dateFormat.format(currdate) %>"
																	style="width: 200px" onchange="replica()">
																</div>
																<!-- <td><b>To Date :</b> <input type="date"
																	class="form-control"></td> -->
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="panel panel-default">
										<div class="panel-heading">Allocated Projects</div>

										<!-- /.panel-heading -->
										<div class="panel-body">
											<div class="dataTable_wrapper">
												<div class="table-responsive">
													<table
														class="table table-striped table-bordered table-hover zero-configuration">
														<thead>
															<tr>
																<th>Project Name</th>
																<th>Client Name</th>
																<th>Plan Start Date</th>
																<th>Plan End Date</th>
																<th>Status</th>
																<th>Action</th>
															</tr>
														</thead>
														<tbody>
															<%
																AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();
																List<Object[]> listOfProject = (ArrayList) allListDAO.assignedProjectList(employee_master_id);

																String sd = null;
						   										String ed = null;
						   										
																for (Object[] parow : listOfProject) {
																	ProjectAllocationBean p = (ProjectAllocationBean) parow[0];
																	EmployeeBean e = (EmployeeBean) parow[1];
																	ProjectMasterBean p1 = (ProjectMasterBean) parow[2];
																	TaskMasterBean t = (TaskMasterBean) parow[3];
																	
																	String startDate = p1.getPlanned_start_date();
							   										String endDate = p1.getPlanned_end_date();
																	try {
							  											  
							   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
							    										Date result = formater.parse(startDate);
							   											Date result1 = formater.parse(endDate);
							   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
							   											sd = AppDateFormat.format(result);
							   											ed = AppDateFormat.format(result1);
							   											System.out.println(AppDateFormat.format(result));
							   											
							   											
							   											
							   										} catch (ParseException e1) {
							   											e1.printStackTrace();
							   										}	
															
															%>

															<tr>
																<form action="newEmployeeTimeSheetInsert" method="get"
																	name="myForm">
																	<input type="hidden" name="project_master_name"
																		value="<%=p.getProjectMasterBean().getProject_master_name()%>">
																	<input type="hidden" name="project_master_id"
																		value="<%=p.getProjectMasterBean().getProject_master_id()%>">
																	<input type="hidden" name="client_master_id"
																		value="<%=p.getProjectMasterBean().getClientMasterBean().getClient_master_id()%>">
																	<input type="hidden" name="client_master_name"
																		value="<%=p.getProjectMasterBean().getClientMasterBean().getClient_master_name()%>">
																	<td><%=p.getProjectMasterBean().getProject_master_name()%></td>
																	<td><%=p.getProjectMasterBean().getClientMasterBean().getClient_master_name()%></td>
																	<td><%=sd%></td>
																	<td><%=ed%></td>
																	<td><%=p.getProjectMasterBean().getProjectStatusBean().getProject_status_name()%></td>
																	<td>
																	<%if(p.getProjectMasterBean().getProjectStatusBean().getProject_status_id() == 3){ %>
																	<input type="hidden" name="date"
																		id="<%=p.getProject_Allocation_id()%>1">
																	<button type="submit" class="btn btn-primary"
																			onclick="replica(<%=p.getProject_Allocation_id()%>1); return validateForm();">Add
																			TimeSheet</button>
																			
																			<%} %>
																	
																			</td>
																			</form>
															</tr>
															
															<%
																}
															%>
															
															<tr>
															<form action="newEmployeeExternalTimeSheetInsert" method="get"
																	name="myForm">
																	<input type="hidden" name="project_master_name"
																		value="No Project">
																	<input type="hidden" name="project_master_id"
																		value="2">
																	<input type="hidden" name="client_master_id"
																		value="1">
																	<input type="hidden" name="client_master_name"
																		value="Internal">
															<td colspan="5"><input type="hidden" name="date"
																		id="1111111">External task</td>
															<td><button type="submit" class="btn btn-primary"
																			onclick="replica(1111111); return validateForm();">Add
																			TimeSheet</button></td>
															</tr>
														</tbody>

													</table>
													<!-- <a href ="#"><button type="submit" class="btn btn-primary">Add Unplanned Task</button></a> -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-lg-12">
									<div class="panel panel-default">
										<div class="panel-heading">Weekly Timesheet</div>

										<!-- /.panel-heading -->
										<div class="panel-body">
											<div class="dataTable_wrapper">
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
															AllListDAO allListDAO1 = new AllListDAO();
															List<Object[]> getWeeklyTimesheet2 = (ArrayList) request.getAttribute("getWeeklyTimesheet2");
															String d = null;
															for (Object[] aRow : getWeeklyTimesheet2) {
																double workSum = 0;
																double leaveSum = 0;
																String w = null;
																String l = null;
																TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];

																/* request.getAttribute("date"); */

																EmployeeBean employeeBean = (EmployeeBean) aRow[1];
																DayBean dayBean = (DayBean) aRow[2];
																ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
																ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
																TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];

																String date = timeSheetBean1.getDate();

																List<Object[]> listOfSum = allListDAO.getSumOfHours(employee_master_id, date);

																for (Object[] arow : listOfSum) {

																	TimeSheetBean t = (TimeSheetBean) arow[0];

																	workSum = workSum + t.getWorked_hours();
																	leaveSum = leaveSum + t.getLeave_hours();
																	System.out.println("date:" + t.getDate());
																	System.out.println("work hour:" + t.getWorked_hours());
																	w = String.format("%.2f", workSum);
																	l = String.format("%.2f", leaveSum);
																}
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
														<td><%=w%></td>

														<%
															if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("saved")) {
														%>
														<td><%=timeSheetBean1.getTask_time_status()%>
															<%
																if (timeSheetBean1.getEmployee_comment() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<td><%=timeSheetBean1.getApproval_status()%></td>
														<td><a
															href="employeeTimeSheetUpdateButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>&project_master_name=<%=timeSheetBean1.getProjectMasterBean().getProject_master_name()%>&client_master_name=<%=timeSheetBean1.getProjectMasterBean().getClientMasterBean().getClient_master_name()%>&task_master_name=<%=taskMasterBean.getTask_master_name()%>">
															<i class="icon icon-edit2" data-toggle="tooltip"
																data-placement="top" title="Update"></i></a> <a
															href="employeeSubmitButtonUpdate?date=<%=timeSheetBean1.getDate()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>">
															<i class="icon icon-floppydisk"
																data-toggle="tooltip" data-placement="top"
																title="Submit"></i></a> <a
															href="employeeTimeSheetAllDelete?date=<%=timeSheetBean1.getDate()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>">
															<i class="icon icon-trash" data-toggle="tooltip"
																data-placement="top" title="Delete" style="color: red;"></i></a>
														</td>
														<%
															}else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("updated") && timeSheetBean1.getApproval_status().equalsIgnoreCase("pending")) {
														%>
														<td><%=timeSheetBean1.getTask_time_status()%>
															<%
																if (timeSheetBean1.getEmployee_comment() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														
														 <td><%=timeSheetBean1.getApproval_status()%>
															<%
																if (timeSheetBean1.getRejection_reason() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getRejection_reason()%>"></i>
															<%
																}
															%></td>
														<td>
														<a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a> 
														</td>
														<%
															}else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("updated") && timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")) {
														%>
														<td><%=timeSheetBean1.getTask_time_status()%>
															<%
																if (timeSheetBean1.getEmployee_comment() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<%if(timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")){ %><td style="color: green;"><%=timeSheetBean1.getApproval_status()%>
														<%}else if(timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")){ %><td style="color: red;"><%=timeSheetBean1.getApproval_status()%><%}%>
															<%
																if (timeSheetBean1.getRejection_reason() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getRejection_reason()%>"></i></td>
															<%
																}
															%>
														<td>
														<a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a> 
														</td>
														<%
															}
															else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("submit")
																		&& timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")) {
														%>
														<td>Submitted <%
															if (timeSheetBean1.getEmployee_comment() != "") {
														%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<%if(timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")){ %><td style="color: green;"><%=timeSheetBean1.getApproval_status()%>
														<%}else if(timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")){ %>
														<td style="color: red;"><%=timeSheetBean1.getApproval_status()%><%} %>
														<td><a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a>
																</td>

														<%}else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("submit")
 																&& timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")) {
														 %>
														<td>Submitted <%
															if (timeSheetBean1.getEmployee_comment() != "") {
														%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<%if(timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")){ %><td style="color: green;"><%=timeSheetBean1.getApproval_status()%>
														<%}else if(timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")){ %><td style="color: red;"><%=timeSheetBean1.getApproval_status()%><%} %>
															<%
																if (timeSheetBean1.getRejection_reason() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getRejection_reason()%>"></i>
															<%
																}
															%></td>
														<td><a
															href="employeeTimeSheetUpdateButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>&project_master_name=<%=timeSheetBean1.getProjectMasterBean().getProject_master_name()%>?client_master_name=<%=timeSheetBean1.getProjectMasterBean().getClientMasterBean().getClient_master_name()%>">
															<i class="icon icon-edit2" data-toggle="tooltip"
																data-placement="top" title="Update"></i></a> <a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a> 
															<% 	}
 															else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("updated")
 																&& timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")) {
														 %>
														<td>Submitted <%
															if (timeSheetBean1.getEmployee_comment() != "") {
														%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<%if(timeSheetBean1.getApproval_status().equalsIgnoreCase("approved")){ %><td style="color: green;"><%=timeSheetBean1.getApproval_status()%>
														<%}else if(timeSheetBean1.getApproval_status().equalsIgnoreCase("rejected")){ %><td style="color: red;"><%=timeSheetBean1.getApproval_status()%><%} %>
															<%
																if (timeSheetBean1.getRejection_reason() != "") {
															%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getRejection_reason()%>"></i>
															<%
																}
															%></td>
														<td><a
															href="employeeTimeSheetUpdateButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>&project_master_name=<%=timeSheetBean1.getProjectMasterBean().getProject_master_name()%>?client_master_name=<%=timeSheetBean1.getProjectMasterBean().getClientMasterBean().getClient_master_name()%>">
															<i class="icon icon-edit2" data-toggle="tooltip"
																data-placement="top" title="Update"></i></a> <a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a> 
																<%
 															} else if (timeSheetBean1.getTask_time_status().equalsIgnoreCase("submit")
 															&& timeSheetBean1.getApproval_status().equalsIgnoreCase("pending")) {
 %>
														<td>Submitted <%
															if (timeSheetBean1.getEmployee_comment() != "") {
														%>
															<i class="icon-android-chat" data-container="body"
															data-toggle="popover" data-placement="top"
															data-content="<%=timeSheetBean1.getEmployee_comment()%>"></i>
															<%
																}
															%></td>
														<td><%=timeSheetBean1.getApproval_status()%></td>
														<td><a
															href="employeeTimeSheetViewButton?timesheet_master_id=<%=timeSheetBean1.getTimesheet_master_id()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean1.getDate()%>">
															<i class="icon icon-eye4"
																data-toggle="tooltip" data-placement="top"
																title="Show View"></i></a> <a
															href="employeeTimeSheetAllDelete?date=<%=timeSheetBean1.getDate()%>&employee_master_id=<%=employeeBean.getEmployee_master_id()%>">
															<i class="icon icon-trash" data-toggle="tooltip"
																data-placement="top" title="Delete" style="color: red;"></i></a></td>
														<%
															}
														%>

														</tr>
														<%
															}
														%>
													</tbody>
												</table>
												<h5><b>Legends :&nbsp;</b></h5> <i class="icon icon-edit2" style="color:#337ab7;"></i><b> : Update </b> &nbsp;&nbsp;&nbsp;<i class="icon icon-floppydisk" style="color:#337ab7;"></i><b> : Submit </b> &nbsp;&nbsp;&nbsp;<i class="icon icon-trash" style="color:red;"></i><b> : Delete</b> &nbsp;&nbsp;&nbsp;<i class="icon icon-eye4" style="color:#337ab7;"></i><b> : View Detail</b> &nbsp;&nbsp;&nbsp;<i class="icon-android-chat" style="color:#337ab7;"></i><b> : Comment </b> &nbsp;&nbsp;&nbsp;
											</div>
										</div>
									</div>
								</div>

							</div>
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
    <!-- /build-->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
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
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
    
</body>
</html>