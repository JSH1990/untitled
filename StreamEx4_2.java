package streamEX;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    스트림의 중간연산(2)

    flatMap - 스트림 배열의 문자들을 하나의 스트림문자로 만들어준다.
    만약 Map을 사용하면, 스트림의 객체주소로 출력되어진다.
 */

public class StreamEx4_2 {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
    );

        //Stream<Stream<Stream>> srtStrmStrm = strArrStrm.map(Arrays::stream); //스트림의 객체주소가 찍히게 됨
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase) //스트림의 요소를 모두 소문자로 변경
                .distinct() //중복제거
                .sorted() //정렬
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
        "Believe or not It is true",
        "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) //공백이 하나 이상이면 제거
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

}
