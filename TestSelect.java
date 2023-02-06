package examsurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {
    public static void main(String[] args)  {
        jdbcTemplate jt = new jdbcTemplate(); // db연결 객체를 만들어준다.
        String sql = "select \"NO\", \"TYPENAME\", \"VOTE\" from \"FOODTYPE\"";

        Connection conn = jt.getConnection(); // jdbcTemplate클래스에서 예외를 던지면(throws SQLException) jt.getConnection()을 호출할때, 예외를 작성해야하지만, try~catch문으로 작성하면 jt.getConnection()를 호출할때 또 예외처리를 해줘야한다.
        PreparedStatement pstmt = null;
        ResultSet rs = null; //ResultSet은 SELECT문의 결과를 저장하는 객체이다.
        List<FoodTypeVo> result = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // db의 쿼리를 담는 rs의 객체를 한타입의 객체로 관리하고자 vo객체에 넣었다.
            while (rs.next()){
                FoodTypeVo vo = new FoodTypeVo( //DB내
                        rs.getInt("NO"),
                        rs.getString("TYPENAME"),
                        rs.getInt("VOTE"));
                result.add(vo); // 리스트를 만들어, add메서드를 통해 db쿼리문마다 객체를 생성해 리스트에 담아준다.
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        for (FoodTypeVo vo : result) {
            System.out.println(vo); //향상된 for문 통해 , result 객체를 이용해 쿼리문을 출력한다.
        }

    }
}
