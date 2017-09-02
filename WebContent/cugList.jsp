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
    <title>CUG List</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <%@include file="header.jsp"%>
  </head>
  
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

    <!-- navbar-fixed-top-->
    
    
    <div class="fullscreen-search-overlay"></div>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
<section id="file-export">
    <div class="row">
        <div class="col-xs-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">CUG List</h4>
                    <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="icon-m	inus4"></i></a></li>
                            <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        </ul>
                    </div>
                </div>
                
                
                <%AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();
				List<CUGBean> listOfCugDetails = allListCoreHrDAO.SPgetListOfCugNo();
				List<EmployeeBean> listOfCugDetailsFromEmployeeMaster = allListCoreHrDAO.SPgetListOfCugNoFromEmployee();%>
			
                <div class="card-body collapse in">
                    <div class="card-block card-dashboard">
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
                            <tfoot>
                                <tr>
                                	 <th>No.</th>
                                    <th style="width: 150px;">Employee Name</th>
                                    <th style="width: 150px;">Designation</th>
                                    <th>Location</th>
                                    <th>Email-Id</th>
                                    <th>Mobile Number</th>
                                    <th>Zone</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- File export table -->

        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <%@include file="footer.jsp"%>

    
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
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

<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/dt-advanced-initialization.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:52:11 GMT -->
</html>
