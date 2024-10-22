package test_me;

public class Player {
    String name;
    Integer card;



    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
