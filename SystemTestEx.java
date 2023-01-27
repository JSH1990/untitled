package System.클래스;

import static java.lang.Thread.sleep;

public class SystemTestEx {
    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[1000];
        int cnt = 0;
        int val = (int) (Math.random() * 1000) + 1; //1~ 1000사이의 임의의 값
        for (int i=0; i < data.length; i++){ //1000개 배열에 1부터 1000까지 값을 저장
            data[i] = i + 1;
        }
        long time1 = System.currentTimeMillis(); // 측정을 위한 시작시간 가져옴
        for (int i=0; i< data.length; i++){
            cnt++;
            sleep(1); //시간 측정에 대한 지연 요인을 만들기 위해서 인위적으로 추가
            if(val == data[i]){
                System.out.println("위치 : " + (i+1));
                break;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(cnt);
        System.out.println(time2-time1);

        //시스템 프로퍼티 읽기
        System.out.println(System.getProperty("os.name")); //os name 키값을 넣으면 해당 정보를 반환
        System.out.println(System.getProperty("user.name")); //os name 키값을 넣으면 해당 정보를 반환
    }
}
