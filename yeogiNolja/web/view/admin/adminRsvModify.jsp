<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
		document.getElementById("outDate").setAttribute("min",  today);

		$("#outDate").on("change keyup paste", function(){
			var inDate = $("#inDate").val();
			var outDate = $("#outDate").val();
			
			if(inDate > outDate){
			alert("checkOut은 checkIn이후여야 합니다.");
			$(this).val('');
			}
				
		});
		$("#adult").val(${booking.adult});
		$("#roomNum").val(${booking.roomNum});
		
	});
</script>


<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-box2 icon-gradient bg-amy-crisp"> </i>
			</div>
			<div>
				Edit Reservation
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
			<form action="adminHotelModifyImpl.mc" method="post">
				<h5 class="card-title">Modify Reservation</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>Reservation ID</th>
							<th>${rsv.hotel_id}
							<input type="text" name="dest"id="dest" value="asdf">
								<input type="hidden" name="hotel_id" value="${rsv.hotel_id}">
								
								<span class="form-label">Your Destination</span> <input
				class="form-control" type="text"
				placeholder="Enter a destination or hotel name" name="dest"
				id="dest" value="${booking.dest}" required>
							</th>
						</tr>
						<tr>
							<th>Customer</th>
							<td><input id="title" name="name" type="text" class="form-control"
								value="${rsv.name}"/>
							</td>
						</tr>
						<tr>
							<th>Hotel</th>
							<td><input id="title" name="addr_sd" type="text" class="form-control"
								value="${rsv.hotel_name}"/>
							</td>
						</tr>
						<tr>
							<th>Room</th>
							<td><input id="title" name="total_room" type="text" class="form-control"
								value="${rsv.room_name}"/>
							</td>
						</tr>
						<tr>
						
						
							<th>Period</th>
								<td>
								<div class="form-row">
									<div class="col-md-6">
										<div class="position-relative form-group">
											<fmt:parseDate value='${rsv.start_date}' var='date1' pattern='yyyy-mm-dd'/>
											<fmt:formatDate value="${date1}" var='date11' pattern="yyyy-mm-dd"/>
												<span class="form-label">Check In </span> <input
													class="form-control" type="date" name="start_date"
													value="${date11}" required>
										</div>
									</div>
									<div class="col-md-6">									
										<div class="position-relative form-group">
											<fmt:parseDate value='${rsv.end_date}' var='date2' pattern='yyyy-mm-dd'/>
											<fmt:formatDate value="${date2}" var='date22' pattern="yyyy-mm-dd"/>
											<span class="form-label">Check out</span> <input
												class="form-control" type="date" name="end_date"
												value="${date22}" required>
										</div>
									</div>
								</div>
								</td>
							</tr>
						<tr>
							<th>Price</th>
							<td><input id="title" name="lat" type="text" class="form-control"
								value="${rsv.price}"/>
							</td>
						</tr>
						<tr>
							<th>Pay</th>
							<td>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio1" class="custom-control-input"
										name="pay_yn" value="Y" checked /> <label class="custom-control-label"
										for="exampleCustomRadio1"> YES </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio2" class="custom-control-input"
										name="pay_yn" value="N" checked /> <label class="custom-control-label"
										for="exampleCustomRadio2"> NO </label>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="mb-2 mr-2 btn btn-primary btn-lg btn-block">Modify </button>
				</div>
			</div>
			</form>
			</div>
		</div>
	</div>
</div>
