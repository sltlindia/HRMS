
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
   <title>Pending Leave</title>
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
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
 int leave_id = Integer.parseInt(request.getParameter("leave_id"));
	int employee_master_id1 = user.getEmployee_master_id();
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
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Pending Leave</h1>
				</div>
			</div>
			<br>
			<%if(request.getAttribute("LeaveapprovedSuccessfully") !=null) {%>
		 		<div class="panel-body">
                            <div class="alert alert-dismissable alert-successfully ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveapprovedSuccessfully}
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
							 <%=d %> </h4>

						 </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
													
						<div class="panel-body">
							<form action="LeaveUpdate" method="post">
							
								<table class="table table-stripped" border="0">
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="2"><input type="hidden" name="contactNumberDuringLeave"
											class="form-control" value="<%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>"><%= leaveBean.getEmployeeBean().getFirstname() %> <%= leaveBean.getEmployeeBean().getLastname() %>											
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
        
	                            
	                            	<input type="hidden" name="action" id="action" value="">
	                            	<%if(request.getParameter("hrApproval") != null){ %>
	                            	<input type="hidden" name="hrApproval" id="action" value="<%=request.getParameter("hrApproval")%>">
	                            	<%} %>
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
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
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
	<script>
				$(document).ready(function() {
					$('#dataTables-example').DataTable({
						responsive : true
					});
				});

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