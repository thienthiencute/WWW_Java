package servlet;

import dao.DanhSachTinTucQuanLy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhSachTinTucQuanLy dao = new DanhSachTinTucQuanLy(dataSource);
        String action = req.getParameter("action");
        String mattStr = req.getParameter("matt");
        if ("delete".equals(action) && mattStr != null) {
            int matt = Integer.parseInt(mattStr);
            dao.deleteTinTuc(matt);
        }
        resp.sendRedirect("danhsach"); // trở lại danh sách
    }
}
