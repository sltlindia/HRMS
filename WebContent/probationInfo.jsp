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
    <title>SLTL HRMS</title>
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
    <%@include file="header.jsp" %>
</head>
<%-- <%
HttpSession probationSession = request.getSession();
session.setAttribute("probationSession", probationSession);
EmployeeBean probation = (EmployeeBean)session.getAttribute("probationSession");
if(user==null){ 
%> --%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
		<br>
		<h4 style="color: red">Probation Assessment Form can be applicable for only those employees whose joining month is NOVEMBER-2017 or after NOVEMBER-2017</h4>
			<div class="row">
				<div class="col-lg-12">
						<h3 class="page-header">Criteria to evaluate candidate- Knowledge,Skills and Attitude</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<form action="probationOpenInfopageInsert" method="post">
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h4 class="card-title" id="horz-layout-basic"><b><font size="2px">Criteria to evaluate candidate- Knowledge,Skills and Attitude</font></b></h4>
									<!-- <h5 class="card-title" id="horz-layout-basic">Please rate on scale of 1 to 5</h5> -->
				               		<!-- <h4 class="card-title" id="horz-layout-basic">Probation Confirmation Assessment Form</h4> -->
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<!-- <div class="panel panel-primary">
				<div class="panel-heading">
					<b>Criteria to evaluate candidate- Knowledge,Skills and Attitude</b>
				</div> -->
				<!-- /.col-lg-12 -->
                <div class="panel-body">
	<h4 style="color: #1276D3;"><b>Please keep in mind the following to while rating the candidate:</b></h4>
       <ol type="a" style="font-size: 15px;">
      	 	<li>The candidate is a trainee and will need time to improve.Please rate him as a fresher.</li>
      		<li>Keep in mind the present period for which he is being rated,and not the past.</li>
      		<li>Rate the candidate on only one attribute at a time.</li>
      		<li>Please remain as objective as possible.</li></h5>
       </ol>
	<hr>
	
	<h4 style="color: #1276D3;"><b>Knowledge & Abilities</b></h4>
       <ol type="1" style="font-size: 15px;">
      	 	<li>Ability to Connect Past Training/Education Qualifications to Tasks</li>
      		<li>Accuracy In Work</li>
      		<li>Number Of Tasks Completed(Task Volume)</li>
      		<li>Knowledge Of Department Processes</li>
      		<li>Ability To Work Without Supervision</li>
      		<li>Ability To Think Out Of T he Box</li>
       </ol>
	<hr>

	<h4 style="color: #1276D3 ;"><b>Skills</b></h4>
       <ol start="7" style="font-size: 15px;">
      	 	<li>Communication Skills</li>
      		<li>I.T. Skills</li>
      		<li>Decision Making Skills</li>
      		<li>Skill To Learn New Concepts</li>
       </ol>
	<hr>
	
	<h4 style="color: #1276D3 ;"><b>Attitude</b></h4>
       <ol start="11" style="font-size: 15px;">
      	 	<li>Openness To Accepting Mistakes</li>
      		<li>Ability To Work In A Team</li>
      		<li>Discipline And Punctuality</li>
      		<li>Initiative To Take Ownership And Deliver On Communication</li>
      		<li>Honesty And Integrity In Work</li>
       </ol>
	<hr>
	
	<h4 style="color: #1276D3 ;"><b>Key</b></h4>
	<div class="row">
       <div class="col-lg-12">
                    <div class="panel panel-default">
                        
                        <!-- /.panel-heading -->
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead style="font-size: 15px;"> 
                                        <tr align="center">
                                            <td width="250px" ><b>Assessment Period</b></td>
                                            <td width="250px"><b>Month</b></td>
                                            <td width="250px"><b>Score</b></td>
                                            <td width="250px"><b>Inference</b></td>
                                        </tr>
                                    </thead>
                                    <tbody style="font-size: 15px;">
                                        <tr align="center">
                                            <td>1</td>
                                            <td>Average of month 1 & 2</td>
                                            <td>40% / 35% / 30%</td>
                                            <td>R / W / T</td>
                                        </tr>
                                        <tr align="center">
                                            <td>2</td>
                                            <td>Average of month 3 & 4</td>
                                            <td>45% / 40% / 35%</td>
                                            <td>R / W / T</td>
                                        </tr>
                                        <tr align="center">
                                            <td>3</td>
                                            <td>Average of month 5 & 6</td>
                                            <td>55% / 50% / 45%</td>
                                            <td>R / W / T</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel -->
                </div>
              </div>
	
	<h5 style="color: #D31235 ;"><b>Note:</b></h5>
       <ol type="1" style="font-size: 15px;">
      	 	<li><b>Confirmation</b> is to be offered only if the candidate scores 65%< for two consecutive months.In case he/she score above the retain score % - but lesser than 65% - his/her probation period is deemed to have extended.</li>
      		<li><b>Maximum possible score for a given month/assessment period - </b>75/150</li>
      		<li><b>Key -</b> Retain (R) / Warn (W) / Terminate (T)</li>
       </ol>
	<hr>

	<h4 style="color: #1276D3 ;"><b>Rating Scale</b></h4>
      <font size="3px"> 
      		<p>1 - Very Poor</p>
      		<p>2 - Poor</p>
      		<p>3 - Good(Met Expectation)</p>
      		<p>4 - Very Good(Above Expectation)</p>
      		<p>5 - Excellent(Greatly Exceeded Expectation)</p>
      </font>

</div>
<center>
										<input
											type="submit" value="I read all criteria for probation assessment form" class="btn btn-primary">
									</center>
									<br>
									<br>
</div>
</div>
</div>
</div>
</div>

<%if(request.getParameter("employee_master_id") != null){ %>
<input type="hidden" name="employee_master_id" value="<%=request.getParameter("employee_master_id")%>">
<%} %>
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
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
            
<!-- <script src="datepicker/dcalendar.picker.js"></script>
<script>
$('#plannedStartDate').dcalendarpicker();
$('#plannedEndDate').dcalendarpicker();
$('#calendar-demo').dcalendar(); //creates the calendar
</script> -->
<%-- <%}else{ %>
 response.sendRedirect("probationForm.jsp");
<%} %> --%>
</body>
</html>