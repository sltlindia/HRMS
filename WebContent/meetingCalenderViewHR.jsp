<%@page import="com.hrms.meetingmanagemnet.dao.AllListMeetingDAO"%>
<%@page import="com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean"%>
<%@page  language="java" import="java.util.*,java.text.*"%>
<%!
public int nullIntconv(String inv)
{   
	int conv=0;
		
	try{
		conv=Integer.parseInt(inv);
	}
	catch(Exception e)
	{}
	return conv;
}
%>
<%
 int iYear=nullIntconv(request.getParameter("iYear"));
 int iMonth=nullIntconv(request.getParameter("iMonth"));

 Calendar ca = new GregorianCalendar();
 int iTDay=ca.get(Calendar.DATE);
 int iTYear=ca.get(Calendar.YEAR);
 int iTMonth=ca.get(Calendar.MONTH);

 System.out.println("Y  " + iYear + " M " + iMonth);
  
 
 if(iYear==0)
 {
	  iYear=iTYear;
	  iMonth=iTMonth;
 }

 GregorianCalendar cal = new GregorianCalendar (iYear, iMonth, 1); 

 int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 int weekStartDay=cal.get(Calendar.DAY_OF_WEEK);
 
 cal = new GregorianCalendar (iYear, iMonth, days); 
 int iTotalweeks=cal.get(Calendar.WEEK_OF_MONTH);
  
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Calender OF Meeting</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
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
    <%@include file="header.jsp" %>
<script>
function goTo()
{
  document.frm.submit()
}
</script>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">SLTL Meeting Calender</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				
<%AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO(); %>
	<div class="row">
<div class="col-md-12">
<div class="card">
<div class="card-body collapse in">
<div class="card-block">
<div class="form-body">			
<form name="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="6%">Year :</td>
        <td width="7%">
		<select name="iYear" onchange="goTo()">
        <%
		// start year and end year in combo box to change year in calendar
	    for(int iy=iTYear-70;iy<=iTYear+70;iy++)
		{
		  if(iy==iYear)
		  {
		    %>
          <option value="<%=iy%>" selected="selected"><%=iy%></option>
          <%
		  }
		  else
		  {
		    %>
          <option value="<%=iy%>"><%=iy%></option>
          <%
		  }
		}
	   %>
        </select></td>
        <td width="73%" align="center"><h3><%=new SimpleDateFormat("MMMM").format(new Date(2008,iMonth,01))%> <%=iYear%></h3></td>
        <td width="6%">Month :</td>
        <td width="8%">
		<select name="iMonth" onchange="goTo()">
        <%
		// print month in combo box to change month in calendar
	    for(int im=0;im<=11;im++)
		{
		  if(im==iMonth)
		  {
	     %>
          <option value="<%=im%>" selected="selected"><%=new SimpleDateFormat("MMMM").format(new Date(2008,im,01))%></option>
          <%
		  }
		  else
		  {
		    %>
          <option value="<%=im%>"><%=new SimpleDateFormat("MMMM").format(new Date(2008,im,01))%></option>
          <%
		  }
		}
	   %>
        </select></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table align="center" border="1" cellpadding="3" cellspacing="0" width="100%">
      <tbody>
        <tr bgcolor=" #d7dbdd" align="center">
            	<td align="Center" height="40"><b>Sun</b></td>
            	<td align="Center" height="40"><b>Mon</b></td>
            	<td align="Center" height="40"><b>Tue</b></td>
            	<td align="Center" height="40"><b>Wed</b></td>
            	<td align="Center" height="40"><b>Thu</b></td>
            	<td align="Center" height="40"><b>Fri</b></td>
            	<td align="Center" height="40"><b>Sat</b></td>
        </tr>
        <%
        int cnt =1;
        for(int i=1;i<=iTotalweeks;i++)
        {
		%>
        <tr>
          <% 
	        for(int j=1;j<=7;j++)
	        {
		        if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
		        {
		         %>
                <td align="center" height="130" width="130">&nbsp;</td>
               <% 
		        }
		        else
		        {
		        	String day = String.valueOf(cnt-weekStartDay+1);
		        	String month = new SimpleDateFormat("MM").format(new Date(2008,iMonth,01));
		        	String year = String.valueOf(iTYear);
		        	String date = day + "/" + month +"/" + year;
		        	String date1 = year + "-" + month +"-" + day;
		        	
		        	List<MeetingBookingDetailBean> listOfMeeting = allListMeetingDAO.getMeetingsByempIdGroupByFacilityForHR(date1);
		        	String color = "";
					if(listOfMeeting.size() != 0){
			        	 color = "#B7E5C9";
			         }
		         %>
                <td height="130" width="130" style="background-color: <%=color%>"><P style="font-size: 13px;"><%=date%></P>
                <p style="font-size: 10px;">
                	<%for(MeetingBookingDetailBean meetingBookingDetailBean : listOfMeeting){
                		int facilityId = meetingBookingDetailBean.getMeetingRoomDetailBean().getMeeting_room_detail_id();
                		List<MeetingBookingDetailBean> listOfMeetingByFacility = allListMeetingDAO.getMeetingsByFacilityId(facilityId,date1);
                	%>
                		<a style="cursor: pointer;" data-toggle="modal"
							data-target="#meetingData" onclick="getData(<%=facilityId%>,'<%=date1%>')"><font color="red"><b><%=meetingBookingDetailBean.getMeetingRoomDetailBean().getFacility_name()%></font> (<%=listOfMeetingByFacility.size()%>)</b></a>
                	<%} %>
                </p>	
                </td>
               <% 
		        }
		        cnt++;
		      }
	        %>
        </tr>
        <% 
	    }
	    %>
      </tbody>
    </table></td>
  </tr>
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

<div class="modal fade" id="meetingData" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Meeting Detail</h4>
				</div>
					<div class="modal-body">
						<table class="table table-bordered" id="facilityBooking" style="font-size: 13px;">
						<thead>
						<tr>
							<th>Name</th>
							<th>Department</th>
							<th>Time Period</th>
						</tr>
						</thead>
							
						<tbody>
						
						</tbody>
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">CLOSE</button>
					</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

<!-- Bootstrap Core JavaScript -->
   <%@include file="footer.html"%>
    <!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
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
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    
    function getData(id,date) {
    	$("#facilityBooking tbody").empty();
    	$
		.ajax({
			method : "POST",
			url : 'meetingData',
			data : {date:date,facilityId:id,action:'time'},
			success : function(data) {
				if(data == '[]'){
					var tblRow = "<tr><td colspan=\"3\" align=\"center\"><font style=\"color:red\"> All Slots are free for booking <font>"
						+ "</td>"
				$(tblRow).appendTo("#facilityBooking tbody");
				}else{
				var json1 = JSON.parse(data);
				$
						.each(
								json1,
								function(i, f) {
									var tblRow = "<tr><td>"
											+ f.employee_name
											+ "</td><td>"
											+f.departmentName
											+ "</td><td>"
											+ f.from_time +" to  "+f.to_time
											+ "</td>"
											

									$(tblRow).appendTo("#facilityBooking tbody");
								});
			}
			}
				
		});
		
	}
    
    </script>
        
	
</body>
</html>
