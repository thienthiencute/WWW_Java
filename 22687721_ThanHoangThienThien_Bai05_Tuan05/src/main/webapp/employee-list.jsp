<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/23/2025
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/images/HRbanner.png" height="200px"
         width="100%">
    <h2>Employees List</h2>
    <a href="${pageContext.request.contextPath}/employees?action=new">Add Employee</a>
    <br/><br/>
    <table class="table table-primary">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Department_Id</th>
            <th>Department_Name</th>
            <th>Action</th>
        </tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
                <td>${emp.department.dept_id}</td>
                <td>${emp.department.deptName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees?action=edit&id=${emp.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/employees?action=delete&id=${emp.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/departments"> Department</a>
</div>
</body>
</html>

