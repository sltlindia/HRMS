<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveBean"%>
<%@page import="com.hrms.incentive.dao.AllIncentiveListDAO"%>
<%@page import="com.hrms.pms.bean.ReviewBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
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
<title>CI List</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
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
	href="app-assets/vendors/css/extensions/sweetalert.css">
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
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int manager_id = user.getManagerBean().getManager_id();
		AllListDAO allListDAO = new AllListDAO();

		List<YearBean> listOfYear = allListDAO.getListOfYear();
		List<MonthBean> listOfMonth = allListDAO.getListOfMonth();
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		int emp_id = user.getEmployee_master_id();
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">CI List</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>
				
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">

								<div class="row">
									<div class="col-lg-12">
				        	<div class="card box-shadow-0" data-appear="appear">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					                <div class="col-sm-6">
					                 <h5 class="card-title">CI List</h5>
												</div>

											</div>
											<!-- /.panel-heading -->
											<div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					                    <div class="table-responsive">
													<table
														class="table table-striped table-bordered table-hover">
														<thead>
															<%
																for (YearBean yearBean : listOfYear) {
																	int year = Integer.parseInt(yearBean.getYear());
																	int year1 = year + 1;
																	String yearDuration = year + "-" + year1;
															%>
															<tr class="panel-group">
																<th style="padding: 3px;"><a id="year<%=yearBean.getYear_id()%>"
																	style="color: black; text-decoration: none; cursor: pointer;"
																	onclick="showData(this.id)"><i
																		class="icon-android-add-circle"></i> <%=year%> - <%=year1%></a></th>
																<th style="padding: 3px;"><div align="right"><button name="button"
																		onclick="window.open('kaizenBillBoard.jsp?year=<%=yearDuration%>','_blank')"
																		class="btn btn-primary">
																		<i class="icon-document-text" align="right"></i> BillBoard
																	</button>
																	<button name="button"
																		onclick="window.open('kaizenLeaderBoard.jsp?year=<%=yearDuration%>','_blank')"
																		class="btn btn-primary">
																		<i class="icon-document-text"></i> LeaderBoard
																	</button></div></th>
															</tr>
															<script>
																$(document).ready(function() {
																					$(".year"+<%=yearBean.getYear_id()%>).hide();
																				});
															</script>

															<tr class="year<%=yearBean.getYear_id()%>">
																<td colspan="2">
																<div class="table-responsive">
																	<table
																		class="table table-striped table-bordered">
																		<thead>
																			<tr align="center">
																				<th rowspan="2" style="padding: 0px;">&nbsp;Month</th>
																				<th colspan="4" style="padding: 0px;">&nbsp;Total CI</th>
																				<th rowspan="2" style="padding: 0px;">&nbsp;Action</th>
																			</tr>
																		</thead>

																		<tbody>
																			<tr align="center">
																				<th style="padding: 0px;"></th>
                                    					  						<th style="padding: 0px;">&emsp;On-Progress&emsp;<i class="icon-information-circled" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="No of CI which are Approved but not completed"></i></th>
				                                    					  		<th style="padding: 0px;">&emsp;Completed&emsp;<i class="icon-information-circled" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="No of CI which are Approved and completed"></i></th>
				                                    					  		<th style="padding: 0px;">&emsp;Pending&emsp;<i class="icon-information-circled" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="No of CI Pending for Approval"></i></th>
				                                    					  		<th style="padding: 0px;">&emsp;Genuine&emsp;<i class="icon-information-circled" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="No of CI which are approved by departmental HOD but pending for other HOD's Approval"></i></th>
				                                    					  		<th style="padding: 0px;">&emsp;Rejected&emsp;<i class="icon-information-circled" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="No of CI Rejected"></i></th>
				                                    					  		<th style="padding: 0px;"></th>
																			</tr>
																		</tbody>

																		<tbody>

																			<%
																				for (int i = 3; i < 12; i++) {
																						MonthBean monthBean = listOfMonth.get(i);

																						List<KaizenBean> lisOfApprovedOnProgressCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year, monthBean.getMonth_id(), "approved", "submitted");
																						List<KaizenBean> lisOfApprovedCompletedCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year, monthBean.getMonth_id(), "approved", "completed");
																						List<KaizenBean> lisOfPendingForApprovalCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year, monthBean.getMonth_id(), "pending", "saved");
																						List<KaizenBean> lisOfPendingForApprovalSumittedCI = allKaizenListDAO
																								.getListOfAllKaizenByEmpIdWithStatus(emp_id, year, monthBean.getMonth_id(), "pending", 
																																					"submitted");
																						List<KaizenBean> lisOfMainRejectedKaizen = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year, monthBean.getMonth_id(), "rejected", "submitted");
																						List<KaizenBean> lisOfMainGenuineKaizen = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year, monthBean.getMonth_id(), "genuine", "submitted");
																			%>


																			<tr align="center">
																				<th style="padding: 1px;">&emsp;<%=monthBean.getMonth_name()%>,<%=year%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfApprovedOnProgressCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfApprovedCompletedCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfPendingForApprovalCI.size() + lisOfPendingForApprovalSumittedCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfMainGenuineKaizen.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfMainRejectedKaizen.size()%></th>
																				<th style="padding: 1px;">&emsp;<a
																					href="kaizenList.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>">&emsp;<button
																							class="btn btn-primary">
																							<i class="icon-eye4"></i> Show
																							All CI
																						</button></a></th>
																			</tr>
																			<%
																				}
																			%>


																			<%
																				for (int i = 0; i < 3; i++) {
																						MonthBean monthBean = listOfMonth.get(i);

																						List<KaizenBean> lisOfApprovedOnProgressCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year1, monthBean.getMonth_id(), "approved", "submitted");
																						List<KaizenBean> lisOfApprovedCompletedCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year1, monthBean.getMonth_id(), "approved", "completed");
																						List<KaizenBean> lisOfPendingForApprovalCI = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year1, monthBean.getMonth_id(), "pending", "saved");
																						List<KaizenBean> lisOfPendingForApprovalSumittedCI = allKaizenListDAO
																								.getListOfAllKaizenByEmpIdWithStatus(emp_id, year1, monthBean.getMonth_id(), "pending",
																										"submitted");
																						List<KaizenBean> lisOfMainRejectedKaizen = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year1, monthBean.getMonth_id(), "rejected", "submitted");
																						List<KaizenBean> lisOfMainGenuineKaizen = allKaizenListDAO.getListOfAllKaizenByEmpIdWithStatus(
																								emp_id, year1, monthBean.getMonth_id(), "genuine", "submitted");
																			%>

																			<tr align="left">
																				<th style="padding: 1px;">&emsp;<%=monthBean.getMonth_name()%>,<%=year1%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfApprovedOnProgressCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfApprovedCompletedCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfPendingForApprovalCI.size() + lisOfPendingForApprovalSumittedCI.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfMainGenuineKaizen.size()%></th>
																				<th style="padding: 1px;">&emsp;<%=lisOfMainRejectedKaizen.size()%></th>
																				<th style="padding: 1px;">&emsp;<a
																					href="kaizenList.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>">&emsp;<button
																							class="btn btn-primary">
																							<i class="icon-eye4"></i> Show
																							All CI
																						</button></a></th>
																			</tr>
																			<%
																				}
																			%>


																		</tbody>
																	</table>
																	</div>
																</td>
															</tr>

															<%
																}
															%>
														</thead>
													</table>
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

	<%@include file="footer.html"%>
	<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
	
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
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js"
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
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
	</script>
	<script>
    
    function showData(id){
		 $("."+id).slideToggle(2);
	     $("i", "#"+id).toggleClass("icon-android-remove-circle icon-android-add-circle");
	}
    </script>
    <script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>