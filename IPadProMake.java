package 아이패드주문하기;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import static java.lang.Thread.sleep;

public class IPadProMake {
    int screen; //화면 크기 : 11인치, 12.9인치
    int color; //색상: 스페이스 그레이 / 실버
    int memory; //용량 : 128GB, 256GB, 512GB, 1TB
    int network; //네트워크 : wi-fi, wi-fi+Cellular
    String name; //각인서비스 시 이름 저장
    String productDate; //제품 생산 일자(시리얼넘버를 만들 때 사용)
    String serialNum; //제품 일련 번호 : iPad13128C2301121
    static int cnt = 0; //클래스 변수 : 객체 시 생성되지 않고 클래스 생성시 만들어 짐


    public IPadProMake(String name) {
        this.name = name;
        Date now = new Date(); //현재의 시간 정보를 가져오기 위해 사용
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        productDate = sdf.format(now); //시간 정보 중 "yyMMdd" 패턴으로 시간 정보 가져옴
        cnt++; //생성자는 객체가 만들어 질때 호출된다. 객체횟수 확인 용도
        productDate += cnt; //연월일 + 생산 갯수
    }

    //제품 구매에 대한 진행 여부를 묻는 메뉴 만들기
   public boolean continueOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== iPad pro 구입하기 ====");
        System.out.print("구입 하시려면 yes / 종료는 quit : ");
        String isContinue = sc.next();
        if(isContinue.equalsIgnoreCase("yes")) return true;
        return false;
    }

    //화면 크기 정하기
    public void setScreen() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("디스플레이 선택 [1] 11인치, [2] 12.9인치 : ");
            screen = sc.nextInt();
            if (screen == 1 || screen == 2) return; //여기서 해당 메서드가 끝남
            System.out.println("디스플레이를 다시 선택 하세요. ");
        }
    }

    public void setColor() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("컬러 선택 [1] 스페이스 그레이, [2] 실버 : ");
            color = sc.nextInt();
            if (color == 1 || color == 2) return;
            System.out.println("컬러를 다시 선택 하세요. ");
        }
    }

   public void setMemory() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("용량 선택 [1]128GB,[2]256GB,[3]512GB ,[4]1TB : ");
            memory = sc.nextInt();
            if (memory > 0 && memory < 5) return;
            System.out.println("용량을 다시 선택하세요. ");
        }
    }

   public void setNetwork() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("네트워크 선택 : [1]Wi-Fi, [2]Wi-Fi+Cellular : ");
            network = sc.nextInt();
            if(network == 1 || network == 2) return;
            System.out.println("네트워크를 다시 선택 하세요. ");

        }
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("각인 서비스를 신청 하시겠습니까?");
        String service = sc.next();
        if(service.equalsIgnoreCase("yes"));{
            System.out.print("이름을 입력하세요 : ");
            name = sc.next();
        }
    }

    // 일련 번호 만들기 : iPad + 11/13 + 128/256/512/1024 + w/c + 230112 + 생산댓수
  public   void setSerialNum() {
        String scrStr = (screen == 1) ? "11" : "13";
        String[] memStr = {"", "128", "256", "512", "1024"};
        String netStr = (network == 1) ? "W" : "C";
        serialNum = "iPad" + scrStr + memStr[memory] + netStr + productDate;
    }

    // 제품 구매가 완료 되면 출고까지 30초 대기
   public void inProduct() throws InterruptedException {
        int cnt = 0;
        while (true){
            sleep(100);
            cnt++;
            System.out.print(" << iPad Pro 제작중 : [" + cnt + "%] >>");
            System.out.print("\r");
            if (cnt >= 100) break;
        }
    }

   public void productPad() {
        final String[] scrType = {"", "11인치", "12.9인치"};
        final String[] colorType = {"", "스페이스그레이", "실버"};
        final String[] memType = {"", "128GB", "256GB", "512GB", "1TB"};
        final String[] netType = {"", "Wi-Fi", "Wi-Fi+Cellular"};
        System.out.println("==== iPad pro 가 출고 되었습니다. ====");
        System.out.println("디스플레이  :" + scrType[screen]);
        System.out.println("제품 색상   :" + colorType[color]);
        System.out.println("제품 용량   :" + memType[memory]);
        System.out.println("네트 워크   :" + netType[network]);
        System.out.println("이름       :" + name);
        System.out.println("일련 번호   :" + serialNum);
        System.out.println("---------------------------------");
    }
}
