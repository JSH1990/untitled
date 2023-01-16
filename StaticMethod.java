package 정적메소드;

public class StaticMethod {
    public static void main(String[] args) {
            Bank kakao = new Bank("국민", 1000);
            Bank shinHan = new Bank("신한", 1000);
            Bank NH = new Bank("신한", 1000);
        kakao.setDeposit(100);
        shinHan.setWithdraw(300);
        NH.setWithdraw(500);
        kakao.viewAccount();

        System.out.println(Bank.getCount()); //getCount()메소드는 정적메소드이며, 클래스 소속\

        System.out.println("현재 시간은 출력 합니다.");
        System.out.println(Util.getCurrentDate("yyyy년MM월dd일-hh:mm:ss"));
        System.out.println("도메인주소 :" +AI);

    }
}
