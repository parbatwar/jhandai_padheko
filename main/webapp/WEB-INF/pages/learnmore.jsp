<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Learn More - Jhandai Padheko</title>
  <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/learnmore.css" />
</head>
<body>
<%@ include file="/jsp/header.jsp" %>
 <div class="learn-more-container">

  <div class="section">
    <img src="${pageContext.request.contextPath}/resources/images/statics/books.jpg" alt="Books"/>
    <div class="text">
      <h2>What is Jhandai Padheko?</h2>
      <p>Jhandai Padheko is a modern Library Management System designed for schools, colleges, and institutions in Nepal. From tracking books to managing members, it does it all digitally — goodbye paper records, hello automation!</p>
    </div>
  </div>

  <div class="section">
    <img src="${pageContext.request.contextPath}/resources/images/statics/choice.jpg" alt="Choice"/>
    <div class="text">
      <h2>Why Choose Jhandai Padheko?</h2>
      <p>It’s fast, intuitive, and built with Nepali users in mind. Whether you’re a librarian managing hundreds of students or an institution seeking insights through reports — this system fits all.</p>
      <ul>
        <li>Sleek and Simple UI</li>
        <li>Easy to deploy</li>
        <li>Scalable for big institutions</li>
      </ul>
    </div>
  </div>

  <div class="section">
    <img src="${pageContext.request.contextPath}/resources/images/statics/users.jpg" alt="Users"/>
    <div class="text">
      <h2>Who Can Use It?</h2>
      <p><strong>📘 Librarians:</strong> Manage books, members, and fines efficiently.<br>
         <strong>🎓 Students:</strong> Search, borrow, and track books easily.<br>
         <strong>🏫 Institutions:</strong> Generate reports and digitize the library system.
      </p>
    </div>
  </div>

  <div class="section">
    <img src="${pageContext.request.contextPath}/resources/images/statics/reports.jpg" alt="Reports"/>
    <div class="text">
      <h2>Key Features</h2>
      <div class="features">
        <div class="feature-box">
          <h3>📚 Book Catalog</h3>
          <p>Search, add, and categorize books with ease.</p>
        </div>
        <div class="feature-box">
          <h3>👥 Member Management</h3>
          <p>Track user profiles, activity, and borrowing history.</p>
        </div>
        <div class="feature-box">
          <h3>🔁 Borrow and Return</h3>
          <p>Quick check-in/out with automated due alerts.</p>
        </div>
        <div class="feature-box">
          <h3>💰 Fine Tracking</h3>
          <p>Auto-calculate late fines with real-time records.</p>
        </div>
        <div class="feature-box">
          <h3>📊 Reports</h3>
          <p>View detailed usage trends, logs, and stats.</p>
        </div>
        <div class="feature-box">
  			<h3>🔐 Admin Controls</h3>
  			<p>Manage roles, permissions, and secure system settings.</p>
		</div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/jsp/footer.jsp" %>
</body>
</html>
