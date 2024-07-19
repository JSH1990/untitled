package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        //Object 클래스의 메서드
        String string = child.toString();
        System.out.println(string);
    }
}
