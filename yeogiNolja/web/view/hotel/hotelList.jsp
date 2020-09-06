<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<style>
#totalPage, #sortCrit>ul {
	list-style: none;
	margin: 0 auto;
	height: 20px;
	color: black;
}

#totalPage>li, #sortCrit>ul>li {
	margin: 0 10px;
	float: left;
	color: black;
}

a {
	color: black;
}

img {
	width: 15%;
	height: 15%;
}
</style>

<script>
	
	$(document).ready(function(){
		setTotalPageNum();
		//setHotelList();
	});
	
	
	function setTotalPageNum(){
		var pageNumSet = '';
		var num = ${fn:length(hotelList)}/5;
		num = Math.ceil(num);
		for (var i = 1; i <= num; i++) {
			pageNumSet += '<li>';
			pageNumSet += '<a href="hotelList.mc?pageNum='+i+'">'+i + "</a></li>";
		}
		document.querySelector("#totalPage").innerHTML=pageNumSet;
	};
	
	function setHotelList(){
		var page = Number(${pageNum})-1;
		var beginNum = page * 5;
		var endNum = page * 5 + 4;
		console.log(beginNum + " " + endNum);

		var result = '<c:forEach var="hlist" items="${hotelList}" begin="0" end="4">';
		result += '	<p>${hlist.hotel_id}${hlist.name}</p>';
		result += '	</c:forEach>'; 
		document.querySelector("#hotelListInfo").innerHTML=result;
	}
</script>


<div class="booking-cta">

	<div id="sortCrit">
		<ul>
			<li><a href="hotelList.mc?orderBy=hotel_id">추천순</a></li>
			<li><a href="hotelList.mc?orderBy=grade">호텔등급</a></li>
			<li><a href="hotelList.mc?orderBy=hotel_name">이름순</a></li>
		</ul>
	</div>

	<%-- <p>${pageNum}+1</p> --%>
	<div id=hotelListInfo>
		<c:forEach var="hlist" items="${hotelList}" begin="0" end="4">
			<div>
				<div>
					<h3>
						<a href="hotelListDetail.mc?hotelId=${hlist.hotel_id}">${hlist.name}</a>
					</h3>
					<p>${hlist.addr_sd}|${hlist.addr_sgg}
						| ${hlist.addr_emd} | <a href="#">지도보기</a>
					</p>
				</div>
				<div>
					<div style="float: left;">
						<p>
							<img src=img/hotel/${hlist.hotel_img}>${hlist.grade }|${hlist.amenities}</p>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	<div>
		<ul id=totalPage></ul>
	</div>
</div>
