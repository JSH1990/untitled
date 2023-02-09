package 스트림예제7번;

import java.util.ArrayList;
import java.util.List;

public class StreamObjTest {
    public static void main(String[] args) {
        List<TravelCustomer> customers = new ArrayList<>();
        customers.add(new TravelCustomer("유나", 21, 1000));
        System.out.println("고객 명단 출력");
        customers.stream().map(c-> c.getName()).forEach(s-> System.out.println(s));
        int total = customers.stream().mapToInt(c -> c.getPrice()).sum();
        System.out.println("총 여행 비용 : " + total);

        System.out.println("== 20세 이상 성인 출력==");
        customers.stream()
                .filter(c -> c.getAge() >= 20)
                .map(c ->c.getName())
                .sorted()
                .forEach(s-> System.out.println(s));
    }
    }


    class TravelCustomer{
    String name;
    int age;
    int price;

    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }
}
