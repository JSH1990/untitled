package 인터페이스리모콘;

public class Television implements RemoteControl{
    private int volume;
    @Override
    public void turnOn() {
        System.out.println("티비를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("티비를 끕니다.");

    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume < RemoteControl.MIM_VOLUME){
            this.volume = RemoteControl.MIM_VOLUME;
        }else {
            this.volume = volume;
        }
        System.out.println("현재 Television 볼륨 : " + this.volume);
       }

       @Override
      public void getInfo(){
           System.out.println("Television 입니다.");
           System.out.println("현재 볼륨은 " + volume + " 입니다.");
       }
       @Override
    public void setMute(boolean mute){
        if (mute) System.out.println("tv를 무음 처리 합니다.");
        else System.out.println("tv를 무음 처리 합니다.");
       }
}

