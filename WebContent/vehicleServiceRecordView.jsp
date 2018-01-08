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
<script type='text/javascript'
	src='/HRMS/dwr/interface/TrackingAjaxDataDAO.js'></script>
<script type='text/javascript' src='/HRMS/dwr/engine.js'></script>
<script type='text/javascript' src='/HRMS/dwr/util.js'></script>


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
			int vehicle_service_id = Integer.parseInt(request.getParameter("vehicle_service_id"));
			VehicleServiceRecordBean vehicleServiceRecordBean = allListVtsDAO.getVehicleServiceRecordById(vehicle_service_id);
			%>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Vehicle Service Record</div>
						<div class="panel-body">
							<form action="vehicleServiceRecordUpdate" method="post">
							<input type="hidden" name="vehicle_service_id" value="<%=vehicleServiceRecordBean.getVehicle_service_record_id()%>">
								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped table-hover">
											<tr>
											<th>Date</th>
												<td>:</td>
												<td>
													<input type="text" class="form-control"
												value="<%=vehicleServiceRecordBean.getRecord_date() %>" disabled="disabled"></td>
											</tr>
											<tr>
												<td><label>&nbsp;Free Service or not??&nbsp;<i
														class="fa fa-question-circle" data-toggle="tooltip"
														data-placement="top"
														title="This vehicle has free service or not?" value="<%=vehicleServiceRecordBean.getFree_service()%>"></i></label></td>
												<td>:</td>
												<td>
												<input type="text" class="form-control" disabled="disabled"
													value="<%=vehicleServiceRecordBean.getFree_service()%>">
												</td>
											</tr>
											<tr>
											<th>Driver Name</th>
											<td>:</td>
												<td>
												<input type="text" class="form-control"
												value="<%=vehicleServiceRecordBean.getDriverBean().getDriver_first_name()%> <%=vehicleServiceRecordBean.getDriverBean().getDriver_last_name()%>" disabled="disabled">
												</td>
											</tr>
											<tr>
											<th>Vehicle No.</th>
											<td>:</td>
											<td>
											<input type="text" class="form-control"
												value="<%=vehicleServiceRecordBean.getVehicleBean().getVehicle_name()%> <%=vehicleServiceRecordBean.getVehicleBean().getVehicle_no()%>" disabled="disabled">
												</td>
											</tr>
											<tr>
												<th>Items(Change)</th>
												<td>:</td>
												<td colspan="5"><textarea
														class="form-control" disabled="disabled"><%=vehicleServiceRecordBean.getItems_change() %></textarea></td>
											</tr>
											<tr>
												<th>Amount</th>
												<td>:</td>
												<td colspan="5"><input type="number"  step="any" class="form-control" disabled="disabled"
													value="<%=vehicleServiceRecordBean.getAmount()%>"></td>
											</tr>
											<tr>
												<th>Kilometer</th>
												<td>:</td>
												<td colspan="5"><input type="number"  step="any" class="form-control" disabled="disabled"
													value="<%=vehicleServiceRecordBean.getKilometer()%>"></td>
											</tr>
											
										</table>
										<center>
											<a href="vehicleServiceRecordForm.jsp"><button type="button" class="btn btn-primary">Back</button></a>
											</center>
									</div>
								</div>
							</form>
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
			</div>
			<div class="row">
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