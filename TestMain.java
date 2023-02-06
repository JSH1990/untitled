package examsurvey;

public class TestMain {
    public static void main(String[] args) {

        jdbcTemplate jdbcTemplate = new jdbcTemplate();
        FoodTypeDao dao = new FoodTypeDao(jdbcTemplate); //FoodType에 대해서 db에 연동되는 기능은 dao 에서 관리가 되고있다.
    }
}
