package 슈퍼필드;
// super : 자식 클래스가 부모클래스로 부터 상속 받은 필드(멤버)를 참조하는 변수
// super() : 부모 클래스의 생성자를 호출하는 메소드 입니다. (자식의 생성자 내에서 호출)
// 자식의 생성자에서 부모의 생성자를 호출 할 때는 부모의 생성자를 먼저 호출하고, 다른 초기화를 진행해야 한다.
// 생성자를 따로 만들지 않으면 기본 생성자가 호출되는 것처럼 부모의 생성자도 생성자를 별도로 만들어 주지 않으면
// 기본적으로 부모의 생성자가 자동 호출 됨.

public class SuperField {
    public static void main(String[] args) {
        System.out.println("main 메소드호출");
        Child child = new Child();
        child.disPlay();
    }
}

class Parent {
    int a;
    Parent(){
        System.out.println("부모의 기본생성자 호출");
        a = 10;
    }
    Parent(int n){
        System.out.println("부모의 생성자 호출");
        a = n;
    }
}
class Child extends Parent {
  int b;
  Child(){
      //super();
      System.out.println("자식의 생성자 호출");
      //super(200); 에러나는이유 : 첫줄에 없기 때문에 (가장먼저 호출되어야 하므로)
      b = 20;
  }
  void disPlay(){
      System.out.println(a);
      System.out.println(b);
  }
    }
