<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Search Reservations </h5>
				<span class="form-label">Check In</span> <input
						class="form-control" type="date" name="inDate" id="inDate"
						value="${booking.inDate}" required>
						
				<span class="form-label">Check out</span> <input
						class="form-control" type="date" name="outDate" id="outDate"
						value="${booking.outDate}" required>
				
				
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
					<tbody><!-- 
						<c:forEach var="u" items="${userList}">
							<tr>
								<td scope="row">${u.email}</td>
								<th>${u.name}</th>
								<td>${u.pwd}</td>
								<td>${u.admin_yn}</td>
								<td>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-info" 
									onclick="location.href='adminUserModify.mc?id=${u.email}'">Edit</button>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-danger">Delete</button>
								</td>					
							</tr>
						</c:forEach> -->
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

	function getHotelListData() {
		$.ajax({
			url : 'hotelListAutoCom.mc',
			async : false,

			success : function(result) {
				console.log("autoComplete ok");
				setAutoComplete(result.data);
			},
			error : function() {
				console.log("autoComplete Fail");
			}
		});
	}

	function setAutoComplete(searchSource) {
		$("#dest").autocomplete({
			source : searchSource,
			select : function(event, ui) {
				console.log(ui.item);
			},
			focus : function(event, ui) {
				return false;
			},
			minLength : 1,
			autoFocus : true,
			classes : {
				"ui-autocomplete" : "highlight"
			},
			position : {
				my : "right top",
				at : "right bottom"
			},
			close : function(event) {
				console.log(event);
			}
		});

	}

	$(document).ready(function() {
		getHotelListData();
		var today = getDateFormat(new Date());
		document.getElementById("inDate").setAttribute("min", today);
		document.getElementById("outDate").setAttribute("min", today);

	});
</script>