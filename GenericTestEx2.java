package 제네릭;
// 제너릭 타입 : 타입 변수를 사용해 다형성 구현
public class GenericTestEx2 {
    public static void main(String[] args) {
        Person<String> p1 = new Person<>("곰돌이사육사");
        System.out.println(p1.info);
    }
}
//'T'타입 변수라고 하며, 임의의 참조형 타입을 의미, 'T' 변수명을 의미하며 아무이름으로 지어도 됨(일반적으로 대문자 T)
class Person <T>{
    public T info;
    Person(T info){
        this.info = info;
    }


}