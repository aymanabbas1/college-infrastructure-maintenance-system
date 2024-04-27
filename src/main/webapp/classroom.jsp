<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<h2>Classroom Service Selection:</h2>
<form action="${pageContext.request.contextPath}/UserFormServlet" method="post">
    <label for="service">Select Service Required:</label>
    <select id="service" name="service">
        <option value="fan repair">Fan Repair</option>
        <option value="lights repair">Lights Repair</option>
        <option value="projector repair">Projector Repair</option>
        <option value="table-chair/bench repair">Table/Chair/Bench Repair</option>
        <option value="switchboard repair">Switchboard Repair</option>
    </select>
    <br><br>
    
    <!-- Classroom Number Selection based on the selected floor -->
    <label for="classroomNumber">Select Classroom Number:</label>
    <select id="classroomNumber" name="classroomNumber">
        <%
            // Get the selected floor from the previous page
            String floor = request.getParameter("floor");
            
            // Generate classroom numbers based on the selected floor
            int startClassroomNumber = Integer.parseInt(floor) * 100 + 1;
            int endClassroomNumber;
            if (floor.equals("5")) {
                endClassroomNumber = 509;
            } else {
                endClassroomNumber = Integer.parseInt(floor) * 100 + 29; // Assuming 28 classrooms per floor
            }
            
            for (int i = startClassroomNumber; i < endClassroomNumber; i++) {
                %>
                <option value="<%= i %>"><%= i %></option>
                <%
            }
        %>
    </select>
    <br><br>
    
    <!-- Hidden fields to pass the location, floor, and area values received from the previous page -->
    <input type="hidden" name="location" value="${location}">
    <input type="hidden" name="floor" value="${floor}">
    <input type="hidden" name="area" value="Classroom">
      <input type="hidden" name="username" value="${username}">
    
    <input type="submit" value="Submit">
</form>
</body>
</html>
</html>
