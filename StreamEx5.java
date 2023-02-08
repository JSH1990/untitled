package 스트림예제5번;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 중개 연산 : 생성된 스트림은 중개 연산을 통해 또 다른 스크립으로 변환, 중개 연산은 연속으로 연결해서 사용 가능
// filter() : 조건에 맞는 요소만으로 구성된 새로운 스트림 반환
// distinct() : 스트림에서 중복된 요소를 제거하고 새로운 스트림 생성
// 7개의 정수를 입력 받아 홀수 짝수 나누어 담기
public class StreamEx5 {
    public static void main(String[] args) {
//        IntStream stream1 = IntStream.of(7,5,5,2,1,3,5,4,6);
//        IntStream stream2 = IntStream.of(7,5,5,2,1,3,5,4,6);
//        // 스트림에서 홀수 값만 골라냄
//        stream1.filter(n->n % 2 != 0).forEach(e-> System.out.print(e + " "));
//        System.out.println();
//        //스트림에서 중복 요소를 제거
//        stream2.distinct().forEach(e -> System.out.print(e + " "));

        //스트림 변환 : 해당 스트림의 요소들에 주어진 함수의 인수로 전달하여, 그 반환 값으로 이루어진 새로운 스트림 생성
        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        stream.map(s->s.length()).forEach(System.out::println);

        String[] arr = {"I study hard", "you study Java"};
        Stream<String> stream3 = Arrays.stream(arr);
        stream3.flatMap(s->Stream.of(s.split(" "))).forEach(System.out::println);
    }
}
