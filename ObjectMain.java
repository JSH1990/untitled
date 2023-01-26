package Object클래스;
// Object 클래스 : 모든 클래스의 조상이 되는 최상위 클래스 (항상 존재하지만 숨어 있음)
// toString() : 해당 객체(인스턴스)에 대한 정보를 문자열로 반환
// 해당객체와 매개변수로 전달받은 객체를 비교하여 결과 (참조가 같은지)
public class ObjectMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        ObjectMain objectMain = new ObjectMain();
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student1.equals(student2));
        student1 = student2;
        System.out.println(student1.equals(student2));
    }
}

class Student extends Object {
    int id;
    String name;



}