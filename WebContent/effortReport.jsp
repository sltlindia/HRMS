<%@page import="java.util.Collections"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="com.hrms.timesheet.bean.ProjectAllocationBean"%>
<%@page import="com.hrms.pms.bean.ProjectAllocationPercentageBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.pms.bean.MilestoneBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.timesheet.dao.AllInsertDAO"%>
<%@page import="com.hrms.timesheet.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Effort Reports</title>
<script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">
/* function ListOfAllContent(id) {
	window.location.replace("listOfTaskForEffort?project_id=" +id);
} */

	
function checkedstartDate() {
	
	var a = document.getElementById('start_date');
	var b = document.getElementById('plannedStartDate');
	var c = document.getElementById('plannedEndDate');
		c.value = b.value;
}

function checkInteger(id) {
	
	if(isNaN(id)){
		alert("Character not valid");
		document.getElementById('resources').value = 1;
	}
	
}</script>
<script type="text/javascript" src="js/canvasjs.min.js"></script>

<%@include file="header.jsp"%>
</head>
<body>
<%int project_id = 0; 
List<String> arrayPlannedDuration = new ArrayList<String>();
List<String> arrayActualDuration = new ArrayList<String>();
%>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Reports</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

<form action="listOfTaskForEffort">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Effort Report</div>
						<!-- /.panel-heading -->
						<div class="panel-body">

							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-2">
													<b>Project</b>
												</div>
												<div class="col-md-3">
													<select class="form-control" name="project_id"
														id="projectName" oninput="ListOfAllContent(this.value)" style="width: 213px;">
														<option value="">---Select Project Name---</option>

														<%
															int manager_id = user.getManagerBean().getManager_id();
															AllListDAO allListDAO = new AllListDAO();
															List<ProjectMasterBean> listOfProjectMaster = allListDAO.getListOfProjectMaster(manager_id);
															for (ProjectMasterBean p : listOfProjectMaster) {
														%>
														
														<%
													if(request.getParameter("project_id") != null){
														project_id = Integer.parseInt(request.getParameter("project_id"));
													}
											%>
											<%if(p.getProject_master_id() == project_id) {%>
														<option value="<%=p.getProject_master_id()%>" selected="selected"><%=p.getProject_master_name()%></option>

														<%}else{ %>
														<option value="<%=p.getProject_master_id()%>" ><%=p.getProject_master_name()%></option>
														<%
															}}
														%>
														
														<%
															List<EmployeeBean> listOfEmployee = allListDAO.getListOfEmployeeForProject(manager_id);
															for (EmployeeBean e : listOfEmployee) {
																int emp_manager_id = e.getManagerBean().getManager_id();

																List<ProjectMasterBean> listOfUnderProject = allListDAO.getListOfUnderProjectMaster(emp_manager_id);
																System.out.println("underProjectSize:" + listOfUnderProject.size());
																for (ProjectMasterBean p : listOfUnderProject) {
														%>
														<%
													if(request.getParameter("project_id") != null){
														project_id = Integer.parseInt(request.getParameter("project_id"));
													}
											%>
											<%if(p.getProject_master_id() == project_id) {%>
														<option value="<%=p.getProject_master_id()%>" selected="selected"><%=p.getProject_master_name()%></option>

														<%}else{ %>
														<option value="<%=p.getProject_master_id()%>" ><%=p.getProject_master_name()%></option>
														<%
															}}}
														%>
														
													</select>
												</div>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" value="SUBMIT" class="btn btn-primary">
												<!-- <td><b>To Date :</b> <input type="date"
																	class="form-control"></td> -->
											</div>
										</div>
									</div>
								</div>
							</div>
</form>

							<!-- <div class="dataTable_wrapper">
							<table class="table">
							<tr>
							<th>Project : </th>
							<td></td>
							<td colspan="2"><input type="text"></td>
							</tr>
							</table>
							</div> -->

                <div class="col-lg-12">
                    <div class="panel panel-default">
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                            <li><a href="#chart" data-toggle="tab">Effort variance chart</a>
                                </li>
                                <li><a href="#project" data-toggle="tab">Project</a>
                                </li>
                                <li><a href="#milestone" data-toggle="tab">Milestone</a>
                                </li>
                                <li class="active"><a href="#task" data-toggle="tab">task</a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="task">
                                    <h4>Task</h4>
                                    <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
									<thead>	
										<tr>
											<th>Task Name</th>
											<th>Milestone Name</th>
											<th>Planned Effort(Hrs)</th>
											<th>Approved Timesheet Effort(Hrs)</th>
											<th>% Worked</th>
											<th>Unapproved Timesheet Effort(Hrs)</th>
											<th>% Variance</th>
										</tr>
									</thead>
									<%if(request.getAttribute("listOfTask") != null) {
										
									List<TaskMasterBean> listOfTask = (ArrayList)request.getAttribute("listOfTask");
									for(TaskMasterBean t : listOfTask){
										double hours = 0;
										int duration = 0;
										double sumOfHours = 0;
										double w = 0;
										double sumOfWorkedHours = 0;
										double sumOfRejectedHours = 0;
										double variance = 0;
										double finalVariance = 0;
										double per = 0;
										
										int task_id = t.getTask_master_id();
										String d = t.getTask_estimated_duration();
										String[] split = d.split(" ");
										
										duration =Integer.parseInt(split[0]); 
										
										
										
										
										List<Object[]> listOfAllocatedTask = allListDAO.getAllocatedTaskListByProjectId(task_id);
										if(listOfAllocatedTask.size() != 0){
	                                    for(Object[] aRow : listOfAllocatedTask){
	                                    	
	                                    	ProjectAllocationBean p = (ProjectAllocationBean) aRow[0];
	                                    	int employee_id = p.getEmployeeBean().getEmployee_master_id();
	                                    	
	                                    	System.out.println("employee_id:"+employee_id);
	                                    	
	                                    	List<Object[]> PerAllocation = allListDAO.getPerOfAllocationByProjectId(employee_id,project_id);
		                                    for(Object[] aRow1 : PerAllocation){
		                                    	
		                                    	ProjectAllocationPercentageBean p1 = (ProjectAllocationPercentageBean) aRow1[0];
		                                    	
		                                    	double percentage = p1.getPer_allocation()/100;
		                                    	hours = duration * 8 * percentage;
		                                    	System.out.println("hours:"+hours);
		                                    	sumOfHours = sumOfHours + hours;
		                                    	w = Double.parseDouble(String.format("%.2f", sumOfHours));
		                                    	
		                                    
	                                    }
										
	                                    }
										
	                                    }
										
										
										
										List<TimeSheetBean> listOfApprovedTimesheet= allListDAO.getListOfAprovedTimesheet(task_id);
										for(TimeSheetBean timeSheetBean : listOfApprovedTimesheet){
											
											double workedHour = timeSheetBean.getWorked_hours();
											System.out.println("workedHours:"+workedHour);
											sumOfWorkedHours = sumOfWorkedHours + workedHour;
											
											if(sumOfWorkedHours != 0){
											variance = ((sumOfWorkedHours - w) / w) * 100;
											finalVariance = Double.parseDouble(String.format("%.2f", variance));
											}
											
										}
										
										
										List<TimeSheetBean> listOfRejectedTimesheet= allListDAO.getListOfRejectTimesheet(task_id);
										for(TimeSheetBean timeSheetBean : listOfRejectedTimesheet){
											
											double workedHour = timeSheetBean.getWorked_hours();
											System.out.println("workedHours:"+workedHour);
											sumOfRejectedHours = sumOfRejectedHours + workedHour;
											
										}
										
										Double maxValue = allListDAO.getMaxPer(task_id);										
										per = maxValue;
										%>
										<tbody>
											<tr>
												<td><%=t.getTask_master_name()%></td>
												<td><%=t.getMilestoneBean().getMilestone_name()%></td>
												<%if(listOfAllocatedTask.size() != 0){ %>
												<td><%=w%></td>
												<%}else{ %>
												<td>0</td>
												<%} %>
												<td><%=sumOfWorkedHours%></td>
												<td><%=per%></td>
												<%
												String plannedDuration = w+","+t.getTask_master_name()+","+per;
												arrayPlannedDuration.add(plannedDuration);
												
												String actualConcate = sumOfWorkedHours+","+t.getTask_master_name()+","+per;
												arrayActualDuration.add(actualConcate);
												%>
												<td><%=sumOfRejectedHours %></td>
												<%if(finalVariance < 0){ %>
												<td><font color="blue"><%=finalVariance%></font></td>
												<%}else if(finalVariance > 0){ %>
												<td><font color="red"><%=finalVariance%></font></td>
												<%}else{ %>
												<td><%=finalVariance%></td>
												<%} %>
											</tr>
										</tbody>
										<%} } %>
										</table>
                                </div>
                                </div>
                                
                                
                                <div class="tab-pane fade" id="milestone">
                                    <h4>Milesotne</h4>
                                    <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
									<thead>	
										<tr>
											<th>Milestone Name</th>
											<th>Planned Effort(Hrs)</th>
											<th>Approved Timesheet Effort(Hrs)</th>
											<th>% Worked</th>
											<th>Unapproved Timesheet Effort(Hrs)</th>
											<th>% Variance</th>
										</tr>
									</thead>
									<%if(request.getAttribute("listOfMilestone") != null) {
									List<Object[]> listOfMilestone = (ArrayList)request.getAttribute("listOfMilestone");
									for(Object[] aRow : listOfMilestone){
										MilestoneBean m = (MilestoneBean) aRow[0];
										
										double hours = 0;
										int duration = 0;
										double sumOfHours = 0;
										double w = 0;
										double sumOfWorkedHours = 0;
										double sumOfRejectedHours = 0;
										double variance = 0;
										double finalVariance = 0;
										double per = 0;
										int milestone_id = m.getMilestone_id();
										ArrayList<Double> arrayList = new ArrayList<Double>();
										
										List<TaskMasterBean> listOfTask = allListDAO.getTaskListByProjectId1(milestone_id);
										if(listOfTask.size() != 0){
		                                for(TaskMasterBean t : listOfTask){
										
		                                	
										
										
										int task_id = t.getTask_master_id();
										String d = t.getTask_estimated_duration();
										String[] split = d.split(" ");
										
										duration =Integer.parseInt(split[0]); 
										
										
										List<TimeSheetBean> listOfApprovedTimesheet= allListDAO.getListOfAprovedTimesheet(task_id);
										for(TimeSheetBean timeSheetBean : listOfApprovedTimesheet){
											
											double workedHour = timeSheetBean.getWorked_hours();
											System.out.println("workedHours:"+workedHour);
											sumOfWorkedHours = sumOfWorkedHours + workedHour;
											
											
										}
										
										
										List<TimeSheetBean> listOfRejectedTimesheet= allListDAO.getListOfRejectTimesheet(task_id);
										for(TimeSheetBean timeSheetBean : listOfRejectedTimesheet){
											
											double workedHour = timeSheetBean.getWorked_hours();
											System.out.println("workedHours:"+workedHour);
											sumOfRejectedHours = sumOfRejectedHours + workedHour;
											
										}
										
										Double maxValue = allListDAO.getMaxPer(task_id);	
										arrayList.add(maxValue);
										
										List<Object[]> listOfAllocatedTask = allListDAO.getAllocatedTaskListByProjectId(task_id);
										if(listOfAllocatedTask.size() != 0){
	                                    for(Object[] aRow1 : listOfAllocatedTask){
	                                    	
	                                    	ProjectAllocationBean p = (ProjectAllocationBean) aRow1[0];
	                                    	int employee_id = p.getEmployeeBean().getEmployee_master_id();
	                                    	
	                                    	System.out.println("employee_id:"+employee_id);
	                                    	
	                                    	List<Object[]> PerAllocation = allListDAO.getPerOfAllocationByProjectId(employee_id,project_id);
		                                    for(Object[] aRow2 : PerAllocation){
		                                    	
		                                    	ProjectAllocationPercentageBean p1 = (ProjectAllocationPercentageBean) aRow2[0];
		                                    	
		                                    	double percentage = p1.getPer_allocation()/100;
		                                    	hours = duration * 8 * percentage;
		                                    	System.out.println("hours:"+hours);
		                                    	sumOfHours = sumOfHours + hours;
		                                    	w = Double.parseDouble(String.format("%.2f", sumOfHours));
		                                    	
		                                    	if(sumOfHours != 0){
			                                    	variance = ((sumOfWorkedHours - w) / w) * 100;
													finalVariance = Double.parseDouble(String.format("%.2f", variance));
			                                    	}
		                                    	
		                                    
	                                    }
										
	                                    }
										
	                                    }
		                                }
		                                double maxPerfinal = Collections.max(arrayList);
		                                arrayList.clear();
										%>
										
								
									<tbody>
										<tr>
											<td><%=m.getMilestone_name()%></td>
											<td><%=w%></td>
											<td><%=sumOfWorkedHours%></td>
											<td><%=maxPerfinal%></td>
											<td><%=sumOfRejectedHours %></td>
											<%if(finalVariance < 0){ %>
												<td><font color="blue"><%=finalVariance%></font></td>
												<%}else if(finalVariance > 0){ %>
												<td><font color="red"><%=finalVariance%></font></td>
												<%}else{ %>
												<td><%=finalVariance%></td>
												<%} %>
											
										</tr>
									</tbody>
									<%} }}%>
									</table>
                                </div>
                                </div>
                                
                                 <div class="tab-pane fade" id="project">
                                    <h4>Project</h4>
                                   <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
									<thead>	
										<tr>
											<th>Project Name</th>
											<th>Planned Effort(Hrs)</th>
											<th>Approved Timesheet Effort(Hrs)</th>
											<th>% Worked</th>
											<th>Unapproved Timesheet Effort(Hrs)</th>
											<th>% Variance</th>
										</tr>
									</thead>
                               <%if(request.getAttribute("projectMasterBean") != null) {
									ProjectMasterBean projectMasterBean = (ProjectMasterBean)request.getAttribute("projectMasterBean");
									
									double hours = 0;
									int duration = 0;
									double sumOfHours = 0;
									double w = 0;
									double sumOfWorkedHours = 0;
									double sumOfRejectedHours = 0;
									double variance = 0;
									double finalVariance = 0;
									double per = 0;
									int projectId = projectMasterBean.getProject_master_id();
									
									List<TaskMasterBean> listOfTask = allListDAO.getTaskListByProjectId2(projectId);
									if(listOfTask.size() != 0){
	                                for(TaskMasterBean t : listOfTask){
									
	                                	
									
									
									int task_id = t.getTask_master_id();
									String d = t.getTask_estimated_duration();
									String[] split = d.split(" ");
									
									duration =Integer.parseInt(split[0]); 
									
									
									List<TimeSheetBean> listOfApprovedTimesheet= allListDAO.getListOfAprovedTimesheet(task_id);
									for(TimeSheetBean timeSheetBean : listOfApprovedTimesheet){
										
										double workedHour = timeSheetBean.getWorked_hours();
										System.out.println("workedHours:"+workedHour);
										sumOfWorkedHours = sumOfWorkedHours + workedHour;
										
									}
									
									
									List<TimeSheetBean> listOfRejectedTimesheet= allListDAO.getListOfRejectTimesheet(task_id);
									for(TimeSheetBean timeSheetBean : listOfRejectedTimesheet){
										
										double workedHour = timeSheetBean.getWorked_hours();
										System.out.println("workedHours:"+workedHour);
										sumOfRejectedHours = sumOfRejectedHours + workedHour;
										
									}
									
									Double maxValue = allListDAO.getMaxPerProject(projectId);										
									per = maxValue;
									
									List<Object[]> listOfAllocatedTask = allListDAO.getAllocatedTaskListByProjectId(task_id);
									if(listOfAllocatedTask.size() != 0){
                                    for(Object[] aRow1 : listOfAllocatedTask){
                                    	
                                    	ProjectAllocationBean p = (ProjectAllocationBean) aRow1[0];
                                    	int employee_id = p.getEmployeeBean().getEmployee_master_id();
                                    	
                                    	System.out.println("employee_id:"+employee_id);
                                    	
                                    	List<Object[]> PerAllocation = allListDAO.getPerOfAllocationByProjectId(employee_id,project_id);
	                                    for(Object[] aRow2 : PerAllocation){
	                                    	
	                                    	ProjectAllocationPercentageBean p1 = (ProjectAllocationPercentageBean) aRow2[0];
	                                    	
	                                    	double percentage = p1.getPer_allocation()/100;
	                                    	hours = duration * 8 * percentage;
	                                    	System.out.println("hours:"+hours);
	                                    	sumOfHours = sumOfHours + hours;
	                                    	w = Double.parseDouble(String.format("%.2f", sumOfHours));
	                                    	
	                                    	if(sumOfHours != 0){
	                                    	variance = ((sumOfWorkedHours - w) / w) * 100;
											finalVariance = Double.parseDouble(String.format("%.2f", variance));
	                                    	}
	                                    
                                    }
									
                                    }
									
                                    }
	                                }
										
									%>
									<tbody>
										<tr>
											<td><%=projectMasterBean.getProject_master_name()%></td>
											<td><%=w%></td>
											<td><%=sumOfWorkedHours%></td>
											<td><%=per%></td>
											<td><%=sumOfRejectedHours %></td>
											<%if(finalVariance < 0){ %>
												<td><font color="blue"><%=finalVariance%></font></td>
												<%}else if(finalVariance > 0){ %>
												<td><font color="red"><%=finalVariance%></font></td>
												<%}else{ %>
												<td><%=finalVariance%></td>
												<%} %>
										</tr>
									</tbody>
									
									</table>
									<%} }%>
                                </div>
                                </div>
                                
                                
                                
                                
                                
                                 <div class="tab-pane fade" id="chart" onclick="chart()">
                                    <div class="table-responsive">
                                    <div id="chartContainer" style="height: 400px; width: 70%;"></div>
                                </div>
                                </div>
                                
	
	
	<script type="text/javascript">
  FusionCharts.ready(function(){
    var revenueChart = new FusionCharts({
        "type": "mscolumn3d",
        "renderAt": "chartContainer",
        "width": "650",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
        	    "chart": {
        	        "caption": "Effort Variance",
        	        "xaxisname": "Task",
        	        "yaxisname": "Efforts(Hrs)",
        	        /* "palette": "2",
        	        "yaxismaxvalue": "1000",
        	        "numdivlines": "3", */
        	        "theme": "zune"
        	    },
        	    "categories": [
        	        {
        	            "category": [
        	                     	<%for(String b : arrayActualDuration){
        	       					 String[] bc = b.split(",");
        	       					 double actualuration =  Double.parseDouble(bc[0]);
        	       						             String task_name = bc[1];
        	       						             String per = bc[2];
        	       						             String demo ="t1";%>

        	                {
        	                    "label": "<%=task_name%>"
        	                },
        	                <%}%>
        	            ]
        	        }
        	                     	
        	    ],
        	    "dataset": [
        	        {
        	            "seriesname": "Planned Efforts",
        	            "data": [
<%for(String a : arrayPlannedDuration){
	 String[] ac = a.split(",");
	 double actualuration =  Double.parseDouble(ac[0]);
		             String task_name = ac[1];
		             String per = ac[2];
		             %>
        	                {
        	                    "value": <%=actualuration%>
        	                },
        	               <%}%>
        	            ]
        	        },
        	        {
        	            "seriesname": "Actual Efforts",
        	            "data": [
<%for(String b : arrayActualDuration){
	 String[] bc = b.split(",");
	 double actualuration =  Double.parseDouble(bc[0]);
		             String task_name = bc[1];
		             String per = bc[2];
		             String demo ="t1";%>
        	                {
        	                    "value": <%=actualuration%>
        	                },
        	                <%}%>
        	            ]
        	        }
        	    ]
        	}

  });
revenueChart.render();
})
</script>
             
                                
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
	
</div>
	<!-- /.row -->
	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>
