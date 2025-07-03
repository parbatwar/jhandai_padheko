<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Your Account</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/register.css">
</head>
<body>
	<div class="register-container">
		<h1 class="register-title">Create Your Account</h1>
		<%
		String errorMessage = (String) request.getAttribute("error");
		String successMessage = (String) request.getAttribute("success");

		if (errorMessage != null && !errorMessage.isEmpty()) {
			out.println("<p class = \"error-message\">" + errorMessage + "</p>");
		}

		if (successMessage != null && !successMessage.isEmpty()) {
		%>
		<p class="success-message"><%=successMessage%>
			<%
			}
			%>
		
		<form class="form-grid" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>First Name</label> <input type="text" name="firstName"
					required>
			</div>
			<div class="form-group">
				<label>Last Name</label> <input type="text" name="lastName" required>
			</div>

			<div class="form-group">
				<label>Date of Birth</label> <input type="date" name="dob" required>
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="gender-options">
					<div class="gender-option">
						<input type="radio" id="male" name="gender" value="male" required>
						<label for="male">Male</label>
					</div>
					<div class="gender-option">
						<input type="radio" id="female" name="gender" value="female">
						<label for="female">Female</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label>Email</label> <input type="email" name="email" required>
			</div>

			<div class="form-group">
				<label>Phone Number</label> <input type="text" name="phone" required
					maxlength="10" pattern="\d{10}"
					title="Phone number must be exactly 10 digits">
			</div>
			<!-- 
            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" name="phone" required>
            </div> 
            -->

			<style>
.file-upload {
	position: relative;
	display: inline-block;
}

.file-upload input[type="file"] {
	display: none;
}

.file-upload-label {
	background-color: #FFC107; /* Your yellow theme */
	color: black;
	padding: 10px 20px;
	border-radius: 5px;
	font-weight: bold;
	cursor: pointer;
	border: none;
	display: inline-block;
	transition: background 0.3s;
}

.file-upload-label:hover {
	background-color: #e0a800; /* Darker yellow on hover */
}
</style>

			<div class="form-group">
				<label>Upload Profile Picture</label><br>
				<div class="file-upload">
					<label for="profilePic" class="file-upload-label">Choose
						Picture</label> <input type="file" name="image" id="profilePic"
						accept="image/*" required>
				</div>
			</div>

			<div class="form-group">
				<label>Username</label> <input type="text" name="username" required>
			</div>

			<!-- Row 5 -->
			<div class="form-group">
				<label>Password</label> <input type="password" name="password"
					required>
			</div>
			<div class="form-group">
				<label>Confirm Password</label> <input type="password"
					name="confirmpassword" required>
			</div>

			<!-- Full width row -->
			<div class="terms-checkbox full-width">
				<input type="checkbox" id="terms" name="terms" required> <label
					for="terms">I agree to the Term and conditions of Jhandai
					Padheko and Privacy policy.</label>
			</div>

			<div class="full-width">
				<button type="submit" class="register-btn">Register</button>
			</div>

			<div class="login-link full-width">
				Already have an account? <a
					href="${pageContext.request.contextPath}/login">Log in</a>
			</div>
		</form>
	</div>
</body>
</html>