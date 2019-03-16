/**
 * 공통 회원가입 
 */
  $(function() {
	  $("#idCheck").on("click",function(){
		  if($("#id").val() != ""){
		  var loginVo = { id: $("#id").val()};
		  $.ajax({ 
				async: true,
				type : 'POST',	     
				method: "json",
				data : JSON.stringify(loginVo),  
				url : "/portal/common/idCheck.do",
				contentType: "application/json; charset=UTF-8",	       
			    success : function(data) {
			    	   if(JSON.parse(data).success = true){
			    	  	   $("#errorId").html("<font color=blue>"+JSON.parse(data).msg+"</font>");
			    	   }else{
			    		   $("#errorId").html("<font color=red>"+JSON.parse(data).msg+"</font>"); 
			    	   }			    	   
			    },
		       error : function(request,status,error,data) {	  
		    	   alert(request+status+error+"="+data);
		    	 
		       }	       
		   });
		  }else{
				  alert("id NULL입니다");
		  }
	  });
	  $("#emailCheck").on("click",function(){
		  if($("#email").val() != ""){
		  var loginVo = { email: $("#email").val()};
		  $.ajax({ 
				async: true,
				type : 'POST',	     
				method: "json",
				data : JSON.stringify(loginVo),  
				url : "/portal/common/emailCheck.do",
				contentType: "application/json; charset=UTF-8",	       
			    success : function(data) {
		    	   if(JSON.parse(data).success = true){
		    	  	   $("#errorEmail").html("<font color=blue>"+JSON.parse(data).msg+"</font>");
		    	   }else{
		    		   $("#errorEmail").html("<font color=red>"+JSON.parse(data).msg+"</font>"); 
		    	   }
			    },
		       error : function(request,status,error,data) {	  
		    	   alert(request+status+error+"="+data);
		    	 
		       }	       
		   });
		  }else{
			  alert("이메일 NULL입니다");
		  }   
	  });
	  
  });