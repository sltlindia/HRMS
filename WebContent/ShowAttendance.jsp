<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
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
	<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
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
<title>Show Attendance</title>
</head>


<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int emp_code = user.getEmployee_code(); /* emp_code = 331, emp_id = 331; */
		int EMP_MASTER_ID = user.getEmployee_master_id(); /* Like 1522 Employee Master Id*/
		String company_code = user.getCompanyListBean().getCompany_code(); // Like Company Code for 1 to 7 ......
		int ODDAYCOUNT = 0;
		int HdCounter = 0;
		int SLCounter = 0;
		int LeaveLCounter = 0;
		int presentCounter = 0;
		int MissPunch = 0;
		ArrayList<String> ODDATECOUNT = new ArrayList<String>();
		ArrayList<String> HOLIDAYDAYCOUNT = new ArrayList<String>();
		ArrayList<String> CODATECOUNT = new ArrayList<String>();
	%>
	<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">Attendance Details</h4>
				                		</div>
				            		</div>
				            		
						<div class="card-body collapse in">
	  						<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
											<br>
											<div class="panel-body">
												<!-- Nav tabs -->
												<ul class="nav nav-tabs">
													<%
														int year = 0;
														year = Calendar.getInstance().get(Calendar.YEAR);
														int month_id = Calendar.getInstance().get(Calendar.MONTH) + 1;

														if (request.getParameter("month_id") != null) {
															month_id = Integer.parseInt(request.getParameter("month_id"));
															int Year = Calendar.getInstance().get(Calendar.YEAR);

															if (month_id > 9) {
																year = Year - 1;
															}

															//year = Year -1;
														}
													%>

													<select class="form-control" name="MonthId"
														placeholder="Select Company Name" id="MonthId"
														required="required" onchange="diff(this.value);">
														<option value="">---Select Month Name---</option>
														<%
															AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
															List<MonthBean> listofMonth = allLMSListDAO.getListOfMonth();

															for (MonthBean month : listofMonth) {
																if (month.getMonth_id() > 9) {

																	if (month_id == month.getMonth_id()) {
														%>
														<option value="<%=month.getMonth_id()%>"
															selected="selected"><%=month.getMonth_name()%></option>
														<%
															} else {
														%>
														<option value="<%=month.getMonth_id()%> "><%=month.getMonth_name()%></option>
														<%
															}
														%>
														<%
															}
														%>

														<%
															if (month.getMonth_id() < 10 && month.getMonth_id() >= 1) {

																	if (month_id == month.getMonth_id()) {
														%>
														<option value="<%=month.getMonth_id()%>"
															selected="selected"><%=month.getMonth_name()%></option>
														<%
															} else {
														%>
														<option value="<%=month.getMonth_id()%> "><%=month.getMonth_name()%></option>
														<%
															}
														%>
														<%
															}
														%>

														<%
															}
														%>

													</select>
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
																				<table class="table table-bordered table-xs" style="font-size: 12px;">
																					<thead>
																						<tr>
																							<!--     <th>Vacancy Id</th> -->
																							<th style="text-align:center; padding-left: 0px; padding-right: 0px;" width="15px;">Date</th>
																							<th style="text-align:center; padding-left: 0px; padding-right: 0px;" rowspan="2" width="15px;">In
																								Time</th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" rowspan="2" width="15px;">Out
																								Time</th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">Total Hours</th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">Work Hours <a
																								href="" data-toggle="modal"
																								data-target="#myModal"><i class="fa fa-info"></i></a></th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">LC</th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">EG</th>
																							<!-- <th style="text-align:center"> Leave </th>
											<th style="text-align:center"> SL </th>
											<th style="text-align:center"> HD </th> -->
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">Gate Pass</th>
																							<th style="text-align:center;padding-left: 0px; padding-right: 0px;" width="15px;">Status</th>

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

																						System.out.println("START DATE " + startDate + " END DATE " + endDate);

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

																						AllLMSListDAO allListDAO = new AllLMSListDAO();
																						List<HolidayBean> listofholiday = allListDAO.getListOfHoliday();
																						String day = null;
																						String q = null;
																						for (HolidayBean h : listofholiday) {

																							String date = h.getHoliday_date();
																							Date w = formater56.parse(date);
																							q = formater56.format(w);
																							HOLIDAYDAYCOUNT.add(q);

																						}

																						System.out.println("OD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ODDATECOUNT);

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

																							//System.out.println("MIN DATE " + date + " MAX DATE " + maxDay);
																							String Sunday = null;
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
																								boolean sundayflag = false, ODflag = false, HolidayFlag = false, COflag = false;
																								long lowhours = 0;
																								double total = 0;
																								double total1 = 0;
																								String datePunchOut1 = null;
																								String datePunchIn2 = null;
																								String in = "";
																								String out1 = "";
																								String w = "-";
																								String w1 = "-";
																								String gatePass = "";
																								String security_out_time = null;
																								int sumOfMainHours = 0;
																								int sumOfMainMinutes = 0;
																								boolean NOATTDAY = false;

																								//System.out.println(" Incriment Date" + incDate);
																								incDate = sdf.format(c.getTime());
																								Date result4 = sdf.parse(incDate);
																								incDate = format1.format(result4);

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
																										//System.out.println("SUNDAY" + incDate);

																										Sunday = "SUNDAY";
																										sundayflag = true;
																									}

																									//System.out.println("Date>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result4);

																									for (String d : ODDATECOUNT) {

																										Date d1 = formater56.parse(d);

																										if (d1.equals(result4)) {
																											//System.out.println("OD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+d);

																											ODflag = true;
																										}
																									}

																									for (String d : CODATECOUNT) {

																										Date h1 = formater56.parse(d);

																										if (h1.equals(result4)) {
																											System.out.println(" >>>>>>>>>>>>>>>>>> CO DATE <<<<<<<<<<<<<<");
																											COflag = true;
																										}

																									}

																									for (String r : HOLIDAYDAYCOUNT) {
																										Date d2 = formater56.parse(r);

																										if (d2.equals(result4)) {
																											HolidayFlag = true;
																											System.out.println("HOIDAY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + r + " <<<<<>>>>> " + d2
																													+ " <<<<<>>>>> " + result4);
																										}

																									}

																									while (rs.next()) {

																										runCount++;

																										String Intime = null, outtime = null;

																										// PunchDate Formate
																										PDate = rs.getString(11);

																										SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																										SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

																										Date result1 = formater2.parse(PDate);

																										//PunchDate = formater1.format(result1);

																										SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");

																										ArrayList<String> INDATE = new ArrayList<String>();
																										/* INDATE.add(incDate); */

																										SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");

																										if (PDate == null) {
																											System.out.println("Absent");
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

																										//System.out.println("splitIntimeValue " + StartIntime + " splitOuttimeValue " +  EndOuttime);
																										// Total Hours Count
																										Date d1 = null;
																										Date d2 = null;
																										Date d3 = null;
																										Date d4 = null;

																										if (PunchOut2 == null && PunchIn2 != null) {
																											PunchOut2 = PunchIn2;
																											PunchIn2 = null;

																											outtime = Intime;
																											Intime = PunchIn1;

																											dateStart2 = dateStart1;
																											dateStart1 = tempIntime;
																											total = 0;
																										}

																										if ((Intime != null || outtime != null) && (Intime != null && outtime != null)) {
																											try {

																												d1 = format.parse(dateStart1);
																												d2 = format.parse(dateStart2);

																												/* Date MinTime = new Date("01/01/2016 09:15:00");
																												Date MaxTime = new Date("01/01/2016 18:00:00");
																												 
																												date3 = format.format(MinTime);
																												date4 = format.format(MaxTime);
																												
																												d3 =  format.parse(date3);
																												d4 =  format.parse(date4);
																												
																												Time TIME1 = new Time(d1.getTime());
																												Time TIME2 = new Time(d2.getTime());
																												
																												Time TIME3 = new Time(d3.getTime());
																												Time TIME4 = new Time(d4.getTime()); */

																												//System.out.println("IN TIME " + TIME1 + "OUT TIME " + TIME2); 
																												//System.out.println("Static TIME IN " + TIME3 + " Static OUT TIME " + TIME4); 

																												SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
																												dateFormat.format(d1);
																												//dateFormat.format(MinTime);

																												dateFormat.format(d2);
																												//dateFormat.format(MaxTime);

																												//in milliseconds
																												long diff = d2.getTime() - d1.getTime();
																												diffSeconds = diff / 1000 % 60;
																												diffMinutes = diff / (60 * 1000) % 60;
																												diffHours = diff / (60 * 60 * 1000) % 24;
																												diffDays = diff / (24 * 60 * 60 * 1000) + 1;

																												//System.out.println(diffDays + " days, " + " Hours " + diffHours + " Minutes " + diffMinutes + " Second " + diffSeconds);

																												mainhours = Long.toString(diffHours);
																												mainminuts = Long.toString(diffMinutes);

																												if (mainminuts.length() == 1) {
																													mainminuts = "0" + mainminuts;
																												}

																												sumOfMainHours = sumOfMainHours + Integer.parseInt(mainhours);
																												sumOfMainMinutes = sumOfMainMinutes + Integer.parseInt(mainminuts);

																												if (sumOfMainMinutes > 60) {
																													sumOfMainMinutes = sumOfMainMinutes - 60;
																													sumOfMainHours = sumOfMainHours + 1;
																												}

																												String zeroValue = String.valueOf(sumOfMainMinutes);

																												if (sumOfMainMinutes < 10) {
																													zeroValue = "0" + sumOfMainMinutes;
																												}

																												Totalcount = sumOfMainHours + "." + zeroValue;

																												System.out.println("mainhours:" + mainhours + "sumOfMainHours:" + sumOfMainHours);
																												System.out.println(
																														"mainMinutes:" + mainminuts + "sumOfMainHours:" + sumOfMainMinutes);

																												Totalhours = Double.parseDouble(Totalcount);
																												total = Double.parseDouble(Totalcount);
																												System.out.println("TOTAL TIME " + Totalhours);

																												w = String.format("%.2f", total);

																												//System.out.print(w);

																											} catch (Exception e) {
																												e.printStackTrace();
																											}
																										} else if ((Intime == null || outtime == null) && (Intime == null && outtime == null)) {
																											w = "0.0";
																											Status = "Miss Punch";
																											System.out.println("NULL");
																											MissPunch = MissPunch + 1;
																										}

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
																										security_out_time = gatePassBean.getSecurity_out_time();

																									}

																									if (total == 0) {

																										String ODDATE = null;
																										ODDATE = AppDateFormat12.format(result4);

																									}

																									if (total != 0.0 && runCount == 1) {

																										finalWorkHour = total - 1.0;
																										qwrty = (float) finalWorkHour;

																										/* String[] arr=String.valueOf(qwrty).split("\\.");
																										int[] intArr=new int[2];
																										intArr[0]=Integer.parseInt(arr[0]); // 1
																										intArr[1]=Integer.parseInt(arr[1]); // 9
																										
																										System.out.println("hours1:"+ intArr[0]);
																										System.out.println("minutes1:"+ intArr[1]);
																										
																										String merge = null;
																										
																										if(intArr[1] > 60){
																											intArr[1] = intArr[1] - 60;
																											
																											if(intArr[1] < 10){
																												merge = 0+""+intArr[1];
																											}else{
																												merge = String.valueOf(intArr[1])  ;
																											}
																										
																										int sum = intArr[0] + 1;	
																										String value1 =  sum +"."+ merge;
																										finalWorkHour = Double.parseDouble(value1);
																											
																										} */

																										qwrty = (float) finalWorkHour;

																										w1 = String.format("%.2f", finalWorkHour);

																									} else if (total != 0.0) {

																										SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																										SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

																										Date endResult = formater2.parse(datePunchOut1);
																										Date startResult = formater2.parse(datePunchIn2);

																										String endDateStart = format.format(endResult);
																										String startDateStart = format.format(startResult);

																										try {

																											Date d11 = format.parse(endDateStart);
																											Date d22 = format.parse(startDateStart);

																											SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
																											dateFormat.format(d11);
																											//dateFormat.format(MinTime);

																											dateFormat.format(d22);
																											//dateFormat.format(MaxTime);

																											//in milliseconds
																											long diff = d22.getTime() - d11.getTime();
																											diffSeconds = diff / 1000 % 60;
																											diffMinutes = diff / (60 * 1000) % 60;
																											diffHours = diff / (60 * 60 * 1000) % 24;
																											diffDays = diff / (24 * 60 * 60 * 1000) + 1;

																											String mainhours1 = Long.toString(diffHours);
																											String mainminuts1 = Long.toString(diffMinutes);

																											if (mainminuts.length() == 1) {
																												mainminuts = "0" + mainminuts;
																											}

																											int mainhoursInt = Integer.parseInt(mainhours1);
																											int mainminutsInt = Integer.parseInt(mainminuts1);

																											if (mainminutsInt > 60) {
																												mainminutsInt = mainminutsInt - 60;
																												mainhoursInt = mainhoursInt + 1;
																											}

																											String zeroValue = String.valueOf(mainminutsInt);

																											if (mainminutsInt < 10) {
																												zeroValue = "0" + mainminutsInt;
																											}

																											String tCount = mainhoursInt + "." + zeroValue;

																											total1 = Double.parseDouble(tCount);

																										} catch (Exception e) {
																											e.printStackTrace();
																										}

																										if (total1 < 0.60) {
																											finalWorkHour = total + total1 - 1.0;
																										} else {
																											finalWorkHour = total;
																										}

																										System.out.println("finalWorkHour:" + finalWorkHour);

																										qwrty = (float) finalWorkHour;

																										w1 = String.format("%.2f", finalWorkHour);

																										String[] arr = String.valueOf(w1).split("\\.");
																										int[] intArr = new int[2];
																										intArr[0] = Integer.parseInt(arr[0]); // 1
																										intArr[1] = Integer.parseInt(arr[1]); // 9

																										System.out.println("hours1:" + intArr[0]);
																										System.out.println("minutes1:" + intArr[1]);

																										if (intArr[1] > 60) {
																											intArr[1] = intArr[1] - 60;
																											intArr[0] = intArr[0] + 1;

																											String pointValue = null;

																											if (intArr[1] < 10) {
																												pointValue = 0 + "" + intArr[1];
																											} else {
																												pointValue = String.valueOf(intArr[1]);
																											}

																											String value1 = intArr[0] + "." + pointValue;

																											System.out.println("value1:" + value1);

																											finalWorkHour = Double.parseDouble(value1);

																										} else {

																											String pointValue = null;

																											if (intArr[1] < 10) {
																												pointValue = 0 + "" + intArr[1];
																											} else {
																												pointValue = String.valueOf(intArr[1]);
																											}

																											String value1 = intArr[0] + "." + pointValue;
																											finalWorkHour = Double.parseDouble(value1);
																										}

																										qwrty = (float) finalWorkHour;
																										w1 = String.format("%.2f", finalWorkHour);

																										double newFinalWorkHour = 0;

																										if (total1 < 0.60) {
																											newFinalWorkHour = finalWorkHour + 1.0;
																											w = String.format("%.2f", newFinalWorkHour);
																										} else {
																											newFinalWorkHour = finalWorkHour + total1;
																											w = String.format("%.2f", newFinalWorkHour);
																										}

																									}

																									if (finalWorkHour <= 5.29 && finalWorkHour >= 4) {
																										if (runCount == 1) {

																											double parseFinalData = Double.parseDouble(w);
																											if (parseFinalData < 6) {
																												finalWorkHour = finalWorkHour + 1;
																												w1 = String.format("%.2f", finalWorkHour);
																											}
																										}
																									}
																					%>


																					<tbody>
																						<tr align="Center">
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;"
																								rowspan="2"><%=PunchDate%></th>
																							<th
																								style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;">
																								<%
																									if (PunchIn1 == null) {
																								%>--<%
																									} else {
																								%><%=PunchIn1%> <%
 	}
 %>
																							</th>
																							<th
																								style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;">
																								<%
																									if (PunchOut1 == null) {
																								%>--<%
																									} else {
																								%><%=PunchOut1%> <%
 	}
 %>
																							</th>
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;" rowspan="2"><%=w%>
																							</th>
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;" rowspan="2"><%=w1%>
																							</th>
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;"
																								rowspan="2">
																								<%
																									if (finalWorkHour < 7.46) {
																								%> <%
 	if (BioIntime <= StartIntime) {
 %> <font color="Red"><%=MININTIME%></font> <%-- <% ShortLeaveCounter++; %>  --%>
																								<%
																									}
																												}
																								%>
																							</th>
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;"
																								rowspan="2">
																								<%
																									if (finalWorkHour < 7.46) {
																								%> <%
 	if (EG >= EndOuttime) {
 %> <font color="Red"><%=MAXOUTTIME%></font> <%-- <% ShortLeaveCounter++; %>  --%>
																								<%
																									}
																												}
																								%>
																							</th>


																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;" rowspan="2"><font
																								color="Black" style="font-style: italic;"><i
																									class="" style="cursor: pointer;"
																									style="width:1000px;" tabindex="0"
																									data-toggle="popover" data-trigger="hover"
																									title="Out Time Detail"
																									data-content="<%=security_out_time%>"> <%=gatePass%>
																								</i></font></th>
																							<th style="padding-left: 0px; padding-right: 0px; text-align:center" width="15px;"
																								rowspan="2">
																								<%
																									if (PunchIn1 == null && PunchIn2 == null && PunchOut1 == null && PunchOut2 == null) {
																													if (sundayflag == false) {
																								%> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {
 %> <%
 	if (HolidayFlag == true) {
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
 %> <font color="blue" style="font-style: italic;">Sunday </font> <%
 	}
 %> <%
 	}
 %> <%
 	} else {
 %> <%
 	if (total != 0 && total >= 4.0) {

 						if (finalWorkHour < 7.46 && sundayflag == false) {

 							if (BioIntime < StartIntime) {
 %> <!--  <font color="green"><font color="Red">(LC)</font></font>  -->
																								<%
																									}
																															if (BioOutTime > EndOuttime) {
																								%> <!--  <font color="green"><font color="Red">(EG)</font></font>  -->
																								<%
																									}
																								%> <%
 	if (finalWorkHour <= 7.45 && finalWorkHour >= 5.30) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {
 									SLCounter = SLCounter + 1;
 %> <font color="green"><font color="Red">(SL)</font></font> <%
 	}
 %> <%
 	}
 %> <%
 	if (finalWorkHour <= 5.29 && finalWorkHour >= 4) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else if (COflag == true) {
 %> <font color="purple"> CO </font> <%
 	} else {

 									HdCounter = HdCounter + 1;
 %> <font color="green"><font color="Red">(HD)</font></font> <%
 	}
 %> <%
 	}
 %> <%
 	if (finalWorkHour < 3.59) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else {
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
 	presentCounter++;
 %> <font color="green"><font color="Red"></font>Present</font> <%
 	if (sundayflag == true) {
 %> <font color="green">in sunday</font> <%
 	}
 %> <%
 	} else {
 %> <%
 	presentCounter++;
 %> <font color="green">Present</font> <%
 	if (sundayflag == true) {
 %> <font color="green">in sunday</font> <%
 	}
 %> <%
 	}
 %> <%
 	} else if ((PunchIn1 != null) && (w.equals(""))
 							|| (PunchIn1 != null && PunchOut1 == null)) {

 						MissPunch = MissPunch + 1;
 %> <font color="Red"> Miss Punch</font> <%
 	} else if (w.equals("")) {
 						if (sundayflag == false) {
 %> <font color="Red"> Absent </font> <%
 	} else {
 %> <font color="blue" style="font-style: italic;"> Sunday </font> <%
 	}
 					} else if (total <= 4.0) {
 %> <%
 	if (ODflag == true) {
 %> <font color="purple"> OD </font> <%
 	} else {
 %> <%
 	if (HolidayFlag == true) {
 %> <font color="Awesome"> Holiday </font> <%
 	} else {
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
																								style="padding-left: 0px; padding-right: 0px;text-align:center" width="15px;">
																								<%
																									if (PunchIn2 == null) {
																								%>--<%
																									} else {
																								%><%=PunchIn2%> <%
 	}
 %>
																							</th>
																							<th
																								style="padding-left: 0px; padding-right: 0px;text-align:center" width="15px;">
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
																					<br>
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


																			</div>
																			<h5>
																				<b>Legends :&nbsp;</b>
																			</h5>
																			<i class="" style="color: #337ab7;"></i><b>(LC) :
																				Late Coming </b> &nbsp;&nbsp;&nbsp;<i class=""
																				style="color: #337ab7;"></i><b>(EG) : Early
																				Going</b> &nbsp;&nbsp;&nbsp; <i class=""
																				style="color: #337ab7;"></i><b>(HD) : Half Day</b>
																			&nbsp;&nbsp;&nbsp;<i class="" style="color: #337ab7;"></i><b>(SL)
																				: Short Leave</b> &nbsp;&nbsp;&nbsp;

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
					Company Give You 45 Minutes Lunch Break And 15 Minutes For Tea
					Break.<br> So If Your Working Hours Are Less Than 8:00 Hours
					Than, Late Coming Or Early Going May Count.<br>


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
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
	<script>
		$(document).ready(function() {

			$('#dataTables-example').DataTable({
				responsive : true,
			// "aSort" : false
			});

			/*  $('#dataTables-exampleCO').DataTable({
			     responsive: true, 
			     "aSort" : false
				 });
			
			 $('#dataTables-exampleLEAVE').DataTable({
			     responsive: true,   
			     "order": [[ 6, "desc" ]]
				 }); */
		});
	</script>
	<script type="text/javascript">
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		$("[data-toggle=popover]").popover({
			html : true
		})

		$('.popover-dismiss').popover({
			trigger : 'focus'
		})
	</script>

</body>
</html>