package extends1.super1;

/*
상속 관계를 사용하면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야한다.(규칙)
상속 관계에서 부모 생성자를 호출할 때는 super()를 사용하면 된다.
부모 클래스의 생성자가 기본생성자(파라미터가 없는 생성자)인 경우에는 super()를 생략할 수 있다.
참고로 기본 생성자를 많이 생성하기때문에 편의상 이런 기능을 제공한다.
 */

public class Super1Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.call();
    }
}
