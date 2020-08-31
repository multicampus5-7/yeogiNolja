<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>여기놀자</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>


<body>
	<header>
		<c:choose>
			<c:when test="${user == null}">
				<p>
					<a href="login.mc">login</a>
					<a href="admin.mc">admin</a>
				</p>
			</c:when>
			<c:otherwise>
				<p>${user.name}님</p>
				<p><a href="logout.mc">logout</a></p>
			</c:otherwise>
		</c:choose>


	</header>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-4">
						<jsp:include page="${centerpage}"></jsp:include>
					</div>
					<div class="col-md-4 col-md-pull-7">

						<c:choose>
							<c:when test="${setBookingForm==true }">
								<jsp:include page="bookingForm.jsp"></jsp:include>
							</c:when>
							<c:otherwise>
								<p>form not found</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>