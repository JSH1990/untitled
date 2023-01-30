package 어레이리스트예제1;

import java.util.*;

// List 인터페이스란? 배열과 비슷한 구조를 가지며, 하위에 ArrayList, LinkedList Vector 클래스로 구성됨
// 요소의 저장 순서가 유지, 중복 저장 허용, 동적 할당(크기 지정을 안해도 됨), 다양한 메소드 제공
// ArrayList : 물리적으로 연속된 공간에 저장, 검색을 인덱스로 하기 때문에 빠름, 삽입, 삭제는 느림(단, 맨뒤의 삽입/ 삭제는 빠름)
// Vector : ArrayList 와 동일 특성을 가짐, 멀티스레드 환경을 위해 동기화 기능 지원하기 때문에 안정적이나 ArrayList 보다는 느림
// LinkedList : 물리적으로 연속된 공간이 아님, 참조로 다음 저장 위치를 가리킴. 삽입/삭제가 매우 빠름, 검색은 느림
public class ArrayListEx1 {
    public static void main(String[] args) {
        String[] data = {"138", "145", "122"};
        List<String> pitches = new ArrayList<>(Arrays.asList(data)); // asList()는 이미 만들어진 배열을 List에 추가

//        System.out.println(pitches.size()); //ArrayListd의 개수 반환
//        System.out.println(pitches.contains("145"));// false 출력됨, 전달된 값이 ArrayList 내에 있는지 확인
//        System.out.println(pitches.remove(0));// 리스트에서 해당 항목을 삭제하고 삭제된 요소를 반환함
//        System.out.println(pitches.remove("138"));// 리스트에서 해당 항목을 삭제하고 삭제된 요소를 반환함
        pitches.sort(Comparator.reverseOrder()); //오름 차순 정렬
        System.out.println(pitches);



    }
}
