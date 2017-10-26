<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.lms.bean.GatePassBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryBean"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@page import="com.hrms.recruitement.bean.ResumeDataBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.recruitement.bean.VacancyFormBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.recruitement.dao.AllRecruitmentListDAO"%>
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
<script type="text/javascript">
	function diff(value) {
		//alert(value);
		window.location.replace("ShowAttendance.jsp?month_id=" + value);

	}
</script>
<style type="text/css">
.txt {
	text-align: center;
	line-height: 5vh;
}
</style>
<title>Insert title here</title>
</head>


<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int manager_id = user.getManagerBean().getManager_id();
		int emp_code = user.getEmployee_code(); /* emp_code = 331, emp_id = 331; */
		int EMP_MASTER_ID = user.getEmployee_master_id(); /* Like 1522 Employee Master Id*/
		String company_code = user.getCompanyListBean().getCompany_code(); // Like Company Code for 1 to 7 ......
		String value = "";
		int ODDAYCOUNT = 0;
		int HdCounter = 0;
		int SLCounter = 0;
		int LeaveLCounter = 0;
		int MissPunch = 0;
		int HolidayCounter = 0;
		int SundayCounter = 0;
		int presentCounter = 0;
		double FinalHoursCounter = 0;
		double dailyWorkHours = 0;
		ArrayList<String> ODDATECOUNT = new ArrayList<String>();
		ArrayList<String> HOLIDAYDAYCOUNT = new ArrayList<String>();
		ArrayList<String> CODATECOUNT = new ArrayList<String>();
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
										<h4 class="page-header"></h4>
									</div>
								</div>
								<!-- /.row -->

								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h5>Attendance Details</h5>
											</div>
											<!-- /.panel-heading -->
											<div class="panel-body">
												<!-- Nav tabs -->
												<ul class="nav nav-tabs">
													<%
														int year = 0;
														year = Calendar.getInstance().get(Calendar.YEAR);
														int month_id = 0;
														String name = null;
														if (request.getParameter("month_id") != null) {
															month_id = Integer.parseInt(request.getParameter("month_id"));
															value = request.getParameter("employee_name");
															EMP_MASTER_ID = Integer.parseInt(value);

															System.out.println("COMPANY " + company_code);
															int Year = Calendar.getInstance().get(Calendar.YEAR);

															if (month_id > 9) {
																year = Year - 1;
															}
														}
													%>

													<form action="masterINOUT.jsp">
														<div class="row">
															<div class="col-md-12">

																<div class="col-md-2">Select Employee :</div>
																<div class="col-md-3">


																	<%
																		AllListDAO allListDAO = new AllListDAO();
																		int emp_id = user.getEmployee_master_id();
																		List<EmployeeBean> listOfEmployee = null;
																		if (emp_id == 1120 || emp_id == 975 || emp_id == 1946) {
																			//listOfEmployee = allListDAO.getListOfAllEmployeeForLeaveSurat();
																		} else if (emp_id == 1959) {
																			//listOfEmployee = allListDAO.getListOfAllEmployeeForLeaveA8DeptWise();
																		} else {
																			listOfEmployee = allListDAO.getListOfAllEmployeeForLeave();
																		}
																	%>
																	<select class="select2-diacritics form-control"
																		id="select2-diacritics" name="employee_name"
																		placeholder="SELECT" required>
																		<option value="">---SELECT---</option>
																		<%
																			for (EmployeeBean e : listOfEmployee) {
																		%>
																		<option value="<%=e.getEmployee_master_id()%>"><%=e.getEmployee_code() + "," + e.getFirstname() + " " + e.getLastname()%></option>
																		<%
																			}
																		%>

																	</select>
																</div>

																<div class="col-md-2">Select Month :</div>
																<div class="col-md-3">
																	<select class="form-control" name="month_id"
																		placeholder="Select Company Name" id="MonthId"
																		required="required"">
																		<option value="0">---Select Month Name---</option>
																		<%
																			AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																			List<MonthBean> listofMonth = allLMSListDAO.getListOfMonth();
																			for (MonthBean month : listofMonth) {
																				if (month_id == month.getMonth_id()) {
																		%>
																		<option value="<%=month.getMonth_id()%>"
																			selected="selected"><%=month.getMonth_name()%></option>
																		<%
																			} else {
																		%>
																		<option value="<%=month.getMonth_id()%>"><%=month.getMonth_name()%></option>
																		<%
																			}
																		%>
																		<%
																			}
																		%>
																	</select>
																</div>
																<div class="col-md-2">
																	<input class="btn btn-primary" type="submit"
																		name="submit" value="SUBMIT">
																</div>
															</div>

														</div>
													</form>
													<br>



												</ul>


												<!-- Tab panes -->

												<div class="row">
													<div class="col-lg-12">
														<div class="tab-content">

															<div class="row">
																<div class="col-lg-12">
																	<%--   ${delete } --%>
																	<!-- /.panel-heading -->
																	<div class="panel-body">
																		<div class="dataTable_wrapper">
																			<div class="table-responsive">
																				<%
																					if (month_id != 0) {
																				%>
																				<%-- <h4>
																					<%=name%>
																				</h4> --%>
																				<table class="table table-bordered table-xs"
																					style="font-size: 12px;">
																					<thead>
																						<tr>
																							<!--     <th>Vacancy Id</th> -->
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">Date</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								rowspan="2" width="15px;">In Time</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								rowspan="2" width="15px;">Out Time</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">Total Hours</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">Work Hours <a href=""
																								data-toggle="modal" data-target="#myModal"><i
																									class="icon icon-eye4"></i></a></th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">LC</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">EG</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">LS</th>
																							<!-- <th style="text-align:center"> Short Leave </th> -->
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">Gate Pass</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">Status</th>

																						</tr>
																					</thead>
																					<%
																						String startDate = null;
																							String endDate = null;

																							System.out.println("MONTH ID " + month_id);

																							if (month_id == 1 || month_id == 3 || month_id == 5 || month_id == 7 || month_id == 8) {
																								startDate = year + "-0" + month_id + "-01";
																								endDate = year + "-0" + month_id + "-31";
																							} else if (month_id == 4 || month_id == 6 || month_id == 9) {
																								startDate = year + "-0" + month_id + "-01";
																								endDate = year + "-0" + month_id + "-30";
																							} else if (month_id == 10 || month_id == 12) {
																								startDate = year + "-" + month_id + "-01";
																								endDate = year + "-" + month_id + "-31";
																							}

																							if (month_id == 11) {
																								startDate = year + "-" + month_id + "-01";
																								endDate = year + "-" + month_id + "-30";
																							}
																							if (month_id == 2) {
																								if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
																									startDate = year + "-0" + month_id + "-01";
																									endDate = year + "-0" + month_id + "-29";
																								} else {
																									startDate = year + "-0" + month_id + "-01";
																									endDate = year + "-0" + month_id + "-28";
																								}
																							}

																							startDate = year + "-01-01";
																							endDate = year + "-12-31";

																							List<LeaveODBean> listOfgatOD = allLMSListDAO.getODListPerMonth(startDate, endDate, EMP_MASTER_ID);
																							SimpleDateFormat formater56 = new SimpleDateFormat("yyyy-MM-dd");
																							String addOd = null;
																							for (LeaveODBean leaveODBean : listOfgatOD) {
																								int ODDCOUNT = 0;

																								int ODID = leaveODBean.getOD_ID();
																								String s = leaveODBean.getOD_StartDate();
																								String e = leaveODBean.getOD_EndDate();
																								System.out.println("OD ID" + ODID);
																								System.out.println("COUNT");
																								ODDCOUNT = leaveODBean.getOD_TotalDay();
																								System.out.println("OKKKKK" + ODDCOUNT);

																								Date frontDate1 = formater56.parse(s);

																								for (int j = 0; j < ODDCOUNT; j++) {

																									addOd = formater56.format(frontDate1);
																									ODDATECOUNT.add(addOd);
																									System.out.println("current INCC " + addOd);

																									if (ODDCOUNT == 1) {
																										frontDate1.setDate(frontDate1.getDate() + 0);

																									} else {
																										frontDate1.setDate(frontDate1.getDate() + 1);
																									}

																									System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<");

																									//System.out.println("current INCC " + frontDate1);
																								}

																								//ODDATECOUNT.add(e);
																							}

																							List<LeaveCOBean> listOfgatCO = allLMSListDAO.getCOListPerMonth(startDate, endDate, EMP_MASTER_ID);
																							String COMAINDATE = null;
																							for (LeaveCOBean leaveCOBean : listOfgatCO) {
																								int CODCOUNT = 0;

																								String CO = leaveCOBean.getCO_date();
																								Date CoStartDate = formater56.parse(CO);
																								CoStartDate.setDate(CoStartDate.getDate() + 0);
																								COMAINDATE = formater56.format(CoStartDate);
																								CODATECOUNT.add(COMAINDATE);

																							}

																							AllLMSListDAO allListDAOe = new AllLMSListDAO();
																							List<HolidayBean> listofholiday = allListDAOe.getListOfHoliday();
																							String day = null;
																							String q = null;
																							for (HolidayBean h : listofholiday) {

																								String date = h.getHoliday_date();
																								Date w = formater56.parse(date);
																								q = formater56.format(w);
																								HOLIDAYDAYCOUNT.add(q);

																							}

																							Connection conn = null;
																							Statement smt;
																							ResultSet rs = null;
																							conn = DBConnection.getConnection();

																							String unplanstartDate = null;
																							String unplanendDate = null;

																							unplanstartDate = "" + month_id + "/01/" + year;
																							boolean currentDateFlag = false;

																							if (conn != null) {
																								smt = conn.createStatement();
																								//String date="11/01/2016";
																								String date = unplanstartDate;
																								String incDate;
																								SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

																								Calendar calendar = Calendar.getInstance();

																								// Move calendar to yesterday
																								calendar.add(Calendar.DATE, -1);

																								// Get current date of calendar which point to the yesterday now
																								Date yesterday = calendar.getTime();

																								SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy 12:00:00 aa");
																								SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
																								Calendar c = Calendar.getInstance();
																								c.setTime(sdf.parse(date));
																								int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

																								int ShortLeaveCounter = 0;

																								//System.out.println("MIN DATE " + date + " MAX DATE " + maxDay);
																								String Sunday = null;
																								for (int co = 0; co < maxDay; co++) {

																									String PunchDate = null, PDate = null, Start = null, Stop = null, dateStart1 = null,
																											dateStart2 = null, date3 = null, date4 = null;
																									double StartIntime = 0, EndOuttime = 0, BioIntime = 9.05, BioOutTime = 5.30, EG = 6.00,
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
																									boolean sundayflag = false, ODflag = false, HolidayFlag = false, COflag = false;
																									long lowhours = 0;
																									double total = 0;
																									double total1 = 0;
																									String in = "";
																									String out1 = "";
																									String w = "-";
																									String w1 = "-";
																									String gatePass = "";
																									String gatePassPurpose = "";
																									String security_out_time = null;
																									String datePunchOut1 = null;
																									String datePunchIn2 = null;
																									int sumOfMainHours = 0;
																									int sumOfMainMinutes = 0;
																									String Totalcountakash = null;
																									boolean NOATTDAY = false;
																									String test = "-";
																									long finalMinutes = 0;
																									long actualMintes = 0;
																									long lunchMinute = 0;

																									List<String> listOfAllPunch = new ArrayList<String>();

																									//System.out.println(" Incriment Date" + incDate);
																									incDate = sdf.format(c.getTime());
																									Date result4 = sdf.parse(incDate);
																									incDate = format1.format(result4);

																									// This code for Not Download Attendance;
																									smt.executeQuery(
																											"SELECT * from FingerTec_TimeTrack.dbo.In_Out_Detail where Date = '" + incDate + "'");
																									rs = smt.getResultSet();
																									if (rs.next()) {
																										System.out.println(" IF DATE " + incDate);
																									} else {
																										System.out.println(" ELSE IF DATE " + incDate);
																										NOATTDAY = true;
																										System.out.println(" ELSE IF DATE " + incDate);
																									}

																									if (result4.before(yesterday)) {

																										//System.out.println(" Incriment Date  " + incDate);
																										PunchDate = formater1.format(result4);

																										smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.In_Out_Detail where EMP_CODE = "
																												+ emp_code + " AND Date = '" + incDate + "' AND Code='" + company_code + "'");
																										rs = smt.getResultSet();

																										c.add(Calendar.DATE, 1);

																										SimpleDateFormat AppDateFormat12 = new SimpleDateFormat("yyyy-MM-dd");

																										/* c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
																										int sunday = c.get(Calendar.DAY_OF_WEEK);
																										if (sunday == Calendar.SUNDAY) 
																										{ 
																										   System.out.println("SUNDAY " + incDate);
																										}
																										 */

																										if (result4.getDay() == 0) {
																											System.out.println("SUNDAY" + incDate);

																											Sunday = "SUNDAY";
																											sundayflag = true;
																										}

																										for (String d : ODDATECOUNT) {

																											Date d1 = formater56.parse(d);

																											if (d1.equals(result4)) {
																												//System.out.println("OD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+d);

																												ODflag = true;
																											}
																										}

																										for (String r : HOLIDAYDAYCOUNT) {
																											Date d2 = formater56.parse(r);

																											if (d2.equals(result4)) {
																												HolidayFlag = true;
																												System.out.println("HOIDAY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + r + " <<<<<>>>>> "
																														+ d2 + " <<<<<>>>>> " + result4);
																											}

																										}

																										for (String d : CODATECOUNT) {

																											Date h1 = formater56.parse(d);

																											if (h1.equals(result4)) {
																												System.out.println(" >>>>>>>>>>>>>>>>>> CO DATE <<<<<<<<<<<<<<");
																												COflag = true;
																											}

																										}

																										while (rs.next()) {

																											runCount++;

																											String Intime = null, outtime = null;

																											// PunchDate Formate
																											PDate = rs.getString(11);
																											SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																											Date result1 = formater2.parse(PDate);

																											//PunchDate = formater1.format(result1);

																											SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
																											SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

																											ArrayList<String> INDATE = new ArrayList<String>();
																											/* INDATE.add(incDate); */

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

																											System.out.println("START " + Start + " END " + Stop);
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

																										SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																										SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
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

																													} catch (Exception e) {
																														e.printStackTrace();
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

																														} catch (Exception e) {
																															e.printStackTrace();
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

																										//System.out.println("Akash " + GatePassDate);

																										List<GatePassBean> listOfgatepass = allLMSListDAO.getGatePassListPerMonth(GatePassDate,
																												EMP_MASTER_ID);
																										for (GatePassBean gatePassBean : listOfgatepass) {
																											int id = gatePassBean.getGate_pass_id();
																											//System.out.println("ID " + id);
																											gatePass = "YES";
																											gatePassPurpose = "(" + gatePassBean.getPurpose_of_leave() + ")";
																											security_out_time = gatePassBean.getSecurity_out_time();

																										}
																					%>






																					<tbody>
																						<tr align="Center">
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2"><%=PunchDate%></th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">
																								<%
																									if (PunchIn1 == null) {
																								%>--<%
																									} else {
																								%><%=PunchIn1%> <%
 	}
 %>
																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">
																								<%
																									if (PunchOut1 == null) {
																								%>--<%
																									} else {
																								%><%=PunchOut1%> <%
 	}
 %>
																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									long hours = actualMintes / 60;
																													long minutes = actualMintes % 60;
																								%> <%=hours + "." + minutes%>
																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									long fhours = finalMinutes / 60;
																													long fminutes = finalMinutes % 60;
																													dailyWorkHours = Double.parseDouble(fhours + "." + fminutes);
																								%> <%=fhours + "." + fminutes%>
																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									if (finalMinutes <= 474) {
																								%> <%
 	if (BioIntime <= StartIntime) {
 %> <font color="Red"><%=MININTIME%></font> <%-- <% ShortLeaveCounter++; %>  --%>
																								<%
																									}
																													}
																								%>

																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									if (finalMinutes <= 474) {
																								%> <%
 	if (EG >= EndOuttime) {
 %> <font color="Red"><%=MAXOUTTIME%></font> <%-- <% ShortLeaveCounter++; %>  --%>
																								<%
																									}
																													}
																								%>
																							</th>

																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									if (finalMinutes > 480) {
																								%> <%=finalMinutes - 480%> minutes <%
 	}
 %>
																							</th>


																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2"><font
																								color="Black" style="font-style: italic;"><i
																									class="" style="cursor: pointer;"
																									style="width:1000px;" tabindex="0"
																									data-toggle="popover" data-trigger="hover"
																									title="Out Time Detail"
																									data-content="<%=security_out_time%>"> <%=gatePass%>
																										<%=gatePassPurpose%></i></font></th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;" rowspan="2">
																								<%
																									if (listOfAllPunch.size() == 0) {
																														if (sundayflag == false) {
																								%> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {
 %> <%
 	if (HolidayFlag == true) {
 									HolidayCounter = HolidayCounter + 1;
 %> <font color="Awesome"> Holiday </font> <%
 	} else {
 									//LeaveLCounter = LeaveLCounter + 1;
 %> <%
 	if (NOATTDAY == false) {

 										LeaveLCounter = LeaveLCounter + 1;
 %> <font color="Red"> Leave </font> <%
 	} else {
 %> <i class="glyphicon glyphicon-cloud-download"></i> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	} else {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {
 								SundayCounter = SundayCounter + 1;
 %> <font color="blue" style="font-style: italic;">Sunday </font> <%
 	}
 %> <%
 	}
 %> <%
 	} else {
 %> <%
 	if (finalMinutes != 0 && finalMinutes >= 235) {

 							if (finalMinutes <= 475 && sundayflag == false) {
 								if (finalMinutes <= 355) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 										//FinalHoursCounter = FinalHoursCounter + 480;
 %> <font color="purple"> CO </font> <%
 	} else {

 										HdCounter = HdCounter + 1;
 %> <font color="green"><font color="Red">(HD)</font></font> <%
 	}
 %> <%
 	} else if (finalMinutes <= 444) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 										//FinalHoursCounter = FinalHoursCounter + 480;
 %> <font color="purple"> CO </font> <%
 	} else {
 										SLCounter = SLCounter + 1;
 %> <font color="green"><font color="Red">(SL)</font></font> <%
 	}
 %> <%
 	} else {
 %> <%
 	if ((BioIntime < StartIntime) && (finalMinutes <= 474)) {
 										FinalHoursCounter = FinalHoursCounter + finalMinutes;
 %> <%
 	presentCounter++;
 %> <font color="Red">(LC) </font><font color="green">Present</font> <%
 	} else if ((BioOutTime > EndOuttime) && (finalMinutes <= 474)) {
 %> <%
 	FinalHoursCounter = FinalHoursCounter + finalMinutes;

 										presentCounter++;
 %> <font color="Red">(EG)</font><font color="green">Present</font> <%
 	} else {
 %> <%
 	presentCounter++;
 %> <font color="green">Present</font> <%
 	}
 %> <%
 	}
 %> <%
 	} else if (sundayflag == true) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {
 %> <font color="green">Present in Sunday</font> <%
 	}
 %> <%
 	} else if (finalMinutes > 480) {
 %> <%
 	presentCounter++;
 %> <%
 	if (COflag == true) {
 									FinalHoursCounter = FinalHoursCounter + 480;
 %> <font color="purple"> CO </font> <%
 	} else {
 									FinalHoursCounter = FinalHoursCounter + finalMinutes;
 %> <font color="Orange">(LS)</font> <font color="green">Present</font>
																								<%
																									}
																								%> <%
 	} else {
 %> <%
 	presentCounter++;
 %> <font color="green">Present</font> <%
 	}
 %> <!-- COUNTING OF LESS THAN 4 HOURS --> <%
 	} else if (listOfAllPunch.size() == 1) {

 							MissPunch = MissPunch + 1;
 %> <font color="Red"> Miss Punch</font> <%
 	} else if (finalMinutes == 0) {
 							if (sundayflag == false) {
 %> <font color="Red"> Absent </font> <%
 	} else {
 								SundayCounter = SundayCounter + 1;
 %> <font color="blue" style="font-style: italic;"> Sunday </font> <%
 	}
 						} else if (finalMinutes < 235) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else {
 %> <%
 	if (HolidayFlag == true) {
 									HolidayCounter = HolidayCounter + 1;
 %> <font color="Awesome"> Holiday </font> <%
 	} else {
 									//LeaveLCounter = LeaveLCounter + 1;
 %> <%
 	if (NOATTDAY == false) {

 										LeaveLCounter = LeaveLCounter + 1;
 %> <font color="Red"> Leave </font> <%
 	} else {
 %> <i class="glyphicon glyphicon-cloud-download"></i> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %>
																							</th>







																						</tr>


																						<tr>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">
																								<%
																									if (PunchIn2 == null) {
																								%>--<%
																									} else {
																								%><%=PunchIn2%> <%
 	}
 %>
																							</th>
																							<th
																								style="text-align: center; padding-left: 0px; padding-right: 0px;"
																								width="15px;">
																								<%
																									if (PunchOut2 == null) {
																								%>--<%
																									} else {
																								%><%=PunchOut2%> <%
 	}
 %>
																							</th>
																						</tr>


																					</tbody>
																					<%
																						} else {
																										currentDateFlag = true;
																					%>

																					<%
																						}
																					%>
																					<%
																						}
																							}
																					%>
																					<div>
																						<h5>
																							PRESENT :
																							<%=presentCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LEAVE :
																							<%=LeaveLCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; HD :
																							<%=HdCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SL :
																							<%=SLCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Miss Punch :
																							<%=MissPunch%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Holiday :
																							<%=HolidayCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sunday :
																							<%=SundayCounter%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Total Work Hours :
																							<%=String.format("%.2f", (FinalHoursCounter / 60))%>
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

																						</h5>
																					</div>
																					<br>




																				</table>


																				<%
																					if (currentDateFlag == true) {
																				%>
																				<h5>
																					<font color="red">* You can only show back
																						dated attendance.</font>
																				</h5>
																				<h5>
																					<i class="glyphicon glyphicon-cloud-download"></i>
																					: <font color="red">Download Pending.</font>
																				</h5>
																				<%
																					}
																				%>


																				<%
																					}
																				%>
																			</div>
																			<h5>
																				<b>Legends :&nbsp;</b>
																			</h5>
																			<i class="" style="color: #337ab7;"></i><b>(LC) :
																				Late Coming </b> &nbsp;&nbsp;&nbsp;<i class=""
																				style="color: #337ab7;"></i><b>(EG) : Early
																				Going</b> &nbsp;&nbsp;&nbsp;

																			<!-- /.modal-content -->
																		</div>
																		<!-- /.modal-dialog -->
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
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Attendance Details</h4>
				</div>
				<div class="modal-body">
					Company give you 1 hour lunch break and 15 minutes for tea break.<br>
					So if your working hours are less than 7:45 hours than, late coming
					or early going may count.<br>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal"
						onclick="check()">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
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
	<!-- BEGIN PAGE VENDOR JS-->
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
	<script src="app-assets/vendors/js/forms/select/select2.full.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/scripts/forms/select/form-select2.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->

</body>
</html>