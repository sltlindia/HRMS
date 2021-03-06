 <%@page import="com.hrms.timesheet.dao.AllTimesheetListDAO"%>
<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.DayBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
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
    <title>Pending Timesheet</title>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
    $('#selecctall').click(function(event) {  //on click 
        if(this.checked) { // check select status
            $('.checkbox1').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"               
            });
        }
        else{
            $('.checkbox1').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
            });
            $('.checkbox2').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox2"                       
            });    
        }
    });
    
});

function save(id) {
	/* alert(id); */
	if(id==1){
	document.getElementById('action').value="approved";
	}else{
		document.getElementById('action').value="rejected";
	}
}

function validate_form()
{
valid = true;

if($('input[type=checkbox]:checked').length == 0)
{
    alert ( "ERROR! Please select at least one checkbox" );
    valid = false;
}

return valid;
}


</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">Time-Sheet Management</h4>
				                		</div>
				            		</div>
				<div class="card-body collapse in">
	  				<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading"><span class="icon-ios-calendar"></span> &nbsp;&nbsp;<b>Pending Timesheets</b></div>
						<br>
						<div class="panel-body">
				<form method="post" action="statusUpdate" onsubmit="return validate_form();">
				<input type="hidden" name="action" id="action" value="">
				
				
                 <div class="row">
                <div class="col-lg-12">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
										<%AllTimesheetListDAO allListDAO = new AllTimesheetListDAO();
															request.getAttribute("date");
															List<Object[]> pendingTimesheet = (ArrayList)request.getAttribute("pendingTimesheet");
															List<UnplanProjectBean> pendingUnplanTimesheet = (ArrayList)request.getAttribute("pendingUnplanTimesheet");
															if(pendingTimesheet.size() + pendingUnplanTimesheet.size()!= 0){%>
													
                                    <thead>
                                        <tr>
                                            <th colspan="1"></th>
                                            <th rowspan="3">Date</th>
                                            <th rowspan="3">Day</th>
                                            <th rowspan="3">Employee Name</th>
                                            <!-- <th rowspan="3">Project Name</th>
                                            <th rowspan="3">Task Name</th> -->
                                            <th rowspan="3">Total Worked Hours</th>
                                            <th>Task Time Status</th>
                                            <th rowspan="3">Status</th>
                                            <th rowspan="3">Action</th>
                                        </tr>
                                    </thead>
                                     <tbody>
                                        
                                         <tr>
                                            <td><input type="checkbox" id="selecctall" class="checkbox" name="checkAll[]"  onclick="myFunction()"> all</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                       
                                        
														<% 	
															for (Object[] aRow : pendingTimesheet) {
																String d = null;
																double workSum =0;
																double leaveSum =0;
																	TimeSheetBean timeSheetBean = (TimeSheetBean) aRow[0];
																	EmployeeBean employeeBean = (EmployeeBean) aRow[1];
																	DayBean dayBean = (DayBean) aRow[2];
																	ProjectMasterBean projectMasterBean = (ProjectMasterBean) aRow[3];
																	ClientMasterBean clientMasterBean = (ClientMasterBean) aRow[4];
																	TaskMasterBean taskMasterBean = (TaskMasterBean) aRow[5];
																	
																	String date = timeSheetBean.getDate();
																	int employee_id = employeeBean.getEmployee_master_id();
																	
																		List<Object[]> listOfSum = allListDAO.getSumOfHours(employee_id, date);
																	
																			for(Object[] arow : listOfSum){
																		
																		TimeSheetBean t = (TimeSheetBean) arow[0];
																		
																		workSum = workSum + t.getWorked_hours();
																		leaveSum = leaveSum + t.getLeave_hours();
																	}
																			
																			List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheetList(employee_id, date);
																			for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
																					
																				workSum = workSum + unplanProjectBean.getWorked_hours();
																			}

																			try {

																				String date1 = timeSheetBean.getDate();
																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				Date result = formater.parse(date1);
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																				d = AppDateFormat.format(result);
																				System.out.println(AppDateFormat.format(result));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}


														%>
                                        				<tr>
                                        					<!-- <td></td> -->
                                        					<td><input type="checkbox" class="checkbox1" id="accept" name="check" value="<%=employeeBean.getEmployee_master_id()+","+timeSheetBean.getDate()%>"></td>
                                        					<td><%=d%></td>
																<td><%=dayBean.getDay()%></td>
                                        						<td><%=employeeBean.getFirstname() %> <%=employeeBean.getLastname() %></td>
																<%-- <td><%=projectMasterBean.getProject_master_name()%></td>
																<td><%=taskMasterBean.getTask_master_name()%></td> --%>
																<td><%=workSum%></td>
																<td><%=timeSheetBean.getTask_time_status() %></td>
																<td><%=timeSheetBean.getApproval_status() %></td>
																<td><a href="pendingTimeSheetDetail?employee_master_id=<%=employeeBean.getEmployee_master_id()%>&date=<%=timeSheetBean.getDate()%>&buttonShow=show">
																<i class="icon-eye4" style="color: #2196f3" data-toggle="tooltip"
																data-placement="top" title="View Details"></i></a></td>
																</tr>
																<%
															}%>
															
															
																<% 	
															for (UnplanProjectBean t : pendingUnplanTimesheet) {
																String d = null;
																double workSum =0;
																double leaveSum =0;
																	
																	String date = t.getDate();
																	int employee_id = t.getEmployeeBean().getEmployee_master_id();
																	
																	List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO.getdayUnplanTimeSheetList(employee_id, date);
																	for (UnplanProjectBean unplanProjectBean : getdailyUnplanTimeSheetList) {
																			
																		workSum = workSum + unplanProjectBean.getWorked_hours();
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


														%>
                                        				<tr>
                                        					<!-- <td></td> -->
                                        					<td><input type="checkbox" class="checkbox1" id="accept" name="check" value="<%=t.getEmployeeBean().getEmployee_master_id()+","+t.getDate()%>"></td>
                                        					<td><%=d%></td>
																<td><%=t.getDayBean().getDay()%></td>
                                        						<td><%=t.getEmployeeBean().getFirstname()%> <%=t.getEmployeeBean().getLastname()%></td>
																<%-- <td><%=projectMasterBean.getProject_master_name()%></td>
																<td><%=taskMasterBean.getTask_master_name()%></td> --%>
																<td><%=workSum%></td>
																<td><%=t.getTask_time_status() %></td>
																<td><%=t.getApproval_status() %></td>
																<td><a href="pendingTimeSheetDetail?employee_master_id=<%=t.getEmployeeBean().getEmployee_master_id()%>&date=<%=t.getDate()%>&buttonShow=show">
																<i class="icon-eye4" style="color: #2196f3" data-toggle="tooltip"
																data-placement="top" title="View Details"></i></a></td>
																</tr>
																<%}
															%>
											
                                    </tbody>
                                   
                                </table>
                                <br>
          <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Remarks</h4>
                                        </div>
                                        <div class="modal-body">
                                      <textarea class="form-control" rows="3"
													name="remarks" id="remarks"></textarea>
                                        </div>
                                        <div class="modal-footer">
                                        <input type="submit" class="btn btn-primary" name="submit" value="SUBMIT" onclick="save(2)">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                                
                            </div>
                            
                            <center><button type="submit" class="btn btn-primary" onclick="save(1)">Approve</button>
                            <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#myModal">Reject</button></center>
									<%}
															  else{%>
                              <td>No more timesheet(s) for approval </td>
                              <% }%>
                		        
				        	<font size="3px;"><b>Legends :&nbsp;</b></font> <i class="icon-eye4" style="color: #2196f3"></i><b> : View Detail </b> &nbsp;&nbsp;&nbsp;                
                        </div>
                        
                    </div>
                    
                </div>
                </div>
                </div>
                            </div>
                            </form>
                            <br>
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
      <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
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