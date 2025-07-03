<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Privacy Policy - Jhadai Padheko Library</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/privacypolicy.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/footer.css"> 
</head>
<body>
<%@include file="/jsp/header.jsp" %>
    <div class="privacy-container">
        <div class="privacy-image">
            <img src="<%= request.getContextPath() %>/resources/images/statics/privacy.jpg" alt="Privacy">
        </div>
        <h1>Privacy and Policy</h1>
        <p>
            Your privacy while using the Jhadai Padheko Library system and its services is a critical part of your academic freedom. We are committed to safeguarding your personal data and digital identity. Our practices are in line with national and state-level data protection regulations, as well as university policies.
        </p>

        <p>
            All personally identifiable information, including borrowing history, login records, and digital access logs, are kept confidential. We do not disclose this information to any third party unless compelled by legal action such as a subpoena, court order, or legal warrant.
        </p>

        <h2>Data Collection and Usage</h2>
        <p>
            We only collect data that is essential to provide smooth library services. This may include your name, institutional email, user ID, and borrowing history. This data is used strictly for internal service improvements and communication purposes. We do not sell or share your data with advertisers or marketers.
        </p>

        <h2>Cookies and Tracking</h2>
        <p>
            Some third-party databases integrated with our library system may use cookies to personalize your experience. However, Jhadai Padheko Library itself does not track your online behavior or store cookies on your device. These third-party cookies are temporary and expire once the session ends.
        </p>

        <h2>Online Services and Third-party Links</h2>
        <p>
            Our digital catalog and library portal may contain links to external websites or databases. While we strive to ensure they uphold strong privacy standards, we are not responsible for their policies. We encourage users to read privacy policies of any third-party services accessed through our system.
        </p>

        <h2>Security and Encryption</h2>
        <p>
            To prevent unauthorized access and ensure data integrity, our system uses encrypted connections (HTTPS), secure login mechanisms, and periodic security audits. User credentials are hashed, and sensitive data is stored in a secure manner using role-based access control.
        </p>

        <h2>Email and Online Queries</h2>
        <p>
            Any communication through our support email or chat services is treated with strict confidentiality. Your information is not used for any purpose other than responding to your inquiry or improving our services.
        </p>

        <h2>User Rights and Consent</h2>
        <p>
            Users have the right to access, correct, or delete their personal information from our system. By using the Jhadai Padheko Library system, you agree to the terms outlined in this Privacy and Policy page. For any questions, concerns, or data requests, please contact our admin team.
        </p>

        <h2>Policy Updates</h2>
        <p>
            This policy is reviewed regularly and may be updated as needed to align with changes in regulations or our services. Continued use of the system after changes are posted implies acceptance of the revised terms.
        </p>

        <p class="feedback-note">
            📬 For feedback or questions, please use our <a href="#">feedback form</a> or contact us at: support@jhadaipadheko.edu
        </p>
    </div>
<%@include file="/jsp/footer.jsp" %>
</body>
</html>