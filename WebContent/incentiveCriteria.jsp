<%@page import="com.hrms.incentive.bean.IncentiveSalesPersonListBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.incentive.bean.IncentiveCriteriaBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveBean"%>
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
    <title>Incentive Criteria</title>
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
<script type="text/javascript">
function updateEligibleIncentive(id,incentive) {
	
	
	
	var a = document.getElementById('arrayOfIds'+id).value;
	var sales_id = document.getElementById('salesId'+id).value;
	var month_id = document.getElementById('month'+id).value;
	var year_id = document.getElementById('year'+id).value;
	var product_id = document.getElementById('product'+id).value;
	
	/* if(a != ""){ */
	
	var retVal = confirm("Are you sure?");
	if(retVal == true){
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		
	
	var $form = $(this), url = 'eligibleIncentiveStatusUpdate';
	

	var posting = $.post(url, {
		listOfId : a,
		incentive : incentive,
		sales_id : sales_id,
		month_id : month_id,
		year_id : year_id,
		product_id : product_id
		
	});
	
	
	 posting.done(function(data) {
		
		$('.pincentiveSaveYes'+id).text(incentive+' %');
		$('.incentiveSaveNo'+id).fadeOut('fast');
		$('.incentiveSaveYes'+id).fadeIn('fast');
		
		dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>Successfully Save Eligible Incentive...<b></h4></div>');
		
	}); 
	 
}
	 
/* }else{
	var dialog = bootbox.dialog({
	    message: '<div class="text-center"><i class="fa fa-times-circle-o fa-4x"></i></div><div class="text-center"><h4><b>There is No Achieved target..Try Later<b></h4></div>',
	    onEscape : true,
	});
	} */
	
}
</script>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%int month;
int year1;
int monthId = 0;
GregorianCalendar date1 = new GregorianCalendar();    
year1 = date1.get(Calendar.YEAR);
AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();

if(request.getParameter("month_id") != null){
	monthId = Integer.parseInt(request.getParameter("month_id"));
}

 %>
	<%int employee_master_id1 = user.getEmployee_master_id(); 
		int yearId = Integer.parseInt(request.getParameter("year_id"));
		
		
		YearBean yearBean = allIncentiveListDAO.getyearByYearId(yearId);
		
	%>
	 <div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        	 <h1 class="page-header">Incentive List of
						<%=yearBean.getYear()%></h1>
				        	 <br>
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Incentive List of
							<%=yearBean.getYear()%></h4>
				               		
				                </div>
				            </div>
				            
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
	<%-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						Incentive List of
						<%=yearBean.getYear()%></h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							Incentive List of
							<%=yearBean.getYear()%></div> --%>
						<div class="panel-body">

							<div class="tab-content">
								<div class="tab-pane fade in active" id="complaint">

									<div class="panel-body">
										<div class="dataTable_wrapper">
											<div class="panel-body">
											
												<form action="" method="post">
												<div class="row">
												<div class="col-md-6 col-sm-6 col-xs6">
													<select class="form-control" name="month_id" id="month"
														required="required">
														<option value="">---Month---</option>
														<%
                                          
											AllListDAO monthList = new AllListDAO();
                                         	 List<MonthBean> listOfMonth = monthList.getListOfMonth();
                 						 	for (MonthBean m : listOfMonth){
                 						 		if(m.getMonth_id() !=0 && m.getMonth_id() <13){
                 						 			if(monthId == m.getMonth_id()){
                                          
                                          %>
														<option value="<%=m.getMonth_id()%>" selected="selected"><%=m.getMonth_name()%></option>
														<%}else{ %>
														
														<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>
														
														<%} %>
														
														<%} }%>
													</select>
												</div>
												
												
												<div class="col-md-6 col-sm-6 col-xs6">
													<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
												</div>
											</div>
											</form>	
												
												
											<hr>



												<table
													class="table table-striped table-bordered table-hover"
													border="3"
													id="dataTables-example<%=monthId%>">
													<thead>
														<tr>
															<th>Sales Person Name</th>
															<th>Month</th>
															<th>Year</th>
															<th>Product</th>
															<th>Target</th>
															<th>Achieved</th>
															<th>Percentage</th>
															<th>Eligible Incentive</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<TargetBean> listOfTarget = allIncentiveListDAO.getListOfTargetByYearId(yearId,monthId);
                                   	for(TargetBean t : listOfTarget){
                                   		int sales_id = t.getSalespersonBean().getSales_person_id();
                                   		int month_id = t.getMonthBean().getMonth_id();
                                   		int year_id = t.getYearBean().getYear_id();
                                   		int year = Integer.parseInt(t.getYearBean().getYear());
                                   		int product_id = t.getProductMasterBean().getProduct_master_id();
                                   		double target = Double.parseDouble(t.getTarget_value());
                                   		%>
														<tr>
															<td><%=t.getSalespersonBean().getFirstname()+" "+t.getSalespersonBean().getLastname()%></td>
															<td><%=t.getMonthBean().getMonth_name()%></td>
															<td><%=t.getYearBean().getYear()%></td>
															<td><%=t.getProductMasterBean().getProduct_name()%></td>
															<td><%=t.getTarget_value()%></td>

															<%
																
																List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, month_id, year, product_id);
																List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, month_id, year, product_id);
																
																String eligible_incentive_save = "no";
																double eligible_incentive_percentage = 0;
																String listOfId = "";
																for(IncentiveBean incentiveBean : listOfIncentive){
																	eligible_incentive_save = incentiveBean.getEligible_insentive_save();
																	eligible_incentive_percentage = incentiveBean.getEligible_incentive_percentage();
																	if(listOfId == ""){
																		listOfId = String.valueOf(incentiveBean.getIncentive_id());	
																	}else{
																	listOfId = listOfId+","+incentiveBean.getIncentive_id();
																	}
																}
																int achived = listOfIncentive.size() + listOfIncentiveAsHigherDesignation.size();	
																
																double achived_per = 0;
																																
																if(target != 0){
																 achived_per = (achived * 100)/target;
																}else if(achived != 0){
																	achived_per = 50;
																}
																
																System.err.println(t.getSalespersonBean().getFirstname()+":"+listOfIncentiveAsHigherDesignation.size());
																double incentive = 0;	
																	String w = String.format("%.2f", achived_per);
																	
																	if(achived_per != 0){
																	IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
																		incentive = incentiveCriteriaBean.getEligible_incentive();																	
																	}
																%>

															<td><%=achived%></td>
															<td><%=w%> %</td>
															<td><input type="hidden"
																id="arrayOfIds<%=t.getSales_target_id()%>"
																value="<%=listOfId%>"> <input type="hidden"
																id="salesId<%=t.getSales_target_id()%>"
																value="<%=t.getSalespersonBean().getSales_person_id()%>">
																<input type="hidden"
																id="month<%=t.getSales_target_id()%>"
																value="<%=month_id%>"> <input type="hidden"
																id="year<%=t.getSales_target_id()%>"
																value="<%=year_id%>"> <input type="hidden"
																id="product<%=t.getSales_target_id()%>"
																value="<%=product_id%>">

																<div class="row">
																	<div class="col-md-5">
																		<p
																			class="pincentiveSaveYes<%=t.getSales_target_id()%>"><%=incentive%>
																			%
																		</p>
																	</div>

																	<div class="col-md-3">
																		<div
																			class="incentiveSaveNo<%=t.getSales_target_id()%>">
																			<a style="cursor: pointer;"
																				onclick="updateEligibleIncentive(<%=t.getSales_target_id()%>,<%=incentive%>)"><i
																				class="icon-save"></i></a>
																		</div>
																	</div>
																</div></td>
															<td><a
																href="incentiveSalesPersonWiseReport.jsp?sales_id=<%=sales_id%>&month_id=<%=month_id%>&year_id=<%=year_id%>&product_id=<%=product_id%>&eligibleIncentive=<%=incentive%>&year=<%=year%>">
																	<button class="btn btn-default btn-sm">
																		<i class="icon-chevron-circle-right"
																			data-toggle="tooltip" data-placement="top"
																			title="show View"></i> Detail
																	</button>
															</a></td>
														</tr>

														<%} %>
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
	<%
        for(MonthBean monthBean : listOfMonth){
        	int i = monthBean.getMonth_id();
        	String nameOfMonth = monthBean.getMonth_name();
        %>
	<script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#dataTables-example"+<%=i%>).length && $("#dataTables-example"+<%=i%>).DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm",
                  title : "TargetVSAchievd Of <%=nameOfMonth%>,<%=yearBean.getYear()%>",
                  exportOptions: {
                      columns: [0,1,2,3,4,5,6,7]
                  }
                }, {
                  extend: "csv",
                  className: "btn-sm",
                  title : "TargetVSAchievd Of <%=nameOfMonth%>,<%=yearBean.getYear()%>",
                  exportOptions: {
                      columns: [0,1,2,3,4,5,6,7]
                  }
                }, {
                  extend: "excel",
                  className: "btn-sm",
                  title : "TargetVSAchievd Of <%=nameOfMonth%>,<%=yearBean.getYear()%>",
                  exportOptions: {
                      columns: [0,1,2,3,4,5,6,7]
                  },
                }, {
                  extend: "pdf",
                  className: "btn-sm",
                  title : "TargetVSAchievd Of <%=nameOfMonth%>,<%=yearBean.getYear()%>",
                  exportOptions: {
                      columns: [0,1,2,3,4,5,6,7]
                  }
                }, {
                  extend: "print",
                  className: "btn-sm",
                  title : "TargetVSAchievd Of <%=nameOfMonth%>,<%=yearBean.getYear()%>",
                  exportOptions: {
                      columns: [0,1,2,3,4,5,6,7]
                  }
                }],
                responsive: !0	
              })
            },
            TableManageButtons<%=i%> = function() {
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
            TableManageButtons<%=i%>.init();
          </script>
	<%} %>




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