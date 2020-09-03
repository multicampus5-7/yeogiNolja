<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-drawer icon-gradient bg-happy-itmeo"> </i>
			</div>
			<div>
				${hotelDetail.name}
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Hotel Information</h5>
				<img src="img/hotel/${hotelDetail.hotel_img }">
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>ID</th>
							<td>${hotelDetail.hotel_id}</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td>${hotelDetail.addr_sd} ${hotelDetail.addr_sgg} ${hotelDetail.addr_emd}</td>
						</tr>
						<tr>
							<th>ROOMS</th>
							<th>${hotelDetail.total_room}</th>
						</tr>
						<tr>
							<th>AMENITIES</th>
							<th>${hotelDetail.amenities}</th>
						</tr>
					</tbody>
					<tbody><!-- 
						<c:forEach var="hlist" items="${hotelList}">
							<tr>
								<th scope="row">${hlist.hotel_id}</th>
								<td><a href="hotelDetail.mc?id=${hlist.hotel_id}">${hlist.name}</a></td>
								<td>${hlist.grade}</td>
								<td>${hlist.total_room}</td>
								<td>${hlist.addr_sd} ${hlist.addr_sgg} ${hlist.addr_emd}</td>						
							</tr>
						</c:forEach> -->
					</tbody>
				</table>
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${roomList}">
							<tr>
								<th scope="row">${r.room_id}</th>
								<td>${r.room_num}</td>
								<td><a href="#">${r.room_name}</a></td>
								<td>${r.adults}</td>
								<td>${r.price}</td>
								<td>
									<button type="button" class="btn mr-2 mb-2 btn-primary" data-target="#exampleModal">
	                                            ${r.room_img}
	                                </button> <!-- data-toggle="modal" -->
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
