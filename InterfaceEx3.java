package 상속과인터페이스;

import java.util.Scanner;

public class InterfaceEx3 {
    public static void main(String[] args) {
//        NetworkAdapter2 adapter;
        Scanner sc = new Scanner(System.in);
        System.out.print("연결 할 네트워크를 선택하세요 [1]WiFi [2]5G : ");
        int sel = sc.nextInt();
        if (sel == 1){
            WiFi wiFi = new WiFi("KT", "고유림");
            wiFi.connect();
            wiFi.sendMsg();
            wiFi.rcvMsg();
        }else {
            FiveG fiveG = new FiveG("Sk", "나희도");
            fiveG.connect();
            fiveG.sendMsg();
            fiveG.rcvMsg();

        }
    }
}
