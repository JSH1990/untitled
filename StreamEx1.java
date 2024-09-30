package streamEX;

import java.util.stream.Stream;

/*
 Q. 스트림이란?
 A. 다양한 데이터 소스(컬렉션-LIST/SET/MAP,배열)를 표준화된 방법으로 다루기 위한 것

 Q. 스트림 과정
 A. 컬렉션/배열 -> Stream만들기 -> 중간연산(여러번가능) -> 최종연산(1번) => 결과
 중간 연산 : 연산 결과가 스트림인 연산. 반복적으로 사용 가능
 최종 연산 : 연산 결과가 스트림이 아닌 연산. 단 한번만 적용 가능 (스트림의 요소를 소모)

 Ex) stream.distinct().limit(5).sorted().forEach(Sysyem.out::println)
            중간 연산   중간연산   중간연산  최종연산

 Q. 스트림 특징

 1. 스트림은 데이터소스(원본)으로부터 데이터를 읽기만 할뿐 변경하지 않는다.

 2. 스트림은 Iterator처럼 일회용이다. (필요하면 다시 스트림을 생성해야함)

 3. 최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산(무제한 스트림에도 sort(정렬)나 distinct(중복제거) 가능하다.

 4. 스트림은 작업을 내부 반복으로 처리한다. (stream의 forEach메서드안에 for문을 넣어버려 코드수를 줄인다.)
 Ex) for(String str : strList) System.out.println(str); -> stream.forEach(System.out::println);

 5. 스트림의 작업을 병렬로 처리 - 병렬스트림(멀티스레드)
 Ex) Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
 int sum = strStream.parallel() //병렬 스트림으로 전환(속성만 변경)
           .mapToInt(s -> s.length()).sum(); //모든 문자열의 길이의 합.

           결과 : 10

 */
public class StreamEx1 {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
        int sum = strStream.parallel() //병렬 스트림으로 전환(속성만 변경)
                .mapToInt(s -> s.length()).sum();

        System.out.println(sum);
    }
}