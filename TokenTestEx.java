package 스트링토근;

import java.util.Scanner;
import java.util.StringTokenizer;

//StringTokenizer() : 문자열이 특정 구분자로 연결되어 있는 경우, 구분자 기준으로 문자열을 관리 할 수 있음
//countTokens()
public class TokenTestEx {
    public static void main(String[] args) {
        int idx = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 / 기준으로 입력 : ");
        String name = sc.nextLine(); //문자열을 개행문자를 만날때까지 입력 받음
        StringTokenizer st = new StringTokenizer(name, "/"); //배열과 구분자를 객체 생성시 넣어줌
        String[] nameStr = new String[st.countTokens()];
        while (st.hasMoreTokens()){
            nameStr[idx++] = st.nextToken();
        }
        for (String e : nameStr) System.out.print(e + " ");
    }
}