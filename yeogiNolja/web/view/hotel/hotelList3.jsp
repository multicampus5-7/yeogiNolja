<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=77051248a1682bf5a19186626f35773e"></script>
<!-- modal src -->
<!-- duplicated jquery src hidden -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

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

.map {
	height: 10px;
	border: 2px solid blue;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		setTotalPageNum();
		
		//$('#map').eq(2).hide();
		 for (var i = ${stNum}; i <=${endNum}; i++) {
			var str = '#map'+i;
			var str2 = '#showMap' +i;
			$(str).hide();
			
			$(str2).click(function(){
				console.log(str2);
				if($(str).is(":visible"))
					$(str).hide();
				
				else{
					$(str).show();
				}
				
				
				
				
				
				
				
			});
		} 
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

	function displayMap(){
		var mapContainer = document.getElementById('map'),
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667),
	        level: 3 
	    };

		var map = new kakao.maps.Map(mapContainer, mapOption); 
		var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 
		var marker = new kakao.maps.Marker({
	    	position: markerPosition
		});

		marker.setMap(map);
	};
	
	
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
			end="${endNum}" varStatus="status">
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
							| ${hlist.addr_emd} | <a id="showMap${status.count }">지도보기</a></td>
				</tr>
				<tr>
					<td>${hlist.grade }|${hlist.amenities}</td>
				</tr>
			</table>
			<div id="map${status.count }" class="map"></div>
			<hr />
		</c:forEach>
	</div>
	<div>
		<ul id=totalPage></ul>
	</div>

</div>
