package 로또번호;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoArrayMain {
    public static void main(String[] args) {
        // ArrayList 생성
        HashSet<Integer> hash = new HashSet<>();
        int tmp = 0;
        while(true) { // 로또번호가 중복되는 횟수를 알 수 없기 때문에..
            // 0 ~ 44까지 45개의 값 생성 후 1을 더해서 (1 ~ 45까지의 값을 만듬)
            tmp = (int)((Math.random() * 45) + 1);
            // contains(값) : 해당 값이 리스트에 포함되어 있는지 확인
            if(hash.contains(tmp) == false) { // tmp가 리스트에 포함되어 있지 않으면..
                hash.add(tmp);
            }
            // ArrayList 크기가 6이면 반복문을 끝냄
            if(hash.size() == 6) break;
        }
        // 향상된 for문으로 결과 출력
        for(Integer e : hash) System.out.print(e + " ");
    }
}

