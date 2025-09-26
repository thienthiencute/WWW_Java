<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.TinTuc"%>
<%@ page import="java.util.List"%>
<%
    List<TinTuc> list = (List<TinTuc>) request.getAttribute("listTinTuc");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Tin Tức</title>
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
        <h2>Danh Sách Tin Tức</h2>
        <a href="TinTucFormServlet" class="btn">Thêm tin tức mới</a>
        <br><br>
        <table border="1" cellpadding="5">
            <thead>
            <tr>
                <th>Mã TT</th>
                <th>Tiêu đề</th>
                <th>Nội dung</th>
                <th>Liên kết</th>
                <th>Mã DM</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <%
                if(list != null && !list.isEmpty()){
                    for(TinTuc t : list){
            %>
            <tr>
                <td><%= t.getMatt() %></td>
                <td><%= t.getTieude() %></td>
                <td><%= t.getNoidungtt() %></td>
                <td><a href="<%= t.getLienket() %>" target="_blank">Xem</a></td>
                <td><%= t.getMadm() %></td>
                <td>
                    <a href="QuanLyFormServlet?action=delete&matt=<%= t.getMatt() %>" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="6" style="text-align:center;">Chưa có tin tức nào</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
