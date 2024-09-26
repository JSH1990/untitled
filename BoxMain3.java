package generic.ex1;

public class BoxMain3{
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); //생성 시점에 T의 타입 결정
        integerBox.setValue(10);
//        integerBox.setValue("문자"); //Integer타입만 허용, 컴파일오류
        Integer integer = integerBox.getValue();
        System.out.println(integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.setValue("Hello");
        String str = stringBox.getValue();
        System.out.println(str);

        //원하는 모든 타입사용가능(기본형은 안된다)

        //타입 추론 : 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
        

    }
}
