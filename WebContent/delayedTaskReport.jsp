<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.util.stream.IntStream"%>
<%@page import="java.time.Month"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Collection"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <title>Weekly Cost Report</title>
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
	
<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sweetalert/sweetalert.css">
<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">

<%@include file="header.jsp"%>
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

function listOfDefaulter() {
	alert("ripal");
	var startDate = document.getElementById('startDate').value;
	var endDate  = document.getElementById('endDate').value;
	window.location.replace("defaulterReportDateWise?startDate="+startDate+"&endDate="+endDate);
} 

function hide(){
        $("#sub").hide();
        $("#sub1").hide();
        window.print();
        $("#sub").show();
        $("#sub1").show();
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
        $('#plannedStartDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#plannedEndDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">
<%
AllListDAO allListDAO = new AllListDAO();
int role_id = user.getRoleBean().getRole_id();
List<String> array = new ArrayList<String>();
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			           <%if(request.getParameter("projectId")!=null){%>
					<center><h1 class="page-header"><img alt="logo" src="img/sltllogo.png" height="85px" width="135px"></h1></center>
				<%}else{ %>
				<h1 class="page-header">Reports</h1>
				
					<%} %>
			        </div>
			    </div>
				<!-- /.col-lg-12 -->
			
			<br>
			<!-- /.row -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Delayed Report</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
<%-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
				<%if(request.getParameter("projectId")!=null){%>
					<center><h1 class="page-header"><img alt="logo" src="img/sltllogo.png" height="85px" width="135px"></h1></center>
				<%}else{ %>
				<h1 class="page-header">Reports</h1>
				
					<%} %>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">Delayed Report</div>
							 --%>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
								<form action = "taskSearch" method="post">
									<div class="table-responsive">
										<table class="table">
										
													<%if(request.getParameter("projectId")!=null){ 
											int project_id =Integer.parseInt(request.getParameter("projectId"));
											String plannedStartDate = request.getParameter("plannedStartDate");
											String plannedEndDate = request.getParameter("plannedEndDate");
											%>
											
											<tr>	
															<th><label>Project Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="projectId"
															id="projectName" required>
														<option value="">---Select Project Name---</option>

														<%
															int manager_id = user.getManagerBean().getManager_id();
															
															List<ProjectMasterBean> listOfProjectMaster = null;
															
															if(role_id == 1 || role_id == 2 || role_id == 3 || role_id == 4){%>
																<%listOfProjectMaster = allListDAO.getListOfAllProject();
															}else{%>
																<%listOfProjectMaster = allListDAO.getListOfProjectMaster(manager_id);
															}
															for (ProjectMasterBean p : listOfProjectMaster) {
																if(project_id == p.getProject_master_id()){
														%>
														<option value="<%=p.getProject_master_id()%>" selected="selected"><%=p.getProject_master_name()%></option>
														<%}else{ %>
														<option value="<%=p.getProject_master_id()%>" ><%=p.getProject_master_name()%></option>
														<%} }%>
														</select>
														</td>
														</tr>
										
											
											<%}else{ %>
													<tr>	
															<th><label>Project Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="projectId"
															id="projectName" required>
														<option value="">---Select Project Name---</option>

														<%
															int manager_id = user.getManagerBean().getManager_id();
														List<ProjectMasterBean> listOfProjectMaster = null;
														
														if(role_id == 1 || role_id == 2 || role_id == 3 || role_id == 4){%>
														<%listOfProjectMaster = allListDAO.getListOfAllProject();
													}else{%>
														<%listOfProjectMaster = allListDAO.getListOfProjectMaster(manager_id);
													}
															for (ProjectMasterBean p : listOfProjectMaster) {
														%>
														<option value="<%=p.getProject_master_id()%>" ><%=p.getProject_master_name()%></option>
														<%} %>
														</select>
														</td>
														</tr>
										
														<%} %>
										</table>
									</div>
										
										<div id="sub">
										<center><input type="submit" class="btn btn-primary" name="submit" value="SUBMIT"></center>
										</div>
										</form>
										</div>
										</div>
										<div class="panel-body">
								<div class="dataTable_wrapper">
								<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
										<tr>	<th>Week No</th>
												<th>Planned Start Date</th>
												<th>Actual start date</th>
												<th>Status</th>
											</tr>
										</thead>
										
										
										<tbody>
										
										<%
										if(request.getAttribute("listOfTask")  != null){
											
											List<TaskMasterBean> listOfTask  =(ArrayList) request.getAttribute("listOfTask");
											String min = null;
											String delayed = "--------";
											int project_id =Integer.parseInt(request.getParameter("projectId"));
											System.out.println("yash ramani");
											for(TaskMasterBean t : listOfTask){
												
											String startDate = t.getTask_planned_start_date();
											System.out.println("date:"+startDate);
											String endDate = t.getTask_planned_end_date();
											System.out.println("endDate:"+endDate);
											System.out.println("yash ramani");
											int task_id =t.getTask_master_id();
													
											
											String minValue = allListDAO.getMinDate(task_id);
											min = minValue;
											if(min != null){
											DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
											Date date = format.parse(startDate);
											Date date1 = format.parse(min);
											if(date1.after(date)){
											delayed = "Delayed";
											}
											}
											 String d = null;
											 String d1 = null;
											try {
												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												Date result = formater.parse(startDate);
												d = AppDateFormat.format(result);
												if(min != null){
												
												
												Date result1 = formater.parse(min);
												
												
												d1 = AppDateFormat.format(result1);
												System.out.println(AppDateFormat.format(result));
											}} catch (ParseException e1) {
												e1.printStackTrace();
											}
											
										%>
										
											<tr class="odd gradeX">
												<td><%=t.getTask_master_name()%></td>
												<td><%=d%></td>
												<%if(min == null){%>
												<td>Not started</td>
												<%}else{ %>
												<td><%=d1%></td>
												<%} %>
												<%if(min != null){%>
												<td><font color="red"><%=delayed%></font></td>
												<%}else{ %>
												<td>---------</td>
												<%} %>
												<%} }%>
											</tr>
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
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
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
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
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
