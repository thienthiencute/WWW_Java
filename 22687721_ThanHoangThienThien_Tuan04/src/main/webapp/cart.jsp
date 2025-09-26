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
    <title>Cart</title>
    <style>
        .container { width: 600px; margin: 30px auto; background: #fff; padding: 20px; border-radius: 8px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background: #f2f2f2; }
        form { display:inline; }
        .empty { color: #888; }
        a { display: inline-block; margin-top: 18px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Cart</h2>

    <c:if test="${empty cart.items}">
        <p class="empty">Cart is empty!</p>
    </c:if>

    <c:if test="${not empty cart.items}">
        <table class="table table-border">
            <tr>
                <th>Model</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>${item.product.model}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="update"/>
                            <input type="hidden" name="productId" value="${item.product.id}"/>
                            <input type="number" name="quantity" value="${item.quantity}" min="1"/>
                            <input type="submit" value="Update"/>
                        </form>
                    </td>
                    <td><fmt:formatNumber value="${item.product.price}" type="number" maxFractionDigits="0"/> VNĐ</td>
                    <td><fmt:formatNumber value="${item.product.price * item.quantity}" type="number" maxFractionDigits="0"/> VNĐ</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="remove"/>
                            <input type="hidden" name="productId" value="${item.product.id}"/>
                            <input type="submit" value="Remove"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><strong>Total: </strong> <fmt:formatNumber value="${cart.total}" type="number" maxFractionDigits="0"/> VNĐ</p>
    </c:if>

    <a href="product">Continue Shopping</a>
</div>
</body>
</html>