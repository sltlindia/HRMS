<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="com.hrms.lms.util.DBConnection"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hrms.pms.bean.EmployeeStatusBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Leave Balance</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
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
	href="app-assets/vendors/css/extensions/sweetalert.css">
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
	href="app-assets/vendors/css/forms/selects/select2.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->

<%@include file="header.jsp"%>
</head>
<body>
	<%
		int role_id = user.getRoleBean().getRole_id();
		int manager_id = user.getManagerBean().getManager_id();
		String authority = user.getRoleBean().getRole_authority();

		Connection conn = null;
		Statement smt;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		AllLMSListDAO allListDAO = new AllLMSListDAO();

		Calendar now = Calendar.getInstance(); // Current Month, Year, Date

		int month_id = 0;
		if (request.getParameter("monthId") != null) {
			month_id = Integer.parseInt(request.getParameter("monthId"));
		} else {
			month_id = now.get(Calendar.MONTH) + 1;
		}

		int year = 0;
		if (request.getParameter("year") != null) {
			year = Integer.parseInt(request.getParameter("year"));
		} else {
			year = now.get(Calendar.YEAR);
		}

		String fromDate = null;
		String toDate = null;

		if (month_id == 1 || month_id == 3 || month_id == 5 || month_id == 7 || month_id == 8) {
			fromDate = year + "-0" + month_id + "-01";
			toDate = year + "-0" + month_id + "-31";
		} else if (month_id == 4 || month_id == 6 || month_id == 9) {
			fromDate = year + "-0" + month_id + "-01";
			toDate = year + "-0" + month_id + "-30";
		} else if (month_id == 10 || month_id == 12) {
			fromDate = year + "-" + month_id + "-01";
			toDate = year + "-" + month_id + "-31";
		}
		if (month_id == 11) {
			fromDate = year + "-" + month_id + "-01";
			toDate = year + "-" + month_id + "-30";
		}
		if (month_id == 2) {
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
				fromDate = year + "-0" + month_id + "-01";
				toDate = year + "-0" + month_id + "-29";
			} else {
				fromDate = year + "-0" + month_id + "-01";
				toDate = year + "-0" + month_id + "-28";
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
										<h1 class="page-header">Employee Leave/CO/OD List</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>
								<br>
								<%
									if (request.getAttribute("success") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-success">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${success}
									</div>
								</div>
								<%
									}
								%>
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-body">
												<form action="leaveBalanceEmployeeReport.jsp">
													<div class="row">
														<div class="col-md-2">
															<b>Select Month</b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>

														<div class="col-md-8">
															<select class="form-control" name="monthId"
																placeholder="Select Month Name" id="monthId">

																<option value="0">---Select Month Name---</option>
																<%
																	List<MonthBean> listOfMonth = allListDAO.getListOfMonth();
																	for (MonthBean monthBean : listOfMonth) {
																%>

																<option value="<%=monthBean.getMonth_id()%>"><%=monthBean.getMonth_name()%></option>

																<%
																	}
																%>
															</select>
														</div>
													</div>
													<br>
													<div class="row">
														<div class="col-md-2">
															<b>Select Year</b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>

														<div class="col-md-8">
															<select class="form-control" name="year" id="year"
																required="required">
																<option value="">---Select Year---</option>
																<%
																	List<YearBean> listOfYear = allListDAO.getListOfYear();
																	for (YearBean y : listOfYear) {
																%>
																<option value="<%=y.getYear()%>"><%=y.getYear()%></option>
																<%
																	}
																%>
															</select>
														</div>
													</div>


													<br>
													<div align="center">
														<input type="submit" class="btn btn-primary" name="submit"
															value="SUBMIT">
													</div>
												</form>
												<hr>
												<!-- /.panel-heading -->
												<div class="panel-body">
													<div class="dataTable_wrapper">
														<div class="">
															<table
																class="table table-striped table-bordered file-export"
																id="datatable-buttons">
																<thead>
																	<tr>
																		<th>No</th>
																		<th>Company Code</th>
																		<th>Emp_code</th>
																		<th>Name</th>
																		<th>Leave</th>
																		<th>CO</th>
																		<!-- <th>Balance PL</th>
                                        	<th>Balance SL</th>
                                        	<th>Balance CO</th>
                                        	<th>LWP</th>   -->
																	</tr>
																</thead>
																<tbody>
																	<%
																		List<EmployeeBean> getemployeeList = allListDAO.getFullListOfEmployee();
																		String apdate = null, start_date = null, end_date = null;

																		int empcode = 0;
																		String company_code = null;
																		for (int i = 0; i < getemployeeList.size(); i++) {
																			EmployeeBean e = getemployeeList.get(i);

																			int emp_id = e.getEmployee_master_id();

																			double leaveCount = 0;
																			double COCount = 0;

																			List<LeaveBean> listOfLeave = allListDAO.getLeaveByEmpId2(emp_id, fromDate, toDate);
																			for (LeaveBean l : listOfLeave) {
																				if (l.getStatus().equalsIgnoreCase("Approved")) {

																					leaveCount = leaveCount + l.getDay_count();
																				}
																			}

																			List<LeaveCOBean> listOfCO = allListDAO.getCOByEmpId1(emp_id, fromDate, toDate);
																			for (LeaveCOBean lc : listOfCO) {
																				if (lc.getStatus().equalsIgnoreCase("Approved")) {

																					String date = lc.getCO_date();

																					double co = 0;

																					if (lc.getTotal_Hours() >= 4) {
																						co = 1.0;
																					} else if (lc.getTotal_Hours() >= 2 && lc.getTotal_Hours() <= 4) {
																						co = 0.5;
																					} else if (lc.getTotal_Hours() <= 2) {
																						co = 0.0;
																					}

																					COCount = COCount + co;
																				}
																			}

																			LeaveBalanceBean leaveBalanceBean = allListDAO.getleaveListbyEMP(emp_id);

																			double pl = 0;
																			double sl = 0;
																			double CO = 0;
																			double lwp = 0;

																			if (leaveBalanceBean != null) {
																				pl = leaveBalanceBean.getPlan_Leave();
																				sl = leaveBalanceBean.getUnplan_Leave();
																				CO = leaveBalanceBean.getCO();
																				lwp = leaveBalanceBean.getLeave_without_pay();
																			}
																	%>
																	<tr align="Center">
																		<td><%=i + 1%></td>
																		<td><%=e.getCompanyListBean().getCompany_code()%></td>
																		<td><%=e.getEmployee_code()%></td>
																		<td><%=e.getFirstname() + " " + e.getLastname()%></td>
																		<td><%=leaveCount%></td>
																		<td><%=COCount%></td>
																		<%--  <td><%=pl%></td>
                                        <td><%=sl%></td>
                                         <td><%=CO%></td>
                                          <td><%=lwp%></td> --%>
																	</tr>
																	<%
																		}
																	%>
																</tbody>

																<tbody>
															</table>
														</div>
													</div>
													<!-- /.table-responsive -->
													<!-- /.panel -->
												</div>
												<!-- /.col-lg-12 -->
											</div>
											<!-- /.row -->
										</div>
										<!-- /#page-wrapper -->
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

	<script src="app-assets/vendors/js/tables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->


	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/tables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.flash.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/jszip.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/pdfmake.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/vfs_fonts.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.html5.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.print.min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->

	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/forms/select/form-select2.min.js"
		type="text/javascript"></script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
	</script>
</body>
</html>