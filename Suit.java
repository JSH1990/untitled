package test;

public enum Suit {
    SPADE("\u2660"),
    HEART("\u2665"),
    DIAMOND("\u2666"),
    CLUB("\u2663")
    ;

    private String icon;

    Suit(String icon) {
        this.icon = icon;
    }

    public String getIcon() { //enum에서 아이콘 꺼낼수 있도록
        return icon;
    }
}
