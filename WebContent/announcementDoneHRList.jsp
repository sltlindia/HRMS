<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewEmployeeBean"%>
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
    <title>Broadcast List</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
</head>
<script type="text/javascript">
	function hideMessage() {
		//document.getElementById("panelbody").style.display="none"; 
		$('#panelbody').fadeOut('slow');
	}

	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
</script>
<%@include file="header.jsp"%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
<%
		int employee_id = user.getEmployee_master_id();
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<%
				if (request.getAttribute("successAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-success">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${successAnnouncement}
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("conflictAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-success">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${conflictAnnouncement}
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("deleteAnnouncement") != null) {
			%>
			<div id="panelbody" class="panel-body">
				<div class="alert alert-dismissable alert-danger">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${deleteAnnouncement}
				</div>
			</div>
			<%
				}
			%>
				<!-- <div class="row"> 
			        <div class="col-xs-12">
			            <h4>Broadcast List</h4>
			            <hr>
			        </div>
			    </div> -->
				<div class="row">
				    <div class="col-md-12 col-xs-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Broadcast List</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-block card-dashboard">
	               				 	<div class="table-responsive">
				                         <table class="table table-striped table-bordered zero-configuration" width="100%">
				                            <thead>
				                                <tr>
													<th>Title</th>
													<th>Broadcast By</th>
													<th>Date Of Submission</th>
													<th>Attachment</th>
													<th>Action</th>
												</tr>
											</thead>
											
											<tbody>
												<%
													DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
													Date date1 = new Date();
													String currDate = dateFormat2.format(date1);
													System.out.println(dateFormat2.format(date1));
													AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
													List<AnnouncementBean> listOfAnnouncement = allListSelfServiceDAO.getListOfAnnouncementDoneByMe(employee_id);
													for (AnnouncementBean a : listOfAnnouncement) {
														String date_of_submission = a.getAnnouncement_submission_date();
														String ds = "-";
														Date date = new Date();
														String end_date = a.getAnnouncement_enddate();
														Date result3 = null;
														try {
															SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
															SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

															Date result = formater.parse(date_of_submission);
															ds = AppDateFormat.format(result);
															result3 = formater.parse(end_date);
															System.out.println("end_date " + result3);
															System.out.println(AppDateFormat.format(result));
														} catch (ParseException e1) {
															e1.printStackTrace();
														}
												%>
												<tr>
													<td><b><%=a.getAnnouncement_title()%></b></td>
													<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
													<td><%=ds%></td>
													<%-- <td><%=a.getAnnouncement_attachment()%></td> --%>



													<td>
														<%
															String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
														%> <a
														href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
															src="upload/IconsOfMSOffice/<%=ext2%>.png" height="50px"
															width="50px" data-toggle="tooltip" data-placement="top"
															title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
														<%
															} else {
														%> <a
														href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
															<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
													</td>
													<td><a href="" data-toggle="modal"
														data-target="#myModalView<%=a.getAnnouncement_id()%>"><i class="icon icon-eye4" title="View Data" data-toggle="tooltip"
															data-placement="top" title="View Data"></i>
															</a>&nbsp;&nbsp;<a
														href="announcementUpdate.jsp?announcement_id=<%=a.getAnnouncement_id()%>"><i class="ficon icon-edit" title="Edit Data" data-toggle="tooltip"
															data-placement="top" title="Edit Data"></i></a>&nbsp;&nbsp;<a
														href="announcementDelete?announcement_id=<%=a.getAnnouncement_id()%>"><i class="ficon icon-trash-o" title="Delete Data"
															data-toggle="tooltip"
															data-placement="top" onclick="return confSubmit()" style="color: red;" title="Delete Data"></i></a></td>

												</tr>
												<%
													}
												%>
											</tbody>
										</table>



										<%
											for (AnnouncementBean a : listOfAnnouncement) {
										%>
										<div class="modal fade"
											id="myModalView<%=a.getAnnouncement_id()%>" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<%
												int announcement_id = a.getAnnouncement_id();
											%>
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel"></h4>
													</div>
													<table class="table">
														<tr>
															<td width="25%"><label>&nbsp;Title</label></td>
															<td>:</td>
															<td><%=a.getAnnouncement_title()%></td>
														</tr>
														<tr>
															<td style="white-space: pre-wrap;"><label>&nbsp;Description</label></td>
															<td>:</td>
															<td><%=a.getAnnouncement_description()%></td>
														</tr>
														<%if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {%>
														<tr>
															<td><label>&nbsp;Attachment</label></td>
															<td>:</td>
															<td>
																<%
																	String ext2 = FilenameUtils.getExtension(a.getAnnouncement_attachment());

																		if (!a.getAnnouncement_attachment().equalsIgnoreCase("-")) {
																%> <a
																href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>"><img
																	src="upload/IconsOfMSOffice/<%=ext2%>.png"
																	height="50px" width="50px" data-toggle="tooltip"
																	data-placement="top"
																	title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<%=a.getAnnouncement_attachment()%>
																<%
																	} else {
																%> <a
																href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																	<%=a.getAnnouncement_attachment()%></a> <%
 	}
 %>
															</td>
														</tr>
														<%} %>
														<%
															String ds = a.getAnnouncement_submission_date();
																String de = a.getAnnouncement_enddate();
																String ad = a.getAnnouncment_date();
																try {
																	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																	SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																	Date result1 = formater.parse(ds);
																	Date result2 = formater.parse(de);
																	Date result3 = formater.parse(ad);
																	ds = AppDateFormat.format(result1);
																	de = AppDateFormat.format(result2);
																	ad = AppDateFormat.format(result3);
																	

																	System.out.println(AppDateFormat.format(result1));
																	System.out.println(AppDateFormat.format(result2));
																} catch (ParseException e1) {
																	e1.printStackTrace();
																}
														%>
														<tr>
															<td><label>&nbsp;Announcement Date</label></td>
															<td>:</td>
															<td><%=ad%></td>
														</tr>

														<tr>
															<td><label>&nbsp;End Date Of Broadcast</label></td>
															<td>:</td>
															<td><%=de%></td>
														</tr>
														<%if (!a.getFrom_time().equalsIgnoreCase("00:00:00")) {%>
														<tr>
															<td><label>&nbsp;From Time</label></td>
															<td>:</td>
															<td><%=a.getFrom_time()%></td>
														</tr>
														<%} %>
														<%if (!a.getTo_time().equalsIgnoreCase("00:00:00")) {%>
														<tr>
															<td><label>&nbsp;To Time</label></td>
															<td>:</td>
															<td><%=a.getTo_time()%></td>
														</tr>
														<%} %>
														<tr>
															<td><label>&nbsp;Broadcast Done By</label></td>
															<td>:</td>
															<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
														</tr>

													</table>


													<input type="hidden" name="redirect">
													<div class="modal-footer">
														<button type="button" class="btn btn-danger"
															data-dismiss="modal">CLOSE</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->



										</div>
										<%
											}
										%>
										<!-- /.modal-content -->
								 </div>
	               				 </div>
	               			</div>
				        </div>
				    </div>
				    </div>
					<!-- <center>
						<a href="announcementForm.jsp"><button type="button"
								class="btn btn-primary" data-dismiss="modal">Back</button></a>
					</center> -->
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
    <!-- /build-->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js" type="text/javascript"></script>
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