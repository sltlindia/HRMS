<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.hibernate.transform.DistinctResultTransformer"%>
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
    <title>Employee Report</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int project_id = Integer.parseInt(request.getParameter("project_id"));
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Project Reports</h1>
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
				               		<h4 class="card-title" id="horz-layout-basic">Report of <%=request.getParameter("proj_name") %></h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			
										<div class="panel-body">
											<div class="dataTable_wrapper">
											<table class="table table-stripped table-hover">
													<thead>
														<tr>
															<!-- <th>employee name</th> -->
															<th>Employee Name</th>
															<th>Client Name</th>
															<th>Plan Start Date</th>
															<th>Plan End Date</th>
															<th>Action</th>
															<!-- <th>Worked Hours</th> -->
															
															<!-- <th>status</th> -->
														</tr>
													</thead>
													<tbody>

														<%
															AllListDAO allListDAO = new AllListDAO();
																List<Object[]> projectReport = allListDAO.projectReport(project_id);
																System.out.println("size:" + projectReport.size());
																int sum = 0;
																String sd = null;
						   										String ed = null;
						   										
																for (Object[] aRow : projectReport) {
																	TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];

																	/* System.out.println(sheetBean.getTimesheet_master_id());
																	System.out.println(sheetBean.getProjectMasterBean().getProject_master_name());
																	System.out.println(sheetBean.getClientMasterBean().getClient_master_name());
																	System.out.println(sheetBean.getWorked_hours());*/
																String startDate= sheetBean.getProjectMasterBean().getPlanned_start_date();
																	String endDate = sheetBean.getProjectMasterBean().getPlanned_end_date();
														%>
													
														<% try {
										  											  
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
															<%-- <td><%=sheetBean.getEmployeeBean().getFirstname() %></td> --%>
															<td><%=sheetBean.getEmployeeBean().getFirstname()+" "+sheetBean.getEmployeeBean().getLastname()%></td>
															<td><%=sheetBean.getClientMasterBean().getClient_master_name()%></td>
															<td><%=sd%></td>
															<td><%=ed%></td>
															<%-- <td><a href="reportOfEmployee.jsp?employee_id=<%=sheetBean.getEmployeeBean().getEmployee_master_id()%>&name=<%=sheetBean.getEmployeeBean().getFirstname()+" "+sheetBean.getEmployeeBean().getLastname()%>"><i class="glyphicon glyphicon-modal-window" data-toggle="tooltip" data-placement="top" title="View"></i></a></td> --%>
															<td><a href="" data-toggle="modal"
																data-target="#myModal<%=sheetBean.getEmployeeBean().getEmployee_master_id() %><%=sheetBean.getProjectMasterBean().getProject_master_id()%>"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="View"></i></a></td>
															</tr>
															
														<%
															}
														%>
														<tr>
														
															<td><b>Total Employee : <%=projectReport.size()%></b></td>
															<td colspan="4"></td>
														</tr>
													</tbody>
												</table>
													
														<%
																List<Object[]> projectReport1 = allListDAO.projectReport(project_id);
																for (Object[] aRow : projectReport1) {
																	TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
																	%>

														
						<div class="modal fade" id="myModal<%=sheetBean.getEmployeeBean().getEmployee_master_id() %><%=sheetBean.getProjectMasterBean().getProject_master_id()%>" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-body">


									<table class="table">
														<tr>
														<!-- <th>Employee Name</th> -->
															<th>Date</th>
															<th>Task Name</th>
															<th>Status</th>
															<th>Worked Hours</th>
														</tr>
														<%int project_id1 = sheetBean.getProjectMasterBean().getProject_master_id();
														int employee_id = sheetBean.getEmployeeBean().getEmployee_master_id();
															AllListDAO allListDAO1 = new AllListDAO();
															List<Object[]> employeeReport1 = allListDAO1.employeeReport1(employee_id,project_id1);
															double sum1 = 0;
															String project_name = null;
															String client_name = null;
																System.out.println("size:" + employeeReport1.size());
																String d = null;
																for (Object[] aRow1 : employeeReport1) {
																	TimeSheetBean sheetBean1 = (TimeSheetBean) aRow1[0];
																	sum1 = sum1 + sheetBean1.getWorked_hours();
																	project_name =sheetBean1.getProjectMasterBean().getProject_master_name();
																	client_name =sheetBean1.getClientMasterBean().getClient_master_name();
																	
														%>
														<%try {
																 
																  String date1 = sheetBean.getDate();
																SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																Date result = formater.parse(date1);
																SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																d = AppDateFormat.format(result);
																System.out.println(AppDateFormat.format(result));
															} catch (ParseException e1) {
																e1.printStackTrace();
															} %>
														<tr>
															<td><%=d%></td>
															<td>
															<%if(sheetBean1.getTaskMasterBean().getTask_master_id() !=0) {%>
															<%=sheetBean1.getTaskMasterBean().getTask_master_name()%>
															<%}else{ %>
															<font color="red"><%=sheetBean1.getExternal_task_name()%></font>
															<%} %>
															</td>
															<td><%=sheetBean1.getApproval_status() %></td>
															<td><center><%=sheetBean1.getWorked_hours()%></center></td>
														</tr>
													
														<%
															}
														%>
														<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h5 class="modal-title" id="myModalLabel">Project Name:<b><%=project_name%></b> &nbsp;&nbsp;&nbsp; Client Name:<b><%=client_name %></b></h5>
									</div>
																											<tr>
															<th colspan="3" align="left">Total</th>
															<th><center><%=sum1%></center></th>
															
														</tr>
													
</table>


									</div>
								</div>
							</div>
						</div>
														
								<%} %>						
														
														
														
														
												<center><a href="projectReport.jsp"><button type="button" class="btn btn-info" name="save" value="save">Back</button></a></center>
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