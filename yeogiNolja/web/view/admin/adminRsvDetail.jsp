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
				${rsv.name}'s Reservation Detail
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button class="mb-2 mr-2 btn btn-info"
				onclick="location.href='adminRsvlModify.mc?id=${rsv.rsv_id}'">
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
				<h5 class="card-title">Reservation Information</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>Reservation ID</th>
							<td>${rsv.rsv_id}</td>
						</tr>
						<tr>
							<th>Customer</th>
							<td>${rsv.name} (${rsv.user_email})</td>
						</tr>
						<tr>
							<th>Hotel</th>
							<td>${rsv.hotel_name}</td>
						</tr>
						<tr>
							<th>Room </th>
							<td>${rsv.room_name} (${rsv.room_num}호)</td>
						</tr>
						<tr>
							<th>Period</th>
							<td><fmt:parseDate value="${rsv.start_date}" var="startDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/>
								 ~ 
								<fmt:parseDate value="${rsv.end_date}" var="endDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>PRICE</th>
							<td><fmt:formatNumber value="${rsv.price}" pattern="###,###,###"/> (${rsv.pay_yn })</td>
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
				<img src="img/hotel/${rsv.hotel_img }" width=100% height=300px>
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
