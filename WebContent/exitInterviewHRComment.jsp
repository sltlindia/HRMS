<%@page import="com.hrms.exitformality.bean.ExitInterviewEmployeeBean"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewScoreBean"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewManagerCommentsBean"%>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
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
    <style type="text/css">
    .form-control {
	    padding: .5rem .75rem;
	    font-size: 1rem;
	    line-height: 1.25;
	    color: #55595C;
	    border: 1px solid #D4D4D4;
	    background-color: #FFF;
	    background-image: none;
	    -webkit-background-clip: padding-box;
	    background-clip: padding-box;
	    border-radius: .18rem;
	    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	    -moz-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	}
	</style>
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
int exit_interview_id = Integer.parseInt(request.getParameter("exit_employee_id"));
String emp_name = user.getFirstname()+" "+ user.getLastname();
int manager_id = user.getManagerBean().getManager_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());

%>
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      			<div class="content-body">
      				<section id="horizontal-form-layouts">
      					<div class="row"> 
							<div class="col-xs-12">
								<h4>Exit Interview Form</h4>
								<hr>
							</div>
						</div>
      					<div class="card">
	      					<div class="card-body collapse in">
			               		<div class="card-block">
									<div class="form-body">
										
										<div class="row">
											<div class="col-md-10 col-sm-10 col-xs-6">
												<h3 class="page-header" align="Center" style="margin-top: 0px;">Exit Interview Form<br> F-HRD-19</h3>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-6">
												<%
													AllListExitFormalityDAO allListExitFormalityDAO= new AllListExitFormalityDAO();
													List<ExitInterviewEmployeeBean> listOfExitEmployee = allListExitFormalityDAO.getListOfExitEmployee(exit_interview_id);	
													for(ExitInterviewEmployeeBean e : listOfExitEmployee){
													
														int company_id = e.getEmployeeBean().getCompanyListBean().getCompany_list_id();
														
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
														src="img/sltllogo.png" width="170px" height="70px">
													<%} else if (company_id == 5) {%>
														<img alt="logo"
														src="img/sltllogo.png" width="170px" height="70px">
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
			                    		<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>1) Name Of Employee:</label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <%=e.getEmployeeBean().getFirstname() +" "+ e.getEmployeeBean().getLastname() %>
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>2) Department : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                            <%=e.getDepartment() %>
					                        </div>
		                      			</div>
		                      			<%
											int managerId = Integer.parseInt(e.getReporting_manager());
											LoginDAO loginDAO = new LoginDAO();
											EmployeeBean employeeBean = loginDAO.getEmailId(managerId);
											%>
										<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>3) Reports To : </label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%>
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>4) Designation : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                            <%=e.getDesignation() %>
					                        </div>
		                      			</div>
		                      			<%
											String jd = null;
											String td = null;
												
												String joiningDate = e.getDate_of_joining();
												String terminationDate = e.getTermination_date();
											
												try {
													  
													SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(joiningDate);
													Date result1 = formater.parse(terminationDate);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
												jd = AppDateFormat.format(result);
													td = AppDateFormat.format(result1);
													System.out.println(AppDateFormat.format(result));
													
													
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
											
											%>
										<div class="row">
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>5) Date Of  Joining : </label>
					                        </div>
					                        <div class="form-group col-md-4 col-xs-6">
					                            <%=jd %>
					                        </div>
					                        <div class="form-group col-md-2 col-xs-6">
					                        	<label>6) Termination Date : </label>
					                        </div>
					                       <div class="form-group col-md-4 col-xs-6">
					                            <%=td %>
					                       </div>
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
							                    <table class="table table-hover table-bordered">
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
														List<ExitInterviewScoreBean> listOfAttributeScore = allListDAO.getListOfAttributeScore(exit_interview_id);
															for(int i=0;i<listOfAttributeScore.size();i++){
																ExitInterviewScoreBean eis = listOfAttributeScore.get(i);
														%>
							                            <tr>
							                                <td><%=i+1 %></td>
							                                <td><%=eis.getExit_interview_attribute()%></td>
							                                <td style="width: 250px;"><%=eis.getExit_interview_score() %></td>
							                                <td><%=eis.getExit_interview_comments() %></td> 
							                            </tr>
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
												</div>
												<%if(request.getParameter("action") != null){ 
													ExitInterviewManagerCommentsBean exitInterviewManagerCommentsBean = allListExitFormalityDAO.getManagerCommentById(employee_master_id, exit_interview_id);
												%>
												<div class="row">
													<div class="form-group col-md-12 col-xs-12">
															<h4><u>Discussing Manager's Comments :</u> (<%=emp_name %>)</h4>
															<p>(Please remember the objective of the Exit Interview is to obtain feedback)</p>
																1. The main issue responsible for the individual's resignation is :
																<textarea rows="" cols="" class="form-control" name="mainIssue" readonly="readonly"><%=exitInterviewManagerCommentsBean.getMain_issue() %></textarea>
																(only one issue please)
																<br>
																<br>
																2. What are secondary issues which may have reinforced the individual's decision to leave?
																<textarea rows="" cols="" class="form-control" name="secondaryIssue" readonly="readonly"><%=exitInterviewManagerCommentsBean.getSecondary_issue() %></textarea>
																<br>
																3. What are the two key suggestions made by the individual which can actually change (for the better) the way we work?
																<textarea rows="" cols="" class="form-control" name="keySuggestions" readonly="readonly"><%=exitInterviewManagerCommentsBean.getKey_suggestions() %></textarea>
													</div>
												</div>
												
							                  </div>
							                  <%}else{ %>
							                  	<form action="exitInterviewManagerCommentsInsert" method="post">
														<h4><u>Discussing Manager's Comments :</u> (<%=emp_name %>)</h4>
														<p>(Please remember the objective of the Exit Interview is to obtain feedback)</p>
															1. The main issue responsible for the individual's resignation is :
															<textarea rows="" cols="" class="form-control" name="mainIssue"></textarea>
															(only one issue please)
															<br>
															<br>
															2. What are secondary issues which may have reinforced the individual's decision to leave?
															<textarea rows="" cols="" class="form-control" name="secondaryIssue"></textarea>
															<br>
															3. What are the two key suggestions made by the individual which can actually change (for the better) the way we work?
															<textarea rows="" cols="" class="form-control" name="keySuggestions"></textarea>
														
															<br>
															<center><input type="submit" class="btn btn-primary" id="subm"  name="submit" value="SUBMIT"></center>
														
														<input type="hidden" name="exit_interview_employee_id" value="<%=exit_interview_id%>">
														<br>
														</div>
													</div>
												</form>
							                </div>
										</div>
										
										<%}} %>
									</div>
									</section>
								</div>
      </div>
</div>
</body>
</html>