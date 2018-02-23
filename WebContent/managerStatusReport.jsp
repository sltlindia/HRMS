<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="java.util.Collections"%>
<%@page import="com.hrms.timesheet.bean.DayBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.timesheet.bean.ProjectAllocationBean"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
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
   <title>Status Time Report</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
	<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
	<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">
<%@include file="header.jsp"%>
<script type="text/javascript">
/* function confSubmit() {
	var startDate = document.getElementById('plannedStartDate').value;
	var endDate  = document.getElementById('plannedEndDate').value;
	window.location.replace("statusReport?startDate="+startDate+"&endDate="+endDate);
} */
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
        $('#startDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#endDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">
<%AllListDAO allListDAO = new AllListDAO(); 
LoginDAO loginDAO = new LoginDAO();
int role_id = user.getRoleBean().getRole_id();
List<String> unplannedTask = new ArrayList<String>();
%>
<div class="app-content container center-layout mt-2">
<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Reports</h1>
			        </div>
			    </div>

<br>
				 <div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Status Report</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
							<%int manager_id = user.getManagerBean().getManager_id(); %>

							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
								<form action="managerStatusReport" id="managerStatusReport">
								<input type="hidden" name="manager_id" value="<%=manager_id%>">
										<div class="table-responsive">
										<table class="table">
										<tr>
															<th><label>Start Date</label></th>
															<td>:</td>
															<td><input type="date"
																class="form-control" name="startDate"
																id="startDate" placeholder="yyyy-mm-dd"
																value="<%=request.getAttribute("startDate")%>" required /></td>
																<th><label>End Date</label></th>
																<td>:</td>
															<td><input type="date"
																class="form-control" name="endDate" placeholder="yyyy-mm-dd"
																id="endDate" value="<%=request.getAttribute("endDate")%>" required /></td>
																</tr>
																
															
															<%if(role_id == 1 || role_id == 2 || role_id == 3 || role_id == 12) {%>
															
															
															<tr>	
															<th><label>Employee Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="employee_id"
															id="employee_id" >
														<option value="0">---Select Employee Name---</option>
														 <%
																		AllListDAO employeeList  = new AllListDAO();
                                        	  List<EmployeeBean> listOfEmployee = employeeList.underHrList();
                 						 	for (EmployeeBean e : listOfEmployee){
                 						 		 if(request.getAttribute("employee_id")!=null){
                                               	  int id =(Integer) request.getAttribute("employee_id");
                                               	  if(id == e.getEmployee_master_id()){
                                                 %>
                                                 	 <option value="<%=e.getEmployee_master_id()%>" selected="selected"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
										<%} %>	 
														</select>
														</td>
														</tr>
															
															
															<%} else{%>
															<tr>	
															<th><label>Employee Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="employee_id"
															id="employee_id" >
														<option value="0">---Select Employee Name---</option>
														 <%
																		AllListDAO employeeList  = new AllListDAO();
                                        	  List<EmployeeBean> listOfEmployee = employeeList.getListOfEmployee(manager_id);
                 						 	for (EmployeeBean e : listOfEmployee){
                 						 		int managerId = e.getManagerBean().getManager_id();
                                          
                 						 		 if(request.getAttribute("employee_id")!=null){
                                               	  int id =(Integer) request.getAttribute("employee_id");
                                               	  if(id == e.getEmployee_master_id()){
                                                 %>
                                                 	 <option value="<%=e.getEmployee_master_id()%>" selected="selected"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                          <%List<EmployeeBean> listOfEmployee1 = employeeList.getListOfEmployee(managerId); 
                                          for (EmployeeBean e1 : listOfEmployee1){
                                          if(request.getAttribute("employee_id")!=null){
                                        	  int id =(Integer) request.getAttribute("employee_id");
                                        	  if(id == e1.getEmployee_master_id()){
                                          %>
                                          	 <option value="<%=e1.getEmployee_master_id()%>" selected="selected"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%}else{ %>
                                          	  <option value="<%=e1.getEmployee_master_id()%>"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%} %>
                                          	 <%}else{ %>
                                          	  <option value="<%=e1.getEmployee_master_id()%>"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%} %>
										<%} }%>	 
														</select>
														</td>
														</tr>
														<%} %>
														
															<%if(role_id == 1 || role_id == 2 || role_id == 3 || role_id == 12) {%>
															<tr>		
															<th><label>Department Name</label></th>
															<td>:</td>
															<td colspan=4">
															<select class="form-control" name="department_id"
															id="department_id" >
														<option value="0">---Select Department Name---</option>
														<%List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment(); 
														for(DepartmentBean d : listOfDepartment){
															if(request.getAttribute("department_id") !=null){
																int id = (Integer) request.getAttribute("department_id");
															
																if(id == d.getDepartment_id()){
														%>
														 <option value="<%=d.getDepartment_id()%>" selected="selected"><%=d.getDepartment_name()%></option>
														 <%}else{ %>
														 <option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
														<%} %>
														 <%}else{ %>
														  <option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
														 <%} %>
										<%} %>	 
														</select> 
														</td>
														</tr>
															<%}%>
														
																
										
										</table>
										</div>
										<center><input type="submit" class="btn btn-primary" name="submit" value="SUBMIT"></center> 
										</form>
										</div>
										</div>
										<br>
										
				<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Planned Task</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
										<div class="panel-body">
										<div class="dataTable_wrapper">
										<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
										<tr>
												<th>Employee Name</th>
												<th>Department</th>
												<th>Project Name</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<th>% Completed</th>
												<th>Planned/Unplanned</th>								
												</tr>
												<%ArrayList<Double> arrayList = new ArrayList<Double>(); %>
										</thead>
										<tbody>
										<%
										if(request.getAttribute("listOfStatusReport") != null){
										List<TimeSheetBean> listOfStatusReport = (ArrayList)request.getAttribute("listOfStatusReport"); 
										for(TimeSheetBean t : listOfStatusReport) {
											double sumOfWorkedHour = 0;
											int task_id = t.getTaskMasterBean().getTask_master_id();
											int employee_id = t.getEmployeeBean().getEmployee_master_id();
											String employeeName = t.getEmployeeBean().getFirstname()+" "+t.getEmployeeBean().getLastname();
											String projectName = t.getProjectMasterBean().getProject_master_name();
											String departmentName = t.getEmployeeBean().getDepartmentBean().getDepartment_name();
											String taskName = null;
											if(t.getTaskMasterBean().getTask_master_name().equalsIgnoreCase("-")){
												taskName = t.getExternal_task_name();
											}else{
												taskName = t.getTaskMasterBean().getTask_master_name() ;
											}
											
											List<TimeSheetBean> listOfApprovedTimesheet= allListDAO.getListOfAprovedTimesheetByEmployeeId(task_id,employee_id);
											
											for(TimeSheetBean t1:listOfApprovedTimesheet){
												double workedHour = t1.getWorked_hours();
												sumOfWorkedHour = sumOfWorkedHour + workedHour;
											}
											Double maxValue = allListDAO.getMaxPer(task_id);	
											arrayList.add(maxValue);
											double maxPerfinal = Collections.max(arrayList);
			                                arrayList.clear();
			                                
										%>
										<%
										ProjectAllocationBean allocationBean = loginDAO.getAllocationByTaskId(task_id, employee_id);
										if(allocationBean!=null){
										%>
										<tr>
										<td><%=employeeName%></td>
										<td><%=departmentName %></td>
										<td><%=projectName%></td>
										<td><%=taskName%></td>
										<td><%=sumOfWorkedHour%></td>
										<td><%=maxPerfinal %></td>
										<td>Planned</td>
										<%} else{
											String merge = employeeName+","+projectName+","+taskName+","+sumOfWorkedHour+","+maxPerfinal+","+departmentName;
											unplannedTask.add(merge);
											%>
											<%} %>
											<% }}%>
											</tr>
										</tbody>
									</table>
									</div>
									</div>
									</div>
									</div>
									</div>
									</div>
									
									<div class="row">
									 <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">UnPlanned Task</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
									<div class="panel-body">
										<div class="dataTable_wrapper">
										<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example1">
										<thead>
										<tr>
												<th>Employee Name</th>
												<th>Department</th>
												<th>Project Name</th>
												<th>Task Name</th>
												<th>Worked Hours</th>
												<th>% Completed</th>
												<th>Planned/Unplanned</th>								
												</tr>
										</thead>
										<tbody>
										<%for(String  u : unplannedTask){
										
											String[] split = u.split(",");
											
											String employeeName = split[0];
											String projectName = split[1];
											String taskName = split[2];
											String sumOfWorkedHour = split[3];
											String maxPerfinal = split[4];
											String departmentName = split[5];
											
											
										%>
										<tr>
										<td><%=employeeName%></td>
										<td><%=departmentName %></td>
										<td><%=projectName%></td>
										<td><%=taskName%></td>
										<td><%=sumOfWorkedHour%></td>
										<td><%=maxPerfinal %></td>
										<td>Unplanned</td>
										</tr>
										<%} %>
										</tbody>
									</table>
									</div>
									</div>
									</div>
									</div>
									</div>
									</div>
									</div>
									</div>
									
									<div class="row">
											 <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Upcoming Task</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
									<div class="panel-body">
										<div class="dataTable_wrapper">
										<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example2">
										<thead>
										<tr>
											<%if(request.getAttribute("listofTask1") != null){%>
												<th>Employee Name</th>
											<%} else{%>
											<th>Manager Name</th>
											<%} %>
												<th>Task Name</th>
												<th>Project Name</th>
												<th>Start Date</th>
												</tr>
										</thead>
										<tbody>
										<%if(request.getAttribute("listofTask") != null){
										
											List<TaskMasterBean> listOfTask =(ArrayList) request.getAttribute("listofTask");
												for(TaskMasterBean t : listOfTask){	
													
													String date = t.getTask_planned_start_date();
													String sd = null;
													
			   										try {
			  											  
			   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			    										Date result = formater.parse(date);
			   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			    										sd = AppDateFormat.format(result);
			   											
			   										} catch (ParseException e1) {
			   											e1.printStackTrace();
			   										}	
										%>
										<tr>
										<td><%=t.getManagerBean().getManager_name() %>
										<td><%=t.getTask_master_name()%></td>
										<td><%=t.getProjectMasterBean().getProject_master_name()%></td>
										<td><%=sd%></td>
										</tr>
										<%} }%>

											<%if(request.getAttribute("listofTask1") != null){
										
											List<ProjectAllocationBean> listOfTask1 =(ArrayList) request.getAttribute("listofTask1");
												for(ProjectAllocationBean t : listOfTask1){	
													String date = t.getTaskMasterBean().getTask_planned_start_date();
													String sd = null;
													
			   										try {
			  											  
			   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			    										Date result = formater.parse(date);
			   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			    										sd = AppDateFormat.format(result);
			   											
			   										} catch (ParseException e1) {
			   											e1.printStackTrace();
			   										}	
										%>
										<tr>
											
										<td><%=t.getEmployeeBean().getFirstname()+" "+t.getEmployeeBean().getLastname()%></td>
										<td><%=t.getTaskMasterBean().getTask_master_name()%></td>
										<td><%=t.getProjectMasterBean().getProject_master_name()%></td>
										<td><%=sd%></td>
										</tr>
										<%} }%>
										</tbody>
									</table>
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
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
        $('#dataTables-example1').DataTable({
            responsive: true
    });
        $('#dataTables-example2').DataTable({
            responsive: true
    });
    });
    </script>
	<script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>

</body>
</html>