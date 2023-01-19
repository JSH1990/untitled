package 인터페이스네트워크;

import java.util.Scanner;

public class InterfaceMainEx1 {
    public static void main(String[] args) {
        NetWorkAdapter adapter = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("연결 할 네트워크를 선택 하세요. [1]WiFi [2]5G [3]LTE : ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                adapter = new Wifi("Kt Magapass");
                break;
            case 2:
                adapter = new FiveG("Sk Telecom");
                break;
            case 3:
                adapter = new LTE("Lg U+");
                break;
            default:
                System.out.println("네트워크를 잘 못 선택하였습니다.");
        }
        adapter.connect();
    }
}
