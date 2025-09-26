<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 9/15/2025
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product Detail</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .detail-container { max-width: 500px; margin: 40px auto; background: #f9f9f9; padding: 30px; border-radius: 10px; }
        ul { list-style: none; padding: 0; }
        li { margin-bottom: 8px; }
        img { margin: 18px 0; border-radius: 8px; border: 1px solid #ccc; }
        a { text-decoration: none; color: #1976d2; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<div class="detail-container">
    <h2>Product Detail</h2>
    <c:if test="${not empty product}">
        <ul>
            <li><b>Id:</b> ${product.id}</li>
            <li><b>Model:</b> ${product.model}</li>
            <li><b>Description:</b> ${product.description}</li>
            <li><b>Quantity:</b> ${product.quantity}</li>
            <li><b>Price: <fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0"/> VNĐ<br></li>
            <li>
                <img src="${pageContext.request.contextPath}/images/${product.image}"
                     alt="${product.model}" width="150"/>
            </li>
        </ul>
    </c:if>
    <p>
        <a href="${pageContext.request.contextPath}/products">Back to Product List</a>
    </p>
</div>
</body>
</html>