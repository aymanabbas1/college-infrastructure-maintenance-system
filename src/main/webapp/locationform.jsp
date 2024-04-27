<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Form</title>
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
</head>
<body>
<header>
    
       <span>Request</span>
        <a href="login.jsp"><button>Logout</button></a>
   
</header>

<h2>Select the location where you require a service:</h2>
<form action="submitlocation.jsp" method="post">
    <label for="location">Location:</label>
    <select id="location" name="location">
        <option value="Main Block">Main Block</option>
        <option value="Mech Block">Mech Block</option>
    </select>
    <input type="hidden" name="username" value="${param.username}">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
