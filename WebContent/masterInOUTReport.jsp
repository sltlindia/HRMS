<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.lms.bean.GatePassBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
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
<%@include file="header.jsp"%>
<style type="text/css">
.txt {
	text-align: center;
	line-height: 5vh;
}
</style>
<script type="text/javascript">
	function redirect(value) {

		var depts_id = value;

		window.location.replace("masterInOUTReport.jsp?depts_id=" + depts_id);

	}
</script>




<!-- <link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet"
	type="text/css" /> -->

<title>HD AND SL COUNT</title>

</head>
<%
	int EMPCODE = 0;
	String SELECTCOMPANYCODE = null;
	String LEAVETYPE = null;
	AllListDAO allListDAO = new AllListDAO();
	int depts_id = 0;
	if (request.getParameter("depts_id") != null) {
		depts_id = Integer.parseInt(request.getParameter("depts_id"));
	}

	if (request.getParameter("empcode") != null && request.getParameter("companyId") != null
			&& request.getParameter("leavetypeselect") != null) {
		EMPCODE = Integer.parseInt(request.getParameter("empcode"));
		SELECTCOMPANYCODE = request.getParameter("companyId");
		LEAVETYPE = request.getParameter("leavetypeselect");
	}
%>
<body>
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
										<h1 class="page-header">Employee Attendance Status</h1>
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
											<form action="masterInOUTReport.jsp">
												<div id="collapseOne" class="panel-collapse collapse in">
													<div class="panel-body">

														<div class="table-responsive">
															<table class="table table-stripped" border="0">
																<thead>

																	<%
																		if (request.getAttribute("empcode") != null) {
																			int comapny_code = Integer.parseInt(request.getParameter("companyId"));
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
																		<td><label>Select Company Name</label></td>
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


																	<tr>
																		<td><label>Select </label></td>
																		<td>:</td>
																		<td><select class="form-control"
																			name="leavetypeselect" id="leavetypeselect" required>
																				<option value="">-- Select Leave Type --</option>
																				<option value="Leave">Leave</option>
																				<option value="HL">HL</option>
																				<option value="SL">SL</option>
																		</select></td>
																	</tr>
																	<tr>

																		<th>Select Department</th>
																		<td>:</td>
																		<td><select class="form-control" name="dept_id"
																			onchange="redirect(this.value);">
																				<option value="">---Select Department---</option>
																				<option value="0">All Department</option>
																				<%
																					List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment();
																						for (DepartmentBean d : listOfDepartment) {
																							if (d.getDepartment_id() != 0) {
																								if (d.getDepartment_id() == depts_id) {
																				%>
																				<option value="<%=d.getDepartment_id()%>"
																					selected="selected"><%=d.getDepartment_name()%></option>
																				<%
																					} else {
																				%>
																				<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
																				<%
																					}
																				%>
																				<%
																					}
																						}
																				%>
																		</select>
																	</tr>



																</thead>

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
																	<td><label>Select Company Name</label></td>
																	<td>:</td>
																	<td><select class="form-control" name="companyId"
																		placeholder="Select Company Name" id="companyId"
																		required>

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
																	</select></td>
																</tr>


																<tr>
																	<td><label>Select </label></td>
																	<td>:</td>
																	<td><select class="form-control"
																		name="leavetypeselect" id="leavetypeselect" required>
																			<option value="">-- Select Leave Type --</option>
																			<option value="Leave">Leave</option>
																			<option value="HL">HL</option>
																			<option value="SL">SL</option>

																	</select></td>
																</tr>



																<%
																	}
																%>









																<tr>
																	<td colspan="3" align="center">
																		<button class="btn btn-success" id="btnsubmit"
																			type="submit" value="Submit">Submit</button>
																	</td>
																</tr>


																<tr>
																	<th>Select Department</th>
																	<td>:</td>
																	<td><select class="form-control" name="dept_id"
																		onchange="redirect(this.value);">
																			<option value="0">---Select Department---</option>
																			<option value="0">All Department</option>
																			<%
																				List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment();
																				for (DepartmentBean d : listOfDepartment) {
																					if (d.getDepartment_id() != 0) {
																						if (d.getDepartment_id() == depts_id) {
																			%>
																			<option value="<%=d.getDepartment_id()%>"
																				selected="selected"><%=d.getDepartment_name()%></option>
																			<%
																				} else {
																			%>
																			<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
																			<%
																				}
																			%>
																			<%
																				}
																				}
																			%>
																	</select> <%
 	List<EmployeeBean> listOfEmployee = null;
 	if (depts_id == 0) {
 		if (EMPCODE != 0) {
 			listOfEmployee = allListDAO.getListOfAllEmployeeByCompanyCodeOrEmpCode(SELECTCOMPANYCODE, EMPCODE);
 		} else {
 			listOfEmployee = allListDAO.getListOfAllEmployeeAllocation();
 		}

 	} else {
 		listOfEmployee = allListDAO.getListOfEmployeeAllocationByDepartment(depts_id);
 	}
 %>
																</tr>












															</table>
														</div>
													</div>
												</div>
										</div>
									</div>

									</form>

									<br>
									<br>
									<div class="row">
										<div class="col-lg-12">
											<div class="panel panel-primary">
												<div class="panel-body">
													<!-- /.panel-heading -->
													<div class="panel-body">
														<div class="dataTable_wrapper">
															<div class="table-responsive">
																<table class="table table-striped table-bordered"
																	id="datatable-buttons1">
																	<thead>
																		<tr>
																			<!--     <th>Vacancy Id</th> -->
																			<th>Date</th>
																			<th>Employee Code</th>
																			<th>Name</th>
																			<th>Department</th>
																			<th>Punch In 1</th>
																			<th>Punch Out 1</th>
																			<th>Punch In 2</th>
																			<th>Punch Out 2</th>
																			<th>Total Hours</th>
																			<th>Work Hours</th>
																			<th>Leave</th>
																			<th>HD</th>
																			<th>SL</th>
																			<th>Gate Pass</th>
																			<th>OD</th>
																			<!-- <th style="text-align:center"> Sunday </th> -->
																			<!-- <th style="text-align:center"> SL </th>
													<th style="text-align:center"> HD </th>
													<th style="text-align:center">Gate Pass</th>
													<th style="text-align:center">Status</th>  -->

																		</tr>
																	</thead>
																	<tbody>

																		<%
																			
																		%>



																		<%
																			if ((request.getParameter("empcode") != null && request.getParameter("companyId") != null
																					&& request.getParameter("leavetypeselect") != null) || request.getParameter("depts_id") != null) {

																				LoginDAO loginDAO = new LoginDAO();
																				AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																				List<EmployeeBean> getemployeeList = null;
																				getemployeeList = loginDAO.getListOfEmployee();

																				int temp = 0, temp1 = 0, sumid = 0, qwert = 0;
																				Connection conn = null;
																				Statement smt;
																				ResultSet rs = null;
																				conn = DBConnection.getConnection();
																				smt = conn.createStatement();

																				int year = 0;
																				year = Calendar.getInstance().get(Calendar.YEAR);
																				int month_id = 02, emp_code = 0;

																				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
																				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy 12:00:00 aa");
																				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
																				SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
																				SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																				SimpleDateFormat AppDateFormat12 = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
																				String incDate = null, company_code = null, COMPANYCODE = null, NAME = null, DEPARTMENT = null;
																				int EMP_MASTER_ID = 0;
																				//String PunchIn1 = null, PunchIn2 = null, PunchOut1 = null, PunchOut2 = null; 

																				String unplanstartDate = "06/01/2017";

																				temp = temp + 1;

																				for (EmployeeBean e : listOfEmployee) {
																					EMP_MASTER_ID = e.getEmployee_master_id();
																					int rowCount = 0;

																					emp_code = e.getEmployee_code();
																					/* EMP_MASTER_ID = e.getEmployee_master_id(); */
																					company_code = e.getCompanyListBean().getCompany_code();
																					String date = unplanstartDate;
																					Calendar c = Calendar.getInstance();
																					c.setTime(sdf.parse(date));
																					int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

																					smt.executeQuery(
																							"SELECT * FROM FingerTec_TimeTrack.dbo.Emp_Master e , FingerTec_TimeTrack.dbo.Department_Master d  WHERE EMP_CODE = "
																									+ emp_code + " AND Code = '" + company_code + "' AND e.Dept_Id = d.Dept_Id");
																					rs = smt.getResultSet();

																					if (rs.next()) {
																						COMPANYCODE = rs.getString(1);
																						NAME = rs.getString(9);
																						DEPARTMENT = rs.getString(22);
																					} else {
																						COMPANYCODE = "";
																						NAME = "";
																						DEPARTMENT = "";
																					}

																					System.out.println("CODE  " + COMPANYCODE + " NAME  " + NAME + "    DEPARTMENT    " + DEPARTMENT);
																		%>



																		<%
																			for (int co = 0; co < maxDay; co++) {
																						String PunchDate = null, PDate = null, Start = null, Stop = null, dateStart1 = null,
																								dateStart2 = null, date3 = null, date4 = null;
																						double StartIntime = 0, EndOuttime = 0, BioIntime = 9.10, BioOutTime = 5.30, EG = 6.00,
																								Totalhours = 0;
																						long diffSeconds = 0;
																						long diffMinutes = 0;
																						long diffHours = 0;
																						long diffDays = 0;
																						int count = 0;
																						int runCount = 0;
																						double finalWorkHour = 0;
																						float qwrty = 0.0f;
																						String mainhours = null;
																						String mainminuts = null;
																						String Totalcount = null, Status = "Absent", abc = null;
																						String PunchIn1 = null, PunchIn2 = null, PunchOut1 = null, PunchOut2 = null;
																						String tempIntime = null, MININTIME = "", MAXOUTTIME = "";
																						boolean sundayflag = false;
																						long lowhours = 0;
																						double total = 0;
																						String datePunchOut1 = null;
																						String datePunchIn2 = null;
																						String in = "";
																						String out1 = "";
																						String w = "";
																						String w1 = "-";
																						String gatePass = "";
																						String security_out_time = null;
																						String Sunday = "";
																						String LeaveType = "";
																						double total1 = 0;
																						String OD = "";
																						int sumOfMainHours = 0;
																						int sumOfMainMinutes = 0;
																						long finalMinutes = 0;
																						long actualMintes = 0;
																						long lunchMinute = 0;

																						List<String> listOfAllPunch = new ArrayList<String>();

																						//System.out.println(" Incriment Date" + incDate);
																						incDate = sdf.format(c.getTime());
																						Date result4 = sdf.parse(incDate);
																						incDate = format1.format(result4);

																						//System.out.println(" Incriment Date  " + incDate);
																						PunchDate = format1.format(result4);

																						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.In_Out_Detail where EMP_CODE = "
																								+ emp_code + " AND Date = '" + incDate + "' AND Code='" + company_code + "'");
																						rs = smt.getResultSet();
																						c.add(Calendar.DATE, 1);

																						if (result4.getDay() == 0) {
																							System.out.println("SUNDAY" + incDate);

																							Sunday = "SUNDAY";
																							sundayflag = true;
																						}

																						while (rs.next()) {
																							runCount++;
																							String Intime = null, outtime = null;

																							PDate = rs.getString(11);
																							Date result1 = formater2.parse(PDate);
																							SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
																							if (PDate == null) {
																								System.out.println("Absent");
																							}

																							if (rs.getString(9) != null) {
																								listOfAllPunch.add(rs.getString(9));
																							}
																							if (rs.getString(10) != null) {
																								listOfAllPunch.add(rs.getString(10));
																							}

																							// InTime Formate
																							Start = rs.getString(9);
																							if (Start != null) {

																								Date result2 = formater2.parse(Start);

																								Intime = time.format(result2);
																								if (MININTIME.equals("")) {
																									MININTIME = Intime;
																								}

																								if (tempIntime == null) {
																									tempIntime = dateStart1;
																								}

																								if (PunchIn1 == null) {
																									PunchIn1 = Intime;
																									dateStart1 = format.format(result2);
																								} else if (PunchIn2 == null) {
																									PunchIn2 = Intime;
																									datePunchIn2 = Start;
																									dateStart1 = format.format(result2);

																								} else {

																									PunchOut2 = Intime;
																									dateStart2 = format.format(result2);
																									outtime = Intime;
																									Intime = PunchIn2;
																									dateStart2 = format.format(result2);

																								}

																								String[] split = Intime.split(":");

																								String splitIntimeValue = split[0] + "." + split[1];
																								if (StartIntime == 0) {
																									StartIntime = Double.parseDouble(splitIntimeValue);
																								}

																							} else {
																								//Intime = null;
																								Totalcount = "0.0";
																							}

																							// OutTime Formate
																							Stop = rs.getString(10);
																							//System.out.println("START "+ Start + " END "+ Stop);
																							if (Stop != null) {
																								Date result3 = formater2.parse(Stop);
																								dateStart2 = format.format(result3);
																								outtime = time.format(result3);
																								MAXOUTTIME = outtime;
																								if (PunchOut1 == null) {
																									PunchOut1 = outtime;
																									datePunchOut1 = Stop;
																									MAXOUTTIME = outtime;

																								} else if (PunchOut2 == null) {
																									PunchOut2 = outtime;
																									MAXOUTTIME = outtime;

																								} else {
																									PunchOut2 = outtime;
																								}

																								String[] split = outtime.split(":");
																								String splitOuttimeValue = split[0] + "." + split[1];

																								EndOuttime = Double.parseDouble(splitOuttimeValue);

																							} else {
																								//outtime = null;
																								Totalcount = "0.0";
																							}

																						}

																						SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
																						if (listOfAllPunch.size() != 0) {

																							Date myLastDate = null;
																							Date myFirstDate = null;
																							if (listOfAllPunch.size() != 1) {
																								if (listOfAllPunch.get(0) != null
																										&& listOfAllPunch.get(listOfAllPunch.size() - 1) != null) {
																									myFirstDate = formater2.parse(listOfAllPunch.get(0));
																									myLastDate = formater2.parse(listOfAllPunch.get(listOfAllPunch.size() - 1));

																									try {

																										//in milliseconds
																										long diff = myLastDate.getTime() - myFirstDate.getTime();
																										diffSeconds = diff / 1000 % 60;
																										diffMinutes = diff / (60 * 1000) % 60;
																										diffHours = diff / (60 * 60 * 1000) % 24;

																										long minutes = diffHours * 60;
																										finalMinutes = minutes + diffMinutes;
																										actualMintes = finalMinutes;

																									} catch (Exception ex) {
																										ex.printStackTrace();
																									}

																								}

																								if (listOfAllPunch.size() < 4) {

																									Date endTime = timeFormat.parse(timeFormat.format(myLastDate));
																									Date startTime = timeFormat.parse(timeFormat.format(myFirstDate));

																									Date eligibleTime = timeFormat.parse("14:00:00");

																									if (endTime.before(eligibleTime)) {
																										System.err.println("endtime criteria");
																									} else if (startTime.after(eligibleTime)) {
																										System.err.println("starttime criteria");
																									} else if (finalMinutes <= 354) {
																										System.err.println("hd criteria");
																									} else {
																										finalMinutes = finalMinutes - 60;
																										lunchMinute = 60;
																									}

																								} else if (listOfAllPunch.size() > 3) {
																									if (listOfAllPunch.get(1) != null && listOfAllPunch.get(2) != null) {
																										myFirstDate = formater2.parse(listOfAllPunch.get(1));
																										myLastDate = formater2.parse(listOfAllPunch.get(2));

																										try {

																											//in milliseconds
																											long diff = myLastDate.getTime() - myFirstDate.getTime();
																											diffSeconds = diff / 1000 % 60;
																											diffMinutes = diff / (60 * 1000) % 60;
																											diffHours = diff / (60 * 60 * 1000) % 24;

																											long minutes = diffHours * 60;
																											lunchMinute = minutes + diffMinutes;

																										} catch (Exception ex) {
																											ex.printStackTrace();
																										}

																										finalMinutes = finalMinutes - lunchMinute;

																									}
																								}

																							} else {

																								Status = "Miss Punch";

																							}

																						} else {
																							Status = "Leave";
																						}

																						String GatePassDate = null;

																						GatePassDate = AppDateFormat12.format(result4);

																						System.out.println("Akash " + GatePassDate + "EMP MASTER ID " + EMP_MASTER_ID);

																						List<GatePassBean> listOfgatepass = allLMSListDAO.getGatePassListPerMonth(GatePassDate,
																								EMP_MASTER_ID);
																						for (GatePassBean gatePassBean : listOfgatepass) {
																							int id = gatePassBean.getGate_pass_id();
																							System.out.println("ID " + id);
																							gatePass = "YES " + gatePassBean.getPurpose_of_leave();
																							security_out_time = gatePassBean.getSecurity_out_time();

																						}

																						List<LeaveODBean> listOfOD = allLMSListDAO.getODForHDSL(GatePassDate, GatePassDate,
																								EMP_MASTER_ID);
																						for (LeaveODBean leaveODBean : listOfOD) {

																							OD = "YES";
																							System.out.println("OD Exist");

																						}

																						//System.out.println("Total Employee " + temp);
																		%>
																		<%
																			if (finalMinutes < 445 && (finalMinutes != 0) && (sundayflag == false)) {
																							rowCount++;
																		%>
																		<%
																			if (rowCount == 1) {
																		%>

																		<%-- <tbody>
                                    	<tr align="Center">
                                    	<th style="text-align:center; width: 50px;" colspan="10">
                                 				<div class="txt">
                                 				<%= COMPANYCODE + " " + NAME + " " + DEPARTMENT %>
                                 				</div>
                                 				</th>
	    								</tr>
	    						</tbody> --%>
																		<%
																			}
																		%>


																		<tr>
																			<td><%=PunchDate%></td>
																			<td><%=COMPANYCODE%></td>
																			<td><%=NAME%></td>
																			<td><%=DEPARTMENT%></td>
																			<td>
																				<%
																					if (PunchIn1 == null) {
																				%>--<%
																					} else {
																				%><%=PunchIn1%> <%
 	}
 %>
																			</td>
																			<td>
																				<%
																					if (PunchOut1 == null) {
																				%>--<%
																					} else {
																				%><%=PunchOut1%> <%
 	}
 %>
																			</td>
																			<td>
																				<%
																					if (PunchIn2 == null) {
																				%>--<%
																					} else {
																				%><%=PunchIn2%> <%
 	}
 %>
																			</td>
																			<td>
																				<%
																					if (PunchOut2 == null) {
																				%>--<%
																					} else {
																				%><%=PunchOut2%> <%
 	}
 %>
																			</td>
																			<td>
																				<%
																					long hours = actualMintes / 60;
																									long minutes = actualMintes % 60;
																				%> <%=hours + "." + minutes%> <%-- <%=actualMintes %> --%>
																			</td>
																			<td>
																				<%
																					long fhours = finalMinutes / 60;
																									long fminutes = finalMinutes % 60;
																				%> <%=fhours + "." + fminutes%> <%-- <%=finalMinutes %> --%>
																			</td>
																			<td>
																				<%
																					if (finalMinutes < 235) {
																				%> <font color="Red">Leave</font> <%
 	}
 %>

																			</td>
																			<td>
																				<%
																					if (finalMinutes <= 354 && finalMinutes >= 235) {
																				%> <font color="Red">HD</font> <%
 	}
 %>

																			</td>
																			<td>
																				<%
																					if (finalMinutes <= 444 && finalMinutes >= 355) {
																				%> <font color="Red">SL</font> <%
 	}
 %>

																			</td>

																			<td><font color="Red"><%=gatePass%></font></td>
																			<td><font color="Red"><%=OD%></font></td>

																		</tr>





																		<%
																			}
																					}
																		%>




																		<%
																			}
																			}
																		%>
																	</tbody>
																</table>
															</div>
															<h5>
																<b>Legends :&nbsp;</b>
															</h5>
															<i class="" style="color: #337ab7;"></i><b>(LC) :
																Late Coming </b> &nbsp;&nbsp;&nbsp;<i class=""
																style="color: #337ab7;"></i><b>(EG) : Early Going</b>
															&nbsp;&nbsp;&nbsp; <i class="" style="color: #337ab7;"></i><b>(HD)
																: Half Day</b> &nbsp;&nbsp;&nbsp;<i class=""
																style="color: #337ab7;"></i><b>(SL) : Short Leave</b>
															&nbsp;&nbsp;&nbsp;




															<%--   <%} %> --%>
														</div>
														<!-- /.table-responsive -->
														<!-- /.panel -->
													</div>
													<!-- /.col-lg-12 -->
												</div>
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