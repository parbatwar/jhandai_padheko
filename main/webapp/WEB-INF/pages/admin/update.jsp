<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Update User</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/update.css" />
</head>
<body>
<div class="container">
    <h2>Update User</h2>
    
    <form method="post" action="${pageContext.request.contextPath}/update">
        <input type="hidden" name="userId" value="${user.user_id}" />

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${user.firstName}" required />

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${user.lastName}" required />

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required />

        <label for="dob">DOB:</label>
        <input type="date" id="dob" name="dob" value="${user.dob}" required />

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
            <option value="Other" ${user.gender == 'Other' ? 'selected' : ''}>Other</option>
        </select>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required />

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" required />

        <button type="submit">Update User</button>
    </form>

    <a href="${pageContext.request.contextPath}/adminusers">Back to User List</a>
</div>
</body>
</html>