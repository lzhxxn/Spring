<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>Sp03 index</title> 
		
	</head>
	<body>
		<div style="text-align:center">

		  <!--  <p>
		  		   <h1>Sp02 index</h1>
		   	  <a href="address/list.do">주소록</a>(with JDBC)<br/>
		   	  <a href="board/list.do">게시판</a>(with JDBC)<br/><br/>
		   	 
		   	  <a href="address1/list.do">주소록(1)</a>(with MyBatis)<br/>
		   	  <a href="address2/list.do">주소록(2)</a>(with MyBatis - another Mapper)<br/>
		   	  <a href="board1/list.do?cp=1&ps=5">게시판(1)</a>(with MyBatis)<br/>
		   	  <a href="file/list.do">파일폼</a><br/>
		   </p> -->
		   
		   
		   	 <h1>Sp03 index AJAX</h1>
		   	 <h3>Ajax</h3>
		   	 <a href ="ajax/test01.do">Ajax01</a>&nbsp;&nbsp;<br>
			 <a href ="ajax/test02.do">Ajax02</a>&nbsp;&nbsp;<br>
 		     <a href ="ajax/test03.do">Ajax03</a>&nbsp;&nbsp;<br>
   			 <a href ="ajax/test04.do">Ajax04</a>&nbsp;&nbsp;<br>
   			 
   			 <h3>RestFul 구축</h3>
   			 <a href ="rest/getText">getText</a>&nbsp;&nbsp;<br>   <!--  // 확장자가없다  -->
   			 <a href ="rest/getAddress.xml">getText</a>XML&nbsp;&nbsp;<br>
   			 <a href ="rest/getAddress.json">getText</a>JSON&nbsp;&nbsp;<br>
   			 <a href ="rest/getList.xml">getList</a>XML&nbsp;&nbsp;<br>
   			 <a href ="rest/getList.json">getList</a>JSON&nbsp;&nbsp;<br>
   			 <a href ="rest/getMap.xml">getMap</a>XML&nbsp;&nbsp;<br>
   			 <a href ="rest/getMap.json">getMap</a>JSON&nbsp;&nbsp;<br>
   			 <br/>
   			 
   			 <a href ="rest/check?height=180&weight=80">check</a>XML&nbsp;&nbsp;<br>    <!--  // XML 생략가능  -->
   			 <a href ="rest/check.json?height=140&weight=45">check</a>JSON&nbsp;&nbsp;<br>
   			 <a href="rest/product/bag/001">product/bag/001</a>(xml) &nbsp;&nbsp;<br> 
		  	 <a href="rest/product/bag/002.json">product/bag/002.json</a>(json) &nbsp;&nbsp;<br>  
		  	 <br/> 
		    
		     <a href="ajax/requestbody.do">requestbody.do</a><br>
		     <br/>
		     
		      <h3>Ajax 응용</h3>
		      <!-- <a href="file/form_dd.do">Drag&Drop</a> &nbsp;&nbsp;<br>   -->
		      <a href="file/list.do">파일리스트</a><br>&nbsp;&nbsp;
		      <a href="chart/chart.do">Google Chart</a><br>&nbsp;&nbsp;    
		      <a href="auto/auto.do">자동완성기능</a><br>&nbsp;&nbsp;    
		      
		     
	</body>
</html>

