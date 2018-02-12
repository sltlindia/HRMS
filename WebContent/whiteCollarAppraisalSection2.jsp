<%@page import="com.hrms.pms.bean.AppraisalWhiteCollarSection2Bean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.dao.AllInsertDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalWhiteSection1Bean"%>
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
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
 int employee_code = (int)request.getAttribute("employee_id");
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				 <div class="card">
				        	 <div class="card-header">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3>Section 2: Review of Past Performance</h3>
					<h4>(To be completed by the HOD / Appraiser)</h4></center>
					<hr>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<%AllListDAO allListDAO = new AllListDAO();
			int appraisal_id = (int) request.getAttribute("appraisal_id");
			System.out.print("app"+appraisal_id);
			AppraisalWhiteSection1Bean appraisalWhiteSection1Bean = allListDAO.getAppraisalQuestionDetail(appraisal_id);
			AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean = allListDAO.getAppraisalSection2QuestionDetail(appraisal_id);
			
			%>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
						<h4><font color="red">${duplicate}</font></h4>
				<form action="appraisalWhiteCollarSection2Insert" method="post">
				<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
				
				<%if(appraisalWhiteCollarSection2Bean != null){%>
				<input type="hidden" name="section2_id" value="<%=appraisalWhiteCollarSection2Bean.getAppraisal_white_sectoin2_id()%>">
				<%} %>
				
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-body collapse in">
									<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; ">
									<div class="panel-heading">
										<h4 class="panel-title">
											Review employee's input on "Roles and Responsibilities" and make any needed comments on additions, deletions, or changes.
										<%-- <i class="fa fa-comment-o" data-toggle="popover" data-placement="top" data-content="<%=appraisalWhiteSection1Bean.getRoles_Responsibility()%>"></i> --%>
									</h4>
									</div>
									<textarea class="form-control" rows="6" name="Roles"><%if(appraisalWhiteCollarSection2Bean != null){%><%=appraisalWhiteCollarSection2Bean.getRoles_and_responsibilities()%><%}else{%><%=appraisalWhiteSection1Bean.getRoles_Responsibility()%>
										<%}%></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											Review employee's input on "Major Accomplishments" and makes any needed comments on additions, deletions, or changes.
										<%-- <i class="fa fa-comment-o" data-toggle="popover" data-placement="top" data-content="<%=appraisalWhiteSection1Bean.getContribution_achievememt()%>"></i> --%>
									</h4>
									</div>
									<textarea class="form-control" rows="6" name="Accomplishments"><%if(appraisalWhiteCollarSection2Bean != null){%><%=appraisalWhiteCollarSection2Bean.getMajor_accomplishments()%><%}else{%>
										<%=appraisalWhiteSection1Bean.getContribution_achievememt()%>
										<%}%></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											Review employee's input on "Opportunities for Development" and makes any needed comments on additions, deletions, or changes.
										<%-- <i class="fa fa-comment-o" data-toggle="popover" data-placement="top" data-content="<%=appraisalWhiteSection1Bean.getOpportunities()%>"></i> --%>
									</h4>
									</div>
									<textarea class="form-control" rows="6" name="Opportunities"><%if(appraisalWhiteCollarSection2Bean != null){%><%=appraisalWhiteCollarSection2Bean.getOpportunities_for_development()%><%}else{%><%=appraisalWhiteSection1Bean.getObstacles()%>
										<%}%></textarea>
									<div class="panel-heading">
										<h4 class="panel-title">
											Identify next potential job/assignment, if appropriate, and timing. Discuss your view of employee's potential and career path. 
										<%-- <i class="fa fa-comment-o" data-toggle="popover" data-placement="top" data-content="<%=appraisalWhiteSection1Bean.getObstacles()%>"></i> --%>
									</h4>
									
									</div>
									<textarea class="form-control" rows="6" name="job/assignment"><%if(appraisalWhiteCollarSection2Bean != null){%><%=appraisalWhiteCollarSection2Bean.getJob_assignment()%><%}else{%><%=appraisalWhiteSection1Bean.getOpportunities()%>
										<%}%></textarea>
										<br>
									<center>
									<input type="submit" value="Continue" class="btn btn-primary"></a>
									<input type="reset" value="Cancel" class="btn btn-danger">
								</center>
							
							
								</div>
								</div>
								</div>
								
							</div>

							<!-- /.panel-body -->
							<input type="hidden"  name="employee_id" value="<%= employee_code%>">
							
				</form>


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
<script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>

</body>

</html>
