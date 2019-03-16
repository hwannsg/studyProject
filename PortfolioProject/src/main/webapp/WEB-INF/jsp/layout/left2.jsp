<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/datePicker/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/datePicker/bootstrap-datepicker.kr.js" type="text/javascript"></script>
<script type="text/javascript" src="/javaScriptFile/commonLeft.js"></script>
</head>

<script>
$(document).ready(function() {
	$("input[name ='startDay']").datepicker({format:"yyyy-mm-dd"}).datepicker();
	$("input[name ='endDay']").datepicker({format:"yyyy-mm-dd"}).datepicker();
});
$(function() {

});
function inputTimeColon(time) {
    // replace 함수를 사용하여 콜론( : )을 공백으로 치환한다.
    var replaceTime = time.value.replace(/\:/g, "");

    // 텍스트박스의 입력값이 4~5글자 사이가 되는 경우에만 실행한다.
    if(replaceTime.length >= 4 && replaceTime.length < 5) {
        var hours = replaceTime.substring(0, 2);      // 선언한 변수 hours에 시간값을 담는다.
        var minute = replaceTime.substring(2, 4);    // 선언한 변수 minute에 분을 담는다.

        // isFinite함수를 사용하여 문자가 선언되었는지 확인한다.
        if(isFinite(hours + minute) == false) {
            alert("문자는 입력하실 수 없습니다.");
            time.value = "00:00";
            return false;
        }

        // 두 변수의 시간과 분을 합쳐 입력한 시간이 24시가 넘는지를 체크한다.
        if(hours + minute > 2400) {
            alert("시간은 24시를 넘길 수 없습니다.");
            time.value = "24:00";
            return false;
        }

        // 입력한 분의 값이 60분을 넘는지 체크한다.
        if(minute > 60) {
            alert("분은 60분을 넘길 수 없습니다.");
            time.value = hours + ":00";
            return false;
        }

        time.value = hours + ":" + minute;
    }
}
</script>
<section> 
	<form id="form" name="form">
	
	</form>
 	<div class="leftpanel">
    <div class="leftpanelinner">
      <div class="tab-content">

        <!-- ################# MAIN MENU ################### -->
		
        <div class="tab-pane active" id="mainmenu">
          <h5 class="sidebar-title">일정 추가 </h5>
        </div><!-- tab-pane -->
		<div class="nav nav-pills nav-stacked nav-quirk">
			<form id="Schedule" name ="Schedule">
			 	<input type="text" class="timeBox" name="startDay" id="startDay" placeholder = "startDay" maxlength="5"/>	
				<input type="text" class="timeBox" id ="startTime" name ="startTime" onKeyup="inputTimeColon(this);" placeholder="HH:MM" maxlength="5"/>
				<input type="text" class="timeBox" name="endDay" id="endDay" placeholder = "endDay" maxlength="5"/>
				<input type="text" class="timeBox" id ="endTime" name ="endTime" onKeyup="inputTimeColon(this);" placeholder="HH:MM" maxlength="5"/>
				<textarea rows="5" id ="title" name="title"class="form-control" placeholder="Type your Lecture comment..." required></textarea>
				<select class="form-control" name="sType" id ="sType">
							<option value="">스케쥴 종류</option>
							<option value="1">출장</option>
							<option value="2">미팅</option>
							<option value="3">교육</option>
							<option value="4">외근</option>
				</select> 
				<input type='checkbox' name='allDay' value='allDay' id= "allDay"/>allDay
				<br/>
				<input type ='button' class = 'btn btn-success' value ='결재하기' id ='CreateSchedule' name ='CreateSchedule'>
			</form>
		</div>
        
      </div><!-- tab-content -->

    </div><!-- leftpanelinner -->
  </div><!-- leftpanel -->
 </section> 