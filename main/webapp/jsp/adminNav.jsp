<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="sidebar">
	<div class="logo">
		<a href="${pageContext.request.contextPath}/index"><img
			src="${pageContext.request.contextPath}/resources/images/system/Logo.webp"
			alt="Jhandai Padheko Logo" /></a>
		<p>Jhandai Padheko</p>
	</div>
	<ul class="nav">
		<li><a href="${contextPath}/dashboard">Dashboard</a></li>
		<li><a href="${contextPath}/adminbooks">Books</a></li>
		<li><a href="${contextPath}/adminusers">Users</a></li>
		<li><a href="${contextPath}/purchase">Purchase</a></li>
		<li><a href="${contextPath}/borrow">Borrow</a></li>
	</ul>
	<div class="logout">
		<form action="${contextPath}/logout" method="post">
			<input type="submit" class="nav-button" value="Logout" />
		</form>
	</div>
</div>