<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<div id="center">
<h1>User Update Page</h1>
<form action="userupdateimpl.mc" method="post">
	ID: ${userdetail.email }<br>
	PWD: <input type="text" name="pwd" value="${userdetail.pwd }"><br>
	NAME: <input type="text" name="name" value="${userdetail.name }"><br>
	<input type="hidden" name="email" value="${userdetail.email }">
	<input type="submit" value="UPDATE">
</form>

</div>