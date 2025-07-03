<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatebooks.css">
    <title>Update Book</title>
</head>
<body>
    <h2>Update Book</h2>

    <form action="${pageContext.request.contextPath}/updatebooks" method="post">
        <!-- Hidden book ID -->
        <input type="hidden" name="bookId" value="${book.book_id}" />

        <label>Title:</label>
        <input type="text" name="bookTitle" value="${book.book_title}" required /><br/><br/>

        <label>Author:</label>
        <input type="text" name="bookAuthor" value="${book.book_author}" required /><br/><br/>

        <label>Genre:</label>
        <input type="text" name="bookGenre" value="${book.book_genre}" required /><br/><br/>

        <label>Condition:</label>
        <input type="text" name="bookCondition" value="${book.book_condition}" required /><br/><br/>

        <label>Price:</label>
        <input type="number" step="0.01" name="bookPrice" value="${book.book_price}" required /><br/><br/>

        <label>Quantity:</label>
        <input type="number" name="bookQuantity" value="${book.book_quantity}" required /><br/><br/>

        <label>Type:</label>
        <input type="text" name="bookType" value="${book.book_type}" required /><br/><br/>

        <label>Image URL:</label>
        <input type="text" name="bookImage" value="${book.book_image}" required /><br/><br/>

        <label>Description:</label><br/>
        <textarea name="description" rows="5" cols="40" required>${book.description}</textarea><br/><br/>

        <button type="submit">Update Book</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
</body>
</html>
