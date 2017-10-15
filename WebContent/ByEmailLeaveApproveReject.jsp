
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
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
<script type="text/javascript">
function replica(){
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
	<script type="text/javascript">
	
	</script>
	<script src="dist/js/dontBack.js"></script>
</head>
<%@include file="emailHeader.jsp" %>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
// int leave_id = Integer.parseInt(request.getParameter("leave_id"));
 int leave_id = 3127; 
AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
List<LeaveBean> listOfLeave = allLMSListDAO.getLeaveByLeaveId(leave_id);
for(LeaveBean leaveBean : listOfLeave)
{

	if(leaveBean.getStatus().equalsIgnoreCase("approved")){
		
		 request.setAttribute("success", "Leave Already Approved By You");
		 request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		
	}else if(leaveBean.getStatus().equalsIgnoreCase("rejected")){
	
		request.setAttribute("error", "Leave Already Rejected By You");
		 request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
		 
}else if(leaveBean.getStatus().equalsIgnoreCase("cancelled")){
	
	request.setAttribute("error", "Leave Cancelled By Employee");
	 request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);
	 
}else{
	
%>

<div id="wrapper" style="padding-left: 100px; padding-right: 100px">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Pending Leave</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
				
												<div class="table-responsive">
												<form action="emailLeaveUpdate" method="post">
								<table class="table table-stripped" border="0">
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="2"><%=leaveBean.getEmployeeBean().getFirstname()+" "+leaveBean.getEmployeeBean().getLastname() %></input>
											
										</tr>
									<input type="hidden"  name="leaveid" id="lid" value="<%= leave_id %>">
									<input type="hidden"  name="status" id="status" value="">
									<input type="hidden"  name="empcode"  value="<%= leaveBean.getEmployeeBean().getEmployee_master_id()%>">
									<input type="hidden"  name="leavetypeid" id="leavetypeid" value="<%= leaveBean.getLeaveType_ID() %>">
									<%-- <input type=" hidden" id="adjvalue" name="adjvalue" value="<%= leaveBean.getAdjvalue() %>"> --%>
									<%
									int user_code = leaveBean.getEmployeeBean().getEmployee_master_id();
									/*  AllListDAO gradeMasterList1 = new AllListDAO(); */
									 LeavecutBalance leavecutBalance = allLMSListDAO.getleaveCUTBYLeaveID(leave_id);
									LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(user_code);
									%>
											
											
											<input type="hidden"  name="CUTCO" id="CUTCO" value="<%= leavecutBalance.getCO()%>">
											<input type="hidden"  name="CUTPL" id="CUTPL" value="<%= leavecutBalance.getPL()%>">
											<input type="hidden"  name="CUTSL" id="CUTSL" value="<%= leavecutBalance.getSL()%>">
											<input type="hidden"  name="CUTLWP" id="CUTLWP" value="<%= leavecutBalance.getLWP()%>">
											
											<input type="hidden"  name="CO1" id="CO1" value="<%= leaveBean.getCO()%>">
											<input type="hidden"  name="PL1" id="PL1" value="<%= leaveBean.getPL()%>">
											<input type="hidden"  name="SL1" id=SL1 value="<%= leaveBean.getSL()%>">
											<input type="hidden"  name="LWP1" id="LWP1" value="<%=leaveBean.getLWP()%>">
											<input type="hidden"  name="plan" id="plan" value="<%=leaveBalanceBean.getPlan_Leave()%>">
											<input type="hidden"  name="unplan" id="unplan" value="<%=leaveBalanceBean.getUnplan_Leave()%>"/>
											<input type="hidden"  name="CO" id="CO" value="<%=leaveBalanceBean.getCO()%>">
											<input type="hidden"  name="LWP" id="LWP" value="<%=leaveBalanceBean.getLeave_without_pay()%>">
											<input type="hidden"  name="employee_master_id" value="<%=leaveBean.getEmployeeBean().getEmployee_master_id()%>">
											<input type="hidden" name="numdays" value="<%= leaveBean.getDay_count() %>">
											
											
											<%
											
											String lf = null;
											String lt = null;
											
											
											try {
												  
												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(leaveBean.getLeave_From());
												Date result1 = formater.parse(leaveBean.getLeave_To());
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												lf = AppDateFormat.format(result);
												lt = AppDateFormat.format(result1);
											} catch (ParseException e1) {
												e1.printStackTrace();
											} %>
											
									<tr>
										<td><label>Purpose Of Leave</label></td>
										<td>:</td>
										<td colspan="2">
										<%=leaveBean.getPurpose_of_Leave()%>
										</td>
									</tr>
									
									<tr>
										<td><label>Leave Date</label></td>
										<td>:</td>
										<td ><%= lf %> (From)
										</td>
										
										
										<td>
										<%String half = leaveBean.getFrom_half();
										if(half.equalsIgnoreCase("FF")){
										%>
										Full Day
										<%}else if(half.equalsIgnoreCase("FH")){ %>
										First Half
										<%}else if(half.equalsIgnoreCase("SH")) {%>
										Second Half
										<%} %>
										
									</td>
									</tr>
									<tr>
									<td colspan="2"></td>									
									<td><%=lt%> (To)</td>
									
									<td>
									<%String half1 = leaveBean.getTo_half();
									if(half1.equalsIgnoreCase("FF")){
									%>
									Full Day
									<%}else if(half1.equalsIgnoreCase("FH")){ %>
									First Half
									<%}else if(half1.equalsIgnoreCase("SH")) {%>
									Second Half
									<%} %>
									</td>
									</tr>
									
									<tr>
										<td><label> Leave Day Count </label></td>
										<td>:</td>
										<td colspan="2"><%=leaveBean.getDay_count()%></td>
									</tr>
									
									<tr>
										<td><label>Contact Address </label></td>
										<td>:</td>
										<td colspan="2"><%= leaveBean.getAddress() %></td>
									</tr>
									<tr>
										<td><label>Contact Number During Leave</label></td>
										<td>:</td>
										<td colspan="2"><%=leaveBean.getNumber()%></td>
									</tr>

									
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
	                            	<input type="hidden" name="action" id="action" value="">
                                			<button class="btn btn-primary" type="submit" value="accept" onclick="reject(1)">Accept</button>
                                			
                                			<input type="submit" class="btn btn-danger" id="reason" type="submit" value="Reject"  onclick="reject(2); return validateForm();"></button>
                                		</td>
                                	</tr> 
								</table>
                                                
                                                </form>
                                                </div>	
												</div>
								<br>
										</div>

				

		<%} }%>					
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

</body>
</html>