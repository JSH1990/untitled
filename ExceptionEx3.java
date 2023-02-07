package 예외처리예제3;
// NullPointerException
public class ExceptionEx3 {
    public static void main(String[] args) {
        Test test = null;
        try {
            String testStr = test.name;
            System.out.println(test);
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("참조하는 값이 없습니다.");
        }
    }
}

class Test{
    String name = "곰돌이사육사";

}