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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLTL HRMS</title>

<%@include file="header.jsp"%>
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
<body>
<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Vehicle Service Record System</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<%AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
			 int current_month = Calendar.getInstance().get(Calendar.MONTH)+1;
			 AllListDAO allListDAO = new AllListDAO();
			 MonthBean monthBean = allListDAO.getListOfMonthById(current_month);
			%>
				<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Basic Information</div>
						<div class="panel-body">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#vehicleRecordForm" data-toggle="tab"><span class="fa fa-plus-circle fa-fw"></span> Vehicle Service Record
										</a></li>
										<!-- <li><a href="#history" data-toggle="tab"><span class="fa fa-history fa-fw"></span>  Tracking History</a></li> -->
							
								<li><a href="#vehicleRecordFormList" data-toggle="tab"><span class="fa fa-taxi fa-fw"></span>  Vehicle Service Record List (<%=monthBean.getMonth_name()%>)</a></li>
								


							</ul>
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
														class="fa fa-question-circle" data-toggle="tooltip"
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
																	<th>Kilometer</th>
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
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->
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
	</div>
	</div>
	 <script src="js/jquery1111.min.js"></script>
<script src="js/jquery-ui1104.min.js"></script>


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