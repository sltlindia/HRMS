<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <title>Leave OD Employee Show</title>
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
<script type="text/javascript">

		var days;
		var y;
		var x;
		var x1;
		var b , y1;
/* 
		/* $(function() {
			  $( "#datepicker1" ).datepicker({  maxDate: 0 });
			});  */
		/* $(function() {
			  $( "#datepicker2" ).datepicker({  maxDate: 0 });
			}); */
		
$(document).ready(function()
{
    var $datepicker1 =  $( "#datepicker1" );
    var $datepicker2 =  $( "#datepicker2" );
	 var holiday = [];
     holiday[0] = new Date("08/15/2016");
     holiday[1] = new Date("08/17/2016");
     
     
     
     $datepicker1.datepicker({		
			dateFormat: 'dd/mm/yy' , 
		 	minDate: '-10', 
		 	maxDate: '+2m',
			 changeMonth: true,
			 onSelect: function(dateStr)
			 {
	            $('#datepicker2').datepicker('option', 'defaultDate', dateStr);
	           	$('#datepicker2').datepicker('option', 'minDate', dateStr);
	         	setTimeout(function()
	         			{
	           				 $( "#datepicker2").datepicker('show');
	        			}, 300); 
	        }
		});
		
     	$datepicker2.datepicker({
		    dateFormat: "dd/mm/yy",
		     maxDate: '+2m',
		     changeMonth: true,
		         onClose: function() 
		         {

        	 maxDate: 0 
            var fromDate = $datepicker1.datepicker('getDate');
            var toDate = $datepicker2.datepicker('getDate');
            
			  var f = $.datepicker.formatDate('mm/dd/yy', fromDate);
			  var t = $.datepicker.formatDate('mm/dd/yy', toDate);
				var diff = new Date(toDate - fromDate);
				 days = ((diff/1000/60/60/24) + 1);
			  
			  
			for (var i = 0; i < holiday.length; i++) 
				{
					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiday[i]);
					if((f == f1) || (t == f1))
					{
						//alert("true");
						days = days - 1;
						// alert("For loop " + days);
					}
				}
			
		//alert(days);
		 
		 var SunDay = null;
		 currentDate = new Date(fromDate);
	     var between = [];
	    
	     while (currentDate <= toDate)
		 {
	         between.push(new Date(currentDate));
	         currentDate.setDate(currentDate.getDate() + 1);
	     }

		
	    	 for(var k = 0; k < between.length; k++)
			  {
		    	 var sundayCheck = between[k].getDay();
				if(sundayCheck == 0)
				{
					SunDay++;
				}
			}
		 
			 //alert(SunDay);
			b = days;
			y1 = days;
			y = days - 1;
           // alert(days);
			document.getElementById("numdays2").value = days;
			//alert(holiday[0] + " " + fromDate);
				
        }
    });
});

</script>
<script>

function GetHours()
{

	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	return parseInt ((timeEnd - timeStart)); 
	
} 
function myFunction()
{
	
	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	
	document.getElementById("totalhours").value = GetHours();
	
	
	if(document.getElementById("endtime"))
	{

		var starttime = document.getElementById("starttime").value;
		var endtime =  document.getElementById("endtime").value;
		var timeStart = new Date("01/01/2007 " + starttime).getHours();
		var timeEnd = new Date("01/01/2007 " + endtime).getHours();
		
		if(starttime > endtime)
		{
			document.getElementById("totalhours").value = 0;
			 document.getElementById("endtime").value = 0;	
		}

		
		if(hourDiff < 0)
		{
			 //document.getElementById("totalhours").value = 0;
			// document.getElementById("endtime").value = 0;
			document.getElementById("totalhours").value = GetHours();
		}
		else
			{
				alert("Houre Count" + hourDiff);
			 	document.getElementById("totalhours").value =GetHours();
			}
		//create date format          
	
		
	}    
   
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
int OD_ID = Integer.parseInt(request.getParameter("OD_ID"));

	List<LeaveODBean> listOfOD =(ArrayList)request.getAttribute("listOfOD");

	for(LeaveODBean odBean : listOfOD)
	{
		
		int emp_id = odBean.getEmployeeBean().getEmployee_master_id();
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
					<h3 class="page-header" align="Center"> Outdoor duty slip <br>
					
										F-HRD-18</h3>
					
				</div>
			</div>
			<%if(request.getAttribute("LeaveExist") !=null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveExist}
                            </div>
          		</div>  
          		<%}
			else if(request.getAttribute("LeaveSuccessfully") !=null) 
			{	
			%>
			<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveSuccessfully}
                            </div>
          		</div>  
          		<%}
			else if(request.getAttribute("LeavefromtodateExist") !=null) 
				{	
          		%>
          		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeavefromtodateExist}
                            </div>
          		</div>
          		<%} %>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4 align="left">
								Date :
								<%
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
								Date today = Calendar.getInstance().getTime();  
							
								String date1= dateFormat.format(today);
							
								String d = null;
								String start = null;
								String end = null;
							
							
							try {
								  
								SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
								Date result = formater.parse(date1);
								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
								d = AppDateFormat.format(result);
								System.out.println(AppDateFormat.format(result));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							
							try 
							{
								
								SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
								Date result1 = formater1.parse(odBean.getOD_StartDate());
								Date result2 = formater1.parse(odBean.getOD_EndDate());
								SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
								start = formater2.format(result1);
								end = formater2.format(result2);
							
							}
							catch (ParseException e1) 
							{
								e1.printStackTrace();
							}	
							
							%><%=d %></h4>

						</div>
						
						
						<div class="panel-body">
							<form action="EmployeeODUpdate" method="post" enctype="multipart/form-data">
								<table class="table table-stripped" border="0">
								<%if(odBean.getStatus().equals("rejected") || (odBean.getStatus().equals("Pending"))){ %>		
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" name="Empname"
											class="form-control" value="<%= odBean.getEmployeeBean().getFirstname() %> <%= odBean.getEmployeeBean().getLastname() %>" required></input>
											<input type="hidden"  name="OD_Id" id="lid" value="<%= OD_ID %>">
											<input type="hidden"  name="employee_master_id" id="lid" value="<%= emp_id %>">
											
										</tr>	
									</tbody>
									<tbody>
										<tr >
											<th><label style="width: 200px">Please briefly describe the need of working on out station / outdoor</label></th>
											<td>:</td>
											<td colspan="3"><textarea id="describe" rows="2" width="155" name="describe" placeholder="Enter Description" required class="form-control"><%=odBean.getDescription() %></textarea>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>From Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker1" width="155" name="StartDate" required class="form-control" value="<%=start%>">
										</tr>	
									</tbody>
									
									<tbody>
									<tr>
											<th><label>To Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker2" width="155" name="EndDate"  required class="form-control" value="<%=end%>"></td>
									</tr>
									</tbody>
									<tbody>
										<tr>
											<th><label>Start Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="starttime" name="starttime" class="form-control" value="<%= odBean.getOD_StartTime()%>">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>End Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="endtime" name="endtime" class="form-control" value="<%= odBean.getOD_EndTime()%>">
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
										<td><label>Total Day Count </label></td>
										<td>:</td>
										<td colspan="3"><input type="text" class="form-control"	rows="3" id="numdays2" name="numdays" required readonly value="<%= odBean.getOD_TotalDay()%>"></input>
								
									</tr>
									</tbody>
							</tbody>
						
							<tbody>
								<%if(odBean.getStatus().equals("rejected") || (odBean.getStatus().equals("Pending"))){ %>
									<tr>
                                		<td align="center" colspan="4">
                                		
                                		
                                <!-- /.modal-dialog -->
        
	                            <input type="hidden" name="action" id="action" value="">
	                            	<input type="hidden" name="redirect">
                                			<button class="btn btn-success btn-lg" type="submit" value="accept" onclick="reject(1)">Update</button>
                                		</td>
                                	</tr>
                                	 <%if (odBean.getStatus().equals("Pending")){ %>
                                	 
                                        <%} else
                                        	{%>
                                        	<tr>
                                	<td colspan="4">
                                	<div class="form-group has-error">
                                            <label class="control-label" for="remarks">Reject Reason / Remarks</label>
                                            <input type="text" class="form-control" value="<%=odBean.getReason()%>"  id="remarks" name="remarks" oninput="replica()" >
                                        </div>
                                        </td> 
                                        </tr> 
                                        <%} %> 
                             <%} %>
								</tbody>
							<input type="hidden"  name="status" id="status" value="">
							
							<%}else{ %>
							
								<tbody>
										<tr>
											<th><font size="2px">Employee Name</font></th>
											<td>:</td>
											<td colspan="3"><font size="2px"><%= odBean.getEmployeeBean().getFirstname() %> <%= odBean.getEmployeeBean().getLastname() %></font>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><font size="2px">From Date</font></th>
											<td>:</td>
											<td colspan="3"><font size="2px"><%=start%></font>
										</tr>	
									</tbody>
									<tbody>
									<tr>
											<th><font size="2px">To Date</font></th>
											<td>:</td>
											<td colspan="3"><font size="2px"><%=end%></font>
									</tr>
									</tbody>
									<tbody>
										<tr>
											<th><font size="2px">Start Time</font></th>
											<td>:</td>
											<td colspan="3"><font size="2px"><%= odBean.getOD_StartTime()%></font>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><font size="2px">End Time</font></th>
											<td>:</td>
											<td colspan="3"><font size="2px"><%= odBean.getOD_EndTime()%></font>
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
										<th><font size="2px"><font size="2px">Total Day Count </font></th>
										<td>:</td>
										<td colspan="3"><font size="2px"><%= odBean.getOD_TotalDay()%></font>
								
									</tr>
									</tbody>
						
							<%} %>
							<%} %>
								
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
				</section>
				</div>
				</div>
				</div>
							
		<%@include file="footer.html"%>		
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
</html>
</body>