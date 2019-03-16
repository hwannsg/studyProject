<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
/**
 * ========================================================
 * 주시스템    : plas
 * 서브시스템  : portal
 * 프로그램명  : Layout
 * 설명 	   : Layout 페이지
 * 작성자      : 황승국
 * 작성일      : 2018.10.29.
 * ========================================================
 * 수정자/수정일 :
 * 수정사유/내역 : 
 * ========================================================
 */
%>
<html>
<head>

<link rel="stylesheet" href="/lib/Hover/hover.css">
<link rel="stylesheet" href="/lib/fontawesome/css/font-awesome.css">
<link rel="stylesheet" href="/lib/weather-icons/css/weather-icons.css">
<link rel="stylesheet" href="/lib/ionicons/css/ionicons.css">
<link rel="stylesheet" href="/lib/jquery-toggles/toggles-full.css">
<link rel="stylesheet" href="/lib/morrisjs/morris.css">
<link rel="stylesheet" href="/css/quirk.css">
<script src="/lib/modernizr/modernizr.js"></script>
<script src="/lib/jquery/jquery.js"></script>
<script src="/lib/jquery-ui/jquery-ui.js"></script>
<script src="/lib/bootstrap/js/bootstrap.js"></script>
<script src="/lib/jquery-toggles/toggles.js"></script>

<script src="/lib/morrisjs/morris.js"></script>
<script src="/lib/raphael/raphael.js"></script>

<script src="/lib/flot/jquery.flot.js"></script>
<script src="/lib/flot/jquery.flot.resize.js"></script>
<script src="/lib/flot-spline/jquery.flot.spline.js"></script>

<script src="/lib/jquery-knob/jquery.knob.js"></script>

<script src="/js/quirk.js"></script>
<script src="/js/dashboard.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<link href="/fullcalendar/fullcalendar.css" rel="stylesheet"/>
<link href="/fullcalendar/fullcalendar.print.css" rel="stylesheet" media="print"/>
<script type="text/javascript" src="/fullcalendar/lib/moment.min.js"></script>
<script type="text/javascript" src="/fullcalendar/lib/jquery.min.js"></script>
<script type="text/javascript" src="/fullcalendar/fullcalendar.js" charset="euc-kr"></script>
<script type="text/javascript" src="/fullcalendar/lang-all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<tiles:insertAttribute name="header" />
</head>
<body>
	<!--  -->
	<tiles:insertAttribute name="left" />
	<div>
		<div class="mainpanel">
			<div class="contentpanel">
			</div>
			<div class="contentpanel">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>

</body>	

</html>