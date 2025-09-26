package bai02;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountUtil {
    private DataSource dataSource;

    public AccountUtil(DataSource dataSource) throws Exception {
        this.dataSource = dataSource;
    }

    public List<Account> getAccounts() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM accounts ORDER BY ID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String fname = rs.getString("FIRSTNAME");
                String lname = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                Date dateOfBirth = rs.getDate("DATEOFBIRTH");
                boolean gender = rs.getBoolean("GENDER");

                Account acc = new Account(fname, lname, email, password, dateOfBirth);
                accounts.add(acc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (stmt != null) stmt.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
        return accounts;
    }

    // Thêm account
    public void addAccount(Account acc) throws Exception {
        String sql = "INSERT INTO accounts (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH, GENDER) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getFirstName());
            ps.setString(2, acc.getLastName());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());
            ps.setDate(5, acc.getBirthday() != null ? Date.valueOf(acc.getBirthday()) : null);
            ps.setBoolean(6, acc.isGender());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
    }
}
