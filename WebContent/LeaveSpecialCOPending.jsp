<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.dao.AllListDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<title>CO Details</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<script type="text/javascript">
	function replica() {
		/* alert("akash"); */
		var a = document.getElementById('remarks');
		var b = document.getElementById('remarksReplica');

		b.value = a.value;

	}

	function validateForm() {
		var x = document.getElementById("remarks").value;
		if (x == null || x == "") {
			alert("Please fill Reject reason");
			return false;
		}
	}

	function reject(id) {

		//alert(id);

		if (id == 1) {
			document.getElementById('status').value = "approved"
		} else if (id == 2) {
			document.getElementById('status').value = "rejected"
		}
	}
	function reject1() {

		if (document.getElementById('remarks').value = " ") {
			alert("Please fill reason remarks");
		}
		/* }else if(id==2){
			document.getElementById('action').value ="rejected"
		} */
	}
</script>
<%@include file="header.jsp"%>
</head>
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int CO_ID = (Integer) request.getAttribute("CO_ID");
		AllListDAO allListDAO = new AllListDAO();

		List<LeaveCOBean> listOfCO = (ArrayList) request.getAttribute("listOfCO");

		for (LeaveCOBean coBean : listOfCO) {

			int emp_id = coBean.getEmployeeBean().getEmployee_master_id();

			LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) allListDAO.getleaveListbyEMP(emp_id);

			double co = leaveBalanceBean.getCO();
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
										<h3 class="page-header" align="Center">
											Compensatory Off Form <br> F-HRD-17
										</h3>

									</div>
								</div>
								<%
									if (request.getAttribute("LeaveExist") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${LeaveExist}
									</div>
								</div>
								<%
									} else if (request.getAttribute("LeaveSuccessfully") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-success">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${LeaveSuccessfully}
									</div>
								</div>
								<%
									} else if (request.getAttribute("LeavefromtodateExist") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${LeavefromtodateExist}
									</div>
								</div>
								<%
									}
								%>
								<!-- /.row -->
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h4 align="left">
													Date :
													<%
													DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
														Date today = Calendar.getInstance().getTime();

														String date1 = dateFormat.format(today);

														String d = null;

														try {

															SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
															Date result = formater.parse(date1);
															SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
															d = AppDateFormat.format(result);
															System.out.println(AppDateFormat.format(result));
														} catch (ParseException e1) {
															e1.printStackTrace();
														}
												%><%=d%></h4>

											</div>


											<div class="panel-body">
												<form action="ManagerCOUpdate" method="post" id="LeaveCO"
													name="LeaveCO" enctype="multipart/form-data">
													<table class="table table-stripped" border="0">
														<tbody>
															<tr>
																<th><label>Employee Name</label></th>
																<td>:</td>
																<td colspan="2"><input type="text"
																	name="contactNumberDuringLeave" class="form-control"
																	value="<%=coBean.getEmployeeBean().getFirstname()%> <%=coBean.getEmployeeBean().getLastname()%>"
																	required></input> <input type="hidden" name="CO_Id"
																	id="lid" value="<%=CO_ID%>"> <input
																	type="hidden" name="CO" id="lid" value="<%=co%>">
																	<input type="hidden" name="Empid" id="lid"
																	value="<%=emp_id%>">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label style="width: 200px">Please
																		briefly describe the need of working on holiday</label></th>
																<td>:</td>
																<td colspan="3"><textarea id="describe" rows="2"
																		value="" width="155" name="describe" required
																		class="form-control"><%=coBean.getDecripction()%></textarea>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Date</label></th>
																<td>:</td>
																<td colspan="3"><input type="text" id="datepicker1"
																	width="155" name="fromDate"
																	value="<%=coBean.getCO_date()%>" required
																	class="form-control">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Start Time</label></th>
																<td>:</td>
																<td colspan="3"><input type="time" id="starttime"
																	name="starttime" onchange="diff()"
																	value="<%=coBean.getStart_time()%>"
																	class="form-control">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>End Time</label></th>
																<td>:</td>
																<td colspan="3"><input type="time" id="endtime"
																	value="<%=coBean.getEnd_time()%>" name="endtime"
																	onchange="diff()" class="form-control">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Total Hours Count</label></th>
																<td>:</td>
																<td colspan="3"><input type="text" id="totalhours"
																	value="<%=coBean.getTotal_Hours()%>"
																	name="totalhours" class="form-control"
																	readonly="readonly">
															</tr>
														</tbody>
														<%
															}
														%>
														<tbody>
															<tr>
																<td align="center" colspan="4">
																	<!-- /.modal-dialog --> <input type="hidden"
																	name="specialCO" value="specialCO"> <input
																	type="hidden" name="action" id="action" value="">
																	<button class="btn btn-success btn-lg" type="submit"
																		value="accept" onclick="reject(1)">Accept</button> <input
																	type="submit" class="btn btn-danger btn-lg" id="reason"
																	type="submit" value="reject"
																	onclick="reject(2); return validateForm();">
																</button>



																</td>
															</tr>
															<tr>
																<td colspan="4">
																	<div class="form-group has-error">
																		<label class="control-label" for="remarks">Reject
																			Reason / Remarks</label> <input type="text"
																			class="form-control" id="remarks" name="remarks"
																			oninput="replica()">
																	</div>
																</td>
															</tr>
														</tbody>
														<input type="hidden" name="status" id="status"
															value="approved">

													</table>
												</form>
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
	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->
</body>
</html>