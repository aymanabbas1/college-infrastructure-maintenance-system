<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Request</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span>Requests</span>
		<a  href="request0.jsp"><button>Request Dashboard</button></a>
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
<h2>Edit Request</h2>
<form action="EditRequestServlet" method="post">
    <label for="requestId">Request ID:</label>
    <input type="text" name="requestId" value="${request.requestId}" readonly><br>
    <label for="userId">User ID:</label>
    <input type="text" id="userId" name="userId" value="${request.userId}" readonly><br>
    <label for="serviceName">Service Name:</label>
    <input type="text" name="serviceName" value="${request.serviceName}" readonly><br>
    <label for="location">Location:</label>
    <input type="text" id="location" name="location" value="${request.location}" readonly><br>
    <label for="dateOfRequest">Date of Request:</label>
    <input type="date" id="dateOfRequest" name="dateOfRequest" value="${request.dateOfRequest}" readonly><br>
    <label for="status">Status:</label>
    <input type="text" name="status" value="${request.status}" readonly><br>
    <label for="staffId">Staff ID:</label>
    <input type="text" id="staffId" name="staffId" value="${request.staffId}"><br>
    <label for="dateOfCompletion">Date of Completion:</label>
    <input type="date" id="dateOfCompletion" name="dateOfCompletion" value="${request.dateOfCompletion}" readonly><br>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
