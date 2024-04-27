<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Staff</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
   
 <header>
<span style= "  margin-left: 49vw;">Staff</span>
		
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
 <h1 style = "  margin-left: 45.5vw;">Edit Staff</h1>
    <form action="EditStaffServlet" method="post">
        <label for="staffId">Staff ID:</label> 
        <input type="text" name="staffId" value="${staff.staffId}" readonly><br>
        
        <label for="staffName">Staff Name:</label> 
        <input type="text" id="staffName" name="staffName" value="${staff.staffName}" ><br> 
        <label for="contactNo">Contact No:</label> 
        <input type="text" id="contactNo" name="contactNo" value="${staff.contactNo}" ><br>   
        <!-- Add additional fields as needed -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
