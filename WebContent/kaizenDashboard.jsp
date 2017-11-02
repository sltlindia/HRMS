<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenProblemIdentificationBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>CI Graph</title>
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
<script type="text/javascript" src="js/canvasjs.min.js"></script>
<script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript"
	src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
	<script src="js/anychart-bundle.min.js"></script>
<link rel="stylesheet" href="css/anychart-ui.min.css" />
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%AllListDAO allListDAO = new AllListDAO();
List<YearBean> listOfYears = allListDAO.getListOfYear();
AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
String year_id = "0";
int listOfPending = 0;
int listOfApproved = 0;
int listOfCategoryA = 0;
int listOfCategoryB = 0;
int listOfCategoryC = 0;
int listOfCategoryAInKaizen = 0;
int listOfCategoryBInKaizen = 0;
int listOfCategoryCInKaizen = 0;

String getYear = "";
if(request.getParameter("year") != null){ 
	getYear = request.getParameter("year");
}

List<String> arrayOfMonth = new ArrayList<>();
List<Integer> arrayOfCI = new ArrayList<>();
List<Integer> arrayOfCost = new ArrayList<>();
List<KaizenBean> listOfQuality = null;
List<KaizenBean> listOfCost = null;
List<KaizenBean> listOfSafety = null;
List<KaizenBean> listOfDelivery = null;
List<KaizenBean> listOfProductivity = null;
List<KaizenBean> listOfCostMonthWise = null;
List<Double> costCount = new ArrayList<>();    
List<Double> implementationcostCount = new ArrayList<>();    
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">CI Status</h3>
				</div>
				</div>
			<form action="kaizenDashboard.jsp">
			<div class="col-md-4 col-lg-4 col-sm-4">
				<select class="form-control" name="year" id="year"
					onchange="response(this.value)">
					<option value="0">--Select Year--</option>
					<%
					
						for (YearBean yearBean : listOfYears) {
							String yearName = yearBean.getYear()+"-"+(Integer.parseInt(yearBean.getYear())+1);
						if(yearName.equalsIgnoreCase(getYear)){
						%>
						
					<option value="<%=yearName%>" selected="selected"><%=yearName%>
					</option>
					<%}else{%>
						<option value="<%=yearName%>"><%=yearName%>
						</option>
					<%}
					}%>
				</select>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary">
			
			</form>
			<%
			if(request.getParameter("year") != null){
			if(request.getParameter("year") != null){ 
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				List<KaizenBean> getListOfAllKiazen = allKaizenListDAO.getListOfKaizenByStatusPending(year1,year2);
				List<KaizenBean> getListOfApproved = allKaizenListDAO.getListOfKaizenByStatusApproved(year1,year2);
				listOfPending = getListOfAllKiazen.size();
				listOfApproved = getListOfApproved.size();
				%>
				<%} %>
				<div class="row">
				<div class="col-lg-6">
				<div class="panel-body">
				<div id="ciStatus"></div>		
			
				</div>	
				</div>
				<div class="col-lg-6">
				
			<%
			if(request.getParameter("year") != null){ 
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				List<KaizenProblemIdentificationBean> getListOfCategoryA = allKaizenListDAO.getListOfProlemIdentificationCategory("A",year1,year2);
				List<KaizenProblemIdentificationBean> getListOfCategoryB = allKaizenListDAO.getListOfProlemIdentificationCategory("B",year1,year2);
				List<KaizenProblemIdentificationBean> getListOfCategoryC = allKaizenListDAO.getListOfProlemIdentificationCategory("C",year1,year2);
				List<KaizenBean> getListOfCategoryAInKaizen = allKaizenListDAO.getListOfProlemIdentificationCategoryInKaizen("A", year1, year2);
				List<KaizenBean> getListOfCategoryBInKaizen = allKaizenListDAO.getListOfProlemIdentificationCategoryInKaizen("B", year1, year2);
				List<KaizenBean> getListOfCategoryCInKaizen = allKaizenListDAO.getListOfProlemIdentificationCategoryInKaizen("C", year1, year2);
				listOfCategoryA = getListOfCategoryA.size();
				listOfCategoryB = getListOfCategoryB.size();
				listOfCategoryC = getListOfCategoryC.size();
				listOfCategoryAInKaizen = getListOfCategoryAInKaizen.size();
				listOfCategoryBInKaizen = getListOfCategoryBInKaizen.size();
				listOfCategoryCInKaizen = getListOfCategoryCInKaizen.size();
				%>
				<%} %>
				<div class="panel-body">
				<div id="problemWiseCIStatus"></div>		
			
				</div>
				</div>
				</div>
				<%
			if(request.getParameter("year") != null){ 
				
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				
				for(int i=4;i<=12;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					List<KaizenBean> getListOfCategoryA = allKaizenListDAO.getListOfImplementedCIByMonth(monthBean.getMonth_id(),year1);
					arrayOfMonth.add(monthBean.getMonth_name());
					arrayOfCI.add(getListOfCategoryA.size());
				}
				
				for(int i=1;i<=3;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					List<KaizenBean> getListOfCategoryA = allKaizenListDAO.getListOfImplementedCIByMonth(monthBean.getMonth_id(),year2);
					arrayOfMonth.add(monthBean.getMonth_name());
					arrayOfCI.add(getListOfCategoryA.size());
				}
				
				%>
					
				
			  
				<%} %>
				<div class="row">
				<div class="col-lg-6">
				<div class="panel-body">
				<div id="monthWiseCIStatus"></div>		
			
				</div>
				</div>
				<%
			if(request.getParameter("year") != null){ 
				
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				
				
				listOfQuality = allKaizenListDAO.getListOfFactors("quality",year1,year2);
				listOfCost = allKaizenListDAO.getListOfFactors("cost",year1,year2);
				listOfSafety = allKaizenListDAO.getListOfFactors("safety",year1,year2);
				listOfDelivery = allKaizenListDAO.getListOfFactors("delivery",year1,year2);
				listOfProductivity = allKaizenListDAO.getListOfFactors("productivity",year1,year2);
				%>
					
				
			  
				<%} %>
				<div class="col-lg-6">
					<div class="panel-body">
				<div id="qcdsp"></div>		
			</div>
				</div>
				</div>
					<%
			if(request.getParameter("year") != null){ 
				
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				

				for(int i=4;i<=12;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					String sum = allKaizenListDAO.getListOfCostByMonth(monthBean.getMonth_id(),year1);
					double finalSum = 0;
					if(sum != null){
						finalSum = Double.parseDouble(sum);
					}
					costCount.add(finalSum);
					
				}
				
				for(int i=1;i<=3;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					String sum = allKaizenListDAO.getListOfCostByMonth(monthBean.getMonth_id(),year2);
					double finalSum = 0;
					if(sum != null){
						finalSum = Double.parseDouble(sum);
					}
					
					costCount.add(finalSum);
				}
				%>
					
				
			  
				<%}%>
				<div class="row">
				<div class="col-lg-2">
				</div>
				<div class="col-lg-6">
				<div class="panel-body">
				<div id="costBenefit"></div>		
			</div>
			</div>
			<div class="col-lg-2">
			</div>
			</div>
			
				<%
			if(request.getParameter("year") != null){ 
				
				 String year = request.getParameter("year");
				String[] split = year.split("-");

				int year1 = Integer.parseInt(split[0]);
				int year2 = Integer.parseInt(split[1]);
				

				for(int i=4;i<=12;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					String sum = allKaizenListDAO.getListOfCostByMonth(monthBean.getMonth_id(),year1);
					String implementationCost = allKaizenListDAO.getListOfImplemetationCostByMonth(monthBean.getMonth_id(),year1);
					double finalSum = 0;
					double finalCostSum = 0;
					
					if(implementationCost != null){
						finalCostSum = Double.parseDouble(implementationCost);
					}
					
					implementationcostCount.add(finalCostSum);
					
				}
				
				for(int i=1;i<=3;i++){
					MonthBean monthBean = allListDAO.getListOfMonthById(i);
					String sum = allKaizenListDAO.getListOfCostByMonth(monthBean.getMonth_id(),year2);
					String implementationCost = allKaizenListDAO.getListOfImplemetationCostByMonth(monthBean.getMonth_id(),year2);
					
					double finalSum = 0;
					double finalCostSum = 0;
					
					
					if(implementationCost != null){
						finalCostSum = Double.parseDouble(implementationCost);
					}
					
					
					implementationcostCount.add(finalCostSum);
				}}
				%>
				<div class="panel-body">
				<div id="compare"></div>		
				</div>
				<%} %>
			</div>
		</div>
</div>
</div>
</section>
</div>
</div>
</div>
	<script type="text/javascript">
 
 FusionCharts.ready(function () {
	    var salesAnlysisChart = new FusionCharts({
	        type: 'pie2d',
	        renderAt: 'ciStatus',
	        width: '476',
	        height: '380',
	        dataFormat: 'json',
	        dataSource: {
	            "chart": {
	                "caption": "",
	                "subCaption": "CI Status",
	                "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
	                "bgColor": "#ffffff",
	                "showBorder": "0",
	                "use3DLighting": "0",
	                "showShadow": "0",
	                "enableSmartLabels": "0",
	                "startingAngle": "0",
	                "showPercentValues": "1",
	                "showPercentInTooltip": "0",
	                "decimals": "1",
	                "captionFontSize": "14",
	                "subcaptionFontSize": "14",
	                "subcaptionFontBold": "0",
	                "toolTipColor": "#ffffff",
	                "toolTipBorderThickness": "0",
	                "toolTipBgColor": "#000000",
	                "toolTipBgAlpha": "80",
	                "toolTipBorderRadius": "2",
	                "toolTipPadding": "5",
	                "showHoverEffect":"1",
	                "showLegend": "1",
	                "legendBgColor": "#ffffff",
	                "legendBorderAlpha": '0',
	                "legendShadow": '0',
	                "legendItemFontSize": '10',
	              
	            },
	            "data": [

   	                {
   	                    "label": "Implemented",
   	                     "value": <%=listOfApproved%>
   	                },
   	                
   	             	{
   	                    "label": "Under Approved",
   	                     "value": <%=listOfPending%>
   	                }
   	              
   	             ]
	        }
	    }).render();
	});
 
 </script>

 
 <script type="text/javascript">
 
 FusionCharts.ready(function () {
    var salesChart = new FusionCharts({
    type: 'MSColumn3D',
    renderAt: 'problemWiseCIStatus',
    width: '476',
    height: '380',
    dataFormat: 'json',
    dataSource: {
        "chart": {
            "caption": "Problem Wise CI Status",
            "subcaption": "CI",
            "yaxismaxvalue": "20",
            "decimals": "0",
            "numberprefix": "",
            "numbersuffix": "",
            "placevaluesinside": "1",
            "rotatevalues": "0",
            "divlinealpha": "50",
            "plotfillalpha": "80",
            "drawCrossLine": "1",
            "crossLineColor": "#cc3300",
            "crossLineAlpha": "100",
            "theme": "zune"
        },
        "categories": [{
            "category": [{
                    "label": "A"
                },
                {
                    "label": "B"
                },
                {
                    "label": "C"
                }
                
            ]
        }],
        
        "dataset": [{
                "seriesname": "Problem Identification",
                "data": [{
                        "value": "<%=listOfCategoryA%>"
                    },
                    {
                        "value": "<%=listOfCategoryB%>"
                    },
                    {
                        "value": "<%=listOfCategoryC%>"
                    }
                  
                ]
            },
            {
                "seriesname": "CI",
                "data": [{
                        "value": "<%=listOfCategoryAInKaizen%>"
                    },
                    {
                        "value": "<%=listOfCategoryBInKaizen%>"
                    },
                    {
                        "value": "<%=listOfCategoryCInKaizen%>"
                    }
                    
                ]
            }
           
        ]
    }
})
    .render();
});
 
 
 </script>
 <script type="text/javascript">
 
 FusionCharts.ready(function(){
	    var salesChart = new FusionCharts({
	        type: 'scrollline2d',
	        dataFormat: 'json',
	        renderAt: 'monthWiseCIStatus',
	        width: '476',
	        height: '380',
	        dataSource: {
	            "chart": {
	                "caption": "Month Wise Implemented CI",
	                "subCaption": "(Implemented CI)",
	                "xAxisName": "Month",
	                "yAxisName": "Implemented CI",
	                "yaxismaxvalue": "15",
	                "showValues": "0",
	                "numberPrefix": "",
	                "showBorder": "0",
	                "showShadow": "0",
	                "bgColor": "#ffffff",
	                "paletteColors": "#008ee4",
	                "showCanvasBorder": "0",
	                "showAxisLines": "0",
	                "showAlternateHGridColor": "0",
	                "divlineAlpha": "100",
	                "divlineThickness": "1",
	                "divLineIsDashed": "1",
	                "divLineDashLen": "1",
	                "divLineGapLen": "1",
	                "lineThickness": "3",  
	                "flatScrollBars": "1",
	                "scrollheight": "10",
	                "numVisiblePlot": "12",
	                "showHoverEffect":"1"
	            },
	            "categories": [
	                {
	                    "category": [
	                    	
	                    	<%if(arrayOfMonth != null){
	                    	for(String month : arrayOfMonth){%>
	                    	{ "label": "<%=month%>" },
	                    	<%}}%>
	                    ]
	                }
	            ],
	            "dataset": [
	                {
	                    "data": [
	                    	<%if(arrayOfCI != null){
	                    	for(Integer size : arrayOfCI){ %>
	                    	{ "value": "<%=size%>" },
	                    	<%}}%>
	                    ]
	                }
	            ]
	        }
	    }).render();
	});
 </script>
 
 <script type="text/javascript">
 FusionCharts.ready(function () {
	    var revenueChart = new FusionCharts({
	        type: 'column3d',
	        renderAt: 'qcdsp',
	        width: '476',
	        height: '380',
	        dataFormat: 'json',
	        dataSource: {
	            "chart": {
	                "caption": "Metric wise CI status",
	                "subCaption": "(KPI)",
	                "xAxisName": "",
	                "yAxisName": "No. Of CI's",
	                "paletteColors": "#0075c2",
	                "valueFontColor": "#ffffff",
	                "yaxismaxvalue": "15",
	                "baseFont": "Helvetica Neue,Arial",
	                "captionFontSize": "14",
	                "subcaptionFontSize": "14",
	                "subcaptionFontBold": "0",
	                "placeValuesInside": "1",
	                "rotateValues": "1",
	                "showShadow": "0",
	                "divlineColor": "#999999",               
	                "divLineIsDashed": "1",
	                "divlineThickness": "1",
	                "divLineDashLen": "1",
	                "divLineGapLen": "1",
	                "canvasBgColor": "#ffffff"
	            },

	            "data": [
	                {
	                    "label": "Quality",
	                    <%if(listOfQuality != null){%>
	                    "value": "<%=listOfQuality.size()%>"
	                    <%}%>
	                },
	                {
	                    "label": "Cost",
	                    <%if(listOfCost != null){%>
	                    "value": "<%=listOfCost.size()%>"
	                    <%}%>
	                },
	                {
	                    "label": "Delivery",
	                    <%if(listOfDelivery != null){%>
	                    "value": "<%=listOfDelivery.size()%>"
	                    <%}%>
	                },
	                {
	                    "label": "Safety",
	                    <%if(listOfSafety != null){%>
	                    "value": "<%=listOfSafety.size()%>"
	                    <%}%>
	                },
	                {
	                    "label": "Productivity",
	                    <%if(listOfProductivity != null){%>
	                    "value": "<%=listOfProductivity.size()%>"
	                    <%}%>
	                }
	               
	            ]
	        }
	    });
	    revenueChart.render();
	});
 </script>
  <script type="text/javascript">
 
 FusionCharts.ready(function(){
	    var salesChart = new FusionCharts({
	        type: 'scrollline2d',
	        dataFormat: 'json',
	        renderAt: 'costBenefit',
	        width: '650',
	        height: '300',
	        dataSource: {
	            "chart": {
	                "caption": "Month Wise",
	                "subCaption": "(Cost Benefit)",
	                "xAxisName": "Month",
	                "yAxisName": "Cost",
	                "yaxismaxvalue": "100000",
	                "showValues": "0",
	                "numberPrefix": "",
	                "showBorder": "0",
	                "showShadow": "0",
	                "bgColor": "#ffffff",
	                "paletteColors": "#008ee4",
	                "showCanvasBorder": "0",
	                "showAxisLines": "0",
	                "showAlternateHGridColor": "0",
	                "divlineAlpha": "100",
	                "divlineThickness": "1",
	                "divLineIsDashed": "1",
	                "divLineDashLen": "1",
	                "divLineGapLen": "1",
	                "lineThickness": "3",  
	                "flatScrollBars": "1",
	                "scrollheight": "10",
	                "numVisiblePlot": "12",
	                "showHoverEffect":"1"
	            },
	            "categories": [
	                {
	                    "category": [
	                    	
	                    	<%if(arrayOfMonth != null){
	                    	for(String month : arrayOfMonth){%>
	                    	{ "label": "<%=month%>" },
	                    	<%}}%>
	                    ]
	                }
	            ],
	            "dataset": [
	                {
	                    "data": [
	                    	<%if(costCount != null){
	                    	for(Double size : costCount){ %>
	                    	{ "value": "<%=size%>" },
	                    	<%}}%>
	                    ]
	                }
	            ]
	        }
	    }).render();
	});
 </script>
 
 
 
 <script type="text/javascript">
 
 
 $(document).ready(function() {
	 netCashFlow();
		
	});


	function netCashFlow(){
		
		// create data set on our data
	    var dataSet = anychart.data.set(getDataNetCashFlow());

	    // map data for the first series, take x from the zero column and value from the first column of data set
	    var seriesData_1 = dataSet.mapAs({x: [0], value: [1]});

	    // map data for the second series, take x from the zero column and value from the second column of data set
	    var seriesData_2 = dataSet.mapAs({x: [0], value: [2]});

	    // map data for the third series, take x from the zero column and value from the third column of data set
	    var seriesData_3 = dataSet.mapAs({x: [0], value: [3]});

	    // create line chart
	    chart = anychart.line();

	    // turn on chart animation
	    chart.animation(true);

	    // set chart padding
	    chart.padding([10, 20, 5, 20]);

	    // turn on the crosshair
	    chart.crosshair()
	            .enabled(true)
	            .yLabel(false)
	            .yStroke(null);

	    // set tooltip mode to point
	    chart.tooltip().positionMode('point');

	    // set chart title text settings
	    chart.title('Benefit vs. Implementation Cost');
	    chart.title().padding([0, 0, 5, 0]);

	    // set yAxis title
	    chart.yAxis().title('AMOUNT');
	    chart.xAxis().labels().padding([5]);

	    // create first series with mapped data
	    var series_1 = chart.line(seriesData_1);
	    series_1.name('Cost Benefit');
	    series_1.hoverMarkers()
	            .enabled(true)
	            .type('circle')
	            .size(4);
	    series_1.tooltip()
	            .position('right')
	            .anchor('left')
	            .offsetX(5)
	            .offsetY(5);

	    // create second series with mapped data
	    var series_2 = chart.line(seriesData_2);
	    series_2.name('Implementation Cost')
	    		.stroke('black');


	    // turn the legend on
	    chart.legend()
	            .enabled(true)
	            .fontSize(13)
	            .padding([0, 0, 10, 0]);

	    // set container id for the chart and set up paddings
	    chart.container('compare');

	    // initiate chart drawing
	    chart.draw();
		
	}
	function getDataNetCashFlow() {
		
	    return [
	    	<%
	    	if(implementationcostCount.size() != 0){
	    	for(int w=0;w<12;w++){
	    	%>
	    		["<%=arrayOfMonth.get(w)%>",<%=costCount.get(w)%>,<%=implementationcostCount.get(w)%>],
	    	<%}}%>
	    	]
	}
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