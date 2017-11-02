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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRMS</title>

</head>

<%@include file="header.jsp"%>
<script src="js/dropzone.js"></script>
<!-- <script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script> -->
<link rel="stylesheet" href="css/dropzone.css">
<body>
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

	<div id="wrapper">
		<div id="page-wrapper">



			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">CI MANAGEMENT</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>



			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
						
						<div class="row">
						
							<div class="col-md-6">
								CI Photos
							</div>
							
							
							<div class="col-md-6" align="right">
								<a href="kaizenList.jsp"><button class="btn btn-outline btn-primary btn-xs">Go To List</button></a>
								<a href="kaizenView.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn btn-outline btn-primary btn-xs">Go To CI</button></a>
							</div>
						
						</div>
					</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<%if(openStatus.equalsIgnoreCase("before")){ %>
								<li class="active"><a href="#home" data-toggle="tab">Before Photos</a></li>
								<%}else{ %>
								<li><a href="#home" data-toggle="tab">Before Photos</a></li>
								<%} %>
								
								
								<%
								if(openStatus.equalsIgnoreCase("after")){%>
								<li class="active"><a href="#profile" data-toggle="tab">After Photos</a></li>
								<%}else{ %>
								<li><a href="#profile" data-toggle="tab">After Photos</a></li>
								<%} %>
								
										
								
							
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
							
							<%if(openStatus.equalsIgnoreCase("before")){ %>
								<div class="tab-pane fade in active" id="home">
								<%}else{ %>
								<div class="tab-pane fade" id="home">
								<%} %>
							
									<h4>PHOTO UPLOAD - BEFORE CI</h4>

									<div class="row">
											<div class="panel-body">
												<form action="kaizenBeforeUploadAttachment"
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
												<div class="panel panel-primary">
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
												</div>
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
												<div class="panel panel-primary">
												<div class="panel-body">
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
												</div>
												
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


	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

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