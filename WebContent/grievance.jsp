<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="java.util.List"%>
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
    <title>Upload Document</title>
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
    <!-- END VENDOR CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END ROBUST CSS-->
     <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/ui/prism.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/tags/bootstrap-tagsinput.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/tags/tagging.css">
    <!-- BEGIN Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <style type="text/css">
	.timepicker_wrap {
		padding: 10px;
		border-radius: 5px;
		z-index: 998;
		display: none;
		box-shadow: 2px 2px 5px 0 rgba(50, 50, 50, 0.35);
		background: #f6f6f6;
		border: 1px solid #ccc;
		float: left;
		position: absolute;
		top: 27px;
		left: 0;
		width: 280px;
		format: 'HH:mm';
		showMeridian: false;
	}
	
	textarea {
		/* box-sizing: padding-box; */
		overflow: hidden;
		/* demo only: */
		padding: 10px;
		width: 100%;
		font-size: 14px;
	}
	</style>
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
			error += "Please make sure your file is in pdf , doc ,docx , xml , jpg , jpeg , xls , txt , png or ppt.";
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
    <%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12">
					<h2 class="content-header-title mb-0">Grievance Management</h2>
				</div>
			</div>
			<div class="content-body">
				<section id="striped-row-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="striped-row-layout-basic">Grievance</h4>
							</div>

							<div class="card-body collapse in">
								<div class="card-block">
									<form action="grievanceQueryInsert" class="form form-horizontal form-bordered" method="post" name="" enctype="multipart/form-data">
										<div class="form-body">
											<div class="form-group row">
												<label class="col-md-3 label-control">Type</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
														<select class="form-control" name="grievance_query_type_id" required="required">
															<option value="">--- Select Type ---</option>
															<%AllListGrievanceDAO allListDAO = new AllListGrievanceDAO();
															List<GrievanceQueryTypeBean> listOfGrievanceQueryType = allListDAO.getListOfGrievanceQueryType();
												 	          for (GrievanceQueryTypeBean g : listOfGrievanceQueryType){%>
															<option value="<%=g.getGrievance_query_type_id()%>,<%=g.getGrievance_query_type()%>"><%=g.getGrievance_query_type()%></option>
															<%}%>
														</select>
														<div class="form-control-position">
															<i class="icon-paper-stack"></i>
														</div>
													</div>
												</div>
											</div>
											
											<div class="form-group row">
												<label class="col-md-3 label-control" for="Description">Query</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
														<textarea name="query" id="query" rows="5"
															class="form-control" placeholder="Max. 10000 words"
															required="required"></textarea>
														<div class="form-control-position">
															<i class="icon-file2"></i>
														</div>
													</div>
												</div>
											</div>
											
											<div class="form-group row">
												<label class="col-md-3 label-control">Select File<br>
													(.pdf, .doc, .docx, .jpg, .png,
														.jpeg, .txt, .ppt, .xml, .xlsx, .xls, .png, .pptx)
												</label>
												<div class="col-md-9">
													<label id="projectinput7" class="file center-block">
														<input type="file" name="attachment" value=""
														id="attachment_id" onchange="checkFile(this)" /> <a
														style="cursor: pointer;">
														
														<!-- <input type="file" value="Browse" class="form-control" name="attachment" id="attachment_id" onchange="checkFile(this)"> -->
															<i class="fa fa-times"></i>
													</a> <span class="file-custom"></span>
													</label>
												</div>
											</div>
											
											<div class="form-group row">
												<label class="col-md-3 label-control">Addition Email-Id<br>(Enter Multiple Email-Ids Using Tab key.)</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
							                                <input type="text" value="" data-role="tagsinput" class="form-control typeahead-tags" width="100px"/>
													</div>
												</div>
											</div>
											
											<div class="form-actions right">
												<button type="reset" class="btn btn-warning mr-1">
													<i class="icon-cross2"></i> CANCEL
												</button>
												<input type="hidden" name="redirection">
												<button type="submit" class="btn btn-primary">
													<i class="icon-check2"></i> SUBMIT
												</button>
											</div>
											
											<input type="hidden" name="redirect" >
										</div>
									</form>
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
    <!-- /build-->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/forms/tags/bootstrap-tagsinput.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/forms/tags/tagging.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/prism.min.js" type="text/javascript"></script>
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/forms/tags/tagging.min.js" type="text/javascript"></script>
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
			