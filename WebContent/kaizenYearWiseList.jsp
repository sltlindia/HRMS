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
<title>CI List</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="header.jsp" %>
<body>
<%

	int manager_id = user.getManagerBean().getManager_id();
	AllListDAO allListDAO = new AllListDAO();
	
	List<YearBean> listOfYear = allListDAO.getListOfYear();
	List<MonthBean> listOfMonth = allListDAO.getListOfMonth();
	  AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

 %>
<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">CI List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	CI List
                        	</div>
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover">
                                      <thead>
                                      <%for(YearBean yearBean : listOfYear){
                                      int year = Integer.parseInt(yearBean.getYear());
                                      int year1 =  year + 1;
                                      String yearDuration = year+"-"+year1;
                                      %>
                                        <tr class="odd gradeX">
                                        <th><a id="year<%=yearBean.getYear_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="fa fa-plus-circle"></i> <%=year%> - <%=year1%></a></th>
                                        <th><button name="button" onclick="window.open('kaizenBillBoard.jsp?year=<%=yearDuration%>','_blank')" class="btn btn-default btn-xs"><i class="fa fa-file-text"></i> BillBoard</button>
                                        <button name="button" onclick="window.open('kaizenLeaderBoard.jsp?year=<%=yearDuration%>','_blank')" class="btn btn-default btn-xs"><i class="fa fa-file-text"></i> LeaderBoard</button></th>
                                        </tr>
                                        
                                        				<script>
	
																$(document).ready(function(){
																		 $(".year"+<%=yearBean.getYear_id()%>).hide();
																});
	
															</script>
                                        
                                        	<tr class="year<%=yearBean.getYear_id()%>">
                                        		<td colspan="2">
                                        			  <table class="table table-striped table-bordered table-hover">
                                    					  <thead>
                                    					  		<tr>
                                    					  			<th rowspan="2">Month</th>
                                    					  			<th colspan="4">Total CI</th>
                                    					  			<th rowspan="2">Action</th>
                                    					  		</tr>
                                    					  </thead>
                                    					  
                                    					  <tbody>
                                    					  	<tr>
                                    					  		<th></th>
                                    					  		<th>Approved On-Progress</th>
                                    					  		<th>Approved Completed</th>
                                    					  		<th>Pending</th>
                                    					  		<th>Rejected</th>
                                    					  		<th></th>
                                    					  	</tr>	
                                    					  </tbody>
                                    					  
                                    					  <tbody>
                                    					  
                                    					  <%for(int i = 3;i<12;i++){
																MonthBean monthBean = listOfMonth.get(i);
																
																List<KaizenBean> lisOfApprovedOnProgressCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,monthBean.getMonth_id(),"approved","submitted");
																List<KaizenBean> lisOfApprovedCompletedCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,monthBean.getMonth_id(),"approved","completed");
																List<KaizenBean> lisOfPendingForApprovalCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,monthBean.getMonth_id(),"pending","completed");
																List<KaizenBean> lisOfMainRejectedKaizen = allKaizenListDAO.getListOfAllKaizenBymanagerIdWithRejected(manager_id,year,monthBean.getMonth_id());%>
																
                                    					  
                                    					  		<tr>
                                    					  			<th><%=monthBean.getMonth_name()%>,<%=year%></th>
                                    					  			<th><%=lisOfApprovedOnProgressCI.size()%></th>
                                    					  			<th><%=lisOfApprovedCompletedCI.size()%></th>
                                    					  			<th><%=lisOfPendingForApprovalCI.size()%></th>
                                    					  			<th><%=lisOfMainRejectedKaizen.size()%></th>
                                    					  			<th>
                                    					  			     <a href="kaizenManagerList.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>"><button class="btn btn-default btn-xs"><i class="glyphicon glyphicon-eye-open"></i> Show All CI</button></a>
                                    					  			      <button class="btn btn-default btn-xs" onclick="window.open('kaizenManagerScore.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>','_blank')"> Give Score</button>
                                    					  			</th>
                                    					  		</tr>
                                    					  <%} %>
                                    					  
                                    					  
                                    					  <%for(int i = 0;i<3;i++){
																MonthBean monthBean = listOfMonth.get(i);
																List<KaizenBean> lisOfApprovedOnProgressCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year1,monthBean.getMonth_id(),"approved","submitted");
																List<KaizenBean> lisOfApprovedCompletedCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year1,monthBean.getMonth_id(),"approved","completed");
																List<KaizenBean> lisOfPendingForApprovalCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year1,monthBean.getMonth_id(),"pending","completed");
																List<KaizenBean> lisOfMainRejectedKaizen = allKaizenListDAO.getListOfAllKaizenBymanagerIdWithRejected(manager_id,year1,monthBean.getMonth_id());
                                    						  %>
																
																
                                    					  
                                    					  		<tr>
                                    					  			<th><%=monthBean.getMonth_name()%>,<%=year1%></th>
                                    					  			<th><%=lisOfApprovedOnProgressCI.size()%></th>
                                    					  			<th><%=lisOfApprovedCompletedCI.size()%></th>
                                    					  			<th><%=lisOfPendingForApprovalCI.size()%></th>
                                    					  			<th><%=lisOfMainRejectedKaizen.size()%></th>
                                    					  			<th>
                                    					  			     <a href="kaizenManagerList.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>"><button class="btn btn-default btn-xs"><i class="glyphicon glyphicon-eye-open"></i> Show All CI</button></a>
                                    					  			      <button class="btn btn-default btn-xs" onclick="window.open('kaizenManagerScore.jsp?year=<%=year%>&month=<%=monthBean.getMonth_id()%>&month_name=<%=monthBean.getMonth_name()%>','_blank')"> Give Score</button>
                                    					  			</th>
                                    					  		</tr>
                                    					  <%} %>
                                    					  
                                    					  
                                    					  </tbody>
                                    					  </table>
                                        		</td>
                                        	</tr>
                                        
                                        <%} %>
                                    </thead>
                                </table>
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
    <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

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