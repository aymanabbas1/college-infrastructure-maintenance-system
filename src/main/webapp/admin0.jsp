<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
     
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin0.css">
   
</head>
<body>
<header>
    
       <span>Admin Dashboard</span>
        <a href="login.jsp"><button>Logout</button></a>
   
</header>

<h2>Welcome, Admin</h2>
<div class="container">
    <button onclick="location.href='request0.jsp'">Requests</button>
    <button onclick="window.location.href='<%=request.getContextPath()%>/UserServlet'">Users Information</button>
    <button onclick="window.location.href='<%=request.getContextPath()%>/ServiceServlet'">Services Provided</button>
    <button onclick="window.location.href='<%=request.getContextPath()%>/ProvidedByServlet'">Service-Staff Assignment</button>
    <button onclick="window.location.href='<%=request.getContextPath()%>/StaffServlet'">Staff Information</button>
</div>
</body>
</html>
