<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<style type="text/css">
    body {
        margin : 40px 10px;
        padding : 0;
        font-family : "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size : 14px;
    }

    #calendar {
        max-width : 900px;
        margin : 0 auto;
    }

    .fc-day-number.fc-sat.fc-past { color:#0000FF; }
    .fc-day-number.fc-sun.fc-past { color:#FF0000; }
</style>
<script type="text/javascript">
    var jsonData;
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
	
    jQuery(document).ready(function() {
			jsonData = null;
			$.ajax({
			  	  type : 'POST',
			        data : 'S',
			        url : "/portal/P1/P1AjaxList.do",
			        processData : false,
			        contentType: false,
				  	success : function(data) {
			  		setCalendar(data);
			     }
			    , error : function(request, status, error) {
			    alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
			    }		     
	 	    });
		
		function setCalendar(data){
			 jsonData = JSON.stringify(data);
			 var calendar = $('#calendar').fullCalendar({
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					lang : "ko",
					selectable: false,
					selectHelper: false,
		/* 			select: function(start, end, allDay) {
						
						var title = prompt('일정을 입력하세요.');
						if (title) {
						
							calendar.fullCalendar('renderEvent',
								{
									title: title,
									start: start,
									end: end,
									allDay: allDay
								},
								true // make the event "stick"
							);
						}
						calendar.fullCalendar('unselect');
						
					}, */
					editable: false,
					events: eval(jsonData)      
						/* 					[
						{
							title: '여름 휴가',
							start: '20190301',
							end:   '20190305'
							
						},
					{
							title: '02 Long Event',
							start: new Date(y, m, d-5),
							end: new Date(y, m, d-2)
						},
						{
							id: 999,
							title: '03 Repeating Event',
							start: new Date(y, m, d-3, 16, 0),
							allDay: false
						},
						{
							id: 999,
							title: '04 Repeating Event',
							start: new Date(y, m, d+4, 16, 0),
							allDay: false
						},
						{
							title: '05 Meeting',
							start: new Date(y, m, d, 10, 30),
							allDay: false
						},
						{
							title: '06 Lunch',
							start: new Date(y, m, d, 12, 0),
							end: new Date(y, m, d, 14, 0),
							allDay: false
						},
						{
							title: '07 Birthday Party',
							start: new Date(y, m, d+1, 19, 0),
							end: new Date(y, m, d+1, 22, 30),
							allDay: false // 주간의 나타남, true 나타나지않음
						},
						{
							title: '08 Click for Google',
							start: new Date(y, m, 28),
							end: new Date(y, m, 29),
							url: 'http://google.com/'
						} 
					]*/
				});    
		}
		
	        
	    
    });  
</script>
<style>
	.fc table{
	width :1000px;
	}
	::-webkit-scrollbar {
	
	display:none;
	
	}
</style>
<div class="row">	
	<div class="col-md-11 col-lg-8">
		<div class="panel">			
			<div class="panel-body">
				<div>
			   		<div id="calendar"></div>			   		
			   	</div>	
			</div> 					
		</div>		
	</div>
</div>
