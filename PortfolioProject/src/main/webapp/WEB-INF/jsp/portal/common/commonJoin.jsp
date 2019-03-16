<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Quirk Responsive Admin Templates</title>
  <link rel="stylesheet" href="/lib/fontawesome/css/font-awesome.css">
  <link rel="stylesheet" href="/css/quirk.css">
  <script src="/lib/modernizr/modernizr.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="/javaScriptFile/commonResist.js"></script>
</head>
<script>
$(function() {
$("#Regist").on("click",function(){
/* 	  if($("#id").val() != "" && $("#email").val() != "" && $("#pwd").val() != "" && $("#name").val() != "" && $("#subject").val() != "" && $("#grade").val() != ""){
	 */	  var formData = new FormData($("#joinForm")[0]);  
		  $.ajax({ 
			  	type : 'POST',
	            data : formData, 
				url : "/portal/common/joinSite.do",
				processData : false,
	            contentType: false,	          
			    success : function(data) {
		    	   if(JSON.parse(data).success = true){
		    	  	   alert(JSON.parse(data).msg);
		    	   }else{
		    		   alert(JSON.parse(data).msg);
		    	   }
			    },
		       error : function(request,status,error,data) {	  
		    	   alert(request+status+error+"="+data);
		    	 
		       }	       
		   });
/* 	  
	  }else{
		  alert("다시 한번 확인 부탁드립니다.");
	  } */
	});
});
</script>
<body class="signwrapper">

  <div class="sign-overlay"></div>
  <div class="signpanel"></div>

  <div class="panel signin">
    <div class="panel-heading">
      <h1>HR join Page</h1>
      <h4 class="panel-title">회원가입창</h4>
     
    </div>
    <div class="panel-body">
      <form id="joinForm" name="joinForm"> 
        <input type ="hidden" id ="userType" name ="userType" value="${type}">
        <div class="form-group">
          <input type ="text" id ="id"name ="id" class="btn btn-quirk btn-block" placeholder ="input your id"/>
          <div id="errorId"></div>
          <br/>
          <input type ="button" id ="idCheck"name ="idCheck" class="btn btn-quirk btn-block" value = "id check">
          <br/>
          <input type ="password" id ="pwd"name ="pwd" class="btn btn-quirk btn-block" placeholder ="input your pwd"/>
          <br/>
          <input type ="text" id ="name"name ="name" class="btn btn-quirk btn-block" placeholder ="input your name"/>
          <br/>
          <input type ="text" id ="email"name  ="email" class="btn btn-quirk btn-block" placeholder ="input your email"/> 
          <div id="errorEmail"></div>         
          <br/>
          <input type ="button" id ="emailCheck"name ="emailCheck" class="btn btn-quirk btn-block" value = "email check">
          <br/>
          <input type ="text" id ="age"name  ="age" class="btn btn-quirk btn-block" placeholder ="19940611"/>
          <br/>
		  <select class="form-control" name="subject" id ="subject">
				<option value="">Choose a Job</option>
				<c:forEach items="${Data}" var="list" varStatus="status">
					<option value="${list.CODE}">${list.NAME}</option>
				</c:forEach>
		  </select>
		  <br/>
          <select class="form-control" name="grade" id = "grade">
				<option value="">Choose a level</option>
				<option value="1">사원</option>
				<option value="2">대리</option>
				<option value="3">과장</option>
				<option value="4">차장</option>
				<option value="5">부장</option>
				<option value="6">이사</option>
		  </select>
		  <br/>
		   <input type ="button" id ="Regist"name ="Regist" class="btn btn-quirk btn-block" value = "Regist" >
		   <!--  disabled="" -->
        </div>
      </form>
      <hr class="invisible">
    </div>
  </div><!-- panel -->

</body>
</html>