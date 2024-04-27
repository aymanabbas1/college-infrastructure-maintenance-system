<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Services</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span>Services</span>
		<a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
</header>


<h1>Service List</h1>
<a class = "add-button" href="<%=request.getContextPath()%>/newserviceform.jsp"><button>Add New Service</button></a>
<c:if test="${not empty errorMessage}">
        <p style="color: red">${errorMessage}</p>
    </c:if>

<table border = "1">
    <thead>
        <tr>
            <th>Service ID</th>
            <th>Service Name</th>
             <th>Actions</th>
            <!-- Add more columns as needed -->
        </tr>
    </thead>
    <tbody>
        <c:forEach var="service" items="${services}">
            <tr>
                <td>${service.serviceId}</td>
                <td>${service.serviceName}</td>
                 <td>
                    <a href="EditServiceServlet?serviceId=${service.serviceId}">Edit</a>
                    <a href="DeleteServiceServlet?serviceId=${service.serviceId}" onclick="return confirm('Are you sure you want to delete this service?')">Delete</a>
                </td>
                <!-- Add more columns as needed -->
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>