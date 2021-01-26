<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>Sp02 index</title> 
		
	</head>
	<body>
		<div style="text-align:center">
		   <h1>Sp02 index</h1>
		   <p>
		   	  <a href="address/list.do">주소록</a>(with JDBC)<br/>
		   	  <a href="board/list.do">게시판</a>(with JDBC)<br/><br/>
		   	 
		   	  <a href="address1/list.do">주소록(1)</a>(with MyBatis)<br/>
		   	  <a href="address2/list.do">주소록(2)</a>(with MyBatis - another Mapper)<br/>
		   	  <a href="board1/list.do?cp=1&ps=5">게시판(1)</a>(with MyBatis)<br/>
		   	  <a href="file/list.do">파일폼</a><br/>
		   </p>
		</div>
	</body>
</html>

