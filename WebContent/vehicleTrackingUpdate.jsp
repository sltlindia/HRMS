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
<script type='text/javascript'
	src='/HRMS/dwr/interface/TrackingAjaxDataDAO.js'></script>
<script type='text/javascript' src='/HRMS/dwr/engine.js'></script>
<script type='text/javascript' src='/HRMS/dwr/util.js'></script>

<script type="text/javascript">
	function response(vehicle_id) {

		TrackingAjaxDataDAO.getMaxReading(vehicle_id, function(data) {
			dwr.util.setValue(start_reading, data);
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

		if (start_reading == 0) {
			alert("Start reading can not be zero");
			document.getElementById("start_reading").value = "";
		} else if (start_reading < end_reading) {
			var total_km = parseFloat(end_reading) - parseFloat(start_reading);
			document.getElementById("kilometer").value = total_km.toFixed(2);
		} else {
			if (end_reading != 0) {
				alert("End reading should be greater than start reading");
				document.getElementById("kilometer").value = "0";
			}
		}

	}

	function changeAVG() {
		var kilometer = parseFloat(document.getElementById("kilometer").value);
		var litre = parseFloat(document.getElementById("ltr").value);

		if (kilometer != 0 && litre != 0) {
			var avg = parseFloat(kilometer) / parseFloat(litre);
			document.getElementById("average").value = avg.toFixed(2);
		} else {
			alert("Kilometer or average should not be zero");
		}
	}
</script>
<body>
	<%
		int emp_id = user.getEmployee_master_id();
		int i = 0;
		int j = 0;
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
	%>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Vehicle Tracking System</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Tracking Update</div>
						<div class="panel-body">
							<div class="tab-pane fade in active" id="tracking">
								<form action="trackingHistoryUpdate" melabelod="post"
									enctype="multipart/form-data">
									<br>
									<%int vehicle_tracking_id = Integer.parseInt(request.getParameter("vehicle_tracking_id"));
									AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
									VehicleTrackingBean vehicleTrackingBean = allListVtsDAO.getVehicleTrackingById(vehicle_tracking_id);
									%>
									<input type="hidden" name="vehicle_tracking_id" value="<%=vehicle_tracking_id%>">
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
											<label>Date</label> <input type="text" class="form-control"
												name="date" id="date" required="required"
												onchange="ValidateDate(this.value)" value="<%=vehicleTrackingBean.getDate()%>">

										</div>



									</div>
									<hr>
									<div class="row">
										<!-- <div class="col-lg-3">
												<label>Driver Name</label> <input type="text"
													class="form-control" name="driver_name" id="driver_name"
													placeholder="Enter Driver Name" required>
											</div> -->

										<div class="col-lg-3">
											<label>Driver Name</label> <select class="form-control"
												name="driver_id" id="driver_id" required="required">
												<option value="">--Select Driver--</option>
												<%
													List<DriverBean> listOfDriver = allListVtsDAO.getListOfDriver();

													for (DriverBean driverBean : listOfDriver) {
														if(driverBean.getDriver_id() == vehicleTrackingBean.getDriverBean().getDriver_id()){%>
														
												<option value="<%=driverBean.getDriver_id()%>" selected="selected"><%=driverBean.getDriver_first_name()%>
													<%=driverBean.getDriver_last_name()%></option>
													<%}else{ %>
													<option value="<%=driverBean.getDriver_id()%>"><%=driverBean.getDriver_first_name()%>
													<%=driverBean.getDriver_last_name()%></option>
													
													<%} %>
												<%
													}
												%>
											</select>
										</div>

										<div class="col-lg-3">
											<label>Vehicle No.</label> <select class="form-control"
												name="vehicle_id" id="vehicle_id" required="required">
												<option value="">--Select Vehicle--</option>
												<%
													List<VehicleBean> listOfVehicleList = allListVtsDAO.getListOfVehicles();

													for (VehicleBean vehicleBean : listOfVehicleList) {
												if(vehicleBean.getVehicle_master_id() == vehicleTrackingBean.getVehicleBean().getVehicle_master_id()){%>
												<option value="<%=vehicleBean.getVehicle_master_id()%>" selected="selected"><%=vehicleBean.getVehicle_name()%>
													(<%=vehicleBean.getVehicle_no()%>)
												</option>
												<%}else{ %>
												<option value="<%=vehicleBean.getVehicle_master_id()%>"><%=vehicleBean.getVehicle_name()%>
													(<%=vehicleBean.getVehicle_no()%>)
												</option>
												<%} %>
												<%
													}
												%>
											</select>
										</div>
										<div class="col-lg-3">
											<label>Start Reading</label> <input type="number" step="any"
												class="form-control" name="start_reading" id="start_reading"
												placeholder="Enter Start Reading" onchange="changeKM()" value=<%=vehicleTrackingBean.getStart_reading() %>
												required>
										</div>
										<div class="col-lg-3">
											<label>End Reading</label> <input type="number" step="any"
												class="form-control" name="end_reading" id="end_reading"
												value="<%=vehicleTrackingBean.getEnd_reading()%>" placeholder="Enter End Reading"
												onchange="changeKM();changeAVG()" required>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-lg-3">
											<label>Kilometer</label> <input type="text"
												class="form-control" name="kilometer" id="kilometer"
												value="0" readonly="readonly">
										</div>
										<div class="col-lg-3">
											<label>Litre</label> <input type="number"
												class="form-control" step="any" name="ltr" id="ltr"
												placeholder="Enter Litre" onchange="changeAVG()" value="<%=vehicleTrackingBean.getLitre()%>" required>
										</div>
										<div class="col-lg-3">
											<label>Amount (Rs.)</label> <input type="text"
												class="form-control" name="amount" id="amount" value="<%=vehicleTrackingBean.getAmount()%>"
												placeholder="Enter Amount" required>
										</div>

										<div class="col-lg-3">
											<label>Average</label> <input type="text"
												class="form-control" name="average" id="average" value="0"
												placeholder="Enter Average" readonly="readonly" value="<%=vehicleTrackingBean.getLitre()%>">
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
									<div class="col-lg-12">
										<div class="panel panel-danger">
											<div class="panel-heading">
												<h5>
													<b>End Reading Remain History</b>
												</h5>
											</div>
											<div class="panel-body">

												<div class="dataTable_wrapper">
													<table
														class="table table-striped table-bordered table-hover"
														id="dataTables-example">
														<thead>
															<tr>
																<th>No.</th>
																<th>Driver</th>
																<th>Date</th>
																<th>Vehicle Name</th>
																<th>Vehicle No.</th>
																<th>Start reading</th>
																<th>End reading</th>
																<th>km</th>
																<th>ltr</th>
																<th>Amount</th>
																<th>Average</th>
																<th>Action</th>
															</tr>
														</thead>
														<tbody>
															<%
																int k = 1;
																AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
																List<VehicleTrackingBean> listOfVehiclesTracking = allListVtsDAO3.getListOfVehiclesTrackingEndReadingZero();
																for (VehicleTrackingBean t : listOfVehiclesTracking) {
															%>
															<tr>
																<td><%=k++%></td>
																<td><%=t.getDriverBean().getDriver_first_name() + " " + t.getDriverBean().getDriver_last_name()%></td>
																<td><%=t.getDate()%></td>
																<td><%=t.getVehicleBean().getVehicle_name()%></td>
																<td><%=t.getVehicleBean().getVehicle_no()%></td>
																<td><%=t.getStart_reading()%></td>
																<td><%=t.getEnd_reading()%></td>
																<td><%=t.getKm()%></td>
																<td><%=t.getLitre()%></td>
																<td><%=t.getAmount()%></td>
																<td><%=t.getAverage()%></td>
																<td><a
																	href="vehicleTrackingUpdate.jsp?vehicle_tracking_id=<%=t.getVehicle_tracking_id()%>"><i
																		class="glyphicon glyphicon-edit" data-toggle="tooltip"
																		data-placement="top" title="Edit Data"></i></a>&nbsp;<a
																	href="vehicleTrackingDelete?vehicle_tracking_id=<%=t.getVehicle_tracking_id()%>"><i
																		class="glyphicon glyphicon-trash"
																		data-toggle="tooltip" data-placement="top"
																		title="Delete Data" onclick="return confSubmit()"
																		style="color: red;"></i></a></td>
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
						<!-- /.ending of tab content -->
					</div>
				</div>
			</div>
		</div>
	</div>
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