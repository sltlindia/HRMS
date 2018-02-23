<!DOCTYPE html>
<%@page import="com.hrms.corehr.bean.CUGBean"%>
<%@page import="com.hrms.corehr.dao.AllListCoreHrDAO"%>
<html lang="en" data-textdirection="LTR" class="loading">
  
<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/dt-advanced-initialization.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:52:09 GMT -->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
   <title>CUG Number List</title>
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
    <%@include file="header.jsp"%>
  </head>
  
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

    <!-- navbar-fixed-top-->
    
    

    <!-- ////////////////////////////////////////////////////////////////////////////-->
<div class="app-content container center-layout mt-2">
<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
		<br>
   <div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> CUG Number List</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
         
                
                <%AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();
				List<CUGBean> listOfCugDetails = allListCoreHrDAO.getListOfCugNo();
				List<EmployeeBean> listOfCugDetailsFromEmployeeMaster = allListCoreHrDAO.getListOfCugNoFromEmployee();%>
		  <div class="panel-body">
                            <div class="dataTable_wrapper">	
   <div class="dataTables_wrapper form-inline dt-bootstrap4" id="DataTables_Table_0_wrapper">
         <table class="table table-striped table-bordered file-export">
            <thead>
               <tr>
                 <th>No.</th>
                 <th style="width: 150px;">Employee Name</th>
                 <th style="width: 150px;">Designation</th>
                 <th>Location</th>
                 <th>Email-Id</th>
                 <th>Mobile Number</th>
                 <th>Zone</th>
                </tr>
            </thead>
   						<tbody>
                            <%int i = 1;
                                    for(EmployeeBean c : listOfCugDetailsFromEmployeeMaster){ 
                                    if(c.getCug_num() != null){
                                    %>
                                <tr>
                                    <td><%=i++%></td>
                                    <td><%=c.getFirstname()+" "+c.getLastname()%></td>
                                    <td style="width: auto;"><%=c.getRoleBean().getRole_type()%></td>
                                    <td><%=c.getLocation()%></td>
                                    <td><%=c.getEmail_id()%></td>
                                    <td><%=c.getCug_num() %></td>
                                    <td>-</td>
                                </tr>
                                 <%} }%>
                                 
                                  <%
                                    for(CUGBean c : listOfCugDetails){ %>
                                        <tr>
                                        <td><%=i++%></td>
                                            <td><%=c.getEmpoloyee_Name()%></td>
                                            <td style="width: auto;"><%=c.getDesignation()%></td>
                                            <td><%=c.getLocation()%></td>
                                            <td><%=c.getEmail()%></td>
                                            <td><%=c.getMob_num()%></td>
                                            <td><%=c.getBelongto()%></td>
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
			</section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


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
    <!-- END PAGE VENDOR JS-->
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
   
</body>

<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/dt-advanced-initialization.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:52:11 GMT -->
</html>
