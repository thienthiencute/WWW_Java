package dao;

import model.TinTuc;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLy {

    private DataSource dataSource;

    public DanhSachTinTucQuanLy(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public List<TinTuc> getTinTucTheoDanhMuc(int madm) {
        List<TinTuc> list = new ArrayList<>();
        String sql = "SELECT * FROM TINTUC WHERE MADM=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, madm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TinTuc(
                        rs.getInt("MATT"),
                        rs.getString("TIEUDE"),
                        rs.getString("NOIDUNGTT"),
                        rs.getString("LIENKET"),
                        rs.getInt("MADM")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean addTinTuc(TinTuc t) {
        String sql = "INSERT INTO TINTUC (TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getTieude());
            ps.setString(2, t.getNoidungtt());
            ps.setString(3, t.getLienket());
            ps.setInt(4, t.getMadm());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteTinTuc(int matt) {
        String sql = "DELETE FROM TINTUC WHERE MATT=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, matt);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
