<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
 <%@page import="java.util.Date"%>
 <%@page import="java.text.ParseException"%>
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
   <title>CO Application Form</title>
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
	
<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sweetalert/sweetalert.css">
<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">
<%@include file="header.jsp" %>
 

 
<script type="text/javascript">

function redirect(value) {
	/* alert("test"); */
	window.location.replace(value);
}
</script>


<script src="dist/js/dontBack.js"></script>
<%ArrayList<Date> holidayDate = new ArrayList<Date>();
	ArrayList<String> holiday = new ArrayList<String>();
%>

<%
								AllLMSListDAO allListDAO2 = new AllLMSListDAO();
								List<HolidayBean> listgholiday = allListDAO2.getListOfHoliday();
								for(HolidayBean h : listgholiday)
								{
									/* SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									Date result = formater.parse(h.getHoliday_date());
									System.out.println(result.toString()); */
									
									
									String date = h.getHoliday_date();
									String d1 = null;	
									String d2 = null;
										try {
											  
											SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
											Date result2 = formater1.parse(date);
											SimpleDateFormat AppDateFormat = new SimpleDateFormat("MM/dd/yyyy");
											SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
											d1 = AppDateFormat.format(result2);
											d2 = AppDateFormat1.format(result2);
											//System.out.println("date:"+d1);
											holiday.add(d1);
											holidayDate.add(result2);
										} catch (ParseException e1) {
											e1.printStackTrace();
										}	
									
								}
								%>

<script type="text/javascript">


		var days;
		var y;
		var x;
		var x1;
		var b , y1;

		/* $(function() { */
			/*   $( "#datepicker1" ).datepicker({  maxDate: 0 }); */
			 /*  $("#datepicker1").datepicker({
				    maxDate: 0,
					dateFormat: "dd/mm/yy"
					});
			}); */
		
		/* 
		  var $datepicker1 =  $( "#datepicker1" );
		
		 var fromDate = $datepicker1.datepicker('getDate');
		 alert(fromDate); */
		
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#datepicker1" );
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'dd/mm/yy' ,
				 			 maxDate: 0,
				 			 showAnim: "slide",
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 				<%-- var holiDates = [];
				 			    var disableddates =[];
				 		 		<%for (int i =0; i<holiday.size(); i++)
				 		 		{
				 		 				String date = holiday.get(i);%>
				 		   		  		holiDates[<%=i%>] = new Date("\"<%=date%>\"");
				 		   		<%}%> --%>
				 				 
				 	
				 				 
				 		   	var toDate = $datepicker1.datepicker('getDate');  
				 				var backDate = new Date(toDate);
								 backDate.setDate(backDate.getDate());
								
								 if(backDate.getDay() == 0)
								 {
									 
									 document.getElementById("sunday").value = "YES";
								 }
								 else
									 {
										 document.getElementById("sunday").value = "NO";
									 } 	

							/* 	 
								 var holiDates = [];
								 for (var i = 0; i < holiDates.length; i++) 
					 				{
					 					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
					 					alert("OK");
					 					
					 				} */

								 
								 
								 
								 
				 			 }
				      
				 		});
				 });
		 
		 
function diff()
 {
	
	
	var start = document.getElementById("starttime").value;
	var end =  document.getElementById("endtime").value;
	
	
    
    var s0 = 0;
	var s1 = 0;
	var e0 = 0;
	var e1 = 0;
	
	
    start = start.split(":");
    end = end.split(":");

	
    
  	var start1 = start[1].split(" ");
    var end1 = end[1].split(" ");
    
    s1 = start1[0];
	e1 = end1[0]
  	
	if(start1[1] == 'PM'){
		s0 =  parseInt(start[0]) + 12;
	}else{
		s0 = start[0];
	}
    
	if(end1[1] == 'PM'){
		e0 =  parseInt(end[0]) + 12;
	}else{
		e0 = end[0];
	}
	
	
  
    var startDate = new Date(0, 0, 0, s0, s1, 0);
    var endDate = new Date(0, 0, 0, e0, e1, 0);
    
    var diff = endDate.getTime() - startDate.getTime();
    
    
    var hours = Math.floor(diff / 1000 / 60 / 60);
    diff -= hours * 1000 * 60 * 60;
    var minutes = Math.floor(diff / 1000 / 60);

    //alert(minutes);
    // If using time pickers with 24 hours format, add the below line get exact hours
    if (hours < 0)
       hours = hours + 24;

    document.getElementById("totalhours").value = hours +  "." + minutes;

    
    return (hours <= 9 ? "0" : "") + hours + ":" + (minutes <= 9 ? "0" : "") + minutes;

}


</script>
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
				</script>
				
				
				
<%if(request.getAttribute("success") !=null) {%>
			 <script type="text/javascript">
        function codeAddress() {
        	 swal("SUCCESS!","Successfully Done!","success");
        }
        window.onload = codeAddress;
        </script>
<%}else if(request.getAttribute("LeavefromtodateExist") != null){ %>
			<script type="text/javascript">
        function codeAddress() {
        	 swal("ERROR!","From Date And To Date Already exit!","error");
        }
        window.onload = codeAddress;
        </script>
<%} else if(request.getAttribute("LeaveExist") != null){ %>
 <script type="text/javascript">
        function codeAddress() {
        	 swal("ERROR!","Already Exist!","error");
        }
        window.onload = codeAddress;
        </script>
<%} else if(request.getAttribute("NotEligible") != null){ %>
 <script type="text/javascript">
        function codeAddress() {
        	 swal("ERROR!","You Are Not Eligible For CO!","error");
        }
        window.onload = codeAddress;
        </script>
<%} %>
				
				

</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload = "startTimer()">
<%
int employee_master_id1 = user.getEmployee_master_id();
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
						<h3 class="page-header" align="Center">Compensatory Off Form <br>
					F-HRD-17</h3>
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
				               		<h4 class="card-title" id="horz-layout-basic">Leave / CO / OD Form</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
	
                        <div class="panel-body">
                        
                        
                        <table class="table" style="margin-bottom: 0px;">
                        <thead>
	                        <tr>
								<td width="100px"><label>Select Form</label></td>
								<td width="10px">:</td>
								<td width="200px;">
									<select class="form-control" name="leavetypeselect" id="leavetypeselect" onchange="redirect(this.value);" required>
										<option value="applyleave.jsp">   Leave    </option>
										<option value="leaveCO.jsp" selected="selected">   	 CO       </option>
										<option value="leaveOD.jsp">      OD       </option>
									</select>
								</td>
								<td></td>
								<td></td>
							</tr>
                        </thead>
                        </table>
                        </div>
                    </div>
                </div>
			</div>
			<%-- 
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
          		<%} %> --%>
			<!-- /.row -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000; align="left"">Date :
								<%DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
							
							
							
							%><%=d %></h5>
				                  </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
			
						
						
						<div class="panel-body">
							<form action="LeaveCo" method="post" enctype="multipart/form-data">
								<table class="table table-stripped" border="0">
											
								
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><%=user.getFirstname()+" "+user.getLastname()%>
												<input type="hidden"  name="employee_master_id" value="<%=user.getEmployee_master_id()%>">
										</tr>	
									</tbody>
									<tbody>
										<tr >
											<th><label style="width: 200px">Please briefly describe the need of working on holiday</label></th>
											<td>:</td>
											<td colspan="3"><textarea id="describe" rows="2" width="155" name="describe" placeholder="Enter Description" required class="form-control"></textarea>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker1" width="155" name="fromDate" placeholder="dd/mm/yyyy" required class="form-control">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Start Time</label></th>
											<td>:</td>
											<td colspan="3"><input id="starttime" type="text" class="form-control" name="starttime" placeholder="HH:mm" required/></td>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>End Time</label></th>
											<td>:</td>
											<td colspan="3"><input id="endtime" type="text" class="form-control" name="endtime" onchange="diff()" placeholder="HH:mm" required/></td>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Total Hours Count</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="totalhours" value="" name ="totalhours" placeholder="Click here to get total hours" class="form-control" readonly="readonly" onclick="diff()">
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
									<% 
									AllLMSListDAO allListDAO = new AllLMSListDAO();
									String under_manager_id = user.getUnder_manager_id();
									ManagerBean managerBean =allListDAO.getnameOfManager(under_manager_id);
									%>
										<td><label>Reporting Manager</label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" name="Manager"
											class="form-control" placeholder="Reporting Manager" value="<%=managerBean.getManager_name()%>" required readonly></input>
											<input type="hidden"  name="reportingManager" value="<%=user.getUnder_manager_id()%>">
											</td>
								
									</tr>
								</tbody>
							</tbody>
							<tr>
								<input type="hidden" name="sunday" id="sunday" value="">	
								<input type="hidden" name="redirect">
								<td align="center" colspan="7">
								
										<button class="btn btn-success" id="btnsubmit" type="submit" value="Submit" onclick="diff();">Submit</button>
										
								</td>
								
							</tr>
							<tbody>
							
           
							</table>
							<h3><b><font color="red">Note:</font></b></h3>
								<b>
								<ul>
								<li>0-2 Hours Of Work : NA</li>
								<li>2-4 Hours Of Works : Half CO</li>
								<li>4 Hours & Above : Full CO</li></b>
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
							</section>
							</div>
							</div>
							</div>
							
</body>
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
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
	<script src="bower_components/jquery/dist/jquery.min.js"></script>  
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
<script src="offlinetimepicker/mdtimepicker.js"></script>
  <script src="sweetalert/sweet-alerts.min.js" type="text/javascript"></script>
<script src="sweetalert/sweetalert.min.js" type="text/javascript"></script>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

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
 
   <!--  <script>
	$('#starttime').timepicki();
	$('#endtime').timepicki();
    </script> -->
    
   
    
    
    <!--  END PAGE LEVEL SCRIPTS  -->
</html>