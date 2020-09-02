<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- CSS , JS -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
	function getDateFormat(date) {
		var dd = date.getDate();
		var mm = date.getMonth() + 1;
		var yyyy = date.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		return today = "" + yyyy + '-' + mm + '-' + dd;
	}

	function getHotelListData() {
		$.ajax({
			url : 'hotelListAutoCom.mc',

			success : function(result) {
				console.log("autoComplete ok");
				//setAutoComplete(result.data);
			},
			error : function() {
				console.log("autoComplete Fail");
			}
		});
	}

	$(function() { //화면 다 뜨면 시작
		var searchSource = [ "김치 볶음밥", "신라면", "진라면", "라볶이", "팥빙수", "너구리",
				"삼양라면", "안성탕면", "불닭볶음면", "짜왕", "라면사리" ]; // 배열 형태로 
		$("dest").autocomplete({ //오토 컴플릿트 시작
			source : searchSource, // source 는 자동 완성 대상
			select : function(event, ui) { //아이템 선택시
				console.log(ui.item);
			},
			focus : function(event, ui) { //포커스 가면
				return false;//한글 에러 잡기용도로 사용됨
			},
			minLength : 1,// 최소 글자수
			autoFocus : true, //첫번째 항목 자동 포커스 기본값 false
			classes : { //잘 모르겠음
				"ui-autocomplete" : "highlight"
			},
			delay : 500, //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
			//            disabled: true, //자동완성 기능 끄기
			position : {
				my : "right top",
				at : "right bottom"
			}, //잘 모르겠음
			close : function(event) { //자동완성창 닫아질때 호출
				console.log(event);
			}
		});

	});
/* 	function setAutoComplete(searchSource) {
		console.log(searchSource);
		$("#dest").autocomplete({
			source : searchSource,
			select : function(event, ui) {
				console.log(ui.item);
			},
			focus : function(event, ui) {
				return false;
			},
			minLength : 1,
			autoFocus : true,
			classes : {
				"ui-autocomplete" : "highlight"
			},
			position : {
				my : "right top",
				at : "right bottom"
			},
			close : function(event) {
				console.log(event);
			}
		});
		console.log("ok");

	} */

	$(document).ready(function() {
		getHotelListData();
		var today = getDateFormat(new Date());
		document.getElementById("inDate").setAttribute("min", today);
		document.getElementById("outDate").setAttribute("min", today);
	});
</script>

<div class="booking-form">
	<form action="bookingImpl.mc" method="post">
		<div class="form-group">

			<span class="form-label">Your Destination</span> <input
				class="form-control" type="text"
				placeholder="Enter a destination or hotel name" name="dest"
				value="${booking.dest}" required>

		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check In</span> <input
						class="form-control" type="date" name="inDate" id="inDate"
						value="${booking.inDate}" required>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check out</span> <input
						class="form-control" type="date" name="outDate" id="outDate"
						value="${booking.outDate}" required>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Type</span> <select class="form-control"
						name="hotelType">
						<option value="O01">호텔/콘도</option>
						<option value="O02">모텔/여관/여인숙</option>
						<option value="O03">캠프/별장/펜션</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Rooms</span> <select class="form-control"
						name="roomNum">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Adults</span> <select class="form-control"
						name="adult">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>

		</div>
		<button class="submit-btn" type="submit">Check availability</button>
	</form>
</div>
