<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/8/2025
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Information</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f8fcff; }
        .container { width: 600px; margin: 40px auto; border: 1px solid #b3d1e0; border-radius: 8px; background: #fff; padding: 25px 35px; }
        h2 { text-align: center; color: #2a456b; }
        p, ul { font-size: 16px; color: #234; }
        b { color: #235689; }
        ul { margin-top: 0; }
        h3 { margin-bottom: 7px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Student Information</h2>
    <p><b>Name:</b> ${student.firstName} ${student.lastName}</p>
    <p><b>Date of Birth:</b> ${student.dateOfBirth}</p>
    <p><b>Email:</b> ${student.email}</p>
    <p><b>Mobile:</b> ${student.phoneNumber}</p>
    <p><b>Gender:</b> ${student.gender}</p>
    <p><b>Address:</b> ${student.address}, ${student.city}, ${student.state}, ${student.country}</p>


    <h3>Hobbies:</h3>
    <ul>
        <c:forEach var="h" items="${student.hobbies}">
            <li>${h}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
