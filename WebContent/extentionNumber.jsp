<%@page import="com.hrms.corehr.bean.ExtentionNumberBean"%>
<%@page import="com.hrms.corehr.dao.AllListCoreHrDAO"%>
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
    <title>Extention Number</title>
    <link rel="shortcut icon" sizes="152x152" href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
     <%@include file="header.jsp"%>
  </head>
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

   <%AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();%> 

    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <!-- Horizontal navigation-->
    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <!-- <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12">
            <h2 class="content-header-title mb-0">CUG LIST</h2>
            <p></p>
          </div>
        </div> -->
        <div class="content-body">
		<div class="col-xl-12 col-lg-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Extention Number</h4>
				</div>
				<div class="card-body">
					<div class="card-block">
						<ul class="nav nav-tabs nav-linetriangle">
							<li class="nav-item">
							<a class="nav-link active" id="baseIcon-tab31" data-toggle="tab" aria-controls="tabIcon31" href="#tabIcon31" aria-expanded="true"><i class="ficon icon-ios-telephone"></i> E - 30</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="baseIcon-tab32" data-toggle="tab" aria-controls="tabIcon32" href="#tabIcon32" aria-expanded="false"><i class="icon-ios-telephone"></i> E - 2</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="baseIcon-tab33" data-toggle="tab" aria-controls="tabIcon33" href="#tabIcon33" aria-expanded="false"><i class="icon-ios-telephone"></i> A - 8</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="baseIcon-tab33" data-toggle="tab" aria-controls="tabIcon34" href="#tabIcon34" aria-expanded="false"><i class="icon-ios-telephone"></i> Surat</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="baseIcon-tab33" data-toggle="tab" aria-controls="tabIcon35" href="#tabIcon35" aria-expanded="false"><i class="icon-ios-telephone"></i> NYT</a>
							</li>
						</ul>
						
						
						<div class="tab-content px-1 pt-1">
							<div role="tabpanel" class="tab-pane active" id="tabIcon31" aria-expanded="true" aria-labelledby="baseIcon-tab31">
								<div class="card-body collapse in">
			                    <div class="card-block card-dashboard">
			                        <table class="table table-striped table-bordered comma-decimal-place">
			                            <thead>
	                                        <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th style="width: 100px;">Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
	                                    </thead>
			                            <tbody>
	                                    <%int i = 1;
	                                    List<ExtentionNumberBean> listOfExtentionNo = allListCoreHrDAO.getListOfExtentionNumber();
	                                    for(ExtentionNumberBean c : listOfExtentionNo){ %>
	                                        <tr>
	                                        <td><%=i++%></td>
	                                            <td><%=c.getName()%></td>
	                                            <td><%=c.getDepartment_name()%></td>
	                                            <td><%=c.getExt_No()%></td>
	                                            <td><%=c.getCompanyname()%></td>
	                                        </tr>
	                                        <%} %>
	                                    </tbody>
			                            <tfoot>
			                                <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th style="width: 100px;">Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
			                            </tfoot>
			                        </table>
			                    </div>
			                </div>
							</div>
							<div class="tab-pane" id="tabIcon32" aria-labelledby="baseIcon-tab32">
								<div class="card-body collapse in">
			                    <div class="card-block card-dashboard">
			                        <table class="table table-striped table-bordered comma-decimal-place">
			                            <thead>
	                                        <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
	                                    </thead>
			                            <tbody>
	                                    <%int j = 1;
	                                    List<ExtentionNumberBean> listOfExtentionNoE2 = allListCoreHrDAO.getListOfExtentionNumberE2(); 
	                                    for(ExtentionNumberBean c : listOfExtentionNoE2){ %>
	                                        <tr>
	                                       <td><%=j++%></td>
                                            <td><%=c.getName()%></td>
                                            <td><%=c.getDepartment_name()%></td>
                                            <td><%=c.getExt_No()%></td>
                                            <td><%=c.getCompanyname()%></td>
	                                        </tr>
	                                        <%} %>
	                                    </tbody>
			                            <tfoot>
			                                <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
			                            </tfoot>
			                        </table>
			                    </div>
			                </div>
							</div>
							
							
							<div class="tab-pane" id="tabIcon33" aria-labelledby="baseIcon-tab33">
								<div class="card-body collapse in">
			                    <div class="card-block card-dashboard">
			                        <table class="table table-striped table-bordered comma-decimal-place">
			                            <thead>
	                                        <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
	                                    </thead>
			                            <tbody>
	                                    <%int k = 1;
	                                    List<ExtentionNumberBean> listOfExtentionNoA8 = allListCoreHrDAO.getListOfExtentionNumberA8(); 
	                                    for(ExtentionNumberBean c : listOfExtentionNoA8){ %>
	                                        <tr>
	                                       <td><%=k++%></td>
                                            <td><%=c.getName()%></td>
                                            <td><%=c.getDepartment_name()%></td>
                                            <td><%=c.getExt_No()%></td>
                                            <td><%=c.getCompanyname()%></td>
	                                        </tr>
	                                        <%} %>
	                                    </tbody>
			                            <tfoot>
			                                <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
			                            </tfoot>
			                        </table>
			                    </div>
			                </div>
							</div>
							<div class="tab-pane" id="tabIcon34" aria-labelledby="baseIcon-tab33">
								<div class="card-body collapse in">
			                    <div class="card-block card-dashboard">
			                        <table class="table table-striped table-bordered comma-decimal-place">
			                            <thead>
	                                        <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
	                                    </thead>
			                            <tbody>
	                                    <%int l = 1;
	                                    List<ExtentionNumberBean> listOfExtentionNoSurat = allListCoreHrDAO.getListOfExtentionNumberSurat(); 
	                                    for(ExtentionNumberBean c : listOfExtentionNoSurat){ %>
	                                        <tr>
	                                       <td><%=l++%></td>
                                            <td><%=c.getName()%></td>
                                            <td><%=c.getDepartment_name()%></td>
                                            <td><%=c.getExt_No()%></td>
                                            <td><%=c.getCompanyname()%></td>
	                                        </tr>
	                                        <%} %>
	                                    </tbody>
			                            <tfoot>
			                                <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
			                            </tfoot>
			                        </table>
			                    </div>
			                </div>
							</div>
							<div class="tab-pane" id="tabIcon35" aria-labelledby="baseIcon-tab33">
								<div class="card-body collapse in">
			                    <div class="card-block card-dashboard">
			                        <table class="table table-striped table-bordered comma-decimal-place">
			                            <thead>
	                                        <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
	                                    </thead>
			                            <tbody>
	                                    <%int m = 1;
	                                    List<ExtentionNumberBean> listOfExtentionNoNY = allListCoreHrDAO.getListOfExtentionNumberNY(); 
	                                    for(ExtentionNumberBean c : listOfExtentionNoNY){ %>
	                                        <tr>
	                                       <td><%=m++%></td>
                                            <td><%=c.getName()%></td>
                                            <td><%=c.getDepartment_name()%></td>
                                            <td><%=c.getExt_No()%></td>
                                            <td><%=c.getCompanyname()%></td>
	                                        </tr>
	                                        <%} %>
	                                    </tbody>
			                            <tfoot>
			                                <tr bgcolor="#E5E7E9">
		                                        <th>No.</th>
		                                        <th>Name</th>
		                                        <th>Department Name</th>
		                                        <th>Extension Number</th>
		                                        <th>Location</th>
	                                        </tr>
			                            </tfoot>
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
<!-- Vertical Tabs end -->
        </div>
      </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

<%@include file="footer.html" %>
    
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
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    
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