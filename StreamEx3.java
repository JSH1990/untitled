package streamEX;

import java.util.Comparator;
import java.util.stream.Stream;

/*
    스트림의 중간연산(1)
 */
public class StreamEx3 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("a", 3, 300),
                new Student("b", 1, 150),
                new Student("c", 2, 100),
                new Student("d", 3, 200),
                new Student("e", 1, 300)
        );

        //studentStream.sorted(Comparator.comparing(Student::getBan) //1.반별 정렬
        studentStream.sorted(Comparator.comparing((Student s) -> s.getBan()) //람다식 변환
                .thenComparing(Comparator.naturalOrder())) //2.기본 정렬
                .forEach(System.out::println);
    }


}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString(){
        return String.format("%s, %d, %d", name, ban, totalScore);
    }

    String getName() {
        return name;
    }

    int getBan() {
        return ban;
    }

    int getTotalScore() {
        return totalScore;
    }

    //총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

}