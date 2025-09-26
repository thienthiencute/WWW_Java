package iuh.fit.edu.thanhoangthienthien_tuan04_bai04.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DBUtil {
    private DataSource dataSource;

    public DBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        Connection conn;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}

