<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="booking-cta"
	style="border: 2px solid green; overflow: scroll; width: 100%; height: 100%;">
	<h1>hotelList.jsp</h1>
	<c:forEach var="hlist" items="${hotelList}">
		<p>${hlist.hotel_id}${hlist.name}</p>
	</c:forEach>
</div>
