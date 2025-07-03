<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us - Our Bookstore</title>
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/about.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>
<%@include file="/jsp/header.jsp" %>
    <div class="container">
        <!-- Header Section -->
        <div class="header-section">
            <h1>WELCOME TO JHANDAI PADEKO</h1>
            <p class="tagline">Books are a portable magic</p>
            <div class="intro-text">
                <p>Books are tiny universes bound between covers, waiting to unfold in your hands. At Jhandai Padeko, we believe every page turned leads to a new world — where imagination dances with knowledge and curiosity spreads its wings. We don’t just promote reading; we celebrate it as a lifestyle, a quiet stand against ignorance. With each book, we aim to spark minds, feed souls, and inspire a love for learning.</p>
                <p>Whether you're lost in fantasy, exploring history, or diving into self-growth, books offer a timeless escape — no batteries needed, just an open mind. In a world that never stops, they are your stillness, your adventure, your quiet companion. Jhandai Padeko is more than a name it's a home for seekers, dreamers, and thinkers. Welcome to a space where stories live and learning never ends.</p>
            </div>
        </div>

        <!-- Stats Section -->
        <div class="stats-section">
            <div class="stat-number">18k</div>
            <div class="stat-description">BOOKS HAVE BEEN PUBLISHED</div>
            <div class="quote">
                <p>"Sometimes, you read a book and it fills you with this weird evangelical zeal, and you become convinced that the shattered world will never be put back together unless and until all living humans read the book."</p>
                <p class="author">- Mohamed Arafa</p>
            </div>
        </div>

        <!-- Team Section -->
        <div class="team-section">
            <h2>OUR TEAM</h2>
            <div class="team-members">
                <div class="team-member">
                    <div class="member-photo">
                        <img src="${pageContext.request.contextPath}/resources/images/system/Nikku.jpeg" class="profile-pic">
                    </div>
                    <h3>Nikesh Simkhada</h3>
                    <p>Founder & CEO</p>
                </div>
                <div class="team-member">
                    <div class="member-photo">
                        <img src="${pageContext.request.contextPath}/resources/images/system/Prastuti.jpeg" class="profile-pic">
                    </div>
                    <h3>Prastuti Acharya</h3>
                    <p>Head of Operations</p>
                </div>
                <div class="team-member">
                    <div class="member-photo">
                        <img src="${pageContext.request.contextPath}/resources/images/system/Parbat.jpeg" class="profile-pic">
                    </div>
                    <h3>Parbat Sunuwar</h3>
                    <p>Marketing Director</p>
                </div>
                <div class="team-member">
                    <div class="member-photo">
                        <img src="${pageContext.request.contextPath}/resources/images/system/Preeti.jpeg" class="profile-pic">
                    </div>
                    <h3>Preeti Kharel</h3>
                    <p>Content Curator</p>
                </div>
                <div class="team-member">
                    <div class="member-photo">
                        <img src="${pageContext.request.contextPath}/resources/images/system/Kribeep.jpg" class="profile-pic">
                    </div>
                    <h3>Kribeep Thapa</h3>
                    <p>Customer Relations</p>
                </div>
            </div>
        </div>

        <!-- Additional Info Section -->
        <div class="info-section">
            <h2>OUR STORY</h2>
            <p>Once upon a time, not in a castle, but in a quiet corner of Kathmandu, a group of curious minds sat under a flickering tube light, surrounded by borrowed books, half-sipped tea, and dreams bigger than the pages they turned. They were students, thinkers, and late-night learners, united by one simple truth: knowledge is freedom, and books are the wings.</p>
            <p>They called themselves “Jhandai Padeko” — a name born out of realness, hustle, and humor. It started as an inside joke, but soon became a proud identity. Because let’s be honest — we've all been there, cramming last-minute, juggling assignments and reality. But in that chaos, we also discovered something magical: books weren’t just study materials — they were portals. Escape rooms. Mentors. Mirrors. Friends.</p>
            <p>And so, the dream was born — to create a space where every learner, whether jhandai padeko or deeply invested, could explore, share, and grow. Not just a library system, but a community. A digital haven where the pressure fades and passion rises. A place where your reading list is not just about passing, but about becoming.</p>
            <p>Today, Jhandai Padeko Library Management System stands as a tribute to that spirit — built by students, for students, with love, laughter, and a whole lot of late-night motivation. We invite you to be a part of this journey — borrow a book, chase a thought, and lose yourself in the magic of stories.</p>
            <div class="download-btn">
            </div>
        </div>
    </div>
<%@include file="/jsp/footer.jsp" %>
</body>
</html>