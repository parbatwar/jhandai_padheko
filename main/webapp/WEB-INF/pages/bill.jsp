<%@ page import="java.util.*, com.jhandai_padheko.model.*" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bill - Purchase Summary</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Your Bill</h1>

    <%
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            out.println("<p>No items purchased.</p>");
        } else {
            float totalAmount = 0;
    %>

    <table border="1">
        <tr>
            <th>Book Title</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <%
            for (CartItem item : cart) {
                totalAmount += item.getTotalPrice();
        %>
        <tr>
            <td><%= item.getBook().getBook_title() %></td>
            <td><%= item.getBook().getBook_price() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getTotalPrice() %></td>
        </tr>
        <% } %>
    </table>

    <p><strong>Total Amount: </strong><%= totalAmount %></p>

    <h2>Payment Successful!</h2>
    <p>Thank you for your purchase. Your order has been processed successfully.</p>

    <a href="index.jsp">Return to Home</a>

    <%
        session.removeAttribute("cart");  // Clear the cart after purchase
    %>

    <% } %>
</body>
</html>
