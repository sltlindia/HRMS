<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="java.util.List"%>
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
    <title>CI List</title>
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
  </head>
  
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int emp_id = user.getEmployee_master_id(); 

AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
List<KaizenBean> listOfKaizenByEmpId = null;
if(request.getParameter("year") != null ){
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	 listOfKaizenByEmpId = allKaizenListDAO.getListOfAllKaizenByEmpId(emp_id, year, month);
}else {
	listOfKaizenByEmpId = allKaizenListDAO.getListOfAllKaizenByEmpIdOfCurrentMonth(emp_id);
}

%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">CI List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	My CI List
                        	</div>
                        	
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                        	<th>No</th>
                                        	<th>CI Name</th>
                                        	<th>Creation Time</th>
                                        	<th>Completion Time</th>
                                        	<th>Lock Status</th>
                                        	<th>Approval Staus</th>
                                        	<th>Action</th>
                                        </tr>
                                    </thead>
                                    <div class="form-group">
                                    <!-- Round Button Group -->
                                   
                                    <%-- <a href="addManagerForKaizen.jsp?kaizen_id=<%=kaizen_id%>" data-target="#myModalManager" id="addManager">&nbsp;<i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a> --%>
                                     <tbody>
                                     	
                                     	<%for(KaizenBean kaizenBean : listOfKaizenByEmpId){
                                     		int kaizen_id = kaizenBean.getKaizen_id();
                                     		
                                     	%>
                                     	<%-- <tr class="panel-group">
																<th><a id="year<%=yearBean.getYear_id()%>"
																	style="color: black; text-decoration: none; cursor: pointer;"
																	onclick="showData(this.id)"><i
																		class="icon-android-add-circle"></i> <%=year%> - <%=year1%></a></th>
																<th><div align="right"><button name="button"
																		onclick="window.open('kaizenBillBoard.jsp?year=<%=yearDuration%>','_blank')"
																		class="btn btn-primary">
																		<i class="fa fa-file-text" align="right"></i> BillBoard
																	</button>
																	<button name="button"
																		onclick="window.open('kaizenLeaderBoard.jsp?year=<%=yearDuration%>','_blank')"
																		class="btn btn-primary">
																		<i class="fa fa-file-text"></i> LeaderBoard
																	</button></div></th>
															</tr>
                                     	
                                     	 --%>
                                     	
	                                     <tr  class="panel-group">
	                                     
	                                     	<td><a id="kaizen<%=kaizenBean.getKaizen_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a></td>
	                                     	<td><%=kaizenBean.getKaizen_name()%></td>
	                                     	<td><%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%></td>
	                                     	<td><%if(kaizenBean.getCompletion_date() != null){%>
	                                     		<%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getCompletion_date()))%>
	                                     		<%}else{ %>
	                                     			-
	                                     		<%} %>
	                                     	</td>
	                                     	<td><%if(kaizenBean.getCompletion_status().equalsIgnoreCase("submitted")){%>
	                                     			LOCK
	                                     		<%}else{%>
	                                     			UNLOCK
	                                     		<%}%>
	                                     	</td>
	                                     	<td><%=kaizenBean.getStatus().toUpperCase()%></td>
	                                     	<td><a href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-primary"><i class="fa fa-share-square"></i> Detail</button></a>
	                                     	<%if(!kaizenBean.getCompletion_status().equalsIgnoreCase("completed")){%>
	                                     		<a href="kaizenPhotoUpload.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-primary"><i class="fa fa-photo"></i> Add Photos</button></a>
	                                     	<%} %>
	                                     	</td>
	                                     </tr>
	                                     <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="7">
	                                     <div class="row">
	                                     
	                                     <div class="col-sm-6 col-md-6 col-lg-6">
	                                      <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px'  alt='Sample Image'></a></div>"
														/>
												<%}%>
																					
												</div>
												</div>
	                                     </div>
	                                     
	                                     <div class="col-sm-6 col-md-6 col-lg-6">
	                                     <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;" 
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
	                                     
	                                     </div>
	                                     </div>
	                                     </td>
	                                     </tr>
	                                    <script>
	
											$(document).ready(function(){
											$(".kaizen"+<%=kaizenBean.getKaizen_id()%>).hide();
											});
	
										</script>
                                     	<%} %>
                                    </tbody>
                                </table>
                                <div align="left">
											<b>NOTE :</b>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-star-full" style="color: #85929E;" data-toggle="tooltip"
														data-placement="top" title="Billboard Result"></i><b> : BillBoard Winner</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-star-full" style="color: #F1C40F;" data-toggle="tooltip"
														data-placement="top" title="Leaderboard Result"></i><b> : LeaderBoard Winner</b>
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
    <!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
    
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
    function showData(id){
		 $("."+id).slideToggle(2);
	     $("i", "#"+id).toggleClass("icon-android-remove-circle icon-android-add-circle");
	}
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
      <!-- BEGIN PAGE VENDOR JS-->
    <!-- <script>
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
         -->
<script>
	  $("[data-toggle=popover]")
	    .popover({html:true})
	    
	    $('.popover-dismiss').popover({
	  	trigger: 'focus'
		})
	</script>
        
</body>
</html>