package 커피메뉴만들기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// 해시맵을 이용한 커피 메뉴 (보기/추가/삭제/변경)
// 초기 메뉴를 추가 함


public class CoffeeMenuEx {
    Map<String, MenuInfo> map = new TreeMap<>(); //main 외부에서 Map 생성
    public static void main(String[] args) {
        CoffeeMenuEx coffee = new CoffeeMenuEx(); //객체 생성
        coffee.makeMenu(); //메뉴만들기 메서드 호출
        coffee.selectMenu(); //메뉴선택 메서드 호출
    }

    void makeMenu(){ //메뉴 만들기 메서드
        map.put("Americano", new MenuInfo("Americano", 1500, "Coffe", "기본 커피 입니다.")); //아메리카노
        map.put("Espresso", new MenuInfo("Espresso", 2500, "Coffe", "진한 커피 입니다.")); //에스프레스
        map.put("Latte", new MenuInfo("Latte", 4500, "Coffe", "우유가 포함된 커피 입니다.")); //라떼
    }

    void selectMenu(){ //메뉴 선택 메서드
        Scanner sc = new Scanner(System.in); //스캐너 객체생성
        while (true){ //조건문
            System.out.print("메뉴를 선택 하세요 : ");
            System.out.print("[1] 메뉴보기, [2] 메뉴 조회, [3] 메뉴 추가, [4] 메뉴 수정,[5] 메뉴삭제, [6] 종료 : ");
            int selMenu = sc.nextInt();
            String key = ""; // 초기화
            switch (selMenu) { // 조건문
                case 1:
                    System.out.println("======== 메뉴보기 ========");
                    for (String e : map.keySet()) {
                        System.out.println("메뉴 : " + map.get(e).name);
                        System.out.println("가격 : " + map.get(e).price);
                        System.out.println("분류 : " + map.get(e).group);
                        System.out.println("설명 : " + map.get(e).desc);
                        System.out.println("====================");

                    }
                    break;

                case 2:
                    System.out.print("조회 할 메뉴를 입력 하세요 : ");
                    key = sc.next();
                    if (map.containsKey(key)) { //map 에 키가 존재하는지 확인 (있으면 true)
                        System.out.println("메뉴 : " + map.get(key).name);
                        System.out.println("가격 : " + map.get(key).price);
                        System.out.println("분류 : " + map.get(key).group);
                        System.out.println("설명 : " + map.get(key).desc);
                        System.out.println("====================");
                    } else System.out.println("해당 메뉴가 존재하지 않습니다.");
                    break;

                case 3:
                    System.out.println("추가 할 메뉴를 입력하세요 : ");
                    key = sc.next();
                    if (map.containsKey(key)) {
                        System.out.println("해당 메뉴가 이미 존재 합니다.");
                    } else {
                        System.out.println("가격 입력 : ");
                        int price = sc.nextInt();
                        System.out.println("분류 입력 : ");
                        String group = sc.next();
                        sc.nextLine();// 버퍼비우기
                        System.out.println("설명 입력 : ");
                        String desc = sc.nextLine();
                        map.put(key, new MenuInfo(key, price, group, desc));
                    }
                    break;
                case 4:
                    System.out.print("삭제할 메뉴를 입력 하세요 : ");
                    key = sc.next();
                    if (map.containsKey(key)) {
                        map.remove(key);
                        System.out.println(key + " 메뉴를 삭제 했습니다. ");
                    } else System.out.println("삭제할 메뉴가 없습니다.");
                    break;

                case 5:
                        System.out.println("수정할 메뉴를 입력 하세요 : ");
                        key = sc.next();
                        if (map.containsKey(key)) {
                            System.out.println("가격 입력 : ");
                            int price = sc.nextInt();
                            System.out.println("분류 입력 : ");
                            String group = sc.next();
                            sc.nextLine();// 버퍼비우기
                            System.out.println("설명 입력 : ");
                            String desc = sc.nextLine();
                            map.replace(key, new MenuInfo(key, price, group, desc));
                        }else System.out.println("수정할 메뉴가 없습니다.");
                        break;
                case 6 :
                    System.out.println("메뉴를 종료 합니다.");
                    return; //break 사용하면 조건문을 벗어날수 없음
            }

        }
    }
}
