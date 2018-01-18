<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.vehicletracking.bean.DriverBean"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Track History Report</title>
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
     <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
    <%@include file="header.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		var $datepicker1 = $("#fromDate");
		var $datepicker2 = $("#toDate");

		$datepicker1.datepicker({
			dateFormat : 'yy-mm-dd',
			onSelect : function(dateStr) {
				if ($('#toDate').val() == "") {
					$('#toDate').val(this.value);
				}
			}

		});

		$datepicker2.datepicker({
			dateFormat : 'yy-mm-dd',
		});

	});
</script>


</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
	%>
	<%
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy");
	%>

	<%
		String fromDate = "";
		String toDate = "";
		String vehicleId = "0";
		String driverId = "0";
		int count = 0;

		if (request.getParameter("fromDate") != null) {
			fromDate = request.getParameter("fromDate");
			if (!fromDate.equalsIgnoreCase("")) {
				count++;
			}
		}

		if (request.getParameter("toDate") != null) {
			toDate = request.getParameter("toDate");
			if (!toDate.equalsIgnoreCase("")) {
				count++;
			}
		}

		if (request.getParameter("vehicle_id") != null) {
			vehicleId = request.getParameter("vehicle_id");
			if (!vehicleId.equalsIgnoreCase("0")) {
				count++;
			}
		}

		if (request.getParameter("driver_id") != null) {
			driverId = request.getParameter("driver_id");
			if (!driverId.equalsIgnoreCase("0")) {
				count++;
			}
		}

		System.out.println("Count:" + count);
		AllListDAO allListDAO = new AllListDAO();
		List<MonthBean> allMonthList = allListDAO.getListOfMonth();
		List<Double> listOfAverage = new ArrayList<>();
	%>
<div class="app-content container center-layout mt-2">
	<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Vehicle Tracking History</h1>
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
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Basic Information</div> -->
						<div class="panel-body">
                            	
							<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
								<%
									if (request.getParameter("action") == null) {
								%>
								<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#vehicleServiceHistory"
									aria-expanded="true" data-toggle="tab"><span class="icon-plus-circled"></span>
										Vehicle Track History </a></li>
								<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Average_graph" 
									aria-expanded="true" data-toggle="tab"><span class="icon-android-car"></span> 
										Average Graph</a></li>
								<%
									} else {
								%>
								<li  class="nav-item"><a class="nav-link" href="#vehicleServiceHistory" 
									aria-expanded="true" data-toggle="tab"><span class="icon-plus-circled"></span> 
									Vehicle Track History</a></li>
								<li class="nav-item"><a class="nav-link active" href="#Average_graph"
									aria-expanded="true" data-toggle="tab"><span class="icon-android-car"></span>
										Average Graph</a></li>
								<%
									}
								%>
							</ul>
							<hr>
							<div class="tab-content">
								<%
									if (request.getParameter("action") == null) {
								%>
								<div class="tab-pane fade in active" id="vehicleServiceHistory">
									<%
										} else {
									%>
									<div class="tab-pane fade" id="vehicleServiceHistory">
										<%
											}
										%>
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
																id="fromDate" value="<%=fromDate%>"
																placeholder="dd-mm-yyyy">
														</div>

														<div class="col-md-2 col-lg-2 col-sm-2">
															<center>
																<h6>To</h6>
															</center>
														</div>
														<div class="col-md-4 col-lg-4 col-sm-4">
															<input type="text" class="form-control" name="toDate"
																id="toDate" value="<%=toDate%>" placeholder="dd-mm-yyyy">
														</div>

													</div>
													<br>
													<div class="row">

														<div class="col-md-2 col-lg-2 col-sm-2">
															<h6>Vehicle No :</h6>
														</div>

														<div class="col-md-4 col-lg-4 col-sm-4">
															<select class="form-control" name="vehicle_id"
																id="vehicle_id" onchange="response(this.value)">
																<option value="0">--Select Vehicle--</option>
																<%
																	List<VehicleBean> listOfVehicleList = allListVtsDAO.getListOfVehicles();

																	for (VehicleBean vehicleBean : listOfVehicleList) {
																		if (vehicleBean.getVehicle_master_id() == Integer.parseInt(vehicleId)) {
																%>
																<option value="<%=vehicleBean.getVehicle_master_id()%>"
																	selected="selected"><%=vehicleBean.getVehicle_name()%>
																	(<%=vehicleBean.getVehicle_no()%>)
																</option>
																<%
																	} else {
																%>
																<option value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%>
																	(<%=vehicleBean.getVehicle_no()%>)
																</option>
																<%
																	}
																%>

																<%
																	}
																%>
															</select>
														</div>



														<div class="col-md-2 col-lg-2 col-sm-2">
															<center>
																<h6>Driver Name :</h6>
															</center>
														</div>

														<div class="col-md-4 col-lg-4 col-sm-4">
															<select class="form-control" name="driver_id"
																id="driver_id" onchange="response(this.value)">
																<option value="0">--Select Driver--</option>
																<%
																	List<DriverBean> listOfDriver = allListVtsDAO.getListOfDriver();

																	for (DriverBean driverBean : listOfDriver) {
																		if (driverBean.getDriver_id() == Integer.parseInt(driverId)) {
																%>
																<option value="<%=driverBean.getDriver_id()%>"
																	selected="selected"><%=driverBean.getDriver_first_name()%>
																	<%=driverBean.getDriver_last_name()%></option>
																<%
																	} else {
																%>
																<option value="<%=driverBean.getDriver_id()%>"><%=driverBean.getDriver_first_name()%>
																	<%=driverBean.getDriver_last_name()%></option>
																<%
																	}
																%>

																<%
																	}
																%>
															</select>
														</div>

													</div>
													<br>
													<div align="center">
														<input type="submit" name="submit" value="SUBMIT"
															class="btn btn-primary">
													</div>
												</div>
											</form>
										</div>

										<%
											AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
											List<VehicleTrackingBean> listOfVehiclesTracking = allListVtsDAO.getListOfVehicleFilter(fromDate, toDate,
													vehicleId, driverId, count);
											double total_km = 0;
											double total_ltr = 0;
											double total_amount = 0;
											double average = 0;
											for (VehicleTrackingBean li : listOfVehiclesTracking) {
												if (li.getKm() != 0 && li.getEnd_reading() != 0) {
													total_km = total_km + li.getKm();
													total_ltr = total_ltr + li.getLitre();
													total_amount = total_amount + li.getAmount();
													average = total_km / total_ltr;

												}
											}
										%>
										<br>
				<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Total Average</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
										
													<div class="panel-body">
														<div class="col-lg-12">
															<div class="col-lg-3">
																<label>Total Kilometer : </label> <label><%=total_km%></label>
															</div>
															<div class="col-lg-3">
																<label>Total Liter : </label> <label><%=total_ltr%></label>
															</div>
															<div class="col-lg-3">
																<label>Total Amount : </label> <label><%=total_amount%></label>
																</div>
															<div class="col-lg-3">
																<label>Total Average : </label> <label><%=String.format("%.2f", average)%></label>
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
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Tracking History</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
										
													<div class="panel-body">

														<div class="dataTable_wrapper">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable-buttons">
																<thead>
																<tr>
																	<th style=" padding: 0.4rem; width: 73.8px;">No.</th>
																	<th style=" padding: 0.4rem; width: 108.8px;">Driver</th>
																	<th style=" padding: 0.4rem; width: 113.8px;">Date</th>
																	<th style=" padding: 0.4rem; width: 139.8px;">Vehicle Name</th>
																	<th style=" padding: 0.4rem; width: 133.8px;">Start reading</th>
																	<th style=" padding: 0.4rem; width: 132.8px;">End reading</th>
																	<th style=" padding: 0.4rem; width: 124.8px;">km</th>
																	<th style=" padding: 0.4rem; width: 145.8px;">ltr</th>
																	<th style=" padding: 0.4rem; width: 99.8px;">Amount</th>
																	<th style=" padding: 0.4rem; width: 97.8px;">Average</th>
																	<th style=" padding: 0.4rem; width: 137.8px;">Attachment</th>
																</tr>
																</thead>
																<tbody>
																	<%
																		int k = 1;

																		for (VehicleTrackingBean t : listOfVehiclesTracking) {
																	%>
																	<tr>
																		<td style=" padding: 0.4rem; width: 73.8px;"><%=k++%></td>
																		<td style=" padding: 0.4rem; width: 108.8px;"><%=t.getDriverBean().getDriver_first_name() + " " + t.getDriverBean().getDriver_last_name()%></td>
																		<td style=" padding: 0.4rem; width: 113.8px;"><%=ddmmyyyy.format(yyyymmdd.parse(t.getDate()))%></td>
																		<td style=" padding: 0.4rem; width: 139.8px;"><%=t.getVehicleBean().getVehicle_name()%> <%=t.getVehicleBean().getVehicle_no()%></td>
																		<td style=" padding: 0.4rem; width: 133.8px;"><%=t.getStart_reading()%></td>
																		<td style=" padding: 0.4rem; width: 132.8px;"><%=t.getEnd_reading()%></td>
																		<td style=" padding: 0.4rem; width: 124.8px;"><%=t.getKm()%></td>
																		<td style=" padding: 0.4rem; width: 145.8px;"><%=t.getLitre()%></td>
																		<td style=" padding: 0.4rem; width: 99.8px;"><%=t.getAmount()%></td>
																		<td style=" padding: 0.4rem; width: 97.8px;"><%=t.getAverage()%></td>
																		<td style=" padding: 0.4rem; width: 137.8px;">
																		<%String ext2 = FilenameUtils.getExtension(t.getAttachment());
								if(t.getAttachment() != null){
								%>
								 <a target="_blank" href="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getAttachment()%>">
      <img src="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getVehicleBean().getVehicle_name()%>_<%=t.getVehicleBean().getVehicle_no()%>\fuel_tracking\<%=t.getAttachment()%>" alt="<%=t.getAttachment()%>" width="60" height="60">
    </a>
								<%} 
								else { %>
								<a>-</a>
								<%} %>
								</td>
																		<%-- <%if(t.getAttachment() != null){ %>
																		<td><%=t.getAttachment()%></td>
																		<%}else{ %>
																		<td>-</td>
																		<%} %> --%>
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
									<%
										if (request.getParameter("action") == null) {
									%>
									<div class="tab-pane fade" id="Average_graph">
										<%
											} else {
										%>
										<div class="tab-pane fade in active" id="Average_graph">
											<%
												}
											%>
											 <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Tracking History</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
										
														<!-- /.panel-heading -->

														<div class="panel-body">
															<form action="trackHistoryFilter.jsp">
																<div class="row">
																	<div class="col-md-2 col-lg-2 col-sm-2">
																		<h6>Vehicle No :</h6>
																	</div>
																	<input type="hidden" name="action" value="action">
																	<div class="col-md-4 col-lg-4 col-sm-4">
																		<select class="form-control" name="vehicle_id_graph"
																			id="vehicle_id" onchange="response(this.value)">
																			<option value="0">--Select Vehicle--</option>

																			<%
																				String vehicle_id_graph = "";

																				for (VehicleBean vehicleBean : listOfVehicleList) {
																					if (request.getParameter("action") != null) {
																						vehicle_id_graph = request.getParameter("vehicle_id_graph");
																						if (vehicleBean.getVehicle_master_id() == Integer.parseInt(vehicle_id_graph)) {
																			%>
																			<option
																				value="<%=vehicleBean.getVehicle_master_id()%>"
																				selected="selected"><%=vehicleBean.getVehicle_name()%>
																				(<%=vehicleBean.getVehicle_no()%>)
																			</option>
																			<%
																				} else {
																			%>
																			<option
																				value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%>
																				(<%=vehicleBean.getVehicle_no()%>)
																			</option>
																			<%
																				}
																					} else {
																			%>
																			<option
																				value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%>
																				(<%=vehicleBean.getVehicle_no()%>)
																			</option>
																			<%
																				}
																			%>
																			<%
																				}
																			%>
																		</select>

																		<%
																			for (MonthBean m : allMonthList) {
																				int month_id = m.getMonth_id();
																				double average1 = 0;
																				double total_km1 = 0;
																				double total_ltr1 = 0;

																				if (request.getParameter("action") != null) {
																					vehicle_id_graph = request.getParameter("vehicle_id_graph");
																					int vehicle_graph_id = Integer.parseInt(vehicle_id_graph);
																					List<VehicleTrackingBean> listOfAllVehicleTrackingByGraph = allListVtsDAO
																							.getVehicleAverageGraph(vehicle_graph_id, month_id);
																					for (VehicleTrackingBean vt : listOfAllVehicleTrackingByGraph) {

																						if (vt.getKm() != 0 && vt.getEnd_reading() != 0) {
																							total_km1 = total_km1 + vt.getKm();
																							total_ltr1 = total_ltr1 + vt.getLitre();
																						}

																					}

																					if (total_ltr1 != 0) {
																						average1 = total_km1 / total_ltr1;
																					}
																					listOfAverage.add(average1);

																				}
																			}
																		%>
																	</div>
																	<input type="submit" value="Submit"
																		class="btn btn-primary">
																</div>


															</form>
															<div class="row">
																<div class="col-lg-12">
																	
																		<div class="panel-heading">
																			<i class="icon-bar-chart-o"></i> Average Report
																		</div>
																		<!-- /.panel-heading -->
																		<div class="panel-body" align="center">
																			<div id="taskReport"></div>
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
			</div>
			</div>
			</div>
			</section>
		</div>
	</div>
	</div>
	<script type="text/javascript">
 
 FusionCharts.ready(function () {
	    var salesAnlysisChart = new FusionCharts({
	        type: 'mscombi2d',
	        renderAt: 'taskReport',
	        width: '700',
	        height: '350',
	        dataFormat: 'json',
	        dataSource: {
	            "chart": {
	                /* "caption": "Harry's SuperMart",
	                "subCaption": "Sales analysis of last year", */
	                "xAxisname": "Month",
	                "yAxisName": "Average",
	                /* "numberPrefix": "$", */
	                "showBorder": "0",
	                "showValues": "0",
	                "paletteColors": "#0075c2,#1aaf5d,#f2c500",
	                "bgColor": "#ffffff",
	                "showCanvasBorder": "0",
	                "canvasBgColor": "#ffffff",
	                "captionFontSize": "14",
	                "subcaptionFontSize": "14",
	                "subcaptionFontBold": "0",
	                "divlineColor": "#999999",
	                "divLineIsDashed": "1",
	                "divLineDashLen": "1",
	                "divLineGapLen": "1",
	                "showAlternateHGridColor": "0",
	                "usePlotGradientColor": "0",
	                "toolTipColor": "#ffffff",
	                "toolTipBorderThickness": "0",
	                "toolTipBgColor": "#000000",
	                "toolTipBgAlpha": "80",
	                "toolTipBorderRadius": "2",
	                "toolTipPadding": "5",
	                "legendBgColor": "#ffffff",
	                "legendBorderAlpha": '0',
	                "legendShadow": '0',
	                "legendItemFontSize": '10',
	                "legendItemFontColor": '#666666'
	            },
	            "categories": [
	                {
	                    "category": [
	                    	<%for (MonthBean monthBean : allMonthList) {%>

   	                {
   	                    "label": "<%=monthBean.getMonth_name()%>"
   	                },
   	                <%}%>
	                    ]
	                }
	            ],
	            "dataset": [
	                {
	                    "seriesName": "Average",
	                    "showValues": "1",
	                    "data": [
	                    	<%for (Double a : listOfAverage) {
	                    	
	                    	%>
	                    	        	                {
	                    	        	                    "value": <%=String.format("%.2f", a)%>
	                    	        	                },
	                    	        	               <%}%>
	                    ]
	                }
	                ]
	                
	        }
	    }).render();
	});
 
 </script>

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
				var handleDataTableButtons = function() {
					"use strict";
					0 !== $("#datatable-buttons").length
							&& $("#datatable-buttons").DataTable({
								dom : "Bfrtip",
								buttons : [ {
									extend : "copy",
									className : "btn-sm"
								}, {
									extend : "csv",
									className : "btn-sm"
								}, {
									extend : "excel",
									className : "btn-sm"
								}, {
									extend : "pdf",
									className : "btn-sm"
								}, {
									extend : "print",
									className : "btn-sm"
								} ],
								responsive : !0
							})
				}, TableManageButtons = function() {
					"use strict";
					return {
						init : function() {
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
						keys : true
					});
					$('#datatable-responsive').DataTable();
					$('#datatable-scroller').DataTable({
						ajax : "js/datatables/json/scroller-demo.json",
						deferRender : true,
						scrollY : 380,
						scrollCollapse : true,
						scroller : true
					});
					var table = $('#datatable-fixed-header').DataTable({
						fixedHeader : true
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