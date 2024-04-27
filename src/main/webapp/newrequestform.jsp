<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Request</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/locationform.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/crud.css">
</head>
<body>
<header>
<span>Requests History</span>
		<a  href="request0.jsp"><button>Request Dashboard</button></a>
        <a  href="admin0.jsp"><button>Admin Dashboard</button></a>
        <a  href="login.jsp"><button>Logout</button></a>
        
        
</header>
<h2>New Request</h2>
<form action="${pageContext.request.contextPath}/AddRequestServlet" method="post">
    <label for="serviceName">Service Name:</label>
    <select id="serviceName" name="serviceName">
        <option value="infrastructure repair">Infrastructure Repair</option>
        <option value="plumbing">Plumbing</option>
        <option value="table-chair/bench repair">Table/Chair/Bench Repair</option>
        <option value="lights repair">Lights Repair</option>
        <option value="fan repair">Fan Repair</option>
        
        <option value="projector repair">Projector Repair</option>
        <option value="switchboard repair">Switchboard Repair</option>
    </select>
    <br><br>
    <label for="location">Location:</label>
    <input type="text" id="location" name="location"><br><br>
    <input type="submit" value="Add Request">
</form>
</body>
</html>
