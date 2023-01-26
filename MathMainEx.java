package Math클래스;
//Math 클래스의 모든 메소드는 클래스 메소드 이므로 객체를 생성하지 않고 바로 사용
//(random () : 0.0 ~ 1.0 미만의 임의의 double 형 값을 생성해서 반환
public class MathMainEx {
    public static void main(String[] args) {
        //abs() 메소드 : 절대값 구하기, 양수면 양수, 음수면 음수
//
//        System.out.println(Math.abs(10));
//        System.out.println(Math.abs(-10));
//        System.out.println(Math.abs(-3.14));
//
        //floor() : 소수점 이하를 무조건 날림
        //ceil() : 소수점 이하가 있으면 무조건 올림
        //round() : 반올림
//        System.out.println(Math.floor(10.999));
//        System.out.println(Math.floor(10.0001));
//        System.out.println(Math.floor(-3.14));
//        System.out.println(Math.round(10.999));
//        System.out.println(Math.round(10.0001));
//        System.out.println(Math.round(-3.14));

        System.out.println(Math.max(11, 9.999));
        System.out.println(Math.min(11, 9.999));
        System.out.println(Math.pow(2,5)); //2 의 5제곱


}
}