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
 <!-- <script type='text/javascript' src='/HRMS/dwr/interface/AjaxDataDAO.js'></script>
  <script type='text/javascript' src='/HRMS/dwr/engine.js'></script>
 <script type='text/javascript' src='/HRMS/dwr/util.js'></script> -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Add Time sheet</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <%@include file="header.jsp" %>
  </head>
<script type="text/javascript">

function response(project_master_id,dept_id){
	  
	var emp_id = document.getElementById('emp_id').value;
			 dwr.util.removeAllOptions(taskName1);
			// document.getElementById('imgLoader').style.visibility = 'hidden'; 
			if(project_master_id==''){
				var data=[{ task_master_name:'--- Select Task ---', task_master_id:'' }];
				dwr.util.addOptions("taskName1",data,"task_master_id","task_master_name");
				//document.getElementById('imgLoader').style.visibility = 'hidden';
			}else{
				
				//document.getElementById('taskName1').style.visibility = 'hidden';
			 	//document.getElementById('imgLoader').style.visibility = 'visible';
				AjaxDataDAO.getAllTask(project_master_id,dept_id,emp_id,function(data){
				dwr.util.addOptions(taskName1,["---Select Task---"]);
				dwr.util.addOptions(taskName1,["Other Task"]);
				dwr.util.addOptions(taskName1,data,"task_master_id","task_master_name");
				//document.getElementById('taskName1').style.visibility = 'visible';
				//document.getElementById('imgLoader').style.visibility = 'hidden';
				});
			} 
			
			} 
 

function save(id) {
	if(id==1){
		
	document.getElementById('data').value ="saved";
	
	var form = document.getElementById('employeeTimeSheetInsert');
    for(var i=0; i < form.elements.length; i++){
      if(form.elements[i].value === '' && form.elements[i].hasAttribute('required')){
        alert('There are some required fields!');
        return false;
      }
    }
    form.submit();
    
    
	}else if(id==2){
		
		document.getElementById('data').value ="submit";
		var retVal = confirm("Are you sure? you want to submit it.");
		
		
		
		if(retVal==true){
			/* document.getElementById("employeeTimeSheetInsert").submit(); */
			
			
			var form = document.getElementById('employeeTimeSheetInsert');
			    for(var i=0; i < form.elements.length; i++){
			      if(form.elements[i].value === '' && form.elements[i].hasAttribute('required')){
			        alert('There are some required fields!');
			        return false;
			      }
			    }
			    form.submit();
			
			
			
		}
		
		
		
		
		
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



function showTextBox(){
	
	 $('#subTask').fadeIn('slow');
	 $('#hideButton').fadeOut('slow');
}

function checkInteger(id) {
	
	var a = document.getElementById(id).value;
	
	if(isNaN(a)){
		alert("not valid");
		document.getElementById(id).value = 0;
	}
}

function checkTask() {
	
	var a = document.getElementById('unplanTaskId').value;
	
	if(a == 0){
		alert("please select task..");
	}
}


function confSubmit() {
	
	var val = "Are you Sure? \n";
	val += "You can not edit your Timesheet after submitting it.";
	
	var v = confirm(val);
	
	if(v == true){
		document.getElementById('employeeTimeSheetInsert').submit();
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
	var project_id = document.getElementById("project_id").value;
	
		var retVal = confirm("Are you sure?");
		if( retVal == true )
			{
			window.location.replace("timeSheetDelete?timesheet_id="+id+"&date="+date+"&project_id="+project_id+"&action=addPage");
			}
				else
				{
					window.location.replace("addTimesheet.jsp?date="+date+"&project_id="+project_id);
					return false;
		 		}
	
}



function timesheetUnplanDelete(id) {
	
	var date = document.getElementById("date").value;
	var project_id = document.getElementById("project_id").value;
	
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("timeSheetDelete?timesheet_id="+id+"&date="+date+"&project_id="+project_id+"&action=addPage&unplan=unplan");
		}
			else
			{
				window.location.replace("addTimesheet.jsp?date="+date+"&project_id="+project_id);
				return false;
	 		}
	
}


function autoSubmit(id) {
	document.getElementById(id).submit();
}

function autoSubmit1() {
	document.getElementById('addTimesheet').submit();
}

function autoPercentage(id) {
	
	var days = document.getElementById("totalDays"+id).value;
	var workHour = document.getElementById(id).value;
	var percentage = document.getElementById("percentage"+id).value;
	
	
	
	var percentageValue = (workHour * 100)/(days*8);
	var n = percentageValue.toFixed(2);
	
	 document.getElementById("percentage"+id).value = n;
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
	
	
	
function checkhrs(id) {
	
	var a = 'hours'+id;
	
	var b = document.getElementById(a).value;
	
	if(b == 0){
		document.getElementById(a).value = "";
	}
	
	if(id == 0){
		
	}
}	


function checkhrs1() {
	
	var b = document.getElementById('workHours').value;
	
	if(b == 0){
		document.getElementById('workHours').value = "";
	}
	
}	

	
function checkhrs2() {
	
	var b = document.getElementById('unplanWorkedHours').value;
	
	if(b == 0){
		document.getElementById('unplanWorkedHours').value = "";
	}
	
}	

</script>
<head>
<script src="dist/js/dontBack.js"></script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns" onload="startTimer()">
<!-- <div class="se-pre-con" align="center" style="padding : 370px;"><h3>Loading...</h3></div> -->
	<%
	double w = 0;
	int manager_id = user.getManagerBean().getManager_id();
	int dept_id = user.getDepartmentBean().getDepartment_id();
	
	/* if(employee_master_id == 1166 || employee_master_id == 1836){
		dept_id = 18;
	} */
	
	
	int project_id = 0;
	String date = null;
	String approval_status = null;
	String status = null;
	
		if(request.getParameter("project_id") != null){
		project_id = Integer.parseInt(request.getParameter("project_id"));
		date = request.getParameter("date");
		}else{
			project_id = (Integer) request.getAttribute("project_id");
			date =(String) request.getAttribute("date");
		}
		
		
		AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();
		List<Object[]> duplicatTimesheetForDate = allListDAO.getDuplicateDateTimesheet(employee_master_id, date);
		
		
		int client_master_id = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currdate = new Date();
		Date date1 = dateFormat.parse(date);
		
		
		List<Object[]> getdailyTimeSheetList = allListDAO.getdayTimeSheetList(employee_master_id, date);
		double workSum = 0;
		for (Object[] aRow : getdailyTimeSheetList) {
			TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
				workSum = workSum + timeSheetBean1.getWorked_hours();
				approval_status = timeSheetBean1.getApproval_status();
				status = timeSheetBean1.getTask_time_status();
		
		}
		
		List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheetList(employee_master_id, date);
		for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
				
			workSum = workSum + unplanProjectBean.getWorked_hours();
			approval_status = unplanProjectBean.getApproval_status();
			status = unplanProjectBean.getTask_time_status();
		}
		w = Double.parseDouble(String.format("%.2f", workSum));

	%>
	
	<input type="hidden" name="emp_id" id="emp_id" value="<%=employee_master_id%>">
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
				               				<h4 class="card-title" id="horz-layout-basic">Time-Sheet Management</h4>
				                		</div>
				            		</div>
				<div class="card-body collapse in">
	  <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
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
          	
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<div class="row">
													<div class="col-lg-6">
														<span class="icon-ios-calendar"></span> &nbsp;&nbsp;<b>All
															TIME-SHEET</b>
													</div>
        
													
												</div>
											</div>
						<br>
						<div class="panel-body">
						<form action="duplicatTimesheetCheck" id="addTimesheet" method="post">
						<input type="hidden" name="insert">
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
								%>
									<input type="text" class="form-control" name="date" id="date1"
										value="<%=date%>" style="width: 200px"
										onchange="autoSubmit1()" readonly="readonly">
								</div>

								<div class="col-md-1" align="center">
									<b>Project :</b>
								</div>
								<div class="col-md-4">
									<select class="form-control" name="project_id" id="addTimesheet" onchange="autoSubmit(this.id);">
										<option value="">---Select Project Name---</option>
										
										<%
																List<ProjectManagerListBean> listOfAssignProject = (ArrayList) allListDAO.listOfProjectWithActiveStatus(employee_master_id);
						   										
																for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
																	if(project_id == projectManagerListBean.getProjectMasterBean().getProject_master_id()){
															%>
										<option value="<%=projectManagerListBean.getProjectMasterBean().getProject_master_id()%>" selected="selected">
										<%if(!projectManagerListBean.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_code()%>:
										<%}%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_master_name()%></option>
										<%}else{ %>
										<option value="<%=projectManagerListBean.getProjectMasterBean().getProject_master_id()%>">
										<%if(!projectManagerListBean.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_code()%>:
										<%}%>
										<%=projectManagerListBean.getProjectMasterBean().getProject_master_name()%></option>
										<%} %>
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
											if(project_id == projectMasterBean.getProject_master_id()){				
															%>
										<option value="<%=projectMasterBean.getProject_master_id()%>" selected="selected">
										<%if(!projectMasterBean.getProject_code().equalsIgnoreCase("0")){%>
										<%=projectMasterBean.getProject_code()%>:
										<%}%>
										<%=projectMasterBean.getProject_master_name()%></option>
										<%}else{ %>
										<option value="<%=projectMasterBean.getProject_master_id()%>">
										<%if(!projectMasterBean.getProject_code().equalsIgnoreCase("0")){%>
										<%=projectMasterBean.getProject_code()%>:
										<%}%>
										<%=projectMasterBean.getProject_master_name()%></option>
										<%} %>
										<%} }%>
										
										
										
										
									<%
																List<Object[]> listOfProject = (ArrayList) allListDAO.assignedProjectList(employee_master_id);

																/* String sd = null;
						   										String ed = null; */
						   										
																for (Object[] parow : listOfProject) {
																	boolean flag = true;
																	ProjectAllocationBean p = (ProjectAllocationBean) parow[0];
																	EmployeeBean e = (EmployeeBean) parow[1];
																	ProjectMasterBean p1 = (ProjectMasterBean) parow[2];
																	TaskMasterBean t = (TaskMasterBean) parow[3];
																	
																	client_master_id = p1.getClientMasterBean().getClient_master_id();
																	
																
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
																	if(project_id == p.getProjectMasterBean().getProject_master_id()){
															%>
										<option value="<%=p.getProjectMasterBean().getProject_master_id()%>" selected="selected">
										<%if(!p1.getProject_code().equalsIgnoreCase("0")){ %>
										<%=p1.getProject_code()%>:
										<%}%>
										<%=p.getProjectMasterBean().getProject_master_name()%></option>
										<%}else{ %>
										<option value="<%=p.getProjectMasterBean().getProject_master_id()%>">
										<%if(!p1.getProject_code().equalsIgnoreCase("0")){%>
										<%=p1.getProject_code()%>:
										<%}%>
										<%=p.getProjectMasterBean().getProject_master_name()%></option>
										<%} %>
										<%} }%>
									
										
										<%if(project_id == 0){ %>
										<option value="0" selected="selected">Unplan Project</option>
										<%}else{ %>
										<option value="0">Unplan Project</option>
										<%} %>
										
										<%if(project_id == 1){ %>
										<option value="1" selected="selected">Other Project</option>
										<%}else{ %>
										<option value="1">Other Project</option>
										<%} %>
									</select>
								</div>
										<div class="col-md-3" align="right">
													<a href="timesheet.jsp"><button class="btn btn-primary"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Back">
									<span class="icon icon-reply"></span>&nbsp;&nbsp;<b>Back To Home</b></button></a>
														
													</div>
						</form>
							</div>
						</div>
						<br>
						<%if(project_id == 0 || project_id == 1){ %>
							<form action="unplanProjectInsert" id="employeeTimeSheetInsert"  method="post" enctype="multipart/form-data">
						<%}else{ %>
							<form action="timeSheetInsert" id="employeeTimeSheetInsert"  method="post" enctype="multipart/form-data">
						<%} %>
						
						<input type="hidden" name="date" id="date" value="<%=date%>">
						<input type="hidden" name="day_id" value="<%=day_id%>">
						<input type="hidden" name="project_master_id" id="project_id" value="<%=project_id%>">
						<input type="hidden" name="client_master_id" value="<%=client_master_id%>">
						<input type="hidden" name="data" id="data" value="">
						<div class="row">
						<div class="col-lg-12">
						<div class="panel-body">
								<div class="table-responsive">
								<p align="right"><b>Total Work hours : <font color="red"><%=w%> hour(s)</font></b></p>
								<%if(project_id != 0 && project_id != 1 ){ %>
									<table class="table table-striped table-bordered table-hover" id="dataTables">
										<thead>
											<tr bgcolor="#C6C3C2">
												<th name="taskName">Task
													Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
												<th>Worked Hours</th>
												<!-- <th>% Completed</th> -->
												<th>Start Date</th>
												<th>End Date</th>
												<th>Comment</th>
											</tr>
														
										</thead>
										<tbody>
											
											<%
																			AllTimesheetListDAO taskMasterList = new AllTimesheetListDAO();
																			List<Object[]> listOfTask = taskMasterList.assignedTaskList(project_id,employee_master_id);
																			String sd = null;
									   										String ed = null;
																			
																			for (Object[] aRow : listOfTask) {
																				ProjectAllocationBean projectAllocationBean = (ProjectAllocationBean) aRow[0];
																				ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[1];
																				EmployeeBean employeeBean =(EmployeeBean) aRow[2];
																				TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[3];
																						
																				String startDate = taskMasterBean.getTask_planned_start_date();
										   										String endDate = taskMasterBean.getTask_planned_end_date();
																				
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
												<td>
												<input type="hidden" name="task_master_id" value="<%=taskMasterBean.getTask_master_id()%>">
												<%=taskMasterBean.getTask_master_name()%></td>
												<td width="97px">
													<% String[] split = taskMasterBean.getTask_estimated_duration().split(" "); 
													   String value = split[0];
													%>
												<input type="hidden" name="totaldaye" id="totalDays<%=taskMasterBean.getTask_master_id()%>" value="<%=value%>">
												
												<input type="text" class="txt"
													size="3" name="workedHours" id="hours<%=taskMasterBean.getTask_master_id() %>" value="0"
													onchange="checkInteger(this.id); autoPercentage(this.id)" required></td>
												
												<input type="hidden" name="percentage_completed"  size="3" id="percentage<%=taskMasterBean.getTask_master_id()%>" onchange="handleChange(this.id); checkInteger(this.id)"
																		value="0">
												<td><%=sd%></td>
												<td><%=ed%></td>
												
												<td>
												<textarea rows="" cols="" class="form-control" name="comment" id="<%=taskMasterBean.getTask_master_id() %>" placeholder="Max 5000 words" oninput="checkhrs(this.id)"></textarea>
												
												<!-- <input type="text" class="form-control" name="comment" value="" placeholder="Max 500 words"> -->
													
													<input type="hidden" name="insert">
												</td>
												</tr>
												<%} %>
											
											<tr>
										<td>
										
										<input type="hidden" name="unplannedTask" value="0">
										
										
										<script type="text/javascript">
										
										function disable(){
											$("#subTask1").fadeIn('fast');
											document.getElementById('unplanTaskName').disabled = false;
										}
										</script>
										
										
										
										
										
										
										<div class="col-md-11" style="padding-right: 0px;padding-left: 0PX">
										
											<select class="form-control" name="task_master_id" id="unplanTaskId">
												<option value="0">---Select Task---</option>
												<option value="0">Other Task</option>
												<%List<TaskMasterBean> listOfTask1 = allListDAO.getTaskListForUnallocatedProject(project_id, employee_master_id,dept_id);
			                                    	for(TaskMasterBean t : listOfTask1){%>
													<option value="<%=t.getTask_master_id()%>"><%=t.getTask_master_name() %></option>
												<%} %>
											</select>
											
										</div>
													
										<div class="col-md-1" style="padding-left: 15px; padding-right: 0px;">
											<a style="cursor: pointer;" onclick="disable()"><i class="icon-plus-circled"  id="hideButton" style="padding-top: 8px;"></i></a>
										</div>
										
										<br><br>
										<div class="col-md-11" style="padding-right: 0px;padding-left: 0PX">
										<div id="subTask1" style="padding-top: 5px;"><input type="text" class="form-control" name="taskName" id="unplanTaskName"  placeholder="Enter Task Name" disabled="disabled"></div>
										</div>
										
										
										
										</td>
												<%-- <input type="text" name="taskName" value="<%=projectAllocationBean.getTaskMasterBean().getTask_master_name()%>"> --%>

										<td width="97px">
											<input type="text" class="txt"
											size="3" name="workedHours" id="unplanWorkedHours" value="0"
											onchange="checkInteger(this.id);checkTask();" required>
										</td>
										
										<input type="hidden" name="percentage_completed" size="3"
																value="0">
										<td>-</td>
										<td>-</td>
										<td>
											<textarea rows="" cols="" class="form-control" name="comment" placeholder="Max 5000 words"  oninput="checkhrs2()"></textarea>
												
												<!-- <input type="text" class="form-control" name="comment" value="" placeholder="Max 500 words"> -->
													
												<input type="hidden" name="insert">
												</td>
											</tr>

										</tbody>
	<!-- 	<tr id="summation" style="visibility: hidden;">
		<td>&nbsp;</td>
		<td align="right">Sum :</td>
		<td align="center"><span id="sum">0</span></td>
		</tr> -->
										
									</table>
					<%}else if(project_id == 0){ %>
								<table class="table table-striped table-bordered table-hover" id="dataTables">
										<thead>
											<tr bgcolor="#C6C3C2">
												<th name="taskName">Project
													Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<!-- <th>% Completed</th> -->
												<th>Comment</th>
											</tr>
														
										</thead>
										<tbody>
												<tr>
												<td>
												<input list="project" id="12" class="form-control" name="project_name" placeholder="Enter Project Name">
												<td><input type="text" class="form-control" name="task_name" value="" placeholder="Enter Task Name"></td>
												<td width="97px"><input type="text" class="txt"
													size="3" name="workedHours" id="workHours" value="0"
													onchange="checkInteger(this.id);"  required></td>
													<input type="hidden" name="percentage_completed" size="3" id="percentage" onchange="handleChange(this.id); checkInteger(this.id)"
																		value="0" >
												<td>
												<textarea rows="" cols=""  class="form-control" name="comment" value=""  placeholder="Max 5000 words" oninput="checkhrs1()"></textarea>
												
												<!-- <input type="text" class="form-control" name="comment" value="" placeholder="Max 500 words"> -->
													<input type="hidden" name="insert">
												</td>
												</tr>
												
											
										</tbody>
		<!-- <tr id="summation" style="visibility: hidden;">
		<td>&nbsp;</td>
		<td align="right">Sum :</td>
		<td align="center"><span id="sum">0</span></td>
		</tr> -->
										
									</table>
								
								<%}else if(project_id == 1){ %>
												
									<table class="table table-striped table-bordered table-hover" id="dataTables">
										<thead>
											<tr bgcolor="#C6C3C2">
												<th name="taskName">Project
													Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<!-- <th>% Completed</th> -->
												<th>Comment</th>
											</tr>
														
										</thead>
										<tbody>
												<tr>
												<td>
	  												<select class="form-control" name="projectIdd" id="projectIdd" onchange="java:response(this.value,<%=dept_id%>);">
														<option value="0">---Select Project---</option>
	  												<%List<ProjectMasterBean> listOfActiveProject = allListDAO.getListOfAllProject();
	  												for(ProjectMasterBean projectMasterBean : listOfActiveProject){
	  												%>
			  				 							 <option value="<%=projectMasterBean.getProject_master_id()%>">
			  				 							 <%if(!projectMasterBean.getProject_code().equalsIgnoreCase("0")){%>
			  				 							 	<%=projectMasterBean.getProject_code()%>:
														 <%}%>
			  				 							 <%=projectMasterBean.getProject_master_name()%></option>
			  				 							 <%} %>
													</select>
													</td>
													
												<td>
												
													<div class="col-md-11" style="padding-right: 0px;padding-left: 0PX">
													<select class="form-control" name="task_id" id="taskName1">
														<option value="0">---Select Task---</option>
													</select>
													</div>
													<div class="col-md-1" style="padding-left: 15px; padding-right: 0px;">
													<a style="cursor: pointer;" onclick="showTextBox()"><i class="icon-plus-circled"  id="hideButton" style="padding-top: 8px;"></i></a>
													</div>
													<br>
													<br>
													<div id="subTask" style="padding-top: 5px;"><input type="text" name="subTask" placeholder="Enter Sub Task" class="form-control"></div>
													
												<!-- <img src="img/arrow.png" id="imgLoader" style="visibility: hidden;"> -->
												
												
												<!-- <input type="text" class="form-control" name="task_name" value="" placeholder="Enter Task Name"> -->
												<!-- <input list="task" class="form-control" name="task_name" placeholder="Enter Task Name">
			  									<datalist id="taskID">
			  				 			 		<option value=""/>
		                         				</datalist> -->
												</td>
												
												<td width="97px"><input type="text" class="txt"
													size="3" name="workedHours" id="workHours" value="0"
													onchange="checkInteger(this.id);"  required>
													<input type="hidden" name="percentage_completed" size="3" id="percentage" onchange="handleChange(this.id); checkInteger(this.id)" value="0" > 
												</td>
												
												<td>
												<textarea rows="" cols=""  class="form-control" name="comment" value=""  placeholder="Max 5000 words" oninput="checkhrs1()"></textarea>
												
												<!-- <input type="text" class="form-control" name="comment" value="" placeholder="Max 500 words"> -->
													<input type="hidden" name="insert">
												</td>
												</tr>
												
											
										</tbody>
		<!-- <tr id="summation" style="visibility: hidden;">
		<td>&nbsp;</td>
		<td align="right">Sum :</td>
		<td align="center"><span id="sum">0</span></td>
		</tr> -->
										
									</table>			
								<%} %>
								
								</div>
						</div>
						</div>
						</div>
						
						
						

					<!-- <br>
						<br> -->
							<div class="row">
								<div class="col-lg-12">
									<div class="panel panel-default">
									<%String d1 = null;
									int size = getdailyUnplanTimeSheetList.size() + getdailyTimeSheetList.size();
										try {
										  
											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
											Date result = formater.parse(date);
											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
											d1 = AppDateFormat.format(result);
											System.out.println(AppDateFormat.format(result));
											
											
											
										} catch (ParseException e1) {
											e1.printStackTrace();
										}	 %>
										<div class="panel-heading" align="left"><span class="icon icon-ios-calendar"></span> &nbsp;&nbsp;<b>Overall Timesheet for Date : <%=d1%></b></div>
										<br>
										<div class="panel-body">
											<div class="dataTable_wrapper">
											<table class="table table-striped table-bordered table-hover" id="dataTables">

											<tr>
												<th>Project Name</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<!-- <th>% Completed</th> -->
												<th>Comment</th>
												
												<th>Action</th>
												
											</tr>

											<%
											
											
											
											for (Object[] aRow : getdailyTimeSheetList) {
												String d = null;
												TimeSheetBean timeSheetBean1 = (TimeSheetBean) aRow[0];
												
												if(timeSheetBean1.getUnplanned_task()== 1){
											%>
												<tr bgcolor="#F1D194">
											<%}else{ %>
												<tr>
											<%} %>
												<input type="hidden" name="timesheet_id" value="<%=timeSheetBean1.getTimesheet_master_id()%>">
												<input type="hidden" name="action" value="planUpdate">
												
												<td>
												<%if(!timeSheetBean1.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")){ %>
													<%=timeSheetBean1.getProjectMasterBean().getProject_code()%> : 
												<%}%>
													<%=timeSheetBean1.getProjectMasterBean().getProject_master_name() %></td>
												
												<td><input type="hidden" name="task_master_id" value="<%=timeSheetBean1.getTaskMasterBean().getTask_master_id()%>"><%=timeSheetBean1.getTaskMasterBean().getTask_master_name() %></td>
												<td width="97px"><input type="text" class="txt"
													size="3" name="workedHours" id="workHours<%=timeSheetBean1.getTimesheet_master_id()%>" value="<%=timeSheetBean1.getWorked_hours()%>"
													onchange="checkInteger(this.id);"></td>
												<input type="hidden" name="percentage_completed" class="form-control"  size="3" id="percentage" onchange="handleChange(this.id); checkInteger(this.id)"
																		value="<%=timeSheetBean1.getPercentage_completed()%>">
												<td><textarea class="form-control" name="comment" placeholder="Max 5000 words"><%=timeSheetBean1.getEmployee_comment()%></textarea>
												<input type="hidden" name="update">
												</td>
												
												
												<td>
												<a href="#"><i class="icon icon-trash" style="color: red" onclick="timesheetDelete(<%=timeSheetBean1.getTimesheet_master_id()%>)"></i></a>
  												</td>
												
												
											</tr>
											<%} %>
											
											
											<%
											for(UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
												String d = null;
												
											%>
											<tr bgcolor="#F1D194">
												<input type="hidden" name="unplanUpdate">
												<input type="hidden" name="timesheet_id" value="<%=unplanProjectBean.getTimesheet_unplan_project_id()%>">
												<input type="hidden"  name="action" value="unPlanUpdate">
											
												<td><input type="text" class="form-control" name="project_name" value="<%=unplanProjectBean.getProject_name()%>" placeholder="Enter Project Name"></td>
												<td><input type="text" class="form-control" name="task_name" value="<%=unplanProjectBean.getTask_name()%>" placeholder="Enter Task Name"></td>
												<td width="97px"><input type="text" class="txt"
													size="3" name="workedHours" id="workHours<%=unplanProjectBean.getTimesheet_unplan_project_id()%>" value="<%=unplanProjectBean.getWorked_hours()%>"
													onchange="checkInteger(this.id);"></td>
													<input type="hidden" name="percentage_completed" size="3" class="form-control" id="percentage" onchange="handleChange(this.id); checkInteger(this.id)"
																		value="<%=unplanProjectBean.getPercentage_completed()%>">
												<td><textarea class="form-control" name="comment" placeholder="Max 5000 words"><%=unplanProjectBean.getEmployee_comment()%></textarea>
												<input type="hidden" name="update">
												
												<td>
												<a href="#"><i class="icon icon-trash" style="color: red" onclick="timesheetUnplanDelete(<%=unplanProjectBean.getTimesheet_unplan_project_id()%>)"></i></a>
												</td>
												
											</tr>
											<%} %>
											</table>
											</div>
											<br>
											<div align="left">
											<b>NOTE :</b>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon icon-stop" style="color:#F1D194;"></i><b> : Unplanned Task</b>
														&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon icon-trash" style="color: red"></i><b> : Delete Task</b>
														
											
										
									</div>
											</div>
											</div>
											<input type="hidden" name="redirect">
								<div align="right" style="padding-right: 30px;">
								<input type="button" class="btn btn-success" value="Save" onclick="save(1)"/>&nbsp;&nbsp;&nbsp;
								<input type="button" class="btn btn-primary" value="Submit" onclick="save(2);	"/>
								</div>
									
							<br>	
								</form>			
							</form>
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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	  <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
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
	<script>
	$(document).ready(function(){
		$("#subTask1").fadeOut('slow');
		$("#subTask").fadeOut('slow');
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
				$('#workHours').val(0);
			}
			 else if(sum < 8)
				{
				alert("WorkedHours can not be less than 8");
				}  */
				
				
		});
		//.toFixed() method will roundoff the final sum to 2 decimal places
		var sumOfWorkHour =parseInt($('#sumOfworkHours').val());
		
		var totalWorkHour = sum;
		<%if(employee_master_id != 1836){%>
		if(totalWorkHour>24){
			alert("WorkedHours can not be greater than 24");
			$('#workHours').val(0);
			$('#unplanWorkHours').val(0);
			$('.txt').val(0);
			for(var a = 0;a<=5000;a++){
				/* $('#'+a).val(0); */
				$('#workHours'+a).val(0);
			}
		}
		<%}%>
		
		$("#sum").html(sum.toFixed(2));
	}
</script>
</body>
</html>