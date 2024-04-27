<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Service-Staff Assignment Form</title>
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
    <h1 style="  margin-left: 32vw;">New Service-Staff Assignment Form</h1>
    <form action="${pageContext.request.contextPath}/AddProvidedByServlet" method="post">

        <label for="staffId">Staff ID:</label>
        <input type="text" id="staffId" name="staffId"><br>
        <label for="serviceId">Service ID:</label>
        <input type="text" id="serviceId" name="serviceId"><br>
        <!-- Add more input fields as needed -->

        <input type="submit" value="Add Service-Staff Assignment">
    </form>
</body>
</html>
