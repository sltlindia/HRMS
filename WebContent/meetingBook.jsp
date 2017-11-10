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
    <title>Book Internal Meeting</title>
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
<%@include file="header.jsp"%> 
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">

<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
<%SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa"); %>
		<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Book Internal Meeting</h1>
			            <hr>
			        </div>
			    </div>
				<!-- /.col-lg-12 -->
			
			<!-- /.row -->
			
			<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="meetingBook.jsp" aria-expanded="true">Add Meeting
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="meetingCalenderViewEmployee.jsp" aria-expanded="true">Calendar View (History)</a>
							</li>
						</ul>
                            <hr>	
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Booking Form</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				            </div>
				            <div class="card-body collapse in">
	               			<div class="card-block">
								
								<form action="" method="post" id="form">
								<div id="table-responsive">
										<table class="table">
										
										
											<tr>
												<th style="padding-left: 0">Name </th>
												<td style="padding-left: 0">:</td>
												<td style="padding-left: 0">
													<%=user.getFirstname()+" "+user.getLastname()%>
												</td>
												
												
												<th style="padding-right: 0">Department </th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<%=user.getDepartmentBean().getDepartment_name()%>
												</td>
											</tr>
											
											
											
											<tr>
												<th style="padding-left: 0">Meeting Name </th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<input type="text"
													class="form-control" name="name" id="name"
													value="" placeholder="max 500 words"
													required>
												</td>
												
												
												
												<th style="padding-right: 0">Meeting Purpose </th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0;width: 40%">
													<textarea
														maxlength="1000" name="purpose" class="form-control"
														id="purpose" placeholder="max 1000 words" required></textarea>
												</td>
												
												
											</tr>
											
											
											<tr>
												<th style="padding-left: 0">Participant No</th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<input type="number"
													class="form-control" placeholder="Eneter Number" name="participant_no" id="participant_no"
													value="" onchange="getFacility(this.value);getTime();"
													required>
												</td>
												
												
												
												<th style="padding-right: 0">Date</th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<input type="text" id="datepicker1"
											 name="date" placeholder="yyyy-mm-dd" required
											class="form-control" required onchange="getTime();">
												</td>
												
												
											</tr>
											
											
											<tr>
												<th style="padding-left: 0">Facility</th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<select class="form-control" id="facilityOption" name="facility" onchange="getTime();">
														<option value="">----SELECT FACILITY---</option>
													</select>
													<br>
													<p class="detailOfFacility"><b>Resources :</b> <font id="rscDetail"></font> <p>
													<p class="detailOfFacility"><b>Capacity :</b> <font id="capacityDetail"></font> <p>
												</td>
												
												
												
												<td colspan="4">
													<table class="table" id="facilityBooking" bordercolor="gray">
															
															<thead>
															<tr style="background-color: #F5F5F5">
																<th colspan="3">Booking Detail</th>
															</tr>
															</thead>
															
															<thead class="thead-inverse">
															<tr>
																<th>Name</th>
																<th>Department</th>
																<th>Time Period</th>
															</tr>
															</thead>
															
															<tbody>
																														
															</tbody>
															
															
															
														</table>
												</td>
												
												
											</tr>
											
											
											<tr>
												<th style="padding-left: 0">From Time</th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<input id="starttime" type="text" class="form-control" name="starttime" value="" placeholder="HH:mm aa" onchange="checkTimePeriod()"/>
												</td>
												
												
												
												<th style="padding-right: 0">To Time</th>
												<td style="padding-left: 0">: </td>
												<td style="padding-left: 0">
													<input id="endtime" type="text" class="form-control" name="endtime" value="" placeholder="HH:mm aa" onchange="checkTimePeriod()"/>
												</td>
												
												
											</tr>
											
											
										
										</table>
										
										</div>	
											</form>
											
											
											<div align="center">
												<input type="reset" value="RESET" class="btn btn-danger">
												<button class="btn btn-primary" onclick="submit();">SUBMIT</button>
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
	  <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
      <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    <script src="app-assets/js/scripts/navs/navs.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/forms/select/form-select2.min.js" type="text/javascript"></script>
    
    <script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	 <script src="offlinetimepicker/mdtimepicker.js"></script>
	<script>
		
			
			$(document).ready(function()
			{
				
				$("#facilityBooking").hide();
				$(".detailOfFacility").hide();
				
				var $datepicker1 =  $( "#datepicker1" );
	         
	   		$datepicker1.datepicker({		
	   			dateFormat: 'yy-mm-dd' , 
	   			 changeMonth: true,
	   		});
				
			});
		
		</script>
		
		
		 <script>
  $(document).ready(function(){
    $('#starttime').mdtimepicker(); //Initializes the time picker
  });
</script>
<script>
  $(document).ready(function(){
    $('#endtime').mdtimepicker(); //Initializes the time picker
  });
</script>

<script type="text/javascript">

function getFacility(value) {
	
	$('#facilityOption').empty();
	$("#facilityBooking").hide();
	
	$
			.ajax({
				method : "POST",
				url : 'meetingData',
				data : {no:value,action:'facility'},
				success : function(data) {
					
					$('#facilityOption').append($('<option>', { 
				        value: 0 ,
				        text : '----SELECT FACILITY---'
				    }));
					
					var json1 = JSON.parse(data);
					$
							.each(
									json1,
									function(i, f) {
										$('#facilityOption').append($('<option>', { 
									        value: f.meeting_room_detail_id ,
									        text : f.facility_name
									    }));
									});
				}
			});
	
}


function getTime() {
	
	var date = $("#datepicker1").val();
	var facilityId = $("#facilityOption").val();
	$("#facilityBooking tbody").empty();
	$(".detailOfFacility").hide();
	
	
	$
			.ajax({
				method : "POST",
				url : 'meetingData',
				data : {date:date,facilityId:facilityId,action:'time'},
				success : function(data) {
					$("#facilityBooking").show();
					if(data == '[]'){
						var tblRow = "<tr><td colspan=\"3\" align=\"center\"><font style=\"color:red\"> All Slots are free for booking <font>"
							+ "</td>"
					$(tblRow).appendTo("#facilityBooking tbody");
					}else{
					var json1 = JSON.parse(data);
					$
							.each(
									json1,
									function(i, f) {
										var tblRow = "<tr><td>"
												+ f.employee_name
												+ "</td><td>"
												+f.departmentName
												+ "</td><td>"
												+ f.from_time +" to  "+f.to_time
												+ "</td>"
												

										$(tblRow).appendTo("#facilityBooking tbody");
									});
				}
				}
					
			});
	
	
	
	$
	.ajax({
		method : "POST",
		url : 'facilityDetail',
		data : {facilityId:facilityId},
		success : function(data) {
			$(".detailOfFacility").show();
			var json = JSON.parse(data);
			$("#rscDetail").text(json.resources);
			$("#capacityDetail").text(json.capacity);
		
		}
			
	});
	
}


function checkTimePeriod(){
	var startTime = $("#starttime").val();
	var endTime = $("#endtime").val();
	
	var date = $("#datepicker1").val();
	var facilityId = $("#facilityOption").val();
	
	var result = true;
	
	if(startTime == ""){
		result = false;
	}
		
	if(endTime == ""){
		result = false;
	}
	
	
	
	if(result == true){
		
		
		$
		.ajax({
			method : "POST",
			url : 'meetingTimeScheduleCheck',
			data : {date:date,facilityId:facilityId,startTime:startTime,endTime:endTime},
			success : function(data) {
				if(data == "fail"){
					
					alert("This Time Period Already taken");
					
					$("#starttime").val("");
					$("#endtime").val("");
				}
			}
				
		});
		
	}
	
	
	
}



function submit(){
	
	var name = $("#name").val();
	var purpose = $("#purpose").val();
	var participant_no = $("#participant_no").val();
	var datepicker1 = $("#datepicker1").val();
	var facilityOption = $("#facilityOption").val();
	var startTime = $("#starttime").val();
	var endTime = $("#endtime").val();
	
	var result = true;
	
	
	if(name == ""){
		alert("Meeting name is required");
		result = false;
	}
	
	if(purpose == ""){
		alert("Meeting Purpose is required");
		result = false;
	}
	
	
	if(participant_no == ""){
		alert("Meeting Participant no is required");
		result = false;
	}
	
	
	if(datepicker1 == ""){
		alert("Date is required");
		result = false;
	}
	
	
	if(facilityOption == ""){
		alert("Room Selection is required");
		result = false;
	}
	
	if(startTime == ""){
		alert("Start time is required");
		result = false;
	}
	
	if(endTime == ""){
		alert("End time is required");
		result = false;
	}
	
	
	
	if(result == true){
		
		$.ajax({
		    method: "POST",
		    url: 'meetingInsert',
		    data: $('#form').serialize(),
		    success: function (data) {
					 window.location.replace("meetingCalenderViewEmployee.jsp");
		    	}
		    	
		    });
		
		}
	
	
	
	
}

</script>



 <script>
  $(document).ready(function(){
    $('#starttime').mdtimepicker(); //Initializes the time picker
  });
</script>
<script>
  $(document).ready(function(){
    $('#endtime').mdtimepicker(); //Initializes the time picker
  });
</script>
    
 <!-- <script src="js/timepicki.js"></script> -->

 
</body>
</html>