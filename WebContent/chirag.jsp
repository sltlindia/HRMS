<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.bean.RoleCategoryBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page
	import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Announcement Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Exit Interview From</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Striped Row Forms - Robust Bootstrap Admin Template</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
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
	href="app-assets/css/plugins/animate/animate.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
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

textarea {
	/* box-sizing: padding-box; */
	overflow: hidden;
	/* demo only: */
	padding: 10px;
	width: 100%;
	font-size: 14px;
}
</style>
<script type="text/javascript">
	function checkFile(fieldObj) {
		var FileName = fieldObj.value;
		var FileExt = FileName.substr(FileName.lastIndexOf('.') + 1);
		var FileSize = fieldObj.files[0].size;
		var FileSizeMB = (FileSize / 1048576).toFixed(2);

		if ((FileExt != "pdf" && FileExt != "doc" && FileExt != "docx"
				&& FileExt != "jpg" && FileExt != "png" && FileExt != "jpeg"
				&& FileExt != "txt" && FileExt != "ppt" && FileExt != "xml"
				&& FileExt != "xlsx" && FileExt != "xls" && FileExt != "png" && FileExt != "pptx")) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file is in pdf , doc ,docx , xml , jpg , jpeg , xls , txt , png or ppt.";
			alert(error);
			fieldObj.value = "";
		} else if (FileSize > 1048576) {
			var error = "File type : " + FileExt + "\n\n";
			error += "Size: " + FileSizeMB + " MB \n\n";
			error += "Please make sure your file size less than 1 MB.\n\n";
			alert(error);
			fieldObj.value = "";
			return false;
		}
		return true;
	}
	function ValidateDateMitigation(value) {

		var a = value;
		var b = document.getElementById("currentDate").value;

		if (a < b) {
			alert("Please give future date as a announcement end date");
			document.getElementById("announcement_enddate").value = 0000 - 00 - 00;
		}

	}
	function endDateValidation(value) {

		// alert("enddatevalidate function ni andar ayu");
		var a = value;
		var b = document.getElementById("announcement_date").value;

		if (a < b) {
			// alert("Endvalidate if ni andar");
			alert("Announcement end date must be bigger than announcement date.");
			document.getElementById("announcement_enddate").value = 0000 - 00 - 00;
		}

	}
	function ValidateDate(value) {
		// alert("validate function ni andar ayu");
		var a = value;
		var b = document.getElementById("currentDate").value;

		if (a < b) {
			alert("Please give future date as a announcement date");
			document.getElementById("announcement_date").value = 0000 - 00 - 00;
		}

	}
	function removeAttachment() {
		document.getElementById('attachment_id').value = '';
	}
	function hideMessage() {
		//document.getElementById("panelbody").style.display="none"; 
		$('#panelbody').fadeOut('slow');
	}
	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
	function checkType(value) {
		if (value == "yes") {
			document.getElementById("fromTime").disabled = false;
			document.getElementById("toTime").disabled = false;
		}
		if (value == "no") {
			document.getElementById("fromTime").disabled = true;
			document.getElementById("toTime").disabled = true;
		}
	}
</script>
<script>
	$(document).ready(function() {
		$('#decision').on('change', function() {
			if (this.value == 'rejected')
			//.....................^.......
			{
				$("#accordion1").show();
				$("#accordion2").hide();
			} else if (this.value == 'selected') {
				$("#accordion2").show();
				$("#accordion1").hide();
			} else {
				$("#accordion1").hide();
				$("#accordion2").hide();
			}

		});
	});
</script>
<script type="text/javascript">
	var datefield = document.createElement("input")
	datefield.setAttribute("type", "text")
	if (datefield.type != "date") { //if browser doesn't support input type="date", load files for jQuery UI Date Picker
		document
				.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
	}
</script>

<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#announcement_enddate').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>
<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#announcement_date').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#selecctall').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox1').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});

	$(document).ready(function() {
		$('#selecctall1').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox2').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});

	$(document).ready(function() {
		$('#selecctall2').click(function(event) { //on click 
			if (this.checked) { // check select status
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = true; //select all checkboxes with class "checkbox1"               
				});
			} else {
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"                       
				});
				$('.checkbox3').each(function() { //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox2"                       
				});
			}
		});

	});
</script>

<%@include file="header.jsp"%>
</head>

<body>
		<%
		CompanyListDAO companyListDAO = new CompanyListDAO(); 
	List<CompanyListBean> listOfCompany = companyListDAO.getListOfCompanyList();
			
									for (CompanyListBean c1 : listOfCompany) {
								%>
					<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									
									<button type="button" class="btn btn-outline-indigo indigo block btn-lg" data-toggle="modal" data-target="#slideInUp">
										Launch Modal
									</button>

									<!-- Modal -->
									<div class="modal animated slideInUp text-xs-left" id="slideInUp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel74" aria-hidden="true">
									  <div class="modal-dialog modal-lg" role="document">
										<div class="modal-content">
										  <div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											  <span aria-hidden="true">&times;</span>
											</button>
										
											<h4 class="modal-title" id="myModalLabel">
															<b>Employee Name For Company : <%=c1.getCompany_name()%></b>
														</h4>
										  </div>
										 <%
															int company_id = c1.getCompany_list_id();
																AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> listOfEmployees = allListDAO.getListOfEmployeeByCompany(company_id);
																for (EmployeeBean r : listOfEmployees) {
														%>
														
														<div class="col-md-2">
															<label><%=r.getFirstname() + " " + r.getLastname()%></label>
														</div>
														<%
															}
														%>
										  <div class="modal-footer">
											<button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-outline-primary">Save changes</button>
										  </div>
										</div>
									  </div>
									</div>
								</div>
							</div>
							<%} %>
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
	<script src="app-assets/js/scripts/modal/components-modal.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<!-- END PAGE LEVEL JS-->
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
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
	<script src="js/timepicki.js"></script>

	<script>
		$('#fromTime').timepicki();
	</script>


	<script type="text/javascript">
		$(function() {
			$('#fromTime').timepicki({
				showMeridian : false
			});
		});
	</script>
	<script>
		$('#toTime').timepicki();
	</script>


	<script type="text/javascript">
		$(function() {
			$('#toTime').timepicki({
				showMeridian : false
			});
		});

		var textarea = document.querySelector('textarea');

		textarea.addEventListener('keydown', autosize);

		function autosize() {
			var el = this;
			setTimeout(function() {
				el.style.cssText = 'height:auto; padding:5px;';
				// for box-sizing other than "content-box" use:
				// el.style.cssText = '-moz-box-sizing:content-box';
				el.style.cssText = 'height:' + el.scrollHeight + 'px';
			}, 0);
		}
	</script>
</body>

</html>