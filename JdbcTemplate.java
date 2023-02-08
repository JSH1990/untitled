package testSurvey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {

    public JdbcTemplate() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("드라이버 검색 성공!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()  {
        String user = "tester1";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
