<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Requests</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">

</head>
<body>

<!-- requests table with edit, delete option(with confirmation box)-->
<header>
<span style = "  margin-left: 46vw;">Requests</span>
		<a  href="request0.jsp"><button>Request Dashboard</button></a>
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>

<h1>Requests</h1>
    <table border="1">
        <thead>
            <tr>
            	<th>Request ID</th>
            	<th>Service Name</th>
                <th>User ID</th>
                <th>Location</th>
                <th>Date of Request</th>
                <th>Status</th>
                <th>Staff ID</th>
                <th>Date of Completion</th>
                
                <th>Actions</th> <!-- Column for edit and delete actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${requests}">
                <tr>
                	<td>${request.requestId}</td>
                	<td>${request.serviceName}</td>
                    <td>${request.userId}</td>
                    <td>${request.location}</td>
                    <td>${request.dateOfRequest}</td>
                    <td>${request.status}</td>
                    <td>${request.staffId}</td>
                    <td>${request.dateOfCompletion}</td>
                    <td>
                        <!-- Edit link to edit servlet -->
                        <a href="EditRequestServlet?requestId=${request.requestId}&bothVisible=${requestScope.bothVisible}">Edit</a>

                        <!-- Delete link to delete servlet with confirmation -->
                        
                        <!-- onclick is an inline JavaScript event handler attached to the anchor element's onclick event. 
                        When the user clicks on the anchor link, the JavaScript function confirm() is called, 
                        displaying a confirmation dialog with the message "Are you sure you want to delete this request?". 
                        If the user clicks "OK", the confirm() function returns true,
                        allowing the default action (navigating to the URL specified in the href attribute) to proceed. 
                        If the user clicks "Cancel", confirm() returns false, preventing the default action. -->
                        
                        <a href="DeleteRequestServlet?requestId=${request.requestId}" onclick="return confirm('Are you sure you want to delete this request?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>