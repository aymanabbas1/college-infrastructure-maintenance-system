<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>New Service Form</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
    
    
</head>
<body>
<header>
<span>Service</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
    <h1 style = "  margin-left: 41vw;">New Service Form</h1>
    <form action="${pageContext.request.contextPath}/AddServiceServlet" method="post">

       <!--  <label for="serviceId">Service Id:</label>
        <input type="text" id="serviceId" name="serviceId"><br> -->
        <label for="serviceName">Service Name:</label>
        <input type="text" id="serviceName" name="serviceName"><br>
        <input type="submit" value="Add Service">
    </form>
</body>
</html>
