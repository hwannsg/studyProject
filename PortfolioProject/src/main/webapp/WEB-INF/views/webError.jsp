<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

    <title>ATNS IoT Service - Web Error <c:out value="${statusCode}"/></title>
    <style>
	.content{
		background-color:#fbfbfc; 
		box-shadow:0px 1px 15px 0px rgba(15,38,70,0.1); 
		height:100%;
	}
	
	.content .content-inner{
			height:100%;
	}
	
	.cn{
		display: flex;
		justify-content: center;
		align-items: center;
		height:100%;
	}
	
	.elem-error{
		display:block;
		margin:10px;
	}
	
	#error-box{
		padding:300px;
		background-color:#fff;
		border:2px solid red;
	}
	
	#error-box > *{
		display:block;
		
	}
	
	h1{
		margin: 10px 0 10px;
	}
	
	i{
		margin:2px;
	}
	
	.fa-warning{
		color:red;
	}
	</style>
</head>

<body>
	<div id="wrap" class='content auto-wrap '>
		<div class='content-inner cn'>
			<div id='error-box'>
				<h1 class='h1-type ac'><i class="fa fa-fw fa-warning"></i></h1>
				<h1 class='h1-type ac'>Page access Error</h1>
				<h2 class='h2-type1 '>Web Error Code : <%=request.getAttribute("javax.servlet.error.status_code") %></h2>
				<div class='elem-error'>
					요청 주소:<br/><%=request.getAttribute("javax.servlet.error.request_uri") %>
				</div>
				<div class='elem-error'>
					<span class="btn btn-type1 btn-block btn-xl" onclick="location.href = '/';"><i class="fa fa-home"></i> 홈으로</span>
				</div>
			 </div>
		</div>
	</div>
</body>

</html>