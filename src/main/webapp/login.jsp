<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
<nav>
    <ul>
        <li><span>College Infrastructure Maintenance System</span></li> <!-- Title -->
        
    </ul>
</nav>
<c:if test="${not empty errorMessage}">
        <p style="color: red">${errorMessage}</p>
    </c:if>
    <h2>Login</h2>
    
    
    <form action = "LoginServlet" method = "post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
    
<!-- Your content after login goes here -->
    
    
</body>
</html>
