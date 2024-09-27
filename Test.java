package test_me;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> test = new HashMap<>();

        int sum = 0;
        test.put(1, "스페이스");
        test.put(2, "하트");
        System.out.println("test = " + test);

        System.out.println("test.keySet() = " + test.keySet());

        for (Integer key : test.keySet()) {
            sum += key;
        }

        System.out.println("sum = " + sum);


    }


}
