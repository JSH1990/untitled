package 클래스정렬예제1;

import java.util.TreeSet;

// Comparable 은 클래스 정렬을 구현 할 수 있도록 해주는 인터페이스이며 TreeSet 컬렉션에서 사용해야 함
// compareTo() 메소드르 오버라이딩해서 정렬 조건을 구현 해야 함. 정렬 조건은 자신의 객체와 매개변수로 입력 받은 객체를 비교
public class ComparableEx1 {
    public static void main(String[] args) {
        TreeSet<CarSort> ts = new TreeSet<>();
        ts.add(new CarSort("싼타페",2016, "흰색"));
        ts.add(new CarSort("쏘렌토",2020, "빨간색"));
        ts.add(new CarSort("모닝",2011, "검은색"));
        ts.add(new CarSort("g80",2011, "노란색"));

        System.out.println("aaaa".compareTo("aaaaa"));
        for (CarSort e : ts){
            System.out.println("차종: " + e.modelName + " 연식: " + e.modelYear + " 색상 :" + e.color);
        }
    }
}
