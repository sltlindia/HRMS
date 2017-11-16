<%@page import="com.hrms.meetingmanagemnet.dao.AllListMeetingDAO"%>
<%@page import="com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean"%>
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
    <title>Booking History</title>
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
    <%@include file="header.jsp" %>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO(); %>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Meeting History (Grid)</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					
					<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link" id="base-tab" href="meetingBook.jsp" aria-expanded="true">Add Meeting
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="meetingCalenderViewEmployee.jsp" aria-expanded="true">Grid View (History)</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="meetingCalenderViewEmployee.jsp" aria-expanded="true">Calendar View (History)</a>
							</li>
						</ul>
                            <hr>
			<div class="row">
			<div class="col-md-12">
			
			
			<%List<MeetingBookingDetailBean> listOfMeetingByEmpId = allListMeetingDAO.getMeetingsByempId(user.getEmployee_master_id());
			for(MeetingBookingDetailBean meetingBookingDetailBean : listOfMeetingByEmpId){
			%>
				<div class="col-lg-3">
				<div class="card">
					<div class="card-body collapse in">
					<div class="card-block">
						<h4 style="margin-top: 0px;margin-bottom: 0px">
					<a style="cursor: pointer;" data-toggle="modal"
							data-target="#meetingData" onclick="getData(<%=meetingBookingDetailBean.getMeeting_booking_detail_id()%>)"><%=meetingBookingDetailBean.getMeeting_name() %>
							</a></h4>
							<p style="margin-top: 0px;margin-bottom: 0px">
							<%SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa"); 
							SimpleDateFormat yyyymmdd = new SimpleDateFormat("dd/MM/yyyy");
							%>
								<b><%=yyyymmdd.format(meetingBookingDetailBean.getDate())%></b> (<font><b><%=meetingBookingDetailBean.getParticipant_no()%></b></font> Participant(s))
								
							</p>
						
							<p><%=meetingBookingDetailBean.getMeetingRoomDetailBean().getFacility_name()%> 
							<br>(<%=HHmmaa.format(meetingBookingDetailBean.getFrom_time())%> to
								<%=HHmmaa.format(meetingBookingDetailBean.getTo_time())%>)</p>
						</div>
					</div>
				</div>	
				</div>
			<%} %>	
					
			
	</div>
	


<div class="modal fade" id="meetingData" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Meeting Detail</h4>
				</div>
					<div class="modal-body">
						<table class="table">
							<tr>
								<td>Meeting Name</td>
								<td>:</td>
								<td id="name"></td>
							</tr>
							
							<tr>
								<td>Meeting Purpose</td>
								<td>:</td> 
								<td id="purpose" style="white-space: pre-wrap;"></td>
							</tr>
							
							<tr>
								<td>Facility</td>
								<td>:</td>
								<td id="facility"></td>
							</tr>
							
							
							<tr>
								<td>Resource</td>
								<td>:</td>
								<td id="resource"></td>
							</tr>
							
							<tr>
								<td>Participant No</td>
								<td>:</td>
								<td id="no"></td>
							</tr>
							
							<tr>
								<td>Time Period</td>
								<td>:</td>
								<td id="time"></td>
							</tr>
							
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">CLOSE</button>
					</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	</div>
	</section>
	</div>
	</div>
	</div>
<%@include file="footer.html"%>
    <!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
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
    <!-- /build-->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
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
	
<script type="text/javascript">
function getData(id) {
	
	$
	.ajax({
		method : "POST",
		url : 'meetingDataById',
		data : {id:id},
		success : function(data) {
			var json = JSON.parse(data);
			$("#myModalLabel").text(json.meetingName);
			$("#name").text(json.meetingName);
			$("#purpose").text(json.meetingPurpose);
			$("#facility").text(json.facility+" (Capacity : "+json.capacity+" )");
			$("#no").text(json.no);
			$("#time").text(json.from_time+" to "+json.to_time);
			$("#resource").text(json.resources);
			
		}
			
	});
	
}

</script>	

</body>
</html>