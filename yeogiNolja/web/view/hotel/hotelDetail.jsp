<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<style>
img {
	width: 100%;
	height: 20%;
}
</style>
<div class="booking-cta">
	<h1>${hotel.name}</h1>
	<p>주소 : ${hotel.addr_sd} ${hotel.addr_sgg} ${hotel.addr_emd }</p>
	<p>호텔등급: ${hotel.grade}</p>
	<p>편의시설: ${hotel.amenities }</p>
	<c:forEach var="hotelRoom" items="${hotelRoomList }">
		<table>
			<tr>
				<td rowspan="3" style="width: 30%"><img
					src="img/room/${hotelRoom.room_img} "></td>
			</tr>
			<tr>
				<td><p>${hotelRoom.room_name}<p></td>
				<td rowspan="3"><button class="submit-btn">예약하기</button></td>
			</tr>
			<tr>
				<td><p>${hotelRoom.price }원</p></td>
			</tr>
		</table>
	</c:forEach>
</div>
