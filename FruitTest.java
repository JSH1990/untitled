            package 과일이름정렬;

            import java.util.Arrays;
            import java.util.Comparator;
            import java.util.HashSet;
            import java.util.Scanner;

            public class FruitTest {
                public static void main(String[] args) {

                            String[] fruit = {"kiwi", "banana", "apple"}; // n개의 문자열 배열 생성
                            Arrays.sort(fruit, new Comparator<String>() {
                                @Override
                                public int compare(String o1, String o2) {
                                    if (o1.length() == o2.length()) return 1;
                                    else{
                                        if (o1.length() == o2.length()) {
                                            return o1.compareTo(o2); // o1 길이가 길면 양수
                                        }
                                        return -1;
                                    }
                                }
                            });
                            System.out.println(Arrays.toString(fruit));

                            String test = "abcd";
                    System.out.println(test.compareTo("ab"));
                    System.out.println(test.compareTo("abcd"));
                    System.out.println(test.compareTo("abcdefdds"));

                        }
                    }

