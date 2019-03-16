<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script language="JavaScript" type="text/JavaScript">
 	$(function() {	

		$("#goHome").on("click",function(){
			$("#form").attr("method", "get").attr("action", "/").submit();
		});
		
		$("#searchValue").on("click",function(){	
			if($("#searchList").val() != "" && $("#searchText").val()){
				$("#form").attr("method", "post").attr("action", "/portal/common/commonSearch.do").submit();				
			}else{
				alert("카테고리를 선택 부탁");
			}
		});
		
		
		
		
	});
</script> 
<header>
  <div class="headerpanel">
    <div class="logopanel">
      <h2 id="goHome"><a>EduCation</a></h2>
    </div><!-- logopanel -->

    <div class="headerbar">

      <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
	  <form id= "form" name ="form">
      <div class="searchpanel">
        <div class="input-group">

           <span class="input-group-btn" >
             <select class="form-control" id="searchList" name="searchList" style ="width: 100px">
				<option value="">선택 </option>
				<option value="1">강좌</option>
				<option value="2">선생님+과목</option>
			</select>
			</span>
			<input type="text" class="form-control" placeholder="Search for." id="searchText" name ="searchText">
			<span class="input-group-btn" >
            <button class="btn btn-default" type="button"  id="searchValue" ><i class="fa fa-search"></i></button>
          	</span>
        </div><!-- input-group -->
      </div>
	  </form>
      
    </div><!-- headerbar -->
  </div><!-- header-->