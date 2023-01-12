package 홀수짝수나누어담기;

import java.util.Scanner;

// 7개의 정수를 입력 받아 홀수와 짝수 배열에 나누어 담기
// 입력 받는 inputInt()
// 홀수와 짝수를 계산하는 oddEven()
// 결과를 출력하는 dispOutput()
// 입력 : 1 2 3 4 5 6 7
// 홀수 : 1 3 5 7
// 쩍수 : 2 4 6
public class OddEvenSeparator {
    int[] inputArr = new int[7] // 정수를 입력 받는 배열 arr
    int[] evenArr = new int[7]; // 입력 받은 배열에서 짝수만 담는 배열 even
    int[] oddArr = new int[7]; // 입력 받은 배열에서 홀수만 담는 배열 odd
    int evenIdx = 0; //짝수 갯수
    int oddIdx = 0; //홀수 갯수
    public void inputInt() { //입력 메서드

        Scanner sc = new Scanner(System.in); //입력 객체생성
        System.out.print("정수 입력 :");
        for (int i = 0; i < inputArr.length; i++){
            inputArr[i] = sc.nextInt();

             //수만큼 배열에 담기
        }
    }
    public void separatorArray() { //계산 메서드

        for(int e : inputArr) { //조건문 통해 배열[i]의 담긴 수
            if (e % 2 == 0) evenArr[evenIdx++] = e;//짝수 일때 배열에 담는다
            else oddArr[oddIdx++] = e;//홀수 일때 배열에 담는다
        }
    }
    public void disOutput() {
        System.out.print("홀수 : ");
        for (int i = 0; i < odd[i]; i++)System.out.print(odd[i] + " "); //조건문 이용해 홀수일때
        System.out.println();
        System.out.print("짝수 : ");
        for(int i = 0; i < eIdx; i++) System.out.print(even[i] + " "); //조건문이용해 짝수일때
        System.out.println();
    }
}
