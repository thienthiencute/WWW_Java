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
<style>
    .product-list {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
    }
    .product-class {
        border: 1px solid #ccc;
        padding: 12px;
        border-radius: 6px;
        width: 220px;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .hinh {
        width: 120px;
        height: 120px;
        object-fit: contain;
        margin-bottom: 8px;
    }
</style>
<a href="cart">View Cart</a>
<div class="product-list">
    <c:forEach items="${products}" var="p">
        <div class="product-class">
            <b>${p.model}</b><br>
            <img src="${pageContext.request.contextPath}/images/${p.image}" class="hinh" width="150" height="150"/>
            <br>
            Price: <fmt:formatNumber value="${p.price}" type="number" maxFractionDigits="0"/> <br>
            <form action="${pageContext.request.contextPath}/cart" method="post">
                <input type="number" min="1" size="2" value="1" name="quantity"/> <br/>
                <input type="hidden" name="id" value="${p.id}"/>
                <input type="hidden" name="action" value="add"/>
                <input type="submit" value="Add To Cart"/><br/>
            </form>
            <a href="${pageContext.request.contextPath}/product?id=${p.id}">Product Detail</a><br/>
        </div>
    </c:forEach>
</div>
