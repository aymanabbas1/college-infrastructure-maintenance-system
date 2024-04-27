<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
 
</head>
<body>
<header>
<span style = "  margin-left: 48vw;">User</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
	<h1 style = "  margin-left: 45.5vw;">Edit User</h1>
	<form action="EditUserServlet" method="post">
		<label for="userId">User ID:</label> 
		<input type="text" name="userId" value="${user.userId}" readonly><br>
		
		<label for="username">Username:</label> 
		<input type="text" id="username" name="username" value="${user.username}" ><br> 
		<label for="password">Password:</label> 
		<input type="text" id="password" name="password" value="${user.password}" ><br> 	
		<!-- Add additional fields as needed -->
		<input type="submit" value="Submit">
	</form>
</body>
</html>