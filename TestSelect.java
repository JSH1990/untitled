package testSurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate();
        String sql = "";
        Connection conn = jt.getConnection();
        PreparedStatement pstmt = null;
        try {
            conn.prepareStatement(sql);
        } catch (SQLException e) {
           e.printStackTrace();
        }


    }
    }

