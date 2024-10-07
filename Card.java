package test;

public class Card implements Comparable<Card> { //다른카드와 내 카드를 비교하기 위해 인터페이스 구현받음
    private final int rank; //카드의 숫자
    private final Suit suit; //카드의 모양

    public Card(int rank, Suit suit) { //final 이기때문에 생성자 만들어줘야함
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card anotherCard) {
        //숫자를 먼저 비교하고, 숫자가 같으면 마크를 비교
        if (this.rank != anotherCard.rank) { //현재 카드의 숫자가 다른카드와 같지 않으면
            return Integer.compare(this.rank, anotherCard.rank); //비교해서 내 카드가 크면 1, 같으면0, 작으면 -1을 반환한다. 이미 구현되어 있다.
        } else { //현재카드의 숫자와 다른카드의 숫자가 같으면
            return this.suit.compareTo(anotherCard.suit); //모양을 비교한다.
            /*
            compareTo를 사용할 수 있는이유는 Enum은 이미 Comparable를 상속받고 있기때문이다.
            Enum안에 있는 SPADE(1), HEART(2), DIAMONDE(3), CLUB(4) 순서별로 서로 비교한다.

            - Suit는 ENUM 타입이다. 스페이드, 하트 등의 문양의 순서는 변하지않는다고 가정하고, ENUM의 기본 순서를 사용한다.
            - ENUM 타입은 compareTo()가 열거형의 순서인 ordinal로 구현되어 있다. 그리고 ENUM의 compareTo() 메서드는 final 선언되어 있어서 재정의 할 수 없다.
             */
        }
    }

    @Override
    public String toString() {
        return rank + "(" + suit.getIcon() + ")";
    }
}