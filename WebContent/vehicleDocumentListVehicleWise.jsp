
<%@page import="com.hrms.vehicletracking.bean.VehicleBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleDocumentAttachmentBean"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleDocumentBean"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.vehicletracking.bean.VehiclePolicyDocumentBean"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="header.jsp"%>
<body>
<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Vehicle Document History</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
<%SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy"); %>
					<div class="row">
										<div class="col-lg-12">
											<div class="panel panel-danger">
												<div class="panel-heading">
													<h5>
														<b>Vehicle Document History(Vehicle Wise)</b>
													</h5>
												</div>
												${delete }
												<!-- /.panel-heading -->

												<div class="panel-body">

													<div class="dataTable_wrapper">
														<table
															class="table table-striped table-bordered table-hover" id="datatable-buttons">
															<thead>
																<tr>
																	<th>No.</th>
																	<th>Vehicle Name</th>
																	<th>Registered No.</th>
																	<th>Document Name</th>
																	<th>Attachments</th>
																	<td>Action</td>
																
																</tr>
															</thead>
															<tbody>
																<%
																	int k=1;
																	AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
																	List<VehicleDocumentAttachmentBean> listOfVehicleDocumentAttachments = allListVtsDAO3.getListOfVehicleDocumentAttachments(Integer.parseInt(request.getParameter("vehicle_document_id")));
																	for (VehicleDocumentAttachmentBean t : listOfVehicleDocumentAttachments) {
																		int vehicle_document_id = t.getVehicleDocumentBean().getVehicle_document_id();
																		
																%>
																<tr>
																	<td><%=k++ %></td>
																	<td><%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_name()%></td>
																	<td><%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_no()%></td>
																	<td><%=t.getVehicleDocumentBean().getDocument_name() %></td>
																	<td>
																		<%
																		String ext2 = FilenameUtils.getExtension(t.getVehicle_attachment_name());
							
								if(t.getVehicle_attachment_name() != null){
								%>
								 <a target="_blank" href="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_name()%>_<%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_no()%>\document\<%=t.getVehicle_attachment_name()%>">
      <img src="FileServlet?path=D:\hrms\upload\vehicle_tracking\<%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_name()%>_<%=t.getVehicleDocumentBean().getVehicleBean().getVehicle_no()%>\document\<%=t.getVehicle_attachment_name()%>" alt="<%=t.getVehicle_attachment_name()%>" width="60" height="60">
    </a>
								<%} 
								else { %>
								<a>-</a>
								<%} %>
								</td>
								<td><a
														href="vehicleDocumentAttachmentDelete?vehicle_document_attachment_id=<%=t.getVehicle_document_attachment_id()%>"><i
															class="glyphicon glyphicon-trash" data-toggle="tooltip"
															data-placement="top" title="View Data"
															onclick="return confSubmit()"></i></a></td>								
																	</tr>
																	<%} %>
															</tbody>
														</table>

													</div>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->
											</div>
										</div>
									</div>
</div></div>



	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
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