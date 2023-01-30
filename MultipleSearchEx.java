package 배수찾기;

import java.util.*;

public class MultipleSearchEx {
    public static void main(String[] args) {

                List<Integer> list = new ArrayList<>();

                Scanner sc = new Scanner(System.in);

                int tmp; // 키보드를 통해서 값을 입력 받는 변수
                int n = sc.nextInt();

                while(true) {// 항상 참인 경우 이므로 무한으로 반복하는 반복문, 이 경우는 반드시 탈출 조건이 필요

                    tmp = sc.nextInt();
                    if(tmp == 0) break;
                    list.add(tmp); //원칙적으로는 객체를 만들고 넣어주는게 좋다.
                }

                for(Integer e : list) {
                    if(e % n == 0) System.out.println(e + " is a multiple of " + n +".");
                    else System.out.println(e + " is NOT a multiple of " + n + ".");
                }

    }
    }

