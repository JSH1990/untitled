package 영화표예매;

import java.util.Scanner;

//영화표 예매하기 클래스를 만들고 객체 생성
//극장의 좌석은 10개 (10개의 좌석 예약 상태를 기록하기 위한 배열 필요)
//좌석당 가격은 12000원
//메뉴는 예약하기와 종료로 구성
//예약하기에서는 현재 좌석의 예약 상태를 보여주고 예약을 받음
//종료는 판매된 좌석의 개수를 확인해서 판매 금액을 구함 (3 * 12000 = 36000)
public class MovieMain {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(12000); //ticket 객체생성 후, 매개변수 12000원입력
        Scanner sc = new Scanner(System.in); //스캐너 객체 생성

        while (true){ //while 문
            System.out.println("[1] 예매하기"); //"[1] 예매하기" 출력문
            System.out.println("[2] 종료하기"); //"[2] 종료하기" 출력문
            int selectMenu = sc.nextInt(); //스캐너객체에 selectMenu 입력
            if (selectMenu == 1) ticket.setSeat(); //if조건문 1누를때 좌석설정메서드 호출
            else System.out.println(ticket.totalAmount()); // 2누를때 총금액호출
            break; //조건문 종료
        }
    }
}
