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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<title>Track History Report</title>
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
	type="text/css" />

<script type="text/javascript" src="js/canvasjs.min.js"></script>
<script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript"
	src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>

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
<%@include file="header.jsp"%>
<body>
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

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Vehicle Tracking History</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Basic Information</div>
						<div class="panel-body">
							<ul class="nav nav-tabs">
								<%
									if (request.getParameter("action") == null) {
								%>
								<li class="active"><a href="#vehicleServiceHistory"
									data-toggle="tab"><span class="fa fa-plus-circle fa-fw"></span>
										Vehicle Track History </a></li>
								<!-- <li><a href="#history" data-toggle="tab"><span class="fa fa-history fa-fw"></span>  Tracking History</a></li> -->

								<li><a href="#Average_graph" data-toggle="tab"><span
										class="fa fa-taxi fa-fw"></span> Average Graph</a></li>
								<%
									} else {
								%>
								<li><a href="#vehicleServiceHistory" data-toggle="tab"><span
										class="fa fa-plus-circle fa-fw"></span> Vehicle Track History
								</a></li>
								<!-- <li><a href="#history" data-toggle="tab"><span class="fa fa-history fa-fw"></span>  Tracking History</a></li> -->

								<li class="active"><a href="#Average_graph"
									data-toggle="tab"><span class="fa fa-taxi fa-fw"></span>
										Average Graph</a></li>
								<%
									}
								%>
							</ul>
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
										<div class="row">
											<div class="col-lg-12">
												<div class="panel panel-success">
													<div class="panel-heading">
														<h5>
															<b>Total Average</b>
														</h5>
													</div>
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
										<div class="row">
											<div class="col-lg-12">
												<div class="panel panel-danger">
													<div class="panel-heading">
														<h5>
															<b>Tracking History</b>
														</h5>
													</div>
													<!-- /.panel-heading -->

													<div class="panel-body">

														<div class="dataTable_wrapper">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable-buttons">
																<thead>
																	<tr>
																		<th>No.</th>
																		<th>Driver</th>
																		<th>Date</th>
																		<th>Vehicle Name</th>
																		<th>Start reading</th>
																		<th>End reading</th>
																		<th>km</th>
																		<th>ltr</th>
																		<th>Amount</th>
																		<th>Average</th>
																		<th>Attachment</th>
																	</tr>
																</thead>
																<tbody>
																	<%
																		int k = 1;

																		for (VehicleTrackingBean t : listOfVehiclesTracking) {
																	%>
																	<tr>
																		<td><%=k++%></td>
																		<td><%=t.getDriverBean().getDriver_first_name() + " " + t.getDriverBean().getDriver_last_name()%></td>
																		<td><%=ddmmyyyy.format(yyyymmdd.parse(t.getDate()))%></td>
																		<td><%=t.getVehicleBean().getVehicle_name()%> <%=t.getVehicleBean().getVehicle_no()%></td>
																		<td><%=t.getStart_reading()%></td>
																		<td><%=t.getEnd_reading()%></td>
																		<td><%=t.getKm()%></td>
																		<td><%=t.getLitre()%></td>
																		<td><%=t.getAmount()%></td>
																		<td><%=t.getAverage()%></td>
																		<td>
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
											<div class="row">
												<div class="col-lg-12">
													<div class="panel panel-default">
														<div class="panel-heading">
															<h5>
																<b>Tracking History</b>
															</h5>
														</div>
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
																			<i class="fa fa-bar-chart-o fa-fw"></i> Average Report
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

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>


	<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script> -->

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	<script src="js/datatables/dataTables.buttons.min.js"></script>
	<script src="js/datatables/buttons.bootstrap.min.js"></script>
	<script src="js/datatables/jszip.min.js"></script>
	<script src="js/datatables/pdfmake.min.js"></script>
	<script src="js/datatables/vfs_fonts.js"></script>
	<script src="js/datatables/buttons.html5.min.js"></script>
	<script src="js/datatables/buttons.print.min.js"></script>
	<script src="js/datatables/dataTables.fixedHeader.min.js"></script>
	<script src="js/datatables/dataTables.keyTable.min.js"></script>
	<script src="js/datatables/dataTables.responsive.min.js"></script>
	<script src="js/datatables/responsive.bootstrap.min.js"></script>
	<script src="js/datatables/dataTables.scroller.min.js"></script>

	<script src="js/pace/pace.min.js"></script>
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