<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout - IUH BOOKSTORE</title>
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
        .checkout-layout {
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
            border: 2px solid #000;
            border-radius: 6px;
            padding: 18px 16px;
            margin-top: 18px;
            min-width: 220px;
            max-width: 320px;
        }
        .menu-title {
            font-size: 18px;
            font-weight: bold;
            color: #444;
        }
        .menu-link {
            font-size: 13px; color: #555;
        }
        .menu-search {
            border: 1px solid #aaa;
            border-radius: 4px;
            width: 100%;
            padding: 5px 10px;
        }

        /* Checkout area */
        .checkout-panel {
            flex: 1 1 0;
            min-width: 0;
            padding: 32px 48px 0 48px;
        }
        .checkout-card {
            background: #fff;
            border: 2px solid #000;
            border-radius: 8px;
            padding: 22px 26px 14px 26px;
            margin-top: 18px;
        }
        .checkout-heading {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 18px;
            color: #333;
        }
        .form-group label {
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-row {
            margin-bottom: 12px;
        }
        .checkout-btn-bar {
            margin-top: 16px;
        }
        .checkout-success {
            color: #218838;
            font-weight: bold;
            font-size: 20px;
            text-align: center;
            margin: 28px 0 18px 0;
        }

        @media (max-width: 1100px) {
            .checkout-layout { flex-direction: column; }
            .menu-wrap { max-width: 100vw; min-width: 0; }
            .checkout-panel { padding: 0 4vw; }
        }
        @media (max-width: 900px) {
            .checkout-panel { padding: 0 2vw; }
            .menu-box { margin: 0 auto 16px auto; }
        }
    </style>
</head>
<body>
<!-- Header & Menu -->
<div class="nav-header">
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
<div class="checkout-layout">
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
            <div style="margin-top:18px;">
                <b>Shopping cart</b> (<c:out value="${not empty cart.items ? cart.items.size() : 0}"/>)
            </div>
        </div>
    </div>

    <!-- Checkout -->
    <div class="checkout-panel">
        <div class="checkout-card">
            <c:choose>
                <c:when test="${param.saveSuccess == '1'}">
                    <div class="checkout-success">Thanh toán thành công</div>
                    <div style="text-align:center;">
                        <a href="book" class="btn btn-primary">Về trang chủ</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="checkout-heading">Checkout - Already registered?</div>
                    <form action="thanhtoan.jsp" method="post">
                        <div class="form-row">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Fullname:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="fullName" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Shipping address:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="shippingAddress" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Total price:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="totalPrice" class="form-control" readonly
                                           value="<fmt:formatNumber value='${cart.totalPrice}' type='number' maxFractionDigits='0'/>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Payment method:</label>
                                <div class="col-sm-9 pt-2">
                                    <label><input type="radio" name="paymentMethod" value="Paypal" required> Paypal</label>
                                    <label style="margin-left:12px;"><input type="radio" name="paymentMethod" value="ATM"> ATM Debit</label>
                                    <label style="margin-left:12px;"><input type="radio" name="paymentMethod" value="Visa/Master Card"> Visa/Master card</label>
                                </div>
                            </div>
                        </div>
                        <div class="checkout-btn-bar">
                            <button type="submit" name="save" value="1" class="btn btn-success">Save</button>
                            <a href="cart" class="btn btn-secondary">Cancel</a>
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<%-- Script to redirect after POST --%>
<c:if test="${not empty param.save}">
    <script>
        window.location = "thanhtoan.jsp?saveSuccess=1";
    </script>
</c:if>

</body>
</html>
