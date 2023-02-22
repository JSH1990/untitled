package EX1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static JdbcConnection instance;

    private String user = "";
    private String password = "";
    private String url = "";

    private JdbcConnection(){}

    public static JdbcConnection getInstance(){
        synchronized (JdbcConnection.class){
            if (instance == null){
                instance = new JdbcConnection();
            }
        }return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }



}
