package 인터페이스리모콘;
// 인터페이스란?
// 모든 필드는 자동으로 상수(final static)으로 변환 됩니다.
// 모든 메서드는 자동으로 추상메소드가 됩니다. (public abstract 가 자동 추가 됩니다.)
// default 메소드 : 예외적으로 구현부를 가질 수 있으며 상속 받은 클래스에서 재정의 가능 합니다.
// 정적메소드를 포함 할 수 있습니다. (정적메소드는 객체와 상관없고, 인터페이스 타입으로 사용 됩니다.)
public interface RemoteControl {
    int MAX_VOLUME = 100;
    int MIM_VOLUME = 0;
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    static void changeBattery(){
        System.out.println("건전지를 교환 합니다.");
    }

    void getInfo();

    //자바 버전 1.8이후에 추가 되었으며 예외적으로 메소드의 구현부를 가질 수 있습니다.
    default void setMute(boolean mute){
        if(mute) System.out.println("무음 처리 합니다.");
        else System.out.println("무음 해제 합니다.");
    }
}
