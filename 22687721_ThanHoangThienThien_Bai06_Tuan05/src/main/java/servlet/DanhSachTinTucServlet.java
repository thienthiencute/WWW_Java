package servlet;

import dao.DanhSachTinTucQuanLy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TinTuc;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/danhsach")
public class DanhSachTinTucServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhSachTinTucQuanLy dao = new DanhSachTinTucQuanLy(dataSource);
        String madmParam = req.getParameter("madm");
        int madm = (madmParam != null) ? Integer.parseInt(madmParam) : 1;
        List<TinTuc> list = dao.getTinTucTheoDanhMuc(madm);
        req.setAttribute("listTinTuc", list);
        req.getRequestDispatcher("DanhSachTinTuc.jsp").forward(req, resp);

    }
}
