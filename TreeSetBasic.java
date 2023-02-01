package 트리셋;

import java.util.Iterator;
import java.util.TreeSet;

// 검색 기능이 강화된 컬렉션 입니다.
// 객체 삽입시 자동으로 정렬이 이루어지며, 정렬은 이진 검색 트리로 구성 됩니다.
// 검색은 중위(Inorder)순회 방식으로 이루어지고 자동으로 오름차순 정렬이 됩니다.
public class TreeSetBasic {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(23);
        ts.add(10);
        ts.add(4);
        ts.add(53);
        ts.add(1);
        ts.add(8);
        for (int e : ts) System.out.print(e + " -> ");
        System.out.println("\b\b\b");
        ts.remove(48); // 매개변수로 전달한 요소를 제거

        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " -> ");
        }
        System.out.print("\b\b\b");
        //요소의 개수
        System.out.println("트리의 크기 : " + ts.size() );
    }

}
