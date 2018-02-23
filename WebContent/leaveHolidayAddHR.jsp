<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Leave Holiday List</title>
<link rel="shortcut icon" sizes="152x152" href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<%@include file="header.jsp"%>
<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "text")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>

<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#fromDate').datepicker({
            dateFormat: 'dd/mm/yy'
        });
    })
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holiday List</title>
<script type="text/javascript">
		function hideMessage()
		 {
			//document.getElementById("panelbody").style.display="none"; 
			 $('#panelbody').fadeOut('slow');
		 }

			function startTimer()
			 {
					var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
			 }



			function myFunction(id) 
			{
	    		//document.getElementById("demo").innerHTML = "Hello World";
	    		//alert("Akash Patel");
	    		var holiday_id =  document.getElementById("holidayid").value;
	    		
	    		if(holiday_id == "")
		    		{
	        			alert("Please enter the Employee Code");
	        		}
        			else
            			{
            				var yes = confirm("Are You Sure Delete Holiday !");
            				if(yes == true)
                				{
            						window.location.replace("HolidayDeleteHR?holiday_id="+ id);
                				}
            				else
                				{
            						window.location.replace("leaveHolidayAddHR.jsp");
                				}
				    		
	        			}
	    	
			}
		</script>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns"
	onload="startTimer()">
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
										<h3 class="page-header">Holiday List</h3>
									</div>
								</div>
								<%
									if (request.getAttribute("LeaveExist") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-danger">
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
									<div class="alert alert-dismissable alert-danger">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${LeavefromtodateExist}
									</div>
								</div>
								<%
									}
								%>
						<br>
	
		<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Holiday Report</h4>
				                </div>
				            </div>
			 <div class="card-body collapse in">
				<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
											<div class="panel-body">
												<div class="dataTable_wrapper">
													<table
														class="table table-striped table-bordered table-hover">
														<!-- id="dataTables-example" -->
														<thead>
															<tr>
																<th style="text-align: center">Holiday Date</th>
																<th style="text-align: center">Holiday Name</th>
																<th style="text-align: center">Action</th>

															</tr>
														</thead>
														<tbody>
															<%
																String d1 = null;
																AllLMSListDAO allListDAO = new AllLMSListDAO();
																List<HolidayBean> listofholiday = allListDAO.getListOfHoliday();
																for (HolidayBean h : listofholiday) {

																	String date = h.getHoliday_date();

																	try {

																		SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																		Date result2 = formater1.parse(date);
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
																		d1 = AppDateFormat.format(result2);
																		//System.out.println(d1);
																		//holiday.add(d1);

																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}
															%>
															<tr>

																<td align="center"><%=d1%></td>
																<td align="center"><%=h.getHoliday_name()%></td>
																<td align="center">
																	<button type="button" class="btn btn-default"
																		data-toggle="modal"
																		data-target="#myModal<%=h.getHoliday_id()%>">
																		<i class="icon-android-add-circle"></i> Update
																	</button> &nbsp;&nbsp;&nbsp;<i id="holidayid"
																	class=" icon-trash-a"
																	onclick="myFunction(<%=h.getHoliday_id()%>)"></i></a>
																</td>



																<div class="modal fade text-xs-left"
																	id="myModal<%=h.getHoliday_id()%>" tabindex="-1"
																	role="dialog" aria-labelledby="myModalLabel"
																	aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close"
																					data-dismiss="modal" aria-hidden="true">&times;</button>
																				<h4 class="modal-title" id="myModalLabel">
																					Update
																					<%=h.getHoliday_name()%></h4>
																			</div>
																			<div class="modal-body">
																				<form action="HolidayUpdatesHR" method="POST">
																					<input type="hidden" name="holidayID"
																						value="<%=h.getHoliday_id()%>"> <B>
																						Holiday Date : </B> <br> <input type="date"
																						id="datepicker1" width="155" name="fromDate"
																						required value="<%=h.getHoliday_date()%>"
																						class="form-control"><br>
																						
																						 <B>
																						Holiday Name : </B> <textarea class="form-control" name="holidayname"  type="text"  required
																						value="<%=h.getHoliday_name()%>"
																						placeholder="Max 500 words"><%=h.getHoliday_name()%></textarea>
																						<br>
																						
																			</div>
																			<div class="modal-footer">
																				<button type="button" class="btn btn-danger"
																					data-dismiss="modal">CLOSE</button>
																				<input type="submit" class="btn btn-primary"
																					name="button" value="UPDATE">
																			</div>
																			</form>
																		</div>
																		<!-- /.modal-content -->
																	</div>
																	<!-- /.modal-dialog -->
																</div>

															</tr>
															<%
																}
															%>
														</tbody>
														<tbody>
													</table>
												</div>

<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Holidays Add</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
					                					
															<div class="panel-body">

																<div class="table-responsive">
																	<form action="HolidayAddHR" method="POST">
																		<table class="table table-stripped" border="0">
																			<thead>
																				<tr>
																					<td><label>Holiday Date </label></td>
																					<td>:</td>
																					<td><input type="text" id="fromDate"
																						width="155" name="fromDate"
																						placeholder="mm/dd/yyyy" required
																						class="form-control"></td>
																				</tr>
																			</thead>
																			<tr>
																				<td><label>Holiday Name </label></td>
																				<td>:</td>
																				<td><input type="text" name="holidayname"
																					class="form-control" required></td>
																			</tr>
																			<tr>
																				<td colspan="3" align="center">
																					<button class="btn btn-success" id="btnsubmit"
																						type="submit" value="Submit">Add</button>
																				</td>
																			</tr>
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
	<script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.sticky.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script> -->
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