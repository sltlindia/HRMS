<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="java.util.List"%>
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
    <title>Appraisal</title>
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
<%@include file="header.jsp"%>
<script type="text/javascript">
function statusChange(id) {
	if(id==1){
	document.getElementById('status').value="pending";	
	
	var retVal = confirm("After Click On this Button you can update your Data in future..");
	if(retVal == true){
		document.getElementById('whiteCollarSection3Insert').submit();
	}
	
	}else if(id==2){
		var retVal = confirm("Are you sure you want to lock Data? Once you lock the Data you can't Update Data.");
		document.getElementById('status').value="approved";		
		if(retVal == true){
			document.getElementById('whiteCollarSection3Insert').submit();
		}
		
	}
}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				 <div class="card">
				        	 <div class="card-header">
			<div class="row">
				<div class="col-lg-12">
					<center><h1 class="page-header">
						Section 3: Summary Of Performance</h3>
					(To be completed by Appraisee & Appraiser after Performance Review Session)</h1></center>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3>Section 3: Summary Of Performance</h3>
					<h4>(To be completed by Appraisee & Appraiser after Performance Review Session)</h4></center>
					<hr>
				</div>
				/.col-lg-12
			</div>
			/.row -->
			<div class="row">
				<div class="col-lg-12">
				<form action="whiteCollarSection3Insert" id="whiteCollarSection3Insert" method="get">
				<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
				<%
				AllListDAO allListDAO = new AllListDAO();
				int appraisal_id = (Integer) request.getAttribute("appraisal_id");
				List<AppraisalBean> listOfAppriasal = allListDAO.getappraisal(appraisal_id);
				String comment = "";
				for(AppraisalBean appraisalBean : listOfAppriasal){
					comment = appraisalBean.getAppraiser_commnet();
				}
				%>
				
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">3B - Appraiser's Comments:</a>
										</h4>
									</div>
									<textarea class="form-control" rows="6" name="b_cmt"><%=comment%></textarea>
									<div class="panel-heading" style="visibility: hidden;">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">3C - Reviewing Officer's Comments (If any):</a>
										</h4>
									</div>
									<!-- <textarea class="form-control" rows="6" name="r_cmt" style="visibility: hidden;"></textarea> -->
									<input type="hidden" name="r_cmt">
									<input type="hidden" id="status" name="status" value="">
									<center>
									<input type="button" value="Save" class="btn btn-primary" onclick="statusChange(1)">
									<input type="button" value="Lock" class="btn btn-success" onclick="statusChange(2)">
								</center>
									<h4 style="color: red;">
									 &nbsp;&nbsp;Note : 
									</h4>
									
									<p>&nbsp;&nbsp;<font style="color: red;"><b>SAVE</b></font> : If You Click on save button you can update appraisal Go to Dashboard --> Appraisal Notification</p>
									<p>&nbsp;&nbsp;<font style="color: red;"><b>LOCk</b></font> : Once You Lock the Data you can not Edit appraisal.</p>
								</div>
							</div>

							<!-- /.panel-body -->
							
							
							
							
				</form>



					<!-- /.panel -->
				<!-- /.col-lg-12 -->
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
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>


</body>

</html>
