package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initCard(); //카드 만들기
        shuffle(); //카드 섞기

        //for (int i = 0; i < 13; i++) {
        //for (Suit suit : Suit.values()) {
        //cards.add(new Card(i, suit));

        //Suit[] values = Suit.values();
        //for (Suit suit : values) {
        //cards.add(new Card(i, suit));

        //cards.add(new Card(i, Suit.SPADE));
        //cards.add(new Card(i, Suit.HEART));
        //cards.add(new Card(i, Suit.DIAMOND));
        //cards.add(new Card(i, Suit.CLUB));
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    private void initCard() {
        for (int i = 1; i < 13; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    /*
    List에서 데이터를 앞에서 부터 꺼내고 있다. 지금처럼 데이터의 수가 작다면 ArrayList를 사용해도 괜찮지만,
    데이터의 수가 많다면 LinkedList를 고려하자
     */
    public Card drawCard(){ //카드 선택
        return cards.remove(0); //제일 위에 있는 카드를 뽑고 반환(첫번째 값을 꺼낸다.)
    }
}
