<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<div class="booking-cta">
	<h1>${hotel.name}</h1>
	<p>주소 : ${hotel.addr_sd} ${hotel.addr_sgg} ${hotel.addr_emd }</p>
	<p>호텔등급: ${hotel.grade}</p>
	<p>편의시설: ${hotel.amenities }</p>

	<c:forEach var="hotelRoom" items="${hotelRoomList }">
		<p>${hotelRoom.room_name}</p>
	</c:forEach>
</div>
