package examsurvey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcTemplate {

    public jdbcTemplate(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //반복적인 db 연결을 피하기위해 하나의 접속과 관련된 클래스를 만들어서,
    //jdbc드라이버를 찾는 메서드와 db접속을 위한 메서드 두개를 만들어 준다.

    public Connection getConnection() {
        String user = "tester1";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1541:xe";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
        }
    }

