<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.*, com.jhandai_padheko.model.BookModel, com.jhandai_padheko.service.BookService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Books - Jhandai Padheko Library</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/books.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/footer.css">
</head>

<body>
	<%@ include file="/jsp/header.jsp"%>
	<div class="searched">
	<c:if test="${not empty searchQuery}">
		<p>
			Search results for: <strong>${searchQuery}</strong>
		</p>
	</c:if>

	<c:choose>
		<c:when test="${empty bookList}">
			<p>
				No books found for "
				<c:out value='${searchQuery}' />
				".
			</p>
		</c:when>
		<c:otherwise>
			<div class="main-container">
				<c:forEach var="book" items="${bookList}">
					<a
						href="${pageContext.request.contextPath}/bookview?book_id=${book.book_id}"
						class="book-link" style="text-decoration: none;">
						<div class="book-card">
							<img
								src="${pageContext.request.contextPath}/resources/images/books/${book.book_image}"
								alt="${book.book_title}">
							<h2>Rs. ${book.book_price}</h2>
							<h3>${book.book_title}</h3>
							<p>${book.book_author}</p>
						</div>
					</a>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	

	<c:if test="${empty searchQuery}">
		<div class="container">
			<div class="top-banner">
				<h1>📚 EXPLORE BOOKS AT JHANDAI PADHEKO LIBRARY</h1>
				<img
					src="<%=request.getContextPath()%>/resources/images/books/booksbaner.png"
					alt="Banner">
			</div>

			<div class="main-container">
				<%
				BookService dao = new BookService();
				List<BookModel> books = dao.getAllBooks();
				for (BookModel book : books) {
				%>
				<a
					href="<%=request.getContextPath()%>/bookview?book_id=<%=book.getBook_id()%>"
					class="book-link" style="text-decoration: none;">
					<div class="book-card">
						<img
							src="<%=request.getContextPath()%>/resources/images/books/<%=book.getBook_image()%>"
							alt="<%=book.getBook_title()%>">
						<h2>
							Rs.
							<%=String.format("%.2f", book.getBook_price())%></h2>
						<h3><%=book.getBook_title()%></h3>
						<p><%=book.getBook_author()%></p>
					</div>
				</a>
				<%
				}
				%>
			</div>
		</div>
	</c:if>

	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>