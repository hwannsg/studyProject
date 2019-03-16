/**
 * 공통 left.js
 */
  $(function() {
	  $("#userlogOut").on("click",function(){
		  $("#form").attr("method", "post").attr("action", "/portal/common/logoutAction.do").submit();
	  });

	  $("#p2000").on("click",function(){
		  $("#form").attr("method", "post").attr("action", "/portal/P2/P2Action.do").submit();
	  });
	  $("#p3000").on("click",function(){
		  $("#form").attr("method", "post").attr("action", "/portal/P1/P1Action.do").submit();
	  });

  });