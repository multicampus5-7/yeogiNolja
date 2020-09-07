<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-magic-wand icon-gradient bg-mixed-hopes"> </i>
			</div>
			<div>
				Reservations
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
			<div class="d-inline-block dropdown">
				<button type="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"
					class="btn-shadow dropdown-toggle btn btn-info">
					<span class="btn-icon-wrapper pr-2 opacity-7"> <i
						class="fa fa-business-time fa-w-20"></i>
					</span> Buttons
				</button>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
			<form action="adminRsvSearchDateImpl.mc" method="post">
				<h5 class="card-title">Search Reservations </h5>
				<div class="form-row">
					<div class="col-md-6"> 
					<div class="position-relative form-group"> <span class="form-label">Check In</span> <input
							class="form-control" type="date" name="start_date"
							value="${rsv.start_date}" required> </div>
					</div>
					<div class="col-md-6"> 
					<div class="position-relative form-group"> <span class="form-label">Check out</span> <input
							class="form-control" type="date" name="end_date"
							value="${rsv.end_date}" required> </div>
					</div>
				</div>
				<button class="mt-1 btn btn-primary" type="submit">Search</button>
			</form>
			</div>
		</div>		
	</div>
	<div class="col-lg-6">
		<div class="tab-pane tabs-animation fade show active"
			role="tabpanel">
			<div class="main-card mb-3 card">
				<div class="card-body">
					<div id='calendar'></div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">About Results</h5>
				<table class="mb-0 table">
					<thead>
						<tr>
							<th>R. ID</th>
							<th>HOTEL</th>
							<th>ROOM</th>
							<th>E-MAIL</th>
							<th>START DATE</th>
							<th>END DATE</th>
							<th>ACTIONS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rsv" items="${reserveList}">
							<tr>
								<td scope="row">${rsv.rsv_id}</td>
								<td>${rsv.hotel_id}</td>
								<td>${rsv.room_id}</td>
								<td>${rsv.user_email}</td>
								<td>
									<fmt:parseDate value="${rsv.start_date}" var="startDate" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<fmt:parseDate value="${rsv.end_date}" var="endDate" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<button class="mr-2 btn-icon btn-icon-only btn btn-outline-info" 
									onclick="location.href='adminRsvModify.mc?id=${rsv.rsv_id}'">Edit</button>
									<button class="mr-2 btn-icon btn-icon-only btn btn-outline-danger">
									<i class="pe-7s-trash btn-icon-wrapper"> </i> </button>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


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

	$(document).ready(function() {
		getHotelListData();
		var today = getDateFormat(new Date());
		document.getElementById("inDate").setAttribute("min", today);
		document.getElementById("outDate").setAttribute("min", today);

	});
</script>