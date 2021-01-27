<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8"/>
		<title>Ajax Test01</title>
		<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript">
		   /*
		   $(document).ready(function(){
		   });*/
		   
		   $(function(){                        
			   //$("#searchOk01").on("click", function(){  		/*     번호: <input type="text" name="seq" id="seq"/>   ==  $("#seq") 으로 받아온다. */
			   $("#seq").on("keyup", function(){           		 /* on keyup을 할 때, function을 실행해라 */
				   $.ajax({										/*  $.ajax({ JQuery의 메서드이다. $.post 등 */     /* $.post (JQuery) $("#") (Element) */
					   url: "../ajax01/search01.do", 		/* 모두 객체이다.  자바스크립트는 var obj = {} key/value값 한 쌍으로 만들어진다. var car = {model:"500", color:"white"} */ 
					   type: "GET",						/*   자바스크립트 -> var v = document.getElementByld("seq").value; == 제이쿼리 -> $("#seq");  */
					   data: { seq: $("#seq").val()},    /* , , ,객체기때문에 여러개를 만들 수 있다. 위에도객체 이것도객체 */
					   success: function(responseData){ /* function도 value값이 될 수 있다. success 4번 / 200번 나오면 ~ 수행하시오 , success: function(data) alert(data; console.log(data);}; erro: fuction(data)..*/
						  //var jsObj = JSON.parse(responseData); //JSON 데이터를 JSObj객체로 변환해주는 메서드 parse !! jQuery 버젼을 올려서 필요 없음
                          if(!responseData){
							  //alert("존재하지 않는 seq 임");
							  return false;
						  }						/* 	t JS<=JSON으로 바꿔줘야한다. JSON 데이터타입 6가지가있다.(VELOG) */
						  var html= "";				/* JAVASCRIPT 데이터를 [  ...  ] 대괄호로 한다. */  /* 한결같이  더블쿼테이션이 다있다. JSON 은 ! */
						  html += "<form id='ajax'>";
						  html += "번호 <input name='seq' value='"+responseData.seq+"'>";
						  html += "이름 <input name='name' value='"+responseData.name+"'>";
						  html += "주소 <input name='addr' value='"+responseData.addr+"'>";
						  html += "날짜 <input name='rdate' value='"+responseData.rdate+"'>";
						  html += "</form>";
						  $("#name").val("");
						  
						  $("#container").html(html);
					   }
				   });
			   });
			   
			   $("#searchOk02").on("click", function(){
				   $.ajax({
					   url: "../ajax01/search02.do",
					   type: "POST",
					   data: { name: $("#name").val()},
					   success: function(responseData){
						  //var jsObj = JSON.parse(responseData); //jQuery 버젼을 올려서 필요 없음
                          if(!responseData){
							  //alert("존재하지 않는 name 임");
							  return false;
						  }
						  var html= "";
						  html += "<table border='1' width='50%'>";
						  html += "<tr>";
						  html += "<th>번호</th>";
						  html += "<th>이름</th>";
						  html += "<th>주소</th>";
						  html += "<th>날짜</th>";
						  html += "</tr>";
						
						  if(responseData.length != 0){
							  for(var i=0; i<responseData.length; i++){
								  html += "<tr>";
								  html += "<td align='center'>"+responseData[i].seq+"</td>";
								  html += "<td align='center'>"+responseData[i].name+"</td>";
								  html += "<td align='center'>"+responseData[i].addr+"</td>";
								  html += "<td align='center'>"+responseData[i].rdate+"</td>";
								  html += "</tr>";
							  }
						  }else{
							  html += "<tr>";
							  html += "<td colspan='4' align='center'>그런 이름을 가진 사람 없음</td>";
							  html += "</tr>";
						  }
						  html += "</table>";
						  $("#seq").val("");
						  
						  $("#container").html(html);
					   }
				   });
			   });
		   });
		</script>
	</head>
	<body>
	    <center>
	    <h2>(방법1) response객체에 JSON문자열 담기</h2>
	    
	    번호: <input type="text" name="seq" id="seq"/>
	    <input type="button" value="번호 검색" id="searchOk01"/>
	    <br/>
	    
	    이름: <input type="text" name="name" id="name"/>
	    <input type="button" value="이름 검색" id="searchOk02"/>
	 
        <br/><br/>
		<div id="container"></div>
		<br/><br/>
		
		<a href="../">인덱스</a><br/><br/>
		</center>
	</body>
</html>