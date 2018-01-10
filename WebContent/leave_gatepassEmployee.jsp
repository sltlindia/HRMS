<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<title>OD Details</title>
<%@include file="header.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="css/TimerPicker/jquery.min.js"></script>
<script type="text/javascript" src="css/TimerPicker/jquery-ui.min.js"></script>
<link href="css/TimerPicker/jquery-ui.css" rel="stylesheet">

<link href="css/timepicki.css" rel="stylesheet">

<style type="text/css">
.timepicker_wrap {
	padding: 10px;
	border-radius: 5px;
	z-index: 998;
	display: none;
	box-shadow: 2px 2px 5px 0 rgba(50, 50, 50, 0.35);
	background: #f6f6f6;
	border: 1px solid #ccc;
	float: left;
	position: absolute;
	top: 27px;
	left: 0;
	width: 280px;
	format: 'HH:mm';
	showMeridian: false;
}
</style>


<script type="text/javascript">
	$(function() {
		$("#datepicker1").datepicker({
			maxDate : 0,
			dateFormat : "dd/mm/yy"
		});
	});
</script>

<script type="text/javascript">
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var colCount = table.rows[0].cells.length;

		for (var i = 0; i < colCount; i++) {

			var newcell = row.insertCell(i);

			newcell.innerHTML = table.rows[0].cells[i].innerHTML;
			//alert(newcell.childNodes);
			switch (newcell.childNodes[0].type) {
			case "text":
				newcell.childNodes[0].value = "";
				break;
			case "checkbox":
				newcell.childNodes[0].checked = false;
				break;
			case "select-one":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			}
		}
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					if (rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}

			}
		} catch (e) {
			alert(e);
		}
	}
</script>
</head>
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">

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
				               				<h4 class="card-title" id="horz-layout-basic">GATE PASS</h4>
				                		</div>
				            		</div>
 								<!-- /.row -->
								<div class="card-body collapse in">
	  							 <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
								   <div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h4 align="left">
													Date :
													<%
													DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
													Date today = Calendar.getInstance().getTime();

													String date1 = dateFormat.format(today);

													String d = null;
													String currentdate = null;

													try {

														SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
														Date result = formater.parse(date1);

														SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
														currentdate = AppDateFormat1.format(result);

														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														d = AppDateFormat.format(result);
														System.out.println(AppDateFormat.format(result));
													} catch (ParseException e1) {
														e1.printStackTrace();
													}
												%><%=d%></h4>

											</div>

											<div class="panel-body">
												<form action="gatePassInsert" method="post">
													<div class="row">
														<div class="col-lg-12">
															<br> <b>To : The Security Gate,<br>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please
																Allow The following Persons....... To go Out for
																Official / Personal Work.
															</b>
														</div>
													</div>
													<br> <br>
													<table class="table table-stripped">
														<tbody>
															<tr bgcolor="#DCDCDC">
																<!-- <th style="width: 20px;"></th> -->
																<th style="width: 260px;"><center>Name</center></th>
																<th style="width: 100px;"><center>
																		Personal</center></th>
																<th style="width: 100px;"><center>
																		Official</center></th>
																<th style="width: 180px;"><center>At</center></th>
																<th style="width: 260px;"><center>Remark</center></th>
															</tr>
														</tbody>

													</table>
													<table class="table table-stripped" id="dataTable">

														<tbody>
															<tr>
																<!-- <TD style="width: 20px;"><INPUT type="checkbox" name="chk"/></TD> -->
																<td style="width: 260px;"><input type="text"
																	class="form-control" id="employeeName"
																	name="employeeName"
																	value="<%=user.getFirstname() + " " + user.getMiddlename() + " " + user.getLastname()%>"
																	readonly="readonly"></td>
																<td style="width: 100px;"><center>
																		<input type="radio" name="purpose_of_leave"
																			value="Personal" required>
																	</center></td>
																<td style="width: 100px;"><center>
																		<input type="radio" name="purpose_of_leave"
																			value="Official" required>
																	</center></td>
																<td style="width: 180px;"><input id="outTime"
																	type="text" class="form-control" name="outTime"
																	placeholder="HH:mm" required></td>
																<td style="width: 260px;"><textarea
																		class="form-control" style="height: 34px"
																		name="reason" placeholder="Enter Remark" required></textarea></td>
															</tr>
														</tbody>
													</table>


													<table class="table table-stripped" bgcolor="#DCDCDC">
														<tbody>

															<tr bgcolor="#DCDCDC">
																<th><center>From</center></th>
																<th><center>To</center></th>
																<th><center>Round Trip</center></th>
															</tr>
															<tr>
																<td>
																	<center>
																		<select class="form-control" name="CompanyName"
																			placeholder="Select Company Name" id="CompanyName"
																			required="required" style="width: 200px;"
																			onchange="diff(this.value);">
																			<option value="">---Select Location---</option>
																			<option value="A-8">A-8</option>
																			<option value="A-15">A-15</option>
																			<option value="E-2">E-2</option>
																			<option value="E-30">E-30</option>
																			<option value="SEZ">SEZ</option>
																		</select>
																	</center>
																</td>
																<td><input type="text" class="form-control"
																	name="Todec" width="200px"
																	placeholder="Enter Destination" required></td>
																<td>
																	<center>
																		<select class="form-control" name="Returnable"
																			placeholder="" id="" required="required"
																			style="width: 200px;">
																			<option value="">---Select---</option>
																			<option value="YES">Yes</option>
																			<option value="NO">No</option>
																		</select>
																	</center>
																</td>
															</tr>

														</tbody>


													</table>

													<%
														int manager_id = Integer.parseInt(user.getUnder_manager_id());
														LoginDAO loginDAO = new LoginDAO();
														EmployeeBean employeeBean = loginDAO.getUserByManagerId(manager_id);
													%>
													<table class="table table-stripped">
														<tbody>

															<tr bgcolor="#DCDCDC">
																<th><center>Authorised By</center></th>
																<th><center>Date</center></th>
															</tr>
															<tr>
																<%-- <td><center><%=employeeBean.getFirstname()+ " "+employeeBean.getLastname() %></center></td> --%>
																<td style="width: 460px;"><center>
																		<input type="radio" name="manager"
																			value="<%=employeeBean.getManagerBean().getManager_id()%>"
																			checked="checked" />
																		<%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%>
																		<%
																			int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
																			EmployeeBean employeeBean1 = loginDAO.getUserByManagerId(under_manager_id);
																		%>
																		&nbsp;&nbsp;&nbsp;<input type="radio" name="manager"
																			value="<%=employeeBean1.getManagerBean().getManager_id()%>" />
																		<%=employeeBean1.getFirstname() + " " + employeeBean1.getLastname()%>
																	</center></td>
																<td><center><%=currentdate%></center></td>
															</tr>

														</tbody>
														<tbody>
															<tr>
																<td colspan="6" align="Center"><input type="submit"
																	class="btn btn-success" id="btnsubmit" value="Submit">
																	<!-- <input type="button" value="Add Row" onclick="addRow('dataTable')" />
									 	<INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" /> -->
																</td>
															</tr>
														</tbody>

													</table>

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
				</div>
				</div>
				</section>
			</div>
		</div>
	</div>
<%@include file="footer.html"%>
	<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->
	 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>	
    
   <script src="js/timepicki1.js"></script>
 
    <script>
	$('#outTime').timepicki();
    </script> 	
    
    
    <script type="text/javascript">
	$(function() {
		$('#outTime').timepicki({
			  showMeridian : false
				});
		});
	</script>
</body>
</html>