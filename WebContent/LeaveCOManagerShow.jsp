<%@page import="com.hrms.lms.util.DBConnection"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		int CO_ID = Integer.parseInt(request.getParameter("CO_ID"));
		AllListDAO allListDAO = new AllListDAO();
		String StartTime = null, EndTime = null;

		String PunchDate = null, PDate = null, Start = null, Stop = null, dateStart1 = null, dateStart2 = null,
				date3 = null, date4 = null;
		String PunchIn1 = null, PunchIn2 = null, PunchOut1 = null, PunchOut2 = null;
		String tempIntime = null, MININTIME = "", MAXOUTTIME = "";
		List<LeaveCOBean> listOfCO = (ArrayList) request.getAttribute("listOfCO");
		Connection conn = null;
		Statement smt;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		for (LeaveCOBean coBean : listOfCO) {

			int emp_id = coBean.getEmployeeBean().getEmployee_master_id();
			int emp_code = coBean.getEmployeeBean().getEmployee_code();
			int approval_by = coBean.getUnder_manager_id();
			LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) allListDAO.getleaveListbyEMP(emp_id);
			String CODATE = coBean.getCO_date();
			String company_code = coBean.getEmployeeBean().getCompanyListBean().getCompany_code();
			double co = leaveBalanceBean.getCO();

			if (conn != null) {
				smt = conn.createStatement();
				smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.In_Out_Detail where EMP_CODE = " + emp_code
						+ " AND Date = '" + CODATE + "' AND Code='" + company_code + "'");
				rs = smt.getResultSet();
				SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
				while (rs.next()) {
					String Intime = null, outtime = null;
					Start = rs.getString(9);
					Stop = rs.getString(10);

					if (Start != null) {
						Date result2 = formater2.parse(Start);
						dateStart1 = format.format(result2);
						Intime = time.format(result2);
						if (MININTIME.equals("")) {
							MININTIME = Intime;
						}

						if (tempIntime == null) {
							tempIntime = dateStart1;
						}

						if (PunchIn1 == null) {
							PunchIn1 = Intime;
						} else {
							PunchIn2 = Intime;
						}
					}

					if (Stop != null) {
						Date result3 = formater2.parse(Stop);
						dateStart2 = format.format(result3);
						outtime = time.format(result3);
						MAXOUTTIME = outtime;
						if (PunchOut1 == null) {
							PunchOut1 = outtime;

						} else {

							PunchOut2 = outtime;

						}
					}

				}

			}
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
													<div class="row">

														<%
															DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
																Date today = Calendar.getInstance().getTime();

																String date1 = dateFormat.format(today);

																String d = null;
																String start = null;

																try {

																	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
																	Date result = formater.parse(date1);
																	SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																	d = AppDateFormat.format(result);
																	System.out.println(AppDateFormat.format(result));
																} catch (ParseException e1) {
																	e1.printStackTrace();
																}

																try {

																	SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																	Date result1 = formater1.parse(coBean.getCO_date());
																	SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
																	start = formater2.format(result1);

																} catch (ParseException e1) {
																	e1.printStackTrace();
																}
														%>
														<div class="col-md-6">
															Date :
															<%=d%>
														</div>

														<%
															if (request.getParameter("hrApproval") != null) {
														%>
														<div class="col-md-6" align="right">
															<a href="pendingLeaveHrSide.jsp?hrApproval=co"
																style="color: white"><i class="fa fa-mail-reply"></i></a>
														</div>
														<%
															}
														%>

													</div>
												</h4>
											</div>


											<div class="panel-body">
												<form action="ManagerCOUpdate" method="post"
													enctype="multipart/form-data">
													<table class="table table-stripped" border="0">
														<tbody>
															<tr>
																<th width="250px"><label>Employee Name</label></th>
																<td>:</td>
																<td colspan="2"><input type="hidden"
																	name="contactNumberDuringLeave"
																	value="<%=coBean.getEmployeeBean().getFirstname()%> <%=coBean.getEmployeeBean().getLastname()%>"><%=coBean.getEmployeeBean().getFirstname()%>
																	<%=coBean.getEmployeeBean().getLastname()%></td>
																<input type="hidden" name="CO_Id" id="lid"
																	value="<%=CO_ID%>">
																<input type="hidden" name="CO" id="lid"
																	value="<%=co%>">
																<input type="hidden" name="Empid" id="lid"
																	value="<%=emp_id%>">
																<input type="hidden" name="approval" id="lid"
																	value="<%=approval_by%>">


																<th colspan="2"><center>Punching Time</center></th>


															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label style="width: 200px">Please
																		briefly describe the need of working on holiday</label></th>
																<td>:</td>
																<td colspan="2"><input type="hidden" id="describe"
																	value="<%=coBean.getDecripction()%>" name="describe"><%=coBean.getDecripction()%>
																</td>

																<th>In Time</th>
																<th>Out Time</th>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Date</label></th>
																<td>:</td>
																<td colspan="2"><input type="hidden"
																	id="datepicker1" name="fromDate" value="<%=start%>"><%=start%>
																</td>

																<td>
																	<%
																		if (PunchIn1 == null) {
																	%>--<%
																		} else {
																	%><%=PunchIn1%>
																	<%
																		}
																	%>
																</td>
																<td>
																	<%
																		if (PunchOut1 == null) {
																	%>--<%
																		} else {
																	%><%=PunchOut1%>
																	<%
																		}
																	%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<%
																StartTime = coBean.getStart_time();
																	EndTime = coBean.getEnd_time();

																/* 	SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH : mm aa");
																	SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
																	Date D1 = _24HourSDF.parse(StartTime);
																	Date D2 = _24HourSDF.parse(EndTime);
																	StartTime = _12HourSDF.format(D1);
																	EndTime = _12HourSDF.format(D2); */
															%>
															<tr>
																<th><label>Start Time</label></th>
																<td>:</td>
																<td colspan="2"><input type="hidden" id="starttime"
																	name="starttime" value="<%=coBean.getStart_time()%>"><%=StartTime%>
																</td>
																<td>
																	<%
																		if (PunchIn2 == null) {
																	%>--<%
																		} else {
																	%><%=PunchIn2%>
																	<%
																		}
																	%>
																</td>
																<td>
																	<%
																		if (PunchOut2 == null) {
																	%>--<%
																		} else {
																	%><%=PunchOut2%>
																	<%
																		}
																	%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>End Time</label></th>
																<td>:</td>
																<td colspan="4"><input type="hidden" id="endtime"
																	name="endtime" value="<%=coBean.getEnd_time()%>"><%=EndTime%>
																</td>

															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Total Hours Count</label></th>
																<td>:</td>
																<td colspan="4"><input type="hidden"
																	id="totalhours" value="<%=coBean.getTotal_Hours()%>"
																	name="totalhours"><%=coBean.getTotal_Hours()%>
																</td>

															</tr>
														</tbody>
														<%
															}
														%>
														<tbody>
															<tr>
																<td align="center" colspan="6">
																	<!-- /.modal-dialog --> <input type="hidden"
																	name="action" id="action" value=""> <%
 	if (request.getParameter("hrApproval") != null) {
 %>
																	<input type="hidden" name="hrApproval"
																	value="<%=request.getParameter("hrApproval")%>">
																	<%
																		}
																	%>
																	<button class="btn btn-primary" type="submit"
																		value="accept" onclick="reject(1)">Accept</button> <input
																	type="submit" class="btn btn-danger" id="reason"
																	type="submit" value="reject"
																	onclick="reject(2); return validateForm();">
																</button>



																</td>
															</tr>
															<tr>
																<td colspan="6">
																	<div class="form-group has-error">
																		<label class="control-label" for="remarks">Reject
																			Reason / Remarks</label> <input type="text"
																			class="form-control" id="remarks" name="remarks"
																			oninput="replica()">
																	</div>
																</td>
															</tr>
														</tbody>
														<input type="hidden" name="status" id="status" value="">

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