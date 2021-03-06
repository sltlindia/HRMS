<%@page import="java.math.BigDecimal"%>
<%@page import="com.hrms.incentive.bean.IncentiveSalesPersonListBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveDesignationBean"%>
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
<title>Incentive Update</title>
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
<script type="text/javascript">
var year = null;
var month = null;

function calculation() {
		
			var price = document.getElementById("price").value;
			//alert("BASIC PRICE"+price);
			var deductions = document.getElementById("deductions").value;
			//alert("Deduction"+deductions);
			var accesories = document.getElementById("accesories").value;
			//alert("Accesories"+accesories);

			if ((isNaN(deductions)) || (isNaN(accesories)) || (isNaN(price)) ) {
				alert("character not allowed");
				
				if(isNaN(deductions)){
					document.getElementById("deductions").value = "0";
				}else if(isNaN(accesories)){
					document.getElementById("accesories").value = "0";
				}else if(isNaN(price)){
					document.getElementById("price").value = "0";
				}
				
			} else if ((deductions < 0) || (accesories < 0) || (price < 0) ) {
				alert("Negative value not allowed");
				
				if(deductions < 0){
					document.getElementById("deductions").value = "0";
				}else if(accesories < 0){
					document.getElementById("accesories").value = "0";
				}else if(price < 0){
					document.getElementById("price").value = "0";
				}
				
			} else  {
				var Basic = ((parseInt(price) - parseInt(deductions)) + parseInt(accesories));
				//alert("Net Basic"+Basic);
				document.getElementById("Basic").value = Basic;
			}
		var qut_price = document.getElementById("qut_price").value;
		//alert("Quotation Price"+qut_price);
		if ((isNaN(Basic)) || (isNaN(qut_price)) ) {
			alert("character not allowed");
			
			if(isNaN(qut_price)){
				document.getElementById('qut_price').value = "0";
			}else if(isNaN(Basic)){
				document.getElementById('Basic').value = "0";
			}
			
		} else if ((Basic < 0) || (qut_price < 0)) {
			alert("Negative value not allowed");
			
			if(qut_price < 0){
				document.getElementById('qut_price').value = "0";
			}else if(Basic < 0){
				document.getElementById('Basic').value = "0";
			}
		} else  {
			var discount = (((parseInt(qut_price) - parseInt(Basic))/ parseInt(qut_price)) * 100);
			//alert("Discount:"+discount);
			document.getElementById("discount").value = (discount).toFixed(2);
		}
		
		
	}
</script>


<script type="text/javascript">

function getResponse(id,salesId){
	
	alert(salesId);
	
	/* 1 : for Sales person
	2 : for product
	3 : for laser source
	4 : for classification */
	
	
	if(id==1){ // for full list of Sales person dynamically
			 dwr.util.removeAllOptions('sales'+salesId);
			 IncentiveAjaxDataDAO.getnameOfsalesPerson(function(data){
			dwr.util.addOptions('sales'+salesId,["---Select---"]);
			dwr.util.addOptions('sales'+salesId,data,"sales_person_id","fullname");
			});
	}else if(id==2){ // for full list of product dynamically
		dwr.util.removeAllOptions('product');
		 IncentiveAjaxDataDAO.getnameOfproduct(function(data){
		dwr.util.addOptions('product',["---Select---"]);
		dwr.util.addOptions('product',data,"product_master_id","product_name");
		});
	}else if(id==3){ // for full list of laserSource dynamically
		dwr.util.removeAllOptions('laserSource');
		 IncentiveAjaxDataDAO.getListOfLaser(function(data){
		dwr.util.addOptions('laserSource',["---Select---"]);
		dwr.util.addOptions('laserSource',data,"laser_master_id","laser_source")
		}); 
	}else if(id==4){ // for full list of classification dynamically
		dwr.util.removeAllOptions('classification');
		 IncentiveAjaxDataDAO.getnameOfclassification(function(data){
		dwr.util.addOptions('classification',["---Select---"]);
		dwr.util.addOptions('classification',data,"classification_id","classification_name");
		});
	}
}	


function getProductData(id){
	
		dwr.util.removeAllOptions('product');
		 IncentiveAjaxDataDAO.getnameOfproductByMonthYearId(id,month,year,function(data){
		dwr.util.addOptions('product',["---Select---"]);
		dwr.util.addOptions('product',data,"product_master_id","product_name");
		});
		 
		 		
}	


function getDesignationData(id,salesId){
	 
			dwr.util.removeAllOptions('designation'+salesId);
	 		IncentiveAjaxDataDAO.getDesignationOfPersonById(id,function(data){
			dwr.util.addOptions('designation'+salesId,data,"designation","designation");
			});
}	


function getAllDesignation(id){
	 
	 
	 
			dwr.util.removeAllOptions('designation'+id);
	 		IncentiveAjaxDataDAO.getnameOfDesignation(function(data){
			dwr.util.addOptions('designation'+id,["---Select---"]);
			dwr.util.addOptions('designation'+id,data,"incentive_designation_name","incentive_designation_name");
			});
}	




	
</script>






<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
	
	
	int month;
	int year1;
GregorianCalendar date1 = new GregorianCalendar();    
year1 = date1.get(Calendar.YEAR);


int incentive_id = 0;

if(request.getAttribute("incentive_id") != null){
	incentive_id = 	(Integer) request.getAttribute("incentive_id");
}else if(request.getParameter("incentive_id") != null){
	incentive_id = Integer.parseInt(request.getParameter("incentive_id"));
}



AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();
IncentiveBean incentiveBean = allIncentiveListDAO.getListOfIncentiveById(incentive_id);


String[] splitValue = incentiveBean.getPo_date().split("-");

 %>
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

			<%if(request.getAttribute("client") !=null){%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-success ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${client}
				</div>
			</div>
			<%} %>
			<%if(request.getAttribute("clientError") !=null){%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-danger ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${clientError}
				</div>
			</div>
			<%} %>


		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Incentive Detail</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
							<form action="incentiveInsert" method="post">

								
								<input type="hidden" name="inc_id" value="<%=incentiveBean.getIncentive_id()%>">
								<input type="hidden" name="incentive_eligible_percentage" value="<%=incentiveBean.getEligible_incentive_percentage()%>">
								<input type="hidden" name="eligible_incentive_save" value="<%=incentiveBean.getEligible_insentive_save()%>">

								<div class="row">
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Order Book Date</label> <input type="text" id="datepicker1"
											width="155" name="poDate" placeholder="yyyy-mm-dd" required
											class="form-control" value="<%=incentiveBean.getPo_date()%>" readonly="readonly">
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>SJO Date</label> <input type="text" id="datepicker2"
											width="155" name="sjoDate" placeholder="yyyy-mm-dd" required
											class="form-control" value="<%=incentiveBean.getSjo_date()%>" readonly="readonly">
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Inv. Date</label> <input type="text" id="datepicker3"
											width="155" name="invDate" placeholder="yyyy-mm-dd" required
											class="form-control" value="<%=incentiveBean.getInv_date()%>" readonly="readonly">
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3">
									<label>Weather is new or repeat order?</label>
									
									<label
										class="radio-inline"> <%if(incentiveBean.getNew_repeat().equalsIgnoreCase("new")){ %>
										<input type="radio" name="newRepeat" value="new"
										checked="checked" /> <%}else{ %> <input
										type="radio" name="newRepeat" value="new"  />
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
								
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Invoice No.</label> <label>:</label> <input type="text"
											class="form-control" name="invoiceNo" id="invoice"
											placeholder="Enter Invoice No." value="<%=incentiveBean.getInvoice_no()%>"
											 required>


									</div>
									
									
									
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Zone&nbsp;<i class="icon-question-circle"
											data-toggle="tooltip" data-placement="top" title="#"></i></label>
										<div>
											<select class="form-control" name="zone" id="zone"
												required="required">
												<option value="">---Select Zone---</option>
												<%
											AllIncentiveListDAO zoneList = new AllIncentiveListDAO();
                                         	 List<ZoneBean> listofZone = zoneList.getnameOfzone();
                 						 	for (ZoneBean z : listofZone){
                 						 		if(incentiveBean.getZoneBean().getZone_id() == z.getZone_id()){
                                                    %>
          												<option value="<%=z.getZone_id()%>" selected="selected"><%=z.getZone_name()%></option>
          												<%}else{ %>
          												<option value="<%=z.getZone_id()%>"><%=z.getZone_name()%></option>
          												<%} }%>
          											
											</select>
										</div>

									</div>
									
									
									
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Customer</label> <input type="text"
											class="form-control" name="customer" id="customer"
											placeholder="Enter Customer Name" 
											value="<%=incentiveBean.getCustomer() %>" required>
									</div>
									<!-- /.col-sm-6 col-md-6 col-lg-6 -->
									
									
									
									<div class="col-sm-3 col-md-3 col-lg-3">
										<label>Customer Code</label>
										<div>
											<input type="text" class="form-control" name="customerCode" 
												required="required" placeholder="Enter Code" value="<%=incentiveBean.getCustomer_code()%>" maxlength="12">
												
										</div>
									</div>
									
								</div>
								<!-- /.row -->
					
								<br>
								<br>
								<div class="row">

								<div class="col-sm-4 col-md-4 col-lg-4">
										<label>Model</label>
										<div>
											<input type="text" class="form-control" name="model" id="model"
												required="required" value="<%=incentiveBean.getProject_code() %>" placeholder="Enter Model">
												
										</div>
									</div>
								
								
								<div class="col-sm-4 col-md-4 col-lg-4">
								<label>Scope</label>
										<div>
									<input type="text"
											class="form-control" name="scope" id="scope"
											placeholder="Enter Scope" value="<%=incentiveBean.getScope()%>"
											 required>
										</div>
								</div>
								
								<div class="col-sm-4 col-md-4 col-lg-4">
								<label>Remarks</label>
										<div>
											<input type="text"
											class="form-control" name="remarks" id="remarks"
											placeholder="Enter Remarks" value="<%=incentiveBean.getRemarks()%>"
											 required>
										</div>
								</div>
								
									
									<!-- /.col-sm-6 col-md-6 col-lg-6 -->

								</div>
								
								<br>
								<br>
								<div class="row">
								
									<div class="col-sm-8 col-md-8 col-lg-8">
								
									<div class="row">
									<div class="col-sm-6 col-md-6 col-lg-6">
									<label>Sales Person</label>
									</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
									<label>Designation</label>
									</div>
									
									<%List<IncentiveSalesPersonListBean> listOfSalesPerson = allIncentiveListDAO.getNameOfIncentiveList(incentive_id); 
										for(int i =0;i<listOfSalesPerson.size();i++){
											IncentiveSalesPersonListBean incentiveSalesPersonListBean = listOfSalesPerson.get(i);
									%>
									
									<input type="hidden" name="incentivePersonListId" value="<%=incentiveSalesPersonListBean.getIncentive_sales_person_list_id()%>">
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group input-group">
										<span class="input-group-addon"><a href="incentiveMaster1.jsp" onclick="window.open('incentiveMaster1.jsp', 'newwindow', 'width=500, height=500'); return false;" style="color: black;"><i class="icon-plus-round"></i></a></span>
                                          <%if(i+1 == 1){ %>
                                           <select class="form-control" name="sales" id="sales<%=i+1%>"
												required="required" onchange="getProductData(this.value);getDesignationData(this.value,<%=i+1%>)">
												<%}else{ %>
												    <select class="form-control" name="sales" id="sales<%=i+1%>"
												 onchange="getDesignationData(this.value,<%=i+1%>)">
												<%} %>
												<option value="0">---Select---</option>
												<%
                                          
											AllIncentiveListDAO salesList = new AllIncentiveListDAO();
                                         	 List<SalespersonBean> listofSales = salesList.getnameOfsales();
                 						 	for (SalespersonBean s : listofSales){
                 						 		if(s.getSales_person_id() == incentiveSalesPersonListBean.getSalespersonBean().getSales_person_id()){
                                                    
                                                    %>
          												<option value="<%=s.getSales_person_id()%>" selected="selected"><%=s.getFullname()%></option>
          												
          												<%}else{%>
          												
          												<option value="<%=s.getSales_person_id()%>"><%=s.getFullname()%></option>
          												
          												<%} %>
												<%} %>
											</select>
											<span class="input-group-addon"><i class="icon-refresh2" onclick="getResponse(1,<%=i+1%>);" style="color: black;"></i></span>
                                        </div>
                                        </div>
                                        
                                          <div class="col-sm-6 col-md-6 col-lg-6">
                                          <div class="form-group input-group">
														<select class="form-control"
															name="designation" id="designation<%=i+1%>"
															placeholder="Enter Designation" >
															<option value="0">---Select Designation---</option>
															
															<%List<IncentiveDesignationBean> listOfDesignation = salesList.getnameOfDesignation(); 
																for(IncentiveDesignationBean designationBean : listOfDesignation){
																	if(designationBean.getIncentive_designation_name().equalsIgnoreCase(incentiveSalesPersonListBean.getDesignation())){
															%>
															<option value="<%=designationBean.getIncentive_designation_name()%>" selected="selected"><%=designationBean.getIncentive_designation_name()%></option>
															<%}else{ %>
															<option value="<%=designationBean.getIncentive_designation_name()%>"><%=designationBean.getIncentive_designation_name()%></option>
															<%} %>
															<%} %>
														</select>
														<span class="input-group-addon"><i class="icon-refresh2" onclick="getAllDesignation(<%=i+1%>);" style="color: black;"></i></span>
														</div>
													</div>
									
									<%} %>
									
									
									<%for(int j=listOfSalesPerson.size()+1;j<=5;j++){%>
										<input type="hidden" name="incentivePersonListId" value="0">
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group input-group">
										<span class="input-group-addon"><a href="incentiveMaster1.jsp" onclick="window.open('incentiveMaster1.jsp', 'newwindow', 'width=500, height=500'); return false;" style="color: black;"><i class="icon-plus-round"></i></a></span>
                                          
                                           <select class="form-control" name="sales" id="sales<%=j %>"
												onchange="getDesignationData(this.value,<%=j%>)">
												
												<option value="0">---Select---</option>
												<%
                                          
											AllIncentiveListDAO salesList = new AllIncentiveListDAO();
                                         	 List<SalespersonBean> listofSales = salesList.getnameOfsales();
                 						 	for (SalespersonBean s : listofSales){
                                          
                                          %>
												<option value="<%=s.getSales_person_id()%>"><%=s.getFullname()%></option>
												<%} %>
											</select>
											<span class="input-group-addon"><i class="icon-refresh2" onclick="getResponse(1,<%=j%>);" style="color: black;"></i></span>
                                        </div>
                                        </div>
                                        
                                          <div class="col-sm-6 col-md-6 col-lg-6">
                                          <div class="form-group input-group">
														<select class="form-control"
															name="designation" id="designation<%=j%>"
															placeholder="Enter Designation" >
															<option value="0">---Select Designation---</option>
															
															<%List<IncentiveDesignationBean> listOfDesignation = salesList.getnameOfDesignation(); 
																for(IncentiveDesignationBean designationBean : listOfDesignation){
															%>
															<option value="<%=designationBean.getIncentive_designation_name()%>"><%=designationBean.getIncentive_designation_name()%></option>
															<%} %>
														</select>
														<span class="input-group-addon"><i class="icon-refresh2" onclick="getAllDesignation(<%=j%>);" style="color: black;"></i></span>
														</div>
													</div>
									
									<%} %>
									
									
								</div>
							</div>			
								
								
									<div class="col-sm-4 col-md-4 col-lg-4">
								<label>Product</label>
								
								
								<div class="form-group input-group">
								<span class="input-group-addon"><a href="incentiveMaster1.jsp" onclick="window.open('incentiveMaster1.jsp', 'newwindow', 'width=500, height=500'); return false;" style="color: black;"><i class="icon-plus-round"></i></a></span>
                                          <select class="form-control" name="product" id="product"
												required="required">
												<option value="">---Select---</option>
												<%
                                          
											AllIncentiveListDAO productList = new AllIncentiveListDAO();
                                         	 List<ProductMasterBean> listofProduct = productList.getnameOfproduct();
                 						 	for (ProductMasterBean p : listofProduct){
                 						 		if(p.getProduct_master_id() == incentiveBean.getProductMasterBean().getProduct_master_id()){
                                                    
                                                    %>
          												<option value="<%=p.getProduct_master_id()%>" selected="selected"><%=p.getProduct_name()%></option>
          												
          												<%}else{ %>
          												
          												<option value="<%=p.getProduct_master_id()%>"><%=p.getProduct_name()%></option>
          												
          												<%} }%>
											</select>
											<span class="input-group-addon"><i class="icon-refresh2" onclick="getResponse(2);" style="color: black;"></i></span>
                                        </div>
								
								
								
								</div>
								
								
								
								<div class="col-sm-4 col-md-4 col-lg-4">
								<label>Laser Source</label>
								
								<div class="form-group input-group">
								<span class="input-group-addon"><a href="incentiveMaster1.jsp" onclick="window.open('incentiveMaster1.jsp', 'newwindow', 'width=500, height=500'); return false;" style="color: black;"><i class="icon-plus-round"></i></a></span>
                                          <select class="form-control" name="laserSource" id="laserSource"
												required="required">
												<option value="">---Select---</option>
												<%
                                          
                                         	 List<LaserMasterBean> listofLaser = productList.getListOfLaser();
                 						 	for (LaserMasterBean l : listofLaser){
                 			
                 						 		if(l.getLaser_master_id() == incentiveBean.getLaserMasterBean().getLaser_master_id()){
                                                    
                                                    %>
          												<option value="<%=l.getLaser_master_id()%>" selected="selected"><%=l.getLaser_source()%></option>
          												
          												<%}else{ %>
          												
          												<option value="<%=l.getLaser_master_id()%>"><%=l.getLaser_source()%></option>
          												
          												<%} %>
												<%} %>
											</select>
											<span class="input-group-addon"><i class="icon-refresh2" onclick="getResponse(3);" style="color: black;"></i></span>
                                        </div>
								
								</div>
								
								
								<div class="col-sm-4 col-md-4 col-lg-4">
								<label>Classification</label>
								
								<div class="form-group input-group">
								<span class="input-group-addon"><a href="incentiveMaster1.jsp" onclick="window.open('incentiveMaster1.jsp', 'newwindow', 'width=500, height=500'); return false;" style="color: black;"><i class="icon-plus-round"></i></a></span>
                                          <select class="form-control" name="classification" id="classification"
												required="required">
												<option value="">---Select---</option>
												<%
                                          
											AllIncentiveListDAO classificationList = new AllIncentiveListDAO();
                                         	 List<ClassificationBean> listofClassification = classificationList.getnameOfclassification();
                 						 	for (ClassificationBean c : listofClassification){
                 			
                 						 		if(c.getClassification_id() == incentiveBean.getClassificationBean().getClassification_id()){
                                                    
                                                    %>
          												<option value="<%=c.getClassification_id()%>" selected="selected"><%=c.getClassification_name()%></option>
          												
          												<%}else{ %>
          												
          												<option value="<%=c.getClassification_id()%>"><%=c.getClassification_name()%></option>
          												
          												<%} %>
												<%} %>
											</select>

											<span class="input-group-addon"><i class="icon-refresh2" onclick="getResponse(4);" style="color: black;"></i></span>
                                        </div>
								
								
								
								</div>
								
								</div>
								
								
								
								<br>
								<div class="row">
								
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Invoice Amount</label>
										<div>
									<input type="text"
											class="form-control" name="inv_amt" id="inv_amt"
											placeholder="Enter Invoice Amount" value="<%=new BigDecimal(incentiveBean.getInvoice_amount())%>"
											 required onchange="calculation();">
										</div>
								</div>
								
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Quotation Price</label>
										<div>
									<input type="text"
											class="form-control" name="qut_price" id="qut_price"
											placeholder="Enter Quotation Price" value="<%=new BigDecimal(incentiveBean.getQuotation_price())%>"
											 required onchange="calculation();">
										</div>
								</div>
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Basic Price</label>
										<div>
									<input type="text"
											class="form-control" name="basicPrice" id="price"
											placeholder="Enter Basic Price" value="<%=new BigDecimal(incentiveBean.getBasic_price())%>"
											 required onchange="calculation();">
										</div>
								</div>
								
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Deductions</label>
										<div>
									<input type="text"
											class="form-control" name="deductions" id="deductions"
											placeholder="Enter Deductions" value="<%=new BigDecimal(incentiveBean.getDeduction())%>"
											 required onchange="calculation();">
										</div>
								</div>
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Additional Accesories</label>
										<div>
									<input type="text"
											class="form-control" name="accesories" id="accesories"
											placeholder="Enter Value" value="<%=new BigDecimal(incentiveBean.getAdditional_accesories())%>"
											 required onchange="calculation();">
										</div>
								</div>
								
								
								<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Net Basic</label>
										<div>
									<input type="text"
											class="form-control" name="netBasic" id="Basic"
											placeholder="Net Basic Price" value="<%=new BigDecimal(incentiveBean.getNet_basic())%>"
											 readonly="readonly" onchange="calculation(this.id); calculation1(this.id);">
										</div>
								</div>
								
									<div class="col-sm-2 col-md-2 col-lg-2">
								<label>Discount on</label>
										<div>
									<input type="text"
											class="form-control" name="discount" id="discount"
											placeholder="Discount" value="<%=incentiveBean.getDiscount() %>"
											 readonly="readonly" onchange="calculation1(this.id);">
										</div>
								</div>
								
								</div>
								
								<br>
								<div class="row">
								
								
								
								
								
								</div>
								
								
								<hr>
										<center>
											<input type="submit" value="Submit" class="btn btn-primary">
											<input type="reset" value="Reset" class="btn btn-danger">
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
</section>
</div>
</div>
</div>						<!-- /.row -->
								<script>
		
			
			$(document).ready(function()
			{
				
				year = <%=splitValue[0]%>;
				month = <%=splitValue[1]%>;
				
				var $datepicker1 =  $( "#datepicker1" );
			    var $datepicker2 =  $( "#datepicker2" );
			    var $datepicker3 =  $( "#datepicker3" );
				
			    
			    /* $("#datepicker1").datepicker({  dateFormat: 'dd/mm/yy'});
		    	$("#datepicker2").datepicker({ dateFormat: 'dd/mm/yy' }); */
	
	 
	         
	   		$datepicker1.datepicker({		
	   			dateFormat: 'yy-mm-dd' , 
	   			 changeMonth: true,
	   			 onSelect: function(dateStr)
	   			 {
	   				 
		   	            $('#datepicker2').datepicker('option', 'defaultDate', dateStr);
		   	           	$('#datepicker2').datepicker('option', 'minDate', dateStr);
		   	      	   $('#datepicker3').datepicker('option', 'defaultDate', dateStr);
		   	     		$('#datepicker3').datepicker('option', 'minDate', dateStr);
		   	         	setTimeout(function()
		   	         			{
		   	           				 $( "#datepicker2").datepicker('show');
		   	        			}, 300); 
		   	        
		   	         var split = dateStr.split("-");
		   	         
		   	      	  year = split[0];
		   	          month = split[1];
		   	         	
		   	         dwr.util.removeAllOptions('sales1');
					 IncentiveAjaxDataDAO.getnameOfsalesPersonByYearnadMonth(year,month,function(data){
					dwr.util.addOptions('sales1',["---Select---"]);
					dwr.util.addOptions('sales1',data,"sales_person_id","fullname");
					 })		
			}
	   			  
	   		});
	   		
			$datepicker2.datepicker({
			     dateFormat: "yy-mm-dd",
			     changeMonth: true,
			         onClose: function() 
			         {
			        	
				       
			        }
			    });
		
				$datepicker3.datepicker({
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
								<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
								<script type="text/javascript">
        window.onload = function() 
        {            
          
              $('#autoUpdate1').fadeOut('slow');
              $('#autoUpdate2').fadeOut('slow');
              $('#autoUpdate3').fadeOut('slow');
              $('#autoUpdate4').fadeOut('slow');
              $('#autoUpdate5').fadeOut('slow');
              $('#autoUpdate6').fadeOut('slow');
              $('#autoUpdate7').fadeOut('slow');
              $('#autoUpdateth').fadeOut('slow');
              $('#radiobutton1').fadeOut('slow');
              $('#radiobutton2').fadeOut('slow');
            //  $('#radiobutton').fadeOut('slow');
        }
        </script>
</body>
</html>