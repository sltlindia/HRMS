<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
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
    <title>Leave Balance Report</title>
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
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<% double COTotal = 0, PLTotal = 0 , SLTotal = 0; 
	double netbalance = 0;
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
					<h1 class="page-header">Reports</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
								<form action="Report" method="POST">
										<div class="table-responsive">
										<table class="table">
										<tr>
															<th style="width: 120px;">  Employee Name :</th>
														<!-- 	<td style="width: 150px;"><input type="text" value="" name="employeeCode"  class="form-control" width="10px"/></td> -->
																<!--  <th style="width: 120px;">Department :</th> -->
																<td style="width: 150px;">
																<%if(request.getParameter("employeeCode") != null){ 
																	String emp_code = request.getParameter("employeeCode");
																	int employe_code = Integer.parseInt(emp_code);
																%>
																
																<select class="form-control" name="employeeCode">
																	<option value="">-- Select ---</option>
																<%
																int manager_id = user.getManagerBean().getManager_id();
																AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																List<EmployeeBean> e = allLMSListDAO.getListOfEmployeeName(manager_id);
																String f;
																int code = 0;
																for(EmployeeBean name : e)
																{
																	f = name.getFirstname() + " " + name.getLastname();
																	/* System.out.println(f); */
																	code = name.getEmployee_code();
																	if(employe_code == code){
																
																%>
																<option value="<%=code %>" selected="selected"><%=f %></option>
														
														
																<%}else{ %>
																	<option value="<%=code %>"><%=f %></option>
																<%
																	}}
																%>
																</select>
																<%}else{ %>
																<select class="form-control" name="employeeCode" required>
																	<option value="">-- Select ---</option>
																<%
																int manager_id = user.getManagerBean().getManager_id();
																AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																List<EmployeeBean> e = allLMSListDAO.getListOfEmployeeName(manager_id);
																String f;
																int code = 0;
																for(EmployeeBean name : e)
																{
																	f = name.getFirstname() + " " + name.getLastname();
																	/* System.out.println(f); */
																	code = name.getEmployee_code();
																%>	
																	<option value="<%=code %>"><%=f %></option>
																<%} %>
																</select>
																<%} %>
																</td>
																<td style="width: 150px;"></td> 
														</tr>
										</table>
										</div>
										<center><input type="submit" class="btn btn-primary" name="submit" value="SUBMIT"></center>
										<br>
										</form>
										</div>
										</div>
										
										
										<div class="panel-body">
										<div class="dataTable_wrapper">
										<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
										
										<thead>
										<tr>
												<th style="text-align:center;" rowspan="2">Date</th>
												<th colspan="2" style="text-align:center">CO</th>
												<th colspan="2" style="text-align:center">Plan Leave</th>
												<th colspan="2" style="text-align:center">Unplan Leave</th>											
												</tr>
										<tr>
										<th style="text-align:center">Balance Leave</th>
										<th style="text-align:center">Applied Leave</th>
										<th style="text-align:center">Balance Leave</th>
										<th style="text-align:center">Applied Leave</th>
										<th style="text-align:center">Balance Leave</th>
										<th style="text-align:center">Applied Leave</th>
										</tr>
										
										</thead>
										<tbody>
										<%if(request.getAttribute("listOfLeaveReport") != null){
										AllLMSListDAO allListDAO = new AllLMSListDAO();
										List<LeavecutBalance> listOfLeaveReport =(ArrayList) request.getAttribute("listOfLeaveReport");
										for(LeavecutBalance l : listOfLeaveReport){
											int emp_code = l.getLeaveBean().getEmployeeBean().getEmployee_code();
											
											
											
											
											String date = null;
											String d1 = null;
											String sd = null;	
																	try {
																		 date = l.getLeaveBean().getLeave_To();
							   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
							    										Date result = formater.parse(date);
							   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd/MM/yyyy");
							   											sd = AppDateFormat.format(result);
							   											System.out.println(AppDateFormat.format(result));
							   											
							   											
							   											
							   										} catch (ParseException e1) {
							   											e1.printStackTrace();
							   										}	
															
											
											
										%>
									<tr>
										<th style="text-align:center">
											<%=sd %>
										</th>
										<%LeaveBalanceBean balance = allListDAO.getleaveListbyEMPCode(emp_code);
											COTotal = balance.getCO();
											PLTotal = balance.getPlan_Leave();
											SLTotal = balance.getUnplan_Leave();
											
											netbalance = COTotal + PLTotal + SLTotal;
										
										%>
										<th style="text-align:center">
											<%=l.getMain_CO()%>
										</th>
										<th style="text-align:center">
											<%=l.getCO()%>
										</th>
										<th style="text-align:center">
											<%=l.getMain_PL()%>
										</th>
										<th style="text-align:center">
											<%=l.getPL()%>
										</th>
										<th style="text-align:center">
											<%=l.getMain_SL()%>
										</th>
										<th style="text-align:center">
												<%=l.getSL() %>
										</th>
									</tr>
									<%} %>
										</tbody>
										<tr>
										<th style="text-align:center">Total Balance</th>
										<th colspan="2" style="text-align:center"><%= COTotal %> </th>
										<th colspan="2" style="text-align:center">	<%= PLTotal  %></th>
										<th colspan="2" style="text-align:center"><%= SLTotal  %></th>		
									
										</tr>
										<%}%>
										</tbody>
										<tbody>
										<tr>
											<th style="text-align:center">Net Balance</th>
											<th colspan="6" style="text-align:center"><%=netbalance %> </th>
										</tr>
										</tbody>
									</table>
									<!-- /.table -->
								</div>
								</div>
								<!-- /.dataTable_wrapper -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel panel-primary -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
</div>
</div>
</div>
</div>
</section>
</div>
</div>
</div>
	 <!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
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