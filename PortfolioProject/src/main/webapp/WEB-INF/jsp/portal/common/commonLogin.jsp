<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 //[뒤로가기]버튼으로 보지 못하도록, no-cache로 설정
 response.setDateHeader("Expires", 0);
 response.setHeader("Pragma", "no-cache");
 if (request.getProtocol().equals("HTTP/1.1")) {
  response.setHeader("Cache-Control", "no-cache");
 }
 //※ 이 기능은 전송방식이 POST인 경우에만 사용할 수 있다.
 //GET방식으로 전송한 경우에는 아 무 효력 없이 모든 페이지가 노출된다.
%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Quirk Responsive Admin Templates</title>
  <link rel="stylesheet" href="/lib/fontawesome/css/font-awesome.css">
  <link rel="stylesheet" href="/css/quirk.css">
  <!-- 카카오톡 -->
  <script src="https://developers.kakao.com/sdk/js/kakao.min.js">
  <!-- 카카오톡 -->
  <script src="/lib/modernizr/modernizr.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
</head>
  <script language="JavaScript" type="text/JavaScript">
  $(document).ready(function(){
	  $("#login").on("click",function(){
		  if($("#id").val() != "" && $("#pwd").val() != "" ){
				$("#form").attr("method", "post").attr("action", "/portal/common/LogOnSite.do").submit();
		  }else{
			  alert("Type 골라주세요");
		  }
	  });
	  
	  $("#join").on("click",function(){
		  $("#form").attr("method", "GET").attr("action", "/portal/common/joinAction.do").submit();
	  });

    });

  </script>
<body class="signwrapper">

  <div class="sign-overlay"></div>
  <div class="signpanel"></div>

  <div class="panel signin">
    <div class="panel-heading">
      <h1>Edu</h1>
      <h4 class="panel-title">Welcome! Please signin.</h4>
       <h4 class="panel-title">${error}</h4>
    </div>
    <div class="panel-body">
      <form id="form" name="form">
        <div class="form-group mb10">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input type="text" class="form-control" id="id" name="id"placeholder="Enter UserId">
          </div>
        </div>
        <div class="form-group nomargin">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password">
          </div>
        </div>
        <br/>
        <div class="form-group">
          <input type="button" class="btn btn-quirk btn-block" id="login" name="login" value="Login">
          <button id="join" class="btn btn-quirk btn-block">Join in</button>
        </div>
      </form>
      <hr class="invisible">
    </div>
  </div><!-- panel -->

</body>
</html>