package 손익분기점;

import java.util.Scanner;

// 첫번째 : 고정비용
// 두번째 : 가변비용
// 세번째 : 판매금액
// 손익분기점을 달성 할 수 없으면 -1
public class BreakEventEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fixCost = sc.nextInt(); //고정비용
        int varCost = sc.nextInt(); //가변비용(생산비용)
        int sellPrice = sc.nextInt(); //판매금액
        int cnt = 0;
        if(varCost >= sellPrice) {
            System.out.println("-1");
            return;
        }
        System.out.println((fixCost / (sellPrice - varCost)) + 1);

        }
    }

