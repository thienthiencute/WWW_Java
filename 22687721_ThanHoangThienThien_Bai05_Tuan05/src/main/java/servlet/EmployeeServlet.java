package servlet;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Department;
import model.Employee;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list": {
                List<Employee> employees = empDAO.getAllEmployees();
                req.setAttribute("employees", employees);
                req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
                break;
            }
            case "new": {
                req.setAttribute("departments", depDAO.getAll());
                req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
                break;
            }
            case "edit": {
                int id = Integer.parseInt(req.getParameter("id"));
                Employee emp = empDAO.getById(id);
                req.setAttribute("employee", emp);
                req.setAttribute("departments", depDAO.getAll());
                req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
                break;
            }
            case "delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                empDAO.delete(id);
                resp.sendRedirect("employees");
                break;
            }
            case "viewbyid": {
                String deptIdParam = req.getParameter("deptId");
                List<Employee> list;
                if (deptIdParam != null && !deptIdParam.isEmpty()) {
                    int deptId = Integer.parseInt(deptIdParam);
                    list = empDAO.getByDepartmentId(deptId);
                } else {
                    list = empDAO.getAllEmployees();
                }
                req.setAttribute("employees", list);
                req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int deptId = Integer.parseInt(req.getParameter("department.dept_id"));

        Department dept = new Department();
        dept.setDept_id(deptId);

        Employee emp = new Employee(id, name, salary, dept);
        if (id > 0) {
            empDAO.update(emp);
        } else {
            empDAO.save(emp);
        }
        resp.sendRedirect("employees");
    }
}

