<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase List - Admin</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/purchase.css" />
	<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/adminNav.css" />
</head>
<body>

	<div class="container">
		<%@include file="/../jsp/adminNav.jsp" %>

		<div class="content">
			<h2>Purchase List</h2>
			<p>Total Purchases: ${fn:length(purchaseList)}</p>

			<div class="table-container">
				<table>
					<thead>
						<tr>
							<th>Purchase ID</th>
							<th>User ID</th>
							<th>Purchase Date</th>
							<th>Book ID</th>
							<th>Purchase Amount</th>
							<th>Purchase Quantity</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty purchaseList}">
							<c:forEach var="purchase" items="${purchaseList}">
								<tr>
									<td>${purchase.purchaseId}</td>
									<td>${purchase.userId}</td>
									<td>${purchase.purchaseDate}</td>
									<td>${purchase.bookId}</td>
									<td>${purchase.purchaseAmount}</td>
									<td>${purchase.purchaseQuantity}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty purchaseList}">
							<tr>
								<td colspan="6">No purchases found or connection issue.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
