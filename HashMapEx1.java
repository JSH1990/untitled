package 해시맵기본;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Hashmap : 키와 값으로 구성되어 있음, 키의 중복 여부 확인은 HashCode()통해서 수행 함
// 키의 중복은 허용하지 않음, 값은 중복 가능, 순서를 유지 하지 않음
// 경우에 따라서 hashCode()와 equals() 메소드를 오버라이드 해시 사용햐여 함
// Hashmap 은 성능이 우수하고, 멀티스레드 환경을 지원하지 않음(즉 동기화 기능 없음)
// HashTable 은 HashMap 내부 구조가 동일하며, 멀티스레드 지원
// Properties 는 HashTable 을 상속 받아서 기능을 제약하여 사용(키와 값이 모두 문자열로만 구성), 정보를 파일에 저장하거나 읽기위한 용도
public class HashMapEx1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //객체 추가 : put(키와 값)
        map.put("우영우", 99);
        map.put("동그라미", 55);
        map.put("최수연", 95);
        map.put("이준호", 88);
        map.put("동그라미", 96); //키가 같아서 값이 나중의 값을 대체 됨
        System.out.println("총 Entry 수 : " + map.size());
        System.out.println(map.get("동그라미"));

        for(String key : map.keySet()){ //keySet 은 모든 키를 Set 객체에 담아서 리턴
            System.out.println(key + " : " + map.get(key));}
        //반복자로 순회하는 방법(iterator)
        Set<String> keySet = map.keySet(); //모든 키를 Set 객체에 넘겨줌(Set 은 Collection 프레임워크)
        Iterator<String> iterator = keySet.iterator(); //복잡하게 하는이유 - map 에는 반복자가 없기 때문.
        while (iterator.hasNext()){ //키가 존재하는지 확인
            String key = iterator.next(); // 있다면 키를 가져옴
            System.out.println(key + " : " + map.get(key));
        }
        map.remove("최수연");
        map.replace("이준호" , 91);

    }
}
