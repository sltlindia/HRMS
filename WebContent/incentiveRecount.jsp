<%@page import="com.hrms.incentive.bean.AmountHistoryBean"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hrms.incentive.bean.IncentiveBean"%>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Incentive Recount</title>
<link rel="shortcut icon" sizes="152x152" href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascri pt" src="offlineDatePicker/jquery-ui.min.js"></script>
<%@include file="header.jsp"%>
<link href="offlineDatePicker/12jquery-ui.css" rel="stylesheet">
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%int month;
int year1;
GregorianCalendar date1 = new GregorianCalendar();    
year1 = date1.get(Calendar.YEAR);
 %>
	<%int employee_master_id1 = user.getEmployee_master_id(); %>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        	 <h1 class="page-header">Incentive Form</h1>
				        	 <br>

			<%
int incentive_id = 0;

if(request.getAttribute("incentive_id") != null){
	incentive_id = 	(Integer) request.getAttribute("incentive_id");
}else if(request.getParameter("incentive_id") != null){
	incentive_id = Integer.parseInt(request.getParameter("incentive_id"));
}

AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();
IncentiveBean incentiveBean = allIncentiveListDAO.getListOfIncentiveById(incentive_id);
%>

			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-primary">
					 <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Incentive Detail</h4>
				               		
				                </div>

								<div class="col-md-6" align="right">
									<a href="incentive.jsp"><button type="button"
											class="btn btn-default btn-xs">
											<li class="icon-plus-round"></li> Add Another
										</button></a> <a href="incentiveListByYear.jsp"><button type="button"
											class="btn btn-default btn-xs">
											<li class="icon-reply3"></li> Go To List
										</button></a>
										<%if(request.getParameter("action") != null) {
										
											int month_id = Integer.parseInt(request.getParameter("month_id"));
											double eligibleIncentive = incentiveBean.getEligible_incentive_percentage();
										%>
										<a href="incentiveList.jsp?sales_id=<%=incentiveBean.getSalespersonBean().getSales_person_id()%>&month_id=<%=month_id%>&year_id=<%=incentiveBean.getYearBean().getYear_id()%>&product_id=<%=incentiveBean.getProductMasterBean().getProduct_master_id()%>&eligibleIncentive=<%=eligibleIncentive%>&year=<%=incentiveBean.getYearBean().getYear()%>"><button type="button"
											class="btn btn-default btn-xs">
											<li class="icon-reply3"></li> Back
										</button></a>
										<%} %>
								</div>

							</div>
  					<div class="card-body collapse in">
					       <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
	<form action="incentiveInsert" method="post">
							<div class="row">
								<div class="col-lg-3">
									<label>PO Date</label> <input type="text" width="155"
										name="poDate" placeholder="dd/mm/yyyy" required
										class="form-control" value="<%=incentiveBean.getPo_date() %>"
										readonly="readonly">
								</div>
								<div class="col-lg-3">
									<label>SJO Date</label> <input type="text" width="155"
										name="sjoDate" placeholder="dd/mm/yyyy" required
										class="form-control" value="<%=incentiveBean.getSjo_date() %>"
										readonly="readonly">
								</div>
								<div class="col-lg-3">
									<label>Inv. Date</label> <input type="text" width="155"
										name="invDate" placeholder="dd/mm/yyyy" required
										class="form-control" value=<%=incentiveBean.getInv_date() %>
										readonly="readonly">
								</div>
								<div class="col-md-3">
									<label>Weather is new or repeat order?</label> <label
										class="radio-inline"> <%if(incentiveBean.getNew_repeat().equalsIgnoreCase("new")){ %>
										<input type="radio" name="newRepeat" value="new"
										checked="checked" /> <%}else{ %> <input
										type="radio" name="newRepeat" value="new" />
										<%} %> New
									</label> <label class="radio-inline"> <%if(incentiveBean.getNew_repeat().equalsIgnoreCase("repeat")){ %>
										<input type="radio" name="newRepeat" value="repeat"
										checked="checked" /> <%}else{ %> <input
										type="radio" name="newRepeat" value="repeat"
										/> <%} %> Repeat
									</label>
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-lg-3">
									<label>Invoice No.</label> <label>:</label> <input type="text"
										class="form-control" name="invoiceNo" id="invoice"
										placeholder="Enter Invoice No."
										value="<%=incentiveBean.getInvoice_no() %>"
										onchange="compareWithOther(this.value)" readonly="readonly">


								</div>
								<!-- /.col-lg-12 -->

								<div class="col-lg-3">

									<label>Invoice Month</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getMonthBean().getMonth_name()%>"
											readonly="readonly">
									</div>
								</div>

								<div class="col-lg-3">
									<label>Year</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getYearBean().getYear()%>-<%=Integer.parseInt(incentiveBean.getYearBean().getYear()) + 1%>"
											readonly="readonly">
									</div>


								</div>

								<div class="col-lg-3">
									<label>Zone&nbsp;<i class="icon-question-circle"
										data-toggle="tooltip" data-placement="top" title="#"></i></label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getZoneBean().getZone_name()%>"
											readonly="readonly">
											
											
												<input type="hidden" class="form-control" name="zone"
											value="<%=incentiveBean.getZoneBean().getZone_id()%>"
											readonly="readonly">
									</div>

								</div>


							</div>
							<!-- /.row -->

							<br>
							<div class="row">
								<div class="col-lg-3">
									<label>Customer</label> <input type="text" class="form-control"
										name="customer" id="customer"
										placeholder="Enter Customer Name"
										value="<%=incentiveBean.getCustomer() %>"
										onchange="compareWithOther(this.value)" readonly="readonly">
								</div>
								<!-- /.col-lg-6 -->


								<div class="col-lg-3">
									<label>Sales Person</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getSalespersonBean().getFirstname()+" "+incentiveBean.getSalespersonBean().getLastname()%>"
											readonly="readonly">
											
											<input type="hidden" class="form-control" name= "sales"
											value="<%=incentiveBean.getSalespersonBean().getSales_person_id()%>"
											readonly="readonly">
									</div>
								</div>

								<div class="col-lg-3">
									<label>Product</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getProductMasterBean().getProduct_name()%>"
											readonly="readonly">
											
											<input type="hidden" class="form-control" name="product"
											value="<%=incentiveBean.getProductMasterBean().getProduct_master_id()%>"
											readonly="readonly">
									</div>
								</div>

								<div class="col-lg-3">
									<label>Model</label>
									<div>
										<input type="text" class="form-control" name="model"
											id="model" required="required"
											value="<%=incentiveBean.getProject_code() %>"
											placeholder="Enter Model" readonly="readonly">

									</div>
								</div>
							</div>

							<br>
							<div class="row">

								<div class="col-lg-3">
									<label>Laser Source</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getLaserMasterBean().getLaser_source()%>"
											readonly="readonly">
											
											<input type="hidden" class="form-control" name="laserSource"
											value="<%=incentiveBean.getLaserMasterBean().getLaser_master_id()%>"
											readonly="readonly">
									</div>
								</div>

								<div class="col-lg-3">
									<label>Classification</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getClassificationBean().getClassification_name()%>"
											readonly="readonly">
									</div>
									
									<div>
										<input type="hidden" class="form-control" name="classification"
											value="<%=incentiveBean.getClassificationBean().getClassification_id()%>"
											readonly="readonly">
									</div>
									
								</div>

								<div class="col-lg-3">
									<label>Scope</label>
									<div>
										<input type="text" class="form-control" name="scope"
											id="scope" placeholder="Enter Scope"
											value="<%=incentiveBean.getScope() %>" readonly="readonly">
									</div>
								</div>

								<div class="col-lg-3">
									<label>Remarks</label>
									<div>
										<input type="text" class="form-control" name="remarks"
											id="remarks" placeholder="Enter Remarks"
											value="<%=incentiveBean.getRemarks() %>" readonly="readonly">
									</div>
								</div>

							</div>



							<br>
							<div class="row">
								<div class="col-lg-2">
									<label>Quotation Price</label>
									<div>
										<input type="text" class="form-control" name="qut_price"
											id="qut_price" placeholder="Enter Quotation Price"
											value="<%=new BigDecimal(incentiveBean.getQuotation_price())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-lg-2">
									<label>Basic Price</label>
									<div>
										<input type="text" class="form-control" name="basicPrice"
											id="price" placeholder="Enter Basic Price"
											value="<%=new BigDecimal(incentiveBean.getBasic_price())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>


								<div class="col-lg-2">
									<label>Deductions</label>
									<div>
										<input type="text" class="form-control" name="deductions"
											id="deductions" placeholder="Enter Deductions"
											value="<%=new BigDecimal(incentiveBean.getDeduction())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-lg-2">
									<label>Additional Accesories</label>
									<div>
										<input type="text" class="form-control" name="accesories"
											id="accesories" placeholder="Enter Value"
											value="<%=new BigDecimal(incentiveBean.getAdditional_accesories())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-lg-2">
									<label>Net Basic</label>
									<div>
										<input type="text" class="form-control" name="netBasic"
											id="Basic" placeholder="Net Basic Price"
											value="<%=new BigDecimal(incentiveBean.getNet_basic())%>"
											readonly="readonly"
											onchange="calculation(this.id); calculation1(this.id);"
											readonly="readonly">
									</div>
								</div>


								<div class="col-lg-2">
									<label>Discount on</label>
									<div>
										<input type="text" class="form-control" name="discount"
											id="discount" placeholder="Discount"
											value="<%=incentiveBean.getDiscount()%>" readonly="readonly"
											onchange="calculation1(this.id);" readonly="readonly">
									</div>
								</div>

							</div>

							<br>

								<hr>
										<center>
										<input type="hidden" name="incentive_id" value="<%=incentive_id%>">
											<input type="submit" value="Recount" class="btn btn-primary">
										</center>
										<br>
							
							</form>

						</div>
					</div>
				</div>
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
					<script>

								function updateData(value,id) {

									

									var $form = $(this), url = 'incentiveStatusUpdate';
									

									var posting = $.post(url, {
										value : value,
										id : id
									});
									
									
									posting.done(function(data) {
										console.log('success');
									});
									
								}
									
								
								</script>



			<script>
			
			$(document).ready(function()
			{
				
				var $datepicker1 =  $( "#datepicker1" );
			    var $datepicker2 =  $( "#datepicker2" );
			    var $datepicker3 =  $( "#datepicker3" );
				
			    
			    /* $("#datepicker1").datepicker({  dateFormat: 'dd/mm/yy'});
		    	$("#datepicker2").datepicker({ dateFormat: 'dd/mm/yy' }); */
	
	 
	         
	   		$datepicker1.datepicker({		
	   			dateFormat: 'yy-mm-dd' , 
	   			 changeMonth: true,
	   		});
	   		
			});
		
		</script>

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
	<script src="app-assets/vendors/js/ui/jquery.sticky.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script> -->
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