package 제네릭;

import java.util.ArrayList;
import java.util.List;

// 컴파일 시 강한 타입 체크 / 자바 8 이전 대비 변경 사항
// 타입 변환 제거 / 자바 8이전 대비 변경 사항
public class GenericTestEx {
    public static void main(String[] args) {
//        List list = new ArrayList(); // 자바 8 이전 스타일
//        list.add(0);
//        String str = (String) list.get(0);
       List<String> list = new ArrayList<>();
       list.add("hello");
    String str = list.get(0);
        System.out.println(str);
    }
}
