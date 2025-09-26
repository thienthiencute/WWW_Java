<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/8/2025
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f8fcff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 98%;
            max-width: 900px;
            margin: 20px auto;
            border: 1px solid #b3d1e0;
            border-radius: 8px;
            background: #fff;
            padding: 25px 30px 20px 30px;
            box-shadow: 0 2px 8px rgba(100, 160, 200, 0.07);
        }
        h1{
            text-align: center;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            font-weight: 600;
            color: #2a456b;
        }

        form {
            width: 100%;
        }

        .row {
            display: flex;
            gap: 20px;
            margin-bottom: 15px;
            align-items: center;
        }

        .row label {
            min-width: 100px;
            color: #333;
            font-weight: 500;
        }

        .row input[type="text"],
        .row input[type="email"],
        .row input[type="date"],
        .row input[type="number"],
        .row select,
        .row textarea {
            flex: 1;
            padding: 7px 10px;
            border: 1px solid #b3d1e0;
            border-radius: 4px;
            font-size: 15px;
            background: #f7fbff;
            transition: border 0.2s;
        }

        .row textarea {
            resize: vertical;
            min-height: 36px;
            max-height: 90px;
        }

        .row input:focus,
        .row select:focus,
        .row textarea:focus {
            border: 1.5px solid #5ca6e6;
            background: #eef6fb;
            outline: none;
        }

        .gender,
        .hobbies,
        .course {
            display: flex;
            gap: 20px;
            align-items: center;
        }

        .gender label,
        .hobbies label,
        .course label {
            min-width: unset;
            margin-right: 8px;
        }

        .gender input[type="radio"],
        .course input[type="radio"],
        .hobbies input[type="checkbox"] {
            margin-right: 6px;
            accent-color: #3f88c5;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 12px;
        }

        th, td {
            border: 1px solid #b3d1e0;
            padding: 7px 5px;
            text-align: center;
            background: #fafeff;
            font-size: 15px;
        }

        th {
            background: #e6f2fa;
            font-weight: 600;
            color: #336699;
        }

        .actions {
            text-align: center;
            margin-top: 18px;
        }

        .actions button {
            padding: 7px 23px;
            margin: 0 7px;
            border: none;
            border-radius: 4px;
            font-size: 15px;
            font-weight: 500;
            cursor: pointer;
            background: #3498db;
            color: #fff;
            transition: background 0.18s;
        }

        .actions button[type="reset"] {
            background: #888;
        }

        .actions button:hover {
            background: #217dbb;
        }
    </style>
</head>
<body class="container">
<h1>Student Registration Form</h1>
<form action="student" method="get">
    <!-- Personal Info Row -->
    <div class="row">
        <label>First Name</label><input type="text" name="firstName">
        <label>Last Name</label><input type="text" name="lastName">
    </div>
    <div class="row">
        <label>Date of Birth</label><input type="date" name="dateOfBirth">
    </div>
    <div class="row">
        <label>Email</label><input type="email" name="email">
        <label>Mobile</label><input type="text" name="mobile">
    </div>
    <div class="row gender">
        <label>Gender</label>
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female
    </div>
    <div class="row">
        <label>Address</label>
        <textarea name="address"></textarea>
    </div>
    <div class="row">
        <label>City</label><input type="text" name="city">
        <label>Pin Code</label><input type="text" name="pinCode">
    </div>
    <div class="row">
        <label>State</label><input type="text" name="state">
        <label>Country</label><input type="text" name="country" value="India">
    </div>
    <div class="row hobbies">
        <label>Hobbies</label>
        <input type="checkbox" name="hobbies" value="Drawing"> Drawing
        <input type="checkbox" name="hobbies" value="Singing"> Singing
        <input type="checkbox" name="hobbies" value="Dancing"> Dancing
        <input type="checkbox" name="hobbies" value="Sketching"> Sketching
        <input type="checkbox" name="hobbies" value="Others"> Others
    </div>
    <table>
        <tr>
            <th>Sl.No</th><th>Examination</th><th>Board</th><th>Percentage</th><th>Year of Passing</th>
        </tr>
        <tr>
            <td>1</td><td>Class X</td>
            <td><input type="text" name="board1"></td>
            <td><input type="text" name="percentage1"></td>
            <td><input type="text" name="yearOfPassing1"></td>
        </tr>
        <tr>
            <td>2</td><td>Class XII</td>
            <td><input type="text" name="board2"></td>
            <td><input type="text" name="percentage2"></td>
            <td><input type="text" name="yearOfPassing2"></td>
        </tr>
    </table>
    <div class="row course">
        <label>Course applies for</label>
        <input type="radio" name="course" value="BCA"> BCA
        <input type="radio" name="course" value="B.Com"> B.Com
        <input type="radio" name="course" value="B.Sc"> B.Sc
        <input type="radio" name="course" value="B.A"> B.A
    </div>
    <div class="actions">
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </div>
</form>
</body>
</html>
