<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-11 col-lg-8 dash-left">
		<div class="panel">
			<div class="panel-heading">화면 리스트</div>
			<div class="panel-body">

				<div class="table-responsive">

					<table
						class="table table-bordered table-default table-striped nomargin"
						id="tableMenuList">
						<thead class="success">
							<tr>
								<th><label class="ckbox ckbox-primary"> <input
										type="checkbox"><span> 삭제</span>
								</label></th>
								<th>No.</th>
								<th>메뉴명</th>
								<th>주소 URL</th>
								<th>권한</th>
								<th>마지막 수정자</th>
								<th>마지막 수정일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><label class="ckbox ckbox-primary"> <input
										type="checkbox"><span></span>
								</label></td>
								<td>0</td>
								<td>menuList</td>
								<td>menu/ctrl/list.do</td>
								<td>C</td>
								<td>신태휘</td>
								<td>2019.03.10</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-2 col-lg-1 dash-left">
		<div class="panel">
			<div style="padding: 10px;">
				<button id="addRow" class="btn btn-primary">추가</button>
				<button class="btn btn-primary">저장</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#addRow").on("click", function(){
			fn_addRow();
		});
	})
				
	var fn_addRow = function() {
		fn_getTableRow();
		var html ="";
		html += '<tr>';
		html += '<td><label class="ckbox ckbox-primary">';
		html += '	<input type="checkbox"><span></span>' ;
		html += '		</label></td>';
		html += '		<td>';
		html += '			<input name="menuNewIdx" type="text" value=1 disabled="disabled"></td>';
		html += '		<td>';
		html += '			<input name="menuNewName" type="text" value=""></td>';
		html += '		<td>';
		html += '			<input name="menuNewUrl" type="text" value=""></td>';
		html += '		<td><select name="menuRight">';
		html += '				<option value="A">A</option>';
		html += '				<option value="B">B</option>';
		html += '				<option value="C">C</option>';
		html += '		</select></td>';
		html += '		<td>';
		html += '			<input name="menuRegUserNm" type="text" value="" disabled="disabled"></td>';
		html += '		<td>';
		html += '			<input name="menuRegDt" type="text" value="' + fn_getToday() +'" disabled="disabled"></td>';
		html += '	</tr>';
		
		$("#tableMenuList").append(html);
	}
	
	var fn_getToday = function() {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();

		if(dd<10) {
		    dd='0'+dd
		} 

		if(mm<10) {
		    mm='0'+mm
		} 

		today = yyyy+'.'+mm+'.'+dd;
		return today;
	}
	
	var fn_getTableRow = function() {
		var table = $("#tableMenuList")
		
		var abccd = $("#tableMenuList").children("tbody").children("tr").length;
		
		return 0;
	}

</script>