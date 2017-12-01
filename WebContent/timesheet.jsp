<%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="com.hrms.pms.bean.ProjectManagerListBean"%>
<%@page import="com.hrms.pms.bean.ProjectAssignToManagerBean"%>
<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
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

<style type="text/css">
.txt {
	text-align: center;
	line-height: 6vh;
}

th a {
	display: block;
	width: 100%;
	text-decoration: none;
}

a {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
	cursor: pointer;
}
</style>


<script type="text/javascript">

function replica(id){
	
	var a = document.getElementById("date1");
	var b = document.getElementById();
	
	b.value = a.value;
	
}


function refresh(id){
	
	var date = document.getElementById("date1").value;
	window.location.replace("timesheet.jsp?date="+date);
	
}

function validateForm() {
    var x = document.getElementById("date1").value;
    if (x == null || x == "") {
        alert("Date must be filled out");
        return false;
    }
}
</script>
<script>
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
<style>
/* 	#BFE8C1 */
.ui-datepicker-unselectable.gesloten span.ui-state-default {
	background: #999999 !important;
	border-color: #999999 !important;
	text-decoration: line-through;
}

.ui-datepicker-unselectable.verhuurt span.ui-state-default {
	background: #BFE8C1; /* APPROVED */
	border-color: #BFE8C1 !important;
	color: black !important;
}

.ui-datepicker-unselectable.verhuurt1 span.ui-state-default {
	background: #BFCDE8; /* SUBMITTED */
	border-color: #BFCDE8 !important;
	color: black !important;
}

.ui-datepicker-unselectable.verhuurt2 span.ui-state-default {
	background: #E8BFC2; /* REJECTED */
	border-color: #E8BFC2 !important;
	color: black !important;
}
</style>
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
</head>
<body onload="startTimer();">
	<!-- <div class="se-pre-con" align="center" style="padding : 370px;"><h3>Loading...</h3></div> -->
	<%
		int manager_id = user.getManagerBean().getManager_id();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = null;
		if (request.getParameter("date") != null) {
			currDate = request.getParameter("date");
		} else if (request.getAttribute("date") != null) {
			currDate = (String) request.getAttribute("date");
		} else {
			Date did = new Date();
			currDate = dateFormat.format(did);
		}

		Calendar now = Calendar.getInstance();

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM");
		SimpleDateFormat format3 = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		String[] days = new String[7];
		String[] days1 = new String[7];
		String[] days2 = new String[7];

		if (request.getParameter("date") != null) {
			String date = request.getParameter("date");
			Date result1 = format1.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(result1);//Set specific Date if you want to

			for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
				System.out.println(i);//Returns Date
				int k = i - 1;
				cal.set(Calendar.DAY_OF_WEEK, i);
				days[k] = format.format(cal.getTime());
				days1[k] = format1.format(cal.getTime());
				days2[k] = format3.format(cal.getTime());
				System.out.println(cal.getTime());//Returns Date
			}
		} else if (request.getAttribute("date") != null) {

			String date = (String) request.getAttribute("date");
			Date result1 = format1.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(result1);//Set specific Date if you want to

			for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
				System.out.println(i);//Returns Date
				int k = i - 1;
				cal.set(Calendar.DAY_OF_WEEK, i);
				days[k] = format.format(cal.getTime());
				days1[k] = format1.format(cal.getTime());
				days2[k] = format3.format(cal.getTime());
				System.out.println(cal.getTime());//Returns Date
			}

		} else {
			int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1; //add 2 if your week start on monday
			now.add(Calendar.DAY_OF_MONTH, delta);
			for (int i = 0; i < 7; i++) {
				days[i] = format.format(now.getTime());
				days1[i] = format1.format(now.getTime());
				days2[i] = format3.format(now.getTime());
				now.add(Calendar.DAY_OF_MONTH, 1);
			}

		}
	%>



	<%
		List<String> listOfApprovedDates = new ArrayList();
		List<String> listOfRejectedDates = new ArrayList();
		List<String> listOfPendingDates = new ArrayList();

		AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();

		/* List<TimeSheetBean> getWeeklyTimesheet2 = allListDAO.getAllTimesheet(user.getEmployee_master_id());
		List<UnplanProjectBean> getUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheet(user.getEmployee_master_id());;
		
		for(TimeSheetBean timeSheetBean : getWeeklyTimesheet2){
			String date = timeSheetBean.getDate();
			String d1 = null;	
				try {
					  
					SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
					Date result2 = formater1.parse(date);
					SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					d1 = AppDateFormat1.format(result2);
					if(timeSheetBean.getApproval_status().equalsIgnoreCase("approved")){
						listOfApprovedDates.add(d1);
					}else if(timeSheetBean.getApproval_status().equalsIgnoreCase("rejected")){
						listOfRejectedDates.add(d1);
					}else if(timeSheetBean.getApproval_status().equalsIgnoreCase("pending") && timeSheetBean.getTask_time_status().equalsIgnoreCase("submit")){
						listOfPendingDates.add(d1);
					}
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}	
		}
		 */

		/* for(UnplanProjectBean timeSheetBean : getUnplanTimeSheetList){
			String date = timeSheetBean.getDate();
			String d1 = null;	
				try {
					  
					SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
					Date result2 = formater1.parse(date);
					SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					d1 = AppDateFormat1.format(result2);
					if(timeSheetBean.getApproval_status().equalsIgnoreCase("approved")){
						listOfApprovedDates.add(d1);
					}else if(timeSheetBean.getApproval_status().equalsIgnoreCase("rejected")){
						listOfRejectedDates.add(d1);
					}else if(timeSheetBean.getApproval_status().equalsIgnoreCase("pending")){
						listOfPendingDates.add(d1);
					}
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}	
		}
		 */
	%>
	 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
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
								<%
									if (request.getAttribute("error") != null) {
								%>
								<div class="panel-body" id="panelbody">
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${error}
									</div>
								</div>
								<%
									}
								%>
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-body">
												<!-- /.panel-body -->
												<form action="duplicatTimesheetCheck" method="get">
													<input type="hidden" name="insert">
													<div class="row">

														<div class="col-md-1" align="right">
															<b>Date :</b>
														</div>
														<div class="col-md-3">
															<input type="text" class="form-control" name="date"
																id="date1" value="<%=currDate%>" style="width: 200px"
																onchange="refresh(this.id)">
														</div>

														<div class="col-md-1" align="center">
															<b><span class="blink1">Project :</span></b>
														</div>
														<div class="col-md-4">
															<select class="form-control" name="project_id" required>

																<option value="">---Select Project Name---</option>

																<%
																	AllListDAO allListDAO2 = new AllListDAO();
																	List<ProjectManagerListBean> listOfAssignProject = (ArrayList) allListDAO
																			.listOfProjectWithActiveStatus(employee_master_id);

																	for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
																%>
																<option
																	value="<%=projectManagerListBean.getProjectMasterBean().getProject_master_id()%>">
																	<%
																		if (!projectManagerListBean.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")) {
																	%>
																	<%=projectManagerListBean.getProjectMasterBean().getProject_code()%>:
																	<%
																		}
																	%>
																	<%=projectManagerListBean.getProjectMasterBean().getProject_master_name()%></option>
																<%
																	}
																%>



																<%
																	List<ProjectMasterBean> listOfProjectMaster = allListDAO.getListOfProjectMaster(manager_id);
																	for (ProjectMasterBean projectMasterBean : listOfProjectMaster) {
																		boolean flag = true;
																		for (ProjectManagerListBean projectManagerListBean : listOfAssignProject) {
																			if (projectManagerListBean.getProjectMasterBean().getProject_master_id() == projectMasterBean
																					.getProject_master_id()) {
																				flag = false;
																			}
																		}
																		if (flag == true) {
																%>
																<option
																	value="<%=projectMasterBean.getProject_master_id()%>">
																	<%
																		if (!projectMasterBean.getProject_code().equalsIgnoreCase("0")) {
																	%>
																	<%=projectMasterBean.getProject_code()%>:
																	<%
																		}
																	%>
																	<%=projectMasterBean.getProject_master_name()%></option>
																<%
																	}
																	}
																%>



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
																			if (projectManagerListBean.getProjectMasterBean().getProject_master_id() == p.getProjectMasterBean()
																					.getProject_master_id()) {
																				flag = false;
																			}
																		}

																		for (ProjectMasterBean projectMasterBean : listOfProjectMaster) {
																			if (projectMasterBean.getProject_master_id() == p.getProjectMasterBean().getProject_master_id()) {
																				flag = false;
																			}
																		}

																		if (flag == true) {
																%>
																<option
																	value="<%=p.getProjectMasterBean().getProject_master_id()%>">
																	<%
																		if (!p.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")) {
																	%>
																	<%=p.getProjectMasterBean().getProject_code()%>:
																	<%
																		}
																	%>
																	<%=p.getProjectMasterBean().getProject_master_name()%></option>
																<%
																	}
																%>
																<%
																	}
																%>




																<option value="0">Unplan Project</option>
																<option value="1">Other Project</option>
															</select>
														</div>

														<div class="col-md-3">
															<input type="submit" class="btn btn-primary"
																value="Add Timesheet">
														</div>

													</div>
												</form>

												<br> <br>
												<!-- /.panel -->

												<div class="row">
													<div class="col-lg-12">
														<div class="panel panel-default">
															<div class="panel-heading">
																<div class="row">
																	<div class="col-lg-6" align="left">
																		<span class="icon-ios-calendar"></span>
																		&nbsp;&nbsp;<b>Weekly Timesheet</b>
																	</div>
																	<div class="col-lg-6" align="right">
																		<a href="showAllTimeSheetDetail.jsp"><button class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Back">
																				<span class="icon icon-ios-calendar"></span>&nbsp;&nbsp;Show
																				All Timesheet
																			</button></a>
																	</div>
																</div>
															</div>
															<div class="panel-body">
																<div class="dataTable_wrapper">


																	<h4 align="left">Planned List</h4>
																	<div class="table-responsive">
																		<table class="table table-bordered"
																			style="width: 1000px;">

																			<tr bgcolor="#C6C3C2">
																				<th rowspan="2"><div class="txt">Project
																						Name</div></th>
																				<td colspan="8"><center>
																						<b>Week : <%=days2[0].toString()%> to <%=days2[6].toString()%></b>
																					</center>
																				</th>
																			</tr>

																			<tr bgcolor="#C6C3C2">
																				<%
																					for (int i = 0; i < days.length; i++) {
																						int dayId = 0;
																						if (i == 0) {
																							dayId = 7;
																						} else {
																							dayId = i;
																						}

																						DayBean dayBean = allListDAO.getDayNameByDayId(dayId);
																				%>
																				<th><center>
																						<a
																							href="duplicatTimesheetCheck?date=<%=days1[i]%>&update=update"
																							style="color: black; text-decoration: none;"
																							data-toggle="tooltip" data-placement="top"
																							title="Click here to show timesheet of <%=days[i]%>">
																							<%=dayBean.getDay()%> <br> <%=days[i]%></a>
																					</center></th>
																				<%
																					}
																				%>
																				<th><center>Total</center></th>
																			</tr>
																			<%
																				for (Object[] parow : listOfProject) {

																					double total = 0;

																					ProjectAllocationBean p = (ProjectAllocationBean) parow[0];
																					EmployeeBean e = (EmployeeBean) parow[1];
																					ProjectMasterBean p1 = (ProjectMasterBean) parow[2];
																					TaskMasterBean t = (TaskMasterBean) parow[3];

																					int project_id = p1.getProject_master_id();

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
																			%>
																			<tr>
																				<th bgcolor="#C6C3C2">
																					<%
																						String project_name = p.getProjectMasterBean().getProject_master_name();
																					%>
																					<%
																						if (!p.getProjectMasterBean().getProject_code().equalsIgnoreCase("0")) {
																					%>
																					<%=p.getProjectMasterBean().getProject_code()%> : <%
																						}
																					%>
																					<%=project_name%>
																				</th>

																				<%
																					for (String d : days1) {
																							List<TimeSheetBean> listOfTimesheet = allListDAO.getSumOfHoursEmployeeWise(employee_master_id, d,
																									project_id);
																							double sum = 0;
																							String status = "null";
																							String approval_status = "null";
																							for (TimeSheetBean timeSheetBean : listOfTimesheet) {

																								sum = sum + timeSheetBean.getWorked_hours();
																								status = timeSheetBean.getTask_time_status();
																								approval_status = timeSheetBean.getApproval_status();

																							}
																				%>
																				<%
																					total = total + sum;
																				%>

																				<td>
																					<center><%=sum%></center>
																				</td>
																				<%
																					}
																				%>
																				<th><center><%=total%></center></th>
																			</tr>
																			<%
																				}
																			%>


																			<tr>
																				<th bgcolor="#C6C3C2"><center>Total</center></th>
																				<%
																					double total = 0;
																					for (String d : days1) {
																						List<TimeSheetBean> listOfTimesheet = allListDAO.getSumOfHoursEmployeeWise1(employee_master_id, d);
																						double sum = 0;
																						String status = "null";
																						String approval_status = "null";
																						String rejection_reason = null;
																						for (TimeSheetBean timeSheetBean : listOfTimesheet) {
																							sum = sum + timeSheetBean.getWorked_hours();
																							status = timeSheetBean.getTask_time_status();
																							approval_status = timeSheetBean.getApproval_status();
																							rejection_reason = timeSheetBean.getRejection_reason();

																						}
																				%>
																				<%
																					if (status.equalsIgnoreCase("saved")) {
																				%>
																				<th>
																					<%
																						} else if (status.equalsIgnoreCase("submit")) {
																					%> <%
 	if (approval_status.equalsIgnoreCase("approved")) {
 %>
																				
																				<th bgcolor="#BFE8C1">
																					<%
																						} else if (approval_status.equalsIgnoreCase("rejected")) {
																					%>
																				
																				<th bgcolor="#E8BFC2" data-toggle="tooltip"
																					data-placement="top" title="<%=rejection_reason%>">
																					<%
																						} else {
																					%>
																				
																				<th bgcolor="#BFCDE8">
																					<%
																						}
																					%> <%
 	} else {
 %>
																				
																				<th>
																					<%
																						}
																					%>
																					<%
																						total = total + sum;
																					%>
																					<center><%=sum%></center>
																				</th>
																				<%
																					}
																				%>
																				<th><center><%=total%></center></th>
																			</tr>
																		</table>
																	</div>
																</div>

																<br> <br>
																<h4 align="left">Unplanned List</h4>
																<div class="table-responsive">
																	<table class="table table-bordered "
																		style="width: 1000px;">

																		<tr bgcolor="#C6C3C2">
																			<th rowspan="2"><div class="txt">Project
																					Name</div></th>
																			<th colspan="8"><center>
																					Week :
																					<%=days2[0].toString()%>
																					to
																					<%=days2[6].toString()%></center></th>
																		</tr>

																		<tr bgcolor="#C6C3C2">
																			<%
																				for (int i = 0; i < days.length; i++) {
																					int dayId = 0;
																					if (i == 0) {
																						dayId = 7;
																					} else {
																						dayId = i;
																					}
																					DayBean dayBean = allListDAO.getDayNameByDayId(dayId);
																			%>
																			<th><center>
																					<a
																						href="duplicatTimesheetCheck?date=<%=days1[i]%>&update=update"
																						style="color: black; text-decoration: none;"
																						data-toggle="tooltip" data-placement="top"
																						title="Click here to show timesheet of <%=days[i]%>">
																						<%=dayBean.getDay()%><br><%=days[i]%></a>
																				</center></th>
																			<%
																				}
																			%>
																			<th><center>Total</center></th>
																		</tr>

																		<%-- <%for (Object[] parow : listOfProject) {
												
												double total1 = 0;
												 
																	ProjectAllocationBean p = (ProjectAllocationBean) parow[0];
																	EmployeeBean e = (EmployeeBean) parow[1];
																	ProjectMasterBean p1 = (ProjectMasterBean) parow[2];
																	TaskMasterBean t = (TaskMasterBean) parow[3];
																	
																	int project_id = p1.getProject_master_id();
 																			
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
							   										}%>	
											<tr>
											<th bgcolor="#C6C3C2"><%=p.getProjectMasterBean().getProject_master_name() %></th>
											
											<% 
											 for(String  d : days1){
											 List<TimeSheetBean> listOfTimesheet = allListDAO.getSumOfUnplannedTaskHoursEmployeeWise(employee_master_id, d, project_id);
											 double sum = 0;
											 String status = "null";
											 String approval_status = "null";
											 for(TimeSheetBean timeSheetBean : listOfTimesheet){
												 
												 sum = sum + timeSheetBean.getWorked_hours();
												 status = timeSheetBean.getTask_time_status();
												 approval_status = timeSheetBean.getApproval_status();
											 }
											 %>
											 <%total1 = total1 + sum;%>
											 <td>
											 <center><%=sum%></center>
											 </td>
	    									<%}%>
											
	    									<th><center><%=total1%></center></th>	
											</tr>
											<%}%> --%>

																		<tr>
																			<th bgcolor="#C6C3C2">Unplan Projects</th>
																			<%
																				double total2 = 0;
																				for (String d : days1) {
																					List<UnplanProjectBean> listOfTimesheet = allListDAO
																							.getSumOfHoursEmployeeWiseUnplanList(employee_master_id, d);
																					double sum = 0;
																					String status = "null";
																					String approval_status = "null";
																					String rejection_reason = null;
																					for (UnplanProjectBean timeSheetBean : listOfTimesheet) {
																						sum = sum + timeSheetBean.getWorked_hours();
																						status = timeSheetBean.getTask_time_status();
																						approval_status = timeSheetBean.getApproval_status();
																						rejection_reason = timeSheetBean.getRejection_reason();

																					}
																			%>
																			<td>
																				<%
																					total2 = total2 + sum;
																				%>
																				<center><%=sum%></center>
																			</td>
																			<%
																				}
																			%>
																			<th><center><%=total2%></center></th>
																		</tr>

																		<tr>
																			<th bgcolor="#C6C3C2"><center>Total</center></th>
																			<%
																				double total1 = 0;
																				String rejection_reason = "null";
																				for (String d : days1) {
																					List<TimeSheetBean> listOfTimesheet = allListDAO.getSumOfUnplannedTaskEmployeeWise1(employee_master_id,
																							d);
																					List<UnplanProjectBean> listOfTimesheet1 = allListDAO
																							.getSumOfHoursEmployeeWiseUnplanList(employee_master_id, d);
																					double sum = 0;
																					String status = "null";
																					String approval_status = "null";

																					for (TimeSheetBean timeSheetBean : listOfTimesheet) {
																						sum = sum + timeSheetBean.getWorked_hours();
																						status = timeSheetBean.getTask_time_status();
																						approval_status = timeSheetBean.getApproval_status();
																						rejection_reason = timeSheetBean.getRejection_reason();

																					}

																					for (UnplanProjectBean timeSheetBean : listOfTimesheet1) {
																						sum = sum + timeSheetBean.getWorked_hours();
																						status = timeSheetBean.getTask_time_status();
																						approval_status = timeSheetBean.getApproval_status();
																						rejection_reason = timeSheetBean.getRejection_reason();
																					}
																			%>
																			<%
																				if (status.equalsIgnoreCase("saved")) {
																			%>
																			<th>
																				<%
																					} else if (status.equalsIgnoreCase("submit")) {
																				%> <%
 	if (approval_status.equalsIgnoreCase("approved")) {
 %>
																			
																			<th bgcolor="#BFE8C1">
																				<%
																					} else if (approval_status.equalsIgnoreCase("rejected")) {
																				%>
																			
																			<th bgcolor="#E8BFC2" data-toggle="tooltip"
																				data-placement="top" title="<%=rejection_reason%>">
																				<%
																					} else {
																				%>
																			
																			<th bgcolor="#BFCDE8">
																				<%
																					}
																				%> <%
 	} else {
 %>
																			
																			<th>
																				<%
																					}
																				%> <%
 	total1 = total1 + sum;
 %>
																				<center><%=sum%></center>
																			</th>
																			<%
																				}
																			%>
																			<th><center><%=total1%></center></th>
																		</tr>
																	</table>
																</div>
																<br> <br>
																<div align="left">
																	<b>NOTE :</b>&nbsp;&nbsp;&nbsp;&nbsp;<i
																		class="icon icon-stop" style="color: #BFCDE8;"></i><b>
																		: Submitted</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
																		class="icon icon-stop" style="color: #BFE8C1;"></i><b>
																		: Approved</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
																		class="icon icon-stop" style="color: #E8BFC2;"></i><b>
																		: Rejected</b>
																</div>
															</div>

														</div>



													</div>
												</div>
												<!-- /.col-lg-12 -->
											</div>
											<!-- /.row -->
											<!-- /#page-wrapper -->
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
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->

	
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
	<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	<script>
			
			$(document).ready(function()
			{
				
				var $datepicker1 =  $( "#date1" );
			    var $datepicker2 =  $( "#datepicker2" );
				
			    var approveDates = [];
		    	var tool = [];
		    	var rejectedDates =[];
		    	var pendingDates =[];
	   
		    	
		    	<%for (int z =0; z <listOfApprovedDates.size(); z++)
		 		{
		 				String datedate = listOfApprovedDates.get(z);%>
		 				approveDates.push("<%=datedate%>");
		   		  <%}%>
		   		  
		   		  
		   		<%for (int y =0; y<listOfRejectedDates.size(); y++)
		 		{
		 				String datedate = listOfRejectedDates.get(y);%>
		 				rejectedDates.push("<%=datedate%>");
		   		  <%}%>
		   		  
		   		  
		   		<%for (int x=0; x<listOfPendingDates.size(); x++)
		 		{
		 				String datedate = listOfPendingDates.get(x);%>
		 				pendingDates.push("<%=datedate%>");
		   		  <%}%>
		    	
		    	
		   		function noSundaynoHoliday(date)
		   		{
		   			
		   				// Approved //
	   			 	 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
	   			 		var tooltipDate = "This date is Timesheet Approved!";
	   					if(approveDates.indexOf(string) != -1)
	   					{
	   						return [false,'verhuurt', tooltipDate];
	   					} 
	   					
	   					// Submited //
	   					var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
	   			 		var tooltipDate = "This date is Timesheet pending!";
	   					if(pendingDates.indexOf(string) != -1)
	   					{
	   						return [false,'verhuurt1', tooltipDate];
	   					} 
	   					
	   					// Rejected //
	   					var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
	   			 		var tooltipDate = "This date is Timesheet Rejected!";
	   					if(rejectedDates.indexOf(string) != -1)
	   					{
	   						return [true,'verhuurt2', tooltipDate];
	   					} 
	   				 return [true]
		   		}
		    	
		    	
		    	
		    	
		    	
	   		$datepicker1.datepicker({		
	   			dateFormat: 'yy-mm-dd' , 
	   		 	minDate: '-3',
	   		 	maxDate: '+10',
	   			beforeShowDay: noSundaynoHoliday,
	   			 changeMonth: true,
	   			 onSelect: function(dateStr)
	   			 {
	   				var date =  $datepicker1.datepicker('getDate');
	   				var currentdate = $.datepicker.formatDate('yy-mm-dd', date);
	   				
	   				window.location.replace("timesheet.jsp?date="+currentdate);
	   	        }
	   		});
	   		
			
			});

			
			
		
		
		</script>
</body>
</html>