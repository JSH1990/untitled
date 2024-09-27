package test_me;


public class CardGameMain {
    public static void main(String[] args) {
        Player player1 = new Player("플레이어1");
        Player player2 = new Player("플레이어2");

        Card card1 = new Card();
        Card card2 = new Card();

        Integer pickOne = card1.pick();
        System.out.println("pickOne = " + pickOne);
        player1.setCard(pickOne);

        System.out.println("player1 = " + player1);

        System.out.println();

        Integer pickTwo = card2.pick();
        System.out.println("pickTwo = " + pickTwo);
        player2.setCard(pickTwo);
        System.out.println("player2 = " + player2);

        Integer sum1 = card1.print(player1);

        Integer sum2 = card2.print(player2);

        if(sum1.equals(sum2)){
            System.out.println("비겼습니다.");
        }else {
            if(sum1 > sum2){
                System.out.println(player1.name+"님이 이겼습니다.");
            }else {
                System.out.println(player1.name+"님이 졌습니다.");
            }
        }
    }
}
