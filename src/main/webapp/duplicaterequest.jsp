<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Duplicate Request</title>
 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
</head>
<body>
<header>
    
       <span>Request</span>
        <a href="login.jsp"><button>Logout</button></a>
   
</header>

<p style= "text-align:center;">
    The request has already been alerted. The department will take care of it soon. Thank you for your time. 
</p>
</body>
</html>