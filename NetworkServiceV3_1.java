package exception.ex3;

/*
실무에서는 수많은 라이브러리를 사용하고, 또 다양한 외부 시스템과 연동한다.
사용하는 각각의 클래스들이 자신만의 예외를 모두 체크 예외로 만들어서 전달한다고 가정하자.

이렇게 처리할수 없는 예외들은 중간에서 여러곳에서 나누어 처리하기보다는 예외를 공통으로 처리할수있는 곳을 만들어서
한곳에서 해결하면 된다. 어짜피 해결할수 없는 예외들이기때문에 이런 경우 고객에게는 현재 시스템에 문제가 있습니다.
라고 오류 메세지를 보여주고, 만약 웹 이라면 오류페이지를 보여주면 된다.

 */

public class NetworkServiceV3_1 {
    public void sendMessage(String data) {
        String address = "https://example.com"; //접속해야할 url 주소
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);
        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " +
                    e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메세지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}