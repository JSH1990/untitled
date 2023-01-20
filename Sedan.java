package 자동차종합예제;

public class Sedan extends Car {
    public Sedan(String name) {
        this.name = name;
        speed = 230;
        fuelEff = 8;
        fuelTank = 30;
        seatCnt = 4;
    }

    @Override
    public void setMode(boolean isMode) {
        if (isMode) seatCnt += 1;
    }
}
