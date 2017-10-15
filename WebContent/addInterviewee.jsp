<%@page import="com.hrms.corehr.dao.AllListCoreHrDAO"%>
<%@page import="com.hrms.corehr.bean.InterviewTrackerDesignationBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.lms.bean.IntervieweeBean"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.Date"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<title>Gate Pass</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
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
	href="app-assets/vendors/css/extensions/sweetalert.css">
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
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/forms/selects/select2.min.css">
	<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
<%@include file="securityHeader.jsp" %>
  
<title>Interview Tracker</title>



<script type="text/javascript">
 
function changeOpenStatus(id) {
	if(id==1){
		document.getElementById('openStatus').value = "intervieweeForm";
	}else if(id==2){
		document.getElementById('openStatus').value = "intervieweeList";
	}
}


function hideMessage()
{
	//document.getElementById("panelbody").style.display="none"; 
	 $('#panelbody').fadeOut('slow');
}

function startTimer()
{
		var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
}

</script>




<script type="text/javascript">
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#date" );
				     var $datepicker2 =  $( "#intervieweeDate" );
				     var $datepicker3 =  $( "#date_of_birth" );
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'dd-mm-yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 			 }
				      
				 		});
				      $datepicker2.datepicker({		
				 			dateFormat: 'dd-mm-yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 			 }
				      
				 		});
				      $datepicker3.datepicker({		
				 			dateFormat: 'dd-mm-yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 			 }
				      
				 		});
				 });
		
</script>





</head>
<body onload = "startTimer()">

<%
String parseCurrDate = "";
String openStatus = "intervieweeForm";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat appFormater = new SimpleDateFormat("dd-MM-yyyy");
Date currDate1 = new Date();
parseCurrDate = simpleDateFormat.format(currDate1);

if(request.getParameter("date") != null){
	parseCurrDate = request.getParameter("date");
}

if(request.getParameter("date1") != null){
	String unparseCurrDate = request.getParameter("date1");
	Date date = appFormater.parse(unparseCurrDate);
	parseCurrDate = simpleDateFormat.format(date);
}

if(request.getParameter("openStatus") != null){
	openStatus = request.getParameter("openStatus");
}

Date date = simpleDateFormat.parse(parseCurrDate);
String parseCurrDate1 = appFormater.format(date);
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
					<h3 class="page-header">Interviewee Detail</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<%if(request.getAttribute("success") !=null){%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success" style="margin-bottom: 0px;">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                            </div>
          		</div>  
          		<%} %>
          		<%if(request.getAttribute("error") !=null){%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger" style="margin-bottom: 0px;">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${error}
                            </div>
          		</div>  
          		<%} %>          

			<br>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                          <ul class="nav nav-tabs">
                            
                             <%if(openStatus.equalsIgnoreCase("intervieweeForm")){ %>
                             
													<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#intervieweeForm"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose" onclick="changeOpenStatus(1)"></i>
															Interviewee Form</a></li>
                              <%}else{ %>
                              	<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#intervieweeForm"
														aria-controls="homeIcon" aria-expanded="false"><i
															class="icon-ios-compose" onclick="changeOpenStatus(1)"></i>
															Interviewee Form</a></li>
                              <%} %>
                                
                                
                               <%if(openStatus.equalsIgnoreCase("intervieweeList")){ %>
                               	<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#intervieweeList"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose" onclick="changeOpenStatus(2)"></i>
															Interviewee List</a></li>
                              <%}else{ %>
                              		  	<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#intervieweeList"
														aria-controls="homeIcon" aria-expanded="false"><i
															class="icon-ios-compose" onclick="changeOpenStatus(2)"></i>
															Interviewee List</a></li>
                              <%} %>
                            </ul>

                            <!-- Tab panes -->
                           	<div class="tab-content px-1 pt-1">
                            
                             <%if(openStatus.equalsIgnoreCase("intervieweeForm")){ %>
                             	<div role="tabpanel" class="tab-pane fade active in"
														id="intervieweeForm" aria-labelledby="homeIcon-tab"
														aria-expanded="true">
                             	<%}else{ %>
                             	<div role="tabpanel" class="tab-pane fade"
														id="intervieweeForm" aria-labelledby="homeIcon-tab"
														aria-expanded="false">
                              	<%} %>
                               
                                   <br>
                                    
                           <form action="intervieweeInsert" method="get">
							<div class="table-responsive">
								<table class="table table-hover">
								
									<tr>
									<th><label>Name</label></th>
									<td>:</td>
									<td><input type="text" class="form-control" name="firstName" value="" placeholder="Enter First Name" required></td>
									<td><input type="text" class="form-control" name="middleName" value="" placeholder="Enter Middle Name" required></td>
									<td><input type="text" class="form-control" name="lastName" value="" placeholder="Enter Last Name" required></td>
									</tr>
									
									
									<tr>
									<th><label>Date Of Birth</label></th>
									<td>:</td>
									<td colspan="5"><input type="text" class="form-control" name="date_of_birth" id="date_of_birth" value="" placeholder="dd-mm-yyyy" required></td>
									</tr>
									
									<tr>
									<th><label>Email Id</label></th>
									<td>:</td>
									<td colspan="5"><input type="text" class="form-control" name="email_id" value="" placeholder="Enter Email Id" required></td>
									</tr>
									
									<tr>
									<th><label>Mobile Number</label></th>
									<td>:</td>
									<td colspan="5"><input type="text" class="form-control" name="mobile_number" value="" placeholder="Enter Mobile Number" required></td>
									</tr>
									
									<tr>
									<th><label>Designation</label></th>
									<td>:</td>
									<td colspan="5">
									<select class="form-control" name="designation" placeholder="Select Designation" required="required">
											<option value=""> --- Select Designation --- </option>
									<%
									AllListDAO allListDAO = new AllListDAO();
									AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();
			  				 		List<InterviewTrackerDesignationBean> listOfInterviewTracker = allListCoreHrDAO.getListOfInterviewDesignation();
			  				 		for(InterviewTrackerDesignationBean i : listOfInterviewTracker){
			  				 		%>
			  				 			 		<option value="<%=i.getInterview_role_type()%>"><%=i.getInterview_role_type()%></option>
			  				 		<%} %>
									</select>
									</td>
									
									</tr>
									
									<%Date interviewDate = new Date(); 
									SimpleDateFormat formater1 = new SimpleDateFormat("dd-MM-yyyy");
									String currDate = formater1.format(interviewDate);
									%>
									
									
									<tr>
									<th><label>Interview Date</label></th>
									<td>:</td>
									<td colspan="5"><input type="text" class="form-control" name="intervieweeDate" id="intervieweeDate" value="<%=currDate %>" placeholder="yyyy-mm-dd" required></td>
									</tr>
									
									<tr>
									<th><label>Location</label></th>
									<td>:</td>
									<td colspan="5"><input type="text" class="form-control" name="interviewee_location" value="" placeholder="Enter Location" required></td>
									</tr>
									
									<tr>
									<th><label>HR Concern Person</label></th>
									<td>:</td>
									<td colspan="5">
										<select class="form-control" name="hr_concern_person" id="hr_concern_person" placeholder="Select HR Concern Person Name" required="required">
											<option value=""> --- Select HR Concern Person Name --- </option>
													<%
														AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
														List<EmployeeBean> listOfHREmployee = allLMSListDAO.getListOfEmployeeByRoleAuthority();
														for (EmployeeBean e : listOfHREmployee) {
															if(e.getManagerBean().getManager_id() != 63){
													%>
														<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname()%></option>
													<%
														}}
													%>
											</select>
									
									
									</tr>
									
								</table>
                           </div>	
							
							<center>
				<input type="submit" value="SUBMIT" class="btn btn-primary">
				<input type="reset" value="RESET" class="btn btn-danger">
			</center>
			<br>
		</form>	
                                    
                                    
                                </div>
                                
                                <%if(openStatus.equalsIgnoreCase("intervieweeList")){ %>
                              		  	<div role="tabpanel" class="tab-pane fade active in"
														id="intervieweeList" aria-labelledby="homeIcon-tab"
														aria-expanded="true">
                             	<%}else{ %>
                              		 <div role="tabpanel" class="tab-pane fade"
														id="intervieweeList" aria-labelledby="homeIcon-tab"
														aria-expanded="false">
                              	<%} %>
                                
                               
                                    <br>
                                    
                                    
                                    <div class="row">
									<form action="addInterviewee.jsp">
									
									<input type="hidden" class="openStatus" name="openStatus" id="openStatus" value="<%=openStatus%>">
										<div class="col-md-2"><h6>Select Date</h6></div>
										<div class="col-md-1">:</div>
										<div class="col-md-3"><input type="text" name="date1" id="date" placeholder="yyyy-mm-dd" value="<%=parseCurrDate1%>" class="form-control"></div>
										<div class="col-md-4"><input type="submit" value="SUBMIT" class="btn btn-primary"></div>
									</form>
									</div>
                                    
                                    <hr>
                                    
                             <div class="dataTable_wrapper">
                             <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover zero-configuration" style="width: 100%;">
                                    <thead>
                                        <tr>
                                            <th>Interviewee Name</th>
                                            <th>Designation</th>
                                            <th>Interview Date</th>
                                            <th>Mobile Number</th>
                                            <th>Location</th>
                                            <th>HR Concern Person</th>
                                            <th>In Time</th>
                                            <th>Out Time</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                   
                                    <tbody>
                                   	<%	List<IntervieweeBean> listOfInterviewee = allLMSListDAO.getListOfInterviewee(parseCurrDate); 
                                   		 for(IntervieweeBean i : listOfInterviewee){
                                   			 
                                   			Date date1 = simpleDateFormat.parse(i.getInterview_date());
                                   			String interview_date = appFormater.format(date1); 
                                   			
                                   			String intervieweeInTime = "-------";
                                   			String intervieweeOutTime = "-------";
                                   			 
                                   			try {
                                    		    final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                                    		    
                                    		    if(i.getInterviewee_in_time() != null){
                                    		    	
                                    		    	String[] split1 = i.getInterviewee_in_time().split(" ");
                                    		   		final String time = split1[1];
                                    		   		final Date dateObj = sdf.parse(time);
                                    		   		intervieweeInTime = new SimpleDateFormat("K:mm a").format(dateObj);
                                    		    }
                                    		    
                                    		    
                                    		    if(!i.getInterviewee_out_time().equalsIgnoreCase("null")){	
                                    		    	String[] split2 = i.getInterviewee_out_time().split(" ");
                                    		   		final String time1 = split2[1];
                                    		   		final Date dateObj1 = sdf.parse(time1);
                                    		   		intervieweeOutTime = new SimpleDateFormat("K:mm a").format(dateObj1);
                                    		    }	 
                                    		    
                                    		    
                                    		    
                                    		} catch (final ParseException e) {
                                    		    e.printStackTrace();
                                    		}	 
                                   			 
                                   		%>	 
                                   		
                                   		<tr>
                                   			<td><%=i.getInterviewee_name()%></td>
                                   			<td><%=i.getDesignation() %></td>
                                   			<td><%=interview_date %></td>
                                   			<td><%=i.getMobile_number() %></td>
                                   			<td><%=i.getInterviewee_location() %></td>
                                   			<td><%=i.getEmployeeBean().getFirstname() +" "+ i.getEmployeeBean().getLastname()%></td>
                                   			<td><%=intervieweeInTime %></td>
                                   			<td><%=intervieweeOutTime%></td>
                                   			<td>
                                   			<%if(i.getInterviewee_out_time() == null || i.getInterviewee_out_time().equalsIgnoreCase("null")){ %>
                                   			
                                   			<a href="intervieweeUpdate?interviewee_id=<%=i.getInterviewee_id()%>&outTimeUpdate=outTimeUpdate&openStatus=intervieweeList"><input type="button" class="btn btn-danger btn-xs" value="OUT"></a>
                                   			<%}else{ %>
                                   				------
                                   			<%} %>
                                   			
                                   			</td>
                                   			
                                   		
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
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
               
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
       <!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
		
	<!-- END PAGE LEVEL JS-->
	<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	
</body>
</html>