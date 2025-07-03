<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Using JSTL forEach loop to display student data -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admindash.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminNav.css" />
</head>
<body>


	<div class="container">
		<%@include file="/../jsp/adminNav.jsp"%>
		<div class="content">
			<!-- Chart Container -->
			<div class="chart-card">
				<h3>Daily Purchase Amount</h3>
				<canvas id="purchaseChart" width="400" height="100"></canvas>
			</div>

			<!-- Chart.js CDN -->
			<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

			<script>
    const ctx = document.getElementById('purchaseChart').getContext('2d');

    const labels = [
        <c:forEach var="item" items="${summaries}" varStatus="loop">
            "${item.date}"<c:if test="${!loop.last}">,</c:if>
        </c:forEach>
    ];

    const data = [
        <c:forEach var="item" items="${summaries}" varStatus="loop">
            ${item.totalAmount}<c:if test="${!loop.last}">,</c:if>
        </c:forEach>
    ];

    new Chart(ctx, {
        type: 'bar', // or 'line'
        data: {
            labels: labels,
            datasets: [{
                label: 'Purchase Amount (Rs)',
                data: data,
                backgroundColor: '#2c3e50',
                borderRadius: 4,
                borderSkipped: false
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>

			<div class="card">
				<div>
					<h2>Welcome, Admins!</h2>
				</div>
				<img src="${contextPath}/resources/images/system/logo.jpeg"
					alt="logo">
			</div>
			<div class="header">
				<div class="info-box">
					<h3>Total Users</h3>
					<p>${fn:length(userList)}</p>
				</div>
				<div class="info-box">
					<h3>Books</h3>
					<p>${fn:length(bookList)}</p>
				</div>
				<div class="info-box">
					<h3>Borrow</h3>
					<p>${fn:length(borrowList)}</p>
				</div>
				<div class="info-box">
					<h3>E-Books</h3>
					<p>${ebookCount}</p>
				</div>
			</div>




			<div class="table-container">
				<h3>Recently Enrolled Users</h3>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
							<th>Gender</th>
							<th>Email</th>
							<th>Number</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty userList}">
							<c:forEach var="user" items="${userList}">
								<tr>
									<td>${user.user_id}</td>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.username}</td>
									<td>${user.gender}</td>
									<td>${user.email}</td>
									<td>${user.phone}</td>
								</tr>

							</c:forEach>
						</c:if>
						<c:if test="${empty userList}">
							<tr>
								<td colspan="6">No users found or connection issue.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>