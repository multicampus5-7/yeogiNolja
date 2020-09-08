<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- modal src -->
<!-- duplicated jquery src hidden -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c6ffc3753db47ec9c6dd9088d9872dd0"></script>

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
	width: 100%;
	height: 30%;
}


</style>

<script>
	$(document).ready(function(){
		setTotalPageNum();
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
	
	/* 지도 변수들 */
	var map;
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
			center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	/* 모달 생성 후, 3초 후에 지도 업로드되게 */
	 $('a[href="#modal_open"]').click(function(event) {
	      event.preventDefault();
	 
	      $(this).modal({
	    	  fadeDuration: 1000,
	    	  fadeDelay: 0.50,
	      });
	      setTimeout(function(){

		      map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	    	  // 마커가 지도 위에 표시되도록 설정합니다
	    	  marker.setMap(map);
	      }, 3000);
	 });
	
</script>


<div class="booking-cta">

	<div id="sortCrit">
		<ul>
			<li><a href="hotelList.mc?orderBy=hotel_id">추천순</a></li>
			<li><a href="hotelList.mc?orderBy=grade">호텔등급</a></li>
			<li><a href="hotelList.mc?orderBy=hotel_name">이름순</a></li>
		</ul>
	</div>

	<div id=hotelListInfo>
		<hr />
		<c:forEach var="hlist" items="${hotelList}" begin="${stNum}"
			end="${endNum}">
			<table>
				<tr>
					<td rowspan="3" style="width: 40%"><img
						src=img/hotel/${hlist.hotel_img}></td>
					<td><h3>
							<a href="hotelListDetail.mc?hotelId=${hlist.hotel_id}">
								${hlist.name} </a>
						</h3></td>
				</tr>
				<tr>
					<td><p>${hlist.addr_sd}|${hlist.addr_sgg}
							| ${hlist.addr_emd} | <a href="#modal_open" rel="modal:open">지도보기</a>
					</td>
				</tr>
				<tr>
					<td>${hlist.grade }|${hlist.amenities}</td>
				</tr>
			</table>
			<hr />
		</c:forEach>
	</div>
	<div>
		<ul id=totalPage></ul>
	</div>
	
	<div id="modal_open" class="modal" style="z-index: 3; width: 500px; height: 1000px;">
		<!-- 지도가 표시될 div -->
		<div id="map" style="width: 80%; height: 40%; z-index: 99;">			
		</div>
		<!-- close 동작 실시 -->
		<a href="#" rel="modal:close">CLOSE</a>
	</div>
</div>
