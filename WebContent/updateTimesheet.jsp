<%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="com.hrms.pms.bean.ProjectManagerListBean"%>
<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Time sheet</title>
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
<script src="dist/js/dontBack.js"></script>
<script type="text/javascript">
function save(id) {
	if(id==1){
	document.getElementById('data').value ="saved";
	}else if(id==2){
		document.getElementById('data').value ="submit";
	}else if(id==3){
		document.getElementById('data').value ="saved";
		document.getElementById('redirect').value ="unplannedRedirect";
	}
}


function sumOfHours(id) {
	/* alert(id);  */
	var a = document.getElementById(id).value;
	var sum = parseInt("0");
	var b = 0;
	for(var i=id;i<10;i++){
		/* alert(i); */
		b =parseInt(document.getElementById(i).value);
	/* 	alert(b); */
		sum = sum + b;
	}
	alert(sum);
}


function handleChange(id) {
	 var a = document.getElementById(id).value;
	
	if(a<0 || a>100){
		document.getElementById(id).value = 0;
		alert("Please! Enter percentage between 0 to 100 ");
	}
	
	
	

}

function checkInteger(id) {
	
	var a = document.getElementById(id).value;
	
	if(isNaN(a)){
		alert("not valid");
		document.getElementById(id).value = 0;
	}
}


function confSubmit() {
	
	
	var Val = confirm("Are you Sure? You can not edit your Timesheet after submitting it.");
	
	if(Val == true){
		document.getElementById('employeeTimeSheetUpdate').submit();
	}else{
	}
	
	
}	


function checkSum(id){
	
	
	var a = document.getElementById("sumOfworkHours").value;
	var b = document.getElementById(id).value;
	
	if(a+b>24){
		alert("test");
	}
	
}

function timesheetDelete(id) {
	
	var date = document.getElementById("date").value;
	
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("timeSheetDelete?timesheet_id="+id+"&date="+date);
		}
			else
			{
				window.location.replace("updateTimesheet.jsp?date="+date);
				return false;
	 		}
	
}

function timesheetUnplanDelete(id) {
	
	var date = document.getElementById("date").value;
	
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("timeSheetDelete?timesheet_id="+id+"&date="+date+"&unplan=unplan");
		}
			else
			{
				window.location.replace("addTimesheet.jsp?date="+date+"&project_id="+project_id);
				return false;
	 		}
	
}

function autoSubmit() {
	document.getElementById('addTimesheet').submit();
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
<!-- <div class="se-pre-con" align="center" style="padding : 370px;"><h3>Loading...</h3></div> -->
<%
	double w = 0;
	int manager_id = user.getManagerBean().getManager_id();
	String date = null;
	String approval_status = null;
	String rejection_reason = null;
	String task_status = null;
	
	
	
		if(request.getParameter("date") != null){
		date = request.getParameter("date");
		}else{
			date = (String) request.getAttribute("date");
		}		
		
		AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();
		List<Object[]> duplicatTimesheetForDate = allListDAO.getDuplicateDateTimesheet(employee_master_id, date);
		
		
		int client_master_id = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currdate = new Date();
		Date date1 = dateFormat.parse(date);
		
		
		List<Object[]> getdailyTimeSheetList = allListDAO.getdayTimeSheetList(employee_master_id, date);
		double workSum = 0;
		if(getdailyTimeSheetList.size() != 0){
		for (Object[] aRow : getdailyTimeSheetList) {
			TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
				workSum = workSum + timeSheetBean1.getWorked_hours();
				approval_status = timeSheetBean1.getApproval_status();
				task_status = timeSheetBean1.getTask_time_status();
				rejection_reason = timeSheetBean1.getRejection_reason();
		}}
		
		
		List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheetList(employee_master_id, date);
		if(getdailyUnplanTimeSheetList.size() != 0){
		for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
			workSum = workSum + unplanProjectBean.getWorked_hours();
			approval_status = unplanProjectBean.getApproval_status();
			task_status = unplanProjectBean.getTask_time_status();
			rejection_reason = unplanProjectBean.getRejection_reason();
		}}
		
		w = Double.parseDouble(String.format("%.2f", workSum));
		int size = getdailyUnplanTimeSheetList.size() + getdailyTimeSheetList.size();
		
		if(size == 0){
			request.getRequestDispatcher("timesheet.jsp").forward(request, response);
			return;
		}

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
			<%if(request.getAttribute("success") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                            </div>
          		</div>  
          		<%} %>
          		<%if(request.getAttribute("error") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${error}
                            </div>
          		</div>  
          		<%} %>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-lg-6">
									<span class="icon icon-ios-calendar"></span> &nbsp;&nbsp;<b>MY TIME-SHEET</b>
								</div>
								<div class="col-lg-6" align="right">
									<a href="timesheet.jsp?date=<%=date%>"><button class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Back">
									<span class="icon icon-reply"></span>&nbsp;&nbsp;<b>Back To Home</b></button></a>
								</div>
							</div>
						
						</div>
						<div class="panel-body">
						<form action="addTimesheet.jsp" id="addTimesheet" method="post">
							<div class="row">
								<div class="col-md-1" align="right">
									<b>Date :</b>
								</div>
								<div class="col-md-3">
								<%Calendar c = Calendar.getInstance();
								c.setTime(date1);
								int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); 
								int day_id = dayOfWeek -1;
								if(day_id == 0){
									day_id=7;
								}
								
								String parseDate= null;
								try {
									  
										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
										Date result = formater.parse(date);
										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
										parseDate = AppDateFormat.format(result);
									} catch (ParseException e1) {
										e1.printStackTrace();
									}
								%>
								
								<input type="hidden" class="form-control" name="date" id="date1"
										value="<%=date%>" style="width: 200px"
										onchange="replica()">
									<b><%=parseDate%></b>
								</div>
								<%
								if(size != 0){
								if((task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("pending"))
														|| (task_status.equalsIgnoreCase("submit") && approval_status.equalsIgnoreCase("rejected"))
														|| (task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("updated"))
														){
											%>
								<div class="col-md-1" align="center">
									<b>Project :</b>
								</div>
								
								<div class="col-md-4">
									<select class="form-control" name="project_id" onchange="autoSubmit();">
										<option value="">---Select Project Name---</option>
									
									<%
																List<ProjectManagerListBean> listOfAssignProject = (ArrayList) allListDAO.listOfProjectWithActiveStatus(employee_master_id);
						   										
																for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
															
															%>
										<option value="<%=projectManagerListBean.getProjectMasterBean().getProject_master_id()%>">
										<%if(!projectManagerListBean.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_code()%>:
										<%}%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_master_name()%></option>
										<%} %>
										
										
										<%List<ProjectMasterBean> listOfProjectMaster  = allListDAO.getListOfProjectMaster(manager_id);
										for (ProjectMasterBean projectMasterBean : listOfProjectMaster) {
											boolean flag = true;
											for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
												if(projectManagerListBean.getProjectMasterBean().getProject_master_id() == projectMasterBean.getProject_master_id()){
													flag = false;
												}
												}
										if(flag == true){		
															%>
										<option value="<%=projectMasterBean.getProject_master_id()%>">
										<%if(!projectMasterBean.getProject_code().equalsIgnoreCase("0")){%>
										<%=projectMasterBean.getProject_code()%>:
										<%}%>
										<%=projectMasterBean.getProject_master_name()%></option>
										<%} }%>
										
										
										
										
									
									<%
																
									
																List<Object[]> listOfProject = (ArrayList) allListDAO.assignedProjectList(employee_master_id);
																String sd = null;
						   										String ed = null;
						   										
																for (Object[] parow : listOfProject) {
																	boolean flag = true;
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
							   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
							   											sd = AppDateFormat.format(result);
							   											ed = AppDateFormat.format(result1);
							   											System.out.println(AppDateFormat.format(result));
							   											
							   											
							   											
							   										} catch (ParseException e1) {
							   											e1.printStackTrace();
							   										}	
																	
																	for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
																	if(projectManagerListBean.getProjectMasterBean().getProject_master_id() == p.getProjectMasterBean().getProject_master_id()){
																		flag = false;
																	}
																	}
																	
																	
																	
																	for (ProjectMasterBean projectMasterBean : listOfProjectMaster) {
																		if(projectMasterBean.getProject_master_id() == p.getProjectMasterBean().getProject_master_id()){
																			flag = false;
																		}
																		}
																	
															if(flag == true){
															%>
										<option value="<%=p.getProjectMasterBean().getProject_master_id()%>">
										<%if(!p.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){%>
										<%=p.getProjectMasterBean().getProject_code()%>:
										<%}%>
										<%=p.getProjectMasterBean().getProject_master_name()%></option>
										<%} %>
										<%} %>
										
										
										
										<option value="0">Unplan Project</option>
										<option value="1">Other Project</option>
									</select>
								</div>
								<%}} %>
							</form>
							</div>
						</div>
						<form action="employeeTimeSheetUpdate" id="employeeTimeSheetUpdate"  method="post" enctype="multipart/form-data">
						<input type="hidden" name="date" id="date" value="<%=date%>">
						<input type="hidden" name="day_id" value="<%=day_id%>">
						<%-- <input type="hidden" name="project_master_id" value="<%=project_id%>">
						<input type="hidden" name="client_master_id" value="<%=client_master_id%>">  --%>
						<input type="hidden" name="data" id="data" value="">
						<input type="hidden" name=approval_status id="" value="<%=approval_status%>">
						
						<div class="row">
						<div class="col-lg-12">
						<div class="panel-body">
								<div class="table-responsive">
								<p align="right"><b>Total Work hours : <font color="red"><%=w%> hour(s)</font></b></p>
										<table class="table table-bordered zero-configuration">
									
										
											<tr bgcolor="#C6C3C2">
												<th>Project Name</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<!-- <th>% Completed</th> -->
												<th>Comment</th>
												<%if((task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("pending"))
													|| (task_status.equalsIgnoreCase("submit") && approval_status.equalsIgnoreCase("rejected"))
													|| (task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("updated"))
													){%>
													<th>Action</th>
												<%} %>
											</tr>
	
											
											<%
											if(getdailyTimeSheetList.size() != 0){
											for (Object[] aRow : getdailyTimeSheetList) {
												String d = null;
												TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
													
												int project_id = timeSheetBean1.getProjectMasterBean().getProject_master_id();
												int unplan_task = timeSheetBean1.getUnplanned_task();
												
												if((task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("pending"))
														|| (task_status.equalsIgnoreCase("submit") && approval_status.equalsIgnoreCase("rejected"))
														|| (task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("updated"))
														){
											%>
												<%if(unplan_task == 1){ %>
													<tr bgcolor="#F1D194">
												<%}else{ %>
												<tr>
												<%} %>
													<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%>
														<input type="hidden" name="timesheet_id" value="<%=timeSheetBean1.getTimesheet_master_id()%>">
														<input type="hidden" name="project_master_id" value="<%=timeSheetBean1.getProjectMasterBean().getProject_master_name() %>">
													
														<%if(!timeSheetBean1.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){ %>
													<%=timeSheetBean1.getProjectMasterBean().getProject_code()%> : 
												    <%}%>
														<%=timeSheetBean1.getProjectMasterBean().getProject_master_name() %></td>
													<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%>
												<select class="form-control" name="task_master_id" id="">
										<option value="0">---Select Task---</option>
										<%List<TaskMasterBean> listOfTask1 = allListDAO.getTaskListByProjectId2(project_id);
                                    for(TaskMasterBean t : listOfTask1){
                                    if(timeSheetBean1.getTaskMasterBean().getTask_master_id() == t.getTask_master_id()){
                                    %>
										<option value="<%=t.getTask_master_id()%>" selected="selected"><%=t.getTask_master_name() %></option>
										<%}else{ %>
										<option value="<%=t.getTask_master_id()%>"><%=t.getTask_master_name() %></option>
										<%} %>
										<%} %>
									</select>
												</td>
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194" width="97px"><%}else{ %><td width="97px"><%}%><input type="text" class="txt"
													size="3" name="workedHours" id="workHours" value="<%=timeSheetBean1.getWorked_hours()%>"
													onchange="checkInteger(this.id);"></td>
												<%if(unplan_task == 1){ %><%}else{ %><%}%>
												<input type="hidden" name="percentage_completed" class="" size="3" id="" onchange="handleChange(this.id); checkInteger(this.id)"
																		value="<%=timeSheetBean1.getPercentage_completed()%>">
																		
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%><textarea rows="" cols="" class="form-control" name="comment" placeholder="Max 5000 words"><%=timeSheetBean1.getEmployee_comment()%></textarea>   <%-- <input type="text" class="form-control" name="comment" value="<%=timeSheetBean1.getEmployee_comment()%>" placeholder="Max 5000 words"> --%>
													<input type="hidden" name="update">
												</td>
											
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%><a href="#"><i class="icon icon-trash" style="color: red" onclick="timesheetDelete(<%=timeSheetBean1.getTimesheet_master_id()%>)"></i></a></td>
												
												
											</tr>
											<%}else{ %>
											<tr>
											
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%>
												
												<%if(!timeSheetBean1.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){ %>
													<%=timeSheetBean1.getProjectMasterBean().getProject_code()%> : 
												<%}%>
													<%=timeSheetBean1.getProjectMasterBean().getProject_master_name() %>
												</td>
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%><%=timeSheetBean1.getTaskMasterBean().getTask_master_name() %></td>
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%><%=timeSheetBean1.getWorked_hours()%></td>
												<%-- <%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%><%=timeSheetBean1.getPercentage_completed()%></td> --%>
												<%if(timeSheetBean1.getEmployee_comment().equalsIgnoreCase("")){ %>
													<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td style="white-space: pre;"><%}%>-----</td>
												<%}else{%>
													<%if(unplan_task == 1){ %><td bgcolor="#F1D194" style="white-space: pre;"><%}else{ %><td style="white-space: pre;"><%}%><%=timeSheetBean1.getEmployee_comment()%></td>												
												<%} %>
												
												<%if(!task_status.equalsIgnoreCase("submit")){ %>
												<%if(unplan_task == 1){ %><td bgcolor="#F1D194"><%}else{ %><td><%}%></td>
												<%} %>
												</tr>
											<%} %>
											<%} }%>
											
											
											<%if(getdailyUnplanTimeSheetList.size() != 0){
											for(UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
												if((task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("pending"))
														|| (task_status.equalsIgnoreCase("submit") && approval_status.equalsIgnoreCase("rejected"))
														|| (task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("updated"))
														){
													%>
													<tr>
														<td bgcolor="#F1D194"><input type="hidden" name="timesheet_id" value="<%=unplanProjectBean.getTimesheet_unplan_project_id()%>"><input type="text" class="form-control" name="project_name" value="<%=unplanProjectBean.getProject_name()%>" placeholder="Enter Project Name"></td>
														<td bgcolor="#F1D194"><input type="text" class="form-control" name="task_name" value="<%=unplanProjectBean.getTask_name()%>" placeholder="Enter Task Name"></td>
														<td width="97px" bgcolor="#F1D194"><input type="text" class="txt"
															size="3" name="workedHours" id="workHours" value="<%=unplanProjectBean.getWorked_hours()%>"
															onchange="checkInteger(this.id);"></td>
															<input type="hidden" name="percentage_completed" size="3" id="percentage" value="<%=unplanProjectBean.getPercentage_completed()%>" onchange="handleChange(this.id); checkInteger(this.id)" value="0">
														<td bgcolor="#F1D194"><textarea rows="" cols="" class="form-control" name="comment" placeholder="Max 5000 words"><%=unplanProjectBean.getEmployee_comment()%></textarea>     <%--  <input type="text" class="form-control" name="comment" value="<%=unplanProjectBean.getEmployee_comment()%>" placeholder="Max 5000 words"> --%>
															<input type="hidden" name="unplanUpdate">
														</td>
														
														<td bgcolor="#F1D194"><a href="#"><i class="icon icon-trash" style="color: red" onclick="timesheetUnplanDelete(<%=unplanProjectBean.getTimesheet_unplan_project_id()%>)"></i></a></td>
														
													</tr>
													<%}else{ %>
													
													<tr >
														<td bgcolor="#F1D194"><%=unplanProjectBean.getProject_name()%></td>
														<td bgcolor="#F1D194"><%=unplanProjectBean.getTask_name()%></td>
														<td bgcolor="#F1D194"><%=unplanProjectBean.getWorked_hours()%></td>
														<%-- <td bgcolor="#F1D194"><%=unplanProjectBean.getPercentage_completed()%></td> --%>
														<%if(unplanProjectBean.getEmployee_comment().equalsIgnoreCase("")){ %>
															<td bgcolor="#F1D194">-----</td>
														<%}else{%>
															<td bgcolor="#F1D194" style="white-space: pre;"><%=unplanProjectBean.getEmployee_comment()%></td>												
														<%} %>
														
														<%if(!task_status.equalsIgnoreCase("submit")){ %>
														<td bgcolor="#F1D194"></td>
														<%} %>
												
											</tr>
											<%} %>
											<%} }%>
											
 											
											</table>

								</div>
								
								<%
								if(size != 0){
								if(approval_status.equalsIgnoreCase("rejected")){ %>
						 <div class="row">
						 <div class="col-lg-12">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            Rejection Reason
                        </div>
                        <div class="panel-body">
                            <p><%=rejection_reason %></p>
                        </div>
                    </div>
                </div>
                </div>
						<%}} %>
								<%
								if(size != 0){
								if((task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("pending"))
										|| (task_status.equalsIgnoreCase("submit") && approval_status.equalsIgnoreCase("rejected"))
										|| (task_status.equalsIgnoreCase("saved") && approval_status.equalsIgnoreCase("updated"))
										){ %>
								<input type="hidden" name="redirect">
								<div align="right" style="padding-right: 30px;">
								<input type="submit"   class="btn btn-success" value="Save" onclick="save(1)"/>&nbsp;&nbsp;&nbsp;
								<input type="button"   class="btn btn-primary" value="Submit" onclick="save(2); confSubmit();"/>
								</div>
								<%} }%>
								
								<!-- /.table-responsive -->
							<!-- /.panel-body -->
							<br>
							<br>
							<div align="left">
								<b>NOTE :</b>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon icon-stop" style="color:#F1D194;"></i><b> : Unplanned Task</b>
							</div>
						</div>
						</div>
						</div>
						
						
						</form>

					</div>

					</div>
				</div>
				<!-- /#page-wrapper -->
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
	<script>
	$(document).ready(function(){

		//iterate through each textboxes and add keyup
		//handler to trigger sum event
		$(".txt").each(function() {

			$(this).keyup(function(){
				calculateSum();
			});
		});

	});
	function calculateSum() {

		var sum = 0;
		//iterate through each textboxes and add the values
		$(".txt").each(function() {

			//add only if the value is number
			if(!isNaN(this.value) && this.value.length!=0) {
				sum += parseFloat(this.value);
			}
			/* if(sum>24){
				alert("WorkedHours can not be greater than 24");
				$('#workedHours').val(0);
			}
			/* else if(sum < 8)
				{
				alert("WorkedHours can not be less than 8");
				} */
		});
		//.toFixed() method will roundoff the final sum to 2 decimal places
		var totalWorkHour = sum;
		if(totalWorkHour>24){
			alert("WorkedHours can not be greater than 24");
			$('.txt').val(0);
		}
		$("#sum").html(sum.toFixed(2));
	}

	
</script>


</body>
</html>