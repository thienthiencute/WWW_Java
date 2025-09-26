<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - Danh sách sách</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f9f9f9; font-family: Arial, sans-serif; }

        /* Header */
        .top-header {
            background: linear-gradient(to bottom, #c2a86b 60%, #e7d8b2 100%);
            padding: 0;
            margin-bottom: 0;
        }
        .top-header .nav-link {
            color: #fff !important;
            font-weight: bold;
            padding: 18px 22px;
        }
        .top-header .nav-link.active {
            background: #b3945a !important;
            border-radius: 4px;
        }


        /* Layout */
        .content-flex {
            display: flex;
            flex-direction: row;
            align-items: flex-start;
            width: 100vw;
            max-width: 100vw;
        }
        .panel-wrap {
            flex: 0 0 280px;
            max-width: 320px;
            min-width: 220px;
        }
        .panel-box {
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 6px;
            padding: 18px 16px;
            margin-top: 18px;
        }
        .panel-title { font-size: 18px; font-weight: bold; color: #444; }
        .panel-link { font-size: 13px; color: #555; }
        .panel-search-box { border: 1px solid #aaa; border-radius: 4px; width: 100%; padding: 5px 10px; }

        /* Book List */
        .book-area { flex: 1 1 0; padding: 16px 32px 0 32px; min-width: 0; }
        .book-container { display: flex; flex-wrap: wrap; gap: 22px; justify-content: flex-start; }
        .book-item {
            background: #fff;
            border: 1px solid #aaa;
            border-radius: 7px;
            padding: 13px 12px 10px 12px;
            min-width: 190px;
            max-width: 210px;
            margin-bottom: 18px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.02);
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .book-item img {
            width: 110px;
            height: 160px;
            object-fit: cover;
            border: 1px solid #ccc;
            margin-bottom: 9px;
            background: #eee;
        }
        .book-title { font-size: 15px; font-weight: bold; margin-bottom: 4px; }
        .book-meta { font-size: 13px; margin-bottom: 1px; }
        .book-detail-link {
            font-size: 13px;
            color: #1976d2;
            text-decoration: underline;
            margin-bottom: 3px;
        }
        .book-detail-link:hover { color: #0d395f; }
        .add-cart-btn { font-size: 13px; padding: 3px 14px; margin-top: 2px; }

        /* Responsive */
        @media (max-width: 1100px) {
            .content-flex { flex-direction: column; }
            .panel-wrap { max-width: 100vw; min-width: 0; }
            .book-area { padding: 0 4vw; }
        }
        @media (max-width: 700px) {
            .book-area { padding: 0 2vw; }
            .book-container { justify-content: center; }
            .panel-box { margin: 0 auto 16px auto; }
        }
    </style>
</head>
<body>
<!-- Header -->
<div class="top-header">
    <div class="container-fluid">
        <div class="row align-items-center" style="padding-top: 8px;">
            <div class="col-md-4">
                <h2 style="color:#fff;font-family:serif;font-weight:bold;letter-spacing:2px;margin-bottom:0;">
                    IUH BOOKSTORE
                </h2>
            </div>
            <div class="col-md-8">
                <ul class="navbar-nav flex-row justify-content-end">
                    <li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">EXAMPLES</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">SERVICES</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#">PRODUCTS</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">CONTACT</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Main content -->
<div class="content-flex">
    <div class="panel-wrap">
        <div class="panel-box">
            <div class="panel-title">ABOUT US</div>
            <div style="font-size:12px; color:#444; margin-bottom:18px;">
                About us information will be here...
                <a href="#" class="panel-link">Read More »</a>
            </div>
            <div class="panel-title" style="margin-top:14px;">SEARCH SITE</div>
            <form method="get" action="books">
                <input type="text" class="panel-search-box" name="q" placeholder="Nhập mã sách hoặc tên sách..." value="${param.q != null ? param.q : ''}"/>
                <button type="submit" class="btn btn-primary btn-sm" style="margin-top: 6px;">Tìm kiếm</button>
            </form>
        </div>
    </div>
    <div class="book-area">
        <div class="book-container">
            <c:forEach var="b" items="${books}">
                <div class="book-item">
                    <div class="book-title">${b.title} - Tác giả: ${b.author}</div>
                    <img src="${pageContext.request.contextPath}/images/${b.image}" alt="${b.title}"/>
                    <div class="book-meta">Price: <fmt:formatNumber value="${b.price}" type="number" maxFractionDigits="0"/></div>
                    <div class="book-meta">Quantity: ${b.quantity}</div>
                    <a class="book-detail-link" href="book?id=${b.id}">Product details</a>
                    <form action="${pageContext.request.contextPath}/cart" method="post" style="margin:0;">
                        <input type="hidden" name="id" value="${b.id}"/>
                        <input type="hidden" name="action" value="add"/>
                        <input type="hidden" name="quantity" value="1"/>
                        <button type="submit" class="btn btn-primary add-cart-btn">Add to cart</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
