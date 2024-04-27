<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Service</title>
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span>Services</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
    <h1>Edit Service</h1>
    <form action="EditServiceServlet" method="post">
    	<label for="serviceName">Service Name:</label>
        <input type="text" name="serviceId" value="${service.serviceId}" readonly> 
        <!-- Hidden field for service ID -->
        <label for="serviceName">Service Name:</label>
        <input type="text" id="serviceName" name="serviceName" value="${service.serviceName}"><br>
        <!-- Add additional fields as needed -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
