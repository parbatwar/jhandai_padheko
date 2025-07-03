<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrow List - Admin</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/borrow.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/adminNav.css" />

</head>
<body>

<div class="container">
    <%@include file="/../jsp/adminNav.jsp" %>

    <div class="content">
        <h2>Borrow List</h2>
        <p>Total Borrows: ${fn:length(borrowList)}</p>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Borrow ID</th>
                        <th>User ID</th>
                        <th>Book ID</th>
                        <th>Issued Date</th>
                        <th>Due Date</th>
                        <th>Return Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty borrowList}">
                        <c:forEach var="borrow" items="${borrowList}">
                            <tr>
                                <td>${borrow.borrowId}</td>
                                <td>${borrow.userId}</td>
                                <td>${borrow.bookId}</td>
                                <td>${borrow.issuedDate}</td>
                                <td>${borrow.dueDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty borrow.returnDate}">
                                            Not Returned
                                        </c:when>
                                        <c:otherwise>
                                            ${borrow.returnDate}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty borrowList}">
                        <tr>
                            <td colspan="6">No borrows found or connection issue.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
