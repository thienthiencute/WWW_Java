package dao;

import model.Department;
import util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private DBUtil dbUtil;

    public DepartmentDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    // lay danh sach department
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT dept_id, deptName FROM department";

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Department dept = new Department();
                dept.setDept_id(rs.getInt("dept_id"));
                dept.setDeptName(rs.getString("deptName"));
                departments.add(dept);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return departments;
    }
}
