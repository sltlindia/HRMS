<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="java.util.List"%>
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

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns"><%
	ArrayList<String> holiday = new ArrayList<String>();
%>
<div class="app-content container center-layout mt-2">
	<div class="content-wrapper">
		<div class="content-body">
			<section id="horizontal-form-layouts">
			<div class="card">
				<div class="card-body collapse in">
					<div class="card-block">
						<div class="form-body">
							<div class="row" style="text-align: center;">
								<img alt="logo" src="img/SLTL.gif" height="169px" width="300px">
							</div>
							<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">SLTL Holiday List - 2017</h4>
				                		</div>
				            		</div>
				            		<div class="card-body collapse in">
	  										<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
										<!-- /.panel-heading -->
										<div class="panel-body">
											<div class="dataTable_wrapper">
												<table
													class="table table-striped table-bordered table-hover">
													<!-- id="dataTables-example" -->
													<thead>
														<tr>
															<th style="text-align: center">Holiday Date</th>
															<th style="text-align: center">Holiday Name</th>
															<th style="text-align: center">Holiday Day</th>
														</tr>
													</thead>
													<tbody>
														<%
															String d1 = null;
															AllLMSListDAO allListDAO = new AllLMSListDAO();
															List<HolidayBean> listofholiday = allListDAO.getListOfHoliday();
															String day = null;
															for (HolidayBean h : listofholiday) {

																String date = h.getHoliday_date();

																try {

																	SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																	Date result2 = formater1.parse(date);
																	SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
																	d1 = AppDateFormat.format(result2);
																	//System.out.println(d1);
																	//holiday.add(d1);

																	Calendar cal = Calendar.getInstance();
																	cal.setTime(result2);
																	if (result2.getDay() == 0) {
																		System.out.println("SUNDAY");
																		day = "Sunday";
																	} else if (result2.getDay() == 1) {
																		System.out.println("Monday");
																		day = "Monday";
																	} else if (result2.getDay() == 2) {
																		System.out.println("TUESDAY");
																		day = "Tuesday";
																	} else if (result2.getDay() == 3) {
																		System.out.println("WEDNESDAY");
																		day = "Wednesday";
																	} else if (result2.getDay() == 4) {
																		System.out.println("THURSDAY");
																		day = "Thursday";
																	} else if (result2.getDay() == 5) {
																		System.out.println("FRIDAY");
																		day = "Friday";
																	} else if (result2.getDay() == 6) {
																		System.out.println("SATURDAY");
																		day = "Saturday";
																	}

																} catch (ParseException e1) {
																	e1.printStackTrace();
																}
														%>
														<tr>

															<td align="center"><%=d1%></td>
															<td align="center"><%=h.getHoliday_name()%></td>
															<td align="center"><%=day%></td>
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

	<!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
</body>
</html>