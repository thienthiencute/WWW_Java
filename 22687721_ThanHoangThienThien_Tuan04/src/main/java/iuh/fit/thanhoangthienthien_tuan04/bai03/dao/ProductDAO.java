package iuh.fit.thanhoangthienthien_tuan04.bai03.dao;

import iuh.fit.thanhoangthienthien_tuan04.bai03.beans.Product;
import iuh.fit.thanhoangthienthien_tuan04.bai03.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    // Read ALL
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String model = rs.getString("MODEL");
                Double price = rs.getDouble("PRICE");
                Integer quatity = rs.getInt("QUANTITY");
                String image = rs.getString("IMGURL");
                String description = rs.getString("DESCRIPTION");
                Product p = new Product(id, model, price, quatity, description, image);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Read By ID
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ID=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Integer proid = rs.getInt("ID");
                    String model = rs.getString("MODEL");
                    Double price = rs.getDouble("PRICE");
                    Integer quantity = rs.getInt("QUANTITY");
                    String image = rs.getString("IMGURL");
                    String description = rs.getString("DESCRIPTION");

                    Product p = new Product(proid, model, price, quantity, description, image);
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}


