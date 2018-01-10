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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
</head>
<!-- <script type='text/javascript' src='/HRMS/dwr/interface/TrackingAjaxDataDAO.js'></script>
  <script type='text/javascript' src='/HRMS/dwr/engine.js'></script>
  <script type='text/javascript' src='/HRMS/dwr/util.js'></script> -->

<script type="text/javascript">



function response(vehicle_id){
			
				TrackingAjaxDataDAO.getMaxReading(vehicle_id,function(data){
				 dwr.util.setValue(start_reading,data);
				});

}

	function checkInteger(id) {

		var a = document.getElementById(id).value;

		if (isNaN(a)) {
			alert("Only numeric value is valid.");
			document.getElementById(id).value = 0;
		}
	}

	function demo(complaint_id) {

		var retVal = confirm("Are you sure?");
		if (retVal == true) {
			window.location.replace("complaintDelete?complaint_id="
					+ complaint_id);
		} else {
			window.location.replace("complaint.jsp");
			return false;
		}
	}
</script>
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

function changeKM() {
	var start_reading = parseFloat(document.getElementById("start_reading").value);
	var end_reading = parseFloat(document.getElementById("end_reading").value);
	
			if(start_reading == 0){
				alert("Start reading can not be zero");
				document.getElementById("start_reading").value = "";
			}
			else if(start_reading < end_reading)
				{
				var total_km = parseFloat(end_reading)
					- parseFloat(start_reading);
			document.getElementById("kilometer").value = total_km.toFixed(2);
				}
			else{
				if(end_reading != 0){
				alert("End reading should be greater than start reading");
				document.getElementById("kilometer").value = "0";
				}
			}
		
	}
	
function changeAVG() {
	var kilometer = parseFloat(document.getElementById("kilometer").value);
	var litre = parseFloat(document.getElementById("ltr").value);
	
	if(kilometer != 0 && litre != 0){
		var avg = parseFloat(kilometer)/parseFloat(litre);
		document.getElementById("average").value = avg.toFixed(2);
	}else{
		alert("Kilometer or average should not be zero");
	}
}
</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int emp_id = user.getEmployee_master_id();
		int i = 0;
		int j = 0;
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
	%>
	<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Vehicle Tracking System</h1>
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
				               		<h4 class="card-title" id="horz-layout-basic">Basic Information</h4>
				                </div>
				            </div>
				             <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
								<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#tracking" aria-expanded="true" data-toggle="tab"><span class="icon-plus-circled"></span>&nbsp;Add Tracking
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#vehicle" aria-expanded="true" data-toggle="tab"><span class="icon-android-car"></span>&nbsp;Add Vehicle</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#vehicleList" aria-expanded="true" data-toggle="tab"><span class="icon-android-car"></span>&nbsp;Vehicle List</a>
							</li>
						</ul>
                            <hr>	
				               <!-- <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">

								<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#tracking" aria-expanded="true" data-toggle="tab"><span class="fa fa-plus-circle fa-fw"></span> Add Tracking
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#vehicle" aria-expanded="true" data-toggle="tab"><span class="fa fa-car fa-fw"></span>  Add Vehicle
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#vehicleList" aria-expanded="true" data-toggle="tab"><span class="fa fa-taxi fa-fw"></span>  Vehicle List
								</a>
							</li>
						</ul>
                            <hr>	
					 -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="tracking">
									<form action="trackingHistoryInsert" melabelod="post"
										enctype="multipart/form-data">
										<br>
										<div class="row">
											<div class="col-lg-3">
												<label>Employee Name</label> <label>:</label> <font
													color="#337ab7"><%=user.getFirstname() + " " + user.getLastname()%></font>
											</div>
											<input type="hidden" name="employee_master_id"
												class="form-control"
												value="<%=user.getEmployee_master_id()%>">
											<div class="col-lg-2">
												<label>Employee Code</label> <label>:</label> <label
													style="color: #337ab7"><%=user.getEmployee_code()%></label>
											</div>
											<div class="col-lg-3">
												<label>Department</label> <label>:</label> <label
													style="color: #337ab7"><%=user.getDepartmentBean().getDepartment_name()%></label>
											</div>
											<div class="col-lg-4">
												<label>Date</label> 
												<input type="text" class="form-control"
													name="date" id="date"
													required="required"
													onchange="ValidateDate(this.value)" placeholder="yyyy-mm-dd">
												
												</div>
											
											
											
										</div>
										<hr>
										<%AllListVtsDAO allListVtsDAO = new AllListVtsDAO(); %>
										<div class="row">
											<!-- <div class="col-lg-3">
												<label>Driver Name</label> <input type="text"
													class="form-control" name="driver_name" id="driver_name"
													placeholder="Enter Driver Name" required>
											</div> -->
											
											<div class="col-lg-3">
												<label>Driver Name</label> <select class="form-control"
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
											</div>
											
											<div class="col-lg-3">
												<label>Vehicle No.</label> <select class="form-control"
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
											</div>
											<div class="col-lg-3">
												<label>Start Reading</label> <input type="number"  step="any"
													class="form-control" name="start_reading" id="start_reading"
													placeholder="Enter Start Reading" onchange="changeKM()" required>
											</div>
											<div class="col-lg-3">
												<label>End Reading</label> <input type="number"  step="any"
													class="form-control" name="end_reading" id="end_reading" value="0"
													placeholder="Enter End Reading" onchange="changeKM()" required>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-lg-3">
												<label>Kilometer</label> <input type="text" class="form-control"
													name="kilometer" id="kilometer" value = "0"
													readonly="readonly">
											</div>
											<div class="col-lg-3">
												<label>Litre</label> <input type="number" class="form-control" step="any"
													name="ltr" id="ltr" placeholder="Enter Litre" onchange="changeAVG()"
													required>
											</div>
											<div class="col-lg-3">
												<label>Amount (Rs.)</label> <input type="text"
													class="form-control" name="amount" id="amount"
													placeholder="Enter Amount" required>
											</div>

											<div class="col-lg-3">
												<label>Average</label> <input type="text"
													class="form-control" name="average" id="average" value="0"
													placeholder="Enter Average" readonly="readonly">
											</div>

										</div>




										<!-- /.row -->
										<hr>
										<input type="hidden" name="redirect" value="">
										<center>
											<input type="submit" value="Submit" class="btn btn-primary">
											<input type="reset" value="Reset" class="btn btn-danger">
										</center>
										<br>
									</form>
									<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-radius: 4px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">End Reading Remain History</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
									<!-- <div class="row">
										<div class="col-lg-12">
											<div class="panel panel-danger">
												<div class="panel-heading">
													<h5>
														<b>End Reading Remain History</b>
													</h5>
												</div> -->
												<div class="panel-body">

													<div class="dataTable_wrapper">
														<table
															class="table table-striped table-bordered table-hover" id="dataTables-example">
															<thead>
																<tr>
																<th style=" padding: 0.4rem; width: 45.8px;" >No.</th>
																	<th style=" padding: 0.4rem; width: 109.8px;">Driver</th>
																	<th style=" padding: 0.4rem; width: 83.8px;">Date</th>
																	<th style=" padding: 0.4rem; width: 117.8px;">Vehicle Name</th>
																	<th style=" padding: 0.4rem; width: 104.8px;">Vehicle No.</th>
																	<th style=" padding: 0.4rem; width: 111.8px;">Start reading</th>
																	<th style=" padding: 0.4rem; width: 99.8px;">End reading</th>
																	<th style=" padding: 0.4rem; width: 43.8px;">km</th>
																	<th style=" padding: 0.4rem; width: 37.8px;">ltr</th>
																	<th style=" padding: 0.4rem; width: 75.8px;">Amount</th>
																	<th style=" padding: 0.4rem; width: 76.8px;">Average</th>
																	<!-- <th>Action</th> -->
																</tr>
															</thead>
															<tbody>
																<%
																	int k=1;
																	AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
																	List<VehicleTrackingBean> listOfVehiclesTracking = allListVtsDAO3.getListOfVehiclesTrackingEndReadingZero();
																	for (VehicleTrackingBean t : listOfVehiclesTracking) {
																%>
																<tr>
																<td style=" padding: 0.4rem; width: 45.8px;"><%=k++ %></td>
																	<td style=" padding: 0.4rem; width: 109.8px;"><%=t.getDriverBean().getDriver_first_name()+" "+t.getDriverBean().getDriver_last_name()%></td>
																	<td style=" padding: 0.4rem; width: 83.8px;"><%=ddmmyyyy.format(yyyymmdd.parse(t.getDate()))%></td>
																	<td style=" padding: 0.4rem; width: 117.8px;"><%=t.getVehicleBean().getVehicle_name() %></td>
																	<td style=" padding: 0.4rem; width: 104.8px;"><%=t.getVehicleBean().getVehicle_no() %></td>
																	<td style=" padding: 0.4rem; width: 111.8px;"><%=t.getStart_reading() %></td>
																	<td style=" padding: 0.4rem; width: 99.8px;"><%=t.getEnd_reading() %></td>
																	<td style=" padding: 0.4rem; width: 43.8px;"><%=t.getKm() %></td>
																	<td style=" padding: 0.4rem; width: 37.8px;"><%=t.getLitre() %></td>
																	<td style=" padding: 0.4rem; width: 75.8px;"><%=t.getAmount() %></td>
																	<td style=" padding: 0.4rem; width: 76.8px;"><%=t.getAverage() %></td>
																	<%-- <td>
																	<a
														href="vehicleTrackingUpdate.jsp?vehicle_tracking_id=<%=t.getVehicle_tracking_id()%>"><i
															class="glyphicon glyphicon-edit" data-toggle="tooltip"
															data-placement="top" title="Edit Data"></i></a>&nbsp;<a
														href="vehicleTrackingDelete?vehicle_tracking_id=<%=t.getVehicle_tracking_id()%>"><i
															class="glyphicon glyphicon-trash" data-toggle="tooltip"
															data-placement="top" title="Delete Data"
															onclick="return confSubmit()" style="color: red;"></i></a>
																	</td> --%>
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
									</div>
								</div>
								</div>
								</div>


								<div class="tab-pane fade" id="vehicle">
								</br>
								<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-radius: 4px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Add Vehicle</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
									
										<div class="panel-body">
										<form action="vehicleInsert" melabelod="post">
												<br>
												<div class="row">
													<div class="col-lg-12">
														<div class="col-lg-4">
															<label>Employee Name</label> <label>:</label> <font
																color="#337ab7"><%=user.getFirstname() + " " + user.getLastname()%></font>
														</div>
														<input type="hidden" name="employee_master_id"
															class="form-control"
															value="<%=user.getEmployee_master_id()%>">
														<div class="col-lg-2">
															<label>Employee Code</label> <label>:</label> <label
																style="color: #337ab7"><%=user.getEmployee_code()%></label>
														</div>
														<div class="col-lg-3">
															<label>Department</label> <label>:</label> <label
																style="color: #337ab7"><%=user.getDepartmentBean().getDepartment_name()%></label>
														</div>
													</div>
												</div>



												<hr>
												<div class="row">
													<div class="col-lg-12">
														<div class="col-lg-4">
															<label>Vehicle Name</label> <input type="text"
																class="form-control" name="vehicle_name"
																id="vehicle_name" placeholder="Enter Driver Name"
																required>
														</div>

														<div class="col-lg-4">
															<label>Vehicle No.</label> <input type="text"
																class="form-control" name="vehicle_no" id="vehicle_no"
																placeholder="GJ-AL-7858" required>
														</div>

														<div class="col-lg-4">
															<label>Vehicle Type</label> <select class="form-control"
																name="vehicle_type" id="vehicle_type"
																onchange="autoShow(this.value)" required="required">
																<option value="">--Select Vehicle Type--</option>
																<%
																	List<VehicleTypeBean> listOfVehicleType = allListVtsDAO.getListOfVehicleType();

																	for (VehicleTypeBean vehicleTypeBean : listOfVehicleType) {
																%>
																<option
																	value="<%=vehicleTypeBean.getVehicle_type_id()%>"><%=vehicleTypeBean.getVehicle_type_name()%></option>
																<%
																	}
																%>
															</select>
														</div>
													</div>
												</div>

												<!-- /.row -->
												<hr>
												<input type="hidden" name="redirect" value="">
												<center>
													<input type="submit" value="Submit" class="btn btn-primary">
													<input type="reset" value="Reset" class="btn btn-danger">
												</center>
												<br>
											</form>
										</div>
								</div>
								</div>
								</div>
								</div>
								</div>
								</div>
								
								<div class="tab-pane fade" id="vehicleList">
									<div class="row">
										<div class="col-lg-12">
											
												<!-- /.panel-heading -->

												<div class="panel-body">

													<div class="dataTable_wrapper">
														<table
															class="table table-bordered table-hover" id="dataTables-example">
															<thead>
																<tr>
																<th>No.</th>
																	<th>Vehicle Name</th>
																	<th>Vehicle Number</th>
																	<th>Vehicle Type</th>
																	<!-- <th>Action</th> -->
																</tr>
															</thead>
															<tbody>
																<%
																int c=1;
																	AllListVtsDAO allListVtsDAO2 = new AllListVtsDAO();
																	List<VehicleBean> listOfVehicles = allListVtsDAO2.getListOfVehicles();
																	for (VehicleBean v : listOfVehicles) {
																%>
																<tr>
																<td><%=c++ %></td>
																	<td><%=v.getVehicle_name()%></td>
																	<td><%=v.getVehicle_no()%></td>
																	<td><%=v.getVehicleTypeBean().getVehicle_type_name()%></td>
																<%-- 	<td>&nbsp;&nbsp;
																	<a href="vehicleDelete?vehicle_id=<%=v.getVehicle_master_id()%>" data-toggle="modal"><i class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="Delete Company" style="color: #337ab7;"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
																	<a href="vehicleUpdate.jsp?vehicle_id=<%=v.getVehicle_master_id()%>"data-toggle="modal"><i class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="Update Company"></i></a></td>
																 --%></tr>
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
									</div>
									
									</div><!-- /.ending of tab content -->
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