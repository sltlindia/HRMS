<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.timesheet.bean.DayBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
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
    <title>Sweet Alerts - Robust Bootstrap Admin Template</title>
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
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
    $('#selecctall').click(function(event) {  //on click 
        if(this.checked) { // check select status
            $('.checkbox1').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"               
            });
        }
        else{
            $('.checkbox1').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
            });
            $('.checkbox2').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox2"                       
            });    
        }
    });
    
});
function save(id) {
	/* alert(id); */
	if(id==1){
	document.getElementById('action').value="PerDateapproved";
	}else{
		document.getElementById('action').value="PerDaterejected";
	}
}
</script>
<script type="text/javascript">

function init () {
    var text = document.getElementById('text');
    function resize () {
        text.style.height = 'auto';
        text.style.height = text.scrollHeight+'px';
    }
    /* 0-timeout to get the already changed text */
    function delayedResize () {
        window.setTimeout(resize, 0);
    }
    observe(text, 'change',  resize);
    observe(text, 'cut',     delayedResize);
    observe(text, 'paste',   delayedResize);
    observe(text, 'drop',    delayedResize);
    observe(text, 'keydown', delayedResize);

    text.focus();
    text.select();
    resize();
}


</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<% 
String status = "";
String rejection_reason = "";
	List<Object[]> pendingTimesheetView = (ArrayList) request.getAttribute("pendingTimesheetView");
	List<UnplanProjectBean> pendingTimesheet = (ArrayList)request.getAttribute("getdailyUnplanTimeSheetList");
								String date = null;
								String day = null;
								String name = null;
								String d = null;
								
								for(UnplanProjectBean u : pendingTimesheet){
									date = u.getDate();
									day = u.getDayBean().getDay();
									name = u.getEmployeeBean().getFirstname()+" "+u.getEmployeeBean().getLastname();
									status = u.getApproval_status();
									rejection_reason = u.getRejection_reason();
								}
								
											for (Object[] aRow : pendingTimesheetView) {
												TimeSheetBean timeSheetBean = (TimeSheetBean) aRow[0];
												date = timeSheetBean.getDate();
												day = timeSheetBean.getDayBean().getDay();
												name = timeSheetBean.getEmployeeBean().getFirstname()+" "+timeSheetBean.getEmployeeBean().getLastname();
												status = timeSheetBean.getApproval_status();
												rejection_reason = timeSheetBean.getRejection_reason();
											}
											
											try {
												 
												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(date);
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												d = AppDateFormat.format(result);
											} catch (ParseException e1) {
												e1.printStackTrace();
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
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
						<div class="row">
								<div class="col-lg-6">
									<span class="icon icon-ios-calendar"></span> &nbsp;&nbsp;<b>Timesheet for Date : <%=d %></b>
								</div>
								<div class="col-lg-6" align="right">
									<%if(status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("updated")){%>
										<a href="pendingTimeSheetList">
									<%}else if(status.equalsIgnoreCase("approved")){%>
										<a href="approvedTimeSheet">
									<%}else if(status.equalsIgnoreCase("rejected")){%>
										<a href="rejectedTimeSheet">
									<%} %>
									<button class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Back">
									<span class="icon icon-reply"></span>&nbsp;&nbsp;Back</button></a>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<form method="post" action="statusUpdate">
				<input type="hidden" name="action" id="action" value="">
				<input type="hidden" name="employee_id" id="action" value="<%=request.getParameter("employee_master_id") %>">
				<input type="hidden" name="date" id="action" value="<%=request.getParameter("date") %>">
						
						<div class="panel-body">
							<div class="dataTable_wrapper">
							
							<div class="row">
								<div class="panel panel-default">
									<div class="panel-body">
							
								<h5><div class="col-md-3"><b>Date</b> : <%=d %></div>
								<div class="col-md-2"><b>Day</b> : <%=day %></div>
								<div class="col-md-5"><b>Employee Name</b> : <%=name %></div></h5>	
								</div>
								</div>
							</div>	
							<div class="table table-responsive">
								<table class="table table-striped table-bordered table-hover">

									<thead>
										<tr>
											
											<th>Project Name</th>
											<th>Task Name</th>
											<th>Worked Hours</th>
											<th>Comment</th>
											
											<!-- <th>Action</th> -->
										</tr>
										</thead>
									 <tbody>
                                        
										<%
											
											for (Object[] aRow : pendingTimesheetView) {
												
												TimeSheetBean timeSheetBean = (TimeSheetBean) aRow[0];
												EmployeeBean employeeBean = (EmployeeBean) aRow[1];
												DayBean dayBean = (DayBean) aRow[2];
												ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
												ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
												TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];
												
										%>
										<%try {
																 
																  String date1 = timeSheetBean.getDate();
																SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																Date result = formater.parse(date1);
																SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																d = AppDateFormat.format(result);
																System.out.println(AppDateFormat.format(result));
															} catch (ParseException e1) {
																e1.printStackTrace();
															} %>
															
										<%if(timeSheetBean.getUnplanned_task() == 1){%>					
										<tr bgcolor="#F1D194">
										<%}else{ %>
										<tr>
										<%} %>
											<td>
											<%if(!projectMasterBean.getProject_code().equalsIgnoreCase("0")){%>
											<%=projectMasterBean.getProject_code()%> :
											<%} %>
											<%=projectMasterBean.getProject_master_name()%>
											</td>
											<%if(taskMasterBean.getTask_master_id() !=0){ %>
											<td>
											<%=taskMasterBean.getTask_master_name()%>
											</td>
											<%}else{ %>
											<td>
											<font color="red"><%=timeSheetBean.getExternal_task_name() %></font>
											</td>
											<%} %>
											<td><%=timeSheetBean.getWorked_hours()%></td>
											<%-- <td><div>
                                    		<p>
                                        		<span class="pull-right text-muted"><%=timeSheetBean.getPercentage_completed()%>%</span>
                                    		</p>
														<div class="progress progress-striped active">
															<%
																if (timeSheetBean.getPercentage_completed() <= 50) {
															%>
															<div class="progress-bar progress-bar-success"
																role="progressbar"
																aria-valuenow="<%=timeSheetBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=timeSheetBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=timeSheetBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																} else if (50 < timeSheetBean.getPercentage_completed()
																			&& timeSheetBean.getPercentage_completed() <= 75) {
															%>
															<div class="progress-bar progress-bar-info"
																role="progressbar"
																aria-valuenow="<%=timeSheetBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=timeSheetBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=timeSheetBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																} else if (timeSheetBean.getPercentage_completed() > 75) {
															%>
															<div class="progress-bar progress-bar-danger"
																role="progressbar"
																aria-valuenow="<%=timeSheetBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=timeSheetBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=timeSheetBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																}
															%>
														</div>
													</div>
											</td>
 --%>											
											<td style="white-space: pre"><%=timeSheetBean.getEmployee_comment()%></td>
											</tr>
											<%
												}
											%>
											
											<%
											for(UnplanProjectBean unplanProjectBean : pendingTimesheet) {
											%>
											<tr >
												<td bgcolor="#F1D194"><%=unplanProjectBean.getProject_name()%></td>
												<td bgcolor="#F1D194"><%=unplanProjectBean.getTask_name()%></td>
												<td bgcolor="#F1D194"><%=unplanProjectBean.getWorked_hours()%></td>
												<%-- <td bgcolor="#F1D194">
												<div>
                                    		<p>
                                        		<span class="pull-right text-muted"><%=unplanProjectBean.getPercentage_completed()%>%</span>
                                    		</p>
														<div class="progress progress-striped active">
															<%
																if (unplanProjectBean.getPercentage_completed() <= 50) {
															%>
															<div class="progress-bar progress-bar-success"
																role="progressbar"
																aria-valuenow="<%=unplanProjectBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=unplanProjectBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=unplanProjectBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																} else if (50 < unplanProjectBean.getPercentage_completed()
																			&& unplanProjectBean.getPercentage_completed() <= 75) {
															%>
															<div class="progress-bar progress-bar-info"
																role="progressbar"
																aria-valuenow="<%=unplanProjectBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=unplanProjectBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=unplanProjectBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																} else if (unplanProjectBean.getPercentage_completed() > 75) {
															%>
															<div class="progress-bar progress-bar-danger"
																role="progressbar"
																aria-valuenow="<%=unplanProjectBean.getPercentage_completed()%>"
																aria-valuemin="0" aria-valuemax="100"
																style="width: <%=unplanProjectBean.getPercentage_completed()%>%">
																<span class="sr-only"><%=unplanProjectBean.getPercentage_completed()%>
																	(success)</span>
															</div>
															<%
																}
															%>
														</div>
													</div>
												</td> --%>
												<%if(unplanProjectBean.getEmployee_comment().equalsIgnoreCase("")){ %>
													<td bgcolor="#F1D194">-----</td>
												<%}else{%>
													<td bgcolor="#F1D194" style="white-space: pre"><%=unplanProjectBean.getEmployee_comment()%></td>											
												<%} %>
												
												
											</tr>
											<%} %>
										<br>
										
									
								</table>
								</div>
                            <%if(request.getParameter("buttonShow") != null) {%>
							<center><button type="submit" class="btn btn-primary" onclick="save(1)">Approve</button>
                            <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#myModal">Reject</button></center>
                            <%} %>
						</div>
						<br>
						<%if(status.equalsIgnoreCase("rejected")){ %>
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
						<%} %>
						<br>
						<b>NOTE :</b>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-stop" style="color:#F1D194;"></i><b> : Unplanned Task</b>
						</div>		
											
						
				
				
				
				
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Remarks</h4>
                                        </div>
                                        <div class="modal-body">
                                      <input type="text" class="form-control" name="remarks" id="remarks">
                                        </div>
                                        <div class="modal-footer">
                                        <input type="submit" class="btn btn-primary" name="submit" value="SUBMIT" onclick="save(2)">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
							
						
					</form>
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
	  </body>
</html>