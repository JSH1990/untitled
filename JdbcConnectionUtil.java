import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//�̱���  ����- ��ü�� �ϳ��� ����
public class JdbcConnectionUtil {
    private static JdbcConnectionUtil instance;

    private DataSource ds;


    private JdbcConnectionUtil() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB"); //JNDI
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static JdbcConnectionUtil getInstance() {
        synchronized (JdbcConnectionUtil.class) {

            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(instance == null) {
                instance = new JdbcConnectionUtil();
            }
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}