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

<h2>Select the location details:</h2>
<form action="${pageContext.request.contextPath}/SubmitLocation" method="post">

    <label for="area">Area:</label>
    <select id="area" name="area">
        <option value="Washroom">Washroom</option>
        <option value="Classroom">Classroom</option>
        <option value="Hallways">Hallways</option>
    </select>
    <br><br>

    <label for="floor">Floor:</label>
    <select id="floor" name="floor">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
    <br><br>

    <input type="hidden" name="location" value="${param.location}">
    <input type="hidden" name="username" value="${param.username}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
