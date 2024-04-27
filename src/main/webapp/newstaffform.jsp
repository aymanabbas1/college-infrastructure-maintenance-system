<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Staff Form</title>
       <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span style = "  margin-left: 49vw;">Staff</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
    <h1 style = "  margin-left: 42.5vw;">New Staff Form</h1>
    <form action="${pageContext.request.contextPath}/AddStaffServlet" method="post">

        <label for="staffName">Staff Name:</label>
        <input type="text" id="staffName" name="staffName"><br>
        
        <label for="contactNo">Contact Number:</label>
        <input type="text" id="contactNo" name="contactNo"><br>
        
        <input type="submit" value="Add Staff">
    </form>
</body>
</html>
