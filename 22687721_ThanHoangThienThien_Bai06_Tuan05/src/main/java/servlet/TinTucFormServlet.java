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

@WebServlet("/TinTucFormServlet")
public class TinTucFormServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DanhSachTinTucQuanLy dao = new DanhSachTinTucQuanLy(dataSource);

        String tieude = req.getParameter("tieude");
        String noidungtt = req.getParameter("noidungtt"); // phải trùng với name trong form
        String lienket = req.getParameter("lienket");
        String madmStr = req.getParameter("madm");

        int madm = Integer.parseInt(madmStr);
        dao.addTinTuc(new TinTuc(tieude, noidungtt, lienket, madm));

        resp.sendRedirect("danhsach?madm=" + madm); // redirect về danh sách sau khi thêm
    }
}
