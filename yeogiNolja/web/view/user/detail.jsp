<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="center">
	<h1>User Detail Page</h1>
	<h2>${userdetail.email }</h2>
	<h2>${userdetail.pwd }</h2>
	<h2>${userdetail.name }</h2>
	<h3><a href="userupdate.mc?id=${userdetail.id }">UPDATE</a></h3>
</div>
