package bai02;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/registerform")
public class AccountRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountUtil accountUtil;

    @Resource(name = "jdbc/storedb")
    private DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            accountUtil = new AccountUtil(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // Lấy dữ liệu từ form
            String firstname = req.getParameter("firstName");
            String lastname = req.getParameter("lastName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            int day = Integer.parseInt(req.getParameter("birthDay"));
            int month = Integer.parseInt(req.getParameter("birthMonth"));
            int year = Integer.parseInt(req.getParameter("birthYear"));
            LocalDate birthday = LocalDate.of(year, month, day);

            String genderStr = req.getParameter("gender");
            boolean gender = "Male".equalsIgnoreCase(genderStr);

            // Tạo đối tượng Account
            Account account = new Account(firstname, lastname, email, password, birthday, gender);

            // Thêm vào DB
            accountUtil.addAccount(account);

            // Lấy lại danh sách account
            List<Account> accounts = accountUtil.getAccounts();

            // Đẩy dữ liệu sang JSP
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("account.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<Account> accounts = accountUtil.getAccounts();
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("/Bai_02/FormResgistration.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
