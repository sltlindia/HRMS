<%@page import="java.text.ParseException"%>
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
    <title>Sweet Alerts - Robust Bootstrap Admin Template</title>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
  </head><script type="text/javascript">

function demo(complaint_id){
	
	var retVal = confirm("Are you sure?");
		if( retVal == true )
			{
			window.location.replace("complaintDelete?complaint_id="+complaint_id);
			}
				else
  			{
 				window.location.replace("complaint.jsp");
  				return false;
		 		}
}
</script>
<body>
<% int emp_id = user.getEmployee_master_id(); 
int i=0;
int complaint_id = Integer.parseInt(request.getParameter("complaint_id"));
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
					<h3 class="page-header">IT Complaint Register</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
   <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                        	<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">Basics Information</a>
                        </div>
                        	<div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#complaint" data-toggle="tab">F-IT-01_Complain Register_2017_FINAL</a>
                                </li>
                             
                              </ul>
                              
                               <div class="tab-content">
                                <div class="tab-pane fade in active" id="complaint">
                               <%AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
                               List<ComplaintBean> listOfComplaint = allListSelfServiceDAO.getcomplaintByComplaintId(complaint_id);
                               for(ComplaintBean l : listOfComplaint){
                               %>
                               <form action="complaintUpdate" melabelod="post" enctype="multipart/form-data">
                               <input type="hidden" value="<%=complaint_id%>" name="complaint_id" id="complaint_id"> 
                               <br>
							<div class="row">
															<div class="col-lg-3">
																<label>Employee Name</label>
																<label>:</label>
																<font color="red"><%=user.getFirstname()+" "+user.getLastname()%></font>	
														</div>
														<input type="hidden" name="employee_master_id" class="form-control"
																	value="<%=user.getEmployee_master_id()%>">
												<div class="col-lg-2">
																<label>Employee Code</label>
																<label>:</label>
																<label style="color: red"><%=user.getEmployee_code()%></label>
																</div>
														<div class="col-lg-3">
																<label>Department</label>
																<label>:</label>
																<label style="color: red"><%=user.getDepartmentBean().getDepartment_name()%></label>
																</div>
														<div class="col-lg-4">
																<label>Current Date</label>
																<label>:</label>
															<%DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
							Date today = Calendar.getInstance().getTime();  
							
							String date1= dateFormat.format(today);
							
							String d = null;
							String currenlabelate = null;
							
							try {
								  
								
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
								
								Date result = sdf.parse(date1);
								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
								SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
								currenlabelate = AppDateFormat1.format(result);
								d = AppDateFormat.format(result);
								System.out.println(AppDateFormat.format(result));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							%>
																<label style="color: red"><%=date1%></label>
																</div>
																</div>
														
						<hr>
					<div class="row">
						<div class="col-lg-4">
							<label>Extension No.</label>
							<input type="text" class="form-control" name="extension" id="extension" value= "<%=l.getExtension() %>" required>
						</div>			
						  <div class="col-lg-4">
								<label>Problem Nature</label>
								<select class="form-control" name="problem_nature"
												id="problem_nature" 
												onchange="autoShow(this.value)" required>
													<option value="0">--Select Problem Nature--</option>
													<%
															List<ProblemNatureBean> listOfProblemList = allListSelfServiceDAO.getListOfProblem();

															for (ProblemNatureBean problemNatureBean2 : listOfProblemList) {
													%>
													<%if(problemNatureBean2.getProblem_nature_id() == l.getProblemNatureBean().getProblem_nature_id()){%>
													<option value="<%=problemNatureBean2.getProblem_nature_id()%>" selected="selected"><%=problemNatureBean2.getProblem_nature_name()%></option>
													<%
															}else{%>
														<option value="<%=problemNatureBean2.getProblem_nature_id()%>"><%=problemNatureBean2.getProblem_nature_name()%></option>
													<%}
															}
													%>
											</select>
							</div>	
						<div class="col-lg-4">
							<label>Location</label>
							<input type="text" class="form-control" name="location" id="location" value="<%=l.getLocation() %>" required>
						</div>			
														
						</div>
								<hr>
								<div class="row">
						<div class="col-lg-12">
								<!-- <label>Deliverable</label> -->
								<label>Problem Description</label><br>
								<textarea id="limiter" rows="5" cols="5" class="form-control" name="problem_desc" required><%=l.getDescription()%></textarea>
								<!-- <textarea id="limiter" rows="5" cols="5" class="form-control" name="deliverable" value="" placeholder="Machine Parameters To Be Delivered" maxlength="500"  required></textarea> -->
							</div>
						
						</div>
					</div>
					<!-- /.row -->
					<hr>
					<input type="hidden" name="redirect" value="">
				<center>
					<input type="submit" value="Update" class="btn btn-primary">
				</center>
				<br>
				</form>
                                </div> 
                              
                              
                              </div>   
                         </div>
                         
                     
                      </div>       
                              
                   <div class="panel-group" id="accordion">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">Complaint History</a>
										</h4>
									</div>
					
                                            <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover zero-configuration">
                                    <thead>
                                        <tr>
                                        <th>No.</th>
                                            <th>Employee Name</th>
                                            <th>Problem Nature</th>
                                            <th>Submission Date</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                            
                                        </tr>
                                    </thead>
                                      <tbody>
                                   <%
                                   
                                   
                                   List<ComplaintBean> listOfcomp = allListSelfServiceDAO.getcomplaintByEmployeeId(emp_id);
                                   
                                        	  for(ComplaintBean a : listOfcomp){
                                        		  
                                        		  String date = a.getDate();
                                        		  String sd = null;
                                        		  try {
		  											  
			   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			    										Date result = formater.parse(date);
			   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			    										sd = AppDateFormat.format(result);
			   											
			   											
			   											
			   										} catch (ParseException e1) {
			   											e1.printStackTrace();
			   										}	
                                        		  
                                        		                                          		  
                                          %>
                                  
                                        <tr class="odd gradeX">
                                        <td><%=i= i+1 %>
                                        <td><%=a.getEmployeeBean().getFirstname()+" "+a.getEmployeeBean().getLastname()%></td>
                                        <td><%=a.getProblemNatureBean().getProblem_nature_name()%></td>
                                        <td><%=sd%></td>
                                        <td><%=a.getStatus() %>
                                        <td><a href="" data-toggle="modal"
														data-target="#myModalView<%=a.getComplaint_id()%>"><i
															class="icon icon-eye4"
															data-toggle="tooltip" data-placement="top"
															title="View Broadcast"></i></a>
															<%if(a.getStatus().equalsIgnoreCase("pending")){ %>&nbsp;<a
																	href="complaintUpdate.jsp?complaint_id=<%=a.getComplaint_id()%>"><i
																		class="icon icon-edit2" data-toggle="tooltip"
																		data-placement="top" title="Update Complaint""></i></a>
<a href="complaintDelete?complaint_id=<%=a.getComplaint_id()%>"><i
																		class="icon icon-trash" style="color: red;
																		data-toggle="tooltip" data-placement="top"
																		title="Delete Complaint"
																		onclick="demo(<%=a.getComplaint_id()%>)"></i></a> 
												<%} %>			
															
															
															</td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                                <%} 
                               List<ComplaintBean> listOfcomp = allListSelfServiceDAO.getcomplaintByEmployeeId(emp_id);
											for (ComplaintBean a : listOfcomp) {
										%>
										<div class="modal fade"
											id="myModalView<%=a.getComplaint_id()%>" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<%
												int complaint_id1 = a.getComplaint_id();
											%>
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel"></h4>
													</div>
													<table class="table">
														<tr>
															<td><label>&nbsp;Complaint Done By</label></td>
															<td>:</td>
															<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
														</tr>
														<tr>
															<td><label>&nbsp;Problem Nature</label></td>
															<td>:</td>
															<td><%=a.getProblemNatureBean().getProblem_nature_name()%></td>
														</tr>
														<%
															String ds = a.getDate();
																try {
																	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																	SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																	Date result1 = formater.parse(ds);
																	ds = AppDateFormat.format(result1);
																	

																	System.out.println(AppDateFormat.format(result1));
																} catch (ParseException e1) {
																	e1.printStackTrace();
																}
														%>
														<tr>
															<td><label>&nbsp;Date Of Submission</label></td>
															<td>:</td>
															<td><%=ds%></td>
														</tr>
														<tr>
															<td><label>&nbsp;Description</label></td>
															<td>:</td>
															<td><%=a.getDescription()%></td>
														</tr>
														<tr>
															<td><label>&nbsp;Location</label></td>
															<td>:</td>
															<td><%=a.getLocation()%></td>
														</tr>
														<tr>
															<td><label>&nbsp;Extension</label></td>
															<td>:</td>
															<td><%=a.getExtension() %>
															</td>
														</tr>
														
														

													</table>
													<input type="hidden" name="redirect">
													<div class="modal-footer">
														<button type="button" class="btn btn-danger"
															data-dismiss="modal">CLOSE</button>
													</div>
												</div>
												</form>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->



										</div>
										<%
											}
										%>
                                
                                  <h5><b>Legends :&nbsp;</b></h5>&nbsp;&nbsp;&nbsp;<i class="icon  icon-edit2" style="color:#3BAFDA;"></i><b> : Edit Complaint </b> &nbsp;&nbsp;&nbsp;<i class="icon icon-eye4" style="color:#3BAFDA;"></i><b> : View Complaint </b></div>

                                       
                            </div>
                       </div></div></div>     
                       
                       </div>
     
     
 </div> </div>
                      
   
        
                              <div class="tab-pane fade" id="download">
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
	<!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
</body>
</html>