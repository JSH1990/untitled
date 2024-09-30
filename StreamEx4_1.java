package streamEX;

import java.io.File;
import java.util.stream.Stream;

/*
    스트림의 중간연산(2)
    
    Skip(건너뛰기) / limit(자르기) / distinct(중복제거) / filter(걸러내기) / sorted(정렬) / map(변환) / peek(forEach) / flatmap(스트림의 스트림을 스트림으로 변환)
 */

public class StreamEx4_1 {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("EX1"),
                new File("Ex1.txt") //File배열
        };

        Stream<File> fileStream = Stream.of(fileArr); //Stream요소가 <File>임

        //map()으로 Stream<File>을 Stream<String>으로 변환
        //Stream<File> ----map(File::getName)---> Stream<String>
//        Stream<String> filenameStream = fileStream.map(File::getName);
        Stream<String> filenameStream = fileStream.map((f) -> f.getName()); //람다식
        filenameStream.forEach(System.out::println);

        System.out.println();

        fileStream = Stream.of(fileArr); //스트림을 다시 생성

        fileStream.map(File::getName) //Stream<File> -> Stream<String>
        .filter(s -> s.indexOf('.')!=-1) //확장자가 없는 것은 제외
                .peek(s -> System.out.printf("filename: %s\n", s))
                .map(s -> s.substring(s.indexOf('.')+1)) //확장자만 추출
                .peek(s -> System.out.printf("extension: %s\n", s))
                .map(String::toUpperCase) //모두 대문자로 전환
                .distinct() //중복제거
                .forEach(System.out::println); //JAVABAKTXT

        System.out.println();
    }
}
