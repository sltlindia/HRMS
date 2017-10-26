<%@page import="com.hrms.lms.bean.LeaveCancelRequestBean"%>
<%@page import="com.hrms.lms.controller.LeaveCancelApprovanceServlet"%>
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
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
    <title>Sweet Alerts - Robust Bootstrap Admin Template</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
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
    <!-- END Custom CSS-->
<script type="text/javascript">
function replica(){
	/* alert("akash"); */
	var a = document.getElementById('remarks');
	var b = document.getElementById('remarksReplica');
	
	b.value = a.value;
	
}

function validateForm() {
    var x = document.getElementById("remarks").value;
    if (x == null || x == "") {
        alert("Please fill Reject reason");
        return false;
    }
}

function reject(id){
	
//alert(id);
	
	if(id==1){
		document.getElementById('status').value ="approved"
		}else if(id==2){
			document.getElementById('status').value ="rejected"
		}
}
</script>
</head>
<%@include file="header.jsp" %>
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
 int leave_id = Integer.parseInt(request.getParameter("leave_id"));

AllLMSListDAO allLMSListDAO = new AllLMSListDAO();

LeaveCancelRequestBean leaveCancelRequestBean = allLMSListDAO.getCancelLeaveById(leave_id);


List<LeaveBean> listOfLeave = allLMSListDAO.getLeaveByLeaveId(leave_id);
for(LeaveBean leaveBean : listOfLeave)
{

	
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
					<h3 class="page-header"> Pending Leave</h3>
				</div>
			</div>
			<!-- /.row -->
			
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
						<h4 align="left">
						<div class="row">
								
								<% DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							Date today = Calendar.getInstance().getTime();  
							
							String date1= dateFormat.format(today);
							
							String d = null;
							
							
							try {
								  
								SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
								Date result = formater.parse(date1);
								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
								d = AppDateFormat.format(result);
								System.out.println(AppDateFormat.format(result));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							
							
							%>
							<div class="col-md-6">
							Date :
							<%=d %>
							</div> 
							
							</div>
							</h4>
						</div>
													
						<div class="panel-body">
							<form action="leaveUpdateApprovance" method="get">
								<table class="table table-stripped" border="0">
									<tbody>
									
									
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="2"><%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>
											
										</tr>
									<input type="hidden"  name="leave_id" id="lid" value="<%= leave_id %>">
									<input type="hidden"  name="status" id="status" value="">
									<input type="hidden" name="leave_cancel_id" value="<%=leaveCancelRequestBean.getLeave_cancel_request_id()%>">
											
									</tbody>
									<tr>
									<tbody>
										<td><label>Purpose Of Leave</label></td>
										<td>:</td>
										<td colspan="2">
										<%= leaveBean.getPurpose_of_Leave() %>
										</td>
									<tbody>
									</tr>
									
									</tr>
									<tr>
										<td><label>Leave Applied For</label></td>
										<td>:</td>
										<td ><%= leaveCancelRequestBean.getUpdated_leave_from()%>(From)
										</td>
										
										
										<td>
										<%String half = leaveCancelRequestBean.getUpdated_from_half();
										if(half.equalsIgnoreCase("FF")){
										%>
										Full Day
										<%}else if(half.equalsIgnoreCase("FH")){ %>
										First Half
										<%}else if(half.equalsIgnoreCase("SH")) {%>
										Second Half
										<%} %>
										
									</td>
									</tr>
									<tr>
									<td colspan="2"></td>									
									<td>
											<%= leaveCancelRequestBean.getUpdated_leave_to() %>(To)
											</td>
											<td>
									<%String half1 = leaveCancelRequestBean.getUpdated_to_half();
									if(half1.equalsIgnoreCase("FF")){
									%>
									Full Day
									<%}else if(half1.equalsIgnoreCase("FH")){ %>
									First Half
									<%}else if(half1.equalsIgnoreCase("SH")) {%>
									Second Half
									<%} %>
									
									</br>
									
									<input type="hidden" class="textbox" id="numdays2" name="numdays11" readonly="readonly"/>
									</td>
									<tbody>
									</tr>
									<tr>
									<tbody>
										<td><label> Leave Day Count </label></td>
										<td>:</td>
										<td colspan="2"><%=leaveCancelRequestBean.getUpdated_day_count()%>
								<tbody>
									</tr>
									
									<tr>
									<tbody>
										<td><label>Contact Address </label></td>
										<td>:</td>
										<td colspan="2"><%= leaveBean.getAddress() %></td>
								<tbody>
									</tr>
									<tr>
									<tbody>
										<td><label>Contact Number During Leave</label></td>
										<td>:</td>
										<td colspan="2"><%= leaveBean.getNumber() %></td>
								</tbody>
									</tr>

									<tr>
									</tbody>
							<%} %>
									<tbody>
									<tr>
                                		<td align="center" colspan="4">
                                		
                                		
                                <!-- /.modal-dialog -->
        
	                            
	                            	<input type="hidden" name="action" id="action" value="">
                                			<button class="btn btn-primary" type="submit" value="accept" onclick="reject(1)">Accept</button>
                                			
                                			<input type="submit" class="btn btn-danger" id="reason" type="submit" value="Reject"  onclick="reject(2);"></button>
                                			
                                			
                                			
                                		</td>
                                	</tr> 
								</tbody>
								</table>
							</form>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
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