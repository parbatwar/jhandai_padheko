<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Profile Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/profileview.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<%@ include file="/jsp/header.jsp"%>
	<div class="profile-banner">
		<h1>Hello ${user.firstName} ${user.lastName}</h1>
		<p>This is your profile page. You can see the progress you've made
			with your work and manage your projects or assigned tasks.</p>
	</div>

	<div class="profile-card">
		<div class="profile-pic-section">
			<a href="${pageContext.request.contextPath}/update">
				<button class="edit-btn">Edit Profile</button>
			</a>
			<div class="profile-picture">
			<img src="${pageContext.request.contextPath}/resources/images/uploads/linux-programmer-pixel-art-4k-ld.jpg" alt="Profile Picture"
					class="img-thumbnail" />
				<!-- <img src="${user.imagePath}" alt="Profile Picture"
					class="img-thumbnail" />
					<h3>${user.imagePath} </h3> -->
			</div>
			<div class="profile-actions">
				<!-- Add additional profile actions here if needed -->
			</div>
		</div>

		<div class="card-info">
			<h3>${user.firstName} ${user.lastName}</h3>
			<!-- Display first name, last name, and age -->

			<div class="additional-details">
				<div class="detail-item">
					<strong>Gender:</strong> ${user.gender}
				</div>
				<div class="detail-item">
					<strong>Phone:</strong> ${user.phone}
				</div>
				<div class="detail-item">
					<strong>Email:</strong> ${user.email}
				</div>
				<div class="detail-item">
					<strong>Date of Birth:</strong> ${user.dob != null ? user.dob : "N/A"}
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>
