<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Information</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span style = "margin-left: 44vw">Staff Information</span>
 <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
       
</header>
<h1 >Staff List</h1>
<a class = "add-button" href="<%=request.getContextPath()%>/newstaffform.jsp"><button>Add New Staff</button></a>
<c:if test="${not empty errorMessage}">
        <p style="color: red">${errorMessage}</p>
    </c:if>

<table border="1">
    <thead>
        <tr>
            <th>Staff ID</th>
            <th>Staff Name</th>
            <th>Contact No</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td>${staff.staffId}</td>
                <td>${staff.staffName}</td>
                <td>${staff.contactNo}</td>
                <td>
                    <a href="EditStaffServlet?staffId=${staff.staffId}">Edit</a>
                    <a href="DeleteStaffServlet?staffId=${staff.staffId}" onclick="return confirm('Are you sure you want to delete this staff?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
