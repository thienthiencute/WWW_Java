<%@ page import="bai02.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/8/2025
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f7fafd; }
        h1 { text-align: center; }
        table { margin: 0 auto; border-collapse: collapse; width: 80%; background: #fff; }
        th, td { border: 1px solid #cbd5e1; padding: 10px 14px; text-align: center; }
        th { background: #1675fa; color: #fff; }
        tr:nth-child(even) { background: #f0f5ff; }
    </style>
</head>
<body>
<h1>Account List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <!-- <th>Gender</th> Nếu có trường gender thì thêm cột này -->
    </tr>
    <%
        List<Account> accounts = (List<Account>) request.getAttribute("accounts");
        if (accounts != null && !accounts.isEmpty()) {
            for (Account acc : accounts) {
    %>
    <tr>
        <td><%= acc.getId() %></td>
        <td><%= acc.getFirstname() %></td>
        <td><%= acc.getLastname() %></td>
        <td><%= acc.getEmail() %></td>
        <td><%= acc.getDateOfBirth() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No account found.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
