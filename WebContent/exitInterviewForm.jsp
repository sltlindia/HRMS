<%@page import="com.hrms.exitformality.bean.ExitInterviewFormAttributeBean"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
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
    <title>Exit Interview From</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    
    
    <script type="text/javascript">
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "text")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
    }
</script>


<script>
    if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
        jQuery(function($){ //on document.ready
                $('#timesheetinput3').datepicker({
                    dateFormat: 'yy-mm-dd'
                });
        })
    }
</script>
    
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
			
			<%	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formater1 = new SimpleDateFormat("dd-MM-yyyy");
				LoginDAO loginDAO = new LoginDAO();
				int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
					EmployeeBean employeeBean = loginDAO.getEmployeeId(under_manager_id);
			%>
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
				               				<h4 class="card-title" id="horz-layout-basic">Exit Interview Form</h4>
				                		</div>
				            		</div>
      					<div class="card">
	      					 <div class="card-body collapse in">
	 							 <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
									<div class="form-body">
										
										<div class="row">
											<div class="col-md-9 col-sm-6 col-xs-6">
												<h3 class="page-header" align="Center" style="margin-top: 0px;">Exit Interview Form<br> F-HRD-19</h3>
											</div>
											<div class="col-md-3 col-sm-6 col-xs-6">
												<%
												int company_id = user.getCompanyListBean().getCompany_list_id();
												if (company_id == 1) {%>
													<img alt="logo"
													src="img/sltllogo.png" width="170px" height="70px">
												<%} else if (company_id == 2) {%>
													<img alt="logo"
													src="img/SS.png" width="170px" height="70px">
												<%} else if (company_id == 3) {%>
													<img alt="logo"
													src="img/S.HR.png" width="170px" height="70px">
												<%} else if (company_id == 4) {%>
													<img alt="logo"
													src="img/COSMOS.png" width="170px" height="70px">
												<%} else if (company_id == 5) {%>
													<img alt="logo"
													src="img/CS.png" width="170px" height="70px">
												<%} else if (company_id == 6) {%>
													<img alt="logo"
													src="img/sltllogo.png" width="170px" height="70px">
												<%} else if (company_id == 7) {%>
													<img alt="logo"
													src="img/SE.png" width="170px" height="70px">
												<%} else if (company_id == 8) {%>
													<img alt="logo"
													src="img/sltllogo.png" width="170px" height="70px">
												<%}%>
											</div>
										</div>
										<hr>
										<form action="exitInterviewFormInsert" method="post" enctype="multipart/form-data">
			                    		<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>1) Name Of Employee:</label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <input type="text" class="form-control" value="<%=user.getFirstname()+" "+user.getLastname() %>" readonly="readonly">
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>2) Department : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                            <input type="text" class="form-control" value="<%=user.getDepartmentBean().getDepartment_name() %>" readonly="readonly">
					                        </div>
		                      			</div>
									<%
									String joiningDate = user.getJoining_date() ;
									
									try {
										
										Date date = formater.parse(joiningDate);
										joiningDate = formater1.format(date);
									
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									%>
										<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>3) Reports To : </label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <input type="text" class="form-control" value="<%=employeeBean.getFirstname()+" "+employeeBean.getLastname() %>" readonly="readonly">
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>4) Designation : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                            <input type="text" class="form-control" value="<%=user.getRoleBean().getRole_type() %>" readonly="readonly">
					                        </div>
		                      			</div>
										<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>5) Date Of  Joining : </label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <input type="text" class="form-control" value="<%=joiningDate %>" readonly="readonly">
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>6) Termination Date : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                          <div class="form-group row">
				                        		<div class="col-md-12">
						                            <div class="position-relative has-icon-left">
						                            	<input type="text" id="timesheetinput3" class="form-control" name="termination_date" placeholder="yyyy-mm-dd" required">
							                            <div class="form-control-position">
							                                <i class="icon-calendar5"></i>
							                            </div>
						                            </div>
						                        </div>
					                        </div>
					                       </div>
					                       <input type="hidden" name="terminate">
		                      			</div>
		                      		<hr>
		                      			<div class="row">
											<div class="form-group col-md-12 col-xs-12">
												<b>Score the attributes below with a response which comes closest to how you feel or act :</b>
											</div>
										</div>
										<div class="row">
		 									<div class="form-group col-md-2 col-xs-12">
												<p>1. Always / Absolutely</p>
											</div>
											<div class="form-group col-md-3 col-xs-12">
												<p>2. Most often / To a great extent</p>
											</div>	
											<div class="form-group col-md-2 col-xs-12">
												<p>3. Sometimes / Fairly</p>
											</div>
											<div class="form-group col-md-2 col-xs-12">
												<p>4. Rarely / Somewhat</p>
											</div>	
											<div class="form-group col-md-3 col-xs-12">
												<p>5. Never / Not at all</p>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="form-group col-md-12 col-xs-12">
		 									 <div class="table-responsive">
							                    <table class="table table-bordered">
							                        <thead>
							                           <tr>
					                                    	<th>Sr No.</th>
					                                    	<th>Attribute</th>
					                                    	<th>Score</th>
					                                    	<th>Comments</th>
														</tr>
							                        </thead>
							                        <tbody>
							                        	<%
															AllListExitFormalityDAO allListDAO = new AllListExitFormalityDAO();
															List<ExitInterviewFormAttributeBean> listOfAttribute = allListDAO.getListOfAttribute();
																for(int i=0;i<listOfAttribute.size();i++){
																	ExitInterviewFormAttributeBean eifa = listOfAttribute.get(i);
															%>
							                            <tr>
							                                <td><%=i+1 %></td>
							                                <td style="white-space: pre-wrap;width: 500px;"><%=eifa.getExit_interview_form_attribute()%></td>
							                                <td>
							                                	<select class="select2-theme form-control" name="score" required="required">
							                                		<option value="">--- Select Score ---</option>
																	<option value="1. Always / Absolutely">1. Always / Absolutely</option>
																	<option value="2. Most often / To a great extent">2. Most often / To a great extent</option>
																	<option value="3. Sometimes / Fairly">3. Sometimes / Fairly</option>
																	<option value="4. Rarely / Somewhat">4. Rarely / Somewhat</option>
																	<option value="5. Never / Not at all">5. Never / Not at all</option>
							                                	</select>
							                                </td>
							                                <td><textarea name="comments" class="form-control" placeholder="Max. 1000 words" style="resize: none;"></textarea></td>
							                            </tr>
							                            <input type="hidden" name="exit_attribute_name" value="<%=eifa.getExit_interview_form_attribute()%>">
							                            <input type="hidden" name="attributeInsert">
							                            <%} %>
							                        </tbody>
							                    </table>
							                    <hr>
							                    
							                    <div class="row">
							                    	<div class="form-group col-md-12 col-xs-12">
								                    	<p><b>(If you have any further comments/suggestions, you may enclose an additional sheet)</b></p>
								                    	<textarea class="form-control" name="additional_comment"></textarea>
														<input type="hidden" name="temp">
													</div>
														<br>
													<div class="form-group col-md-12 col-xs-12">
													<center><input type="submit" class="btn btn-success btn-min-width mr-1 mb-1" id="subm"  name="submit" value="SAVE" onclick="insertData();"></center>
													</div>
												</div>
												</form>
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
    <script src="app-assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js" type="text/javascript"></script>
    
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
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