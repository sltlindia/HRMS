<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenInsertDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> HRMS </title>


<style>
div.gallery1 {
    border: 1px solid #ccc;
}

div.gallery1:hover {
    border: 1px solid #777;
}

div.gallery1 img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}

* {
    box-sizing: border-box;
}

.responsive1 {
    padding: 0 6px;
    float: left;
    width: 24.99999%;
}

@media only screen and (max-width: 700px){
    .responsive1 {
        width: 49.99999%;
        margin: 6px 0;
    }
}

@media only screen and (max-width: 500px){
    .responsive1 {
        width: 100%;
    }
}

.clearfix:after {
    content: "";
    display: table;
    clear: both;
}
</style>
<%@include file="header.jsp" %>
</head>
<body>

<div id="wrapper">
		<div id="page-wrapper">
		<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"> KAIZEN MANAGEMENT</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
<div class="panel panel-primary">
						<div class="panel-heading"> PHOTO UPLOAD - BEFORE KAIZEN </div>
						<div class="panel-body">
<%AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment();
for(KaizenBeforeUploadAttachmentBean li : listOfBefore){%>
<div class="responsive1">
  <div class="gallery1">
    <a target="_blank" href="fileUpload?path=D:\hrms\upload\kaizen\KaizenBefore\<%=li.getKaizen_before_uploaded_attachment_name()%>">
      <img src="fileUpload?path=D:\hrms\upload\kaizen\KaizenBefore\<%=li.getKaizen_before_uploaded_attachment_name()%>" alt="Trolltunga Norway" width="300" height="200">
    </a>
   <!--  <div class="desc">Add a description of the image here</div> -->
  </div>
</div>
<%} %>
<!-- 
<div class="responsive">
  <div class="gallery">
    <a target="_blank" href="img_forest.jpg">
      <img src="img_forest.jpg" alt="Forest" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>
</div>

<div class="responsive">
  <div class="gallery">
    <a target="_blank" href="img_lights.jpg">
      <img src="img_lights.jpg" alt="Northern Lights" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>
</div>

<div class="responsive">
  <div class="gallery">
    <a target="_blank" href="img_mountains.jpg">
      <img src="img_mountains.jpg" alt="Mountains" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>
</div> -->

<div class="clearfix"></div>
</div>
</div></div>
</div></div>
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
    
    <!-- <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script> -->
     <script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
   
</body>
</html>