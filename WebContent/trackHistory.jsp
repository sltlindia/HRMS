<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleTrackingBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleTypeBean"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.selfservice.bean.DownloadBean"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="java.util.Calendar"%>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
    </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Vehicle Tracking History</h1>
			        </div>
			    </div>

<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
		    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Tracking History</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					
												${delete }
												<!-- /.panel-heading -->

												<div class="panel-body">

													<div class="dataTable_wrapper">
														<table
															class="table table-striped table-bordered table-hover" id="datatable-buttons">
															<thead>
																<tr>
																	<th style=" padding: 0.4rem; width: 73.8px;">No.</th>
																	<th style=" padding: 0.4rem; width: 108.8px;">Driver</th>
																	<th style=" padding: 0.4rem; width: 113.8px;">Date</th>
																	<th style=" padding: 0.4rem; width: 139.8px;">Vehicle Name</th>
																	<th style=" padding: 0.4rem; width: 133.8px;">Start reading</th>
																	<th style=" padding: 0.4rem; width: 132.8px;">End reading</th>
																	<th style=" padding: 0.4rem; width: 124.8px;">km</th>
																	<th style=" padding: 0.4rem; width: 145.8px;">ltr</th>
																	<th style=" padding: 0.4rem; width: 99.8px;">Amount</th>
																	<th style=" padding: 0.4rem; width: 75.8px;">Average</th>
																	<th style=" padding: 0.4rem; width: 176.8px;">Attachment</th>
																</tr>
															</thead>
															<tbody>
																<%
																	int k=1;
																	AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
																	List<VehicleTrackingBean> listOfVehiclesTracking = allListVtsDAO3.getListOfVehiclesTracking();
																	for (VehicleTrackingBean t : listOfVehiclesTracking) {
																%>
																<tr>
																<th style=" padding: 0.4rem; width: 73.8px;" ><%=k++ %></td>
																	<td style=" padding: 0.4rem; width: 108.8px;"><%=t.getDriverBean().getDriver_first_name()+" "+t.getDriverBean().getDriver_last_name()%></td>
																	<td style=" padding: 0.4rem; width: 113.8px;"><%=ddmmyyyy.format(yyyymmdd.parse(t.getDate()))%></td>
																	<td style=" padding: 0.4rem; width: 139.8px;"><%=t.getVehicleBean().getVehicle_name() %>
																	<%=t.getVehicleBean().getVehicle_no() %></td>
																	<td style=" padding: 0.4rem; width: 133.8px;"><%=t.getStart_reading() %></td>
																	<td style=" padding: 0.4rem; width: 132.8px;"><%=t.getEnd_reading() %></td>
																	<td style=" padding: 0.4rem; width: 124.8px;"><%=t.getKm() %></td>
																	<td style=" padding: 0.4rem; width: 145.8px;"><%=t.getLitre() %></td>
																	<td style=" padding: 0.4rem; width: 99.8px;"><%=t.getAmount() %></td>
																	<td style=" padding: 0.4rem; width: 75.8px;"><%=t.getAverage() %></td>
																
																	<td style=" padding: 0.4rem; width: 176.8px;">
																		<%String ext2 = FilenameUtils.getExtension(t.getAttachment());
								if(t.getAttachment() != null){
								%>
								 <a target="_blank" href="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getAttachment()%>">
      <img src="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getVehicleBean().getVehicle_name()%>_<%=t.getVehicleBean().getVehicle_no()%>\fuel_tracking\<%=t.getAttachment()%>" alt="<%=t.getAttachment()%>" width="60" height="60">
    </a>
								<%} 
								else { %>
								<a>-</a>
								<%} %>
								</td>
																	</tr>
																<%
																	}
																%>
															</tbody>
														</table>

													</div>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->
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
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
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
    
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>