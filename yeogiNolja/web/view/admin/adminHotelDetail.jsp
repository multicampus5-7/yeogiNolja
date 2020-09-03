<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-diamond icon-gradient bg-strong-bliss"> </i>
			</div>
			<div>
				${hotelDetail.name}
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button class="mb-2 mr-2 btn btn-info"
				onclick="location.href='adminHotelModify.mc?id=${hotelDetail.hotel_id}'">
				Edit</button>
			<button class="mb-2 mr-2 btn btn-danger">
				Delete</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Hotel Information</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>ID</th>
							<td>${hotelDetail.hotel_id}</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td>${hotelDetail.name}</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td>${hotelDetail.addr_sd} ${hotelDetail.addr_sgg} ${hotelDetail.addr_emd}</td>
						</tr>
						<tr>
							<th>ROOMS</th>
							<td>${hotelDetail.total_room}</td>
						</tr>
						<tr>
							<th>AMENITIES</th>
							<td>${hotelDetail.amenities}</td>
						</tr>
						<tr>
							<th>GRADE</th>
							<td>${hotelDetail.grade}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Photo</div>
				<img src="img/hotel/${hotelDetail.hotel_img }" width=100% height=300px>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Maps</div>
				<div id="gmap-example"></div>
			</div>
		</div>
	</div>

	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Rooms</h5>
				<table class="mb-0 table">
					<thead>
						<tr>
							<th>ID</th>
							<th>NUMBER</th>
							<th>NAME</th>
							<th>CAPACITY</th>
							<th>PRICE</th>
							<th>PHOTO</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${roomList}">
							<tr>
								<th scope="row">${r.room_id}</th>
								<td>${r.room_num}</td>
								<td>${r.room_name}</td>
								<td>${r.adults}</td>
								<td><fmt:formatNumber value="${r.price}" pattern="###,###,###"/></td>
								<td>
									<button type="button" class="btn mr-2 mb-2 btn-primary" data-target="#exampleModal">
	                                            ${r.room_img}
	                                </button> <!-- data-toggle="modal" -->
								</td>
								<td><button class="mb-2 mr-2 btn-transition btn btn-outline-info" >Edit</button>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-danger">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog-2" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p class="mb-0"><img src="img/room/${r.room_img }"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
