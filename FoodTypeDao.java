package examsurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodTypeDao {
    private jdbcTemplate jdbcTemplate; //jdbc 드라이버를 찾는 클래스

    public FoodTypeDao(jdbcTemplate jdbcTemplate) { //참조변수를 받아와서 객체생성

        this.jdbcTemplate = jdbcTemplate;
    }

    //select
    public List<FoodTypeVo> selectFoodTypeAll() {
        String sql = "select \"NO\", \"TYPENAME\", \"VOTE\" from \"FOODTYPE\"";
        Connection conn = jdbcTemplate.getConnection(); // jdbcTemplate클래스에서 예외를 던지면(throws SQLException) jt.getConnection()을 호출할때, 예외를 작성해야하지만, try~catch문으로 작성하면 jt.getConnection()를 호출할때 또 예외처리를 해줘야한다.
        PreparedStatement pstmt = null;
        ResultSet rs = null; //ResultSet은 SELECT문의 결과를 저장하는 객체이다.
        List<FoodTypeVo> result = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // db의 쿼리를 담는 rs의 객체를 한타입의 객체로 관리하고자 vo객체에 넣었다.
            while (rs.next()) {
                FoodTypeVo vo = new FoodTypeVo( //DB내
                        rs.getInt("NO"),
                        rs.getString("TYPENAME"),
                        rs.getInt("VOTE"));
                result.add(vo); // 리스트를 만들어, add메서드를 통해 db쿼리문마다 객체를 생성해 리스트에 담아준다.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return;
    }

    }

    //insert

    //update

}
