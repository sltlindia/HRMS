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
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/forms/selects/select2.min.css">
<!-- END Custom CSS-->
<%
	String fromDate = "2017-08-01";
	String toDate = "2017-08-31";
%>
<title>Test Data(<%=fromDate%> to <%=toDate%>)
</title>
<!-- <link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" /> -->

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
		int dept_id = 0;
		if (request.getParameter("dept_id") != null) {
			dept_id = Integer.parseInt(request.getParameter("dept_id"));
		} else {
			dept_id = 1;
		}

		String status = "approved";
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
											<div class="panel-heading">Employee Leave List</div>

											<div class="panel-body">
												<!-- /.panel-heading -->
												<div class="panel-body">
													<div class="dataTable_wrapper">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered zero-configuration">
																<thead>
																	<tr>
																		<th></th>
																		<th>LeaveType</th>
																		<th>Emp Id</th>
																		<th></th>
																		<th>Company Code</th>
																		<th>AMS Name</th>
																		<th>Emp Code</th>
																		<th>HRMS Name</th>
																		<th>Location</th>
																		<th>From_Date</th>
																		<th>To_Date</th>
																		<th></th>
																		<th>Approval_Date</th>
																		<th>Approval_By</th>
																		<th></th>
																		<th></th>
																		<th></th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>


																	<%
																		String leave = "leave";
																		if (leave.equalsIgnoreCase("leave")) {

																			List<LeaveBean> getemployeeList = null;
																			getemployeeList = allListDAO.getAllPlanLeaveForExcel(fromDate, toDate, status);
																			String apdate = null, start_date = null, end_date = null;

																			int empcode = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList.size(); i++) {

																				System.out.println("leave");

																				LeaveBean e = getemployeeList.get(i);
																				empcode = e.getEmployeeBean().getEmployee_code();
																				start_date = e.getLeave_From();
																				end_date = e.getLeave_To();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
																				apdate = e.getApproval_rejected_date();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																				SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");

																				Date result1 = formater1.parse(apdate);
																				Date result2 = formater3.parse(start_date);
																				Date result3 = formater3.parse(end_date);

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");

																				apdate = formater2.format(result1);
																				start_date = formater2.format(result2);
																				end_date = formater2.format(result3);
																				int em = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = " + empcode
																							+ " and  Code = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}
																					if (em != 0) {
																	%>
																	<tr align="Center">
																		<td></td>
																		<td>1</td>
																		<td><%=em%></td>
																		<td>Null</td>

																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>

																		<td><%=start_date%></td>
																		<td><%=end_date%></td>
																		<td></td>
																		<td><%=apdate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td><%=e.getFrom_half()%></td>
																		<td><%=e.getTo_half()%></td>
																		<td><%=e.getDay_count()%></td>
																	</tr>
																	<%
																		}
																				}
																			}
																		}
																	%>



																	<%
																		if (leave.equalsIgnoreCase("leave")) {
																			List<LeaveBean> getemployeeList = null;
																			getemployeeList = allListDAO.getAllUnPlanLeaveForExcel(fromDate, toDate, status);
																			String apdate = null, start_date = null, end_date = null;

																			int empcode = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList.size(); i++) {

																				System.out.println("unleave");

																				LeaveBean e = getemployeeList.get(i);
																				empcode = e.getEmployeeBean().getEmployee_code();
																				start_date = e.getLeave_From();
																				end_date = e.getLeave_To();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
																				apdate = e.getApproval_rejected_date();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																				SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");

																				Date result1 = formater1.parse(apdate);
																				Date result2 = formater3.parse(start_date);
																				Date result3 = formater3.parse(end_date);

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");

																				apdate = formater2.format(result1);
																				start_date = formater2.format(result2);
																				end_date = formater2.format(result3);
																				int em = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = " + empcode
																							+ " and  Code = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}
																					if (em != 0) {
																	%>
																	<tr align="Center">
																		<td></td>
																		<td>2</td>
																		<td><%=em%></td>
																		<td>Null</td>
																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>
																		<td><%=start_date%></td>
																		<td><%=end_date%></td>
																		<td></td>
																		<td><%=apdate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td><%=e.getFrom_half()%></td>
																		<td><%=e.getTo_half()%></td>
																		<td><%=e.getDay_count()%></td>
																	</tr>
																	<%
																		}
																				}
																			}
																		}
																	%>



																	<%
																		if (leave.equalsIgnoreCase("leave")) {
																			List<LeaveBean> getemployeeList = null;
																			getemployeeList = allListDAO.getAllHalfLeaveForExcel(fromDate, toDate, status);
																			String apdate = null, start_date = null, end_date = null;

																			int empcode = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList.size(); i++) {

																				System.out.println("halfleave");

																				LeaveBean e = getemployeeList.get(i);
																				empcode = e.getEmployeeBean().getEmployee_code();
																				start_date = e.getLeave_From();
																				end_date = e.getLeave_To();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
																				apdate = e.getApproval_rejected_date();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																				SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");

																				Date result1 = formater1.parse(apdate);
																				Date result2 = formater3.parse(start_date);
																				Date result3 = formater3.parse(end_date);

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");

																				apdate = formater2.format(result1);
																				start_date = formater2.format(result2);
																				end_date = formater2.format(result3);
																				int em = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = " + empcode
																							+ " and  Code = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}
																					if (em != 0) {
																	%>
																	<tr align="Center">
																		<td></td>
																		<td>6</td>
																		<td><%=em%></td>
																		<td>Null</td>


																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%>
																			(<%=e.getFrom_half()%>) (<%=e.getTo_half()%>) (<%=e.getDay_count()%>)</td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>

																		<td><%=start_date%></td>
																		<td><%=end_date%></td>
																		<td></td>
																		<td><%=apdate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td><%=e.getFrom_half()%></td>
																		<td><%=e.getTo_half()%></td>
																		<td><%=e.getDay_count()%></td>
																	</tr>
																	<%
																		}
																				}
																			}
																		}
																	%>



																	<%
																		if (leave.equalsIgnoreCase("leave")) {
																			String Co_StartDate = null;
																			List<LeaveCOBean> getemployeeList1 = null;
																			getemployeeList1 = allListDAO.getAllFullCOForExcel(fromDate, toDate, status);

																			int empcode1 = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList1.size(); i++) {

																				System.out.println("fulllco");

																				LeaveCOBean e = getemployeeList1.get(i);
																				Co_StartDate = e.getCO_date();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																				Date result1 = formater1.parse(Co_StartDate);

																				empcode1 = e.getEmployeeBean().getEmployee_code();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
																				Co_StartDate = formater2.format(result1);

																				int em1 = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = " + empcode1
																							+ " and  CODE = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em1 = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}

																					if (em1 != 0) {
																	%>

																	<tr align="Center">
																		<td></td>
																		<td>3</td>
																		<td><%=em1%></td>
																		<td>Null</td>

																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>



																		<td><%=Co_StartDate%></td>
																		<td><%=Co_StartDate%></td>
																		<td></td>
																		<td><%=Co_StartDate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td></td>
																		<td></td>
																		<td></td>
																	</tr>



																	<%
																		}
																				}
																			}
																		}
																	%>



																	<%
																		if (leave.equalsIgnoreCase("leave")) {
																			String Co_StartDate = null;
																			List<LeaveCOBean> getemployeeList1 = null;
																			getemployeeList1 = allListDAO.getAllHalfCOForExcel(fromDate, toDate, status);

																			int empcode1 = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList1.size(); i++) {

																				System.out.println("half co");

																				LeaveCOBean e = getemployeeList1.get(i);
																				Co_StartDate = e.getCO_date();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																				Date result1 = formater1.parse(Co_StartDate);

																				empcode1 = e.getEmployeeBean().getEmployee_code();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
																				Co_StartDate = formater2.format(result1);

																				int em1 = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = " + empcode1
																							+ " and  CODE = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em1 = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}

																					if (em1 != 0) {
																	%>

																	<tr align="Center">
																		<td></td>
																		<td>7</td>
																		<td><%=em1%></td>
																		<td>Null</td>

																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>

																		<td><%=Co_StartDate%></td>
																		<td><%=Co_StartDate%></td>
																		<td></td>
																		<td><%=Co_StartDate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td></td>
																		<td></td>
																		<td></td>
																	</tr>
																	<%
																		}
																				}
																			}
																		}
																	%>



																	<%
																		if (leave.equalsIgnoreCase("leave")) {
																			String OD_StartDate = null, OD_EndDate = null;
																			List<LeaveODBean> getemployeeList2 = null;
																			getemployeeList2 = allListDAO.getAllODForExcel(fromDate, toDate, status);
																			int empcode2 = 0;
																			String company_code = null;
																			for (int i = 0; i < getemployeeList2.size(); i++) {

																				System.out.println("OD");

																				LeaveODBean e = getemployeeList2.get(i);
																				OD_StartDate = e.getOD_StartDate();
																				OD_EndDate = e.getOD_EndDate();
																				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																				Date result1 = formater1.parse(OD_StartDate);
																				Date result2 = formater1.parse(OD_EndDate);

																				//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
																				OD_StartDate = formater2.format(result1);
																				OD_EndDate = formater2.format(result2);

																				empcode2 = e.getEmployeeBean().getEmployee_code();
																				company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
																				int em2 = 0;
																				String name = null;
																				if (conn != null) {
																					smt = conn.createStatement();

																					smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = " + empcode2
																							+ " and  CODE = '" + company_code + "'");
																					rs = smt.getResultSet();
																					while (rs.next()) {
																						System.out.println("Emp Master Id " + rs.getString(1));
																						em2 = Integer.parseInt(rs.getString(1));
																						name = rs.getString(9);
																					}

																					if (em2 != 0) {
																	%>

																	<tr align="Center">
																		<td></td>
																		<td>4</td>
																		<td><%=em2%></td>
																		<td>Null</td>


																		<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=name%></td>
																		<td><%=e.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=e.getEmployeeBean().getFirstname() + " " + e.getEmployeeBean().getMiddlename()
									+ " " + e.getEmployeeBean().getLastname()%></td>
																		<td><%=e.getEmployeeBean().getLocation()%></td>



																		<td><%=OD_StartDate%></td>
																		<td><%=OD_EndDate%></td>
																		<td></td>
																		<td><%=OD_StartDate%></td>
																		<td>1041</td>
																		<td>Null</td>
																		<td></td>
																		<td></td>
																		<td></td>
																	</tr>
																	<%
																		}
																				}
																			}
																		}
																	%>

																</tbody>



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
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js"
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

</body>
</html>