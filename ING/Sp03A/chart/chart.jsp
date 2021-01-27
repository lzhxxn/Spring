<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Google Chart API</title>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
function ajaxData() {
	$.ajax({
		url: './chartData',
		dataType: "json",
		type: 'post',
		async: false,
		success: function(list) {
			google.charts.load('current', {'packages':['corechart']});
			google.charts.setOnLoadCallback(drawChart);
			function drawChart() {
				var dataChart = [['Task', 'Hours per Day']];
				if(list.length != 0) {
					$.each(list, function(i, item){
						dataChart.push([item.item, item.number]);
					});
				}else {
					dataChart.push(['입력해주세요', 1]);
				}
				var data = google.visualization.arrayToDataTable(dataChart);
				var view = new google.visualization.DataView(data);
				var options = {
						title: "제목",
						width: 900, // 넓이 옵션
						height: 200, // 높이 옵션
				};
				var chart1 = new google.visualization.PieChart(
						document.getElementById('piechart'));
				var chart2 = new google.visualization.LineChart(
						document.getElementById('linechart'));
				var chart3 = new google.visualization.BarChart(
						document.getElementById('barchart'));
				var chart4 = new google.visualization.ColumnChart(
						document.getElementById('columnchart'));
				
				chart1.draw(view, options);
				chart2.draw(view, options);
				chart3.draw(view, options);
				chart4.draw(view, options);
			}
		}
	});
}
$(document).ready(function(){
	ajaxData();
});
</script>
</head>
<body>
    <center>
        <h1>Google Chart</h1> 
        <input type="button" value="데이터호출" onclick="ajaxData()"/>
        &nbsp;&nbsp;
	    <a href="../">인덱스</a>
	    <br/><br/>
	   
		<div id="piechart"></div>
		<div id="linechart"></div>
		<div id="barchart"></div>
		<div id="columnchart"></div>
		
	</center>
</body>
</html>
