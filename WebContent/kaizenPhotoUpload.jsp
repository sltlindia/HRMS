<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.selfservice.bean.SelfServiceTypeBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="java.util.List"%>
<%@page
	import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
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
    <title>HRMS</title>
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
    <link rel="stylesheet" type="text/css" href="dist/css/dropzone.css">
    <script src="dist/js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%

int kaizen_id = 0;

if(request.getParameter("kaizen_id") != null){
	kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
}else if(request.getAttribute("kaizen_id") != null){
	kaizen_id = (Integer) request.getAttribute("kaizen_id");
}

String befor_description = "";
String after_description = "";

AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);

if(kaizenBean.getBefore_description() != null && !kaizenBean.getBefore_description().equalsIgnoreCase("null")){
	befor_description = kaizenBean.getBefore_description();
}

if(kaizenBean.getAfter_description() != null && !kaizenBean.getAfter_description().equalsIgnoreCase("null")){
	after_description =  kaizenBean.getAfter_description();
}


String openStatus = "before";

if(request.getParameter("before_description") != null){
	openStatus = "before";
}else if(request.getParameter("after_description") != null){
	openStatus = "after";
}

%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">CI MANAGEMENT</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>

<div class="row">
				<div class="col-lg-12">
					<div class="card">
				       <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					                <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">CI Photos</h4>
				                </div>
				                <div class="col-md-6" align="right">
								<a href="kaizenList.jsp"><button class="btn btn-outline btn-primary btn-xs">Go To List</button></a>
								<a href="kaizenView.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn btn-outline btn-primary btn-xs">Go To CI</button></a>
								</div>
				     		</div>
				     <div class="card-body collapse in">
					        <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<!-- /.panel-heading -->
						<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        				<%if(openStatus.equalsIgnoreCase("before")){ %>
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#home" aria-expanded="true">Before Photos
								</a>
							</li>
							<%}else{ %>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#home" aria-expanded="true">Before Photos</a>
							</li>
							<%} %>
							<%
								if(openStatus.equalsIgnoreCase("after")){%>
							<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#profile" aria-expanded="true">After Photos
								</a>
							</li>
							<%}else{ %>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#profile" aria-expanded="true">After Photos</a>
							</li>
							<%} %>
						</ul>
                            <hr>	
							<!-- Nav tabs -->
							<%-- <ul class="nav nav-tabs nav-linetriangle no-hover-bg">
								<%if(openStatus.equalsIgnoreCase("before")){ %>
								<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#home" aria-expanded="true">Before Photos
								</a>
							</li>
								<%}else{ %>
								<li><a id="base-tab" href="#home" aria-expanded="true">Before Photos</a></li>
								<%} %>
								
								
								<%
								if(openStatus.equalsIgnoreCase("after")){%>
								<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#profile" aria-expanded="true">After Photos</a>
							</li>
								<%}else{ %>
								<li><a href="#profile" id="base-tab" href="#profile" aria-expanded="true">After Photos</a></li>
								<%} %>
								
							</ul>
							<hr> --%>

				
							<!-- Tab panes -->
							 <div class="tab-content">
							
							<%if(openStatus.equalsIgnoreCase("before")){ %>
								<div class="tab-pane fade in active" id="home">
								<%}else{ %>
								<div class="tab-pane fade" id="home">
								<%} %>
							
									<h4>PHOTO UPLOAD - BEFORE CI</h4>
									<div class="row">
											<div class="col-lg-12">
												<form action="kaizenAfterUploadAttachment"
													id="frmFileUpload" class="dropzone" method="post"
													enctype="multipart/form-data">

													<input type="hidden" name="kaizen_id"
														value="<%=kaizen_id%>">

													<div class="dz-message">
														<div class="col-lg-12">
															<i class="fa fa-upload fa-3x"></i>
														</div>
														<h3>Drop files here or click to upload.</h3>
														<em>(Once you select file(s).Files are automatically
															uploaded to server.)</em>
													</div>

													<div class="fallback">
														<input name="file" type="file" name="before_photo"
															id="before_photo" multiple="multiple" />
													</div>
												</form>

												<br>
												<form action="kaizenDescUpdate">
												<div class="row">
													<input type="hidden" name="kaizen_id" value="<%=kaizen_id%>">
														<div class="col-lg-12">
															<div class="col-lg-3">
																<label>Description Before CI:</label>
															</div>
															<div class="col-lg-9">
																<textarea rows="4" class="form-control"
																	name="before_description" placeholder="Max 500 words"><%=befor_description%></textarea>
															</div>
														</div>
												</div>
												<br>
												<div class="row">
												
												<%if(request.getAttribute("firstInsert") != null){%>
												<input type="hidden" name="firstInsert">
												<%} %>
												
												<center>
															<input type="submit" value="Submit" class="btn btn-primary">
															<input type="reset" value="Cancel" class="btn btn-danger">
															<a href= "kaizenView.jsp?kaizen_id=<%=kaizen_id%>"><input type="button" value="Skip" class="btn btn-info"></a>
														</center>
												</div>
												</form>
												
												
												<br>
												
					                <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 9px;">
					                    <h5 class="card-title">Photo List</h5>
					                </div>
					                <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					                    <!-- <div class="card-block border-bottom-blue-grey" style="padding:0;"> -->
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
												<div class="col-md-1 col-sm-2 col-xs3">
														<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;" 
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/><br>
														<br>
														<a href="kaizenAttachmentDelete?attachment_id=<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_upload_attachment_id()%>&kaizenBefore=kaizenBefore&kaizen_id=<%=kaizen_id%>"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a>
														</div>
												<%} %>
												
								</div>
								</div>
									<%-- <div class="panel panel-primary">
												<div class="panel-body">
												
														<h5><b>Photo List</b></h5>
														<div class="row">
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
												<div class="col-md-1 col-sm-2 col-xs3">
														<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;" 
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/><br>
														<br>
														<a href="kaizenAttachmentDelete?attachment_id=<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_upload_attachment_id()%>&kaizenBefore=kaizenBefore&kaizen_id=<%=kaizen_id%>"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a>
														</div>
												<%} %>
												</div>
																					
												</div>
												</div> --%>
										</div>
									</div>


								</div>
								
								<%if(openStatus.equalsIgnoreCase("after")){ %>
								<div class="tab-pane fade in active" id="profile">
								<%}else{ %>
								<div class="tab-pane fade" id="profile">
								<%} %>
								
									<h4>PHOTO UPLOAD - AFTER CI</h4>

									<div class="row">
											<div class="panel-body">
												<form action="kaizenAfterUploadAttachment"
													id="frmFileUpload" class="dropzone" method="post"
													enctype="multipart/form-data">

													<input type="hidden" name="kaizen_id"
														value="<%=kaizen_id%>">

													<div class="dz-message">
														<div class="col-lg-12">
															<i class="fa fa-upload fa-3x"></i>
														</div>
														<h3>Drop files here or click to upload.</h3>
														<em>(Once you select file(s).Files are automatically
															uploaded to server.)</em>
													</div>

													<div class="fallback">
														<input name="file" type="file" name="after_photo"
															id="after_photo" multiple />
													</div>
												</form>
 
												<br>
												<form action="kaizenDescUpdate">
												<div class="row">
													<input type="hidden" name="kaizen_id" value="<%=kaizen_id%>">
														<div class="col-lg-12">
															<div class="col-lg-3">
																<label>Description After CI:</label>
															</div>
															<div class="col-lg-9">
																<textarea rows="4" class="form-control"
																	name="after_description"><%=after_description %></textarea>
															</div>
														</div>
												</div>
												<br>
												<div class="row">
															<center>
															<input type="submit" value="Submit" class="btn btn-primary">
															<input type="reset" value="Cancel" class="btn btn-danger">
															<a href= "kaizenView.jsp?kaizen_id=<%=kaizen_id%>"><input type="button" value="Skip" class="btn btn-info"></a>
														</center>
														</div>
												</form>
												<br>
												
												
												<br>
												
								<div class="card box-shadow-0" data-appear="appear">
					                <div class="card-header card-inverse" style="background-color: #967ADC;padding: 9px;">
					                    <h5 class="card-title">Photo List</h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey" style="padding:0;">
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" 
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/><br><br>
														<a href="kaizenAttachmentDelete?attachment_id=<%=kaizenAfterUploadAttachmentBean.getKaizen_after_upload_attachment_id()%>&kaizenAfter=kaizenAfter&kaizen_id=<%=kaizen_id%>"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a>
												<%} %>
												
								</div>
								</div>
								</div>
											
												<%-- <div class="card box-shadow-0" data-appear="appear">
													<div class="card-body collapse in">
														<h5><b>Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" 
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/><br><br>
														<a href="kaizenAttachmentDelete?attachment_id=<%=kaizenAfterUploadAttachmentBean.getKaizen_after_upload_attachment_id()%>&kaizenAfter=kaizenAfter&kaizen_id=<%=kaizen_id%>"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a>
												<%} %>
																					
												</div>
												</div> --%>
												
											</div>
									</div>


								</div>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
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
	<!-- <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                FILE UPLOAD - DRAG & DROP OR WITH CLICK & CHOOSE
                                <small>Taken from <a href="http://www.dropzonejs.com/" target="_blank">www.dropzonejs.com</a></small>
                            </h2>
                            <ul class="header-dropdown m-r--5">
                                <li class="dropdown">
                                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="material-icons">more_vert</i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li><a href="javascript:void(0);">Action</a></li>
                                        <li><a href="javascript:void(0);">Another action</a></li>
                                        <li><a href="javascript:void(0);">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="body">
                            <form action="/" id="frmFileUpload" class="dropzone" method="post" enctype="multipart/form-data">
                                <div class="dz-message">
                                    <div class="drag-icon-cph">
                                        <i class="material-icons">touch_app</i>
                                    </div>
                                    <h3>Drop files here or click to upload.</h3>
                                    <em>(This is just a demo dropzone. Selected files are <strong>not</strong> actually uploaded.)</em>
                                </div>
                                <div class="fallback">
                                    <input name="file" type="file" multiple />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div> -->


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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->

	<!-- <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script> -->

<script>
	  $("[data-toggle=popover]")
	    .popover({html:true})
	    
	    $('.popover-dismiss').popover({
	  	trigger: 'focus'
		})
	</script>

</body>
</html>