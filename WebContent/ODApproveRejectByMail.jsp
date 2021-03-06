
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.controller.SpecificAllocationSearchServlet"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
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
    <title>CO Approve Reject Mail</title>
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
  </head>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="dist/js/dontBack.js"></script>
<%@include file="emailHeader.jsp" %>
<script type="text/javascript">

	function replica()
	{
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
function reject1(){
	
	
	
	if(document.getElementById('remarks').value =" "){
		alert("Please fill reason remarks");	}
		/* }else if(id==2){
			document.getElementById('action').value ="rejected"
		} */
}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
 int OD_ID = Integer.parseInt(request.getParameter("od_id"));

	AllLMSListDAO allListDAO = new AllLMSListDAO();
	List<LeaveODBean> listOfOD = allListDAO.getODByODId(OD_ID);
	
	for(LeaveODBean odBean : listOfOD)
	{
		
		if(odBean.getStatus().equalsIgnoreCase("approved")){
			 request.setAttribute("success", "OD Already Approved By You");
			 request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		}else if(odBean.getStatus().equalsIgnoreCase("rejected")){
			request.setAttribute("error", "OD Already Rejected By You");
			request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		}else if(odBean.getStatus().equalsIgnoreCase("cancelled")){
			request.setAttribute("error", "OD Cancelled By Employee");
			request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		}else{
		
		int emp_id = odBean.getEmployeeBean().getEmployee_master_id();
		int approval_by = odBean.getUnder_manager_id();
%>

<div id="wrapper" style="padding-left: 100px; padding-right: 100px">
			<div class="row">
				<div class="col-lg-12">
					<center><h2 class="page-header">Outdoor duty slip <br>
					
										F-HRD-18</h2></center>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
								
								<%
							String start = null;
							String end = null;
							
							
							
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
							
							%>
							
							
						
						<div class="row">
				<div class="col-lg-12">
				
					<div class="table-responsive">
						
							<form action="emailODUpdate" method="post" enctype="multipart/form-data">
							
							
							
							
								<table class="table table-stripped" border="0">
											
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><%= odBean.getEmployeeBean().getFirstname() %> <%= odBean.getEmployeeBean().getLastname() %></input>
											<input type="hidden"  name="OD_Id" id="lid" value="<%= OD_ID %>">
											<input type="hidden"  name="Empid" id="lid" value="<%= emp_id %>">
											<input type="hidden"  name="approval" id="lid" value="<%= approval_by %>">
											
											<input type="hidden"  name="describe" value="<%=odBean.getDescription()%>">
											<input type="hidden"  name="StartDate" value="<%= start%>">
											<input type="hidden"  name="EndDate" value="<%=end%>">
											<input type="hidden"  name="starttime" value="<%= odBean.getOD_StartTime()%>">
											<input type="hidden"  name="endtime" value="<%= odBean.getOD_EndTime()%>">
											<input type="hidden"  name="numdays" value="<%= odBean.getOD_TotalDay()%>">
											
										</tr>	
									</tbody>
									<tbody>
										<tr >
											<th><label style="width: 200px">Please briefly describe the need of working on out station / outdoor</label></th>
											<td>:</td>
											<td colspan="3"><%= odBean.getDescription()%>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>From Date</label></th>
											<td>:</td>
											<td colspan="3"><%=start%>
										</tr>	
									</tbody>
									<tbody>
									<tr>
											<th><label>To Date</label></th>
											<td>:</td>
											<td colspan="3"><%=end%></td>
									</tr>
									</tbody>
									<tbody>
										<tr>
											<th><label>Start Time</label></th>
											<td>:</td>
											<td colspan="3"><%= odBean.getOD_StartTime()%>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>End Time</label></th>
											<td>:</td>
											<td colspan="3"><%= odBean.getOD_EndTime()%>
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
										<td><label>Total Day Count </label></td>
										<td>:</td>
										<td colspan="3"><%= odBean.getOD_TotalDay()%>
								
									</tr>
									</tbody>
							</tbody>
							<%} }%>
							<tbody>
								
								<tr>
                                	<td colspan="4">
                                	<div class="form-group has-error">
                                            <label class="control-label" for="remarks">Reject Reason / Remarks</label>
                                            <input type="text" class="form-control"  id="remarks" name="remarks" oninput="replica()" >
                                        </div>
                                        </td> 
                                        </tr>
									<tr>
                                		<td align="center" colspan="4">
                                		
                                		
                                <!-- /.modal-dialog -->
        
	                            
	                            	<input type="hidden" name="action" id="action" value="">
	                            	
	                            	<%if(request.getParameter("hrApproval") != null){ %>
	                            <input type="hidden" name="hrApproval"  value="<%=request.getParameter("hrApproval")%>">
	                            <%}else{%>
	                            <input type="hidden" name="hrApproval"  value="">
	                            <%}%>
	                            	  
                                			<button class="btn btn-primary" type="submit" value="accept" onclick="reject(1)">Accept</button>
                                			
                                			<input type="submit" class="btn btn-danger" id="reason" type="submit" value="reject"  onclick="reject(2); return validateForm();"></button>
                                			
                                			
                                			
                                		</td>
                                	</tr> 
								</tbody>
							<input type="hidden"  name="status" id="status" value="">
							<tbody>
							</table>
							</form>
							</div>
							</div>
							</div>
							</div>
							</div>
							</div>
<!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
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
    
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
</body>
</html>