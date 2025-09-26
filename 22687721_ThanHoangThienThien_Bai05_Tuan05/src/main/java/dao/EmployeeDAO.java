package dao;

import model.Department;
import model.Employee;
import util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private DBUtil dbUtil;

    public EmployeeDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = """
                SELECT e.id, e.name, e.salary, e.department_id, d.deptName
                FROM employee e
                LEFT JOIN department d ON e.department_id = d.dept_id
                """;
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Department dept = new Department(
                        rs.getInt("department_id"),
                        rs.getString("deptName")
                );
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        dept
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Employee> getByDepartmentId(int deptId) {
        List<Employee> list = new ArrayList<>();
        // Sửa câu lệnh SQL để JOIN với bảng department
        String sql = """
            SELECT e.id, e.name, e.salary, e.department_id, d.deptName
            FROM employee e
            JOIN department d ON e.department_id = d.dept_id
            WHERE e.department_id = ?
            """;
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Tạo đối tượng Department có cả ID và tên phòng ban
                    Department dept = new Department(
                            rs.getInt("department_id"),
                            rs.getString("deptName")
                    );
                    Employee emp = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary"),
                            dept
                    );
                    list.add(emp);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void save(Employee emp) {
        String sql = "INSERT INTO employee(name, salary, department_id) VALUES(?, ?, ?)";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getDepartment().getDept_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Employee emp) {
        String sql = "UPDATE employee SET name=?, salary=?, department_id=? WHERE id=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getDepartment().getDept_id());
            ps.setInt(4, emp.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getById(int id) {
        String sql = """
                SELECT e.id, e.name, e.salary, d.dept_id, d.deptName
                FROM employee e
                LEFT JOIN department d ON e.department_id = d.dept_id
                WHERE e.id = ?
                """;
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Department dept = new Department(
                            rs.getInt("dept_id"),
                            rs.getString("deptName")
                    );
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary"),
                            dept
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
