package test_me;

import java.util.*;

public class Card {
    private int[] deck = new int[10];
    private List<Integer> pickCard = new ArrayList<>();
    int count = 0;


    public Card() {
        for (int i = 0; i < deck.length; i++) {
            this.deck[i] = i + 1;
            System.out.println("Arrays.toString(deck) = " + Arrays.toString(deck));
        }
        System.out.println();
    }


    public Integer pick() {
        for (Integer i : deck) { //배열 숫자꺼내고
            Random random = new Random(); //랜덤클래스 생성
            int i1 = (random.nextInt(i))+1; //deck배열에서 나온 숫자
            pickCard.add(i1);
        }

        System.out.println("pickCard = " + pickCard);

        for (int i = 0; i < pickCard.size(); i++) {
            count += pickCard.get(i);
        }

        return count;
    }

    public void result() {
    }

    public Integer print(Player player) {
        return player.getCard();
    }

}
