package examsurvey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String user = "tester1";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1541:xe";
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("드라이버 검색 성공!");

            conn = DriverManager.getConnection(url,user,password);
            System.out.println("접속 성공!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
