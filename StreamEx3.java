package 스트렘예제3;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        String[] arr = {"남해이", "최지열", "남행선"};
        Stream<String> stream1 = Arrays.stream(arr); //배열로 부터 스트림을 만듦
        stream1.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Stream<String> stream2 = Arrays.stream(arr, 1, 3);
        stream2.forEach(e -> System.out.print(e + " "));
        //숫자 범위로 부터 스트림 만들기
        IntStream stream = IntStream.rangeClosed(1, 100); //
        int sum = stream.sum();
        System.out.println("합계 : " + sum);
    }

}
