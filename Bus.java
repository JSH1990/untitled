package 자동차종합예제;

public class Bus extends Car {
    @Override
    public void setMode(boolean isMode) {
        if (isMode) fuelTank += 30;
    }

    public Bus(String name) {
        this.name = name;
        speed = 230;
        fuelEff = 8;
        fuelTank = 30;
        seatCnt = 4;
    }
}

