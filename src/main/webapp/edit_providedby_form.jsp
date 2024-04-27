<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Service-Staff Assignment</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span style = "  margin-left: 42.5vw;">Service-Staff Assignment</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
    <h1 style = "  margin-left: 35vw;">Edit Service-Staff Assignment</h1>
    <form action="EditProvidedByServlet" method="post">
        <!-- Old values -->
        <label for="oldStaffId">Old Staff ID:</label>
        <input type="text" name="oldStaffId" value="${providedBy.staffId}" readonly><br>
        <label for="oldServiceId">Old Service ID:</label>
        <input type="text" name="oldServiceId" value="${providedBy.serviceId}" readonly><br>
        
        <!-- New values -->
        <label for="newStaffId">New Staff ID:</label>
        <input type="text" id="newStaffId" name="newStaffId" value=""><br>
        <label for="newServiceId">New Service ID:</label>
        <input type="text" id="newServiceId" name="newServiceId" value=""><br>
        
        <!-- Add additional fields as needed -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
