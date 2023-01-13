package 상속이있는TV;
// 상속관계 있는 TV
// 오버라이딩 적용
public class InheritanceTv {
    public static void main(String[] args) {
        ProductTv lgTV = new ProductTv("우리집 TV");
        lgTV.setPower(true);
        lgTV.setVolume(120);
        lgTV.setChannel(1900, true);
        lgTV.viewTV();

    }
}
