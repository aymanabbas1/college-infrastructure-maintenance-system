<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Requests Dashboard</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin0.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span style = "  margin-left: 44.5vw;">Request Dashboard</span>
        <a  href="login.jsp"><button>Logout</button></a>
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
</header>

<c:if test="${not empty errorMessage}">
    <p style="color: red">${errorMessage}</p>
</c:if>
<h2>Requests Dashboard</h2>

<div class="container">
    <button onclick="location.href='${pageContext.request.contextPath}/CompletionAndStaffServlet'">View Requests with Pending Staff Assignments</button>
    <button onclick="location.href='${pageContext.request.contextPath}/CompletionPendingServlet'">View Requests with Completion Pending</button>
    <button onclick="location.href='${pageContext.request.contextPath}/RequestHistoryServlet'">View Request History</button>
    <button onclick="location.href='${pageContext.request.contextPath}/AddRequestServlet'">Add Request</button>
</div>
</body>
</html>
