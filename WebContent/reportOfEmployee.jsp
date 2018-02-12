<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="java.util.List"%>
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
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String name = request.getParameter("name");
	%>
		<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Employee Reports</h1>
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
				               		<h4 class="card-title" id="horz-layout-basic"><%=name%></h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					                
										<div class="panel-body">
											<div class="dataTable_wrapper">
												<table class="table">
													<thead>
														<tr>
															<!-- <th>employee name</th> -->
															<th>Project Name</th>
															<!-- <th>Client Name</th>
															<th>Task Name</th> -->
															<th>Worked Hours</th>
															<th>Action</th>
												
															<!-- <th>status</th> -->
														</tr>
													</thead>
													<tbody>
														<%
															AllListDAO allListDAO = new AllListDAO();
															List<Object[]> employeeReport = allListDAO.employeeReport(employee_id);
															System.out.println("size:" + employeeReport.size());
															
															
														%>
																	
														<%	for (Object[] aRow : employeeReport) {
																TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
																double sum = 0;
																int project_id = sheetBean.getProjectMasterBean().getProject_master_id();
																List<Object[]> employee = allListDAO.employeeReport1(employee_id,project_id);
																for (Object[] arow : employee) {
																	TimeSheetBean t = (TimeSheetBean) arow[0];
																	
																	sum = sum + t.getWorked_hours();
																	System.out.println("sum:"+sum);
																	}
														%>


														<tr>
															<%-- <td><%=sheetBean.getEmployeeBean().getFirstname() %></td> --%>
															<td><%=sheetBean.getProjectMasterBean().getProject_master_name()%></td>
															<%-- <td><%=sheetBean.getClientMasterBean().getClient_master_name()%></td>
															<td><%=sheetBean.getTaskMasterBean().getTask_master_name()%></td> --%>
															<td>
																<%
																	/* sum = sum + Integer.parseInt(sheetBean.getWorked_hours()); */
																%><%=sum%></td>
																
															<td><a href="" data-toggle="modal"
																data-target="#myModal<%=sheetBean.getProjectMasterBean().getProject_master_id()%>"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="View" style="color : #337ab7"></i></a></td>
														</tr>
														<%
															}
														%>

													</tbody>
													
												</table>
											</div>
										</div>

										<%-- 	<%} %> --%>
									</div>
								</div>
							</div>
						</form>
						
						<%AllListDAO ListDAO = new AllListDAO();
						List<ProjectMasterBean> listOfProject = ListDAO.getListOfProject();
						for(ProjectMasterBean p : listOfProject){
						%>
						<div class="modal fade" id="myModal<%=p.getProject_master_id()%>" tabindex="-1" role="dialog"
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
														<%int project_id = p.getProject_master_id();
															AllListDAO allListDAO1 = new AllListDAO();
															List<Object[]> employeeReport1 = allListDAO1.employeeReport1(employee_id,project_id);
															double sum1 = 0;
															String project_name = null;
															String client_name = null;
																System.out.println("size:" + employeeReport1.size());
																String d = null;
																for (Object[] aRow : employeeReport1) {
																	TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
																	sum1 = sum1 + sheetBean.getWorked_hours();
																	project_name =sheetBean.getProjectMasterBean().getProject_master_name();
																	client_name =sheetBean.getClientMasterBean().getClient_master_name();
																	
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
															<%if(sheetBean.getTaskMasterBean().getTask_master_id() !=0) {%>
															<%=sheetBean.getTaskMasterBean().getTask_master_name()%>
															<%}else{ %>
															<font color="red"><%=sheetBean.getExternal_task_name()%></font>
															<%} %>
															</td>
															<td><%=sheetBean.getApproval_status() %></td>
															<td><center><%=sheetBean.getWorked_hours()%></center></td>
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
						<!-- <button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#myModal">Launch Demo Modal</button> -->
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