package 인터페이스리모콘;

public class Audio implements RemoteControl{
    private int volume;
    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 끕니다.");

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
        System.out.println("현재 Audio 볼륨 : " + this.volume);
       }
       public void getInfo(){
           System.out.println("오디오 입니다.");
           System.out.println("현재 볼륨은 " + volume + " 입니다.");
       }
}

