package EX1;

import java.sql.*;

public class EX01 {
    public static void main(String[] args) {

        String user = "";
        String password = "";
        String url = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        String sql = "";

        try {
            conn = DriverManager.getConnection("");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                MemberVo vo = new MemberVo(
                  rs.getInt(1),
                  rs.getInt(2),
                  rs.getInt
                );

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}