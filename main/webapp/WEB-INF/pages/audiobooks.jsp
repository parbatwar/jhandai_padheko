<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AudioBooks</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/audiobooks.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>

<body class="body">
	<%@include file="/jsp/header.jsp"%>
	<div class="title">
		<h1>AUDIOBOOKS</h1>
	</div>


	<div style="margin-top: 80px;" class="audiobooks">

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/atomichabits.jpg"
				height="300px" alt="Atomic Habits" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;">
						<b>Atomic Habits</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By James Clear</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;"
				href="${pageContext.request.contextPath}/bookview"> <img
				src="${pageContext.request.contextPath}/resources/images/books/1984.png"
				height="300px" alt="1984" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;">
						<b>It Ends With Us</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Colleen Hoover</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/Knowing Gods Voice.jpg"
				height="300px" alt="Knowing God's Voice" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 300px;">
						<b>Knowing God's Voice</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Kenneth C. Ulmer</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/theMountainIsYou.jpg"
				height="300px" alt="TMIY" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-height: 100px;">
						<b>The Mountain is You</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Brianna Wiest</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>
	</div>

	<div style="margin-top: 50px;" class="audiobooks">

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/Ikigai.jpeg"
				height="300px" alt="Ikigai" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;">
						<b>Ikigai</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Miralles and
						Garcia</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;"
				href="${pageContext.request.contextPath}/bookview"> <img
				src="${pageContext.request.contextPath}/resources/images/books/Me Before You.jpg"
				height="300px" alt="Me Before You" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;">
						<b>Me Before You</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Jojo Moyes</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/Milk And Honey.jpg"
				height="300px" alt="Milk and Honey" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 300px;">
						<b>Milk and Honey</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Rupi Kaur</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>

		<div class="books-card">
			<a style="text-decoration: none;" href="#"> <img
				src="${pageContext.request.contextPath}/resources/images/books/Verity.jpg"
				height="300px" alt="Verity" />
				<div class="card-info">
					<p
						style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;">
						<b>Verity</b>
					</p>
					<p style="color: #747474; font-size: 14px;">By Colleen Hoover</p>
					<button class="dwn-button">Download</button>
				</div>
			</a>
		</div>
	</div>
	<%@include file="/jsp/footer.jsp"%>
</body>
</html>