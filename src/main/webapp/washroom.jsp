<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Form</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
</head>
<body>
<header>
    
       <span>Request</span>
        <a  href="login.jsp"><button>Logout</button></a>
   
</header>

<h2>Washroom Service Selection:</h2>
<form action="${pageContext.request.contextPath}/UserFormServlet" method="post">

    <label for="service">Select Service Required:</label>
    <select id="service" name="service">
        <option value="infrastructure repair">Infrastructure Repair</option>
        <option value="plumbing">Plumbing</option>
    </select>
    <br><br>
    
    <input type="hidden" name="location" value="${location}">
    <input type="hidden" name="username" value="${username}">
    <input type="hidden" name="floor" value="${floor}">
    <input type="hidden" name="area" value="Washroom">
    
    <input type="submit" value="Submit">
</form>
</body>
</html>
