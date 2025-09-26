<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Detail - IUH BOOKSTORE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f9f9f9; font-family: Arial, sans-serif; }

        /* Header */
        .nav-header {
            background: linear-gradient(to bottom, #b3a074 60%, #e4d5b7 100%);
            padding: 0;
            margin-bottom: 0;
        }
        .nav-header .nav-link {
            color: #fff !important;
            font-weight: bold;
            padding: 18px 22px;
        }
        .nav-header .nav-link.active {
            background: #a18a5b !important;
            border-radius: 4px;
        }

        /* Layout */
        .detail-flex {
            display: flex;
            flex-direction: row;
            align-items: flex-start;
            width: 100vw;
            max-width: 100vw;
        }
        .menu-wrap {
            flex: 0 0 280px;
            max-width: 320px;
            min-width: 220px;
        }
        .menu-box {
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 6px;
            padding: 18px 16px;
            margin-top: 18px;
            min-width: 220px;
            max-width: 320px;
        }
        .menu-title { font-size: 18px; font-weight: bold; color: #444; }
        .menu-link { font-size: 13px; color: #555; }
        .menu-search { border: 1px solid #aaa; border-radius: 4px; width: 100%; padding: 5px 10px; }

        /* Book Detail */
        .detail-area { flex: 1 1 0; min-width: 0; padding: 32px 48px 0 48px; }
        .detail-card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 3px 8px rgba(0,0,0,0.03);
            padding: 32px 38px 25px 38px;
            margin: 30px 0 0 0;
            display: flex;
            align-items: flex-start;
        }
        .cover-img {
            width: 180px;
            height: 260px;
            border-radius: 7px;
            object-fit: cover;
            margin-right: 36px;
            border: 1.5px solid #ccc;
            background: #eee;
            box-shadow: 0 2px 7px rgba(0,0,0,0.05);
        }
        .info-box h3 { margin-top: 0; font-size: 24px; font-weight: bold; margin-bottom: 7px; color: #50260e; }
        .info-meta { font-size: 16px; margin-bottom: 6px; color: #444; }
        .info-desc { font-size: 15px; color: #444; margin-bottom: 16px; margin-top: 14px; background: #f6f4ed; border-radius: 6px; padding: 13px 16px; border: 1px solid #e1dbc8; }
        .btn-back { margin-top: 18px; font-size: 15px; color: #1976d2; text-decoration: underline; background: none; border: none; cursor: pointer; padding: 0; }
        .btn-back:hover { color: #0d395f; text-decoration: underline; }
        .btn-add { font-size: 13px; padding: 6px 14px; background: #007bff; color: #fff; border: none; border-radius: 4px; cursor: pointer; }
        .btn-add:hover { background: #0056b3; }

        /* Responsive */
        @media (max-width: 1100px) {
            .detail-flex { flex-direction: column; }
            .menu-wrap { max-width: 100vw; min-width: 0; }
            .detail-area { padding: 0 4vw; }
        }
        @media (max-width: 900px) {
            .detail-card { flex-direction: column; align-items: center; padding: 18px; }
            .cover-img { margin-right: 0; margin-bottom: 17px; }
            .info-box { text-align: center; }
            .menu-box { margin: 0 auto 16px auto; }
            .detail-area { padding: 0 2vw; }
        }
    </style>
</head>
<body>
<div class="nav-header">
    <div class="container-fluid">
        <div class="row align-items-center" style="padding-top: 8px;">
            <div class="col-md-4">
                <h2 style="color:#fff;font-family:serif;font-weight:bold;letter-spacing:2px;margin-bottom:0;">IUH BOOKSTORE</h2>
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

<div class="detail-flex">
    <!-- Sidebar -->
    <div class="menu-wrap">
        <div class="menu-box">
            <div class="menu-title">ABOUT US</div>
            <div style="font-size:12px; color:#444; margin-bottom:18px;">
                About us information will be here...
                <a href="#" class="menu-link">Read More »</a>
            </div>
            <div class="menu-title" style="margin-top:14px;">SEARCH SITE</div>
            <form method="get" action="books">
                <input type="text" class="menu-search" name="q" placeholder=""/>
            </form>
        </div>
    </div>

    <!-- Book Detail -->
    <div class="detail-area">
        <c:if test="${not empty book}">
            <div class="detail-card">
                <img class="cover-img" src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title}" />
                <div class="info-box">
                    <h3>${book.title}</h3>
                    <div class="info-meta"><b>Tác giả:</b> ${book.author}</div>
                    <div class="info-meta"><b>Số lượng:</b> ${book.quantity}</div>
                    <div class="info-meta"><b>Giá:</b> <fmt:formatNumber value="${book.price}" type="number" maxFractionDigits="0"/> VNĐ</div>
                    <div class="info-desc">${book.description}</div>
                    <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${book.id}"/>
                        <input type="hidden" name="action" value="add"/>
                        <input type="number" name="quantity" value="1" min="1" style="width:50px;"/>
                        <button type="submit" class="btn-add">Add to cart</button>
                    </form>
                    <br>
                    <a href="books" class="btn-back">← Back to Product List</a>
                </div>
            </div>
        </c:if>
        <c:if test="${empty book}">
            <div class="alert alert-warning mt-4">Sách không tồn tại hoặc đã bị xóa.</div>
        </c:if>
    </div>
</div>
</body>
</html>
