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
				selectHelper: true,
				select: function(start, end, allDay) {
					
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
					
				}, 
				editable: false,
				events: eval(jsonData)    
			});    
	}
    jQuery(document).ready(function() {
			jsonData = null;
			$.ajax({
			  	  type : 'POST',
			        data : 'w',
			        url : "/portal/P2/P2AjaxList.do",
			        processData : false,
			        contentType: false,
				  	success : function(data) {
			  		setCalendar(data);
			     }
			    , error : function(request, status, error) {
			    alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
			    }		     
	 	    });
		
		
		
	        
	    
    }); 
    $(function() {
    	$("#CreateSchedule").on("click",function(){
		  var formData = $("#Schedule").serialize();
     	  $.ajax({ 
		     		 	type : "POST",
						url : "/portal/P2/P2SaveList.do",
						cache : false,
						data : formData,	          
   					    success : function(data) {
   				    	   if(JSON.parse(data).success = true){
   				    		location.reload();
   				    		 
   				    	   }else{
   				    		   alert(JSON.parse(data).msg);
   				    	   }
   					    },
   				       error : function(request,status,error,data) {	  
   				    	   alert(request+status+error+"="+data);
   				    	 
   				       }	       
   				   }); 
   			});
		});
    
</script>
<style>
	.row{
	    MARGIN-TOP: -80PX;
	    margin-left: -20px;
	    margin-right: -90PX;
	}
</style>
<section>
<div class="row">	
	<div class="col-md-11 col-lg-8">
		<div class="panel">			
			<div class="panel-body">
				
				
				<div>
			   		<div id="calendar" name ="calendar"></div>
			   					   		
			   	</div>	
			</div> 					
		</div>		
	</div>
</div>

</section>
