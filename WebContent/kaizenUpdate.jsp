<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenMemberBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
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
    <title>Kaizen Update</title>
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
<script>									
	function checkInteger(id) {
		
			var a = document.getElementById(id).value;
		
		if(isNaN(a)){
			alert("Cost should be only in digits.Please enter digits only!!!");
			document.getElementById(id).value = "";
		}
		
	}
	
	</script>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int kaizen_id = 0;

if(request.getParameter("kaizen_id") != null){
	kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
}else if(request.getAttribute("kaizen_id") != null){
	kaizen_id = (Integer) request.getAttribute("kaizen_id");
}
AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
List<KaizenManagerBean> listOfManager = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id); 

session.setAttribute("updateSession", "rejection");
%>

 <div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Update CI</h1>
						</div>
					</div>

	<div class="row">
				<div class="col-lg-12">
					<div class="card">
				        	<div class="card-header">
				        		<div class="col-lg-6">
				               		<h4 class="card-title" id="horz-layout-basic">UPDATE CI</h4>
				                </div>

<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update CI</h1>
				</div>
				/.col-lg-12
			</div>
			/.row

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">UPDATE CI</div>
						<div class="panel-body"> -->

		<%-- <%if(kaizenBean.getCompletion_status().equalsIgnoreCase("saved")){%> --%>
				<div class="panel-body">
							<form action="kaizenUpdate" method="post" name=""
								enctype="multipart/form-data">
								
								
								<%if(request.getParameter("reject") != null){%>
											<input type="hidden" name="reject" value="rejectionUpdate">
									 		<%} %>
								
								
								<input type="hidden" name="kaizen_id" value="<%=kaizenBean.getKaizen_id()%>">
								<input type="hidden" name="date" value="<%=kaizenBean.getDate()%>">
								<input type="hidden" name="status" value="<%=kaizenBean.getStatus()%>">
								<input type="hidden" name="before_desc" value="<%=kaizenBean.getBefore_description()%>">
								<input type="hidden" name="after_desc" value="<%=kaizenBean.getAfter_description()%>">
								<input type="hidden" name="reason" value="<%=kaizenBean.getRejection_reason()%>">
								<input type="hidden" name="completion_status" value="<%=kaizenBean.getCompletion_status()%>">
								<input type="hidden" name="emp_id" value="<%=kaizenBean.getEmployeeBean().getEmployee_master_id()%>">
								<input type="hidden" name="manager_id" value="<%=kaizenBean.getManager_id()%>">
								<input type="hidden" name="problem_id" value="<%=kaizenBean.getKaizenProblemIdentificationBean().getKaizen_problem_identification_id()%>">

								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped">
										
										<tr>
											
											
											<td colspan="4"><label>Problem Identification </label>
											<textarea rows="" cols="" class="form-control" name="existing_problem"><%=kaizenBean.getKaizenProblemIdentificationBean().getProblem_description()%></textarea>
												</td>
												
												<td>
												<label>Category</label>
												<select class="form-control"
													name="category" onchange="departmentHideShow(this.value);">
													<option value="">---Select Category---</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("A")){%><option value="A" selected="selected"><%}else{%><option value="A"><%}%>A : Can be improved by self</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("B")){%><option value="B" selected="selected"><%}else{%><option value="B"><%}%>B : Can be improved by help of other Department</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("C")){%><option value="C" selected="selected"><%}else{%><option value="C"><%}%>C : Can be improved by help of Management</option>
												</select>
												</td>
											
											
											
											
										</tr>	
										
										
											<tr>
												<td><label>CI Name</label>
												<input class="form-control" type="text" name ="kaizen_name" placeholder="Kaizen name" value="<%=kaizenBean.getKaizen_name()%>" required>
												</td>

												<td colspan="6" maxlength="825"><label>Improvement Plan</label>
												<textarea name="description" maxlength="700" class="form-control" placeholder="Max 800 words"><%=kaizenBean.getKaizen_desc()%></textarea>
												</td>
												
											</tr>
										


											<tr>
											<td colspan="3">
											<label>Projected Saving : </label> 
												<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" checked="checked" > Delivery 
												<%}else{ %>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" > Delivery 
												<%} %>
												
												
												<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" checked="checked" > Cost 
												<%}else{ %>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" > Cost 
												<%} %>
												
												
												
												<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" checked="checked" > Quality
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" > Quality
												<%} %>
												
												<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" checked="checked" > Safety
												<%}else{ %>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" > Safety
												<%} %>
												
												<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" checked="checked" > Productivity
												<%}else{ %>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" > Productivity
												<%} %>
												</td>
												
												
												<td colspan="3"><label>Impletation Cost <i class="fa fa-question-circle"
													style="cursor: pointer;" data-toggle="tooltip"
													data-placement="top" title="title"></i></label>
												<input type="text"
													name="implementation_cost" id="implementationCount" class="form-control" value="<%=kaizenBean.getImplementation_cost()%>" onchange="checkInteger(this.id);" ></td>
											</tr>

<tr>
												<td id="timeField">
												<label>Time Saving (Delivery)</label>
													<textarea maxlength="75" name="time_saving" id="time_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getDelivery()%></textarea>
												</td>
												
												
												<td id="moneyField">
													<label>Money Saving (Cost)</label>
													<textarea maxlength="75" name="money_saving" id="money_saving" class="form-control" onchange="checkInteger(this.id);"><%=kaizenBean.getCost()%></textarea>
												</td> 
												
												
												<td id="effortField">
													<label>EffortSaving (Quality)</label>
													<textarea maxlength="75" name="effort_saving" id="effort_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getQuality()%></textarea>
												</td>
												
												<td id="safetyField">
													<label>Safety</label>
													<textarea maxlength="75" name="safety_saving" id="safety_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getSafety()%></textarea>
												</td>
												
												
												<td id="productivityField">
													<label>Productivity</label>
													<textarea maxlength="75" name="productivity_saving" id="productivity_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getProductivity()%></textarea>
												</td>
											</tr>
											

										</table>
														<input type="hidden" name="update">

									</div>
									<center>
										<input type="hidden" name="redirection">
										<input type="submit" value="UPDATE" class="btn btn-primary">
									</center>
									<br>

								</div>
							</form>
<%-- <%}else if(kaizenBean.getCompletion_status().equalsIgnoreCase("submitted")) {%>

							<form action="kaizenUpdate" method="post" name=""
								enctype="multipart/form-data">
								
								
								<input type="hidden" name="kaizen_id" value="<%=kaizenBean.getKaizen_id()%>">
								<input type="hidden" name="date" value="<%=kaizenBean.getDate()%>">
								<input type="hidden" name="status" value="<%=kaizenBean.getStatus()%>">
								<input type="hidden" name="before_desc" value="<%=kaizenBean.getBefore_description()%>">
								<input type="hidden" name="after_desc" value="<%=kaizenBean.getAfter_description()%>">
								<input type="hidden" name="reason" value="<%=kaizenBean.getRejection_reason()%>">
								<input type="hidden" name="completion_status" value="<%=kaizenBean.getCompletion_status()%>">

								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped">
										
										
										
										<tr>
											
											
											<td colspan="4"><label>Problem Identification </label>
												<input type="hidden" name="existing_problem" value="<%=kaizenBean.getExisting_problem()%>">
												<p style="white-space: pre-wrap;"><%=kaizenBean.getExisting_problem()%></p>
												</td>
												
												<td>
												<label>Category</label>
													<input type="hidden" class="form-control"  name="category" id="category" value="<%=kaizenBean.getCategory_id()%>" onchange="departmentHideShow(this.value);" readonly="readonly">
												<p><%=kaizenBean.getCategory_id()%></p>
												</td>
											
											
											
										</tr>	
										
										
										<tr>
												<td><label>CI Name</label>
												<input class="form-control" type="text" name ="kaizen_name" placeholder="Kaizen name" value="<%=kaizenBean.getKaizen_name()%>" readonly="readonly" required>
												</td>

												<td colspan="6" maxlength="825"><label>Improvement Plan</label>
												<textarea name="description" maxlength="700" class="form-control" placeholder="Max 800 words" readonly="readonly"><%=kaizenBean.getKaizen_desc()%></textarea>
												</td>
												
											</tr>
										
										
									
											<tr>
												
											</tr>


											<tr>
											<td colspan="3">
											<label>Projected Saving : </label> 
												<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" checked="checked" > Delivery 
												<%}else{ %>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" > Delivery 
												<%} %>
												
												
												<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" checked="checked" > Cost 
												<%}else{ %>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" > Cost 
												<%} %>
												
												
												
												<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" checked="checked" > Quality
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" > Quality
												<%} %>
												
												<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" checked="checked" > Safety
												<%}else{ %>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" > Safety
												<%} %>
												
												<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" checked="checked" > Productivity
												<%}else{ %>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" > Productivity
												<%} %>
												</td>
												
												
												<td colspan="3"><label>Impletation Cost <i class="fa fa-question-circle"
													style="cursor: pointer;" data-toggle="tooltip"
													data-placement="top" title="title"></i></label>
												<input type="text"
													name="implementation_cost" class="form-control" value="<%=kaizenBean.getImplementation_cost()%>" readonly="readonly"></td>
											</tr>

<tr>
												<td id="timeField">
												<label>Time Saving (Delivery)</label>
													<textarea name="time_saving" id="time_saving" class="form-control"><%=kaizenBean.getDelivery()%></textarea>
												</td>
												
												
												<td id="moneyField">
													<label>Money Saving (Cost)</label>
													<textarea name="money_saving" id="money_saving" class="form-control" onchange="checkInteger(this.id);"><%=kaizenBean.getCost()%></textarea>
												</td>
												
												
												<td id="effortField">
													<label>Effort Saving (Quality)</label>
													<textarea name="effort_saving" id="effort_saving" class="form-control"><%=kaizenBean.getQuality()%></textarea>
												</td>
												
												<td id="safetyField">
													<label>Safety</label>
													<textarea name="safety_saving" id="safety_saving" class="form-control"><%=kaizenBean.getSafety()%></textarea>
												</td>
												
												
												<td id="productivityField">
													<label>Productivity</label>
													<textarea name="productivity_saving" id="productivity_saving" class="form-control"><%=kaizenBean.getProductivity()%></textarea>
												</td>
											</tr>
											

										</table>
														<input type="hidden" name="update">

									</div>
									<center>
										<input type="hidden" name="redirection">
										<input type="submit" value="UPDATE" class="btn btn-primary">
									</center>
									<br>

								</div>
							</form>


<%} %> --%>
						</div>
						<!-- /.panel -->
						</div>
					</div>
					<!-- /.col-lg-12 -->
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
	  $("[data-toggle=popover]")
	    .popover({html:true})
	    
	    $('.popover-dismiss').popover({
	  	trigger: 'focus'
		})
	</script>
	
	
	<script>
		window.onload = function() {
			<%if(kaizenBean.getDelivery().equalsIgnoreCase("")){%>
			$('#timeField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getCost() .equalsIgnoreCase("")){%>
			$('#moneyField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getQuality().equalsIgnoreCase("")){%>
			$('#effortField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getSafety().equalsIgnoreCase("")){%>
			$('#safetyField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getProductivity().equalsIgnoreCase("")){%>
			$('#productivityField').fadeOut('fast');
			<%}%>
		}
	</script>
	
	<script>
		function projectedSaving() {
			if ($('#Time').is(":checked")) {
				$('#timeField').fadeIn('slow');

			} else {
				$('#time_saving').val('');
				$('#timeField').fadeOut('slow');

			}
			if ($('#Money').is(":checked")) {
				$('#moneyField').fadeIn('slow');
			} else {
				$('#money_saving').val('');
				$('#moneyField').fadeOut('slow');

			}
			if ($('#Effort').is(":checked")) {
				$('#effortField').fadeIn('slow');

			} else {
				$('#effort_saving').val('');
				$('#effortField').fadeOut('slow');
			}
			
			if ($('#Safety').is(":checked")) {
				$('#safetyField').fadeIn('slow');

			} else {
				$('#safety_saving').val('');
				$('#safetyField').fadeOut('slow');
			}
			
			if ($('#Productivity').is(":checked")) {
				$('#productivityField').fadeIn('slow');

			} else {
				$('#productivity_saving').val('');
				$('#productivityField').fadeOut('slow');
			}
		}

	</script>


</body>
</html>