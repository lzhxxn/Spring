<!doctype html>
<html>
 <head>
  <meta charset="utf-8">
  <title>AjaxReview</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
  <body>
  <button type="button">Click Me!</button>
  <div id="text"></div>
<script>
 $(function(){
  $("button").click(function(){
   $.ajax({
    url: "ajax/xxx.do", // client will send request URL addr
    data: { name:"이지훈", age:27 }, // http 요청과 함께 서버로 보낼 Data
    type: "POST", // http 요청방식 GET & POST
    dataType: "json", //
    /*success: function(json){
     $("<h1>").text(json.title).appendTo("body");
     $("<div class=\"content\">.html(json.html).appendTo("body");
     }*/
    })
    .done(function(json){
     $("<h1>").text(json.title).appendTo("body");
     $("<div class=\"content\">.html(json.html).appendTo("body");
    })
    .fail(function(xhr, status, errorThrown){
     $("#text").html("오류가 발생했습니다.<br>").append("오류명: " + errorThrown + "<br>").append("상태: " + status);
    })
    .always(function(xhr, status){
     $("#text").html("요청이 완료되었습니다!");
     
     });
     }
     });
     </script>
    </body>
   </html>