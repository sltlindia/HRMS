<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
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
    <title>Leave Update After Approve</title>
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
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script></script>
<title>Insert title here</title>
<script type="text/javascript">
	var y;
	var x;
	var x1;
	var b;
	var y1;
	var days;

</script>
		<script type="text/javascript">
			
				function myFunction() 
				{
					
					var lid = document.getElementById("lid").value
					var temp = document.getElementById("daycount").value
					if(temp == 0)
			    		{
							var yes = confirm("Are You Sure  !  \n\nYou Want Cancelled Leave ?");
			    			if(yes == true)
			    				{
			    					document.getElementById("temp").submit();
			    				}
			    				else
			    					{
			    						window.location.replace("Myleave?leave_id=" + lid);
			    					}
			    		}
					else
			    		{
							document.getElementById("temp").submit();
			    		}
				}
				
				
				function radioCheck(id){
					alert(id);
					
					document.getElementById(id).checked = true;
					
				}
			
	</script>
<%@include file="header.jsp" %>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
int monthid = 0;
double qwe = 0;
String status = null;
 int leave_id = Integer.parseInt(request.getParameter("leave_id"));
String fromDate = null;
String toDate = null;
System.out.println("Leaved Id" + leave_id);
AllLMSListDAO allListDAO = new AllLMSListDAO(); 
ArrayList<String> holiday = new ArrayList<String>();
ArrayList<String> holidayDate = new ArrayList<String>();
List<LeaveBean> listOfLeave = (ArrayList)request.getAttribute("listOfLeave");
for(LeaveBean leaveBean : listOfLeave)
{
	status = leaveBean.getStatus();
	try {
		  
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		Date result = formater.parse(leaveBean.getLeave_From());
		Date result1 = formater.parse(leaveBean.getLeave_To());
		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = AppDateFormat.format(result);
		toDate = AppDateFormat.format(result1);
		System.out.println(AppDateFormat.format(result));
		
		
		
	} catch (ParseException e1) {
		e1.printStackTrace();
	}	
	
	
	
	Date date = new Date();
	
	String Leave_From = leaveBean.getLeave_From();
	String Leave_To = leaveBean.getLeave_To();
	Date r1 = null;
	Date r2 = null;
	
	try 
	{
		SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
		r1 = formater1.parse(Leave_From);
		r2 = formater1.parse(Leave_To);
		SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
		Leave_From = formater2.format(r1);
		Leave_To = formater2.format(r2);
		System.out.println("Leave From Date " + Leave_From);
		System.out.println("Leave TO Date " + Leave_To);
	}
	catch (ParseException e1) 
	{
		e1.printStackTrace();
	}	
%>


<script type="text/javascript">
        window.onload = function() 
        {            
         	
        	<%
        		qwe = leaveBean.getDay_count();
        	%>
        	
        	<%-- x = <%= qwe %>
			y1 = <%= qwe %>
			y = <%= qwe - 1 %>
			b = x;
            days = x; --%>
            
            
            if(days == 1 || days == 0.5)
			{
				 // document.getElementById('3').checked = false;
				  $('#radiobutton1').fadeOut('slow');
				  $('#radiobutton2').fadeIn('slow');
				  
			}
			else
				{
					document.getElementById('0').checked = true;
					$('#radiobutton1').fadeIn('slow');
					$('#radiobutton2').fadeIn('slow');
				}	
            
			
			
        }
        </script>
     <div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
						<div class="card-block">
							<div class="form-body">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"> My Leave</h3>	
				</div>
			</div>
			<br>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic" align="left">
								Date :
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
							 <%= d %> </h4>

						  </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
													
						<div class="panel-body">
							
							<form action="leaveUpdateForApprovance" method="get">
								<table class="table table-stripped" border="0">
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" name=""
											class="form-control" value="<%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>" required></input>
											
										</tr>
										<tbody>
									 <input type="hidden"  name="leaveid" id="lid" value="<%= leave_id %>">
									<input type="hidden"  name="status" id="status" value="">
									<input type="hidden"  name="empcode"  value="<%= leaveBean.getEmployeeBean().getEmployee_master_id()%>">
									<input type="hidden"  name="pastFromDate"  value="<%= leaveBean.getLeave_From()%>">
									<input type="hidden"  name="pastToDate"  value="<%= leaveBean.getLeave_To()%>">
				
									 <%
											 AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
												List<LeavecutBalance> l =(ArrayList) allListDAO.getListOfAdjustLeave(leave_id);
											
											for (LeavecutBalance c : l)	
   						 					{
											%>
											<input type="hidden"  name="CO" id="CO" value="<%= c.getMain_CO()%>">
											<input type="hidden"  name="plan" id="plan" value="<%= c.getMain_PL()%>">
											<input type="hidden"  name="unplan" id="unplan" value="<%=c.getMain_SL()%>"/>
											<input type="hidden"  name="LWP" id="LWP" value="<%= c.getMain_LWP()%>"/>
											<% }%>
											
											
											<input type="hidden"  name="CO1" id="CO1" value="<%= leaveBean.getCO()%>"/>
											<input type="hidden"  name="PL1" id="PL1" value="<%= leaveBean.getPL()%>">
											<input type="hidden"  name="SL1" id=SL1 value="<%=leaveBean.getSL()%>">
											<input type="hidden"  name="LWP1" id="LWP1" value="<%= leaveBean.getLWP()%>">
											
											<input type="hidden"  name="LeaveType" id="LeaveType" value="<%= leaveBean.getLeaveType_ID()%>">
											<input type="hidden"  name="MainStatus" id="MainStatus" value="<%= leaveBean.getStatus()%>">
											
											
											
											
											<input type="hidden"  name="pushMainDate" id="pushMainDate" value="">
											<input type="hidden"  name="popMainDate" id="popMainDate" value="">
											<input type="hidden"  name="BackwordSunday" id=BackwordSunday value="">
											<input type="hidden"  name="totalDays" value="<%=leaveBean.getDay_count()%>">
											<input type="hidden"  name="leaveFromPast" value="<%=leaveBean.getFrom_half()%>">
											<input type="hidden"  name="leaveToPast" value="<%=leaveBean.getTo_half()%>">
									
		
									
									<tbody>
									<tr>
									
										<td><label>Purpose Of Leave</label></td>
										<td>:</td>
										<td colspan="3"><input type="text" name="purposeofleave"
											class="form-control" value="<%= leaveBean.getPurpose_of_Leave() %>" required></input>
									
									</tr>
									</tbody>
									
									<tbody>
									<tr>
										<td><label>Leave Applied For</label></td>
										<td>:</td>
										<%
										
										String abc = leaveBean.getLeave_From();
										String def = leaveBean.getLeave_To();
										String FROM	 = null;	
										String TO = null;
											try {
												  
												SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(abc);
												Date result3 = formater1.parse(def);
												monthid = result2.getMonth() + 1;
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("MM/dd/yyyy");
												SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
												
												FROM = AppDateFormat1.format(result2);
												TO = AppDateFormat1.format(result3);
												//System.out.println("date:"+d1);
												
											} catch (ParseException e1) {
												e1.printStackTrace();
											}	
										%>
										
										
										<td colspan="2">From Date: <input type="text" id="datepicker1" width="155" name="fromDate" required class="form-control" value="<%= FROM %>" onselect="radioCheck(7);"><!-- From<input type="date" id="pick_date"   name="fromDate"
											 placeholder="yyyy-MM-dd" class="form-control" onchange="cal()"
											style="width: 160px;" required /> -->
											
										
										</td>
						
										<td>
										<div id="radiobutton1">
									<%String half = leaveBean.getFrom_half();
										if(half.equalsIgnoreCase("FF")){
										%>
										<input id="7" type="radio" name="leavefromDate" value="FF" onchange="check();" checked="checked">Full Day
									<input id="1" type="radio" name="leavefromDate" onchange="check();" value="FH">First Half
									<input id="2" type="radio" name="leavefromDate" onchange="check();" value="SH">Second Half
										<%}else if(half.equalsIgnoreCase("FH")){ %>
										<input id="7" type="radio" name="leavefromDate" onchange="check();" value="FF">Full Day
										<input id="1" type="radio" name="leavefromDate" onchange="check();" value="FH" checked="checked">First Half
										<input id="2" type="radio" name="leavefromDate" onchange="check();"  value="SH">Second Half
										<%}else if(half.equalsIgnoreCase("SH")) {%>
										<input id="7" type="radio" name="leavefromDate" onchange="check();"  value="FF">Full Day
										<input id="1" type="radio" name="leavefromDate" onchange="check();"  value="FH">First Half
										<input id="2" type="radio" name="leavefromDate" onchange="check();"  value="SH" checked="checked">Second Half
									<%} %>
									</div>
									</td>
									</tr>
									</tbody>
									<tbody>
									<tr>
									<td colspan="2"></td>									
									<td colspan="2">
													To Date: <input type="text" id="datepicker2" class="form-control" name="toDate"  required value="<%= TO %>" onselect="radioCheck(3);">
											<!-- To<input id="drop_date"  type="date"
											name="toDate" onchange="cal()" placeholder="yyyy-MM-dd" style="width: 160px;"
											class="form-control" required /> -->
											
											<p></p>

											</td>
											<td>
											<div id="radiobutton2">
										<%String half1 = leaveBean.getTo_half();
										if(half1.equalsIgnoreCase("FF")){
										%>
										<input id="3" type="radio" name="leavetoDate" value="FF" onchange="check();"  checked="checked">Full Day
									<input id="4" type="radio" name="leavetoDate" value="FH" onchange="check();">First Half
									<input id="5" type="radio" name="leavetoDate" value="SH" onchange="check();">Second Half
										<%}else if(half1.equalsIgnoreCase("FH")){ %>
										<input id="3" type="radio" name="leavetoDate" value="FF" onchange="check();">Full Day
									<input id="4" type="radio" name="leavetoDate" value="FH"checked="checked" onchange="check();">First Half
									<input id="5" type="radio" name="leavetoDate" value="SH" onchange="check();">Second Half
										<%}else if(half1.equalsIgnoreCase("SH")) {%>
										<input id="3" type="radio" name="leavetoDate" value="FF" onchange="check();">Full Day
										<input id="4" type="radio" name="leavetoDate" value="FH" onchange="check();">First Half
										<input id="5" type="radio" name="leavetoDate" value="SH" checked="checked" onchange="check();">Second Half
										<%} %>
								
									
									</br>
									
											
											<input type="hidden" class="textbox" id="numdays2" name="status" value="<% leaveBean.getStatus(); %>"/>
											<input type="hidden"  name="monthID" id="monthID" value="<%=monthid%>"/>
									</div>
									</td>
									
									</tr>
									</tbody>
								<tbody>
								
								
									<tr>
									
										<td><label> Leave Day Count </label></td>
										<td>:</td>
										<td colspan="3">
										<input type="text" class="form-control"
												rows="3" id="daycount" name="daycount" value="<%= leaveBean.getDay_count() %>" required readonly></input>
										
										<%-- <input type="text" class="form-control" name="numdays"
												rows="2" id="numdays2"  value="<%= leaveBean.getDay_count() %>" required></input> --%>
												</td>
												<input type="hidden" class="textbox" id="Mainday" name="Mainday" value="<%= leaveBean.getDay_count() %>"/>
									</tr>
									</tbody>
									<tbody>
									
									<tbody>
									<tr>
										<td><label>Contact Address </label></td>
										<td>:</td>
										<td colspan="3"><input type="text" name="contactAddress"
											class="form-control" value="<%= leaveBean.getAddress() %>" required></input>
											</td>
								
									</tr>
									</tbody>
									<tbody>
									
									<tbody>
									<tr>
										<td><label>Contact Number During Leave</label></td>
										<td>:</td>
										<td colspan="3"><input type="text" name="contactNumberDuringLeave"
											class="form-control" value="<%= leaveBean.getNumber() %>" required></input></td>
								</tr>
								<tbody>
								
								 <tr>
                                		<td><label>Reason for update</label></td>
										<td>:</td>
                                         <td colspan="3"><input type="text" class="form-control"  id="remarks" name="reason" required>
                                        </td> 
                                        </tr>
							
								
								<tr align="center">
								<td colspan="5">
                                			<input type="submit" name="submit" class="btn btn-success" value="UPDATE">
                                			</td>
                                			</tr>
								
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
</div>
</section>
</div>
</div>
</div>
<script type="text/javascript">
  
$(document).ready(function()
		{
		    var $datepicker1 =  $( "#datepicker1" );
		    var $datepicker2 =  $( "#datepicker2" );
		    
			
		    /* $("#datepicker1").datepicker({  dateFormat: 'dd/mm/yy'});
	    	$("#datepicker2").datepicker({ dateFormat: 'dd/mm/yy' }); */
		  var holiDates = [];
	    var disableddates =[];
 		<%for (int i =0; i<holiday.size(); i++)
 		{
 				String date = holiday.get(i);%>
   		  		holiDates[<%=i%>] = new Date("\"<%=date%>\"");
   		  <%}%>
  
   		 /*  holiDates[1] = new Date("01/26/2016");
   		  holiDates[2] = new Date("03/23/2016");
   		  holiDates[3] = new Date("08/15/2016");
   		  holiDates[4] = new Date("08/18/2016");
   		  holiDates[5] = new Date("08/25/2016");
   		  holiDates[6] = new Date("08/26/2016");
   		  holiDates[7] = new Date("10/11/2016");
   		  holiDates[8] = new Date("10/29/2016");
   		  holiDates[9] = new Date("10/30/2016");
   		  holiDates[10] = new Date("10/31/2016");
   		  holiDates[11] = new Date("11/01/2016");
   		  holiDates[12] = new Date("11/02/2016");
   		  holiDates[14] = new Date("11/03/2016");
   		  holiDates[15] = new Date("11/04/2016");
   		 /*  holiDates[16] = new Date("09/01/2016");
   		  holiDates[17] = new Date("09/01/2016"); */
   		
   		var daysToDisable = [0];
   	 	<%for (int z =0; z<holidayDate.size(); z++)
 		{
 				String datedate = holidayDate.get(z);%>
 				disableddates.push("<%=datedate%>");
   		  <%}%>
   		  
   		  
   		  
   		  <% int role_id = user.getDepartmentBean().getDepartment_id();
   		  if(role_id == 1)
   		  {
			%>
			   		function noSundaynoHoliday(date)
			   		{
			   			// SUNDAY DISABLE //
			   		    var day = date.getDay();
			   		    if ($.inArray(day, daysToDisable) != -1) {
			   		        return [false];
			   		    } 
			
			   				// HOLIDAYS DISABLE //
			   			 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
			   				if(disableddates.indexOf(string) != -1)
			   				{
			   					 return [false];
			   				} 
			   		   
			   			// 1ND AND 3TH SAT DISABLE //
			   				 var day = date.getDay(),
			   		        week = Math.floor(date.getDate() / 7);
			   				if(day == 6 && (week == 0 || week == 2))
			   				{
			   					return [false];
			   				} 
			   		    //return day == 6 && (week == 1 || week == 3)
					
			   		    return [true]
			   		}
   		<%
   		}
   		  else
   		  {
   		%>
   		function noSundaynoHoliday(date)
   		{
   			// SUNDAY DISABLE //
   		    var day = date.getDay();
   		    if ($.inArray(day, daysToDisable) != -1) {
   		        return [false];
   		    } 

   				// HOLIDAYS DISABLE //
   			 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
   				if(disableddates.indexOf(string) != -1)
   				{
   					 return [false];
   				} 
   		   
   			// 2ND AND 4TH SAT DISABLE //
   				/* var day = date.getDay(),
   		        week = Math.floor(date.getDate() / 7);
   				if(day == 6 && (week == 1 || week == 3))
   				{
   					return [false];
   				} */
   		    //return day == 6 && (week == 1 || week == 3)
				 	
   		    return [true]
   		}
   		
   		  <%}%>
   		  
   	
   		  
   		  
   		function noSunday(date){ 
            return [date.getDay() != 0, ''];
         }; 
   		  
         $datepicker1.datepicker({		
    			dateFormat: 'dd/mm/yy' , 
    		 	minDate: '<%=fromDate%>', 
    		 	maxDate: '<%=toDate%>',
    			beforeShowDay: noSundaynoHoliday,
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
 		    minDate: '<%=fromDate%>', 
		 	maxDate: '<%=toDate%>',
 		     beforeShowDay: noSundaynoHoliday,
 		     changeMonth: true,
 		         onClose: function() 
 		         {
 		        	
 		
		        	 
		           	var firstCheck = false;
		            var lastCheck = false;   
		        	var fromDate = $datepicker1.datepicker('getDate');
		            var toDate = $datepicker2.datepicker('getDate'); 
		            var sundayCheker = $datepicker2.datepicker('getDate');
		             
		 		    var f = $.datepicker.formatDate('mm/dd/yy', fromDate);
		 			var t = $.datepicker.formatDate('mm/dd/yy', toDate);

		 			var f1 = $.datepicker.formatDate('dd/mm/yy', fromDate);
		 			var t1 = $.datepicker.formatDate('dd/mm/yy', toDate);
		 			
		 			var diff = new Date(toDate - fromDate);
		            days = ((diff/1000/60/60/24) + 1);
		 			    
					 
		            	var monthID = fromDate.getMonth() + 1;
			           //alert(monthID);
			           document.getElementById("monthID").value = monthID;
		            
		            
		       
		 			for (var i = 0; i < holiDates.length; i++) 
		 				{
		 					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
		 					
		 					if((f == f1) || (t == f1))
		 					{
		 						if(f == f1)
			 					{
		 							alert(f + " Is Already Public Holiday");
		 							firstCheck = true;
				 				}
		 						else if(t == f1)
			 						{
		 								alert(t + " Is Already Public Holiday");
		 								lastCheck = true;
		 								/* sundayCheker.setDate(sundayCheker.getDate() - 1);
			 			               	if(sundayCheker.getDay() == 0)
				 			               {
						 						days = days - 1;
						 						alert("sunday");
				 			               }  */
			 						}
		 						 
									  
		 					}
		 				}

					// more Then Date Select
					if(toDate < fromDate)
					{
						alert("Date More Then Select");
						document.getElementById("datepicker2").value = "";
						document.getElementById("daycount").value = 0;
					}
					else
						{
							document.getElementById("daycount").value  = days;
						}

					
					 currentDate = new Date(fromDate);
				     var between = [];
				    
				     while (currentDate <= toDate)
					 {
				         between.push(new Date(currentDate));
				         currentDate.setDate(currentDate.getDate() + 1);
				     }

					
				     // Pre Working Day
				     popDate = new Date(fromDate);
				     var between1 = [];
				     while (popDate >= fromDate)
					 {
				         between1.push(new Date(popDate));
				         popDate.setDate(popDate.getDate() - 1);
				         if(popDate.getDay() == 0)
				        	{
				        		
				        		popDate.setDate(popDate.getDate() - 1);
				        		document.getElementById("BackwordSunday").value = "Y";
				        	}
				         else
				        	 {
				        		 document.getElementById("BackwordSunday").value = "N";
				        	 }
				     }
				     
				     var popMainDate = $.datepicker.formatDate('dd/mm/yy', popDate);
				     document.getElementById("popMainDate").value = popMainDate;
				     
				     // Next Working Day
				     pushDate = new Date(toDate);
				     var between = [];
				     var SunDay = null;
				     while (pushDate <= toDate)
					 {
				         between.push(new Date(pushDate));
				         pushDate.setDate(pushDate.getDate() + 1);
				         if(pushDate.getDay() == 0)
				        	{
				        		pushDate.setDate(pushDate.getDate() + 1);
				        		document.getElementById("BackwordSunday").value = "Y";
				        	}
				         else
				        	 {
				        		 document.getElementById("BackwordSunday").value = "N";
				        	 }
				     }
				     
				     var pushMainDate = $.datepicker.formatDate('dd/mm/yy', pushDate);
				     	document.getElementById("pushMainDate").value = pushMainDate;
				     	
				     
				     
						var firstWorkingDay = null;
						var lastWorkingDay = null;
					
				    	 for(var k = 0; k < between.length; k++)
						  {
					    	 var k2 = $.datepicker.formatDate('mm/dd/yy', between[k]);
					    	 var sundayCheck = between[k].getDay();
					    	 var k21 = between[k];
					    	 var flag = false;
					    	 for(var l = 0; l < holiDates.length; l++)
								{
									 holiday = holiDates[l].getDay();
								     var l2 = $.datepicker.formatDate('mm/dd/yy', holiDates[l]);
									
								 	 if(k2 == l2)
									 {
										flag = true;
									 }
							}

							if(flag == false)
							{
									if(firstWorkingDay == null)
									{
										if(sundayCheck != 0)
										{
											firstWorkingDay = k21
										}
									}
									else
										{
											if(sundayCheck != 0)
											{
												lastWorkingDay = k21;
											}
										}
								}
						}
			 
			 		  var paidCount = 0;
			 		 

					if(firstWorkingDay != null && lastWorkingDay !=null){
						
						var  fWork =firstWorkingDay;
						var  lWork = lastWorkingDay;
						
						var diff = new Date(lWork - fWork);
		               	var finalLeaveDays = ((diff/1000/60/60/24) + 1);
						days = finalLeaveDays;

	               	
						}
						else
							{
							       for(var j = 0; j < holiDates.length; j++)
									{
											holiday = holiDates[j].getDay();
										 	var f2 = $.datepicker.formatDate('mm/dd/yy', holiDates[j]);
											if(firstCheck == false && lastCheck == false )
											{
											
											}
											else
												{
							    		   		 	if((f2 > f && f2 < t))
							        		   		{   		
															days = days - 1;
							    		      			 	 paidCount++;	
							        		   		}
								    		   		 if(f2 == f)
									    		   		{
									    		   			paidCount++;
									    		   			days = days - 1;
								    		   				
									    		   		 }	
								    		   		 		else if(f2 == t)
										    		   		{
										    		   			sundayCheker.setDate(sundayCheker.getDate() - 1);
										    		   			if(sundayCheker.getDay() == 0)
										 			               {
												 						days = days - 1;
										 			               } 
				
						 			              					 paidCount++;
							    		   							 days = days - 1;
							    		   					 }			 	   		 
												}
						    		   		 
								   		}
 
								}
			      
				
					if( lastCheck == false )
					{
						sundayCheker.setDate(sundayCheker.getDate());
		               	if(sundayCheker.getDay() == 0)
			               {
		 						days = days - 1;
		 						
			               } 
					}

					
					
						x = days;
						y1 = days;
						y = days - 1;
						b = x;
						
						
						//alert(x + " " + y1 + " " + y + " " + b);
						
			      //  document.getElementById("numdays4").value  = paidCount; 
			        document.getElementById("daycount").value  = days;	

			        if(days == 1)
					{
						 // document.getElementById('3').checked = false;
						  $('#radiobutton1').fadeOut('slow');
						  $('#radiobutton2').fadeIn('slow');
						  
					}
					else
						{
							document.getElementById('7').checked = true;
							$('#radiobutton1').fadeIn('slow');
							$('#radiobutton2').fadeIn('slow');
						}	
			        
			        
		      	 // check();
		        }
		    });
		});



  function check()
  {
  	var radios = document.getElementsByName("leavefromDate");
  	var radios1 = document.getElementsByName("leavetoDate");
  	
  	
  	if( x == null){
			alert("Please select date again...");
			
			var id = document.getElementById('lid').value;
			window.location.replace("Myleave?leave_id="+id+"&status=approved&action=afterApprove");
			
		}else{
  	
  	 for( i = 0; i < 3; i++ )
  	{ 
  		//alert(x + " " + y1 + " " + y + " " + b);
  		
  		if( radios[i].checked || radios1[i].checked)
  		{
  			if((radios[i].id == 7) || (radios1[i].id == 3))
  			{
  				
  				
  				if(y1 == days)
  				{
  					x = y1;		
  				}
  				else
  				{
  					//alert("first else cell" + b);
  						b = y1 + 0.5;
  						x = b;				
  				}
  				
  			}
  			else if((radios[i].id == 1) || (radios[i].id == 2) || (radios1[i].id == 4) || (radios1[i].id == 5))
  			{
  				
  				if(y == b)
  				{
  					x = b;			
  				}
  				else
  				{
  				
  					y1 = b;
  					b = x - 0.5;
  					x = b;	
  				}			
  			}
  		}
  	}
  	document.getElementById("daycount").value = x;
  	
  	
  }

  }
</script>


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