<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
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
   <title>Leave OD Manager Show</title>
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
	function replica() {
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

	function reject(id) {

		//alert(id);

		if (id == 1) {
			document.getElementById('status').value = "approved"
		} else if (id == 2) {
			document.getElementById('status').value = "rejected"
		}
	}
	function reject1() {

		if (document.getElementById('remarks').value = " ") {
			alert("Please fill reason remarks");
		}
		/* }else if(id==2){
			document.getElementById('action').value ="rejected"
		} */
	}
	$(window).keypress(function(e) {
		var video = document.getElementById("vid");
		if (e.which == 32) {
			if (video.paused == true)
				video.play();
			else
				video.pause();
		}
	});
</script>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">
	<%
		int OD_ID = Integer.parseInt(request.getParameter("OD_ID"));
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		List<LeaveODBean> listOfCO = (ArrayList) request.getAttribute("listOfOD");

		for (LeaveODBean odBean : listOfCO) {
			int emp_id = odBean.getEmployeeBean().getEmployee_master_id();
			int approval_by = odBean.getUnder_manager_id();
			LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) allLMSListDAO.getleaveListbyEMP(emp_id);
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
										<h3 class="page-header" align="Center">
											Outdoor duty slip <br> F-HRD-18
										</h3>

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
				    <div class="col-md-12">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic" align="left">

														<%
															DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
																Date today = Calendar.getInstance().getTime();

																String date1 = dateFormat.format(today);

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

																try {

																	SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																	Date result1 = formater1.parse(odBean.getOD_StartDate());
																	Date result2 = formater1.parse(odBean.getOD_EndDate());
																	SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
																	start = formater2.format(result1);
																	end = formater2.format(result2);

																} catch (ParseException e1) {
																	e1.printStackTrace();
																}
														%>

														<div class="col-md-6">
															Date :
															<%=d%>
														</div>

														<%
															if (request.getParameter("hrApproval") != null) {
														%>
														<div class="col-md-6" align="right">
															<a href="pendingLeaveHrSide.jsp?hrApproval=od"
																style="color: white"><i class="fa fa-mail-reply"></i></a>
														</div>
														<%
															}
														%>
													
												
						</div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">


											<div class="panel-body">

												<form action="ManagerODUpdate" method="post"
													enctype="multipart/form-data">




													<table class="table table-stripped" border="0">

														<tbody>
															<tr>
																<th width="250px"><label>Employee Name</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden" name="Empname"
																	value="<%=odBean.getEmployeeBean().getFirstname()%> <%=odBean.getEmployeeBean().getLastname()%>"><%=odBean.getEmployeeBean().getFirstname()%>
																	<%=odBean.getEmployeeBean().getLastname()%></td>
																<input type="hidden" name="OD_Id" id="lid"
																	value="<%=OD_ID%>">
																<input type="hidden" name="Empid" id="lid"
																	value="<%=emp_id%>">
																<input type="hidden" name="approval" id="lid"
																	value="<%=approval_by%>">
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label style="width: 200px">Please
																		briefly describe the need of<br> working on out station /
																		outdoor</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden" id="describe"
																	name="describe" value="<%=odBean.getDescription()%>"><%=odBean.getDescription()%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>From Date</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden"
																	name="StartDate" value="<%=start%>"><%=start%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>To Date</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden" name="EndDate"
																	value="<%=end%>"><%=end%></td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>Start Time</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden"
																	name="starttime" value="<%=odBean.getOD_StartTime()%>"><%=odBean.getOD_StartTime()%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th><label>End Time</label></th>
																<td>:</td>
																<td colspan="3"><input type="hidden" name="endtime"
																	value="<%=odBean.getOD_EndTime()%>"><%=odBean.getOD_EndTime()%>
																</td>
															</tr>
														</tbody>
														<tbody>
															<input type="hidden" name="CO" id="CO"
																value="<%=leaveBalanceBean.getCO()%>">
															<input type="hidden" name="SundayCO" id="SundayCO"
																value="<%=odBean.getSundayCOadd()%>">
															<input type="hidden" name="HolidayCO" id="HolidayCO"
																value="<%=odBean.getHolidayCOadd()%>">
															<input type="hidden" name="coDates" id="coDates"
																value="<%=odBean.getCoDates()%>">
															<tr>

																<td><label>Total Day Count </label></td>
																<td>:</td>
																<td colspan="3"><input type="hidden" name="numdays"
																	value="<%=odBean.getOD_TotalDay()%>"><%=odBean.getOD_TotalDay()%>
																</td>

															</tr>
														</tbody>
														</tbody>
														<%
															}
														%>
														<tbody>
															<tr>
																<td align="center" colspan="4">
																	<!-- /.modal-dialog --> <input type="hidden"
																	name="action" id="action" value=""> <%
													 	if (request.getParameter("hrApproval") != null) {
													 %> <input type="hidden" name="hrApproval"
																	value="<%=request.getParameter("hrApproval")%>">
																	<%
																		} else {
																	%> <input type="hidden" name="hrApproval" value="">
																	<%
																		}
																	%>

																	<button class="btn btn-primary" type="submit"
																		value="accept" onclick="reject(1)">Accept</button> <input
																	type="submit" class="btn btn-danger" id="reason"
																	type="submit" value="reject"
																	onclick="reject(2); return validateForm();">
																	</button>



																</td>
															</tr>
															<tr>
																<td colspan="4">
																	<div class="form-group has-error">
																		<label class="control-label" for="remarks">Reject
																			Reason / Remarks</label> <input type="text"
																			class="form-control" id="remarks" name="remarks"
																			oninput="replica()">
																	</div>
																</td>
															</tr>
														</tbody>
														<input type="hidden" name="status" id="status" value="">
														<tbody>
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
</body>
</html>