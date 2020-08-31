<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
		var today = getDateFormat(new Date());
		document.getElementById("checkInDate").setAttribute("min", today);
		document.getElementById("checkOutDate").setAttribute("min", today);

		$('.submit-btn').click(function() {
			location.href='hotelList.mc';
			var destination = $('#dest').val();
			var checkInDate = $('#checkInDate').val();
			var checkOutDate = $('#checkOutDate').val();
			var rooms = $('#rooms').val();
			var adults = $('#adults').val();
			var children = $('#children').val();
			console.log(destination);
			console.log(checkInDate);
			console.log(checkOutDate);
			console.log(rooms + adults + children);
		});
	});
</script>

<div class="booking-form">
	<form>
		<div class="form-group">
			<span class="form-label">Your Destination</span> <input
				class="form-control" type="text"
				placeholder="Enter a destination or hotel name" id="dest" required>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check In</span> <input
						class="form-control" type="date" id="checkInDate" required>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check out</span> <input
						class="form-control" type="date" id="checkOutDate" required>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Rooms</span> <select class="form-control"
						id="rooms">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Adults</span> <select class="form-control"
						id="adults">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Children</span> <select
						class="form-control" id="children">
						<option>0</option>
						<option>1</option>
						<option>2</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
		</div>
		<button class="submit-btn">Check availability</button>
	</form>
</div>
