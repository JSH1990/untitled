package examsurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        jdbcTemplate jt = new jdbcTemplate(); // db연결 객체를 만들어준다.
        String sql = "insert into \"FOODTYPE\" (\"NO\", \"TYPENAME\", \"VOTE\" values (\"FOODTYPE_SEQ\".nextval, ?, 1)";
        Connection conn = jt.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            System.out.print("음식 종류 입력 :");
            String ft = in.nextLine();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ft);
            result = pstmt.executeUpdate(); // db의 쿼리를 담는 rs의 객체를 한타입의 객체로 관리하고자 vo객체에 넣었다.
            System.out.println("결과 : " + result);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) ;
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
                for (FoodTypeVo vo : result) {
            System.out.println(vo); //향상된 for문 통해 , result 객체를 이용해 쿼리문을 출력한다.
        }

    }
}
    }
}
