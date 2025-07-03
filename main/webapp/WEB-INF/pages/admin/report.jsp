<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Page</title>
    <style>
        /* Reset and base font */
        body, html {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #2c3e50;
        }

        /* Page container */
        .container {
            padding: 40px;
            max-width: 800px;
            margin: 50px auto;
            background-color: white;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #34495e;
            font-size: 32px;
            margin-bottom: 30px;
        }

        .stat {
            font-size: 18px;
            margin: 12px 0;
            padding: 12px 20px;
            border-left: 5px solid #1f7a8c;
            background-color: #f4f6f8;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .stat:hover {
            background-color: #e6eff1;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Library Report Summary</h1>
        <div class="stat">📚 Total Books: ${totalBooks}</div>
        <div class="stat">💾 Total eBooks: ${totalEbooks}</div>
        <div class="stat">👤 Total Users: ${totalUsers}</div>
        <div class="stat">🛡 Total Admins: ${totalAdmins}</div>
        <div class="stat">👨 Male Users: ${maleUsers}</div>
        <div class="stat">👩 Female Users: ${femaleUsers}</div>
    </div>
</body>
</html>