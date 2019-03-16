<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/datePicker/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/datePicker/bootstrap-datepicker.kr.js" type="text/javascript"></script>
<script type="text/javascript" src="/javaScriptFile/commonLeft.js"></script>
</head>

<script>
$(document).ready(function() {
	
	$("#workTimeSearch").on("click",function(){
		 var defaultData = new Date();
		 //$('#userDate').datepicker({format:"yyyy-mm-dd"}).datepicker("setDate",defaultData );
		 var userDate = $("#userDate").val();
		 $.ajax({ 
           async: true,
           type : 'POST',
           data : userDate,
           url : "/portal/login/mainworkTimeSearch.do",
           dataType : "json",
           contentType: "application/json; charset=UTF-8",    
		    success : function(data) {
		    		var html = "";
		    		var a = 0;
		    		if(data.data.length > 0){
		    		for(var i =0; i<data.data.length -1 ;i++){
		    			html +="<tr data-dismiss='modal'>";
		    			html +="<td>";
		    			html += i+1;
		    			html +="</td>";
		    			html +="<td>";
		    			html += data.data[i].user_date;				    			
		    			html +="</td>"
		    			html +="<td>";
		    			html += data.data[i].min;
		    			html +="</td>"
		    			html +="<td>";
		    			html += data.data[i].max;
		    			html +="</td>"
		    			html +="<td>";
		    			html += data.data[i].to_char;
		    			html +="</td>"
		    			html +="</tr>";
		    		}
		    		var test = data.data.length - 1;
		    		var test123 = data.data[test].total;
		    		html +="<tr data-dismiss='modal'>";
		    		html +="<td colspan = "+4+">";
	    			html +="총 근무시간";
	    			html +="</td>"
	    			html +="<td>";
	    			html += test123;
	    			html +="(";
	    			html += data.data[test].text;
	    			html +=")"
	    			html +="</td>";
		    		html +="</tr>";
		    		}else{
		    			html +="<tr data-dismiss='modal'>";
			    		html +="<td colspan = "+5+">";
		    			html +="데이터가 존재하지 않습니다.";
		    			html +="</td>"
			    		html +="</tr>";
		    		}	
		    		$("#workTimeArea").html(html);
		    },
	       error : function(request,status,error) {	                
	       	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }	       
	   });
	});

		  //학생 메뉴 바

	  });
</script>
<section> 
	<form id="form" name="form">
	
	</form>
 	<div class="leftpanel">
    <div class="leftpanelinner">


      <div class="media leftpanel-profile">
        <div class="media-left">
          <a href="#">
          </a>
        </div>
        		<%
			String joinDate ="";
        	joinDate = (String)session.getAttribute("joinDate");
        	
			String dpCode ="";
			dpCode = (String)session.getAttribute("dpCode");
			
			String EMAIL ="";
			EMAIL = (String)session.getAttribute("EMAIL");
			
			String NAME ="";
			NAME = (String)session.getAttribute("NAME");
			
			String level ="";
			level = (String)session.getAttribute("level");
			
		%>
        <div class="media-body">
          <h4 class="media-heading"><%=NAME %>-<%=level %><a data-toggle="collapse" data-target="#loguserinfo" class="pull-right"><i class="fa fa-angle-down"></i></a></h4>
          <span><%=dpCode %></span>
        </div>
      </div><!-- leftpanel-profile -->

      <div class="leftpanel-userinfo collapse" id="loguserinfo">
        <h5 class="sidebar-title">Adress</h5>
        <address>
                          우편번호: 03048 
			주소: 서울특별시 종로구 청와대로 1 
        </address>    
        <h5 class="sidebar-title">요약</h5>
        <ul class="list-group">
		  <li class="list-group-item">
            <label class="pull-left">과목</label>
            <span class="pull-right">z</span>
          </li>
          <li class="list-group-item">
            <label class="pull-left">Email</label>
            <span class="pull-right">Z</span>
          </li>
          <li class="list-group-item">
            <label class="pull-left">userID</label>
            <span class="pull-right">zz</span>
          </li>
          <li class="list-group-item">
            <label class="pull-left">근무시간 체크</label>
            <div class="social-icons pull-right">
              <a><i></i></a>
              <a><i class="glyphicon glyphicon-user"   data-toggle="modal" data-target="#workTime"></i></a>
              <a><i></i></a>
            </div>
          </li>
        </ul>
      </div><!-- leftpanel-userinfo -->

      <ul class="nav nav-tabs nav-justified nav-sidebar">
        <li class="tooltips active" data-toggle="tooltip" title="Main Menu"><a data-toggle="tab" data-target="#mainmenu"><i class="tooltips fa fa-ellipsis-h"></i></a></li>
        <li class="tooltips unread" data-toggle="tooltip" title="Check Mail"><a data-toggle="tab" data-target="#emailmenu"><i class="tooltips fa fa-envelope"></i></a></li>
        <li class="tooltips" data-toggle="tooltip" title="Contacts" id="userList"><a data-toggle="tab" data-target="#contactmenu"><i class="fa fa-user"></i></a></li>
        <li class="tooltips" data-toggle="tooltip" title="Settings"><a data-toggle="tab" data-target="#settings"><i class="fa fa-cog"></i></a></li>
        <li class="tooltips" data-toggle="tooltip" title="Log Out" id ="userlogOut"><a><i class="fa fa-sign-out"></i></a></li>
      </ul>

      <div class="tab-content">

        <!-- ################# MAIN MENU ################### -->
		
        <div class="tab-pane active" id="mainmenu">
          <h5 class="sidebar-title">강사용 Tab</h5>
          <ul class="nav nav-pills nav-stacked nav-quirk">
            <li id="p1000"><a><i class="fa fa-home"></i><span>강좌 개설</span></a></li>
            <li id="p2000"><a><span class="badge pull-right"></span><i class="fa fa-cube"></i> <span>사장님 스케쥴</span></a></li>
            <li id="p3000"><a><i class="fa fa-map-marker"></i> <span>휴가 달력</span></a></li>
            <li id="p4000"><a><i class="badge pull-right"></i> <span>신태휘</span></a></li>
          </ul>

          <h5 class="sidebar-title">Common Menu</h5>
          <ul class="nav nav-pills nav-stacked nav-quirk">
            <li class="nav-parent">
              <a href=""><i class="fa fa-check-square"></i> <span>법인 카드 신청</span></a>
              <ul class="children">
                <li id= "goCorporationPage"><a>법인 카드 신청</a></li>
              </ul>
            </li>
            <li class="nav-parent"><a href=""><i class="fa fa-suitcase"></i> <span>휴가 신청</span></a>
              <ul class="children">
                <li id = "leaveApplication"><a>휴가 신청</a></li>
                <li id = "leaveAppApproval"><a>휴가 결재</a></li>
                <li id = "leaveAppCalender"><a>휴가 캘린더</a></li>
              </ul>
            </li>
            <li class="nav-parent"><a href=""><i class="fa fa-file-text"></i> <span>공지사항</span></a>
              <ul class="children">
                <li id= "goNoPage"><a>공지 사항</a></li>
              </ul>
            </li>
            <li class="nav-parent"><a href=""><i class="fa fa-th-list"></i> <span>Tables</span></a>
              <ul class="children">
                <li><a>Basic Tables</a></li>
              </ul>
            </li>
            
          </ul>
        </div><!-- tab-pane -->

        <!-- ######################## EMAIL MENU ##################### -->

        <div class="tab-pane" id="emailmenu">
          <div class="sidebar-btn-wrapper">
            <a href="compose.html" class="btn btn-danger btn-block">Compose</a>
          </div>

          <h5 class="sidebar-title">Mailboxes</h5>
          <ul class="nav nav-pills nav-stacked nav-quirk nav-mail">
            <li><a><i class="fa fa-inbox"></i> <span>Inbox (3)</span></a></li>
            <li><a><i class="fa fa-pencil"></i> <span>Draft (2)</span></a></li>
            <li><a><i class="fa fa-paper-plane"></i> <span>Sent</span></a></li>
          </ul>

          <h5 class="sidebar-title">Tags</h5>
          <ul class="nav nav-pills nav-stacked nav-quirk nav-label">
            <li><a><i class="fa fa-tags primary"></i> <span>Communication</span></a></li>
            <li><a><i class="fa fa-tags success"></i> <span>Updates</span></a></li>
            <li><a><i class="fa fa-tags warning"></i> <span>Promotions</span></a></li>
            <li><a><i class="fa fa-tags danger"></i> <span>Social</span></a></li>
          </ul>
        </div><!-- tab-pane -->

        <!-- ################### CONTACT LIST ################### -->

        <div class="tab-pane" id="contactmenu">
          <div class="input-group input-search-contact">
            <input type="text" class="form-control" placeholder="Search contact">
            <span class="input-group-btn">
              <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
            </span>
          </div>
          <h5 class="sidebar-title">My Contacts</h5>
          <div id="listView"></div>
        </div><!-- tab-pane -->

        <!-- #################### SETTINGS ################### -->

        <div class="tab-pane" id="settings">
          <h5 class="sidebar-title">General Settings</h5>
          <ul class="list-group list-group-settings">
            <li class="list-group-item">
              <h5>Daily Newsletter</h5>
              <small>Get notified when someone else is trying to access your account.</small>
              <div class="toggle-wrapper">
                <div class="leftpanel-toggle toggle-light success"></div>
              </div>
            </li>
            <li class="list-group-item">
              <h5>Call Phones</h5>
              <small>Make calls to friends and family right from your account.</small>
              <div class="toggle-wrapper">
                <div class="leftpanel-toggle-off toggle-light success"></div>
              </div>
            </li>
          </ul>
          <h5 class="sidebar-title">Security Settings</h5>
          <ul class="list-group list-group-settings">
            <li class="list-group-item">
              <h5>Login Notifications</h5>
              <small>Get notified when someone else is trying to access your account.</small>
              <div class="toggle-wrapper">
                <div class="leftpanel-toggle toggle-light success"></div>
              </div>
            </li>
            <li class="list-group-item">
              <h5>Phone Approvals</h5>
              <small>Use your phone when login as an extra layer of security.</small>
              <div class="toggle-wrapper">
                <div class="leftpanel-toggle toggle-light success"></div>
              </div>
            </li>
          </ul>
        </div><!-- tab-pane -->


      </div><!-- tab-content -->

    </div><!-- leftpanelinner -->
  </div><!-- leftpanel -->
 </section> 
 <div class="modal fade" id="workTime">
	  <div class="modal-dialog">
	    <div class="modal-content">
	        <!-- header -->
			<div class="modal-header">
			    <!-- 닫기(x) 버튼 -->
			  <button type="button" class="close" data-dismiss="modal">×</button>
			  <!-- header title -->
			  <h4 class="modal-title">근무 시간 주 (5일) </h4>
			  <div>
				  <input type="text" class="form-control" name="userDate" id="userDate" />
				  <button type="button" id = "workTimeSearch" >조회</button>
			  </div>
			</div>
			<!-- body -->
			<div class="modal-body">
			    <table class="table nomargin" style="height:100px" id="costTable" >
			    	<thead> 
				    	<tr style="text-align:center">
				    		<th>인덱스</th>
				    		<th>날짜</th>
				    		<th>출근 시간</th>
				    		<th>퇴근 시간</th>
				    		<th>총 근무시간</th>
				    	</tr>	
			    	</thead>
			    	<tbody id ="workTimeArea" style="text-align:center">
			    	</tbody>			    	
			    </table>
			</div>
			<!-- Footer -->
			<div class="modal-footer">
			</div>
	    </div>
	  </div>
	</div>