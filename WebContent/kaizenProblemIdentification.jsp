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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CI Problem Identification</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<%@include file="header.jsp"%>
<body>
	<%

	int manager_id = user.getManagerBean().getManager_id();
	AllListDAO allListDAO = new AllListDAO();
	
	List<YearBean> listOfYear = allListDAO.getListOfYear();
	List<MonthBean> listOfMonth = allListDAO.getListOfMonth();
	  AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

 %>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Problem List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>



			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-6">Problem List</div>

								<div class="col-md-6" align="right">
									<button data-toggle="modal" data-target="#addProblem"
										class="btn btn-default">Add Problem</button>
								</div>
							</div>

						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover">

									<thead>
										<tr>
											<th>Problem</th>
											<th>Category</th>
											<th>Added By</th>
											<th>Date</th>
											<th colspan="2">Action</th>
										</tr>
									</thead>

									<tbody>
										<%List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptId(user.getDepartmentBean().getDepartment_id());
                                      for(KaizenProblemIdentificationBean kaizenProblemIdentificationBean : listOfIdentification){
                                    	  KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenByProblemId(kaizenProblemIdentificationBean.getKaizen_problem_identification_id());
                                      %>
										<tr>
											<td style="width: 400px"><%=kaizenProblemIdentificationBean.getProblem_description()%></td>
											<td><%=kaizenProblemIdentificationBean.getCategory()%></td>
											<td><%=kaizenProblemIdentificationBean.getEmployeeBean().getFirstname()+" "+kaizenProblemIdentificationBean.getEmployeeBean().getLastname()%></td>
											<td><%=dateFormat.format(dateFormat1.parse(kaizenProblemIdentificationBean.getDate()))%></td>
											<td>
											<%if(kaizenProblemIdentificationBean.getEmployeeBean().getEmployee_master_id() == user.getEmployee_master_id()){%>
											<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#edit<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>">
													Edit <i class="fa fa-edit"></i>
												</button>
												
												<%if(kaizenBean == null) {%>
													<a href="problemIdentificationDelete?problem_id=<%=kaizenProblemIdentificationBean.getKaizen_problem_identification_id()%>" style="text-decoration: none;color: black;"><button type="button" class="btn btn-default btn-xs">
													Delete <i class="fa fa-trash"></i></a>
												</button>
												<%} %>
												<%} %>
												</td>

											<td>
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
											<div class="panel-body">
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


	<script src="js/datatables/jquery.dataTables.min.js"></script>
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

	<script src="js/pace/pace.min.js"></script>
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