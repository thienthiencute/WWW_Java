package iuh.fit.thanhoangthienthien_tuan04.bai03.servlet;

import iuh.fit.thanhoangthienthien_tuan04.bai03.beans.CartBean;
import iuh.fit.thanhoangthienthien_tuan04.bai03.beans.Product;
import iuh.fit.thanhoangthienthien_tuan04.bai03.dao.ProductDAO;


import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Resource(name = "jdbc/shopdb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            productDAO = new ProductDAO(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                int quantity = 1;
                try {
                    String qtyStr = req.getParameter("quantity");
                    if (qtyStr != null) {
                        quantity = Integer.parseInt(qtyStr);
                    }
                } catch (Exception ex) {
                    quantity = 1;
                }
                Product p = productDAO.getProductById(id);
                cart.addProduct(p, quantity); // Truyền số lượng vào đây
            } else if ("update".equals(action)) {
                int productId = Integer.parseInt(req.getParameter("productId"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cart.updateQuantity(productId, quantity);
            } else if ("remove".equals(action)) {
                int productId = Integer.parseInt(req.getParameter("productId"));
                cart.removeProduct(productId);
            } else if ("clear".equals(action)) {
                cart.clear();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        resp.sendRedirect("cart");
    }
}
