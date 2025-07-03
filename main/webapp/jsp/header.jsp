<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%

    // Initialize necessary objects and variables
    HttpSession userSession = request.getSession(false);
    String currentUser = (String) (userSession != null ? userSession.getAttribute("username") : null);
    String contextPath = request.getContextPath();

    // Determine action URL and button label based on user session
    String actionUrl;
    String formMethod;
    String buttonLabel;

    if (currentUser != null) {
        actionUrl = contextPath + "/logout";
        formMethod = "post"; // Call doPost in LogoutController
        buttonLabel = "Logout";
    } else {
        actionUrl = contextPath + "/login";
        formMethod = "get"; // Call doGet in LoginController
        buttonLabel = "Login";
    }
%>

<div class="header">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/resources/images/system/Logo.webp" 
        alt="Jhandai Padheko Logo" /></a><p>Jhandai Padheko</p>
    </div>
<%
    String uri = request.getRequestURI();
    String path = uri.substring(request.getContextPath().length());
    boolean isHome = path.equals("/") || path.equals("/index") || path.equals("/home");
%>

<nav class="nav">
  <ul>
    <li>
    <a href="${pageContext.request.contextPath}/index" class="<%= uri.contains("/index") ? "active" : "" %>">
        Home
    </a>
</li>
    <li>
      <a href="${pageContext.request.contextPath}/books" class="<%= uri.contains("/books") ? "active" : "" %>">
        Books
      </a>
    </li>
    <li>
      <a href="${pageContext.request.contextPath}/audiobooks" class="<%= uri.contains("/audiobooks") ? "active" : "" %>">
        Audiobooks
      </a>
    </li>
    <li>
      <a href="${pageContext.request.contextPath}/about" class="<%= uri.contains("/about") ? "active" : "" %>">
        About        
      </a>
    </li>
  </ul>
</nav>
    <div class="user-actions">
    <a href="${pageContext.request.contextPath}/search" class="search-button" onclick="toggleSearchBar()">Search</a>
    
    <div id="searchBarContainer" class="search-bar-container">
    <form action="${pageContext.request.contextPath}/search" method="get" class="search-form">
        <input type="text" name="query" placeholder="Search books..." required class="search-input">
        <input type="submit" class="search-button"><value="Go">
    </form>
    </div>
    
    
    <script>
    function toggleSearchBar() {
        event.preventDefault();
        const searchBar = document.getElementById('searchBarContainer');
        searchBar.style.display = searchBar.style.display === 'none' ? 'block' : 'none';
    }
</script>

    <form action="<%= actionUrl %>" method="<%= formMethod %>" style="display:inline;">
        <input type="submit" class="login-button" value="<%= buttonLabel %>"/>
    </form>

    <%
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
    %>
        <!-- Show My Profile link only if logged in -->
        <a href="${pageContext.request.contextPath}/profile" class="profile-link">My Profile</a>
    <%
        } else {
    %>
        <a href="${pageContext.request.contextPath}/register" class="signup-button">Sign Up</a>
    <%
        }
    %>
</div>
    <button class="mobile-menu-button">Menu</button>
</div>
