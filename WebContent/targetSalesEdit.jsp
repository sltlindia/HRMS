<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.incentive.bean.TargetBean"%>
<%@page import="com.hrms.incentive.bean.LaserMasterBean"%>
<%@page import="com.hrms.incentive.bean.ClassificationBean"%>
<%@page import="com.hrms.incentive.bean.ProductMasterBean"%>
<%@page import="com.hrms.incentive.bean.ZoneBean"%>
<%@page import="com.hrms.incentive.bean.SalespersonBean"%>
<%@page import="com.hrms.incentive.dao.AllIncentiveListDAO"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//Dlabel HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dlabel">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Sales Target</title>
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
	<%int month;
int year1;
GregorianCalendar date1 = new GregorianCalendar();    
year1 = date1.get(Calendar.YEAR);
 %>
	<%int employee_master_id1 = user.getEmployee_master_id(); 
	int sales_target_id = Integer.parseInt(request.getParameter("sales_target_id"));
	
	AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();
	
	TargetBean targetBean = allIncentiveListDAO.getListOfTargetById(sales_target_id);
	
	
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        	 <h1 class="page-header">Sales Person Target</h1>
				        	 <br>
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Basic Information</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
	
 							<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
								<li class="nav-item"><a href="#target" data-toggle="tab" class="nav-link active">Sales
										Person Target </a></li>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane fade in active" id="complaint">
									
									<form action="targetEdit" method="post">
										<input type="hidden" name="sales_target_id" value="<%=sales_target_id%>">
										
										<br>
										<div class="row">

											<div class="col-lg-3">
												<label>Sales Person </label> &nbsp;&nbsp;&nbsp;<label>
													: </label>&nbsp;&nbsp;&nbsp; <select class="form-control"
													name="sales" id="sales" required="required">
													<option value="">---Select Sales Person---</option>
													<%
                                          
											AllIncentiveListDAO salesList = new AllIncentiveListDAO();
                                         	 List<SalespersonBean> listofSales = salesList.getnameOfsales();
                 						 	for (SalespersonBean s : listofSales){
                 			if(targetBean.getSalespersonBean().getSales_person_id() == s.getSales_person_id()){
                                          
                                          %>
													<option value="<%=s.getSales_person_id()%>" selected="selected"><%=s.getFirstname()+" "+s.getLastname()%></option>
													<%}else{ %>
													<option value="<%=s.getSales_person_id()%>"><%=s.getFirstname()+" "+s.getLastname()%></option>
													<%} %>
													<%} %>
												</select>
											</div>
											<div class="col-lg-2">
												<label>Target</label> <input type="text"
													class="form-control" name="target" id="target"
													placeholder="Enter target value" value="<%=targetBean.getTarget_value() %>" required>
											</div>
											
											
											<div class="col-lg-3">
												<label>Product</label>
												<div>
													<select class="form-control" name="product" id="product"
														required="required">
														<option value="">---Select Product---</option>
														<%
                                          
											AllIncentiveListDAO productList = new AllIncentiveListDAO();
                                         	 List<ProductMasterBean> listofProduct = productList.getnameOfproduct();
                 						 	for (ProductMasterBean p : listofProduct){
                 			if(targetBean.getProductMasterBean().getProduct_master_id() == p.getProduct_master_id()){
                                          
                                          %>
														<option value="<%=p.getProduct_master_id()%>" selected="selected"><%=p.getProduct_name()%></option>
														<%}else{ %>
														<option value="<%=p.getProduct_master_id()%>"><%=p.getProduct_name()%></option>
														<%} %>
														<%} %>
													</select>
												</div>
											</div>
											
											
											
											<div class="col-lg-2">

												<label>Invoice Month</label>
												<div>
													<select class="form-control" name="month_id" id="month"
														required="required">
														<option value="">---Month---</option>
														<%
                                          
											AllListDAO monthList = new AllListDAO();
                                         	 List<MonthBean> listOfMonth = monthList.getListOfMonth();
                 						 	for (MonthBean m : listOfMonth){
                 						 		if(m.getMonth_id() !=0 && m.getMonth_id() <13){
                 						 			if(m.getMonth_id() == targetBean.getMonthBean().getMonth_id()){
                                          
                                          %>
														<option value="<%=m.getMonth_id()%>" selected="selected"><%=m.getMonth_name()%></option>
														<%}else{ %>
														<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>
														<%} %>
														<%} }%>
													</select>
												</div>
											</div>
											
											
											
											<div class="col-lg-2">
												<label>Year</label>
												<div>
													<select class="form-control" name="year_id" id="year11"
														required="required">
														<option value="">---Year---</option>
														<%
										AllListDAO yearList  = new AllListDAO();
                                          List<YearBean> listOfYear = yearList.getListOfYear();
                 						 	for (YearBean y : listOfYear){
                 						 		if(Integer.parseInt(y.getYear()) <= year1){
                 						 			
                 						 			if(y.getYear_id() == targetBean.getYearBean().getYear_id()){
                                          %>
														<option value="<%=y.getYear_id()%>" selected="selected"><%=y.getYear()%>-<%=Integer.parseInt(y.getYear()) + 1%></option>
														<%}else{ %>
														<option value="<%=y.getYear_id()%>"><%=y.getYear()%>-<%=Integer.parseInt(y.getYear()) + 1%></option>
														<%} %>
														<%} }%>
													</select>
												</div>


											</div>
											
											
										</div>

										<br>
										<!-- /.row -->
										<input type="hidden" name="redirect" value="">
										<center>
											<input type="submit" value="Update" class="btn btn-primary">
										</center>

									</form>
								</div>


							</div>


						</div>
					</div>


					<br>


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
        $('#dataTables-example1').DataTable({
            responsive: true
    });
        $('#dataTables-example2').DataTable({
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
