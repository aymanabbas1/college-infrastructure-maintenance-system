 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service-Staff Assignment List</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">

</head>
<body>
<header>
<span style = "margin-left: 43vw;">Service-Staff Assignment</span>
		<a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
</header>
<h1 style = "  margin-left: 35vw;">Service-Staff Assignment List</h1>
<a class= "add-button" href="${pageContext.request.contextPath}/newprovidedbyform.jsp"><button>Add New Service-Staff Assignment</button></a>
<c:if test="${not empty errorMessage}">
        <p style="color: red">${errorMessage}</p>
    </c:if>

<table border="1">
    <thead>
        <tr>
            <th>Staff ID</th>
            <th>Service ID</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="providedBy" items="${providedByList}">
            <tr>
                <td>${providedBy.staffId}</td>
                <td>${providedBy.serviceId}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/EditProvidedByServlet?staffId=${providedBy.staffId}&serviceId=${providedBy.serviceId}">Edit</a>
                    <a href="${pageContext.request.contextPath}/DeleteProvidedByServlet?staffId=${providedBy.staffId}&serviceId=${providedBy.serviceId}" onclick="return confirm('Are you sure you want to delete this entry?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>