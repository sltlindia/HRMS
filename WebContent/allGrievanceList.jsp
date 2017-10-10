<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryBean"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@page import="com.hrms.recruitement.bean.ResumeDataBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.recruitement.bean.VacancyFormBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.recruitement.dao.AllRecruitmentListDAO"%>
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
    <!-- END Custom CSS-->
<script type="text/javascript">
function demo(grievance_query_id){
	
	var retVal = confirm("Are you sure?");
		if( retVal == true )
			{
			window.location.replace("grievanceQueryDelete?grievance_query_id="+grievance_query_id);
			}
				else
  			{
 				 document.write ("User does not want to continue!");
 				window.location.replace("allGrievanceList.jsp");
  				return false;
		 		}
}
</script>
<%@include file="header.jsp"%>
</head>


<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int employee_id = user.getEmployee_master_id();
int manager_id = user.getManagerBean().getManager_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
%>
       <div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12">
					<h2 class="content-header-title mb-0">Query List</h2>
				</div>
			</div>
			<!-- /.row -->
			<%if(request.getAttribute("delete") !=null ) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${delete}
                            </div>
          		</div>  
          		<%} %>
          		
          		<div class="content-body">
							<section id="dom">
								<div class="row">
				   					 <div class="col-md-12">
							            <div class="card">
							                <div class="card-header">
							                    <h4 class="card-title">Report Of Pending Queries</h4>
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
							                        <table class="table table-striped table-bordered dom-jQuery-events">
							                            <thead>
							                                		<tr>
							                                            	 <%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
							                                            	<th>Employee Code</th>
							                                             	<th>Employee Name</th>
							                                             	<th>Department</th>
							                                             	<%} %>
							                                            	<th>Query</th>
							    											<th>Type</th>
							    											<th>Date Of Submission</th>
							                                                <th>Attachment</th>
							                                                <th>Escalated To</th>
							                                             	<th>Status</th>
							                                             	<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
							                                             	<th>Action</th>
							                                             	<%} %>
							                                            </tr>
							                            </thead>
							                            <tbody>
							                                <%AllListGrievanceDAO allListGrievanceDAO = new AllListGrievanceDAO();
																	
																	List<GrievanceQueryBean> listOfGrievance  = null;
																if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){	
							                                    listOfGrievance = allListGrievanceDAO.getListOfPendingGrievanceQuery();
																}else{
							                                    listOfGrievance = allListGrievanceDAO.getListOfPendingGrievanceQueryByEmployeeId(employee_id);
							                                    System.err.println(listOfGrievance.size());
																}
							                                   	for(GrievanceQueryBean g : listOfGrievance){
							                                   		String date_of_submission = g.getDate_of_submission();
							                                   		String date_of_resolve = g.getDate_of_resolve();
							                          			  String ds = "-";
							                          			  String dr = "-";
																	   try {
												   							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												   							SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												    						
												   							Date result = formater.parse(date_of_submission);
												   							ds = AppDateFormat.format(result);
												   							
												   							if(!date_of_resolve.equalsIgnoreCase("null")){
												   							Date result2 = formater.parse(date_of_resolve);
												   							dr= AppDateFormat.format(result2);
												   							}
												   							
												   							System.out.println(AppDateFormat.format(result));
												   						} catch (ParseException e1) {
												   							e1.printStackTrace();
												   					}%>	                                         
							                                         	<tr>
							                                         	<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
							                                         	 <td><%=g.getEmployeeBean().getEmployee_code()%></td>
							                                             <td><%=g.getEmployeeBean().getFirstname()+" "+g.getEmployeeBean().getLastname()%></td>
							                                             <td><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
							                                             <%} %>
							                                         	<td><%=g.getQuery()%></td>
							                                         	<td><%=g.getGrievanceQueryTypeBean().getGrievance_query_type()%></td>
							                                         	<td><%=ds%></td>
							                                         	<td>
							                                         	<%
							                                         	String ext = FilenameUtils.getExtension(g.getAttachment()); // returns "exe"
							                                         	if(!g.getAttachment().equalsIgnoreCase("-")){
							                                         	%>
							                                         	<a href="downloadGrievance?attachment=<%=g.getAttachment()%>"><img src="upload/IconsOfMSOffice/<%=ext%>.png" height="25px" width="25px" data-toggle="tooltip" data-placement="top" title="<%=g.getAttachment()%>"></a>
																			<a href="downloadGrievance?attachment=<%=g.getAttachment()%>">&nbsp;&nbsp;<i class="icon-download3" style="font-size: 15px;"></i></a>
																			<%}else{ %>
																			No Attachment
																			<%} %>
																		</td>
																		<td>
																		<%int escalated_id = g.getEscalation_id();
																		if(escalated_id != 0){
																		 LoginDAO loginDAO = new LoginDAO();
																		 EmployeeBean employeeBean = loginDAO.getInfoById(escalated_id);
																		%>
																		<%=employeeBean.getFirstname() +" "+ employeeBean.getLastname()%>
																		<%}else{ %>
																		----
																		<%} %>
																		</td>
							                                         	<td><%=g.getStatus()%></td>
							                                         	<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
							                                             	<td><a href="" data-toggle="modal" data-target="#myModalReply<%=g.getGrievance_query_id()%>"><i class="icon-forward2" data-toggle="tooltip" data-placement="top" title="Reply" ></i></a>&nbsp;&nbsp;
							                                             		<a style="cursor: pointer;"><i class="icon-cross" data-toggle="tooltip" data-placement="top" title="Delete" style="color: red;" onclick="demo(<%=g.getGrievance_query_id()%>)"></i></a>
							                                             		<a href="" data-toggle="modal" data-target="#myModal1<%=g.getGrievance_query_id()%>"><i class="icon-share2" data-toggle="tooltip" data-placement="top" title="Escalate" ></i></a>
							                                             	</td>
							                                             <%} %>
							                                         	
							                                         	</tr>
							                                         	
							                                         	<div class="modal fade" id="myModal1<%=g.getGrievance_query_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							                                <div class="modal-dialog">
							                                    <div class="modal-content">
							                                        <div class="modal-header">
							                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                                            <h4 class="modal-title" id="myModalLabel">List of Authorised Persons</h4>
							                                        </div>
							                                        <form action="grivanceEscalationInsert">
							                                         <input type="hidden" name="grievance_id" value="<%=g.getGrievance_query_id()%>">
							                                        <div class="modal-body">
							                                        <select required class="form-control" name="employee_master_id">
																		<option value="">---Select Person Name---</option>
																		<%
							                                        	AllListDAO employeeList  = new AllListDAO();
							                                            List<EmployeeBean> listOfEmployee = employeeList.getFullListOfEmployee(manager_id);
							                   						 	for (EmployeeBean e : listOfEmployee){
							                                            %>
							                                            <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
							                                            <%} %>
							                                            </select>
							                                        </div>
							                                        
							                                        <div class="modal-footer">
							                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							                                            <input type="submit" class="btn btn-primary" value="SEND">
							                                        </div>
							                                        </form>
							                                    </div>
							                                    <!-- /.modal-content -->
							                                </div>
							                                <!-- /.modal-dialog -->
							                            </div>
							                                   
							                                    <!-- /.modal-content -->
							                                </div>
							                                <!-- /.modal-dialog -->
							                            </div>
							                                         <%} %>	
							                            </tbody>
							                            
							                        </table>
							                        </div><br>
							                        <h5><b>Legends :&nbsp;</b></h5> <i class="icon-download3" style="color:#337ab7;"></i><b> : Download File</b> 
                                         	<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
                                         &nbsp;&nbsp;&nbsp;<i class="icon-undo2" style="color:#337ab7;"></i><b> : Reply </b>&nbsp;&nbsp;&nbsp;<i class="icon-cross" style="color:red;"></i><b> : Delete </b>	
                                         <%} %>
							                        
							                    </div>
							                </div>
							            </div>
							            </div>
							            </div>
							</section>
							
							<section id="dom">
								<div class="row">
				   					 <div class="col-md-12">
							            <div class="card">
							                <div class="card-header">
							                    <h4 class="card-title">Report Of Resolve Queries</h4>
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
							                        <table class="table table-striped table-bordered dom-jQuery-events">
							                            <thead>
							                                <tr>
				                                   				<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
				                                   				<th>Employee Code</th>
				                                             	<th>Employee Name</th>
				                                             	<th>Department</th>
				                                             	<%} %>
				                                            	<th>Query</th>
				    											<th>Type</th>
				    											<th>Date Of Submission</th>
				                                                <th>Date Of Resolution</th>
				                                             	<th>Reply</th>
				                                             	<th>Status</th>
				                                             	<th>Attachment</th>
				                                             	<th>Reply Attachment</th>
				                                             	<th>Action</th>
				                                   			</tr>
							                            </thead>
							                            <tbody>
							                                	<%
							                                   	List<GrievanceQueryBean> listOfResolveQuery = null;
							                                   	if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){	
							                                   	listOfResolveQuery = allListGrievanceDAO.getListOfResolveGrievanceQuery();
							                                   	}else{
							                                   	listOfResolveQuery = allListGrievanceDAO.getListOfResolveGrievanceQueryByEmployeeId(employee_id);
							                                   	}
							                                   	for(GrievanceQueryBean g : listOfResolveQuery){
							                                   		String date_of_submission = g.getDate_of_submission();
							                                   		String date_of_resolve = g.getDate_of_resolve();
							                          			  String ds = "-";
							                          			  String dr = "-";
																	   try {
												   							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												   							SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												    						
												   							Date result = formater.parse(date_of_submission);
												   							ds = AppDateFormat.format(result);
												   							
												   							if(!date_of_resolve.equalsIgnoreCase("null")){
												   							Date result2 = formater.parse(date_of_resolve);
												   							dr= AppDateFormat.format(result2);
												   							}
												   							
												   							System.out.println(AppDateFormat.format(result));
												   						} catch (ParseException e1) {
												   							e1.printStackTrace();
												   					}%>	
							                                   <tr>
							                                   
							                                   			<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 117 || under_manager_id == 4){ %>
							                                   			 <td><%=g.getEmployeeBean().getEmployee_code()%></td>
							                                             <td><%=g.getEmployeeBean().getFirstname()+" "+g.getEmployeeBean().getLastname()%></td>
							                                             <td><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
							                                             <%} %>
							                                   			<td><%=g.getQuery()%></td>
							                                         	<td><%=g.getGrievanceQueryTypeBean().getGrievance_query_type()%></td>
							                                         	<td><%=ds%></td>
							                                         	<td><%=dr%></td>
							                                         	<td><%=g.getReply()%></td>
							                                         	<td><%=g.getStatus()%></td>
							                                         	<td>
							                                         	<%String ext = FilenameUtils.getExtension(g.getAttachment()); // returns "exe" 
							                                         	if(!g.getAttachment().equalsIgnoreCase("-")){%>
																			<a href="downloadGrievance?attachment=<%=g.getAttachment()%>"><img src="upload/IconsOfMSOffice/<%=ext%>.png" height="25px" width="25px" data-toggle="tooltip" data-placement="top" title="<%=g.getAttachment()%>"></a>
																			<a href="downloadGrievance?attachment=<%=g.getAttachment()%>"><i class="glyphicon glyphicon-download"></i></a>
																			<%}else{ %>
																			No Attachment
																			<%}%>
							                                         	</td>
							                                         	<td>
							                                         	<%String ext1 = FilenameUtils.getExtension(g.getReply_attachment()); // returns "exe"
							                                         	if(!g.getReply_attachment().equalsIgnoreCase("null")){%>
																			<a href="downloadGrievance?attachment=<%=g.getReply_attachment()%>"><img src="upload/IconsOfMSOffice/<%=ext1%>.png" height="25px" width="25px" data-toggle="tooltip" data-placement="top" title="<%=g.getReply_attachment()%>"></a> <%=g.getReply_attachment()%>
																			<a href="downloadGrievance?attachment=<%=g.getReply_attachment()%>"><i class="glyphicon glyphicon-download"></i></a>
																			<%}else{ %>
																			No Attachment
																			<%} %>
							                                         	</td>
							                                         	<td><a href="" data-toggle="modal" data-target="#myModalView<%=g.getGrievance_query_id()%>"><i class="icon-eye3" data-toggle="tooltip" data-placement="top" title="Show Detail"></i></a> &nbsp;&nbsp;
							                                         		<a href="showView?query_id=<%=g.getGrievance_query_id()%>" style="color: red;"><i class="icon-cross" data-toggle="tooltip" data-placement="top" title="Remove"></i>
							                                         	</td>
							                                   </tr>
							                                   <%}%>	
							                            </tbody>
							                            
							                        </table>
							                        </div><br>
							                        <h5><b>Legends :&nbsp;</b></h5> <i class="icon-download3" style="color:#337ab7;"></i><b> : Download File</b> &nbsp;&nbsp;&nbsp;<i class="icon-eye3" style="color:#337ab7;font-size: 15px;"></i><b> : View Query Details </b>&nbsp;&nbsp;&nbsp;<i class="icon-cross" style="color: red;"></i><b> : Remove Form View List</b>
							                        
							                        
							                        <%for(GrievanceQueryBean g : listOfGrievance){ %>
					                                <div class="modal fade" id="myModalReply<%=g.getGrievance_query_id() %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					                                <div class="modal-dialog">
					                                    <div class="modal-content">
					                                        <div class="modal-header">
					                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					                                            <h4 class="modal-title" id="myModalLabel">Reply For Query : <%=g.getQuery() %></h4>
					                                        </div>
					                                        <form action="queryReplyInsert" method="post" enctype="multipart/form-data">
					                                        <input type="hidden" name="query_id" value="<%=g.getGrievance_query_id()%>">
					                                        
															<table class="table" >
															<tr>
																	<td><label>Reply</label><p class="help-block">(Max 1000 Words.)</p></td>
																	<td>:</td>
																	<td><textarea class="form-control" name="reply" required></textarea></td>
															</tr>
															<tr>
																	<td><label>Attachment</label></td>
																	<td>:</td>
																	<td><input type="file" name="attachment" value=""></td>
															</tr>
															
															</table>
															<input type="hidden" name="query" value="<%=g.getQuery()%>"> 
															<input type="hidden" name="email" value="<%=g.getEmployeeBean().getEmail_id()%>">
															<input type="hidden" name="redirect">
					                                        <div class="modal-footer">
					                                        	<input type="submit" name="submit" value="SUBMIT" class="btn btn-primary">
					                                            <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
					                                        </div>
					                                    </div>
					                                    </form>
					                                    <!-- /.modal-content -->
					                                </div>
					                                <!-- /.modal-dialog -->
					                            </div>             
					                          <%} %>
					                          
					                          <%for(GrievanceQueryBean g : listOfResolveQuery){
                                    	  String date_of_submission = g.getDate_of_submission();
                                     		String date_of_resolve = g.getDate_of_resolve();
                            			  String ds = "-";
                            			  String dr = "-";
  										   try {
  					   							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
  					   							SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
  					    						
  					   							Date result = formater.parse(date_of_submission);
  					   							ds = AppDateFormat.format(result);
  					   							
  					   							if(!date_of_resolve.equalsIgnoreCase("null")){
  					   							Date result2 = formater.parse(date_of_resolve);
  					   							dr= AppDateFormat.format(result2);
  					   							}
  					   							
  					   							System.out.println(AppDateFormat.format(result));
  					   						} catch (ParseException e1) {
  					   							e1.printStackTrace();
  					   					}
  					   					%>
  					   					
                                    	<div class="modal fade" id="myModalView<%=g.getGrievance_query_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Query Detail</h4>
                                        </div>
                                        <form action="queryReplyInsert" method="post" enctype="multipart/form-data">
                                        <input type="hidden" name="query_id" value="<%=g.getGrievance_query_id()%>">
                                        
										<table class="table" >
										
										<tr>
												<td><label>Employee Code</label></td>
												<td>:</td>
												<td><%=g.getEmployeeBean().getEmployee_code()%></td>
										</tr>
										<tr>
												<td><label>Employee Name</label></td>
												<td>:</td>
												<td><%=g.getEmployeeBean().getFirstname()+" "+ g.getEmployeeBean().getLastname()%></td>
										</tr>
										
										<tr>
												<td><label>Department</label></td>
												<td>:</td>
												<td><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
										</tr>
										
										
										<tr>
												<td><label>Query</label></td>
												<td>:</td>
												<td><%=g.getQuery()%></td>
										</tr>
										<tr>
												<td><label>Query Type</label></td>
												<td>:</td>
												<td><%=g.getGrievanceQueryTypeBean().getGrievance_query_type()%></td>
										</tr>
										
										<tr>
												<td><label>Attachment</label></td>
												<td>:</td>
												<td>
												<%String ext = FilenameUtils.getExtension(g.getAttachment()); // returns "exe"
												if(!g.getAttachment().equalsIgnoreCase("-")){%>
												<a href="downloadGrievance?attachment=<%=g.getAttachment()%>"><img src="upload/IconsOfMSOffice/<%=ext%>.png" height="50px" width="50px" data-toggle="tooltip" data-placement="top" title="<%=g.getAttachment()%>"></a> <%=g.getAttachment()%>
												<%}else{ %>
												No Attachment
												<%} %>
												</td>
										</tr>
										<tr>
												<td><label>Date of Submission</label></td>
												<td>:</td>
												<td><%=ds%></td>
										</tr>
										
										<tr>
												<td><label>reply</label></td>
												<td>:</td>
												<td><%=g.getReply()%></td>
										</tr>
										
										<tr>
												<td><label>Date Of Resolve</label></td>
												<td>:</td>
												<td><%=dr%></td>
										</tr>
										
										<tr>
												<td><label>Reply Attachment</label></td>
												<td>:</td>
												<td>
												<%String ext1 = FilenameUtils.getExtension(g.getReply_attachment()); // returns "exe"
												if(!g.getReply_attachment().equalsIgnoreCase("null")){%>
												<a href="downloadGrievance?attachment=<%=g.getReply_attachment()%>"><img src="upload/IconsOfMSOffice/<%=ext1%>.png" height="50px" width="50px" data-toggle="tooltip" data-placement="top" title="<%=g.getReply_attachment()%>"></a> <%=g.getReply_attachment()%>
												<%}else{ %>
												No Attachment
												<%} %>
												</td>
										</tr>
										
										</table>
										<input type="hidden" name="query" value="<%=g.getQuery()%>">
										<input type="hidden" name="email" value="<%=g.getEmployeeBean().getEmail_id()%>">
										<input type="hidden" name="redirect">
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
                                        </div>
                                    </div>
                                    </form>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>             
                                   <%} %>
                                   
                                   <center><a href="grievance.jsp"><button type="button" class="btn btn-primary" data-dismiss="modal">Back</button></center>
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
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
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
</html>