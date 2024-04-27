<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New User Form</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
 <header>
<span style = "  margin-left: 49vw;">User</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
    <h1 style = "  margin-left: 42.5vw;">New User Form</h1>
    <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">

        <label for="userId">Username</label>
        <input type="text" id="username" name="username"><br>
        <label for="username">Password:</label>
        <input type="text" id="password" name="password"><br>
        <input type="submit" value="Add User">
    </form>
</body>
</html>
