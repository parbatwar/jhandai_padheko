<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        .social-login {
            display: flex;
            flex-direction: column;
            width: 100%;
            margin-top: 20px; /* Add space below "Forgot Password?" */
        }

        .social-button {
            display: flex;
            align-items: center;
            justify-content: center;
            border: none;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
            cursor: pointer;
            color: #fff;
            transition: background-color 0.3s ease;
        }

        .social-button:hover {
            opacity: 0.8;
        }

        .social-button img {
            max-height: 24px;
            margin-right: 10px;
        }

        .social-apple {
            background-color: #333; /* Dark background for Apple */
            color: #f8f9fa; /* White text */
        }

        .social-google {
            background-color: #ffc107; /* White background for Google */
            color: #333; /* Dark text for Google */
            border: 1px solid #ddd; /* Add a border */
        }

        .social-facebook {
            background-color: #1877f2; /* Facebook blue */
            color: #f8f9fa; /* White text */
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="logo-container">
            <img src="<%= request.getContextPath() %>/resources/images/system/logo.jpeg" alt="Website Logo">
        </div>
        <div class="form-section">
            <h2>User Login</h2>
            <%
        String errorMessage = (String) request.getAttribute("error");
        String successMessage = (String) request.getAttribute("success");
        
        if (errorMessage != null && !errorMessage.isEmpty()){
        	out.println("<p class = \"error-message\">" + errorMessage + "</p>");
        }
        
        if (successMessage != null && !successMessage.isEmpty()){
        %>
        <p class="success-message"><%=successMessage%>
        <%
        }
        %>
            <form action="login" method="post">
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="text" id="username" name="username" placeholder="Username" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="login-button">Login</button>
            </form>
            <div class="forgot-password">
                <a href="#">Forgot Password?</a>
            </div>

            <div class="social-login">
                <button class="social-button social-apple">
                    <img src="<%= request.getContextPath() %>/resources/images/system/apple.jpeg" alt="Apple">
                    Continue with Apple
                </button>
                <button class="social-button social-google">
                    <img src="<%= request.getContextPath() %>/resources/images/system/google.jpeg" alt="Google">
                    Continue with Google
                </button>
                <button class="social-button social-facebook">
                    <img src="<%= request.getContextPath() %>/resources/images/system/facebook.jpeg" alt="Facebook">
                    Continue with Facebook
                </button>
                <div class= "register-link full-width">
                	Don't have an account? <a href="${pageContext.request.contextPath}/register">Register Account</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>