<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width">
<title>Org Chart</title>
<link rel="stylesheet" href="css/Treant.css">
<link rel="stylesheet" href="css/example6.css">
<link rel="stylesheet" href="css/perfect-scrollbar.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/jquery.mousewheel.min.js"></script>

<script>

  (function($) {
	  $.dragScroll = function(options) {
	    var settings = $.extend({
	      scrollVertical: true,
	      scrollHorizontal: true,
	      cursor: null
	    }, options);

	    var clicked = false,
	      clickY, clickX;

	    var getCursor = function() {
	      if (settings.cursor) return settings.cursor;
	      if (settings.scrollVertical && settings.scrollHorizontal) return 'move';
	      if (settings.scrollVertical) return 'row-resize';
	      if (settings.scrollHorizontal) return 'col-resize';
	    }

	    var updateScrollPos = function(e, el) {
	      $('html').css('cursor', getCursor());
	      var $el = $(el);
	      $(window).scrollTop($(window).scrollTop() + (clickY - e.pageY));
	      $('.chart').scrollLeft($('.chart').scrollLeft() + (clickX - e.pageX));
	      
	     /*  settings.scrollVertical && $el.scrollTop($el.scrollTop() + (clickY - e.pageY));
	      settings.scrollHorizontal && $el.scrollLeft($el.scrollLeft() + (clickX - e.pageX)); */
	    }

	    $(document).on({
	      'mousemove': function(e) {
	        clicked && updateScrollPos(e, this);
	      },
	      'mousedown': function(e) {
	        clicked = true;
	        clickY = e.pageY;
	        clickX = e.pageX;
	      },
	      'mouseup': function() {
	        clicked = false;
	        $('html').css('cursor', 'auto');
	      }
	    });
	  }
	}(jQuery))

	$.dragScroll();
 
 
 
  /* var clicked = false, clickY, clickX ;
 $(document).on({
     'mousemove': function(e) {
         clicked && updateScrollPos(e);
     },
     'mousedown': function(e) {
         clicked = true;
         clickY = e.pageY;
         clickX = e.pageX;
     },
     'mouseup': function() {
         clicked = false;
         $('html').css('cursor', 'auto');
     }
 });

 
 var getCursor = function() {
     if (settings.cursor) return settings.cursor;
     if (settings.scrollVertical && settings.scrollHorizontal) return 'move';
     if (settings.scrollVertical) return 'row-resize';
     if (settings.scrollHorizontal) return 'col-resize';
   }
 
 
 var updateScrollPos = function(e) {
	 $('html').css('cursor', getCursor());
      $(window).css('cursor', 'col-resize');
     $(window).scrollTop($(window).scrollTop() + (clickY - e.pageY));
     $('.chart').scrollLeft($('.chart').scrollLeft() + (clickX - e.pageX));
 } */
 

 
 
 
 
</script>



<script type="text/javascript">
function redirect(id) {
	
	var manager = document.getElementById("manager").value;
	var department = document.getElementById("department").value;
	
	var retVal = confirm("would you like to open all branches?");
	if( retVal == true )
		{
		if(id == 1){
			window.location.replace("ornogram.jsp?department="+department+"&manager=1&openBranch=false");
		}else if(id == 2){
			window.location.replace("ornogram.jsp?manager="+manager+"&openBranch=false");
		}
		}
			else
			{
				if(id == 1){
					window.location.replace("ornogram.jsp?department="+department+"&manager=1&openBranch=true");
				}else if(id == 2){
					window.location.replace("ornogram.jsp?manager="+manager+"&openBranch=true");
				}
	 		}
	
}

</script>
</head>

<%@include file="projectCreatorHeader.jsp"%>
<body>
<%
int dept_id = 0;
%>
	<%
    int mID = user.getManagerBean().getManager_id();
   
    int deptId = 0;
    
    if(mID == 1 || mID == 2 || mID == 3 || mID == 4 || mID == 5 || mID == 117 || mID == 96){
    	if(request.getParameter("department") != null){
    		dept_id = Integer.parseInt(request.getParameter("department"));
    	}
    	
    	
    	if(request.getParameter("manager") != null){
    		mID = Integer.parseInt(request.getParameter("manager"));
    	}
    	%>	
    	<br>
    									<label>Department:</label>
    									<select name="department"
												id="department" required="required"
												onchange="redirect(1)" required>
													<option value="0">--Select Department--</option>
													<%
														DepartmentDAO departmentDAO = new DepartmentDAO();
															List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
															for (DepartmentBean departmentBean : listOfDepartment) {
															if(dept_id == departmentBean.getDepartment_id()){
													%>
													<option value="<%=departmentBean.getDepartment_id()%>" selected="selected"><%=departmentBean.getDepartment_name()%></option>
													<%}else{ %>
													<option value="<%=departmentBean.getDepartment_id()%>"><%=departmentBean.getDepartment_name()%></option>
													<%} %>	
													<%
													  }
													%>
										</select>
											
											
											<label>Manager:</label>
											<select name="manager"
												id="manager" required="required"
												onchange="redirect(2)" required>
													<option value="0">--Select Manager--</option>

													<%
														LoginDAO loginDAO = new LoginDAO();
													String under_manager_id = null;
															List<EmployeeBean> ListOfManager = loginDAO.getListOfManagerFromEmployeeMaster();
															for (EmployeeBean employeeBean : ListOfManager) {
																if(!employeeBean.getFirstname().equalsIgnoreCase("PPC")){
																if(employeeBean.getManagerBean().getManager_id() == mID){
													%>
													<option value="<%=employeeBean.getManagerBean().getManager_id()%>" selected="selected"><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></option>
													<%}else{ %>
													<option value="<%=employeeBean.getManagerBean().getManager_id()%>"><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></option>
													<%
															}}}
													%>
											</select>
											
    <%}%>
    &emsp;&emsp;
    <a href="login.jsp"><button class="btn bth-primary btn-xs">BACK</button></a>										

	<div id="wrapper" style="padding-left: 10px; padding-right: 10px;">
		<div id="header"></div>
		<div class="chart" id="collapsable-example"> </div>
		<script src="js/vendor/raphael.js"></script>
		<script src="js/Treant.js"></script>

		<script src="js/vendor/jquery.min.js"></script>

		<script src="js/vendor/jquery.mousewheel.js"></script>
		<script src="js/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	</div>
											

	<script>
	   var openBranch = null;
	<%if(request.getParameter("openBranch") != null){
		String openBranchValue =  request.getParameter("openBranch");
		if(openBranchValue.equals("true")){
	%>
		openBranch = true;
		<%}else if(openBranchValue.equals("false")){%>
		openBranch = false;
		<%}%>
	<%}else{%>
		openBranch = true;
	<%}%>
	
	
    var tree_structure = {
    	    chart: {
    	        container: "#collapsable-example",
    	        levelSeparation:    30,
    	        siblingSeparation:  70,
    	        subTeeSeparation:   70,
    	      	nodeAlign: "BOTTOM",
    	        scrollbar: "fancy",
    	        padding: 35,
    			 node: {
    	                collapsable: true,
    					HTMLclass: "evolution-tree"
    	            },
    	        connectors: {
    	            type: "curve",
    	            style: {

    	                "stroke-width": 2,
    	                "stroke-linecap": "round",
    	                "stroke": "#ccc"
    	            }
    	        }
    	    },

    	    nodeStructure:
    	       
    	    	<% LoginDAO loginDAO = new LoginDAO();
            List<EmployeeBean> listOfEmployeeInZeroLevel = loginDAO.getListOfEmployeeZeroLevel(mID); // CEO OF SLTL
    			for (EmployeeBean e0 : listOfEmployeeInZeroLevel) { // START e0 
    				int m0 = e0.getManagerBean().getManager_id();
    			/* 	int company_id = e0.getCompanyListBean().getCompany_list_id();
    				String company_name = null;
    				if (company_id == 1) {
    					company_name = "SLTL";
    				} else if (company_id == 2) {
    					company_name = "SS";
    				} else if (company_id == 3) {
    					company_name = "S.HR";
    				} else if (company_id == 4) {
    					company_name = "COSMOS";
    				} else if (company_id == 5) {
    					company_name = "CSLASER";
    				} else if (company_id == 6) {
    					company_name = "SEZ";
    				} else if (company_id == 7) {
    					company_name = "CL";
    				}else
    				if (company_id == 8) {
    					company_name = "App";
    				} */
    			
    						List<EmployeeBean> listOfEmployeeInFirstLevelDepartment = null;
    						
    						if(mID == 1 && dept_id != 0){
    							listOfEmployeeInFirstLevelDepartment = loginDAO.getListByDepartmentUnderForAuthorityManagerId(m0,dept_id); // LIST OF FIRST LEVEL DEPARTMENT
    						}else{
    							listOfEmployeeInFirstLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m0,dept_id);// LIST OF FIRST LEVEL DEPARTMENT
    						}
    						%>
    				 	{
    		    	    	text: {name: "<%=e0.getFirstname()+" "+e0.getLastname()+" ("+e0.getRoleBean().getRole_type()+")"%>"},
    		    	    	
    		                image: "http://192.168.182.104:80/HRMS/img/<%=company_name%>/<%=e0.getEmployee_code()%>.bmp",
    		    	        HTMLclass: "the-parent_employee",
    		    	        collapsed: openBranch,
    	       	 children: [
    	            {
    	            	pseudo: true,
    	                children: [
    	                	<%for(EmployeeBean d1 : listOfEmployeeInFirstLevelDepartment){ // START d1
    	            			int dept_id1 = d1.getDepartmentBean().getDepartment_id();
    	            			List<EmployeeBean> listOfSubDepartmentInFirstLevel = loginDAO.getListByUnderManagerIdAndGroupBySubDeptId(m0,dept_id1); // LIST OF SUB DIPARTMENT FIRST LEVEL
    	            			if(listOfSubDepartmentInFirstLevel.size() != 0){ // START IF CONDITION FOR SUB DIPARTMENT FIRST LEVEL
    	                    %>
    	                	  {
    	                	  	text: { name: "<%=d1.getDepartmentBean().getDepartment_name()%>"},
    	                	  	HTMLclass: "the-parent_department",
    	                	  	 collapsed: openBranch,
    	                	    children: [
    	                	    	<%for(EmployeeBean sd1 : listOfSubDepartmentInFirstLevel){ // START OF sd1
    	    	            			String sub_department  = sd1.getSub_department();
    	    	            			List<EmployeeBean> listOfEmployeeInFirstLevel = loginDAO.getListByUnderManagerIdAndSubDeptId(m0,dept_id1,sub_department); // LIST OF FIRST LEVEL EMPLOYEE BY MANAGER_ID,DEPT_ID,SUB_DEPARTMENT
    	    	                    %>
    	                	    	{
            	                        text: {name: "<%=sub_department%>"},
            	                       	 HTMLclass: "the-parent_subDepartment",
            	                         childrenDropLevel: 1,
          	                       		 stackChildren: true,
          	                       		 collapsed: openBranch,
            	                	    children: [
            	                	    	<%for(EmployeeBean e1 : listOfEmployeeInFirstLevel){ // START OF e1
            	                	    		int m1 = e1.getManagerBean().getManager_id();
            	                	    		int company_id1 = e1.getCompanyListBean().getCompany_list_id();
            	                				String company_name1 = null;
            	                				if (company_id1 == 1) {
            	                					company_name1 = "SLTL";
            	                				} else if (company_id1 == 2) {
            	                					company_name1 = "SS";
            	                				} else if (company_id1 == 3) {
            	                					company_name1 = "S.HR";
            	                				} else if (company_id1 == 4) {
            	                					company_name1 = "COSMOS";
            	                				} else if (company_id1 == 5) {
            	                					company_name1 = "CSLASER";
            	                				} else if (company_id1 == 6) {
            	                					company_name1 = "SEZ";
            	                				} else if (company_id1 == 7) {
            	                					company_name1 = "CL";
            	                				}else
            	                				if (company_id1 == 8) {
            	                					company_name1 = "App";
            	                				}
            	                				List<EmployeeBean> listOfEmployeeInSecondLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m1,dept_id);
            	                				if(listOfEmployeeInSecondLevelDepartment.size() != 0){ // START OF IF FOR SECOND LEVEL DEPARTMENT
            	    	                    %>
            	                	    			{
            	                	    				text: { name: "<%=e1.getFirstname()+" "+e1.getLastname()+" ("+e1.getRoleBean().getRole_type()+")"%>"},
            	                	    				 image: "http://192.168.182.104:80/HRMS/img/<%=company_name1%>/<%=e1.getEmployee_code()%>.bmp",
            	                	    				HTMLclass: "the-parent_employee",
            	                	    				 collapsed: openBranch,
            	                    	                children: [
            	                    	                	<%for(EmployeeBean d2 : listOfEmployeeInSecondLevelDepartment){ // START d2
            	                    	            			int dept_id2 = d2.getDepartmentBean().getDepartment_id();
            	                    	            			List<EmployeeBean> listOfSubDepartmentInSecondLevel = loginDAO.getListByUnderManagerIdAndGroupBySubDeptId(m1,dept_id2); // LIST OF SUB DIPARTMENT SECOND LEVEL
            	                    	                    %>
            	                    	                	  {
            	                    	                		  text: { name: "<%=d2.getDepartmentBean().getDepartment_name()%>"},
            	                      	                	  	  HTMLclass: "the-parent_department", 
            	                      	                	  	  collapsed: openBranch,
            	                      	                	  	 children: [
            	                     	                	    	<%for(EmployeeBean sd2 : listOfSubDepartmentInSecondLevel){ // START OF sd2
            	                     	    	            			String sub_department2  = sd2.getSub_department();
            	                     	    	            			List<EmployeeBean> listOfEmployeeInSecondLevel = loginDAO.getListByUnderManagerIdAndSubDeptId(m1,dept_id2,sub_department2); // LIST OF SECOND LEVEL EMPLOYEE BY MANAGER_ID,DEPT_ID,SUB_DEPARTMENT
            	                     	    	                    %>
            	                     	                	    	{
            	                             	                        text: { name: "<%=sub_department2%>"},
            	                             	                        HTMLclass: "the-parent_subDepartment",
            	                             	                       	childrenDropLevel: 1,
                                           	                       		stackChildren: true,
                                           	                       	 	collapsed: openBranch,
            	                             	                       children: [
            	                           	                	    	<%for(EmployeeBean e2 : listOfEmployeeInSecondLevel){ // START OF e2
            	                           	                	    		int m2 = e2.getManagerBean().getManager_id();
            	                           	                	    	
            	                           	                	    	int company_id2 = e2.getCompanyListBean().getCompany_list_id();
            	                           	             				String company_name2 = null;
            	                           	             				if (company_id2 == 1) {
            	                           	             					company_name2 = "SLTL";
            	                           	             				} else if (company_id2 == 2) {
            	                           	             					company_name2 = "SS";
            	                           	             				} else if (company_id2 == 3) {
            	                           	             					company_name2 = "S.HR";
            	                           	             				} else if (company_id2 == 4) {
            	                           	             					company_name2 = "COSMOS";
            	                           	             				} else if (company_id2 == 5) {
            	                           	             					company_name2 = "CSLASER";
            	                           	             				} else if (company_id2 == 6) {
            	                           	             					company_name2 = "SEZ";
            	                           	             				} else if (company_id2 == 7) {
            	                           	             					company_name2 = "CL";
            	                           	             				}else
            	                           	             				if (company_id2 == 8) {
            	                           	             					company_name2 = "App";
            	                           	             				}
            	                           	                	    	
            	                           	                				List<EmployeeBean> listOfEmployeeInThirdLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m2,dept_id);
            	                           	                				if(listOfEmployeeInThirdLevelDepartment.size() != 0){ // START OF IF FOR THIRD LEVEL DEPARTMENT
            	                           	    	                    %>
            	                           	                	    			{
            	                           	                	    				text: { name: "<%=e2.getFirstname()+" "+e2.getLastname()+" ("+e2.getRoleBean().getRole_type()+")"%>"},
            	                           	                	    			 	image: "http://192.168.182.104:80/HRMS/img/<%=company_name2%>/<%=e2.getEmployee_code()%>.bmp",
            	                           	                	    				HTMLclass: "the-parent_employee",
            	                           	                	    			    collapsed: openBranch,
            	                           	                	    				
            	                           	                	    			 children: [
            	                     	                    	                	<%for(EmployeeBean d3 : listOfEmployeeInThirdLevelDepartment){ // START d3
            	                     	                    	            			int dept_id3 = d3.getDepartmentBean().getDepartment_id();
            	                     	                    	            			List<EmployeeBean> listOfSubDepartmentInThirdLevel = loginDAO.getListByUnderManagerIdAndGroupBySubDeptId(m2,dept_id3); // LIST OF SUB DIPARTMENT THIRD LEVEL
            	                     	                    	                    %>
            	                     	                    	                	  {
            	                     	                    	                		  text: { name: "<%=d3.getDepartmentBean().getDepartment_name()%>"},
            	                     	                      	                	  	  HTMLclass: "the-parent_department",
            	                     	                      	                	      collapsed: openBranch,
            	                     	                      	                	  	  
            	                     	                      	                	  	children: [
            	                    	                     	                	    	<%for(EmployeeBean sd3 : listOfSubDepartmentInThirdLevel){ // START OF sd3
            	                    	                     	    	            			String sub_department3  = sd3.getSub_department();
            	                    	                     	    	            			List<EmployeeBean> listOfEmployeeInThirdLevel = loginDAO.getListByUnderManagerIdAndSubDeptId(m2,dept_id3,sub_department3); // LIST OF THIRD LEVEL EMPLOYEE BY MANAGER_ID,DEPT_ID,SUB_DEPARTMENT
            	                    	                     	    	                    %>
            	                    	                     	                	    	{
            	                    	                             	                        text: { name: "<%=sub_department3%>"},
            	                    	                             	                        HTMLclass: "the-parent_subDepartment",
            	                    	                             	                       	childrenDropLevel: 1,
            	                                                 	                       		 stackChildren: true,
            	                                                 	                       		collapsed: openBranch,
            	                    	                             	                       children: [
            	                       	                           	                	    	<%for(EmployeeBean e3 : listOfEmployeeInThirdLevel){ // START OF e3
            	                       	                           	                	    		int m3 = e3.getManagerBean().getManager_id();
            	                       	                           	                	    	
            	                       	                           	                	    	int company_id3 = e3.getCompanyListBean().getCompany_list_id();
            	                       	                           	      				String company_name3 = null;
            	                       	                           	      				if (company_id3 == 1) {
            	                       	                           	      					company_name3 = "SLTL";
            	                       	                           	      				} else if (company_id3 == 2) {
            	                       	                           	      					company_name3 = "SS";
            	                       	                           	      				} else if (company_id3 == 3) {
            	                       	                           	      					company_name3 = "S.HR";
            	                       	                           	      				} else if (company_id3 == 4) {
            	                       	                           	      					company_name3 = "COSMOS";
            	                       	                           	      				} else if (company_id3 == 5) {
            	                       	                           	      					company_name3 = "CSLASER";
            	                       	                           	      				} else if (company_id3 == 6) {
            	                       	                           	      					company_name3 = "SEZ";
            	                       	                           	      				} else if (company_id3 == 7) {
            	                       	                           	      					company_name3 = "CL";
            	                       	                           	      				}else
            	                       	                           	      				if (company_id3 == 8) {
            	                       	                           	      					company_name3 = "App";
            	                       	                           	      				}
            	                       	                           	      				
            	                       	                           	      				
            	                       	                           	                				List<EmployeeBean> listOfEmployeeInFourthLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m3,dept_id);
            	                       	                           	                				if(listOfEmployeeInFourthLevelDepartment.size() != 0){ // START OF IF FOR FOURTH LEVEL DEPARTMENT
            	                       	                           	    	                    %>
            	                       	                           	                	    			{
            	                       	                           	                	    				text: { name: "<%=e3.getFirstname()+" "+e3.getLastname()+" ("+e3.getRoleBean().getRole_type()+")"%>"},
            	                       	                           	                	    			image: "http://192.168.182.104:80/HRMS/img/<%=company_name3%>/<%=e3.getEmployee_code()%>.bmp",
            	                       	                           	                	    				HTMLclass: "the-parent_employee",
            	                       	                           	                	    			 collapsed: openBranch,
            	                       	                           	                	    				
            	                       	                           	                	    			children: [
            	                    	                     	                    	                	<%for(EmployeeBean d4 : listOfEmployeeInFourthLevelDepartment){ // START d4
            	                    	                     	                    	            			int dept_id4 = d4.getDepartmentBean().getDepartment_id();
            	                    	                     	                    	            			List<EmployeeBean> listOfSubDepartmentInFourthLevel = loginDAO.getListByUnderManagerIdAndGroupBySubDeptId(m3,dept_id4); // LIST OF SUB DIPARTMENT FOURTH LEVEL
            	                    	                     	                    	                    %>
            	                    	                     	                    	                	  {
            	                    	                     	                    	                		  text: { name: "<%=d4.getDepartmentBean().getDepartment_name()%>"},
            	                    	                     	                      	                	  	  HTMLclass: "the-parent_department",
            	                    	                     	                      	                	   collapsed: openBranch,
            	                    	                     	                      	                	  	  
            	                    	                     	                      	                	  	children: [
            	                    	                    	                     	                	    	<%for(EmployeeBean sd4 : listOfSubDepartmentInFourthLevel){ // START OF sd4
            	                    	                    	                     	    	            			String sub_department4  = sd4.getSub_department();
            	                    	                    	                     	    	            			List<EmployeeBean> listOfEmployeeInFourthLevel = loginDAO.getListByUnderManagerIdAndSubDeptId(m3,dept_id4,sub_department4); // LIST OF FOURTH LEVEL EMPLOYEE BY MANAGER_ID,DEPT_ID,SUB_DEPARTMENT
            	                    	                    	                     	    	                    %>
            	                    	                    	                     	                	    	{
            	                    	                    	                             	                        text: { name: "<%=sub_department4%>"},
            	                    	                    	                             	                        HTMLclass: "the-parent_subDepartment",
            	                    	                    	                             	                       childrenDropLevel: 1,
            	                    	                                                 	                       		 stackChildren: true,
            	                    	                                                 	                       		collapsed: openBranch,
            	                    	                    	                             	                       children: [
            	                       	                       	                           	                	    	<%for(EmployeeBean e4 : listOfEmployeeInFourthLevel){ // START OF e4
            	                       	                       	                           	                	    		int m4 = e4.getManagerBean().getManager_id();
            	                       	                       	                           	                	    	
            	                       	                       	                           	                	   int company_id4 = e4.getCompanyListBean().getCompany_list_id();
            	                       	                       	                             				String company_name4 = null;
            	                       	                       	                             				if (company_id4 == 1) {
            	                       	                       	                             					company_name4 = "SLTL";
            	                       	                       	                             				} else if (company_id4 == 2) {
            	                       	                       	                             					company_name4 = "SS";
            	                       	                       	                             				} else if (company_id4 == 3) {
            	                       	                       	                             					company_name4 = "S.HR";
            	                       	                       	                             				} else if (company_id4 == 4) {
            	                       	                       	                             					company_name4 = "COSMOS";
            	                       	                       	                             				} else if (company_id4 == 5) {
            	                       	                       	                             					company_name4 = "CSLASER";
            	                       	                       	                             				} else if (company_id4 == 6) {
            	                       	                       	                             					company_name4 = "SEZ";
            	                       	                       	                             				} else if (company_id4 == 7) {
            	                       	                       	                             					company_name4 = "CL";
            	                       	                       	                             				}else
            	                       	                       	                             				if (company_id4 == 8) {
            	                       	                       	                             					company_name4 = "App";
            	                       	                       	                             				}
            	                       	                       	                           	                	    	
            	                       	                       	                           	                				List<EmployeeBean> listOfEmployeeInFifthLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m4,dept_id);
            	                       	                       	                           	                				if(listOfEmployeeInFifthLevelDepartment.size() != 0){ // START OF IF FOR FIFTh LEVEL DEPARTMENT
            	                       	                       	                           	    	                    %>
            	                       	                       	                           	                	    			{
            	                       	                       	                           	                	    				text: { name: "<%=e4.getFirstname()+" "+e4.getLastname()+" ("+e4.getRoleBean().getRole_type()+")"%>"},
            	                       	                       	                           	                	    		image: "http://192.168.182.104:80/HRMS/img/<%=company_name4%>/<%=e4.getEmployee_code()%>.bmp",
            	                       	                       	                           	                	    				HTMLclass: "the-parent_employee",
            	                       	                       	                           	                	    		 collapsed: openBranch,
            	                       	                       	                           	                	    				
            	                       	                       	                           	                	    		children: [
            	                	                    	                     	                    	                	<%for(EmployeeBean d5 : listOfEmployeeInFifthLevelDepartment){ // START d4
            	                	                    	                     	                    	            			int dept_id5 = d5.getDepartmentBean().getDepartment_id();
            	                	                    	                     	                    	            			List<EmployeeBean> listOfSubDepartmentInFifthLevel = loginDAO.getListByUnderManagerIdAndGroupBySubDeptId(m4,dept_id5); // LIST OF SUB DIPARTMENT FIFTH LEVEL
            	                	                    	                     	                    	                    %>
            	                	                    	                     	                    	                	  {
            	                	                    	                     	                    	                		  text: { name: "<%=d5.getDepartmentBean().getDepartment_name()%>"},
            	                	                    	                     	                      	                	  	  HTMLclass: "the-parent_department",
            	                	                    	                     	                      	                	   collapsed: openBranch,
            	                	                    	                     	                      	                	  	children: [
            	                	                    	                    	                     	                	    	<%for(EmployeeBean sd5 : listOfSubDepartmentInFifthLevel){ // START OF sd5
            	                	                    	                    	                     	    	            			String sub_department5  = sd5.getSub_department();
            	                	                    	                    	                     	    	            			List<EmployeeBean> listOfEmployeeInFifthLevel = loginDAO.getListByUnderManagerIdAndSubDeptId(m4,dept_id5,sub_department5); // LIST OF FIFTH LEVEL EMPLOYEE BY MANAGER_ID,DEPT_ID,SUB_DEPARTMENT
            	                	                    	                    	                     	    	                    %>
            	                	                    	                    	                     	                	    	{
            	                	                    	                    	                             	                        text: { name: "<%=sub_department5%>"},
            	                	                    	                    	                             	                        HTMLclass: "the-parent_subDepartment",
            	                	                    	                    	                             	                       childrenDropLevel: 1,
            	                	                    	                                                 	                       		 stackChildren: true,
            	                	                    	                                                 	                       		collapsed: openBranch,
            	                	                    	                    	                             	                       children: [
            	                	                       	                       	                           	                	    	<%for(EmployeeBean e5 : listOfEmployeeInFourthLevel){ // START OF e5
            	                	                       	                       	                           	                	    		int m5 = e5.getManagerBean().getManager_id();
            	                	                       	                       	                           	                	    	
            	                	                       	                       	                           	                	   int company_id5 = e5.getCompanyListBean().getCompany_list_id();
            	                	                       	                       	                             				String company_name5 = null;
            	                	                       	                       	                             				if (company_id5 == 1) {
            	                	                       	                       	                             					company_name5 = "SLTL";
            	                	                       	                       	                             				} else if (company_id5 == 2) {
            	                	                       	                       	                             					company_name5 = "SS";
            	                	                       	                       	                             				} else if (company_id5 == 3) {
            	                	                       	                       	                             					company_name5 = "S.HR";
            	                	                       	                       	                             				} else if (company_id5 == 4) {
            	                	                       	                       	                             					company_name5 = "COSMOS";
            	                	                       	                       	                             				} else if (company_id5 == 5) {
            	                	                       	                       	                             					company_name5 = "CSLASER";
            	                	                       	                       	                             				} else if (company_id5 == 6) {
            	                	                       	                       	                             					company_name5 = "SEZ";
            	                	                       	                       	                             				} else if (company_id5 == 7) {
            	                	                       	                       	                             					company_name5 = "CL";
            	                	                       	                       	                             				}else
            	                	                       	                       	                             				if (company_id5 == 8) {
            	                	                       	                       	                             					company_name5 = "App";
            	                	                       	                       	                             				}
            	                	                       	                       	                           	                	    	
            	                	                       	                       	                           	                				List<EmployeeBean> listOfEmployeeInSixthLevelDepartment = loginDAO.getListByDepartmentUnderManagerId(m5,dept_id);
            	                	                       	                       	                           	                				if(listOfEmployeeInSixthLevelDepartment.size() != 0){ // START OF IF FOR SIXTH LEVEL DEPARTMENT
            	                	                       	                       	                           	    	                    %>
            	                	                       	                       	                           	                	    			{
            	                	                       	                       	                           	                	    				text: { name: "<%=e5.getFirstname()+" "+e5.getLastname()+" ("+e0.getRoleBean().getRole_type()+")"%>"},
            	                	                       	                       	                           	                	    				image: "http://192.168.182.104:80/HRMS/img/<%=company_name5%>/<%=e5.getEmployee_code()%>.bmp",
            	                	                       	                       	                           	                	    				HTMLclass: "the-parent_employee",
            	                	                       	                       	                           	                	    				 collapsed: openBranch,
            	                	                       	                       	                           	                	    				
            	                	                       	                       	                           	                	    			},
            	                	                       	                       	                           	                	    	<%}else{%> // END OF IF FOR SIXTH LEVEL DEPARTMENT AND START ELSE FOR SAME IF
            	    				            	                       	                       	                           	                	{
            	    				                       	                       	                           	                	    				text: { name: "<%=e5.getFirstname()+" "+e5.getLastname()+" ("+e5.getRoleBean().getRole_type()+")"%>"},
            	    				                       	                       	                           	                	    				image: "http://192.168.182.104:80/HRMS/imges/<%=company_name5%>/<%=e5.getEmployee_code()%>.bmp",
            	    				                       	                       	                           	                	    			},
            	                	                       	                       	                           	                	    	<%}%> // END OF ELSE FOR IF OF SIXTH LEVEL DEPRTMENT
            	                	                       	                       	                           	                	    	
            	                	                       	                       	                           	                	    	<%}%> // END OF e5
            	                	                    	                    	                             	                        ]
            	                	                    	                    	                             	                        
            	                	                    	                    	                             	                        
            	                	                    	                    	                     	                	    	},
            	                	                    	                    	                     	                	    	<%}%> // END OF sd5
            	                	                    	                    	                     	                	    	]
            	                	                    	                     	                      	                	  	  
            	                	                    	                     	                    	                	  },
            	                	                    	                     	                    	                	 <%}%> // END d5
            	                	                       	                           	                	    				]
            	                       	                       	                           	                	    				
            	                       	                       	                           	                	    				
            	                       	                       	                           	                	    			},
            	                       	                       	                           	                	    	<%}else{%> // END OF IF FOR FIFTH LEVEL DEPARTMENT AND START ELSE FOR SAME IF
				            	                       	                       	                           	                	{
				                       	                       	                           	                	    				text: { name: "<%=e4.getFirstname()+" "+e4.getLastname()+" ("+e4.getRoleBean().getRole_type()+")"%>"},
				                       	                       	                           	                	    			image: "http://192.168.182.104:80/HRMS/imges/<%=company_name4%>/<%=e4.getEmployee_code()%>.bmp",
				                       	                       	                           	                	    			},
            	                       	                       	                           	                	    	<%}%> // END OF ELSE FOR IF OF FIFTH LEVEL DEPRTMENT
            	                       	                       	                           	                	    	
            	                       	                       	                           	                	    	<%}%> // END OF e4
            	                    	                    	                             	                        ]
            	                    	                    	                             	                        
            	                    	                    	                             	                        
            	                    	                    	                     	                	    	},
            	                    	                    	                     	                	    	<%}%> // END OF sd4
            	                    	                    	                     	                	    	]
            	                    	                     	                      	                	  	  
            	                    	                     	                    	                	  },
            	                    	                     	                    	                	 <%}%> // END d4
            	                       	                           	                	    				]	
            	                       	                           	                	    			},	
            	                    	                             	                        <%}else{%>	// END OF IF FOR FOURTH LEVEL DEPARTMENT AND START FOR SAME IF
		            	                    	                             	                       	{
		   	                       	                           	                	    				text: { name: "<%=e3.getFirstname()+" "+e3.getLastname()+" ("+e3.getRoleBean().getRole_type()+")"%>"},
		   	                       	                           	                	    				image: "http://192.168.182.104:80/HRMS/imges/<%=company_name3%>/<%=e3.getEmployee_code()%>.bmp",
		   	                       	                           	                	    				},
            	                    	                             	                        <%}%> // END ELSE FOR FOURTH LEVEL DEPARTMENT IF
            	                    	                             	                        <%}%> // END e3
            	                    	                             	                        
            	                    	                             	                      ]  
            	                    	                             	                        
            	                    	                     	                	    	},
            	                    	                     	                	    	<%}%>// END sd3
            	                    	                     	                	    ]	
            	                     	                      	                	  	  
            	                     	                      	                	  	  
            	                     	                    	                	  },
            	                     	                    	                	  <%}%> // END d3
            	                     	                    	                	  ]
            	                           	                	    				
            	                           	                	    				
            	                           	                	    			},
            	                           	                	    	<%}else{%> // END OF IF FOR THIRD LEVEL DEPARTMENT AND START OF ELSE FOR THIS IF
			            	                           	                	 	{
				                           	                	    				text: { name: "<%=e2.getFirstname()+" "+e2.getLastname()+" ("+e2.getRoleBean().getRole_type()+")"%>"},
				                           	                	    				image: "http://192.168.182.104:80/HRMS/imges/<%=company_name2%>/<%=e2.getEmployee_code()%>.bmp",
				                           	                	    			},
            	                           	                	    	
            	                           	                	    	<%}%> // END OF ELSE FOR THIRD LEVEL DEPARTMENT IF
            	                           	                	    	
            	                           	                	    	<%}%>
            	                             	                       ] 
            	                             	                        
            	                             	                        
            	                     	                	    	},
            	                     	                	    	<%}%> // END OF sd2
            	                     	                	    ]	
            	                      	                	  	  
            	                    	                	  },
            	                    	                	  
            	                    	                	 <%}%>  // END d2
            	                	    				]
            	                	    				
            	                	    			},
            	                	    			<%}else{%> // END OF IF FOR SECOND LEVEL DEPARTMENT AND ELSE FOR THIS IF
            	                	    			{
            	                	    				text: { name: "<%=e1.getFirstname()+" "+e1.getLastname()+" ("+e1.getRoleBean().getRole_type()+")"%>"},
            	                	    				image: "http://192.168.182.104:80/HRMS/imges/<%=company_name1%>/<%=e1.getEmployee_code()%>.bmp",
            	                	    			},	
            	                	    			<%}%> // END OF ELSE FOR SECOND LEVEL DEPARTMENT
            	                	    		<%}%> // END OF e1	
    	                	    				]
            	                        
    	                	    	},
    	                	    	<%}%> // END OF sd1
    	                	    	]
    	                	  },
    	                	  <%}else{ %> // END IF CONDITION FOR SUB DIPARTMENT FIRST LEVEL AND START OF ELSE OF THIS IF
    	                	  {
      	                	  	text: { name: "<%=e0.getFirstname()+" "+e0.getLastname()%>"},
      	                	  	image: "img/user.bmp",
      	                	  },	    	                	  
    	                	  <%}%> // END OF ELSE  FOR SUB DIPARTMENT FIRST LEVEL
    	                	 <%}%> // END d1
    	                	]
    	            },  
    	          
    	            
    	        ]
    	    	
    	        
    	        <%}%> // END e0
    	    }
    	};

    </script>

	<script>
        new Treant( tree_structure );
    </script>
    
    
    
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
</body>
</html>