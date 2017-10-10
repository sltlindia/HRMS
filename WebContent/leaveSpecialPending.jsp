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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<title>Leave Details</title>
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
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
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
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
<%
 int leave_id = (Integer)request.getAttribute("leave_id");
	System.out.println("Leaved Id" + leave_id);

AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
List<LeaveBean> listOfLeave = (ArrayList)request.getAttribute("listOfLeave");
for(LeaveBean leaveBean : listOfLeave)
{

	
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
					<h3 class="page-header"> Pending Leave</h3>
				</div>
			</div>
			<!-- /.row -->
			<%if(request.getAttribute("LeaveapprovedSuccessfully") !=null) {%>
		 		<div class="panel-body">
                            <div class="alert alert-dismissable alert-successfully ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveapprovedSuccessfully}
                            </div>
          		</div>  
          		<%}%>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4 align="left">
						
								
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
							 <%=d %> </h4>

						</div>
													
						<div class="panel-body">
							<form action="LeaveUpdate" id="LeaveForm" name="LeaveForm" method="post">
						 	
								<table class="table table-stripped" border="0">
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="2"><input type="hidden" name="contactNumberDuringLeave"
											class="form-control" value="<%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>"><%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>											
										</tr>
									<input type="hidden"  name="leaveid" id="lid" value="<%= leave_id %>">
									<input type="hidden"  name="status" id="status" value="approved">
									<input type="hidden"  name="empcode"  value="<%= leaveBean.getEmployeeBean().getEmployee_master_id()%>">
									<input type="hidden"  name="leavetypeid" id="leavetypeid" value="<%= leaveBean.getLeaveType_ID() %>">
									<%-- <input type=" hidden" id="adjvalue" name="adjvalue" value="<%= leaveBean.getAdjvalue() %>"> --%>
									<%
									int user_code = leaveBean.getEmployeeBean().getEmployee_master_id();
									/*  AllListDAO gradeMasterList1 = new AllListDAO(); */
									 LeavecutBalance leavecutBalance = allLMSListDAO.getleaveCUTBYLeaveID(leave_id);
									LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(user_code);
									%>
											
											<%-- <input type="hidden"  name="privilege" id= "privilege" value="<%=leaveBalanceBean.getPrivilege_Leave()%>">
											<input type="hidden"  name="madical" id="madical" value="<%=leaveBalanceBean.getMedical_Leave()%>">
											<input type="hidden"  name="Casual" id="Casual" value="<%=leaveBalanceBean.getCasual_Leave()%>">
											<input type="hidden"  name="Maternity" id= "Maternity" value="<%=leaveBalanceBean.getMaternity_Leave()%>">--%>
											
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
											<input type="hidden"  name="month_id" value="<%=leaveBean.getMonth_ID()%>">
											<input type="hidden" name="specialLeave" value="specialLeave">
									</tbody>
											<%-- <input type="hidden"  name="employee_master_id" value="<%=user.getEmployee_master_id()%>">
											<input type="hidden"  name="privilege" id= "privilege" value="<%=user.getPrivilege_Leave()%>">
											<input type="hidden"  name="madical" value="<%=user.getMedical_Leave()%>"> --%>
									<tbody>
										<%-- <tr>
											<th>Employee Code</th>
											<td>:</td>
											
											<td><%=user.getEmployee_code()%></td>
										</tr> --%>
									</tbody>
									<tr>
									<tbody>
										<td><label>Purpose Of Leave</label></td>
										<td>:</td>
										<td colspan="2">
										<input type="hidden" name="contactNumberDuringLeave" value="<%= leaveBean.getPurpose_of_Leave() %>"><%= leaveBean.getPurpose_of_Leave() %></textarea>
										</td>
									<tbody>
									</tr>
									
									</tr>
									<tr>
										<td><label>Leave Applied For</label></td>
										<td>:</td>
										<td ><input type="hidden" name="contactNumberDuringLeave"
											value="<%= leaveBean.getLeave_From() %>">
											
											<%= leaveBean.getLeave_From() %>
										<%String half = leaveBean.getFrom_half();
										if(half.equalsIgnoreCase("FF")){
										%>
										(Full Day)
										<%}else if(half.equalsIgnoreCase("FH")){ %>
										(First Half)
										<%}else if(half.equalsIgnoreCase("SH")) {%>
										(Second Half)
										<%} %> 
										&nbsp;&nbsp;&nbsp;&nbsp; <b> TO </b> &nbsp;&nbsp;&nbsp;&nbsp; 
										<%= leaveBean.getLeave_To() %><%String half1 = leaveBean.getTo_half();
										if(half1.equalsIgnoreCase("FF")){
										%>
										(Full Day)
										<%}else if(half1.equalsIgnoreCase("FH")){ %>
										(First Half)
										<%}else if(half1.equalsIgnoreCase("SH")) {%>
										(Second Half)
										<%} %>
										</td> 
										
										
										<td>
										
										
									</td>
									</tr>
									
									</br>
									
									<input type="hidden" class="textbox" id="numdays2" name="numdays11" readonly="readonly"/>
									
									<tbody>
									
									<tr>
									<tbody>
										<td><label> Leave Day Count </label></td>
										<td>:</td>
										<td colspan="2"><input type="hidden" name="numdays"
												id="numdays2"  value="<%= leaveBean.getDay_count() %>"><%= leaveBean.getDay_count() %>
								<tbody>
									</tr>
									
									<tr>
									<tbody>
										<td><label>Contact Address </label></td>
										<td>:</td>
										<td colspan="2"><input type="hidden" name="" value="<%= leaveBean.getAddress() %>"><%= leaveBean.getAddress() %></textarea></td>
								<tbody>
									</tr>
									<tr>
									<tbody>
										<td><label>Contact Number During Leave</label></td>
										<td>:</td>
										<td colspan="2"><input type="hidden" name="contactNumberDuringLeave"
											value="<%= leaveBean.getNumber() %>"><%= leaveBean.getNumber() %></td>
								</tbody>
									</tr>

									<tr>
									</tbody>
							<%} %>
									<tbody>
									<tr>
                                		<td align="center" colspan="4">
                                <!-- /.modal-dialog -->
        						
	                            
                                			<button class="btn btn-primary" type="submit" value="accept" onclick="reject(1)">Accept</button>
                                			
                                			<input type="submit" class="btn btn-danger" id="reason" type="submit" value="reject"  onclick="reject(2); return validateForm();"></button>
                                			
                                			
                                			
                                		</td>
                                	</tr> <tr>
                                	
                                	
                                	<td colspan="4">
                                	<div class="form-group has-error">
                                            <label class="control-label" for="remarks">Reject Reason / Remarks</label>
                                            <input type="text" class="form-control"  id="remarks" name="remarks" oninput="replica()" >
                                        </div>
                                        </td> 
                                        </tr>
								</tbody>
								</table>
							</form>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
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
</body>
</html>