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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
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
	href="app-assets/vendors/css/forms/icheck/icheck.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/forms/icheck/custom.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
<link rel="stylesheet" type="text/css"
	href="app-assets/css/pages/users.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/pages/timeline.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="css/dropzone.css">
<script src="js/dropzone.js" type="text/javascript"></script>
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
<link href="css/timepicki.css" rel="stylesheet">
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
<title>CO Application Form</title>
<script type="text/javascript">

function redirect(value) {
	/* alert("test"); */
	window.location.replace(value);
}
</script>


<%
	ArrayList<Date> holidayDate = new ArrayList<Date>();
	ArrayList<String> holiday = new ArrayList<String>();
%>

<%
	AllLMSListDAO allListDAO2 = new AllLMSListDAO();
	List<HolidayBean> listgholiday = allListDAO2.getListOfHoliday();
	for (HolidayBean h : listgholiday) {
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
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h3>Leave / CO / OD Form</h3>
											</div>
											<div class="panel-body">
											<br>
												<div class="col-md-2"><b>Select Form:</b></div>
												<div class="col-md-6">
													<div class="form-group">
														<select class="form-control" name="leavetypeselect"
															id="leavetypeselect" onchange="redirect(this.value);"
															required>
															<option value="applyLeave.jsp">Leave</option>
															<option value="leaveCO.jsp" selected="selected">CO</option>
															<option value="leaveOD.jsp">OD</option>
														</select>
													</div>
												</div>
											</div>
										</div>
										<!-- /.panel -->
									</div>
									<!-- /.col-lg-12 -->
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
								<div class="row">
									<div class="col-lg-12">
										<h3 class="page-header" align="Center">
											Compensatory Off Form <br> F-HRD-17
										</h3>
										<h4 align="right">
											Date :
											<%
											DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
											Date today = Calendar.getInstance().getTime();

											String date1 = dateFormat.format(today);

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
										%><%=d%></h4>

									</div>
								</div>
								<%
									if (request.getAttribute("LeaveExist") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-danger ">
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
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${LeavefromtodateExist}
									</div>
								</div>
								<%
									}
								%>
								<!-- /.row -->
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-default">
											<div class="panel-heading"></div>


											<div class="panel-body">
												<form action="LeaveCo" method="post"
													enctype="multipart/form-data">
													<table class="table table-stripped" border="0">


														<tbody>
															<tr>
																<th><label>Employee Name</label></th>
																<td>:</td>
																<td colspan="3"><%=user.getFirstname() + " " + user.getLastname()%>
																	<input type="hidden" name="employee_master_id"
																	value="<%=user.getEmployee_master_id()%>">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label style="width: 200px">Please
																		briefly describe the need of working on holiday</label></th>
																<td>:</td>
																<td colspan="3"><textarea id="describe" rows="2"
																		width="155" name="describe"
																		placeholder="Enter Description" required
																		class="form-control"></textarea>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Date</label></th>
																<td>:</td>
																<td colspan="3"><input type="text" id="datepicker1"
																	width="155" name="fromDate" placeholder="dd/mm/yyyy"
																	required class="form-control">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Start Time</label></th>
																<td>:</td>
																<td colspan="3"><input id="starttime" type="text"
																	class="form-control" name="starttime"
																	placeholder="HH:mm" required /></td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>End Time</label></th>
																<td>:</td>
																<td colspan="3"><input id="endtime" type="text"
																	class="form-control" name="endtime" onchange="diff()"
																	placeholder="HH:mm" required /></td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Total Hours Count</label></th>
																<td>:</td>
																<td colspan="3"><input type="text" id="totalhours"
																	value="" name="totalhours"
																	placeholder="Click here to get total hours"
																	class="form-control" readonly="readonly"
																	onclick="diff()">
															</tr>
														</tbody>
														<tbody>
															<tr>

																<%
																	AllLMSListDAO allListDAO = new AllLMSListDAO();
																	String under_manager_id = user.getUnder_manager_id();
																	ManagerBean managerBean = allListDAO.getnameOfManager(under_manager_id);
																%>
																<td><label>Reporting Manager</label></td>
																<td>:</td>
																<td colspan="6"><input type="text"
																	class="form-control" name="Manager"
																	class="form-control" placeholder="Reporting Manager"
																	value="<%=managerBean.getManager_name()%>" required
																	readonly></input> <input type="hidden"
																	name="reportingManager"
																	value="<%=user.getUnder_manager_id()%>"></td>

															</tr>
														</tbody>
														</tbody>
														<tr>
															<input type="hidden" name="sunday" id="sunday" value="">
															<input type="hidden" name="redirect">
															<td align="center" colspan="7">

																<button class="btn btn-success" id="btnsubmit"
																	type="submit" value="Submit" onclick="diff();">Submit</button>

															</td>

														</tr>
														<tbody>
													</table>
													<h3>
														<b><font color="red">Note:</font></b>
													</h3>
													<b>
														<ul>
															<li>0-2 Hours Of Work : NA</li>
															<li>2-4 Hours Of Works : Half CO</li>
															<li>4 Hours & Above : Full CO</li>
													</b>
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
</body>
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
<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>

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
				 			 changeMonth: true,
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
	
	
    start = start.split(":");
    end = end.split(":");
  
    var startDate = new Date(0, 0, 0, start[0], start[1], 0);
    var endDate = new Date(0, 0, 0, end[0], end[1], 0);
    
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
<script src="js/timepicki.js"></script>
<script>
	$('#starttime').timepicki();
	$('#endtime').timepicki();
    </script>
<!--  END PAGE LEVEL SCRIPTS  -->
</html>