package servlet;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import javax.sql.DataSource;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {
    @Resource(name = "jdbc/hrsource")
    private DataSource dataSource;

    private EmployeeDAO empDAO;
    private DepartmentDAO depDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            empDAO = new EmployeeDAO(dataSource);
            depDAO = new DepartmentDAO(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
