<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="org.apache.poi.ss.formula.functions.Count"%>
<%@page import="com.hrms.incentive.bean.IncentiveDesignationBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveCriteriaBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveSalesPersonListBean"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hrms.incentive.bean.IncentiveBean"%>
<%@page import="com.hrms.incentive.dao.AllIncentiveListDAO"%>
<%@page import="com.hrms.pms.bean.ReviewBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
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
    <title>Incentive Sales Person Wise Report</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <%@include file="header.jsp" %>
    </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%

	
	AllIncentiveListDAO allIncentiveListDAO  = new AllIncentiveListDAO();
	List<IncentiveBean> listOfAllIncentive = null;
	int year_id = Integer.parseInt(request.getParameter("year_id"));
	List<IncentiveSalesPersonListBean> listOfAllIncentiveBYHigherAuthority =  null;
	int fromMonth = 0;
	int toMonth = 0;
	String customerCode = "";
	YearBean yearBean = allIncentiveListDAO.getyearByYearId(year_id);
	String nameOfYear = "";
	if(yearBean != null){
		nameOfYear = yearBean.getYear();
	}
	
	if(request.getParameter("sales_id") != null){
		
		int sales_id = Integer.parseInt(request.getParameter("sales_id"));
		int month_id = Integer.parseInt(request.getParameter("month_id"));
		int year = Integer.parseInt(request.getParameter("year"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		listOfAllIncentiveBYHigherAuthority = allIncentiveListDAO.getListOfAllIncentiveBySalespersonIdList(sales_id, month_id, year, product_id);
		
		
	}else if(request.getParameter("fromMonth") != null && request.getParameter("toMonth") != null){
		fromMonth = Integer.parseInt(request.getParameter("fromMonth"));
		toMonth = Integer.parseInt(request.getParameter("toMonth"));
		listOfAllIncentiveBYHigherAuthority = allIncentiveListDAO.getListOfAllIncentiveBySalespersonListBetweenMonth(nameOfYear,fromMonth,toMonth);
	}else if(request.getParameter("customer_code") != null){
		customerCode = request.getParameter("customer_code");
		listOfAllIncentiveBYHigherAuthority = allIncentiveListDAO.getListOfAllIncentiveBySalespersonListByCustomerCode(customerCode);
	}
	
	List<IncentiveDesignationBean> listOfDesignation = allIncentiveListDAO.getnameOfDesignation();
	
	/* SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat ddMMyyyy= new SimpleDateFormat("dd-MM-yyyy"); */
	

 %>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Incentive List</h4>
				               		
				                </div>
				            </div>
				            
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
                       <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                         <form action="" method="post">
                        	<select class="form-control" name="fromMonth" id="month"
														required="required">
														<option value="">---Month---</option>
														<%
                                          
											AllListDAO monthList = new AllListDAO();
                                         	 List<MonthBean> listOfMonth = monthList.getListOfMonth();
                 						 	for (MonthBean m : listOfMonth){
                 						 		if(m.getMonth_id() !=0 && m.getMonth_id() <13){
                 						 			if(fromMonth == m.getMonth_id()){
                                          
                                          %>
														<option value="<%=m.getMonth_id()%>" selected="selected"><%=m.getMonth_name()%></option>
														<%}else{ %>
														
														<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>
														
														<%} %>
														
														<%} }%>
													</select>
													
													
													<p align="center">TO</p>
												
												
												<select class="form-control" name="toMonth" id="month"
														required="required">
														<option value="">---Month---</option>
														<%
                                          
                 						 	for (MonthBean m : listOfMonth){
                 						 		if(m.getMonth_id() !=0 && m.getMonth_id() <13){
                 						 			if(toMonth == m.getMonth_id()){
                                          
                                          %>
														<option value="<%=m.getMonth_id()%>" selected="selected"><%=m.getMonth_name()%></option>
														<%}else{ %>
														
														<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>
														
														<%} %>
														
														<%} }%>
													</select>	
													
												<br>
												<p align="center">
													<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
												</p>
													
								</form>				
								</div>
								</div>
								</div>
								 <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                        <form action="" method="post">
                        	<input type="text" class="form-control" name="customer_code" value="<%=customerCode%>" placeholder="Eneter Customer Code">
                        	
                        	
                        	<br>
												<p align="center">
													<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
												</p>
												</form>
                        </div>
                        </div>
                        </div>			
                        </div>
                       
                        
                        
                       
			
				 <div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-9">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Incentive List</h4>
				                </div>
                          			 <a href="incentiveList.jsp?year_id=<%=year_id%>">
															<button class="btn btn-default btn-sm">
															<i class="icon-chevron-circle-right" data-toggle="tooltip"
																data-placement="top" title="show View"></i> All Incentive
															</button>	
																</a>
																
																
																
																<a href="incentiveReleasePaid.jsp?year_id=<%=year_id%>">
															<button class="btn btn-default btn-sm">
															<i class="icon-chevron-circle-right" data-toggle="tooltip"
																data-placement="top" title="show View"></i> Release / Paid
															</button>	
																</a>
                           	</div>
                           
                             <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="datatable-buttons">
                                    <thead>
                                        <tr>
                                       	    <th></th>
                                       	    <th>Order Type</th>
                                        	<th>Invoice No</th>
                                        	<th>Incentive Status</th>
                                        	<th width="100px;">Year</th>
                                        	<th>Payment Date</th>
                                            <th>PO Date</th>
                                            <th>SJO Date</th>
                                            <th>Invoice Date</th>
                                            <th>Customer Code</th>
                                            <th>Customer Name</th>
                                            <th>Sales Person</th>
                                            <th>Designation</th>
                                            <th>Zone</th>
                                            <th>Product</th>
                                            <th>Model</th>
                                            <th>Laser Source</th>
                                            <th>Classification</th>
                                          	<th>Scope</th>
                                          	<th>Remarks</th>
                                          	<th>Final Value</th>
                                            <th>Basic Price</th>
                                            <th>Deduction</th>
                                            <th>Additional Accessories</th>
                                            <th>Net Basic</th>
                                            <th>Discount</th>
                                            <th>Target</th>
                                            <th>Achieved</th>
                                            <th>Incentive</th>
                                            <th>Slab value</th>
                                            <th>Incentive Amount</th>
                                            
                                            <!--  <th>Slab value</th>
                                            
                                            <th>Incentive Amount</th> -->
                                            
                                            
                                            
                                        </tr>
                                    </thead>
                                      <tbody>
                                         <%
                                         if(listOfAllIncentiveBYHigherAuthority != null){
                 						 	for (IncentiveSalesPersonListBean i : listOfAllIncentiveBYHigherAuthority){
                                          	int i_id = i.getIncentiveBean().getIncentive_id();
                                          	
                                          	String[] splitPO = i.getIncentiveBean().getPo_date().split("-");
                                			int yearPO = Integer.parseInt(splitPO[0]);
                                			int monthPO = Integer.parseInt(splitPO[1]);
                                			String datePO = splitPO[2];
                                          %>
                                  
                                        <tr class="odd gradeX">
                                        <td><a href="incentiveView.jsp?incentive_id=<%=i.getIncentiveBean().getIncentive_id()%>&action=view&month_id=<%=monthPO%>">
                                        	<i class="icon-android-add-circle"></i><button class="btn btn-default btn-xs"><i class="icon-share-square-o" data-toggle="tooltip"
																data-placement="top" title="Go to view" ></i> View</button></a></td>
                                        <td><%=i.getIncentiveBean().getNew_repeat().toUpperCase()%></td>
                                        <td><%=i.getIncentiveBean().getInvoice_no()%></td>
                                        <td>
                                       <%if(i.getIncentive_status().equalsIgnoreCase("paid")){ %>
                                        <font color="green"><b><%=i.getIncentive_status().toUpperCase()%></b></font>
                                        <%}else if(i.getIncentive_status().equalsIgnoreCase("realese")){ %>
                                        <font color="blue"><b><%=i.getIncentive_status().toUpperCase()%></b></font>
                                        <%}else{ %>
                                         <font color="red"><b><%=i.getIncentive_status().toUpperCase()%></b></font>
                                        <%} %>
                                        </td>
                                        <td><%=i.getIncentiveBean().getYearBean().getYear()%></td>
                                        <td>
                                        	<%if(i.getPaid_date() != null){%>
                                        		<%=ddMMyyyy.format(yyyyMMdd.parse(i.getIncentiveBean().getPo_date()))%>
                                        	<%}else{ %>
                                        	  -
                                        	<%} %>
                                        </td>
                                        <td><%=ddMMyyyy.format(yyyyMMdd.parse(i.getIncentiveBean().getPo_date()))%></td>
                                        <td><%=ddMMyyyy.format(yyyyMMdd.parse(i.getIncentiveBean().getSjo_date()))%></td>
                                        <td><%=ddMMyyyy.format(yyyyMMdd.parse(i.getIncentiveBean().getInv_date()))%></td>
                                        <td><%=i.getIncentiveBean().getCustomer_code()%></td>
                                        <td><%=i.getIncentiveBean().getCustomer()%></td>
                                        <td><%=i.getSalespersonBean().getFullname()%></td>
                                        <td><%=i.getDesignation()%></td>
                                        <td><%=i.getIncentiveBean().getZoneBean().getZone_name()%></td>
                                        <td><%=i.getIncentiveBean().getProductMasterBean().getProduct_name()%></td>
                                        <td><%=i.getIncentiveBean().getProject_code()%></td>
                                        <td><%=i.getIncentiveBean().getLaserMasterBean().getLaser_source()%></td>
                                        <td><%=i.getIncentiveBean().getClassificationBean().getClassification_name()%></td>
                                        <td><%=i.getIncentiveBean().getScope()%></td>
                                        <td><%=i.getIncentiveBean().getRemarks()%></td>
                                        <td><%=String.format("%.2f",new BigDecimal(i.getIncentiveBean().getQuotation_price()))%></td>
                                        <td><%=String.format("%.2f",new BigDecimal(i.getIncentiveBean().getBasic_price()))%></td>
                                        <td><%=String.format("%.2f",new BigDecimal(i.getIncentiveBean().getDeduction()))%></td>
                                        <td><%=String.format("%.2f",new BigDecimal(i.getIncentiveBean().getAdditional_accesories()))%></td>
                                        <td><%=String.format("%.2f",new BigDecimal(i.getIncentiveBean().getNet_basic()))%></td>
                                        <td><%=String.format("%.2f",i.getIncentiveBean().getDiscount())%></td>
                                        
                                           
                                        
                                        <%String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(i.getSalespersonBean().getSales_person_id(), yearPO,i.getIncentiveBean().getProductMasterBean().getProduct_master_id(),monthPO); 
            							List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(i.getSalespersonBean().getSales_person_id(), monthPO , yearPO, i.getIncentiveBean().getProductMasterBean().getProduct_master_id());
            							List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(i.getSalespersonBean().getSales_person_id(), monthPO, yearPO, i.getIncentiveBean().getProductMasterBean().getProduct_master_id());
            							
            							
            							
            							int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
                                        %>
                                        
                                        <%Double eligible_percentage = i.getEligible_incentive_percentage();
                                        if(count == null && i.getDesignation().equalsIgnoreCase("SERVICE")){
                                        	eligible_percentage = 100.00;
                                        }
                                        %>
                                        
                                        <td><%if(count != null){%>
                                        	<%=count%>
                                        <%}else{ %>
                                        	Target Not Set
                                        <%} %></td>
                                        <td><%=achived%></td>
                                        <td>
                                        <%if(eligible_percentage != 0){%>
                                        	<%=i.getEligible_incentive_percentage()%> %
                                        <%}else if(count == null){ %>
                                        	Target Not Set
                                        <%} %>
                                        </td>
                                        <td><%=i.getSlab_value()%></td>
                                        
                                        
                                        <%Double amount = (i.getIncentive_amount()* eligible_percentage)/ 100; %>
                                        <td><%=String.format("%.2f",new BigDecimal(amount))%></td>
                                        
                                       
                                        </tr>
                                        <%} }%>
                                    </tbody>
                                </table>
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
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script> 
    <!-- END PAGE VENDOR JS-->
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    
      <script src="js/pace/pace.min.js"></script>
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm",
                  title : "Incentive List <%=nameOfYear%>",
                  exportOptions: {
                      columns: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
                  }
                }, {
                  extend: "csv",
                  className: "btn-sm",
                  title : "Incentive List <%=nameOfYear%>",
                  exportOptions: {
                      columns: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
                  }
                }, {
                  extend: "excel",
                  className: "btn-sm",
                  title : "Incentive List <%=nameOfYear%>",
                  exportOptions: {
                      columns: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
                  }
                }],
                responsive:!0	
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
        <script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable();
            $('#datatable1').dataTable();
            $('#datatable-keytable').DataTable({
              keys: true
            });
            $('#datatable-responsive').DataTable();
            $('#datatable-scroller').DataTable({
              ajax: "js/datatables/json/scroller-demo.json",
              deferRender: true,
              scrollY: 380,
              scrollCollapse: true,
              scroller: true	
            });
            var table = $('#datatable-fixed-header').DataTable({
              fixedHeader: true
            });
          });
          TableManageButtons.init();
        </script>
    
</body>
</html>