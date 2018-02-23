<%@page import="com.hrms.incentive.bean.IncentiveDesignationBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveSalesPersonListBean"%>
<%@page import="com.hrms.incentive.bean.AmountHistoryBean"%>
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
<title>Incentive View</title>
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

<%@include file="header.jsp"%>


<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "text")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>

<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#datepicker1').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>

<!--  <script src="dist/js/dontBack.js"></script> -->
 
 <!-- JS dependencies -->
   <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    bootbox code
    <script src="js/bootbox.min.js"></script> -->
 

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
					       
	<!-- <div id="wrapper">
		<div id="page-wrapper">
			<br>


			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<h1 class="page-header">Incentive Form</h1>
				</div>
				/.col-sm-12 col-md-12 col-lg-12
			</div> -->

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
											<i class="icon-android-add-circle"></i> Add Another
										</button></a> <a href="incentiveList.jsp?year_id=<%=incentiveBean.getYearBean().getYear_id()%>"><button type="button"
											class="btn btn-default btn-xs">
											<i class="icon-reply3"></i> Go To List
										</button></a>
										
										
										<a href="incentiveUpdate.jsp?incentive_id=<%=incentive_id%>"><button type="button"
											class="btn btn-default btn-xs" id="updateButton"> Update
										</button></a>
										
										
										
								</div>
				            </div>
				            
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<%-- <div class="panel-heading">

							<div class="row">
								<div class="col-sm-6 col-md-6 col-sm-6 col-md-6 col-lg-6">
									<b>Incentive Detail</b>
								</div>

								<div class="col-sm-6 col-md-6 col-sm-6 col-md-6 col-lg-6" align="right">
									<a href="incentive.jsp"><button type="button"
											class="btn btn-default btn-xs">
											<li class="icon-android-add-circle"></li> Add Another
										</button></a> <a href="incentiveList.jsp?year_id=<%=incentiveBean.getYearBean().getYear_id()%>"><button type="button"
											class="btn btn-default btn-xs">
											<li class="icon-reply3"></li> Go To List
										</button></a>
										
										
										<a href="incentiveUpdate.jsp?incentive_id=<%=incentive_id%>"><button type="button"
											class="btn btn-default btn-xs" id="updateButton"> Update
										</button></a>
										
										
										
								</div>

							</div>

						</div> --%>
							<div class="row">
								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>PO Date</label> <input type="text" style="border-width:1px; margin-bottom: 1px" width="155"
										name="poDate" placeholder="dd/mm/yyyy" required
										class="form-control" value="<%=incentiveBean.getPo_date() %>"
										readonly="readonly">
								</div>
								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>SJO Date</label> <input type="text" width="155"
										name="sjoDate" placeholder="dd/mm/yyyy" required
										class="form-control" value="<%=incentiveBean.getSjo_date() %>"
										readonly="readonly">
								</div>
								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>Inv. Date</label> <input type="text" width="155"
										name="invDate" placeholder="dd/mm/yyyy" required
										class="form-control" value=<%=incentiveBean.getInv_date() %>
										readonly="readonly">
								</div>
								<div class="col-sm-3 col-md-3 col-lg-3">
									<label>whether is new or repeat order?</label> <label
										class="radio-inline"> <%if(incentiveBean.getNew_repeat().equalsIgnoreCase("new")){ %>
										<input type="radio" name="newRepeat" value="new"
										checked="checked" disabled="disabled" /> <%}else{ %> <input
										type="radio" name="newRepeat" value="new" disabled="disabled" />
										<%} %> New
									</label> <label class="radio-inline"> <%if(incentiveBean.getNew_repeat().equalsIgnoreCase("repeat")){ %>
										<input type="radio" name="newRepeat" value="repeat"
										checked="checked" disabled="disabled" /> <%}else{ %> <input
										type="radio" name="newRepeat" value="repeat"
										disabled="disabled" /> <%} %> Repeat
									</label>
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>Invoice No.</label> <label>:</label> <input type="text"
										class="form-control" name="invoiceNo" id="invoice"
										placeholder="Enter Invoice No."
										value="<%=incentiveBean.getInvoice_no() %>"
										onchange="compareWithOther(this.value)" readonly="readonly">


								</div>
								<!-- /.col-sm-12 col-md-12 col-lg-12 -->

								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>Zone&nbsp;<i class="fa fa-question-circle"
										data-toggle="tooltip" data-placement="top" title="#"></i></label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getZoneBean().getZone_name()%>"
											readonly="readonly">
									</div>

								</div>
								
								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>Customer Code</label> <input type="text" class="form-control"
										name="customer" id="customer"
										placeholder="Enter Customer Name"
										value="<%=incentiveBean.getCustomer_code()%>"
										onchange="compareWithOther(this.value)" readonly="readonly">
								</div>

								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
									<label>Customer</label> <input type="text" class="form-control"
										name="customer" id="customer"
										placeholder="Enter Customer Name"
										value="<%=incentiveBean.getCustomer() %>"
										onchange="compareWithOther(this.value)" readonly="readonly">
								</div>


							</div>
							<!-- /.row -->

							<br>
							<div class="row">
								
								<!-- /.col-sm-6 col-md-6 col-lg-6 -->


								

								<div class="col-sm-4 col-md-4 col-lg-4">
									<label>Model</label>
									<div>
										<input type="text" class="form-control" name="model"
											id="model" required="required"
											value="<%=incentiveBean.getProject_code() %>"
											placeholder="Enter Model" readonly="readonly">

									</div>
								</div>
								
								
								<div class="col-sm-4 col-md-4 col-lg-4">
									<label>Scope</label>
									<div>
									<textarea  class="form-control" name="scope"
											id="scope" readonly="readonly"><%=incentiveBean.getScope() %></textarea>
									</div>
								</div>

								<div class="col-sm-4 col-md-4 col-lg-4">
									<label>Remarks</label>
									<div>
									
									<textarea  class="form-control" name="remarks"
											id="remarks" readonly="readonly"><%=incentiveBean.getRemarks()%></textarea>
									</div>
								</div>

								<!-- /.col-sm-6 col-md-6 col-lg-6 -->

							</div>

							<br>
							<div class="row">
							
							<div class="col-sm-8 col-md-8 col-lg-8">
							<table class="table table-bordered">
									<thead>
										<tr bgcolor="#E5E7E9">
											<th>Name</th>
											<th>Designation</th>
											<th>Slab Value</th>
											<th>Eligible Percentage</th>
											<th>Incentive</th>
											<th class="tblEligibleIncentive">Eligible Incentive</th>
											<th>Status</th>
										</tr>
									</thead>	
									
									<tbody>
							<%List<IncentiveSalesPersonListBean> listOfSalesPerson = allIncentiveListDAO.getNameOfIncentiveList(incentive_id);
							double finalIncentiveToBePaid = 0;
								for(IncentiveSalesPersonListBean incentiveSalesPersonListBean : listOfSalesPerson){
									String status = incentiveSalesPersonListBean.getIncentive_status();
							%>
								<tr>
									<td><%=incentiveSalesPersonListBean.getSalespersonBean().getFullname()%></td>
									<td><%=incentiveSalesPersonListBean.getDesignation() %></td>
									<td><%=incentiveSalesPersonListBean.getSlab_value() %> %</td>
									<%
										double eligibleIncentive = incentiveSalesPersonListBean.getEligible_incentive_percentage();
										
										if(eligibleIncentive == 0 && incentiveSalesPersonListBean.getDesignation().equalsIgnoreCase("SERVICE")){
											eligibleIncentive = 100.00;
                                    	}
									
										Double amount = (incentiveSalesPersonListBean.getIncentive_amount()* eligibleIncentive)/ 100;
										
										finalIncentiveToBePaid = finalIncentiveToBePaid + amount;
									%>
									<th><%=eligibleIncentive%> %</th>
									<td><%=String.format("%.2f",new BigDecimal(incentiveSalesPersonListBean.getIncentive_amount()))%></td>
									
									<td class="tblEligibleIncentive">
										<%=String.format("%.2f",new BigDecimal(amount))%></td>
									<td>
										<%if(status.equalsIgnoreCase("paid")){ %>
                                        <font color="green"><b><%=status.toUpperCase()%></b></font>
                                        <%}else if(incentiveSalesPersonListBean.getIncentive_status().equalsIgnoreCase("realese")){ %>
                                        <font color="blue"><b><%=status.toUpperCase()%></b></font>
                                        <%}else{ %>
                                         <font color="red"><b><%=status.toUpperCase()%></b></font>
                                        <%} %>
									</td>
								</tr>
								
							<%} %>
							
							<tr class="tblEligibleIncentive">
								<td colspan="5" align="right"><b>Total</b></td>
								<td><b><%=String.format("%.2f",new BigDecimal(finalIncentiveToBePaid))%></b></td>
								<td></td>
							</tr>
							
							</tbody>
							</table>
							</div>
							
							
							<div class="col-sm-4 col-md-4 col-lg-4">
							
							<div class="row">
							
								<div class="col-sm-12 col-md-12 col-lg-12">
									<label>Product</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getProductMasterBean().getProduct_name()%> (<%=incentiveBean.getProductMasterBean().getMachine_category() %>)"
											readonly="readonly">
									</div>
								</div>

								<div class="col-sm-12 col-md-12 col-lg-12">
									<label>Laser Source</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getLaserMasterBean().getLaser_source()%>"
											readonly="readonly">
									</div>
								</div>

								<div class="col-sm-12 col-md-12 col-lg-12">
									<label>Classification</label>
									<div>
										<input type="text" class="form-control"
											value="<%=incentiveBean.getClassificationBean().getClassification_name()%>"
											readonly="readonly">
									</div>
								</div>
						</div>
						</div>
								

							</div>



							<br>
							<div class="row">
							
							<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Invoice Amount</label>
									<div>
										<input type="text" class="form-control" name="inv_amt"
											id="inv_amt" placeholder="Enter Quotation Price"
											value="<%=new BigDecimal(incentiveBean.getInvoice_amount())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>
							
								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Quotation Price</label>
									<div>
										<input type="text" class="form-control" name="qut_price"
											id="qut_price" placeholder="Enter Quotation Price"
											value="<%=new BigDecimal(incentiveBean.getQuotation_price())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Basic Price</label>
									<div>
										<input type="text" class="form-control" name="basicPrice"
											id="price" placeholder="Enter Basic Price"
											value="<%=new BigDecimal(incentiveBean.getBasic_price())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>


								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Deductions</label>
									<div>
										<input type="text" class="form-control" name="deductions"
											id="deductions" placeholder="Enter Deductions"
											value="<%=new BigDecimal(incentiveBean.getDeduction())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Additional Accesories</label>
									<div>
										<input type="text" class="form-control" name="accesories"
											id="accesories" placeholder="Enter Value"
											value="<%=new BigDecimal(incentiveBean.getAdditional_accesories())%>"
											required onchange="calculation();" readonly="readonly">
									</div>
								</div>

								<div class="col-sm-2 col-md-2 col-lg-2">
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


								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Discount on</label>
									<div>
										<input type="text" class="form-control" name="discount"
											id="discount" placeholder="Discount"
											value="<%=incentiveBean.getDiscount()%> %" readonly="readonly"
											onchange="calculation1(this.id);" readonly="readonly">
									</div>
								</div>

							</div>

							<br>


						<%-- 	<div class="row">

								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Slab Value</label>
									<div>
										<h4>
											<b><%=incentiveBean.getSlab()%> %</b>
										</h4>
									</div>
								</div>

								<div class="col-sm-2 col-md-2 col-lg-2">
									<label>Incentive</label>
									<div>
										<h4>
											<b><%=String.format("%.2f", new BigDecimal(incentiveBean.getAmount()))%></b>
										</h4>
									</div>
								</div>

							</div> --%>
						
							
						<hr>
							<h4><b>Amount History</b></h4>
						<hr>	
					
					<form action="amountInsert" method="post">
					
						<div class="row">
	
								<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="row">	
								<div class="col-sm-12 col-md-12 col-lg-12">
								
								    <div class="panel panel-default">
                        <div class="panel-heading">
                           Amount Received History
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Amount</th>
                                            <th>Date</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%List<AmountHistoryBean> historyOfAccount = allIncentiveListDAO.getListOfAccountHostory(incentive_id);
                                    double total = 0;
                                    double invoice = incentiveBean.getInvoice_amount();
                                    for(int i=0;i<historyOfAccount.size();i++){
                                    		AmountHistoryBean accountHistoryBean = historyOfAccount.get(i);
                                    		total = total + accountHistoryBean.getAmount();
                                    %>
                                        <tr>
                                           <td><%=i+1%></td>
                                           <td><%=new BigDecimal(accountHistoryBean.getAmount())%></td>
                                           <td><%=accountHistoryBean.getDate()%></td>
                                           <td><a href="amountDelete?amount_id=<%=accountHistoryBean.getAmount_history_id()%>&incentive_id=<%=incentive_id%>"><i class="glyphicon glyphicon-trash"></i></a></td>
                                        </tr>
                                        
                                        <%} %>
                                        
                                       <tr>
                                       		<th>Total</th>
                                       		<th><%=new BigDecimal(total)%></th>
                                       		<th colspan="2"></th>
                                       </tr> 
                                       
                                       <tr>
                                       		<th colspan="4">Remaining Amount : <%=new BigDecimal(invoice-total)%></th>
                                       </tr>
                                        
                                    </tbody>
                                </table>
                                
                                
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
									
								</div>
								
						</div>
						</div>		
								<%if(incentiveBean.getIncentive_status().equalsIgnoreCase("paid")){ %>
								<script>
								$(document).ready(function()
								{
									$('#updateButton').fadeOut('fast');
									 $("i", ".text-center").toggleClass("fa fa-ban fa fa-check-circle");
									 $('.pincentiveStatus').text('Incentive Paid');
								});
								</script>
								<%} %>
	
						<div class="col-sm-6 col-md-6 col-lg-6">
						
						<%if( (invoice - total) != 0) {%>
						
						<%SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); %>
						
							<div class="row">
							
							<div class="col-sm-12 col-md-12 col-lg-12">
								<h5><b>Enter Here Received Amount of this Invoice.</b></h5>
							</div>
							
							
							<div class="col-sm-5 col-md-5 col-lg-5">
							 	<input type="hidden" name="incentive_id" value="<%=incentive_id%>">
							 	<%if(request.getParameter("month_id") != null) {%>
							 	<input type="hidden" name="month_id" value="<%=request.getParameter("month_id")%>">
							 	<%} %>
								<input type="hidden" name="action" value="view">
											
											<%double remainingAmount = invoice - total; %>
											
											<input type="text" class="form-control" name="amount" id="amountValue" value="" placeholder="Enter Amount" onchange="checkData(this.value,<%=remainingAmount%>);" required> 
							</div>

								<div class="col-sm-4 col-md-4 col-lg-4">
										<input type="text" class="form-control" id="datepicker1" name="date" value="<%=dateFormat.format(new Date())%>" placeholder="yyyy-mm-dd" required>	
								</div>
								
								
								<div class="col-sm-3 col-sm-3 col-md-3 col-lg-3 col-lg-3">
										<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT" >
								</div>	
							</div>
								
								<%} %>
								
								
								
								
								<%-- <%if( (invoice - total) == 0 ) {%>
								
								<%if(incentiveBean.getEligible_insentive_save().equalsIgnoreCase("yes")){%>
								
								<div class="row">
								<div class="text-center">
								<i class="fa fa-ban fa-4x"></i>
								</div>
										<div class="text-center"><b><p class="pincentiveStatus">Incentive Not Paid</p></b></div>
								<div class="col-sm-3 col-md-3 col-lg-3">
							 	<b> Change Incentive Status</b>
								</div>
								
								</br>
								
								<div class="col-sm-5 col-md-5 col-lg-5">
								
								
							 			<%if(incentiveBean.getIncentive_status().equalsIgnoreCase("paid")){%>
							 			<input type="radio" name="incentiveStatus" value="paid" checked="checked" onclick="updateData(this.value,<%=incentive_id%>);"> Paid &nbsp;&nbsp;
							 			<%}else{ %>
							 			<input type="radio" name="incentiveStatus" value="paid" onclick="updateData(this.value,<%=incentive_id%>);"> Paid &nbsp;&nbsp;
							 			<%} %>
							 			
							 			
							 			<%if(incentiveBean.getIncentive_status().equalsIgnoreCase("not paid")){%>
							 			<input type="radio" name="incentiveStatus" value="not paid" checked="checked" onclick="updateData(this.value,<%=incentive_id%>);"> Not Paid &nbsp;&nbsp;
							 			<%}else{ %>
							 			<input type="radio" name="incentiveStatus" value="not paid" onclick="updateData(this.value,<%=incentive_id%>);"> Not Paid &nbsp;&nbsp;
							 			<%} %>
							 			
								</div>
								
								</div>
								
								<%}else{ %>
								
								<div class="text-center"><i class="fa fa-ban fa-4x"></i></div>
								<div class="text-center"><h5>Incentive Not Paid</h5></div>
								<div class="text-center">First Save Eligible Criteria For pay incentive <a href="incentiveCriteria.jsp?year_id=<%=incentiveBean.getYearBean().getYear_id()%>"> Click Here </a></div>
									
								
									
								<%} %>
								
								<%} %> --%>
							</div>	
								

							</div>
					
					</form>
							

	<a href="incentiveMaster.jsp" onclick="window.open('incentiveMaster.jsp?colorChanger=<%=incentiveBean.getProductMasterBean().getMachine_category().toLowerCase()+""+incentiveBean.getNew_repeat()+""+incentiveBean.getSalespersonBean().getDesignation().toLowerCase()%>', 'newwindow', 'width=500, height=500'); return false;">* Incentive Policy</a>
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
					
					function checkData(value,remainingAmount){
						
						if(isNaN(value)){
							alert("Character Not Allowed");
							document.getElementById("amountValue").value = "";
						}else{
							var a = remainingAmount - value;
							if(a<0){
								alert("Thia amount is greater than remaining amount.");
								document.getElementById("amountValue").value = "";
							}
						}
						
					}
					

								function updateData(value,id) {


									var $form = $(this), url = 'incentiveStatusUpdate';
									

									var posting = $.post(url, {
										value : value,
										id : id
									});
									
									
									posting.done(function(data) {
										if(value == "paid"){
										$('#updateButton').fadeOut('fast');
										$('.pincentiveStatus').text('Incentive Paid');
										 $("i", ".text-center").toggleClass("fa fa-ban fa fa-check-circle");
										var dialog = bootbox.dialog({
										    message: '<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4>Incentive Status Change to <b>PAID</b>.</h4></div>',
										    onEscape : true,
										});
										}else{
										$('#updateButton').fadeIn('fast');
										$('.pincentiveStatus').text('Incentive Not Paid');
										 $("i", ".text-center").toggleClass("fa fa-check-circle fa fa-ban");
										var dialog = bootbox.dialog({
										    message: '<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4>Incentive Status Change to <b>NOT PAID</b>.</h4></div>',
										    onEscape : true,
										});
										}
										
									});
									
								}
									
								
								</script>



			<script>
			
			$(document).ready(function()
			{
				var $datepicker1 =  $( "#datepicker1" );
			    
				$datepicker1.datepicker({
				     dateFormat: "yy-mm-dd",
				     changeMonth: true,
				         onClose: function() 
				         {
				        	
					       
				        }
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