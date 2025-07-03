<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jhandai_padheko.model.BookModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product View</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookview.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>

<%@include file="/jsp/header.jsp" %>

<%
    BookModel book = (BookModel) request.getAttribute("book");
    //List<BookModel> trendingBooks = //(List<BookModel>) request.getAttribute("trendingBooks");
%>

<% if (book != null) { %>
<div class="product-container">
  <div class="product-image">
    <img src="${pageContext.request.contextPath}/resources/images/books/<%= book.getBook_image() %>" alt="<%= book.getBook_title() %>">
  </div>
 
  <div class="product-details">
    <h1><%= book.getBook_title() %></h1>
    <br>
    <h3>by <%= book.getBook_author() %></h3>
    <br>    
    <p class="price">₹<%= book.getBook_price() %></p>
    <p class="description"><%= book.getDescription() %></p>   
    
	    <!-- Quantity Selector -->
	<div class="quantity-selector">
	  <button type="button" class="quantity-btn" onclick="decreaseQty()">−</button>
	  <input type="number" id="quantity" name="quantity" value="1" min="1" readonly>
	  <button type="button" class="quantity-btn" onclick="increaseQty()">+</button>
	</div>
	
	<!-- Add to Cart Button -->
	<form action="${pageContext.request.contextPath}/addtocart" method="post" style="margin-top: 20px;"  onsubmit="return showPopup()">
	  <input type="hidden" name="book_id" value="<%= book.getBook_id() %>">
	  <input type="hidden" name="quantity" id="qtyValue" value="1">
	  <button type="submit" class="add-to-cart">Add to Cart</button>
	</form>
    
  </div>
</div>

  
  <% } else { %>
    <p style="text-align:center; color:red;">Book not found.</p>
<% } %>

<%@include file="/jsp/footer.jsp" %>

<script>
  function increaseQty() {
    const qtyInput = document.getElementById('quantity');
    let qty = parseInt(qtyInput.value);
    qtyInput.value = qty + 1;
    document.getElementById('qtyValue').value = qty + 1;
  }

  function decreaseQty() {
    const qtyInput = document.getElementById('quantity');
    let qty = parseInt(qtyInput.value);
    if (qty > 1) {
      qtyInput.value = qty - 1;
      document.getElementById('qtyValue').value = qty - 1;
    }
  }
 
  function showPopup() {
	    alert("✅ Book added to cart successfully!");
	    return true; // Allow form to submit after popup
	  }
</script>

</body>
</html>