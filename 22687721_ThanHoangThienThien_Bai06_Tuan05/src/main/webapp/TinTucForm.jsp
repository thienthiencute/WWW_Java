<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Tin Tức</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>Quản Lý Tin Tức</header>

<div class="container">
    <div class="sidebar">
        <h3>Danh mục</h3>
        <a href="danhsach?madm=1">Thời sự</a>
        <a href="danhsach?madm=2">Giải trí</a>
        <a href="danhsach?madm=3">Công nghệ</a>
    </div>

    <div class="main-content">
        <h2>Thêm Tin Tức Mới</h2>
        <form action="TinTucFormServlet" method="post">
            <label>Tiêu đề:</label>
            <input type="text" name="tieude" placeholder="Nhập tiêu đề" required>

            <label>Nội dung (max 255 ký tự):</label>
            <textarea name="noidungtt" maxlength="255" placeholder="Nhập nội dung" required></textarea>

            <label>Liên kết (http://...):</label>
            <input type="text" name="lienket" placeholder="http://..." pattern="http://.*" required>

            <label>Mã danh mục:</label>
            <input type="number" name="madm" placeholder="Nhập mã danh mục" required>

            <input type="submit" value="Thêm tin tức">
        </form>
        <br>
        <a href="danhsach?madm=1">Quay lại danh sách</a>
    </div>
</div>
</body>
</html>
