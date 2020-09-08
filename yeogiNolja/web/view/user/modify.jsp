<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회원정보 수정</title>
<link rel="stylesheet" href="css/modify/style.css">
</head>
<body>
	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<span class="font-weight-bold">NAME : ${user.name } </span> <span
						class="text-black-50">EMAIL: ${user.email }</span> <span></span>
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Profile Settings</h4>
					</div>
					<form action="userupdateimpl.mc" method="post">
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels">NAME</label><input type="text" name="name"
									class="form-control" placeholder="your name"
									value="${user.name }">
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-12">
								<label class="labels">EMAIL</label><input value="${user.email }"
									disabled /> <input type="hidden" name="email"
									value="${user.email }">
							</div>
							<div class="col-md-12">
								<label class="labels">PASSWORD</label><input type="password"
									name="pwd" class="form-control" placeholder="your new pwd"
									value="${user.pwd }">
							</div>
						</div>
						<div class="mt-5 text-center">
							<input type="submit" value="UPDATE">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>