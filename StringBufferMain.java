package 스트링버퍼;
// StringBuffer : 객체 생성 후 사용, 문자열 추가시 기존의 문자열이 수정됨 , 동기화 지원(멀티쓰레드에서 안전)
// StringBuilder : 객체 생성 후 사용, 문자열 추가시 기존 문자열이 수정 됨, 동기화 지원 안됨, 성능은 우수.
// String : 객체 생성 불필요 , 문자열추가 시
// append() : 문자열을 추가 할때 사용
public class StringBufferMain {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append("!!");
        sb.insert(7, "안녕하세요");
        sb.delete(1,3); //1번인덱스에서 3번 미안 (1,2가 해당 됨)
        System.out.println(sb.substring(0,3));
    }
}
