package iuh.fit.edu.thanhoangthienthien_tuan04_bai04.servlet;


import iuh.fit.edu.thanhoangthienthien_tuan04_bai04.beans.Book;
import iuh.fit.edu.thanhoangthienthien_tuan04_bai04.dao.BookDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


@WebServlet({"/books", "/book"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Resource(name = "jdbc/bookdb")
    private DataSource dataSource;

    @Override
    public void init() {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String q = req.getParameter("q");

        // Xem chi tiết sách
        if (id != null) {
            Book book = bookDAO.getBookById(id);
            if (book != null) {
                req.setAttribute("book", book);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/chitietsach.jsp");
                dispatcher.forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
            }
            return;
        }
        List<Book> books;
        if (q != null && !q.trim().isEmpty()) {
            books = bookDAO.searchBooks(q.trim());
        } else {
            books = bookDAO.getAllBooks();
        }
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/danhsach.jsp");
        dispatcher.forward(req, resp);
    }
}