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
<%@include file="header.jsp"%>
</head>

<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<title>Interview Report</title>
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">

<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet"
	type="text/css" /> -->

<script type="text/javascript">
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#fromDate" );
				     var $datepicker2 =  $( "#toDate" );
				     
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 onSelect: function(dateStr)
				 			 {
				 				 if($('#toDate').val() == ""){
				 				 $('#toDate').val(this.value);
				 				 }
				 			 }
				      
				 		});
				      
				      $datepicker2.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 		});
				      
				 });
		



</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
		<div class="app-content container center-layout mt-2">
		<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
		<%
										String fromDate = "";
										String toDate = "";
										String vehicleId = "0";
										String driverId = "0";
										int count = 0;
										
										
										if(request.getParameter("fromDate") != null){ 
											fromDate = request.getParameter("fromDate");
											if(!fromDate.equalsIgnoreCase("")){
												count++;
											}
										}
										
										
										
										if(request.getParameter("toDate") != null){ 
											toDate = request.getParameter("toDate");
											if(!toDate.equalsIgnoreCase("")){
												count++;
											}
										}
											
										
										if(request.getParameter("vehicle_id") != null){ 
											vehicleId = request.getParameter("vehicle_id");
											if(!vehicleId.equalsIgnoreCase("0")){
												count++;
											}
										}
										
										
										
										if(request.getParameter("driver_id") != null){ 
											driverId = request.getParameter("driver_id");
											if(!driverId.equalsIgnoreCase("0")){
												count++;
											}
										}
										
										System.out.println("Count:"+count);
										
										%>
										<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Vehicle Service Record History</h1>
			        </div>
			    </div>
				<!-- /.col-lg-12 -->
			
			<br>
	<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Vehicle Service Record History</h3>
				</div>
				/.col-lg-12
			</div> -->
			<%AllListVtsDAO allListVtsDAO = new AllListVtsDAO(); %>
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
				<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Basic Information</div>
						<div class="panel-body"> -->
							<!-- <ul class="nav nav-tabs">
								<li class="active"><a href="#vehicleRecordForm" data-toggle="tab"><span class="fa fa-plus-circle fa-fw"></span> Vehicle Service Record History
										</a></li>
								<li><a href="#vehicleRecordFormList" data-toggle="tab"><span class="fa fa-taxi fa-fw"></span>  Vehicle Service Record List(All Record)</a></li>
							</ul>
							<div class="tab-content">
							<div class="tab-pane fade in active" id="vehicleRecordForm"> -->
								<div class="panel panel-primary">
				<!-- /.panel-heading -->
			 <form action="">
				<div class="panel-body">
				
				<div class="row">
					<div class="col-md-2 col-lg-2 col-sm-2">
						<h6>Date :</h6>
					</div>
					<div class="col-md-4 col-lg-4 col-sm-4">
						<input type="text" class="form-control" name="fromDate"
							id="fromDate" value="<%=fromDate%>" placeholder="dd-mm-yyyy">
					</div>

					<div class="col-md-2 col-lg-2 col-sm-2">
						<center>
							<h6>To</h6>
						</center>
					</div>
					<div class="col-md-4 col-lg-4 col-sm-4">
						<input type="text" class="form-control" name="toDate" id="toDate"
							value="<%=toDate%>" placeholder="dd-mm-yyyy">
					</div>
					
					</div>
					<br>
					<div class="row">
					
					<div class="col-md-2 col-lg-2 col-sm-2" >
							<h6>Vehicle No :</h6>
						</div>
					
							<div class="col-md-4 col-lg-4 col-sm-4">
												<select class="form-control"
													name="vehicle_id" id="vehicle_id"
													 onchange="response(this.value)">
													<option value="0">--Select Vehicle--</option>
													<%
														List<VehicleBean> listOfVehicleList = allListVtsDAO.getListOfVehicles();

														for (VehicleBean vehicleBean : listOfVehicleList) {
															if(vehicleBean.getVehicle_master_id() == Integer.parseInt(vehicleId)){
													%>
													<option
														value="<%=vehicleBean.getVehicle_master_id()%>" selected="selected"><%=vehicleBean.getVehicle_name()%> (<%=vehicleBean.getVehicle_no()%>)</option>
													<%}else{ %>
														<option
														value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%> (<%=vehicleBean.getVehicle_no()%>)</option>
													<%} %>
													
													<%
														}
													%>
												</select>
						</div>
						
						
						
						<div class="col-md-2 col-lg-2 col-sm-2" >
						<center>
							<h6>Driver Name :</h6>
							</center>
						</div>
					
							<div class="col-md-4 col-lg-4 col-sm-4">
												<select class="form-control"
													name="driver_id" id="driver_id"
													 onchange="response(this.value)">
													<option value="0">--Select Driver--</option>
													<%
														List<DriverBean> listOfDriver = allListVtsDAO.getListOfDriver();

														for (DriverBean driverBean : listOfDriver) {
															if(driverBean.getDriver_id() == Integer.parseInt(driverId)){
													%>
													<option
														value="<%=driverBean.getDriver_id()%>" selected="selected"><%=driverBean.getDriver_first_name()%> <%=driverBean.getDriver_last_name() %></option>
													<%}else {	%>
															<option
														value="<%=driverBean.getDriver_id()%>"><%=driverBean.getDriver_first_name()%> <%=driverBean.getDriver_last_name() %></option>
													<%} %>
													
													<%
														}
													%>
												</select>
						</div>
					
					</div>
					<br>
					<div align="center">
					<input type="submit" name="submit" value="SUBMIT" class="btn btn-primary">
					</div>
				</div>
				</form>
				</div>
				</div>
				</div>
			</div>

		<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h1 class="card-title" id="horz-layout-basic"><b><font size="2px">Vehicle Document History</font></b></h1>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
		<!-- 	<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<h5>
								<b>Vehicle Service History</b>
							</h5>
						</div> -->
						<!-- /.panel-heading -->

						<div class="panel-body">

							<div class="dataTable_wrapper">
							<div class ="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="datatable-buttons">
									<thead>
																<tr>
																<th>No.</th>
																	<th>Vehicle Record Date</th>
																	<th>Item(Change)</th>
																	<th>Amount</th>
																	<th>Driver Name</th>
																	<th>Vehicle Name</th>
																	<th>Free Service</th>
																	<th>Kilometer</th>
																	<th>Action</th>
																</tr>
															</thead>
									<tbody>
										<%
																	int k=1;
																	AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
																	List<VehicleServiceRecordBean> listOfVehiclesTracking = allListVtsDAO.getListOfVehicleServiceFilter(fromDate, toDate, vehicleId, driverId, count);
																	for (VehicleServiceRecordBean v : listOfVehiclesTracking) {
																%>
													<tr>
														<tr>
																<td><%=k++%></td>
																	<td><%=ddmmyyyy.format(yyyymmdd.parse(v.getRecord_date()))%></td>
																	<td><%=v.getItems_change()%></td>
																	<td><%=v.getAmount() %></td>
																	<td><%=v.getDriverBean().getDriver_first_name()%> <%=v.getDriverBean().getDriver_last_name()%></td>
																	<td><%=v.getVehicleBean().getVehicle_name()%><%=v.getVehicleBean().getVehicle_no()%></td>
																	<td><%=v.getFree_service()%></td>
																	<td><%=v.getKilometer()%></td>
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
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>
			</div>
			</div>
			</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
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
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
	<script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable();
            $('#datatable1').dataTable();
            $('#datatable-keytable').DataTable({
              keys: true
            });
            $('#datatable-responsive').DataTable();
            $('#datatable-scroller').DataTable({
              ajax: "js/datatables/json/scroller-demo.json",
              deferRender: true,
              scrollY: 380,
              scrollCollapse: true,
              scroller: true	
            });
            var table = $('#datatable-fixed-header').DataTable({
              fixedHeader: true
            });
          });
          TableManageButtons.init();
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