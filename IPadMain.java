package 아이패드주문하기;

public class IPadMain {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            IPadProMake iPad = new IPadProMake("iPad pro");
            if (!iPad.continueOrder()) break;
            iPad.setScreen();
            iPad.setColor();
            iPad.setMemory();
            iPad.setNetwork();
            iPad.setName();
            iPad.setSerialNum();
            iPad.inProduct();
            iPad.productPad();

            ;
        }
    }
}
