<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleServiceRecordBean"%>
<%@page import="com.hrms.vehicletracking.bean.DriverBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleTrackingBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleTypeBean"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.selfservice.bean.DownloadBean"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//Dlabel HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dlabel">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>SLTL HRMS</title>
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
    <style type="text/css">
    #tablePadding{
		padding-left: 3px;
	}
    </style>
</head>


<script type="text/javascript">
	var datefield = document.createElement("input")
	datefield.setAttribute("type", "text")
	if (datefield.type != "date") { //if browser doesn't support input type="date", load files for jQuery UI Date Picker
		document
				.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
	}
</script>

<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#date').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}


</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Vehicle Service Record System</h1>
			        </div>
			    </div>
				<!-- /.col-lg-12 -->
			
			<br>
			<!-- /.row -->
			<%AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
			 int current_month = Calendar.getInstance().get(Calendar.MONTH)+1;
			 AllListDAO allListDAO = new AllListDAO();
			 MonthBean monthBean = allListDAO.getListOfMonthById(current_month);
			%>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Basic Information</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
								<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#vehicleRecordForm" aria-expanded="true" data-toggle="tab"><span class="icon-plus-circled"></span>&nbsp;Vehicle Service Record
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#vehicleRecordFormList" aria-expanded="true" data-toggle="tab"><span class="icon-android-car"></span>&nbsp;Vehicle Service Record List (<%=monthBean.getMonth_name()%>)</a>
							</li>
						</ul>
                            <hr>	
		
							<div class="tab-content">
							<div class="tab-pane fade in active" id="vehicleRecordForm">
							<form action="vehicleServiceRecordInsert" method="post">
								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped table-hover">
											<tr>
											<th>Date</th>
												<td>:</td>
												<td><input type="text" class="form-control"
												name="date" id="date" required="required"
												onchange="ValidateDate(this.value)" placeholder="yyyy-MM-dd" required="required"></td>
											</tr>
											<tr>
												<td><label>&nbsp;Free Service or not??&nbsp;<i
														class="icon-question-circle" data-toggle="tooltip"
														data-placement="top"
														title="All the employee of the specific company which you select will notify by all the details of broadcast."></i></label></td>
												<td>:</td>
												<td><input type="radio" name="free_service" id="yes"
													value="yes">
													Yes <input type="radio" name="free_service" id="no" value="no" checked="checked"
													autofocus> No</td>
											</tr>
											<tr>
											<th>Driver Name</th>
											<td>:</td>
												<td>
												<select class="form-control"
													name="driver_id" id="driver_id"
													required="required" onchange="response(this.value)">
													<option value="">--Select Driver--</option>
													<%
														List<DriverBean> listOfDriver = allListVtsDAO.getListOfDriver();
														for (DriverBean driverBean : listOfDriver) {
													%>
													<option
														value="<%=driverBean.getDriver_id()%>"><%=driverBean.getDriver_first_name()%> <%=driverBean.getDriver_last_name() %></option>
													<%
														}
													%>
												</select>
												</td>
											</tr>
											<tr>
											<th>Vehicle No.</th>
											<td>:</td>
											<td><select class="form-control"
													name="vehicle_id" id="vehicle_id"
													required="required" onchange="response(this.value)">
													<option value="">--Select Vehicle--</option>
													<%
														List<VehicleBean> listOfVehicleList = allListVtsDAO.getListOfVehicles();

														for (VehicleBean vehicleBean : listOfVehicleList) {
													%>
													<option
														value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%> (<%=vehicleBean.getVehicle_no()%>)</option>
													<%
														}
													%>
												</select>
												</td>
											</tr>
											<tr>
												<th>Items(Change)</th>
												<td>:</td>
												<td colspan="5"><textarea
														name="items" placeholder="Max. 10000 words"
														required="required" class="form-control" required="required"></textarea></td>
											</tr>
											<tr>
												<th>Amount</th>
												<td>:</td>
												<td colspan="5"><input type="number"  step="any" class="form-control"
													name="amount" placeholder="Amount" autofocus
													id="amount" required="required"></td>
											</tr>
											<tr>
												<th>Kilometer</th>
												<td>:</td>
												<td colspan="5"><input type="number"  step="any" class="form-control"
													name="kilometer" placeholder="kilometer" autofocus
													id="kilometer" required="required" ></td>
											</tr>
											
										</table>
									</div>
									<center>
										<input type="hidden" name="redirection"> <input
											type="submit" value="Submit" class="btn btn-primary">
										<input type="reset" value="Cancel" class="btn btn-danger">
									</center>
								</div>
							</form>
						<%-- 	<div class="row">
										<div class="col-lg-12">
											
												<!-- /.panel-heading -->
<div class="panel panel-primary">
						<div class="panel-heading">Vehicle Service Record List(<%=monthBean.getMonth_name()%>)</div>
												<div class="panel-body">

													<div class="dataTable_wrapper">
														<table
															class="table table-bordered table-hover" id="dataTables-example">
															<thead>
																<tr>
																<th>No.</th>
																	<th>Vehicle Record Date</th>
																	<th>Item(Change)</th>
																	<th>Amount</th>
																	<th>Driver Name</th>
																	<th>Vehicle Name</th>
																	<th>Free Service</th>
																	<th>Action</th>
																</tr>
															</thead>
															<tbody>
																<%
																int c=1;
																	AllListVtsDAO allListVtsDAO2 = new AllListVtsDAO();
																	List<VehicleServiceRecordBean> listOfVehicleServiceRecord = allListVtsDAO2.getListOfVehicleServiceCurrentMonth();
																	for (VehicleServiceRecordBean v : listOfVehicleServiceRecord) {
																%>
																<tr>
																<td><%=c++ %></td>
																	<td><%=ddmmyyyy.format(yyyymmdd.parse(v.getRecord_date()))%></td>
																	<td><%=v.getItems_change()%></td>
																	<td><%=v.getAmount() %></td>
																	<td><%=v.getDriverBean().getDriver_first_name()%> <%=v.getDriverBean().getDriver_last_name()%></td>
																	<td><%=v.getVehicleBean().getVehicle_name()%><%=v.getVehicleBean().getVehicle_no()%></td>
																	<td><%=v.getFree_service()%></td>
																	<td>
																		<a
														href="vehicleServiceRecordFormUpdate.jsp?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="glyphicon glyphicon-edit" data-toggle="tooltip"
															data-placement="top" title="Edit Data"></i></a>&nbsp;<a
														href="vehicleServiceRecordDelete?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="glyphicon glyphicon-trash" data-toggle="tooltip"
															data-placement="top" title="Delete Data"
															onclick="return confSubmit()" style="color: red;"></i></a>
															<a
														href="vehicleServiceRecordView.jsp?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="glyphicon glyphicon-eye-open" data-toggle="tooltip"
															data-placement="top" title="View Data"
															onclick="return confSubmit()"></i></a>
																	</td>
																</tr>
																<%
																	}
																%>
															</tbody>
														</table>

													</div>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->
											</div>
										</div>
										</div> --%>
						</div>
					
						<div class="tab-pane fade" id="vehicleRecordFormList">
									<div class="row">
										<div class="col-lg-12">
											
												<!-- /.panel-heading -->

												<div class="panel-body">

													<div class="dataTable_wrapper">
													<div class = "table-responsive">
														<table
															class="table table-bordered table-hover" id="dataTables-example">
															<thead>
																<tr>
																<th id="tablePadding">No.</th>
																	<th id="tablePadding">Vehicle Record Date</th>
																	<th id="tablePadding">Item(Change)</th>
																	<th id="tablePadding">Amount</th>
																	<th id="tablePadding">Driver Name</th>
																	<th id="tablePadding">Vehicle Name</th>
																	<th id="tablePadding">Free Service</th>
																	<th id="tablePadding">Kilometer</th>
																	<th id="tablePadding">Action</th>
																</tr>
															</thead>
															<tbody>
																<%
																int c=1;
																AllListVtsDAO allListVtsDAO2 = new AllListVtsDAO();
																List<VehicleServiceRecordBean> listOfVehicleServiceRecord = allListVtsDAO2.getListOfVehicleServiceCurrentMonth();
																	for (VehicleServiceRecordBean v : listOfVehicleServiceRecord) {
																%>
																<tr>
																<td id="tablePadding"><%=c++ %></td>
																	<td id="tablePadding"><%=ddmmyyyy.format(yyyymmdd.parse(v.getRecord_date()))%></td>
																	<td id="tablePadding"><%=v.getItems_change()%></td>
																	<td id="tablePadding"><%=v.getAmount() %></td>
																	<td id="tablePadding"><%=v.getDriverBean().getDriver_first_name()%> <%=v.getDriverBean().getDriver_last_name()%></td>
																	<td id="tablePadding"><%=v.getVehicleBean().getVehicle_name()%><%=v.getVehicleBean().getVehicle_no()%></td>
																	<td id="tablePadding"><%=v.getFree_service()%></td>
																	<td id="tablePadding"><%=v.getKilometer()%></td>
																	<td id="tablePadding">
															<a href="vehicleServiceRecordFormUpdate.jsp?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="icon-edit2" data-toggle="tooltip"
															data-placement="top" title="Edit Data"></i></a>&nbsp;
															<a href="vehicleServiceRecordDelete?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="icon-trash2" data-toggle="tooltip"
															data-placement="top" title="Delete Data"
															onclick="return confSubmit()" style="color: red;"></i></a>
															<a href="vehicleServiceRecordView.jsp?vehicle_service_id=<%=v.getVehicle_service_record_id()%>"><i
															class="icon-eye4" data-toggle="tooltip"
															data-placement="top" title="View Data"
															onclick="return confSubmit()"></i></a>
																	</td>
																</tr>
																<%
																	}
																%>
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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
			$('#dataTables-example1').DataTable({
				responsive : true
			});
			$('#dataTables-example2').DataTable({
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
</body>
</html>