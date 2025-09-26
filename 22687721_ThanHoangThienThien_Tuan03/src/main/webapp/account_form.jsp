<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/8/2025
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background: #fafcff;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 480px;
            margin: 40px auto;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 24px rgba(0,0,0,0.08);
            padding: 36px 32px 28px 32px;
        }
        h1 {
            text-align: center;
            font-size: 2rem;
            margin-bottom: 32px;
            color: #222;
        }
        .row {
            display: flex;
            gap: 16px;
            margin-bottom: 18px;
        }
        .row input, .row select {
            flex: 1;
        }
        input, select {
            width: 100%;
            padding: 14px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 1rem;
            margin-bottom: 0;
            box-sizing: border-box;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-size: 1rem;
            color: #333;
        }
        .gender-row {
            display: flex;

            margin-bottom: 26px;

        }
        .gender-row label {
            margin-bottom: 0;
            font-weight: normal;
            color: #222;
        }
        .btn {
            width: 100%;
            padding: 14px;
            background: #1675fa;
            color: #fff;
            font-size: 1.2rem;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 16px;
            font-weight: bold;
        }
        .btn:hover {
            background: #0d5dd6;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>User Registration Form</h1>
    <form method="post" action="registerform">
        <div class="row">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
        </div>
        <div class="row">
            <input type="email" name="email" placeholder="Your Email" required>
        </div>
        <div class="row">
            <input type="password" name="password" placeholder="Password" required>
        </div>
        <label>Birthday</label>
        <div class="row">
            <select name="month" required>
                <option value="">Month</option>
                <option value="01">January</option>
                <option value="02">February</option>
                <option value="03">March</option>
                <option value="04">April</option>
                <option value="05">May</option>
                <option value="06">June</option>
                <option value="07">July</option>
                <option value="08">August</option>
                <option value="09">September</option>
                <option value="10">October</option>
                <option value="11">November</option>
                <option value="12">December</option>
            </select>
            <select name="day" required>
                <option value="">Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                <option value="<%= String.format("%02d", i) %>"><%= i %></option>
                <% } %>
            </select>
            <select name="year" required>
                <option value="">Year</option>
                <% for(int y = 1960; y <= 2025; y++) { %>
                <option value="<%= y %>"><%= y %></option>
                <% } %>
            </select>
        </div>
        <label>Gender</label>
        <div class="gender-row">
            <input type="radio" id="female" name="gender" value="Female" required>
            <label for="female">Female</label>
            <input type="radio" id="male" name="gender" value="Male">
            <label for="male">Male</label>
        </div>
        <button type="submit" class="btn">Sign Up</button>
    </form>
</div>
</body>
</html>
