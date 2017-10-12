<%@page import="com.hrms.lms.bean.LeaveAdjustBalanceBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>CUG List</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
<script type="text/javascript">
	window.onload = function() {
	}

	function onclick1() {
		$('#autoUpdate1').fadeIn('slow');
		$('#autoUpdate2').fadeIn('slow');
		$('#autoUpdate3').fadeIn('slow');
		$('#autoUpdate4').fadeIn('slow');
		$('#autoUpdate5').fadeIn('slow');
	}

	function hideMessage() {
		$('#panelbody').fadeOut('slow');
	}

	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
</script>
<script>
	function myFunction() {
		var empcode = document.getElementById("empcode").value;
		var companyId = document.getElementById("companyId").value;
		if (empcode == "") {
			alert("Please enter the Employee Code");
		} else {
			window.location.replace("LeaveHrAdd?empcode=" + empcode
					+ "&companyId=" + companyId);
			onclick1();
		}

	}
</script>
<title>Leave Adjust Form</title>
</head>
<%@include file="header.jsp"%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns" onload="startTimer()">
	<%
		//int v_id =  (Integer)session.getAttribute("v_id"); 
		String click = request.getParameter("Submit");
		LeaveBalanceBean leaveBalanceBean = new LeaveBalanceBean();
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
					<h3 class="page-header">Leave Adjust Form</h3>
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
								String currentdate = null;

								try {

									SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									Date result = formater.parse(date1);
									SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
									SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
									currentdate = AppDateFormat1.format(result);

									d = AppDateFormat.format(result);
									System.out.println(AppDateFormat.format(result));
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							%><%=d%></h4>

						</div>


						<div class="panel-body">
							<%
								if (request.getAttribute("empcode") != null) {
							%>
							<form action="LeaveupdateHR" method="post"
								enctype="multipart/form-data">
								<%
									}
								%>


								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">Employee Detail</div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">

												<div class="table-responsive">
													<table class="table table-stripped" border="0">
														<thead>
															<%
																if (request.getAttribute("empcode") != null) {
																	int comapny_code = (Integer) request.getAttribute("companyId");
															%>
															<tr>
																<td><label>Enter Employee Code</label></td>
																<td>:</td>
																<td><input type="text" class="form-control"
																	name="empcode" id="empcode" placeholder="Enter Code"
																	value="<%=request.getAttribute("empcode")%>" required />
																</td>
															</tr>

															<tr>
																<td><label>Select Name</label></td>
																<td>:</td>
																<td><select class="form-control" name="companyId"
																	placeholder="Select Company Name" id="companyId"
																	required="required">

																		<option value="">---Select Company Name---</option>
																		<%
																			CompanyListDAO companyListDAO = new CompanyListDAO();
																				List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																				for (CompanyListBean companyListBean : listOfCompanyList) {
																					if (comapny_code == companyListBean.getCompany_list_id()) {
																		%>
																		<option
																			value="<%=companyListBean.getCompany_list_id()%>"
																			selected="selected"><%=companyListBean.getCompany_name()%></option>

																		<%
																			} else {
																		%>
																		<option
																			value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																		<%
																			}
																		%>

																		<%
																			}
																		%>
																</select>
															</tr>
														</thead>
														<tr>
															<td><label>Employee Name :-</label></td>
															<td>:</td>
															<td><%=request.getAttribute("name")%></td>
														</tr>
														<%
															} else {
														%>
														<tr>
															<td><label>Enter Employee Code</label></td>
															<td>:</td>
															<td><input type="text" class="form-control"
																name="empcode" id="empcode" placeholder="Enter Code"
																required></td>
														</tr>

														<tr>
															<td><label>Select Company</label></td>
															<td>:</td>
															<td><select class="form-control" name="companyId"
																placeholder="Select Company Name" id="companyId"
																required="required">

																	<option value="">---Select Company Name---</option>
																	<%
																		CompanyListDAO companyListDAO = new CompanyListDAO();
																			List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																			for (CompanyListBean companyListBean : listOfCompanyList) {
																	%>
																	<option
																		value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																	<%
																		}
																	%>
															</select><br></td>
														</tr>
														<%
															}
														%>
														<tr>
															<td colspan="3" align="center">
																<button class="btn btn-success" id="btnsubmit"
																	type="button" value="Submit" onclick="myFunction()">Submit</button>
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>


								<%
									if (request.getAttribute("leaveBalanceBean") != null) {
								%>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">Addition Or Subtraction Of
											Leave</div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="table-responsive">
													<table class="table table-stripped" border="0">

														<tbody>
														<thead>

															<tr>

																<td id="autoUpdate1" colspan="3" align="Center"
																	style="font-weight: bold;">Type Of Leave</td>
																<td id="autoUpdate2" colspan="3" align="Center"
																	style="font-weight: bold;">Leave Balance (Day's)</td>
																<td id="autoUpdate3" colspan="3" align="Center"
																	style="font-weight: bold;">Addition Of Leave</td>
																<td id="autoUpdate3" colspan="3" align="Center"
																	style="font-weight: bold;">Subtraction Of Leave</td>
																<td id="autoUpdate3" colspan="3" align="Center"
																	style="font-weight: bold;">Reason</td>
															</tr>

														</thead>
														</tbody>

														<tbody>
															<%
																String name = null;
																	String updatedate = null;
																	String married = null;
																	String gender = null;
																	AllLMSListDAO allListDAO = new AllLMSListDAO();
																	List<LeaveTypeBean> listOfleave1 = allListDAO.getListOfLeave();
																	LeaveBalanceBean leaveBalanceBeans = (LeaveBalanceBean) request.getAttribute("leaveBalanceBean");

																	if (leaveBalanceBeans != null) {
																		name = leaveBalanceBeans.getLeave_update_name();
																		updatedate = leaveBalanceBeans.getLeave_update_date();
																		married = leaveBalanceBeans.getEmployeeBean().getMarital_status();
																		gender = leaveBalanceBeans.getEmployeeBean().getGender();
																		System.out.println(name + " " + updatedate);

																		// System.out.println(married + " " + gender);

																	}
																	for (LeaveTypeBean c : listOfleave1)

																	{

																		if (leaveBalanceBeans != null) {

																			{
															%>
															<input type="hidden" name="date" id="date"
																value="<%=currentdate%>">
															<input type="hidden" name="empmaster" id="empmaster"
																value="<%=leaveBalanceBeans.getEmployeeBean().getEmployee_master_id()%>">
															<input type="hidden" name="plan" id="plan"
																value="<%=leaveBalanceBeans.getPlan_Leave()%>">
															<input type="hidden" name="unplan" id="unplan"
																value="<%=leaveBalanceBeans.getUnplan_Leave()%>">
															<input type="hidden" name="CO" id="CO"
																value="<%=leaveBalanceBeans.getCO()%>">
															<input type="hidden" name="LWP" id="LWP"
																value="<%=leaveBalanceBeans.getLeave_without_pay()%>">
															<%-- <input type="text" value=" <%= leaveBalanceBeans.getLeave_update_date() %>"> --%>
															<%
																}
															%>
															<tr align="Center">

																<%
																	String p = c.getLeave_name();
																%>
																<%
																	if (married.equalsIgnoreCase("married") && gender.equalsIgnoreCase("female")) {
																%>
																<td colspan="3"><%=c.getLeave_name()%></td>
																<%
																	if (p.equalsIgnoreCase("Plan Leave")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getPlan_Leave()%><input
																	type="hidden" name="leaveName" value="Plan Leave"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("Unplan Leave")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getUnplan_Leave()%><input
																	type="hidden" name="leaveName" value="Unplan Leave"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("CO")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getCO()%><input
																	type="hidden" name="leaveName" value="CO"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("Leave without pay")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getLeave_without_pay()%><input
																	type="hidden" name="leaveName" value="LWP"></td>
																<%
																	}
																%>




																<td colspan="3"><input type="text"
																	class="form-control" name="addvalue" value="0"
																	align="Center" width="10px"></td>

																<td colspan="3"><input type="text"
																	class="form-control" name="subValue" value="0"
																	align="Center" width="10px"></td>

																<td colspan="3"><input type="text"
																	class="form-control" name="Reason" value=""
																	align="Center" placeholder="Enter Reason"></td>

																<%
																	} else {
																%>



																<%
																	if (c.getLeave_type_id() != 5) {
																						if (!c.getLeave_name().equalsIgnoreCase("Maternity Leave")) {
																%>
																<td colspan="3"><%=c.getLeave_name()%></td>
																<%
																	}
																%>

																<%
																	if (p.equalsIgnoreCase("Plan Leave")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getPlan_Leave()%><input
																	type="hidden" name="leaveName" value="Plan Leave"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("Unplan Leave")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getUnplan_Leave()%><input
																	type="hidden" name="leaveName" value="Unplan Leave"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("CO")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getCO()%><input
																	type="hidden" name="leaveName" value="CO"></td>
																<%
																	}
																%>
																<%
																	if (p.equalsIgnoreCase("Leave without pay")) {
																%>
																<td colspan="3"><%=leaveBalanceBeans.getLeave_without_pay()%><input
																	type="hidden" name="leaveName" value="LWP"></td>
																<%
																	}
																%>
																<td colspan="3"><input type="text"
																	class="form-control" name="addvalue" value="0" size="2"></td>

																<td colspan="3"><input type="text"
																	class="form-control" name="subValue" value="0"
																	align="Center" size="2"></td>

																<td colspan="3"><input type="text"
																	class="form-control" name="Reason" value=""
																	placeholder="Enter Reason"></td>
																<%
																	}
																				}
																%>
															</tr>

															<%
																}
																	}
															%>
														</tbody>
														<tbody>
															<tr>
																<input type="hidden" name="name"
																	value="<%=user.getFirstname() + " " + user.getLastname()%>">
																<input type="hidden" name="redirect">
																<td colspan="15">
																	<%
																		if ((name != null) && (updatedate != null)) {
																	%> <label>Last Update Name : - &nbsp;&nbsp; <%=name%>
																</label><br> <label>Last Update Date : -
																		&nbsp;&nbsp; <%=updatedate%>
																</label> <br> <%
 	} else {
 %> <%
 	}
 %>
																	<div id="autoUpdate4" align="center">
																		<button class="btn btn-success" id="btnsubmit"
																			type="submit" value="update">Update</button>
																	</div>
																</td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<td>
																<td>
															</tr>
														</tbody>
													</table>

												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
							<%
								}
							%>


							<div class="panel panel-default">
								<div class="panel-heading">
									<b>Last Leave Adjust Details</b>
								</div>
								<div class="panel-body">

									<div class="table-responsive">
										<table class="table table-bordered zero-configuration">
											<thead>
												<tr>
													<th><center>Name</center></th>
													<th colspan="3"><center>CO</center></th>
													<th colspan="3"><center>PL</center></th>
													<th colspan="3"><center>SL</center></th>
													<th colspan="3"><center>LWP</center></th>
													<th><center>Updated Date</center></th>
													<th><center>Updated Name</center></th>
												</tr>
											</thead>

											<thead>
												<tr>
													<th></th>
													<th><center>(+)</center></th>
													<th><center>(-)</center></th>
													<th><center>Reason</center></th>
													<th><center>(+)</center></th>
													<th><center>(-)</center></th>
													<th><center>Reason</center></th>
													<th><center>(+)</center></th>
													<th><center>(-)</center></th>
													<th><center>Reason</center></th>
													<th><center>(+)</center></th>
													<th><center>(-)</center></th>
													<th><center>Reason</center></th>
													<th></th>
													<th></th>
												</tr>
											</thead>

											<tbody>
												<%
													if (request.getAttribute("listOfAdjustHrBalance") != null) {
														List<LeaveAdjustBalanceBean> listOfLeaveAdjustHr = (ArrayList) request
																.getAttribute("listOfAdjustHrBalance");
														for (LeaveAdjustBalanceBean l : listOfLeaveAdjustHr) {
												%>
												<tr>
													<td><%=l.getEmployeeBean().getFirstname() + " " + l.getEmployeeBean().getLastname()%></td>
													<td><%=l.getAdd_CO()%></td>
													<td><%=l.getSub_CO()%></td>
													<td>
														<%
															if (l.getCO_Reason() == null || l.getCO_Reason().equals("")) {
														%>
														------ <%
															} else {
														%> <%=l.getCO_Reason()%> <%
 	}
 %>
													</td>
													<td><%=l.getAdd_PL()%></td>
													<td><%=l.getSub_PL()%></td>
													<td>
														<%
															if (l.getPlan_Reason() == null || l.getPlan_Reason().equals("")) {
														%>
														----- <%
															} else {
														%> <%=l.getPlan_Reason()%> <%
 	}
 %>
													</td>
													<td><%=l.getAdd_SL()%></td>
													<td><%=l.getSub_SL()%></td>
													<td>
														<%
															if (l.getUnplan_Reason() == null || l.getUnplan_Reason().equals("")) {
														%>
														---- <%
															} else {
														%> <%=l.getUnplan_Reason()%> <%
 	}
 %>
													</td>
													<td><%=l.getAdd_LWP()%></td>
													<td><%=l.getSub_LWP()%></td>
													<td>
														<%
															if (l.getLWP_Reason() == null || l.getLWP_Reason().equals("")) {
														%>
														----- <%
															} else {
														%> <%=l.getLWP_Reason()%> <%
 	}
 %>
													</td>
													<td><%=l.getLeave_update_date()%></td>
													<td><%=l.getLeave_update_name()%></td>
												</tr>
												<%
													}
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
</section>
</div>
</div>
</div>
</body>
<!-- Bootstrap Core JavaScript -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>


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
	
	
	  <!-- BEGIN PAGE VENDOR JS-->
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
    
      <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
</body>
</html>