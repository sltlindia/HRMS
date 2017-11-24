<%@page import="com.hrms.kaizen.bean.KaizenProblemIdentificationBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
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
    <title>CI Problem Identification</title>
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
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
    

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%

	int manager_id = user.getManagerBean().getManager_id();
	AllListDAO allListDAO = new AllListDAO();
	
	List<YearBean> listOfYear = allListDAO.getListOfYear();
	List<MonthBean> listOfMonth = allListDAO.getListOfMonth();
	  AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

 %>
 <div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Problem List</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
 
 			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				        	<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
				        	<div class="col-md-6">
				            	<h4 class="card-title" id="horz-layout-basic">Problem List</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				            </div>
							<div class="col-md-6" align="right">
								<button data-toggle="modal" data-target="#addProblem"
										class="btn btn-default">Add Problem</button>
							</div>
							</div>	
						<!-- /.panel-heading -->
				<div class="card-body collapse in">
					   <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
							<div id="table-responsive">
								<table class="table table-stripped ">
									<thead>
										<tr>
											<th style="padding : 5px; " ">Problem</th>
											<th style="padding : 5px; " ">Category</th>
											<th style="padding : 5px; " ">Added By</th>
											<th style="padding : 5px; " ">Date</th>
											<th colspan="2" style="padding : 5px; " ">Action</th>
										</tr>
									</thead>

									<tbody>
										<%List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptId(user.getDepartmentBean().getDepartment_id());
                                      for(KaizenProblemIdentificationBean kaizenProblemIdentificationBean : listOfIdentification){
                                    	  KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenByProblemId(kaizenProblemIdentificationBean.getKaizen_problem_identification_id());
                                      %>
										<tr>
											<td style="padding : 5px; " "><%=kaizenProblemIdentificationBean.getProblem_description()%></td>
											<td style="padding : 5px; " "><%=kaizenProblemIdentificationBean.getCategory()%></td>
											<td style="padding : 5px; " "><%=kaizenProblemIdentificationBean.getEmployeeBean().getFirstname()+" "+kaizenProblemIdentificationBean.getEmployeeBean().getLastname()%></td>
											<td style="padding : 5px; " "><%=dateFormat.format(dateFormat1.parse(kaizenProblemIdentificationBean.getDate()))%></td>
											<td style="padding : 5px; " ">
											<%if(kaizenProblemIdentificationBean.getEmployeeBean().getEmployee_master_id() == user.getEmployee_master_id()){%>
											
												
												<%if(kaizenBean == null) {%>
												<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#edit<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>">
													Edit <i class="fa fa-edit"></i>
												</button>
													<a href="problemIdentificationDelete?problem_id=<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>" style="text-decoration: none;color: black;"><button type="button" class="btn btn-default btn-xs">
													Delete <i class="fa fa-trash"></i></button></a>
												
												<%} %>
												<%} %>
												</td>

											<td style="padding : 5px; " ">
											<%
											if(kaizenBean != null){
											%>
											<a
												href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>"><button
														class="btn btn-default btn-xs">CI Detail
														</button></a>
											<%}else{ %>
											
											<a
												href="kaizen.jsp?id=<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>"><button
														class="btn btn-default btn-xs">CI For this
														Problem</button></a>
											<%} %>
											</td>
										</tr>


										<div class="modal fade" id="edit<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel">Edit
															Problem Identification</h4>
													</div>
													<form action="problemIndentificationUpdate" method="post">
														<div class="modal-body">
															<input type="hidden" name="p_id"
																value="<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>">
																
																<input type="hidden" name="date"
																value="<%=kaizenProblemIdentificationBean.getDate()%>">
																
																<input type="hidden" name="emp_id"
													value="<%=kaizenProblemIdentificationBean.getEmployeeBean().getEmployee_master_id()%>">
															<label>Problem Description</label>
															<textarea class="form-control" name="description"
																placeholder="Max 500 words"><%=kaizenProblemIdentificationBean.getProblem_description()%></textarea>
															<label>Category</label> <select class="form-control"
																name="category"
																onchange="departmentHideShow(this.value);">
																<option value="">---Select Category---</option>
																<%if(kaizenProblemIdentificationBean.getCategory().equalsIgnoreCase("A")){%><option value="A" selected="selected"><%}else{%><option value="A"><%}%>A : Can be improved by self</option>
																<%if(kaizenProblemIdentificationBean.getCategory().equalsIgnoreCase("B")){%><option value="B" selected="selected"><%}else{%><option value="B"><%}%>B : Can be improved by help of other Department</option>
																<%if(kaizenProblemIdentificationBean.getCategory().equalsIgnoreCase("C")){%><option value="C" selected="selected"><%}else{%><option value="C"><%}%>C : Can be improved by help of Management</option>
															</select>
														</div>
													
														<div class="modal-footer">
															<input type="hidden" name="redirectionTeamMember">
															<input type="submit" class="btn btn-primary"
																name="submit" value="Update">
															<button type="button" class="btn btn-danger"
																data-dismiss="modal">CLOSE</button>
														</div>
													</form>
													<!-- /.modal-content -->
												
												</div>
												<!-- /.modal-dialog -->
											</div>
										</div>


										<%} %>
									</tbody>
								</table>
							</div>
							</div>
					

							<div class="modal fade" id="addProblem" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<form action="problemIndentificationInsert" method="post">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">Problem
													Identification</h4>
											</div>
											<div class="modal-body">
												<input type="hidden" name="emp_id"
													value="<%=user.getEmployee_master_id()%>"> <label>Problem
													Description</label>
												<textarea class="form-control" name="description"
													placeholder="Max 500 words"></textarea>
												<label>Category</label> <select class="form-control"
													name="category" onchange="departmentHideShow(this.value);">
													<option value="">---Select Category---</option>
													<option value="A">A : Can be improved by self</option>
													<option value="B">B : Can be improved by help of other Department</option>
													<option value="C">C : Can be improved by help of Management</option>
												</select>
											</div>
											<div class="modal-footer">
												<input type="submit" class="btn btn-primary" value="SUBMIT">
											</div>
										</div>
									</form>
							
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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    
    function showData(id){
		 $("."+id).slideToggle(2);
	     $("i", "#"+id).toggleClass("fa-minus-circle fa-plus-circle");
	}
    </script>


	<!-- <script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	<script src="js/datatables/dataTables.buttons.min.js"></script>
	<script src="js/datatables/buttons.bootstrap.min.js"></script>
	<script src="js/datatables/jszip.min.js"></script>
	<script src="js/datatables/pdfmake.min.js"></script>
	<script src="js/datatables/vfs_fonts.js"></script>
	<script src="js/datatables/buttons.html5.min.js"></script>
	<script src="js/datatables/buttons.print.min.js"></script>
	<script src="js/datatables/dataTables.fixedHeader.min.js"></script>
	<script src="js/datatables/dataTables.keyTable.min.js"></script>
	<script src="js/datatables/dataTables.responsive.min.js"></script>
	<script src="js/datatables/responsive.bootstrap.min.js"></script>
	<script src="js/datatables/dataTables.scroller.min.js"></script>

	<script src="js/pace/pace.min.js"></script> -->
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

</body>
</html>