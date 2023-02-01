package 트리맵기본;
//TreeMap 도 TreeSet 마찬가지로 이진 검색 트리(값이 추가 될때 정렬이 됨)로 구현 되어 있습니다.

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx1 {
    public static void main(String[] args) {

    TreeMap<Integer, String> score = new TreeMap<>();
    score.put(87, "나희도");
    score.put(88, "고유림");
    score.put(75, "백이진");
    score.put(65, "우영우");
    score.put(98, "구자경");

        Map.Entry<Integer, String> entry = null;
        entry = score.firstEntry();
        System.out.println("가장 낮은 점수 : " + entry.getKey() + " : " + entry.getValue());
        entry = score.lastEntry();
        System.out.println("가장 높은 점수 : " + entry.getKey() + " : " + entry.getValue());
        entry = score.lowerEntry(95);
        System.out.println("95 아래 점수 : " + entry.getKey() + " : " + entry.getValue());
        entry = score.higherEntry(95);
        System.out.println("95 위의 점수 : " + entry.getKey() + " : " + entry.getValue());


    }
}
