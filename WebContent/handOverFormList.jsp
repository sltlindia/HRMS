<%@page import="com.hrms.exitformality.bean.HandOverApprovalBean"%>
<%@page import="com.hrms.exitformality.bean.DetailsOfHandOverFormBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hand Over Form List</title>
<!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
<%@include file="header.jsp" %>
</head>
<body>
<%
   int manager_id = user.getManagerBean().getManager_id();
   int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
%>
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">Hand Over List</h4>
				                		</div>
				            		</div>

<!-- <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      <div class="content-body">
      				<section id="horizontal-form-layouts">
      					<div class="row"> 
							<div class="col-xs-12">
								<h4>Hand Over List</h4>
								<hr>
							</div>
						</div> -->
		
		
		<div class="card-body collapse in">
	  		<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<div class="row">
				    <div class="col-md-12 col-xs-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">PENDING HAND OVER FORM</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-block card-dashboard">
	               				 	<div class="table-responsive">
				                       <table class="table table-striped table-bordered zero-configuration">
                               	<thead>
                                 	<tr>
                                    	<th>Employee Name</th>
                                    	<th>Designation</th>
                                    	<th>Department</th>
                                    	<th>Action</th>
                                    	
									</tr>
								</thead>
									
								<tbody>
									<%AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();
									List<DetailsOfHandOverFormBean> listOfExitFormalityFormByEmpId = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverId(employee_master_id);
									
									for(DetailsOfHandOverFormBean d : listOfExitFormalityFormByEmpId){ %>
										<tr>
											<td><%=d.getHand_over_from_name() %></td>
											<td><%=d.getHand_over_from_designation() %></td>
											<td><%=d.getHand_over_from_department() %></td>
											<td><a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-edit"></i> Review</button></a></td>
										</tr>
									<%} %>
									
									
									<%
									List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverIdAfterSecondApproval = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverIdAfterSecondApproval(manager_id);
									for(DetailsOfHandOverFormBean d : listOfExitFormalityFormByHandOverIdAfterSecondApproval){ 
									
										int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
										
										HandOverApprovalBean handOverApprovalBean = allListExitFormalityDAO.getHandOverDetailIdByEmpId(employee_master_id, details_of_hand_over_form_id);
										if(handOverApprovalBean != null){
										%>
											<tr>
												<td><%=d.getHand_over_from_name() %></td>
												<td><%=d.getHand_over_from_designation() %></td>
												<td><%=d.getHand_over_from_department() %></td>
												<td><a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-edit"></i> Review</button></a></td>
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
		
		
		<div class="row">
				    <div class="col-md-12 col-xs-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">COMPLETED HAND HOVER FORM</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-body collapse in">
	               				 <div class="card-block card-dashboard">
				                        <div class="table-responsive">
				                       	<table class="table table-striped table-bordered zero-configuration"">
				                               		<thead>
				                                 	<tr>
				                                    	<th>Employee Name</th>
				                                    	<th>Designation</th>
				                                    	<th>Department</th>
				                                    	<th>Action</th>
													</tr>
													</thead>
													
													<tbody>
													<%
													List<DetailsOfHandOverFormBean> listOfExitFormalityFormByEmpId1 = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverIdForView(employee_master_id);
													
													for(DetailsOfHandOverFormBean d : listOfExitFormalityFormByEmpId1){ %>
														<tr>
															<td><%=d.getHand_over_from_name() %></td>
															<td><%=d.getHand_over_from_designation() %></td>
															<td><%=d.getHand_over_from_department() %></td>
															<td><a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>&approved=approved"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-eye4"></i> View</button></a></td>
														</tr>
													<%} %>
													
													<%
													for(DetailsOfHandOverFormBean d : listOfExitFormalityFormByHandOverIdAfterSecondApproval){ 
													
														int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
													
														HandOverApprovalBean handOverApprovalBean = allListExitFormalityDAO.getHandOverDetailIdByEmpIdForView(employee_master_id, details_of_hand_over_form_id);
														if(handOverApprovalBean != null){
													%>
														<tr>
															<td><%=d.getHand_over_from_name() %></td>
															<td><%=d.getHand_over_from_designation() %></td>
															<td><%=d.getHand_over_from_department() %></td>
															<td><a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>&approved=approved"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-eye4"></i> View</button></a></td>
														</tr>
													<%} }%>
													
													<%
													if (manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117) {
													List<DetailsOfHandOverFormBean> listOfExitFormalityForHrApproval1 = allListExitFormalityDAO.getListOfExitFormalityFormForHRApproval();
													for(DetailsOfHandOverFormBean d : listOfExitFormalityForHrApproval1){ 
													
													int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
													
													Long count = allListExitFormalityDAO.getCountOfApprovalHandOver(details_of_hand_over_form_id);
													if(count == 4){
													%>
														<tr>
															<td><%=d.getHand_over_from_name() %></td>
															<td><%=d.getHand_over_from_designation() %></td>
															<td><%=d.getHand_over_from_department() %></td>
															<td><a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>&hrApproval=hrApproval&approved=approved"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-eye4"></i> View</button></a></td>
														</tr>
													<%} } }%>
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
    
    
     
  
   
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js" type="text/javascript"></script>
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