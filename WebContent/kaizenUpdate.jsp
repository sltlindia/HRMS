<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenMemberBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kaizen Update</title>

<script>									
	function checkInteger(id) {
		
			var a = document.getElementById(id).value;
		
		if(isNaN(a)){
			alert("Cost should be only in digits.Please enter digits only!!!");
			document.getElementById(id).value = "";
		}
		
	}
	
	</script>

</head>
<%@include file="header.jsp"%>
<body>
<%int kaizen_id = 16;

if(request.getParameter("kaizen_id") != null){
	kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
}else if(request.getAttribute("kaizen_id") != null){
	kaizen_id = (Integer) request.getAttribute("kaizen_id");
}
AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
List<KaizenManagerBean> listOfManager = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id); 

session.setAttribute("updateSession", "rejection");
%>
<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update CI</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">UPDATE CI</div>
						<div class="panel-body">

		<%-- <%if(kaizenBean.getCompletion_status().equalsIgnoreCase("saved")){%> --%>

							<form action="kaizenUpdate" method="post" name=""
								enctype="multipart/form-data">
								
								
								<%if(request.getParameter("reject") != null){%>
											<input type="hidden" name="reject" value="rejectionUpdate">
									 		<%} %>
								
								
								<input type="hidden" name="kaizen_id" value="<%=kaizenBean.getKaizen_id()%>">
								<input type="hidden" name="date" value="<%=kaizenBean.getDate()%>">
								<input type="hidden" name="status" value="<%=kaizenBean.getStatus()%>">
								<input type="hidden" name="before_desc" value="<%=kaizenBean.getBefore_description()%>">
								<input type="hidden" name="after_desc" value="<%=kaizenBean.getAfter_description()%>">
								<input type="hidden" name="reason" value="<%=kaizenBean.getRejection_reason()%>">
								<input type="hidden" name="completion_status" value="<%=kaizenBean.getCompletion_status()%>">
								<input type="hidden" name="emp_id" value="<%=kaizenBean.getEmployeeBean().getEmployee_master_id()%>">
								<input type="hidden" name="manager_id" value="<%=kaizenBean.getManager_id()%>">
								<input type="hidden" name="problem_id" value="<%=kaizenBean.getKaizenProblemIdentificationBean().getKaizen_problem_identification_id()%>">

								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped">
										
										<tr>
											
											
											<td colspan="4"><label>Problem Identification </label>
											<textarea rows="" cols="" class="form-control" name="existing_problem"><%=kaizenBean.getKaizenProblemIdentificationBean().getProblem_description()%></textarea>
												</td>
												
												<td>
												<label>Category</label>
												<select class="form-control"
													name="category" onchange="departmentHideShow(this.value);">
													<option value="">---Select Category---</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("A")){%><option value="A" selected="selected"><%}else{%><option value="A"><%}%>A : Can be improved by self</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("B")){%><option value="B" selected="selected"><%}else{%><option value="B"><%}%>B : Can be improved by help of other Department</option>
													<%if(kaizenBean.getKaizenProblemIdentificationBean().getCategory().equalsIgnoreCase("C")){%><option value="C" selected="selected"><%}else{%><option value="C"><%}%>C : Can be improved by help of Management</option>
												</select>
												</td>
											
											
											
											
										</tr>	
										
										
											<tr>
												<td><label>CI Name</label>
												<input class="form-control" type="text" name ="kaizen_name" placeholder="Kaizen name" value="<%=kaizenBean.getKaizen_name()%>" required>
												</td>

												<td colspan="6" maxlength="825"><label>Improvement Plan</label>
												<textarea name="description" maxlength="700" class="form-control" placeholder="Max 800 words"><%=kaizenBean.getKaizen_desc()%></textarea>
												</td>
												
											</tr>
										


											<tr>
											<td colspan="3">
											<label>Projected Saving : </label> 
												<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" checked="checked" > Delivery 
												<%}else{ %>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" > Delivery 
												<%} %>
												
												
												<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" checked="checked" > Cost 
												<%}else{ %>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" > Cost 
												<%} %>
												
												
												
												<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" checked="checked" > Quality
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" > Quality
												<%} %>
												
												<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" checked="checked" > Safety
												<%}else{ %>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" > Safety
												<%} %>
												
												<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" checked="checked" > Productivity
												<%}else{ %>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" > Productivity
												<%} %>
												</td>
												
												
												<td colspan="3"><label>Impletation Cost <i class="fa fa-question-circle"
													style="cursor: pointer;" data-toggle="tooltip"
													data-placement="top" title="title"></i></label>
												<input type="text"
													name="implementation_cost" id="implementationCount" class="form-control" value="<%=kaizenBean.getImplementation_cost()%>" onchange="checkInteger(this.id);" ></td>
											</tr>

<tr>
												<td id="timeField">
												<label>Time Saving (Delivery)</label>
													<textarea maxlength="75" name="time_saving" id="time_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getDelivery()%></textarea>
												</td>
												
												
												<td id="moneyField">
													<label>Money Saving (Cost)</label>
													<textarea maxlength="75" name="money_saving" id="money_saving" class="form-control" onchange="checkInteger(this.id);"><%=kaizenBean.getCost()%></textarea>
												</td> 
												
												
												<td id="effortField">
													<label>Effort Saving (Quality)</label>
													<textarea maxlength="75" name="effort_saving" id="effort_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getQuality()%></textarea>
												</td>
												
												<td id="safetyField">
													<label>Safety</label>
													<textarea maxlength="75" name="safety_saving" id="safety_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getSafety()%></textarea>
												</td>
												
												
												<td id="productivityField">
													<label>Productivity</label>
													<textarea maxlength="75" name="productivity_saving" id="productivity_saving" placeholder="Max 75 words" class="form-control"><%=kaizenBean.getProductivity()%></textarea>
												</td>
											</tr>
											

										</table>
														<input type="hidden" name="update">

									</div>
									<center>
										<input type="hidden" name="redirection">
										<input type="submit" value="UPDATE" class="btn btn-primary">
									</center>
									<br>

								</div>
							</form>
<%-- <%}else if(kaizenBean.getCompletion_status().equalsIgnoreCase("submitted")) {%>

							<form action="kaizenUpdate" method="post" name=""
								enctype="multipart/form-data">
								
								
								<input type="hidden" name="kaizen_id" value="<%=kaizenBean.getKaizen_id()%>">
								<input type="hidden" name="date" value="<%=kaizenBean.getDate()%>">
								<input type="hidden" name="status" value="<%=kaizenBean.getStatus()%>">
								<input type="hidden" name="before_desc" value="<%=kaizenBean.getBefore_description()%>">
								<input type="hidden" name="after_desc" value="<%=kaizenBean.getAfter_description()%>">
								<input type="hidden" name="reason" value="<%=kaizenBean.getRejection_reason()%>">
								<input type="hidden" name="completion_status" value="<%=kaizenBean.getCompletion_status()%>">

								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped">
										
										
										
										<tr>
											
											
											<td colspan="4"><label>Problem Identification </label>
												<input type="hidden" name="existing_problem" value="<%=kaizenBean.getExisting_problem()%>">
												<p style="white-space: pre-wrap;"><%=kaizenBean.getExisting_problem()%></p>
												</td>
												
												<td>
												<label>Category</label>
													<input type="hidden" class="form-control"  name="category" id="category" value="<%=kaizenBean.getCategory_id()%>" onchange="departmentHideShow(this.value);" readonly="readonly">
												<p><%=kaizenBean.getCategory_id()%></p>
												</td>
											
											
											
										</tr>	
										
										
										<tr>
												<td><label>CI Name</label>
												<input class="form-control" type="text" name ="kaizen_name" placeholder="Kaizen name" value="<%=kaizenBean.getKaizen_name()%>" readonly="readonly" required>
												</td>

												<td colspan="6" maxlength="825"><label>Improvement Plan</label>
												<textarea name="description" maxlength="700" class="form-control" placeholder="Max 800 words" readonly="readonly"><%=kaizenBean.getKaizen_desc()%></textarea>
												</td>
												
											</tr>
										
										
									
											<tr>
												
											</tr>


											<tr>
											<td colspan="3">
											<label>Projected Saving : </label> 
												<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" checked="checked" > Delivery 
												<%}else{ %>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" > Delivery 
												<%} %>
												
												
												<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" checked="checked" > Cost 
												<%}else{ %>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" > Cost 
												<%} %>
												
												
												
												<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" checked="checked" > Quality
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" > Quality
												<%} %>
												
												<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" checked="checked" > Safety
												<%}else{ %>
												<input
													type="checkbox" name="" id="Safety" value="Safety"
													onclick="projectedSaving();" > Safety
												<%} %>
												
												<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" checked="checked" > Productivity
												<%}else{ %>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" > Productivity
												<%} %>
												</td>
												
												
												<td colspan="3"><label>Impletation Cost <i class="fa fa-question-circle"
													style="cursor: pointer;" data-toggle="tooltip"
													data-placement="top" title="title"></i></label>
												<input type="text"
													name="implementation_cost" class="form-control" value="<%=kaizenBean.getImplementation_cost()%>" readonly="readonly"></td>
											</tr>

<tr>
												<td id="timeField">
												<label>Time Saving (Delivery)</label>
													<textarea name="time_saving" id="time_saving" class="form-control"><%=kaizenBean.getDelivery()%></textarea>
												</td>
												
												
												<td id="moneyField">
													<label>Money Saving (Cost)</label>
													<textarea name="money_saving" id="money_saving" class="form-control" onchange="checkInteger(this.id);"><%=kaizenBean.getCost()%></textarea>
												</td>
												
												
												<td id="effortField">
													<label>Effort Saving (Quality)</label>
													<textarea name="effort_saving" id="effort_saving" class="form-control"><%=kaizenBean.getQuality()%></textarea>
												</td>
												
												<td id="safetyField">
													<label>Safety</label>
													<textarea name="safety_saving" id="safety_saving" class="form-control"><%=kaizenBean.getSafety()%></textarea>
												</td>
												
												
												<td id="productivityField">
													<label>Productivity</label>
													<textarea name="productivity_saving" id="productivity_saving" class="form-control"><%=kaizenBean.getProductivity()%></textarea>
												</td>
											</tr>
											

										</table>
														<input type="hidden" name="update">

									</div>
									<center>
										<input type="hidden" name="redirection">
										<input type="submit" value="UPDATE" class="btn btn-primary">
									</center>
									<br>

								</div>
							</form>


<%} %> --%>
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
			</div>
		</div>
	</div>
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
	
	<script>
	  $("[data-toggle=popover]")
	    .popover({html:true})
	    
	    $('.popover-dismiss').popover({
	  	trigger: 'focus'
		})
	</script>
	
	
	<script>
		window.onload = function() {
			<%if(kaizenBean.getDelivery().equalsIgnoreCase("")){%>
			$('#timeField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getCost() .equalsIgnoreCase("")){%>
			$('#moneyField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getQuality().equalsIgnoreCase("")){%>
			$('#effortField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getSafety().equalsIgnoreCase("")){%>
			$('#safetyField').fadeOut('fast');
			<%}%>
			<%if(kaizenBean.getProductivity().equalsIgnoreCase("")){%>
			$('#productivityField').fadeOut('fast');
			<%}%>
		}
	</script>
	
	<script>
		function projectedSaving() {
			if ($('#Time').is(":checked")) {
				$('#timeField').fadeIn('slow');

			} else {
				$('#time_saving').val('');
				$('#timeField').fadeOut('slow');

			}
			if ($('#Money').is(":checked")) {
				$('#moneyField').fadeIn('slow');
			} else {
				$('#money_saving').val('');
				$('#moneyField').fadeOut('slow');

			}
			if ($('#Effort').is(":checked")) {
				$('#effortField').fadeIn('slow');

			} else {
				$('#effort_saving').val('');
				$('#effortField').fadeOut('slow');
			}
			
			if ($('#Safety').is(":checked")) {
				$('#safetyField').fadeIn('slow');

			} else {
				$('#safety_saving').val('');
				$('#safetyField').fadeOut('slow');
			}
			
			if ($('#Productivity').is(":checked")) {
				$('#productivityField').fadeIn('slow');

			} else {
				$('#productivity_saving').val('');
				$('#productivityField').fadeOut('slow');
			}
		}

	</script>


</body>
</html>