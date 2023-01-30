package 벡터예제;

import java.util.List;
import java.util.Vector;

//vector 는 ArrayList 내부적으로 동일한 구조입니다. 메소드의 사용방법도 완전히 동일 합니다. 멀티스레드에 안전
public class VectorEx1 {
    public static void main(String[] args) {
        List<NameCard> list = new Vector<>();
        list.add(new NameCard("우영우", "010", "ee@ee.net", "대리", "서울"));

        for (NameCard e : list){
            System.out.println("e.name = " + e.name);
            System.out.println("e.name = " + e.phone);
            System.out.println("e.name = " + e.mail);
            System.out.println("e.name = " + e.position);
            System.out.println("e.name = " + e.address);
        }
    }
}

class NameCard {
    String name;
    String phone;
    String mail;
    String position;
    String address;

    public NameCard(String name, String phone, String mail, String position, String address) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.position = position;
        this.address = address;
    }


}


