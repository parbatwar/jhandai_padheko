<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Books</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminbooks.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminNav.css" />
</head>
<body>
	<div class="container">
		<%@include file="/../jsp/adminNav.jsp"%>


		<div class="content">
			<h2>Book List</h2>
			<div class="header">


				<div class="table-container">
					<table>
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>
								<th>Author</th>
								<th>Genre</th>
								<th>Condition</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Type</th>
								<th>Actions</th>

							</tr>
						</thead>
						<tbody>
							<!-- Using JSTL forEach loop to display book data -->
							<%@ taglib prefix="fn"
								uri="http://java.sun.com/jsp/jstl/functions"%>
							<p>Total Books: ${fn:length(bookList)}</p>

							<c:if test="${not empty bookList}">
								<c:forEach var="book" items="${bookList}">
									<tr>
										<td>${book.book_id}</td>
										<td>${book.book_title}</td>
										<td>${book.book_author}</td>
										<td>${book.book_genre}</td>
										<td>${book.book_condition}</td>
										<td>${book.book_price}</td>
										<td>${book.book_quantity}</td>
										<td>${book.book_type}</td>
										<td>
										    <a href="${contextPath}/updatebooks?bookId=${book.book_id}" title="Edit" class="action-btn">
										      <img src="${pageContext.request.contextPath}/resources/images/system/edit.png" alt="Edit" title="Edit" />
										    </a>
											<a href="${contextPath}/deleteBooks?bookId=${book.book_id}"
											   onclick="return confirm('Are you sure you want to delete this book?');"
											   title="Delete" class="action-btn">
											   <img src="${pageContext.request.contextPath}/resources/images/system/trash.png" alt="Delete" title="Delete" />
											</a>

										</td>
										
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty bookList}">
								<tr>
									<td colspan="6">No books found or connection issue.</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>