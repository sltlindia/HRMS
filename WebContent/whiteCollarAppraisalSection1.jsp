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
    <!-- END Custom CSS-->
<script type="text/javascript">

window.onload = function auto(){
	
	document.getElementById("year22").disabled = true;
	$("#year22").hide();
	document.getElementById("year33").disabled = true;
	$("#year33").hide();
}

function monthDisabled(value) {
	if(value == "monthly"){
		document.getElementById("month").disabled = false;
		document.getElementById("year22").disabled = true;
		document.getElementById("year11").disabled = false;
		document.getElementById("year33").disabled = true;
		$("#year22").hide();
		$("#year33").hide();
		$("#year11").show();
		$("#month").show();
		
	}else if(value == "yearly"){
		document.getElementById("month").disabled = true;
		document.getElementById("year11").disabled = true;
		document.getElementById("year22").disabled = false;
		document.getElementById("year33").disabled = true;
		$("#year33").hide();
		$("#year11").hide();
		$("#year22").show();
		$("#month").hide();
	}else if(value == "quarterly"){
		document.getElementById("month").disabled = true;
		document.getElementById("year11").disabled = false;
		document.getElementById("year33").disabled = false;
		document.getElementById("year22").disabled = true;
		$("#year33").show();
		$("#year11").show();
		$("#year22").hide();
		$("#month").hide();
	}
}
</script>
</head>
<%@include file="header.jsp" %>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%int appraisal_id = 0;
int year_id =0;

if(request.getParameter("appraisal_id") != null){
	appraisal_id =Integer.parseInt(request.getParameter("appraisal_id"));
}else{
	appraisal_id = (Integer) request.getAttribute("appraisal_id");
}


if(request.getParameter("year_id") != null){
	year_id = Integer.parseInt(request.getParameter("year_id"));
}else{
	year_id = (Integer) request.getAttribute("year_id");
}
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
				<div class="card-header">
			<div class="row">
				<div class="col-lg-12">
					<center><h3 class="page-header">Section 1: Self-Appraisal</h3>
					<h4>(To be completed by Employee / Appraisee)</h4></center>
					<hr>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3>Section 1: Self-Appraisal</h3>
					<h4>(To be completed by Employee / Appraisee)</h4></center>
					<hr>
				</div>
				/.col-lg-12
			</div> -->
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					
						<h4><font color="red">${duplicate}</font></h4>
				<form action="whiteCollarSection1Insert" method="get" name="">
				<input type="hidden" name="appraisal_id" value="<%=appraisal_id%>">
				<input type="hidden" name="year_id" value="<%=year_id%>">
				
				<div class="card-body collapse in">
				<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; ">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											Describe your key roles & responsibility in the organization
										</h4>
									</div>
									<textarea class="form-control" rows="6" name="roles" placeholder="max 1000 words" required="required"></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											List out your major contributions / achievements this year (Other than goals/objectives)
										</h4>
									</div>
									<textarea class="form-control" rows="6" name="contributions" placeholder="max 1000 words" required="required"></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											What are the obstacles you have found in your growth?
										</h4>
									</div>
									<textarea class="form-control" rows="6" name="obstacles" placeholder="max 1000 words" required="required"></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											Identify opportunities for development, which could benefit you in current or future assignments. Development activities may include strength you wish to enhance, new area for you, or areas which need improvement.
										</h4>
									</div>
									<textarea class="form-control" rows="6" name="opportunities" placeholder="max 1000 words" required="required"></textarea>
									
								</div>

							<!-- /.panel-body -->
							<br>
								<center>
										<input type="submit" value="Next" class="btn btn-primary"></a>
										<input type="reset" value="Cancel" class="btn btn-danger">
								</center>
						</div>	
						</div>
						
				</form>

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
