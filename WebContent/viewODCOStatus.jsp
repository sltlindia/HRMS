<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
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
   <title>CO / OD Status</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
	<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
<%@include file="header.jsp" %>
<script type="text/javascript">
function deleteCO(id) {
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("coDelete?CO_id="+id);
		}
			else
			{
				window.location.replace("viewODCOStatus.jsp");
				return false;
	 		}
}


function deleteOD(id) {
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("odDelete?OD_id="+id);
		}
			else
			{
				window.location.replace("viewODCOStatus.jsp");
				return false;
	 		}
}
</script>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">
<%
int userId = user.getEmployee_master_id();
%>
<div class="app-content container center-layout mt-2">
<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Status</h1>
			        </div>
			    </div>

<br>

<%if(request.getAttribute("LeaveapprovedSuccessfully") !=null) 
			{	
			%>
			<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveapprovedSuccessfully}
                            </div>
          		</div>  
          		<%}
				else if(request.getAttribute("delete") !=null) {	
				%>
<div id="panelbody" class="panel-body">
                <div class="alert alert-dismissable alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                     ${delete}
                </div>
		</div>  
		<%}%>
          		
      <div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Compensatory Off</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">    	

							<div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="dataTables-exampleCO">
										<thead>
											<tr>
												<th style="text-align:center">Date</th>
												<th style="text-align:center">Start Time </th>
												<th style="text-align:center">End Time </th>
												<th style="text-align:center">Total Hours </th>
												<th style="text-align:center">Total CO Added </th>
												<th style="text-align:center">Status</th>
												<th style="text-align:center">Action</th>
											</tr>
										</thead>
										<%
										AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
										List<LeaveCOBean> co = allLMSListDAO.getCOByEmpId1(userId);
										for(LeaveCOBean c : co)
										{
											
											String _24HourStartTime = c.getStart_time();
											String _24HourEndTime = c.getEnd_time();
											String start = null;
											
											try 
											{
												
												SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result1 = formater1.parse(c.getCO_date());
												SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
												start = formater2.format(result1);
											
											}
											catch (ParseException e1) 
											{
												e1.printStackTrace();
											}	
											
										%>
										
										<tbody>
										<tr align="Center" >
											<td>
													<%= start %>
											</td>
											<td>
													<%= c.getStart_time()%>
											</td>
											<td>
													<%=c.getEnd_time() %>
   						 					</td>	
   						 					<td>
   						 							<%= c.getTotal_Hours() %>
   						 					</td>
   						 					<td>
   						 						<% if(c.getTotal_Hours() > 4) 
   						 							{%>
   						 							 <font color="Red"> 1.0 </font>
   						 							<% }
   						 								else if(c.getTotal_Hours()  > 2 && c.getTotal_Hours() <= 4)
   						 								{%>
   						 								 <font color="Red"> 0.5 </font>
   						 								<%}
   						 									else if(c.getTotal_Hours() <= 2)
   						 									{%>
   						 									<font color="Red"> 0.0 </font>
   						 									<%} %>
   						 					</td>
											<td>
											<%if(c.getStatus().equalsIgnoreCase("Pending")){%>
											<font color="blue">Pending</font>
											<%}else if(c.getStatus().equalsIgnoreCase("approved")){ %>
											<font color="green">Approved</font>
											<%}else if(c.getStatus().equalsIgnoreCase("rejected")){ %>
											<font color="red">Rejected</font>
											<%}else if(c.getStatus().equalsIgnoreCase("cancelled")){ %>
											<font color="orange">Cancelled</font>
											<%}%>
													
											</td>
											<td><%if(c.getStatus().equalsIgnoreCase("pending") || c.getStatus().equalsIgnoreCase("rejected")){%>
											<a href="LeaveCOEmployeeShow?CO_ID=<%=c.getCO_ID()%>&status=Pending"><i class="icon-edit2"></i></a>
											<i class="icon-trash-a" onclick="deleteCO(<%=c.getCO_ID()%>);" style="color: red;"></i>
											<%} %>
											</td>
										</tr>
									
										</tbody>
										<%} %>
								 		</table>
										</div>
										 <h5><b>Legends :&nbsp;</b></h5> <i class="icon-eye4" style="color:#337ab7;"></i><b> : View CO </b> &nbsp;&nbsp;&nbsp;<i class="icon-trash-a" style="color:red;"></i><b> : Cancel CO </b> &nbsp;&nbsp;&nbsp;
                                
										</div>
										</div>	
										</div>
										</div>	
										</div>	
										</div>
										</div>
 				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> OutDoor Duty</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">

							<div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="dataTables-exampleOD">
										<thead>
											<tr>
												<th style="text-align:center">From Date</th>
												<th style="text-align:center">To Date </th>
												<th style="text-align:center">Start Time </th>
												<th style="text-align:center">End Time </th>
												<th style="text-align:center">Total Day </th>
												<th style="text-align:center">Status</th>
												<th style="text-align:center">Action</th>
											</tr>
										</thead>
										<%
										
										List<LeaveODBean> d = allLMSListDAO.getODByEmpId1(userId);
										for(LeaveODBean od : d)
										{
											
											String _24HourStartTime = od.getOD_StartTime();
											String _24HourEndTime = od.getOD_EndTime();
											String start = null;
											String end = null;
											
											try 
											{
												
												SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result1 = formater1.parse(od.getOD_StartDate());
												Date result2 = formater1.parse(od.getOD_EndDate());
												SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
												start = formater2.format(result1);
												end = formater2.format(result2);
											
											}
											catch (ParseException e1) 
											{
												e1.printStackTrace();
											}	
									
										%>
										
										<tbody>
										<tr align="Center" >
											<td>
													<%= start  %>
											</td>
											<td>
													<%=end %>
											</td>
											<td>
													<% if(od.getOD_StartTime() == "")
														{%>
													-----
													<%
														}
													else
														{%>
														<%= od.getOD_StartTime() %>
														<%} %>
   						 					</td>	
											<td>
													<% if(od.getOD_EndTime() == ""){%>
													-----
													<%}else{%>
													<%= od.getOD_EndTime() %>
													<%} %>
   						 					</td>	
   						 					<td>
   						 							<%= od.getOD_TotalDay() %>
   						 					</td>
   						 					
											<td>
													<%if( od.getStatus().equalsIgnoreCase("Pending")){%>
											<font color="blue">Pending</font>
											<%}else if( od.getStatus().equalsIgnoreCase("approved")){ %>
											<font color="green">Approved</font>
											<%}else if( od.getStatus().equalsIgnoreCase("rejected")){ %>
											<font color="red">Rejected</font>
											<%}else if( od.getStatus().equalsIgnoreCase("cancelled")){ %>
											<font color="orange">Cancelled</font>
											<%}%>
											</td>
											<td>
											
											
											<%if(od.getStatus().equalsIgnoreCase("pending")){%>
											<a href="LeaveODEmployeeShow?OD_ID=<%=od.getOD_ID()%>&status=Pending"><i class="icon-edit2"></i></a>
											<i class="icon-trash-a" onclick="deleteOD(<%=od.getOD_ID()%>);" style="color: red;"></i>
											<%} %>
											</td>
										</tr>
									
										</tbody>
										<%} %>
										</table>
										</div>
										 <h5><b>Legends :&nbsp;</b></h5> <i class="icon-eye4" style="color:#337ab7;"></i><b> : View OD </b> &nbsp;&nbsp;&nbsp;<i class="icon-trash-a" style="color:red;"></i><b> : Cancel OD </b> &nbsp;&nbsp;&nbsp;
                                
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
    <script>
    $(document).ready(function() {
    	
        $('#dataTables-exampleOD').DataTable({
                responsive: true, 
                "aSort" : false
        });
        
        $('#dataTables-exampleCO').DataTable({
            responsive: true, 
            "aSort" : false
   		 });
       
        $('#dataTables-exampleLEAVE').DataTable({
            responsive: true,   
            "order": [[ 6, "desc" ]]
   		 });
    });
    
    
    </script>
        
     <!--END PAGE LEVEL SCRIPTS -->
</body>
</html>
