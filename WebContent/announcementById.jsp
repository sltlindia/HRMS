<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.selfservice.bean.RoleCategoryBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page
	import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Announcement Form</title>
<script type="text/javascript">
	function checkFile(fieldObj) {
		var FileName = fieldObj.value;
		var FileExt = FileName.substr(FileName.lastIndexOf('.') + 1);
		var FileSize = fieldObj.files[0].size;
		var FileSizeMB = (FileSize / 1048576).toFixed(2);

		if ((FileExt != "pdf" && FileExt != "doc" && FileExt != "docx"
				&& FileExt != "jpg" && FileExt != "png" && FileExt != "jpeg"
				&& FileExt != "txt" && FileExt != "ppt" && FileExt != "xml"
				&& FileExt != "xlsx" && FileExt != "xls" && FileExt != "png" && FileExt != "pptx")) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file is in pdf or doc or docx or xml or jpg or jpeg or xls or txt or png or ppt.\n\n";
			alert(error);
			fieldObj.value = "";
		} else if (FileSize > 1048576) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file size less than 1 MB.\n\n";
			alert(error);
			fieldObj.value = "";
			return false;
		}
		return true;
	}
</script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Exit Interview From</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns">
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      <div class="content-body">
      				<section id="horizontal-form-layouts">
      					<div class="row"> 
							<div class="col-xs-12">
								<h4>Broadcast Form</h4>
								<hr>
							</div>
						</div>
      					<div class="card">
	      					<div class="card-body collapse in">
			               		<div class="card-block">
									<div class="form-body">
										<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading"><h4 align="left">Broadcast Form</h4></div>
						<div class="panel-body">
							
								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<%
											int announcement_id = Integer.parseInt(request.getParameter("announcement_id"));
										%>
										<input type="hidden" name="announcement_id" id="announcement_id"
											value="<%=announcement_id%>">
										<%
											AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
											List<AnnouncementBean> listOfAnnouncement = allListSelfServiceDAO.getListOfAnnouncement(announcement_id);
											for (AnnouncementBean a : listOfAnnouncement) { %>
										<table class="table table-stripped table-hover">
											<tr>
												<td width="20%"><label>Title</label></th>
												<td>:</td>
												<td><%=a.getAnnouncement_title()%></td>
											</tr>
											<tr>
												<td><label>Description</label></td>
												<td>:</td>
												<td style="white-space: pre-wrap;"><%=a.getAnnouncement_description()%></td>
											</tr>
											<%if(!a.getAnnouncement_attachment().equalsIgnoreCase("-")){ %>
											<tr>
												<td><label>Attachment
													</label>
												</td>
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
																	title="<%=a.getAnnouncement_attachment()%>"></a>&nbsp;&nbsp;<a
																href="downloadAnnouncementAttachment?attachment=<%=a.getAnnouncement_attachment()%>">
																	<%=a.getAnnouncement_attachment()%></a>
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
											<%-- <tr>
												<td><label>Category</label></td>
												<td>:</td>
												<td>
													<div class="form-group">
													<%
															List<AnnouncementCategoryBean> listOfCategoryDetail  = allListSelfServiceDAO.getListOfAnnouncementCategoryDetail(announcement_id);
															for(AnnouncementCategoryBean a1 : listOfCategoryDetail){
														%>
														<%=a1.getRoleCategoryBean().getRole_category_name()%>&nbsp;&nbsp;&nbsp;
													 	<%}%>
													</div>
												</td>
											</tr> --%>
											<tr>
											<td><label>Broadcast By</label></td>
											<td>:</td>
											<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%>
											</td>
											</tr>
											<%-- 	<tr>
															<td><label>&nbsp;Category </label></td>
															<td>:</td>
															<%List<AnnouncementCategoryBean> listOfCategoryDetail  = allListSelfServiceDAO.getListOfAnnouncementCategoryDetail(announcement_id);
															if(listOfCategoryDetail.size() != 0){ %>
															<td>
															<%
															for(AnnouncementCategoryBean a1 : listOfCategoryDetail){ %>
															<%=a1.getRoleCategoryBean().getRole_category_name() %>,<%} %>
															</td>
															<%}else{ %>
															<td>No Category</td>
															<%} %>
														</tr>
														<tr>
															<td><label>&nbsp;Department </label></td>
															<td>:</td>
																<%
																	List<AnnouncementDepartmentBean> listOfDeparmentDetail = allListSelfServiceDAO
																				.getListOfAnnouncementDepartmentDetail(announcement_id);
																				if(listOfDeparmentDetail.size() != 0){
																					
																				
																				%>
															
															<td>
															
																		<% for (AnnouncementDepartmentBean a1 : listOfDeparmentDetail) {
																%> <%=a1.getDepartmentBean().getDepartment_name()%>,<%
																	}
																%>
															</td>
<%}else{%>
	<td>No Department</td>
<%}
	%>
														</tr>
														<tr>
															<td><label>&nbsp;Company </label></td>
															<td>:</td>
															<%
																	List<AnnouncementCompanyBean> listOfCompanyDetail = allListSelfServiceDAO
																				.getListOfAnnouncementCompanyDetail(announcement_id);
																				if(listOfCompanyDetail.size() != 0){
																				%>
															<td>
																
																		<% for (AnnouncementCompanyBean a1 : listOfCompanyDetail) {
																%> <%=a1.getCompanyListBean().getCompany_name()%>,<%
																	}
																%>
															</td>
															<%}else{ %>
															<td>No Company</td>
															<%} %>
														
														</tr> --%>
										</table>
										<%}%>
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
    <script src="app-assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js" type="text/javascript"></script>
    
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
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