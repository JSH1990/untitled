package 영화표예매;
//현재 좌석 상태를 보여주는 메서드가 필요
//좌석을 예매하는 메서드가 필요
//판매된 좌석의 개수를 구해 총 판매 금액을 구하는 메서드가 필요

import java.util.Scanner;

public class MovieTicket {
    private int[] seat = new int[10];//극장의 좌석 상태를 표시하는 배열 만들기(총 10개) seat변수
    private int ticketPrice;//ticketPrice 변수 생성

    MovieTicket(int price){
        this.ticketPrice = price;//price 매개변수를 가진 생성자 생성
    }



    void printSeat(){ //현재 좌석을 보여주는 메서드 printSeat
        for (int i =0 ; i<seat.length; i++) { //조건문 for이용해, 10개의좌석값 넣어줌
            if(seat[0] == 0){ //조건문 seat[0]이 0이면
                System.out.print("[]"); //비어있으면 "[]" 출력
            } else {
                System.out.print("[V]"); //자리가 있으면 "[V]" 출력
            }
            System.out.println(); //다음칸 넘어감

        }
    }

        void setSeat(){
            printSeat(); // 좌석 예약하는 메서드
            Scanner sc = new Scanner(System.in); //sc객체 생성
            System.out.print("좌석 번호를 입력 하세요 : "); //"좌석번호 입력하세요" 출력
            int seatPos = sc.nextInt(); // 예약변수 seatPos생성
            if(seat[seatPos-1] == 0) { // 아직 판매되지 않은 좌석
                seat[seatPos-1] = 1; // 판매된 좌석으로 변경
                printSeat(); // 판매 이후 좌석 상태를 보여 줌
            } else System.out.println("이미 판매된 좌석 입니다. 다른 좌석을 선택 하세요");
    }

    int totalAmount() { //합계 메서드
        int cnt = 0; //총 갯수 초기화
        for(int e : seat) { //향상된 조건문 이용한 자리
            if(e == 1) cnt++; //갯수 한개씩 추가
        }
        return cnt * ticketPrice; //갯수 * 티켓값
    }
}
