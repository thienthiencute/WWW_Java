<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/8/2025
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form student</title>
</head>
<body>
    <form action="student" method="get">
        <label>First Name</label>
        <input type="text" name ="firstName" class="form-control" maxlength="30" required>
        <label>Last Name</label>
        <input type="text" name ="lastName" class="form-control" maxlength="30" required> <br>
<%--        <label>Date of Birth</label>--%>
<%--        <input type="date" name ="dob" class="form-control" required> <br>--%>
        <label>Email</label>
        <input type="email" name ="email" class="form-control" maxlength="30" required>
        <label>Mobile</label>
        <input type="tel" name ="mobile" class="form-control" maxlength="10" required> <br>
        <label>Gender</label>
<%--        <div class="form-check form-check-inline">--%>
<%--            <input type="radio" name="Male" value="male" class="form-check-input"> Male--%>
<%--            <input type="radio" name="Female" value="female" class="form-check-input"> Female--%>
<%--        </div>--%>
        <label>Hobbies</label> <br>
        <div class="form-check form-check-inline">
            <input type="checkbox" name="hobbies" value="Drawing" class="form-check-input"> Drawing
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" name="hobbies" value="Singing" class="form-check-input"> Singing
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" name="hobbies" value="Dancing" class="form-check-input"> Dancing
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" name="hobbies" value="Sketching" class="form-check-input"> Sketching
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" name="hobbies" value="Others" class="form-check-input"> Others
        </div>

        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>

</body>
</html>
