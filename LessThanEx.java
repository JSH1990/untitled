package X보다작은수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 문제 : 정수 N개로 이루어진 배열 A와 정수 X 가 주어진다. 이 때 A에서 X보다 작은 수를 모두 출력
// 10 5 => 배열의 길이와 주어진 수
// 1 10 4 9 2 3 8 5 7 6
// 결과 : 1 4 2 3
public class LessThanEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열의 개수
        int x = sc.nextInt(); // 비교 값
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt()); // 리스트 입력 받은 값 추가
            if(list.get(i) < x) System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    }

