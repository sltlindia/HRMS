<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Over -Time report</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
	
<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sweetalert/sweetalert.css">
<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">

<%@include file="header.jsp"%>
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "date")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>
<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#startDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#endDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>
<script type="text/javascript">
function confSubmit() {
	var startDate = document.getElementById('startDate').value;
	var endDate  = document.getElementById('pndDate').value;
	window.location.replace("overTimeReport?startDate="+startDate+"&endDate="+endDate);
}
</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">

<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			          <h1 class="page-header">Reports</h1>
			        </div>
			    </div>
			<br>


				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Over-Time Report</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
							<%int manager_id = user.getManagerBean().getManager_id(); %>

							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
								<form action="overTimeReport" id="overTimeReport">
								<input type="hidden" name="manager_id" value="<%=manager_id%>">
										<div class="table-responsive">
										<table class="table">
										<tr>
															
															<%if(request.getAttribute("startDate") != null) {%>
															<th><label>Start Date</label></th>
															<td>:</td>
															<td><input type="text"
																class="form-control" name="startDate"
																id="startDate" placeholder="yyyy-mm-dd"
																value="<%=request.getAttribute("startDate")%>" required/></td>
																<th><label>End Date</label></th>
																<td>:</td>
															<td><input type="text"
																class="form-control" name="endDate" placeholder="yyyy-mm-dd"
																id="endDate" value="<%=request.getAttribute("endDate")%>"
																 required /></td>
																<%}else{ %>
																<th><label>Start Date</label></th>
																<td>:</td>
																<td><input type="text"
																class="form-control" name="startDate"
																id="startDate" placeholder="yyyy-mm-dd"
																value="" required /></td>
																<th><label>End Date</label></th>
																<td>:</td>
															<td><input type="text"
																class="form-control" name="endDate" placeholder="yyyy-mm-dd"
																id="endDate" value=""
																 required /></td>
																<%} %>
														</tr>
										</table>
										</div>
										<center><input type="submit" class="btn btn-primary" name="submit" value="SUBMIT"></center>
										</form>
										</div>
										</div>
										<br>
										
										<div class="panel-body">
										<div class="dataTable_wrapper">
										<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
										<tr>
												<th>Employee Name</th>
												<th>Date</th>
												<th>Worked Hours</th>
												<th>Over-Time hours</th>											
												</tr>
										</thead>
										<tbody>
										<%AllListDAO allListDAO = new AllListDAO();
										if(request.getAttribute("listOfOverTimeReport") != null){
										List<Object[]> listOfOverTimeReport = (ArrayList)request.getAttribute("listOfOverTimeReport"); 
										for(Object[] aRow : listOfOverTimeReport) {
											String d = null;
											double workSum = 0;
											double leaveSum = 0;
											String w = null;
											String l = null;
											TimeSheetBean t  = (TimeSheetBean) aRow[0];
											EmployeeBean e = (EmployeeBean) aRow[1];
											String date = t.getDate();
											int employee_master_id1 = t.getEmployeeBean().getEmployee_master_id();
											List<Object[]> listOfSum = allListDAO.getSumOfHours(employee_master_id, date);

											for (Object[] arow : listOfSum) {

												TimeSheetBean t1 = (TimeSheetBean) arow[0];

												workSum = workSum + t1.getWorked_hours();
												leaveSum = leaveSum + t1.getLeave_hours();
												System.out.println("date:" + t.getDate());
												System.out.println("work hour:" + t.getWorked_hours());
												w = String.format("%.2f", workSum);
												l = String.format("%.2f", leaveSum);
											}
											try {
												 
												String date1 = t.getDate();
												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(date1);
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												d = AppDateFormat.format(result);
												System.out.println(AppDateFormat.format(result));
											} catch (ParseException e1) {
												e1.printStackTrace();
											} 
							
									if(workSum > 8){%>
										<tr>
										<td><%=e.getFirstname()+" "+e.getLastname()%></td>
										<td><%=d%></td>
										<td><%=w%></td>
										<td><%=(workSum - 8)%></td>
										<% }%>
										<%}}
										else{%>
										<tr>
										<td colspan="4"> No Data available</td>
										</tr>
										<% } %>
										</tr>
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
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
	<script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
</body>
</body>
</html>