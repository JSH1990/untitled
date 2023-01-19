package 상속과인터페이스;

public class Chat {
    Chat (){}
    void sendMsg(){
        System.out.println("메세지를 보냅니다.");
    }
    void rcvMsg(){
        System.out.println("메세지를 닫습니다.");
    }
}
class WiFi extends Chat implements NetworkAdapter2 {
    String company;
    String name;

    public WiFi(String company, String name) {
        this.company = company;
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(company + "WiFi의 연결 되었습니다.");
    }

    @Override
    void sendMsg() {
        System.out.println(name + "에게 메세지를 보냅니다.");
    }

    @Override
    void rcvMsg() {
        System.out.println(name + "으로 부터 메세지를 받습니다.");
    }
}
    class FiveG extends Chat implements NetworkAdapter2 {
        String company;
        String name;

        public FiveG(String company, String name) {
            this.company = company;
            this.name = name;
        }

        @Override
        public void connect() {
            System.out.println(company + "FiveG로 연결 되었습니다.");
        }

        @Override
        void sendMsg() {
            System.out.println(name + "에게 메세지를 보냅니다.");
        }

        @Override
        void rcvMsg() {
            System.out.println(name + "으로 부터 메세지를 받습니다.");
        }

    }
