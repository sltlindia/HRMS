<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveCancelRequestBean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<%@include file="header.jsp"%>
<title>Leave Status</title>
<script type="text/javascript">
	function redirect(value) {
		/* alert("test"); */
		window.location.replace(value);
	}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int userId = user.getEmployee_master_id();
		//int employee_master_id = user.getEmployee_master_id();
		ArrayList<String> holiday = new ArrayList<String>();
		ArrayList<String> holidayName = new ArrayList<String>();
		ArrayList<String> holidayDate = new ArrayList<String>();
		System.out.print("Employee Master Id " + employee_master_id);
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
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h3>Leave / CO / OD Form</h3>
											</div>
											<div class="panel-body">
												<br>
												<div class="col-md-2">
													<b>Select Form:</b>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<select class="form-control" name="leavetypeselect"
															id="leavetypeselect" onchange="redirect(this.value);"
															required>
															<option value="applyLeave.jsp" selected="selected">
																Leave</option>
															<option value="leaveCO.jsp">CO</option>
															<option value="leaveOD.jsp">OD</option>
														</select>
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
				<%
				String under_manager_id = null;
				int dept_id = 0;	
				String marrital_status = null;
				String gender = null;
				if (request.getAttribute("HR") == null) {
					employee_master_id = user.getEmployee_master_id();
					under_manager_id = user.getUnder_manager_id();
					dept_id = user.getDepartmentBean().getDepartment_id();
					marrital_status = user.getMarital_status();
					gender = user.getGender();
				} else {
					employee_master_id = (Integer) request.getAttribute("emp_id");
					under_manager_id = (String) request.getAttribute("under_manger_id");
					dept_id = (Integer) request.getAttribute("dept_id");
					marrital_status = (String) request.getAttribute("marrital_status");
					gender = (String) request.getAttribute("gender");
				}

				%>
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
								<div class="row">
									<div class="col-lg-12">
										<table class="table table-bordered">
											<tbody>
												<tr bgcolor="#C6C3C2"">
													<th colspan="2" align="center">Type Of Leave</th>
													<th colspan="6" align="left">Leave Balance (Day's)</th>
													<!-- <th colspan="5" id="autoUpdateth">Adjust Of Leave</th> -->
												</tr>
											</tbody>
											<tbody>
												<%
													AllLMSListDAO gradeMasterList1 = new AllLMSListDAO();
													List<LeaveTypeBean> listOfleave1 = gradeMasterList1.getListOfLeave();
													LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) gradeMasterList1
															.getleaveListbyEMP(employee_master_id);

													double Co_Leave = leaveBalanceBean.getCO();

													double Plan_Leave = leaveBalanceBean.getPlan_Leave();
													double unplan_Leave = leaveBalanceBean.getUnplan_Leave();
													double lwp = leaveBalanceBean.getLeave_without_pay();
													double MT = 0;
													for (LeaveTypeBean c : listOfleave1) {
														String p = c.getLeave_name();
														if (marrital_status.equalsIgnoreCase("married") && gender.equalsIgnoreCase("female")) {
												%>
												<tr>

													<td colspan="2"><%=c.getLeave_name()%></td>
													<td colspan="6">
														<%
															if (p.equalsIgnoreCase("CO")) {
														%> <%=Co_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Plan Leave")) {
 %> <%=Plan_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Unplan Leave")) {
 %> <%=unplan_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Leave without pay")) {
 %> <%=lwp%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Maternity Leave")) {
 %> <%=MT%> <%
 	}
 %>
													</td>
													<%
														} else if (!c.getLeave_name().equalsIgnoreCase("Maternity Leave")) {
													%>

													<td colspan="2"><%=c.getLeave_name()%></td>
													<td colspan="6">
														<%
															if (p.equalsIgnoreCase("CO")) {
														%> <%=Co_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Plan Leave")) {
 %> <%=Plan_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Unplan Leave")) {
 %> <%=unplan_Leave%> <%
 	}
 %> <%
 	if (p.equalsIgnoreCase("Leave without pay")) {
 %> <%=lwp%> <%
 	}
 %>
													</td>
													<%
														}
													%>
												</tr>


												<%
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