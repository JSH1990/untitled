package test;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) { //플레이어가 카드를 가지고있음
        hand.add(card);
    }

    public void drawCard(Deck deck) { //카드를 내는것
        hand.add(deck.drawCard()); //카드 반환
    }

    public int rankSum(){ //가지고 있는 카드 번호 합산
        int value = 0;
        for (Card card : hand) {
            value += card.getRank();
        }
        return value;
    }

    public void showHand(){ //가지고 있는 카드 보여주기
        hand.sort(null); //가지고 잇는 카드 정렬
        System.out.println(name + "의 카드: " + hand + ", 합계: "+ rankSum());
    }

    public String getName() {
        return name;
    }
}
