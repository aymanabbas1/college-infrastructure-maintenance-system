<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">

</head>
<body>
<header>
<span>Users</span>
		<a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
</header>

<c:if test="${not empty errorMessage}">
    <p style="color: red">${errorMessage}</p>
</c:if>
<h1>User List</h1>
<a class = "add-button" href="<%=request.getContextPath()%>/newuserform.jsp"><button>Add New User</button></a>


<table border="1">
    <thead>
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <a href="EditUserServlet?userId=${user.userId}">Edit</a>
                    <a href="DeleteUserServlet?userId=${user.userId}" onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
