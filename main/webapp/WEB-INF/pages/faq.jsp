<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frequently Asked Questions</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/faq.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<div class = "body">
	<div class= "title"><h1>Frequently Asked Questions</h1></div>
	<br>
	
	<div class= "box">
	<div class= "question">What is Jhandai Padheko?</div>
	<p><b>Jhandai Padheko</b> is a Library Management System designed to help students, faculty, and staff manage their library activities such as searching for books, borrowing, returning, and reserving materials.</p>
	</div>
	
	<div class= "box">
	<div class= "question">Who can use this system?</div>
	<p>All registered library members, including students, faculty, and staff of the institution, can access and use the system. A valid user account is required to log in.</p>
	</div>
	
	<div class= "box">
	<div class= "question">How do I register or log in?</div>
	<p>You can register through the official registration form provided by the library. Once registered, you can log in using your provided username and password.</p>
	</div>
	
	<div class= "box">
	<div class= "question">How can I search for a book?</div>
	<p>Use the search bar on the homepage to find books by title, author, ISBN, or category. Advanced search options are also available.</p>
	</div>
	
	<div class= "box">
	<div class= "question">How do I borrow a book?</div>
	<p>Once logged in: <br>• Search for the desired book. <br>• Click “Borrow” if the book is available. <br>• Visit the library to collect the physical copy or access the digital version if available.</p>
	</div>
	
	<div class= "box">
	<div class= "question">What happens if I return a book late?</div>
	<p>Late returns are subject to fines as per the library's policy. Your account may also be temporarily suspended until overdue items are returned.</p>
	</div>
	
	<div class= "box">
	<div class= "question">What should I do if I lose or damage a book?</div>
	<p>Please report the lost or damaged item to the library immediately. You may need to pay a replacement fee based on the library’s policy.</p>
	</div>
	
	<div class= "box">
	<div class= "question">How do I update my account details?</div>
	<p>Go to your profile section after logging in and click "Edit Profile" to update your contact info or password.</p>
	</div>
	
	<div class= "box">
	<div class= "question">Is my personal data safe?</div>
	<p>Yes. We collect only the information necessary to manage your library account and do not share your data with third parties without consent.</p>
	</div>
	
	<div class= "box">
	<div class= "question">Whom do I contact for help or support?</div>
	<p>For any technical issues or questions, contact the library help desk or email us at <u>support@jhandaipadheko.com.</u></p>
	</div>
	
</div>
<%@include file="/jsp/footer.jsp" %>
</body>
</html>