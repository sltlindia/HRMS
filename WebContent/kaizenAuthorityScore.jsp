<%@page import="com.hrms.kaizen.bean.KaizenAuthorityScoreBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBillboardResultBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Continuous Improvement</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
       <link type="text/css" rel="stylesheet" href="css/animate.css"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
       <link href="css/bootstrap.min.css" rel="stylesheet">
           <script src="js/jquery.min.js"></script>
        <script src="js/bootbox.min.js"></script>
</head>
<style type="text/css">
/* Smartphones (portrait and landscape) ----------- */
@media only screen 
and (min-device-width : 320px) 
and (max-device-width : 480px) {
/* Styles */
}

/* Smartphones (landscape) ----------- */
@media only screen 
and (min-width : 321px) {
/* Styles */
}

/* Smartphones (portrait) ----------- */
@media only screen 
and (max-width : 320px) {
/* Styles */
}

/* iPads (portrait and landscape) ----------- */
@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) {
/* Styles */
}

/* iPads (landscape) ----------- */
@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) 
and (orientation : landscape) {
/* Styles */
}

/* iPads (portrait) ----------- */
@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) 
and (orientation : portrait) {
/* Styles */
}

/* Desktops and laptops ----------- */
@media only screen 
and (min-width : 1224px) {
/* Styles */
}

/* Large screens ----------- */
@media only screen 
and (min-width : 1824px) {
/* Styles */
}

/* iPhone 4 ----------- */
@media
only screen and (-webkit-min-device-pixel-ratio : 1.5),
only screen and (min-device-pixel-ratio : 1.5) {
/* Styles */
}


#toast-container {
  top: auto !important;
  right: auto !important;
  bottom: 80%;
  left:50%;
  size: 20px;
}

 .collapsible li.active i {
  -ms-transform: rotate(90deg); /* IE 9 */
  -webkit-transform: rotate(90deg); /* Chrome, Safari, Opera */
  transform: rotate(90deg);
}


.preloader-background {
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #eee;
	position: fixed;
	z-index: 100;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;	
}
</style>

<body>

<%
EmployeeBean user = (EmployeeBean) session.getAttribute("user");
int employee_id = user.getEmployee_master_id(); 
int manager_id = user.getManagerBean().getManager_id();

int year = Integer.parseInt(request.getParameter("year"));
int month = Integer.parseInt(request.getParameter("month"));
String month_name = request.getParameter("month_name");

AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

List<KaizenBillboardResultBean> listForLeaderBoard = allKaizenListDAO.getListForLeaderBoard(month, year);


%>

<div class="panel-body">
<div class="row">

<div class="col-sm-3 col-md-3 col-lg-3">
	<img alt="sltlLogo" src="img/sltllogo.png" height="60px" width="170px;">
</div>

<div class="col-sm-5 col-md-5 col-lg-5">
	<label style="color: black;font-size: 28px"><b>Continuous Improvement(CI) <%=month_name%>,<%=year%></b></label>
</div>



<div class="col-sm-4 col-md-4 col-lg-4" align="right">
<h4><%=user.getSalutation()+" "+user.getFirstname()+" "+user.getLastname()%></h4>
</div>
</div>
<hr>
<%-- <%if(kaizenBillboardResultBean == null){ %>
<div align="right">
<button class="btn btn-default" onclick="lockScore();">LOCK</button>
</div>
<%}else{ %>
<div align="center">
<h4>Your Score(s) are locked!!!</h4>
</div>
<%} %> --%>
<br>
<div class="row">

<%  for(KaizenBillboardResultBean kaizenBillboardResultBean : listForLeaderBoard){
	
      			
      			int kaizen_id = kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id();
      			KaizenAuthorityScoreBean kaizenAuthorityScoreBean = allKaizenListDAO.getDetailOfKaizenAuthorityScoreByempId(kaizen_id, employee_id);
      		
      			
      			int qua = 0;
      			int cost = 0;
      			int saf = 0;
      			int prod = 0;
      			int del = 0;
      			int hor = 0;
      			int ci_id = 0;
      			double ave = 0;
      			
      			if(kaizenAuthorityScoreBean != null){
      				 qua = kaizenAuthorityScoreBean.getQuality();
          			 cost = kaizenAuthorityScoreBean.getCost();
          			 saf = kaizenAuthorityScoreBean.getSafety();
          			 prod = kaizenAuthorityScoreBean.getProductivity();
          			 del = kaizenAuthorityScoreBean.getDelivery();
          			 hor = kaizenAuthorityScoreBean.getHorizontal_deployment();
          			 ave = kaizenAuthorityScoreBean.getTotal();
      			}
      			
      			
      		%>
<div class="col-sm-4 col-md-4 col-lg-4">
<div class="panel panel-default" id="">

      <div class="panel-heading">
      <img src="img/sltllogo.png" height="30px" width="60px">
      
      <font style="font-weight: bold;" size="2px"><a style="cursor: pointer;" onclick="window.open('kaizenView.jsp?kaizen_id=<%=kaizen_id%>','_blank');"><%=kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_name()%></a></font>
      </div>
      <ul class="collapsible popout" data-collapsible="accordion">
        
          
      		 <li>
            <div class="collapsible-header active" onclick="imageSwap('img<%=kaizen_id%>');"><i class="material-icons" id="img<%=kaizen_id%>">chevron_right</i><b><%=kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getEmployeeBean().getDepartmentBean().getDepartment_name()%></b>
            	
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span class="badge"><font class="sum<%=kaizen_id%>" size="2px;" color="red" style="font-weight: bold;"><%=ave%></font></span>	
            
            </div>
            <div class="collapsible-body">
           <label><font color="red">1</font>:Poor <font color="red">2</font>:Satisfactory<font color="red">3</font>:Good<font color="red">4</font>:Excellent<font color="red">5</font>:Exceptional</label> <br>
            		<div class="col-sm-3 col-md-3 col-lg-3">
            		Quality
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
            		
            		<%if(qua==1){%>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua1<%=kaizen_id %>" class="qua<%=kaizen_id%>" value="1" checked="checked"/>
					<%}else{ %>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua1<%=kaizen_id %>" class="qua<%=kaizen_id%>" value="1" />
					<%} %>
					<label for="qua1<%=kaizen_id %>">1</label>
					
					<%if(qua==2){%>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua2<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua2<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="2"/>
					<%} %>
					<label for="qua2<%=kaizen_id %>">2</label>
					
					<%if(qua==3){%>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua3<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua3<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="3"/>
					<%} %>
					<label for="qua3<%=kaizen_id %>">3</label>
					
					<%if(qua==4){%>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua4<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua4<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="4"/>
					<%} %>
					<label for="qua4<%=kaizen_id %>">4</label>
					
					<%if(qua==5){%>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua5<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="qua<%=kaizen_id%>" type="radio" id="qua5<%=kaizen_id%>" class="qua<%=kaizen_id%>" value="5"/>
					<%} %>
					<label for="qua5<%=kaizen_id %>">5</label>
            		
            		</div>
    				
					
	    			
	    			
	    			
	    			
	    		
	    			
	    			<div class="col-sm-3 col-md-3 col-lg-3">
            		  Cost
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
	    			
	    			<%if(cost==1){%>
	    			<input name="cost<%=kaizen_id%>" type="radio" id="cost1<%=kaizen_id %>" class="cost<%=kaizen_id%>" value="1" checked="checked" />
					<%}else{ %>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost1<%=kaizen_id %>" class="cost<%=kaizen_id%>" value="1"  />
					<%} %>
					<label for="cost1<%=kaizen_id %>">1</label>
					
					<%if(cost==2){%>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost2<%=kaizen_id%>"  class="cost<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost2<%=kaizen_id%>"  class="cost<%=kaizen_id%>" value="2" />
					<%} %>
					<label for="cost2<%=kaizen_id %>">2</label>
					
					<%if(cost==3){%>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost3<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost3<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="3"  />
					<%} %>
					<label for="cost3<%=kaizen_id %>">3</label>
					
					<%if(cost==4){%>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost4<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost4<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="4" />
					<%} %>
					<label for="cost4<%=kaizen_id %>">4</label>
					
					<%if(cost==5){%>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost5<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="cost<%=kaizen_id%>" type="radio" id="cost5<%=kaizen_id%>" class="cost<%=kaizen_id%>" value="5" />
					<%} %>
	    			<label for="cost5<%=kaizen_id %>">5</label>
					</div>
	    			
	    			
	    			
	    			
	    			 
	    			
	    			
	    			
	    			
	    			<div class="col-sm-3 col-md-3 col-lg-3">
            		  Safety
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
	    			
	    			<%if(saf==1){%>
	    			<input name="saf<%=kaizen_id%>" type="radio" id="saf1<%=kaizen_id %>" class="saf<%=kaizen_id%>" value="1" checked="checked"/>
					<%}else{ %>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf1<%=kaizen_id %>" class="saf<%=kaizen_id%>" value="1"/>
					<%} %>
					<label for="saf1<%=kaizen_id %>">1</label>
					
					<%if(saf==2){%>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf2<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf2<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="2" />
					<%} %>
					<label for="saf2<%=kaizen_id %>">2</label>
					
					<%if(saf==3){%>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf3<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf3<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="3" />
					<%} %>
					<label for="saf3<%=kaizen_id %>">3</label>
					
					<%if(saf==4){%>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf4<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf4<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="4" />
					<%} %>
					<label for="saf4<%=kaizen_id %>">4</label>
					
					<%if(saf==5){%>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf5<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="saf<%=kaizen_id%>" type="radio" id="saf5<%=kaizen_id%>" class="saf<%=kaizen_id%>" value="5" />
					<%} %>
					<label for="saf5<%=kaizen_id %>">5</label>
	    			</div>
					
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			<div class="col-sm-3 col-md-3 col-lg-3">
	    			Productivity
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
	    			
	    			
	    			<%if(prod==1){%>
	    			<input name="prod<%=kaizen_id%>" type="radio" id="prod1<%=kaizen_id %>" class="prod<%=kaizen_id%>" value="1" checked="checked"/>
					<%}else{ %>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod1<%=kaizen_id %>" class="prod<%=kaizen_id%>" value="1" />
					<%} %>
					<label for="prod1<%=kaizen_id %>">1</label>
					
					<%if(prod==2){%>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod2<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod2<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="2" />
					<%} %>
						<label for="prod2<%=kaizen_id %>">2</label>
					
					<%if(prod==3){%>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod3<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod3<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="3"/>
					<%} %>
					<label for="prod3<%=kaizen_id %>">3</label>
					
					<%if(prod==4){%>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod4<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod4<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="4" />
					<%} %>
					<label for="prod4<%=kaizen_id %>">4</label>
					
					<%if(prod==5){%>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod5<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="prod<%=kaizen_id%>" type="radio" id="prod5<%=kaizen_id%>" class="prod<%=kaizen_id%>" value="5"/>
					<%} %>
					<label for="prod5<%=kaizen_id %>">5</label>
	    			</div>
	    			
	    			
	    			
	    			<div class="col-sm-3 col-md-3 col-lg-3">
	    			Delivery
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
	    			
	    			
	    			<%if(del==1){%>
	    			<input name="del<%=kaizen_id%>" type="radio" id="del1<%=kaizen_id %>" class="del<%=kaizen_id%>" value="1" checked="checked"/>
					<%}else{ %>
					<input name="del<%=kaizen_id%>" type="radio" id="del1<%=kaizen_id %>" class="del<%=kaizen_id%>" value="1" />
					<%} %>
					<label for="del1<%=kaizen_id %>">1</label>
					
					<%if(del==2){%>
					<input name="del<%=kaizen_id%>" type="radio" id="del2<%=kaizen_id%>" class="del<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="del<%=kaizen_id%>" type="radio" id="del2<%=kaizen_id%>" class="del<%=kaizen_id%>" value="2" />
					<%} %>
						<label for="del2<%=kaizen_id %>">2</label>
					
					<%if(del==3){%>
					<input name="del<%=kaizen_id%>" type="radio" id="del3<%=kaizen_id%>" class="del<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="del<%=kaizen_id%>" type="radio" id="del3<%=kaizen_id%>" class="del<%=kaizen_id%>" value="3"/>
					<%} %>
					<label for="del3<%=kaizen_id %>">3</label>
					
					<%if(del==4){%>
					<input name="del<%=kaizen_id%>" type="radio" id="del4<%=kaizen_id%>" class="del<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="del<%=kaizen_id%>" type="radio" id="del4<%=kaizen_id%>" class="del<%=kaizen_id%>" value="4" />
					<%} %>
					<label for="del4<%=kaizen_id %>">4</label>
					
					<%if(del==5){%>
					<input name="del<%=kaizen_id%>" type="radio" id="del5<%=kaizen_id%>" class="del<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="del<%=kaizen_id%>" type="radio" id="del5<%=kaizen_id%>" class="del<%=kaizen_id%>" value="5"/>
					<%} %>
					<label for="del5<%=kaizen_id %>">5</label>
	    			</div>
					
	    			
	    			
	    			<br>
	    			Horizontal Deployment
	    			<label style="color: red">(If there is no Horizontal Deployment Keep it blank)</label>
	    			 
	    			 <div class="col-sm-3 col-md-3 col-lg-3">
            		</div>
            		
            		<div class="col-sm-9 col-md-9 col-lg-9">
	    			<%if(hor==1){%>
	    			<input name="hor<%=kaizen_id%>" type="radio" id="hor1<%=kaizen_id %>" class="hor<%=kaizen_id%>" value="1" checked="checked"/>
					<%}else{ %>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor1<%=kaizen_id %>" class="hor<%=kaizen_id%>" value="1"/>
					<%} %>
					<label for="hor1<%=kaizen_id %>">1</label>
					
					<%if(hor==2){%>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor2<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="2" checked="checked"/>
					<%}else{ %>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor2<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="2"/>
					<%} %>
					<label for="hor2<%=kaizen_id %>">2</label>
					
					<%if(hor==3){%>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor3<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="3" checked="checked"/>
					<%}else{ %>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor3<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="3"/>
					<%} %>
					<label for="hor3<%=kaizen_id %>">3</label>
					
					<%if(hor==4){%>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor4<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="4" checked="checked"/>
					<%}else{ %>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor4<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="4"/>
					<%} %>
					<label for="hor4<%=kaizen_id %>">4</label>
					
					<%if(hor==5){%>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor5<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="5" checked="checked"/>
					<%}else{ %>
					<input name="hor<%=kaizen_id%>" type="radio" id="hor5<%=kaizen_id%>"  class="hor<%=kaizen_id%>" value="5"/>
					<%} %>
					<label for="hor5<%=kaizen_id %>">5</label>
					</div> 
					<br>
					<br>
					<center><a class="waves-effect waves-light btn" onclick="insertData(<%=kaizen_id%>)">Save</a></center>
            </div>
            </li>
            
         
         
      </ul>
      
      
      
	</div>	
	</div> 
	<%} %>
</div>
</div>	
</div>
	
      <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
      
      function refreshRadio(name) {
    	  $('input[name='+name+']').prop('checked', false);
		
	}
      
      function imageSwap(id) {
    	  $("i", "#"+id).toggleHtml("arrow_forward arrow_downward");
		}
      
      
      function insertData(id) {
		var sumOfvalue = 0
		
  	 	var kaizen_id = id;
		var employee_id = <%=employee_id%>;
  	 	var ci_id = $("#ci"+id).val();
  	 	var quality = 0;
  	 	var cost = 0;
  	 	var safety = 0;
  	 	var delivery = 0;
  	 	var productivity = 0;
  	 	var horizontal_deployment = 0;
  	 	var count = 0;
  	 	
  	 	
  	 	var q = $("input[type='radio'].qua"+id+":checked").val();
  	 	var c = $("input[type='radio'].cost"+id+":checked").val();
  	 	var s = $("input[type='radio'].saf"+id+":checked").val();
  	 	var d = $("input[type='radio'].del"+id+":checked").val();
  	 	var p = $("input[type='radio'].prod"+id+":checked").val();
  	 	var h = $("input[type='radio'].hor"+id+":checked").val()
  	 	
  	 	if(!isNaN(q)){
  	 		quality = q;
  	 		count++;
  	 	}
  	 	
  	 	if(!isNaN(c)){
  	 		cost = c;
  	 		count++;
  	 	}
  	 	
  	 	if(!isNaN(s)){
  	 		safety = s;
  	 		count++;
  	 	}
  	 	
  	 	if(!isNaN(d)){
  	 		delivery = d;
  	 		count++;
  	 	}
  	 	
  	 	if(!isNaN(p)){
  	 		productivity = p;
  	 		count++;
  	 	}
  	 	
  	 	if(!isNaN(h)){
  	 	  horizontal_deployment = h;
  	 	count++;
  	 	}
  	 	
  	 	sumOfvalue = parseInt(quality) + parseInt(cost) + parseInt(safety) + parseInt(productivity) + parseInt(horizontal_deployment) + parseInt(delivery);
  	 	
  	 	var ave = (sumOfvalue/count).toFixed(2);
  		var $form = $(this), url = 'kaizenAuthorityScoreInsert';
  		

  		 var posting = $.post(url, {
  			 kaizen_id : kaizen_id,
  			 employee_id : employee_id,
  			 quality : quality,
  			 cost : cost,
  			 safety : safety,
  			 productivity : productivity,
  			 delivery : delivery,
  			 horizontal_deployment : horizontal_deployment,
  			 year : <%=year%>,
  			 month : <%=month%>,
  			 ave : ave
  		});
  		 
  		
  		posting.done(function(data) {
  			$(".sum"+id).html(ave);
  			Materialize.toast('Rating Successfully Saved!', 2000);
  		});
  		
  		
  	}

      
      
      function lockScore() {
		alert("test");
		var employee_id = <%=employee_id%>;
  	 	var month = <%=month%> ;
  	 	var year = <%=year%>;
  	 	
  	 	
  		var $form = $(this), url = 'kaizenManagerResultLock';
  		

  		 var posting = $.post(url, {
  			 employee_id : employee_id,
  			 month : month,
  			 year : year
  		});
  		 
  		
  		posting.done(function(data) {
  			Materialize.toast('Locked Successfully!!!', 2000);
  		});
  		
  	 	}
  		
		
      
      </script>
      
      
      
      
</body>
</html>