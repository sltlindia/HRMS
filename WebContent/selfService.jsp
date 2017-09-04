<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="com.hrms.selfservice.bean.SelfServiceQuerybean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.SelfServiceTypeBean"%>
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
    <title>Upload Document</title>
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
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int employee_id = user.getEmployee_master_id(); %>
 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>Self Service HR</h4>
			            <hr>
			        </div>
			    </div>
				<div class="row">
				    <div class="col-md-6">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Document Upload</h4>
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
	               				 <div class="card-block">
	               				 	<form action="selfServiceQueryInsert" class="dropzone" method="post" name="" enctype="multipart/form-data">
				                    	<div class="form-body">
				                    		<div class="row">
				                    			<div class="form-group col-xs-12 mb-2">
				                    				<label class="sr-only" for="timesheetinput7">Type</label>
				                    				<div class="position-relative has-icon-left">
								                         	<select class="select2-theme form-control" id="proofType" name="selfservice_query_type_id" required onchange="show();"">
								                         		<option value="0">--- Select Type ---</option>
																<%AllListSelfServiceDAO allListDAO = new AllListSelfServiceDAO();
																	List<SelfServiceTypeBean> listOfSelfServiceType = allListDAO.getListOfSelfServiceType();
														 	          for (SelfServiceTypeBean s : listOfSelfServiceType){%>				
																<option value="<%=s.getSelfservice_type_id()%>"> <%=s.getSelfservice_type()%></option>
																<%}%>			
															</select>
								                       <div class="form-control-position">
							                                <i class="icon-paper-clip"></i>
							                            </div>
								                       </div>
						                        </div>
				                    		</div>
				                    		<div class="row">
												<div class="form-group col-xs-12 mb-2">
													<label class="sr-only" for="timesheetinput7">Description</label>
													<div class="position-relative has-icon-left">
						                            	<textarea rows="3" class="form-control" name="description" id="description" placeholder="Description" onchange="show();"></textarea>
							                            <div class="form-control-position">
							                                <i class="icon-file2"></i>
							                            </div>
						                            </div>
												</div>
											</div>
											<div style="border: 1px solid #D4D4D4;" id="hide">
											<div class="dz-message">
												<div class="col-lg-12">
													<i class="fa fa-upload fa-3x"></i>
												</div>
													<h3>Drop files here or click to upload.</h3>
														<em>(Once you select file(s).Files are automatically
															uploaded to server.)</em>
											</div>
											 <div class="fallback">
											    <input name="attachment" type="file" />
											  </div>
											  </div>
							                <br>
					                     </div>
					                 </form>
	               				 </div>
	               			</div>
	               			
	               			
				        </div>
				    </div>
				    
				    <div class="col-md-6">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">List</h4>
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
				                        <table class="table table-striped table-bordered comma-decimal-place" width="100%">
				                            <thead>
				                                <tr>
													<th>Date Of Submission</th>
													<th>Description</th>
													<th>Attachment</th>
												</tr>
				                            </thead>
				                            <tbody>
				                             <%
												AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
											List<SelfServiceQuerybean> listOfSelfServiceQuery = null;
											
											
												listOfSelfServiceQuery = allListSelfServiceDAO.getListOfSelfServiceQueryByEmployeeId(employee_id);
												for (SelfServiceQuerybean s : listOfSelfServiceQuery) {
				
													String date_of_submission = s.getDate_of_submission();
													String d = null;
													try {
				
														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date_of_submission);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														d = AppDateFormat.format(result);
														System.out.println(AppDateFormat.format(result));
				
													} catch (ParseException e1) {
														e1.printStackTrace();
													}
											%>
				                                <tr>
													<td><%=d%></td>
													<td><%=s.getDescription()%></td>
													<td><a href="#">
				                                        <img class="img-thumbnail img-fluid" src="FileServlet?path=D:\hrms\upload\selfService\<%=s.getAttachment() %>" itemprop="thumbnail" alt="Image description" style="height: 30px;width: 30px;" />
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
				 
			</section>     		
      	</div>
      </div>
</div>

<%@include file="footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function(){
		$('#hide').hide();
	});
</script>

<script type="text/javascript">
	function show()
	{
		var proof = $('#proofType').val(); 
		var description1 = $('#description').val();
		alert("PROOF :" + proof);
		alert("DESCRIPTION :" + description1);
		
		if( proof != 0 && description1 != "")
			{
				$('#hide').show();
			}
	}
</script>
 
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