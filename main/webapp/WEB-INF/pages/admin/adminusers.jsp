<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Using JSTL forEach loop to display student data -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminusers.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminNav.css" />
</head>
<body>


	<div class="container">
		<%@include file="/../jsp/adminNav.jsp"%>
		<div class="content">

			<div class="table-container">
				<div class="content">
					<div class="header-bar">
						<p>Total Users: ${fn:length(userList)}</p>
						<form
							action="${pageContext.request.contextPath}/generateUserReport"
							method="get">
							<button type="submit" class="report-btn">Generate Report</button>
						</form>
					</div>
					<h3>All Users</h3>
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
								<th>Actions</th>
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
										<td><a
											href="${pageContext.request.contextPath}/update?userId=${user.user_id}"><button
													class="action-btn" type="submit">
													<img
														src="${pageContext.request.contextPath}/resources/images/system/edit.png"
														alt="Edit" title="Edit" />
												</button></a> <a href="${contextPath}/deleteUser?userId=${user.user_id}"
											onclick="return confirm('Are you sure you want to delete this user?');">
												<button class="action-btn" type="submit">
													<img
														src="${pageContext.request.contextPath}/resources/images/system/trash.png"
														alt="Delete" title="Delete" />
												</button>
										</a></td>
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