package 인터페이스코코아톡;

import java.util.Scanner;
//CocoaTok 은 우리가 만들어야 할 부분
//send() 기능이 호출되면 적절한 네트워크가 연결되어 입력 메시지를 수신할 대상자에게 전달하는 형태

public class CocoMain {
    public static void main(String[] args) {
        CocoaTok cocoaTok = new CocoaTok("2NE1"); //채팅방 여는 순간 객체생성(사용자 2NE1)
        cocoaTok.writeMsg("오늘 춥죠?"); //메세지 입력
        NetAdapter adapter; //네트워크 망을 선택하기 위해 어탭터 생성 어떤 네트워크를 쓸지 결정
        Scanner sc = new Scanner(System.in);
        System.out.print("네트워크 [1]Wifi [2]5G");

        int sel = sc.nextInt();
        if(sel == 1) adapter = new WiFi(); //adapter 는 WiFi와 5G의 부모
        else adapter = new FiveG();
        cocoaTok.send(adapter); //메세지를 보내는 순간 WiFI와 5G가 각자 구현.
    }

}
