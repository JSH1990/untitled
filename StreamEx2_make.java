package streamEX;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    스트림 만들기 - 컬렉션
    Collection인터페이스의 stream()으로 컬렉션을 스트림으로 변환

    Stream<E> stream() //Collection인터페이스의 메서드
 */

public class StreamEx2_make {
    public static void main(String[] args) {
        /*
            Stream - 배열일때
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); //list를 스트림으로 변환

        //스트림의 모든 요소를 출력
        //intStream.forEach((i) -> System.out.print(i)); //람다식으로 변환
        intStream.forEach(System.out::print); //12345 forEach()최종 연산

        //intStream.forEach(System.out::println); //에러. 스트림이 이미 닫혔다.
        //다시 스트림생성
        System.out.println();
        intStream = list.stream(); //list로부터 stream을 생성
        intStream.forEach(System.out::print);

        System.out.println();

        /*
            Stream - 문자일때
         */
        Stream<String> strStream = Stream.of("a","b","c");
        strStream.forEach(System.out::print);

        System.out.println();

        /*
            Stream - 문자 배열일때
         */
        
        //String[] strArr = new String[]{"a","b","c","d"};
        //Stream<String> strStream1 = Stream.of(strArr);
        //위의 두줄을 한줄로 바꿀때
        Stream<String> strStream1 = Stream.of(new String[]{"a","b","c","d"}); //new String[] 꼭있어야한다. 없으면 에러
        //Stream<String> strStream = Arrays.stream(strArr); 위와 같은 결과
        strStream1.forEach(System.out::print);
    }
}