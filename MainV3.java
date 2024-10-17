package exception.ex3;

import java.util.Scanner;

public class MainV3 {
    private static SendExceptionV3 sendEx;

    public static void main(String[] args) {

        NetworkServiceV3_1 networkService = new NetworkServiceV3_1();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            try {
                networkService.sendMessage(input);
            } catch (Exception e) {
                exceptionHandler(e);
            }
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }

    //공통 예외처리
    private static void exceptionHandler(Exception e){
        //공통처리
        System.out.println("사용자 메세지: 죄송합니다. 알수 없는 문제가 발생했습니다.");
        System.out.println("==개발자용 디버깅 메세지==");
        e.printStackTrace(System.out); //스택 트레이스 출력

        //필요하면 예외 별로 별도의 추가 처리 가능
        if(e instanceof SendExceptionV3){


            System.out.println("[전송 오류] 전송데이터 : " + sendEx.getSendData());
        }
    }
}
